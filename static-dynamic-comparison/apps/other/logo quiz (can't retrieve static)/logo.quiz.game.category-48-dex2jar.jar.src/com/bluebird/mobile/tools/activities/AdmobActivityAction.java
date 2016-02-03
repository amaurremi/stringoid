package com.bluebird.mobile.tools.activities;

import android.app.Activity;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.bluebird.mobile.tools.animations.FlipAdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class AdmobActivityAction
  extends BaseActivityAction
{
  protected AdView adView;
  
  public AdmobActivityAction(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  protected String getAdMobUnitId()
  {
    int i = getActivity().getResources().getIdentifier("admob_unit_id", "string", getActivity().getPackageName());
    return getActivity().getString(i);
  }
  
  protected ViewGroup getAdviewContainer()
  {
    int i = getActivity().getResources().getIdentifier("adview_container", "id", getActivity().getPackageName());
    return (ViewGroup)getActivity().findViewById(i);
  }
  
  protected void loadAdMob()
  {
    Object localObject = getAdMobUnitId();
    if ((localObject != null) && (this.adView == null))
    {
      ViewGroup localViewGroup = getAdviewContainer();
      if (localViewGroup != null)
      {
        this.adView = new AdView(getActivity());
        this.adView.setAdUnitId((String)localObject);
        this.adView.setAdSize(AdSize.SMART_BANNER);
        localObject = new AdRequest.Builder().build();
        this.adView.setAdListener(new FlipAdListener(this.adView));
        this.adView.loadAd((AdRequest)localObject);
        localViewGroup.addView(this.adView);
      }
    }
  }
  
  public void onCreateAction()
  {
    try
    {
      loadAdMob();
      return;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError) {}
  }
  
  public void onDestroyAction()
  {
    if (this.adView != null) {
      this.adView.destroy();
    }
  }
  
  public void onPauseAction()
  {
    if (this.adView != null) {
      this.adView.pause();
    }
  }
  
  public void onResumeAction()
  {
    if (this.adView != null) {
      this.adView.resume();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/activities/AdmobActivityAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */