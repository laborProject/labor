package com.oracle.labor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.labor.common.codetable.SexOperation;
import com.oracle.labor.dao.BioMapper;
import com.oracle.labor.po.Bio;
import com.oracle.labor.po.BioExample;
import com.oracle.labor.po.Bip;
import com.oracle.labor.po.CompanyInfo;
import com.oracle.labor.po.PersonalInfo;
import com.oracle.labor.po.ZjDwzpdjb;
import com.oracle.labor.po.ZjDwzpgzb;
import com.oracle.labor.po.ZjGrqzdjb;
import com.oracle.labor.po.ZjGrqzgzb;
import com.oracle.labor.po.ZjTjxxhzb;

/**
 * 个人推荐
 * @author Marey
 *
 */
@Service
public class PersonalService {
	
	@Autowired
	CommonService service;
	@Autowired
	BioMapper bioDao;
	
	/**
	 * 根据身份证号查询姓名
	 * @param id
	 * @return 姓名
	 */
	@Transactional
	public String getNameById(String id) {
		if(service.qureyBipById(id) == null) {
			return null;
		}
		return service.qureyBipById(id).getBipName();
	}
	/**
	 * 根据单位法人号查询单位名称
	 * @param no
	 * @return 单位名称
	 */
	@Transactional
	public String getCompanyNameByNo(String no) {
		if(service.qureyBioByNo(no) == null) {
			return null;
		}
		return service.qureyBioByNo(no).getBioName();
	}
	/**
	 * 根据身份证号查询个人信息，若不存在则返回null，不包含冻结或有未回执的推荐信记录
	 * @param id
	 * @return PersonalInfo
	 */
	@Transactional(readOnly=true)
	public PersonalInfo queryGrxxById(String id) {
		
		//在个人基本信息表中查询个人编号
		Bip bip=service.qureyBipById(id);
		if(bip == null) {
			return null;
		}
		List<String> bipId=new ArrayList<String>();
		bipId.add(bip.getBipId());
		//在个人求职登记表中查询求职编号
		List<ZjGrqzdjb> grdj=service.qureyGrqzdj(bipId);
		if(grdj == null) {
			return null;
		}
		String qzbh=grdj.get(0).getQzbh();
		//判断是否存在未回执的推荐信
		List<ZjGrqzgzb> grgz=service.queryGrgz(qzbh);
		if(grgz != null) {
			for(ZjGrqzgzb z:grgz) {
				List<ZjTjxxhzb> hz=service.qureyHz(z.getQzgzbh());
				if(service.isHz(hz)) {
					return null;
				}
			}
		}
		//封装个人信息
		PersonalInfo pi=new PersonalInfo();
		pi.setBipId(id);
		pi.setBipName(bip.getBipName());
		pi.setBipSex(SexOperation.getNameById(bip.getBipSex()));
		pi.setBipAge(bip.getBipAge());
		pi.setBipResAddress(bip.getBipResAddress());
		pi.setBipConMobile(bip.getBipConMobile());
		pi.setDjsj(grdj.get(0).getDjsj());
		return pi;
	}
	/**
	 * 根据姓名查询个人信息，若不存在则返回null，不包含冻结或有未回执的推荐信记录
	 * @param name
	 * @return PersonalInfo List
	 */
	@Transactional(readOnly=true)
	public List<PersonalInfo> queryGrxxByName(String name) {
		
		//在个人基本信息表中查询个人编号
		List<Bip> lb=service.queryBipByName(name);
		if(lb == null) {
			return null;
		}
		List<String> bipId=new ArrayList<String>();
		for(Bip b:lb) {
			bipId.add(b.getBipId());
		}
		//在个人求职登记表中查询求职编号
		List<ZjGrqzdjb> grdj=service.qureyGrqzdj(bipId);
		if(grdj == null) {
			return null;
		}
		String[] qzbh=new String[grdj.size()];
		int j=0;
		for(int i=0;i<grdj.size();i++) {
			qzbh[j]=grdj.get(i).getQzbh();
			j++;
		}
		//移除被冻结的个人信息
		List<Bip> bip=new ArrayList<Bip>();
		for(int i=0;i<grdj.size();i++) {
			bip.add(service.qureyBipByBipId(grdj.get(i).getBipId()));
		}
		//判断是否存在未回执的推荐信
		for(int i=0;i<qzbh.length;i++) {
			//求职工种List
			List<ZjGrqzgzb> grgz=service.queryGrgz(qzbh[i]);
			if(grgz != null) {
				for(ZjGrqzgzb z:grgz) {
					//推荐信息回执List
					List<ZjTjxxhzb> hz=service.qureyHz(z.getQzgzbh());
					if(service.isHz(hz)) {
						grdj.remove(i);
						bip.remove(i);
						break;
					}
				}
			}
		}
		//封装个人信息
		List<PersonalInfo> lp=new ArrayList<PersonalInfo>();
		for(int i=0;i<bip.size();i++) {
			PersonalInfo pi=new PersonalInfo();
			pi.setBipId(bip.get(i).getBipCitizenid());
			pi.setBipName(bip.get(i).getBipName());
			pi.setBipSex(SexOperation.getNameById(bip.get(i).getBipSex()));
			pi.setBipAge(bip.get(i).getBipAge());
			pi.setBipResAddress(bip.get(i).getBipResAddress());
			pi.setBipConMobile(bip.get(i).getBipConMobile());
			pi.setDjsj(grdj.get(i).getDjsj());
			lp.add(pi);
		}

		return lp;
	}
	/**
	 * 根据单位性质，单位行业，经济类型查询单位基本信息
	 * @param dwxz
	 * @param dwhy
	 * @param jjlx
	 * @return 单位基本信息List
	 */
	@Transactional(readOnly=true)
	public List<Bio> qureyBio(String dwxz,String dwhy,String jjlx){
		BioExample be=new BioExample();
		if(dwxz.equals("") && jjlx.equals("") ) {
			be.createCriteria().andBioIndustryEqualTo(dwhy);
		}else if(jjlx.equals("")) {
			be.createCriteria().andBioOrgtypeEqualTo(dwxz).andBioIndustryEqualTo(dwhy);
		}else if(dwxz.equals("")) {
			be.createCriteria().andCdgRegtypeEqualTo(jjlx).andBioIndustryEqualTo(dwhy);
		}else {
			be.createCriteria().andBioOrgtypeEqualTo(dwxz).andCdgRegtypeEqualTo(jjlx).andBioIndustryEqualTo(dwhy);
		}
		List<Bio> bio=new ArrayList<Bio>();
		bio=bioDao.selectByExample(be);
		if(bio.isEmpty()) {
			return null;
		}
		return bio;
	}
	/**
	 * 根据性别，是否应届毕业生，文化程度，工种范围筛选
	 * @param xb
	 * @param whcd
	 * @param yjbys
	 * @param gzppfw
	 * @return 招聘编号
	 */
	public String[] select(List<ZjDwzpgzb> dwgz,String xb,String whcd,String yjbys,String gzppfw){
	
		String[] zpbh=new String[dwgz.size()];
		
		for(int i=0;i<dwgz.size();i++) {
			if(xb != "") {
				String sex=SexOperation.getNameById(xb);
				if(sex.equals("男")) {
					if(dwgz.get(i).getZprsn().equals("0") && dwgz.get(i).getXbbx().equals("0")) {
						continue;
					}
				}
				if(sex.equals("女")) {
					if(dwgz.get(i).getZprsnv().equals("0") && dwgz.get(i).getXbbx().equals("0")) {
						continue;
					}
				}	
			}
			if(whcd != "") {
				
			}
		}
		
		return zpbh;
	}
}
