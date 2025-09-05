class ListaDupla {
    private No inicio;
    private No fim;
    private int tamanho;

    public ListaDupla() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public No getInicio() {
        return inicio;
    }

    public No getFim() {
        return fim;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public void setFim(No fim) {
        this.fim = fim;
    }

    public void incrementarTamanho() {
        tamanho++;
    }

    public void decrementarTamanho() {
        tamanho--;
    }

    public void inserirNoFinal(int valor) {
        No novo = new No(valor);
        if (fim == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
        tamanho++;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void inserirApos(int valorReferencia, int novoValor) {
        No atual = inicio;
        while (atual != null && atual.valor != valorReferencia) {
            atual = atual.proximo;
        }
        if (atual != null) {
            No novo = new No(novoValor);
            novo.proximo = atual.proximo;
            novo.anterior = atual;
            if (atual.proximo != null) {
                atual.proximo.anterior = novo;
            } else {
                fim = novo;
            }
            atual.proximo = novo;
            tamanho++;
        }
    }

    public void imprimir() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}
