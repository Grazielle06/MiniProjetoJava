package com.miniprojeto.p2_gestao_alunos.repositorio;

import com.miniprojeto.p2_gestao_alunos.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioAluno extends JpaRepository <Aluno, Long> {}
