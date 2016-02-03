package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import com.flurry.android.AdCreative;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.Collections;
import java.util.List;

public abstract class cy
  implements am, co
{
  protected abstract ac a(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdCreative paramAdCreative, Bundle paramBundle);
  
  public ac a(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit)
  {
    if ((paramContext == null) || (paramFlurryAdModule == null) || (paramm == null) || (paramAdUnit == null)) {}
    Bundle localBundle;
    do
    {
      do
      {
        do
        {
          return null;
        } while (!b(paramContext, e()));
        localBundle = c(paramContext, paramFlurryAdModule, paramm, paramAdUnit);
      } while (localBundle == null);
      paramAdUnit = ab.a(paramAdUnit);
    } while (paramAdUnit == null);
    return a(paramContext, paramFlurryAdModule, paramm, paramAdUnit, localBundle);
  }
  
  protected abstract cn a(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit, Bundle paramBundle);
  
  protected cx a()
  {
    return c();
  }
  
  protected boolean a(Context paramContext, db paramdb)
  {
    if ((paramContext == null) || (paramdb == null)) {}
    cx localcx;
    do
    {
      return false;
      localcx = a();
    } while (localcx == null);
    return localcx.a(paramContext, paramdb);
  }
  
  public cn a_(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit)
  {
    if ((paramContext == null) || (paramFlurryAdModule == null) || (paramm == null) || (paramAdUnit == null)) {}
    Bundle localBundle;
    do
    {
      do
      {
        return null;
      } while (!a(paramContext, d()));
      localBundle = b(paramContext, paramFlurryAdModule, paramm, paramAdUnit);
    } while (localBundle == null);
    return a(paramContext, paramFlurryAdModule, paramm, paramAdUnit, localBundle);
  }
  
  protected Bundle b(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit)
  {
    return d(paramContext, paramFlurryAdModule, paramm, paramAdUnit);
  }
  
  protected cx b()
  {
    return c();
  }
  
  protected boolean b(Context paramContext, db paramdb)
  {
    if ((paramContext == null) || (paramdb == null)) {}
    cx localcx;
    do
    {
      return false;
      localcx = b();
    } while (localcx == null);
    return localcx.a(paramContext, paramdb);
  }
  
  protected Bundle c(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit)
  {
    return d(paramContext, paramFlurryAdModule, paramm, paramAdUnit);
  }
  
  protected cx c()
  {
    return new cw();
  }
  
  protected Bundle d(Context paramContext, FlurryAdModule paramFlurryAdModule, m paramm, AdUnit paramAdUnit)
  {
    return il.e(paramContext);
  }
  
  protected db d()
  {
    return new db(f(), g(), h(), i(), j());
  }
  
  protected db e()
  {
    return new db(f(), k(), l(), m(), Collections.emptyList());
  }
  
  protected abstract String f();
  
  protected abstract List<cu> g();
  
  protected List<String> h()
  {
    return n();
  }
  
  protected List<String> i()
  {
    return o();
  }
  
  protected abstract List<ActivityInfo> j();
  
  protected abstract List<cu> k();
  
  protected List<String> l()
  {
    return n();
  }
  
  protected List<String> m()
  {
    return o();
  }
  
  protected abstract List<String> n();
  
  protected abstract List<String> o();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */