package com.example.bengalish;

public class Word {
    private String bengali;
    private String english;
    private int image_id=CCCC;
    private static final int CCCC=-1;
    private int audioId;

    Word(String str1,String str2,int audioId)
    {
        this.english=str1;
        this.bengali=str2;
        this.audioId=audioId;
    }
    Word(String str1,String str2,int image_id,int audioId)
    {
        this.english=str1;
        this.bengali=str2;
        this.image_id=image_id;
        this.audioId=audioId;
    }
    public String getBengaliTranslation()
    {
        return this.bengali;
    }
    public String getEnglishTranslation()
    {
        return this.english;
    }
    public int getImageResourceId(){return this.image_id;}
    public boolean hasImage()
    {
        return image_id!=CCCC;
    }
    public int getAudioId(){return this.audioId;}
}
