/**
 * 
 */
package com.cooligc;

import java.util.List;
import java.util.UUID;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sitakant
 *
 */
@Component
public class CarWritter implements ItemWriter<Car> {

	@Autowired
	private CarRepo carRepo;

	@Override
	public void write(List<? extends Car> items) throws Exception {
		System.out.println(UUID.randomUUID().toString() + "\t -> \t Going to write");
		carRepo.saveAll(items);
		System.out.println(UUID.randomUUID().toString() + "\t -> \t Data written");
	}

}
