package com.flurry.android;

final class cx
{
  static cz a(FlurryAds paramFlurryAds, String paramString)
  {
    long l = paramFlurryAds.L();
    paramFlurryAds.M();
    paramString = new cz(l, paramString);
    paramFlurryAds.a(paramString);
    return paramString;
  }
  
  static AdCreative b(AdSpaceLayout paramAdSpaceLayout)
  {
    return new AdCreative(paramAdSpaceLayout.getAdHeight().intValue(), paramAdSpaceLayout.getAdWidth().intValue(), paramAdSpaceLayout.getFormat().toString(), paramAdSpaceLayout.getFix().toString(), paramAdSpaceLayout.getAlignment().toString());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */