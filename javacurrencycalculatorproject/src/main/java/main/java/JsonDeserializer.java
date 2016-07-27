package main.java;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;


public class JsonDeserializer {

    public ExchangeInfoList ConvertedList;

    public JsonDeserializer(String infoList) throws IOException {
        ConvertedList = DeserializeJsonList(infoList);
    }

    private ExchangeInfoList DeserializeJsonList(String infoList) throws IOException {
        /*ObjectMapper mapper = new ObjectMapper();
        ExchangeInfoList asd =  mapper.readValue(infoList,ExchangeInfoList.class);

        return asd ;*/
        //return new Gson().fromJson(infoList,ExchangeInfoList.class);
        //JsonParser jsonParser = new JsonParser();
        //JsonObject jo = (JsonObject)jsonParser.parse(infoList);
        //System.out.println(infoList);
        Gson googleJson = new Gson();
        return googleJson.fromJson(infoList, ExchangeInfoList.class);
    }
}
