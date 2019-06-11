package com.hendisantika.personapi.entity;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : person-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-06-11
 * Time: 14:22
 */
@Data
public class Results {
    private String nat;

    private String gender;

    private String phone;

    private Dob dob;

    private Name name;

    private Registered registered;

    private Location location;

    private Id id;

    private Login login;

    private String cell;

    private String email;

    private Picture picture;
}
