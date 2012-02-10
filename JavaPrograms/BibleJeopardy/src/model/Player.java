package model;

public class Player {
String name;
int points;
public Player(String name){
	this.name=name;
	points=0;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPoints() {
	return points;
}
public void addPoints(int point){
	this.points+=point;
}
public void deductPoints(int point){
	this.points-=point;
}

}
