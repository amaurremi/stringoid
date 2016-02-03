package mobi.beyondpod.ui.core;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

public abstract class ActionBarListActivityBase
  extends ListActivity
{
  final ActionBarHelper mActionBarHelper = ActionBarHelper.createInstance(this);
  
  protected ActionBarHelper getActionBarHelper()
  {
    return this.mActionBarHelper;
  }
  
  public MenuInflater getMenuInflater()
  {
    return this.mActionBarHelper.getMenuInflater(super.getMenuInflater());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mActionBarHelper.onCreate(paramBundle);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return false | this.mActionBarHelper.onCreateOptionsMenu(paramMenu) | super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    this.mActionBarHelper.onPostCreate(paramBundle);
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    this.mActionBarHelper.onTitleChanged(paramCharSequence, paramInt);
    super.onTitleChanged(paramCharSequence, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/ActionBarListActivityBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */