package com.oracle.labor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.labor.po.Bip;
import com.oracle.labor.po.PersonalInfo;
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
	
	/**
	 * 根据身份证号查询姓名
	 * @param id
	 * @return
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
	 * @return
	 */
	@Transactional
	public String getCompanyNameByNo(String no) {
		if(service.qureyBioByNo(no) == null) {
			return null;
		}
		return service.qureyBioByNo(no).getBioName();
	}
	/**
	 * 根据身份证号查询个人信息，若不存在、冻结或有未回执的推荐信返回null
	 * @param id
	 * @return
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
		//在个人求职登记表中查询是否冻结及求职编号
		List<ZjGrqzdjb> grdj=service.qureyGrqzdj(bipId);
		if(grdj == null || grdj.get(0).getSfdj() == "1") {
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
		pi.setBipName(bip.getBipName());
		pi.setBipSex(bip.getBipSex());
		pi.setBipAge(bip.getBipAge());
		pi.setBipResAddress(bip.getBipResAddress());
		pi.setBipConMobile(bip.getBipConMobile());
		pi.setDjsj(grdj.get(0).getDjsj());
		return pi;
	}
	/**
	 * 根据姓名查询个人信息，若不存在、冻结或有未回执的推荐信返回null
	 * @param name
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<PersonalInfo> queryGrxxByName(String name) {
		
		//在个人基本信息表中查询个人编号
		List<Bip> bip=service.queryBipByName(name);
		if(bip == null) {
			return null;
		}
		List<String> bipId=new ArrayList<String>();
		for(Bip b:bip) {
			bipId.add(b.getBipId());
		}
		//在个人求职登记表中查询是否冻结及求职编号
		List<ZjGrqzdjb> grdj=service.qureyGrqzdj(bipId);
		if(grdj == null) {
			return null;
		}
		String[] qzbh=new String[grdj.size()];
		int j=0;
		for(int i=0;i<grdj.size();i++) {
			if(grdj.get(i).getSfdj() == "1") {
				grdj.remove(i);
				bip.remove(i);
			}else {
				qzbh[j]=grdj.get(i).getQzbh();
				j++;
			}
		}
		//判断是否存在未回执的推荐信
		for(int i=0;i<qzbh.length;i++) {
			List<ZjGrqzgzb> grgz=service.queryGrgz(qzbh[i]);
			if(grgz != null) {
				for(ZjGrqzgzb z:grgz) {
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
			pi.setBipName(bip.get(i).getBipName());
			pi.setBipSex(bip.get(i).getBipSex());
			pi.setBipAge(bip.get(i).getBipAge());
			pi.setBipResAddress(bip.get(i).getBipResAddress());
			pi.setBipConMobile(bip.get(i).getBipConMobile());
			pi.setDjsj(grdj.get(i).getDjsj());
			lp.add(pi);
		}
		return lp;
	}
	
	 
}
