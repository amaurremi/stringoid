package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.a.a;
import com.google.android.gms.ads.a.b;
import com.google.android.gms.common.d;
import com.google.android.gms.common.e;
import java.io.IOException;

public final class df
  extends dd
{
  private df(Context paramContext, dn paramdn, do paramdo)
  {
    super(paramContext, paramdn, paramdo);
  }
  
  public static df a(String paramString, Context paramContext)
  {
    dn localdn = new dn();
    a(paramString, paramContext, localdn);
    return new df(paramContext, localdn, new do(239));
  }
  
  private dg d(Context paramContext)
  {
    int i = 0;
    b localb;
    try
    {
      localb = a.a(paramContext);
      paramContext = localb.a();
      if ((paramContext != null) && (paramContext.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")))
      {
        byte[] arrayOfByte = new byte[16];
        int j = 0;
        while (i < paramContext.length())
        {
          int k;
          if ((i != 8) && (i != 13) && (i != 18))
          {
            k = i;
            if (i != 23) {}
          }
          else
          {
            k = i + 1;
          }
          arrayOfByte[j] = ((byte)((Character.digit(paramContext.charAt(k), 16) << 4) + Character.digit(paramContext.charAt(k + 1), 16)));
          j += 1;
          i = k + 2;
        }
        paramContext = this.c.a(arrayOfByte, true);
      }
    }
    catch (e paramContext)
    {
      throw new IOException(paramContext);
    }
    for (;;)
    {
      return new dg(this, paramContext, localb.b());
    }
  }
  
  protected final void b(Context paramContext)
  {
    long l = 1L;
    super.b(paramContext);
    try
    {
      paramContext = d(paramContext);
      label55:
      return;
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        try
        {
          if (!paramContext.b()) {
            break label55;
          }
          a(28, l);
          paramContext = paramContext.a();
          if (paramContext == null) {
            break;
          }
          a(30, paramContext);
          return;
        }
        catch (IOException paramContext)
        {
          return;
        }
        paramContext = paramContext;
        a(28, 1L);
        return;
        l = 0L;
      }
    }
    catch (d paramContext) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */