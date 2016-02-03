package com.google.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.a;
import com.google.ads.internal.d;
import com.google.ads.internal.h;
import com.google.ads.internal.k;
import com.google.ads.util.AdUtil;
import com.google.ads.util.f;
import com.google.ads.util.i.b;
import com.google.ads.util.i.c;
import java.util.HashSet;
import java.util.Set;

public class AdView
  extends RelativeLayout
  implements Ad
{
  private static final a b = (a)a.a.b();
  protected d a;
  
  public AdView(Activity paramActivity, AdSize paramAdSize, String paramString)
  {
    super(paramActivity.getApplicationContext());
    try
    {
      a(paramActivity, paramAdSize, null);
      b(paramActivity, paramAdSize, null);
      a(paramActivity, paramAdSize, paramString);
      return;
    }
    catch (com.google.ads.internal.b paramString)
    {
      a(paramActivity, paramString.c("Could not initialize AdView"), paramAdSize, null);
      paramString.a("Could not initialize AdView");
    }
  }
  
  protected AdView(Activity paramActivity, AdSize[] paramArrayOfAdSize, String paramString)
  {
    this(paramActivity, new AdSize(0, 0), paramString);
    a(paramArrayOfAdSize);
  }
  
  public AdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public AdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet);
  }
  
  private void a(Activity paramActivity, AdSize paramAdSize, String paramString)
    throws com.google.ads.internal.b
  {
    FrameLayout localFrameLayout = new FrameLayout(paramActivity);
    localFrameLayout.setFocusable(false);
    this.a = new d(this, paramActivity, paramAdSize, paramString, localFrameLayout, false);
    setGravity(17);
    try
    {
      paramActivity = k.a(paramActivity, this.a);
      if (paramActivity != null)
      {
        paramActivity.addView(localFrameLayout, -2, -2);
        addView(paramActivity, -2, -2);
        return;
      }
      addView(localFrameLayout, -2, -2);
      return;
    }
    catch (VerifyError paramActivity)
    {
      com.google.ads.util.b.a("Gestures disabled: Not supported on this version of Android.", paramActivity);
      addView(localFrameLayout, -2, -2);
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    try
    {
      String str = b("adSize", paramContext, paramAttributeSet, true);
      localObject2 = a(str);
      if (localObject2 != null) {}
      try
      {
        if (localObject2.length != 0) {
          break label124;
        }
        throw new com.google.ads.internal.b("Attribute \"adSize\" invalid: " + str, true);
      }
      catch (com.google.ads.internal.b localb1) {}
    }
    catch (com.google.ads.internal.b localb2)
    {
      for (;;)
      {
        Object localObject3;
        Object localObject2 = null;
      }
    }
    localObject3 = localb1.c("Could not initialize AdView");
    if ((localObject2 != null) && (localObject2.length > 0)) {}
    for (localObject2 = localObject2[0];; localObject2 = AdSize.BANNER)
    {
      a(paramContext, (String)localObject3, (AdSize)localObject2, paramAttributeSet);
      localb1.a("Could not initialize AdView");
      if (isInEditMode()) {
        break;
      }
      localb1.b("Could not initialize AdView");
      return;
      label124:
      if (!a("adUnitId", paramAttributeSet)) {
        throw new com.google.ads.internal.b("Required XML attribute \"adUnitId\" missing", true);
      }
      if (isInEditMode())
      {
        a(paramContext, "Ads by Google", -1, localObject2[0], paramAttributeSet);
        return;
      }
      Object localObject1 = b("adUnitId", paramContext, paramAttributeSet, true);
      boolean bool = a("loadAdOnCreate", paramContext, paramAttributeSet, false);
      if ((paramContext instanceof Activity))
      {
        localObject3 = (Activity)paramContext;
        a((Context)localObject3, localObject2[0], paramAttributeSet);
        b((Context)localObject3, localObject2[0], paramAttributeSet);
        if (localObject2.length == 1) {
          a((Activity)localObject3, localObject2[0], (String)localObject1);
        }
        while (bool)
        {
          localObject1 = c("testDevices", paramContext, paramAttributeSet, false);
          if (((Set)localObject1).contains("TEST_EMULATOR"))
          {
            ((Set)localObject1).remove("TEST_EMULATOR");
            ((Set)localObject1).add(AdRequest.TEST_EMULATOR);
          }
          loadAd(new AdRequest().setTestDevices((Set)localObject1).setKeywords(c("keywords", paramContext, paramAttributeSet, false)));
          return;
          a((Activity)localObject3, new AdSize(0, 0), (String)localObject1);
          a((AdSize[])localObject2);
        }
        break;
      }
      throw new com.google.ads.internal.b("AdView was initialized with a Context that wasn't an Activity.", true);
    }
  }
  
  private void a(Context paramContext, String paramString, AdSize paramAdSize, AttributeSet paramAttributeSet)
  {
    com.google.ads.util.b.b(paramString);
    a(paramContext, paramString, -65536, paramAdSize, paramAttributeSet);
  }
  
  private void a(AdSize... paramVarArgs)
  {
    AdSize[] arrayOfAdSize = new AdSize[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfAdSize[i] = AdSize.createAdSize(paramVarArgs[i], getContext());
      i += 1;
    }
    this.a.i().n.a(arrayOfAdSize);
  }
  
  private boolean a(Context paramContext, AdSize paramAdSize, AttributeSet paramAttributeSet)
  {
    if (!AdUtil.c(paramContext))
    {
      a(paramContext, "You must have AdActivity declared in AndroidManifest.xml with configChanges.", paramAdSize, paramAttributeSet);
      return false;
    }
    return true;
  }
  
  private boolean a(String paramString, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
    throws com.google.ads.internal.b
  {
    String str = paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", paramString);
    paramBoolean = paramAttributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/lib/com.google.ads", paramString, paramBoolean);
    if (str != null)
    {
      paramAttributeSet = paramContext.getPackageName();
      paramContext = str;
      if (str.matches("^@([^:]+)\\:(.*)$"))
      {
        paramAttributeSet = str.replaceFirst("^@([^:]+)\\:(.*)$", "$1");
        paramContext = str.replaceFirst("^@([^:]+)\\:(.*)$", "@$2");
      }
      if (paramContext.startsWith("@bool/"))
      {
        str = paramContext.substring("@bool/".length());
        TypedValue localTypedValue = new TypedValue();
        try
        {
          getResources().getValue(paramAttributeSet + ":bool/" + str, localTypedValue, true);
          if (localTypedValue.type != 18) {
            break label201;
          }
          if (localTypedValue.data != 0) {
            return true;
          }
        }
        catch (Resources.NotFoundException paramAttributeSet)
        {
          throw new com.google.ads.internal.b("Could not find resource for " + paramString + ": " + paramContext, true, paramAttributeSet);
        }
        return false;
        label201:
        throw new com.google.ads.internal.b("Resource " + paramString + " was not a boolean: " + localTypedValue, true);
      }
    }
    return paramBoolean;
  }
  
  private boolean a(String paramString, AttributeSet paramAttributeSet)
  {
    return paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", paramString) != null;
  }
  
  private String b(String paramString, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
    throws com.google.ads.internal.b
  {
    Object localObject = paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", paramString);
    paramAttributeSet = (AttributeSet)localObject;
    String str;
    if (localObject != null)
    {
      str = paramContext.getPackageName();
      paramContext = (Context)localObject;
      if (((String)localObject).matches("^@([^:]+)\\:(.*)$"))
      {
        str = ((String)localObject).replaceFirst("^@([^:]+)\\:(.*)$", "$1");
        paramContext = ((String)localObject).replaceFirst("^@([^:]+)\\:(.*)$", "@$2");
      }
      paramAttributeSet = paramContext;
      if (paramContext.startsWith("@string/"))
      {
        paramAttributeSet = paramContext.substring("@string/".length());
        localObject = new TypedValue();
      }
    }
    try
    {
      getResources().getValue(str + ":string/" + paramAttributeSet, (TypedValue)localObject, true);
      if (((TypedValue)localObject).string != null)
      {
        paramAttributeSet = ((TypedValue)localObject).string.toString();
        if ((!paramBoolean) || (paramAttributeSet != null)) {
          return paramAttributeSet;
        }
        throw new com.google.ads.internal.b("Required XML attribute \"" + paramString + "\" missing", true);
      }
    }
    catch (Resources.NotFoundException paramAttributeSet)
    {
      throw new com.google.ads.internal.b("Could not find resource for " + paramString + ": " + paramContext, true, paramAttributeSet);
    }
    throw new com.google.ads.internal.b("Resource " + paramString + " was not a string: " + localObject, true);
    return paramAttributeSet;
  }
  
  private boolean b(Context paramContext, AdSize paramAdSize, AttributeSet paramAttributeSet)
  {
    if (!AdUtil.b(paramContext))
    {
      a(paramContext, "You must have INTERNET and ACCESS_NETWORK_STATE permissions in AndroidManifest.xml.", paramAdSize, paramAttributeSet);
      return false;
    }
    return true;
  }
  
  private Set<String> c(String paramString, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
    throws com.google.ads.internal.b
  {
    paramContext = b(paramString, paramContext, paramAttributeSet, paramBoolean);
    paramString = new HashSet();
    if (paramContext != null)
    {
      paramContext = paramContext.split(",");
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        paramAttributeSet = paramContext[i].trim();
        if (paramAttributeSet.length() != 0) {
          paramString.add(paramAttributeSet);
        }
        i += 1;
      }
    }
    return paramString;
  }
  
  void a(Context paramContext, String paramString, int paramInt, AdSize paramAdSize, AttributeSet paramAttributeSet)
  {
    AdSize localAdSize = paramAdSize;
    if (paramAdSize == null) {
      localAdSize = AdSize.BANNER;
    }
    localAdSize = AdSize.createAdSize(localAdSize, paramContext.getApplicationContext());
    if (getChildCount() == 0)
    {
      if (paramAttributeSet != null) {
        break label172;
      }
      paramAdSize = new TextView(paramContext);
      paramAdSize.setGravity(17);
      paramAdSize.setText(paramString);
      paramAdSize.setTextColor(paramInt);
      paramAdSize.setBackgroundColor(-16777216);
      if (paramAttributeSet != null) {
        break label187;
      }
      paramString = new LinearLayout(paramContext);
      label88:
      paramString.setGravity(17);
      if (paramAttributeSet != null) {
        break label201;
      }
    }
    label172:
    label187:
    label201:
    for (paramAttributeSet = new LinearLayout(paramContext);; paramAttributeSet = new LinearLayout(paramContext, paramAttributeSet))
    {
      paramAttributeSet.setGravity(17);
      paramAttributeSet.setBackgroundColor(paramInt);
      paramInt = AdUtil.a(paramContext, localAdSize.getWidth());
      int i = AdUtil.a(paramContext, localAdSize.getHeight());
      paramString.addView(paramAdSize, paramInt - 2, i - 2);
      paramAttributeSet.addView(paramString);
      addView(paramAttributeSet, paramInt, i);
      return;
      paramAdSize = new TextView(paramContext, paramAttributeSet);
      break;
      paramString = new LinearLayout(paramContext, paramAttributeSet);
      break label88;
    }
  }
  
  AdSize[] a(String paramString)
  {
    String[] arrayOfString = paramString.split(",");
    AdSize[] arrayOfAdSize = new AdSize[arrayOfString.length];
    int i = 0;
    for (;;)
    {
      if (i < arrayOfString.length)
      {
        paramString = arrayOfString[i].trim();
        if (paramString.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$"))
        {
          paramString = paramString.split("[xX]");
          paramString[0] = paramString[0].trim();
          paramString[1] = paramString[1].trim();
        }
      }
      try
      {
        int j;
        int k;
        if ("FULL_WIDTH".equals(paramString[0]))
        {
          j = -1;
          boolean bool = "AUTO_HEIGHT".equals(paramString[1]);
          if (!bool) {
            break label131;
          }
          k = -2;
          label104:
          paramString = new AdSize(j, k);
        }
        for (;;)
        {
          if (paramString != null) {
            break label249;
          }
          return null;
          j = Integer.parseInt(paramString[0]);
          break;
          label131:
          k = Integer.parseInt(paramString[1]);
          break label104;
          if ("BANNER".equals(paramString)) {
            paramString = AdSize.BANNER;
          } else if ("SMART_BANNER".equals(paramString)) {
            paramString = AdSize.SMART_BANNER;
          } else if ("IAB_MRECT".equals(paramString)) {
            paramString = AdSize.IAB_MRECT;
          } else if ("IAB_BANNER".equals(paramString)) {
            paramString = AdSize.IAB_BANNER;
          } else if ("IAB_LEADERBOARD".equals(paramString)) {
            paramString = AdSize.IAB_LEADERBOARD;
          } else if ("IAB_WIDE_SKYSCRAPER".equals(paramString)) {
            paramString = AdSize.IAB_WIDE_SKYSCRAPER;
          } else {
            paramString = null;
          }
        }
        label249:
        arrayOfAdSize[i] = paramString;
        i += 1;
      }
      catch (NumberFormatException paramString) {}
    }
    return arrayOfAdSize;
    return null;
  }
  
  public void destroy()
  {
    this.a.b();
  }
  
  public boolean isReady()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.s();
  }
  
  public boolean isRefreshing()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.t();
  }
  
  public void loadAd(AdRequest paramAdRequest)
  {
    if (this.a != null)
    {
      if (isRefreshing()) {
        this.a.f();
      }
      this.a.a(paramAdRequest);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!isInEditMode())
    {
      AdWebView localAdWebView = this.a.l();
      if (localAdWebView != null) {
        localAdWebView.setVisibility(0);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (isInEditMode()) {}
    while ((!((h)this.a.i().g.a()).b()) || (paramInt == 0) || (this.a.i().l.a() == null) || (this.a.i().e.a() == null)) {
      return;
    }
    if ((AdActivity.isShowing()) && (!AdActivity.leftApplication()))
    {
      b.a((WebView)this.a.i().e.a(), "onopeninapp", null);
      return;
    }
    b.a((WebView)this.a.i().e.a(), "onleaveapp", null);
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.a.i().o.a(paramAdListener);
  }
  
  protected void setAppEventListener(AppEventListener paramAppEventListener)
  {
    this.a.i().p.a(paramAppEventListener);
  }
  
  protected void setSupportedAdSizes(AdSize... paramVarArgs)
  {
    if (this.a.i().n.a() == null)
    {
      com.google.ads.util.b.e("Warning: Tried to set supported ad sizes on a single-size AdView. AdSizes ignored. To create a multi-sized AdView, use an AdView constructor that takes in an AdSize[] array.");
      return;
    }
    a(paramVarArgs);
  }
  
  protected void setSwipeableEventListener(SwipeableAdListener paramSwipeableAdListener)
  {
    this.a.i().q.a(paramSwipeableAdListener);
  }
  
  public void stopLoading()
  {
    if (this.a != null) {
      this.a.C();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/google/ads/AdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */