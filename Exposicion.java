/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Exposicion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernandogupioc
 */
public class Exposicion {

    public static void main(String[] args) {
   

        // Crear un estudiante
        Estudiante estudiante1 = new Estudiante("Jairo", 18, "Ingles");
        
        // Crear un profesor
        Profesor profesor1 = new Profesor("Katia Leon", 55, "Ingles");
        
        // Crear una universidad
        Universidad universidad = new Universidad("Universidad Uchill");
        
        // Agregar el estudiante y el profesor a la universidad
        universidad.agregarEstudiante(estudiante1);
        universidad.agregarProfesor(profesor1);
        
        // Crear un curso
        Curso curso1 = new Curso("Inlges");
        
        // Agregar el profesor y los estudiantes al curso
        curso1.setProfesor(profesor1);
        curso1.agregarEstudiante(estudiante1);
        
        // Agregar el curso a la universidad
        universidad.agregarCurso(curso1);
        
        // Mostrar información de la universidad
        universidad.mostrarInformacion();
    }
}

class Persona {
    private String nombre;
    private int edad;
    
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getEdad() {
        return edad;
    }
}

class Estudiante extends Persona {
    private String programa;
    
    public Estudiante(String nombre, int edad, String programa) {
        super(nombre, edad);
        this.programa = programa;
    }
    
    public String getPrograma() {
        return programa;
    }
}

class Profesor extends Persona {
    private String especialidad;
    
    public Profesor(String nombre, int edad, String especialidad) {
        super(nombre, edad);
        this.especialidad = especialidad;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }
}

class Universidad {
    private String nombre;
    private List<Estudiante> estudiantes;
    private List<Profesor> profesores;
    private List<Curso> cursos;
    
    public Universidad(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }
    
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
    
    public void agregarProfesor(Profesor profesor) {
        profesores.add(profesor);
    }
    
    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }
    
    public void mostrarInformacion() {
        System.out.println("Universidad: " + nombre);
        System.out.println("Estudiantes:");
        for (Estudiante estudiante : estudiantes) {
            System.out.println("- Nombre: " + estudiante.getNombre() + " Edad: " + estudiante.getEdad() + " Programa: " + estudiante.getPrograma());
        }
        System.out.println("Profesores:");
        for (Profesor profesor : profesores) {
            System.out.println("- Nombre: " + profesor.getNombre() + " Edad: " + profesor.getEdad() + " Especialidad: " + profesor.getEspecialidad());
        }
        System.out.println("Cursos:");
        for (Curso curso : cursos) {
            System.out.println("- Nombre: " + curso.getNombre() + " Profesor: " + curso.getProfesor().getNombre());
            System.out.println("Estudiantes:");
            for (Estudiante estudiante : curso.getEstudiantes()) {
                System.out.println("-- Nombre: " + estudiante.getNombre());
            }
        }
    }
}

class Curso {
    private String nombre;
    private Profesor profesor;
    private List<Estudiante> estudiantes;
    
    public Curso(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public Profesor getProfesor() {
        return profesor;
    }
    
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
    
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}