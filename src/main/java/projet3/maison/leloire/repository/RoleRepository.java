package projet3.maison.leloire.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import projet3.maison.leloire.entity.Role;
import projet3.maison.leloire.entity.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName(RoleName roleName);


}
