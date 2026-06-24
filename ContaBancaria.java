public class ContaBancaria {
    private double saldo;
    private double limiteChequeEspecial;
    private double chequeEspecialUsado;

    public ContaBancaria(double depositoInicial) {
        this.saldo = depositoInicial;
        this.chequeEspecialUsado = 0;

        if (depositoInicial <= 500.0) {
            this.limiteChequeEspecial = 50.0;
        } else {
            this.limiteChequeEspecial = depositoInicial * 0.5;
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }

    public void consultarChequeEspecial() {
        double disponivel = limiteChequeEspecial - chequeEspecialUsado;
        System.out.println("Limite Total do Cheque Especial: R$ " + limiteChequeEspecial);
        System.out.println("Cheque Especial Disponível: R$ " + disponivel);
        System.out.println("Cheque Especial Usado: R$ " + chequeEspecialUsado);
    }

    public boolean usandoChequeEspecial() {
        return chequeEspecialUsado > 0;
    }

    public void depositar(double valor) {
        if (valor <= 0) return;

        if (usandoChequeEspecial()) {
            // Aplica a taxa de 20% sobre o valor que foi usado
            double taxa = chequeEspecialUsado * 0.20;
            double dividaTotal = chequeEspecialUsado + taxa;

            System.out.println("Cobrando taxa de 20% (R$" + taxa + ") pelo uso do cheque especial.");

            if (valor >= dividaTotal) {
                valor -= dividaTotal;
                chequeEspecialUsado = 0;
                saldo += valor;
            } else {
                // Se o depósito não cobre toda a dívida, abate o que for possível
                chequeEspecialUsado = dividaTotal - valor;
                System.out.println("Depósito não cobriu toda a dívida do cheque especial.");
            }
        } else {
            saldo += valor;
        }
        System.out.println("Depósito realizado. Saldo atual: R$ " + saldo);
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else if (valor <= (saldo + (limiteChequeEspecial - chequeEspecialUsado))) {
            double restante = valor - saldo;
            saldo = 0;
            chequeEspecialUsado += restante;
            System.out.println("Saque realizado utilizando R$ " + restante + " do cheque especial.");
        } else {
            System.out.println("Saldo e limite insuficientes para este saque.");
        }
    }

    public void pagarBoleto(double valor) {
        System.out.println("Tentando pagar boleto de R$ " + valor + "...");
        sacar(valor);
    }
}
