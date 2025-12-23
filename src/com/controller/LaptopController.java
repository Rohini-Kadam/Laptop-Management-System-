package com.controller;

import com.model.Laptop;
import com.service.*;
public class LaptopController {
	
	LaptopServiceI lsi = new LaptopServiceImpl(); 
	
public void addLaptop(Laptop l) {
		lsi.addLaptop(l);
}
public void viewLaptop() {	
		lsi.viewLaptop();	
}
public void updateLaptop(Laptop l) {
		lsi.updateLaptop(l);			
}
public void removeLaptop(Laptop l) {
		lsi.removeLaptop(l);			
}
}
