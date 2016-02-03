package com.gtp.go.weather.sharephoto.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.gtp.go.weather.sharephoto.PhotoDetailActivity;
import com.gtp.go.weather.sharephoto.b.g;
import com.gtp.go.weather.sharephoto.b.p;
import com.gtp.go.weather.sharephoto.c.d;
import com.gtp.go.weather.sharephoto.c.l;
import com.gtp.go.weather.sharephoto.d.c;
import com.gtp.go.weather.sharephoto.d.h;
import com.gtp.go.weather.sharephoto.d.j;

public class UserPhotoItem
  extends FrameLayout
  implements View.OnClickListener
{
  private p a;
  private TextView b;
  private ImageView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private AnimDeleteButton g;
  private TextView h;
  private View i;
  private f j;
  private View k;
  private Context l;
  private c m;
  
  public UserPhotoItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.l = paramContext;
  }
  
  private void a(int paramInt)
  {
    Intent localIntent = new Intent(getContext(), PhotoDetailActivity.class);
    localIntent.putExtra("extra_photo_id", this.a.c());
    if (!this.a.b()) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("extra_photo_isuploaded", bool);
      localIntent.putExtra("extra_enter_type", paramInt);
      getContext().startActivity(localIntent);
      return;
    }
  }
  
  private void d()
  {
    if (this.a.b())
    {
      String str2 = this.a.f();
      String str3 = this.a.g();
      String str1 = h.a(this.a.c());
      localBitmap = com.gtp.go.weather.sharephoto.d.a.a(str1);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = this.l.getResources();
        int n = (int)(((Resources)localObject).getDisplayMetrics().widthPixels * 0.8D);
        int i1 = (int)((Resources)localObject).getDimension(2131427836);
        localObject = h.a(getContext(), n, i1 * 2, str2, str3, str1);
        com.gtp.go.weather.sharephoto.d.a.a(str1, (Bitmap)localObject);
      }
      this.c.setImageBitmap((Bitmap)localObject);
      return;
    }
    Object localObject = this.a.j();
    Bitmap localBitmap = com.gtp.go.weather.sharephoto.d.a.a((String)localObject);
    if (localBitmap == null)
    {
      this.m.a(j.a, (String)localObject, null, new o(this, (String)localObject));
      return;
    }
    this.c.setImageBitmap(localBitmap);
  }
  
  public UserPhotoItem a()
  {
    if (this.a != null)
    {
      this.b.setText(this.a.d());
      String str = this.a.e();
      if (TextUtils.isEmpty(str)) {
        break label166;
      }
      this.d.setText(str);
      this.e.setText(String.valueOf(this.a.m()));
      this.f.setText(String.valueOf(this.a.l()));
      if (!this.a.k()) {
        break label178;
      }
      this.f.setCompoundDrawablesWithIntrinsicBounds(2130838407, 0, 0, 0);
    }
    boolean bool;
    for (;;)
    {
      this.c.setOnClickListener(this);
      if (this.c.getDrawable() == null) {
        d();
      }
      if (this.a.b())
      {
        bool = l.a(Long.valueOf(this.a.c()));
        if (!this.a.h()) {
          break label193;
        }
        this.h.setVisibility(4);
      }
      return this;
      label166:
      this.d.setVisibility(8);
      break;
      label178:
      this.f.setCompoundDrawablesWithIntrinsicBounds(2130838406, 0, 0, 0);
    }
    label193:
    if (bool)
    {
      this.h.setVisibility(0);
      this.h.setText(2131166314);
      this.h.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      this.h.setOnClickListener(null);
      return this;
    }
    this.h.setVisibility(0);
    this.h.setText(2131166313);
    this.h.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838438, 0);
    this.h.setOnClickListener(this);
    return this;
  }
  
  public UserPhotoItem a(View paramView)
  {
    this.k = paramView;
    return this;
  }
  
  public UserPhotoItem a(p paramp)
  {
    if (paramp != null) {
      this.a = paramp;
    }
    return this;
  }
  
  public UserPhotoItem a(c paramc)
  {
    this.m = paramc;
    return this;
  }
  
  public void a(f paramf)
  {
    this.j = paramf;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.i.setVisibility(0);
      return;
    }
    this.i.setVisibility(8);
  }
  
  public long b()
  {
    if (this.a != null) {
      return this.a.c();
    }
    return -1L;
  }
  
  public String c()
  {
    if (this.a != null) {
      return this.a.i();
    }
    return "";
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    if (this.j != null)
    {
      if (!paramView.equals(this.g)) {
        break label102;
      }
      if (!this.g.c()) {
        break label49;
      }
      this.j.a(b(), this.k, this);
    }
    label49:
    label102:
    label180:
    label268:
    label275:
    do
    {
      return;
      paramView = new com.gau.go.launcherex.gowidget.statistics.a.a(117, "delete_click");
      paramView.a(String.valueOf(this.a.c()));
      paramView.d("2");
      com.gau.go.launcherex.gowidget.statistics.r.a(getContext()).a(paramView);
      this.g.a();
      return;
      if (this.g.c()) {
        this.g.b();
      }
      if (paramView.equals(this.f))
      {
        int n;
        if (!this.a.k())
        {
          n = this.a.l();
          paramView = new g();
          paramView.a(this.a.c());
          paramView.a(bool);
          if (!bool) {
            break label268;
          }
          n += 1;
          paramView.a(n);
          d.a(getContext()).a(paramView);
          if (!bool) {
            break label275;
          }
        }
        for (paramView = "exellent_add";; paramView = "exellent_minus")
        {
          paramView = new com.gau.go.launcherex.gowidget.statistics.a.a(117, paramView);
          paramView.a(String.valueOf(this.a.c()));
          paramView.d("2");
          com.gau.go.launcherex.gowidget.statistics.r.a(this.l).a(paramView);
          this.j.a(b(), bool, this);
          return;
          bool = false;
          break;
          n -= 1;
          break label180;
        }
      }
      if (paramView.equals(this.c))
      {
        a(1);
        paramView = new com.gau.go.launcherex.gowidget.statistics.a.a(117, "click_fs");
        paramView.a(String.valueOf(this.a.c()));
        paramView.d("2");
        com.gau.go.launcherex.gowidget.statistics.r.a(getContext()).a(paramView);
        return;
      }
      if (paramView.equals(this.e))
      {
        a(2);
        paramView = new com.gau.go.launcherex.gowidget.statistics.a.a(117, "fs_set_background");
        paramView.a(String.valueOf(this.a.c()));
        com.gau.go.launcherex.gowidget.statistics.r.a(this.l).a(paramView);
        return;
      }
    } while (!paramView.equals(this.h));
    if (com.gau.go.launcherex.gowidget.weather.util.r.c(getContext()))
    {
      this.h.setOnClickListener(null);
      this.h.setText(2131166314);
      this.h.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      Toast.makeText(getContext(), 2131166390, 0).show();
      l.a(getContext(), this.a.a());
      return;
    }
    Toast.makeText(getContext(), 2131165748, 0).show();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setOnClickListener(this);
    this.b = ((TextView)findViewById(2131231208));
    this.c = ((ImageView)findViewById(2131230800));
    this.d = ((TextView)findViewById(2131231298));
    this.e = ((TextView)findViewById(2131231201));
    this.e.setOnClickListener(this);
    this.f = ((TextView)findViewById(2131230803));
    this.f.setOnClickListener(this);
    this.g = ((AnimDeleteButton)findViewById(2131231206));
    this.g.setOnClickListener(this);
    this.h = ((TextView)findViewById(2131231831));
    this.i = findViewById(2131231830);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/view/UserPhotoItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */