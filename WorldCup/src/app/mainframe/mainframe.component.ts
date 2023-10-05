import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-mainframe',
  templateUrl: './mainframe.component.html',
  styleUrls: ['./mainframe.component.css']
})
export class MainframeComponent {
CricketTeam:Array<any>=[];
team:String="";
Wins:number=0;
loss:number=0;
result:String ="";
status:String ="";
teamId=''
baseUrl:String="http://localhost:8080/api/cricket/teams"
constructor(private http:HttpClient){
  this.getCricketTeam()
}

getCricketTeam(){
this.http.get<any>(`${this.baseUrl}/getAllTeam`).subscribe((data)=>{
  console.log(data);
this.CricketTeam=data;
})}

register(){
  let postbody={
    "team": this.team,
    "loss": this.loss,
    "result": this.result,
    "status": this.status,
    "wins": this.Wins
}
this.http.post(`${this.baseUrl}/save`,postbody,{responseType:'text'}).subscribe((data)=>{
  console.log(data);
  this.getCricketTeam();
  this.team="";
  this.Wins=0;
  this.loss=0;
  this.result="";
  this.status="";    
})
}

updateInit(data:any){
  this.teamId=data.id;
  this.team=data.team;
  this.Wins=data.wins;
  this.loss=data.loss;
  this.result=data.result;
  this.status=data.status;
}
updateRecord(){
  let putbody={
    "id":this.teamId,
    "team": this.team,
    "loss": this.loss,
    "result": this.result,
    "status": this.status,
    "wins": this.Wins
}
this.http.put(`${this.baseUrl}/update`,putbody,{responseType:'text'}).subscribe((data)=>{
  this.getCricketTeam();
  console.log(data);
  this.team="";
  this.Wins=0;
  this.loss=0;
  this.result="";
  this.status="";  
})
}
save(){
   if(this.teamId==''){
    this.register();
   }
   else{
    this.updateRecord();
   }
}
deletecricket(data:any){
  this.http.delete(`${this.baseUrl}/delete/${data.id}`,{responseType:'text'}).subscribe((data)=>{
    console.log(data);
    this.getCricketTeam();
    this.team="";
  this.Wins=0;
  this.loss=0;
  this.result="";
  this.status="";
  })
}
}
