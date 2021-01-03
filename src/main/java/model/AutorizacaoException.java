package model;

import javax.xml.ws.WebFault;

@WebFault(name = "AutorizacaoFault")
public class AutorizacaoException extends Exception{

    private String token;

    public AutorizacaoException(String msg){
        super(msg);
        this.token = msg;
    }

    public String getFaultInfo(){
        return "Token: "+this.token+" INVÁLIDO";
    }

}
