package projet3.maison.leloire.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    //  Constructeurs  //
    public Role() {
    }

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }

    //  Accesseurs  //

    public long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName.toString();

    }
}
