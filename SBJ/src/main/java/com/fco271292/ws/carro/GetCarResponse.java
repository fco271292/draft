//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.11.29 a las 02:10:03 PM CST 
//


package com.fco271292.ws.carro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="carro" type="{http://fco271292.com/ws/carro}carro"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "carro"
})
@XmlRootElement(name = "getCarResponse")
public class GetCarResponse {

    @XmlElement(required = true)
    protected Carro carro;

    /**
     * Obtiene el valor de la propiedad carro.
     * 
     * @return
     *     possible object is
     *     {@link Carro }
     *     
     */
    public Carro getCarro() {
        return carro;
    }

    /**
     * Define el valor de la propiedad carro.
     * 
     * @param value
     *     allowed object is
     *     {@link Carro }
     *     
     */
    public void setCarro(Carro value) {
        this.carro = value;
    }

}
