package com.starterkit.mq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 540491 
 * RabbitMQMessagePublisher implements MessagePublisher to
 * publish the json message in to rabbit MQ.
 */
@Component
public class RabbitMQMessagePublisher {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private Queue queue;

	/**
	 * method to publish the json message in to rabbit MQ server and returns the
	 * unique id
	 * @param messageContent
	 * @param requestGuid
	 */
	public void publishMessage(String messageContent, String requestGuid) {
		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setCorrelationIdString(requestGuid);
		messageProperties.setContentType("application/json");
		messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
		Message message = new Message(messageContent.getBytes(), messageProperties);
		rabbitTemplate.sendAndReceive(queue.getName(), message);
	}

}
