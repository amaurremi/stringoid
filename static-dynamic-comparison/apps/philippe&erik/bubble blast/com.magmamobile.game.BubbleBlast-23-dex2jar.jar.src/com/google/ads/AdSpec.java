package com.google.ads;

import android.content.Context;
import java.util.List;

public abstract interface AdSpec
{
  public static final String CONTENT_AD_URL = "http://pagead2.googlesyndication.com/pagead/afma_load_ads.js";
  public static final String SEARCH_AD_URL = "http://www.gstatic.com/mobile/ads/safma_load_ads.js";
  
  public abstract List<Parameter> generateParameters(Context paramContext);
  
  public abstract String getAdUrl();
  
  public abstract boolean getDebugMode();
  
  public abstract int getHeight();
  
  public abstract int getWidth();
  
  public static class Parameter
  {
    private final String mName;
    private final String mValue;
    
    public Parameter(String paramString1, String paramString2)
    {
      if (paramString1 == null) {
        throw new NullPointerException("Parameter name cannot be null.");
      }
      if (paramString2 == null) {
        throw new NullPointerException("Parameter value cannot be null.");
      }
      this.mName = paramString1;
      this.mValue = paramString2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof Parameter)) {
          return false;
        }
        paramObject = (Parameter)paramObject;
      } while ((this.mName.equals(((Parameter)paramObject).mName)) && (this.mValue.equals(((Parameter)paramObject).mValue)));
      return false;
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    public String getValue()
    {
      return this.mValue;
    }
    
    public int hashCode()
    {
      return this.mName.hashCode() * 4999 + this.mValue.hashCode();
    }
    
    public String toString()
    {
      return "Parameter(" + this.mName + "," + this.mValue + ")";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/AdSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */