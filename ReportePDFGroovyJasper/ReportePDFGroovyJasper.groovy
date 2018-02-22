@GrabResolver(name='commons-lang3', root='https://repo.maven.apache.org/maven2')
@Grapes(
    [@Grab(group='net.sf.jasperreports', module='jasperreports', version='6.5.1'),
    @GrabExclude(group = 'commons-lang', module='commons-lang'),
    @Grab(group='org.apache.commons', module='commons-lang3', version='3.7'),
    @Grab(group='com.lowagie', module='itext', version='2.1.7')
    ]
)

import net.sf.jasperreports.engine.*
import net.sf.jasperreports.engine.export.JRPdfExporter
println "Generando PDF ${new Date()}"
def param = [:]
//String reportJasper = JasperCompileManager.compileReportToFile("/home/mt/JaspersoftWorkspace/MyReports/PruebaGroovy.jrxml")
JasperPrint jasperPrint = JasperFillManager.fillReport("/home/mt/JaspersoftWorkspace/MyReports/PruebaGroovy.jasper", param, new JREmptyDataSource())

JRExporter exporter = new JRPdfExporter()
exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint)
exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File("PDF.pdf"))
exporter.exportReport()