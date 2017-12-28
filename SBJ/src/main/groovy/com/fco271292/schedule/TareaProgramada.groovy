package com.fco271292.schedule

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class TareaProgramada {
	
	@Scheduled(cron = "0/30 * * * * ?")
	void obtenerHora() {
		println "${'#'*25} Hora Actual ${'#'*25}"
		println new Date().format('d-MM-yyyy HH:mm:ss')
	}
}
