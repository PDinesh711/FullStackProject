package com.cricket.worldCup.Service;

import com.cricket.worldCup.DTO.GetCricketTeam;
import com.cricket.worldCup.DTO.PostCricketTeam;
import com.cricket.worldCup.DTO.PutCricketTeam;
import com.cricket.worldCup.entity.CricketTeam;

import java.util.List;

public interface CricketTeamService {
     String saveCricketTeam(PostCricketTeam postCricketTeam);
     List<GetCricketTeam> getAllCricketTeam();
     CricketTeam getCricketTeamById(int cricketTeamId);
     String updateCricketTeam(PutCricketTeam putCricketTeam);
     boolean deleteCricketTeam(int cricketTeamId);
}
