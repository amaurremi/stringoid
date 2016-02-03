package com.bubble.mobile.language.support;

import android.graphics.drawable.Drawable;

public class LocaleCodes
{
  private String code;
  private String countryCode;
  private Drawable flagImageRes;
  private int id;
  
  public LocaleCodes(int paramInt, String paramString, Drawable paramDrawable)
  {
    this.id = paramInt;
    if (paramString.indexOf('-') != -1)
    {
      paramString = paramString.split("-");
      this.code = paramString[0];
      this.countryCode = paramString[1];
    }
    for (;;)
    {
      this.flagImageRes = paramDrawable;
      return;
      this.code = paramString;
    }
  }
  
  public String getCode()
  {
    return this.code;
  }
  
  public String getCountryCode()
  {
    return this.countryCode;
  }
  
  public Drawable getFlagImageRes()
  {
    return this.flagImageRes;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
  }
  
  public void setCountryCode(String paramString)
  {
    this.countryCode = paramString;
  }
  
  public void setFlagImageRes(Drawable paramDrawable)
  {
    this.flagImageRes = paramDrawable;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/mobile/language/support/LocaleCodes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */