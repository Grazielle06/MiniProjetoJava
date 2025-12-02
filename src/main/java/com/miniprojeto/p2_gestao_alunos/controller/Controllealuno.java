package com.miniprojeto.p2_gestao_alunos.controller;

import com.miniprojeto.p2_gestao_alunos.model.Aluno;
import com.miniprojeto.p2_gestao_alunos.repositorio.RepositorioAluno;
import com.miniprojeto.p2_gestao_alunos.repositorio.RepositorioCurso;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alunos")
public class Controllealuno {

    private final RepositorioAluno repositorioA;
    private final RepositorioCurso repositorioC;

    public Controllealuno(RepositorioAluno repositorioA, RepositorioCurso repositorioC) {
        this.repositorioA = repositorioA;
        this.repositorioC = repositorioC;
    }

    @GetMapping
    public String listar (Model model){
        model.addAttribute("alunos", repositorioA.findAll());
        return "alunos/list";
    }

    @GetMapping ("/novo")
    public String novoform (Model model){
        model.addAttribute("aluno", new Aluno());
        model.addAttribute("cursos", repositorioC.findAll());
        return "alunos/form";
    }

    @PostMapping
    public String salvar (@Valid @ModelAttribute("aluno") Aluno aluno,
                          BindingResult br,
                          Model model) {
        if (br.hasErrors()) {
            // Se der erro, precisamos recarregar a lista de cursos para o dropdown não sumir
            model.addAttribute("cursos", repositorioC.findAll());
            return "alunos/form";
        }
        repositorioA.save(aluno);
        return "redirect:/alunos";
    }
}