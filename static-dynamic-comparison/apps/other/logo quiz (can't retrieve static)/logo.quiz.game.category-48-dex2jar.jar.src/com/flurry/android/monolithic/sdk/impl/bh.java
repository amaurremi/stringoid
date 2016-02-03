package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import com.flurry.android.impl.ads.avro.protocol.v6.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.List;
import java.util.Map;

public class bh
{
  public final String a;
  public final Map<String, String> b;
  public final Context c;
  public final AdUnit d;
  public final m e;
  public final int f;
  
  public bh(String paramString, Map<String, String> paramMap, Context paramContext, AdUnit paramAdUnit, m paramm, int paramInt)
  {
    this.a = paramString;
    this.b = paramMap;
    this.c = paramContext;
    this.d = paramAdUnit;
    this.e = paramm;
    this.f = paramInt;
  }
  
  public AdFrame a()
  {
    return (AdFrame)this.d.d().get(this.f);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("event=").append(this.a);
    localStringBuilder.append(",params=").append(this.b);
    localStringBuilder.append(",adspace=").append(this.d.b());
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */