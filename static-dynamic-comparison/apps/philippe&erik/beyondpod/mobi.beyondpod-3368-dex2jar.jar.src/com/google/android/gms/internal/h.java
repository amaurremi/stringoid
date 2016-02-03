package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.view.MotionEvent;

public class h
{
  private String dK = "googleads.g.doubleclick.net";
  private String dL = "/pagead/ads";
  private String[] dM = { ".doubleclick.net", ".googleadservices.com", ".googlesyndication.com" };
  private d dN;
  private final c dO = new c();
  
  public h(d paramd)
  {
    this.dN = paramd;
  }
  
  private Uri a(Uri paramUri, Context paramContext, String paramString, boolean paramBoolean)
    throws i
  {
    try
    {
      if (paramUri.getQueryParameter("ms") != null) {
        throw new i("Query parameter already exists: ms");
      }
    }
    catch (UnsupportedOperationException paramUri)
    {
      throw new i("Provided Uri is not in a valid state");
    }
    if (paramBoolean) {}
    for (paramContext = this.dN.a(paramContext, paramString);; paramContext = this.dN.a(paramContext)) {
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
    throws i
  {
    try
    {
      paramUri = a(paramUri, paramContext, paramUri.getQueryParameter("ai"), true);
      return paramUri;
    }
    catch (UnsupportedOperationException paramUri)
    {
      throw new i("Provided Uri is not in a valid state");
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.dN.a(paramMotionEvent);
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
      String[] arrayOfString = this.dM;
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
  
  public d g()
  {
    return this.dN;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */