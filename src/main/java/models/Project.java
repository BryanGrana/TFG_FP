package models;

import java.sql.Date;

public class Project {
	private int id;
	private String name;
	private String description;
	private double budget;
	private Date startDate;
	private Date endDate;

	public Project(int id, String name, String description, double budget, Date startDate, Date endDate) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.budget = budget;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Project() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return name;
	}

}