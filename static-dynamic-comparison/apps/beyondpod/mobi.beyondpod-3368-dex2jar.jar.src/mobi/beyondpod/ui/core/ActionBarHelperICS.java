package mobi.beyondpod.ui.core;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;

public class ActionBarHelperICS
  extends ActionBarHelperHoneycomb
{
  protected ActionBarHelperICS(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  @SuppressLint({"NewApi"})
  protected Context getActionBarThemedContext()
  {
    return this._Activity.getActionBar().getThemedContext();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/ActionBarHelperICS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */