## ¿Cómo haría para que el grafo sea dirigido?

Para crear un grafo dirigido, se debe pasar `true` al constructor al momento de instanciarlo.

En un grafo dirigido las aristas tienen un solo sentido (dirección), la matriz de adyacencia NO es simétrica, y si A -> B existe, no implica que B -> A exista.

## ¿Se puede recorrer igual?

Sí, los recorridos DFS y BFS se aplican de la misma forma. La única diferencia es que en un grafo dirigido, las aristas se recorren únicamente en la dirección en la que fueron definidas.
