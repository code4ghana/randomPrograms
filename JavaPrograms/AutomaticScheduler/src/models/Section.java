package models;

import java.util.HashMap;

public class Section {
	public Section(String sectionNum,String instructor,String location,String coursenum,String status){
		this.sectionNum=sectionNum;
		this.instructor=instructor;
		this.location=location;
		this.courseNum=coursenum;
		this.status=status;
	}
	//ex: tuesday ----[1:00pm, Mech205]
	private HashMap<String,String[]> daysToMeetingTimeAndLocations;
	private String sectionNum,instructor,location,courseNum,status;
	public boolean open;

	public HashMap<String, String[]> getDaysToMeetingTimeAndLocations() {
		return daysToMeetingTimeAndLocations;
	}
	public void setDaysToMeetingTimeAndLocations(
			HashMap<String, String[]> daysToMeetingTimeAndLocations) {
		this.daysToMeetingTimeAndLocations = daysToMeetingTimeAndLocations;
	}
	public String getSectionNum() {
		return sectionNum;
	}
	public void setSectionNum(String sectionNum) {
		this.sectionNum = sectionNum;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setCourseNum(String coursenum) {
		this.courseNum = coursenum;
	}
	public String getCourseNum() {
		return courseNum;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	
}
