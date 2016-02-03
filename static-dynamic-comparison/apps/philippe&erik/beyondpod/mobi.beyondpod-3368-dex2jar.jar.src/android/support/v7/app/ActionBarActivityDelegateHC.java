package android.support.v7.app;

import android.os.Bundle;
import android.view.Window;

class ActionBarActivityDelegateHC
  extends ActionBarActivityDelegateBase
{
  ActionBarActivityDelegateHC(ActionBarActivity paramActionBarActivity)
  {
    super(paramActionBarActivity);
  }
  
  public ActionBar createSupportActionBar()
  {
    ensureSubDecor();
    return new ActionBarImplHC(this.mActivity, this.mActivity);
  }
  
  void onCreate(Bundle paramBundle)
  {
    this.mActivity.getWindow().requestFeature(10);
    super.onCreate(paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/app/ActionBarActivityDelegateHC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */