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
 * �����Ƽ�
 * @author Marey
 *
 */
@Service
public class PersonalService {
	
	@Autowired
	CommonService service;
	
	/**
	 * �������֤�Ų�ѯ����
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
	 * ���ݵ�λ���˺Ų�ѯ��λ����
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
	 * �������֤�Ų�ѯ������Ϣ���������ڡ��������δ��ִ���Ƽ��ŷ���null
	 * @param id
	 * @return
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
		//�ڸ�����ְ�ǼǱ��в�ѯ�Ƿ񶳽ἰ��ְ���
		List<ZjGrqzdjb> grdj=service.qureyGrqzdj(bipId);
		if(grdj == null || grdj.get(0).getSfdj() == "1") {
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
		pi.setBipName(bip.getBipName());
		pi.setBipSex(bip.getBipSex());
		pi.setBipAge(bip.getBipAge());
		pi.setBipResAddress(bip.getBipResAddress());
		pi.setBipConMobile(bip.getBipConMobile());
		pi.setDjsj(grdj.get(0).getDjsj());
		return pi;
	}
	/**
	 * ����������ѯ������Ϣ���������ڡ��������δ��ִ���Ƽ��ŷ���null
	 * @param name
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<PersonalInfo> queryGrxxByName(String name) {
		
		//�ڸ��˻�����Ϣ���в�ѯ���˱��
		List<Bip> bip=service.queryBipByName(name);
		if(bip == null) {
			return null;
		}
		List<String> bipId=new ArrayList<String>();
		for(Bip b:bip) {
			bipId.add(b.getBipId());
		}
		//�ڸ�����ְ�ǼǱ��в�ѯ�Ƿ񶳽ἰ��ְ���
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
		//�ж��Ƿ����δ��ִ���Ƽ���
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
		//��װ������Ϣ
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
