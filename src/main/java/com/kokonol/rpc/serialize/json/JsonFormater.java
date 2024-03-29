package com.kokonol.rpc.serialize.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kokonol.rpc.serialize.Formater;
import com.kokonol.rpc.serialize.Request;

public class JsonFormater implements Formater {

    public static final Formater formater = new JsonFormater();

    public String reqFormat(Class clazz, String method, Object param)
    {
        Request request = new Request();
        request.setParam(param);
        request.setClazz(clazz);
        request.setMethod(method);
        return JSON.toJSONString(request, SerializerFeature.WriteClassName);
    }

    public String rsbFormat(Object param)
    {
        return JSON.toJSONString(param, SerializerFeature.WriteClassName);
    }
}
