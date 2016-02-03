package com.jaysquared.games.whereishd.utils;

public class PlayerScore
{
  private int index;
  private String name;
  private int score;
  
  public PlayerScore(int paramInt1, int paramInt2, String paramString)
  {
    this.index = paramInt1;
    this.score = paramInt2;
    this.name = paramString;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getScore()
  {
    return this.score;
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setScore(int paramInt)
  {
    this.score = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/utils/PlayerScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */