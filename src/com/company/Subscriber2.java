package com.company;

public class Subscriber2 implements IObserver{

    @Override
    public void update(String mesaj) {
        System.out.println(mesaj+" ---> Güncel sıcaklık veritabanına kaydedildi " );
    }
}
