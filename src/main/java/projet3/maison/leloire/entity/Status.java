package projet3.maison.leloire.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private StatusName statusName;

    public Status() {
    }

    public Status(StatusName statusName) {
        this.statusName = statusName;
    }

    public long getId() {
        return id;
    }

    public StatusName getStatusName() {
        return statusName;
    }
}
