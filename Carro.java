public class Carro {
    private boolean ligado;
    private int marcha;
    private int velocidade;

    public Carro() {
        this.ligado = false;
        this.marcha = 0;
        this.velocidade = 0;
    }

    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("Carro ligado.");
        } else {
            System.out.println("O carro já está ligado.");
        }
    }

    public void desligar() {
        if (marcha == 0 && velocidade == 0) {
            ligado = false;
            System.out.println("Carro desligado com segurança.");
        } else {
            System.out.println("Erro: Para desligar, o carro deve estar em ponto morto (marcha 0) e velocidade 0.");
        }
    }

    public void acelerar() {
        if (!ligado) {
            System.out.println("Não é possível acelerar: o carro está desligado.");
            return;
        }
        if (marcha == 0) {
            System.out.println("Não é possível acelerar em ponto morto.");
            return;
        }
        if (velocidade >= 120) {
            System.out.println("Velocidade máxima atingida (120 km/h).");
            return;
        }

        if (podeAcelerarNaMarchaAtual()) {
            velocidade++;
            System.out.println("Acelerou. Velocidade atual: " + velocidade + " km/h.");
        } else {
            System.out.println("Limite de velocidade da marcha atingido. Troque a marcha para acelerar mais.");
        }
    }

    public void diminuirVelocidade() {
        if (!ligado) return;

        if (velocidade > 0) {
            velocidade--;
            System.out.println("Desacelerou. Velocidade atual: " + velocidade + " km/h.");
        } else {
            System.out.println("O carro já está parado.");
        }
    }

    public void trocarMarcha(int novaMarcha) {
        if (!ligado) return;

        if (novaMarcha < 0 || novaMarcha > 6) {
            System.out.println("Marcha inválida. Use de 0 a 6.");
            return;
        }

        if (Math.abs(novaMarcha - marcha) != 1 && novaMarcha != marcha) {
            System.out.println("Erro: Não é permitido pular marchas.");
            return;
        }

        if (velocidadePermiteMarcha(novaMarcha)) {
            marcha = novaMarcha;
            System.out.println("Marcha trocada para: " + marcha);
        } else {
            System.out.println("Erro: A velocidade atual (" + velocidade + " km/h) não permite engatar a marcha " + novaMarcha + ".");
        }
    }

    public void virar(String direcao) {
        if (!ligado) return;
        if (velocidade >= 1 && velocidade <= 40) {
            System.out.println("Virou o carro para a " + direcao + ".");
        } else {
            System.out.println("Erro: Só é possível virar com velocidade entre 1 km/h e 40 km/h.");
        }
    }

    public void verificarVelocidade() {
        System.out.println("Velocidade atual: " + velocidade + " km/h (Marcha: " + marcha + ")");
    }

    // Métodos auxiliares para lidar com a ineficiência lógica da regra original
    private boolean podeAcelerarNaMarchaAtual() {
        switch (marcha) {
            case 1: return velocidade < 20;
            case 2: return velocidade < 40;
            case 3: return velocidade < 60;
            case 4: return velocidade < 80;
            case 5: return velocidade < 100;
            case 6: return velocidade < 120;
            default: return false;
        }
    }

    private boolean velocidadePermiteMarcha(int novaMarcha) {
        if (novaMarcha == 0) return true; // Ponto morto aceita qualquer velocidade no mundo real
        switch (novaMarcha) {
            case 1: return velocidade >= 0 && velocidade <= 20;
            case 2: return velocidade >= 20 && velocidade <= 40; // Ajustado para sobrepor com a marcha 1
            case 3: return velocidade >= 40 && velocidade <= 60;
            case 4: return velocidade >= 60 && velocidade <= 80;
            case 5: return velocidade >= 80 && velocidade <= 100;
            case 6: return velocidade >= 100 && velocidade <= 120;
            default: return false;
        }
    }
}
