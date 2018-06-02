package com.oracle.labor.service;

import java.util.ArrayList;
import java.util.List;

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
 * �����Ƽ�
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
	 * �������֤�Ų�ѯ����
	 * @param id
	 * @return ����
	 */
	@Transactional
	public String getNameById(String id) {
		if(service.qureyBipById(id) == null) {
			return null;
		}
		return service.qureyBipById(id).getBipName();
	}
	/**
	 * ���ݵ�λ���˺Ų�ѯ��λ����
	 * @param no
	 * @return ��λ����
	 */
	@Transactional
	public String getCompanyNameByNo(String no) {
		if(service.qureyBioByNo(no) == null) {
			return null;
		}
		return service.qureyBioByNo(no).getBioName();
	}
	/**
	 * �������֤�Ų�ѯ������Ϣ�����������򷵻�null���������������δ��ִ���Ƽ��ż�¼
	 * @param id
	 * @return PersonalInfo
	 */
	@Transactional(readOnly=true)
	public PersonalInfo queryGrxxById(String id) {
		
		//�ڸ��˻�����Ϣ���в�ѯ���˱��
		Bip bip=service.qureyBipById(id);
		if(bip == null) {
			return null;
		}
		List<String> bipId=new ArrayList<String>();
		bipId.add(bip.getBipId());
		//�ڸ�����ְ�ǼǱ��в�ѯ��ְ���
		List<ZjGrqzdjb> grdj=service.qureyGrqzdj(bipId);
		if(grdj == null) {
			return null;
		}
		String qzbh=grdj.get(0).getQzbh();
		//�ж��Ƿ����δ��ִ���Ƽ���
		List<ZjGrqzgzb> grgz=service.queryGrgz(qzbh);
		if(grgz != null) {
			for(ZjGrqzgzb z:grgz) {
				List<ZjTjxxhzb> hz=service.qureyHz(z.getQzgzbh());
				if(service.isHz(hz)) {
					return null;
				}
			}
		}
		//��װ������Ϣ
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
	 * ����������ѯ������Ϣ�����������򷵻�null���������������δ��ִ���Ƽ��ż�¼
	 * @param name
	 * @return PersonalInfo List
	 */
	@Transactional(readOnly=true)
	public List<PersonalInfo> queryGrxxByName(String name) {
		
		//�ڸ��˻�����Ϣ���в�ѯ���˱��
		List<Bip> lb=service.queryBipByName(name);
		if(lb == null) {
			return null;
		}
		List<String> bipId=new ArrayList<String>();
		for(Bip b:lb) {
			bipId.add(b.getBipId());
		}
		//�ڸ�����ְ�ǼǱ��в�ѯ��ְ���
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
		//�Ƴ�������ĸ�����Ϣ
		List<Bip> bip=new ArrayList<Bip>();
		for(int i=0;i<grdj.size();i++) {
			bip.add(service.qureyBipByBipId(grdj.get(i).getBipId()));
		}
		//�ж��Ƿ����δ��ִ���Ƽ���
		for(int i=0;i<qzbh.length;i++) {
			//��ְ����List
			List<ZjGrqzgzb> grgz=service.queryGrgz(qzbh[i]);
			if(grgz != null) {
				for(ZjGrqzgzb z:grgz) {
					//�Ƽ���Ϣ��ִList
					List<ZjTjxxhzb> hz=service.qureyHz(z.getQzgzbh());
					if(service.isHz(hz)) {
						grdj.remove(i);
						bip.remove(i);
						break;
					}
				}
			}
		}
		//��װ������Ϣ
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
	 * ���ݵ�λ���ʣ���λ��ҵ���������Ͳ�ѯ��λ������Ϣ
	 * @param dwxz
	 * @param dwhy
	 * @param jjlx
	 * @return ��λ������ϢList
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
	 * �����Ա��Ƿ�Ӧ���ҵ�����Ļ��̶ȣ����ַ�Χɸѡ
	 * @param xb
	 * @param whcd
	 * @param yjbys
	 * @param gzppfw
	 * @return ��Ƹ�������
	 */
	public String[] select(List<ZjDwzpgzb> dwgz,String xb,String whcd,String yjbys,String gzppfw){
	
		String[] zpbh=new String[dwgz.size()];
		int j=0;
		for(int i=0;i<dwgz.size();i++) {
			if(xb != "") {
				if(xb.equals("1")) {
					if(dwgz.get(i).getZprsn().equals("0") && dwgz.get(i).getXbbx().equals("0")) {
						continue;
					}
				}
				if(xb.equals("2")) {
					if(dwgz.get(i).getZprsnv().equals("0") && dwgz.get(i).getXbbx().equals("0")) {
						continue;
					}
				}	
			}
			if(whcd != "") {
				if(dwgz.get(i).getWhcd().equals(whcd)) {
					continue;
				}
			}
			if(yjbys != "") {
				if(dwgz.get(i).getSfbys() != yjbys) {
					continue;
				}
			}
			if(gzppfw !="") {
				if(dwgz.get(i).getZpgz().charAt(0) != gzppfw.charAt(0) || (dwgz.get(i).getZpgz().startsWith("6") && gzppfw.charAt(0) != 9)) {
					continue;
				}
			}
			zpbh[j]=dwgz.get(i).getZpbh();
			j++;
		}
		
		return zpbh;
	}
	/**
	 * ����ɸѡ���ֱ�ŷ�װ�򵥵�λ��Ϣ
	 * @param bio
	 * @param djb
	 * @param zpbh
	 * @return �򵥵�λ��ϢList
	 */
	public List<CompanyInfo> qureyDwxx(List<Bio> bio,List<ZjDwzpdjb> djb,String[] zpbh){
		
		List<CompanyInfo> list =new ArrayList<CompanyInfo>();
		for(int i=0;i<djb.size();i++) {
			for(int j=0;j<zpbh.length;j++) {
				if(djb.get(i).getZpbh().equals(zpbh[j])) {
					CompanyInfo ci=new CompanyInfo();
					ci.setZpbh(zpbh[j]);
					ci.setBioName(bio.get(i).getBioName());
					ci.setBioBuaAddress(bio.get(i).getBioBuaAddress());
					ci.setLxrsj(djb.get(i).getLxrsj());
					ci.setDjsj(djb.get(i).getDjsj());
				}
			}
		}
		return list;
	}
}

