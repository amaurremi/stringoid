package com.appbrain;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import cmn.a;
import com.appbrain.a.at;
import com.appbrain.a.bl;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppBrainBanner
  extends FrameLayout
{
  private bl a;
  
  public AppBrainBanner(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public AppBrainBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public AppBrainBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    a.a().a(this);
    setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    this.a = new bl(this);
    this.a.a(paramAttributeSet);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!this.a.a.get()) {
      requestAd();
    }
    while (!this.a.b.get()) {
      return;
    }
    this.a.b();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE) {
      i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 1073741824);
    }
    super.onMeasure(i, paramInt2);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.b.get())) {
      this.a.b();
    }
    super.onWindowFocusChanged(paramBoolean);
  }
  
  /* Error */
  public void requestAd()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 92	com/appbrain/AppBrainBanner:getVisibility	()I
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 44	com/appbrain/AppBrainBanner:a	Lcom/appbrain/a/bl;
    //   18: invokevirtual 94	com/appbrain/a/bl:a	()V
    //   21: goto -10 -> 11
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	this	AppBrainBanner
    //   6	2	1	i	int
    //   24	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	24	finally
    //   14	21	24	finally
  }
  
  public void setBannerListener(BannerListener paramBannerListener)
  {
    this.a.a(paramBannerListener);
  }
  
  public void setButtonTextIndex(int paramInt)
  {
    this.a.f = paramInt;
    if ((this.a.f < 0) || (this.a.f >= bl.h.length)) {
      this.a.f = 0;
    }
  }
  
  public void setColors(int paramInt)
  {
    this.a.d = paramInt;
    if ((this.a.d < 0) || (this.a.d >= at.a.length)) {
      this.a.d = 0;
    }
  }
  
  public void setDesign(int paramInt)
  {
    this.a.c = paramInt;
    if ((this.a.c < 0) || (this.a.c >= at.b.length)) {
      this.a.c = 0;
    }
  }
  
  public void setIsMediatedBanner(boolean paramBoolean, String paramString)
  {
    this.a.a(paramBoolean, paramString);
  }
  
  public void setSingleAppDesign(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void setTitleIndex(int paramInt)
  {
    this.a.e = paramInt;
    if ((this.a.e < 0) || (this.a.e >= bl.g.length)) {
      this.a.e = 0;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if ((paramInt == 0) && (!this.a.a.get())) {
      requestAd();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/AppBrainBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */