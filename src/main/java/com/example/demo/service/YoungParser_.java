package com.example.demo.service;

import com.example.demo.entity.Young;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

public class YoungParser_ {
    public ArrayList<Young> parse() {    //url + parameter
        String url = "https://www.youthcenter.go.kr/opi/empList.do";
        String parameter = "?openApiVlak=2853a1265426c8954d6b244d&pageIndex=1&display=100&query=청년취업";

        //http 요청 --> 응답(xml)
        RestTemplate rest = new RestTemplate();
        String response = rest.getForObject(url + parameter, String.class);
        //System.out.println(response);

        //xml --> json변경
        JSONObject json = XML.toJSONObject(response);
        System.out.println(json);

        //json분석 후 추출(parser, 파서)
        //json바깥쪽부터 안으로 들어오면서 추출을 함.
        JSONObject empsInfo = json.getJSONObject("empsInfo");//값이 json일 때
        JSONArray arr = empsInfo.getJSONArray("emp");//값이 jsonarray일 때

        ArrayList<Young> list = new ArrayList<Young>();

        for (int i = 0; i < arr.length(); i++) {
            Young vo = new Young();
            vo.setBizId(arr.getJSONObject(i).getString("bizId"));
            vo.setCnsgNmor(arr.getJSONObject(i).getString("cnsgNmor"));
            vo.setPolyBizSjnm(arr.getJSONObject(i).getString("polyBizSjnm"));
            vo.setRqutProcCn(arr.getJSONObject(i).getString("rqutProcCn"));
            list.add(vo);
        }
        //{vo, vo, vo, vo, vo, vo, vo,....}
        return list;
    }
}