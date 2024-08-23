package com.jotech.UsuarioDepartamento.controllers;

import com.jotech.UsuarioDepartamento.entities.User;
import com.jotech.UsuarioDepartamento.repositories.UserRepository;
import com.jotech.UsuarioDepartamento.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/user")
public class UserController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return pessoaService.createUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = pessoaService.getUserById(id);
        return ResponseEntity.ok(user);
    }


    @GetMapping
    public ResponseEntity<List<User>> findAll () {
        List<User> users = pessoaService.findAll();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = pessoaService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        pessoaService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}


//    @PutMapping(value = "/{id}")
//    public User updateUser(@PathVariable Long id, @RequestBody User userUpdate) {
//        User existingUser = repository.findById(id).orElse(null);
//
//        // Atualiza os campos do usuário apenas se ele existir
//        if (existingUser != null) {
//            existingUser.setName(userUpdate.getName());
//            existingUser.setEmail(userUpdate.getEmail());
//            existingUser.setDepartment(userUpdate.getDepartment());
//            // Adicione outras atualizações conforme necessário
//
//            // Salva as alterações no repositório
//            return repository.save(existingUser);
//        }
//
//        // Retorna null se o usuário não for encontrado
//        return null;
//    }
//
//
//    @DeleteMapping(value = "/{id}")
//    public void deletePessoa(@PathVariable Long id) {
//        // Verifica se o usuário existe antes de excluí-lo (opcional)
//        if (repository.existsById(id)) {
//            repository.deleteById(id);
//        }
//
//    }


