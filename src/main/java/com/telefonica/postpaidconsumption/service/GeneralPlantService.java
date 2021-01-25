package com.telefonica.postpaidconsumption.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonica.postpaidconsumption.redis.GeneralPlant;

@Service
public class GeneralPlantService {

	private final String REDIS_TABLE = "PLANTA_GENERAL_UNIFICADA";//tiene pk el phone

	@Autowired
	private RedisHashService service;

	public GeneralPlant infoSuscriber(String wlId) {
		return service.getAndParse(REDIS_TABLE, wlId, GeneralPlant.class);

	}

}
