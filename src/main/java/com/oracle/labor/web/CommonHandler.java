package com.oracle.labor.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.labor.common.codetable.LanguageOperation;
import com.oracle.labor.common.codetable.RegioncodeOperation;

@Controller
public class CommonHandler {

	@ResponseBody
	@RequestMapping(value="/service/language",produces="text/html;charset=UTF-8")
	public String getLanguage(String val) {
		String result=LanguageOperation.getOption(val);
		System.out.println(result);
		return result;
	}
	
//	@ResponseBody
//	@RequestMapping(value="/service/regions",produces="text/html;charset=UTF-8")
//	public String getRegions(String region,String code) {
//		if (code==null||"".equals(code)) {
//			System.out.println(RegioncodeOperation.getProvince());
//			return RegioncodeOperation.getProvince();
//		} else {
//			return RegioncodeOperation.getSelectedRegion(code, region);
//		}
//		
//		
//	}

}
