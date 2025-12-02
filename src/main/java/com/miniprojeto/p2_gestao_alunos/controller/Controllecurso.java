package com.miniprojeto.p2_gestao_alunos.controller;

import com.miniprojeto.p2_gestao_alunos.model.Curso;
import com.miniprojeto.p2_gestao_alunos.repositorio.RepositorioCurso;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cursos")
public class Controllecurso {

    private final RepositorioCurso repositorio;

    public Controllecurso(RepositorioCurso repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("cursos", repositorio.findAll());
        // CORREÇÃO 1: O nome do arquivo é list (em inglês), não lista
        return "cursos/list";
    }

    @GetMapping("/novo")
    public String novoForm(Model model){
        // CORREÇÃO 2: "curso" com 'c' minúsculo para bater com o HTML th:object="${curso}"
        model.addAttribute("curso", new Curso());
        return "cursos/form";
    }

    @PostMapping
    public String salvar (@ModelAttribute Curso curso){
        repositorio.save(curso);
        return "redirect:/cursos";
    }
}