package projet3.maison.leloire.entity.dto;

public class MensurationDto {

    private Double longueurTailleDos;
    private Double longueurTailleDevant;
    private Double tourPoitrine;
    private Double hauteurPoitrine;
    private Double demiEcartPoitrine;
    private Double tourTaille;
    private Double tourPetiteHanche;
    private Double tourGrandeHanche;
    private Double demiTourEncolure;
    private Double demiCarrureDos;
    private Double demiCarrureDevant;
    private Double longueurEpaule;
    private Double tourEmmanchure;
    private Double hauteurDessousBras;
    private Double longueurBras;
    private Double grosseurBras;
    private Double hauteurCoude;
    private Double tourPoigner;
    private Double hauteurTailleHanche;
    private Double hauteurMontant;
    private Double enfourchure;
    private Double hauteurTailleGenou;
    private Double hauteurTailleATerre;
    private Double hauteurTailleCoteATerre;
    private Long idRendezVous; // Utilisez l'ID pour la relation ManyToOne

    // Constructeur par défaut
    public MensurationDto() {
    }

    // Constructeur avec tous les champs
    public MensurationDto(Double longueurTailleDos, Double longueurTailleDevant, Double tourPoitrine, Double hauteurPoitrine, Double demiEcartPoitrine, Double tourTaille, Double tourPetiteHanche, Double tourGrandeHanche, Double demiTourEncolure, Double demiCarrureDos, Double demiCarrureDevant, Double longueurEpaule, Double tourEmmanchure, Double hauteurDessousBras, Double longueurBras, Double grosseurBras, Double hauteurCoude, Double tourPoigner, Double hauteurTailleHanche, Double hauteurMontant, Double enfourchure, Double hauteurTailleGenou, Double hauteurTailleATerre, Double hauteurTailleCoteATerre, Long idRendezVous) {
        this.longueurTailleDos = longueurTailleDos;
        this.longueurTailleDevant = longueurTailleDevant;
        this.tourPoitrine = tourPoitrine;
        this.hauteurPoitrine = hauteurPoitrine;
        this.demiEcartPoitrine = demiEcartPoitrine;
        this.tourTaille = tourTaille;
        this.tourPetiteHanche = tourPetiteHanche;
        this.tourGrandeHanche = tourGrandeHanche;
        this.demiTourEncolure = demiTourEncolure;
        this.demiCarrureDos = demiCarrureDos;
        this.demiCarrureDevant = demiCarrureDevant;
        this.longueurEpaule = longueurEpaule;
        this.tourEmmanchure = tourEmmanchure;
        this.hauteurDessousBras = hauteurDessousBras;
        this.longueurBras = longueurBras;
        this.grosseurBras = grosseurBras;
        this.hauteurCoude = hauteurCoude;
        this.tourPoigner = tourPoigner;
        this.hauteurTailleHanche = hauteurTailleHanche;
        this.hauteurMontant = hauteurMontant;
        this.enfourchure = enfourchure;
        this.hauteurTailleGenou = hauteurTailleGenou;
        this.hauteurTailleATerre = hauteurTailleATerre;
        this.hauteurTailleCoteATerre = hauteurTailleCoteATerre;
        this.idRendezVous = idRendezVous;
    }

    // Getters
    public Double getLongueurTailleDos() {
        return longueurTailleDos;
    }

    public Double getLongueurTailleDevant() {
        return longueurTailleDevant;
    }

    public Double getTourPoitrine() {
        return tourPoitrine;
    }

    public Double getHauteurPoitrine() {
        return hauteurPoitrine;
    }

    public Double getDemiEcartPoitrine() {
        return demiEcartPoitrine;
    }

    public Double getTourTaille() {
        return tourTaille;
    }

    public Double getTourPetiteHanche() {
        return tourPetiteHanche;
    }

    public Double getTourGrandeHanche() {
        return tourGrandeHanche;
    }

    public Double getDemiTourEncolure() {
        return demiTourEncolure;
    }

    public Double getDemiCarrureDos() {
        return demiCarrureDos;
    }

    public Double getDemiCarrureDevant() {
        return demiCarrureDevant;
    }

    public Double getLongueurEpaule() {
        return longueurEpaule;
    }

