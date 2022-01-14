package com.mytoshika.mytoshikateam.dto;

import java.util.List;
import java.util.Set;
import lombok.Data;

@Data
public class Team1Dto {
	
	private int id;
	private String teamName;
	private String[] degree;
	private List<String> description;
	private Set<String> address;
	
}
