/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author gerne
 */
public class Clubs {
    private int id;
    private String nombreDelClub;
    private String director;

    // Constructor
    public Clubs(int id, String nombreDelClub, String director) {
        this.id = id;
        this.nombreDelClub = nombreDelClub;
        this.director = director;
    }

    // Getter y Setter para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y Setter para nombreDelClub
    public String getNombreDelClub() {
        return nombreDelClub;
    }

    public void setNombreDelClub(String nombreDelClub) {
        this.nombreDelClub = nombreDelClub;
    }

    // Getter y Setter para director
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Método toString para representación en cadena de texto
    @Override
    public String toString() {
        return "Club [id=" + id + ", nombreDelClub=" + nombreDelClub + ", director=" + director + "]";
    }
}
