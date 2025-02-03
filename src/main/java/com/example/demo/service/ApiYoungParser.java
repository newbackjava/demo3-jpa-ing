package com.example.demo.service;

import com.example.demo.entity.Young;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class ApiYoungParser {
    public List<Young> young() {
        //http통신을 해서
        //url+parameter(인증키, 검색어,...)
        String url = "https://www.youthcenter.go.kr/opi/empList.do";
        String paramter = "?openApiVlak=2853a1265426c8954d6b244d&pageIndex=1&display=10&query=청년취업";
        //데이터를 가지고 올 예정임.(http통신용 라이브러리)
        RestTemplate restTemplate = new RestTemplate();
        //url로 http통신을 하고 결과를 String에 넣어라.!
        String response = restTemplate.getForObject(url + paramter, String.class);
        //System.out.println(response);
        //xml형태로 된 String을 줌.
        //xml형태로 된 String을 JSON으로 변경하자.
        JSONObject json = XML.toJSONObject(response);
        //System.out.println(json);
        //json에서 우리가 필요한 것만 추출하자!
        //json은 맨 위에서부터 하나씩 추출함.
        //추출한 값의 타입이 json이 될 수도 있고
        //                json배열이 될 수 도 있음.
        //empsinfo의 값의 타입은 json
        JSONObject empsInfo = json.getJSONObject("empsInfo");
        //System.out.println("empsInfo>> " + empsInfo);
        //emp의 값의 타입은 jsonarray
        JSONArray empArr = empsInfo.getJSONArray("emp");
        //System.out.println("empArr>> " + empArr);
        //db에 넣기 위해서 vo로 만들어주자.!
        //반복문이므로 list<vo>로 만들어야한다.
        List<Young> list = new ArrayList<>();
        //json을 분석해서 추출함.(parser, 파서)
        for (int i = 0; i < empArr.length(); i++) {
            //for문의 반복만큼 vo가 만들어지고 list에 add하자.!
            Young young = new Young();
            JSONObject object = empArr.getJSONObject(i);
            String bizId = object.getString("bizId");
            String polyBizSjnm = object.getString("polyBizSjnm");
            String cnsgNmorbizId = object.getString("bizId");
            String rqutProcCn = object.getString("rqutProcCn");
            young.setBizId(bizId);
            young.setPolyBizSjnm(polyBizSjnm);
            young.setCnsgNmor(cnsgNmorbizId);
            young.setRqutProcCn(rqutProcCn);

            //System.out.println(young);
            list.add(young);
//            System.out.println("bizId>> " + bizId);
//            System.out.println("polyBizSjnm>> " + polyBizSjnm);
//            System.out.println("cnsgNmorbizId>> " + cnsgNmorbizId);
//            System.out.println("rqutProcCn>> " + rqutProcCn);
            System.out.println("---------------------------------");

             //[{"polyBizSecd":"003002001012","polyBizSjnm":"청년취업사관학교 은평캠퍼스 <산업 실무 프로젝트 기반 LLM 서비스 기획 과정> 참여자 모집","splzRlmRqisCn":"지역인재,제한없음","plcyTpNm":"null","rqutUrla":"https://sesac.seoul.kr/course/active/detail.do?courseActiveSeq=2823&srchCategoryTy
        } //for
        System.out.println(list.size()); //18개
        System.out.println(list); //{vo, vo, vo, ....}
        return list;
    }
}
