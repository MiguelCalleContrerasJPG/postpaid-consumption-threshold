package com.telefonica.postpaidconsumption.business;

import java.util.Objects;

import com.telefonica.postpaidconsumption.business.pojo.PostpaidConsumptionEspRequest;
import com.telefonica.postpaidconsumption.commons.Constants;

public class PostpaidConsumptionRules {

	public static boolean operationCodeFilter(PostpaidConsumptionEspRequest value) {

		return Constants.OPERATION_CODE.equalsIgnoreCase(value.getOperationCode());
	}

	public static boolean sourceSystemFilter(PostpaidConsumptionEspRequest value) {
		if (Objects.isNull(value.getGeneralPlant())) {
			return false;
		}

		return "AMD".equalsIgnoreCase(value.getGeneralPlant().getSourceSystemCode());
	}

	public static boolean customerSegmentFilter(PostpaidConsumptionEspRequest value) {
		if (Objects.isNull(value.getGeneralPlant())) {
			return false;
		}

		return "RESIDENCIAL".equalsIgnoreCase(value.getGeneralPlant().getCustomerSegmentClient());
	}

	public static boolean blackListFilter(PostpaidConsumptionEspRequest value) {
		if (Objects.isNull(value.getGeneralPlant())) {
			return false;
		}

		return "0".equalsIgnoreCase(value.getGeneralPlant().getBlackListFlag());
	}

	public static boolean indecopiListFilter(PostpaidConsumptionEspRequest value) {
		if (Objects.isNull(value.getGeneralPlant())) {
			return false;
		}

		return "0".equalsIgnoreCase(value.getGeneralPlant().getIndecopiListFlag());
	}

}
