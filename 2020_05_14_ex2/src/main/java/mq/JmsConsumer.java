package mq;

import org.springframework.jms.core.JmsTemplate;
import serializers.JsonSerializer;
import serializers.XmlSerializer;
import serializers.YamlSerializer;

import javax.jms.*;
import java.io.IOException;

public class JmsConsumer {
	private JmsTemplate jmsTemplate;
	private Destination destination;
	
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	public String receiveTextMessage() throws JMSException {
		TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);
		String msg = textMessage.getText();
		System.out.println("Consumer receives message " + msg);
		return msg;
	}

	public Object receiveJsonObjectMessage(Class deserializeClass) throws JMSException {
		String msg = receiveTextMessage();
		JsonSerializer jsonSerializer = new JsonSerializer();
		return jsonSerializer.deserialized(msg, deserializeClass);
	}

	public Object receiveXmlObjectMessage(Class deserializeClass) throws JMSException {
		String msg = receiveTextMessage();
		XmlSerializer xmlSerializer = new XmlSerializer();
		try {
			return xmlSerializer.deserialized(msg, deserializeClass);
		} catch (IOException exp) {
			System.out.println(exp.getMessage());
			return null;
		}
	}

	public Object receiveYamlObjectMessage(Class deserializeClass) throws JMSException {
		String msg = receiveTextMessage();
		YamlSerializer yamlSerializer = new YamlSerializer();
		try {
			return yamlSerializer.deserialized(msg, deserializeClass);
		} catch (IOException exp) {
			System.out.println(exp.getMessage());
			return null;
		}
	}
}
