package com.telefonica.postpaidconsumption.business.pojo;

import lombok.Data;

@Data
public class PostpaidConsumptionRtdmRequest {

	// tracking_esp->opcode_filter
	private String trackingEsp;
	// abonado_cd-->planta_general_source
	private String suscriberCode;
	// telefono->opcode_filter
	private String phone;
	// saldo_sc_td->valid
	private String balanceScTd;
	// saldo_sc_mb->valid
	private String balanceScMb;
	// codigo_bono -->opcode_filter
	private String bondCode;
	// tipo_producto_desc-->planta_general_source
	private String productTypeDesc;
	// tipo_bono-->bonos_umbral_postpago
	private String bondType;
}
