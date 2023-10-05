package com.cricket.worldCup.Service;

import com.cricket.worldCup.DTO.GetCricketTeam;
import com.cricket.worldCup.DTO.PostCricketTeam;
import com.cricket.worldCup.DTO.PutCricketTeam;
import com.cricket.worldCup.Repository.CricketTeamRepository;
import com.cricket.worldCup.entity.CricketTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CricketTeamImpl implements CricketTeamService{
    @Autowired
    private CricketTeamRepository repository;
    @Override
    public String saveCricketTeam(PostCricketTeam postCricketTeam) {
        CricketTeam cricketTeam= new CricketTeam(
                postCricketTeam.getTeam(),
                postCricketTeam.getWins(),
                postCricketTeam.getLoss(),
                postCricketTeam.getResult(),
                postCricketTeam.getStatus()
        );
        repository.save(cricketTeam);
        return postCricketTeam.getTeam();
    }

    @Override
    public List<GetCricketTeam> getAllCricketTeam() {
        List<CricketTeam> getAll = repository.findAll();
        List<GetCricketTeam> getCricketTeams = new ArrayList<>();
        for(CricketTeam cricketTeam:getAll){
            GetCricketTeam getCricketTeam = new GetCricketTeam(
                    cricketTeam.getId(),
                    cricketTeam.getTeam(),
                    cricketTeam.getWins(),
                    cricketTeam.getLoss(),
                    cricketTeam.getResult(),
                    cricketTeam.getStatus()
            );
            getCricketTeams.add(getCricketTeam);
        }
        return getCricketTeams;
    }

    @Override
    public CricketTeam getCricketTeamById(int cricketTeamId) {
        Optional<CricketTeam> optionalCricketTeam= repository.findById(cricketTeamId);
        return optionalCricketTeam.get();
    }

    @Override
    public String updateCricketTeam(PutCricketTeam putCricketTeam) {
        if(repository.existsById(putCricketTeam.getId())){
            CricketTeam cricketTeam = repository.getById(putCricketTeam.getId());
            cricketTeam.setTeam(putCricketTeam.getTeam());
            cricketTeam.setWins(putCricketTeam.getWins());
            cricketTeam.setLoss(putCricketTeam.getLoss());
            cricketTeam.setResult(putCricketTeam.getResult());
            cricketTeam.setStatus(putCricketTeam.getStatus());
            repository.save(cricketTeam);
        }
        else{
            System.out.println("Team Not In List !Sorry");
        }
        return "Message \nUpdated ! Team: "+putCricketTeam.getTeam();
    }

    @Override
    public boolean deleteCricketTeam(int cricketTeamId) {
       if (repository.existsById(cricketTeamId)){
           repository.deleteById(cricketTeamId);
       }
       else{
           System.out.println("Team Not Found in the List");
       }
       return true;
    }
}
