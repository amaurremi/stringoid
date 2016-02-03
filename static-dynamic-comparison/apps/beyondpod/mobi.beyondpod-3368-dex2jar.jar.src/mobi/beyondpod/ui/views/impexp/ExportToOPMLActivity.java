package mobi.beyondpod.ui.views.impexp;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.ui.core.ActionBarActivityBase;
import mobi.beyondpod.ui.core.ActionBarHelper;

public class ExportToOPMLActivity
  extends ActionBarActivityBase
{
  private static final String EXPORT_COMPLETE = CoreHelper.LoadResourceString(2131297114);
  private static final String EXPORT_FAILED = CoreHelper.LoadResourceString(2131297113);
  private Button _ExportButton;
  private TextView _Message;
  private View.OnClickListener _OnExportListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      try
      {
        FeedRepository.SaveRepositoryAsOpml(new File(Configuration.BeyondPodPublicStorageRootPath(), "BeyondPodFeeds.opml").getPath());
        Toast.makeText(ExportToOPMLActivity.this, ExportToOPMLActivity.EXPORT_COMPLETE, 0).show();
        return;
      }
      catch (Exception paramAnonymousView)
      {
        Toast.makeText(ExportToOPMLActivity.this, ExportToOPMLActivity.EXPORT_FAILED + "\n" + paramAnonymousView.getMessage(), 0).show();
      }
    }
  };
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903104);
    this._ExportButton = ((Button)findViewById(2131230941));
    this._Message = ((TextView)findViewById(2131230940));
    this._Message.setText(String.format(getResources().getText(2131296885).toString(), new Object[] { Configuration.BeyondPodPublicStorageRootPath() }));
    this._ExportButton.setOnClickListener(this._OnExportListener);
    getActionBarHelper().setDisplayOptions(4, 4);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    finish();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/impexp/ExportToOPMLActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */