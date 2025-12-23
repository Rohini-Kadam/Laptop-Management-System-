package com.ui;

import java.util.Scanner;

import com.controller.LaptopController;
import com.model.Laptop;

public class TestUI {
public static void main(String[] args) {
	LaptopController c =new LaptopController();
	Laptop l = new Laptop();
	Scanner sc =new Scanner(System.in);
System.out.println("-------LMS-------");
System.out.println("Enter 1 to AddLaptop "
			+ "\n Enter 2 to ViewLaptop "
			+ "\n Enter 3 to UpdateLaptop "
			+"\n Enter 4 RemoveLaptop.");
int ch = sc.nextInt();
if(ch==1)
{
	System.out.println("Enter laptop ID: ");
	l.setLaptopId(sc.nextInt());
	System.out.println("Enter laptop name: ");
	l.setLaptopName(sc.next());
	System.out.println("Enter laptop model: ");
	l.setLaptopModel(sc.next());
	System.out.println("Enter laptop price: ");
	l.setLatopPrice(sc.nextDouble());
	
	c.addLaptop(l);
}else if(ch==2)
{
	c.viewLaptop();
}else if(ch==3)
{
	System.out.println("Enter the laptop ID: ");
	int laptopId = sc.nextInt();
	System.out.println("Enter laptop name which you want to change: ");
	String laptopname = sc.next();
	
	l.setLaptopId(laptopId);
	l.setLaptopName(laptopname);
    c.updateLaptop(l);
	
}else if(ch==4)
{
	System.out.println("Enter the laptop ID which you want to delete: ");
	int laptopId = sc.nextInt();
	l.setLaptopId(laptopId);
      c.removeLaptop(l);
	
}else
{
System.out.println("Invalid choice");	
}
}
}
