package com.google.android.b.a.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Locale;
import java.util.Map;

public final class ak
{
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final String g;
  public final String h;
  public final String i;
  public final String j;
  
  public ak(Context paramContext)
  {
    paramContext = paramContext.getResources();
    if ((paramContext != null) && (paramContext.getConfiguration() != null) && (paramContext.getConfiguration().locale != null)) {}
    for (paramContext = paramContext.getConfiguration().locale;; paramContext = Locale.getDefault())
    {
      paramContext = be.a(paramContext);
      this.a = ((String)paramContext.get("error_initializing_player"));
      this.b = ((String)paramContext.get("get_youtube_app_title"));
      this.c = ((String)paramContext.get("get_youtube_app_text"));
      this.d = ((String)paramContext.get("get_youtube_app_action"));
      this.e = ((String)paramContext.get("enable_youtube_app_title"));
      this.f = ((String)paramContext.get("enable_youtube_app_text"));
      this.g = ((String)paramContext.get("enable_youtube_app_action"));
      this.h = ((String)paramContext.get("update_youtube_app_title"));
      this.i = ((String)paramContext.get("update_youtube_app_text"));
      this.j = ((String)paramContext.get("update_youtube_app_action"));
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/a/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */