package mobi.beyondpod.ui.core;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.ui.views.base.ActionModeBP;
import mobi.beyondpod.ui.views.base.ActionModeBP.Callback;
import mobi.beyondpod.ui.views.base.TitleBarActionMode;

public class ActionBarHelperEmulate
  extends ActionBarHelper
{
  private static final String MENU_ATTR_ID = "id";
  private static final String MENU_ATTR_SHOW_AS_ACTION = "showAsAction";
  private static final String MENU_RES_NAMESPACE = "http://schemas.android.com/apk/res/android";
  protected boolean _ShowHomeAsUp = false;
  private TitleBarActionMode _TitleActionMode;
  protected Set<Integer> mActionItemIds = new HashSet();
  
  protected ActionBarHelperEmulate(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private View addActionItemCompatFromMenuItem(final MenuItem paramMenuItem, int paramInt)
  {
    int j = paramMenuItem.getItemId();
    ViewGroup localViewGroup = getActionBarCompat();
    if (localViewGroup == null)
    {
      localObject1 = null;
      return (View)localObject1;
    }
    Object localObject1 = this._Activity;
    int i;
    label41:
    ImageButton localImageButton;
    label73:
    PackageManager localPackageManager;
    if (j == 16908332)
    {
      i = 2130772163;
      localImageButton = new ImageButton((Context)localObject1, null, i);
      localObject1 = this._Activity.getResources();
      if (j != 16908332) {
        break label413;
      }
      i = 2131492909;
      localImageButton.setLayoutParams(new ViewGroup.LayoutParams((int)((Resources)localObject1).getDimension(i), -1));
      if (j == 2131230764) {
        localImageButton.setId(2131230763);
      }
      localImageButton.setScaleType(ImageView.ScaleType.CENTER);
      if (j != 16908332) {
        break label419;
      }
      localImageButton.setId(2131230762);
      if (this._ShowHomeAsUp)
      {
        localImageButton.setBackgroundResource(2130837639);
        localImageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      localObject2 = null;
      localPackageManager = this._Activity.getPackageManager();
    }
    try
    {
      localObject1 = localPackageManager.getActivityIcon(this._Activity.getComponentName());
      localObject2 = localObject1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;) {}
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this._Activity.getApplicationInfo().loadIcon(localPackageManager);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramMenuItem.getIcon();
    }
    localImageButton.setImageDrawable((Drawable)localObject2);
    label228:
    if (paramMenuItem.isEnabled())
    {
      i = 0;
      label239:
      localImageButton.setVisibility(i);
      localImageButton.setContentDescription(paramMenuItem.getTitle());
      localImageButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ActionBarHelperEmulate.this._Activity.onMenuItemSelected(0, paramMenuItem);
        }
      });
      if (paramInt < 0) {
        break label450;
      }
      localViewGroup.addView(localImageButton, paramInt);
    }
    for (;;)
    {
      localObject1 = localImageButton;
      if (paramMenuItem.getItemId() != 2131230764) {
        break;
      }
      paramMenuItem = new ProgressBar(this._Activity, null, 2130772164);
      paramInt = this._Activity.getResources().getDimensionPixelSize(2131492907);
      i = this._Activity.getResources().getDimensionPixelSize(2131492907);
      j = paramInt / 2;
      localObject1 = new LinearLayout.LayoutParams(j, j);
      ((LinearLayout.LayoutParams)localObject1).setMargins((paramInt - j) / 2, (i - j) / 2, (paramInt - j) / 2, 0);
      paramMenuItem.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramMenuItem.setVisibility(8);
      paramMenuItem.setId(2131230761);
      localViewGroup.addView(paramMenuItem);
      return localImageButton;
      i = 2130772189;
      break label41;
      label413:
      i = 2131492908;
      break label73;
      label419:
      localImageButton.setImageDrawable(paramMenuItem.getIcon());
      localImageButton.setId(paramMenuItem.getItemId());
      break label228;
      i = 8;
      break label239;
      label450:
      localViewGroup.addView(localImageButton);
    }
  }
  
  private ViewGroup getActionBarCompat()
  {
    return (ViewGroup)this._Activity.findViewById(2131230757);
  }
  
  private void setupActionBar()
  {
    ViewGroup localViewGroup = getActionBarCompat();
    if (localViewGroup == null) {
      return;
    }
    this._TitleActionMode = ((TitleBarActionMode)this._Activity.findViewById(2131230804));
    this._TitleActionMode.Initialize();
    SimpleMenuItem localSimpleMenuItem = new SimpleMenuItem(new SimpleMenu(this._Activity), 16908332, 0, this._Activity.getString(2131296392));
    localSimpleMenuItem.setIcon(2130838005);
    addActionItemCompatFromMenuItem(localSimpleMenuItem, 0);
    ((TextView)localViewGroup.findViewById(2131230759)).setText(this._Activity.getTitle());
  }
  
  public MenuInflater getMenuInflater(MenuInflater paramMenuInflater)
  {
    return new WrappedMenuInflater(this._Activity, paramMenuInflater);
  }
  
  public void invalidateOptionsMenu()
  {
    this._Activity.onCreateOptionsMenu(new SimpleMenu(this._Activity));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this._Activity.requestWindowFeature(7);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (getActionBarCompat() == null) {
      return false;
    }
    Object localObject = this.mActionItemIds.iterator();
    int i;
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        i = 0;
        if (i != paramMenu.size()) {
          break;
        }
        return true;
      }
      paramMenu.findItem(((Integer)((Iterator)localObject).next()).intValue()).setVisible(false);
    }
    localObject = paramMenu.getItem(i);
    View localView;
    if (localObject != null)
    {
      localView = getActionBarCompat().findViewById(((MenuItem)localObject).getItemId());
      if (localView != null) {
        if (!((MenuItem)localObject).isEnabled()) {
          break label156;
        }
      }
    }
    label156:
    for (int j = 0;; j = 8)
    {
      localView.setVisibility(j);
      if ((localView instanceof ImageView)) {
        ((ImageView)localView).setImageDrawable(((MenuItem)localObject).getIcon());
      }
      i += 1;
      break;
    }
  }
  
  public void onPostCreate(Bundle paramBundle)
  {
    this._Activity.getWindow().setFeatureInt(7, 2130903064);
    setupActionBar();
    paramBundle = new SimpleMenu(this._Activity);
    this._Activity.onCreatePanelMenu(0, paramBundle);
    this._Activity.onPrepareOptionsMenu(paramBundle);
    int i = 0;
    for (;;)
    {
      if (i >= paramBundle.size()) {
        return;
      }
      MenuItem localMenuItem = paramBundle.getItem(i);
      if (this.mActionItemIds.contains(Integer.valueOf(localMenuItem.getItemId()))) {
        addActionItemCompatFromMenuItem(localMenuItem, -1);
      }
      i += 1;
    }
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    TextView localTextView = (TextView)this._Activity.findViewById(2131230759);
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
  }
  
  public void setDisplayOptions(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 4) {
      if (paramInt2 != 4) {
        break label34;
      }
    }
    View localView;
    label34:
    for (boolean bool = true;; bool = false)
    {
      this._ShowHomeAsUp = bool;
      localView = this._Activity.findViewById(2131230762);
      if (localView != null) {
        break;
      }
      return;
    }
    if (this._ShowHomeAsUp) {}
    for (paramInt1 = 2130837639;; paramInt1 = 2130837591)
    {
      localView.setBackgroundResource(paramInt1);
      return;
    }
  }
  
  public void setRefreshActionItemState(boolean paramBoolean)
  {
    int j = 0;
    View localView1 = this._Activity.findViewById(2131230763);
    View localView2 = this._Activity.findViewById(2131230761);
    if (localView1 != null)
    {
      if (paramBoolean)
      {
        i = 8;
        localView1.setVisibility(i);
      }
    }
    else if (localView2 != null) {
      if (!paramBoolean) {
        break label65;
      }
    }
    label65:
    for (int i = j;; i = 8)
    {
      localView2.setVisibility(i);
      return;
      i = 0;
      break;
    }
  }
  
  public void setSubtitle(String paramString)
  {
    TextView localTextView = (TextView)this._Activity.findViewById(2131230760);
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      if (!StringUtils.IsNullOrEmpty(paramString)) {
        break label39;
      }
    }
    label39:
    for (int i = 8;; i = 0)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public ActionModeBP startActionMode(ActionModeBP.Callback paramCallback)
  {
    if (paramCallback == null) {
      return null;
    }
    return this._TitleActionMode.startMultiselect(paramCallback);
  }
  
  private class WrappedMenuInflater
    extends MenuInflater
  {
    MenuInflater mInflater;
    
    public WrappedMenuInflater(Context paramContext, MenuInflater paramMenuInflater)
    {
      super();
      this.mInflater = paramMenuInflater;
    }
    
    /* Error */
    private void loadActionBarMetadata(int paramInt)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aconst_null
      //   4: astore 7
      //   6: aconst_null
      //   7: astore 6
      //   9: aload_0
      //   10: getfield 15	mobi/beyondpod/ui/core/ActionBarHelperEmulate$WrappedMenuInflater:this$0	Lmobi/beyondpod/ui/core/ActionBarHelperEmulate;
      //   13: getfield 31	mobi/beyondpod/ui/core/ActionBarHelperEmulate:mActionItemIds	Ljava/util/Set;
      //   16: invokeinterface 37 1 0
      //   21: aload_0
      //   22: getfield 15	mobi/beyondpod/ui/core/ActionBarHelperEmulate$WrappedMenuInflater:this$0	Lmobi/beyondpod/ui/core/ActionBarHelperEmulate;
      //   25: getfield 41	mobi/beyondpod/ui/core/ActionBarHelperEmulate:_Activity	Landroid/app/Activity;
      //   28: invokevirtual 47	android/app/Activity:getResources	()Landroid/content/res/Resources;
      //   31: iload_1
      //   32: invokevirtual 53	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
      //   35: astore 8
      //   37: aload 8
      //   39: astore 6
      //   41: aload 8
      //   43: astore 5
      //   45: aload 8
      //   47: astore 7
      //   49: aload 8
      //   51: invokeinterface 59 1 0
      //   56: istore_2
      //   57: iconst_0
      //   58: istore_1
      //   59: iload_1
      //   60: ifeq +16 -> 76
      //   63: aload 8
      //   65: ifnull +10 -> 75
      //   68: aload 8
      //   70: invokeinterface 62 1 0
      //   75: return
      //   76: iload_2
      //   77: tableswitch	default:+23->100, 1:+228->305, 2:+52->129
      //   100: iload_1
      //   101: istore_2
      //   102: aload 8
      //   104: astore 6
      //   106: aload 8
      //   108: astore 5
      //   110: aload 8
      //   112: astore 7
      //   114: aload 8
      //   116: invokeinterface 65 1 0
      //   121: istore_3
      //   122: iload_2
      //   123: istore_1
      //   124: iload_3
      //   125: istore_2
      //   126: goto -67 -> 59
      //   129: iload_1
      //   130: istore_2
      //   131: aload 8
      //   133: astore 6
      //   135: aload 8
      //   137: astore 5
      //   139: aload 8
      //   141: astore 7
      //   143: aload 8
      //   145: invokeinterface 69 1 0
      //   150: ldc 71
      //   152: invokevirtual 77	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   155: ifeq -53 -> 102
      //   158: aload 8
      //   160: astore 6
      //   162: aload 8
      //   164: astore 5
      //   166: aload 8
      //   168: astore 7
      //   170: aload 8
      //   172: ldc 79
      //   174: ldc 81
      //   176: iconst_0
      //   177: invokeinterface 85 4 0
      //   182: istore_3
      //   183: iload_1
      //   184: istore_2
      //   185: iload_3
      //   186: ifeq -84 -> 102
      //   189: aload 8
      //   191: astore 6
      //   193: aload 8
      //   195: astore 5
      //   197: aload 8
      //   199: astore 7
      //   201: aload 8
      //   203: ldc 79
      //   205: ldc 87
      //   207: iconst_m1
      //   208: invokeinterface 90 4 0
      //   213: istore 4
      //   215: iload 4
      //   217: iconst_2
      //   218: if_icmpeq +18 -> 236
      //   221: iload 4
      //   223: iconst_1
      //   224: if_icmpeq +12 -> 236
      //   227: iload_1
      //   228: istore_2
      //   229: iload 4
      //   231: bipush 6
      //   233: if_icmpne -131 -> 102
      //   236: aload 8
      //   238: astore 6
      //   240: aload 8
      //   242: astore 5
      //   244: aload 8
      //   246: astore 7
      //   248: aload_0
      //   249: getfield 15	mobi/beyondpod/ui/core/ActionBarHelperEmulate$WrappedMenuInflater:this$0	Lmobi/beyondpod/ui/core/ActionBarHelperEmulate;
      //   252: getfield 31	mobi/beyondpod/ui/core/ActionBarHelperEmulate:mActionItemIds	Ljava/util/Set;
      //   255: iload_3
      //   256: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   259: invokeinterface 99 2 0
      //   264: pop
      //   265: iload_1
      //   266: istore_2
      //   267: goto -165 -> 102
      //   270: astore 7
      //   272: aload 6
      //   274: astore 5
      //   276: new 101	android/view/InflateException
      //   279: dup
      //   280: ldc 103
      //   282: aload 7
      //   284: invokespecial 106	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   287: athrow
      //   288: astore 6
      //   290: aload 5
      //   292: ifnull +10 -> 302
      //   295: aload 5
      //   297: invokeinterface 62 1 0
      //   302: aload 6
      //   304: athrow
      //   305: iconst_1
      //   306: istore_2
      //   307: goto -205 -> 102
      //   310: astore 6
      //   312: aload 7
      //   314: astore 5
      //   316: new 101	android/view/InflateException
      //   319: dup
      //   320: ldc 103
      //   322: aload 6
      //   324: invokespecial 106	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   327: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	328	0	this	WrappedMenuInflater
      //   0	328	1	paramInt	int
      //   56	251	2	i	int
      //   121	135	3	j	int
      //   213	21	4	k	int
      //   1	314	5	localObject1	Object
      //   7	266	6	localObject2	Object
      //   288	15	6	localObject3	Object
      //   310	13	6	localIOException	java.io.IOException
      //   4	243	7	localObject4	Object
      //   270	43	7	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
      //   35	210	8	localXmlResourceParser	android.content.res.XmlResourceParser
      // Exception table:
      //   from	to	target	type
      //   21	37	270	org/xmlpull/v1/XmlPullParserException
      //   49	57	270	org/xmlpull/v1/XmlPullParserException
      //   114	122	270	org/xmlpull/v1/XmlPullParserException
      //   143	158	270	org/xmlpull/v1/XmlPullParserException
      //   170	183	270	org/xmlpull/v1/XmlPullParserException
      //   201	215	270	org/xmlpull/v1/XmlPullParserException
      //   248	265	270	org/xmlpull/v1/XmlPullParserException
      //   21	37	288	finally
      //   49	57	288	finally
      //   114	122	288	finally
      //   143	158	288	finally
      //   170	183	288	finally
      //   201	215	288	finally
      //   248	265	288	finally
      //   276	288	288	finally
      //   316	328	288	finally
      //   21	37	310	java/io/IOException
      //   49	57	310	java/io/IOException
      //   114	122	310	java/io/IOException
      //   143	158	310	java/io/IOException
      //   170	183	310	java/io/IOException
      //   201	215	310	java/io/IOException
      //   248	265	310	java/io/IOException
    }
    
    public void inflate(int paramInt, Menu paramMenu)
    {
      loadActionBarMetadata(paramInt);
      this.mInflater.inflate(paramInt, paramMenu);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/ActionBarHelperEmulate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */