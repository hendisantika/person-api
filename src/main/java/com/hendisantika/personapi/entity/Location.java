package com.hendisantika.personapi.entity;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : person-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-06-11
 * Time: 14:19
 */
@Data
public class Location {
    private String city;

    private String street;

    private Timezone timezone;

    private String postcode;

    private Coordinates coordinates;

    private String state;
}
