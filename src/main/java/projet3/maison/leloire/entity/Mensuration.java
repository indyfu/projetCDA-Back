package projet3.maison.leloire.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Mensuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment de la clé primaire
    @Column(name = "idMensuration")
    private Integer idMensuration;

    @Column(name = "longueurTailleDos")
    private Double longueurTailleDos;

    @Column(name = "longueurTailleDevant")
    private Double longueurTailleDevant;

    @Column(name = "tourPoitrine")
    private Double tourPoitrine;

    @Column(name = "hauteurPoitrine")
    private Double hauteurPoitrine;

    @Column(name = "demiEcartPoitrine")
    private Double demiEcartPoitrine;

    @Column(name = "tourTaille")
    private Double tourTaille;

    @Column(name = "tourPetiteHanche")
    private Double tourPetiteHanche;

    @Column(name = "tourGrandeHanche")
    private Double tourGrandeHanche;

    @Column(name = "demiTourEncolure")
    private Double demiTourEncolure;

    @Column(name = "demiCarrureDos")
    private Double demiCarrureDos;

    @Column(name = "demiCarrureDevant")
    private Double demiCarrureDevant;

    @Column(name = "longueurEpaule")
    private Double longueurEpaule;

    @Column(name = "tourEmmanchure")
    private Double tourEmmanchure;

    @Column(name = "hauteurDessousBras")
    private Double hauteurDessousBras;

    @Column(name = "longueurBras")
    private Double longueurBras;

    @Column(name = "grosseurBras")
    private Double grosseurBras;

    @Column(name = "hauteurCoude")
    private Double hauteurCoude;

    @Column(name = "tourPoigner")
    private Double tourPoigner;

    @Column(name = "hauteurTailleHanche")
    private Double hauteurTailleHanche;

    @Column(name = "hauteurMontant")
    private Double hauteurMontant;

    @Column(name = "enfourchure")
    private Double enfourchure;

    @Column(name = "hauteurTailleGenou")
    private Double hauteurTailleGenou;

    @Column(name = "hauteurTailleATerre")
    private Double hauteurTailleATerre;

    @Column(name = "hauteurTailleCoteATerre")
    private Double hauteurTailleCoteATerre;

    // Mapping de la relation avec la table Rendez_vous (relation @ManyToOne)
    @ManyToOne
    @JoinColumn(name = "idRendezVous", referencedColumnName = "id", nullable = true)
    private RendezVous rendezVous;

    public Mensuration(Double longueurTailleDos, Double longueurTailleDevant, Double tourPoitrine, Double hauteurPoitrine, Double demiEcartPoitrine, Double tourTaille, Double tourPetiteHanche, Double tourGrandeHanche, Double demiTourEncolure, Double demiCarrureDos, Double demiCarrureDevant, Double longueurEpaule, Double tourEmmanchure, Double hauteurDessousBras, Double longueurBras, Double grosseurBras, Double hauteurCoude, Double tourPoigner, Double hauteurTailleHanche, Double hauteurMontant, Double enfourchure, Double hauteurTailleGenou, Double hauteurTailleATerre, Double hauteurTailleCoteATerre) {
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

    }

    public Integer getIdMensuration() {
        return idMensuration;
    }

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

    public RendezVous getRendezVous() {
        return rendezVous;
    }

    public void setIdMensuration(Integer idMensuration) {
        this.idMensuration = idMensuration;
    }

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

    public void setRendezVous(RendezVous rendezVous) {
        this.rendezVous = rendezVous;
    }
}