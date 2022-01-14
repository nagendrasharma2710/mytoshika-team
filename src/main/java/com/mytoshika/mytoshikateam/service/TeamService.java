package com.mytoshika.mytoshikateam.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mytoshika.mytoshikateam.dto.Team1Dto;
import com.mytoshika.mytoshikateam.dto.TeamDto;
import com.mytoshika.mytoshikateam.entity.TeamEntity;
import com.mytoshika.mytoshikateam.repository.TeamRepository;

@Service
public class TeamService {
	
	@Value("${team.base.url}")
	private String teamBaseUrl;
	
	@Value("${team.volume.callLog}")
	private String teamVolumeCallLog;
	
	@Value("${team.base.yahoo}")
	private String teamBaseYahoo;
	
	@Value("${team.base.gmail}")
	private String teamBaseGmail;
	
	@Value("${description.id}")
	private List<String> descriptionId;
	
	@Value("${description.name}")
	private List<String> descriptionName;
	
	@Value("${description.purpose}")
	private List<String> descriptionPurpose;
	
	@Value("${data.address}")
	private Set<String> dataAddress;
	
	@Value("${team.member.degree}")
	private String[] teamMemberDegree;
	
	@Autowired
	private TeamRepository teamRepository;
	
	public TeamEntity addTeam(TeamDto teamDto) {
		TeamEntity teamEntity = new TeamEntity();
		teamEntity.setId(teamDto.getId());
		teamEntity.setTeamName(teamDto.getTeamName());
		teamEntity.setTeamDepartment(teamDto.getTeamDepartment());
		teamEntity.setDescription(teamDto.getDescription());
		return teamRepository.save(teamEntity);
	}
	
	public List<TeamDto> getAllTeam() { 
	List<TeamDto> listOfDto = new ArrayList<TeamDto>();
	List<TeamEntity> listOfEntity  = teamRepository.findAll();
 	 for(TeamEntity teamEntity : listOfEntity) {
 		 TeamDto teamDto = new TeamDto();
 		 teamDto.setId(teamEntity.getId());
 		 teamDto.setTeamName(teamEntity.getTeamName());
 		 teamDto.setTeamDepartment(teamEntity.getTeamDepartment());
 		 teamDto.setDescription(teamEntity.getDescription());
 		 listOfDto.add(teamDto);
 	     }
	return listOfDto;
 	 }	
	
	public TeamDto findById(int id) {
		TeamEntity teamEntity = teamRepository.findById(id).orElse(null);
		if(teamEntity==null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"team not found..");
		TeamDto teamDto = new TeamDto();
		teamDto.setId(teamEntity.getId());
		return teamDto;
	}
	
	public List<Integer> findListOfId() {
		List<Integer> ListOfId = new ArrayList<>();
		List<TeamEntity> ListOfteam = teamRepository.findAll();
		for(TeamEntity teamEntity : ListOfteam) {
			ListOfId.add(teamEntity.getId());
		}
		return ListOfId;
 	}
	
	public List<Team1Dto> findListOfAll() {
		List<Team1Dto> ListOfAll = new ArrayList<>();
		List<TeamEntity> ListOfteamDetail = teamRepository.findAll();
		for(TeamEntity teamEntity : ListOfteamDetail) {
			Team1Dto team1Dto = new Team1Dto();
			team1Dto.setId(teamEntity.getId());
			team1Dto.setTeamName(teamEntity.getTeamName());
			team1Dto.setDegree(teamMemberDegree);
			team1Dto.setDescription(descriptionName);
			team1Dto.setAddress(dataAddress);
			ListOfAll.add(team1Dto);
		}
		return ListOfAll;
	}
	
	public Map<Integer, TeamDto> findAllDetailInMap() {
		Map<Integer, TeamDto> ListOfAllDetailsInMap = new HashMap<Integer, TeamDto>();
		List<TeamEntity> ListOfteamDetailInMap = teamRepository.findAll();
		for(TeamEntity teamEntity : ListOfteamDetailInMap) {
			TeamDto teamDto = new TeamDto();
	 		 teamDto.setId(teamEntity.getId());
	 		 teamDto.setTeamName(teamEntity.getTeamName());
	 		 teamDto.setTeamDepartment(teamEntity.getTeamDepartment());
	 		 teamDto.setDescription(teamEntity.getDescription());
	 		 teamDto.setTeamUrl(teamBaseGmail+("?")+teamEntity.getId()+("?")+teamEntity.getTeamName());
	 		ListOfAllDetailsInMap.put(teamEntity.getId(), teamDto);
	    }
		return ListOfAllDetailsInMap;
	}
	
	public void deleteById(int id) {
		TeamEntity teamEntity = teamRepository.findById(id).orElse(null);
		if(teamEntity ==null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"team not found..");
		teamRepository.delete(teamEntity);
	}
}
