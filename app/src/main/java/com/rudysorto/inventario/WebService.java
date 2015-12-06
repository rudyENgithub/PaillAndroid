package com.rudysorto.inventario;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class WebService {

    //SOAP_ACTION : DEL WSDL targetNamespace + METODO DEL WS
    //METHOD_NAME : METODO DEL WS
    //NAMESPACE : DEL WSDL targetNamespace
    //URL : URL DEL WSDL SACADO DESDE GLASSFISH
    private static final String SOAP_ACTION = "http://ws/login";
    private static final String METHOD_NAME = "login";
    private static final String NAMESPACE = "http://ws/";
    private static final String URL = "http://192.168.1.10:8081/PAILLSQLSERVER-war/LoginWS?WSDL";


    public static String invokeLoginWS(String uid, String password, String webMethName) {
        String resTxt = null;
        // Create request
        SoapObject request = new SoapObject(NAMESPACE, webMethName);
        request.addProperty("uid", uid); // Paso parametros al WS
        request.addProperty("password", password);

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
