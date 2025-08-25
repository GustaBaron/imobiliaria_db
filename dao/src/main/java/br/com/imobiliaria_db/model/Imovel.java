package ImobiliariaSystem.model;

public class Imovel {
    private int id;
    private String endereco;
    private String tipo;
    private int quartos;
    private double valorAluguel;
    private String status;

    public Imovel() {}

    public Imovel(int id, String endereco, String tipo, int quartos, double valorAluguel, String status) {
        this.id = id;
        this.endereco = endereco;
        this.tipo = tipo;
        this.quartos = quartos;
        this.valorAluguel = valorAluguel;
        this.status = status;
    }

    public Imovel(String endereco, String tipo, int quartos, double valorAluguel, String status) {
        this(0, endereco, tipo, quartos, valorAluguel, status);
    }

    // Getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getQuartos() { return quartos; }
    public void setQuartos(int quartos) { this.quartos = quartos; }

    public double getValorAluguel() { return valorAluguel; }
    public void setValorAluguel(double valorAluguel) { this.valorAluguel = valorAluguel; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
