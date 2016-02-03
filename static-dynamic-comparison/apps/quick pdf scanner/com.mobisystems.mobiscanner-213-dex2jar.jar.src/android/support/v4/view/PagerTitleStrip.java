package android.support.v4.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class PagerTitleStrip
  extends ViewGroup
  implements ViewPager.a
{
  private static final int[] ATTRS = { 16842804, 16842901, 16842904, 16842927 };
  private static final int[] bv = { 16843660 };
  private static final b by = new c();
  ViewPager bk;
  TextView bl;
  TextView bm;
  TextView bn;
  private int bo = -1;
  private float bp = -1.0F;
  private int bq;
  private boolean br;
  private boolean bs;
  private final a bt = new a(null);
  private WeakReference<l> bu;
  private int bw;
  int bx;
  private int mGravity;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      by = new d();
      return;
    }
  }
  
  public PagerTitleStrip(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PagerTitleStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TextView localTextView = new TextView(paramContext);
    this.bl = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.bm = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.bn = localTextView;
    addView(localTextView);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
    int i = paramAttributeSet.getResourceId(0, 0);
    if (i != 0)
    {
      this.bl.setTextAppearance(paramContext, i);
      this.bm.setTextAppearance(paramContext, i);
      this.bn.setTextAppearance(paramContext, i);
    }
    int j = paramAttributeSet.getDimensionPixelSize(1, 0);
    if (j != 0) {
      setTextSize(0, j);
    }
    if (paramAttributeSet.hasValue(2))
    {
      j = paramAttributeSet.getColor(2, 0);
      this.bl.setTextColor(j);
      this.bm.setTextColor(j);
      this.bn.setTextColor(j);
    }
    this.mGravity = paramAttributeSet.getInteger(3, 80);
    paramAttributeSet.recycle();
    this.bx = this.bm.getTextColors().getDefaultColor();
    a(0.6F);
    this.bl.setEllipsize(TextUtils.TruncateAt.END);
    this.bm.setEllipsize(TextUtils.TruncateAt.END);
    this.bn.setEllipsize(TextUtils.TruncateAt.END);
    if (i != 0)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(i, bv);
      bool = paramAttributeSet.getBoolean(0, false);
      paramAttributeSet.recycle();
    }
    if (bool)
    {
      a(this.bl);
      a(this.bm);
      a(this.bn);
    }
    for (;;)
    {
      this.bq = ((int)(paramContext.getResources().getDisplayMetrics().density * 16.0F));
      return;
      this.bl.setSingleLine();
      this.bm.setSingleLine();
      this.bn.setSingleLine();
    }
  }
  
  private static void a(TextView paramTextView)
  {
    by.a(paramTextView);
  }
  
  public void a(float paramFloat)
  {
    this.bw = ((int)(255.0F * paramFloat) & 0xFF);
    int i = this.bw << 24 | this.bx & 0xFFFFFF;
    this.bl.setTextColor(i);
    this.bn.setTextColor(i);
  }
  
  void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    int m;
    int i4;
    int k;
    int i3;
    int n;
    int i;
    int i2;
    int i1;
    int j;
    int i5;
    int i7;
    int i6;
    int i8;
    if (paramInt != this.bo)
    {
      a(paramInt, this.bk.D());
      this.bs = true;
      m = this.bl.getMeasuredWidth();
      i4 = this.bm.getMeasuredWidth();
      k = this.bn.getMeasuredWidth();
      i3 = i4 / 2;
      n = getWidth();
      i = getHeight();
      i2 = getPaddingLeft();
      i1 = getPaddingRight();
      paramInt = getPaddingTop();
      j = getPaddingBottom();
      i5 = i1 + i3;
      float f2 = 0.5F + paramFloat;
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = f2 - 1.0F;
      }
      i3 = n - i5 - (int)(f1 * (n - (i2 + i3) - i5)) - i4 / 2;
      i4 = i3 + i4;
      i7 = this.bl.getBaseline();
      i6 = this.bm.getBaseline();
      i5 = this.bn.getBaseline();
      i8 = Math.max(Math.max(i7, i6), i5);
      i7 = i8 - i7;
      i6 = i8 - i6;
      i5 = i8 - i5;
      i8 = this.bl.getMeasuredHeight();
      int i9 = this.bm.getMeasuredHeight();
      int i10 = this.bn.getMeasuredHeight();
      i8 = Math.max(Math.max(i8 + i7, i9 + i6), i10 + i5);
      switch (this.mGravity & 0x70)
      {
      default: 
        j = paramInt + i7;
        i = i6 + paramInt;
        paramInt += i5;
      }
    }
    for (;;)
    {
      this.bm.layout(i3, i, i4, this.bm.getMeasuredHeight() + i);
      i = Math.min(i2, i3 - this.bq - m);
      this.bl.layout(i, j, m + i, this.bl.getMeasuredHeight() + j);
      i = Math.max(n - i1 - k, this.bq + i4);
      this.bn.layout(i, paramInt, i + k, this.bn.getMeasuredHeight() + paramInt);
      this.bp = paramFloat;
      this.bs = false;
      return;
      if ((paramBoolean) || (paramFloat != this.bp)) {
        break;
      }
      return;
      paramInt = (i - paramInt - j - i8) / 2;
      j = paramInt + i7;
      i = i6 + paramInt;
      paramInt += i5;
      continue;
      paramInt = i - j - i8;
      j = paramInt + i7;
      i = i6 + paramInt;
      paramInt += i5;
    }
  }
  
  void a(int paramInt, l paraml)
  {
    Object localObject2 = null;
    int i;
    if (paraml != null)
    {
      i = paraml.getCount();
      this.br = true;
      if ((paramInt < 1) || (paraml == null)) {
        break label250;
      }
    }
    label250:
    for (Object localObject1 = paraml.getPageTitle(paramInt - 1);; localObject1 = null)
    {
      this.bl.setText((CharSequence)localObject1);
      TextView localTextView = this.bm;
      if ((paraml != null) && (paramInt < i)) {}
      for (localObject1 = paraml.getPageTitle(paramInt);; localObject1 = null)
      {
        localTextView.setText((CharSequence)localObject1);
        localObject1 = localObject2;
        if (paramInt + 1 < i)
        {
          localObject1 = localObject2;
          if (paraml != null) {
            localObject1 = paraml.getPageTitle(paramInt + 1);
          }
        }
        this.bn.setText((CharSequence)localObject1);
        int m = getWidth();
        int n = getPaddingLeft();
        int i1 = getPaddingRight();
        i = getHeight();
        int j = getPaddingTop();
        int k = getPaddingBottom();
        m = View.MeasureSpec.makeMeasureSpec((int)((m - n - i1) * 0.8F), Integer.MIN_VALUE);
        i = View.MeasureSpec.makeMeasureSpec(i - j - k, Integer.MIN_VALUE);
        this.bl.measure(m, i);
        this.bm.measure(m, i);
        this.bn.measure(m, i);
        this.bo = paramInt;
        if (!this.bs) {
          a(paramInt, this.bp, false);
        }
        this.br = false;
        return;
        i = 0;
        break;
      }
    }
  }
  
  void a(l paraml1, l paraml2)
  {
    if (paraml1 != null)
    {
      paraml1.unregisterDataSetObserver(this.bt);
      this.bu = null;
    }
    if (paraml2 != null)
    {
      paraml2.registerDataSetObserver(this.bt);
      this.bu = new WeakReference(paraml2);
    }
    if (this.bk != null)
    {
      this.bo = -1;
      this.bp = -1.0F;
      a(this.bk.F(), paraml2);
      requestLayout();
    }
  }
  
  public void f(int paramInt)
  {
    this.bq = paramInt;
    requestLayout();
  }
  
  int getMinHeight()
  {
    int i = 0;
    Drawable localDrawable = getBackground();
    if (localDrawable != null) {
      i = localDrawable.getIntrinsicHeight();
    }
    return i;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = getParent();
    if (!(localObject instanceof ViewPager)) {
      throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }
    localObject = (ViewPager)localObject;
    l locall = ((ViewPager)localObject).D();
    ((ViewPager)localObject).a(this.bt);
    ((ViewPager)localObject).a(this.bt);
    this.bk = ((ViewPager)localObject);
    if (this.bu != null) {}
    for (localObject = (l)this.bu.get();; localObject = null)
    {
      a((l)localObject, locall);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.bk != null)
    {
      a(this.bk.D(), null);
      this.bk.a(null);
      this.bk.a(null);
      this.bk = null;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = 0.0F;
    if (this.bk != null)
    {
      if (this.bp >= 0.0F) {
        f = this.bp;
      }
      a(this.bo, f, true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (j != 1073741824) {
      throw new IllegalStateException("Must measure with an exact width");
    }
    j = getMinHeight();
    int k = getPaddingTop() + getPaddingBottom();
    int m = View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * 0.8F), Integer.MIN_VALUE);
    int n = View.MeasureSpec.makeMeasureSpec(paramInt2 - k, Integer.MIN_VALUE);
    this.bl.measure(m, n);
    this.bm.measure(m, n);
    this.bn.measure(m, n);
    if (i == 1073741824)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
    }
    setMeasuredDimension(paramInt1, Math.max(j, this.bm.getMeasuredHeight() + k));
  }
  
  public void requestLayout()
  {
    if (!this.br) {
      super.requestLayout();
    }
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    this.bl.setTextSize(paramInt, paramFloat);
    this.bm.setTextSize(paramInt, paramFloat);
    this.bn.setTextSize(paramInt, paramFloat);
  }
  
  public int z()
  {
    return this.bq;
  }
  
  private class a
    extends DataSetObserver
    implements ViewPager.e, ViewPager.f
  {
    private int bz;
    
    private a() {}
    
    public void a(int paramInt1, float paramFloat, int paramInt2)
    {
      paramInt2 = paramInt1;
      if (paramFloat > 0.5F) {
        paramInt2 = paramInt1 + 1;
      }
      PagerTitleStrip.this.a(paramInt2, paramFloat, false);
    }
    
    public void b(l paraml1, l paraml2)
    {
      PagerTitleStrip.this.a(paraml1, paraml2);
    }
    
    public void g(int paramInt)
    {
      float f = 0.0F;
      if (this.bz == 0)
      {
        PagerTitleStrip.this.a(PagerTitleStrip.this.bk.F(), PagerTitleStrip.this.bk.D());
        if (PagerTitleStrip.a(PagerTitleStrip.this) >= 0.0F) {
          f = PagerTitleStrip.a(PagerTitleStrip.this);
        }
        PagerTitleStrip.this.a(PagerTitleStrip.this.bk.F(), f, true);
      }
    }
    
    public void h(int paramInt)
    {
      this.bz = paramInt;
    }
    
    public void onChanged()
    {
      float f = 0.0F;
      PagerTitleStrip.this.a(PagerTitleStrip.this.bk.F(), PagerTitleStrip.this.bk.D());
      if (PagerTitleStrip.a(PagerTitleStrip.this) >= 0.0F) {
        f = PagerTitleStrip.a(PagerTitleStrip.this);
      }
      PagerTitleStrip.this.a(PagerTitleStrip.this.bk.F(), f, true);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(TextView paramTextView);
  }
  
  static class c
    implements PagerTitleStrip.b
  {
    public void a(TextView paramTextView)
    {
      paramTextView.setSingleLine();
    }
  }
  
  static class d
    implements PagerTitleStrip.b
  {
    public void a(TextView paramTextView)
    {
      m.a(paramTextView);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/PagerTitleStrip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */