package app.diegoGarcia_evaluation.security.repository;


import app.block5crudvalidation.security.models.ERole;
import app.block5crudvalidation.security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
