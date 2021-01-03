package dao;

import model.Usuario;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class UsuarioDAO {

    public Map<String, Usuario> USUARIOS = new LinkedHashMap<String, Usuario>();
    public static final TokenDAO tokenDao = new TokenDAO();

    public UsuarioDAO(){
        USUARIOS.put("a1", new Usuario("abc", "123"));
        USUARIOS.put("a2", new Usuario("ale", "1234"));
    }

    public String autenticar(Usuario usAutenticar){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>(USUARIOS.values());

        for(Usuario us : usuarios){
            if(us.getUser().equals(usAutenticar.getUser()) &&
            us.getSenha().equals(usAutenticar.getSenha())){
                    return tokenDao.gerarTokenValido(usAutenticar);
            }else{
                System.out.println("Usuário não autenticado");
            }
        }
        return null;
    }

}
