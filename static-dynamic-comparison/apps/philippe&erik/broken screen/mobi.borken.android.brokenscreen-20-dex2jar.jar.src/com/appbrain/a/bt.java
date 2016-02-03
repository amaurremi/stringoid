package com.appbrain.a;

import android.content.Context;
import android.os.SystemClock;

public final class bt
{
  private static final bt a = new bt();
  private static final bt b = new bt();
  private long c = Long.MIN_VALUE;
  
  public static void a(Context paramContext, String paramString)
  {
    a.a(paramContext, paramString, "bcsample");
  }
  
  private void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      long l = SystemClock.elapsedRealtime();
      if (this.c < l - 30000L)
      {
        this.c = l;
        int i = aa.a().a(paramString2, 3);
        if (Math.random() < 1.0D / (1 << i)) {
          cr.a(paramContext).a(paramString1, i);
        }
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void b(Context paramContext, String paramString)
  {
    b.a(paramContext, paramString, "icsample");
  }
  
  static final class a
  {
    private final StringBuilder a = new StringBuilder();
    
    private a a(String paramString1, String paramString2)
    {
      this.a.append("&");
      this.a.append(paramString1);
      this.a.append("=");
      this.a.append(paramString2);
      return this;
    }
    
    public final a a(int paramInt)
    {
      return a("it", String.valueOf(paramInt));
    }
    
    public final a a(long paramLong)
    {
      return a("bi", String.valueOf(paramLong));
    }
    
    public final a a(String paramString)
    {
      return a("ic", paramString);
    }
    
    public final a a(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (String str = "1";; str = "0") {
        return a("sm", str);
      }
    }
    
    public final a b(int paramInt)
    {
      return a("bt", String.valueOf(paramInt));
    }
    
    public final a b(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (String str = "1";; str = "0") {
        return a("mb", str);
      }
    }
    
    public final String toString()
    {
      return this.a.toString();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */