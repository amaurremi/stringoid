package com.adwhirl.adapters;

import android.util.Log;
import com.adwhirl.AdWhirlLayout;
import com.adwhirl.obj.Extra2;
import com.adwhirl.obj.Ration;
import com.adwhirl.util.AdWhirlUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class AdWhirlAdapter
{
  protected static String googleAdSenseAppName;
  protected static String googleAdSenseChannel;
  protected static String googleAdSenseCompanyName;
  protected static String googleAdSenseExpandDirection;
  protected final WeakReference<AdWhirlLayout> adWhirlLayoutReference;
  protected Ration ration;
  
  public AdWhirlAdapter(AdWhirlLayout paramAdWhirlLayout, Ration paramRation)
  {
    this.adWhirlLayoutReference = new WeakReference(paramAdWhirlLayout);
    this.ration = paramRation;
  }
  
  private static AdWhirlAdapter getAdapter(AdWhirlLayout paramAdWhirlLayout, Ration paramRation)
  {
    for (;;)
    {
      try
      {
        switch (paramRation.type)
        {
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 7: 
        case 10: 
        case 11: 
        case 13: 
        case 15: 
        case 19: 
        case 21: 
        case 22: 
          return unknownAdNetwork(paramAdWhirlLayout, paramRation);
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        CustomAdapter localCustomAdapter;
        return unknownAdNetwork(paramAdWhirlLayout, paramRation);
        GenericAdapter localGenericAdapter = new GenericAdapter(paramAdWhirlLayout, paramRation);
        return localGenericAdapter;
      }
      catch (VerifyError localVerifyError)
      {
        if (!Extra2.verboselog) {
          continue;
        }
        Log.e("AdWhirl", "Caught VerifyError", localVerifyError);
        return unknownAdNetwork(paramAdWhirlLayout, paramRation);
      }
      if (Class.forName("com.google.ads.AdView") != null)
      {
        if (Extra2.verboselog) {
          Log.d("AdWhirl SDK", "Admob 4.X Loaded");
        }
        return getNetworkAdapter("com.adwhirl.adapters.GoogleAdMobAdsAdapter", paramAdWhirlLayout, paramRation);
      }
      return unknownAdNetwork(paramAdWhirlLayout, paramRation);
      if (Class.forName("com.inmobi.androidsdk.IMAdView") != null) {
        return getNetworkAdapter("com.adwhirl.adapters.InMobiAdapter", paramAdWhirlLayout, paramRation);
      }
      return unknownAdNetwork(paramAdWhirlLayout, paramRation);
      if (Class.forName("com.qwapi.adclient.android.view.QWAdView") != null) {
        return getNetworkAdapter("com.adwhirl.adapters.QuattroAdapter", paramAdWhirlLayout, paramRation);
      }
      return unknownAdNetwork(paramAdWhirlLayout, paramRation);
      if (Class.forName("com.millennialmedia.android.MMAdView") != null) {
        return getNetworkAdapter("com.adwhirl.adapters.MillennialAdapter", paramAdWhirlLayout, paramRation);
      }
      return unknownAdNetwork(paramAdWhirlLayout, paramRation);
      if (Class.forName("com.google.ads.GoogleAdView") != null) {
        return getNetworkAdapter("com.adwhirl.adapters.AdSenseAdapter", paramAdWhirlLayout, paramRation);
      }
      return unknownAdNetwork(paramAdWhirlLayout, paramRation);
      if (Class.forName("com.zestadz.android.ZestADZAdView") != null) {
        return getNetworkAdapter("com.adwhirl.adapters.ZestAdzAdapter", paramAdWhirlLayout, paramRation);
      }
      return unknownAdNetwork(paramAdWhirlLayout, paramRation);
      return getNetworkAdapter("com.adwhirl.adapters.MdotMAdapter", paramAdWhirlLayout, paramRation);
      return getNetworkAdapter("com.adwhirl.adapters.OneRiotAdapter", paramAdWhirlLayout, paramRation);
      localCustomAdapter = new CustomAdapter(paramAdWhirlLayout, paramRation);
      return localCustomAdapter;
      if (paramRation.key.toLowerCase().equals(AdWhirlUtil.KREACTIVE_KEY)) {
        return new KreactiveAdapter(paramAdWhirlLayout, paramRation);
      }
      AdWhirlAdapter localAdWhirlAdapter = unknownAdNetwork(paramAdWhirlLayout, paramRation);
      return localAdWhirlAdapter;
    }
  }
  
  private static AdWhirlAdapter getNetworkAdapter(String paramString, AdWhirlLayout paramAdWhirlLayout, Ration paramRation)
  {
    try
    {
      paramString = (AdWhirlAdapter)Class.forName(paramString).getConstructor(new Class[] { AdWhirlLayout.class, Ration.class }).newInstance(new Object[] { paramAdWhirlLayout, paramRation });
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      return null;
    }
    catch (InvocationTargetException paramString)
    {
      return null;
    }
    catch (NoSuchMethodException paramString)
    {
      return null;
    }
    catch (SecurityException paramString)
    {
      return null;
    }
    catch (ClassNotFoundException paramString) {}
    return null;
  }
  
  public static void handle(AdWhirlLayout paramAdWhirlLayout, Ration paramRation)
    throws Throwable
  {
    paramAdWhirlLayout = getAdapter(paramAdWhirlLayout, paramRation);
    if (paramAdWhirlLayout != null)
    {
      if (Extra2.verboselog) {
        Log.d("AdWhirl SDK", "Valid adapter, calling handle()");
      }
      paramAdWhirlLayout.handle();
      return;
    }
    throw new Exception("Invalid adapter");
  }
  
  public static void setGoogleAdSenseAppName(String paramString)
  {
    googleAdSenseAppName = paramString;
  }
  
  public static void setGoogleAdSenseChannel(String paramString)
  {
    googleAdSenseChannel = paramString;
  }
  
  public static void setGoogleAdSenseCompanyName(String paramString)
  {
    googleAdSenseCompanyName = paramString;
  }
  
  public static void setGoogleAdSenseExpandDirection(String paramString)
  {
    googleAdSenseExpandDirection = paramString;
  }
  
  private static AdWhirlAdapter unknownAdNetwork(AdWhirlLayout paramAdWhirlLayout, Ration paramRation)
  {
    if (Extra2.verboselog) {
      Log.w("AdWhirl SDK", "Unsupported ration type: " + paramRation.type);
    }
    return null;
  }
  
  public abstract void handle();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adwhirl/adapters/AdWhirlAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */