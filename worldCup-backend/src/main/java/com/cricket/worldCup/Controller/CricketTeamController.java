package com.cricket.worldCup.Controller;

import com.cricket.worldCup.DTO.GetCricketTeam;
import com.cricket.worldCup.DTO.PostCricketTeam;
import com.cricket.worldCup.DTO.PutCricketTeam;
import com.cricket.worldCup.Service.CricketTeamService;
import com.cricket.worldCup.entity.CricketTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/cricket/teams")
public class CricketTeamController {
    @Autowired
    private CricketTeamService service;

    @PostMapping("/save")
    public String SaveCricketTeam(@RequestBody PostCricketTeam postCricketTeam){
        String save = service.saveCricketTeam(postCricketTeam);
        return save;
    }
    @GetMapping("/getAllTeam")
    public List<GetCricketTeam> getCricketTeams(){
        List<GetCricketTeam> getCricketTeams = service.getAllCricketTeam();
        return getCricketTeams;
    }
    @GetMapping("{id}")
    public CricketTeam getCricketTeamById(@PathVariable("id") int cricketTeamId){
        return service.getCricketTeamById(cricketTeamId);
    }
    @PutMapping("/update")
    public String updateCricketTeam(@RequestBody PutCricketTeam putCricketTeam){
        String update = service.updateCricketTeam(putCricketTeam);
        return update;
    }

    @DeleteMapping("delete/{id}")
    public String deleteCricketTeam(@PathVariable("id") int cricketTeamId){
        service.deleteCricketTeam(cricketTeamId);
        return "Message \n Deleted Team From the List !.. ";
    }
}
