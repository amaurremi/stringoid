package android.support.v7.app;

class ActionBarActivityDelegateJB
  extends ActionBarActivityDelegateICS
{
  ActionBarActivityDelegateJB(ActionBarActivity paramActionBarActivity)
  {
    super(paramActionBarActivity);
  }
  
  public ActionBar createSupportActionBar()
  {
    return new ActionBarImplJB(this.mActivity, this.mActivity);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/app/ActionBarActivityDelegateJB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */