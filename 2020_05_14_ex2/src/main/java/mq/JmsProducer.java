package mq;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import serializers.JsonSerializer;
import serializers.XmlSerializer;
import serializers.YamlSerializer;

import javax.jms.*;
import java.io.IOException;

public class JmsProducer {
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
	
	public void sendTextMessage(final String msg) {
		System.out.println("Producer sends " + msg);
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}});		
	}

	public void sendJsonObjectMessage(final Object obj) {
		JsonSerializer jsonSerializer = new JsonSerializer();
		String msg = jsonSerializer.serialized(obj);
		sendTextMessage(msg);
	}

	public void sendXmlObjectMessage(final Object obj) {
		XmlSerializer xmlSerializer = new XmlSerializer();
		try {
			String msg = xmlSerializer.serialized(obj);
			sendTextMessage(msg);
		} catch (IOException exp) {
			System.out.println(exp.getMessage());
		}
	}

	public void sendYamlObjectMessage(final Object obj) {
		YamlSerializer yamlSerializer = new YamlSerializer();
		try {
			String msg = yamlSerializer.serialized(obj);
			sendTextMessage(msg);
		} catch (IOException exp) {
			System.out.println(exp.getMessage());
		}
	}
}
