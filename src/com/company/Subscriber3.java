package com.company;

public class Subscriber3 implements  IObserver{
    @Override
    public void update(String mesaj) {
        System.out.println(mesaj+" ---> Güncel sıcaklık ; kritik sıcaklık kontrol merkezine mesaj gönderildi " );
    }
}
