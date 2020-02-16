/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snooker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Soma
 */
public class Snooker {

    /**
     * @param args the command line arguments
     */
    static ArrayList<SnookerAdatok> SnookerList=new ArrayList<>();
    static ArrayList<String> OrszagokList= new ArrayList<>();
    public static void main(String[] args)
    {
        System.out.println("\n-----------------------\n");
        Feladat2Beolvasas();
        System.out.println("\n-----------------------\n");
        Feladat3VersenyzokSzam();
        System.out.println("\n-----------------------\n");
        Feladat4AtlagNyeremeny();
        System.out.println("\n-----------------------\n");
        Feladat5LegjobbKinai();
        System.out.println("\n-----------------------\n");
        Feladat6NorvegVersenyzo();
        System.out.println("\n-----------------------\n");
        Fladat7Statisztika();
    }

    private static void Feladat2Beolvasas() 
    {
        System.out.println("1.Feladat: Adatok beolvasása");
        try 
        {
            System.setProperty("file.encodig", "UTF8");
            FileReader fajl=new FileReader("snooker.txt");
            int db=0;
            try(BufferedReader br=new BufferedReader(fajl))
            {
                int i= 0;
                String sor=null;
                while((sor=br.readLine())!=null)
                {
                    String[] dbok=sor.split(";");
                   int Helyezes=Integer.parseInt(dbok[0]);
                   String Nev=dbok[1];
                   String Orszag=dbok[2];
                   int Nyeremeny=Integer.parseInt(dbok[3]);
                   SnookerAdatok SA=new SnookerAdatok(Helyezes, Nev, Orszag, Nyeremeny);
                   SnookerList.add(SA);
                   db++;
                }
                if(db>0)
                {
                    System.out.println("\tSikeres beolvasás");
                    System.out.println("\tBeolvasott adatok száma: "+db);
                }
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Hiba: "+e);
        }
    }

    private static void Feladat3VersenyzokSzam()
    {
        System.out.println("3.Feladat: Versenyzők száma");
        System.out.println("\tVersenyzők száma: "+SnookerList.size());
    }

    private static void Feladat4AtlagNyeremeny() 
    {
        System.out.println("4.Feladat: Versenyzők átlag nyereménye az adott időszakban");
        double Osszeg=0;
        double Atlag=0;
        int db=0;
        for (SnookerAdatok snookerAdatok : SnookerList)
        {   db++;
            Osszeg+=snookerAdatok.Nyeremeny;
            Atlag=(Osszeg/db);
        }
        System.out.println("\tA versenyzők átlag nyereménye: "+Atlag);
        
        
    }

    private static void Feladat5LegjobbKinai() 
    {
        System.out.println("5.Feladat: A legjobb Kínai versenyző");
       String MAxNEv="cica";
       int MaxNyeremeny=0;
       int MaxHelyezes=0;
       int NyeremenyErtek=0;
        for (int i = 0; i < SnookerList.size(); i++)
        {
            if(SnookerList.get(i).Orszag.contains("Kína") && MaxNyeremeny<SnookerList.get(i).Nyeremeny )
            {
                MaxNyeremeny=SnookerList.get(i).Nyeremeny;
                MAxNEv=SnookerList.get(i).Nev;
                MaxHelyezes=SnookerList.get(i).Helyezes;
                NyeremenyErtek=MaxNyeremeny*380;
            }            
        }
        System.out.println("\tHelyezés: "+MaxHelyezes);
        System.out.println("\tNév: "+MAxNEv);
        System.out.println("\tOrszág: Kína");
        System.out.println("\tNyeremény összege: "+NyeremenyErtek);
    }

    private static void Feladat6NorvegVersenyzo()
    {
        System.out.println("6.Feladat: Volt Norvég versenyző a listában?");
        int db=0;
        for (int i = 0; i < SnookerList.size(); i++) 
        {
            if(SnookerList.get(i).Orszag.contains("Norvégia"))
            {
                db++;
            }
            
        }
        if(db>0)
        {
            System.out.println("\tVolt Norvég versenyő a listán");
        }
        else
        {
            System.out.println("\tNem volt Norvég versenyő a listán");
        }
    }

    private static void Fladat7Statisztika()
    {
        System.out.println("7.Feladat: Országok statisztikája");
        for (SnookerAdatok snookerAdatok : SnookerList) 
        {
            if(!OrszagokList.contains(snookerAdatok.Orszag))
            {
              OrszagokList.add(snookerAdatok.Orszag);
            }
        }
        for (int i = 0; i < OrszagokList.size(); i++)
        {
            //System.out.println("\t "+OrszagokList.get(i));
            
        }
      
        for (int i = 0; i < OrszagokList.size(); i++) 
        {
           int db=0;
           for (int j = 0; j < SnookerList.size(); j++)
           {
             if(SnookerList.get(j).Orszag.contains(OrszagokList.get(i)))
             {
               db++;
             }                          
           } 
           System.out.println("\t"+OrszagokList.get(i)+" : " +db);   
        }
    }
    
}
