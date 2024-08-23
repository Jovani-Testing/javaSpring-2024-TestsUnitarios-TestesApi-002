package com.jotech.UsuarioDepartamento.service;

import com.jotech.UsuarioDepartamento.controllers.UserController;
import com.jotech.UsuarioDepartamento.entities.User;
import com.jotech.UsuarioDepartamento.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class PessoaService {
  @Autowired
  private UserRepository repository;

  public User createUser(User user) {

    if (user.getName() == null || user.getName().trim().isEmpty()) {
      throw new IllegalArgumentException("O campo 'nome' não pode ser nulo ou vazio.");
    }

    if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
      throw new IllegalArgumentException("O campo 'e-mail' não pode ser nulo ou vazio.");
    }

    if (user.getDepartment() == null) {
      throw new IllegalArgumentException("O campo 'departamento' não pode ser nulo.");
    }

    Long idDepartamento = user.getDepartment().getIdDepartamento();
    if (idDepartamento == null) {
      throw new IllegalArgumentException("O campo 'idDepartamento' não pode ser nulo.");
    }
    if (idDepartamento != 1 && idDepartamento != 2) {
      throw new IllegalArgumentException("O campo 'idDepartamento' deve ser 1 ou 2.");
    }
    return repository.save(user);
  }

  public User getUserById(Long id) {
    if (id == null) {
      throw new IllegalArgumentException("O ID não pode ser nulo.");
    }
    return repository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Usuário com ID " + id + " não encontrado."));
  }
  public List<User> findAll() {
    return repository.findAll();
  }
}


