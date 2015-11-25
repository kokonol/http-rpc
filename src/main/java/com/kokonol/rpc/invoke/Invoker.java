package com.kokonol.rpc.invoke;

import java.io.OutputStream;

import com.kokonol.rpc.exception.RpcException;

public interface Invoker {

	public String request(String reqeust, ConsumerConfig consumerConfig) throws RpcException;
	public void response(String response, OutputStream outputStream) throws RpcException;
}
