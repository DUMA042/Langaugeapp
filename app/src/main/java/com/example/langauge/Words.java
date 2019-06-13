package com.example.langauge;

public class Words {
    private String  EnglishTrans ;
    private String MiworkTrans ;
    private int imageid=NO_IMAGE    ;
    private static final int NO_IMAGE=-1 ;
    public Words (String EnglishTrans ,String MiworkTrans) {
        this.EnglishTrans=EnglishTrans ;
        this.MiworkTrans=MiworkTrans ;
    }

    public Words (String EnglishTrans ,String MiworkTrans,int imageid) {
        this.EnglishTrans=EnglishTrans ;
        this.MiworkTrans=MiworkTrans ;
        this.imageid=imageid;
    }


    public String getEnglishTrans() {
        return EnglishTrans;
    }

    public String getMiworkTrans() {
        return MiworkTrans;
    }
    public int getImageid() {
        return imageid ;
    }
    public boolean check_for_image() {
return imageid!=NO_IMAGE;
    }
}
