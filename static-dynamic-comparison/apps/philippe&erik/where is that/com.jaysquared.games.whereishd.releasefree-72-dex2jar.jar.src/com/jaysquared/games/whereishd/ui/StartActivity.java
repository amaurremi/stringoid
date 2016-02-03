package com.jaysquared.games.whereishd.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.analytics.tracking.android.EasyTracker;
import com.jaysquared.games.whereishd.ApplicationManager;
import com.jaysquared.games.whereishd.GameManager;
import com.jaysquared.games.whereishd.utils.MapTilesPreloaderTask;
import com.jaysquared.games.whereishd.utils.PersistantSettings;
import com.jaysquared.games.whereishd.utils.SLog;
import com.jaysquared.games.whereishd.utils.SystemHelper;

public class StartActivity
  extends Activity
{
  private static final String LOG_TAG = StartActivity.class.getSimpleName();
  
  @TargetApi(13)
  private static Point getDisplaySize(Display paramDisplay)
  {
    Point localPoint = new Point();
    if (Build.VERSION.SDK_INT >= 13)
    {
      paramDisplay.getSize(localPoint);
      return localPoint;
    }
    localPoint.x = paramDisplay.getWidth();
    localPoint.y = paramDisplay.getHeight();
    return localPoint;
  }
  
  private void prepareGame()
  {
    SLog.i(LOG_TAG, "Preparing game...");
    int i = SystemHelper.getVersionCode(this);
    int j = ApplicationManager.getInstance().getSettings().getVersionCode();
    boolean bool = false;
    if (j != i)
    {
      SLog.i(LOG_TAG, "Upgrade from " + j + " to " + i + " deteced, recreating maps...");
      TextView localTextView = (TextView)findViewById(2131230888);
      localTextView.setTypeface(ApplicationManager.getInstance().getGameManager().getTypeface());
      localTextView.setVisibility(0);
      bool = true;
      ApplicationManager.getInstance().getSettings().setVersionCode(i);
    }
    new MapTilesPreloaderTask(this, bool).execute(new Void[] { (Void)null });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    SLog.d(LOG_TAG, "Creating activity...");
    setContentView(2130903083);
  }
  
  protected void onDestroy()
  {
    SLog.d(LOG_TAG, "Destroying activity...");
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    localRotateAnimation.setDuration(5000L);
    localRotateAnimation.setRepeatCount(-1);
    ImageView localImageView = (ImageView)findViewById(2131230972);
    findViewById(2131230972).setVisibility(0);
    localImageView.startAnimation(localRotateAnimation);
    prepareGame();
  }
  
  protected void onStart()
  {
    super.onStart();
    EasyTracker.getInstance(this).activityStart(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    EasyTracker.getInstance(this).activityStop(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/ui/StartActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */