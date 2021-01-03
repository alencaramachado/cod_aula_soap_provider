package ws;


import dao.CarroDAO;
import dao.UsuarioDAO;
import model.AutorizacaoException;
import model.Carro;
import model.ListaCarros;
import model.Usuario;
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
                               @WebParam(name = "chave") String chave,
                               @WebParam(name = "token", header = true) String token)
    throws AutorizacaoException {

        System.out.println("Token: "+token);

        if(UsuarioDAO.tokenDao.eValido(token)){
            this.cDao.cadastrar(carro, chave);
            return carro;
        }else{
            throw new AutorizacaoException(token);
        }

    }



    UsuarioDAO uDao = new UsuarioDAO();


    @WebMethod(operationName = "autenticar")
    @WebResult(name = "token")
    public String autenticar(@WebParam(name = "usuario")Usuario usuario){
        return uDao.autenticar(usuario);
    }

    public String primeiroServico(String valor){
        return "Olá WS Javax.WS: "+valor;
    }

}
