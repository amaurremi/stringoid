package com.pocket.widget.chip;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout.LayoutParams;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.ResizeDetectRelativeLayout;
import com.ideashower.readitlater.views.toolbars.StyledIconButton;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.pocket.p.x;
import com.pocket.widget.bb;
import com.pocket.widget.bc;

public class ChipEditText
  extends ResizeDetectRelativeLayout
{
  private static final boolean a = ;
  private static final int[] b = { 16842908 };
  private static final int[] c = { 2130772086 };
  private e d;
  private com.pocket.i.a.b e;
  private boolean f;
  private bb g;
  private boolean h;
  private HorizontalScrollView i;
  
  public ChipEditText(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public ChipEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public ChipEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    Object localObject1 = null;
    int n = 0;
    int i1 = -2;
    int m = 0;
    Object localObject2;
    int j;
    boolean bool1;
    int k;
    boolean bool2;
    if (paramAttributeSet != null)
    {
      localObject2 = getContext().obtainStyledAttributes(paramAttributeSet, com.ideashower.readitlater.b.ChipEditText);
      j = ((TypedArray)localObject2).getInt(0, -1);
      paramAttributeSet = (AttributeSet)localObject1;
      if (((TypedArray)localObject2).getString(1) != null) {
        paramAttributeSet = ((TypedArray)localObject2).getString(1);
      }
      bool1 = ((TypedArray)localObject2).getBoolean(2, false);
      n = ((TypedArray)localObject2).getResourceId(3, 0);
      i1 = (int)((TypedArray)localObject2).getDimension(4, -2);
      k = ((TypedArray)localObject2).getResourceId(7, 0);
      m = ((TypedArray)localObject2).getResourceId(8, 0);
      bool2 = ((TypedArray)localObject2).getBoolean(6, false);
      localObject1 = ((TypedArray)localObject2).getString(5);
      ((TypedArray)localObject2).recycle();
    }
    for (;;)
    {
      if (getBackground() == null) {
        setBgUnderlinePadding(k);
      }
      localObject2 = new StyledIconButton(getContext());
      ((StyledIconButton)localObject2).setId(14);
      ((StyledIconButton)localObject2).setImageResource(2130837557);
      ((StyledIconButton)localObject2).setBackgroundDrawable(null);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(2131296281), -2);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      z.a((View)localObject2, 10.0F, 3.0F, 3.0F, 3.0F);
      ((StyledIconButton)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ChipEditText.this.h();
        }
      });
      this.g = new bb((View)localObject2, 8);
      this.g.a(new bc()
      {
        public boolean a()
        {
          return ChipEditText.a(ChipEditText.this);
        }
      });
      this.g.a(new bc()
      {
        public boolean a()
        {
          return (ChipEditText.this.getChipCount() > 0) || (ChipEditText.this.getText().length() > 0);
        }
      });
      addView((View)localObject2, localLayoutParams);
      this.d = new e(this, j, paramAttributeSet, m, n, i1);
      this.d.a((CharSequence)localObject1);
      paramAttributeSet = this.d;
      if ((a) && (bool2))
      {
        bool2 = true;
        paramAttributeSet.a(bool2);
        localObject1 = new RelativeLayout.LayoutParams(-1, -2);
        if (j != -1) {
          break label475;
        }
        this.i = new HorizontalScrollView(getContext())
        {
          public boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent)
          {
            if (ChipEditText.b(ChipEditText.this).getWidth() > ChipEditText.c(ChipEditText.this).getWidth()) {
              return super.onInterceptTouchEvent(paramAnonymousMotionEvent);
            }
            return false;
          }
          
          public boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent)
          {
            if (ChipEditText.b(ChipEditText.this).getWidth() > ChipEditText.c(ChipEditText.this).getWidth()) {
              return super.onTouchEvent(paramAnonymousMotionEvent);
            }
            z.a(paramAnonymousMotionEvent, ChipEditText.b(ChipEditText.this));
            return true;
          }
        };
        this.i.setHorizontalScrollBarEnabled(false);
        this.i.setVerticalScrollBarEnabled(false);
        this.i.addView(this.d);
        ((RelativeLayout.LayoutParams)localObject1).width = -2;
        paramAttributeSet = this.i;
        ((RelativeLayout.LayoutParams)localObject1).addRule(15);
        ((RelativeLayout.LayoutParams)localObject1).addRule(9);
      }
      for (;;)
      {
        ((RelativeLayout.LayoutParams)localObject1).addRule(0, ((StyledIconButton)localObject2).getId());
        addView(paramAttributeSet, (ViewGroup.LayoutParams)localObject1);
        a(new a()
        {
          public void a(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
          {
            ChipEditText.d(ChipEditText.this).a();
          }
        });
        setClearingEnabled(bool1);
        setClickable(true);
        return;
        bool2 = false;
        break;
        label475:
        this.i = null;
        paramAttributeSet = this.d;
      }
      bool1 = false;
      bool2 = false;
      j = -1;
      localObject1 = null;
      paramAttributeSet = null;
      k = 0;
    }
  }
  
  private void setBgUnderlinePadding(int paramInt)
  {
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramInt, com.ideashower.readitlater.b.EditTextDrawable);
    paramInt = getPaddingTop();
    this.e = new com.pocket.i.a.b(getContext());
    this.e.a(localTypedArray.getDimensionPixelSize(0, 0), localTypedArray.getDimensionPixelSize(1, 0), localTypedArray.getDimensionPixelSize(2, 0), localTypedArray.getDimensionPixelSize(3, 0), localTypedArray.getDimensionPixelSize(4, 0), localTypedArray.getDimensionPixelSize(5, 0));
    setBackgroundDrawable(this.e);
    z.a(this, paramInt);
    localTypedArray.recycle();
  }
  
  public CharSequence a(int paramInt)
  {
    return this.d.b(paramInt);
  }
  
  public void a(TextWatcher paramTextWatcher)
  {
    this.d.a(paramTextWatcher);
  }
  
  public void a(a parama)
  {
    this.d.a(parama);
  }
  
  public void a(i parami)
  {
    this.d.a(parami);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.d.b(paramCharSequence);
  }
  
  public void a(String paramString)
  {
    this.d.c(paramString);
  }
  
  public void b()
  {
    this.d.f();
  }
  
  public boolean c()
  {
    return this.d.g();
  }
  
  public void d()
  {
    this.d.a();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    invalidate();
  }
  
  public void e()
  {
    this.d.h();
  }
  
  public boolean f()
  {
    return this.d.c();
  }
  
  public void g()
  {
    this.d.d();
  }
  
  public int getChipCount()
  {
    return this.d.getChipCount();
  }
  
  public CharSequence getText()
  {
    return this.d.b();
  }
  
  public void h()
  {
    this.d.e();
  }
  
  public void i()
  {
    this.d.i();
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 3);
    if (this.f) {
      mergeDrawableStates(arrayOfInt, c);
    }
    if ((this.d != null) && (this.d.g())) {
      mergeDrawableStates(arrayOfInt, b);
    }
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.i != null) {
      z.a(paramMotionEvent, this.i);
    }
    for (;;)
    {
      return true;
      z.a(paramMotionEvent, this.d);
    }
  }
  
  public void setAdapter(j paramj)
  {
    this.d.setAdapter(paramj);
  }
  
  public void setClearingEnabled(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.g.a();
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    this.d.a(paramCharSequence);
  }
  
  protected void setIsInputValid(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.f = paramBoolean;
      return;
    }
  }
  
  public void setMimicChipAdapterStyleEnabled(boolean paramBoolean)
  {
    this.d.b(paramBoolean);
  }
  
  public void setOnChipsChangedListener(b paramb)
  {
    this.d.a(paramb);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    throw new UnsupportedOperationException("setOnClickListener() is not allowed with this class.");
  }
  
  public void setOnInputDoneListener(c paramc)
  {
    this.d.a(paramc);
  }
  
  public void setOnInputFocusChangedListener(d paramd)
  {
    this.d.a(paramd);
  }
  
  public void setText(String paramString)
  {
    this.d.a(paramString);
  }
  
  public void setValidator(x paramx)
  {
    this.d.a(paramx);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/chip/ChipEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */