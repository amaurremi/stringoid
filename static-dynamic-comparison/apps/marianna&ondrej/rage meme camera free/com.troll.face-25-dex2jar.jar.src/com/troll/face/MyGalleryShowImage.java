package com.troll.face;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.troll.adapter.MemoryCache;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public class MyGalleryShowImage
  extends Activity
  implements GestureDetector.OnGestureListener
{
  static final int CUSTOM_DIALOG_ID = 0;
  private static final int SHARE = 2;
  private static final int SWIPE_MAX_OFF_PATH = 250;
  private static final int SWIPE_MIN_DISTANCE = 120;
  private static final int SWIPE_THRESHOLD_VELOCITY = 200;
  public static String commentString;
  public static Context ctx;
  public static int imagePosition;
  public static float initialscale;
  private static ArrayList<String> mySDCardImagesAbsolutePath = new ArrayList();
  public static String next;
  public static String pkg;
  public static String uid;
  public static MyWebView wv;
  public static boolean zoomFlag = false;
  private View.OnClickListener buttonListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      Log.d("buttonListener", "friends selected");
      MyGalleryShowImage.this.showDialog(0);
    }
  };
  Button customDialog_Dismiss;
  TextView customDialog_TextView;
  Button customDialog_Update;
  DBAdapter db;
  ProgressDialog dialog;
  private GestureDetector gestureScanner;
  String iamgeUrl;
  String imageID;
  private Map<ImageView, String> imageViews = Collections.synchronizedMap(new WeakHashMap());
  private LinearLayout main;
  MemoryCache memoryCache = new MemoryCache();
  private View.OnClickListener shareListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = new AlertDialog.Builder(MyGalleryShowImage.this);
      paramAnonymousView.setTitle("Share Menu");
      paramAnonymousView.setMessage("Do you want Share this Picture?");
      paramAnonymousView.setPositiveButton("Share", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          MyGalleryShowImage.this.Share();
        }
      });
      paramAnonymousView.show();
    }
  };
  private View.OnClickListener trashImageListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = new AlertDialog.Builder(MyGalleryShowImage.this);
      paramAnonymousView.setTitle("Delete photo");
      paramAnonymousView.setMessage("The photo will be deleted. Are you sure you want to continue?");
      paramAnonymousView.setPositiveButton("Yes", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          new File((String)MyGalleryShowImage.mySDCardImagesAbsolutePath.get(MyGalleryShowImage.imagePosition)).delete();
          ((Activity)MyGalleryShowImage.ctx).finish();
        }
      });
      paramAnonymousView.setNegativeButton("No", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
      });
      paramAnonymousView.show();
    }
  };
  
  public static void swipLeft()
  {
    int i = imagePosition + 1;
    if (i < mySDCardImagesAbsolutePath.size())
    {
      Intent localIntent = new Intent(ctx, MyGalleryShowImage.class);
      MyApp localMyApp = (MyApp)ctx.getApplicationContext();
      localMyApp.setMySDCardSingleImagesAbsolutePath((String)mySDCardImagesAbsolutePath.get(i));
      localMyApp.setPosition(i);
      ctx.startActivity(localIntent);
      ((Activity)ctx).finish();
    }
  }
  
  public static void swipRight()
  {
    int i = imagePosition - 1;
    if (i >= 0)
    {
      Intent localIntent = new Intent(ctx, MyGalleryShowImage.class);
      MyApp localMyApp = (MyApp)ctx.getApplicationContext();
      localMyApp.setMySDCardSingleImagesAbsolutePath((String)mySDCardImagesAbsolutePath.get(i));
      localMyApp.setPosition(i);
      ctx.startActivity(localIntent);
      ((Activity)ctx).finish();
    }
  }
  
  public void Share()
  {
    Log.d("share", "share");
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.putExtra("android.intent.extra.TEXT", "Troll Face , download app here:  market://details?id=com.troll.face");
    localIntent.addFlags(1);
    localIntent.setType("image/jpeg");
    localIntent.putExtra("android.intent.extra.SUBJECT", "TrollFace , This App! Its AWESOME!  https://play.google.com/store/apps/details?id=com.troll.face");
    localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.iamgeUrl)));
    startActivityForResult(Intent.createChooser(localIntent, "TrollFace , This App! Its AWESOME!  https://play.google.com/store/apps/details?id=com.troll.face"), 2);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    getWindowManager().getDefaultDisplay();
    new BitmapFactory.Options();
    switch (paramInt1)
    {
    }
    do
    {
      return;
      if (!Environment.getExternalStorageState().equalsIgnoreCase("MOUNTED")) {
        break;
      }
    } while (this.db.getMessage("Commented").getCount() != 0);
    paramIntent = new AlertDialog.Builder(this);
    paramIntent.setTitle("Thank You");
    paramIntent.setMessage("If you like this app , leave a comment.");
    paramIntent.setPositiveButton("Ok", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        MyGalleryShowImage.this.db.insertMessage("1", "Commented");
        paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.troll.face"));
        MyGalleryShowImage.this.startActivity(paramAnonymousDialogInterface);
      }
    });
    paramIntent.setNegativeButton("No", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        MyGalleryShowImage.this.db.insertMessage("1", "Commented");
      }
    });
    paramIntent.setNeutralButton("Later", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    paramIntent.show();
    return;
    paramIntent = new AlertDialog.Builder(this);
    paramIntent.setTitle("Thank You");
    paramIntent.setMessage("If you like this app , please support us and leave a comment.");
    paramIntent.setPositiveButton("Ok", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.troll.face"));
        MyGalleryShowImage.this.startActivity(paramAnonymousDialogInterface);
      }
    });
    paramIntent.setNegativeButton("No", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    paramIntent.setNeutralButton("Later", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    paramIntent.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2130903046);
    getWindow().setFeatureInt(7, 2130903051);
    ctx = this;
    this.gestureScanner = new GestureDetector(this);
    getIntent();
    pkg = getPackageName();
    paramBundle = (MyApp)getApplication();
    this.iamgeUrl = paramBundle.getMySDCardSingleImagesAbsolutePath();
    mySDCardImagesAbsolutePath = paramBundle.getMySDCardImagesAbsolutePath();
    imagePosition = paramBundle.getPosition();
    wv = new MyWebView(this);
    wv = (MyWebView)findViewById(2131165203);
    wv.getSettings().setSupportZoom(false);
    wv.getSettings().setBuiltInZoomControls(false);
    wv.setVerticalScrollBarEnabled(false);
    wv.setHorizontalScrollBarEnabled(false);
    wv.clearHistory();
    wv.clearCache(true);
    paramBundle = "<html><body  text=\"#232323\"><img src=\"file:///" + this.iamgeUrl + "\" style='width:100%;max-height:100%' >";
    wv.loadDataWithBaseURL("", paramBundle, "text/html", "utf-8", "");
    wv.setBackgroundColor(0);
    wv.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if ((MyGalleryShowImage.this.dialog != null) && (MyGalleryShowImage.this.dialog.isShowing())) {}
        try
        {
          MyGalleryShowImage.this.dialog.cancel();
          MyGalleryShowImage.this.dialog = null;
          MyGalleryShowImage.wv.setVisibility(1);
          return;
        }
        catch (Exception paramAnonymousWebView)
        {
          for (;;) {}
        }
      }
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        try
        {
          MyGalleryShowImage.this.dialog = new ProgressDialog(MyGalleryShowImage.this);
          MyGalleryShowImage.this.dialog.setCancelable(true);
          MyGalleryShowImage.this.dialog.setMessage("Loading Photo...");
          MyGalleryShowImage.this.dialog.show();
          return;
        }
        catch (Exception paramAnonymousWebView) {}
      }
    });
    if (Environment.getExternalStorageState().equalsIgnoreCase("MOUNTED")) {
      this.db = new DBAdapter(this);
    }
    ((ImageView)findViewById(2131165205)).setOnClickListener(this.shareListener);
    paramBundle = getBaseContext();
    Log.d("appContext", "appContext!");
    paramBundle = new LinearLayout(paramBundle);
    Log.d("layout", "layout!");
    paramBundle.setBackgroundColor(0);
    Log.d("Position", "ContecxLoading.getsInstance().getPosition()");
    paramBundle.setGravity(49);
    Log.d("Gravity", "CENTER | BOTTOM");
    Object localObject = AdSize.BANNER;
    Log.d("Size", "BANNER");
    addContentView(paramBundle, new AbsoluteLayout.LayoutParams(-1, -1, 1, 1));
    localObject = new AdView(this, (AdSize)localObject, "a1503f8ec6a9a4c");
    Log.d("AdView", "AdView!");
    ((AdView)localObject).setBackgroundColor(0);
    paramBundle.addView((View)localObject);
    Log.d("layout.adView", "layout.adView!");
    paramBundle = new AdRequest();
    Log.d("request", "request!");
    paramBundle.setTesting(true);
    Log.d("setTesting", "setTesting!");
    ((AdView)localObject).loadAd(paramBundle);
    Log.d("request", "request!");
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    try
    {
      if (Math.abs(paramMotionEvent1.getY() - paramMotionEvent2.getY()) > 250.0F) {
        return false;
      }
      if ((paramMotionEvent1.getX() - paramMotionEvent2.getX() > 120.0F) && (Math.abs(paramFloat1) > 200.0F)) {
        swipLeft();
      } else if ((paramMotionEvent2.getX() - paramMotionEvent1.getX() > 120.0F) && (Math.abs(paramFloat1) > 200.0F)) {
        swipRight();
      }
    }
    catch (Exception paramMotionEvent1) {}
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  protected void onPause()
  {
    super.onPause();
    finish();
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  protected void onStop()
  {
    super.onStop();
    finish();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.gestureScanner.onTouchEvent(paramMotionEvent);
  }
  
  public static class MyWebView
    extends WebView
  {
    Context context;
    long downTime;
    float downXValue;
    GestureDetector gd;
    private boolean hasMoved = false;
    private float lastTouchX;
    private float lastTouchY;
    GestureDetector.SimpleOnGestureListener sogl = new GestureDetector.SimpleOnGestureListener()
    {
      public boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        return super.onDown(paramAnonymousMotionEvent);
      }
    };
    
    public MyWebView(Context paramContext)
    {
      super();
      this.context = paramContext;
      this.gd = new GestureDetector(paramContext, this.sogl);
    }
    
    public MyWebView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      this.context = paramContext;
      this.gd = new GestureDetector(paramContext, this.sogl);
    }
    
    private boolean moved(MotionEvent paramMotionEvent)
    {
      return (this.hasMoved) || (Math.abs(paramMotionEvent.getX() - this.lastTouchX) > 10.0D) || (Math.abs(paramMotionEvent.getY() - this.lastTouchY) > 10.0D);
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if (isClickable()) {
        switch (paramMotionEvent.getAction())
        {
        }
      }
      while ((!bool) && (!isClickable()))
      {
        return false;
        this.lastTouchX = paramMotionEvent.getX();
        this.lastTouchY = paramMotionEvent.getY();
        this.downXValue = paramMotionEvent.getX();
        this.downTime = paramMotionEvent.getEventTime();
        this.hasMoved = false;
        continue;
        this.hasMoved = moved(paramMotionEvent);
        continue;
        float f1 = paramMotionEvent.getX();
        long l = paramMotionEvent.getEventTime();
        float f2 = Math.abs(this.downXValue - f1);
        l -= this.downTime;
        Log.i("Touch Event:", "Distance: " + f2 + "px Time: " + l + "ms");
        if ((this.downXValue < f1) && (l < 220L) && (f2 > 100.0F)) {
          MyGalleryShowImage.swipRight();
        }
        if ((this.downXValue > f1) && (l < 220L) && (f2 > 100.0F)) {
          MyGalleryShowImage.swipLeft();
        }
      }
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/troll/face/MyGalleryShowImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */