/**
 * 
 */
package com.cooligc;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author sitakant
 *
 */
@Component
public class MetaProcessor implements ItemProcessor<Meta, Meta>{

	@Override
	public Meta process(Meta item) throws Exception {
		System.out.println("Meta got called");
		return item;
	}

}
