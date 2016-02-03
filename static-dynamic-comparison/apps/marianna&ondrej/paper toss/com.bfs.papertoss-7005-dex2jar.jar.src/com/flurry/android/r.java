package com.flurry.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import java.io.Closeable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

final class r
{
  static int a(Context paramContext, int paramInt)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramInt + 0.5F);
  }
  
  static String a(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      ah.d("FlurryAgent", "Cannot encode '" + paramString + "'");
    }
    return "";
  }
  
  static String a(String paramString, int paramInt)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= paramInt);
    return paramString.substring(0, paramInt);
  }
  
  static void a(Context paramContext, ImageView paramImageView, int paramInt1, int paramInt2)
  {
    paramImageView.setAdjustViewBounds(true);
    paramImageView.setMinimumWidth(a(paramContext, paramInt1));
    paramImageView.setMinimumHeight(a(paramContext, paramInt2));
    paramImageView.setMaxWidth(a(paramContext, paramInt1));
    paramImageView.setMaxHeight(a(paramContext, paramInt2));
  }
  
  static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */