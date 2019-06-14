package ufjf.dcc193.tr2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ufjf.dcc193.tr2.dao.AvaliadorRepository;
import ufjf.dcc193.tr2.dao.RevisaoRepository;
import ufjf.dcc193.tr2.dao.TrabalhoRepository;
import ufjf.dcc193.tr2.model.Avaliador;
import ufjf.dcc193.tr2.model.Revisao;
import ufjf.dcc193.tr2.model.Trabalho;

/**
 * LoginController
 */
@Controller
@RequestMapping("/acesso/")
public class LoginController {

  @Autowired
  AvaliadorRepository avaliadorRep;

  @Autowired
  TrabalhoRepository trabalhoRep;
  
  @Autowired
  RevisaoRepository revisaoRep;

  @RequestMapping("")
    public String login(Model model){
        model.addAttribute("avaliador",new Avaliador());
        return "acesso/login";
  }

  @RequestMapping("/loginSubmit")
    public String efetuarLogin(Avaliador avaliador, Model model, HttpSession session){
        Avaliador avaliadorQuery = avaliadorRep.findFirstByEmailAndCodigoAcesso(avaliador.getEmail(),avaliador.getCodigoAcesso());
        if(avaliadorQuery != null){
            session.setAttribute("usuario", avaliadorQuery);
            model.addAttribute("avaliador", avaliadorQuery);
            return "acesso/acesso-index";
        }else{
            return "index";
        }
    }

    @RequestMapping("/listarTrabalhos/{id}")
    public String listarTrabalhos(Model model,@PathVariable Long id, HttpSession session){
        Avaliador avaliador = (Avaliador) session.getAttribute("usuarioLogado");
        model.addAttribute("listTrabalhos",  
        trabalhoRep.findByIdAvalaliadorAndIdAreaConhecimentoOrderByStatus(avaliador.getId(), id));
        return "acesso/acesso-trabalho-index";
    }

    @RequestMapping("/avaliar/{id}")
    public String avaliarTrabalhos(Model model,@PathVariable Long id, HttpSession session){
        Avaliador avaliador = (Avaliador) session.getAttribute("usuarioLogado");
        Trabalho trabalho = trabalhoRep.findById(id).get();
        Revisao revisao = revisaoRep.findFirstByAvaliadorAndTrabalho(avaliador,trabalho);
        session.setAttribute("revisao", revisao);
        model.addAttribute("trabalho",  trabalho);
        model.addAttribute("revisao", revisao );
        return "acesso/acesso-avaliacao-index";
    }

    @RequestMapping("/salvarAvaliar")
    public String salvarAvaliarTrabalhos(@RequestParam("action") String tipoAcao,
     Revisao revisao, HttpSession session){
        Revisao revisaoSession = (Revisao) session.getAttribute("avaliacao");
        Long idarea = revisaoSession.getTrabalho().getAreaConhecimento().getId();
        System.out.println(revisao.getDescricao() + " " + revisao.getNota());
        
        System.out.println(tipoAcao);
        if(tipoAcao.contentEquals("Revisar Depois")){
            revisaoSession.setDescricao(revisao.getDescricao());
            revisaoSession.setNota(revisao.getNota());
            revisaoSession.setStatus(0);
            revisaoRep.save(revisaoSession);
        }else if(tipoAcao.contentEquals("Revisar Agora")){
            revisaoSession.setDescricao(revisao.getDescricao());
            revisaoSession.setNota(revisao.getNota());
            revisaoSession.setStatus(1);
            revisaoRep.save(revisaoSession);
        }else if(tipoAcao.contentEquals("Pular")){
            revisaoSession.setDescricao(revisao.getDescricao());
            revisaoSession.setNota(revisao.getNota());
            revisaoSession.setStatus(2);
            revisaoRep.save(revisaoSession);
        }
        session.removeAttribute("avaliacao");
        return "redirect:/acesso/listarTrabalhos/"+idarea; 
    }


}