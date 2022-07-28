package com.skillstorm.demo.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;

@Entity
@Table(name = "pet")
public class Pet {

	// JSR-303 (AKA Bean Validation)
	
	/*
	 * Instead writing boiler plate validation checks, we can use annotations to do this
	 * These annotations will be implicitly checked when Spring creates our objects for us (through Jackson)
	 * 
	 * Validation Annotations:
	 * 
	 * @NotNull - Field cannot be null
	 * @NotEmpty - Strings/Lists/Arrays/Maps cannot be empty
	 * @NotBlank - Strings cannot be an empty string ""
	 * @Min(num) - For numeric values, allows us to specify a minimum
	 * @Max(num) - Same as min, but for max
	 * @Pattern(regex) - Look at a string to ensure that it matches some pattern
	 * @Email - Simple, provided regex for email validation
	 * @Past - When dealing with dates, ensures the date is in the past
	 * @Future - Same as past, but deals with the future
	 * 
	 * @Validated - This goes on the class and ensures that the object be validated to call any method on it
	 * @Valid - Applied to individual parameters/values. Runs validation. Throws exception if not valid
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pet_id")
	private int id;
	
	@NotBlank
	@Column // defaults to using the Java variable name
	private String animal;
	
	@NotBlank
	@Column
	private String breed;

	@NotBlank
	@Column
	private String name;
	
//	@NotNull // I may have ownerless pets
	// This is a foreign key to the Owner table. As such, it is a join Column
//	@ManyToOne(fetch = FetchType.LAZY) // Don't grab this data until calling getOwner()
	@ManyToOne // defaults to eager
	@JoinColumn(name = "owner_id")
//	@JsonBackReference // This does not get serialized. It's accessed on the other end
	@JsonIdentityReference(alwaysAsId = true)
	private Owner owner;
	
	public Pet() {
		super();
	}

	public Pet(int id, String animal, String breed, String name, Owner owner) {
		super();
		this.id = id;
		this.animal = animal;
		this.breed = breed;
		this.name = name;
		this.owner = owner;
	}

	public Pet(String animal, String breed, String name, Owner owner) {
		super();
		this.animal = animal;
		this.breed = breed;
		this.name = name;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		return id == other.id;
	}
}
