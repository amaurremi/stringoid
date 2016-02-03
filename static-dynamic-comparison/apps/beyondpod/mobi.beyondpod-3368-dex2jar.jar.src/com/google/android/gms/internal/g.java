package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

public class g
  extends f
{
  private g(Context paramContext, j paramj, k paramk)
  {
    super(paramContext, paramj, paramk);
  }
  
  public static g a(String paramString, Context paramContext)
  {
    a locala = new a();
    a(paramString, paramContext, locala);
    return new g(paramContext, locala, new m(239));
  }
  
  protected void b(Context paramContext)
  {
    long l = 1L;
    super.b(paramContext);
    try
    {
      paramContext = f(paramContext);
      label55:
      return;
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        try
        {
          if (!paramContext.isLimitAdTrackingEnabled()) {
            break label55;
          }
          a(28, l);
          paramContext = paramContext.getId();
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
    catch (GooglePlayServicesNotAvailableException paramContext) {}
  }
  
  a f(Context paramContext)
    throws IOException, GooglePlayServicesNotAvailableException
  {
    int i = 0;
    AdvertisingIdClient.Info localInfo;
    try
    {
      localInfo = AdvertisingIdClient.getAdvertisingIdInfo(paramContext);
      paramContext = localInfo.getId();
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
        paramContext = this.dw.a(arrayOfByte, true);
      }
    }
    catch (GooglePlayServicesRepairableException paramContext)
    {
      throw new IOException(paramContext);
    }
    for (;;)
    {
      return new a(paramContext, localInfo.isLimitAdTrackingEnabled());
    }
  }
  
  class a
  {
    private String dH;
    private boolean dI;
    
    public a(String paramString, boolean paramBoolean)
    {
      this.dH = paramString;
      this.dI = paramBoolean;
    }
    
    public String getId()
    {
      return this.dH;
    }
    
    public boolean isLimitAdTrackingEnabled()
    {
      return this.dI;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */