package mobi.beyondpod.ui.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.io.File;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.R.drawable;
import mobi.beyondpod.R.id;
import mobi.beyondpod.R.layout;
import mobi.beyondpod.R.string;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class Splash
  extends Activity
{
  private static final String TAG = Splash.class.getSimpleName();
  private Button _CancelBtn;
  private Button _ExitBtn;
  View.OnClickListener _ExitListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      CoreHelper.WriteTraceEntry(Splash.TAG, "Splash is exiting.");
      BeyondPodApplication.GetInstance().shutdown();
      Splash.this.finish();
    }
  };
  private RadioButton _External;
  private boolean _ExternalAvailable;
  private File _ExternalSDCardMount;
  private RadioButton _Internal;
  private boolean _InternalAvailable;
  private File _InternalSDCardMount;
  private Button _ResetBtn;
  private RadioGroup _SDCardSelector;
  private TextView _StatusMsg;
  
  private void InitAndRestartSplash()
  {
    try
    {
      Configuration.Initialize(getApplicationContext());
      Intent localIntent = getIntent();
      finish();
      startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      CoreHelper.LogException(TAG, "Failed to initialize Configuration", localException);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    CoreHelper.WriteTraceEntry(TAG, "Splash activity created!");
    if (BeyondPodApplication.IsInitialized())
    {
      startActivity(new Intent(this, BeyondPodApplication.GetInstance().MasterViewClass()));
      finish();
    }
    label289:
    label302:
    label505:
    label512:
    label520:
    label531:
    do
    {
      ImageView localImageView;
      do
      {
        return;
        setContentView(R.layout.splash);
        paramBundle = (TextView)findViewById(R.id.versionInfo);
        this._StatusMsg = ((TextView)findViewById(R.id.status));
        this._ResetBtn = ((Button)findViewById(R.id.btn_reset));
        this._ResetBtn.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            CoreHelper.WriteTraceEntry(Splash.TAG, "Detected invalid SD card root while using a cached root: " + Configuration.LastSDCardRootPath() + ", Trying to fix by autodetecting the SD Card root...");
            Configuration.setPreferLastSDCardRoot(false);
            Configuration.setLastSDCardRootPath(null);
            Splash.this.InitAndRestartSplash();
          }
        });
        this._CancelBtn = ((Button)findViewById(R.id.btn_cancel));
        this._CancelBtn.setOnClickListener(this._ExitListener);
        this._ExitBtn = ((Button)findViewById(R.id.btn_exit));
        this._ExitBtn.setOnClickListener(this._ExitListener);
        this._SDCardSelector = ((RadioGroup)findViewById(R.id.chooseSD));
        this._Internal = ((RadioButton)findViewById(R.id.internalSD));
        this._External = ((RadioButton)findViewById(R.id.externalSD));
        localImageView = (ImageView)findViewById(R.id.splashIcon);
        paramBundle.setText(Configuration.ProductVersionAsString());
        String str1 = CoreHelper.ExternalStorageState();
        this._InternalSDCardMount = Environment.getExternalStorageDirectory();
        File localFile = CoreHelper.ExternalStorageDirectory();
        boolean bool;
        Object localObject;
        int i;
        if ((this._InternalSDCardMount != null) && (this._InternalSDCardMount.exists()) && (this._InternalSDCardMount.canWrite()))
        {
          bool = true;
          this._InternalAvailable = bool;
          if (Configuration.ConfigurationInitErrorType == -1)
          {
            String str2 = TAG;
            if (!this._InternalAvailable) {
              break label505;
            }
            paramBundle = this._InternalSDCardMount;
            if (!this._ExternalAvailable) {
              break label512;
            }
            localObject = this._ExternalSDCardMount;
            CoreHelper.WriteTraceEntry(str2, String.format("BeyondPod external storage root %s is not available! Internal SD card: %s, External SD card: %s", new Object[] { localFile, paramBundle, localObject }));
          }
          if ((Configuration.ConfigurationInitErrorType != -1) || (!Configuration.PreferLastSDCardRoot()) || (StringUtils.IsNullOrEmpty(Configuration.LastSDCardRootPath())) || ((localFile != null) && (localFile.exists()) && (localFile.canWrite())) || ((!this._InternalAvailable) && (!this._ExternalAvailable))) {
            break label531;
          }
          CoreHelper.WriteTraceEntry(TAG, "Detected invalid SD card root while using a cached root: " + Configuration.LastSDCardRootPath() + ", Asking user if they want to reset...");
          localObject = this._StatusMsg;
          i = R.string.reset_storage_folder_current;
          if (!this._InternalAvailable) {
            break label520;
          }
        }
        for (paramBundle = this._InternalSDCardMount.getAbsolutePath();; paramBundle = this._ExternalSDCardMount.getAbsolutePath())
        {
          ((TextView)localObject).setText(getString(i, new Object[] { localFile, paramBundle }));
          this._SDCardSelector.setVisibility(8);
          this._ExitBtn.setVisibility(8);
          this._ResetBtn.setVisibility(0);
          this._CancelBtn.setVisibility(0);
          return;
          bool = false;
          break;
          paramBundle = "N/A";
          break label289;
          localObject = "N/A";
          break label302;
        }
        this._ExitBtn.setVisibility(0);
        if (!str1.equals("mounted"))
        {
          this._StatusMsg.setTextColor(-65536);
          localImageView.setImageResource(R.drawable.ic_mp_sd_card);
          if ((str1.equals("shared")) || (str1.equals("unmounted")))
          {
            this._StatusMsg.setText(R.string.error_SDCardBusy);
            return;
          }
          if (str1.equals("removed"))
          {
            this._StatusMsg.setText(R.string.error_SDCardMissing);
            return;
          }
          if (str1.equals("unmountable"))
          {
            this._StatusMsg.setText(R.string.error_SDCardError);
            return;
          }
          this._StatusMsg.setText(R.string.error_CantCreateRootFolder);
          return;
        }
      } while ((BeyondPodApplication.LastApplicationException == null) && (Configuration.ConfigurationInitErrorMsg == null));
      this._StatusMsg.setTextColor(-65536);
      localImageView.setImageResource(17301543);
      if (BeyondPodApplication.LastApplicationException != null) {
        this._StatusMsg.setText(BeyondPodApplication.LastApplicationException);
      }
    } while (Configuration.ConfigurationInitErrorMsg == null);
    this._StatusMsg.setText(Configuration.ConfigurationInitErrorMsg);
  }
  
  protected void onDestroy()
  {
    CoreHelper.WriteTraceEntry(TAG, "Splash activity destroyed!");
    super.onDestroy();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/Splash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */