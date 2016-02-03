package com.flurry.android.monolithic.sdk.impl;

import android.text.TextUtils;
import com.flurry.android.impl.appcloud.AppCloudModule;

public abstract class gb
{
  protected gf a = null;
  
  public hk a(String paramString)
  {
    return this.a.b(paramString);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    b(paramString1, paramString2, paramString3);
    if (AppCloudModule.getInstance().b() != null) {
      AppCloudModule.getInstance().b().a(paramString1, paramString2, paramString3);
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return b(paramString1, paramString2, paramString3, paramString4);
  }
  
  protected void b(String paramString1, String paramString2, String paramString3)
  {
    if ((ft.e() != null) && (TextUtils.equals(ft.e().a(), paramString1))) {
      ft.e().a(paramString2, paramString3);
    }
  }
  
  public boolean b(String paramString)
  {
    return this.a.a(paramString);
  }
  
  protected boolean b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = c(paramString1, paramString3, paramString4);
    ja.a(4, "CacheContentProvider", "value in cache = " + str + " ; new value = " + paramString2);
    if (!paramString2.equals(str))
    {
      a(paramString3, paramString1, paramString2);
      this.a.a(paramString1, paramString2, paramString3, paramString4);
      return true;
    }
    return false;
  }
  
  public String c(String paramString1, String paramString2, String paramString3)
  {
    return this.a.a(paramString1, paramString2, paramString3);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/gb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */