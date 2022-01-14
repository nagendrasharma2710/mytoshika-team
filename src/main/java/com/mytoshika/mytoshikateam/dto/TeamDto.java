package com.mytoshika.mytoshikateam.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TeamDto {

	private int id;
	private String teamName;
	private String teamDepartment;
	
	@Pattern(regexp="^[a-zA-Z0-9_.]+$", message = "description should be alphanumeric, period(.)")
	@Size(max=30, message = "description size should not be greater than 30")
	private String description;
	private String teamUrl;

}


