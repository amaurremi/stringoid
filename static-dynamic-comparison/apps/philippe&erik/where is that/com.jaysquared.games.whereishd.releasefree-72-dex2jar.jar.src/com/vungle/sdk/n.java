package com.vungle.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.VideoView;
import java.io.IOException;

final class n
{
  private static Bitmap h = null;
  private static Bitmap i = null;
  private static Bitmap j = null;
  RelativeLayout a;
  VideoView b;
  ProgressBar c;
  RelativeLayout d;
  TextView e;
  ImageView f;
  ImageView g;
  
  public n(Context paramContext)
  {
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    VungleBitmapFactory localVungleBitmapFactory;
    if ((h == null) || (i == null) || (j == null))
    {
      localVungleBitmapFactory = ai.a().b();
      if (h != null) {}
    }
    try
    {
      h = localVungleBitmapFactory.getBitmap("vunglepub_sdk_close.png");
      if (i != null) {}
    }
    catch (IOException localIOException3)
    {
      try
      {
        i = localVungleBitmapFactory.getBitmap("vunglepub_sdk_mute.png");
        if (j != null) {}
      }
      catch (IOException localIOException3)
      {
        try
        {
          for (;;)
          {
            j = localVungleBitmapFactory.getBitmap("vunglepub_sdk_unmute.png");
            this.a = new RelativeLayout(paramContext);
            this.b = new VideoView(paramContext);
            this.c = new ProgressBar(paramContext);
            this.d = new RelativeLayout(paramContext);
            this.e = new TextView(paramContext);
            this.f = new ImageView(paramContext);
            this.g = new ImageView(paramContext);
            this.a.addView(this.b);
            this.a.addView(this.c);
            this.a.addView(this.d);
            this.d.addView(this.e);
            this.d.addView(this.f);
            this.a.addView(this.g);
            a(this.f, f1);
            a(this.g, f1);
            this.f.setImageBitmap(h);
            this.g.setImageBitmap(i);
            this.e.setTextAppearance(paramContext, 16973892);
            paramContext = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
            paramContext.addRule(13);
            this.c.setLayoutParams(paramContext);
            paramContext = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
            paramContext.height = -1;
            paramContext.width = -1;
            paramContext.addRule(13);
            this.b.setLayoutParams(paramContext);
            paramContext = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
            paramContext.addRule(10);
            paramContext.addRule(14);
            this.d.setLayoutParams(paramContext);
            paramContext = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
            paramContext.addRule(9);
            paramContext.addRule(15);
            paramContext.setMargins(Math.round(f1 * 5.0F), 0, 0, 0);
            this.e.setLayoutParams(paramContext);
            paramContext = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
            paramContext.addRule(11);
            paramContext.addRule(15);
            this.f.setLayoutParams(paramContext);
            paramContext = (RelativeLayout.LayoutParams)this.g.getLayoutParams();
            paramContext.addRule(11);
            paramContext.addRule(12);
            this.g.setLayoutParams(paramContext);
            return;
            localIOException2 = localIOException2;
            localIOException2.printStackTrace();
          }
          localIOException3 = localIOException3;
          localIOException3.printStackTrace();
        }
        catch (IOException localIOException1)
        {
          for (;;)
          {
            localIOException1.printStackTrace();
          }
        }
      }
    }
  }
  
  private static void a(ImageView paramImageView, float paramFloat)
  {
    paramImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramImageView.setMinimumWidth((int)(42.0F * paramFloat));
    paramImageView.setMinimumHeight((int)(42.0F * paramFloat));
  }
  
  public final RelativeLayout a()
  {
    return this.a;
  }
  
  public final void a(boolean paramBoolean)
  {
    ImageView localImageView = this.g;
    if (paramBoolean) {}
    for (Bitmap localBitmap = i;; localBitmap = j)
    {
      localImageView.setImageBitmap(localBitmap);
      return;
    }
  }
  
  public final ProgressBar b()
  {
    return this.c;
  }
  
  public final TextView c()
  {
    return this.e;
  }
  
  public final ImageView d()
  {
    return this.f;
  }
  
  public final ImageView e()
  {
    return this.g;
  }
  
  public final VideoView f()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */