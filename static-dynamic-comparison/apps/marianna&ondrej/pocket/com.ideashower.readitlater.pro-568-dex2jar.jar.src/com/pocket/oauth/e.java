package com.pocket.oauth;

import android.os.Bundle;
import com.google.android.gms.b.b;
import com.google.android.gms.common.c;
import com.ideashower.readitlater.a.g;

class e
{
  private final com.google.android.gms.b.a a;
  
  private e(String paramString, final f paramf)
  {
    this.a = new b(g.c(), new c()new com.google.android.gms.common.d
    {
      public void a() {}
      
      public void a(Bundle paramAnonymousBundle)
      {
        paramf.a(e.b(e.this));
      }
    }, new com.google.android.gms.common.d()
    {
      public void a(com.google.android.gms.common.a paramAnonymousa)
      {
        paramf.a(null);
      }
    }).a(paramString).a(d.e).a();
  }
  
  private void a()
  {
    this.a.c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/oauth/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */