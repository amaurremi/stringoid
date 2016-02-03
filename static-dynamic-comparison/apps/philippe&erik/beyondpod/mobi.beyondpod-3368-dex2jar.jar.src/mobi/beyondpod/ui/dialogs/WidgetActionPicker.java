package mobi.beyondpod.ui.dialogs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.rss.LicenseManager;
import mobi.beyondpod.services.player.MediaPlaybackService;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.services.player.SmartPlaylistTemplate;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.views.Splash;

public class WidgetActionPicker
  extends Activity
{
  private static final String OPEN_BEYOND_POD = CoreHelper.LoadResourceString(2131297112);
  private static final String START_SMART_PLAY;
  private static final String TAG = WidgetActionPicker.class.getSimpleName();
  private static final String UPDATE_SMART_PLAY_FEEDS = CoreHelper.LoadResourceString(2131297110);
  private int[] mImages = { 2130837956, 2130837967, 2130837975 };
  private String[] mStrings = { OPEN_BEYOND_POD, START_SMART_PLAY, UPDATE_SMART_PLAY_FEEDS };
  
  static
  {
    START_SMART_PLAY = CoreHelper.LoadResourceString(2131297111);
  }
  
  private void OpenBeyondPodUI()
  {
    Intent localIntent = new Intent(this, BeyondPodApplication.GetInstance().MasterViewClass());
    localIntent.setFlags(536870912);
    localIntent.setData(Uri.parse("mobi.beyondpod.ui.dialogs.WidgetActionPicker"));
    startActivity(localIntent);
  }
  
  private void StartSmartPlay()
  {
    Intent localIntent = new Intent(BeyondPodApplication.GetInstance(), MediaPlaybackService.class);
    localIntent.setAction("mobi.beyondpod.services.musicservicewidgetcommand.startsmartplay");
    startService(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!BeyondPodApplication.IsInitialized())
    {
      CoreHelper.WriteTraceEntry(TAG, "WidgetActionPicker started with no storage card. Exiting...");
      startActivity(new Intent(getApplicationContext(), Splash.class));
      finish();
      return;
    }
    if (!SmartPlaylistTemplate.IsConfigured())
    {
      OpenBeyondPodUI();
      finish();
      return;
    }
    requestWindowFeature(1);
    setContentView(2130903175);
    paramBundle = (ListView)findViewById(2131231227);
    paramBundle.setAdapter(new IconicAdapter(this));
    paramBundle.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          WidgetActionPicker.this.finish();
          return;
          WidgetActionPicker.this.OpenBeyondPodUI();
          continue;
          WidgetActionPicker.this.StartSmartPlay();
          continue;
          if (!LicenseManager.CheckAndNotifyIfInRestrictedMode()) {
            CommandManager.CmdUpdateSmartPlayList();
          }
        }
      }
    });
  }
  
  class IconicAdapter
    extends ArrayAdapter<String>
  {
    private final String NOW_PLAYING = CoreHelper.LoadResourceString(2131297010);
    Activity context;
    
    IconicAdapter(Activity paramActivity)
    {
      super(2130903176, WidgetActionPicker.this.mStrings);
      this.context = paramActivity;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = this.context.getLayoutInflater().inflate(2130903176, null);
      paramViewGroup = (TextView)paramView.findViewById(2131231229);
      ImageView localImageView = (ImageView)paramView.findViewById(2131231228);
      if (paramInt > 0)
      {
        paramViewGroup.setText(WidgetActionPicker.this.mStrings[paramInt]);
        localImageView.setImageResource(WidgetActionPicker.this.mImages[paramInt]);
        return paramView;
      }
      if ((BeyondPodApplication.GetInstance().PlayList().CurrentTrack() != null) && (BeyondPodApplication.GetInstance().PlayList().CurrentTrack().getCurrentPlayState() == 1))
      {
        paramViewGroup.setText(this.NOW_PLAYING);
        localImageView.setImageResource(2130837947);
        return paramView;
      }
      paramViewGroup.setText(WidgetActionPicker.this.mStrings[paramInt]);
      localImageView.setImageResource(WidgetActionPicker.this.mImages[paramInt]);
      return paramView;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/WidgetActionPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */