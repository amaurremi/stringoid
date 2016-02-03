package mobi.beyondpod.ui.dialogs;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.ItemStateHistory;

public class ExternalPlayerStarterActivity
  extends Activity
{
  public static int REQUEST_CODE_CmdOpenExternalPlayer = 0;
  private static final String TAG = ExternalPlayerStarterActivity.class.getSimpleName();
  Handler _Handler;
  ProgressDialog _RepoLoadingDlg;
  int _UpdateTrackWhenRepositoryLoadsRetryCount;
  
  private void UpdateTrackWhenRepositoryLoads(final String paramString, final long paramLong1, long paramLong2, final Float paramFloat, long paramLong3)
  {
    if (FeedRepository.RepositoryLoadState() != 2)
    {
      if (this._UpdateTrackWhenRepositoryLoadsRetryCount > 0)
      {
        this._UpdateTrackWhenRepositoryLoadsRetryCount -= 1;
        CoreHelper.WriteTraceEntry(TAG, "Trying to update the last plying track from external Player, Waiting for repository to load: " + this._UpdateTrackWhenRepositoryLoadsRetryCount);
        if (this._RepoLoadingDlg == null)
        {
          this._RepoLoadingDlg = new ProgressDialog(this);
          this._RepoLoadingDlg.setIndeterminate(true);
          this._RepoLoadingDlg.setCancelable(false);
          this._RepoLoadingDlg.setMessage(getResources().getString(2131296904));
          this._RepoLoadingDlg.show();
        }
        this._Handler.postDelayed(new Runnable()
        {
          public void run()
          {
            ExternalPlayerStarterActivity.this.UpdateTrackWhenRepositoryLoads(paramString, paramLong1, paramFloat, this.val$pctPlayed, this.val$totalTime);
          }
        }, 5000L);
        return;
      }
      CoreHelper.WriteLogEntryInProduction(TAG, "Trying to update the last plying track from external Player, but repository is taking too long to load. Giving up.");
      if (this._RepoLoadingDlg != null) {
        this._RepoLoadingDlg.dismiss();
      }
      finish();
      return;
    }
    Track localTrack2 = FeedRepository.GetTrackByPath(paramString);
    Track localTrack1 = localTrack2;
    if (localTrack2 == null) {
      localTrack1 = FeedRepository.GetTrackByUrl(paramString);
    }
    if (localTrack1 != null) {
      if (paramFloat.floatValue() >= 0.0F)
      {
        if (localTrack1.getTotalTime() == 0L) {
          localTrack1.setTotalTime(paramLong3);
        }
        paramLong1 = ((float)localTrack1.getTotalTime() * paramFloat.floatValue());
        CoreHelper.WriteLogEntryInProduction(TAG, "External Player finished playing track: " + localTrack1.getName() + "(" + paramString + ") at position: " + paramLong1 + ", Toatl Time: " + localTrack1.getTotalTime() + ", Pct:" + paramFloat);
        if (paramLong1 >= 0L) {
          localTrack1.setPlayedTime(paramLong1);
        }
      }
    }
    for (;;)
    {
      if (this._RepoLoadingDlg != null) {
        this._RepoLoadingDlg.dismiss();
      }
      finish();
      return;
      if (paramLong2 >= 0L)
      {
        if (localTrack1.getTotalTime() == 0L) {
          localTrack1.setTotalTime(paramLong3);
        }
        CoreHelper.WriteLogEntryInProduction(TAG, "External Player finished playing track: " + localTrack1.getName() + "(" + paramString + ") at position: " + paramLong2 + ", Toatl Time: " + localTrack1.getTotalTime());
        localTrack1.setPlayedTime(paramLong2);
      }
      else if (System.currentTimeMillis() - paramLong1 > 10000L)
      {
        CoreHelper.WriteLogEntryInProduction(TAG, "External Player finished playing track: " + localTrack1.getName() + ". Track marlked as Played!");
        localTrack1.MarkPlayed();
        ItemStateHistory.MarkTracksItemAsRead(localTrack1);
      }
      else
      {
        CoreHelper.WriteLogEntryInProduction(TAG, "External Player finished playing track: " + localTrack1.getName() + ". Playback was too short. Ignoring");
        continue;
        CoreHelper.WriteLogEntryInProduction(TAG, "External Player finished playing, but track: " + paramString + " was not found!");
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    CoreHelper.WriteTraceEntry(TAG, "Received Activity Result: " + paramIntent);
    String str1;
    long l3;
    Object localObject;
    long l1;
    long l2;
    float f1;
    if (paramInt1 == REQUEST_CODE_CmdOpenExternalPlayer)
    {
      this._UpdateTrackWhenRepositoryLoadsRetryCount = 10;
      str1 = "";
      float f2 = -1.0F;
      long l4 = -1L;
      l3 = -1L;
      localObject = str1;
      l1 = l3;
      l2 = l4;
      f1 = f2;
      if (paramIntent != null) {
        if (paramInt2 != -1)
        {
          localObject = str1;
          l1 = l3;
          l2 = l4;
          f1 = f2;
          if (paramInt2 != 0) {}
        }
        else
        {
          String str2 = paramIntent.getStringExtra("filePath");
          localObject = str2;
          if (str2 == null)
          {
            if (!StringUtils.Equals(paramIntent.getData().getScheme(), "file")) {
              break label300;
            }
            localObject = paramIntent.getData().getPath();
          }
          if (localObject != null) {
            str1 = CoreHelper.SafeDecodeUrl((String)localObject);
          }
          if (!StringUtils.Equals("com.mxtech.intent.result.VIEW", paramIntent.getAction())) {
            break label317;
          }
          l2 = paramIntent.getIntExtra("position", -1);
          l1 = l2;
          if (l2 > -1L) {
            l1 = l2 / 1000L;
          }
          if (l1 <= -1L) {
            break label309;
          }
          l2 = 2L * l1;
          label218:
          l2 = paramIntent.getIntExtra("duration", (int)l2);
          CoreHelper.WriteTraceEntry(TAG, "Received MXPlayer return result! File: " + (String)localObject + ", Position: " + l1 + ", Duration: " + l2);
          f1 = f2;
          localObject = str1;
        }
      }
    }
    for (;;)
    {
      UpdateTrackWhenRepositoryLoads((String)localObject, 0L, l1, Float.valueOf(f1), l2);
      return;
      label300:
      localObject = paramIntent.getDataString();
      break;
      label309:
      l2 = 1000L;
      break label218;
      label317:
      f1 = paramIntent.getFloatExtra("position", -1.0F);
      l2 = paramIntent.getIntExtra("duration", 1000);
      localObject = str1;
      l1 = l3;
    }
  }
  
  protected void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this._Handler = new Handler();
    if (!BeyondPodApplication.IsInitialized())
    {
      CoreHelper.WriteTraceEntry(TAG, "ExternalPlayerStarterActivity started with no storage card. Exiting...");
      finish();
    }
    Intent localIntent;
    do
    {
      return;
      localIntent = getIntent();
      CoreHelper.WriteTraceEntry(TAG, "External Player Starter received intent: " + localIntent + ", flags: " + localIntent.getFlags());
    } while ((!StringUtils.Equals("android.intent.action.VIEW", localIntent.getAction())) || (paramBundle != null));
    paramBundle = new Intent();
    paramBundle.fillIn(localIntent, 0);
    paramBundle.setComponent(null);
    CoreHelper.WriteTraceEntry(TAG, "Starting playback in external player for: " + paramBundle.getData().getPath());
    setIntent(null);
    this._Handler.postDelayed(new Runnable()
    {
      public void run()
      {
        ExternalPlayerStarterActivity.this.startActivityForResult(paramBundle, ExternalPlayerStarterActivity.REQUEST_CODE_CmdOpenExternalPlayer);
      }
    }, 200L);
  }
  
  protected void onDestroy()
  {
    CoreHelper.WriteTraceEntry(TAG, "On Destroy()!");
    super.onDestroy();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("AAA", true);
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onStart()
  {
    CoreHelper.WriteTraceEntry(TAG, "On Start()!");
    super.onStart();
  }
  
  protected void onStop()
  {
    CoreHelper.WriteTraceEntry(TAG, "On Stop()!");
    super.onDestroy();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/ExternalPlayerStarterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */