package com.mopub.mobileads;

import android.app.Activity;
import android.content.Intent;

public class MraidInterstitialAdapter
  extends BaseInterstitialAdapter
{
  public void loadInterstitial()
  {
    if (this.mAdapterListener != null) {
      this.mAdapterListener.onNativeInterstitialLoaded(this);
    }
  }
  
  public void showInterstitial()
  {
    Activity localActivity = this.mInterstitial.getActivity();
    Intent localIntent = new Intent(localActivity, MraidActivity.class);
    localIntent.putExtra("com.mopub.mobileads.Source", this.mJsonParams);
    localActivity.startActivity(localIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/MraidInterstitialAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */