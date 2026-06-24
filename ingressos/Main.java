public class Main {
    public static void main(String[] args) {
        // Ingresso comum (Inteira) - R$ 40,00
        Ingresso ingressoComum = new Ingresso(40.0, "O Senhor dos Anéis", false);
        ingressoComum.exibirInformacoes();
        // Esperado: R$ 40.0

        // Meia Entrada - R$ 40,00 (Paga 20)
        Ingresso meia = new MeiaEntrada(40.0, "Matrix", true);
        meia.exibirInformacoes();
        // Esperado: R$ 20.0

        // Ingresso Família (3 pessoas) - Sem desconto extra - 3 x 40 = 120
        Ingresso familiaPequena = new IngressoFamilia(40.0, "Divertida Mente", true, 3);
        familiaPequena.exibirInformacoes();
        // Esperado: R$ 120.0

        // Ingresso Família (4 pessoas) - Com 5% de desconto - (4 x 40) * 0.95 = 152
        Ingresso familiaGrande = new IngressoFamilia(40.0, "Os Vingadores", false, 4);
        familiaGrande.exibirInformacoes();
        // Esperado: R$ 152.0
    }
}
