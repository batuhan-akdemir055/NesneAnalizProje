package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class Publisher implements  ISubject{


    private int sicaklik;
    private static  int veritaniSayac=0;
    IAgAraYuzu agAraYuzu;
    private List<IObserver> subcribers = new ArrayList<>();


    @Override
    public void attach(IObserver subcriber) {

      subcribers.add(subcriber);
      if(veritaniSayac%3==1)  veritabaninaEkle();
      if (veritaniSayac % 3 == 2) kritikSicaklikKontrol();

      veritaniSayac++;

    }

    @Override
    public void detach(IObserver subcriber) {
        // Veritabanından silme kodunu yap
     subcribers.remove(subcriber);
    }

    @Override
    public void notify(String mesaj) {

        for(IObserver subcriver : subcribers  ){
            subcriver.update(mesaj);
        }
    }

    private Connection baglan(){

        Connection conn=null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbNesneAnaliz",
                    "postgres", "samet5560");
            if (conn != null){
            }
            else
                System.out.println("Bağlantı girişimi başarısız!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    private void veritabaninaEkle(){

        String sql= "INSERT INTO  \"sicaklik\" (\"sicaklikdegeri\") VALUES(\'"+this.sicaklik+"\')";

        try
        {
            Connection conn=this.baglan();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sicaklikAl(int sicaklik){
        this.sicaklik=sicaklik;
    }

    public void kritikSicaklikKontrol(){
        if(this.sicaklik <-50 || this.sicaklik >50){
            System.out.println("Cihazınız kabul edilebilir sıcaklık değerleri dışında  !! Cihaz kapanıyor....");
            agAraYuzu.sogutucuKapat(3);
        }
    }


}
