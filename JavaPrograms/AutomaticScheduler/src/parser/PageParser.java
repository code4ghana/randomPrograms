package parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.Course;
import models.Section;

public class PageParser {
	public PageParser() {
		// TODO Auto-generated constructor stub
	}

	public List<Course> getCourses() {
		ArrayList<String> coursesPages = new PageRetriever().getCoursePages();
		List<Course> courses = new ArrayList<Course>();
		for (Iterator<String> iterator = coursesPages.iterator(); iterator
				.hasNext();) {
			String coursePage = iterator.next();
			courses.addAll(getTable(coursePage));
		}
		return courses;
	}

	private List<Course> getTable(String coursePage) {
		List<Course> courses = new ArrayList<Course>();
		Course course = new Course();
		CharSequence inputStr = coursePage;
		String infoRegex = "&nbsp;</span>([\\w\\s\\d]+).+'>([\\w\\s\\d]+).+";
		//sectionMnemonic,sectionNum,type,credits,open/closed,status,teacher,schedule,location
	//	</td><td>Olsson Hall 120</td></tr>
		String sectionRegex = "='Section[^S].+'right'>([\\d]{5}).+'>([\\d]{3}).+strong>([\\w]+)<.+" +
				"\\((\\d).+>([OC][\\w]+)<.+>([\\d]+\\s/\\s[\\d]+).+" +
				"strong>([\\w\\s]+).+td>" +
				"([MTF]\\w\\s[\\d]{1,2}:[\\d]{1,2}[AMP]{1,2}\\s-\\s[\\d]{1,2}:[\\d]{1,2}[AMP]{1,2}).+" +
				"td>([\\w\\s\\d]{1,}).+";
		// Compile and use regular expression
		Pattern infoPattern = Pattern.compile(infoRegex);
		Pattern sectionPattern = Pattern.compile(sectionRegex);
		Matcher findInfo = infoPattern.matcher(inputStr);
		Matcher findSection = sectionPattern.matcher(inputStr);
		while (findInfo.find()) {
			String mnemonic = findInfo.group(1);
			String name = findInfo.group(2);
			Course c = new Course();
			c.setCourseName(name);
			c.setCourseNum(mnemonic);
			courses.add(c);
		}
		ArrayList<Section> sections=new ArrayList<Section>();
		while (findSection.find()) {
			//sectionMnemonic,sectionNum,type,credits,open/closed,status,teacher,schedule,location
			String secMnemo=findSection.group(1);
			String secNum=findSection.group(2);
			String type=findSection.group(3);
			String credits=findSection.group(4);
			String open=findSection.group(5);
			String status=findSection.group(6);
			String teacher=findSection.group(7);
			String schedule=findSection.group(8);
			String location=findSection.group(9);
			Section sec=new Section(secNum,teacher,location,secMnemo,status);
			sections.add(sec);
			
//			System.out.println(findSection.group(0));
		}
		course.setSections(sections);
		// TODO Auto-generated method stub
		return courses;
	}
}
