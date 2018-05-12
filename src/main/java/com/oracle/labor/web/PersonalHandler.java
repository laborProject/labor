package com.oracle.labor.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.labor.common.codetable.EducationallevelOperation;
import com.oracle.labor.common.codetable.IndustryOperation;
import com.oracle.labor.common.codetable.OrgtypeOperation;
import com.oracle.labor.common.codetable.RegtypeOperation;
import com.oracle.labor.common.codetable.SexOperation;
import com.oracle.labor.common.codetable.SpecialtyOperation;
import com.oracle.labor.po.Bip;
import com.oracle.labor.po.BipForeignlanguage;
import com.oracle.labor.po.BipSkill;
import com.oracle.labor.po.PersonalInfo;
import com.oracle.labor.po.ZjGrqzdjb;
import com.oracle.labor.po.ZjGrqzgzb;
import com.oracle.labor.service.CommonService;
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
	@Autowired
	CommonService cs;
	
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
	public String getPersonalInfo(String bip_citizenid,String bip_name,Map<String,Object> map) {
		
		List<PersonalInfo> pl=new ArrayList<PersonalInfo>();
		if(bip_citizenid!="") {
			pl.add(ps.queryGrxxById(bip_citizenid));
		}else {
			pl=ps.queryGrxxByName(bip_name);
		}
		map.put("list", pl);
		return "service/zj/tjhz/grtj_tjpp_1";
	}
	
	@RequestMapping("/tj/tj")
	public String getInfo(HttpServletRequest request,Map<String,Object> map) {
		
		
		PersonalInfo pi=new PersonalInfo();
		pi.setBipId(request.getParameter("bipId"));
		pi.setBipName(request.getParameter("bipName"));
		pi.setBipSex(request.getParameter("bipSex"));
		pi.setBipResAddress(request.getParameter("address"));
		map.put("personalInfo", pi);
		map.put("orgtype", OrgtypeOperation.getOption());
		map.put("industry", IndustryOperation.getOption());
		map.put("regtype", RegtypeOperation.getOption());
		map.put("sex", SexOperation.getOption());
		map.put("educationallevel", EducationallevelOperation.getOption());
		map.put("specialty", SpecialtyOperation.getOption());
		
		return "service/zj/tjhz/grtj_tjpp_2";
	}
	
	@RequestMapping("/tj/xxxx")
	public String getDetail(HttpServletRequest request,Map<String,Object> map) {
		
		String bipId=request.getParameter("bipId");
		Bip bip=new Bip();
		bip=cs.qureyBipById(bipId);
		List<String> id=new ArrayList<String>();
		id.add(bip.getBipId());
		List<BipForeignlanguage> lf=new ArrayList<BipForeignlanguage>();
		lf=cs.qureyForeingnById(bipId);
		List<BipSkill> ls=new ArrayList<BipSkill>();
		ls=cs.qureySkillById(bipId);
		ZjGrqzdjb djb=new ZjGrqzdjb();
		djb=cs.qureyGrqzdj(id).get(0);
		List<ZjGrqzgzb> gzb=new ArrayList<ZjGrqzgzb>();
		gzb=cs.queryGrgz(djb.getQzbh());
	
		map.put("bip", bip);
		map.put("foreign", lf);
		map.put("skill", ls);
		map.put("djb", djb);
		map.put("gzb", gzb);
		
		return "service/zj/tjhz/grjbxx";
	}
}
