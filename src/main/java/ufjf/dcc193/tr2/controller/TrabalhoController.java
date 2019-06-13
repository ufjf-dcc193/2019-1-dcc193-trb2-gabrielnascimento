package ufjf.dcc193.tr2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ufjf.dcc193.tr2.dao.AreaConhecimentoRepository;
import ufjf.dcc193.tr2.dao.TrabalhoRepository;
import ufjf.dcc193.tr2.model.Trabalho;

/**
 * TrabalhoController
 */
@Controller
@RequestMapping("/trabalho/")
public class TrabalhoController {

    @Autowired
    TrabalhoRepository repTrabalho;

    @Autowired
    AreaConhecimentoRepository repAreaConhecimento;

    @RequestMapping("")
    public String homeTrabalho(Model model){
        model.addAttribute("listTrabalho",repTrabalho.findAll());
        return "trabalho/trabalho-index";
    }

    @RequestMapping("/criar")
    public String preSalvar(Model model){
        model.addAttribute("trabalho",new Trabalho());
        model.addAttribute("listArea",repAreaConhecimento.findAll());
        return "trabalho/trabalho-form";
    }

    @RequestMapping("/salvar")
    public String salvarSubmit(Trabalho trabalho){
        repTrabalho.save(trabalho);
        return "redirect:/trabalho/";
    }

    @RequestMapping("/editar/{id}")
    public String preEditarTrabalho(@PathVariable Long id, Model model){
        model.addAttribute("trabalho",repTrabalho.findById(id).get());
        model.addAttribute("listaArea",repAreaConhecimento.findAll());
        return "trabalho/trabalho-edit-form";
    }

    @RequestMapping("/editar/salvar")
    public String editarTrabalhoSubmit(Trabalho trabalho){
        repTrabalho.save(trabalho);
        return "redirect:/trabalho/";
    }

    @RequestMapping("/deletar/{id}")
    public String deletarTrabalho(@PathVariable Long id){
        repTrabalho.deleteById(id);
        return "redirect:/trabalho/";
    }
}