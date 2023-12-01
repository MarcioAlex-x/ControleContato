package br.com.controlecontato.authentication.repository;


import br.com.controlecontato.authentication.models.RoleModels;
import br.com.controlecontato.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleModelsRepository extends JpaRepository<RoleModels, Long> {

    public List<RoleModels> findByRoleNameIn(List<RoleName> roles);

    public RoleModels findByRoleName(String nome);

}