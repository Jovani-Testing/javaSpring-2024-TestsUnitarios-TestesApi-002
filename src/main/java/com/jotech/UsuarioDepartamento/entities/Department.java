package com.jotech.UsuarioDepartamento.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_department") // Corrigido para camel case no nome da tabela
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Alterado para IDENTITY
    @Column(name = "id_departamento", nullable = false)
    private Long idDepartamento; // Campo renomeado para camel case

    @Column(name = "name")
    private String name;



    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
