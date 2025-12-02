package com.miniprojeto.p2_gestao_alunos.repositorio;

import com.miniprojeto.p2_gestao_alunos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCurso extends JpaRepository <Curso, Long> { }
