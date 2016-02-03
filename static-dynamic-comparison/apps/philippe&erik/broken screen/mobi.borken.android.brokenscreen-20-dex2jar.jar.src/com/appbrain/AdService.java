package com.appbrain;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;

public abstract interface AdService
{
  public abstract String getOfferWallButtonLabel(Context paramContext);
  
  public abstract boolean maybeShowInterstitial(Context paramContext);
  
  public abstract void setOfferWallClickListener(Context paramContext, View paramView);
  
  public abstract void setOfferWallMenuItemClickListener(Context paramContext, MenuItem paramMenuItem);
  
  public abstract boolean shouldShowInterstitial(Context paramContext);
  
  public abstract boolean showInterstitial(Context paramContext);
  
  public abstract void showOfferWall(Context paramContext);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/AdService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */