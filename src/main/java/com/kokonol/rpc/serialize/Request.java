package com.kokonol.rpc.serialize;

import java.io.Serializable;

public class Request implements Serializable{

	private static final long serialVersionUID = 1L;

	private Class clazz;
	
	private String method;
	
	private Object param;

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Object getParam() {
		return param;
	}

	public void setParam(Object param) {
		this.param = param;
	}

    public Object invoke(Object bean) throws Exception{
        return clazz.getMethod(method, param.getClass()).invoke(bean,param);
    }
	
}
