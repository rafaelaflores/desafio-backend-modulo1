package br.com.southsystem.loja.entities;

public class Sair extends ItemMenu {
        @Override
        public String getOpcao() {
            return "Sair do programa\t\t";
        }
        @Override
        public boolean executar() {
            return true; //adicionar a opção de cancelar, ex: "Você realmente deseja sair do programa?"
    }
}
