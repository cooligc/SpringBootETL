/**
 * 
 */
package com.cooligc;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sitakant
 *
 */
@Component
public class CarProcessor implements ItemProcessor<Car, Car> {

	@Autowired
	CarRepo carRepo;
	
	@Autowired
	MetaRepo metaRepo;

	@Override
	public Car process(Car item) throws Exception {
		// If some convertion are needed . e.g lets say csv file contain 1 for
		// petrol type car and 2 for diesel type car and so on.
		// In that case, we can map the appropirate value in car object
		System.out.println("item ---> " + item);
		item.setAuthToken(metaRepo.findTop1ByOrderByIdDesc().getAuthToken());
		return item;
	}
}
