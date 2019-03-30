package nuc.ee.action;

import java.io.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.opensymphony.xwork2.ModelDriven;

import nuc.ee.model.User;
import nuc.ee.service.UserService;

//ע��Action
@SuppressWarnings("serial")
public class RegistAction extends ActionSupport implements ModelDriven<User>{
	
	UserService us = new UserService();
	private User u = new User();
	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String RegistMethod() throws IOException {
		
		int i = us.select_user(u);   //�ж��Ƿ���ע��
		if(i == 0) {   //i=0ʱ��ʾδע�����ע��
			us.insert_user(u);
//			System.out.println(stu.getIcon());
			ActionContext.getContext().getSession().put("success", "ע��ɹ�");
			return "registOK";
		}
		error = "��ѧ����ע�ᣡ";
		return "registRepeat";
		
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return u;
	}
	

}
