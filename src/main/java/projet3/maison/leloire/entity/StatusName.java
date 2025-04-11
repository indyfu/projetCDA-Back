package projet3.maison.leloire.entity;

public enum StatusName {
    EN_ATTENTE("En Attente"),
    ACCEPTE("Accepté"),
    REFUSE("Refusé"),
    ANNULE("Annulé"),
    DEVIS_DISPO("Devis disponible"),
    EN_CREATION("Création en cours"),
    TERMINE("Terminé");

    private String label;

    StatusName(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
