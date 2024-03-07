//package com.demo.knowledge.demo.config.configRabbitMQ;
//
//import com.demo.knowledge.demo.constants.JobQueue;
//import org.springframework.amqp.core.AmqpAdmin;
//import org.springframework.amqp.core.Queue;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RabbitQueueDefine {
//    @Autowired
//    @Qualifier("amqpAdmin")
//    AmqpAdmin amqpAdminMain;
//
//    @Bean
//    public Queue incomingQueue(){
//        for (String queueName: JobQueue.queueNameList){
//            Queue queue =new Queue(queueName, true, false, false, null);
//            amqpAdminMain.declareQueue(queue);
//        }
//        return null;
//    }
//}
