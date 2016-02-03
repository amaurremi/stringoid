package com.gtp.go.weather.sharephoto.award;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.gtp.go.weather.sharephoto.b.a;
import com.gtp.go.weather.sharephoto.b.b;
import java.util.ArrayList;
import java.util.Iterator;

class j
  implements View.OnClickListener
{
  private View b;
  private TextView c;
  private CheckBox d;
  private ImageView e;
  private h f;
  
  j(i parami)
  {
    this.b = c.b(parami.a).getLayoutInflater().inflate(2130903279, null);
    this.c = ((TextView)this.b.findViewById(2131231896));
    this.d = ((CheckBox)this.b.findViewById(2131231256));
    this.e = ((ImageView)this.b.findViewById(2131231897));
    this.b.setOnClickListener(this);
  }
  
  private void a()
  {
    Object localObject = this.f.b;
    a locala;
    if (((b)localObject).c() == 1)
    {
      locala = ((b)localObject).d();
      this.c.setText(locala.d());
      com.gtp.a.a.b.c.a("AwardListDialog", "mApkName: " + locala.d() + ", picPath" + locala.b());
      if (!TextUtils.isEmpty(locala.b())) {
        break label107;
      }
      c.a(this.a.a, (b)localObject);
    }
    for (;;)
    {
      this.d.setChecked(this.f.a);
      return;
      label107:
      localObject = c.a(this.a.a, locala.b());
      if (localObject != null) {
        this.e.setImageBitmap((Bitmap)localObject);
      }
    }
  }
  
  void a(int paramInt)
  {
    this.f = ((h)c.a(this.a.a).get(paramInt));
    a();
  }
  
  public void onClick(View paramView)
  {
    c.c(this.a.a).setBackgroundResource(2130839068);
    c.c(this.a.a).setEnabled(true);
    paramView = c.a(this.a.a).iterator();
    while (paramView.hasNext())
    {
      h localh = (h)paramView.next();
      if (localh.a) {
        localh.a = false;
      }
    }
    this.f.a = true;
    c.a(this.a.a, this.f);
    c.d(this.a.a).notifyDataSetChanged();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */