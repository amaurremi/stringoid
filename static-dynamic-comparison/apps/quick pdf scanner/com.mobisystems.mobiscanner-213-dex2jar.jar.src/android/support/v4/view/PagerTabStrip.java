package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.TextView;

public class PagerTabStrip
  extends PagerTitleStrip
{
  private int aU = this.bx;
  private int aV;
  private int aW;
  private int aX;
  private int aY;
  private int aZ;
  private final Paint ba = new Paint();
  private int bb = 255;
  private boolean bc = false;
  private boolean bd = false;
  private int be;
  private boolean bf;
  private float bg;
  private float bh;
  private int bi;
  private final Rect mTempRect = new Rect();
  
  public PagerTabStrip(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PagerTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.ba.setColor(this.aU);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.aV = ((int)(3.0F * f + 0.5F));
    this.aW = ((int)(6.0F * f + 0.5F));
    this.aX = ((int)(64.0F * f));
    this.aZ = ((int)(16.0F * f + 0.5F));
    this.be = ((int)(1.0F * f + 0.5F));
    this.aY = ((int)(f * 32.0F + 0.5F));
    this.bi = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    f(z());
    setWillNotDraw(false);
    this.bl.setFocusable(true);
    this.bl.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        PagerTabStrip.this.bk.j(PagerTabStrip.this.bk.F() - 1);
      }
    });
    this.bn.setFocusable(true);
    this.bn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        PagerTabStrip.this.bk.j(PagerTabStrip.this.bk.F() + 1);
      }
    });
    if (getBackground() == null) {
      this.bc = true;
    }
  }
  
  void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    Rect localRect = this.mTempRect;
    int i = getHeight();
    int j = this.bm.getLeft();
    int k = this.aZ;
    int m = this.bm.getRight();
    int n = this.aZ;
    int i1 = i - this.aV;
    localRect.set(j - k, i1, m + n, i);
    super.a(paramInt, paramFloat, paramBoolean);
    this.bb = ((int)(Math.abs(paramFloat - 0.5F) * 2.0F * 255.0F));
    localRect.union(this.bm.getLeft() - this.aZ, i1, this.bm.getRight() + this.aZ, i);
    invalidate(localRect);
  }
  
  public void f(int paramInt)
  {
    int i = paramInt;
    if (paramInt < this.aX) {
      i = this.aX;
    }
    super.f(i);
  }
  
  int getMinHeight()
  {
    return Math.max(super.getMinHeight(), this.aY);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = this.bm.getLeft();
    int k = this.aZ;
    int m = this.bm.getRight();
    int n = this.aZ;
    int i1 = this.aV;
    this.ba.setColor(this.bb << 24 | this.aU & 0xFFFFFF);
    paramCanvas.drawRect(j - k, i - i1, m + n, i, this.ba);
    if (this.bc)
    {
      this.ba.setColor(0xFF000000 | this.aU & 0xFFFFFF);
      paramCanvas.drawRect(getPaddingLeft(), i - this.be, getWidth() - getPaddingRight(), i, this.ba);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 0) && (this.bf)) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    for (;;)
    {
      return true;
      this.bg = f1;
      this.bh = f2;
      this.bf = false;
      continue;
      if ((Math.abs(f1 - this.bg) > this.bi) || (Math.abs(f2 - this.bh) > this.bi))
      {
        this.bf = true;
        continue;
        if (f1 < this.bm.getLeft() - this.aZ) {
          this.bk.j(this.bk.F() - 1);
        } else if (f1 > this.bm.getRight() + this.aZ) {
          this.bk.j(this.bk.F() + 1);
        }
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    if (!this.bd) {
      if ((0xFF000000 & paramInt) != 0) {
        break label27;
      }
    }
    label27:
    for (boolean bool = true;; bool = false)
    {
      this.bc = bool;
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (!this.bd) {
      if (paramDrawable != null) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.bc = bool;
      return;
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (!this.bd) {
      if (paramInt != 0) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.bc = bool;
      return;
    }
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt4;
    if (paramInt4 < this.aW) {
      i = this.aW;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/PagerTabStrip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */