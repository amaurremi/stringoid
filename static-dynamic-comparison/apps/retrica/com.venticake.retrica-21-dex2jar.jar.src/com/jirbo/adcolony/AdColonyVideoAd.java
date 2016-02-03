package com.jirbo.adcolony;

public class AdColonyVideoAd
  extends AdColonyInterstitialAd
{
  public AdColonyVideoAd() {}
  
  public AdColonyVideoAd(String paramString)
  {
    super(paramString);
  }
  
  public AdColonyVideoAd withListener(AdColonyAdListener paramAdColonyAdListener)
  {
    this.s = paramAdColonyAdListener;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/AdColonyVideoAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */