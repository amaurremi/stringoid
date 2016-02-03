package com.google.a.a.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.internal.bU;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public final class a
  implements com.google.android.gms.ads.b.c, com.google.android.gms.ads.b.e
{
  private com.google.android.gms.ads.e a;
  private com.google.android.gms.ads.f b;
  
  private static com.google.android.gms.ads.b a(Context paramContext, com.google.android.gms.ads.b.a parama, Bundle paramBundle1, Bundle paramBundle2)
  {
    com.google.android.gms.ads.c localc = new com.google.android.gms.ads.c();
    Object localObject = parama.a();
    if (localObject != null) {
      localc.a((Date)localObject);
    }
    int i = parama.b();
    if (i != 0) {
      localc.a(i);
    }
    localObject = parama.c();
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localc.a((String)((Iterator)localObject).next());
      }
    }
    if (parama.d()) {
      localc.b(bU.a(paramContext));
    }
    boolean bool;
    if (paramBundle2.getInt("tagForChildDirectedTreatment") != -1)
    {
      if (paramBundle2.getInt("tagForChildDirectedTreatment") == 1)
      {
        bool = true;
        localc.a(bool);
      }
    }
    else {
      if (paramBundle1 == null) {
        break label219;
      }
    }
    for (;;)
    {
      paramBundle1.putInt("gw", 1);
      paramBundle1.putString("mad_hac", paramBundle2.getString("mad_hac"));
      if (!TextUtils.isEmpty(paramBundle2.getString("adJson"))) {
        paramBundle1.putString("_ad", paramBundle2.getString("adJson"));
      }
      paramBundle1.putBoolean("_noRefresh", true);
      localc.a(a.class, paramBundle1);
      return localc.a();
      bool = false;
      break;
      label219:
      paramBundle1 = new Bundle();
    }
  }
  
  public final void a()
  {
    if (this.a != null)
    {
      this.a.a();
      this.a = null;
    }
    if (this.b != null) {
      this.b = null;
    }
  }
  
  public final void a(Context paramContext, com.google.android.gms.ads.b.d paramd, Bundle paramBundle1, com.google.android.gms.ads.d paramd1, com.google.android.gms.ads.b.a parama, Bundle paramBundle2)
  {
    this.a = new com.google.android.gms.ads.e(paramContext);
    this.a.a(new com.google.android.gms.ads.d(paramd1.b(), paramd1.a()));
    this.a.a(paramBundle1.getString("pubid"));
    this.a.a(new b(this, paramd));
    this.a.a(a(paramContext, parama, paramBundle2, paramBundle1));
  }
  
  public final void a(Context paramContext, com.google.android.gms.ads.b.f paramf, Bundle paramBundle1, com.google.android.gms.ads.b.a parama, Bundle paramBundle2)
  {
    this.b = new com.google.android.gms.ads.f(paramContext);
    this.b.a(paramBundle1.getString("pubid"));
    this.b.a(new c(this, paramf));
    this.b.a(a(paramContext, parama, paramBundle2, paramBundle1));
  }
  
  public final void b()
  {
    if (this.a != null) {
      this.a.b();
    }
  }
  
  public final void c()
  {
    if (this.a != null) {
      this.a.c();
    }
  }
  
  public final View d()
  {
    return this.a;
  }
  
  public final void e()
  {
    this.b.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */