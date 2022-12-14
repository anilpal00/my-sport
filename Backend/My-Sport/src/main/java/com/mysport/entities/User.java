package com.mysport.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.mysport.validator.BirthDate;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@NotBlank
	@Size(max = 120)
	private String msID;

//	---------------------------------Profile Field----------------------------------------

	@Size(max = 120)
	private String firstName;

	@Size(max = 120)
	private String lastName;

	@Size(min = 10, max = 10)
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String mobileNo;

	// @NotNull(message = "The date of birth is required.")
	@BirthDate(message = "The birth date must be greater or equal than 18")
	@Past(message = "The date of birth must be in the past.")
	private Date dateOfBirth;
	
//	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}")
	@Size(max = 12)
	private String pan;
    
	private String country;
	
	private String street;
	
	private String city;
	
	private String state;
	
    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;
	
    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

	public User() {
	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

}
