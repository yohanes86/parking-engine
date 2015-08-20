package com.myproject.parking.lib.service;

import id.co.veritrans.mdk.v1.VtGatewayConfig;
import id.co.veritrans.mdk.v1.VtGatewayConfigBuilder;
import id.co.veritrans.mdk.v1.VtGatewayFactory;
import id.co.veritrans.mdk.v1.config.EnvironmentType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VeriTransManagerService {

	private static final Logger LOG = LoggerFactory.getLogger(VeriTransManagerService.class);
	
	private String clientKey;
	private String serverKey;
	private String environment;
    private int connectionPoolSize;

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public String getServerKey() {
		return serverKey;
	}

	public void setServerKey(String serverKey) {
		this.serverKey = serverKey;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public int getConnectionPoolSize() {
		return connectionPoolSize;
	}

	public void setConnectionPoolSize(int connectionPoolSize) {
		this.connectionPoolSize = connectionPoolSize;
	}

	public VtGatewayFactory getVtGatewayFactory() {
		VtGatewayConfigBuilder vtGatewayConfigBuilder = new VtGatewayConfigBuilder();
		vtGatewayConfigBuilder.setServerKey(serverKey);
		vtGatewayConfigBuilder.setClientKey(clientKey);
		vtGatewayConfigBuilder.setEnvironmentType(EnvironmentType.valueOf(environment));
		vtGatewayConfigBuilder.setMaxConnectionPoolSize(connectionPoolSize);
		VtGatewayConfig vtGatewayConfig = vtGatewayConfigBuilder.createVtGatewayConfig();
		return new VtGatewayFactory(vtGatewayConfig);
	}
	
	
	
}
