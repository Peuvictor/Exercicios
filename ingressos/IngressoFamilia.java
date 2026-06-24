public class IngressoFamilia extends Ingresso {
    private int numeroPessoas;

    public IngressoFamilia(double valorOriginal, String nomeFilme, boolean dublado, int numeroPessoas) {
        super(valorOriginal, nomeFilme, dublado);
        if (numeroPessoas <= 0) {
            throw new IllegalArgumentException("O número de pessoas deve ser maior que zero.");
        }
        this.numeroPessoas = numeroPessoas;
    }

    @Override
    public double getValorReal() {
        double valorTotal = this.valorOriginal * this.numeroPessoas;

        // Aplica 5% de desconto se for mais de 3 pessoas
        if (this.numeroPessoas > 3) {
            valorTotal = valorTotal * 0.95;
        }

        return valorTotal;
    }
}
