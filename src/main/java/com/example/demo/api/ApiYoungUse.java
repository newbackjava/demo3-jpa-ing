package com.example.demo.api;

import com.example.demo.entity.Young;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public class ApiYoungUse {
    public static void main(String[] args) {
        //rest api연결한 후 파서 결과를 db에 넣고 싶음.
        ApiYoungParser parser = new ApiYoungParser();
        List<Young> list = parser.young();
        System.out.println("-----받은 데이터--------");
        System.out.println(list);
        System.out.println("-----db에 넣을 예정.jpa이용!");
    }
}
