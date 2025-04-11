package projet3.maison.leloire.repository;


import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import projet3.maison.leloire.entity.User;

import java.util.Optional;

/*
*   Spring Data JPA fabriquera au démarrage de l'application une implémentation concrète de cette interface
*   avec ses méthodes  concrètes
*/
@Repository
public interface UserRepository extends JpaRepository<User, Long>{ // Le JpaRepository nous donne accès aux méthodes de bases des requêtes.
    //Il faut lui préciser le type d'objet qu'il attend


    // On donne la signature des méthodes qu'il attend
    User findById (long id);
/*
    Écrire "findBy suivi des noms des attributs de l'entité, séparés pas des "AND" permettra
    à Spring Data JPA de générer une requête SQL.
 */
    // Il faut écrire précisément findBy (Spring JPA le reconnait) + le ou
    // les attributs écrit exactement de la même façon que dans l'entity
    User findByLoginAndPassword(String login, String password);

    /*
    On peut écrire en JPQL ou SQL une requête spécifique qui sera utilisée dans
    l'implémentation de cette méthode abstraite.
     */
    // On fait une requête JPQL pour récupérer les AUTRES owner ayant des pets.
//    @Query("Select o FROM User u WHERE u.id != :selfId AND size(o.pets) > 0 ")
//    List<User> findAllButSelf (@Param("selfId")long selfId);

    Boolean existsByLogin (String login);
    Optional<User> findByLogin (String login);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.name =:name, u.surname=:surname, u.address=:adresse, u.phoneNumber=:telephone, u.email=:email WHERE u.id=:userId ")
    void modifyUser(@Param("userId") Long userId, @Param("name") String name, @Param("surname") String surname, @Param("adresse") String adresse, @Param("telephone") String telephone, @Param("email") String email);

}
