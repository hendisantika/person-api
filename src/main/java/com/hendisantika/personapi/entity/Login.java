package com.hendisantika.personapi.entity;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : person-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-06-11
 * Time: 14:20
 */
@Data
public class Login {
    private String sha1;

    private String password;

    private String salt;

    private String sha256;

    private String uuid;

    private String username;

    private String md5;
}
