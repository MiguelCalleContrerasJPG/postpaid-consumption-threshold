package com.telefonica.postpaidconsumption.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralPlantUnifiedSuscribeService {

	private final String REDIS_TABLE = "PLANTA_GENERAL_UNIFICADA_SUBSCRIBER";

	@Autowired
	private RedisHashService service;

	/**
	 * Obtiene el telefono de un abonado con el suscriberCd
	 * 
	 * @param suscriberCd
	 * @return
	 */
	public String findPhoneNumber(String suscriberCd) {
		return service.getAndParse(REDIS_TABLE, suscriberCd, String.class);
	}

}
