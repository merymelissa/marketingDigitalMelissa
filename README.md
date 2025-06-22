# Marketing Digital 2024-2025



# Proyecto De Marketing Digital Repetidawres

<br>

<img src="https://github.com/merymelissa/marketingDigitalMelissa/blob/main/MelissaVeliz-Proyecto/Actividades/LDM/logo%20proyecto.png" alt="LogoProyecto" width="150" height="120"/>



## ÍNDICE



1. Introducción al proyecto

2. Justificación

3. Objetivos

4. Pasos a seguir

5. Integrantes



1.Introducción al proyecto



Este es un proyecto relacionado con la creación de una aplicación que gestiona campañas de Marketing digital al gusto del cliente.



2.Justificación



Debido a la creciente importancia del marketing digital en la promoción empresarial es cuando surge la necesidad de crear herramientas para la gestión de campañas y de análisis digitales.  



3.Objetivos



El objetivo general de este proyecto es diseñar y desarrollar una aplicación web que facilite la gestión de los datos, la creación de campañas a medida y la presentación de informes.





4.Pasos a seguir



4.1 Identificamos las entidades y nos asignamos los departamentos a los miembros del equipo.



4.2 Creamos el modelo relacional a mano con los atributos y relaciones y después lo pasamos a limpio en la web Miro.

[E-R](https://github.com/merymelissa/marketingDigitalMelissa/blob/main/MelissaVeliz-Proyecto/Actividades/BD/E-R%20Marketing%20Digital.pdf)  



4.3 Hicimos Los casos de uso de nuestros subsistemas y los juntamos

[C.U](https://github.com/merymelissa/marketingDigitalMelissa/blob/main/MelissaVeliz-Proyecto/Actividades/EDE/DIAGRAMAS/CU/CasosDeUso.png)



*Los casos de uso, sirven para describir qué puede hacer un usuario en un sistema y cómo el sistema responde.



4.4 Y seguidamente juntamos nuestro diagrama de Clases

[D.C](https://github.com/merymelissa/marketingDigitalMelissa/blob/main/MelissaVeliz-Proyecto/Actividades/EDE/DIAGRAMAS/DCLASES/DCLASES.png)



*Un DC representa las clases que tiene un programa, sus atributos, métodos y cómo estos se relacionan entre sí.

&nbsp;  

Lo que nos ayuda a organizar el código y entender mejor la estructura de todo el sistema, antes de ponerse a programar.



4.5 Tocaba ponerse con el código Java, para empezar a hacer funcionar por partes los subsistemas del proyecto.

```java
public static void añadirCampaña(Campaña campaña) {
        campañas.add(campaña);
    }

 public void mostrarCampaña() {
        for (int i = 0; i < campañas.size(); i++) {
            System.out.println(campañas.get(i));
        }
    }

```

* En este pequeño bloque de Código de una de las clases, se ven dos métodos en la que una añade campañas y la otra muestra las campañas creadas.



4.6  Y para acabar con este pequeño resumen, en este enlace

[WF](https://github.com/merymelissa/marketingDigitalMelissa/blob/main/MelissaVeliz-Proyecto/Actividades/LDM/Wireframe%20Melissa\_Actualizado.pdf)



Se muestra una pestaña de lo que acabará siendo la página web, esto es sólo un Wireframe, un boceto que se le enseña al cliente para saber si es de su agrado o no, y proceder a realizar la web. :cartwheeling: :cartwheeling: :cartwheeling:



5. Integrantes

 * Miriam Guisado
 * Paco Olmo
 * Jorge Quetglas
 * Richard Rebull
 * Melissa Veliz



