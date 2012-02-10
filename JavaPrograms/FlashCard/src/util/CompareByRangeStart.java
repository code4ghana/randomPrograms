package util;
import java.util.Comparator;

import models.ISpreadAble;



public class CompareByRangeStart implements Comparator<ISpreadAble>{

	
	@Override
	public int compare(ISpreadAble s1, ISpreadAble s2) {
		int retval=0;
		retval= (s1.getRange().getStart()<s2.getRange().getStart())? -1 :1;
		if(s1.getRange().getStart()==s2.getRange().getStart())
			retval=0;
		return retval;
		// TODO Auto-generated method stub
		
	}
	

}
