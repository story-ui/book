package model;

import java.sql.*;
import java.util.ArrayList;
public class UserInfo { 
	private String username=""; 
	private String password=""; 
	private String nickname="";
public String getUsername() {
return username;
}
public void setUsername(String username) {
this.username = username;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
public String getNickname() {
return nickname;
}
public void setNickname(String nickname) {
this.nickname = nickname;
}
//����û����Ƿ���ڵķ���
public boolean checkName(){ 
	System.out.print(username); 
	boolean exist=false;
String sql="select * from user where username='"+username+"'"; DBBean jdbc=new DBBean();
ResultSet rs=jdbc.executeQuery(sql);
try {
if(rs!=null && rs.next()) exist=true;
} catch (SQLException e) { e.printStackTrace();
}
jdbc.close();

return exist;
}
public boolean checkPassword(){ 
	System.out.print(password); 
	boolean exist=false;
String sql="select * from user where password='"+password+"'"; 
DBBean jdbc=new DBBean();
ResultSet rs=jdbc.executeQuery(sql);
try {
if(rs!=null && rs.next()) 
	exist=true;
} catch (SQLException e) { 
	e.printStackTrace();
}
jdbc.close();

return exist;
}
//��ע���û���Ϣ��ӵ����ݿ�ķ���
public int registerUser(){
String sql="insert into user values(null,'"+username+"','"+password+"','"+nickname+"')";
DBBean jdbc=new DBBean();
int result=jdbc.executeUpdate(sql); jdbc.close();
return result;
}
//�������ݿ��������û���Ϣ�ķ���
public static ArrayList<UserInfo> getUserList(){ 
	ArrayList<UserInfo> list=new ArrayList<UserInfo>(); 
	String sql="select * from user";
DBBean jdbc=new DBBean();
ResultSet rs=jdbc.executeQuery(sql);
try {
while(rs.next()){
UserInfo ui=new UserInfo(); ui.setUsername(rs.getString("username")); ui.setPassword(rs.getString("password")); ui.setNickname(rs.getString("nickname")); list.add(ui);
}
} catch (SQLException e) { e.printStackTrace();
}
jdbc.close();
return list;
}
}
