package com.pocket.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.pocket.k.d;
import com.pocket.widget.RainbowProgressCircleView;
import java.io.File;

public abstract class a
  implements View.OnClickListener
{
  protected ViewGroup a;
  protected ImageView b;
  protected TextView c;
  protected RainbowProgressCircleView d;
  protected b e;
  protected Bitmap f;
  private final Context g;
  
  public a(Context paramContext, b paramb)
  {
    this.g = paramContext;
    a(paramb);
    a();
    g();
    b();
    this.a.setOnClickListener(this);
  }
  
  protected void a()
  {
    this.a = ((ViewGroup)LayoutInflater.from(k()).inflate(2130903122, null));
    this.b = ((ImageView)this.a.findViewById(2131230733));
    this.c = ((TextView)this.a.findViewById(2131230902));
    this.d = ((RainbowProgressCircleView)this.a.findViewById(2131230988));
  }
  
  protected void a(Bitmap paramBitmap)
  {
    this.f = paramBitmap;
    this.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.b.setImageBitmap(paramBitmap);
    i();
  }
  
  public abstract void a(Bundle paramBundle);
  
  public void a(b paramb)
  {
    this.e = paramb;
  }
  
  protected void b()
  {
    int i = d();
    if (i != 0) {
      this.b.setImageResource(i);
    }
  }
  
  public abstract int c();
  
  protected abstract int d();
  
  protected abstract void e();
  
  public abstract void f();
  
  protected void g()
  {
    this.c.setText(c());
  }
  
  public void h()
  {
    this.d.setVisibility(0);
  }
  
  public void i()
  {
    this.d.setVisibility(8);
  }
  
  public View j()
  {
    return this.a;
  }
  
  protected Context k()
  {
    return this.g;
  }
  
  public Bitmap l()
  {
    return this.f;
  }
  
  public com.pocket.k.a m()
  {
    int i = (int)k().getResources().getDimension(2131296262);
    return new d(i, i);
  }
  
  public abstract File n();
  
  public abstract String o();
  
  public void onClick(View paramView)
  {
    if (this.f != null)
    {
      if (this.e != null) {
        this.e.a(this, this.f);
      }
      return;
    }
    e();
  }
  
  public abstract Bundle p();
  
  public void q() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */