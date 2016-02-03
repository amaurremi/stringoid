package com.ideashower.readitlater.views.toolbars;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout.LayoutParams;
import com.b.a.b;
import com.b.c.c;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.views.ResizeDetectRelativeLayout;
import com.pocket.widget.ShadowView;

public class ToolbarLayout
  extends ResizeDetectRelativeLayout
{
  private static Interpolator e = new DecelerateInterpolator();
  protected View a;
  protected View b;
  protected View c;
  private d d;
  
  public ToolbarLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ToolbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ToolbarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private static void a(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof StyledToolbar)) {
      ((StyledToolbar)paramView).setIsTopToolbar(paramBoolean);
    }
  }
  
  private boolean a(View paramView)
  {
    return (this.b != null) && (paramView == this.b);
  }
  
  public static Interpolator getInterpolator()
  {
    return e;
  }
  
  public void a() {}
  
  public void a(View paramView, int paramInt)
  {
    a(paramView, false);
    paramView.setId(2131230751);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, paramInt);
    localLayoutParams.addRule(12);
    paramView.setLayoutParams(localLayoutParams);
    if (paramView.getParent() == null) {
      addView(paramView);
    }
    this.c = paramView;
    b();
  }
  
  public void a(final View paramView, final boolean paramBoolean, int paramInt)
  {
    boolean bool1 = true;
    int j = 0;
    int i = paramInt;
    if (paramBoolean)
    {
      i = paramInt;
      if (paramView.getHeight() == 0) {
        i = 0;
      }
    }
    final boolean bool2 = a(paramView);
    paramInt = i;
    if (i == 1)
    {
      if (paramView.getVisibility() != 0) {
        break label115;
      }
      paramInt = i;
      if (bool1 == paramBoolean) {
        paramInt = 0;
      }
    }
    final Object localObject;
    if ((paramView instanceof StyledToolbar))
    {
      localObject = ((StyledToolbar)paramView).getShadowView();
      label76:
      if (paramInt != 0) {
        break label162;
      }
      if (paramBoolean)
      {
        if (com.b.c.a.a(paramView) == 0.0F) {
          break label127;
        }
        com.b.c.a.e(paramView, 0.0F);
        paramView.clearAnimation();
      }
      if (!paramBoolean) {
        break label156;
      }
      paramInt = j;
      paramView.setVisibility(paramInt);
    }
    label115:
    label127:
    label156:
    label162:
    while (paramInt == 0) {
      for (;;)
      {
        return;
        bool1 = false;
        break;
        localObject = null;
        break label76;
        if ((localObject != null) && (com.b.c.a.a((View)localObject) != 0.0F))
        {
          com.b.c.a.e((View)localObject, 0.0F);
          ((ShadowView)localObject).clearAnimation();
          continue;
          paramInt = 8;
        }
      }
    }
    if (localObject != null)
    {
      i = ((ShadowView)localObject).getHeight();
      if (!bool2) {
        break label359;
      }
      if (!paramBoolean) {
        break label347;
      }
      paramInt = 0;
      label189:
      c.a(paramView).c(paramInt).a(350L).a(e).a(new b()
      {
        public void a(com.b.a.a paramAnonymousa)
        {
          if (!paramBoolean) {
            paramView.setVisibility(8);
          }
          for (;;)
          {
            if (ToolbarLayout.a(ToolbarLayout.this) != null) {
              ToolbarLayout.a(ToolbarLayout.this).c(paramBoolean, paramView, bool2);
            }
            ToolbarLayout.this.b();
            return;
            com.b.c.a.e(paramView, 0.0F);
          }
        }
        
        public void b(com.b.a.a paramAnonymousa)
        {
          if (ToolbarLayout.a(ToolbarLayout.this) != null) {
            ToolbarLayout.a(ToolbarLayout.this).b(paramBoolean, paramView, bool2);
          }
        }
        
        public void c(com.b.a.a paramAnonymousa) {}
        
        public void d(com.b.a.a paramAnonymousa) {}
      });
      if (localObject != null)
      {
        if (!bool2) {
          break label394;
        }
        if (!paramBoolean) {
          break label387;
        }
        paramInt = paramView.getHeight();
        label245:
        c.a((View)localObject).c(paramInt).a(350L).a(e).a(new b()
        {
          public void a(com.b.a.a paramAnonymousa)
          {
            if (!paramBoolean) {
              localObject.setVisibility(8);
            }
          }
          
          public void b(com.b.a.a paramAnonymousa)
          {
            if (paramBoolean) {
              localObject.setVisibility(0);
            }
          }
          
          public void c(com.b.a.a paramAnonymousa) {}
          
          public void d(com.b.a.a paramAnonymousa) {}
        });
      }
      localObject = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
      if (!bool2) {
        break label422;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 0);
    }
    for (;;)
    {
      this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.d != null) {
        this.d.a(paramBoolean, paramView, bool2);
      }
      paramView.setVisibility(0);
      return;
      i = 0;
      break;
      label347:
      paramInt = -paramView.getHeight() - i;
      break label189;
      label359:
      if (paramBoolean)
      {
        paramInt = getHeight() - paramView.getHeight();
        break label189;
      }
      paramInt = getHeight() + i;
      break label189;
      label387:
      paramInt = -i;
      break label245;
      label394:
      if (paramBoolean)
      {
        paramInt = getHeight() - paramView.getHeight() - i;
        break label245;
      }
      paramInt = getHeight();
      break label245;
      label422:
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 0);
    }
  }
  
  public void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {}
    for (int i = 1;; i = 0)
    {
      a(paramView, paramBoolean1, i);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(this.b, paramBoolean1, paramBoolean2);
  }
  
  public void b()
  {
    if (this.a == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    if (this.b != null)
    {
      if (this.b.getId() == -1) {
        this.b.setId(2131230742);
      }
      localLayoutParams.addRule(3, this.b.getId());
    }
    if (this.c != null)
    {
      if (this.c.getId() == -1) {
        this.c.setId(2131230751);
      }
      localLayoutParams.addRule(2, this.c.getId());
    }
    this.a.setLayoutParams(localLayoutParams);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(this.c, paramBoolean1, paramBoolean2);
  }
  
  public View getBottomToolbar()
  {
    return this.c;
  }
  
  public View getContent()
  {
    return this.a;
  }
  
  public int getContentHeight()
  {
    int j = 0;
    int k = getHeight();
    if (this.b != null) {}
    for (int i = this.b.getHeight();; i = 0)
    {
      if (this.c != null) {
        j = this.c.getHeight();
      }
      return k - i - j;
    }
  }
  
  public View getTopToolbar()
  {
    return this.b;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    mergeDrawableStates(arrayOfInt, m.b(this));
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = findViewById(2131230730);
    this.b = findViewById(2131230742);
    a(this.b, true);
    this.c = findViewById(2131230751);
    a(this.c, false);
    if (getBackground() == null) {
      setBackgroundResource(2130837763);
    }
    b();
  }
  
  public void setBottomToolbar(View paramView)
  {
    a(paramView, (int)g.c().getResources().getDimension(2131296395));
  }
  
  public void setContent(View paramView)
  {
    this.a = paramView;
    if (paramView.getParent() == null) {
      addView(this.a, 0);
    }
    b();
  }
  
  public void setOnToolbarAnimateListener(d paramd)
  {
    this.d = paramd;
  }
  
  public void setTopToolbar(StyledToolbar paramStyledToolbar)
  {
    a(paramStyledToolbar, true);
    paramStyledToolbar.setId(2131230742);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)paramStyledToolbar.getResources().getDimension(2131296395));
    localLayoutParams.addRule(10);
    paramStyledToolbar.setLayoutParams(localLayoutParams);
    if (paramStyledToolbar.getParent() == null) {
      addView(paramStyledToolbar);
    }
    this.b = paramStyledToolbar;
    b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/toolbars/ToolbarLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */