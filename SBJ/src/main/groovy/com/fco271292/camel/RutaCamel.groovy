package com.fco271292.camel

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

@Component
class RutaCamel extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("timer:${this.getClass().getCanonicalName()}").to("log:${new Date().format('dd-MM-YYYY')}?level=INFO&groupInterval=5000")
	}

}
