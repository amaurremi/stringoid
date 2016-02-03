package mobi.beyondpod.ui.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.ViewConfiguration;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.ui.views.base.ActionModeBP;
import mobi.beyondpod.ui.views.base.ActionModeBP.Callback;

public abstract class ActionBarHelper
{
  protected Activity _Activity;
  
  protected ActionBarHelper(Activity paramActivity)
  {
    this._Activity = paramActivity;
  }
  
  @SuppressLint({"NewApi"})
  public static boolean HasPermanentMenuKey()
  {
    if (Build.VERSION.SDK_INT < 14) {
      return Build.VERSION.SDK_INT < 11;
    }
    return ViewConfiguration.get(BeyondPodApplication.GetInstance().getApplicationContext()).hasPermanentMenuKey();
  }
  
  public static ActionBarHelper createInstance(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return new ActionBarHelperICS(paramActivity);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      return new ActionBarHelperHoneycomb(paramActivity);
    }
    return new ActionBarHelperEmulate(paramActivity);
  }
  
  public MenuInflater getMenuInflater(MenuInflater paramMenuInflater)
  {
    return paramMenuInflater;
  }
  
  public abstract void invalidateOptionsMenu();
  
  public void onCreate(Bundle paramBundle) {}
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return true;
  }
  
  public void onPostCreate(Bundle paramBundle) {}
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt) {}
  
  public abstract void setDisplayOptions(int paramInt1, int paramInt2);
  
  public abstract void setRefreshActionItemState(boolean paramBoolean);
  
  public abstract void setSubtitle(String paramString);
  
  public abstract ActionModeBP startActionMode(ActionModeBP.Callback paramCallback);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/ActionBarHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */