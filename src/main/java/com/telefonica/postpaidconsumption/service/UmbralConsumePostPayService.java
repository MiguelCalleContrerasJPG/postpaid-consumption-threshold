package com.telefonica.postpaidconsumption.service;

import org.springframework.stereotype.Service;

import com.telefonica.postpaidconsumption.business.pojo.PostpaidConsumptionEspRequest;
import com.telefonica.postpaidconsumption.business.pojo.UmbralConsumePostPay;

@Service
public class UmbralConsumePostPayService {

    public UmbralConsumePostPay umbralInfo(PostpaidConsumptionEspRequest source) {
	
	UmbralConsumePostPay target = new UmbralConsumePostPay();
	target.setTrackingEsp(source.getTrackingEsp());
	target.setSubscriberCode(source.getGeneralPlant().getSuscriberCode());
	target.setTelephone(source.getGeneralPlant().getPhone());
	target.setBalanceScTd(evalBalanceScTd(source.getBondCode()));
	target.setBalanceScMb(evalBalanceScMb(source.getBondCode()));
	target.setBondCode(source.getBondCode());
	target.setProductTypeDesc(source.getGeneralPlant().getProductTypeDesc());
	target.setBondType(source.getPostpaidThresholdBonus().getBondType());
	return target;
	
    }
    
    private Integer evalBalanceScTd(String code) {
	if("1".equals(code))
	{
	    return 1;
	}
	else
	{
	    return 2;
	}
    }

    
    private Integer evalBalanceScMb(String code) {
	if("2".equals(code))
	{
	    return 1;
	}
	else
	{
	    return 2;
	}
    }
    
}
