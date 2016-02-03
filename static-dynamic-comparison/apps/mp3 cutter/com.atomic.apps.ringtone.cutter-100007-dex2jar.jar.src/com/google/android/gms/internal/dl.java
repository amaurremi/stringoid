package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.view.MotionEvent;

public final class dl
{
  private String[] a = { ".doubleclick.net", ".googleadservices.com", ".googlesyndication.com" };
  private db b;
  
  public dl(db paramdb)
  {
    new da();
    this.b = paramdb;
  }
  
  private Uri a(Uri paramUri, Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      if (paramUri.getQueryParameter("ms") != null) {
        throw new dm("Query parameter already exists: ms");
      }
    }
    catch (UnsupportedOperationException paramUri)
    {
      throw new dm("Provided Uri is not in a valid state");
    }
    paramContext = this.b.a(paramContext, paramString);
    paramString = paramUri.toString();
    int j = paramString.indexOf("&adurl");
    int i = j;
    if (j == -1) {
      i = paramString.indexOf("?adurl");
    }
    if (i != -1) {
      return Uri.parse(paramString.substring(0, i + 1) + "ms" + "=" + paramContext + "&" + paramString.substring(i + 1));
    }
    paramUri = paramUri.buildUpon().appendQueryParameter("ms", paramContext).build();
    return paramUri;
  }
  
  public final Uri a(Uri paramUri, Context paramContext)
  {
    try
    {
      paramUri = a(paramUri, paramContext, paramUri.getQueryParameter("ai"), true);
      return paramUri;
    }
    catch (UnsupportedOperationException paramUri)
    {
      throw new dm("Provided Uri is not in a valid state");
    }
  }
  
  public final db a()
  {
    return this.b;
  }
  
  public final void a(MotionEvent paramMotionEvent)
  {
    this.b.a(paramMotionEvent);
  }
  
  public final boolean a(Uri paramUri)
  {
    boolean bool2 = false;
    if (paramUri == null) {
      throw new NullPointerException();
    }
    try
    {
      paramUri = paramUri.getHost();
      String[] arrayOfString = this.a;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */