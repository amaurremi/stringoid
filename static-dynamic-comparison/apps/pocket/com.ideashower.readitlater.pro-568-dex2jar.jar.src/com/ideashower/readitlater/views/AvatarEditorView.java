package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.ideashower.readitlater.util.j;
import com.pocket.d.i;

public class AvatarEditorView
  extends s
{
  private Paint f;
  private ColorStateList g;
  private Paint h;
  private PorterDuffXfermode i;
  private int j;
  private i k;
  
  public AvatarEditorView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public AvatarEditorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  public AvatarEditorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private void d()
  {
    Resources localResources = getResources();
    this.j = ((int)(localResources.getDimension(2131296261) / 2.0F));
    a(this.j, this.j);
    int m = j.a(15.0F);
    setPadding(m, m, m, m);
    this.h = new Paint();
    this.g = localResources.getColorStateList(2131165744);
    this.f = new Paint();
    this.f.setAntiAlias(true);
    this.f.setColor(-16777216);
    this.i = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    this.k = new i(getContext());
  }
  
  protected void a()
  {
    super.a();
    this.k.a(this.e);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.k.setState(getDrawableState());
    this.h.setColor(this.g.getColorForState(getDrawableState(), 0));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int m = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
    float f1 = Math.min(this.e.width() / 2.0F, this.e.height() / 2.0F);
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.h);
    this.k.draw(paramCanvas);
    this.f.setXfermode(this.i);
    paramCanvas.drawCircle(this.e.exactCenterX(), this.e.exactCenterY(), f1, this.f);
    this.f.setXfermode(null);
    paramCanvas.restoreToCount(m);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/AvatarEditorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */