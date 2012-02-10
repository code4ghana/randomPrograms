package parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class PageRetriever {
	String SEARCHURL = "http://rabi.phys.virginia.edu/mySIS/CS2/page.php?Semester=1112&Type=Search";
	public ArrayList<String> getCoursePages() {
		ArrayList<String> pages = new ArrayList<String>();
		String[] values = new String[10];
		values[0] = "cs";
		values[1] = "2150";
		pages.add(search(values));

		return pages;
	}

	public String search(String[] values) {
		String[] inputs = { "iMnemonic", "iNumber", "iInstructor", "iBuilding",
				"iRoom", "iDays", "iTime", "iTitle", "iTopic", "iDescription" };
		String page="";
		Map<String, String> data = new HashMap<String, String>();
		for (int i = 0; i < inputs.length; i++) {
			data.put(inputs[i], values[i] == null ? "" : values[i]);
		}
		try {
			URL siteUrl = new URL(SEARCHURL);
			HttpURLConnection conn = (HttpURLConnection) siteUrl
					.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);

			DataOutputStream out = new DataOutputStream(conn.getOutputStream());

			Set keys = data.keySet();
			Iterator keyIter = keys.iterator();
			String content = "";
			for (int i = 0; i<inputs.length; i++) {
				
				if (i != 0) {
					content += "&";
				}
				content += inputs[i]+ "="
						+ URLEncoder.encode(values[i]==null?"":values[i], "UTF-8");
			}
		
			out.writeBytes(content);
			out.flush();
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
//			String line="";

			File output = new File("out.html");
			if (output.isFile()) {
				output.delete();
				output.createNewFile();
			}
//			BufferedWriter bf = new BufferedWriter(new FileWriter(output));
			while (in.ready()) {
				page+=in.readLine()+"\n";
//				bf.write(line);
			}
			in.close();
//			bf.flush();
//			bf.close();

//			System.out.println(data);

		}

		catch (Exception e) {

		}

		return page;
	}
//
//	public String postFormOld(String[] values) {
//
//		final WebClient webClient = new WebClient();
//
//		// Get the first page
//		HtmlPage page1 = null;
//		try {
//			page1 = webClient.getPage(SEARCHURL);
//		} catch (FailingHttpStatusCodeException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (MalformedURLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		// Get the form that we are dealing with and within that form,
//		// find the submit button and the field that we want to change.
//		final HtmlForm form = page1.getFormByName("Search");
//
//		final HtmlSubmitInput button = form.getInputByName("Submit");
//		final HtmlTextInput f1 = form.getInputByName("iMnemonic");
//		final HtmlTextInput f2 = form.getInputByName("iNumber");
//		final HtmlTextInput f3 = form.getInputByName("iInstructor");
//		final HtmlTextInput f4 = form.getInputByName("iBuilding");
//		final HtmlTextInput f5 = form.getInputByName("iRoom");
//		final HtmlTextInput f6 = form.getInputByName("iDays");
//		final HtmlTextInput f7 = form.getInputByName("iTime");
//		final HtmlTextInput f8 = form.getInputByName("iTitle");
//		final HtmlTextInput f9 = form.getInputByName("iTopic");
//		final HtmlTextInput f10 = form.getInputByName("iDescription");
//
//		// fill out forms
//		f1.setValueAttribute(values[0]==null?"":values[0]);
//		f2.setValueAttribute(values[1]==null?"":values[1]);
//		f3.setValueAttribute(values[2]==null?"":values[2]);
//		f4.setValueAttribute(values[3]==null?"":values[3]);
//		f5.setValueAttribute(values[4]==null?"":values[4]);
//		f6.setValueAttribute(values[5]==null?"":values[5]);
//		f7.setValueAttribute(values[6]==null?"":values[6]);
//		f8.setValueAttribute(values[7]==null?"":values[7]);
//		f9.setValueAttribute(values[8]==null?"":values[8]);
//		f10.setValueAttribute(values[9]==null?"":values[9]);
//
//		// Now submit the form by clicking the button and get back the second
//		// page.
//		try {
//			final HtmlPage page2 = button.click();
//			page2.cleanUp();
//			System.out.println(page2.asXml());
//			return page2.asXml();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		webClient.closeAllWindows();
//
//		return null;
//	}
}
