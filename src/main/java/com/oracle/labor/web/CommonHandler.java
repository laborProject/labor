package com.oracle.labor.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.labor.common.codetable.EducationallevelOperation;
import com.oracle.labor.common.codetable.IndustryOperation;
import com.oracle.labor.common.codetable.LanguageOperation;
import com.oracle.labor.common.codetable.OrgtypeOperation;
import com.oracle.labor.common.codetable.RegtypeOperation;
import com.oracle.labor.common.codetable.SexOperation;
import com.oracle.labor.common.codetable.SpecialtyOperation;
/**
 * ͨ��Handler
 * @author Marey
 *
 */
@Controller
public class CommonHandler {

	@ResponseBody
	@RequestMapping(value="/service/language",produces="text/html;charset=UTF-8")
	public String getLanguage(String val) {
		String result=LanguageOperation.getOption(val);
		System.out.println(result);
		return result;
	}
	/**
	 * ��õ�λ���������б�
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/orgtype",produces="text/html;charset=UTF-8")
	public String getOrg() {
		return OrgtypeOperation.getOption();
	}
	/**
	 * ��õ�λ��ҵ�����б�
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/industry",produces="text/html;charset=UTF-8")
	public String getIndustry() {
		return IndustryOperation.getOption();
	}
	/**
	 * ��þ������������б�
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/regtype",produces="text/html;charset=UTF-8")
	public String getReg() {
		return RegtypeOperation.getOption();
	}
	/**
	 * ����Ա������б�
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/sex",produces="text/html;charset=UTF-8")
	public String getSex() {
		return SexOperation.getOption();
	}
	/**
	 * ����Ļ��̶������б�
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/educationallevel",produces="text/html;charset=UTF-8")
	public String getEducation() {
		return EducationallevelOperation.getOption();
	}
	/**
	 * ��ù���ƥ�䷶Χ����ҵ�������б�
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/specialty",produces="text/html;charset=UTF-8")
	public String getSpecialty() {
		return SpecialtyOperation.getHy();
	}
}
