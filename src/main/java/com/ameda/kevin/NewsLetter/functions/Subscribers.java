package com.ameda.kevin.NewsLetter.functions;
/*
*
@author ameda
@project NewsLetter
*
*/

import com.ameda.kevin.NewsLetter.model.Subscriber;
import com.ameda.kevin.NewsLetter.service.SubscriberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Configuration
public class Subscribers {
    private static final Logger LOG = LoggerFactory.getLogger(Subscribers.class);
    private final SubscriberService subscriberService;

    public Subscribers(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @Bean
    public Supplier<List<Subscriber>> findAll(){
        LOG.info("subscriberService.findAll(): was called");
        return  ()-> subscriberService.findAll();
    }

    @Bean
    public Consumer<String> create(){
        return  (email)-> subscriberService.create(email);
    }
}
