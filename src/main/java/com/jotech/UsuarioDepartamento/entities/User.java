package com.jotech.UsuarioDepartamento.entities;

import jakarta.persistence.*;

@Entity
@Table(name="tb_user") // Nome da tabela ajustado para camel case
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY para autoincremento
    @Column(name = "id", nullable = false) // Nome da coluna ajustado para manter a consistência
    private Long id;

    @Column(name = "name", nullable = false) // Nome do campo e obrigatório
    private String name;

    @Column(name = "email", nullable = false, unique = true) // Nome do campo, obrigatório e único
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento") // Referência correta para chave estrangeira
    private Department department;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

//       SELECT * FROM TB_DEPARTMENT ;
//        SELECT * FROM TB_USER ;
//
//        DROP TABLE TB_DEPARTMENT ;
//        DROP TABLE  TB_USER ;

//        INSERT INTO TB_DEPARTMENT (ID_DEPARTAMENTO, NAME) VALUES (2, 'João');
//        INSERT INTO tb_department(id_departamento, name) VALUES (3,'Gestão');