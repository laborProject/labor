package labor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.oracle.labor.common.codetable.RegioncodeOperation;

public class PersonalTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws ParseException {
		String id="110101002000";
		String str=id.substring(0, 9);
//		System.out.println(str);
		if(id.startsWith("11"))a: {
			StringBuffer sb1=new StringBuffer("北京市");
			//区
			StringBuffer sb2=new StringBuffer(id.substring(0, 6));
			sb2.append("000000");
			System.out.println(sb2.toString());
			String str1=RegioncodeOperation.getNameById("110101000000");
			if(sb1.toString().equals(str1)) {
				break a;
			}
			sb1.append(str1);
			//街道
			sb2=new StringBuffer(id.substring(0, 9));
			sb2.append("000");
			
//			String str2=RegioncodeOperation.getNameById(sb2.toString());
//			if(str1.equals(str2)) {
//				break a;
//			}
//			sb1.append(str2);
//			str=sb1.toString();
			System.out.println(str1);
		}
		
		SimpleDateFormat sdf=new SimpleDateFormat("20180519");

		Calendar c=sdf.getCalendar();
		c.add(Calendar.DATE, 15);
		Date d=c.getTime();
		Date d1=new Date();
		System.out.println(d1);
		
		List<Integer> l=new ArrayList();
		l.add(1);
		l.add(0);
		l.add(2);
		l.add(3);
		l.add(0);
		
		for(int i=0;i<l.size();i++) {
			if(l.get(i)==0) {
				l.remove(i);
			}
		}
		
		for(int s:l) {
			System.out.println(s);
		}
		
		
		
	}

}
