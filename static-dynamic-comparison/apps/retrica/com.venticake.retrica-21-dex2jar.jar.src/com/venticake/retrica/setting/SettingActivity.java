package com.venticake.retrica.setting;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.venticake.retrica.MainActivity;
import com.venticake.retrica.c;
import com.venticake.retrica.o;
import com.venticake.retrica.util.CommonUtil;

public class SettingActivity
  extends c
{
  private static Activity o;
  private int p;
  private int q;
  
  private void t()
  {
    ((ImageView)findViewById(2131296424)).setImageBitmap(b.a(o));
  }
  
  protected void i()
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/plain");
    localIntent.putExtra("android.intent.extra.SUBJECT", getResources().getString(2131165273));
    localIntent.putExtra("android.intent.extra.TEXT", getResources().getString(2131165274));
    try
    {
      startActivity(Intent.createChooser(localIntent, getResources().getString(2131165272)));
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException) {}
  }
  
  protected void n()
  {
    Object localObject1 = null;
    try
    {
      localObject2 = getPackageManager().getPackageInfo(getPackageName(), 0);
      localObject1 = localObject2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Object localObject2;
      Intent localIntent;
      for (;;) {}
    }
    localObject2 = getIntent();
    localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("message/rfc822");
    localIntent.putExtra("android.intent.extra.EMAIL", new String[] { o.b() });
    localIntent.putExtra("android.intent.extra.SUBJECT", getResources().getString(2131165280));
    localIntent.putExtra("android.intent.extra.TEXT", "\n\n" + Build.BRAND + " " + Build.MODEL + " (" + Build.VERSION.SDK_INT + " - " + ((PackageInfo)localObject1).versionCode + " @ [" + ((PackageInfo)localObject1).versionName + "] " + 1 + ":" + "76da0b3d20e367a7b770a618f6a7372f32102284" + ")" + "\nAdj: [" + ((Intent)localObject2).getIntExtra("adjustedPreviewWidth", 0) + "x" + ((Intent)localObject2).getIntExtra("adjustedPreviewHeight", 0) + "]" + "\nChs: [" + ((Intent)localObject2).getIntExtra("chosenPreviewWidth", 0) + "x" + ((Intent)localObject2).getIntExtra("chosenPreviewHeight", 0) + "]" + "\nChpc: [" + ((Intent)localObject2).getIntExtra("chosenPictureWidth", 0) + "x" + ((Intent)localObject2).getIntExtra("chosenPictureHeight", 0) + "]" + "\nScr: [" + this.p + "x" + this.q + "]");
    try
    {
      startActivity(Intent.createChooser(localIntent, getResources().getString(2131165279)));
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException) {}
  }
  
  protected void o()
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("fb://page/" + o.c()));
      localIntent.addFlags(524288);
      startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/" + o.c())));
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    o = this;
    getWindow().setFlags(1024, 1024);
    setContentView(2130903069);
    paramBundle = f();
    paramBundle.a(true);
    paramBundle.a(2130837931);
    paramBundle = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
    this.p = paramBundle.widthPixels;
    this.q = paramBundle.heightPixels;
    paramBundle = (ToggleButton)findViewById(2131296410);
    if (a.a().w()) {}
    for (boolean bool = false;; bool = true)
    {
      paramBundle.setChecked(bool);
      paramBundle.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = a.a();
          if (paramBundle.isChecked()) {}
          for (boolean bool = false;; bool = true)
          {
            paramAnonymousView.g(bool);
            return;
          }
        }
      });
      paramBundle = (ToggleButton)findViewById(2131296412);
      paramBundle.setChecked(a.a().r());
      paramBundle.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.a().e(paramBundle.isChecked());
        }
      });
      paramBundle = (ToggleButton)findViewById(2131296420);
      paramBundle.setChecked(a.a().q());
      paramBundle.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.a().d(paramBundle.isChecked());
        }
      });
      paramBundle = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ((MainActivity)MainActivity.a).A();
        }
      };
      final Object localObject = (FrameLayout)findViewById(2131296407);
      ((FrameLayout)localObject).setClickable(true);
      ((FrameLayout)localObject).setOnClickListener(paramBundle);
      paramBundle = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new Intent(SettingActivity.s(), WatermarkActivity.class);
          SettingActivity.this.startActivity(paramAnonymousView);
        }
      };
      localObject = (FrameLayout)findViewById(2131296421);
      ((FrameLayout)localObject).setClickable(true);
      ((FrameLayout)localObject).setOnClickListener(paramBundle);
      paramBundle = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          SettingActivity.this.p();
        }
      };
      localObject = (ToggleButton)findViewById(2131296414);
      ((ToggleButton)localObject).setChecked(a.a().o());
      ((ToggleButton)localObject).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.a().c(localObject.isChecked());
        }
      });
      ((FrameLayout)findViewById(2131296415)).setVisibility(8);
      ((FrameLayout)findViewById(2131296416)).setVisibility(8);
      localObject = (FrameLayout)findViewById(2131296425);
      ((FrameLayout)localObject).setClickable(true);
      ((FrameLayout)localObject).setOnClickListener(paramBundle);
      paramBundle = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          SettingActivity.this.i();
        }
      };
      localObject = (FrameLayout)findViewById(2131296427);
      ((FrameLayout)localObject).setClickable(true);
      ((FrameLayout)localObject).setOnClickListener(paramBundle);
      paramBundle = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          SettingActivity.this.o();
        }
      };
      localObject = (FrameLayout)findViewById(2131296429);
      ((FrameLayout)localObject).setClickable(true);
      ((FrameLayout)localObject).setOnClickListener(paramBundle);
      paramBundle = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          SettingActivity.this.q();
        }
      };
      localObject = (FrameLayout)findViewById(2131296431);
      ((FrameLayout)localObject).setClickable(true);
      ((FrameLayout)localObject).setOnClickListener(paramBundle);
      paramBundle = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          SettingActivity.this.n();
        }
      };
      localObject = (FrameLayout)findViewById(2131296433);
      ((FrameLayout)localObject).setClickable(true);
      ((FrameLayout)localObject).setOnClickListener(paramBundle);
      ((TextView)findViewById(2131296437)).setText(CommonUtil.getAppVersion(this));
      paramBundle = (FrameLayout)findViewById(2131296435);
      paramBundle.setClickable(true);
      paramBundle.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          SettingActivity.this.r();
        }
      });
      return;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    t();
  }
  
  protected void p()
  {
    switch (1)
    {
    }
    for (String str = "market://details?id=" + o.d();; str = "amzn://apps/android?p=" + o.d())
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(str));
      startActivity(localIntent);
      return;
    }
  }
  
  protected void q()
  {
    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://retrica.co/_faq/")));
  }
  
  protected void r()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle(CommonUtil.getAppVersion(this));
    localBuilder.setMessage(o.a() + "(" + 1 + ")\n" + "76da0b3d20e367a7b770a618f6a7372f32102284");
    localBuilder.setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
      }
    });
    localBuilder.show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/setting/SettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */