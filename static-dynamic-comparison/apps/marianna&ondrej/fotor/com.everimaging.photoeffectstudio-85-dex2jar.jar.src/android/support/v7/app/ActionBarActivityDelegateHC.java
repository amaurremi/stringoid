package android.support.v7.app;

class ActionBarActivityDelegateHC
        extends ActionBarActivityDelegateBase {
    ActionBarActivityDelegateHC(ActionBarActivity paramActionBarActivity) {
        super(paramActionBarActivity);
    }

    public ActionBar createSupportActionBar() {
        ensureSubDecor();
        return new ActionBarImplHC(this.mActivity, this.mActivity);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v7/app/ActionBarActivityDelegateHC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */