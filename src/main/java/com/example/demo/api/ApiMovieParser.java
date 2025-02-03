package com.example.demo.api;

import com.example.demo.entity.Movie;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class ApiMovieParser {
    public List<Movie> movie() {
        //http통신을 해서
        //url+parameter(인증키, 검색어,...)
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";

        // 요청에 필요한 매개변수 설정
        String apiKey = "6d67fa164c41539d5695302942e640be";
        String targetDt = "20250119";

        // URL에 파라미터 추가
        String requestUrl = url + "?key=" + apiKey + "&targetDt=" + targetDt;
        String response = restTemplate.getForObject(requestUrl, String.class);
        //System.out.println(response);
        //json으로 인식!
        JSONObject json = new JSONObject(response);
        //System.out.println(json);
        JSONObject box = json.getJSONObject("boxOfficeResult");
        //System.out.println(box);
        JSONArray array = box.getJSONArray("dailyBoxOfficeList");
        System.out.println(array);

        List<Movie> movieList = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            Movie movie = new Movie();
            JSONObject object = array.getJSONObject(i);
            System.out.println(object);
            movie.setRnum(object.getString("rnum"));
            movie.setMovieNm(object.getString("movieNm"));
            movie.setSalesAmt(object.getString("salesAmt"));
            movie.setRankOldAndNew(object.getString("rankOldAndNew"));
            movie.setAudiCnt(object.getString("audiCnt"));
            movieList.add(movie);
        }
        System.out.println("===============");
        System.out.println(movieList);
        return movieList;
    }
}
