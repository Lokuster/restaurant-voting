package ru.javaops.bootjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javaops.bootjava.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}