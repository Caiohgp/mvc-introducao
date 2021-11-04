package br.com.caiohenriquedev.domain;

public enum TipoSexo {
    FEMININO('F'),
    MASCULINO('M');

    private char descricao;

    TipoSexo(char descricao) {
        this.descricao = descricao;
    }

    public char getDescricao(){
        return this.descricao;
    }

    @Override
    public String toString() {
        return "TipoSexo{" +
                "descricao=" + descricao +
                '}';
    }
}
