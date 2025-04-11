package projet3.maison.leloire.entity.dto;

public class UserDto {

    /////////////////
    /// Attributs ///
    /////////////////

    private final Long id;
    private final String name;
    private final String surname;
    private final String token;

    /////////////////////
    /// Constructeurs ///
    /////////////////////

    public UserDto(Long id, String name, String surname, String token) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.token = token;
    }

    ///////////////
    /// Getters ///
    ///////////////

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getToken() {
        return token;
    }
}