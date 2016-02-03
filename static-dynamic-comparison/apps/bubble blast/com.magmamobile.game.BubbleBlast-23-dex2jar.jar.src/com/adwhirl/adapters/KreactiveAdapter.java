package com.adwhirl.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.adwhirl.AdWhirlLayout;
import com.adwhirl.AdWhirlManager;
import com.adwhirl.ModCommon;
import com.adwhirl.obj.Custom;
import com.adwhirl.obj.Extra;
import com.adwhirl.obj.Extra2;
import com.adwhirl.obj.Ration;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class KreactiveAdapter
  extends AdWhirlAdapter
{
  public KreactiveAdapter(AdWhirlLayout paramAdWhirlLayout, Ration paramRation)
  {
    super(paramAdWhirlLayout, paramRation);
  }
  
  public void displayCustom()
  {
    AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (localAdWhirlLayout == null) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (Activity)localAdWhirlLayout.activityReference.get();
    } while (localObject1 == null);
    RelativeLayout localRelativeLayout;
    Object localObject2;
    switch (localAdWhirlLayout.custom.type)
    {
    default: 
      if (Extra2.verboselog) {
        Log.w("AdWhirl SDK", "Unknown custom type!");
      }
      localAdWhirlLayout.rotateThreadedNow();
      return;
    case 1: 
      if (Extra2.verboselog) {
        Log.d("AdWhirl SDK", "Serving custom type: banner");
      }
      localRelativeLayout = new RelativeLayout((Context)localObject1);
      if (localAdWhirlLayout.custom.image == null)
      {
        localAdWhirlLayout.rotateThreadedNow();
        return;
      }
      localObject1 = new ImageView((Context)localObject1);
      ((ImageView)localObject1).setImageDrawable(localAdWhirlLayout.custom.image);
      ModCommon.callTracking(localAdWhirlLayout.custom.trackingDisplay);
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localAdWhirlLayout.pushSubView(localRelativeLayout);
    }
    for (;;)
    {
      localAdWhirlLayout.adWhirlManager.resetRollover();
      localAdWhirlLayout.rotateThreadedDelayed();
      return;
      if (Extra2.verboselog) {
        Log.d("AdWhirl SDK", "Serving custom type: icon");
      }
      localRelativeLayout = new RelativeLayout((Context)localObject1);
      if (localAdWhirlLayout.custom.image == null)
      {
        localAdWhirlLayout.rotateThreadedNow();
        return;
      }
      localRelativeLayout.setLayoutParams(new FrameLayout.LayoutParams(320, 50));
      localObject2 = new ImageView((Context)localObject1);
      int i = Color.rgb(localAdWhirlLayout.extra.bgRed, localAdWhirlLayout.extra.bgGreen, localAdWhirlLayout.extra.bgBlue);
      ((ImageView)localObject2).setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { -1, i, i, i }));
      localRelativeLayout.addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
      localObject2 = new ImageView((Context)localObject1);
      ((ImageView)localObject2).setImageDrawable(localAdWhirlLayout.custom.image);
      ((ImageView)localObject2).setId(10);
      ((ImageView)localObject2).setPadding(4, 0, 6, 0);
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER);
      localRelativeLayout.addView((View)localObject2, new RelativeLayout.LayoutParams(-2, -1));
      Object localObject3 = new ImageView((Context)localObject1);
      ((ImageView)localObject3).setImageDrawable(new BitmapDrawable(getClass().getResourceAsStream("/com/adwhirl/assets/ad_frame.gif")));
      ((ImageView)localObject3).setPadding(4, 0, 6, 0);
      ((ImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER);
      localRelativeLayout.addView((View)localObject3, new RelativeLayout.LayoutParams(-2, -1));
      localObject1 = new TextView((Context)localObject1);
      ((TextView)localObject1).setText(localAdWhirlLayout.custom.description);
      ((TextView)localObject1).setTypeface(Typeface.DEFAULT_BOLD, 1);
      ((TextView)localObject1).setTextColor(Color.rgb(localAdWhirlLayout.extra.fgRed, localAdWhirlLayout.extra.fgGreen, localAdWhirlLayout.extra.fgBlue));
      localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, ((ImageView)localObject2).getId());
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(12);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      ((TextView)localObject1).setGravity(16);
      localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      localAdWhirlLayout.pushSubView(localRelativeLayout);
    }
  }
  
  public void handle()
  {
    AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)this.adWhirlLayoutReference.get();
    if (localAdWhirlLayout == null) {
      return;
    }
    localAdWhirlLayout.scheduler.schedule(new FetchCustomRunnable(this), 0L, TimeUnit.SECONDS);
  }
  
  private static class DisplayCustomRunnable
    implements Runnable
  {
    private KreactiveAdapter customAdapter;
    
    public DisplayCustomRunnable(KreactiveAdapter paramKreactiveAdapter)
    {
      this.customAdapter = paramKreactiveAdapter;
    }
    
    public void run()
    {
      this.customAdapter.displayCustom();
    }
  }
  
  private static class FetchCustomRunnable
    implements Runnable
  {
    private KreactiveAdapter customAdapter;
    
    public FetchCustomRunnable(KreactiveAdapter paramKreactiveAdapter)
    {
      this.customAdapter = paramKreactiveAdapter;
    }
    
    public void run()
    {
      AdWhirlLayout localAdWhirlLayout = (AdWhirlLayout)this.customAdapter.adWhirlLayoutReference.get();
      if (localAdWhirlLayout == null) {
        return;
      }
      localAdWhirlLayout.custom = localAdWhirlLayout.adWhirlManager.getKreactive(this.customAdapter.ration.nid);
      if (localAdWhirlLayout.custom == null)
      {
        localAdWhirlLayout.rotateThreadedNow();
        return;
      }
      localAdWhirlLayout.handler.post(new KreactiveAdapter.DisplayCustomRunnable(this.customAdapter));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adwhirl/adapters/KreactiveAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */