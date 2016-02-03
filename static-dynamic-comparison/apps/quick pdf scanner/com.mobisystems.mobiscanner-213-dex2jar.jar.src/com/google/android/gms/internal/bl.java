package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;

public class bl
{
  private final String Fc;
  private int Fd = 0;
  private long Fe = -1L;
  private long Ff = -1L;
  private int Fg = 0;
  private int Fh = -1;
  private final Object xV = new Object();
  
  public bl(String paramString)
  {
    this.Fc = paramString;
  }
  
  public Bundle a(String paramString, Context paramContext)
  {
    synchronized (this.xV)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("session_id", this.Fc);
      localBundle.putLong("basets", this.Ff);
      localBundle.putLong("currts", this.Fe);
      localBundle.putString("seq_num", paramString);
      localBundle.putInt("preqs", this.Fh);
      localBundle.putInt("pclick", this.Fd);
      localBundle.putInt("pimp", this.Fg);
      paramString = new bh(paramContext);
      localBundle.putInt("gnt", paramString.EA);
      if (paramString.Ez == 1)
      {
        localBundle.putString("net", "wi");
        return localBundle;
      }
      localBundle.putString("net", "ed");
    }
  }
  
  public void a(z paramz, long paramLong)
  {
    synchronized (this.xV)
    {
      if (this.Ff == -1L)
      {
        this.Ff = paramLong;
        this.Fe = this.Ff;
        if ((paramz.extras == null) || (paramz.extras.getInt("gw", 2) != 1)) {}
      }
      else
      {
        this.Fe = paramLong;
      }
    }
    this.Fh += 1;
  }
  
  /* Error */
  public void pD()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/google/android/gms/internal/bl:xV	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 32	com/google/android/gms/internal/bl:Fg	I
    //   14: iconst_1
    //   15: iadd
    //   16: putfield 32	com/google/android/gms/internal/bl:Fg	I
    //   19: aload_1
    //   20: monitorexit
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: astore_2
    //   25: aload_1
    //   26: monitorexit
    //   27: aload_2
    //   28: athrow
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	bl
    //   29	4	1	localObject2	Object
    //   24	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	21	24	finally
    //   25	27	24	finally
    //   2	9	29	finally
    //   27	29	29	finally
  }
  
  public void pE()
  {
    synchronized (this.xV)
    {
      this.Fd += 1;
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */