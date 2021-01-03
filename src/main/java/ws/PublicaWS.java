package ws;

import javax.xml.ws.Endpoint;

public class PublicaWS {

    public static void main(String args[]){

        CarroWS wsCarro = new CarroWS();
        String urlCarroWS = "http://localhost:8080/carrows";
        System.out.println(urlCarroWS+"?wsdl");

        Endpoint.publish(urlCarroWS, wsCarro);

    }

}
