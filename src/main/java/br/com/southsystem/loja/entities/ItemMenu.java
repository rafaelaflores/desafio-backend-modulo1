package br.com.southsystem.loja.entities;
import br.com.southsystem.loja.dao.Dao;
import br.com.southsystem.loja.dao.ProdutosDao;
import java.io.IOException;

public abstract class ItemMenu {
    protected Dao dao;
    public ItemMenu() {
        dao = new ProdutosDao(); //criei o objeto dao aqui para não precisar criar em todos
    }
    public abstract String getOpcao();
    public abstract boolean executar() throws IOException; //esses métodos abstratos serão implementados nas classes que estendem ItemMenu
}

