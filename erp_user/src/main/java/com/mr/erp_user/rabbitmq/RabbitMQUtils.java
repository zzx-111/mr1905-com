package com.mr.erp_user.rabbitmq;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RabbitMQUtils {

    @Autowired
    private RabbitMessagingTemplate messagingTemplate;

    public void sendMessage(){

//        messagingTemplate.messagingTemplate

        Map<String,Object> messageBody = new HashMap<>();
        messageBody.put("orderName","fanyueyueのorder");
        messageBody.put("orderPrice",100000);
        try {
            messagingTemplate.convertAndSend("exchange11905","demo11905", JSON.toJSONString(messageBody));
            System.out.println("发送成功");

        }catch (Exception e){
            System.out.println("发送失败");
        }

    };

}
