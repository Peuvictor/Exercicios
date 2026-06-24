public class MeiaEntrada extends Ingresso {

    public MeiaEntrada(double valorOriginal, String nomeFilme, boolean dublado) {
        // Chama o construtor da classe mãe
        super(valorOriginal, nomeFilme, dublado);
    }

    @Override
    public double getValorReal() {
        return this.valorOriginal / 2.0;
    }
}
