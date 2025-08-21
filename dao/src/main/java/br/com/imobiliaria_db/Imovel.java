package br.com.imobiliaria_db;

public class Imovel {
    private int id;
    private String endereco;
    private String tipo;
    private String quartos;
    private String banheiro;
    private String area_m2;
    private String preco_base;
    private StatusImovel status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getQuartos() {
        return quartos;
    }

    public void setQuartos(String quartos) {
        this.quartos = quartos;
    }

    public String getBanheiro() {
        return banheiro;
    }

    public void setBanheiro(String banheiro) {
        this.banheiro = banheiro;
    }

    public String getArea_m2() {
        return area_m2;
    }

    public void setArea_m2(String area_m2) {
        this.area_m2 = area_m2;
    }

    public String getPreco_base() {
        return preco_base;
    }

    public void setPreco_base(String preco_base) {
        this.preco_base = preco_base;
    }

    public StatusImovel getStatus() {
        return status;
    }

    public void setStatus(StatusImovel status) {
        this.status = status;
    }
}
