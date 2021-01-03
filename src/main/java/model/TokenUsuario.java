package model;

import java.util.Date;

public class TokenUsuario {

    private String token;
    private Date validade;
    private Usuario usuario;

    public TokenUsuario( ) {
    }

    public TokenUsuario(String token, Date validade, Usuario usuario) {
        this.token = token;
        this.validade = validade;
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
