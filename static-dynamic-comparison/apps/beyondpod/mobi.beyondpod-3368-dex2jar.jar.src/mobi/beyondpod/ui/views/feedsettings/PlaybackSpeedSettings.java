package mobi.beyondpod.ui.views.feedsettings;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.PlaybackSpeedControl;

public class PlaybackSpeedSettings
  extends PlaybackSpeedControl
{
  CheckBox _CustomPlaybackSpeed;
  View _PlaybackSpeedControls;
  
  public PlaybackSpeedSettings(View paramView)
  {
    super(paramView);
    this._CustomPlaybackSpeed = ((CheckBox)paramView.findViewById(2131231007));
    this._PlaybackSpeedControls = paramView.findViewById(2131231008);
    CheckBox localCheckBox = this._CustomPlaybackSpeed;
    if (Configuration.EnableAudioPlugins()) {}
    for (int i = 0;; i = 8)
    {
      localCheckBox.setVisibility(i);
      paramView.findViewById(2131231010).setVisibility(this._CustomPlaybackSpeed.getVisibility());
      return;
    }
  }
  
  public void initialize(int paramInt)
  {
    super.initialize(paramInt);
    CheckBox localCheckBox = this._CustomPlaybackSpeed;
    if (this._Speed != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localCheckBox.setChecked(bool);
      this._CustomPlaybackSpeed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean) {}
          for (PlaybackSpeedSettings.this._Speed = Math.round(Configuration.PlaybackSpeed1() * 100.0F);; PlaybackSpeedSettings.this._Speed = 0)
          {
            PlaybackSpeedSettings.this.updateSpeed();
            return;
          }
        }
      });
      return;
    }
  }
  
  protected void updateSpeed()
  {
    if ((this._CustomPlaybackSpeed.getVisibility() == 0) && (this._Speed != 0))
    {
      super.updateSpeed();
      this._PlaybackSpeedControls.setVisibility(0);
      return;
    }
    this._PlaybackSpeedControls.setVisibility(8);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/feedsettings/PlaybackSpeedSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */