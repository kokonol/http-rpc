package com.kokonol.rpc.serialize;

public interface Formater {
	String reqFormat(Class clazz, String method, Object param);
	String rsbFormat(Object result);
}
