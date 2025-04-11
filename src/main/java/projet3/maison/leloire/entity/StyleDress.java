package projet3.maison.leloire.entity;

public enum StyleDress {
    PRINCESS("Princesse"),

    SIRENE("Sirène"),

    VINTAGE("Vintage"),
    ROMANTIQUE("Romantique"),

    MODERN("Moderne"),

    CLASSIQUE("Classique"),

    CHIC("Chic"),

    COCKTAIL(" Robe de Cocktail"),

    DRAPPED("Robe Drapée"),

    LACE("Robe en Dentelle");

    private final String displayName;

    // Constructor
    StyleDress(String displayName) {
        this.displayName = displayName;
    }

    // Getter
    public String getDisplayName() {
        return displayName;
    }

}
