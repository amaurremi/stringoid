package com.mdotm.android.ads;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.PictureListener;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

public class MdotMView
  extends RelativeLayout
{
  private static final Typeface AD_FONT = Typeface.create(Typeface.SANS_SERIF, 1);
  private static final double GRADIENT_STOP = 0.4375D;
  private static final int GRADIENT_TOP_ALPHA = 127;
  private static final int HIGHLIGHT_BACKGROUND_COLOR = -1147097;
  private static final int HIGHLIGHT_COLOR = -19456;
  public static final String LOG_TAG = "MdotM SDK (MdotMView)";
  private static final String MDOTM_BASE_URL = "http://ads.mdotm.com/ads/feed.php?";
  private ProgressBar activityIndicator;
  private String adLandingUrl;
  private Drawable adSelectedBackground;
  private boolean adSelectionInProgress;
  private int backgroundColor = -16777216;
  private Drawable defaultBackground;
  private String dest_url;
  private boolean isAdClicked = false;
  private MdotMActionListener listener;
  private boolean onLandingPage = false;
  private int padding;
  private int textColor = -1;
  
  public MdotMView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MdotMView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public MdotMView(Context paramContext, MdotMActionListener paramMdotMActionListener)
  {
    super(paramContext);
    this.listener = paramMdotMActionListener;
    init();
    setAdSelectionInProgress(false);
  }
  
  private void adNetworkCompleted()
  {
    Log.w("MdotM SDK (MdotMView)", "On ad network completed");
    setClickable(true);
    setAdSelectionInProgress(false);
    this.isAdClicked = false;
    hideActivityIndicator();
  }
  
  private void clicked()
  {
    Log.i("MdotM SDK (MdotMView)", "  Selected to clicked  ");
    if (this.adLandingUrl != null)
    {
      if (!isAdSelectionInProgress())
      {
        if (this.dest_url.toLowerCase().startsWith("market", 0))
        {
          Object localObject1 = new DefaultHttpClient();
          localObject3 = new HttpGet(this.adLandingUrl);
          try
          {
            localObject1 = ((HttpClient)localObject1).execute((HttpUriRequest)localObject3);
            Log.d("MdotM SDK (MdotMView)", ((HttpResponse)localObject1).getStatusLine().toString());
            if (((HttpResponse)localObject1).getEntity() != null)
            {
              localObject1 = new Intent("android.intent.action.VIEW", Uri.parse(this.dest_url));
              getRootView().getContext().startActivity((Intent)localObject1);
            }
            return;
          }
          catch (ClientProtocolException localClientProtocolException)
          {
            Log.e("MdotM SDK (MdotMView)", "Caught ClientProtocolException in getCustom()", localClientProtocolException);
            return;
          }
          catch (IOException localIOException)
          {
            Log.e("MdotM SDK (MdotMView)", "Caught IOException in getCustom()", localIOException);
            return;
          }
          catch (IllegalStateException localIllegalStateException)
          {
            do
            {
              Log.e("MdotM SDK (MdotMView)", "Caught IllegalStateException in getCustom()", localIllegalStateException);
            } while (!localIllegalStateException.getMessage().contentEquals("Scheme 'market' not registered."));
            localObject2 = new Intent("android.intent.action.VIEW", Uri.parse(this.dest_url));
            getRootView().getContext().startActivity((Intent)localObject2);
            return;
          }
        }
        Object localObject2 = this.adLandingUrl;
        setAdSelectionInProgress(true);
        showActivityIndicator();
        final Object localObject4 = new RelativeLayout.LayoutParams(-1, -1);
        final Object localObject3 = (Activity)getRootView().getContext();
        final WebView localWebView = new WebView((Context)localObject3);
        final Button localButton1 = new Button((Context)localObject3);
        Button localButton2 = new Button((Context)localObject3);
        final TextView localTextView = new TextView((Context)localObject3);
        ((Activity)localObject3).addContentView(localWebView, (ViewGroup.LayoutParams)localObject4);
        localWebView.getSettings().setJavaScriptEnabled(true);
        localObject4 = new RelativeLayout((Context)localObject3);
        localWebView.setWebChromeClient(new WebChromeClient()
        {
          public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
          {
            localObject3.setProgress(paramAnonymousInt * 1000);
          }
        });
        localWebView.setWebViewClient(new WebViewClient()
        {
          public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
          {
            Toast.makeText(localObject3, "Oh no! " + paramAnonymousString1, 0).show();
          }
        });
        localWebView.setPictureListener(new WebView.PictureListener()
        {
          public void onNewPicture(WebView paramAnonymousWebView, Picture paramAnonymousPicture)
          {
            localButton1.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                this.val$wvLP.setVisibility(4);
                this.val$relLay.removeAllViews();
                MdotMView.this.onLandingPage = false;
              }
            });
            if (!MdotMView.this.onLandingPage)
            {
              MdotMView.this.adNetworkCompleted();
              localTextView.setVisibility(4);
              MdotMView.this.onLandingPage = true;
            }
          }
        });
        RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams2.addRule(12);
        localLayoutParams2.height = 40;
        localLayoutParams4.addRule(12);
        localLayoutParams4.addRule(11);
        localLayoutParams4.height = 50;
        localLayoutParams3.addRule(12);
        localLayoutParams3.addRule(11);
        localLayoutParams3.rightMargin = 5;
        localLayoutParams3.bottomMargin = 5;
        localButton1.setText("BACK");
        localButton1.setTextSize(8.0F);
        localButton1.setLayoutParams(localLayoutParams2);
        localButton2.setBackgroundDrawable(populateDrawableBackGround(-1, -12303292));
        localButton2.setLayoutParams(localLayoutParams4);
        localButton2.setClickable(false);
        localTextView.setText("loading ....");
        localTextView.setLayoutParams(localLayoutParams3);
        ((RelativeLayout)localObject4).addView(localButton2);
        ((RelativeLayout)localObject4).addView(localButton1);
        ((RelativeLayout)localObject4).addView(localTextView);
        ((Activity)localObject3).addContentView((View)localObject4, localLayoutParams1);
        localWebView.loadUrl((String)localObject2);
        return;
      }
      Log.w("MdotM SDK (MdotMView)", "ad selection under progress");
      return;
    }
    Log.w("MdotM SDK (MdotMView)", "selected ad is null");
  }
  
  /* Error */
  private String convertStreamToString(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 355	java/io/BufferedReader
    //   5: dup
    //   6: new 357	java/io/InputStreamReader
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 360	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   14: sipush 8192
    //   17: invokespecial 363	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   20: astore_3
    //   21: new 365	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   28: astore 4
    //   30: aload_3
    //   31: invokevirtual 369	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: astore 5
    //   36: aload 5
    //   38: ifnonnull +38 -> 76
    //   41: aload_1
    //   42: ifnull +7 -> 49
    //   45: aload_1
    //   46: invokevirtual 374	java/io/InputStream:close	()V
    //   49: aload_3
    //   50: ifnull +7 -> 57
    //   53: aload_3
    //   54: invokevirtual 375	java/io/BufferedReader:close	()V
    //   57: aload 4
    //   59: aconst_null
    //   60: invokevirtual 379	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   63: ifeq +178 -> 241
    //   66: new 156	java/lang/String
    //   69: dup
    //   70: invokespecial 380	java/lang/String:<init>	()V
    //   73: astore_1
    //   74: aload_1
    //   75: areturn
    //   76: aload 4
    //   78: new 365	java/lang/StringBuilder
    //   81: dup
    //   82: aload 5
    //   84: invokestatic 384	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   87: invokespecial 385	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: ldc_w 387
    //   93: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: goto -73 -> 30
    //   106: astore 4
    //   108: ldc 36
    //   110: ldc_w 394
    //   113: aload 4
    //   115: invokestatic 234	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   118: pop
    //   119: aload_1
    //   120: ifnull +7 -> 127
    //   123: aload_1
    //   124: invokevirtual 374	java/io/InputStream:close	()V
    //   127: aload_2
    //   128: astore_1
    //   129: aload_3
    //   130: ifnull -56 -> 74
    //   133: aload_3
    //   134: invokevirtual 375	java/io/BufferedReader:close	()V
    //   137: aconst_null
    //   138: areturn
    //   139: astore_1
    //   140: ldc 36
    //   142: ldc_w 396
    //   145: aload_1
    //   146: invokestatic 234	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   149: pop
    //   150: aconst_null
    //   151: areturn
    //   152: astore_1
    //   153: ldc 36
    //   155: ldc_w 398
    //   158: aload_1
    //   159: invokestatic 234	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   162: pop
    //   163: goto -36 -> 127
    //   166: astore_2
    //   167: aload_1
    //   168: ifnull +7 -> 175
    //   171: aload_1
    //   172: invokevirtual 374	java/io/InputStream:close	()V
    //   175: aload_3
    //   176: ifnull +7 -> 183
    //   179: aload_3
    //   180: invokevirtual 375	java/io/BufferedReader:close	()V
    //   183: aload_2
    //   184: athrow
    //   185: astore_1
    //   186: ldc 36
    //   188: ldc_w 398
    //   191: aload_1
    //   192: invokestatic 234	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   195: pop
    //   196: goto -21 -> 175
    //   199: astore_1
    //   200: ldc 36
    //   202: ldc_w 396
    //   205: aload_1
    //   206: invokestatic 234	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   209: pop
    //   210: goto -27 -> 183
    //   213: astore_1
    //   214: ldc 36
    //   216: ldc_w 398
    //   219: aload_1
    //   220: invokestatic 234	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   223: pop
    //   224: goto -175 -> 49
    //   227: astore_1
    //   228: ldc 36
    //   230: ldc_w 396
    //   233: aload_1
    //   234: invokestatic 234	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   237: pop
    //   238: goto -181 -> 57
    //   241: aload 4
    //   243: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	MdotMView
    //   0	247	1	paramInputStream	InputStream
    //   1	127	2	localObject1	Object
    //   166	18	2	localObject2	Object
    //   20	160	3	localBufferedReader	java.io.BufferedReader
    //   28	49	4	localStringBuilder	StringBuilder
    //   106	136	4	localIOException	IOException
    //   34	49	5	str	String
    // Exception table:
    //   from	to	target	type
    //   30	36	106	java/io/IOException
    //   76	103	106	java/io/IOException
    //   133	137	139	java/io/IOException
    //   123	127	152	java/io/IOException
    //   30	36	166	finally
    //   76	103	166	finally
    //   108	119	166	finally
    //   171	175	185	java/io/IOException
    //   179	183	199	java/io/IOException
    //   45	49	213	java/io/IOException
    //   53	57	227	java/io/IOException
  }
  
  private void createAdWithBannerView(Bitmap paramBitmap)
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageBitmap(paramBitmap);
    this.padding = ((52 - paramBitmap.getHeight()) / 2);
    paramBitmap = new RelativeLayout.LayoutParams(-1, -1);
    paramBitmap.setMargins(this.padding, this.padding, 0, this.padding);
    localImageView.setLayoutParams(paramBitmap);
    localImageView.setId(1);
    addView(localImageView);
  }
  
  private void createAdWithIconView(Bitmap paramBitmap, AdUnit paramAdUnit)
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageBitmap(paramBitmap);
    paramBitmap = new RelativeLayout.LayoutParams(paramBitmap.getWidth(), paramBitmap.getHeight());
    paramBitmap.setMargins(this.padding, this.padding, 0, this.padding);
    localImageView.setLayoutParams(paramBitmap);
    localImageView.setId(1);
    addView(localImageView);
    paramBitmap = new TextView(getContext());
    paramBitmap.setText(paramAdUnit.adText);
    paramBitmap.setTypeface(AD_FONT);
    paramBitmap.setTextColor(this.textColor);
    paramBitmap.setTextSize(13.0F);
    paramBitmap.setId(2);
    paramAdUnit = new RelativeLayout.LayoutParams(-2, -2);
    paramAdUnit.addRule(1, 1);
    paramAdUnit.setMargins(20, 4, 10, 10);
    paramAdUnit.addRule(13);
    paramBitmap.setLayoutParams(paramAdUnit);
    addView(paramBitmap);
    setGravity(15);
  }
  
  private void drawBackgroundView(boolean paramBoolean)
  {
    Log.d("X-Value", " drawBackgroundView   :: " + paramBoolean);
    if (this.defaultBackground == null) {
      this.defaultBackground = populateDrawableBackGround(-1, this.backgroundColor);
    }
    if (this.adSelectedBackground == null) {
      this.adSelectedBackground = populateDrawableBackGround(-1147097, 46080);
    }
    if (paramBoolean)
    {
      setBackgroundDrawable(this.defaultBackground);
      return;
    }
    setBackgroundDrawable(this.adSelectedBackground);
  }
  
  private void fetchAd()
  {
    Log.d("MdotM SDK (MdotMView)", "  fetching Ad started ");
    Object localObject2 = generateURLString();
    Log.d("MdotM SDK (MdotMView)", "   Genrerated url " + (String)localObject2);
    Object localObject1 = new DefaultHttpClient();
    localObject2 = new HttpGet((String)localObject2);
    try
    {
      localObject1 = ((HttpClient)localObject1).execute((HttpUriRequest)localObject2);
      Log.d("MdotM SDK (MdotMView)", ((HttpResponse)localObject1).getStatusLine().toString());
      localObject1 = ((HttpResponse)localObject1).getEntity();
      if (localObject1 != null) {
        initializeAdView(generateAdUnitFromJsonString(convertStreamToString(((HttpEntity)localObject1).getContent())), getContext());
      }
      return;
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      Log.e("MdotM SDK (MdotMView)", "Caught ClientProtocolException in getCustom()", localClientProtocolException);
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("MdotM SDK (MdotMView)", "Caught IOException in getCustom()", localIOException);
    }
  }
  
  private static Bitmap fetchImage(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (paramString != null)
    {
      Bitmap localBitmap = null;
      InputStream localInputStream2 = null;
      InputStream localInputStream1 = localInputStream2;
      localObject = localBitmap;
      try
      {
        URLConnection localURLConnection = new URL(paramString).openConnection();
        localInputStream1 = localInputStream2;
        localObject = localBitmap;
        localURLConnection.setConnectTimeout(0);
        localInputStream1 = localInputStream2;
        localObject = localBitmap;
        localURLConnection.setReadTimeout(0);
        localInputStream1 = localInputStream2;
        localObject = localBitmap;
        localURLConnection.setUseCaches(paramBoolean);
        localInputStream1 = localInputStream2;
        localObject = localBitmap;
        localURLConnection.connect();
        localInputStream1 = localInputStream2;
        localObject = localBitmap;
        localInputStream2 = localURLConnection.getInputStream();
        localInputStream1 = localInputStream2;
        localObject = localInputStream2;
        localBitmap = BitmapFactory.decodeStream(localInputStream2);
        paramString = localBitmap;
        localObject = paramString;
        if (localInputStream2 != null) {}
        try
        {
          ((InputStream)localObject).close();
          throw paramString;
          Log.w("MdotM SDK (MdotMView)", "Image url is null");
          return null;
        }
        catch (IOException localIOException1)
        {
          for (;;) {}
        }
      }
      catch (Throwable localThrowable)
      {
        do
        {
          localThrowable = localThrowable;
          localInputStream2 = null;
          localObject = localInputStream1;
          Log.w("MdotM SDK (MdotMView)", "Problem while fetchImage()  :  " + paramString, localThrowable);
          localObject = localInputStream2;
        } while (localInputStream1 == null);
        try
        {
          localInputStream1.close();
          return null;
        }
        catch (IOException paramString)
        {
          return null;
        }
      }
      finally
      {
        if (localObject == null) {}
      }
    }
    return paramString;
  }
  
  private AdUnit generateAdUnitFromJsonString(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      Object localObject = paramString.replace("[", "").replace("]", "");
      if (((String)localObject).trim().length() < 1)
      {
        Log.d("MdotM SDK (MdotMView)", "Neglecting, Invalid AD response.");
        return null;
      }
      try
      {
        paramString = new JSONObject((String)localObject);
        if (paramString == null) {
          continue;
        }
        localObject = new AdUnit();
        try
        {
          ((AdUnit)localObject).adType = paramString.getInt("ad_type");
          ((AdUnit)localObject).launchType = paramString.getInt("launch_type");
          ((AdUnit)localObject).adText = paramString.getString("ad_text");
          ((AdUnit)localObject).imageUrl = paramString.getString("img_url");
          ((AdUnit)localObject).landingUrl = paramString.getString("landing_url");
          ((AdUnit)localObject).dest_url = paramString.getString("dest_url");
          Log.d("MdotM SDK (MdotMView)", "Created MdotM adUnit successfully");
          return (AdUnit)localObject;
        }
        catch (JSONException paramString)
        {
          Log.d("MdotM SDK (MdotMView)", "Caught JSONException in generateAdUnitFromJsonString()", paramString);
          paramString.printStackTrace();
          return null;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.d("MdotM SDK (MdotMView)", "Caught JSONException while creating JSON object from string:  " + (String)localObject);
          paramString = null;
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  private String generateURLString()
  {
    StringBuilder localStringBuilder = new StringBuilder("http://ads.mdotm.com/ads/feed.php?");
    localStringBuilder.append("appver=");
    localStringBuilder.append(260);
    localStringBuilder.append("&v=");
    localStringBuilder.append(MdotMManager.getSystemVersion());
    localStringBuilder.append("&apikey=");
    localStringBuilder.append("mdotm_android");
    localStringBuilder.append("&appkey=");
    localStringBuilder.append(MdotMManager.getAppKey());
    localStringBuilder.append("&deviceid=");
    try
    {
      localStringBuilder.append(MdotMManager.getDeviceId(getContext()));
      localStringBuilder.append("&aid=");
      localStringBuilder.append(MdotMManager.getAndroidId(getContext()));
      localStringBuilder.append("&width=");
      localStringBuilder.append(320);
      localStringBuilder.append("&height=");
      localStringBuilder.append(50);
      localStringBuilder.append("&rand=");
      localStringBuilder.append(new Integer((int)(Math.random() * 1024.0D)));
      localStringBuilder.append("&fmt=");
      localStringBuilder.append("json");
      localStringBuilder.append("&ua=");
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      try
      {
        localStringBuilder.append(URLEncoder.encode(MdotMManager.getUserAgent(), "UTF-8"));
        localStringBuilder.append("&test=");
        localStringBuilder.append(MdotMManager.getTestModeValue());
        return localStringBuilder.toString();
        localNoSuchAlgorithmException = localNoSuchAlgorithmException;
        localStringBuilder.append("");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
    }
  }
  
  private void hideActivityIndicator()
  {
    post(new Thread()
    {
      public void run()
      {
        if (MdotMView.this.activityIndicator != null)
        {
          MdotMView.this.activityIndicator.setVisibility(4);
          MdotMView.this.setBackgroundDrawable(MdotMView.this.defaultBackground);
        }
      }
    });
  }
  
  private void init()
  {
    fetchAd();
    setFocusable(true);
    setDescendantFocusability(262144);
    setClickable(true);
  }
  
  private void initializeAdView(AdUnit paramAdUnit, Context paramContext)
  {
    if (paramAdUnit != null)
    {
      this.adLandingUrl = paramAdUnit.landingUrl;
      this.dest_url = paramAdUnit.dest_url;
      setFocusable(true);
      setClickable(true);
      paramContext = fetchImage(paramAdUnit.imageUrl, false);
      this.padding = 8;
      RelativeLayout.LayoutParams localLayoutParams;
      if (paramContext != null)
      {
        float f = getResources().getDisplayMetrics().density;
        int i = (int)(20 * f);
        int j = (int)(20 * f);
        this.activityIndicator = new ProgressBar(getContext());
        this.activityIndicator.setIndeterminate(false);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.activityIndicator.setLayoutParams(localLayoutParams);
        this.activityIndicator.setVisibility(4);
        this.activityIndicator.setMinimumHeight(j);
        this.activityIndicator.setMinimumWidth(i);
        this.activityIndicator.setMax(100);
        this.activityIndicator.setBackgroundDrawable(this.defaultBackground);
        localLayoutParams.topMargin = 1;
        if (paramAdUnit.adType != 1) {
          break label241;
        }
        createAdWithBannerView(paramContext);
        if (this.activityIndicator != null)
        {
          this.activityIndicator.setId(2);
          localLayoutParams.addRule(11);
        }
      }
      for (;;)
      {
        if (this.activityIndicator != null) {
          addView(this.activityIndicator);
        }
        drawBackgroundView(true);
        setVisibility(super.getVisibility());
        onAdViewSuccess();
        return;
        label241:
        if (paramAdUnit.adType != 2) {
          break;
        }
        createAdWithIconView(paramContext, paramAdUnit);
        if (this.activityIndicator != null)
        {
          this.activityIndicator.setId(3);
          localLayoutParams.addRule(11);
        }
      }
      Log.w("MdotM SDK (MdotMView)", "Woooo!! unable to display ad, We got unsupported ad type.");
      onAdViewFailure();
      return;
    }
    Log.w("MdotM SDK (MdotMView)", "Ad is not loaded");
    onAdViewFailure();
  }
  
  private boolean isAdSelectionInProgress()
  {
    return this.adSelectionInProgress;
  }
  
  private void onAdViewFailure()
  {
    if (this.listener != null)
    {
      this.listener.adRequestFailed(this);
      return;
    }
    Log.d("MdotM SDK (MdotMView)", " Unable to call mdotmListenres  while failure of AdView");
  }
  
  private void onAdViewSuccess()
  {
    if (this.listener != null)
    {
      this.listener.adRequestCompletedSuccessfully(this);
      return;
    }
    Log.d("MdotM SDK (MdotMView)", "  Unable to call mdotmListenres while success of AdView ");
  }
  
  private static Drawable populateDrawableBackGround(int paramInt1, int paramInt2)
  {
    Rect localRect = new Rect(0, 0, 320, 48);
    Bitmap localBitmap = Bitmap.createBitmap(localRect.width(), localRect.height(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Object localObject = new Paint();
    ((Paint)localObject).setColor(paramInt1);
    ((Paint)localObject).setAntiAlias(true);
    localCanvas.drawRect(localRect, (Paint)localObject);
    paramInt1 = Color.argb(127, Color.red(paramInt2), Color.green(paramInt2), Color.blue(paramInt2));
    localObject = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt1, paramInt2 });
    paramInt1 = (int)(localRect.height() * 0.4375D) + localRect.top;
    ((GradientDrawable)localObject).setBounds(localRect.left, localRect.top, localRect.right, paramInt1);
    ((GradientDrawable)localObject).draw(localCanvas);
    localRect = new Rect(localRect.left, paramInt1, localRect.right, localRect.bottom);
    localObject = new Paint();
    ((Paint)localObject).setColor(paramInt2);
    localCanvas.drawRect(localRect, (Paint)localObject);
    return new BitmapDrawable(localBitmap);
  }
  
  private void setAdSelectionInProgress(boolean paramBoolean)
  {
    this.adSelectionInProgress = paramBoolean;
  }
  
  private void showActivityIndicator()
  {
    post(new Thread()
    {
      public void run()
      {
        if (MdotMView.this.activityIndicator != null)
        {
          MdotMView.this.activityIndicator.setVisibility(0);
          MdotMView.this.activityIndicator.setBackgroundDrawable(MdotMView.this.defaultBackground);
        }
      }
    });
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getAction();
    if ((!this.isAdClicked) && (i == 1))
    {
      this.isAdClicked = true;
      clicked();
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int j = getLeft();
    int k = getTop();
    int m = getRight();
    int n = getBottom();
    Log.i("MdotM SDK (MdotMView)", "  Selected  ");
    if ((f1 < j) || (f1 > m) || (f2 < k) || (f2 > n))
    {
      Log.i("MdotM SDK (MdotMView)", "Always outside of ad display area ");
      if (!this.isAdClicked) {
        drawBackgroundView(true);
      }
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if (i == 1)
      {
        if (!this.isAdClicked)
        {
          this.isAdClicked = true;
          setClickable(false);
          clicked();
          drawBackgroundView(true);
        }
      }
      else if ((i == 0) && (!this.isAdClicked)) {
        drawBackgroundView(false);
      }
    }
  }
  
  public int getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  public MdotMActionListener getListener()
  {
    return this.listener;
  }
  
  public int getTextColor()
  {
    return this.textColor;
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
  }
  
  public void setListener(MdotMActionListener paramMdotMActionListener)
  {
    this.listener = paramMdotMActionListener;
  }
  
  public void setTextColor(int paramInt)
  {
    this.textColor = paramInt;
  }
  
  public static abstract interface MdotMActionListener
  {
    public abstract void adRequestCompletedSuccessfully(MdotMView paramMdotMView);
    
    public abstract void adRequestFailed(MdotMView paramMdotMView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/mdotm/android/ads/MdotMView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */