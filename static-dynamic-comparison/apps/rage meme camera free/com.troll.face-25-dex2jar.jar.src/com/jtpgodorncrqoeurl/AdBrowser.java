package com.jtpgodorncrqoeurl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class AdBrowser
  extends Activity
{
  public static final String SHOW_BACK_EXTRA = "open_show_back";
  public static final String SHOW_FORWARD_EXTRA = "open_show_forward";
  public static final String SHOW_REFRESH_EXTRA = "open_show_refresh";
  public static final String URL_EXTRA = "extra_url";
  
  /* Error */
  public android.graphics.Bitmap bitmapFromJar(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 28
    //   5: invokevirtual 34	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   8: aload_1
    //   9: invokevirtual 40	java/lang/ClassLoader:getResource	(Ljava/lang/String;)Ljava/net/URL;
    //   12: invokevirtual 46	java/net/URL:getFile	()Ljava/lang/String;
    //   15: astore 4
    //   17: aload 4
    //   19: astore_3
    //   20: aload 4
    //   22: ldc 48
    //   24: invokevirtual 54	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   27: ifeq +10 -> 37
    //   30: aload 4
    //   32: iconst_5
    //   33: invokevirtual 58	java/lang/String:substring	(I)Ljava/lang/String;
    //   36: astore_3
    //   37: aload_3
    //   38: ldc 60
    //   40: invokevirtual 64	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   43: istore_2
    //   44: aload_3
    //   45: astore 4
    //   47: iload_2
    //   48: ifle +11 -> 59
    //   51: aload_3
    //   52: iconst_0
    //   53: iload_2
    //   54: invokevirtual 67	java/lang/String:substring	(II)Ljava/lang/String;
    //   57: astore 4
    //   59: new 69	java/util/jar/JarFile
    //   62: dup
    //   63: aload 4
    //   65: invokespecial 72	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   68: astore_3
    //   69: aload_3
    //   70: aload_3
    //   71: aload_1
    //   72: invokevirtual 76	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   75: invokevirtual 80	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   78: astore_1
    //   79: aload_1
    //   80: astore_3
    //   81: aload_1
    //   82: invokestatic 86	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   85: astore 4
    //   87: aload 4
    //   89: astore_3
    //   90: aload_3
    //   91: astore 4
    //   93: aload_1
    //   94: ifnull +10 -> 104
    //   97: aload_1
    //   98: invokevirtual 91	java/io/InputStream:close	()V
    //   101: aload_3
    //   102: astore 4
    //   104: aload 4
    //   106: areturn
    //   107: astore 4
    //   109: aconst_null
    //   110: astore_1
    //   111: aload_1
    //   112: astore_3
    //   113: aload 4
    //   115: invokevirtual 94	java/lang/Exception:printStackTrace	()V
    //   118: aload 5
    //   120: astore 4
    //   122: aload_1
    //   123: ifnull -19 -> 104
    //   126: aload_1
    //   127: invokevirtual 91	java/io/InputStream:close	()V
    //   130: aconst_null
    //   131: areturn
    //   132: astore_1
    //   133: aconst_null
    //   134: areturn
    //   135: astore_1
    //   136: aconst_null
    //   137: astore_3
    //   138: aload_3
    //   139: ifnull +7 -> 146
    //   142: aload_3
    //   143: invokevirtual 91	java/io/InputStream:close	()V
    //   146: aload_1
    //   147: athrow
    //   148: astore_1
    //   149: aload_3
    //   150: areturn
    //   151: astore_3
    //   152: goto -6 -> 146
    //   155: astore_1
    //   156: goto -18 -> 138
    //   159: astore 4
    //   161: goto -50 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	AdBrowser
    //   0	164	1	paramString	String
    //   43	11	2	i	int
    //   19	131	3	localObject1	Object
    //   151	1	3	localException1	Exception
    //   15	90	4	localObject2	Object
    //   107	7	4	localException2	Exception
    //   120	1	4	localObject3	Object
    //   159	1	4	localException3	Exception
    //   1	118	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   3	17	107	java/lang/Exception
    //   20	37	107	java/lang/Exception
    //   37	44	107	java/lang/Exception
    //   51	59	107	java/lang/Exception
    //   59	79	107	java/lang/Exception
    //   126	130	132	java/lang/Exception
    //   3	17	135	finally
    //   20	37	135	finally
    //   37	44	135	finally
    //   51	59	135	finally
    //   59	79	135	finally
    //   97	101	148	java/lang/Exception
    //   142	146	151	java/lang/Exception
    //   81	87	155	finally
    //   113	118	155	finally
    //   81	87	159	java/lang/Exception
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new RelativeLayout(this);
    WebView localWebView = new WebView(this);
    getWindow().requestFeature(2);
    getWindow().setFeatureInt(2, -1);
    Intent localIntent = getIntent();
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setId(100);
    localLinearLayout.setWeightSum(100.0F);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(2, 100);
    localLinearLayout.setBackgroundDrawable(new BitmapDrawable(bitmapFromJar("bitmaps/bkgrnd.png")));
    paramBundle.addView(localWebView, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    paramBundle.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new LinearLayout.LayoutParams(-2, -1);
    ((LinearLayout.LayoutParams)localObject1).weight = 25.0F;
    ((LinearLayout.LayoutParams)localObject1).gravity = 16;
    Object localObject2 = new ImageButton(this);
    ((ImageButton)localObject2).setBackgroundColor(17170445);
    ((ImageButton)localObject2).setId(103);
    localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    if (!localIntent.getBooleanExtra("open_show_back", true)) {
      ((ImageButton)localObject2).setVisibility(8);
    }
    ((ImageButton)localObject2).setImageBitmap(bitmapFromJar("bitmaps/leftarrow.png"));
    ((ImageButton)localObject2).setOnClickListener(new c(this));
    localObject1 = new ImageButton(this);
    ((ImageButton)localObject1).setBackgroundColor(17170445);
    ((ImageButton)localObject1).setId(102);
    localObject2 = new LinearLayout.LayoutParams(-2, -1);
    ((LinearLayout.LayoutParams)localObject2).weight = 25.0F;
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    if (!localIntent.getBooleanExtra("open_show_forward", true)) {
      ((ImageButton)localObject1).setVisibility(8);
    }
    ((ImageButton)localObject1).setOnClickListener(new d(this));
    localObject1 = new ImageButton(this);
    ((ImageButton)localObject1).setImageBitmap(bitmapFromJar("bitmaps/refresh.png"));
    ((ImageButton)localObject1).setBackgroundColor(17170445);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).weight = 25.0F;
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    if (!localIntent.getBooleanExtra("open_show_refresh", true)) {
      ((ImageButton)localObject1).setVisibility(8);
    }
    ((ImageButton)localObject1).setOnClickListener(new e(this));
    localObject1 = new ImageButton(this);
    ((ImageButton)localObject1).setImageBitmap(bitmapFromJar("bitmaps/close.png"));
    ((ImageButton)localObject1).setBackgroundColor(17170445);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).weight = 25.0F;
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    ((ImageButton)localObject1).setOnClickListener(new f(this));
    getWindow().requestFeature(2);
    CookieSyncManager.createInstance(this);
    CookieSyncManager.getInstance().startSync();
    localWebView.getSettings().setJavaScriptEnabled(true);
    localWebView.loadUrl(localIntent.getStringExtra("extra_url"));
    localWebView.setId(101);
    localWebView.setWebViewClient(new g(this));
    setContentView(paramBundle);
    localWebView.setWebChromeClient(new h(this));
  }
  
  protected void onPause()
  {
    super.onPause();
    CookieSyncManager.getInstance().stopSync();
  }
  
  protected void onResume()
  {
    super.onResume();
    CookieSyncManager.getInstance().startSync();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdBrowser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */