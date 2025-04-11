package projet3.maison.leloire.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
public class RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private LocalDateTime dateDuRendezVous;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @OneToOne
    private Dress dress;

    private LocalDateTime dateAnnulation;

    private String motifAnnulation;
    private String commentaire;

    public RendezVous(LocalDateTime dateDuRendezVous, User user, Dress dress) {
    }

    public User getUser() {
        return user;
    }
    @OneToOne
    public Dress getDress() {
        return dress;
    }

    @OneToOne
    public Status status;

    public RendezVous() {
    }

    public RendezVous(LocalDateTime dateDuRendezVous,String commentaire, User user, Dress dress, Status status) {
        this.dateDuRendezVous = dateDuRendezVous;
        this.commentaire = commentaire;
        this.user = user;
        this.dress = dress;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateDuRendezVous() {
        return dateDuRendezVous;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public LocalDateTime getDateAnnulation() {
        return dateAnnulation;
    }

    public String getMotifAnnulation() {
        return motifAnnulation;
    }

    public Status getStatus() {
        return status;
    }

    public void setDateAnnulation(LocalDateTime dateAnnulation) {
        this.dateAnnulation = dateAnnulation;
    }

    public void setMotifAnnulation(String motifAnnulation) {
        this.motifAnnulation = motifAnnulation;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDateDuRendezVous(LocalDateTime dateDuRendezVous) {
        this.dateDuRendezVous = dateDuRendezVous;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
