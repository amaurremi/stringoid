package com.adfonic.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.adfonic.android.api.Request;
import com.adfonic.android.ormma.ExpandProperties;
import com.adfonic.android.ormma.OrmmaBridge;
import com.adfonic.android.ormma.OrmmaView;
import com.adfonic.android.ormma.js.JsOrmmaBridge;
import com.adfonic.android.utils.HtmlFormatter;
import com.adfonic.android.utils.Log;
import com.adfonic.android.view.BaseAdfonicView;

public class AdfonicView
  extends BaseAdfonicView
  implements ViewTreeObserver.OnGlobalLayoutListener, OrmmaView
{
  private static final String ADFONIC_ORMMA_BRIDGE = "AdfonicOrmmaBridge";
  private OrmmaBridge bridge;
  private int currentOrientation = -1;
  private int defaultHeight = -1;
  private ViewGroup.LayoutParams defaultLayoutParams;
  private ViewGroup defaultParent;
  private int defaultWidth = -1;
  private int defaultX;
  private int defaultY;
  private ExpandProperties expandedProperties;
  private boolean manageExpandState = false;
  private int maxHeight;
  private int maxWidth;
  
  public AdfonicView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AdfonicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public AdfonicView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void addGlobalListener()
  {
    getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  private void changeContentArea(final int paramInt1, final int paramInt2)
  {
    if (!this.manageExpandState)
    {
      Log.v("returning as do not have to manage state");
      return;
    }
    Log.v("changeContentArea");
    ((Activity)getContext()).runOnUiThread(new Runnable()
    {
      public void run()
      {
        AdfonicView.this.changeContentAreaOnUiThread(paramInt1, paramInt2);
      }
    });
  }
  
  private void changeContentAreaOnUiThread(int paramInt1, int paramInt2)
  {
    this.defaultParent.removeView(this);
    LinearLayout.LayoutParams localLayoutParams = createLinearLayoutParams(paramInt1, paramInt2);
    LinearLayout localLinearLayout = createBackground(localLayoutParams);
    ViewGroup localViewGroup = (ViewGroup)this.defaultParent.getRootView();
    if (paramInt2 == this.maxHeight) {
      ((Activity)getContext()).getWindow().setFlags(1024, 1024);
    }
    localLinearLayout.setPadding((this.maxWidth - paramInt1) / 2, (this.maxHeight - paramInt2) / 2, 0, 0);
    localViewGroup.addView(localLinearLayout, localLayoutParams);
  }
  
  private LinearLayout createBackground(LinearLayout.LayoutParams paramLayoutParams)
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return false;
      }
    });
    localLinearLayout.addView(this, paramLayoutParams);
    return localLinearLayout;
  }
  
  private void createButton() {}
  
  private LinearLayout.LayoutParams createLinearLayoutParams(int paramInt1, int paramInt2)
  {
    return new LinearLayout.LayoutParams(paramInt1, paramInt2);
  }
  
  private void createOrmmaBridge()
  {
    this.bridge = new JsOrmmaBridge(this);
    addJavascriptInterface(this.bridge, "AdfonicOrmmaBridge");
    this.bridge.ready();
  }
  
  private void enableJavascript()
  {
    getSettings().setJavaScriptEnabled(true);
  }
  
  private Display getDisplay(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
  }
  
  private int getMeasureSpec(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i;
    if (j == 0) {
      i = getSizeToBeUsed(paramInt1, paramInt3);
    }
    do
    {
      do
      {
        do
        {
          return i;
          if (j != Integer.MIN_VALUE) {
            break;
          }
          i = paramInt1;
        } while (paramInt2 == -1);
        i = paramInt1;
      } while (paramInt2 != -2);
      return getSizeToBeUsed(paramInt1, paramInt3);
      i = paramInt1;
    } while (j != 1073741824);
    return paramInt1;
  }
  
  private float getResolutionFactor(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.densityDpi / 160;
  }
  
  private int getSizeToBeUsed(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0)
    {
      float f = paramInt2;
      paramInt1 = View.MeasureSpec.makeMeasureSpec((int)(getResolutionFactor((Activity)getContext()) * f), 1073741824);
    }
    return paramInt1;
  }
  
  private void hideCloseButton() {}
  
  private void init()
  {
    setVewViewCustomProperties();
    enableJavascript();
    addGlobalListener();
    createButton();
    showCloseButton();
    createOrmmaBridge();
  }
  
  private void isKeyboardVisible(int paramInt)
  {
    paramInt = View.MeasureSpec.getSize(paramInt);
    Rect localRect = new Rect();
    ((Activity)getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    int j = ((Activity)getContext()).getWindowManager().getDefaultDisplay().getHeight();
    if (j - i - paramInt > j / 3) {}
    for (boolean bool = true;; bool = false)
    {
      onSoftKeyboardShown(bool);
      return;
    }
  }
  
  private void resetContentAreaToDefault()
  {
    if (!this.manageExpandState)
    {
      Log.v("returning as do not have to manage state");
      return;
    }
    ((Activity)getContext()).runOnUiThread(new Runnable()
    {
      public void run()
      {
        AdfonicView.this.resetContentAreaToDefaultOnUiThread();
      }
    });
  }
  
  private void resetContentAreaToDefaultOnUiThread()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    localViewGroup.removeView(this);
    ((ViewGroup)this.defaultParent.getRootView()).removeView(localViewGroup);
    ((Activity)getContext()).getWindow().clearFlags(1024);
    this.defaultParent.addView(this, 1, this.defaultLayoutParams);
  }
  
  private void resetExpandProperties()
  {
    ExpandProperties localExpandProperties = getExpandProperties();
    localExpandProperties.setHeight(getMaxHeight());
    localExpandProperties.setWidth(getMaxWidth());
    setExpandProperties(localExpandProperties);
  }
  
  private void saveDefaultParams()
  {
    Object localObject = getDisplay(getContext());
    this.currentOrientation = ((Display)localObject).getOrientation();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Display)localObject).getMetrics(localDisplayMetrics);
    this.maxWidth = localDisplayMetrics.widthPixels;
    this.maxHeight = localDisplayMetrics.heightPixels;
    this.defaultWidth = getWidth();
    this.defaultHeight = getHeight();
    this.defaultLayoutParams = getLayoutParams();
    localObject = new int[2];
    getLocationOnScreen((int[])localObject);
    this.defaultX = localObject[0];
    this.defaultY = localObject[1];
    resetExpandProperties();
    this.defaultParent = ((ViewGroup)getParent());
  }
  
  private void setVewViewCustomProperties()
  {
    setScrollContainer(false);
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    setBackgroundColor(0);
  }
  
  private void showCloseButton() {}
  
  public void enableAdLogging(boolean paramBoolean)
  {
    Log.setAdLoggingEnabled(paramBoolean);
  }
  
  public void expand()
  {
    this.manageExpandState = true;
    ExpandProperties localExpandProperties = getExpandProperties();
    int j = localExpandProperties.getHeight();
    int k = localExpandProperties.getWidth();
    int i = j;
    if (j > this.maxHeight) {
      i = this.maxHeight;
    }
    j = k;
    if (k > this.maxWidth) {
      j = this.maxWidth;
    }
    changeContentArea(j, i);
  }
  
  public void expand(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!"undefined".equals(paramString))) {
      loadUrl(paramString);
    }
    expand();
  }
  
  public int getDefaultHeight()
  {
    return this.defaultHeight;
  }
  
  public int getDefaultWidth()
  {
    return this.defaultWidth;
  }
  
  public int getDefaultX()
  {
    return this.defaultX;
  }
  
  public int getDefaultY()
  {
    return this.defaultY;
  }
  
  public ExpandProperties getExpandProperties()
  {
    if (this.expandedProperties == null) {
      this.expandedProperties = new ExpandProperties();
    }
    return this.expandedProperties;
  }
  
  public int getMaxHeight()
  {
    return this.maxHeight;
  }
  
  public int getMaxWidth()
  {
    return this.maxWidth;
  }
  
  public String getPlacementType()
  {
    return "inline";
  }
  
  public void hide()
  {
    setVisibility(8);
  }
  
  public void injectJavaScript(String paramString)
  {
    if (paramString == null) {
      return;
    }
    try
    {
      super.loadUrl("javascript:" + paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean isViewable()
  {
    return getVisibility() == 0;
  }
  
  protected void loadAdContent(String paramString)
  {
    loadDataWithBaseURL("/", new HtmlFormatter().applyHtmlFormatting(paramString), "text/html", "utf-8", null);
    this.bridge.ready();
    resetExpandProperties();
  }
  
  public void onGlobalLayout()
  {
    int i = getResources().getConfiguration().keyboard;
    switch (getResources().getConfiguration().keyboardHidden)
    {
    }
    for (;;)
    {
      if (this.currentOrientation < 0) {
        saveDefaultParams();
      }
      i = getDisplay(getContext()).getOrientation();
      if ((this.currentOrientation >= 0) && (i != this.currentOrientation))
      {
        resetContentAreaToDefault();
        this.bridge.reset();
        saveDefaultParams();
      }
      return;
      this.bridge.onKeyboardChange(true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    isKeyboardVisible(paramInt2);
    int j = 0;
    int i = 0;
    if (getRequest() != null)
    {
      j = (int)getRequest().getAdWidth();
      i = (int)getRequest().getAdHeight();
    }
    super.onMeasure(getMeasureSpec(paramInt1, getLayoutParams().width, j), getMeasureSpec(paramInt2, getLayoutParams().height, i));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.bridge.onSizeChange(paramInt1, paramInt2);
  }
  
  public void onSoftKeyboardShown(boolean paramBoolean) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    this.defaultX = arrayOfInt[0];
    this.defaultY = arrayOfInt[1];
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void open(String paramString)
  {
    Context localContext = getContext();
    localContext.startActivity(AdfonicActivity.getOpenUrlIntent(paramString, localContext));
  }
  
  public void resize(int paramInt1, int paramInt2)
  {
    changeContentArea(paramInt1, paramInt2);
  }
  
  public void setExpandProperties(ExpandProperties paramExpandProperties)
  {
    if (paramExpandProperties.isUseCustomClose()) {
      hideCloseButton();
    }
    for (;;)
    {
      this.expandedProperties = paramExpandProperties;
      return;
      showCloseButton();
    }
  }
  
  public void setOrmmaBridge(OrmmaBridge paramOrmmaBridge)
  {
    this.bridge = paramOrmmaBridge;
  }
  
  public void showDefaultSize()
  {
    setVisibility(0);
    resetContentAreaToDefault();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/AdfonicView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */