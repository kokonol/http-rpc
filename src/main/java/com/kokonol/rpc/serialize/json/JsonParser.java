package com.kokonol.rpc.serialize.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.kokonol.rpc.exception.RpcException;
import com.kokonol.rpc.exception.RpcExceptionCodeEnum;
import com.kokonol.rpc.serialize.Parser;
import com.kokonol.rpc.serialize.Request;

public class JsonParser implements Parser {

    private static final Logger logger = LoggerFactory.getLogger(JsonParser.class);

    public static final Parser parser = new JsonParser();

    public Request reqParse(String param) throws RpcException {
        try
        {
            logger.debug("调用参数 {}", param);
            return (Request)JSON.parse(param);
        }
        catch (Exception e)
        {
            logger.error("转换异常 param = {}", param, e);
            throw new RpcException("",e, RpcExceptionCodeEnum.DATA_PARSER_ERROR.getCode(),param);
        }
    }

    public <T> T rspParse(String result)
    {
        return (T)JSON.parse(result);
    }
}
