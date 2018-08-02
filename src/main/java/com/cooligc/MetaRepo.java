package com.cooligc;

import org.springframework.data.repository.CrudRepository;

public interface MetaRepo extends CrudRepository<Meta, Long> {
	Meta findTop1ByOrderByIdDesc();
}