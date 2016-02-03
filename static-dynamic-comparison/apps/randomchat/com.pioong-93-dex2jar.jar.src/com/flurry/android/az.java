package com.flurry.android;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.List;

abstract class az
  implements bq, k
{
  private static final String d = az.class.getSimpleName();
  
  private static boolean a(av paramav)
  {
    bool2 = false;
    bool1 = false;
    if (paramav == null) {
      bool2 = bool1;
    }
    do
    {
      return bool2;
      bool1 = bool2;
      try
      {
        if (!TextUtils.isEmpty(paramav.H()))
        {
          Class.forName(paramav.H());
          bool1 = true;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          db.a(6, d, "failed to find third party ad network api with exception: ", localClassNotFoundException);
          bool1 = bool2;
        }
      }
      catch (ExceptionInInitializerError localExceptionInInitializerError)
      {
        for (;;)
        {
          db.a(6, d, "failed to initialize third party ad network api with exception: ", localExceptionInInitializerError);
          bool1 = bool2;
        }
      }
      catch (LinkageError localLinkageError)
      {
        for (;;)
        {
          db.a(6, d, "failed to link third party ad network api with exception: ", localLinkageError);
          bool1 = bool2;
        }
      }
      bool2 = bool1;
    } while (bool1);
    db.d(d, "Please consider to add to the project the library: " + paramav.F() + " version: " + paramav.G() + " or higher");
    return bool1;
  }
  
  protected abstract Bundle a(Context paramContext);
  
  public final ao a(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdUnit paramAdUnit)
  {
    if ((paramContext == null) || (paramFlurryAds == null) || (paramcz == null) || (paramAdUnit == null)) {}
    Object localObject;
    do
    {
      do
      {
        return null;
        localObject = b();
      } while ((localObject == null) || (!a((av)localObject)));
      localObject = a(paramContext);
    } while (localObject == null);
    return a(paramContext, paramFlurryAds, paramcz, paramAdUnit, (Bundle)localObject);
  }
  
  protected abstract ao a(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdUnit paramAdUnit, Bundle paramBundle);
  
  protected abstract p a(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdCreative paramAdCreative, Bundle paramBundle);
  
  protected abstract av b();
  
  public final p b(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdUnit paramAdUnit)
  {
    if ((paramContext == null) || (paramFlurryAds == null) || (paramcz == null) || (paramAdUnit == null)) {
      return null;
    }
    Object localObject = c();
    if (localObject == null) {
      return null;
    }
    if (!a((av)localObject)) {
      return null;
    }
    localObject = a(paramContext);
    if (localObject == null) {
      return null;
    }
    if (paramAdUnit == null) {
      paramAdUnit = null;
    }
    while (paramAdUnit == null)
    {
      return null;
      paramAdUnit = paramAdUnit.getAdFrames();
      if ((paramAdUnit == null) || (paramAdUnit.isEmpty()))
      {
        paramAdUnit = null;
      }
      else
      {
        paramAdUnit = (AdFrame)paramAdUnit.get(0);
        if (paramAdUnit == null)
        {
          paramAdUnit = null;
        }
        else
        {
          paramAdUnit = paramAdUnit.getAdSpaceLayout();
          if (paramAdUnit == null) {
            paramAdUnit = null;
          } else {
            paramAdUnit = cx.b(paramAdUnit);
          }
        }
      }
    }
    return a(paramContext, paramFlurryAds, paramcz, paramAdUnit, (Bundle)localObject);
  }
  
  protected abstract av c();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */