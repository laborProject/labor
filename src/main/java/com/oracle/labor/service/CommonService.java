package com.oracle.labor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.labor.dao.BipMapper;
import com.oracle.labor.dao.ZjGrqzdjbMapper;
import com.oracle.labor.dao.ZjGrqzdjjdbMapper;
import com.oracle.labor.dao.ZjGrqzgzbMapper;
import com.oracle.labor.dao.ZjTjxxhzbMapper;
import com.oracle.labor.po.Bip;
import com.oracle.labor.po.BipExample;
import com.oracle.labor.po.ZjGrqzdjb;
import com.oracle.labor.po.ZjGrqzdjbExample;
//import com.oracle.labor.po.ZjGrqzdjjdb;
//import com.oracle.labor.po.ZjGrqzdjjdbExample;
import com.oracle.labor.po.ZjGrqzgzb;
import com.oracle.labor.po.ZjGrqzgzbExample;
import com.oracle.labor.po.ZjTjxxhzb;
import com.oracle.labor.po.ZjTjxxhzbExample;

@Service
public class CommonService {

	@Autowired
	BipMapper bipDao;
	@Autowired
	ZjGrqzdjbMapper grdjDao;
	@Autowired
	ZjGrqzdjjdbMapper grdjjdDao;
	@Autowired
	ZjGrqzgzbMapper grgzDao;
	@Autowired
	ZjTjxxhzbMapper hzDao;
	
	/**
	 * �������֤�Ų�ѯ������Ϣ�����������򷵻�null
	 * @param id
	 * @return
	 */
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
	 * ����������ѯ������Ϣ�����������򷵻�null
	 * @param name
	 * @return
	 */
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
	 * ���ݸ��˱�Ų�ѯ������ְ�Ǽ���Ϣ���������ѹ鵵�ļ�¼�������������򷵻�null
	 * @param bipid
	 * @return
	 */
	public List<ZjGrqzdjb> qureyGrqzdj(List<String> bipid) {
		ZjGrqzdjbExample ze=new ZjGrqzdjbExample();
		ze.createCriteria().andBipIdIn(bipid).andGdsjIsNull();
		List<ZjGrqzdjb> grdj=new ArrayList<ZjGrqzdjb>();
		grdj=grdjDao.selectByExample(ze);
		if(grdj.isEmpty()) {
			return null;
		}
		return grdj;
	}
	/**
	 * ������ְ��Ų�ѯ������ְ���֣��������ѹ鵵�ļ�¼�������������򷵻�null
	 * @param qzbh
	 * @return
	 */
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
	 * ������ְ���ֱ�Ų�ѯ�Ƽ���Ϣ��ִ�����������򷵻�null
	 * @param gzbh
	 * @return
	 */
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
	 * �����Ƽ���Ϣ��ִ��¼�ж��Ƿ����δ��ִ�Ƽ��ţ�falseΪ������δ��ִ�Ƽ���
	 * @param hz
	 * @return
	 */
	public boolean isHz(List<ZjTjxxhzb> hz) {
		if(hz == null) {
			return false;
		}
		for(int i=0;i<hz.size();i++) {
			if(hz.get(i).getSfhz()=="0") {
				return true;
			}
		}
		return false;
	}
//	/**
//	 * ������ְ��Ų�ѯ���˶���ⶳ��¼���������ѹ鵵�ļ�¼�������������򷵻�null
//	 * @param qzbh
//	 * @return
//	 */
//	public List<ZjGrqzdjjdb> qureyGrqzdjjd(String qzbh){
//		ZjGrqzdjjdbExample ge=new ZjGrqzdjjdbExample();
//		ge.createCriteria().andQzbhEqualTo(qzbh).andGdsjIsNull();
//		List<ZjGrqzdjjdb> grdjjd=new ArrayList<ZjGrqzdjjdb>();
//		grdjjd=grdjjdDao.selectByExample(ge);
//		if(grdjjd.isEmpty()) {
//			return null;
//		}
//		return grdjjd;
//	}
	
}
