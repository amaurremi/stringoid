package com.go.weatherex.themestore;

import android.graphics.Bitmap;
import android.widget.ListView;
import com.gau.go.launcherex.gowidget.weather.service.a.a;
import com.jiubang.playsdk.imageload.KPNetworkImageView;
import com.jiubang.playsdk.main.BitmapBean;
import java.util.Map;

class h
  extends com.gau.go.launcherex.gowidget.weather.service.a.g
{
  h(g paramg) {}
  
  public void b(a parama)
  {
    if (!e.class.isInstance(parama)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (e)parama;
        parama = ((e)localObject).c();
      } while ((parama == null) || (parama.a() == null) || (parama.a().isRecycled()));
      localObject = ((e)localObject).d();
      g.a(this.a).put(localObject, parama);
    } while (!(this.a.a.findViewWithTag(localObject) instanceof KPNetworkImageView));
    g.a(this.a, parama, (KPNetworkImageView)this.a.a.findViewWithTag(localObject));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */