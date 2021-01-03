package ws;


import dao.CarroDAO;
import model.Carro;
import model.ListaCarros;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService
public class CarroWS {


    private CarroDAO cDao = new CarroDAO();


    @WebMethod(operationName = "todosOsCarros")
    @WebResult(name = "carros")
    public ListaCarros getCarros(){
        return new ListaCarros(cDao.getCarros());
    }


    @WebMethod(operationName = "cadastrar_carro")
    @WebResult(name = "carro")
    public Carro cadastraCarro(@WebParam(name = "carro") Carro carro,
                               @WebParam(name = "chave  ") String chave){
        this.cDao.cadastrar(carro, chave);
        return carro;
    }

    public String primeiroServico(String valor){
        return "Olá WS Javax.WS: "+valor;
    }

}
