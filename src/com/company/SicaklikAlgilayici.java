package com.company;

public class SicaklikAlgilayici extends Sicaklik implements  ISicaklikAlgilayici{


    public int getSicaklik() {
        return sicaklik;
    }

    public void setSicaklik(int sicaklik) {
        this.sicaklik = sicaklik;
    }

    @Override
    public int sicaklikOku() {
      return  sicaklik;
    }
}
