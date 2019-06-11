package com.hendisantika.personapi.entity;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : person-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-06-11
 * Time: 14:13
 */
@Data
public class Info {
    private String seed;
    private int results;
    private int page;
    private String version;
}
