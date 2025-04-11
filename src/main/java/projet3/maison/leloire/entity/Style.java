package projet3.maison.leloire.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(255)")
    private StyleDress styleDress;

    public Style() {
    }

    public Style(StyleDress styleDress) {
        this.styleDress = styleDress;
    }

    public long getId() {
        return id;
    }

    public StyleDress getStyleDress() {
        return styleDress;
    }
}
