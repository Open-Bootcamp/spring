package com.example.springpatterns.patterns.creational.builder;

public class User {

	// atributos
	private Long id; // puede ser nulo (clase envoltorio Long)
	private String firstName;
	private String lastName;
	private String email;
	private Boolean married;

	// constructores
	public User(Long id, String firstName, String lastName, String email, Boolean married) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.married = married;
	}

	// getter y setter

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public Boolean getMarried() {
		return married;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMarried(Boolean married) {
		this.married = married;
	}

	// magia custom
	public static class Builder {

		private Long id;
		private String firstName;
		private String lastName;
		private String email;
		private Boolean married;

		User build() {
			// En caso de necesitar obligar a rellenar ciertas propiedades
//			if(this.id == null || this.email == null)
//				throws FieldsMandatory();
			return new User(this.id, this.firstName, this.lastName, this.email, this.married);
		}

		public Long getId() {
			return id;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public String getEmail() {
			return email;
		}

		public Boolean getMarried() {
			return married;
		}

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder setMarried(Boolean married) {
			this.married = married;
			return this;
		}

	}

}
