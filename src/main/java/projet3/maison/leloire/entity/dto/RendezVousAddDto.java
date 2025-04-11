package projet3.maison.leloire.entity.dto;

import java.time.LocalDateTime;

public class RendezVousAddDto {

        /// ///////// ///
        /// Attributs ///
        /// ///////// ///

    private LocalDateTime date_du_rendez_vous;
    private long userId;
    private long dressId;
    private String commentaire;



    /// /////// ///
    /// Getters ///
    /// /////// ///

    public LocalDateTime getDate_du_rendez_vous() {
        return date_du_rendez_vous;
    }

    public long getUserId() {
        return userId;
    }

    public long getDressId() {
        return dressId;
    }

    public String getCommentaire() {
        return commentaire;
    }
}
