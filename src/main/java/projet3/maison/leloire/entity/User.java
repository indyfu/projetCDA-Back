package projet3.maison.leloire.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	private  String name;
	private  String surname;

	@JsonIgnore // Ce champs ne sera pas inclut lors du transfert du owner en Json.
	private  String login;

	@JsonIgnore
	private  String password;

	@Column(name = "adresse")
	private String address;

	@Column(name = "telephone")
	private String phoneNumber;

	private String email;


	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private List<Role> roles;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private final List<RendezVous> rdv = new ArrayList<>();
	
	public User() {
	}

	public User(String name, String surname, String login, String password,String address,String phoneNumber,
				List<Role> roles, String email) {
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.roles = roles;
		this.email = email;
	}

	/*
	Les accesseurs sont nécessaires pour la sérialisation de notre objet
	 */

	/// ///////////
	/// Getters ///
	/// ///////////
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSurname() {return surname;}


	public List<Role> getRoles() {
		return roles;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
