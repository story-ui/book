package model;

import java.sql.*; 
public class DBBean { 
	private String driverStr="com.mysql.jdbc.Driver"; 
	private String connStr; 
	private String dbusername="root"; 
	private String dbpassword="264028"; 
	private Connection conn=null; 
	private Statement stmt=null; 
	public DBBean(){ 
		connStr="jdbc:mysql://localhost:3306/test?characterEncoding=gb2312"; 
		try{ Class.forName(driverStr); 
		conn = DriverManager.getConnection(connStr,dbusername,dbpassword); 
		stmt = conn.createStatement(); 
		}catch(Exception ex)
		{
			System.out.println("�޷�ͬ���ݿ⽨�����ӣ�");
			} 
		}
	public int executeUpdate(String s){ 
		int result=0;
		try{ 
			result=stmt.executeUpdate(s); 
		}catch(Exception ex)
		{ 
			System.out.println("ִ�и��´���");
			}
		return result;
}
	public ResultSet executeQuery(String s){ 
	ResultSet rs=null; 
	try{rs=stmt.executeQuery(s);
	} catch(Exception ex)
	{
		System.out.println("ִ�в�ѯ����");
		} 
	return rs; 
	}
public void close(){ 
	try{stmt.close(); 
	conn.close(); 
	}catch(Exception e){}
	} 
}