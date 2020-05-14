import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import mq.JmsConsumer;
import mq.JmsProducer;

import java.net.URI;

class TextMessageTest {

    @Test
    void test() throws Exception {
        BrokerService broker = BrokerFactory.createBroker(new URI(
                "broker:(tcp://localhost:61616)"));
        broker.start();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        try {
            JmsProducer producer = (JmsProducer) context
                    .getBean("jmsProducer");
            producer.sendTextMessage("Hi");

            JmsConsumer consumer = (JmsConsumer) context
                    .getBean("jmsConsumer");
            System.out.println("Consumer receives " + consumer.receiveTextMessage());
        } finally {
            broker.stop();
            context.close();
        }
    }
}
