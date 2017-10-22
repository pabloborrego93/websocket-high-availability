package com.pbg.SocketsDemo.service;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ServerInfoService {

	@Autowired
	Environment environment;

	public String getIpAddress() {
		return InetAddress.getLoopbackAddress().getHostAddress();
	}

	public String getPort() {
		return environment.getProperty("server.port");
	}
	
	public String getCompleteIP() {
		return new String(getIpAddress()+":"+getPort());
	}
	
}
