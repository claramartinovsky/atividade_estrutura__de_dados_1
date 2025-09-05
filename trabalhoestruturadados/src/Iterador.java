class Iterador {
    private No atual;
    private ListaDupla lista;

    public Iterador(ListaDupla lista) {
        this.lista = lista;
        this.atual = lista.getInicio();
    }

    public boolean temProximo() {
        return atual != null && atual.proximo != null;
    }

    public void proximo() {
        if (temProximo()) {
            atual = atual.proximo;
        }
    }

    public void inserirAposAtual(int valor) {
        if (atual != null) {
            No novo = new No(valor);
            novo.proximo = atual.proximo;
            novo.anterior = atual;
            if (atual.proximo != null) {
                atual.proximo.anterior = novo;
            } else {
                lista.setFim(novo);
            }
            atual.proximo = novo;
            lista.incrementarTamanho();
        }
    }

    public void removerAposAtual() {
        if (atual != null && atual.proximo != null) {
            No remover = atual.proximo;
            atual.proximo = remover.proximo;
            if (remover.proximo != null) {
                remover.proximo.anterior = atual;
            } else {
                lista.setFim(atual);
            }
            lista.decrementarTamanho();
        }
    }

    public void inserirAntesAtual(int valor) {
        if (atual != null) {
            No novo = new No(valor);
            novo.anterior = atual.anterior;
            novo.proximo = atual;
            if (atual.anterior != null) {
                atual.anterior.proximo = novo;
            } else {
                lista.setInicio(novo);
            }
            atual.anterior = novo;
            lista.incrementarTamanho();
        }
    }

    public void removerAntesAtual() {
        if (atual != null && atual.anterior != null) {
            No remover = atual.anterior;
            atual.anterior = remover.anterior;
            if (remover.anterior != null) {
                remover.anterior.proximo = atual;
            } else {
                lista.setInicio(atual);
            }
            lista.decrementarTamanho();
        }
    }
}