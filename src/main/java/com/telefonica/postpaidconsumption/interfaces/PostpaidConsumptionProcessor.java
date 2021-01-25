package com.telefonica.postpaidconsumption.interfaces;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface PostpaidConsumptionProcessor {
	

	String INPUT = "postpaid-consumption-in";
	String OUTPUT = "cola-out";

	@Input(INPUT)
	KStream<?, ?> input();

}
