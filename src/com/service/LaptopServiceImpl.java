package com.service;
import com.model.Laptop;
import com.repositary.*;

public class LaptopServiceImpl implements LaptopServiceI{
	LaptopRepositaryI lr = new LaptopRepositaryImpl();
	
@Override
public void addLaptop(Laptop l) {
		lr.addLaptop(l);
}

@Override
public void viewLaptop() {
		lr.viewLaptop();	
}

@Override
public void updateLaptop(Laptop l) {
		lr.updateLaptop(l);
}

@Override
public void removeLaptop(Laptop l) {
		
		lr.removeLaptop(l);
}

}
