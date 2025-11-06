package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Nodo<T> {
    private T dato;
    private List<Nodo<T>> adyacentes;

    public Nodo(T dato) {
        this.dato = dato;
        this.adyacentes = new ArrayList();
    }

    public T getDato() {
        return this.dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public List<Nodo<T>> getAdyacentes() {
        return this.adyacentes;
    }

    public void agregarAdyacente(Nodo<T> nodo) {
        if (nodo == null) {
            throw new IllegalArgumentException("No se puede agregar un nodo adyacente nulo");
        } else {
            if (!this.adyacentes.contains(nodo)) {
                this.adyacentes.add(nodo);
            }

        }
    }

    public void removerAdyacente(Nodo<T> nodo) {
        this.adyacentes.remove(nodo);
    }

    public String toString() {
        return this.dato.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            Nodo<?> nodo = (Nodo)obj;
            return this.dato.equals(nodo.dato);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.dato.hashCode();
    }
}