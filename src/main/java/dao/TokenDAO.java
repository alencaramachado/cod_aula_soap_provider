package dao;

import model.AutorizacaoException;
import model.TokenUsuario;
import model.Usuario;

import java.util.*;

public class TokenDAO {

    // Tabela hash que mante a inf de quais tokens validos
    private static final Map<String, TokenUsuario> TOKEN_VALIDOS =
            new LinkedHashMap<String, TokenUsuario>();

    static final long UM_MINUTO_EM_MILLIS = 60000;

    public String gerarTokenValido(Usuario usuario){

        Calendar horaAtual = Calendar.getInstance();
        long tempo = horaAtual.getTimeInMillis();
        Date tempoAdicionado1min = new Date(tempo + (1*UM_MINUTO_EM_MILLIS));

        Random gerador = new Random();
        String tokenTemp = String.valueOf(gerador.nextFloat());
        TokenUsuario tUs = new TokenUsuario(tokenTemp, tempoAdicionado1min, usuario);
        TOKEN_VALIDOS.put(tokenTemp, tUs);
        return tokenTemp;
    }

    public boolean eValido(String token) throws AutorizacaoException{

        Date dAtual = new Date();

        TokenUsuario tokenUsuario = TOKEN_VALIDOS.get(token);
        try{
            if(dAtual.compareTo(tokenUsuario.getValidade())> 0){
                return false;
            }else if(dAtual.compareTo(tokenUsuario.getValidade()) == 0){
                return true;
            } else if(dAtual.compareTo(tokenUsuario.getValidade()) < 0){
                return true;
            }
        }catch (NullPointerException e){
            throw new AutorizacaoException(token);
        }



        return false;
    }

}
