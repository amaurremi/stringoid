package logo.quiz.commons;

public class MyAdCommons
{
  private String adId;
  private String adName;
  private String adUrl;
  private String gameName;
  private int hintsPerInstall;
  private int imageResource;
  private int imageResourceIcon;
  private int installResourceIcon;
  
  public MyAdCommons(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, int paramInt4)
  {
    this.imageResource = paramInt1;
    this.imageResourceIcon = paramInt2;
    this.installResourceIcon = paramInt3;
    this.hintsPerInstall = paramInt4;
    this.adId = paramString1;
    this.adUrl = paramString2;
    this.adName = paramString3;
    this.gameName = paramString4;
  }
  
  public MyAdCommons(int paramInt, String paramString1, String paramString2)
  {
    this.imageResource = paramInt;
    this.adId = paramString1;
    this.adUrl = paramString2;
  }
  
  public String getAdId()
  {
    return this.adId;
  }
  
  public String getAdName()
  {
    return this.adName;
  }
  
  public String getAdUrl()
  {
    return this.adUrl;
  }
  
  public String getGameName()
  {
    return this.gameName;
  }
  
  public int getHintsPerInstall()
  {
    return this.hintsPerInstall;
  }
  
  public int getImageResource()
  {
    return this.imageResource;
  }
  
  public int getImageResourceIcon()
  {
    return this.imageResourceIcon;
  }
  
  public int getInstallResourceIcon()
  {
    return this.installResourceIcon;
  }
  
  public void setAdId(String paramString)
  {
    this.adId = paramString;
  }
  
  public void setAdName(String paramString)
  {
    this.adName = paramString;
  }
  
  public void setAdUrl(String paramString)
  {
    this.adUrl = paramString;
  }
  
  public void setGameName(String paramString)
  {
    this.gameName = paramString;
  }
  
  public void setHintsPerInstall(int paramInt)
  {
    this.hintsPerInstall = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    this.imageResource = paramInt;
  }
  
  public void setImageResourceIcon(int paramInt)
  {
    this.imageResourceIcon = paramInt;
  }
  
  public void setInstallResourceIcon(int paramInt)
  {
    this.installResourceIcon = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/MyAdCommons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */