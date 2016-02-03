package com.chartboost.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.RelativeLayout;

public final class CBImpressionActivity
  extends Activity
{
  public static final String PARAM_FULLSCREEN = "paramFullscreen";
  protected Chartboost a;
  
  public void onBackPressed()
  {
    if (this.a.b()) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (getIntent().getBooleanExtra("paramFullscreen", false)) {
      getWindow().addFlags(1024);
    }
    getWindow().setWindowAnimations(0);
    setContentView(new RelativeLayout(this));
    this.a = Chartboost.sharedChartboost();
    this.a.a(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.a.c(this);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.a.a(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    this.a.b(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/CBImpressionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */