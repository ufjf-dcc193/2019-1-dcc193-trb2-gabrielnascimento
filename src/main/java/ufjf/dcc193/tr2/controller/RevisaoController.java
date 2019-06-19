package ufjf.dcc193.tr2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ufjf.dcc193.tr2.dao.AreaConhecimentoRepository;
import ufjf.dcc193.tr2.dao.AvaliadorRepository;
import ufjf.dcc193.tr2.dao.RevisaoRepository;
import ufjf.dcc193.tr2.dao.TrabalhoRepository;
import ufjf.dcc193.tr2.model.Revisao;

/**
 * RevisaoController
 */

@Controller
@RequestMapping("/revisao/")
public class RevisaoController {

    @Autowired
    RevisaoRepository revisaoRep;

    @Autowired
    TrabalhoRepository trabalhoRep;

    @Autowired
    AvaliadorRepository avaliadorRep;

	@Autowired
    AreaConhecimentoRepository areaConhecimentoRep;

    @RequestMapping("")
    public String indexRevisao(Model model){
        model.addAttribute("listRevisao",revisaoRep.findAll());
        return "revisao/revisao-index";
    }

    @RequestMapping("/criar")
    public String preCriarRevisao(Model model){
        model.addAttribute("listArea",areaConhecimentoRep.findAll());
        return "revisao/revisao-form";
    }

    @RequestMapping("/criar/{id}")
    public String criarRevisao(Revisao revisao,@PathVariable Long id, Model model){
        model.addAttribute("revisao", new Revisao());
		model.addAttribute("listTrabalho",trabalhoRep.findByAreaConhecimento(
            areaConhecimentoRep.findById(id).get()
        ));
        model.addAttribute("listAvaliador",avaliadorRep.findByAreaConhecimento(
            areaConhecimentoRep.findById(id).get()
        ));
        return "revisao/revisaoReview-form";
    }

    @PostMapping("/criar/salvar")
    public ModelAndView salvarRevisao(@Valid Revisao revisao, BindingResult binding){
        ModelAndView mv = new ModelAndView();
        if(binding.hasErrors()){
            mv.addObject("listArea",areaConhecimentoRep.findAll());
            mv.setViewName("redirect:/revisao/criar");
            return mv;
        }
        mv.setViewName("redirect:/revisao/"); 
        revisaoRep.save(revisao);
        return mv;
    }

    @RequestMapping("/editar/{id}")
    public String editarRevisao(@PathVariable Long id, Model model){
        Revisao revisao = revisaoRep.findById(id).get();
        model.addAttribute("revisao",revisao);
        Long idAreaConhecimento = revisao.getTrabalho().getAreaConhecimento().getId();
        model.addAttribute("listTrabalho",trabalhoRep.findByAreaConhecimento(
            areaConhecimentoRep.findById(idAreaConhecimento).get()
        ));
        model.addAttribute("listAvaliador",avaliadorRep.findByAreaConhecimento(
            areaConhecimentoRep.findById(idAreaConhecimento).get()
        ));
        return "revisao/revisao-edit-form";
    }

    @RequestMapping("/editar/salvar")
    public String editarRevisaoSubmit(Revisao revisao){
        revisaoRep.save(revisao);
        return "redirect:/revisao/";
    }

    @RequestMapping("/deletar/{id}")
    public String deletarRevisao(@PathVariable Long id){
        revisaoRep.deleteById(id);
        return "redirect:/revisao/";
    }


}