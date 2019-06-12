package ufjf.dcc193.tr2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ufjf.dcc193.tr2.dao.*;
import ufjf.dcc193.tr2.model.Avaliador;

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

    @RequestMapping("/salvar")
    public String salvarAvaliador(Avaliador avaliador){
        avaliadorRep.save(avaliador);
        return "redirect:/avaliador/";
    }

    @RequestMapping("/editar/{id}")
    public String preEditarAvaliador(@PathVariable Long id, Model model){
        model.addAttribute("avaliador",avaliadorRep.findById(id).get());
        model.addAttribute("listArea",areaConhecimentoRep.findAll());
        return "avaliador/avaliador-edit";
    }

    @RequestMapping("/editar/submit")
    public String editarsalvarAvaliador(Avaliador avaliador){
        avaliadorRep.save(avaliador);
        return "redirect:/avaliador/";
    }
    
    @RequestMapping("/deletar/{id}")
    public String deletarAvaliador(@PathVariable Long id){
        avaliadorRep.deleteById(id);
        return "redirect:/avaliador/";
    }
}