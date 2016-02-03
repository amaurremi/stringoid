package com.google.android.gms.internal;

import android.text.TextUtils;
import java.io.IOException;

public abstract class ii
{
  protected final ip Go;
  private final String Gp;
  private ir Gq;
  
  protected ii(String paramString1, String paramString2, String paramString3)
  {
    ik.aF(paramString1);
    this.Gp = paramString1;
    this.Go = new ip(paramString2);
    if (!TextUtils.isEmpty(paramString3)) {
      this.Go.aK(paramString3);
    }
  }
  
  public final void a(ir paramir)
  {
    this.Gq = paramir;
    if (this.Gq == null) {
      fB();
    }
  }
  
  protected final void a(String paramString1, long paramLong, String paramString2)
    throws IOException
  {
    this.Go.a("Sending text message: %s to: %s", new Object[] { paramString1, paramString2 });
    this.Gq.a(this.Gp, paramString1, paramLong, paramString2);
  }
  
  public void aD(String paramString) {}
  
  public void b(long paramLong, int paramInt) {}
  
  protected final long fA()
  {
    return this.Gq.fy();
  }
  
  public void fB() {}
  
  public final String getNamespace()
  {
    return this.Gp;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */