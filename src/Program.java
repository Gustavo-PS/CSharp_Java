import java.util.Random;

public class Program {
    public static void main(String[] args) {

        int qtd = 0;
        boolean chave = false;

        System.out.println("\nOla,\nQuantos alunos deseja cadastrar?");

        do {
            try {
                qtd = Integer.parseInt(System.console().readLine());
                chave = true;
            } catch (Exception x) {
                System.out.println("Digite um valor valido");
            }

            if (qtd <= 1)
                System.out.println("Digite um numero maior ou igual a 2");
        } while (!chave || qtd <= 1);
        chave = false;

        int[] vetRA = new int[qtd];

        limparTela();

        for (int i = 0; i < vetRA.length; i++) {
            System.out.println("Digite o RA do " + (i + 1) + " aluno");

            do {
                try {
                    vetRA[i] = Integer.parseInt(System.console().readLine());
                    chave = true;
                } catch (Exception x) {
                    System.out.println("Digite um RA valido");
                    chave = false;
                }

            } while (!chave);
        }
        String[] retorno = new String[(qtd / 2) + 1];

        limparTela();
        sorteio(vetRA, qtd, retorno);
        System.out.println("\nO sorteio final ficou da seguinte forma: \n\n");

        for (int i = 0; i < retorno.length - 1; i++) {
            System.out.println(retorno[i]);
        }
    }

    static String[] sorteio(int[] vetRA, int qtd, String[] retorno) {
        Random gerador = new Random();
        int RANow;
        int sorteio;
        String duplas = "";
        String trio = "";
        int index = 0;

        if (vetRA.length % 2 != 0) {
            for (int i = 0; i < 3; i++) {
                sorteio = gerador.nextInt(vetRA.length);
                RANow = vetRA[sorteio];
                if (RANow == -1) {
                    do {
                        sorteio = gerador.nextInt(vetRA.length);
                        RANow = vetRA[sorteio];

                    } while (RANow == -1);
                }
                vetRA[sorteio] = -1;
                trio = RANow + ";" + trio;
            }

            for (int i = 0; i < vetRA.length - 3; i++) 
            {
                sorteio = gerador.nextInt(vetRA.length);
                RANow = vetRA[sorteio];
                if (RANow == -1) {
                    do {
                        sorteio = gerador.nextInt(vetRA.length);
                        RANow = vetRA[sorteio];

                    } while (RANow == -1);
                }

                vetRA[sorteio] = -1;

                duplas = duplas + RANow + ";";

                if (i >= 1 && i % 2 != 0) {

                    retorno[index] = duplas;
                    index++;
                    duplas = "";
                }
            }
        } else {
            for (int i = 0; i < vetRA.length; i++) {
                sorteio = gerador.nextInt(vetRA.length);
                RANow = vetRA[sorteio];
                if (RANow == -1) {
                    do {
                        sorteio = gerador.nextInt(vetRA.length);
                        RANow = vetRA[sorteio];

                    } while (RANow == -1);
                }

                vetRA[sorteio] = -1;

                duplas = duplas + RANow + ";";

                if (i >= 1 && i % 2 != 0) {

                    retorno[index] = duplas;
                    index++;
                    duplas = "";
                }
            }
        }
        retorno[index] = trio;
        return retorno;
    }

    static void limparTela() {
        System.out.flush();
    }
}
