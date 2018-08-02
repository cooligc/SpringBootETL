/**
 * 
 */
package com.cooligc;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sitakant
 *
 */
@Component
public class MetaWritter implements ItemWriter<Meta> {

	@Autowired
	MetaRepo metaRepo;
	
	@Override
	public void write(List<? extends Meta> items) throws Exception {
		metaRepo.saveAll(items);
	}

}
