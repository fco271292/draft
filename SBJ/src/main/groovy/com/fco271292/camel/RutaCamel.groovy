package com.fco271292.camel

import org.apache.camel.Exchange
import org.apache.camel.Processor
import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

@Component
class RutaCamel extends RouteBuilder {
	
	String mensaje = "La hora actual: ${new Date().format('dd-MM-yyyy HH:mm:ss z')}"
	
	@Override
	public void configure() throws Exception {
		from("timer:Temporizador?period=30s")
			/* Se puede configurar el comportamiento de los datos en este punto */
			.process(new Processor() {
			    public void process(Exchange exchange) throws Exception {
					exchange.getIn().setBody(mensaje)
					exchange.getIn().setHeader(Exchange.FILE_NAME,constant("LOG_${new Date().format('yyyyMMdd_HHmmss')}.txt"))
			   }
			})
			//.setHeader(Exchange.FILE_PATH, constant(System.getProperty("user.home")))
			//.setHeader(Exchange.FILE_NAME,constant("LOG_${new Date().format('yyyyMMdd_HHmmss')}.txt"))
			/* Se puede anexar informacion al cuerpo */
			//.setBody().simple(mensaje)
			.to("log:${this.getClass()}?level=INFO")
			.to("file:salida/log")
	}

}
