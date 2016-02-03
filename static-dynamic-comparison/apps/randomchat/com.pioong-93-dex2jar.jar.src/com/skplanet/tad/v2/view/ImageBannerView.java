package com.skplanet.tad.v2.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import com.skplanet.tad.common.a;
import com.skplanet.tad.common.f;
import com.skplanet.tad.common.f.a;

public class ImageBannerView
  extends ViewFlipper
{
  public ImageBannerView(Context paramContext, Bitmap[] paramArrayOfBitmap)
  {
    super(paramContext);
    final int j = paramArrayOfBitmap.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        setInAnimation(f.a(f.a.j, new Animation.AnimationListener()
        {
          public void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            if (ImageBannerView.this.getDisplayedChild() == j - 1) {
              ImageBannerView.this.stopFlipping();
            }
          }
          
          public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public void onAnimationStart(Animation paramAnonymousAnimation) {}
        }));
        setOutAnimation(f.a(f.a.k, null));
        return;
      }
      ImageView localImageView = new ImageView(paramContext);
      localImageView.setImageBitmap(paramArrayOfBitmap[i]);
      addView(localImageView);
      i += 1;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    try
    {
      super.onDetachedFromWindow();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      a.d("ImageBannerView.onDetachedFromWindow");
      stopFlipping();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/v2/view/ImageBannerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */