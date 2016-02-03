package com.gtp.go.weather.sharephoto.takephoto;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.viewframe.viewholder.b;

class l
  extends b
  implements View.OnClickListener
{
  TextView a;
  ImageView b;
  ResolveInfo c;
  int d = 1;
  
  public l(k paramk, Context paramContext)
  {
    super(paramContext);
    this.e = k.a(paramk).getLayoutInflater().inflate(2130903282, null);
    this.e.setOnClickListener(this);
    this.a = ((TextView)b(2131230938));
    this.b = ((ImageView)b(2131230937));
  }
  
  void a(ResolveInfo paramResolveInfo)
  {
    this.c = paramResolveInfo;
    this.a.setText(paramResolveInfo.activityInfo.loadLabel(k.b(this.g)));
    this.b.setImageDrawable(paramResolveInfo.activityInfo.loadIcon(k.b(this.g)).mutate());
  }
  
  public void onClick(View paramView)
  {
    paramView = EditPhotoActivity.a(k.c(this.g), this.d, this.c.activityInfo.packageName, this.c.activityInfo.name);
    k.d(this.g).startActivity(paramView);
    this.g.dismiss();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */