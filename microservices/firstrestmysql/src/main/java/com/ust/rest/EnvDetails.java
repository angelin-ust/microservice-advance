package com.ust.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//1st stepp

@Component
public class EnvDetails {

@Value("${spring.application.name}")
private String appServerName;
@Value("${server.port}")
private String portNumber;
public String getAppServerName() {
	return appServerName;
}
public void setAppServerName(String appServerName) {
	this.appServerName = appServerName;
}
public String getPortNumber() {
	return portNumber;
}
public void setPortNumber(String portNumber) {
	this.portNumber = portNumber;
}
@Override
public String toString() {
	return "EnvDetails [appServerName=" + appServerName + ", portNumber=" + portNumber + "]";
}



	
}
