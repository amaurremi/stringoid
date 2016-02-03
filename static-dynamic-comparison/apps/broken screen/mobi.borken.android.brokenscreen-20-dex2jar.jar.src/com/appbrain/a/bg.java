package com.appbrain.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import cmn.q;
import com.appbrain.d.g;

final class bg
  extends g
{
  Paint a = new Paint(1);
  Path b;
  
  bg(at.k paramk, int paramInt1, int paramInt2, at.d paramd)
  {
    super(paramInt1, paramInt2);
    this.a.setColor(this.c.c.h);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    paramCanvas.drawPath(this.b, this.a);
  }
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.b = new Path();
    this.b.moveTo(paramInt1, paramInt4);
    this.b.arcTo(new RectF(paramInt1 - q.a(30.0F), paramInt2 - q.a(50.0F), paramInt3 + q.a(30.0F), (paramInt4 - paramInt2) * 2 / 3 + paramInt2), 180.0F, -180.0F);
    this.b.lineTo(paramInt3, paramInt4);
    this.b.lineTo(paramInt1, paramInt4);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */