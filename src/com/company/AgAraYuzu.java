package com.company;

public class AgAraYuzu implements  IAgAraYuzu{

    IMerkeziIslemBirimi merkeziIslemBirimi = new MerkeziIslemBirimi();

    String kullaniciAd;
    String sifre;
    boolean dogrula;
    int sicaklik;

    @Override
    public String kullaniciAdAl(String kullanciAd) {
        this.kullaniciAd=kullanciAd;
        return kullanciAd;
    }

    @Override
    public String sifreAl(String sifre) {
       this.sifre=sifre;
       return  sifre;
    }

    @Override
    public boolean kullaniciDogrula() {
      dogrula= merkeziIslemBirimi.kullaniciDogrulama(kullaniciAd,sifre);
      return dogrula;

    }

    @Override
    public void sicaklikGoruntule() {
       sicaklik= merkeziIslemBirimi.sicaklikAlgilayiciTetikle();
    }

    @Override
    public void sicaklikGonder() {
        System.out.println("Ortamın sıcaklığı : "+ sicaklik);
    }

    @Override
    public void sogutucuAc(int secim) {

        merkeziIslemBirimi.eyleyiciyiTetikle(secim);
    }

    @Override
    public void sogutucuKapat(int secim) {
        merkeziIslemBirimi.eyleyiciyiTetikle(secim);
    }

    @Override
    public void sicaklikAyarla(int sicaklik) {
        merkeziIslemBirimi.sicaklikAyarla(sicaklik);
    }

    @Override
    public boolean sogutucuAcikMi() {
        return merkeziIslemBirimi.sogutucuAcikMi();
    }




}
