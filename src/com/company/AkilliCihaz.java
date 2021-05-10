package com.company;

import java.util.Scanner;

public class AkilliCihaz {

    public void basla(){
        String kullaniciAd ;
        String sifre;
        int menuSecim;
        String secim=null;


        IAgAraYuzu agAraYuzu = new AgAraYuzu();
        System.out.println("Akıllı cihaz açılıyor...");
        Scanner tara = new Scanner(System.in);
        System.out.println("Lütfen kullanıcı adınızı ve şifrenizi giriniz :");
        kullaniciAd= tara.nextLine();
        sifre=tara.nextLine();

        agAraYuzu.kullaniciAdAl(kullaniciAd);
        agAraYuzu.sifreAl(sifre);

        if(agAraYuzu.kullaniciDogrula()){
            do {
                menuGoster();
                menuSecim= tara.nextInt();

                switch (menuSecim){

                    case 1:
                        sicaklikGoruntule(agAraYuzu); break;

                    case 2:
                        sogutucuAc(agAraYuzu, menuSecim);   break;

                    case 3:
                        sogutucuyuKapat(agAraYuzu,menuSecim); break;

                    case 4:
                        if(agAraYuzu.sogutucuAcikMi()){

                            System.out.println("Lütfen ayarlamak istediğniz sıcaklığı giriniz :");
                            int sicaklıkGuncel=tara.nextInt();
                            sicaklikAyarla(agAraYuzu,sicaklıkGuncel);
                        }
                        else{
                            System.out.println("Soğutucu açılmadan sıcaklık ayarlanamaz...");
                        }
                        break;
                    case 5:
                        otomatikKapatmaSuresiAyarla();
                        break;

                    case 6:
                        cikis();
                        break;

                    default:
                        System.out.println("Hatalı seçim");
                        System.out.println("Menü tekrar gösteriliyor");
                        break;
                }
                tara.nextLine();
                System.out.println("Devam etmek istiyor musunuz ?");
                secim=tara.nextLine();

                if(!secim.equals("E")) cikis();
            }while (secim.equalsIgnoreCase("E"));
        }

        else{
            System.out.println("Kullanıcı adınız veya şifreniz hatalı ! Lütfen tekrar deneyin");
        }
    }

    private void otomatikKapatmaSuresiAyarla() {
        Scanner tara = new Scanner(System.in);
        System.out.println("Soğutucunuzu kaç dakika sonra otomatik kapanmasını istiyorsunuz ? ");
        int dakika = tara.nextInt();
        System.out.println("Soğutucunuz kapandıktan sonra renginin ne olmasını istersiniz ?");
        tara.nextLine();
        String renk =tara.nextLine();

        BuilderOtomatikKapatma b1 = new BuilderOtomatikKapatma.OtomatikKapaBuilder(dakika).renk(renk).build();
        if(BuilderOtomatikKapatma.renkVeritabani.contains(renk)){
            System.out.println(b1.getDakika()+"  dakika sonra soğutucunuz kapanacaktır ve rengi --->  "+ b1.getRenk()+ " olacaktır");
        }
        else{
            System.out.println("İstediğniz renk veritabanımızda kayıtlı değildir...");
        }

    }

    private static void sicaklikGoruntule(IAgAraYuzu agAraYuzu) {
        agAraYuzu.sicaklikGoruntule();
        agAraYuzu.sicaklikGonder();
    }

    private static void sogutucuyuKapat(IAgAraYuzu agAraYuzu, int secim) {
        agAraYuzu.sogutucuKapat(secim);
    }

    private static void sogutucuAc(IAgAraYuzu agAraYuzu,int secim) {
        agAraYuzu.sogutucuAc(secim);
    }

    private static void cikis(){
        System.out.println("Akıllı cihaz kapanıyor...");
        System.exit(0);
    }

    private  static  void sicaklikAyarla(IAgAraYuzu agAraYuzu , int sicaklik){
        agAraYuzu.sicaklikAyarla(sicaklik);
    }

    private static  void menuGoster(){
        System.out.println("**************************************");
        System.out.println("Lütfen yapmak istediğniz işlemi seçin !");
        System.out.println("1) Sıcaklığı Görüntüle");
        System.out.println("2) Soğutucuyu Aç");
        System.out.println("3) Soğutucuyu Kapat");
        System.out.println("4) Sıcaklık Ayarla");
        System.out.println("5) Otomatik Kapat");
        System.out.println("6) Çıkış");
        System.out.println("**************************************");
    }

    }

