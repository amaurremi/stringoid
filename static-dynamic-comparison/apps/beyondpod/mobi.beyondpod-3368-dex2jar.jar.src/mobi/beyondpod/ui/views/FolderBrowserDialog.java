package mobi.beyondpod.ui.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import java.io.File;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.ui.core.ActionBarActivityBase;
import mobi.beyondpod.ui.core.ActionBarHelper;

public class FolderBrowserDialog
  extends ActionBarActivityBase
  implements View.OnClickListener
{
  private static final String TAG = FolderBrowserDialog.class.getSimpleName();
  private FolderBrowserViewAdapter _Adapter;
  ListView _Content;
  
  private void SetRootFeed(File paramFile)
  {
    this._Adapter.SetRoot(paramFile);
    setTitle(paramFile.getPath());
    this._Content.postDelayed(new Runnable()
    {
      public void run()
      {
        FolderBrowserDialog.this._Content.setSelectionAfterHeaderView();
      }
    }, 100L);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    do
    {
      return;
      paramView = (File)paramView.getTag();
    } while (paramView == null);
    Intent localIntent = new Intent();
    localIntent.setData(Uri.fromFile(paramView));
    setResult(-1, localIntent);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!FeedRepository.IsRepositoryAvailable())
    {
      CoreHelper.WriteTraceEntry(TAG, "Closing view because the repository is not Loaded");
      finish();
      return;
    }
    setContentView(2130903126);
    this._Content = ((ListView)findViewById(2131231073));
    this._Adapter = new FolderBrowserViewAdapter(this);
    this._Content.setAdapter(this._Adapter);
    this._Adapter.SetRoot(null);
    this._Content.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = FolderBrowserDialog.this._Adapter.getFileAt(paramAnonymousInt);
        FolderBrowserDialog.this.SetRootFeed(paramAnonymousAdapterView);
      }
    });
    getActionBarHelper().setDisplayOptions(4, 4);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this._Adapter.CanGoUp()))
    {
      SetRootFeed(this._Adapter.GetParentDirectory());
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    if (!this._Adapter.CanGoUp()) {
      finish();
    }
    for (;;)
    {
      return true;
      SetRootFeed(this._Adapter.GetParentDirectory());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/FolderBrowserDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */