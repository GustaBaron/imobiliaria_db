package br.com.imobiliaria_db;

import java.util.Date;

public class Contrato {
    private int id;
    private int imovel_id;
    private int cliente_id;
    private double valor_mensal;
    private Date data_inicial;
    private Date data_final;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImovel_id() {
        return imovel_id;
    }

    public void setImovel_id(int imovel_id) {
        this.imovel_id = imovel_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public double getValor_mensal() {
        return valor_mensal;
    }

    public void setValor_mensal(double valor_mensal) {
        this.valor_mensal = valor_mensal;
    }

    public Date getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(Date data_inicial) {
        this.data_inicial = data_inicial;
    }

    public Date getData_final() {
        return data_final;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }
}
