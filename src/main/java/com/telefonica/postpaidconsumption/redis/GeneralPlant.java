package com.telefonica.postpaidconsumption.redis;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneralPlant {

	// abonado_cd
	@JsonProperty("subscriberCd")
	private String suscriberCode;
	// telefono
	@JsonProperty("phone")
	private String phone;
	// tipo_producto_cd
	// tipo_producto_desc
	@JsonProperty("productTypeDesc")
	private String productTypeDesc;
	// cargo_fijo
	// ciclo_facturacion
	// cant_min_plan
	// cant_sms_plan
	// cant_mb_plan
	// cant_min_rpm_plan
	// cod_sistema_fuente
	@JsonProperty("sourceSystemCodeCd")
	private String sourceSystemCode;
	// cod_segmento_cliente
	// desc_segmento_cliente
	@JsonProperty("customerSegmentDesc")
	private String customerSegmentClient;
	// operadora
	// flag_lista_negra
	@JsonProperty("flagIndBlackList")
	private String blackListFlag;
	// flag_lista_indecopi
	@JsonProperty("flagIndicatorList")
	private String indecopiListFlag;
	// cod_plan
	/// desc_plan
	// abr_plan
	// tecnologia

}
