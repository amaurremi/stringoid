package com.mobisystems.mobiscanner.controller;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.google.analytics.tracking.android.l;
import com.mobisystems.mobiscanner.common.CommonPreferences.Keys;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.common.d;
import com.mobisystems.mobiscanner.error.a;

public class AboutActivity
  extends SherlockFragmentActivity
  implements View.OnClickListener, View.OnLongClickListener
{
  private final c mLog = new c(this);
  
  private void Ec()
  {
    Object localObject = findViewById(2131165267);
    View localView2 = findViewById(2131165273);
    View localView3 = findViewById(2131165276);
    View localView4 = findViewById(2131165279);
    View localView1 = findViewById(2131165282);
    View localView5 = findViewById(2131165272);
    View localView6 = findViewById(2131165275);
    View localView7 = findViewById(2131165278);
    View localView8 = findViewById(2131165281);
    a(new View[] { localObject, localView5 }, 0, null);
    a(new View[] { localView2, localView6 }, 50, null);
    a(new View[] { localView3, localView7 }, 100, null);
    a(new View[] { localView4, localView8 }, 150, null);
    localObject = new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        paramAnonymousAnimation = AboutActivity.this.findViewById(2131165266);
        if (paramAnonymousAnimation != null) {
          paramAnonymousAnimation.setBackgroundResource(0);
        }
        paramAnonymousAnimation = (ImageView)AboutActivity.this.findViewById(2131165268);
        RotateAnimation localRotateAnimation = new RotateAnimation(180.0F, 360.0F, 1, 0.5F, 1, 0.5F);
        localRotateAnimation.setInterpolator(new DecelerateInterpolator());
        localRotateAnimation.setRepeatCount(0);
        localRotateAnimation.setDuration(700L);
        paramAnonymousAnimation.startAnimation(localRotateAnimation);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    };
    a(new View[] { localView1 }, 200, (Animation.AnimationListener)localObject);
  }
  
  private void Ed()
  {
    int[] arrayOfInt = new int[5];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 2131165267;
    int[] tmp10_5 = tmp5_4;
    tmp10_5[1] = 2131165273;
    int[] tmp15_10 = tmp10_5;
    tmp15_10[2] = 2131165276;
    int[] tmp20_15 = tmp15_10;
    tmp20_15[3] = 2131165279;
    int[] tmp25_20 = tmp20_15;
    tmp25_20[4] = 2131165282;
    tmp25_20;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      findViewById(arrayOfInt[i]).setOnClickListener(this);
      i += 1;
    }
  }
  
  private void Ee()
  {
    try
    {
      Object localObject = "" + getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
      ((TextView)findViewById(2131165270)).setText((CharSequence)localObject);
      localObject = (TextView)findViewById(2131165271);
      if ((!d.DD()) && (!d.DE())) {
        ((TextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
      }
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        this.mLog.A("Exception getting application version: " + localNameNotFoundException);
        String str = "";
      }
    }
  }
  
  private void Ef()
  {
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }
  
  private void Eg()
  {
    if ((!d.DD()) && (!d.DE())) {
      HelpAboutHelper.aq(this);
    }
  }
  
  private void Eh()
  {
    HelpAboutHelper.at(this);
  }
  
  private void Ei()
  {
    HelpAboutHelper.as(this);
  }
  
  private void Ej()
  {
    HelpAboutHelper.au(this);
  }
  
  private void Ek()
  {
    HelpAboutHelper.ar(this);
  }
  
  private void a(View[] paramArrayOfView, int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    int j = paramArrayOfView.length;
    int i = 0;
    while (i < j)
    {
      View localView = paramArrayOfView[i];
      localView.setVisibility(0);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);
      localTranslateAnimation.setFillEnabled(true);
      localTranslateAnimation.setFillBefore(true);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setDuration('Ɛ');
      localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      localTranslateAnimation.setStartOffset(paramInt);
      if ((i == j - 1) && (paramAnimationListener != null)) {
        localTranslateAnimation.setAnimationListener(paramAnimationListener);
      }
      localView.startAnimation(localTranslateAnimation);
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131165267: 
      Eg();
      return;
    case 2131165273: 
      Ek();
      return;
    case 2131165276: 
      Ej();
      return;
    case 2131165279: 
      Eh();
      return;
    }
    Ei();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    a.ay(getApplicationContext());
    super.onCreate(paramBundle);
    setContentView(2130903065);
    Ec();
    Ed();
    Ee();
    Ef();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return true;
  }
  
  public boolean onLongClick(View paramView)
  {
    Toast.makeText(this, paramView.getContentDescription(), 0).show();
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    finish();
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onStart()
  {
    this.mLog.dl("onStart called");
    super.onStart();
    if (CommonPreferences.Keys.apu.Dm()) {
      getWindow().clearFlags(1024);
    }
    for (;;)
    {
      l.e(this).a(this);
      return;
      getWindow().addFlags(1024);
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    l.e(this).b(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/AboutActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */