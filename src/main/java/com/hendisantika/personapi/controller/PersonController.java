package com.hendisantika.personapi.controller;

import com.hendisantika.personapi.dto.PersonResult;
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

        logger.info("========== Origin Data ==========");
        logger.info(data);
        PersonResult result = new PersonResult();

        setGender(data, result);
        setFullName(data, result);
        setAddress(data, result);
        setPictures(data, result);

        logger.info("========== Modified Data ==========");
        logger.info(result);

        return data;

    }

    private void setGender(PersonData data, PersonResult result) {
        String gender = data.getResults().get(0).getGender();
        result.setGender(gender);
    }

    private void setPictures(PersonData data, PersonResult result) {
        String picture = data.getResults().get(0).getPicture().getLarge();
        result.setPictures(picture);
    }

    private void setAddress(PersonData data, PersonResult result) {
        String street = data.getResults().get(0).getLocation().getStreet();
        String city = data.getResults().get(0).getLocation().getCity();
        String address = street + ", " + city;
        result.setAddress(address);
    }

    private void setFullName(PersonData data, PersonResult result) {
        String title = data.getResults().get(0).getName().getTitle();
        String firstName = data.getResults().get(0).getName().getFirst();
        String lastName = data.getResults().get(0).getName().getLast();
        String fullName = title + " " + firstName + " " + lastName;
        result.setFullName(fullName);
    }
}
