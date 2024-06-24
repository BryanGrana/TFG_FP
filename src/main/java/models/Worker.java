package models;

import java.sql.Date;

public class Worker {
	private int id;
	private String imagePath;
	private String name;
	private String lastname;
	private String email;
	private Date dateOfBirth;
	private long phone;
	private String address;

	public Worker(int id, String imagePath, String name, String lastname, String email, Date dateOfBirth, long phone,
			String address) {
		this.id = id;
		this.imagePath = imagePath;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.address = address;
	}

	public Worker() {

	}

	public Worker(String imagePath, String name, String lastname, String email, Date dateOfBirth, long phone,
			String address) {
		this.imagePath = imagePath;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return lastname + ", " + name;
	}

}