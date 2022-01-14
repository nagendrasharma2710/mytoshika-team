package com.mytoshika.mytoshikateam.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mytoshika_team")
public class TeamEntity {

	@Id
	@GeneratedValue
    private int id;
	private String teamName;
	private String teamDepartment;
	private String description;
	
	
	public String toString() {
		return "EmpEntity [id=" + id + ", teamName=" + teamName + ", teamDepartment=" + teamDepartment
				+ ", description=" + description + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamDepartment() {
		return teamDepartment;
	}
	public void setTeamDepartment(String teamDepartment) {
		this.teamDepartment = teamDepartment;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
