package projet3.maison.leloire.entity.dto;

import projet3.maison.leloire.entity.Style;

public class DressDto {


    private String name;

    private Long styleId;

    private Double prix;

    private String image;

    private String imageAlt1;

    private String imageAlt2;

    private String description;

    public DressDto() {
    }

    public DressDto(String name, Long styleId, Double prix, String image, String imageAlt1, String imageAlt2, String description) {
        this.name = name;
        this.styleId = styleId;
        this.prix = prix;
        this.image = image;
        this.imageAlt1 = imageAlt1;
        this.imageAlt2 = imageAlt2;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Long getStyleId() {
        return styleId;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setStyleId(Long styleId) {
        this.styleId = styleId;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageAlt1(String imageAlt1) {
        this.imageAlt1 = imageAlt1;
    }

    public void setImageAlt2(String imageAlt2) {
        this.imageAlt2 = imageAlt2;
    }
}
