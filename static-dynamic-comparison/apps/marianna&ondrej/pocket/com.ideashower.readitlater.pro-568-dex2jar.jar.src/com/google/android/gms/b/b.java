package com.google.android.gms.b;

import android.content.Context;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;
import com.google.android.gms.internal.bo;
import com.google.android.gms.internal.bt;

public class b
{
  private final Context a;
  private final c b;
  private final d c;
  private final bt d;
  
  public b(Context paramContext, c paramc, d paramd)
  {
    this.a = paramContext;
    this.b = paramc;
    this.c = paramd;
    this.d = new bt(this.a);
  }
  
  public a a()
  {
    return new a(new bo(this.a, this.d.a(), this.b, this.c));
  }
  
  public b a(String paramString)
  {
    this.d.a(paramString);
    return this;
  }
  
  public b a(String... paramVarArgs)
  {
    this.d.a(paramVarArgs);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */