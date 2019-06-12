package com.hendisantika.personapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hendisantika.personapi.dto.PersonResult;
import com.hendisantika.personapi.entity.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by IntelliJ IDEA.
 * Project : person-api
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-06-11
 * Time: 15:13
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerTest {

    @Mock
    RestTemplate restTemplate;

    @Value("${local.server.port}")
    int randomServerPort;

    @InjectMocks
    private PersonController controller;

    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getPerson_Positive() throws Exception {
        PersonData expectedResult = createPersonData();

        when(restTemplate.getForObject(eq("https://randomuser.me/api/"), eq(PersonData.class)))
                .thenReturn(expectedResult);

        MockHttpServletResponse response = mockMvc.perform(get("/api/person"))
                .andReturn().getResponse();

        PersonResult expectedData = createResultData();


        assertEquals(200, response.getStatus());
        assertEquals(mapper.writeValueAsString(expectedResult), mapper.writeValueAsString(expectedResult));
        assertEquals(mapper.writeValueAsString(expectedData), response.getContentAsString());
    }

    @Test
    public void getPerson_Negative() throws Exception {
        PersonData expectedResult = createPersonData();

        when(restTemplate.getForObject(eq("https://randomuser.me/api2/"), eq(PersonData.class)))
                .thenReturn(expectedResult);

        MockHttpServletResponse response = mockMvc.perform(get("/api/person2"))
                .andReturn().getResponse();

        assertThat(response.getContentAsString()).isEqualTo("");
    }

    private PersonResult createResultData() {
        PersonResult result = new PersonResult();
        result.setGender("Male");
        result.setFullName("Mr. Uzumaki Naruto");
        result.setAddress("Buahbatu, Bandung");
        result.setPictures("https://randomuser.me/api/portraits/men/5.jpg");
        return result;
    }

    private PersonData createPersonData() {
        PersonData result = new PersonData();
        result.setResults(Collections.singletonList(createResults()));

        return result;
    }

    private Results createResults() {
        Results results = new Results();

        results.setNat("RK");
        results.setGender("Male");
        results.setPhone("123456789");
        Dob dob = new Dob();
        dob.setDate("1988-08-17T11:11:17Z");
        dob.setAge("30");
        results.setDob(dob);

        Name name = new Name();
        name.setTitle("Mr.");
        name.setFirst("Uzumaki");
        name.setLast("Naruto");
        results.setName(name);

        Registered registered = new Registered();
        registered.setDate("2007-10-19T08:13:43Z");
        registered.setAge("11");
        results.setRegistered(registered);

        Location location = new Location();
        location.setCity("Bandung");
        location.setStreet("Buahbatu");
        location.setState("West Java");
        location.setPostcode("40377");

        Timezone timezone = new Timezone();
        timezone.setOffset("+7:00");
        timezone.setDescription("Asia/Jakarta");
        location.setTimezone(timezone);

        results.setLocation(location);

        Id id = new Id();
        id.setName("CPR");
        id.setValue("512582-0715");

        Login login = new Login();
        login.setUuid("2f90d7f2-47f0-4c8d-9ef6-cd50a242e293");
        login.setUsername("yellowgorilla803");
        login.setPassword("hokage");
        login.setSalt("qB9bXFZK");
        login.setMd5("cd5a7e9a2fe8e24cf4b073bb6602ec5f");
        login.setSha1("42387ea1a7733b18fb935f883033f66f215d9db4");
        login.setSha256("9d4433075100fec4b97464260d3b43d0954188f16e1e5998ab1e8afdf8fa894e");

        results.setCell("61706567");
        results.setEmail("uzumaki_naruto@konohagakure.co.jp");

        Picture picture = new Picture();
        picture.setThumbnail("https://randomuser.me/api/portraits/thumb/men/5.jpg");
        picture.setLarge("https://randomuser.me/api/portraits/men/5.jpg");
        picture.setMedium("https://randomuser.me/api/portraits/med/men/5.jpg");
        results.setPicture(picture);

        Info info = new Info();
        info.setSeed("cdb0a05ce6356b4a");
        info.setResults(1);
        info.setPage(1);
        info.setVersion("1.2");


        return results;
    }

}