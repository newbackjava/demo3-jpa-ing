package com.example.demo.naver;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class APIExamTranslate3EN {
        //영어 ---> 한글로!!!
    public String trans(String en) {
        String clientId = "ifbd5k67av";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "vmsepfL1AAjI3FFlWkjZl3oku88vyHQd16xr2x9x";//애플리케이션 클라이언트 시크릿값";\

        String translatedText = null;
        try {
            String text = URLEncoder.encode(en, "UTF-8");
            String apiURL = "https://naveropenapi.apigw.ntruss.com/nmt/v1/translation";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            // post request
            String postParams = "source=en&target=ko&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            //System.out.println(response.toString());
            //JSON객체로 변환하여 추출하자.
            //{"message":{"result":{"srcLangType":"ko","tarLangType":"en","translatedText":"Good to meet you."}}}
            //키의 값의 타입에 따라 함수를 구분하여 추출함.
            JSONObject obj = new JSONObject(response.toString());
            JSONObject message = obj.getJSONObject("message");
            JSONObject result = message.getJSONObject("result");
            translatedText = result.getString("translatedText");
            System.out.println("translatedText >>> " + translatedText);

        } catch (Exception e) {
            System.out.println(e);
        }//catch
        return translatedText;
    }
}