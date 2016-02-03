package logo.quiz.commons;

public class Level
  implements LevelInterface
{
  private String category;
  private int from = -1;
  private int id;
  private boolean isLevelBackgroundColor;
  private int levelBackgroundResource;
  private int levelImageResource;
  private int logosCount = 0;
  private String subCategory;
  private int to = -1;
  private int unlockLimit;
  private String whatIsThisLabel;
  
  public Level(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.id = paramInt1;
    this.from = paramInt2;
    this.to = paramInt3;
    this.unlockLimit = paramInt4;
    this.levelBackgroundResource = paramInt5;
  }
  
  public Level(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.id = paramInt1;
    this.from = paramInt2;
    this.to = paramInt3;
    this.unlockLimit = paramInt4;
    this.levelBackgroundResource = paramInt5;
    this.levelImageResource = paramInt6;
  }
  
  public Level(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.id = paramInt1;
    this.category = paramString;
    this.unlockLimit = paramInt2;
    this.levelBackgroundResource = paramInt3;
  }
  
  public Level(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    this.id = paramInt1;
    this.category = paramString;
    this.unlockLimit = paramInt2;
    this.levelImageResource = paramInt3;
    this.levelBackgroundResource = paramInt4;
  }
  
  public Level(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    this.id = paramInt1;
    this.category = paramString1;
    this.subCategory = paramString2;
    this.whatIsThisLabel = paramString3;
    this.unlockLimit = paramInt2;
    this.levelBackgroundResource = paramInt3;
  }
  
  public Level(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    this.id = paramInt1;
    this.category = paramString1;
    this.subCategory = paramString2;
    this.whatIsThisLabel = paramString3;
    this.unlockLimit = paramInt2;
    this.levelBackgroundResource = paramInt3;
    this.isLevelBackgroundColor = paramBoolean;
    this.levelImageResource = paramInt4;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public int getFrom()
  {
    return this.from;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int getLevelBackgroundResource()
  {
    return this.levelBackgroundResource;
  }
  
  public int getLevelImageResource()
  {
    return this.levelImageResource;
  }
  
  public int getLogosCount()
  {
    if (this.logosCount == 0) {
      this.logosCount = (this.to - this.from);
    }
    return this.logosCount;
  }
  
  public String getSubCategory()
  {
    return this.subCategory;
  }
  
  public int getTo()
  {
    return this.to;
  }
  
  public int getUnlockLimit()
  {
    return this.unlockLimit;
  }
  
  public String getWhatIsThisLabel()
  {
    return this.whatIsThisLabel;
  }
  
  public void increaseLogosCount()
  {
    this.logosCount += 1;
  }
  
  public boolean isLevelBackgroundColor()
  {
    return this.isLevelBackgroundColor;
  }
  
  public void setCategory(String paramString)
  {
    this.category = paramString;
  }
  
  public void setFrom(int paramInt)
  {
    this.from = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setLevelBackgroundColor(boolean paramBoolean)
  {
    this.isLevelBackgroundColor = paramBoolean;
  }
  
  public void setLevelBackgroundResource(int paramInt)
  {
    this.levelBackgroundResource = paramInt;
  }
  
  public void setLevelImageResource(int paramInt)
  {
    this.levelImageResource = paramInt;
  }
  
  public void setLogosCount(int paramInt)
  {
    this.logosCount = paramInt;
  }
  
  public void setTo(int paramInt)
  {
    this.to = paramInt;
  }
  
  public void setUnlockLimit(int paramInt)
  {
    this.unlockLimit = paramInt;
  }
  
  public void setWhatIsThisLabel(String paramString)
  {
    this.whatIsThisLabel = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/Level.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */