package com.company;

public interface IMerkeziIslemBirimi {

     boolean kullaniciDogrulama(String kullaniciAd, String sifre);
     int sicaklikAlgilayiciTetikle();
     void eyleyiciyiTetikle(int secim);
     void sicaklikAyarla(int sicaklik);
     boolean sogutucuAcikMi();


}
