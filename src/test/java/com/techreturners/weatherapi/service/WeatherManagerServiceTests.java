package com.techreturners.weatherapi.service;

import com.techreturners.weatherapi.exception.WeatherNotCreatedException;
import com.techreturners.weatherapi.model.AdviceRule;
import com.techreturners.weatherapi.model.Advice;
import com.techreturners.weatherapi.model.Weather;
import com.techreturners.weatherapi.respository.WeatherManagerRepository;
import com.techreturners.weatherapi.service.WeatherManagerServiceImpl;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
public class WeatherManagerServiceTests {

    @Mock
    private WeatherManagerRepository mockWeatherManagerRepository;

    @InjectMocks
    private WeatherManagerServiceImpl weatherManagerServiceImpl;

    @Test
    public void testOpenApiGet(){
        //call open API for current weather London
        Weather weather = new Weather();
        WeatherManagerService weatherManagerService = new WeatherManagerServiceImpl();

            weather = ((WeatherManagerServiceImpl) weatherManagerService).getCurrent("Rome");
            assertEquals("Rome", weather.getLocation().getName());
    }

    @Test
    public void testGetAdviceRuleByCity(){

        AdviceRule AdviceRule1 = new AdviceRule(1L, 1, "-100","9.9", "#Temperature is cold, wear an overcoat ");
        AdviceRule AdviceRule2 = new AdviceRule(2L, 1, "10","20.9", "#Temperature is chilly, wear a light jacket ");
        AdviceRule AdviceRule3 = new AdviceRule(3L, 1, "21","29.9", "#Temperature is warm, wear a shirt ");
        AdviceRule AdviceRule4 = new AdviceRule(4L, 1, "30","99", "#Temperature is very hot, drink more water ");

        AdviceRule AdviceRule5 = new AdviceRule(5L, 2, "0.1","7.9", "#No wind... ");
        AdviceRule AdviceRule6 = new AdviceRule(6L, 2, "8","19.9", "#Gentle Breeze... ");

//        moweatherAdvisorRepository.save(AdviceRule);
        List<AdviceRule> AdviceRuleL = new ArrayList<>();
        AdviceRuleL.add(AdviceRule1);
        AdviceRuleL.add(AdviceRule2);
        AdviceRuleL.add(AdviceRule3);
        AdviceRuleL.add(AdviceRule4);
        AdviceRuleL.add(AdviceRule5);
        AdviceRuleL.add(AdviceRule6);

       when(mockWeatherManagerRepository.findAll()).thenReturn(AdviceRuleL);

        Weather weather = weatherManagerServiceImpl.getCurrent("Frankfurt");
        Advice advice = weatherManagerServiceImpl.generateAdvice(weather);
        assertFalse(Strings.isNullOrEmpty(advice.getTempAdvice()));
        //assertEquals("#Temperature is warm, wear a shirt ", advice.getTempAdvice());

    }
    @Test
    void shouldThrowWeatherNotCreatedExceptionWhenLocationEmptyTest(){
        assertThrows(WeatherNotCreatedException.class,
                ()-> weatherManagerServiceImpl.getCurrent(""));
    }

}

