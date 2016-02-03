package com.gtp.go.weather.sharephoto.takephoto;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.SparseArray;
import android.widget.ImageView;
import com.jiubang.ggheart.apps.desks.diy.filter.core.FilterParameter;
import com.jiubang.ggheart.apps.desks.diy.filter.core.FilterService;
import java.lang.ref.SoftReference;

class g
  extends AsyncTask
{
  g(f paramf, FilterParameter paramFilterParameter) {}
  
  protected Bitmap a(Void... paramVarArgs)
  {
    return d.d(this.b.f).render(this.a);
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.b.b.setImageBitmap(paramBitmap);
      d.c(this.b.f).append(this.a.getTypeId(), new SoftReference(paramBitmap));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */