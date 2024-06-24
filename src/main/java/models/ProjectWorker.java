package models;

import java.sql.Timestamp;

public class ProjectWorker {
	private int idWorker;
	private int idProject;
	private String nameProject;
	private String nameWorker;
	private String role;
	private int weeklyAssignedHours;
	private Timestamp assignmentDate;

	public ProjectWorker(int idWorker, int idProject, String nameProject, String nameWorker, String role,
			int weeklyAssignedHours, Timestamp assignmentDate) {
		super();
		this.idWorker = idWorker;
		this.idProject = idProject;
		this.nameProject = nameProject;
		this.nameWorker = nameWorker;
		this.role = role;
		this.weeklyAssignedHours = weeklyAssignedHours;
		this.assignmentDate = assignmentDate;
	}

	public ProjectWorker(int idWorker, int idProject, String role, int weeklyAssignedHours, Timestamp assignmentDate) {
		this.idWorker = idWorker;
		this.idProject = idProject;
		this.role = role;
		this.weeklyAssignedHours = weeklyAssignedHours;
		this.assignmentDate = assignmentDate;
	}

	public ProjectWorker(int idWorker, int idProject, String role, int weeklyAssignedHours) {
		this.idWorker = idWorker;
		this.idProject = idProject;
		this.role = role;
		this.weeklyAssignedHours = weeklyAssignedHours;
	}

	public ProjectWorker(int idWorker, int idProject, String nameProject, String role, int weeklyAssignedHours) {
		this.idWorker = idWorker;
		this.idProject = idProject;
		this.nameProject = nameProject;
		this.role = role;
		this.weeklyAssignedHours = weeklyAssignedHours;
	}

	public int getIdWorker() {
		return idWorker;
	}

	public void setIdWorker(int idWorker) {
		this.idWorker = idWorker;
	}

	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}

	public String getNameWorker() {
		return nameWorker;
	}

	public void setNameWorker(String nameWorker) {
		this.nameWorker = nameWorker;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getWeeklyAssignedHours() {
		return weeklyAssignedHours;
	}

	public void setWeeklyAssignedHours(int weeklyAssignedHours) {
		this.weeklyAssignedHours = weeklyAssignedHours;
	}

	public Timestamp getAssignmentDate() {
		return assignmentDate;
	}

	public void setAssignmentDate(Timestamp assignmentDate) {
		this.assignmentDate = assignmentDate;
	}

	@Override
	public String toString() {
		return nameProject;
	}

}