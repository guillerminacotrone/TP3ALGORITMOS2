import Modelo.Grafo;
import Modelo.Nodo;
import Modelo.Persona;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== TRABAJO PRACTICO III - GRAFOS ===");



        // Crear personas con datos del tipo Persona

        Persona guillermina = new Persona("Guillermina", 28);

        Persona fatima = new Persona("Fatima", 32);

        Persona magali = new Persona("Magali", 25);

        Persona agustina = new Persona("Agustina", 30);

        Persona sofia = new Persona("Sofia", 27);



        // Crear nodos del grafo

        Nodo<Persona> nodoGuillermina = new Nodo<>(guillermina);

        Nodo<Persona> nodoFatima = new Nodo<>(fatima);

        Nodo<Persona> nodoMagali = new Nodo<>(magali);

        Nodo<Persona> nodoAgustina = new Nodo<>(agustina);

        Nodo<Persona> nodoSofia = new Nodo<>(sofia);



        // ========== GRAFO NO DIRIGIDO ==========

        System.out.println("----- Grafo NO DIRIGIDO -----");

        Grafo<Persona> grafoNoDirigido = new Grafo<>(false);



        // Agregar aristas al grafo

        grafoNoDirigido.agregarArista(nodoGuillermina, nodoFatima);

        grafoNoDirigido.agregarArista(nodoFatima, nodoMagali);

        grafoNoDirigido.agregarArista(nodoGuillermina, nodoAgustina);

        grafoNoDirigido.agregarArista(nodoMagali, nodoSofia);

        grafoNoDirigido.agregarArista(nodoAgustina, nodoSofia);



        System.out.println("1. Recorrido DFS (Depth-First Search):");

        List<Nodo<Persona>> dfs = grafoNoDirigido.recorrerDFS(nodoGuillermina);

        for (int i = 0; i < dfs.size(); i++) {

            System.out.println("   " + (i + 1) + ". " + dfs.get(i).getDato());

        }



        System.out.println("2. Recorrido BFS (Breadth-First Search):");

        List<Nodo<Persona>> bfs = grafoNoDirigido.recorrerBFS(nodoGuillermina);

        for (int i = 0; i < bfs.size(); i++) {

            System.out.println("   " + (i + 1) + ". " + bfs.get(i).getDato());

        }



        System.out.println("3. Matriz de Adyacencia:");

        grafoNoDirigido.imprimirMatrizAdyacencia();



        // ========== GRAFO DIRIGIDO ==========

        System.out.println("----- Grafo DIRIGIDO -----");

        Grafo<Persona> grafoDirigido = new Grafo<>(true);



        // Crear nuevos nodos para el grafo dirigido

        Nodo<Persona> nodoGuillerminaDir = new Nodo<>(guillermina);

        Nodo<Persona> nodoFatimaDir = new Nodo<>(fatima);

        Nodo<Persona> nodoMagaliDir = new Nodo<>(magali);

        Nodo<Persona> nodoAgustinaDir = new Nodo<>(agustina);



        // Agregar aristas dirigidas (solo en una dirección)

        grafoDirigido.agregarArista(nodoGuillerminaDir, nodoFatimaDir);

        grafoDirigido.agregarArista(nodoFatimaDir, nodoMagaliDir);

        grafoDirigido.agregarArista(nodoGuillerminaDir, nodoAgustinaDir);

        grafoDirigido.agregarArista(nodoAgustinaDir, nodoFatimaDir);



        System.out.println("1. Recorrido DFS (desde Guillermina):");

        List<Nodo<Persona>> dfsD = grafoDirigido.recorrerDFS(nodoGuillerminaDir);

        for (int i = 0; i < dfsD.size(); i++) {

            System.out.println("   " + (i + 1) + ". " + dfsD.get(i).getDato());

        }



        System.out.println("2. Recorrido BFS (desde Guillermina):");

        List<Nodo<Persona>> bfsD = grafoDirigido.recorrerBFS(nodoGuillerminaDir);

        for (int i = 0; i < bfsD.size(); i++) {

            System.out.println("   " + (i + 1) + ". " + bfsD.get(i).getDato());

        }



        System.out.println("3. Matriz de Adyacencia:");

        grafoDirigido.imprimirMatrizAdyacencia();

    }

}
