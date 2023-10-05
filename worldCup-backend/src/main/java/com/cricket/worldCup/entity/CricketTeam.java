package com.cricket.worldCup.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Worldcup_Cricket")
public class CricketTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private String team;
    @Column
    private int Wins;
    @Column
    private int loss;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column
    private String result;
    @Column
    private String status;



    public CricketTeam(int id, String team, int wins, int loss, String result,String status) {
        this.id = id;
        this.team = team;
        Wins = wins;
        this.loss = loss;
        this.result = result;
        this.status=status;
    }

    public CricketTeam() {

    }

    public CricketTeam(String team, int wins, int loss, String result,String status) {
        this.team = team;
        Wins = wins;
        this.loss = loss;
        this.result = result;
        this.status=status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getWins() {
        return Wins;
    }

    public void setWins(int wins) {
        Wins = wins;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
