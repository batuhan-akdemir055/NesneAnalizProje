package com.company;

public class Sicaklikİslemleri {

    private int sicaklik;
    ISubject publisher;


    public Sicaklikİslemleri(int sicaklik, ISubject publisher){
        this.sicaklik=sicaklik;
        this.publisher=publisher;
    }



    public void mesaj(int sicaklik ){

        publisher.notify("Sıcaklık : "+ sicaklik);
    }




}
