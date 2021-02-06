package com.telefonica.postpaidconsumption.business.pojo;

import lombok.Data;

@Data
/**
 * umbral_consumo_postpago_v3_rtdm
 * @author Synopsis
 *
 */
public class UmbralConsumePostPay {
    //tracking_esp
    private String trackingEsp;
    //abonado_cd
    private String subscriberCode;
    //telefono
    private String telephone;
    //saldo_sc_td
    private Integer balanceScTd;
    //saldo_sc_mb
    private Integer balanceScMb;
    //codigo_bono
    private String bondCode;
    //tipo_producto_desc
    private String productTypeDesc;
    //tipo_bono
    private String bondType;
}
