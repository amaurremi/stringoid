package com.greystripe.sdk;

import android.content.Context;
import android.util.AttributeSet;

public final class GSLeaderboardAdView
  extends am
{
  public GSLeaderboardAdView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GSLeaderboardAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GSLeaderboardAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, null);
  }
  
  private GSLeaderboardAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, String paramString)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new bc(paramContext);
    a(paramContext);
    if (!bj.b(bk.GUID)) {
      bj.a(paramString);
    }
    paramContext.a("guid", bj.b());
    if (super.b()) {
      paramContext.h();
    }
  }
  
  public GSLeaderboardAdView(Context paramContext, String paramString)
  {
    this(paramContext, null, 0, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/GSLeaderboardAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */