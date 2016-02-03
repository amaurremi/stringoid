package com.pocket.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import com.b.c.c;
import com.ideashower.readitlater.views.ThemedEditText;
import com.pocket.b.b;

public class ValidatedEditText
  extends ThemedEditText
{
  private static final Interpolator a = new DecelerateInterpolator();
  private static final Interpolator b = new OvershootInterpolator(3.0F);
  private av c;
  private aw d = aw.a;
  private b e;
  private boolean f;
  
  public ValidatedEditText(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public ValidatedEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  public ValidatedEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private aw a(boolean paramBoolean)
  {
    if (this.c != null) {
      setValidity(this.c.a(this, getText().toString(), paramBoolean));
    }
    for (;;)
    {
      return this.d;
      setValidity(aw.a);
    }
  }
  
  private void d()
  {
    this.e = new b()
    {
      public void a(com.b.a.a paramAnonymousa)
      {
        c.a(ValidatedEditText.this).b(0L).i(1.0F).g(1.0F).a(300L).a(ValidatedEditText.c()).a(null);
      }
    };
  }
  
  public aw a()
  {
    return a(false);
  }
  
  public void b()
  {
    if ((this.c instanceof as)) {
      as.a((as)this.c);
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (paramBoolean) {
      setValidity(aw.a);
    }
    while (!this.f) {
      return;
    }
    a(true);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (this.d != aw.a) {
      setValidity(aw.a);
    }
  }
  
  public void setInstantValidationEnabled(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setValidator(av paramav)
  {
    this.c = paramav;
    if ((this.c instanceof as)) {
      as.a((as)this.c, this);
    }
  }
  
  public void setValidity(aw paramaw)
  {
    if (paramaw == aw.a) {
      b();
    }
    if ((paramaw == this.d) || (paramaw == aw.c)) {
      return;
    }
    this.d = paramaw;
    if (paramaw == aw.b) {}
    for (int i = 2130837849;; i = 2130837799)
    {
      setBackgroundResource(i);
      if ((paramaw != aw.b) || (!com.ideashower.readitlater.util.a.i())) {
        break;
      }
      com.b.c.a.b(this, 1.0F);
      com.b.c.a.c(this, 1.0F);
      c.a(this).b(0L).i(1.07F).g(1.07F).a(200L).a(a).a(this.e);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/ValidatedEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */