package com.mocoplex.adlib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import java.util.Date;

public class AdlibAdViewContainer
  extends FrameLayout
{
  public String a = "";
  protected long b = -1L;
  private SubAdlibAdViewCore c;
  private String d = "-100";
  private SubAdlibAdViewMain e;
  private SubAdlibAdViewCrossBanner f;
  private boolean g = false;
  
  public AdlibAdViewContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AdlibAdViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (AdlibConfig.getInstance().c("smart").equals("")) {}
    for (this.g = false; this.g; this.g = true)
    {
      this.f = new SubAdlibAdViewCrossBanner(getContext());
      paramContext = e.a().e();
      if (AdlibConfig.getInstance().g(paramContext)) {
        this.f.a(paramContext);
      }
      addView(this.f);
      return;
    }
    this.e = new SubAdlibAdViewMain(getContext(), true);
    addView(this.e);
  }
  
  public final void a()
  {
    if (this.c != null) {
      this.c.clearAdView();
    }
    removeAllViews();
    if (this.e != null)
    {
      this.e.onPause();
      this.e.onDestroy();
      this.e = null;
    }
    if (this.f != null)
    {
      this.f.onPause();
      this.f.onDestroy();
      this.f = null;
    }
    this.c = null;
    this.g = false;
  }
  
  public final void a(SubAdlibAdViewCore paramSubAdlibAdViewCore, String paramString)
  {
    if (this.d.equals(paramString)) {
      return;
    }
    this.d = paramString;
    if (!paramSubAdlibAdViewCore.b)
    {
      addView(paramSubAdlibAdViewCore);
      paramSubAdlibAdViewCore.b = true;
    }
    paramSubAdlibAdViewCore.setVisibility(0);
    paramString = this.c;
    if (this.e != null)
    {
      this.e.setVisibility(8);
      this.e.onPause();
      this.e.onDestroy();
      this.e = null;
    }
    if (this.f != null)
    {
      this.f.setVisibility(8);
      this.f.onPause();
      this.f.onDestroy();
      this.f = null;
    }
    if (paramString != null)
    {
      paramString.setVisibility(8);
      paramString.clearAdView();
    }
    this.c = paramSubAdlibAdViewCore;
  }
  
  public void onCreate() {}
  
  public void onDestroy() {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      paramMotionEvent = new Date();
      if (this.b + 5000L <= paramMotionEvent.getTime()) {}
    }
    else
    {
      return false;
    }
    this.b = paramMotionEvent.getTime();
    f.a(getContext()).b(Integer.parseInt(this.d));
    f.a(getContext()).c(this.a);
    return false;
  }
  
  public void onPause() {}
  
  public void onResume() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/AdlibAdViewContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */