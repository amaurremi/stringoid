package com.google.android.gms.internal;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class fi
{
  private static int Qo = 10000;
  private static int Qp = 1000;
  private final eq<em> MJ;
  private final int Qc;
  private final String Qq;
  private final BlockingQueue<hx.a> Qr;
  private int Qs;
  private final Object xV = new Object();
  
  public fi(eq<em> parameq, String paramString, int paramInt)
  {
    this.MJ = parameq;
    this.Qq = paramString;
    this.Qc = paramInt;
    this.Qr = new LinkedBlockingQueue(Qo);
    this.Qs = Qp;
  }
  
  public void a(hx.a.a parama)
  {
    parama.ba(this.Qq);
    parama.db(this.Qc);
    this.Qr.offer(parama.rF());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/fi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */