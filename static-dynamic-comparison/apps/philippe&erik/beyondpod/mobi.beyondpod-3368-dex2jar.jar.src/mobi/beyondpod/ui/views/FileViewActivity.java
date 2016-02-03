package mobi.beyondpod.ui.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarActivityBase;
import mobi.beyondpod.ui.core.ActionBarHelper;

public class FileViewActivity
  extends ActionBarActivityBase
{
  private static final int MENU_EMAIL_SUPPORT = 1;
  private static final int MENU_SCROLL_TO_END = 0;
  private static final int MENU_TRUNCATE_LOG = 2;
  private String _CurrentFile;
  private TextView _EditText;
  private ScrollView _textScroller;
  
  private void ScrollToEnd()
  {
    this._textScroller.post(new Runnable()
    {
      public void run()
      {
        FileViewActivity.this._textScroller.scrollTo(0, FileViewActivity.this._EditText.getHeight());
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this._EditText = new EditText(this);
    setContentView(2130903125);
    this._textScroller = ((ScrollView)findViewById(2131231071));
    this._EditText = ((TextView)findViewById(2131231072));
    this._EditText.setMovementMethod(ScrollingMovementMethod.getInstance());
    this._EditText.setClickable(false);
    this._EditText.setLongClickable(false);
    if (paramBundle == null)
    {
      paramBundle = getIntent();
      if (paramBundle.getData() != null) {
        this._CurrentFile = "";
      }
    }
    for (;;)
    {
      try
      {
        this._CurrentFile = paramBundle.getData().getPath();
        setTitle(paramBundle.getData().getLastPathSegment());
        Object localObject = new FileInputStream(this._CurrentFile);
        arrayOfByte = new byte['က'];
        localByteArrayOutputStream = new ByteArrayOutputStream();
        i = ((InputStream)localObject).read(arrayOfByte);
        if (i != -1) {
          continue;
        }
        localByteArrayOutputStream.close();
        ((InputStream)localObject).close();
        localObject = localByteArrayOutputStream.toString();
        this._EditText.setText((CharSequence)localObject);
        if (paramBundle.getBooleanExtra("ScrollToEnd", false)) {
          ScrollToEnd();
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        byte[] arrayOfByte;
        ByteArrayOutputStream localByteArrayOutputStream;
        int i;
        Toast.makeText(this, "File " + this._CurrentFile + " was not found!", 0).show();
        continue;
      }
      catch (IOException localIOException)
      {
        continue;
      }
      if (paramBundle.getStringExtra("Title") != null) {
        setTitle(paramBundle.getStringExtra("Title"));
      }
      getActionBarHelper().setDisplayOptions(4, 4);
      return;
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
    case 16908332: 
    case 0: 
    case 1: 
      for (;;)
      {
        return false;
        finish();
        return true;
        ScrollToEnd();
        continue;
        CommandManager.CmdSendEMail(this, "support@beyondpod.mobi", "BeyondPod Log File", "Attached is " + this._CurrentFile, this._CurrentFile, true);
      }
    }
    CoreHelper.TruncateLogFile(new File(this._CurrentFile));
    this._EditText.setText("");
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
    paramMenu.add(0, 0, 0, "View Bottom").setIcon(2130837954);
    paramMenu.add(0, 1, 1, "Email Support").setIcon(2130837981);
    if ((Configuration.LogFilePath().equals(this._CurrentFile)) || (Configuration.SyncLogFilePath().equals(this._CurrentFile))) {
      paramMenu.add(0, 2, 2, "Truncate Log File").setIcon(2130837974);
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/FileViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */