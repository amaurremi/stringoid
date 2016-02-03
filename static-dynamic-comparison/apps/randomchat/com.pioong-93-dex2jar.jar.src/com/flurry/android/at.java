package com.flurry.android;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class at
  extends bf
{
  private static final Map<Class<? extends ViewGroup>, ck> bO;
  private static final String d = at.class.getSimpleName();
  private final p bP;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(LinearLayout.class, new cf());
    localHashMap.put(AbsoluteLayout.class, new bl());
    localHashMap.put(FrameLayout.class, new ap());
    localHashMap.put(RelativeLayout.class, new ad());
    bO = Collections.unmodifiableMap(localHashMap);
  }
  
  public at(p paramp, AdUnit paramAdUnit)
  {
    super(paramAdUnit);
    this.bP = paramp;
  }
  
  public final void a(Context paramContext, ViewGroup paramViewGroup)
  {
    new StringBuilder().append("render(").append(paramContext).append(", ").append(paramViewGroup).append(")").toString();
    if ((this.bP == null) || (paramContext == null) || (paramViewGroup == null))
    {
      new StringBuilder().append("failed to render banner ad for bannerView = ").append(this.bP).append(" for context = ").append(paramContext).append(" for viewGroup = ").append(paramViewGroup).toString();
      return;
    }
    Object localObject = FlurryAds.getInstance();
    ac localac = ((FlurryAds)localObject).cL.a((FlurryAds)localObject, paramContext, paramViewGroup, Y());
    if (localac == null)
    {
      new StringBuilder().append("failed to render banner ad for holder = ").append(localac).append(" for adSpaceName = ").append(Y()).toString();
      return;
    }
    localObject = (ViewGroup)localac.getParent();
    if (localObject != null) {
      ((ViewGroup)localObject).removeView(localac);
    }
    localac.stop();
    localac.removeAllViews();
    localObject = (ViewGroup)this.bP.getParent();
    if (localObject != null) {
      ((ViewGroup)localObject).removeView(this.bP);
    }
    localac.addView(this.bP, new RelativeLayout.LayoutParams(-1, -1));
    this.bP.initLayout(paramContext);
    int i;
    if ((E() == null) || (E().getAdFrames().size() < 1))
    {
      paramContext = null;
      if (paramContext != null)
      {
        localac.setLayoutParams(paramContext);
        new StringBuilder().append("banner ad holder layout params = ").append(paramContext.getClass().getName()).append(" {width = ").append(paramContext.width).append(", height = ").append(paramContext.height).append("} for banner ad with adSpaceName = ").append(Y()).toString();
      }
      i = paramViewGroup.getChildCount();
      if ((E() != null) && (E().getAdFrames().size() >= 1)) {
        break label504;
      }
    }
    for (;;)
    {
      paramViewGroup.addView(localac, i);
      return;
      localObject = ((AdFrame)E().getAdFrames().get(0)).getAdSpaceLayout();
      if (localObject == null)
      {
        paramContext = null;
        break;
      }
      ck localck = (ck)bO.get(paramViewGroup.getClass());
      if (localck == null)
      {
        new StringBuilder().append("Ad space layout and alignment from the server is being ignored for ViewGroup subclass ").append(paramViewGroup.getClass().getSimpleName()).toString();
        paramContext = null;
        break;
      }
      localObject = localck.a(paramContext, (AdSpaceLayout)localObject);
      paramContext = (Context)localObject;
      if (localObject != null) {
        break;
      }
      new StringBuilder().append("Ad space layout and alignment from the server is being ignored for ViewGroup subclass ").append(paramViewGroup.getClass().getSimpleName()).toString();
      paramContext = (Context)localObject;
      break;
      label504:
      paramContext = ((AdFrame)E().getAdFrames().get(0)).getAdSpaceLayout();
      if (paramContext != null)
      {
        paramContext = paramContext.getAlignment().toString().split("-");
        if ((paramContext.length == 2) && ("t".equals(paramContext[0]))) {
          i = 0;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */