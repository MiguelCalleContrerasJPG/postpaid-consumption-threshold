package com.telefonica.postpaidconsumption.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonica.postpaidconsumption.redis.PostpaidThresholdBonus;

@Service
public class PostpaidThresholdBonusService {
	//bonos_umbral_postpago
	private final String REDIS_TABLE = "??";// NO DEFINIDO AUN

	@Autowired
	private RedisHashService service;

	public PostpaidThresholdBonus bondInfo(String bondCode) {
		return service.getAndParse(REDIS_TABLE, bondCode, PostpaidThresholdBonus.class);

	}

}
