package com.troll.face;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.appfireworks.android.track.AppTracker;
import com.google.ads.Ad;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.InterstitialAd;
import com.jtpgodorncrqoeurl.AdController;

public class MenuActivity
  extends Activity
  implements com.google.ads.AdListener
{
  private AdController ad;
  private AdController audioAd;
  private int countBackPush = 0;
  DBAdapter db;
  private InterstitialAd interstitial;
  private View.OnClickListener menuopt2Listener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      MenuActivity.this.getPackageName();
      paramAnonymousView = new Intent(MenuActivity.this, MyGalleryActivity.class);
      MenuActivity.this.startActivity(paramAnonymousView);
    }
  };
  private View.OnClickListener menuopt3Listener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      MenuActivity.this.getPackageName();
      paramAnonymousView = new Intent(MenuActivity.this, GalleryActivity.class);
      MenuActivity.this.startActivity(paramAnonymousView);
    }
  };
  private View.OnClickListener menuopt4Listener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = new Intent("android.intent.action.VIEW");
      paramAnonymousView.setData(Uri.parse("market://details?id=com.troll.face.complete"));
      MenuActivity.this.startActivity(paramAnonymousView);
    }
  };
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2130903045);
    getWindow().setFeatureInt(7, 2130903051);
    this.audioAd = new AdController(this, "734590306");
    this.audioAd.resumeAd();
    this.audioAd.loadAudioAd();
    this.interstitial = new InterstitialAd(this, "ca-app-pub-8845149727287653/3470104379");
    paramBundle = new AdRequest();
    this.interstitial.loadAd(paramBundle);
    this.interstitial.setAdListener(this);
    if (Environment.getExternalStorageState().equalsIgnoreCase("MOUNTED")) {
      this.db = new DBAdapter(this);
    }
    ((Button)findViewById(2131165201)).setOnClickListener(this.menuopt2Listener);
    ((Button)findViewById(2131165200)).setOnClickListener(this.menuopt3Listener);
    ((Button)findViewById(2131165202)).setOnClickListener(this.menuopt4Listener);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.ad != null) {
      this.ad.destroyAd();
    }
    if (this.audioAd != null)
    {
      this.audioAd.pauseAd();
      this.audioAd.destroyAd();
    }
    AppTracker.closeSession(getApplicationContext(), true);
  }
  
  public void onDismissScreen(Ad paramAd)
  {
    this.audioAd = new AdController(this, "734590306");
    this.audioAd.resumeAd();
    this.audioAd.loadAudioAd();
  }
  
  public void onFailedToReceiveAd(Ad paramAd, AdRequest.ErrorCode paramErrorCode) {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.countBackPush += 1;
      new AdController(this, "609944004", new com.jtpgodorncrqoeurl.AdListener()
      {
        public void onAdAlreadyCompleted()
        {
          MenuActivity.this.audioAd.destroyAd();
          jdField_this.finish();
        }
        
        public void onAdClicked() {}
        
        public void onAdClosed()
        {
          MenuActivity.this.audioAd.destroyAd();
          jdField_this.finish();
        }
        
        public void onAdCompleted()
        {
          MenuActivity.this.audioAd.destroyAd();
          jdField_this.finish();
        }
        
        public void onAdFailed()
        {
          MenuActivity.this.audioAd.destroyAd();
          jdField_this.finish();
        }
        
        public void onAdLoaded() {}
        
        public void onAdPaused()
        {
          MenuActivity.this.audioAd.destroyAd();
          jdField_this.finish();
        }
        
        public void onAdProgress() {}
        
        public void onAdResumed() {}
      }).loadAd();
      if (this.countBackPush > 1)
      {
        this.audioAd.pauseAd();
        this.audioAd.destroyAd();
        finish();
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onLeaveApplication(Ad paramAd)
  {
    this.audioAd.pauseAd();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.ad != null) {
      this.ad.destroyAd();
    }
    if (this.audioAd != null)
    {
      this.audioAd.pauseAd();
      this.audioAd.destroyAd();
    }
    if (!isFinishing()) {
      AppTracker.pause(getApplicationContext());
    }
  }
  
  public void onPresentScreen(Ad paramAd) {}
  
  public void onReceiveAd(Ad paramAd)
  {
    Log.d("OK", "Received ad");
    if (paramAd == this.interstitial) {
      this.interstitial.show();
    }
  }
  
  public void onRestart()
  {
    super.onRestart();
    Object localObject;
    if (Environment.getExternalStorageState().equalsIgnoreCase("MOUNTED")) {
      if (this.db.getMessage("Commented").getCount() == 0)
      {
        localObject = new AlertDialog.Builder(this);
        ((AlertDialog.Builder)localObject).setTitle("Thank You");
        ((AlertDialog.Builder)localObject).setMessage("If you like this app , leave a comment.");
        ((AlertDialog.Builder)localObject).setPositiveButton("Ok", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            MenuActivity.this.db.insertMessage("1", "Commented");
            paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.troll.face"));
            MenuActivity.this.startActivity(paramAnonymousDialogInterface);
          }
        });
        ((AlertDialog.Builder)localObject).setNegativeButton("No", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            MenuActivity.this.db.insertMessage("1", "Commented");
          }
        });
        ((AlertDialog.Builder)localObject).setNeutralButton("Later", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        ((AlertDialog.Builder)localObject).show();
      }
    }
    for (;;)
    {
      localObject = (MyApp)getApplication();
      return;
      localObject = new AlertDialog.Builder(this);
      ((AlertDialog.Builder)localObject).setTitle("Thank You");
      ((AlertDialog.Builder)localObject).setMessage("If you like this app , please support us and leave a comment.");
      ((AlertDialog.Builder)localObject).setPositiveButton("Ok", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.troll.face"));
          MenuActivity.this.startActivity(paramAnonymousDialogInterface);
        }
      });
      ((AlertDialog.Builder)localObject).setNegativeButton("No", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      ((AlertDialog.Builder)localObject).setNeutralButton("Later", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      ((AlertDialog.Builder)localObject).show();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.audioAd == null) {
      this.audioAd = new AdController(this, "734590306");
    }
    this.audioAd.loadAudioTrack(1L);
    AppTracker.resume(getApplicationContext());
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.ad != null) {
      this.ad.destroyAd();
    }
    if (this.audioAd != null)
    {
      this.audioAd.pauseAd();
      this.audioAd.destroyAd();
    }
    if (!isFinishing()) {
      AppTracker.pause(getApplicationContext());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/troll/face/MenuActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */