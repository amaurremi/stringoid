package com.flurry.android;

import android.content.Context;
import android.os.AsyncTask;
import android.view.ViewGroup;
import java.util.Collections;
import java.util.List;

final class bw
  extends AsyncTask<Void, Void, List<AdUnit>>
{
  private String H;
  private Context J;
  private ViewGroup ao;
  private FlurryAdSize eb;
  private boolean ec;
  private boolean ed;
  
  public bw(FlurryAds paramFlurryAds, Context paramContext, String paramString, FlurryAdSize paramFlurryAdSize)
  {
    this.J = paramContext;
    this.H = paramString;
    this.eb = paramFlurryAdSize;
  }
  
  public bw(FlurryAds paramFlurryAds, Context paramContext, String paramString, FlurryAdSize paramFlurryAdSize, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramFlurryAds, paramContext, paramString, paramFlurryAdSize);
    this.ao = paramViewGroup;
    this.ec = paramBoolean2;
    this.ed = paramBoolean1;
  }
  
  private List<AdUnit> aj()
  {
    try
    {
      List localList = this.ee.a(this.J, this.H, this.ao, false, this.eb);
      this.ee.cJ.b(localList);
      return localList;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return Collections.emptyList();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */