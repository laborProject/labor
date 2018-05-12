package com.oracle.labor.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.labor.po.PersonalInfo;
import com.oracle.labor.service.PersonalService;

/**
 * ¸öÈËÍÆ¼ö
 * @author Marey
 *
 */
@Controller
@RequestMapping("/grtj")
public class PersonalHandler {
	
	@Autowired
	PersonalService ps;
	
	@ResponseBody
	@RequestMapping("/getName")
	public String getNameById(String bip_citizenid) {

		return ps.getNameById(bip_citizenid);
	}
	
	@ResponseBody
	@RequestMapping("/getCompnayName")
	public String getCompanyName(String bio_no) {
		return ps.getCompanyNameByNo(bio_no);
	}
	
	@RequestMapping("/tj/getInfo")
	public String getInfo(String bip_citizenid,String bip_name,Map<String,Object> map) {
		
		List<PersonalInfo> pl=new ArrayList<PersonalInfo>();
		if(bip_citizenid!="") {
			pl.add(ps.queryGrxxById(bip_citizenid));
		}else {
			pl=ps.queryGrxxByName(bip_name);
		}
		map.put("list", pl);
		return "service/zj/tjhz/grtj_tjpp_1";
	}
}
