/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snooker;

/**
 *
 * @author Soma
 */
public class SnookerAdatok 
{
    //Helyezes;Nev;Orszag;Nyeremeny
    public int Helyezes;
    public String Nev;
    public String Orszag;
    public int Nyeremeny;

    public SnookerAdatok(int Helyezes, String Nev, String Orszag, int Nyeremeny) 
    {
        this.Helyezes = Helyezes;
        this.Nev = Nev;
        this.Orszag = Orszag;
        this.Nyeremeny = Nyeremeny;
    }

    public int getHelyezes() {
        return Helyezes;
    }

    public String getNev() {
        return Nev;
    }

    public String getOrszag() {
        return Orszag;
    }

    public int getNyeremeny() {
        return Nyeremeny;
    }
}
