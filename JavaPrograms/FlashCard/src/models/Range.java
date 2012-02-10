package models;
public class Range{
	//the start is inclusive but the end is not
	//so if start is 0 and end is 40, it really goes from 0 to anything <40
	private double start=0;
	private double end=0;
	public Range(double startVal,double endVal){
		start=startVal;
		end=endVal;
	
	}
	public void setVals(double startVal,double endVal){
		start=startVal;
		end=endVal;
	}
	public double getStart(){
		return start;
		}
	public double getEnd(){
		return end;
	}
	public String toString(){
		return "( "+start+"-"+end+")";
	}
}