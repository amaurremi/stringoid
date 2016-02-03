package mobi.beyondpod.ui.views.impexp;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.io.File;
import java.io.FilenameFilter;
import java.util.UUID;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarActivityBase;
import mobi.beyondpod.ui.core.ActionBarHelper;

public class ImportOPMLActivity
  extends ActionBarActivityBase
{
  private static final String TAG = ImportOPMLActivity.class.getSimpleName();
  private Spinner _FileNames;
  File[] _FilesToImport;
  private Button _ImportButton;
  private TextView _Message;
  private View.OnClickListener _OnImportListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = ImportOPMLActivity.this._FilesToImport[ImportOPMLActivity.this._FileNames.getSelectedItemPosition()];
      Feed localFeed = new Feed(UUID.randomUUID(), null, paramAnonymousView.getName(), Uri.fromFile(paramAnonymousView).toString(), 4);
      CoreHelper.WriteLogEntryInProduction(ImportOPMLActivity.TAG, "OPML File Selected: " + paramAnonymousView + ", Url:" + localFeed.getFeedUrl());
      CommandManager.CmdOpenOpmlImporter(localFeed);
    }
  };
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903129);
    this._ImportButton = ((Button)findViewById(2131231082));
    this._Message = ((TextView)findViewById(2131231080));
    this._FileNames = ((Spinner)findViewById(2131231081));
    this._Message.setText(String.format(getResources().getText(2131296887).toString(), new Object[] { Configuration.BeyondPodPublicStorageRootPath() }));
    this._ImportButton.setOnClickListener(this._OnImportListener);
    this._FilesToImport = new File(Configuration.BeyondPodPublicStorageRootPath()).listFiles(new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return paramAnonymousString.endsWith("opml");
      }
    });
    paramBundle = new String[this._FilesToImport.length];
    int i = 0;
    if (i == this._FilesToImport.length)
    {
      paramBundle = new ArrayAdapter(this, 17367048, paramBundle);
      paramBundle.setDropDownViewResource(17367049);
      this._FileNames.setAdapter(paramBundle);
      paramBundle = this._ImportButton;
      if (this._FilesToImport.length <= 0) {
        break label215;
      }
    }
    label215:
    for (boolean bool = true;; bool = false)
    {
      paramBundle.setEnabled(bool);
      getActionBarHelper().setDisplayOptions(4, 4);
      return;
      paramBundle[i] = this._FilesToImport[i].getName();
      i += 1;
      break;
    }
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/impexp/ImportOPMLActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */