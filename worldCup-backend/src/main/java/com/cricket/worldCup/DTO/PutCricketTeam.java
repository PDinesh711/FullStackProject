package com.cricket.worldCup.DTO;

public class PutCricketTeam {
    private int id;
    private String team;
    private int Wins;
    private int loss;
    private String result;
private String status;

    public PutCricketTeam(int id, String team, int wins, int loss, String result,String status) {
        this.id = id;
        this.team = team;
        Wins = wins;
        this.loss = loss;
        this.result = result;
        this.status=status;
    }

    public PutCricketTeam() {

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
