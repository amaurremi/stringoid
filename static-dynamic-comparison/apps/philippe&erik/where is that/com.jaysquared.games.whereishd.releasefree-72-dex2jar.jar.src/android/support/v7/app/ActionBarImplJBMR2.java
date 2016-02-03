package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;

public class ActionBarImplJBMR2
  extends ActionBarImplJB
{
  public ActionBarImplJBMR2(Activity paramActivity, ActionBar.Callback paramCallback)
  {
    super(paramActivity, paramCallback);
  }
  
  public void setHomeActionContentDescription(int paramInt)
  {
    this.mActionBar.setHomeActionContentDescription(paramInt);
  }
  
  public void setHomeActionContentDescription(CharSequence paramCharSequence)
  {
    this.mActionBar.setHomeActionContentDescription(paramCharSequence);
  }
  
  public void setHomeAsUpIndicator(int paramInt)
  {
    this.mActionBar.setHomeAsUpIndicator(paramInt);
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable)
  {
    this.mActionBar.setHomeAsUpIndicator(paramDrawable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/android/support/v7/app/ActionBarImplJBMR2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */