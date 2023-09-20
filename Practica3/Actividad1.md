Actividad1

Menciona los principios de diseno esenciales de los patrones Factory, Abstract Factory y Builder. Menciona
una desventaja de cada patron.
    
    
Factory: El patron Factory es un enfoque de programacion que permite crear objetos sin tener que especificar su clase exacta. Sobre los principios esenciales, el patron Factory utiliza una interfaz o clase base para crear objetos, ademas el proceso de creacion de objetos se encapsula en una clase o metodo separado. El patron Factory permite intercambiar objetos creados sin afectar el codigo que los utiliza. Una desventaja del patron Factory es que puede haber una mayor complejidad en el codigo debido a la necesidad de crear clases adicionales para cada tipo de objeto.


Abstract Factory: El patron Abstract Factory proporciona una abstraccion en la creacion de objetos, lo que permite modificar la implementacion concreta de los objetos sin afectar al codigo que los utiliza. sobre los principios esenciales de este patron, el patron Abstract Factory utiliza una interfaz o clase base para crear familias de objetos relacionados. El patron Abstract Factory permite intercambiar familias de objetos relacionados sin afectar el codigo que los utiliza. Una desventaja del patron Abstract Factory es que puede haber una mayor complejidad en el codigo debido a la necesidad de crear multiples clases de fabrica y productos relacionados ademas Los productos creados por una fabrica abstracta generalmente estan relacionados de alguna manera, lo que puede aumentar el acoplamiento entre ellos. Esto puede dificultar la sustitucion de un producto por otro sin afectar otras partes del codigo.
 

Builder: El patron Builder se utiliza para construir objetos complejos paso a paso. Sobre los principios esenciales, el patron Builder crea una interfaz o clase base para definir los pasos de construccion de un objeto, el proceso de construccion de objetos se encapsula en una clase o metodo separado. El patron Builder permite construir diferentes representaciones de un objeto utilizando los mismos pasos de construccion. Una desventaja del patron Builder es que puede haber una mayor complejidad en el codigo debido a la necesidad de definir multiples clases de constructores y pasos de construccion.
