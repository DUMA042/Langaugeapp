package com.example.langauge;

public class Words {
    private String  EnglishTrans ;
    private String MiworkTrans ;
    private int imageid=NO_IMAGE ;
    private int soundid ;
    private static final int NO_IMAGE=-1 ;
    public Words (String EnglishTrans ,String MiworkTrans,int soundid) {
        this.EnglishTrans=EnglishTrans ;
        this.MiworkTrans=MiworkTrans ;
        this.soundid=soundid;
    }

    public Words (String EnglishTrans ,String MiworkTrans,int imageid,int soundid) {
        this.EnglishTrans=EnglishTrans ;
        this.MiworkTrans=MiworkTrans ;
        this.imageid=imageid;
        this.soundid=soundid;
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

    public int getSoundid() {
        return soundid;
    }

    public boolean check_for_image() {
return imageid!=NO_IMAGE;
    }
}