    public Double getTourEmmanchure() {
        return tourEmmanchure;
    }

    public Double getHauteurDessousBras() {
        return hauteurDessousBras;
    }

    public Double getLongueurBras() {
        return longueurBras;
    }

    public Double getGrosseurBras() {
        return grosseurBras;
    }

    public Double getHauteurCoude() {
        return hauteurCoude;
    }

    public Double getTourPoigner() {
        return tourPoigner;
    }

    public Double getHauteurTailleHanche() {
        return hauteurTailleHanche;
    }

    public Double getHauteurMontant() {
        return hauteurMontant;
    }

    public Double getEnfourchure() {
        return enfourchure;
    }

    public Double getHauteurTailleGenou() {
        return hauteurTailleGenou;
    }

    public Double getHauteurTailleATerre() {
        return hauteurTailleATerre;
    }

    public Double getHauteurTailleCoteATerre() {
        return hauteurTailleCoteATerre;
    }

    public Long getIdRendezVous() {
        return idRendezVous;
    }

    // Setters
    public void setLongueurTailleDos(Double longueurTailleDos) {
        this.longueurTailleDos = longueurTailleDos;
    }

    public void setLongueurTailleDevant(Double longueurTailleDevant) {
        this.longueurTailleDevant = longueurTailleDevant;
    }

    public void setTourPoitrine(Double tourPoitrine) {
        this.tourPoitrine = tourPoitrine;
    }

    public void setHauteurPoitrine(Double hauteurPoitrine) {
        this.hauteurPoitrine = hauteurPoitrine;
    }

    public void setDemiEcartPoitrine(Double demiEcartPoitrine) {
        this.demiEcartPoitrine = demiEcartPoitrine;
    }

    public void setTourTaille(Double tourTaille) {
        this.tourTaille = tourTaille;
    }

    public void setTourPetiteHanche(Double tourPetiteHanche) {
        this.tourPetiteHanche = tourPetiteHanche;
    }

    public void setTourGrandeHanche(Double tourGrandeHanche) {
        this.tourGrandeHanche = tourGrandeHanche;
    }

    public void setDemiTourEncolure(Double demiTourEncolure) {
        this.demiTourEncolure = demiTourEncolure;
    }

    public void setDemiCarrureDos(Double demiCarrureDos) {
        this.demiCarrureDos = demiCarrureDos;
    }

    public void setDemiCarrureDevant(Double demiCarrureDevant) {
        this.demiCarrureDevant = demiCarrureDevant;
    }

    public void setLongueurEpaule(Double longueurEpaule) {
        this.longueurEpaule = longueurEpaule;
    }

    public void setTourEmmanchure(Double tourEmmanchure) {
        this.tourEmmanchure = tourEmmanchure;
    }

    public void setHauteurDessousBras(Double hauteurDessousBras) {
        this.hauteurDessousBras = hauteurDessousBras;
    }

    public void setLongueurBras(Double longueurBras) {
        this.longueurBras = longueurBras;
    }

    public void setGrosseurBras(Double grosseurBras) {
        this.grosseurBras = grosseurBras;
    }

    public void setHauteurCoude(Double hauteurCoude) {
        this.hauteurCoude = hauteurCoude;
    }

    public void setTourPoigner(Double tourPoigner) {
        this.tourPoigner = tourPoigner;
    }

    public void setHauteurTailleHanche(Double hauteurTailleHanche) {
        this.hauteurTailleHanche = hauteurTailleHanche;
    }

    public void setHauteurMontant(Double hauteurMontant) {
        this.hauteurMontant = hauteurMontant;
    }

    public void setEnfourchure(Double enfourchure) {
        this.enfourchure = enfourchure;
    }

    public void setHauteurTailleGenou(Double hauteurTailleGenou) {
        this.hauteurTailleGenou = hauteurTailleGenou;
    }

    public void setHauteurTailleATerre(Double hauteurTailleATerre) {
        this.hauteurTailleATerre = hauteurTailleATerre;
    }

    public void setHauteurTailleCoteATerre(Double hauteurTailleCoteATerre) {
        this.hauteurTailleCoteATerre = hauteurTailleCoteATerre;
    }

    public void setIdRendezVous(Long idRendezVous) {
        this.idRendezVous = idRendezVous;
    }
}
