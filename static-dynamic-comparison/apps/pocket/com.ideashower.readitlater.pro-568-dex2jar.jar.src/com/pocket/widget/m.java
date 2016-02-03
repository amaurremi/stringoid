package com.pocket.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ideashower.readitlater.e.g;
import com.ideashower.readitlater.e.j;
import com.ideashower.readitlater.e.k;
import com.ideashower.readitlater.util.i;
import com.pocket.list.adapter.data.ItemQuery;
import com.pocket.list.adapter.f;
import com.pocket.list.widget.b;

public class m
  extends RelativeLayout
  implements f
{
  private final b a;
  private final GradientDrawable b;
  private final View c;
  private final TextView d;
  private final ImageView e;
  private g f;
  private boolean g = false;
  private com.a.a.a.a h;
  
  public m(Context paramContext, b paramb)
  {
    super(paramContext);
    this.a = paramb;
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903140, this, true);
    this.d = ((TextView)findViewById(2131231046));
    this.e = ((ImageView)findViewById(2131231045));
    this.c = findViewById(2131231044);
    this.b = ((GradientDrawable)((LayerDrawable)this.c.getBackground()).findDrawableByLayerId(2131231158));
    this.d.setTypeface(i.a(i.a));
    setGroup(null);
  }
  
  private void a()
  {
    if (this.f != null)
    {
      int i = this.f.b().getColorForState(getDrawableState(), 0);
      this.b.setColor(i);
      invalidate();
    }
  }
  
  private void b()
  {
    if (this.a.getPocketAdapter() == null) {
      return;
    }
    int j = this.a.getTileSpacingY() * 2;
    if ((this.a.getPocketAdapter() != null) && (this.a.getPocketAdapter().e())) {}
    for (int i = 0;; i = j)
    {
      setPadding(this.a.getTiledGutterLeft() + this.a.getTileSpacingX(), j, this.a.getTiledGutterRight() + this.a.getTileSpacingX(), i);
      return;
    }
  }
  
  public void a(com.pocket.list.adapter.a parama)
  {
    b();
    int i = parama.b().j().n();
    if (i != 0)
    {
      setGroup(k.a().a(i));
      return;
    }
    setGroup(null);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    a();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
  
  public void setGroup(g paramg)
  {
    if ((this.f == paramg) && (this.g)) {}
    do
    {
      return;
      this.g = true;
      this.f = paramg;
      if (paramg != null)
      {
        this.d.setText(this.f.c(getContext()));
        this.e.setVisibility(0);
        paramg = this.f.a(getContext(), new j()
        {
          public void a(g paramAnonymousg, BitmapDrawable paramAnonymousBitmapDrawable)
          {
            if (paramAnonymousg != m.a(m.this)) {
              return;
            }
            paramAnonymousg = paramAnonymousBitmapDrawable.getBitmap();
            m.b(m.this).setImageBitmap(paramAnonymousg);
          }
        });
        if (paramg != null) {
          this.e.setImageBitmap(paramg.getBitmap());
        }
        for (;;)
        {
          a();
          setVisibility(0);
          if (this.h == null) {
            break;
          }
          this.h.b(this, true);
          return;
          if (!this.f.d()) {
            this.e.setVisibility(8);
          }
        }
      }
      setVisibility(8);
    } while (this.h == null);
    this.h.b(this, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */