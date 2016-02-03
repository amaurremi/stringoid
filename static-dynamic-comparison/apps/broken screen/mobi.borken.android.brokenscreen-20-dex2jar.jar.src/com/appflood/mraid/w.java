package com.appflood.mraid;

public abstract class w
{
  public abstract String a();
  
  public String toString()
  {
    String str = a();
    if (str != null) {
      return str.replaceAll("[^a-zA-Z0-9_,:\\s\\{\\}\\'\\\"]", "");
    }
    return "";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/mraid/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */