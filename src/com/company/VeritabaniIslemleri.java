package com.company;

public class VeritabaniIslemleri implements  IKullaniciDogrula{
    IKullaniciDogrula veritabani;

    public VeritabaniIslemleri(IKullaniciDogrula veritabani) {
        this.veritabani = veritabani;
    }

    @Override
    public boolean kullaniciDogrula(String kullaniciAd, String sifre) {

        System.out.println("Veritabanına bağlanılıyor...");
        return  veritabani.kullaniciDogrula(kullaniciAd,sifre);
    }
}
