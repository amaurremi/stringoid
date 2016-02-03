package com.google.analytics.tracking.android;

import java.util.HashMap;
import java.util.Map;

class MetaModel
{
  private Map<String, MetaInfo> metaInfos = new HashMap();
  
  public void addField(String paramString1, String paramString2, String paramString3, Formatter paramFormatter)
  {
    this.metaInfos.put(paramString1, new MetaInfo(paramString2, paramString3, paramFormatter));
  }
  
  MetaInfo getMetaInfo(String paramString)
  {
    if (paramString.startsWith("&")) {
      return new MetaInfo(paramString.substring(1), null, null);
    }
    String str = paramString;
    if (paramString.contains("*")) {
      str = paramString.substring(0, paramString.indexOf("*"));
    }
    return (MetaInfo)this.metaInfos.get(str);
  }
  
  public static abstract interface Formatter
  {
    public abstract String format(String paramString);
  }
  
  public static class MetaInfo
  {
    private final String defaultValue;
    private final MetaModel.Formatter formatter;
    private final String urlParam;
    
    public MetaInfo(String paramString1, String paramString2, MetaModel.Formatter paramFormatter)
    {
      this.urlParam = paramString1;
      this.defaultValue = paramString2;
      this.formatter = paramFormatter;
    }
    
    public String getDefaultValue()
    {
      return this.defaultValue;
    }
    
    public MetaModel.Formatter getFormatter()
    {
      return this.formatter;
    }
    
    public String getUrlParam(String paramString)
    {
      Object localObject = null;
      if (paramString.contains("*"))
      {
        String str = this.urlParam;
        String[] arrayOfString = paramString.split("\\*");
        paramString = (String)localObject;
        if (arrayOfString.length > 1) {}
        try
        {
          int i = Integer.parseInt(arrayOfString[1]);
          paramString = str + i;
          return paramString;
        }
        catch (NumberFormatException paramString)
        {
          Log.w("Unable to parse slot for url parameter " + str);
          return null;
        }
      }
      return this.urlParam;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/analytics/tracking/android/MetaModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */