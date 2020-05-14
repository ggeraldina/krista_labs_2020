import library.Library;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import mq.JmsConsumer;
import mq.JmsProducer;

import java.net.URI;

public class ObjectMessageTest {

    @Test
    void jsonObjectTest() throws Exception {
        BrokerService broker = BrokerFactory.createBroker(new URI(
                "broker:(tcp://localhost:61616)"));
        broker.start();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        Library library = new Library();
        library.fillLibrary();
        Library library1 = new Library();
        library1.fillLibraryOther();

        try {
            JmsProducer producer = (JmsProducer) context
                    .getBean("jmsProducer");
            producer.sendJsonObjectMessage(library);
            producer.sendJsonObjectMessage(library1);

            JmsConsumer consumer = (JmsConsumer) context
                    .getBean("jmsConsumer");
            System.out.println("Consumer receives " + consumer.receiveJsonObjectMessage(Library.class));
            System.out.println("Consumer receives " + consumer.receiveJsonObjectMessage(Library.class));
        } finally {
            broker.stop();
            context.close();
        }
    }

    @Test
    void xmlObjectTest() throws Exception {
        BrokerService broker = BrokerFactory.createBroker(new URI(
                "broker:(tcp://localhost:61616)"));
        broker.start();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        Library library = new Library();
        library.fillLibrary();
        Library library1 = new Library();
        library1.fillLibraryOther();

        try {
            JmsProducer producer = (JmsProducer) context
                    .getBean("jmsProducer");
            producer.sendXmlObjectMessage(library);
            producer.sendXmlObjectMessage(library1);

            JmsConsumer consumer = (JmsConsumer) context
                    .getBean("jmsConsumer");
            System.out.println("Consumer receives " + consumer.receiveXmlObjectMessage(Library.class));
            System.out.println("Consumer receives " + consumer.receiveXmlObjectMessage(Library.class));
        } finally {
            broker.stop();
            context.close();
        }
    }

    @Test
    void yamlObjectTest() throws Exception {
        BrokerService broker = BrokerFactory.createBroker(new URI(
                "broker:(tcp://localhost:61616)"));
        broker.start();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        Library library = new Library();
        library.fillLibrary();
        Library library1 = new Library();
        library1.fillLibraryOther();

        try {
            JmsProducer producer = (JmsProducer) context
                    .getBean("jmsProducer");
            producer.sendYamlObjectMessage(library);
            producer.sendYamlObjectMessage(library1);

            JmsConsumer consumer = (JmsConsumer) context
                    .getBean("jmsConsumer");
            System.out.println("Consumer receives " + consumer.receiveYamlObjectMessage(Library.class));
            System.out.println("Consumer receives " + consumer.receiveYamlObjectMessage(Library.class));
        } finally {
            broker.stop();
            context.close();
        }
    }


    @Test
    void AnyObjectTest() throws Exception {
        BrokerService broker = BrokerFactory.createBroker(new URI(
                "broker:(tcp://localhost:61616)"));
        broker.start();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        Library library = new Library();
        library.fillLibrary();

        try {
            JmsProducer producer = (JmsProducer) context
                    .getBean("jmsProducer");
            producer.sendJsonObjectMessage(library);
            producer.sendXmlObjectMessage(library);
            producer.sendYamlObjectMessage(library);

            JmsConsumer consumer = (JmsConsumer) context
                    .getBean("jmsConsumer");
            System.out.println("Consumer receives " + consumer.receiveJsonObjectMessage(Library.class));
            System.out.println("Consumer receives " + consumer.receiveXmlObjectMessage(Library.class));
            System.out.println("Consumer receives " + consumer.receiveYamlObjectMessage(Library.class));
        } finally {
            broker.stop();
            context.close();
        }
    }
}
