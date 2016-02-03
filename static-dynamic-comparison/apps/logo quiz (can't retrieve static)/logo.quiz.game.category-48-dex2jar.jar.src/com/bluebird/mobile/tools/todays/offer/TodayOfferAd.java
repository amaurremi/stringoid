package com.bluebird.mobile.tools.todays.offer;

import com.bluebird.mobile.tools.commons.PopupListener;

public class TodayOfferAd
{
  private String[] h1Args;
  private int imageResource;
  private String[] label1Args;
  private String[] label2Args;
  private String offerUrl = "market://details?id=your.offer.package.name";
  private PopupListener popupListener;
  
  public TodayOfferAd(int paramInt, String paramString)
  {
    this.imageResource = paramInt;
    this.offerUrl = paramString;
  }
  
  public TodayOfferAd(int paramInt, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this(paramInt, paramString);
    this.label1Args = paramArrayOfString1;
    this.label2Args = paramArrayOfString2;
  }
  
  public TodayOfferAd(int paramInt, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
  {
    this(paramInt, paramString);
    this.h1Args = paramArrayOfString1;
    this.label1Args = paramArrayOfString2;
    this.label2Args = paramArrayOfString3;
  }
  
  public String[] getH1Args()
  {
    return this.h1Args;
  }
  
  public int getImageResource()
  {
    return this.imageResource;
  }
  
  public String[] getLabel1Args()
  {
    return this.label1Args;
  }
  
  public String[] getLabel2Args()
  {
    return this.label2Args;
  }
  
  public String getOfferUrl()
  {
    return this.offerUrl;
  }
  
  PopupListener getPopupListener()
  {
    return this.popupListener;
  }
  
  public void setImageResource(int paramInt)
  {
    this.imageResource = paramInt;
  }
  
  public void setLabel1Args(String... paramVarArgs)
  {
    this.label1Args = paramVarArgs;
  }
  
  public void setLabel2Args(String... paramVarArgs)
  {
    this.label2Args = paramVarArgs;
  }
  
  public void setOfferUrl(String paramString)
  {
    this.offerUrl = paramString;
  }
  
  public void setPopupListener(PopupListener paramPopupListener)
  {
    this.popupListener = paramPopupListener;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/todays/offer/TodayOfferAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */