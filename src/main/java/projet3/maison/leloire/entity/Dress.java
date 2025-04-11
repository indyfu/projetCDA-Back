package projet3.maison.leloire.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Dress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private Style style;

    private Double prix;

    private String image;

    private String imageAlt1;

    private String imageAlt2;

    private String description;

    public Dress() {
    }

    public Dress(String name, Style style, Double prix, String image, String imageAlt1, String imageAlt2, String description) {
        this.name = name;
        this.style = style;
        this.prix = prix;
        this.image = image;
        this.imageAlt1 = imageAlt1;
        this.imageAlt2 = imageAlt2;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Style getStyle() {
        return style;
    }

    public Double getPrix() {
        return prix;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getImageAlt1() {
        return imageAlt1;
    }

    public String getImageAlt2() {
        return imageAlt2;
    }
}
