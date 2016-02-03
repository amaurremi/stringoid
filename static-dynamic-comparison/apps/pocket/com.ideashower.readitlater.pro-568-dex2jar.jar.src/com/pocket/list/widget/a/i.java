package com.pocket.list.widget.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.e.x;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.AvatarView;
import com.ideashower.readitlater.views.ImageRequestView;
import com.pocket.i.a.c;
import com.pocket.p.e;
import com.pocket.p.u;
import com.pocket.widget.MaxLineFixedTextView;
import java.util.ArrayList;

public class i
  extends RelativeLayout
{
  private static final int a = e.a(0.35F, 0);
  private static final int b = e.a(0.45F, 0);
  private static final float c = g.c().getResources().getDimension(2131296266);
  private static final float d = g.c().getResources().getDimension(2131296267);
  private static final float e = j.a(7.0F);
  private static final int f = e.a(0.59F, 0);
  private static final float g = j.a(1.0F);
  private static final float h = j.a(0.5F);
  private static final float i = j.a(1.0F);
  private static final int j = e.a(0.23F, 0);
  private static final float[] k;
  private static final int[] l;
  private static final int m = j.a(7.5F);
  private final ImageRequestView n;
  private final MaxLineFixedTextView o;
  private final TextView p;
  private final a q;
  private final c r;
  private final Paint s;
  private AvatarView t;
  private TextView u;
  private MaxLineFixedTextView v;
  private Bitmap w;
  private boolean x;
  private com.ideashower.readitlater.e.o y;
  
  static
  {
    com.pocket.p.f localf = new com.pocket.p.f().a(e.a(0.3F, 0), 0.21F).a(e.a(0.3F, 0), 0.25F).a(e.a(0.24F, 0), 0.32F).a(e.a(0.18F, 0), 0.36F).a(e.a(0.15F, 0), 0.38F).a(e.a(0.09F, 0), 0.46F).a(e.a(0.06F, 0), 0.52F).a(e.a(0.05F, 0), 0.56F).a(e.a(0.06F, 0), 0.62F).a(e.a(0.07F, 0), 0.66F).a(e.a(0.13F, 0), 0.77F).a(e.a(0.21F, 0), 0.86F).a(e.a(0.31F, 0), 0.95F);
    l = localf.b();
    k = localf.a();
  }
  
  public i(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2130903124, this, true);
    this.n = ((ImageRequestView)findViewById(2131230925));
    this.o = ((MaxLineFixedTextView)findViewById(2131230768));
    this.p = ((TextView)findViewById(2131230991));
    this.q = new a(paramContext, b.a);
    this.q.setBounds(0, m, 0, 0);
    this.q.setCallback(new Drawable.Callback()
    {
      public void invalidateDrawable(Drawable paramAnonymousDrawable)
      {
        i.this.invalidate();
      }
      
      public void scheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable, long paramAnonymousLong) {}
      
      public void unscheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable) {}
    });
    this.n.setDrawPlaceholder(false);
    this.r = new c();
    this.s = new Paint();
    setClickable(true);
    setLongClickable(false);
  }
  
  private void a()
  {
    if (this.t != null) {
      return;
    }
    LayoutInflater.from(getContext()).inflate(2130903125, this, true);
    this.t = ((AvatarView)findViewById(2131230733));
    this.u = ((TextView)findViewById(2131230992));
  }
  
  private void a(Canvas paramCanvas)
  {
    if (!isPressed())
    {
      paramCanvas.drawColor(a);
      return;
    }
    paramCanvas.drawColor(b);
  }
  
  private void a(TextView paramTextView, com.ideashower.readitlater.e.o paramo)
  {
    if ((paramTextView == null) || (paramTextView.getVisibility() != 0)) {
      return;
    }
    if (paramo.e(false))
    {
      u.a(paramTextView, e, 0.0F, 0.0F, f);
      return;
    }
    u.a(paramTextView, g, h, i, j);
  }
  
  private void b()
  {
    if (this.v != null) {
      return;
    }
    LayoutInflater.from(getContext()).inflate(2130903126, this, true);
    this.v = ((MaxLineFixedTextView)findViewById(2131230993));
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.n.getDrawable() == null)
    {
      this.r.draw(paramCanvas);
      a(paramCanvas);
    }
    super.dispatchDraw(paramCanvas);
    if (this.x)
    {
      float f1 = getWidth() / 2.0F;
      float f2 = this.w.getWidth() / 2.0F;
      float f3 = this.p.getTop() + this.p.getBaseline();
      float f4 = (getHeight() - j.a(25.0F) - f3) / 2.0F;
      float f5 = this.w.getHeight() / 2.0F;
      paramCanvas.drawBitmap(this.w, f1 - f2, f3 + (f4 - f5), null);
    }
    this.q.draw(paramCanvas);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    if ((paramView == this.n) && (this.n.getDrawable() != null))
    {
      a(paramCanvas);
      paramCanvas.drawPaint(this.s);
    }
    return bool;
  }
  
  public com.ideashower.readitlater.e.o getItem()
  {
    return this.y;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.r.setBounds(0, 0, getWidth(), getHeight());
      this.s.setShader(new LinearGradient(0.0F, getTop(), 0.0F, getBottom(), l, k, Shader.TileMode.CLAMP));
    }
  }
  
  public void setItem(com.ideashower.readitlater.e.o paramo)
  {
    this.y = paramo;
    this.o.setText(paramo.t());
    this.p.setText(paramo.o());
    this.n.a(paramo.ab(), paramo.ad());
    this.q.a(paramo.A().a());
    boolean bool1 = paramo.L();
    boolean bool2 = paramo.e(false);
    boolean bool3 = paramo.s();
    if (bool1)
    {
      this.x = true;
      if (this.w == null) {
        this.w = BitmapFactory.decodeResource(getResources(), 2130837915);
      }
      if ((bool2) || (this.x) || (bool3)) {
        break label325;
      }
      this.o.setMaxLines(3);
      label127:
      if (!bool2) {
        break label336;
      }
      this.o.setTextSize(0, c);
      this.o.setLineSpacing(0.0F, 0.9F);
      z.a(this.o, j.a(34.0F));
      z.b(this.o, j.a(10.5F));
      label179:
      if ((bool2) || (this.x) || (!bool3)) {
        break label387;
      }
      b();
      this.v.setTextSafe(paramo.r());
    }
    for (;;)
    {
      bool1 = paramo.h(true);
      z.c(this.t, false);
      z.c(this.u, false);
      if (bool1)
      {
        a();
        com.ideashower.readitlater.db.operation.f localf = com.ideashower.readitlater.a.o.c().a((x)paramo.U().get(0));
        this.t.setFriend(localf);
        this.u.setText(localf.h());
      }
      a(this.o, paramo);
      a(this.p, paramo);
      a(this.v, paramo);
      a(this.u, paramo);
      return;
      this.x = false;
      break;
      label325:
      this.o.setMaxLines(2);
      break label127;
      label336:
      this.o.setTextSize(0, d);
      this.o.setLineSpacing(0.0F, 0.85F);
      z.a(this.o, j.a(36.0F));
      z.b(this.o, j.a(13.0F));
      break label179;
      label387:
      if (this.v != null) {
        this.v.setVisibility(8);
      }
    }
  }
  
  public void setPressed(boolean paramBoolean)
  {
    super.setPressed(paramBoolean);
    invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */