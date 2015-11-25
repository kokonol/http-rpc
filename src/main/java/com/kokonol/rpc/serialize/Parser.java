package com.kokonol.rpc.serialize;

import com.kokonol.rpc.exception.RpcException;

public interface Parser {
	Request reqParse(String param) throws RpcException;
	public <T> T rspParse(String result) throws RpcException;
}
