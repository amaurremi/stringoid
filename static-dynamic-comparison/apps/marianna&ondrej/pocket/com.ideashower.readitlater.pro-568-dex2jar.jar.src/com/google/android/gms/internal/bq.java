package com.google.android.gms.internal;

import com.google.android.gms.b.a.b.k;
import com.google.android.gms.common.a;

final class bq
  extends w
{
  private final a d;
  private final String e;
  
  public bq(bo parambo, com.google.android.gms.b.d paramd, a parama, com.google.android.gms.common.data.d paramd1, String paramString)
  {
    super(parambo, paramd, paramd1);
    this.d = parama;
    this.e = paramString;
  }
  
  protected void a(com.google.android.gms.b.d paramd, com.google.android.gms.common.data.d paramd1)
  {
    a locala = this.d;
    if (paramd1 != null) {}
    for (paramd1 = new k(paramd1);; paramd1 = null)
    {
      paramd.a(locala, paramd1, this.e);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */