package com.liuxc.microcloud.fallback;

import java.util.List;

import org.springframework.stereotype.Component;

import com.liuxc.microcloud.api.Dept;
import com.liuxc.microcloud.service.IDeptClientService_Zuul;
import feign.hystrix.FallbackFactory;

@Component
public class IDeptClientServiceFallBackFactory implements FallbackFactory<IDeptClientService_Zuul> {

	@Override
	public IDeptClientService_Zuul create(Throwable arg0) {

		return new IDeptClientService_Zuul() {

			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Dept findById(Long id) {
				Dept dept = new Dept();
				dept.setId(id);
				dept.setName("ERROR: ID not found dept");
				dept.setLoc("客户端提供");
				return dept;
			}

			@Override
			public List<Dept> findAll() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

}
