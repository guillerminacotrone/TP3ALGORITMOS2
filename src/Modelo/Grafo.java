package Modelo;

import java.util.*;

// Acá usamos <T> así el grafo puede trabajar con cualquier tipo de dato, no solo Persona.

public class Grafo<T> {

    private List<Nodo<T>> nodos;

    private boolean dirigido;



    public Grafo(boolean dirigido) {

        this.nodos = new ArrayList<>();

        this.dirigido = dirigido;

    }



    public Grafo() {

        this(false);

    }



    public void agregarNodo(Nodo<T> nodo) {

        if (nodo == null) {

            throw new IllegalArgumentException("No se puede agregar un nodo nulo");

        }

        if (!nodos.contains(nodo)) {

            nodos.add(nodo);

        }

    }



    public void agregarArista(Nodo<T> origen, Nodo<T> destino) {

        if (origen == null || destino == null) {

            throw new IllegalArgumentException("Los nodos no pueden ser nulos");

        }

        if (origen.equals(destino)) {

            throw new IllegalArgumentException("No se puede crear una arista de un nodo a sí mismo");

        }



        if (!nodos.contains(origen)) {

            agregarNodo(origen);

        }

        if (!nodos.contains(destino)) {

            agregarNodo(destino);

        }



        origen.agregarAdyacente(destino);



        // En grafos no dirigidos, la arista es bidireccional

        if (!dirigido) {

            destino.agregarAdyacente(origen);

        }

    }



    public List<Nodo<T>> getNodos() {

        return new ArrayList<>(nodos);

    }



    public boolean esDirigido() {

        return dirigido;

    }



    // CONSIGNA: Recorrer el grafo DFS



    public List<Nodo<T>> recorrerDFS(Nodo<T> inicio) {

        if (inicio == null) {

            throw new IllegalArgumentException("El nodo inicial no puede ser nulo");

        }

        if (!nodos.contains(inicio)) {

            throw new IllegalArgumentException("El nodo inicial no pertenece al grafo");

        }



        List<Nodo<T>> resultado = new ArrayList<>();

        Set<Nodo<T>> visitados = new HashSet<>();

        dfsRecursivo(inicio, visitados, resultado);

        return resultado;

    }



    private void dfsRecursivo(Nodo<T> nodo, Set<Nodo<T>> visitados, List<Nodo<T>> resultado) {

        if (visitados.contains(nodo)) {

            return;

        }



        visitados.add(nodo);

        resultado.add(nodo);



        for (Nodo<T> adyacente : nodo.getAdyacentes()) {

            dfsRecursivo(adyacente, visitados, resultado);

        }

    }



    // CONSIGNA: Recorrer el grafo BFS

    public List<Nodo<T>> recorrerBFS(Nodo<T> inicio) {

        if (inicio == null) {

            throw new IllegalArgumentException("El nodo inicial no puede ser nulo");

        }

        if (!nodos.contains(inicio)) {

            throw new IllegalArgumentException("El nodo inicial no pertenece al grafo");

        }



        List<Nodo<T>> resultado = new ArrayList<>();

        Set<Nodo<T>> visitados = new HashSet<>();

        Queue<Nodo<T>> cola = new LinkedList<>();



        visitados.add(inicio);

        cola.offer(inicio);



        while (!cola.isEmpty()) {

            Nodo<T> nodoActual = cola.poll();

            resultado.add(nodoActual);



            for (Nodo<T> adyacente : nodoActual.getAdyacentes()) {

                if (!visitados.contains(adyacente)) {

                    visitados.add(adyacente);

                    cola.offer(adyacente);

                }

            }

        }



        return resultado;

    }



    // CONSIGNA: Crear la matriz de Adyacencia

    public int[][] crearMatrizAdyacencia() {

        int n = nodos.size();

        int[][] matriz = new int[n][n];





        Map<Nodo<T>, Integer> indiceNodo = new HashMap<>();

        for (int i = 0; i < n; i++) {

            indiceNodo.put(nodos.get(i), i);

        }

        for (int i = 0; i < n; i++) {

            Nodo<T> nodoActual = nodos.get(i);

            for (Nodo<T> adyacente : nodoActual.getAdyacentes()) {

                int j = indiceNodo.get(adyacente);

                matriz[i][j] = 1;

            }

        }

        return matriz;

    }



    public void imprimirMatrizAdyacencia() {

        if (nodos.isEmpty()) {

            System.out.println("\n--- Matriz de Adyacencia ---");

            System.out.println("El grafo está vacío");

            return;

        }



        int[][] matriz = crearMatrizAdyacencia();

        int n = nodos.size();



        System.out.println("\n--- Matriz de Adyacencia ---");

        System.out.print("     ");

        for (int i = 0; i < n; i++) {

            System.out.printf("%-15s", "N" + i);

        }

        System.out.println();





        for (int i = 0; i < n; i++) {

            System.out.printf("N%-3d ", i);

            for (int j = 0; j < n; j++) {

                System.out.printf("%-15d", matriz[i][j]);

            }

            System.out.print(" (" + nodos.get(i).getDato() + ")");

            System.out.println();

        }

    }

}