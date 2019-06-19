package ufjf.dcc193.tr2.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ufjf.dcc193.tr2.dao.*;
import ufjf.dcc193.tr2.model.Avaliador;
import ufjf.dcc193.tr2.model.Revisao;

/**
 * AvaliadorController
 */
@Controller
@RequestMapping("/avaliador/")
public class AvaliadorController {

    @Autowired
    AvaliadorRepository avaliadorRep;

    @Autowired
    AreaConhecimentoRepository areaConhecimentoRep;

    @Autowired
    RevisaoRepository revisaoRep;

    @RequestMapping("")
    public String homeAvaliador(Model model){
        model.addAttribute("listAvaliadores", avaliadorRep.findAll());
        return "avaliador/avaliador-index";
    }
    
    @RequestMapping("/criar")
    public String criarAvaliador(Model model){
        model.addAttribute("avaliador",new Avaliador());
        model.addAttribute("listArea", areaConhecimentoRep.findAll());
        return "avaliador/avaliador-form";
    }

    @PostMapping("/salvar")
    public ModelAndView salvarAvaliador(@Valid Avaliador avaliador, BindingResult binding){
        ModelAndView mv = new ModelAndView();
        if(binding.hasErrors()){
            mv.setViewName("avaliador/avaliador-form");
            mv.addObject("avaliador", avaliador);
            mv.addObject("listArea", areaConhecimentoRep.findAll());
            return mv;
        }
        avaliadorRep.save(avaliador);
        mv.setViewName("redirect:/avaliador/"); 
        return mv;
    }

    @RequestMapping("/editar/{id}")
    public String preEditarAvaliador(@PathVariable Long id, Model model){
        model.addAttribute("avaliador",avaliadorRep.findById(id).get());
        model.addAttribute("listArea",areaConhecimentoRep.findAll());
        return "avaliador/avaliador-edit";
    }

    @PostMapping("/editar/submit")
    public ModelAndView editarSalvarAvaliador(@Valid Avaliador avaliador, BindingResult binding){
        ModelAndView mv = new ModelAndView();
        if(binding.hasErrors()){
            mv.setViewName("avaliador/avaliador-edit");
            mv.addObject("avaliador", avaliador);
            mv.addObject("listArea", areaConhecimentoRep.findAll());
            return mv;
        }
        avaliadorRep.save(avaliador);
        mv.setViewName("redirect:/avaliador/"); 
        return mv;
    }
    
    @RequestMapping("/deletar/{id}")
    public String deletarAvaliador(@PathVariable Long id){
        avaliadorRep.deleteById(id);
        return "redirect:/avaliador/";
    }

    @RequestMapping("/listaRevisao/{id}")
    public String listaRevisaoAvaliador(@PathVariable Long id,Model model, HttpSession session){
        Avaliador avaliador = avaliadorRep.findById(id).get();
        model.addAttribute("listRevisao",revisaoRep.findByAvaliador(avaliador.getId()));
        return "avaliador/avaliador-list-revs";
    }

    @RequestMapping("/mudarStatusRev/{id}")
    public String mudarStatusRevisaoAvaliador(@PathVariable Long id,Revisao revisao){
        Revisao revisaoAux = revisaoRep.findById(id).get();
        revisaoAux.setStatus(revisao.getStatus());
        revisaoRep.save(revisaoAux);
        return "redirect:/listaRevisao/"+ revisaoAux.getAvaliador().getId();
    }
}