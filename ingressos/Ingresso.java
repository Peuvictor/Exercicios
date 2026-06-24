public class Ingresso {
    protected double valorOriginal;
    protected String nomeFilme;
    protected boolean dublado;

    public Ingresso(double valorOriginal, String nomeFilme, boolean dublado) {
        this.valorOriginal = valorOriginal;
        this.nomeFilme = nomeFilme;
        this.dublado = dublado;
    }

    // Retorna o valor cheio por padrão
    public double getValorReal() {
        return this.valorOriginal;
    }

    public void exibirInformacoes() {
        String idioma = dublado ? "Dublado" : "Legendado";
        System.out.println("Filme: " + nomeFilme + " (" + idioma + ") - Valor a pagar: R$ " + getValorReal());
    }
}
