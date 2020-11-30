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
    	if(actionUrl.equals("/login.action")){ //获取参数 
    		String username=request.getParameter("username"); 
    		String password=request.getParameter("password");
    		String nickname=request.getParameter("nickname"); 
    		String info="";
    		System.out.println(username); //设置 JavaBean 属性
    		UserInfo ui=new UserInfo();
    		ui.setPassword(password);
    		ui.setUsername(username); //调用相应业务方法，根据返回值选择合适的视图层响应用户 
    		if(ui.checkName()){ 
    			if(ui.checkPassword()){
    			info="欢迎你"+username+"！";
    			request.setAttribute("outputMessage", info);
    		    request.getRequestDispatcher("success.jsp").forward(request,response);
    			}
    			else{ 
    				info="用户名或密码不正确！";
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
    		else if(actionUrl.equals("/register.action")){ //获取参数 
    			String username=request.getParameter("username"); 
    			String password=request.getParameter("password"); 
    			String nickname=request.getParameter("nickname"); 
    			System.out.println(username); //设置 JavaBean 属性
    			UserInfo ui=new UserInfo(); 
    			ui.setUsername(username); //调用相应业务方法，根据返回值选择合适的视图层响应用户 
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

