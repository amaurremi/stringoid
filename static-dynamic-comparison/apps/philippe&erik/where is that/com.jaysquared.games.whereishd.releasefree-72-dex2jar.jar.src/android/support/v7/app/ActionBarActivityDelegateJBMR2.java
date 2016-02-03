package android.support.v7.app;

class ActionBarActivityDelegateJBMR2
  extends ActionBarActivityDelegateJB
{
  ActionBarActivityDelegateJBMR2(ActionBarActivity paramActionBarActivity)
  {
    super(paramActionBarActivity);
  }
  
  public ActionBar createSupportActionBar()
  {
    return new ActionBarImplJBMR2(this.mActivity, this.mActivity);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/android/support/v7/app/ActionBarActivityDelegateJBMR2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */