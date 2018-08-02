/**
 * 
 */
package com.cooligc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sitakant
 *
 */
@Repository
public interface CarRepo extends CrudRepository<Car, Long> {

}
