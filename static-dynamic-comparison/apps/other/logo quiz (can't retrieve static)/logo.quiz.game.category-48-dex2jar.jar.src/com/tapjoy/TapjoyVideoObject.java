package com.tapjoy;

import java.io.Serializable;
import java.lang.reflect.Array;

public class TapjoyVideoObject
  implements Serializable
{
  public static final int BUTTON_MAX = 10;
  private static final long serialVersionUID = 1L;
  public int buttonCount;
  public String[][] buttonData = (String[][])Array.newInstance(String.class, new int[] { 10, 2 });
  public String clickURL;
  public String currencyAmount;
  public String currencyName;
  public String dataLocation;
  public String iconURL;
  public String offerID;
  public String videoAdName;
  public String videoURL;
  public String webviewURL;
  
  public void addButton(String paramString1, String paramString2)
  {
    this.buttonData[this.buttonCount][0] = paramString1;
    this.buttonData[this.buttonCount][1] = paramString2;
    this.buttonCount += 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TapjoyVideoObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */