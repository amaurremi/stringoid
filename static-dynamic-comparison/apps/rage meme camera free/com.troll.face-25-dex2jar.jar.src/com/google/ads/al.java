package com.google.ads;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;

public class al
{
  private String a = "googleads.g.doubleclick.net";
  private String b = "/pagead/ads";
  private String[] c = { ".doubleclick.net", ".googleadservices.com", ".googlesyndication.com" };
  private ai d;
  private ah e = new ah();
  
  public al(ai paramai)
  {
    this.d = paramai;
  }
  
  private Uri a(Uri paramUri, Context paramContext, String paramString, boolean paramBoolean)
    throws am
  {
    try
    {
      if (paramUri.getQueryParameter("ms") != null) {
        throw new am("Query parameter already exists: ms");
      }
    }
    catch (UnsupportedOperationException paramUri)
    {
      throw new am("Provided Uri is not in a valid state");
    }
    if (paramBoolean) {}
    for (paramContext = this.d.a(paramContext, paramString);; paramContext = this.d.a(paramContext)) {
      return a(paramUri, "ms", paramContext);
    }
  }
  
  private Uri a(Uri paramUri, String paramString1, String paramString2)
    throws UnsupportedOperationException
  {
    String str = paramUri.toString();
    int j = str.indexOf("&adurl");
    int i = j;
    if (j == -1) {
      i = str.indexOf("?adurl");
    }
    if (i != -1) {
      return Uri.parse(str.substring(0, i + 1) + paramString1 + "=" + paramString2 + "&" + str.substring(i + 1));
    }
    return paramUri.buildUpon().appendQueryParameter(paramString1, paramString2).build();
  }
  
  public Uri a(Uri paramUri, Context paramContext)
    throws am
  {
    try
    {
      paramUri = a(paramUri, paramContext, paramUri.getQueryParameter("ai"), true);
      return paramUri;
    }
    catch (UnsupportedOperationException paramUri)
    {
      throw new am("Provided Uri is not in a valid state");
    }
  }
  
  public void a(String paramString)
  {
    this.c = paramString.split(",");
  }
  
  public boolean a(Uri paramUri)
  {
    boolean bool2 = false;
    if (paramUri == null) {
      throw new NullPointerException();
    }
    try
    {
      paramUri = paramUri.getHost();
      String[] arrayOfString = this.c;
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          bool1 = paramUri.endsWith(arrayOfString[i]);
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (NullPointerException paramUri) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/google/ads/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */