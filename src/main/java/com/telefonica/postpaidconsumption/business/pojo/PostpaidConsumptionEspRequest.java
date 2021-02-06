package com.telefonica.postpaidconsumption.business.pojo;

import com.telefonica.postpaidconsumption.redis.GeneralPlant;
import com.telefonica.postpaidconsumption.redis.PostpaidThresholdBonus;

import lombok.Data;

@Data
public class PostpaidConsumptionEspRequest {

	// tracking_esp //key
	private String trackingEsp;
	// telefono
	private String phone;
	// tarif_plan
	private String ratePlan;
	// opcode
	private String operationCode;
	// fecha
	private String date;
	// rejection_code
	private String rejectionCode;
	// cod_bono
	private String bondCode;
	// cantidad
	private String quantity;
	// fecha_ini
	private String startDate;
	// fecha_fin
	private String endDate;
	// bolton_state
	private String boltonState;

	private GeneralPlant generalPlant;
	private PostpaidThresholdBonus postpaidThresholdBonus;
	private UmbralConsumePostPay umbralConsumePostPay;

}
