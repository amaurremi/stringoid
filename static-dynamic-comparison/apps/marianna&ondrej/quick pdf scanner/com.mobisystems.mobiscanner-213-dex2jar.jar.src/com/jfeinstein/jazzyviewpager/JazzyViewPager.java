package com.jfeinstein.jazzyviewpager;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.support.v4.view.l;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.c.a.a;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class JazzyViewPager
  extends ImageViewPager
{
  public static int alF = -1;
  private static final boolean alI;
  private boolean alC = true;
  private boolean alD = false;
  private boolean alE = false;
  private TransitionEffect alG = TransitionEffect.alX;
  private HashMap<Integer, Object> alH = new LinkedHashMap();
  private State alJ;
  private int alK;
  private View alL;
  private View alM;
  private float alN;
  private float alO;
  private float alP;
  private Camera alQ = new Camera();
  private float[] alR = new float[2];
  private Matrix mMatrix = new Matrix();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (boolean bool = true;; bool = false)
    {
      alI = bool;
      return;
    }
  }
  
  public JazzyViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public JazzyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setClipChildren(false);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.e.JazzyViewPager);
    int i = paramContext.getInt(0, 0);
    a(TransitionEffect.valueOf(getResources().getStringArray(a.a.jazzy_effects)[i]));
    setFadeEnabled(paramContext.getBoolean(1, false));
    aL(paramContext.getBoolean(2, false));
    fE(paramContext.getColor(3, -1));
    switch (1.alS[this.alG.ordinal()])
    {
    }
    for (;;)
    {
      paramContext.recycle();
      return;
      setFadeEnabled(true);
    }
  }
  
  private void Cx()
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (!(localView instanceof OutlineContainer))
      {
        removeView(localView);
        super.addView(O(localView), i);
      }
      i += 1;
    }
  }
  
  private void Cy()
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      a.i(localView, 0.0F);
      a.j(localView, 0.0F);
      a.k(localView, 0.0F);
      a.n(localView, 0.0F);
      a.o(localView, 0.0F);
      a.f(localView, 1.0F);
      a.l(localView, 1.0F);
      a.m(localView, 1.0F);
      a.g(localView, 0.0F);
      a.h(localView, 0.0F);
      i += 1;
    }
  }
  
  @TargetApi(11)
  private void Cz()
  {
    if (!alI) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getLayerType() != 0) {
          localView.setLayerType(0, null);
        }
        i += 1;
      }
    }
  }
  
  private View O(View paramView)
  {
    if ((!this.alE) || ((paramView instanceof OutlineContainer))) {
      return paramView;
    }
    OutlineContainer localOutlineContainer = new OutlineContainer(getContext());
    localOutlineContainer.setLayoutParams(generateDefaultLayoutParams());
    paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localOutlineContainer.addView(paramView);
    return localOutlineContainer;
  }
  
  private void a(View paramView1, View paramView2, float paramFloat, int paramInt)
  {
    if (this.alJ != State.alT) {
      if (paramView1 != null)
      {
        a(paramView1, true);
        this.alN = (180.0F * paramFloat);
        if (this.alN <= 90.0F) {
          break label83;
        }
        paramView1.setVisibility(4);
      }
    }
    for (;;)
    {
      if (paramView2 != null)
      {
        a(paramView2, true);
        this.alN = (-180.0F * (1.0F - paramFloat));
        if (this.alN >= -90.0F) {
          break;
        }
        paramView2.setVisibility(4);
      }
      return;
      label83:
      if (paramView1.getVisibility() == 4) {
        paramView1.setVisibility(0);
      }
      this.alO = paramInt;
      a.g(paramView1, paramView1.getMeasuredWidth() * 0.5F);
      a.h(paramView1, paramView1.getMeasuredHeight() * 0.5F);
      a.n(paramView1, this.alO);
      a.k(paramView1, this.alN);
    }
    if (paramView2.getVisibility() == 4) {
      paramView2.setVisibility(0);
    }
    this.alO = (-getWidth() - Cu() + paramInt);
    a.g(paramView2, paramView2.getMeasuredWidth() * 0.5F);
    a.h(paramView2, paramView2.getMeasuredHeight() * 0.5F);
    a.n(paramView2, this.alO);
    a.k(paramView2, this.alN);
  }
  
  private void a(View paramView1, View paramView2, float paramFloat, boolean paramBoolean)
  {
    float f2 = 90.0F;
    if (this.alJ != State.alT)
    {
      if (paramView1 != null)
      {
        a(paramView1, true);
        if (!paramBoolean) {
          break label130;
        }
        f1 = 90.0F;
        this.alN = (f1 * paramFloat);
        a.g(paramView1, paramView1.getMeasuredWidth());
        a.h(paramView1, paramView1.getMeasuredHeight() * 0.5F);
        a.k(paramView1, this.alN);
      }
      if (paramView2 != null)
      {
        a(paramView2, true);
        if (!paramBoolean) {
          break label138;
        }
      }
    }
    label130:
    label138:
    for (float f1 = f2;; f1 = -90.0F)
    {
      this.alN = (-f1 * (1.0F - paramFloat));
      a.g(paramView2, 0.0F);
      a.h(paramView2, paramView2.getMeasuredHeight() * 0.5F);
      a.k(paramView2, this.alN);
      return;
      f1 = -90.0F;
      break;
    }
  }
  
  private void a(View paramView, String paramString)
  {
    Log.v("JazzyViewPager", paramString + ": ROT (" + a.ah(paramView) + ", " + a.ai(paramView) + ", " + a.aj(paramView) + "), TRANS (" + a.am(paramView) + ", " + a.an(paramView) + "), SCALE (" + a.ak(paramView) + ", " + a.al(paramView) + "), ALPHA " + a.ag(paramView));
  }
  
  @TargetApi(11)
  private void a(View paramView, boolean paramBoolean)
  {
    if (!alI) {}
    for (;;)
    {
      return;
      if (paramBoolean) {}
      for (int i = 2; i != paramView.getLayerType(); i = 0)
      {
        paramView.setLayerType(i, null);
        return;
      }
    }
  }
  
  private void b(View paramView1, View paramView2, float paramFloat)
  {
    if (this.alJ != State.alT)
    {
      if (paramView1 != null)
      {
        a(paramView1, true);
        a.g(paramView1, paramView1.getMeasuredWidth());
        a.h(paramView1, 0.0F);
        a.l(paramView1, 1.0F - paramFloat);
      }
      if (paramView2 != null)
      {
        a(paramView2, true);
        a.g(paramView2, 0.0F);
        a.h(paramView2, 0.0F);
        a.l(paramView2, paramFloat);
      }
    }
  }
  
  private void b(View paramView1, View paramView2, float paramFloat, int paramInt)
  {
    if (this.alJ != State.alT) {
      if (paramView1 != null)
      {
        a(paramView1, true);
        this.alN = (180.0F * paramFloat);
        if (this.alN <= 90.0F) {
          break label83;
        }
        paramView1.setVisibility(4);
      }
    }
    for (;;)
    {
      if (paramView2 != null)
      {
        a(paramView2, true);
        this.alN = (-180.0F * (1.0F - paramFloat));
        if (this.alN >= -90.0F) {
          break;
        }
        paramView2.setVisibility(4);
      }
      return;
      label83:
      if (paramView1.getVisibility() == 4) {
        paramView1.setVisibility(0);
      }
      this.alO = paramInt;
      a.g(paramView1, paramView1.getMeasuredWidth() * 0.5F);
      a.h(paramView1, paramView1.getMeasuredHeight() * 0.5F);
      a.n(paramView1, this.alO);
      a.j(paramView1, this.alN);
    }
    if (paramView2.getVisibility() == 4) {
      paramView2.setVisibility(0);
    }
    this.alO = (-getWidth() - Cu() + paramInt);
    a.g(paramView2, paramView2.getMeasuredWidth() * 0.5F);
    a.h(paramView2, paramView2.getMeasuredHeight() * 0.5F);
    a.n(paramView2, this.alO);
    a.j(paramView2, this.alN);
  }
  
  private void b(View paramView1, View paramView2, float paramFloat, boolean paramBoolean)
  {
    float f;
    if (this.alJ != State.alT)
    {
      if (paramView1 != null)
      {
        a(paramView1, true);
        if (!paramBoolean) {
          break label159;
        }
        f = (1.0F - paramFloat) * 0.5F + 0.5F;
        this.alP = f;
        a.g(paramView1, paramView1.getMeasuredWidth() * 0.5F);
        a.h(paramView1, paramView1.getMeasuredHeight() * 0.5F);
        a.l(paramView1, this.alP);
        a.m(paramView1, this.alP);
      }
      if (paramView2 != null)
      {
        a(paramView2, true);
        if (!paramBoolean) {
          break label175;
        }
      }
    }
    label159:
    label175:
    for (paramFloat = 0.5F * paramFloat + 0.5F;; paramFloat = 1.5F - 0.5F * paramFloat)
    {
      this.alP = paramFloat;
      a.g(paramView2, paramView2.getMeasuredWidth() * 0.5F);
      a.h(paramView2, paramView2.getMeasuredHeight() * 0.5F);
      a.l(paramView2, this.alP);
      a.m(paramView2, this.alP);
      return;
      f = 1.5F - (1.0F - paramFloat) * 0.5F;
      break;
    }
  }
  
  private void c(View paramView1, View paramView2, float paramFloat, boolean paramBoolean)
  {
    int i;
    label49:
    float f;
    if (this.alJ != State.alT)
    {
      if (paramView1 != null)
      {
        a(paramView1, true);
        if (!paramBoolean) {
          break label251;
        }
        i = 1;
        this.alN = (i * (15.0F * paramFloat));
        if (!paramBoolean) {
          break label257;
        }
        i = -1;
        this.alO = (i * (float)(getMeasuredHeight() - getMeasuredHeight() * Math.cos(this.alN * 3.141592653589793D / 180.0D)));
        a.g(paramView1, paramView1.getMeasuredWidth() * 0.5F);
        if (!paramBoolean) {
          break label263;
        }
        f = 0.0F;
        label107:
        a.h(paramView1, f);
        a.o(paramView1, this.alO);
        a.i(paramView1, this.alN);
      }
      if (paramView2 != null)
      {
        a(paramView2, true);
        if (!paramBoolean) {
          break label273;
        }
        i = 1;
        label147:
        this.alN = (i * (-15.0F + 15.0F * paramFloat));
        if (!paramBoolean) {
          break label279;
        }
        i = -1;
        label172:
        this.alO = (i * (float)(getMeasuredHeight() - getMeasuredHeight() * Math.cos(this.alN * 3.141592653589793D / 180.0D)));
        a.g(paramView2, paramView2.getMeasuredWidth() * 0.5F);
        if (!paramBoolean) {
          break label285;
        }
      }
    }
    label251:
    label257:
    label263:
    label273:
    label279:
    label285:
    for (paramFloat = 0.0F;; paramFloat = paramView2.getMeasuredHeight())
    {
      a.h(paramView2, paramFloat);
      a.o(paramView2, this.alO);
      a.i(paramView2, this.alN);
      return;
      i = -1;
      break;
      i = 1;
      break label49;
      f = paramView1.getMeasuredHeight();
      break label107;
      i = -1;
      break label147;
      i = 1;
      break label172;
    }
  }
  
  private boolean v(float paramFloat)
  {
    return Math.abs(paramFloat) < 1.0E-4D;
  }
  
  public boolean Cw()
  {
    return this.alD;
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    State localState;
    int i;
    label54:
    label76:
    float f;
    if ((this.alJ == State.alT) && (paramFloat > 0.0F))
    {
      this.alK = F();
      if (paramInt1 == this.alK)
      {
        localState = State.alV;
        this.alJ = localState;
      }
    }
    else
    {
      if (paramInt1 != this.alK) {
        break label262;
      }
      i = 1;
      if ((this.alJ != State.alV) || (i != 0)) {
        break label268;
      }
      this.alJ = State.alU;
      if (!v(paramFloat)) {
        break label293;
      }
      f = 0.0F;
      label87:
      this.alL = fF(paramInt1);
      this.alM = fF(paramInt1 + 1);
      if (this.alD) {
        c(this.alL, this.alM, f);
      }
      if (this.alE) {
        b(this.alL, this.alM);
      }
      switch (1.alS[this.alG.ordinal()])
      {
      }
    }
    for (;;)
    {
      super.a(paramInt1, paramFloat, paramInt2);
      if (f == 0.0F)
      {
        Cz();
        this.alJ = State.alT;
      }
      return;
      localState = State.alU;
      break;
      label262:
      i = 0;
      break label54;
      label268:
      if ((this.alJ != State.alU) || (i == 0)) {
        break label76;
      }
      this.alJ = State.alV;
      break label76;
      label293:
      f = paramFloat;
      break label87;
      a(this.alL, this.alM, f);
      continue;
      a(this.alL, this.alM, f, true);
      continue;
      a(this.alL, this.alM, f, false);
      continue;
      b(this.alL, this.alM, paramFloat, paramInt2);
      continue;
      a(this.alL, this.alM, f, paramInt2);
      c(this.alL, this.alM, f, paramInt2);
      continue;
      d(this.alL, this.alM, f);
      c(this.alL, this.alM, f, paramInt2);
      continue;
      b(this.alL, this.alM, f, true);
      continue;
      b(this.alL, this.alM, f, false);
      continue;
      c(this.alL, this.alM, f, true);
      continue;
      c(this.alL, this.alM, f, false);
      continue;
      b(this.alL, this.alM, f);
      continue;
      b(this.alL, this.alM, f, true);
      c(this.alL, this.alM, f);
    }
  }
  
  protected void a(View paramView1, View paramView2, float paramFloat)
  {
    if (this.alJ != State.alT)
    {
      if (paramView1 != null)
      {
        a(paramView1, true);
        this.alN = (30.0F * paramFloat);
        this.alO = b(this.alN, paramView1.getMeasuredWidth(), paramView1.getMeasuredHeight());
        a.g(paramView1, paramView1.getMeasuredWidth() / 2);
        a.h(paramView1, paramView1.getMeasuredHeight() / 2);
        a.n(paramView1, this.alO);
        a.k(paramView1, this.alN);
        a(paramView1, "Left");
      }
      if (paramView2 != null)
      {
        a(paramView2, true);
        this.alN = (-30.0F * (1.0F - paramFloat));
        this.alO = b(this.alN, paramView2.getMeasuredWidth(), paramView2.getMeasuredHeight());
        a.g(paramView2, paramView2.getMeasuredWidth() * 0.5F);
        a.h(paramView2, paramView2.getMeasuredHeight() * 0.5F);
        a.n(paramView2, this.alO);
        a.k(paramView2, this.alN);
        a(paramView2, "Right");
      }
    }
  }
  
  public void a(TransitionEffect paramTransitionEffect)
  {
    this.alG = paramTransitionEffect;
    switch (1.alS[this.alG.ordinal()])
    {
    }
    for (;;)
    {
      reset();
      return;
      setFadeEnabled(true);
    }
  }
  
  public void aL(boolean paramBoolean)
  {
    this.alE = paramBoolean;
    Cx();
  }
  
  public void addView(View paramView)
  {
    super.addView(O(paramView));
  }
  
  public void addView(View paramView, int paramInt)
  {
    super.addView(O(paramView), paramInt);
  }
  
  public void addView(View paramView, int paramInt1, int paramInt2)
  {
    super.addView(O(paramView), paramInt1, paramInt2);
  }
  
  protected float b(float paramFloat, int paramInt1, int paramInt2)
  {
    this.mMatrix.reset();
    this.alQ.save();
    this.alQ.rotateY(Math.abs(paramFloat));
    this.alQ.getMatrix(this.mMatrix);
    this.alQ.restore();
    this.mMatrix.preTranslate(-paramInt1 * 0.5F, -paramInt2 * 0.5F);
    this.mMatrix.postTranslate(paramInt1 * 0.5F, paramInt2 * 0.5F);
    this.alR[0] = paramInt1;
    this.alR[1] = paramInt2;
    this.mMatrix.mapPoints(this.alR);
    float f1 = paramInt1;
    float f2 = this.alR[0];
    if (paramFloat > 0.0F) {}
    for (paramFloat = 1.0F;; paramFloat = -1.0F) {
      return paramFloat * (f1 - f2);
    }
  }
  
  protected void b(View paramView1, View paramView2)
  {
    if (!(paramView1 instanceof OutlineContainer)) {}
    do
    {
      do
      {
        return;
        if (this.alJ == State.alT) {
          break;
        }
        if (paramView1 != null)
        {
          a(paramView1, true);
          ((OutlineContainer)paramView1).w(1.0F);
        }
      } while (paramView2 == null);
      a(paramView2, true);
      ((OutlineContainer)paramView2).w(1.0F);
      return;
      if (paramView1 != null) {
        ((OutlineContainer)paramView1).start();
      }
    } while (paramView2 == null);
    ((OutlineContainer)paramView2).start();
  }
  
  protected void c(View paramView1, View paramView2, float paramFloat)
  {
    if (paramView1 != null) {
      a.f(paramView1, 1.0F - paramFloat);
    }
    if (paramView2 != null) {
      a.f(paramView2, paramFloat);
    }
  }
  
  protected void c(View paramView1, View paramView2, float paramFloat, int paramInt)
  {
    if (this.alJ != State.alT)
    {
      if (paramView2 != null)
      {
        a(paramView2, true);
        this.alP = (0.5F * paramFloat + 0.5F);
        this.alO = (-getWidth() - Cu() + paramInt);
        a.l(paramView2, this.alP);
        a.m(paramView2, this.alP);
        a.n(paramView2, this.alO);
      }
      if (paramView1 != null) {
        paramView1.bringToFront();
      }
    }
  }
  
  protected void d(View paramView1, View paramView2, float paramFloat)
  {
    if (paramView1 != null) {
      a.f(paramView1, 1.0F);
    }
    if (paramView2 != null) {
      a.f(paramView2, paramFloat);
    }
  }
  
  public void f(Object paramObject, int paramInt)
  {
    this.alH.put(Integer.valueOf(paramInt), paramObject);
  }
  
  public void fE(int paramInt)
  {
    alF = paramInt;
  }
  
  public View fF(int paramInt)
  {
    Object localObject = this.alH.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      return null;
    }
    l locall = D();
    paramInt = 0;
    while (paramInt < getChildCount())
    {
      View localView = getChildAt(paramInt);
      if (locall.isViewFromObject(localView, localObject)) {
        return localView;
      }
      paramInt += 1;
    }
    return null;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.alC) && (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void reset()
  {
    Cy();
    a(F(), 0.0F, 0);
  }
  
  public void setFadeEnabled(boolean paramBoolean)
  {
    this.alD = paramBoolean;
  }
  
  private static enum State
  {
    private State() {}
  }
  
  public static enum TransitionEffect
  {
    private TransitionEffect() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/jfeinstein/jazzyviewpager/JazzyViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */