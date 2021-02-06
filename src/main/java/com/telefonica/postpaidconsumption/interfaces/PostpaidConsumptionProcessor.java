package com.telefonica.postpaidconsumption.interfaces;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface PostpaidConsumptionProcessor {
	

	String INPUT = "queue-topic-notifyExt-out";
	String OUTPUT = "queue-token-retention";

	@Input(INPUT)
	KStream<?, ?> input();

}
