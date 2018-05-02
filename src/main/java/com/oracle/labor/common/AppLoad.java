package com.oracle.labor.common;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.oracle.labor.common.config.IAppConfig;
import com.oracle.labor.common.config.SystemConfig;


public class AppLoad extends HttpServlet{
	
	
	@Override
	public void init() throws ServletException {
		String loadPath  = "";
		try {
			String appPath = getServletContext().getRealPath("/")+"WEB-INF"+File.separator+"/app-config.xml";
			SystemConfig.setROOT_PATH(appPath);
			SAXBuilder sax = new SAXBuilder();
			System.out.println("==========================寮�濮嬪姞杞界郴缁熼厤缃枃浠�==========================");
			System.out.println("==========================閰嶇疆鏂囦欢璺緞"+appPath+"==========================");
			Document doc=null;
			try {
				doc = sax.build(appPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Element ele_root = doc.getRootElement();
			
			List<Element> list = ele_root.getChildren();
			
			for(Element ele_child:list){
				loadPath= ele_child.getAttributeValue("type");
				System.out.println("==========================寮�濮嬪姞杞�"+loadPath+"==========================");
				IAppConfig config = (IAppConfig)(Class.forName(loadPath).newInstance());
				boolean flag = config.init();
				if(flag){
					System.out.println("==========================鍔犺浇"+loadPath+"鎴愬姛==========================");
				}else{
					System.out.println("==========================鍔犺浇"+loadPath+"澶辫触==========================");
					System.out.println("==========================1.璇锋鏌pp-config.xml at "+loadPath+"==========================");
				}
			}
			System.out.println("==========================鍔犺浇绯荤粺閰嶇疆鏂囦欢鎴愬姛锛�==========================");
		} catch (JDOMException e) {

			System.out.println("==========================2.璇锋鏌pp-config.xml at "+loadPath+"==========================");
		} catch (InstantiationException e) {

			System.out.println("==========================3.璇锋鏌pp-config.xml at "+loadPath+"==========================");
		} catch (IllegalAccessException e) {

			System.out.println("==========================4.璇锋鏌pp-config.xml at "+loadPath+"==========================");
		} catch (ClassNotFoundException e) {

			System.out.println("==========================5.璇锋鏌pp-config.xml at "+loadPath+"==========================");
		};
	}
}
