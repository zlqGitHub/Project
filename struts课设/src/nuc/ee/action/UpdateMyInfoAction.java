package nuc.ee.action;

import com.opensymphony.xwork2.ActionContext;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.ee.dao.UserDao;
import nuc.ee.model.User;

//�޸��ҵĸ�����Ϣ  ����update
@SuppressWarnings("serial")
public class UpdateMyInfoAction extends ActionSupport implements ModelDriven<User> {

	User stu = new User();    //��װ�޸ĸ�����Ϣ���ֵ
	UserDao dao = new UserDao();
	
	public User getStu() {
		return stu;
	}

	public void setStu(User stu) {
		this.stu = stu;
	}

	public String UpdateMyInfoMethod() {
		int user = (int) ActionContext.getContext().getSession().get("userid");
		String pass = (String) ActionContext.getContext().getSession().get("pass");
		String tel = (String) ActionContext.getContext().getSession().get("tel");
		System.out.println("pp"+pass+" "+tel+" "+user);	  //session���е�ֵ
		System.out.println("aa"+stu.getPassword());
		System.out.println("bb"+stu.getTelphone());
		//���롢�绰δ�޸�
		if(stu.getPassword().equals(pass) && stu.getTelphone().equals(tel)) {  
			dao.updateMyInfo(user, pass, tel);
//			System.out.println(i);
		}
		//����δ�޸ģ��绰�޸�
		else if(stu.getPassword().equals(pass) && !stu.getTelphone().equals(tel)) {
			dao.updateMyInfo(user, pass, stu.getTelphone());
		}
		//�����޸ģ��绰δ�޸�
		else if(!stu.getPassword().equals(pass) && stu.getTelphone().equals(tel)) {
			dao.updateMyInfo(user, stu.getPassword(), tel);
		}
		//���޸�
		else {
			dao.updateMyInfo(user, stu.getPassword(), stu.getTelphone());
		}
		this.addFieldError("error", "�����µ�¼");
		return "updateMyInfoOK";
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return stu;
	}

}


