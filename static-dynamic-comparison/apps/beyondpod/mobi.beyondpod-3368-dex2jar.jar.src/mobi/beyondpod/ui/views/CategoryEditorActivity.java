package mobi.beyondpod.ui.views;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarActivityBase;
import mobi.beyondpod.ui.core.ActionBarHelper;
import mobi.beyondpod.ui.core.ThemeManager;
import mobi.beyondpod.ui.views.base.ActionModeBP;
import mobi.beyondpod.ui.views.notifications.UserNotificationManager;

public class CategoryEditorActivity
  extends ActionBarActivityBase
{
  private static final String BEYOND_POD_HELP = CoreHelper.LoadResourceString(2131297061);
  private static final String TAG = CategoryEditorActivity.class.getSimpleName();
  CategoriesListView _Categories;
  private ActionModeBP _CurrentActionMode;
  
  protected void onCreate(Bundle paramBundle)
  {
    if (ThemeManager.CurrentPopupWindowTheme() != -1) {
      setTheme(ThemeManager.CurrentPopupWindowTheme());
    }
    super.onCreate(paramBundle);
    if (!FeedRepository.IsRepositoryAvailable())
    {
      CoreHelper.WriteTraceEntry(TAG, "Closing view because the repository is not Loaded");
      finish();
      return;
    }
    getActionBarHelper().setDisplayOptions(4, 4);
    setContentView(2130903086);
    this._Categories = ((CategoriesListView)findViewById(2131230884));
    this._Categories.Initialize();
    setTitle(2131296631);
    getActionBarHelper().setSubtitle(String.valueOf(this._Categories.VisibleCount()));
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131755010, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this._CurrentActionMode != null))
    {
      this._CurrentActionMode.finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332: 
      finish();
      return true;
    case 2131231249: 
      CommandManager.CmdAddNewCategory();
      return true;
    }
    CommandManager.CmdStartHtmlViewActivity(Configuration.HelpFileSchedulingURL(), BEYOND_POD_HELP, false);
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this._Categories != null) {
      this._Categories.OnAfterDeactivate();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this._Categories != null) {
      this._Categories.OnBeforeActivate();
    }
    UserNotificationManager.TipNotifyOnceCategories((ViewGroup)findViewById(2131230881));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/CategoryEditorActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */