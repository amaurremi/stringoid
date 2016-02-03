package com.jumptap.adtag.media;

public class VideoCacheItem
{
  public static final String URL_DELIMITER = ",";
  private String adID;
  private String date;
  private int id;
  
  public VideoCacheItem()
  {
    init(-1, null, null);
  }
  
  public VideoCacheItem(int paramInt, String paramString1, String paramString2)
  {
    init(paramInt, paramString1, paramString2);
  }
  
  public VideoCacheItem(String paramString1, String paramString2)
  {
    init(-1, paramString1, paramString2);
  }
  
  private void init(int paramInt, String paramString1, String paramString2)
  {
    this.id = paramInt;
    this.adID = paramString1;
    this.date = paramString2;
  }
  
  public String getAdID()
  {
    return this.adID;
  }
  
  public String getDate()
  {
    return this.date;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public void setAdID(String paramString)
  {
    this.adID = paramString;
  }
  
  public void setDate(String paramString)
  {
    this.date = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public String toString()
  {
    return "id=" + this.id + " ,adID=" + this.adID + "   ,date=" + this.date;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/media/VideoCacheItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */