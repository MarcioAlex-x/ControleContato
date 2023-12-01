package br.com.controlecontato.authentication.repository;


import br.com.controlecontato.authentication.models.UserModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModels, Long> {

    Optional<UserModels> findByUserName(String userName);
}