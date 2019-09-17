package com.test.basic;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Annotaitions {
	@Parameters({"browser","url"})
	@BeforeMethod(alwaysRun=true)
	public static void setUp(String browser,String url) {
		
		System.out.println("Setup "+browser+" , launching "+ url);
				
	}
	
	
	@Test(groups="smoke",priority=1)
	public static void run1() {
		String url="";
		String userName="";
		String password="";
		String sql="";
		
		try {
			
			
			
			
			ResultSet res=DriverManager.getConnection(url, userName, password).createStatement().executeQuery(sql);
			
			ResultSetMetaData resultData=res.getMetaData();
			
			int column=resultData.getColumnCount();
		
			
			List<Map<String,String>>list=new ArrayList<Map<String,String>>();
			
			while(res.next()) {
				Map<String,String>map=new HashMap<String,String>();
				for(int i=0;i<column;i++) {
					map.put(resultData.getColumnName(i), res.getObject(i).toString());
					
					
				}
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@Test(groups="smoke",priority=2)
	public static void run2() {
		System.out.println("Test run2");
	}
	
	
	@Test(dataProvider="dataProvider")
	public static void runData(String name,String lastName,String password) {
		
		System.out.println(name+" "+lastName+" "+password);
		
	}
	@DataProvider(name="dataProvider")
	public  Object[][] data(){
		
		Object[][]data=new Object[2][3];
		
		data[0][0]="Hello";
		data[0][1]="Hello1";
		data[0][2]="helo2";
		
		data[1][0]="Hello2";
		data[1][1]="Hello3";
		data[1][2]="helo4";
		
		
		return data;
	}
	
	
	
	
	@AfterMethod(alwaysRun=true)
	public static void tearDown() {
		System.out.println("Closing browser");
	}

}
