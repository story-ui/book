package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.UserInfo;
public class LoginCheckServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	System.out.println(request.getServletPath()); 
    	request.setCharacterEncoding("GBK"); 
    	String actionUrl=request.getServletPath(); 
    	if(actionUrl.equals("/login.action")){ //��ȡ���� 
    		String username=request.getParameter("username"); 
    		String password=request.getParameter("password");
    		String nickname=request.getParameter("nickname"); 
    		String info="";
    		System.out.println(username); //���� JavaBean ����
    		UserInfo ui=new UserInfo();
    		ui.setPassword(password);
    		ui.setUsername(username); //������Ӧҵ�񷽷������ݷ���ֵѡ����ʵ���ͼ����Ӧ�û� 
    		if(ui.checkName()){ 
    			if(ui.checkPassword()){
    			info="��ӭ��"+username+"��";
    			request.setAttribute("outputMessage", info);
    		    request.getRequestDispatcher("success.jsp").forward(request,response);
    			}
    			else{ 
    				info="�û��������벻��ȷ��";
    				request.setAttribute("outputMessage", info);
    			    request.getRequestDispatcher("Info.jsp").forward(request,response);
    				/*ui.setPassword(password); 
    				int result=ui.registerUser(); 
    				if(result==1) request.getRequestDispatcher("/book/view/regSuccess.html").forward(request, response); 
    				else
    				request.getRequestDispatcher("/book/view/regFailure.html").forward(request, response); 
    				} 
    				*/
    		}
    			
    		}else{
    			ui.setPassword(password); 
				ui.setNickname(nickname); 
    			request.getRequestDispatcher("register_mvc.html").forward(request,response);   			
    		}
    	}
    		else if(actionUrl.equals("/register.action")){ //��ȡ���� 
    			String username=request.getParameter("username"); 
    			String password=request.getParameter("password"); 
    			String nickname=request.getParameter("nickname"); 
    			System.out.println(username); //���� JavaBean ����
    			UserInfo ui=new UserInfo(); 
    			ui.setUsername(username); //������Ӧҵ�񷽷������ݷ���ֵѡ����ʵ���ͼ����Ӧ�û� 
    			if(ui.checkName()){ 
    				request.getRequestDispatcher("/book/view/userExist.html").forward(request, response); 
    				}else{ 
    					ui.setPassword(password); 
    					ui.setNickname(nickname); 
    					int result=ui.registerUser(); 
    					if(result==1) request.getRequestDispatcher("login.jsp").forward(request, response); 
    					else
    					request.getRequestDispatcher("/book/view/regFailure.html").forward(request, response); 
    					} 
    			}
   
    	}
    }

