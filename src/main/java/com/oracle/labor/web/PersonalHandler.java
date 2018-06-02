package com.oracle.labor.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.labor.po.Bio;
import com.oracle.labor.po.Bip;
import com.oracle.labor.po.BipForeignlanguage;
import com.oracle.labor.po.BipSkill;
import com.oracle.labor.po.CompanyInfo;
import com.oracle.labor.po.PersonalInfo;
import com.oracle.labor.po.ZjDwzpdjb;
import com.oracle.labor.po.ZjDwzpgzb;
import com.oracle.labor.po.ZjGrqzdjb;
import com.oracle.labor.po.ZjGrqzgzb;
import com.oracle.labor.service.CommonService;
import com.oracle.labor.service.PersonalService;

/**
 * 个人推荐
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
	
	/**
	 * 个人推荐页
	 * 根据身份证号回显姓名
	 * @param bip_citizenid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getName",produces="text/html;charset=UTF-8")
	public String getNameById(String bip_citizenid) {

		return ps.getNameById(bip_citizenid);
	}
	/**
	 * 个人推荐页
	 * 根据单位法人码回显单位名称
	 * @param bio_no
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getCompnayName",produces="text/html;charset=UTF-8")
	public String getCompanyName(String bio_no) {
		return ps.getCompanyNameByNo(bio_no);
	}
	/**
	 * 根据身份证号或者姓名获得简单个人信息
	 * 在条件推荐第一页显示
	 * @param bip_citizenid
	 * @param bip_name
	 * @param map
	 * @return
	 */
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
	/**
	 * 条件推荐第二页的个人基础信息
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("/tj/tj")
	public String getInfo(HttpServletRequest request,Map<String,Object> map) {
		
		PersonalInfo pi=new PersonalInfo();
		pi.setBipId(request.getParameter("bipId"));
		pi.setBipName(request.getParameter("bipName"));
		pi.setBipSex(request.getParameter("bipSex"));
		pi.setBipResAddress(request.getParameter("address"));
		map.put("personalInfo", pi);

		return "service/zj/tjhz/grtj_tjpp_2";
	}
	/**
	 * 条件推荐第二页点击姓名查看个人详细信息
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("/tj/xxxx")
	public String getDetail(HttpServletRequest request,Map<String,Object> map) {
		
		//身份证号
		String bipId=request.getParameter("bipId");
		Bip bip=new Bip();
		bip=cs.getBip(cs.qureyBipById(bipId));
		//个人编号
		List<String> id=new ArrayList<String>();
		id.add(bip.getBipId());
		
		List<BipForeignlanguage> lf=new ArrayList<BipForeignlanguage>();
		lf=cs.getForeingn(cs.qureyForeingnById(id.get(0)));
		List<BipSkill> ls=new ArrayList<BipSkill>();
		ls=cs.getSkill(cs.qureySkillById(id.get(0)));
		
		ZjGrqzdjb djb=new ZjGrqzdjb();
		djb=cs.getQzdj(cs.qureyGrqzdj(id).get(0));
		List<ZjGrqzgzb> gzb=new ArrayList<ZjGrqzgzb>();
		gzb=cs.getGz(cs.queryGrgz(djb.getQzbh()));
	
		map.put("bip", bip);
		map.put("foreign", lf);
		map.put("skill", ls);
		map.put("djb", djb);
		map.put("gzb", gzb);
		
		return "service/zj/tjhz/grjbxx";
	}
	
	@RequestMapping("/tj/getCompnay")
	public String getCompany(String dwxz,String dwhy,String dwjjlx,String xb,String yjbys,String whcd,String gzppfw,Map<String,Object> map) {
		
		List<CompanyInfo> lc=new ArrayList<CompanyInfo>();
		
		List<Bio> bio=ps.qureyBio(dwxz, dwhy, dwjjlx);
		if(bio != null) {
			List<String> id=new ArrayList<String>();
			for(Bio b:bio) {
				id.add(b.getBioId());
			}
			List<ZjDwzpdjb> djb=cs.qureyDwdjbById(id);
			System.out.println(djb.size());
			if(djb != null) {
				for(ZjDwzpdjb z:djb) {
					List<ZjDwzpgzb> gzb=cs.qureyDwgz(z.getZpbh());
					if(gzb != null) {
						System.out.println(gzb);
						String[] zpbh=ps.select(gzb, xb, whcd, yjbys, gzppfw);
						System.out.println(zpbh.length);
						if(zpbh != null) {
							lc=ps.qureyDwxx(bio, djb, zpbh);
						}
					}
				}
			}
		}
		map.put("companyInfo", lc);
		System.out.println(bio.size());
		System.out.println(lc.size());
		
		return "service/zj/tjhz/grtj_tjpp_3";
	}
}
