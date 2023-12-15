/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Examen2LabProgra2;

/**
 *
 * @author Admin
 */
public class Entry {
    
    String username;
    long pos;
    Entry siguiente;
    
    public Entry(String username, long pos){
        this.username=username;
        this.pos=pos;
        siguiente=null;
    }
    
}
