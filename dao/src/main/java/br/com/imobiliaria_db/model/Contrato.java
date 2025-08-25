package ImobiliariaSystem.model;

import java.sql.Date;

public class Contrato {
    private int id;
    private double valor;
    private Date dataInicio;
    private Date dataFim;
    private int idImovel;
    private int idCliente;

    public Contrato() {}

    public Contrato(int id, double valor, Date dataInicio, Date dataFim, int idImovel, int idCliente) {
        this.id = id;
        this.valor = valor;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.idImovel = idImovel;
        this.idCliente = idCliente;
    }

    public Contrato(double valor, Date dataInicio, Date dataFim, int idImovel, int idCliente) {
        this(0, valor, dataInicio, dataFim, idImovel, idCliente);
    }

    // Getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public Date getDataInicio() { return dataInicio; }
    public void setDataInicio(Date dataInicio) { this.dataInicio = dataInicio; }

    public Date getDataFim() { return dataFim; }
    public void setDataFim(Date dataFim) { this.dataFim = dataFim; }

    public int getIdImovel() { return idImovel; }
    public void setIdImovel(int idImovel) { this.idImovel = idImovel; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
}
