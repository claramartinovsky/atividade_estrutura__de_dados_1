public class Main {
    public static void main(String[] args) {
        int[] vetor = {2, 7, 9, 12, 16, 21, 27, 33, 42, 54};

        System.out.println("Busca binária pelo valor 21:");
        int pos = buscaBinaria(vetor, 21);
        System.out.println("Posição encontrada: " + pos);

        vetor = inserirNoInicio(vetor, 89);
        System.out.println("\nVetor após inserir 89 no início:");
        for (int v : vetor) {
            System.out.print(v + " ");
        }
        System.out.println("\n");

        ListaDupla lista = new ListaDupla();
        for (int val : new int[]{2, 7, 9, 12, 16, 21, 27, 33, 42, 54}) {
            lista.inserirNoFinal(val);
        }
        System.out.println("Tamanho inicial da lista: " + lista.getTamanho());
        lista.imprimir();

        System.out.println("\nInserindo 130 após o valor 21...");
        lista.inserirApos(21, 130);
        lista.imprimir();
        System.out.println("Tamanho da lista: " + lista.getTamanho());

        Iterador it = new Iterador(lista);

        it.proximo(); 
        System.out.println("\nIterador está em: 7");

        System.out.println("Inserindo 200 após o atual (7)...");
        it.inserirAposAtual(200);
        lista.imprimir();
        System.out.println("Tamanho da lista: " + lista.getTamanho());

        it.proximo(); 
        System.out.println("\nIterador está em: 200");

        System.out.println("Removendo nó após o atual (remove 9)...");
        it.removerAposAtual();
        lista.imprimir();
        System.out.println("Tamanho da lista: " + lista.getTamanho());

        System.out.println("\nInserindo 440 antes do atual (200)...");
        it.inserirAntesAtual(440);
        lista.imprimir();
        System.out.println("Tamanho da lista: " + lista.getTamanho());

        System.out.println("\nRemovendo nó antes do atual (remove 440)...");
        it.removerAntesAtual();
        lista.imprimir();
        System.out.println("Tamanho da lista: " + lista.getTamanho());

        System.out.println("\nLista final:");
        lista.imprimir();
    }

    public static int buscaBinaria(int[] vetor, int valor) {
        int inicio = 0, fim = vetor.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (vetor[meio] == valor) return meio;
            if (vetor[meio] < valor) inicio = meio + 1;
            else fim = meio - 1;
        }
        return -1;
    }

    public static int[] inserirNoInicio(int[] vetor, int valor) {
        int[] novo = new int[vetor.length + 1];
        novo[0] = valor;
        for (int i = 0; i < vetor.length; i++) {
            novo[i + 1] = vetor[i];
        }
        return novo;
    }
}