package models;

import java.util.ArrayList;


public class Course {

private String courseName;
private String courseNum;
private ArrayList<Section> sections;
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public String getCourseNum() {
	return courseNum;
}
public void setCourseNum(String courseNum) {
	this.courseNum = courseNum;
}
public ArrayList<Section> getSections() {
	return sections;
}
public void setSections(ArrayList<Section> sections) {
	this.sections = sections;
}
}
