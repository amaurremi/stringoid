package mobi.beyondpod.ui.dialogs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.ThemeManager;
import mobi.beyondpod.ui.views.FeedItemContentViewDialog;

public class TrackPropertiesDialog
  extends Activity
{
  private static final String TAG = TrackPropertiesDialog.class.getSimpleName();
  View _BackToFeed;
  TextView _Description;
  View _HeaderArea;
  ImageView _Locked;
  View _OpenLink;
  TextView _ParentFeed;
  ImageView _Play;
  TextView _PubDate;
  ImageView _Share;
  ImageView _Star;
  TextView _Title;
  
  private void PlayTrack(Track paramTrack)
  {
    if (paramTrack != null)
    {
      if (paramTrack.IsPlayed()) {
        paramTrack.ClearPlayed();
      }
      CommandManager.CmdPlayPauseTrack(this, paramTrack, null);
      finish();
    }
  }
  
  void UpdateLockedImage(Track paramTrack)
  {
    ImageView localImageView = this._Locked;
    if (paramTrack.AllowAutoDelete()) {}
    for (int i = 2130837908;; i = 2130837909)
    {
      localImageView.setImageResource(i);
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    int j = 0;
    if (ThemeManager.CurrentDialogTheme() != -1) {
      setTheme(ThemeManager.CurrentDialogTheme());
    }
    super.onCreate(paramBundle);
    if (!BeyondPodApplication.IsInitialized())
    {
      finish();
      return;
    }
    requestWindowFeature(1);
    setContentView(2130903168);
    final Track localTrack = FeedRepository.GetTrackByPath(getIntent().getAction());
    if (localTrack == null) {
      finish();
    }
    this._Title = ((TextView)findViewById(2131230966));
    this._ParentFeed = ((TextView)findViewById(2131230950));
    this._Description = ((TextView)findViewById(2131231210));
    this._PubDate = ((TextView)findViewById(2131230967));
    this._HeaderArea = findViewById(2131230978);
    this._BackToFeed = findViewById(2131230983);
    this._OpenLink = findViewById(2131230984);
    this._Locked = ((ImageView)findViewById(2131231213));
    this._Play = ((ImageView)findViewById(2131231211));
    this._Share = ((ImageView)findViewById(2131231212));
    UpdateLockedImage(localTrack);
    paramBundle = this._Share;
    int i;
    TextView localTextView;
    if (localTrack.HasUrl())
    {
      i = 0;
      paramBundle.setVisibility(i);
      paramBundle = this._OpenLink;
      i = j;
      if (StringUtils.IsNullOrEmpty(localTrack.TrackPostUrl())) {
        i = 4;
      }
      paramBundle.setVisibility(i);
      this._BackToFeed.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          TrackPropertiesDialog.this.finish();
        }
      });
      paramBundle = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (!StringUtils.IsNullOrEmpty(localTrack.TrackPostUrl())) {
            FeedItemContentViewDialog.DoOpenOriginalSource(TrackPropertiesDialog.this, true, localTrack.TrackPostUrl(), localTrack.TrackPostTitle());
          }
        }
      };
      this._OpenLink.setOnClickListener(paramBundle);
      this._HeaderArea.setOnClickListener(paramBundle);
      this._Title.setText(localTrack.DisplayName());
      this._ParentFeed.setText(localTrack.getParentFeed().getName());
      localTextView = this._Description;
      if (!StringUtils.IsNullOrEmpty(localTrack.TrackDescription())) {
        break label425;
      }
      paramBundle = localTrack.getParentFeed().getName();
      label332:
      localTextView.setText(paramBundle);
      localTextView = this._PubDate;
      if (localTrack.getLastModifiedDate() == null) {
        break label434;
      }
    }
    label425:
    label434:
    for (paramBundle = DateTime.FormatDateTime(localTrack.getLastModifiedDate());; paramBundle = "")
    {
      localTextView.setText(paramBundle);
      this._Locked.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (localTrack.AllowAutoDelete()) {
            CommandManager.CmdLockTrack(TrackPropertiesDialog.this, localTrack);
          }
          for (;;)
          {
            TrackPropertiesDialog.this.UpdateLockedImage(localTrack);
            return;
            CommandManager.CmdUnlockTrack(TrackPropertiesDialog.this, localTrack);
          }
        }
      });
      this._Play.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          TrackPropertiesDialog.this.PlayTrack(localTrack);
        }
      });
      this._Share.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          CommandManager.CmdSharePodcast(TrackPropertiesDialog.this, localTrack);
        }
      });
      return;
      i = 8;
      break;
      paramBundle = localTrack.TrackDescription();
      break label332;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    CoreHelper.WriteTraceEntry(TAG, "Closing dialog activity when pausing...");
    finish();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/TrackPropertiesDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */