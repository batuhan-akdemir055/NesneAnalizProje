package com.company;

public class MerkeziIslemBirimi implements  IMerkeziIslemBirimi   {

  boolean dogrula=false;

  IKullaniciDogrula kullaniciDogrulaPostgreSQL = new PostgreSQLKullaniciDogrulama();
  IKullaniciDogrula veritabaniSurucusu = new VeritabaniIslemleri(kullaniciDogrulaPostgreSQL);

  SicaklikAlgilayici sicaklikAlgilayici = new SicaklikAlgilayici();
  IEyleyici eyleyici = new Eyleyici();

    @Override
    public boolean kullaniciDogrulama(String kullaniciAd, String sifre) {

        dogrula= veritabaniSurucusu.kullaniciDogrula(kullaniciAd,sifre);
        return  dogrula;
    }

    @Override
    public int sicaklikAlgilayiciTetikle() {
       return sicaklikAlgilayici.sicaklikOku();

    }

    @Override
    public void eyleyiciyiTetikle(int secim) {

      if(secim==2){
        eyleyici.sogutucuyuAc();
      }

      if(secim==3){
        eyleyici.sogutucuKapat();
      }
    }

  @Override
  public void sicaklikAyarla(int sicaklik) {
    int yeniSicaklik = eyleyici.sicaklikAyarla(sicaklik);
    sicaklikAlgilayici.setSicaklik(yeniSicaklik);

  }

  @Override
  public boolean sogutucuAcikMi() {
    return eyleyici.sogutucuAcikMi();
  }


}
