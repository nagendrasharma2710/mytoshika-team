package com.mytoshika.mytoshikateam.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mytoshika.mytoshikateam.dto.Team1Dto;
import com.mytoshika.mytoshikateam.dto.TeamDto;
import com.mytoshika.mytoshikateam.entity.TeamEntity;
import com.mytoshika.mytoshikateam.service.TeamService;

@RestController
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@PostMapping("/addTeam")
	public String addTeam(@Valid @RequestBody TeamDto teamDto) {
		teamService.addTeam(teamDto);
		return "Team added successfully";
	}

	@GetMapping("/getAllTeam")
	public List<TeamDto> showAllTeam() {
		return teamService.getAllTeam();
	}

	@GetMapping("/getTeam/{id}")
	public TeamDto getTeam(@PathVariable int id) {
		return teamService.findById(id);
	}

	@GetMapping("/getTeamList")
	public List<Integer> getTeamList() {
		return teamService.findListOfId();
	}
	
	@GetMapping("/findListOfAllTeam")
	public List<Team1Dto> findListOfAllTeam() {
		return teamService.findListOfAll();
	}
	
	@GetMapping("/findAllDetailInMap")
	public Map<Integer, TeamDto> findAllDetailInMap() {
		return teamService.findAllDetailInMap();
	}
	
	@DeleteMapping("/deleteTeamById/{id}")
	public String deleteById1(@PathVariable int id) {
		teamService.deleteById(id);
		return "Team deleted successfully";
	}

}
