package com.flurry.android.monolithic.sdk.impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v6.AdSpaceLayout;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class af
  extends cl
{
  private static final String a = af.class.getSimpleName();
  private static final Map<Class<? extends ViewGroup>, aj> b = d();
  private final ac c;
  
  public af(ac paramac, AdUnit paramAdUnit)
  {
    super(paramAdUnit);
    this.c = paramac;
  }
  
  private int a(ViewGroup paramViewGroup)
  {
    int i = paramViewGroup.getChildCount();
    if ((b() == null) || (b().d().size() < 1)) {
      return i;
    }
    paramViewGroup = ((AdFrame)b().d().get(0)).e();
    if (paramViewGroup != null)
    {
      paramViewGroup = paramViewGroup.f().toString().split("-");
      if ((paramViewGroup.length == 2) && ("t".equals(paramViewGroup[0]))) {
        return 0;
      }
    }
    return i;
  }
  
  private ViewGroup.LayoutParams a(ViewGroup paramViewGroup, an paraman)
  {
    if ((b() == null) || (b().d().size() < 1)) {
      paraman = null;
    }
    Object localObject;
    do
    {
      return paraman;
      paraman = ((AdFrame)b().d().get(0)).e();
      if (paraman == null) {
        return null;
      }
      localObject = b(paramViewGroup);
      if (localObject == null)
      {
        ja.a(5, a, "Ad space layout and alignment from the server is being ignored for ViewGroup subclass " + paramViewGroup.getClass().getSimpleName());
        return null;
      }
      localObject = ((aj)localObject).a(paraman);
      paraman = (an)localObject;
    } while (localObject != null);
    ja.a(6, a, "Ad space layout and alignment from the server is being ignored for ViewGroup subclass " + paramViewGroup.getClass().getSimpleName());
    return (ViewGroup.LayoutParams)localObject;
  }
  
  private static aj b(ViewGroup paramViewGroup)
  {
    return (aj)b.get(paramViewGroup.getClass());
  }
  
  private static Map<Class<? extends ViewGroup>, aj> d()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(LinearLayout.class, new ak());
    localHashMap.put(AbsoluteLayout.class, new ah());
    localHashMap.put(FrameLayout.class, new ai());
    localHashMap.put(RelativeLayout.class, new al());
    return Collections.unmodifiableMap(localHashMap);
  }
  
  @TargetApi(8)
  public void a(Context paramContext, ViewGroup paramViewGroup)
  {
    ja.a(3, a, "render(" + paramContext + ", " + paramViewGroup + ")");
    if ((this.c == null) || (paramContext == null) || (paramViewGroup == null))
    {
      ja.a(6, a, "failed to render banner ad for bannerView = " + this.c + " for context = " + paramContext + " for viewGroup = " + paramViewGroup);
      return;
    }
    paramContext = FlurryAdModule.getInstance().a(paramContext, paramViewGroup, c());
    if (paramContext == null)
    {
      ja.a(6, a, "failed to render banner ad for holder = " + paramContext + " for adSpaceName = " + c());
      return;
    }
    Object localObject = (ViewGroup)paramContext.getParent();
    if (localObject != null) {
      ((ViewGroup)localObject).removeView(paramContext);
    }
    paramContext.b();
    paramContext.removeAllViews();
    localObject = (ViewGroup)this.c.getParent();
    if (localObject != null) {
      ((ViewGroup)localObject).removeView(this.c);
    }
    paramContext.addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
    this.c.initLayout();
    localObject = a(paramViewGroup, paramContext);
    if (localObject != null)
    {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ja.a(3, a, "banner ad holder layout params = " + localObject.getClass().getName() + " {width = " + ((ViewGroup.LayoutParams)localObject).width + ", height = " + ((ViewGroup.LayoutParams)localObject).height + "} for banner ad with adSpaceName = " + c());
    }
    paramViewGroup.addView(paramContext, a(paramViewGroup));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */