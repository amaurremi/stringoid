package com.google.android.gms.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.C;

public final class e
  extends ViewGroup
{
  private final C a = new C(this);
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a()
  {
    this.a.a();
  }
  
  public final void a(a parama)
  {
    this.a.a(parama);
  }
  
  public final void a(b paramb)
  {
    this.a.a(paramb.a());
  }
  
  public final void a(d paramd)
  {
    this.a.a(new d[] { paramd });
  }
  
  public final void a(String paramString)
  {
    this.a.a(paramString);
  }
  
  public final void b()
  {
    this.a.c();
  }
  
  public final void c()
  {
    this.a.d();
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = getChildAt(0);
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      int i = localView.getMeasuredWidth();
      int j = localView.getMeasuredHeight();
      paramInt1 = (paramInt3 - paramInt1 - i) / 2;
      paramInt2 = (paramInt4 - paramInt2 - j) / 2;
      localView.layout(paramInt1, paramInt2, i + paramInt1, j + paramInt2);
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    Object localObject = getChildAt(0);
    d locald = this.a.b();
    int j;
    if ((localObject != null) && (((View)localObject).getVisibility() != 8))
    {
      measureChild((View)localObject, paramInt1, paramInt2);
      j = ((View)localObject).getMeasuredWidth();
      i = ((View)localObject).getMeasuredHeight();
    }
    for (;;)
    {
      j = Math.max(j, getSuggestedMinimumWidth());
      i = Math.max(i, getSuggestedMinimumHeight());
      setMeasuredDimension(View.resolveSize(j, paramInt1), View.resolveSize(i, paramInt2));
      return;
      if (locald != null)
      {
        localObject = getContext();
        j = locald.b((Context)localObject);
        i = locald.a((Context)localObject);
      }
      else
      {
        j = 0;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/ads/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */