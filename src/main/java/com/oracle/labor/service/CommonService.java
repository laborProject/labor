package com.oracle.labor.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.labor.common.codetable.ComputergradeOperation;
import com.oracle.labor.common.codetable.Deformity;
import com.oracle.labor.common.codetable.EmploytypeOperation;
import com.oracle.labor.common.codetable.HealthstateOperation;
import com.oracle.labor.common.codetable.IndustryOperation;
import com.oracle.labor.common.codetable.LanguageOperation;
import com.oracle.labor.common.codetable.MarriageOperation;
import com.oracle.labor.common.codetable.NationOperation;
import com.oracle.labor.common.codetable.OrgtypeOperation;
import com.oracle.labor.common.codetable.PersonneltypeOperation;
import com.oracle.labor.common.codetable.PoliticsaspectOperation;
import com.oracle.labor.common.codetable.ProficiencyOperation;
import com.oracle.labor.common.codetable.QualificationOperation;
import com.oracle.labor.common.codetable.RegioncodeOperation;
import com.oracle.labor.common.codetable.RegtypeOperation;
import com.oracle.labor.common.codetable.RprtypeOperation;
import com.oracle.labor.common.codetable.SexOperation;
import com.oracle.labor.common.codetable.SpecialtyOperation;
import com.oracle.labor.dao.BioMapper;
import com.oracle.labor.dao.BipForeignlanguageMapper;
import com.oracle.labor.dao.BipMapper;
import com.oracle.labor.dao.BipSkillMapper;
import com.oracle.labor.dao.CdgEducationallevelMapper;
import com.oracle.labor.dao.ZjDwzpdjbMapper;
import com.oracle.labor.dao.ZjDwzpgzbMapper;
import com.oracle.labor.dao.ZjGrqzdjbMapper;
import com.oracle.labor.dao.ZjGrqzgzbMapper;
import com.oracle.labor.dao.ZjTjxxhzbMapper;
import com.oracle.labor.po.Bio;
import com.oracle.labor.po.BioExample;
import com.oracle.labor.po.Bip;
import com.oracle.labor.po.BipExample;
import com.oracle.labor.po.BipForeignlanguage;
import com.oracle.labor.po.BipForeignlanguageExample;
import com.oracle.labor.po.BipSkill;
import com.oracle.labor.po.BipSkillExample;
import com.oracle.labor.po.CdgEducationallevel;
import com.oracle.labor.po.CdgEducationallevelExample;
import com.oracle.labor.po.ZjDwzpdjb;
import com.oracle.labor.po.ZjDwzpdjbExample;
import com.oracle.labor.po.ZjDwzpgzb;
import com.oracle.labor.po.ZjDwzpgzbExample;
import com.oracle.labor.po.ZjGrqzdjb;
import com.oracle.labor.po.ZjGrqzdjbExample;
import com.oracle.labor.po.ZjGrqzgzb;
import com.oracle.labor.po.ZjGrqzgzbExample;
import com.oracle.labor.po.ZjTjxxhzb;
import com.oracle.labor.po.ZjTjxxhzbExample;
/**
 * 通用Service
 * @author Marey
 *
 */
@Service
public class CommonService {

	@Autowired
	BipMapper bipDao;
	@Autowired
	ZjGrqzdjbMapper grdjDao;
	@Autowired
	ZjGrqzgzbMapper grgzDao;
	@Autowired
	ZjTjxxhzbMapper hzDao;
	@Autowired
	BioMapper bioDao;
	@Autowired
	BipForeignlanguageMapper foreignDao;
	@Autowired
	BipSkillMapper skillDao;
	@Autowired
	CdgEducationallevelMapper educationDao;
	@Autowired
	ZjDwzpdjbMapper dwdjDao;
	@Autowired
	ZjDwzpgzbMapper dwgzDao;
	
