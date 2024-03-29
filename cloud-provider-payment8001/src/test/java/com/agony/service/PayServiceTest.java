package com.agony.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author Agony
 * @create 2024/3/20 14:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class PayServiceTest {

    private String name = "asd";
    //
    // public PayServiceTest() {
    //
    // }
    //
    // public PayServiceTest(String name) {
    //     this.name = name;
    // }


    @Test
    public void testZonedTime() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("now = " + now);
    }

    public static void main(String[] args) {
        PayServiceTest payServiceTest = new PayServiceTest();
        System.out.println("payServiceTest = " + payServiceTest);


        PayServiceTest payServiceTest1 = new PayServiceTest("asdasd");
        System.out.println("payServiceTest1 = " + payServiceTest1);


        List<String> list = Arrays.asList("asd", "asdd", "thishad");
        list.forEach(System.out::println);
    }


}