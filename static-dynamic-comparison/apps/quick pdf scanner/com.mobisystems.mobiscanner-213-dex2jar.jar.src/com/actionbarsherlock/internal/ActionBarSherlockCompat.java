package com.actionbarsherlock.internal;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.ActionBarSherlock.Implementation;
import com.actionbarsherlock.ActionBarSherlock.OnActionModeFinishedListener;
import com.actionbarsherlock.ActionBarSherlock.OnActionModeStartedListener;
import com.actionbarsherlock.R.attr;
import com.actionbarsherlock.R.bool;
import com.actionbarsherlock.R.id;
import com.actionbarsherlock.R.layout;
import com.actionbarsherlock.R.styleable;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.internal.app.ActionBarImpl;
import com.actionbarsherlock.internal.view.StandaloneActionMode;
import com.actionbarsherlock.internal.view.menu.ActionMenuPresenter;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.internal.view.menu.MenuBuilder.Callback;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import com.actionbarsherlock.internal.view.menu.MenuPresenter.Callback;
import com.actionbarsherlock.internal.widget.ActionBarContainer;
import com.actionbarsherlock.internal.widget.ActionBarContextView;
import com.actionbarsherlock.internal.widget.ActionBarView;
import com.actionbarsherlock.internal.widget.IcsProgressBar;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.ActionMode.Callback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@ActionBarSherlock.Implementation(api=7)
public class ActionBarSherlockCompat
  extends ActionBarSherlock
  implements MenuItem.OnMenuItemClickListener, MenuBuilder.Callback, MenuPresenter.Callback, com.actionbarsherlock.view.Window.Callback
{
  protected static final int DEFAULT_FEATURES = 0;
  private static final String PANELS_TAG = "sherlock:Panels";
  private ActionBarImpl aActionBar;
  private ActionMode mActionMode;
  private ActionBarContextView mActionModeView;
  private IcsProgressBar mCircularProgressBar;
  private boolean mClosingActionMenu;
  private ViewGroup mContentParent;
  private ViewGroup mDecor;
  private int mFeatures = 0;
  private IcsProgressBar mHorizontalProgressBar;
  private boolean mIsDestroyed = false;
  private boolean mIsTitleReady = false;
  private MenuBuilder mMenu;
  private Bundle mMenuFrozenActionViewState;
  private boolean mMenuIsPrepared;
  private boolean mMenuRefreshContent;
  protected HashMap<android.view.MenuItem, MenuItemImpl> mNativeItemMap;
  private boolean mReserveOverflow;
  private boolean mReserveOverflowSet = false;
  private int mUiOptions = 0;
  private ActionBarView wActionBar;
  
  public ActionBarSherlockCompat(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
  }
  
  public static String cleanActivityName(String paramString1, String paramString2)
  {
    String str;
    if (paramString2.charAt(0) == '.') {
      str = paramString1 + paramString2;
    }
    do
    {
      return str;
      str = paramString2;
    } while (paramString2.indexOf('.', 1) != -1);
    return paramString1 + "." + paramString2;
  }
  
  private ViewGroup generateLayout()
  {
    Object localObject = this.mActivity.getTheme().obtainStyledAttributes(R.styleable.SherlockTheme);
    if (!((TypedArray)localObject).hasValue(59)) {
      throw new IllegalStateException("You must use Theme.Sherlock, Theme.Sherlock.Light, Theme.Sherlock.Light.DarkActionBar, or a derivative.");
    }
    int i;
    if (((TypedArray)localObject).getBoolean(58, false))
    {
      requestFeature(1);
      if (((TypedArray)localObject).getBoolean(60, false)) {
        requestFeature(9);
      }
      if (((TypedArray)localObject).getBoolean(61, false)) {
        requestFeature(10);
      }
      ((TypedArray)localObject).recycle();
      if (hasFeature(1)) {
        break label193;
      }
      if (!hasFeature(9)) {
        break label186;
      }
      i = R.layout.abs__screen_action_bar_overlay;
    }
    for (;;)
    {
      localObject = this.mActivity.getLayoutInflater().inflate(i, null);
      this.mDecor.addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
      localObject = (ViewGroup)this.mDecor.findViewById(R.id.abs__content);
      if (localObject != null) {
        break label224;
      }
      throw new RuntimeException("Couldn't find content container view");
      if (!((TypedArray)localObject).getBoolean(59, false)) {
        break;
      }
      requestFeature(8);
      break;
      label186:
      i = R.layout.abs__screen_action_bar;
      continue;
      label193:
      if ((hasFeature(10)) && (!hasFeature(1))) {
        i = R.layout.abs__screen_simple_overlay_action_mode;
      } else {
        i = R.layout.abs__screen_simple;
      }
    }
    label224:
    this.mDecor.setId(-1);
    ((ViewGroup)localObject).setId(16908290);
    if (hasFeature(5))
    {
      IcsProgressBar localIcsProgressBar = getCircularProgressBar(false);
      if (localIcsProgressBar != null) {
        localIcsProgressBar.setIndeterminate(true);
      }
    }
    return (ViewGroup)localObject;
  }
  
  private IcsProgressBar getCircularProgressBar(boolean paramBoolean)
  {
    if (this.mCircularProgressBar != null) {
      return this.mCircularProgressBar;
    }
    if ((this.mContentParent == null) && (paramBoolean)) {
      installDecor();
    }
    this.mCircularProgressBar = ((IcsProgressBar)this.mDecor.findViewById(R.id.abs__progress_circular));
    if (this.mCircularProgressBar != null) {
      this.mCircularProgressBar.setVisibility(4);
    }
    return this.mCircularProgressBar;
  }
  
  private int getFeatures()
  {
    return this.mFeatures;
  }
  
  private IcsProgressBar getHorizontalProgressBar(boolean paramBoolean)
  {
    if (this.mHorizontalProgressBar != null) {
      return this.mHorizontalProgressBar;
    }
    if ((this.mContentParent == null) && (paramBoolean)) {
      installDecor();
    }
    this.mHorizontalProgressBar = ((IcsProgressBar)this.mDecor.findViewById(R.id.abs__progress_horizontal));
    if (this.mHorizontalProgressBar != null) {
      this.mHorizontalProgressBar.setVisibility(4);
    }
    return this.mHorizontalProgressBar;
  }
  
  private void hideProgressBars(IcsProgressBar paramIcsProgressBar1, IcsProgressBar paramIcsProgressBar2)
  {
    int i = this.mFeatures;
    Animation localAnimation = AnimationUtils.loadAnimation(this.mActivity, 17432577);
    localAnimation.setDuration(1000L);
    if (((i & 0x20) != 0) && (paramIcsProgressBar2.getVisibility() == 0))
    {
      paramIcsProgressBar2.startAnimation(localAnimation);
      paramIcsProgressBar2.setVisibility(4);
    }
    if (((i & 0x4) != 0) && (paramIcsProgressBar1.getVisibility() == 0))
    {
      paramIcsProgressBar1.startAnimation(localAnimation);
      paramIcsProgressBar1.setVisibility(4);
    }
  }
  
  private void initActionBar()
  {
    if (this.mDecor == null) {
      installDecor();
    }
    if ((this.aActionBar != null) || (!hasFeature(8)) || (hasFeature(1)) || (this.mActivity.isChild())) {}
    do
    {
      return;
      this.aActionBar = new ActionBarImpl(this.mActivity, this.mFeatures);
    } while (this.mIsDelegate);
    this.wActionBar.setWindowTitle(this.mActivity.getTitle());
  }
  
  private boolean initializePanelMenu()
  {
    Object localObject = this.mActivity;
    if (this.wActionBar != null)
    {
      TypedValue localTypedValue = new TypedValue();
      ((Context)localObject).getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
      int i = localTypedValue.resourceId;
      if (i != 0) {
        localObject = new ContextThemeWrapper((Context)localObject, i);
      }
    }
    for (;;)
    {
      this.mMenu = new MenuBuilder((Context)localObject);
      this.mMenu.setCallback(this);
      return true;
    }
  }
  
  private void installDecor()
  {
    if (this.mDecor == null) {
      this.mDecor = ((ViewGroup)this.mActivity.getWindow().getDecorView().findViewById(16908290));
    }
    boolean bool1;
    boolean bool2;
    if (this.mContentParent == null)
    {
      Object localObject1 = null;
      Object localObject2;
      int i;
      if (this.mDecor.getChildCount() > 0)
      {
        localObject2 = new ArrayList(1);
        int j = this.mDecor.getChildCount();
        i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= j) {
            break;
          }
          localObject1 = this.mDecor.getChildAt(0);
          this.mDecor.removeView((View)localObject1);
          ((List)localObject2).add(localObject1);
          i += 1;
        }
      }
      this.mContentParent = generateLayout();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (View)((Iterator)localObject1).next();
          this.mContentParent.addView((View)localObject2);
        }
      }
      this.wActionBar = ((ActionBarView)this.mDecor.findViewById(R.id.abs__action_bar));
      if (this.wActionBar != null)
      {
        this.wActionBar.setWindowCallback(this);
        if (this.wActionBar.getTitle() == null) {
          this.wActionBar.setWindowTitle(this.mActivity.getTitle());
        }
        if (hasFeature(2)) {
          this.wActionBar.initProgress();
        }
        if (hasFeature(5)) {
          this.wActionBar.initIndeterminateProgress();
        }
        i = loadUiOptionsFromManifest(this.mActivity);
        if (i != 0) {
          this.mUiOptions = i;
        }
        if ((this.mUiOptions & 0x1) == 0) {
          break label406;
        }
        bool1 = true;
        if (!bool1) {
          break label411;
        }
        bool2 = ResourcesCompat.getResources_getBoolean(this.mActivity, R.bool.abs__split_action_bar_is_narrow);
        label300:
        localObject1 = (ActionBarContainer)this.mDecor.findViewById(R.id.abs__split_action_bar);
        if (localObject1 == null) {
          break label435;
        }
        this.wActionBar.setSplitView((ActionBarContainer)localObject1);
        this.wActionBar.setSplitActionBar(bool2);
        this.wActionBar.setSplitWhenNarrow(bool1);
        this.mActionModeView = ((ActionBarContextView)this.mDecor.findViewById(R.id.abs__action_context_bar));
        this.mActionModeView.setSplitView((ActionBarContainer)localObject1);
        this.mActionModeView.setSplitActionBar(bool2);
        this.mActionModeView.setSplitWhenNarrow(bool1);
      }
    }
    for (;;)
    {
      this.mDecor.post(new Runnable()
      {
        public void run()
        {
          if ((!ActionBarSherlockCompat.this.mIsDestroyed) && (!ActionBarSherlockCompat.this.mActivity.isFinishing()) && (ActionBarSherlockCompat.this.mMenu == null)) {
            ActionBarSherlockCompat.this.dispatchInvalidateOptionsMenu();
          }
        }
      });
      return;
      label406:
      bool1 = false;
      break;
      label411:
      bool2 = this.mActivity.getTheme().obtainStyledAttributes(R.styleable.SherlockTheme).getBoolean(62, false);
      break label300;
      label435:
      if (bool2) {
        Log.e("ActionBarSherlock", "Requested split action bar with incompatible window decor! Ignoring request.");
      }
    }
  }
  
  private boolean isReservingOverflow()
  {
    if (!this.mReserveOverflowSet)
    {
      this.mReserveOverflow = ActionMenuPresenter.reserveOverflow(this.mActivity);
      this.mReserveOverflowSet = true;
    }
    return this.mReserveOverflow;
  }
  
  /* Error */
  private static int loadUiOptionsFromManifest(Activity paramActivity)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 475	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: invokevirtual 480	java/lang/Class:getName	()Ljava/lang/String;
    //   7: astore 9
    //   9: aload_0
    //   10: invokevirtual 484	android/app/Activity:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   13: getfield 489	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   16: astore 10
    //   18: aload_0
    //   19: aload 10
    //   21: iconst_0
    //   22: invokevirtual 493	android/app/Activity:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   25: invokevirtual 497	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   28: ldc_w 499
    //   31: invokevirtual 505	android/content/res/AssetManager:openXmlResourceParser	(Ljava/lang/String;)Landroid/content/res/XmlResourceParser;
    //   34: astore 11
    //   36: aload 11
    //   38: invokeinterface 510 1 0
    //   43: istore_2
    //   44: iconst_0
    //   45: istore_1
    //   46: iload_1
    //   47: istore_3
    //   48: iload_2
    //   49: iconst_1
    //   50: if_icmpeq +275 -> 325
    //   53: iload_1
    //   54: istore_3
    //   55: iload_2
    //   56: iconst_2
    //   57: if_icmpne +298 -> 355
    //   60: iload_1
    //   61: istore_2
    //   62: aload 11
    //   64: invokeinterface 511 1 0
    //   69: astore_0
    //   70: iload_1
    //   71: istore_2
    //   72: ldc_w 513
    //   75: aload_0
    //   76: invokevirtual 516	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifeq +74 -> 153
    //   82: iload_1
    //   83: istore_2
    //   84: aload 11
    //   86: invokeinterface 519 1 0
    //   91: iconst_1
    //   92: isub
    //   93: istore_3
    //   94: iload_1
    //   95: istore_2
    //   96: iload_3
    //   97: iflt +36 -> 133
    //   100: iload_1
    //   101: istore_2
    //   102: ldc_w 521
    //   105: aload 11
    //   107: iload_3
    //   108: invokeinterface 525 2 0
    //   113: invokevirtual 516	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   116: ifeq +30 -> 146
    //   119: iload_1
    //   120: istore_2
    //   121: aload 11
    //   123: iload_3
    //   124: iconst_0
    //   125: invokeinterface 528 3 0
    //   130: istore_1
    //   131: iload_1
    //   132: istore_2
    //   133: iload_2
    //   134: istore_1
    //   135: aload 11
    //   137: invokeinterface 531 1 0
    //   142: istore_2
    //   143: goto -97 -> 46
    //   146: iload_3
    //   147: iconst_1
    //   148: isub
    //   149: istore_3
    //   150: goto -56 -> 94
    //   153: iload_1
    //   154: istore_2
    //   155: iload_1
    //   156: istore_3
    //   157: ldc_w 533
    //   160: aload_0
    //   161: invokevirtual 516	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   164: ifeq +191 -> 355
    //   167: iload_1
    //   168: istore_2
    //   169: aload 11
    //   171: invokeinterface 519 1 0
    //   176: iconst_1
    //   177: isub
    //   178: istore_3
    //   179: iconst_0
    //   180: istore 4
    //   182: aconst_null
    //   183: astore 7
    //   185: aconst_null
    //   186: astore_0
    //   187: iload_3
    //   188: iflt +128 -> 316
    //   191: iload_1
    //   192: istore_2
    //   193: aload 11
    //   195: iload_3
    //   196: invokeinterface 525 2 0
    //   201: astore 12
    //   203: iload_1
    //   204: istore_2
    //   205: ldc_w 521
    //   208: aload 12
    //   210: invokevirtual 516	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   213: ifeq +50 -> 263
    //   216: iload_1
    //   217: istore_2
    //   218: aload 11
    //   220: iload_3
    //   221: iconst_0
    //   222: invokeinterface 528 3 0
    //   227: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   230: astore 8
    //   232: iload 4
    //   234: istore 5
    //   236: iload_1
    //   237: istore_2
    //   238: aload 8
    //   240: ifnull +120 -> 360
    //   243: iload_1
    //   244: istore_2
    //   245: aload 7
    //   247: ifnull +113 -> 360
    //   250: iload_1
    //   251: istore_2
    //   252: aload 8
    //   254: invokevirtual 542	java/lang/Integer:intValue	()I
    //   257: istore_1
    //   258: iload_1
    //   259: istore_2
    //   260: goto +100 -> 360
    //   263: iload 4
    //   265: istore 5
    //   267: aload_0
    //   268: astore 8
    //   270: iload_1
    //   271: istore_2
    //   272: ldc_w 544
    //   275: aload 12
    //   277: invokevirtual 516	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   280: ifeq -44 -> 236
    //   283: iload_1
    //   284: istore_2
    //   285: aload 10
    //   287: aload 11
    //   289: iload_3
    //   290: invokeinterface 547 2 0
    //   295: invokestatic 549	com/actionbarsherlock/internal/ActionBarSherlockCompat:cleanActivityName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   298: astore 7
    //   300: iload_1
    //   301: istore_2
    //   302: aload 9
    //   304: aload 7
    //   306: invokevirtual 516	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   309: istore 6
    //   311: iload 6
    //   313: ifne +14 -> 327
    //   316: iload_1
    //   317: istore_3
    //   318: iload 4
    //   320: ifeq +35 -> 355
    //   323: iload_1
    //   324: istore_3
    //   325: iload_3
    //   326: ireturn
    //   327: iconst_1
    //   328: istore 5
    //   330: aload_0
    //   331: astore 8
    //   333: goto -97 -> 236
    //   336: astore_0
    //   337: iconst_0
    //   338: istore_2
    //   339: aload_0
    //   340: invokevirtual 552	java/lang/Exception:printStackTrace	()V
    //   343: iload_2
    //   344: ireturn
    //   345: astore_0
    //   346: goto -7 -> 339
    //   349: astore_0
    //   350: iload_1
    //   351: istore_2
    //   352: goto -13 -> 339
    //   355: iload_3
    //   356: istore_1
    //   357: goto -222 -> 135
    //   360: iload_3
    //   361: iconst_1
    //   362: isub
    //   363: istore_3
    //   364: iload_2
    //   365: istore_1
    //   366: iload 5
    //   368: istore 4
    //   370: aload 8
    //   372: astore_0
    //   373: goto -186 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	paramActivity	Activity
    //   45	321	1	i	int
    //   43	322	2	j	int
    //   47	317	3	k	int
    //   180	189	4	m	int
    //   234	133	5	n	int
    //   309	3	6	bool	boolean
    //   183	122	7	str1	String
    //   230	141	8	localObject	Object
    //   7	296	9	str2	String
    //   16	270	10	str3	String
    //   34	254	11	localXmlResourceParser	android.content.res.XmlResourceParser
    //   201	75	12	str4	String
    // Exception table:
    //   from	to	target	type
    //   0	44	336	java/lang/Exception
    //   62	70	345	java/lang/Exception
    //   72	82	345	java/lang/Exception
    //   84	94	345	java/lang/Exception
    //   102	119	345	java/lang/Exception
    //   121	131	345	java/lang/Exception
    //   157	167	345	java/lang/Exception
    //   169	179	345	java/lang/Exception
    //   193	203	345	java/lang/Exception
    //   205	216	345	java/lang/Exception
    //   218	232	345	java/lang/Exception
    //   252	258	345	java/lang/Exception
    //   272	283	345	java/lang/Exception
    //   285	300	345	java/lang/Exception
    //   302	311	345	java/lang/Exception
    //   135	143	349	java/lang/Exception
  }
  
  private void onIntChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 2) || (paramInt1 == 5)) {
      updateProgressBars(paramInt2);
    }
  }
  
  private boolean preparePanel()
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if (this.mMenuIsPrepared) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if ((this.mMenu != null) && (!this.mMenuRefreshContent)) {
            break label121;
          }
          if (this.mMenu != null) {
            break;
          }
          bool1 = bool2;
        } while (!initializePanelMenu());
        bool1 = bool2;
      } while (this.mMenu == null);
      if (this.wActionBar != null) {
        this.wActionBar.setMenu(this.mMenu, this);
      }
      this.mMenu.stopDispatchingItemsChanged();
      if (callbackCreateOptionsMenu(this.mMenu)) {
        break;
      }
      this.mMenu = null;
      bool1 = bool2;
    } while (this.wActionBar == null);
    this.wActionBar.setMenu(null, this);
    return false;
    this.mMenuRefreshContent = false;
    label121:
    this.mMenu.stopDispatchingItemsChanged();
    if (this.mMenuFrozenActionViewState != null)
    {
      this.mMenu.restoreActionViewStates(this.mMenuFrozenActionViewState);
      this.mMenuFrozenActionViewState = null;
    }
    if (!callbackPrepareOptionsMenu(this.mMenu))
    {
      if (this.wActionBar != null) {
        this.wActionBar.setMenu(null, this);
      }
      this.mMenu.startDispatchingItemsChanged();
      return false;
    }
    KeyCharacterMap localKeyCharacterMap = KeyCharacterMap.load(-1);
    MenuBuilder localMenuBuilder = this.mMenu;
    boolean bool1 = bool3;
    if (localKeyCharacterMap.getKeyboardType() != 1) {
      bool1 = true;
    }
    localMenuBuilder.setQwertyMode(bool1);
    this.mMenu.startDispatchingItemsChanged();
    this.mMenuIsPrepared = true;
    return true;
  }
  
  private void reopenMenu(boolean paramBoolean)
  {
    if ((this.wActionBar != null) && (this.wActionBar.isOverflowReserved()))
    {
      if ((this.wActionBar.isOverflowMenuShowing()) && (paramBoolean)) {
        break label61;
      }
      if ((this.wActionBar.getVisibility() == 0) && (callbackPrepareOptionsMenu(this.mMenu))) {
        this.wActionBar.showOverflowMenu();
      }
    }
    return;
    label61:
    this.wActionBar.hideOverflowMenu();
  }
  
  private void setFeatureInt(int paramInt1, int paramInt2)
  {
    updateInt(paramInt1, paramInt2, false);
  }
  
  private void showProgressBars(IcsProgressBar paramIcsProgressBar1, IcsProgressBar paramIcsProgressBar2)
  {
    int i = this.mFeatures;
    if (((i & 0x20) != 0) && (paramIcsProgressBar2.getVisibility() == 4)) {
      paramIcsProgressBar2.setVisibility(0);
    }
    if (((i & 0x4) != 0) && (paramIcsProgressBar1.getProgress() < 10000)) {
      paramIcsProgressBar1.setVisibility(0);
    }
  }
  
  private void updateInt(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.mContentParent == null) {}
    while (((1 << paramInt1 & getFeatures()) == 0) && (!paramBoolean)) {
      return;
    }
    onIntChanged(paramInt1, paramInt2);
  }
  
  private void updateProgressBars(int paramInt)
  {
    IcsProgressBar localIcsProgressBar1 = getCircularProgressBar(true);
    IcsProgressBar localIcsProgressBar2 = getHorizontalProgressBar(true);
    int i = this.mFeatures;
    if (paramInt == -1) {
      if ((i & 0x4) != 0)
      {
        paramInt = localIcsProgressBar2.getProgress();
        if ((localIcsProgressBar2.isIndeterminate()) || (paramInt < 10000))
        {
          paramInt = 0;
          localIcsProgressBar2.setVisibility(paramInt);
        }
      }
      else if ((i & 0x20) != 0)
      {
        localIcsProgressBar1.setVisibility(0);
      }
    }
    label109:
    do
    {
      do
      {
        return;
        paramInt = 4;
        break;
        if (paramInt != -2) {
          break label109;
        }
        if ((i & 0x4) != 0) {
          localIcsProgressBar2.setVisibility(8);
        }
      } while ((i & 0x20) == 0);
      localIcsProgressBar1.setVisibility(8);
      return;
      if (paramInt == -3)
      {
        localIcsProgressBar2.setIndeterminate(true);
        return;
      }
      if (paramInt == -4)
      {
        localIcsProgressBar2.setIndeterminate(false);
        return;
      }
      if ((paramInt >= 0) && (paramInt <= 10000))
      {
        localIcsProgressBar2.setProgress(paramInt + 0);
        if (paramInt < 10000)
        {
          showProgressBars(localIcsProgressBar2, localIcsProgressBar1);
          return;
        }
        hideProgressBars(localIcsProgressBar2, localIcsProgressBar1);
        return;
      }
    } while ((20000 > paramInt) || (paramInt > 30000));
    localIcsProgressBar2.setSecondaryProgress(paramInt - 20000);
    showProgressBars(localIcsProgressBar2, localIcsProgressBar1);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.mContentParent == null) {
      installDecor();
    }
    this.mContentParent.addView(paramView, paramLayoutParams);
    initActionBar();
  }
  
  void checkCloseActionMenu(com.actionbarsherlock.view.Menu paramMenu)
  {
    if (this.mClosingActionMenu) {
      return;
    }
    this.mClosingActionMenu = true;
    this.wActionBar.dismissPopupMenus();
    this.mClosingActionMenu = false;
  }
  
  public boolean dispatchCloseOptionsMenu()
  {
    if (!isReservingOverflow()) {}
    while (this.wActionBar == null) {
      return false;
    }
    return this.wActionBar.hideOverflowMenu();
  }
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.aActionBar != null) {
      this.aActionBar.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean dispatchCreateOptionsMenu(android.view.Menu paramMenu)
  {
    return true;
  }
  
  public void dispatchDestroy()
  {
    this.mIsDestroyed = true;
  }
  
  public void dispatchInvalidateOptionsMenu()
  {
    if (this.mMenu != null)
    {
      Bundle localBundle = new Bundle();
      this.mMenu.saveActionViewStates(localBundle);
      if (localBundle.size() > 0) {
        this.mMenuFrozenActionViewState = localBundle;
      }
      this.mMenu.stopDispatchingItemsChanged();
      this.mMenu.clear();
    }
    this.mMenuRefreshContent = true;
    if (this.wActionBar != null)
    {
      this.mMenuIsPrepared = false;
      preparePanel();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      int i = paramKeyEvent.getAction();
      if (this.mActionMode != null) {
        if (i == 1) {
          this.mActionMode.finish();
        }
      }
      do
      {
        return true;
        if ((this.wActionBar == null) || (!this.wActionBar.hasExpandedActionView())) {
          break;
        }
      } while (i != 1);
      this.wActionBar.collapseActionView();
      return true;
    }
    return false;
  }
  
  public boolean dispatchMenuOpened(int paramInt, android.view.Menu paramMenu)
  {
    if ((paramInt == 8) || (paramInt == 0))
    {
      if (this.aActionBar != null) {
        this.aActionBar.dispatchMenuVisibilityChanged(true);
      }
      return true;
    }
    return false;
  }
  
  public boolean dispatchOpenOptionsMenu()
  {
    if (!isReservingOverflow()) {
      return false;
    }
    return this.wActionBar.showOverflowMenu();
  }
  
  public boolean dispatchOptionsItemSelected(android.view.MenuItem paramMenuItem)
  {
    throw new IllegalStateException("Native callback invoked. Create a test case and report!");
  }
  
  public void dispatchPanelClosed(int paramInt, android.view.Menu paramMenu)
  {
    if (((paramInt == 8) || (paramInt == 0)) && (this.aActionBar != null)) {
      this.aActionBar.dispatchMenuVisibilityChanged(false);
    }
  }
  
  public void dispatchPause()
  {
    if ((this.wActionBar != null) && (this.wActionBar.isOverflowMenuShowing())) {
      this.wActionBar.hideOverflowMenu();
    }
  }
  
  public void dispatchPostCreate(Bundle paramBundle)
  {
    if (this.mIsDelegate) {
      this.mIsTitleReady = true;
    }
    if (this.mDecor == null) {
      initActionBar();
    }
  }
  
  public void dispatchPostResume()
  {
    if (this.aActionBar != null) {
      this.aActionBar.setShowHideAnimationEnabled(true);
    }
  }
  
  public boolean dispatchPrepareOptionsMenu(android.view.Menu paramMenu)
  {
    if (this.mActionMode != null) {}
    for (;;)
    {
      return false;
      this.mMenuIsPrepared = false;
      if ((preparePanel()) && (!isReservingOverflow()))
      {
        if (this.mNativeItemMap == null) {
          this.mNativeItemMap = new HashMap();
        }
        while (this.mMenu != null)
        {
          return this.mMenu.bindNativeOverflow(paramMenu, this, this.mNativeItemMap);
          this.mNativeItemMap.clear();
        }
      }
    }
  }
  
  public void dispatchRestoreInstanceState(Bundle paramBundle)
  {
    this.mMenuFrozenActionViewState = ((Bundle)paramBundle.getParcelable("sherlock:Panels"));
  }
  
  public void dispatchSaveInstanceState(Bundle paramBundle)
  {
    if (this.mMenu != null)
    {
      this.mMenuFrozenActionViewState = new Bundle();
      this.mMenu.saveActionViewStates(this.mMenuFrozenActionViewState);
    }
    paramBundle.putParcelable("sherlock:Panels", this.mMenuFrozenActionViewState);
  }
  
  public void dispatchStop()
  {
    if (this.aActionBar != null) {
      this.aActionBar.setShowHideAnimationEnabled(false);
    }
  }
  
  public void dispatchTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    if (((!this.mIsDelegate) || (this.mIsTitleReady)) && (this.wActionBar != null)) {
      this.wActionBar.setWindowTitle(paramCharSequence);
    }
  }
  
  public void ensureActionBar()
  {
    if (this.mDecor == null) {
      initActionBar();
    }
  }
  
  public ActionBar getActionBar()
  {
    initActionBar();
    return this.aActionBar;
  }
  
  protected Context getThemedContext()
  {
    return this.aActionBar.getThemedContext();
  }
  
  public boolean hasFeature(int paramInt)
  {
    return (this.mFeatures & 1 << paramInt) != 0;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    checkCloseActionMenu(paramMenuBuilder);
  }
  
  public boolean onMenuItemClick(android.view.MenuItem paramMenuItem)
  {
    MenuItemImpl localMenuItemImpl = (MenuItemImpl)this.mNativeItemMap.get(paramMenuItem);
    if (localMenuItemImpl != null) {
      localMenuItemImpl.invoke();
    }
    for (;;)
    {
      return true;
      Log.e("ActionBarSherlock", "Options item \"" + paramMenuItem + "\" not found in mapping");
    }
  }
  
  public boolean onMenuItemSelected(int paramInt, com.actionbarsherlock.view.MenuItem paramMenuItem)
  {
    return callbackOptionsItemSelected(paramMenuItem);
  }
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, com.actionbarsherlock.view.MenuItem paramMenuItem)
  {
    return callbackOptionsItemSelected(paramMenuItem);
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    reopenMenu(true);
  }
  
  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    return true;
  }
  
  public boolean requestFeature(int paramInt)
  {
    if (this.mContentParent != null) {
      throw new AndroidRuntimeException("requestFeature() must be called before adding content");
    }
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 6: 
    case 7: 
    default: 
      return false;
    }
    this.mFeatures |= 1 << paramInt;
    return true;
  }
  
  public void setContentView(int paramInt)
  {
    if (this.mContentParent == null) {
      installDecor();
    }
    for (;;)
    {
      this.mActivity.getLayoutInflater().inflate(paramInt, this.mContentParent);
      android.view.Window.Callback localCallback = this.mActivity.getWindow().getCallback();
      if (localCallback != null) {
        localCallback.onContentChanged();
      }
      initActionBar();
      return;
      this.mContentParent.removeAllViews();
    }
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.mContentParent == null) {
      installDecor();
    }
    for (;;)
    {
      this.mContentParent.addView(paramView, paramLayoutParams);
      paramView = this.mActivity.getWindow().getCallback();
      if (paramView != null) {
        paramView.onContentChanged();
      }
      initActionBar();
      return;
      this.mContentParent.removeAllViews();
    }
  }
  
  public void setProgress(int paramInt)
  {
    setFeatureInt(2, paramInt + 0);
  }
  
  public void setProgressBarIndeterminate(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = -3;; i = -4)
    {
      setFeatureInt(2, i);
      return;
    }
  }
  
  public void setProgressBarIndeterminateVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = -1;; i = -2)
    {
      setFeatureInt(5, i);
      return;
    }
  }
  
  public void setProgressBarVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = -1;; i = -2)
    {
      setFeatureInt(2, i);
      return;
    }
  }
  
  public void setSecondaryProgress(int paramInt)
  {
    setFeatureInt(2, paramInt + 20000);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    dispatchTitleChanged(paramCharSequence, 0);
  }
  
  public void setUiOptions(int paramInt)
  {
    this.mUiOptions = paramInt;
  }
  
  public void setUiOptions(int paramInt1, int paramInt2)
  {
    this.mUiOptions = (this.mUiOptions & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public ActionMode startActionMode(ActionMode.Callback paramCallback)
  {
    if (this.mActionMode != null) {
      this.mActionMode.finish();
    }
    ActionModeCallbackWrapper localActionModeCallbackWrapper = new ActionModeCallbackWrapper(paramCallback);
    initActionBar();
    if (this.aActionBar != null) {}
    for (Object localObject = this.aActionBar.startActionMode(localActionModeCallbackWrapper);; localObject = null)
    {
      if (localObject != null) {
        this.mActionMode = ((ActionMode)localObject);
      }
      for (;;)
      {
        if ((this.mActionMode != null) && ((this.mActivity instanceof ActionBarSherlock.OnActionModeStartedListener))) {
          ((ActionBarSherlock.OnActionModeStartedListener)this.mActivity).onActionModeStarted(this.mActionMode);
        }
        return this.mActionMode;
        if (this.mActionModeView == null)
        {
          localObject = (ViewStub)this.mDecor.findViewById(R.id.abs__action_mode_bar_stub);
          if (localObject != null) {
            this.mActionModeView = ((ActionBarContextView)((ViewStub)localObject).inflate());
          }
        }
        if (this.mActionModeView != null)
        {
          this.mActionModeView.killMode();
          localObject = new StandaloneActionMode(this.mActivity, this.mActionModeView, localActionModeCallbackWrapper, true);
          if (paramCallback.onCreateActionMode((ActionMode)localObject, ((ActionMode)localObject).getMenu()))
          {
            ((ActionMode)localObject).invalidate();
            this.mActionModeView.initForMode((ActionMode)localObject);
            this.mActionModeView.setVisibility(0);
            this.mActionMode = ((ActionMode)localObject);
            this.mActionModeView.sendAccessibilityEvent(32);
          }
          else
          {
            this.mActionMode = null;
          }
        }
      }
    }
  }
  
  private class ActionModeCallbackWrapper
    implements ActionMode.Callback
  {
    private final ActionMode.Callback mWrapped;
    
    public ActionModeCallbackWrapper(ActionMode.Callback paramCallback)
    {
      this.mWrapped = paramCallback;
    }
    
    public boolean onActionItemClicked(ActionMode paramActionMode, com.actionbarsherlock.view.MenuItem paramMenuItem)
    {
      return this.mWrapped.onActionItemClicked(paramActionMode, paramMenuItem);
    }
    
    public boolean onCreateActionMode(ActionMode paramActionMode, com.actionbarsherlock.view.Menu paramMenu)
    {
      return this.mWrapped.onCreateActionMode(paramActionMode, paramMenu);
    }
    
    public void onDestroyActionMode(ActionMode paramActionMode)
    {
      this.mWrapped.onDestroyActionMode(paramActionMode);
      if (ActionBarSherlockCompat.this.mActionModeView != null)
      {
        ActionBarSherlockCompat.this.mActionModeView.setVisibility(8);
        ActionBarSherlockCompat.this.mActionModeView.removeAllViews();
      }
      if ((ActionBarSherlockCompat.this.mActivity instanceof ActionBarSherlock.OnActionModeFinishedListener)) {
        ((ActionBarSherlock.OnActionModeFinishedListener)ActionBarSherlockCompat.this.mActivity).onActionModeFinished(ActionBarSherlockCompat.this.mActionMode);
      }
      ActionBarSherlockCompat.access$502(ActionBarSherlockCompat.this, null);
    }
    
    public boolean onPrepareActionMode(ActionMode paramActionMode, com.actionbarsherlock.view.Menu paramMenu)
    {
      return this.mWrapped.onPrepareActionMode(paramActionMode, paramMenu);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/internal/ActionBarSherlockCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */