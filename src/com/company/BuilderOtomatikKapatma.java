package com.company;

import java.util.Arrays;
import java.util.List;

public class BuilderOtomatikKapatma {

    private  int dakika;
    private    String renk;
    public static String [] renkler = {"Mavi","Kırmızı","Mor","Yeşil","Sarı","Pembe","Turuncu","Lacivert"};
    public static List<String> renkVeritabani;


    private  BuilderOtomatikKapatma(OtomatikKapaBuilder otomatikKapaBuilder){
        this.dakika=otomatikKapaBuilder.dakika;
        this.renk=otomatikKapaBuilder.renk;
        renkVeritabani= Arrays.asList(renkler);
    }

    public int getDakika() {
        return dakika;
    }

    public String getRenk() {
        return renk;
    }

    public static List<String> getRenkVeritabani() {
        return renkVeritabani;
    }

    public static  class OtomatikKapaBuilder{
        private int dakika;
        private String renk;


        public  OtomatikKapaBuilder(int dakika){
            this.dakika=dakika;
        }
        public  OtomatikKapaBuilder renk (String renk){
            this.renk=renk;
            return this;
        }

       public BuilderOtomatikKapatma build (){
            return  new BuilderOtomatikKapatma(this);
       }
    }
}