	/**
	 * 根据身份证号查询个人信息，若不存在则返回null
	 * @param id
	 * @return 个人信息
	 */
	@Transactional(readOnly=true)
	public Bip qureyBipById(String id) {
		BipExample be=new BipExample();
		be.createCriteria().andBipCitizenidEqualTo(id);
		List<Bip> bip=new ArrayList<Bip>();
		bip=bipDao.selectByExample(be);
		if(bip.isEmpty()) {
			return null;
		}
		return bip.get(0);
	}
	/**
	 * 根据姓名查询个人信息，若不存在则返回null
	 * @param name
	 * @return 个人信息List
	 */
	@Transactional(readOnly=true)
	public List<Bip> queryBipByName(String name){
		BipExample be=new BipExample();
		be.createCriteria().andBipNameEqualTo(name);
		List<Bip> bip=new ArrayList<Bip>();
		bip=bipDao.selectByExample(be);
		if(bip.isEmpty()) {
			return null;
		}
		return bip;
	}
	/**
	 * 根据个人编号查询个人求职登记信息（不包括已归档或已冻结的记录），若不存在则返回null
	 * @param bipid
	 * @return 个人求职登记信息List
	 */
	@Transactional(readOnly=true)
	public List<ZjGrqzdjb> qureyGrqzdj(List<String> bipid) {
		ZjGrqzdjbExample ze=new ZjGrqzdjbExample();
		ze.createCriteria().andBipIdIn(bipid).andGdsjIsNull().andSfdjIsNull();
		List<ZjGrqzdjb> grdj=new ArrayList<ZjGrqzdjb>();
		grdj=grdjDao.selectByExample(ze);
		ze.clear();
		ze.createCriteria().andBipIdIn(bipid).andSfdjNotEqualTo("1").andGdsjIsNull();
		grdj.addAll(grdjDao.selectByExample(ze));
		if(grdj.isEmpty()) {
			return null;
		}
		return grdj;
	}
	/**
	 * 根据个人编号查询个人信息
	 * @param bipid
	 * @return 个人信息
	 */
	public Bip qureyBipByBipId(String bipid){
		BipExample be=new BipExample();
		be.createCriteria().andBipIdEqualTo(bipid);
		List<Bip> bip=new ArrayList<Bip>();
		bip=bipDao.selectByExample(be);
		if(bip.isEmpty()) {
			return null;
		}
		return bip.get(0);
	}
	/**
	 * 根据求职编号查询个人求职工种（不包括已归档的记录），若不存在则返回null
	 * @param qzbh
	 * @return 个人求职工种List
	 */
	@Transactional(readOnly=true)
	public List<ZjGrqzgzb> queryGrgz(String qzbh){
		ZjGrqzgzbExample ze=new ZjGrqzgzbExample();
		ze.createCriteria().andQzbhEqualTo(qzbh).andGdsjIsNull();
		List<ZjGrqzgzb> grgz=new ArrayList<ZjGrqzgzb>();
		grgz=grgzDao.selectByExample(ze);
		if(grgz.isEmpty()) {
			return null;
		}
		return grgz;
	}
	/**
	 * 根据求职工种编号查询推荐信息回执，若不存在则返回null
	 * @param gzbh
	 * @return 推荐信息回执List
	 */
	@Transactional(readOnly=true)
	public List<ZjTjxxhzb> qureyHz(String gzbh){
		ZjTjxxhzbExample ze=new ZjTjxxhzbExample();
		ze.createCriteria().andQzgzbhEqualTo(gzbh);
		List<ZjTjxxhzb> hz=new ArrayList<ZjTjxxhzb>();
		hz=hzDao.selectByExample(ze);
		if(hz.isEmpty()) {
			return null;
		}
		return hz;
	}
	/**
	 * 根据推荐信息回执记录判断是否存在未回执推荐信
	 * @param hz
	 * @return false：不存在未回执推荐信 true：存在
	 */
	@Transactional(readOnly=true)
	public boolean isHz(List<ZjTjxxhzb> hz) {
		if(hz == null) {
			return false;
		}
		for(int i=0;i<hz.size();i++) {
			if(hz.get(i).getSfhz().equals("0")) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 根据单位法人码查询单位信息，若不存在则返回null
	 * @param no
	 * @return 单位信息
	 */
	@Transactional(readOnly=true)
	public Bio qureyBioByNo(String no) {
		BioExample be=new BioExample();
		be.createCriteria().andBioNoEqualTo(no);
		List<Bio> lb=new ArrayList<Bio>();
		lb=bioDao.selectByExample(be);
		if(lb.isEmpty()) {
			return null;
		}
		return lb.get(0);
	}
	/**
	 * 根据个人编号查询个人外语，若不存在则返回null
	 * @param id
	 * @return 个人外语List
	 */
	@Transactional(readOnly=true)
	public List<BipForeignlanguage> qureyForeingnById(String id){
		BipForeignlanguageExample bfe=new BipForeignlanguageExample();
		bfe.createCriteria().andBipIdEqualTo(id);
		List<BipForeignlanguage> list=new ArrayList<BipForeignlanguage>();
		list=foreignDao.selectByExample(bfe);
		if(list.isEmpty()) {
			return null;
		}
		return list;
	}
	/**
	 * 根据个人编号查询个人技能，若不存在则返回null
	 * @param id
	 * @return 个人技能List
	 */
	@Transactional(readOnly=true)
	public List<BipSkill> qureySkillById(String id){
		BipSkillExample bse=new BipSkillExample();
		bse.createCriteria().andBipIdEqualTo(id);
		List<BipSkill> list=new ArrayList<BipSkill>();
		list=skillDao.selectByExample(bse);
		if(list.isEmpty()) {
			return null;
		}
		return list;
	}
	/**
	 * 将Bip中各项代码转换为名称
	 * @param bip
	 * @return 转换后的Bip
	 */
	public Bip getBip(Bip bip) {
		String id=bip.getBipSex();
		bip.setBipSex(SexOperation.getNameById(id));
		id=bip.getBipMinzu();
		bip.setBipMinzu(NationOperation.getNameById(id));
		id=bip.getBipZzmm();
		if(id!=null && id!="") {
			bip.setBipZzmm(PoliticsaspectOperation.getNameById(id));
		}
		id=bip.getBipHyzk();
		if(id!=null && id!="") {
			bip.setBipHyzk(MarriageOperation.getNameById(id));
		}
		id=bip.getBipHjxz();
		bip.setBipHjxz(RprtypeOperation.getNameById(id));
		id=bip.getBipRylb();
		bip.setBipRylb(PersonneltypeOperation.getNameById(id));
		id=bip.getBipJkzk();
		if(id!=null && id!="") {
			bip.setBipJkzk(HealthstateOperation.getNameById(id));
		}
		id=bip.getBipCjqk();
		if(id!=null && id!="") {
			bip.setBipCjqk(Deformity.getNameById(id));
		}
		
		id=bip.getBipHkszd();
		//对北京的特殊处理
		if(id.startsWith("11"))a: {
			StringBuffer sb1=new StringBuffer("北京市");
			//区
			StringBuffer sb2=new StringBuffer(id.substring(0, 6));
			sb2.append("000000");
			String str1=RegioncodeOperation.getNameById(sb2.toString());
			if(sb1.toString().equals(str1)) {
				break a;
			}
			sb1.append(str1);
			//街道
			sb2=new StringBuffer(id.substring(0, 9));
			sb2.append("000");
			String str2=RegioncodeOperation.getNameById(sb2.toString());
			if(str1.equals(str2)) {
				break a;
			}
			sb1.append(str2);
			bip.setBipHkszd(sb1.toString());
		}else {
			bip.setBipHkszd(RegioncodeOperation.getNameById(id));
		}
		
		id=bip.getBipWhcd();
		CdgEducationallevelExample ce=new CdgEducationallevelExample();
		ce.createCriteria().andCdIdEqualTo(id);
		List<CdgEducationallevel>le=educationDao.selectByExample(ce);
		bip.setBipWhcd(le.get(0).getCdName());
		
		id=bip.getBipPcDj();
		if(id!=null && id!="") {
			bip.setBipPcDj(ComputergradeOperation.getNameById(id));
		}
		id=bip.getBipPcSlcd();
		if(id!=null && id!="") {
			bip.setBipPcSlcd(ProficiencyOperation.getNameById(id));
		}
		
		return bip;
	}
	/**
	 * 将个人技能中代码转换为名称
	 * @param list
	 * @return 转换后的List
	 */
	public List<BipSkill> getSkill(List<BipSkill> list){
		for(BipSkill skill:list) {
			String skillName=SpecialtyOperation.getNameById(skill.getBipSZyjn());
			String skillLevel=QualificationOperation.getNameById(skill.getBipSJsdj());
			skill.setBipSZyjn(skillName);
			skill.setBipSJsdj(skillLevel);
		}
		return list;
	}
	/**
	 * 将个人外语中代码转换为名称
	 * @param list
	 * @return 转换后的List
	 */
	public List<BipForeignlanguage> getForeingn(List<BipForeignlanguage> list){
		for(BipForeignlanguage bf:list) {
			String language=LanguageOperation.getNameById(bf.getBipFlJywy());
			bf.setBipFlJywy(language);
		}
		return list;
	}
	/**
	 * 将个人求职登记表中的代码转换为名称
	 * @param djb
	 * @return 转换后的个人求职登记信息
	 */
	public ZjGrqzdjb getQzdj(ZjGrqzdjb djb) {
		String name=OrgtypeOperation.getNameById(djb.getDwxx());
		djb.setDwxx(name);
		name=IndustryOperation.getNameById(djb.getDwhy());
		djb.setDwhy(name);
		name=RegtypeOperation.getNameById(djb.getDwjjlx());
		djb.setDwjjlx(name);
		name=RegioncodeOperation.getNameById(djb.getGzdq());
		djb.setGzdq(name);
		
		return djb;
	}
	/**
	 * 将个人求职工种表中的代码转换为名称
	 * @param list
	 * @return 转换后的List
	 */
	public List<ZjGrqzgzb> getGz(List<ZjGrqzgzb> list){
		
		for(ZjGrqzgzb gz:list) {
			String name=SpecialtyOperation.getNameById(gz.getGz());
			gz.setGz(name);
			name=EmploytypeOperation.getNameById(gz.getYgxs());
			gz.setYgxs(name);
		}
		
		return list;
	}
	/**
	 * 根据单位编号查询单位招聘登记信息（不包括冻结和已归档记录），若不存在则返回null
	 * @param id
	 * @return 单位招聘登记List
	 */
	@Transactional(readOnly=true)
	public List<ZjDwzpdjb> qureyDwdjbById(List<String> id) {	
		ZjDwzpdjbExample ze=new ZjDwzpdjbExample();
		ze.createCriteria().andDwbhIn(id).andSfdjNotEqualTo("1").andGdsjIsNull();
		List<ZjDwzpdjb> dwdj=new ArrayList<ZjDwzpdjb>();
		dwdj=dwdjDao.selectByExample(ze);
		ze.clear();
		ze.createCriteria().andDwbhIn(id).andSfdjIsNull().andGdsjIsNull();
		dwdj.addAll(dwdjDao.selectByExample(ze));
		if(dwdj.isEmpty()) {
			return null;
		}
		return dwdj;
	}
	/**
	 * 根据招聘编号查询单位招聘工种信息（不包括已归档记录），若不存在则返回null
	 * @param zpbh
	 * @return 单位招聘工种List
	 */
	@Transactional(readOnly=true)
	public List<ZjDwzpgzb> qureyDwgz(String zpbh){
		ZjDwzpgzbExample ze=new ZjDwzpgzbExample();
		ze.createCriteria().andZpbhEqualTo(zpbh).andGdsjIsNull();
		List<ZjDwzpgzb> dwgz=new ArrayList<ZjDwzpgzb>();
		dwgz=dwgzDao.selectByExample(ze);
		if(dwgz.isEmpty()) {
			return null;
		}
		return dwgz;
	}
}
