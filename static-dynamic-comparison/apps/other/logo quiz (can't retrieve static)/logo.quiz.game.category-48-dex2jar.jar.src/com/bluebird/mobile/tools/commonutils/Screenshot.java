package com.bluebird.mobile.tools.commonutils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import android.view.Window;

public class Screenshot
{
  private final View view;
  
  public Screenshot(Activity paramActivity)
  {
    this.view = paramActivity.getWindow().getDecorView().findViewById(16908290).getRootView();
  }
  
  public Screenshot(View paramView)
  {
    this.view = paramView;
  }
  
  public Bitmap snap()
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.view.getWidth(), this.view.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    this.view.draw(localCanvas);
    return localBitmap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/commonutils/Screenshot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */