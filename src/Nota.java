public class Nota {
    private int id;
    private double valor;
    private int porcentaje;

    public Nota(int id, double valor, int porcentaje) {
        this.id = id;
        this.valor = valor;
        this.porcentaje = porcentaje;
    }

    public double getValor() {
        return valor;
    }

    public int getPorcentaje() {
        return porcentaje;
    }
}
