package com.rudysorto.inventario;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class WebService {
    //Namespace of the Webservice - can be found in WSDL

    //Webservice URL - WSDL File location

    //SOAP Action URI again Namespace + Web method name

    // Metodo que queremos ejecutar en el servicio web

    private static final String SOAP_ACTION = "http://paquete_services/getNombreMateria";
    private static final String METHOD_NAME = "getNombreMateria";
    private static final String NAMESPACE = "http://paquete_services/";
    private static final String URL = "http://192.168.1.10:8081/WSPostgresd/dosWebService?WSDL";
    // Namespace definido en el servicio web
    //private static final String namespace = "http://www.webserviceX.NET";
    // namespace + metodo
    //private static final String accionSoap = "http://www.webserviceX.NET/GetCitiesByCountry";
    // Fichero de definicion del servcio web
    //private static final String url = "http://www.webservicex.net/globalweather.asmx";

    public static String invokeHelloWorldWS(String name, String webMethName) {
        String resTxt = null;
        // Create request
        SoapObject request = new SoapObject(NAMESPACE, webMethName);
        request.addProperty("id", name); // Paso parametros al WS

        // Property which holds input parameters
	/*	PropertyInfo sayHelloPI = new PropertyInfo();
		// Set Name
		sayHelloPI.setName("name");
		// Set Value
		sayHelloPI.setValue(name);
		// Set dataType
		sayHelloPI.setType(String.class);
		// Add the property to request object
		request.addProperty(sayHelloPI);*/
        // Create envelope
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        // Set output SOAP object
        envelope.setOutputSoapObject(request);
        // Create HTTP call object
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try {
            // Invoke web service
            androidHttpTransport.call(SOAP_ACTION+METHOD_NAME, envelope);
            // Get the response
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            // Assign it to resTxt variable static variable
            resTxt = response.toString();

        } catch (Exception e) {
            //Print error
            e.printStackTrace();
            //Assign error message to resTxt
            resTxt = "Error occured";
        }
        //Return resTxt to calling object
        return resTxt;
    }
}
