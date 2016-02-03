package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

public class do
  implements Runnable
{
  private final int ku;
  private final int kv;
  protected final ex lN;
  private final Handler pK;
  private final long pL;
  private long pM;
  private ey.a pN;
  protected boolean pO;
  protected boolean pP;
  
  public do(ey.a parama, ex paramex, int paramInt1, int paramInt2)
  {
    this(parama, paramex, paramInt1, paramInt2, 200L, 50L);
  }
  
  public do(ey.a parama, ex paramex, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.pL = paramLong1;
    this.pM = paramLong2;
    this.pK = new Handler(Looper.getMainLooper());
    this.lN = paramex;
    this.pN = parama;
    this.pO = false;
    this.pP = false;
    this.kv = paramInt2;
    this.ku = paramInt1;
  }
  
  public void a(du paramdu, fc paramfc)
  {
    this.lN.setWebViewClient(paramfc);
    ex localex = this.lN;
    if (TextUtils.isEmpty(paramdu.oA)) {}
    for (paramfc = null;; paramfc = eo.v(paramdu.oA))
    {
      localex.loadDataWithBaseURL(paramfc, paramdu.qe, "text/html", "UTF-8", null);
      return;
    }
  }
  
  public void b(du paramdu)
  {
    a(paramdu, new fc(this, this.lN, paramdu.qn));
  }
  
  public void bo()
  {
    this.pK.postDelayed(this, this.pL);
  }
  
  public void bp()
  {
    try
    {
      this.pO = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean bq()
  {
    try
    {
      boolean bool = this.pO;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean br()
  {
    return this.pP;
  }
  
  public void run()
  {
    if ((this.lN == null) || (bq()))
    {
      this.pN.a(this.lN);
      return;
    }
    new do.a(this, this.lN).execute(new Void[0]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/do.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */