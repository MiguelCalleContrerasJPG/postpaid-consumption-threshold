package com.telefonica.postpaidconsumption.transform;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import com.telefonica.postpaidconsumption.business.pojo.PostpaidConsumptionEspRequest;
import com.telefonica.postpaidconsumption.business.pojo.PostpaidConsumptionRtdmRequest;

public class PostpaidConsumptionRtdmRequestTrasnform implements
		Transformer<String, PostpaidConsumptionEspRequest, KeyValue<String, PostpaidConsumptionRtdmRequest>> {

	@Override
	public void init(ProcessorContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public KeyValue<String, PostpaidConsumptionRtdmRequest> transform(String key, PostpaidConsumptionEspRequest value) {

		PostpaidConsumptionRtdmRequest obj = new PostpaidConsumptionRtdmRequest();

		obj.setTrackingEsp(value.getTrackingEsp());
		obj.setPhone(value.getPhone());
		obj.setBondCode(value.getBondCode());

		return KeyValue.pair(key, obj);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
