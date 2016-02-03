package com.vungle.publisher.display.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.widget.TextView;
import com.vungle.publisher.image.BitmapFactory;
import com.vungle.publisher.log.Logger;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;

public final class CountdownProgressView
  extends TextView
{
  private int a;
  private int b;
  
  CountdownProgressView(Context paramContext, BitmapFactory paramBitmapFactory)
  {
    super(paramContext);
    setTextColor(-1);
    setTextSize(16.0F);
    setGravity(17);
    try
    {
      setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmapFactory.getBitmap("vg_timer.png")));
      return;
    }
    catch (IOException paramContext)
    {
      Logger.d("VungleAd", "error loading countdown progress bar background", paramContext);
    }
  }
  
  private void a()
  {
    setText(Integer.toString(this.a - this.b));
    invalidate();
  }
  
  final void setMax(int paramInt)
  {
    if (paramInt != this.a)
    {
      this.a = paramInt;
      a();
    }
  }
  
  final void setProgress(int paramInt)
  {
    if (paramInt != this.b)
    {
      this.b = paramInt;
      a();
    }
  }
  
  @Singleton
  static class Factory
  {
    @Inject
    BitmapFactory a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/display/view/CountdownProgressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */