package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

public class Json {


    public static void toJson(Movie movie, HttpServletResponse response) throws Exception{
        response.setContentType("text/json");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();

        String json = JSONObject.toJSONString(movie,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.DisableCircularReferenceDetect);
        writer.write(json);
        writer.close();
    }

}