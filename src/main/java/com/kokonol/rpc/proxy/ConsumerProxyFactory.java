package com.kokonol.rpc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.kokonol.rpc.invoke.ConsumerConfig;
import com.kokonol.rpc.invoke.HttpInvoker;
import com.kokonol.rpc.invoke.Invoker;
import com.kokonol.rpc.serialize.Formater;
import com.kokonol.rpc.serialize.Parser;
import com.kokonol.rpc.serialize.json.JsonFormater;
import com.kokonol.rpc.serialize.json.JsonParser;


public class ConsumerProxyFactory implements InvocationHandler
{
    private ConsumerConfig consumerConfig;

    private Parser parser = JsonParser.parser;

    private Formater formater = JsonFormater.formater;

    private Invoker invoker = HttpInvoker.invoker;

    private String clazz;

	public Object create() throws Exception {
        Class interfaceClass = Class.forName(clazz);
        return Proxy.newProxyInstance(interfaceClass.getClassLoader(),new Class[]{interfaceClass},this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        Class interfaceClass = proxy.getClass().getInterfaces()[0];
        String req = formater.reqFormat(interfaceClass,method.getName(),args[0]);
        String resb = invoker.request(req,consumerConfig);
        return parser.rspParse(resb);
    }

    public ConsumerConfig getConsumerConfig() {
        return consumerConfig;
    }

    public void setConsumerConfig(ConsumerConfig consumerConfig) {
        this.consumerConfig = consumerConfig;
    }
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Invoker getInvoker() {
        return invoker;
    }

    public void setInvoker(Invoker invoker) {
        this.invoker = invoker;
    }

    public Formater getFormater() {
        return formater;
    }

    public void setFormater(Formater formater) {
        this.formater = formater;
    }

    public Parser getParser() {
        return parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }
}
