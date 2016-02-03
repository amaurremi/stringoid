package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.a.a;
import com.google.android.gms.ads.a.a.a;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

public class gg
  extends j
{
  private gg(Context paramContext, go paramgo, gp paramgp)
  {
    super(paramContext, paramgo, paramgp);
  }
  
  public static gg b(String paramString, Context paramContext)
  {
    cn localcn = new cn();
    a(paramString, paramContext, localcn);
    return new gg(paramContext, localcn, new gq(239));
  }
  
  protected void K(Context paramContext)
  {
    long l = 1L;
    super.K(paramContext);
    try
    {
      paramContext = O(paramContext);
      label55:
      return;
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        try
        {
          if (!paramContext.kv()) {
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
  
  a O(Context paramContext)
  {
    int i = 0;
    a.a locala;
    try
    {
      locala = a.n(paramContext);
      paramContext = locala.getId();
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
        paramContext = this.Qk.a(arrayOfByte, true);
      }
    }
    catch (GooglePlayServicesRepairableException paramContext)
    {
      throw new IOException(paramContext);
    }
    for (;;)
    {
      return new a(paramContext, locala.kv());
    }
  }
  
  class a
  {
    private String SW;
    private boolean SX;
    
    public a(String paramString, boolean paramBoolean)
    {
      this.SW = paramString;
      this.SX = paramBoolean;
    }
    
    public String getId()
    {
      return this.SW;
    }
    
    public boolean kv()
    {
      return this.SX;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/gg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */