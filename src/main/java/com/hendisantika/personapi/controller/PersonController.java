package com.hendisantika.personapi.controller;

import com.hendisantika.personapi.entity.PersonData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by IntelliJ IDEA.
 * Project : person-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-06-11
 * Time: 14:24
 */
@RestController
@RequestMapping
public class PersonController {

    private static Logger logger = LogManager.getLogger(PersonController.class);

    @GetMapping("/api/person")
    PersonData getPerson() {
        RestTemplate restTemplate = new RestTemplate();
        PersonData data = restTemplate.getForObject("https://randomuser.me/api/", PersonData.class);


        logger.info("Origin data --> {}", data);



        return data;

    }
}
