package com.jotech.UsuarioDepartamento.repositories;

import com.jotech.UsuarioDepartamento.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
