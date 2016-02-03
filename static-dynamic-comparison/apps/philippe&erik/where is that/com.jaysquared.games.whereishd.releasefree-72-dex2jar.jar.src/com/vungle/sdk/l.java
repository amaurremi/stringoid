package com.vungle.sdk;

import android.net.Uri;
import android.net.Uri.Builder;

final class l
{
  private static final class a
    implements Runnable
  {
    private String a;
    private String b;
    private String c;
    
    public a(String paramString1, String paramString2, String paramString3)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
    }
    
    public final void run()
    {
      Object localObject = Uri.parse(this.a).buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("isu", this.c);
      ((Uri.Builder)localObject).appendQueryParameter("ut", String.valueOf(System.currentTimeMillis() / 1000L));
      ((Uri.Builder)localObject).appendQueryParameter("app_id", this.b);
      localObject = ((Uri.Builder)localObject).build();
      new StringBuilder("Sending to: ").append(localObject);
      at.a(((Uri)localObject).toString(), null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */