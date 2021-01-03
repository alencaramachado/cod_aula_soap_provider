package dao;
import model.Carro;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
public class CarroDAO {

    private Map<String, Carro> CARROS = new LinkedHashMap<String, Carro>();

    public CarroDAO(){
        CARROS.put("C1", new Carro(1, "Corsa", "CHEVROLET"));
        CARROS.put("C2", new Carro(2, "Cruze", "CHEVROLET"));
        CARROS.put("C3", new Carro(3, "Opala", "CHEVROLET"));
        CARROS.put("C4", new Carro(4, "Fusca", "VOLKSWAGEN"));
        CARROS.put("C5", new Carro(5, "Tempra", "FIAT"));
        CARROS.put("C6", new Carro(6, "X1", "BMW"));
    }

    public List<Carro> getCarros(){
        return new ArrayList<Carro>(CARROS.values());
    }

    public Carro cadastrar(Carro c, String chave){
        CARROS.put(chave, c);
        return  c;
    }


}
