package com.gtp.go.weather.sharephoto.takephoto;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import com.jiubang.ggheart.apps.desks.diy.filter.core.FilterParameter;
import com.jiubang.ggheart.apps.desks.diy.filter.core.FilterService;

final class c
  extends AsyncTask
{
  private c(EditPhotoActivity paramEditPhotoActivity) {}
  
  protected Bitmap a(FilterParameter... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    if (paramVarArgs.mSrcBitmap == null)
    {
      Bitmap localBitmap = ab.a(ab.a(EditPhotoActivity.a(this.a), EditPhotoActivity.b(this.a), EditPhotoActivity.c(this.a)), EditPhotoActivity.d(this.a));
      publishProgress(new Bitmap[] { localBitmap });
      paramVarArgs.mSrcBitmap = localBitmap;
    }
    return EditPhotoActivity.e(this.a).render(paramVarArgs);
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if ((!isCancelled()) && (paramBitmap != null))
    {
      paramBitmap = new BitmapDrawable(this.a.e(), paramBitmap);
      EditPhotoActivity.f(this.a).a(paramBitmap);
      if (!EditPhotoActivity.g(this.a))
      {
        EditPhotoActivity.a(this.a, true);
        this.a.a(5);
      }
    }
  }
  
  protected void a(Bitmap... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      EditPhotoActivity.a(this.a, paramVarArgs[0]);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */