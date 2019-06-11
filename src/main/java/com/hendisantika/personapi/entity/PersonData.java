package com.hendisantika.personapi.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : person-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-06-11
 * Time: 14:27
 */
@Data
public class PersonData {
    private List<Results> results = new ArrayList<>();

    private Info info;
}
