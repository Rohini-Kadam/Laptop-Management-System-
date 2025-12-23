package com.repositary;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.Laptop;

public class LaptopRepositaryImpl implements LaptopRepositaryI {

@Override
public void addLaptop(Laptop l) {
try {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","root");
String query = "insert into laptop values(?,?,?,?)";
PreparedStatement ps = con.prepareStatement(query);
ps.setInt(1, l.getLaptopId());
ps.setString(2, l.getLaptopName());
ps.setString(3, l.getLaptopModel());
ps.setDouble(4, l.getLatopPrice());

ps.execute();
System.out.println("Data added successfully.");
con.close();

} catch (ClassNotFoundException | SQLException e) {
	e.printStackTrace();
	}
}

@Override
public void viewLaptop() {
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","root");
String query = "select * from laptop";
Statement s = con.createStatement();
ResultSet res = s.executeQuery(query);
while(res.next())
{
	int laptopId = res.getInt(1);
	String laptopName = res.getString(2);
	String laptopModel = res.getString(3);
	double laptopPrice = res.getDouble(4);
	System.out.println("The laptop ID: " +laptopId);
	System.out.println("The laptop name: " +laptopName);
	System.out.println("The laptop model: " +laptopModel);
	System.out.println("The laptop price: " +laptopPrice);
}
con.close();
} catch (ClassNotFoundException | SQLException e) 
	{
       e.printStackTrace();
    }		
}

@Override
public void updateLaptop(Laptop l) {
	try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","root");					

CallableStatement cs = con.prepareCall("{call updateLaptop(?,?)}");
cs.setString(1,l.getLaptopName());
cs.setInt(2, l.getLaptopId());
		
cs.execute();			
		
System.out.println("Data updated successfully");
con.close();		
} catch (ClassNotFoundException | SQLException e) 
	{
	e.printStackTrace();	
    }
}

@Override
public void removeLaptop(Laptop l) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");	
	//String query = "delete from laptop where laptopId = ?";					

	//PreparedStatement ps = con.prepareStatement(query);
	//ps.setInt(1, l.getLaptopId());
	//ps.execute();	
	CallableStatement cs = con.prepareCall("{call removeLaptop(?)}");
	
	cs.setInt(1, l.getLaptopId());
	System.out.println("Data deleted successfully");
	con.close();	
} catch (ClassNotFoundException | SQLException e) 
	{
	e.printStackTrace();	
    }	
		
}

}
