package com.telefonica.postpaidconsumption;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.telefonica.postpaidconsumption.business.PostpaidConsumptionRules;
import com.telefonica.postpaidconsumption.business.pojo.PostpaidConsumptionEspRequest;
import com.telefonica.postpaidconsumption.interfaces.PostpaidConsumptionProcessor;
import com.telefonica.postpaidconsumption.redis.GeneralPlant;
import com.telefonica.postpaidconsumption.service.GeneralPlantService;
import com.telefonica.postpaidconsumption.service.PostpaidThresholdBonusService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableBinding(PostpaidConsumptionProcessor.class)
@SuppressWarnings("unchecked")
@SpringBootApplication
public class PostpaidConsumptionThresholdApplication {

	@Autowired
	private GeneralPlantService generalPlantS;

	@Autowired
	private PostpaidThresholdBonusService postpaidThresholdBonusS;

	@StreamListener(PostpaidConsumptionProcessor.INPUT)
	public void process(KStream<String, PostpaidConsumptionEspRequest> input) {

		input.filter(log((key, value) -> PostpaidConsumptionRules.operationCodeFilter(value), "OPERATION_CODE_FILTER"))
				.map((key, value) -> {

					GeneralPlant obj = generalPlantS.infoSuscriber(value.getPhone());
					value.setGeneralPlant(obj);

					return KeyValue.pair(key, value);
				})
				.filter(log((key, value) -> PostpaidConsumptionRules.sourceSystemFilter(value), "SOURCE_SYSTEM_FILTER"))
				.filter(log((key, value) -> PostpaidConsumptionRules.customerSegmentFilter(value),
						"CUSTOMER_SEGMENT_FILTER"))
				.filter(log((key, value) -> PostpaidConsumptionRules.blackListFilter(value), "BLACK_LIST_FILTER"))
				.filter(log((key, value) -> PostpaidConsumptionRules.indecopiListFilter(value), "INDECOPI_LIST_FILTER"))
				.map((key, value) -> {

				//	PostpaidThresholdBonus obj = postpaidThresholdBonusS.bondInfo(value.getBondCode());
				//	value.setPostpaidThresholdBonus(obj);

					return KeyValue.pair(key, value);
				});

	}

	private <K, V> Predicate<K, V> log(Predicate<K, V> predicate, String label) {
		return (key, value) -> {
			boolean result = predicate.test(key, value);
			log.info("[STREAM: {}] tracking={}, result={}", label, key, result);
			return result;
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(PostpaidConsumptionThresholdApplication.class, args);
	}

}
