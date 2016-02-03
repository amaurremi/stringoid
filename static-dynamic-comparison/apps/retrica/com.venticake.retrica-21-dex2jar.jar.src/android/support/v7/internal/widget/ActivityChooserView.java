package android.support.v7.internal.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v7.b.e;
import android.support.v7.b.f;
import android.support.v7.b.h;
import android.support.v7.b.i;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;

public class ActivityChooserView
  extends ViewGroup
{
  android.support.v4.view.j a;
  private final j b;
  private final k c;
  private final LinearLayout d;
  private final Drawable e;
  private final FrameLayout f;
  private final ImageView g;
  private final FrameLayout h;
  private final ImageView i;
  private final int j;
  private final DataSetObserver k = new DataSetObserver()
  {
    public void onChanged()
    {
      super.onChanged();
      ActivityChooserView.a(ActivityChooserView.this).notifyDataSetChanged();
    }
    
    public void onInvalidated()
    {
      super.onInvalidated();
      ActivityChooserView.a(ActivityChooserView.this).notifyDataSetInvalidated();
    }
  };
  private final ViewTreeObserver.OnGlobalLayoutListener l = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public void onGlobalLayout()
    {
      if (ActivityChooserView.this.c())
      {
        if (ActivityChooserView.this.isShown()) {
          break label31;
        }
        ActivityChooserView.b(ActivityChooserView.this).d();
      }
      label31:
      do
      {
        return;
        ActivityChooserView.b(ActivityChooserView.this).c();
      } while (ActivityChooserView.this.a == null);
      ActivityChooserView.this.a.a(true);
    }
  };
  private ListPopupWindow m;
  private PopupWindow.OnDismissListener n;
  private boolean o;
  private int p = 4;
  private boolean q;
  private int r;
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, android.support.v7.b.k.ActivityChooserView, paramInt, 0);
    this.p = paramAttributeSet.getInt(0, 4);
    Drawable localDrawable = paramAttributeSet.getDrawable(1);
    paramAttributeSet.recycle();
    LayoutInflater.from(getContext()).inflate(h.abc_activity_chooser_view, this, true);
    this.c = new k(this, null);
    this.d = ((LinearLayout)findViewById(f.activity_chooser_view_content));
    this.e = this.d.getBackground();
    this.h = ((FrameLayout)findViewById(f.default_activity_button));
    this.h.setOnClickListener(this.c);
    this.h.setOnLongClickListener(this.c);
    this.i = ((ImageView)this.h.findViewById(f.image));
    this.f = ((FrameLayout)findViewById(f.expand_activities_button));
    this.f.setOnClickListener(this.c);
    this.g = ((ImageView)this.f.findViewById(f.image));
    this.g.setImageDrawable(localDrawable);
    this.b = new j(this, null);
    this.b.registerDataSetObserver(new DataSetObserver()
    {
      public void onChanged()
      {
        super.onChanged();
        ActivityChooserView.c(ActivityChooserView.this);
      }
    });
    paramContext = paramContext.getResources();
    this.j = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(e.abc_config_prefDialogWidth));
  }
  
  private void a(int paramInt)
  {
    if (this.b.e() == null) {
      throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }
    getViewTreeObserver().addOnGlobalLayoutListener(this.l);
    boolean bool;
    int i1;
    label59:
    label90:
    ListPopupWindow localListPopupWindow;
    if (this.h.getVisibility() == 0)
    {
      bool = true;
      int i2 = this.b.c();
      if (!bool) {
        break label190;
      }
      i1 = 1;
      if ((paramInt == Integer.MAX_VALUE) || (i2 <= i1 + paramInt)) {
        break label195;
      }
      this.b.a(true);
      this.b.a(paramInt - 1);
      localListPopupWindow = getListPopupWindow();
      if (!localListPopupWindow.f())
      {
        if ((!this.o) && (bool)) {
          break label214;
        }
        this.b.a(true, bool);
      }
    }
    for (;;)
    {
      localListPopupWindow.e(Math.min(this.b.a(), this.j));
      localListPopupWindow.c();
      if (this.a != null) {
        this.a.a(true);
      }
      localListPopupWindow.h().setContentDescription(getContext().getString(i.abc_activitychooserview_choose_application));
      return;
      bool = false;
      break;
      label190:
      i1 = 0;
      break label59;
      label195:
      this.b.a(false);
      this.b.a(paramInt);
      break label90;
      label214:
      this.b.a(false, false);
    }
  }
  
  private void d()
  {
    if (this.b.getCount() > 0)
    {
      this.f.setEnabled(true);
      int i1 = this.b.c();
      int i2 = this.b.d();
      if ((i1 != 1) && ((i1 <= 1) || (i2 <= 0))) {
        break label161;
      }
      this.h.setVisibility(0);
      Object localObject = this.b.b();
      PackageManager localPackageManager = getContext().getPackageManager();
      this.i.setImageDrawable(((ResolveInfo)localObject).loadIcon(localPackageManager));
      if (this.r != 0)
      {
        localObject = ((ResolveInfo)localObject).loadLabel(localPackageManager);
        localObject = getContext().getString(this.r, new Object[] { localObject });
        this.h.setContentDescription((CharSequence)localObject);
      }
    }
    for (;;)
    {
      if (this.h.getVisibility() != 0) {
        break label173;
      }
      this.d.setBackgroundDrawable(this.e);
      return;
      this.f.setEnabled(false);
      break;
      label161:
      this.h.setVisibility(8);
    }
    label173:
    this.d.setBackgroundDrawable(null);
  }
  
  private ListPopupWindow getListPopupWindow()
  {
    if (this.m == null)
    {
      this.m = new ListPopupWindow(getContext());
      this.m.a(this.b);
      this.m.a(this);
      this.m.a(true);
      this.m.a(this.c);
      this.m.a(this.c);
    }
    return this.m;
  }
  
  public boolean a()
  {
    if ((c()) || (!this.q)) {
      return false;
    }
    this.o = false;
    a(this.p);
    return true;
  }
  
  public boolean b()
  {
    if (c())
    {
      getListPopupWindow().d();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this.l);
      }
    }
    return true;
  }
  
  public boolean c()
  {
    return getListPopupWindow().f();
  }
  
  public d getDataModel()
  {
    return this.b.e();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    d locald = this.b.e();
    if (locald != null) {
      locald.registerObserver(this.k);
    }
    this.q = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.b.e();
    if (localObject != null) {
      ((d)localObject).unregisterObserver(this.k);
    }
    localObject = getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this.l);
    }
    if (c()) {
      b();
    }
    this.q = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.d.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!c()) {
      b();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    LinearLayout localLinearLayout = this.d;
    int i1 = paramInt2;
    if (this.h.getVisibility() != 0) {
      i1 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localLinearLayout, paramInt1, i1);
    setMeasuredDimension(localLinearLayout.getMeasuredWidth(), localLinearLayout.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(d paramd)
  {
    this.b.a(paramd);
    if (c())
    {
      b();
      a();
    }
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    String str = getContext().getString(paramInt);
    this.g.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    this.g.setImageDrawable(paramDrawable);
  }
  
  public void setInitialActivityCount(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.n = paramOnDismissListener;
  }
  
  public void setProvider(android.support.v4.view.j paramj)
  {
    this.a = paramj;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/ActivityChooserView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */