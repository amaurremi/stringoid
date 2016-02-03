package com.mobisystems.mobiscanner.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.mobisystems.mobiscanner.common.CommonPreferences.Keys;
import com.mobisystems.mobiscanner.common.d;

public class SplashActivity
  extends SherlockFragmentActivity
  implements k
{
  private Runnable aCR;
  Handler mHandler;
  
  private void HI()
  {
    Object localObject1 = (TextView)findViewById(2131165352);
    Object localObject2 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
    ((TextView)localObject1).setTypeface((Typeface)localObject2);
    ((TextView)findViewById(2131165357)).setTypeface((Typeface)localObject2);
    Object localObject3 = (TextView)findViewById(2131165270);
    Object localObject4 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
    ((TextView)localObject3).setTypeface((Typeface)localObject4);
    localObject1 = "";
    try
    {
      localObject2 = getString(2131296712) + getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
      localObject1 = localObject2;
      localObject2 = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("."));
      localObject1 = localObject2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
    ((TextView)localObject3).setText((CharSequence)localObject1);
    ((TextView)findViewById(2131165358)).setTypeface((Typeface)localObject4);
    ((TextView)findViewById(2131165358)).setTypeface((Typeface)localObject4);
    localObject1 = (ImageView)findViewById(2131165355);
    localObject2 = new RotateAnimation(0.0F, 1080.0F, 1, 0.5F, 1, 0.5F);
    ((RotateAnimation)localObject2).setInterpolator(new LinearInterpolator());
    ((RotateAnimation)localObject2).setRepeatCount(0);
    ((RotateAnimation)localObject2).setDuration(5000L);
    localObject3 = (ImageView)findViewById(2131165356);
    localObject4 = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject4).setInterpolator(new LinearInterpolator());
    ((AlphaAnimation)localObject4).setRepeatCount(0);
    ((AlphaAnimation)localObject4).setDuration(3000L);
    ((AlphaAnimation)localObject4).setFillAfter(true);
    ((AlphaAnimation)localObject4).setFillEnabled(true);
    ((AlphaAnimation)localObject4).setFillBefore(true);
    ((AlphaAnimation)localObject4).setStartOffset(2000L);
    ((ImageView)localObject1).startAnimation((Animation)localObject2);
    ((ImageView)localObject3).startAnimation((Animation)localObject4);
    findViewById(2131165351).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView.setVisibility(8);
        SplashActivity.a(SplashActivity.this);
      }
    });
  }
  
  private void HJ()
  {
    this.mHandler.removeCallbacks(this.aCR);
    Intent localIntent = new Intent();
    localIntent.setClass(this, DocumentListActivity.class);
    localIntent.setFlags(268468224);
    startActivity(localIntent);
  }
  
  @SuppressLint({"InlinedApi"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(1024);
    if (d.DC()) {}
    for (int i = 4098;; i = 1)
    {
      getWindow().getDecorView().setSystemUiVisibility(i);
      paramBundle = PreferenceManager.getDefaultSharedPreferences(this);
      if (paramBundle.getBoolean(CommonPreferences.Keys.apI.Dl(), false)) {
        break;
      }
      a.a(getSupportFragmentManager());
      paramBundle = paramBundle.edit();
      paramBundle.putBoolean(CommonPreferences.Keys.apM.getKey(), false);
      paramBundle.commit();
      return;
    }
    setContentView(2130903076);
    HI();
    this.mHandler = new Handler();
    this.aCR = new Runnable()
    {
      public void run()
      {
        SplashActivity.a(SplashActivity.this);
      }
    };
    d.an(this);
  }
  
  public void onDialogNegativeAction(String paramString, Bundle paramBundle)
  {
    if ("ACCEPT_EULA".equals(paramString))
    {
      Toast.makeText(this, "You must accept the Terms before using the application ", 1).show();
      finish();
    }
  }
  
  public void onDialogPositiveAction(String paramString, Bundle paramBundle)
  {
    if ("ACCEPT_EULA".equals(paramString))
    {
      PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean(CommonPreferences.Keys.apI.Dl(), true).commit();
      setContentView(2130903076);
      HI();
      this.mHandler = new Handler();
      this.aCR = new Runnable()
      {
        public void run()
        {
          SplashActivity.a(SplashActivity.this);
        }
      };
      this.mHandler.postDelayed(this.aCR, 6000L);
      d.an(this);
    }
  }
  
  protected void onPause()
  {
    if ((this.mHandler != null) && (this.aCR != null)) {
      this.mHandler.removeCallbacks(this.aCR);
    }
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((this.mHandler != null) && (this.aCR != null)) {
      this.mHandler.postDelayed(this.aCR, 6000L);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/SplashActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */