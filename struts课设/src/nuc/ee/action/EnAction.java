package nuc.ee.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.catalina.deploy.InjectionTarget;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import nuc.ee.service.*;
import nuc.ee.model.*;
public class EnAction extends ActionSupport{
	private String en;
	private String td;
	private String state;
	private List<En> enList;
	private String introduce;	
	
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getEn() {
		return en;
	}
	public void setEn(String en) {
		this.en = en;
	}
	public String getTd() {
		return td;
	}
	public void setTd(String td) {
		this.td = td;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<En> getEnList() {
		return enList;
	}
	public void setEnList(List<En> enList) {
		this.enList = enList;
	}
	EnService service = new EnService();
	
	//��ѯ��������
	public String inItMethod() {			
		if(en != null&&!"".equals(en.trim())) {
			if("ena".equals(en)) {
				enList = service.inIt(en);
			}
			if("enb".equals(en)) {
				enList = service.inIt(en);
			}
			if("enc".equals(en)) {
				enList = service.inIt(en);
			}
			ActionContext.getContext().getSession().put("en", en);
		}else {
			en = (String)ActionContext.getContext().getSession().get("en");
			if("ena".equals(en)) {
				enList = service.inIt(en);
			}
			if("enb".equals(en)) {
				enList = service.inIt(en);
			}
			if("enc".equals(en)) {
				enList = service.inIt(en);
			}
		}
		return SUCCESS;
	}
	
	//ɾ����������
	public String deleteMethod() {			
		String en = (String)ActionContext.getContext().getSession().get("en");
		if("ena".equals(en)) {
			service.DeleteEn(en,td);
		}
		if("enb".equals(en)) {
			service.DeleteEn(en,td);
		}
		if("enc".equals(en)) {
			service.DeleteEn(en,td);
		}
		return SUCCESS;
	}
	
	//��Ӽ�������
	public String addMethod() {		
		String en = (String)ActionContext.getContext().getSession().get("en");
		if("ena".equals(en)) {
			service.addEn(en,td, state,introduce);
		}
		if("enb".equals(en)) {
			service.addEn(en,td, state,introduce);
		}
		if("enc".equals(en)) {
			service.addEn(en,td, state,introduce);
		}
		return SUCCESS;
	}
	
	//���ż�������
	public String update1Method() throws UnsupportedEncodingException {		
		String en = (String)ActionContext.getContext().getSession().get("en");
		td = new String(td.getBytes("iso-8859-1"),"utf-8");
		if("ena".equals(en)) {
			service.update(en,td, "�ѿ���");
		}
		if("enb".equals(en)) {
			service.update(en,td, "�ѿ���");
		}
		if("enc".equals(en)) {
			service.update(en,td, "�ѿ���");
		}
		return SUCCESS;
	}  
	
	//�رռ�������
	public String update2Method() throws UnsupportedEncodingException {		
		String en = (String)ActionContext.getContext().getSession().get("en");
		td = new String(td.getBytes("iso-8859-1"),"utf-8");
		if("ena".equals(en)) {
			service.update(en,td, "δ����");
		}
		if("enb".equals(en)) {
			service.update(en,td, "δ����");
		}
		if("enc".equals(en)) {
			service.update(en,td, "δ����");
		}
		return SUCCESS;
	} 
}
