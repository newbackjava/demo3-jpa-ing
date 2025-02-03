package com.example.demo.api;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class ApiMovie_ {
    public static void main(String[] args) {
        //http통신을 해서
        //url+parameter(인증키, 검색어,...)
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";

        // 요청에 필요한 매개변수 설정
        String apiKey = "6d67fa164c41539d5695302942e640be";
        String targetDt = "20231209";

        // URL에 파라미터 추가
        String requestUrl = url + "?key=" + apiKey + "&targetDt=" + targetDt;

        // GET 요청 보내기
        String response = restTemplate.getForObject(requestUrl, String.class);
        //System.out.println(response);
        //xml형태로 된 String을 줌.
        //xml형태로 된 String을 JSON으로 변경하자.
       // System.out.println(response);

        JSONObject jsonObject = new JSONObject(response);
        System.out.println(jsonObject);
    }
}
