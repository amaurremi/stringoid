package com.venticake.retrica.view.album;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.venticake.retrica.MainActivity;
import com.venticake.retrica.e;
import com.venticake.retrica.g;
import com.venticake.retrica.util.ControlUserInput;
import com.venticake.retrica.util.UserInterfaceUtil;
import java.io.File;
import java.io.IOException;

public class QuickViewActivity
  extends e
  implements View.OnTouchListener, LazyImageView.LoadingFinishListner
{
  public static final String EXTRA_KEY_AD_DISPLAY_TYPE = "AdDisplayType";
  public static final String EXTRA_KEY_DEBUG_TEXT = "DebugText";
  public static final String EXTRA_KEY_DISPLAY_AD = "DisplayAd";
  public static final String EXTRA_KEY_FROM = "From";
  public static final String EXTRA_KEY_POSITION = "Position";
  public static final String EXTRA_KEY_URI = "URI";
  Activity mActivity;
  boolean mAdAlreadyDisplayed = false;
  int mAdDisplayType = 4369;
  String mDebugText = null;
  boolean mDisplayAd = false;
  String mFrom = null;
  ImageButton mInstagramButton;
  LazyImageView mLazyImageView;
  private File[] mMediaFiles;
  private ViewPager mPager;
  private int mPagerMaxPages = 3;
  int mPosition = 0;
  Button mRemoveAdButton;
  ImageButton mSaveButton;
  ImageButton mShareButton;
  ImageButton mTrashButton;
  String mURIString = null;
  
  private void displayDebugInfoButton(String paramString)
  {
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView().findViewById(16908290);
    Button localButton = new Button(this);
    localButton.setTextSize(2, 12.0F);
    if (paramString == null)
    {
      if (this.mDebugText == null) {}
      for (paramString = "Info";; paramString = "Info\n" + this.mDebugText)
      {
        localButton.setText(paramString);
        localViewGroup.addView(localButton, dp2px(80), dp2px(70));
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            QuickViewActivity.this.showInfo();
          }
        });
        return;
      }
    }
    if (this.mDebugText == null) {}
    for (;;)
    {
      localButton.setText(paramString);
      localViewGroup.addView(localButton, dp2px(180), dp2px(90));
      break;
      paramString = paramString + "\n" + this.mDebugText;
    }
  }
  
  private int dp2px(int paramInt)
  {
    return (int)(getResources().getDisplayMetrics().density * paramInt + 0.5F);
  }
  
  private FrameLayout getAdTargetLayout(boolean paramBoolean)
  {
    if (paramBoolean) {
      return (FrameLayout)findViewById(2131296406);
    }
    return (FrameLayout)findViewById(2131296403);
  }
  
  private String setupUI()
  {
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    setContentView(2130903068);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("From");
    this.mDisplayAd = localIntent.getBooleanExtra("DisplayAd", false);
    this.mAdDisplayType = localIntent.getIntExtra("AdDisplayType", 4369);
    this.mURIString = localIntent.getStringExtra("URI");
    this.mDebugText = localIntent.getStringExtra("DebugText");
    this.mPosition = localIntent.getIntExtra("Position", -1);
    this.mPager = ((ViewPager)findViewById(2131296402));
    if (str.equals("QuickView after capture")) {
      this.mPagerMaxPages = 1;
    }
    for (;;)
    {
      this.mPager.setAdapter(new QuickViewActivity.QuickViewPagerAdapter(this, getApplicationContext()));
      this.mPager.setCurrentItem(this.mPosition);
      this.mShareButton = ((ImageButton)findViewById(2131296404));
      this.mTrashButton = ((ImageButton)findViewById(2131296405));
      this.mRemoveAdButton = ((Button)findViewById(2131296401));
      this.mShareButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          QuickViewActivity.this.doShare();
          com.venticake.retrica.c.b("QuickView Share");
        }
      });
      this.mTrashButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          QuickViewActivity.this.doTrash();
          com.venticake.retrica.c.b("QuickView Delete");
        }
      });
      this.mRemoveAdButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ((MainActivity)MainActivity.a).A();
        }
      });
      return str;
      this.mMediaFiles = g.a(true, this.mActivity);
    }
  }
  
  private void showInfo()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.mLazyImageView.getLoadedImageWidth() + " x " + this.mLazyImageView.getLoadedImageHeight() + "\n");
    try
    {
      Object localObject1 = new ExifInterface(Uri.parse(this.mURIString).getPath());
      if (localObject1 != null)
      {
        String str1 = ((ExifInterface)localObject1).getAttribute("Orientation");
        if (str1 != null)
        {
          int i = Integer.parseInt(str1);
          localStringBuffer.append("orientation: " + str1 + " (" + UserInterfaceUtil.getExifString(i) + ")" + "\n");
        }
        str1 = ((ExifInterface)localObject1).getAttribute("GPSLatitude");
        String str2 = ((ExifInterface)localObject1).getAttribute("GPSLatitudeRef");
        String str3 = ((ExifInterface)localObject1).getAttribute("GPSLongitude");
        localObject1 = ((ExifInterface)localObject1).getAttribute("GPSLongitudeRef");
        if (str1 != null) {
          localStringBuffer.append("lat: " + str1 + " (" + str2 + ")\n");
        }
        if (str3 != null) {
          localStringBuffer.append("lon: " + str3 + " (" + (String)localObject1 + ")\n");
        }
      }
      localObject1 = new AlertDialog.Builder(this);
      ((AlertDialog.Builder)localObject1).setTitle("Info");
      ((AlertDialog.Builder)localObject1).setMessage(localStringBuffer);
      ((AlertDialog.Builder)localObject1).setPositiveButton(17039370, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface.dismiss();
        }
      });
      ((AlertDialog.Builder)localObject1).show();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
  
  protected void closeActivity()
  {
    new Handler(getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        jdField_this.finish();
      }
    });
  }
  
  protected void doShare()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.SEND");
    if (this.mFrom.equals("QuickView after capture")) {
      localIntent.putExtra("android.intent.extra.STREAM", Uri.parse(this.mURIString));
    }
    for (;;)
    {
      localIntent.setType("image/jpeg");
      startActivity(Intent.createChooser(localIntent, getResources().getString(2131165237)));
      return;
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(this.mMediaFiles[this.mPager.getCurrentItem()]));
    }
  }
  
  protected void doTrash()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle(2131165236);
    localBuilder.setPositiveButton(2131165235, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        QuickViewActivity.this.removeFileAndCloseActivity();
      }
    });
    localBuilder.setNegativeButton(2131165234, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    localBuilder.create().show();
  }
  
  public View getHandler()
  {
    return getWindow().getDecorView();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((shouldDisplayAd()) && (this.mAdAlreadyDisplayed))
    {
      if (paramConfiguration.orientation != 2) {
        break label42;
      }
      com.venticake.a.a.a().b(this, getAdTargetLayout(com.venticake.a.a.c.d));
    }
    label42:
    while (paramConfiguration.orientation != 1) {
      return;
    }
    com.venticake.a.a.a().b(this, getAdTargetLayout(com.venticake.a.a.c.d));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mActivity = this;
    this.mFrom = setupUI();
    if (this.mFrom.equals("QuickView after capture")) {
      com.venticake.retrica.c.b("QuickView after capture");
    }
    do
    {
      return;
      if (this.mFrom.equals("QuickView from album"))
      {
        com.venticake.retrica.c.b("QuickView from album");
        return;
      }
    } while (!this.mFrom.equals("QuickView after NoEffect capture"));
    com.venticake.retrica.c.b("QuickView after NoEffect capture");
  }
  
  protected void onDestroy()
  {
    Log.d("spad", "onDestroy - (shouldDisplayAd: " + shouldDisplayAd() + ", adDisplayed: " + this.mAdAlreadyDisplayed + ")");
    if ((shouldDisplayAd()) && (this.mAdAlreadyDisplayed)) {
      com.venticake.a.a.a().b(this);
    }
    super.onDestroy();
  }
  
  public void onLoadingFinish(Bitmap paramBitmap) {}
  
  protected void onPause()
  {
    super.onPause();
    Log.d("spad", "onPause - (shouldDisplayAd: " + shouldDisplayAd() + ", adDisplayed: " + this.mAdAlreadyDisplayed + ")");
  }
  
  protected void onResume()
  {
    super.onResume();
    Log.d("spad", "onResume - (shouldDisplayAd: " + shouldDisplayAd() + ", adDisplayed: " + this.mAdAlreadyDisplayed + ")");
    if (!shouldDisplayAd())
    {
      this.mRemoveAdButton.setVisibility(8);
      if (!shouldDisplayAd()) {
        break label129;
      }
      if (!this.mAdAlreadyDisplayed) {
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            if (com.venticake.a.a.a().a(jdField_this, QuickViewActivity.this.getAdTargetLayout(com.venticake.a.a.c.d), QuickViewActivity.this.mAdDisplayType)) {
              QuickViewActivity.this.mAdAlreadyDisplayed = true;
            }
          }
        }, 100L);
      }
    }
    label129:
    while (!this.mAdAlreadyDisplayed)
    {
      return;
      this.mRemoveAdButton.setVisibility(0);
      this.mRemoveAdButton.bringToFront();
      this.mRemoveAdButton.invalidate();
      break;
    }
    com.venticake.a.a.a().b(this);
    this.mAdAlreadyDisplayed = false;
  }
  
  public void onStop()
  {
    super.onStop();
    Log.d("spad", "onStop - (shouldDisplayAd: " + shouldDisplayAd() + ", adDisplayed: " + this.mAdAlreadyDisplayed + ")");
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return new ControlUserInput(this).onTouchEvent(paramMotionEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.mLazyImageView.isLoaded())) {
      this.mLazyImageView.loadImage(this.mURIString);
    }
  }
  
  protected void removeFile()
  {
    g localg = new g(this);
    if (this.mFrom.equals("QuickView after capture"))
    {
      localg.a(this.mURIString.toString());
      return;
    }
    localg.a(Uri.fromFile(this.mMediaFiles[this.mPager.getCurrentItem()]).toString());
  }
  
  protected void removeFileAndCloseActivity()
  {
    this.mLazyImageView.deleteImage();
    new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public void run()
      {
        QuickViewActivity.this.removeFile();
        QuickViewActivity.this.closeActivity();
      }
    }, 100L);
  }
  
  public boolean shouldDisplayAd()
  {
    if (com.venticake.retrica.setting.a.a().u()) {
      return false;
    }
    return this.mDisplayAd;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/QuickViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */