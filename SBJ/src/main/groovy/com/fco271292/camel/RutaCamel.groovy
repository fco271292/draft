package com.fco271292.camel

import org.apache.camel.Exchange
import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

@Component
class RutaCamel extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("timer:Temporizador?period=30s")
			.setHeader(Exchange.FILE_NAME,constant("LOG_${new Date().format('yyyyMMdd_HHmmss')}.txt"))
			.setBody().simple("${new Date().format('dd-MM-yyyy HH:mm:ss z')}")
			.to("log:${this.getClass()}?level=INFO")
			.to("file:salida/log")
	}

}
