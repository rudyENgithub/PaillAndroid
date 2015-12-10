package com.rudysorto.inventario;

import com.rudysorto.inventario.com.rudysorto.inventario.entitys.AppMoviles;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;

import java.util.ArrayList;
import java.util.List;



import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;
import org.ksoap2.transport.HttpTransportSE;


public class WebServiceEJB {

    //Namespace of the Webservice - can be found in WSDL

    //Webservice URL - WSDL File location

    //SOAP Action URI again Namespace + Web method name

    // Metodo que queremos ejecutar en el servicio web

    private static final String SOAP_ACTION = "http://ws.rudysorto.com/selectLike";
    private static final String METHOD_NAME = "selectLike";
    private static final String NAMESPACE = "http://ws.rudysorto.com/";
    private static final String URL = "http://192.168.16.4:8080/PaillMoviles-war/AppsMovilesWS?WSDL";
    // Namespace definido en el servicio web
    //private static final String namespace = "http://www.webserviceX.NET";
    // namespace + metodo
    //private static final String accionSoap = "http://www.webserviceX.NET/GetCitiesByCountry";
    // Fichero de definicion del servcio web
    //private static final String url = "http://www.webservicex.net/globalweather.asmx";

    public static List<String> invokeHelloWorldWS(String name, String webMethName) {
        //	List<String> resTxt = new  List<String> ;
        List<String> resTxt = new ArrayList<String>();
        // Create request
        SoapObject request = new SoapObject(NAMESPACE, webMethName);
        request.addProperty("par", name); // Paso parametros al WS

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
        //	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        AndroidHttpTransport transp = new AndroidHttpTransport(URL);

        try {
            // Invoke web service
            transp.call(SOAP_ACTION+METHOD_NAME, envelope);
            // Get the response
            //SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            SoapObject primitive= (SoapObject) envelope.bodyIn;
            // Assign it to resTxt variable static variable
            //	resTxt = response.toString();
            //	resTxt = (List<Tproducto>) response;

            System.out.println("List+++++++++++++++++");
            for(int i=1;i<primitive.getPropertyCount();i++){
                //	 resTxt.add((String) primitive.getProperty(i));
                //arraylist.add(primitive.getPropertyCount());
                //  System.out.println("ForLoop--------------"+primitive.getProperty(i));
                SoapObject obj3 =(SoapObject) primitive.getProperty(i);
                // int id= Integer.parseInt(obj3.getProperty(0).toString());
                String nombre = obj3.getProperty(2).toString();
                resTxt.add(nombre);
                //  System.out.println("ForLoop--------------"+primitive.getProperty(i));
                System.out.println("ForLoop--------------"+nombre);
                // System.out.println("is result null????????????"+arrayList.listIterator());
            }


        } catch (Exception e) {

            System.out.println("Error Value XXX=" + e);
            //resText="Error Occur";
            e.printStackTrace();
        }
        System.out.println("XXXX" + resTxt + "XXXX");
        //Return resTxt to calling object
        return resTxt;
    }


    public static List<AppMoviles> invokeHelloWorldWSReload(String name, String webMethName) {
        //	List<String> resTxt = new  List<String> ;
        List<AppMoviles> resTxt = new ArrayList<AppMoviles>();

        // Create request
        SoapObject request = new SoapObject(NAMESPACE, webMethName);
        request.addProperty("par", name); // Paso parametros al WS

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
        //	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        AndroidHttpTransport transp = new AndroidHttpTransport(URL);

        try {
            // Invoke web service
            transp.call(SOAP_ACTION+METHOD_NAME, envelope);
            // Get the response
            //SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            SoapObject primitive= (SoapObject) envelope.bodyIn;
            // Assign it to resTxt variable static variable
            //	resTxt = response.toString();
            //	resTxt = (List<Tproducto>) response;
            System.out.println("RR");
            System.out.println("RR" + primitive.getPropertyCount());
            System.out.println("List+++++++++++++++++");
            for(int i=0;i<primitive.getPropertyCount();i++){
                //	 resTxt.add((String) primitive.getProperty(i));
                //arraylist.add(primitive.getPropertyCount());
                //  System.out.println("ForLoop--------------"+primitive.getProperty(i));
                SoapObject obj3 =(SoapObject) primitive.getProperty(i);
                // int id= Integer.parseInt(obj3.getProperty(0).toString());
                String nombre = obj3.getProperty(2).toString();
               int id = Integer.parseInt(obj3.getProperty(1).toString());
                String descripcion = obj3.getProperty(0).toString();

                resTxt.add(new AppMoviles(id, nombre, descripcion));
                //  System.out.println("ForLoop--------------"+primitive.getProperty(i));
                System.out.println("ForLoop--------------"+id+ "-" +nombre+"-"+descripcion);
                // System.out.println("is result null????????????"+arrayList.listIterator());
            }



        } catch (Exception e) {

            System.out.println("Error Value XXX=" + e);
            //resText="Error Occur";
            e.printStackTrace();
        }
        System.out.println("XXXX" + resTxt + "XXXX");
        //Return resTxt to calling object
        return resTxt;
    }

}

