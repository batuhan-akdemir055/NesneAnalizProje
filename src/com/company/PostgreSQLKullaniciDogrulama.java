package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgreSQLKullaniciDogrulama implements  IKullaniciDogrula{

    private Connection baglan(){

        Connection conn=null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbNesneAnaliz",
                    "postgres", "samet5560");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    @Override
    public boolean kullaniciDogrula(String kullaniciAd, String sifre) {
        String sql= "SELECT \"kullaniciad\",\"sifre\" FROM \"veritabani\" WHERE \"kullaniciad\"="+"'"+kullaniciAd+"'"+"AND \"sifre\"="+"'"+sifre+"'";
        Connection conn=this.baglan();

        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            conn.close();

            if(!rs.next()){
                return false;
            }

            else{
                System.out.println("Kullanıcı doğrulama işlemi başarılı");
                return true;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
