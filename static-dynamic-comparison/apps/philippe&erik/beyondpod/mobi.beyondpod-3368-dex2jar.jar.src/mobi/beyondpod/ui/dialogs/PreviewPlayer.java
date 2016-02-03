package mobi.beyondpod.ui.dialogs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import java.util.UUID;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ActionBarActivityBase;
import mobi.beyondpod.ui.core.ActionBarHelper;

public class PreviewPlayer
  extends ActionBarActivityBase
{
  private static final String TAG = PreviewPlayer.class.getSimpleName();
  private PreviewPlayerControl mControl;
  private boolean mControlResumed = false;
  Feed mCurrentFeed;
  private boolean mFinishOnCompletion;
  private boolean mFocused = false;
  private boolean mResumed = false;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getActionBarHelper().setDisplayOptions(4, 4);
    setContentView(2130903154);
    paramBundle = findViewById(2131231101);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("android.intent.extra.album");
    if (!StringUtils.IsNullOrEmpty(str)) {
      this.mCurrentFeed = Configuration.FindFeedByIdInTempOrRepository(UUID.fromString(str));
    }
    int j = localIntent.getIntExtra("output", -1);
    int i = j;
    if (j == -1)
    {
      str = localIntent.getType();
      if ((!StringUtils.IsNullOrEmpty(str)) && (!str.startsWith("audio"))) {
        break label258;
      }
      i = 1;
    }
    for (;;)
    {
      CoreHelper.WriteTraceEntry(TAG, "Starting preview of " + localIntent.getDataString() + ", Feed: " + this.mCurrentFeed + ", Type:" + i + ", mime:" + localIntent.getType());
      CommandManager.CmdPauseAudioPlayback();
      this.mControl = new PreviewPlayerControl(paramBundle, this, localIntent.getData(), this.mCurrentFeed, i)
      {
        public void onCompletion()
        {
          if (PreviewPlayer.this.mFinishOnCompletion) {
            PreviewPlayer.this.finish();
          }
        }
      };
      if (localIntent.hasExtra("android.intent.extra.screenOrientation"))
      {
        i = localIntent.getIntExtra("android.intent.extra.screenOrientation", -1);
        if (i != getRequestedOrientation()) {
          setRequestedOrientation(i);
        }
      }
      if (localIntent.hasExtra("android.intent.extra.title")) {
        setTitle(localIntent.getStringExtra("android.intent.extra.title"));
      }
      this.mFinishOnCompletion = localIntent.getBooleanExtra("android.intent.extra.finishOnCompletion", true);
      return;
      label258:
      if (str.startsWith("video"))
      {
        i = 2;
      }
      else
      {
        i = j;
        if (str.startsWith("image")) {
          i = 3;
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mControl.onDestroy();
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
  
  public void onPause()
  {
    super.onPause();
    this.mResumed = false;
    if (this.mControlResumed)
    {
      this.mControl.onPause();
      this.mControlResumed = false;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.mResumed = true;
    if ((this.mFocused) && (this.mResumed) && (!this.mControlResumed))
    {
      this.mControl.onResume();
      this.mControlResumed = true;
    }
    if (this.mCurrentFeed != null) {
      getActionBarHelper().setSubtitle(this.mCurrentFeed.getName());
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    this.mFocused = paramBoolean;
    if ((this.mFocused) && (this.mResumed) && (!this.mControlResumed))
    {
      this.mControl.onResume();
      this.mControlResumed = true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/PreviewPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */