package com.jtpgodorncrqoeurl;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask.Status;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RemoteViews;
import android.widget.TextView;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class AdController
{
  public static final String EXIT = "exit";
  public static final String FULL_SCREEN = "fullscreen";
  public static final String LB_LOG = "LBAdController";
  public static final String STYLE_NORMAL = "normal";
  private Button A;
  private Button B;
  private Button C;
  private int D = 0;
  private int E;
  private int F;
  private boolean G = true;
  private String H;
  private List I;
  private int J = 0;
  private Handler K;
  private Runnable L;
  private boolean M = false;
  private boolean N = false;
  private int O = 0;
  private int P = 0;
  private int Q = 0;
  private boolean R = false;
  private AudioManager S;
  private MediaPlayer T;
  private SensorManager U;
  private FileInputStream V;
  private float W;
  private float X;
  private float Y;
  private int Z;
  protected Context a;
  private PendingIntent aa;
  private AlarmManager ab;
  private AdTask ac = null;
  private AdListener ad = null;
  private AdController ae = null;
  private AlertDialog af;
  private E ag;
  private Handler ah;
  private boolean ai = false;
  private AdWebView aj;
  private AdAudioTask ak = null;
  private AdAudioListener al;
  private boolean am = false;
  private boolean an = false;
  private String ao = null;
  private boolean ap = true;
  private boolean aq = false;
  private z ar = new z(this, true);
  private Handler as;
  private Runnable at;
  protected AdView b;
  private Activity c;
  private ViewGroup d;
  private View e;
  private WebView f;
  private String g;
  private boolean h;
  private JSONObject i;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private ProgressDialog o;
  private boolean p = false;
  private RelativeLayout q;
  private RelativeLayout.LayoutParams r;
  private ViewGroup.MarginLayoutParams s;
  private String t;
  private View u;
  private TextView v;
  private View w;
  private TextView x;
  private Button y;
  private Button z;
  
  public AdController(Activity paramActivity, String paramString)
  {
    this(paramActivity, paramString, new RelativeLayout(paramActivity));
  }
  
  public AdController(Activity paramActivity, String paramString, WebView paramWebView)
  {
    this.c = paramActivity;
    this.t = paramString;
    this.f = paramWebView;
    this.q = new RelativeLayout(this.c);
    paramActivity = paramActivity.getSharedPreferences("Preference", 0).edit();
    paramActivity.putString("sectionidMed", "");
    paramActivity.putString("sectionidLrg", "");
    paramActivity.putString("sectionidXLrg", "");
    paramActivity.commit();
    a();
  }
  
  public AdController(Activity paramActivity, String paramString, RelativeLayout paramRelativeLayout)
  {
    this.c = paramActivity;
    this.t = paramString;
    paramString = paramRelativeLayout;
    if (paramRelativeLayout == null) {
      paramString = new RelativeLayout(paramActivity);
    }
    this.q = paramString;
    this.f = null;
    paramActivity = paramActivity.getSharedPreferences("Preference", 0).edit();
    paramActivity.putString("sectionidMed", "");
    paramActivity.putString("sectionidLrg", "");
    paramActivity.putString("sectionidXLrg", "");
    paramActivity.commit();
    a();
  }
  
  public AdController(Activity paramActivity, String paramString, AdAudioListener paramAdAudioListener)
  {
    this(paramActivity, paramString, new RelativeLayout(paramActivity));
    this.al = paramAdAudioListener;
    paramActivity = paramActivity.getSharedPreferences("Preference", 0).edit();
    paramActivity.putString("sectionidMed", "");
    paramActivity.putString("sectionidLrg", "");
    paramActivity.putString("sectionidXLrg", "");
    paramActivity.commit();
  }
  
  public AdController(Activity paramActivity, String paramString, AdListener paramAdListener)
  {
    this(paramActivity, paramString, new RelativeLayout(paramActivity));
    this.ad = paramAdListener;
    paramActivity = paramActivity.getSharedPreferences("Preference", 0).edit();
    paramActivity.putString("sectionidMed", "");
    paramActivity.putString("sectionidLrg", "");
    paramActivity.putString("sectionidXLrg", "");
    paramActivity.commit();
  }
  
  public AdController(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.t = paramString;
    paramContext = paramContext.getSharedPreferences("Preference", 0).edit();
    paramContext.putString("sectionidMed", "");
    paramContext.putString("sectionidLrg", "");
    paramContext.putString("sectionidXLrg", "");
    paramContext.commit();
    a();
  }
  
  public AdController(AdView paramAdView, Context paramContext)
  {
    this.b = paramAdView;
    this.a = paramContext;
  }
  
  private Animation a(String paramString, boolean paramBoolean)
  {
    int i1 = 0;
    int i3 = 1;
    float f5 = 0.0F;
    for (;;)
    {
      int i2;
      int i4;
      int i5;
      try
      {
        i2 = this.i.getInt("windowwidth");
        int i6 = this.i.getInt("windowheight");
        i4 = this.i.getInt("windowx");
        i5 = this.i.getInt("windowy");
        Object localObject2;
        if (paramString.equals("fade"))
        {
          i2 = 1;
          f1 = 0.0F;
          f2 = 0.0F;
          break label405;
          if (i1 == 0) {
            continue;
          }
          Object localObject1;
          localObject2 = new TranslateAnimation(f2, f5, f1, localObject1);
          paramString = (String)localObject2;
        }
        try
        {
          ((Animation)localObject2).setDuration(500L);
          return (Animation)localObject2;
        }
        catch (Exception localException)
        {
          return paramString;
        }
        if (paramString.equals("slideleft"))
        {
          f2 = 0 - i2;
          i2 = 0;
          f1 = 0.0F;
          i1 = 1;
          break label405;
        }
        if (paramString.equals("slideright"))
        {
          f2 = i2 + i4;
          i2 = 0;
          f1 = 0.0F;
          i1 = 1;
          break label405;
        }
        if (paramString.equals("slidedown"))
        {
          f1 = 0 - i6;
          i2 = 0;
          f2 = 0.0F;
          i1 = 1;
          break label405;
        }
        if (paramString.equals("slideup"))
        {
          f1 = i6;
          i2 = 0;
          f2 = 0.0F;
          i1 = 1;
          break label405;
        }
        if (paramString.equals("slidetopleft"))
        {
          f2 = 0 - i2;
          f1 = 0 - i6;
          i2 = 0;
          i1 = 1;
          break label405;
        }
        if (paramString.equals("slidetopright"))
        {
          f2 = i2 + i4;
          f1 = 0 - i6;
          i2 = 0;
          i1 = 1;
          break label405;
        }
        if (paramString.equals("slidebottomleft"))
        {
          f2 = 0 - i2;
          f1 = i6;
          i2 = 0;
          i1 = 1;
          break label405;
        }
        if (!paramString.equals("slidebottomright")) {
          break label397;
        }
        f2 = i2 + i4;
        f1 = i6;
        i2 = 0;
        i1 = 1;
        break label405;
        if (i2 != 0)
        {
          localObject2 = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F);
          paramString = (String)localObject2;
          ((Animation)localObject2).setDuration(500L);
          return (Animation)localObject2;
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
      return null;
      label397:
      label405:
      do
      {
        f3 = 0.0F;
        break;
        i2 = 0;
        f1 = 0.0F;
        f2 = 0.0F;
      } while (!paramBoolean);
      float f4 = i4;
      f5 = i5;
      i1 = i3;
      float f3 = f1;
      float f1 = f5;
      f5 = f2;
      float f2 = f4;
    }
  }
  
  protected static Object a(JSONObject paramJSONObject, Class paramClass)
  {
    Field[] arrayOfField = paramClass.getDeclaredFields();
    paramClass = paramClass.newInstance();
    int i2 = 0;
    String str2;
    if (i2 < arrayOfField.length)
    {
      Field localField = arrayOfField[i2];
      String str1 = localField.getName().replace('_', '-');
      str2 = localField.getType().toString();
      for (;;)
      {
        try
        {
          if (!str2.equals("int")) {
            continue;
          }
          str1 = paramJSONObject.getString(str1).toLowerCase();
          boolean bool = str1.startsWith("#");
          if (!bool) {
            continue;
          }
        }
        catch (JSONException localJSONException)
        {
          int i1;
          AdLog.printStackTrace("LBAdController", localJSONException);
          continue;
          if (!str2.equals("boolean")) {
            continue;
          }
          localJSONException.set(paramClass, Boolean.valueOf(paramJSONObject.getBoolean(localNumberFormatException)));
          continue;
          if (!str2.equals("float")) {
            continue;
          }
          localJSONException.set(paramClass, Float.valueOf(Float.parseFloat(paramJSONObject.getString(localNumberFormatException))));
          continue;
          if (!str2.equals("class com.jtpgodorncrqoeurl.AdNavigationStringEnum")) {
            continue;
          }
          localJSONException.set(paramClass, AdNavigationStringEnum.fromString(paramJSONObject.getString(localNumberFormatException)));
          continue;
          if (!str2.equals("class com.jtpgodorncrqoeurl.AdTransitionStringEnum")) {
            continue;
          }
          localJSONException.set(paramClass, AdTransitionStringEnum.fromString(paramJSONObject.getString(localNumberFormatException)));
          continue;
        }
        try
        {
          if (str1.startsWith("#0x"))
          {
            i1 = Integer.decode(str1.substring(1)).intValue();
            localField.set(paramClass, Integer.valueOf(i1));
            i2 += 1;
            break;
          }
          i1 = Integer.parseInt(str1.substring(1), 16);
          continue;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          AdLog.printStackTrace("LBAdController", localNumberFormatException);
          i1 = -1;
          continue;
        }
        i1 = Integer.parseInt(localNumberFormatException);
        continue;
        if (!str2.equals("class java.lang.String")) {
          continue;
        }
        localField.set(paramClass, paramJSONObject.getString(localNumberFormatException));
      }
    }
    return paramClass;
  }
  
  private void a()
  {
    Object localObject;
    if (this.c != null)
    {
      localObject = this.c;
      if (((Context)localObject).getSharedPreferences("Preference", 0).getString("SD_CONTEXTS", null) == null) {
        break label63;
      }
    }
    label63:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0) {
        new B(this, (Context)localObject).execute(new Void[0]);
      }
      return;
      localObject = this.a;
      break;
    }
  }
  
  private boolean a(Context paramContext, int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, NotificationManager paramNotificationManager, PendingIntent paramPendingIntent, RemoteViews paramRemoteViews)
  {
    AdLog.d("LBAdController", "triggerNotification Called");
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        paramCharSequence1 = new Notification(paramInt, paramCharSequence1, l1);
        paramCharSequence1.flags |= 0x10;
        if (paramRemoteViews == null) {
          continue;
        }
        paramCharSequence1.contentIntent = paramPendingIntent;
        paramCharSequence1.contentView = paramRemoteViews;
        paramNotificationManager.notify(800, paramCharSequence1);
        AdLog.i("LBAdController", "increment counter called");
        if (this.c == null) {
          continue;
        }
        paramContext = this.c;
      }
      catch (Exception paramContext)
      {
        return false;
        paramContext = this.a;
        continue;
      }
      finally
      {
        AdWakeLock.release();
      }
      paramContext = paramContext.getSharedPreferences("Preference", 0);
      paramCharSequence1 = paramContext.edit();
      paramInt = paramContext.getInt("SD_ITERATION_COUNTER_" + this.t, 0);
      paramCharSequence1.putInt("SD_ITERATION_COUNTER_" + this.t, paramInt + 1);
      paramCharSequence1.commit();
      AdWakeLock.release();
      return true;
      paramCharSequence1.setLatestEventInfo(paramContext, paramCharSequence2, paramCharSequence3, paramPendingIntent);
    }
  }
  
  private void b()
  {
    if ((this.G) && (adShowStatus().equals("hidden")))
    {
      AdLog.d("LBAdController", "Ad paused, will not show");
      if (this.ad != null) {}
      try
      {
        AdLog.i("LBAdController", "onAdPaused triggered");
        this.ad.onAdPaused();
        return;
      }
      catch (Exception localException)
      {
        AdLog.i("LBAdController", "Error while calling onAdPaused");
        AdLog.printStackTrace("LBAdController", localException);
        return;
      }
    }
    AdLog.i("LBAdController", "initializing...");
    int i1;
    if (this.ac != null)
    {
      AdLog.i("LBAdController", "AdTask status - " + this.ac.getStatus());
      if (this.ac.getStatus() == AsyncTask.Status.FINISHED) {
        i1 = 1;
      }
    }
    for (;;)
    {
      if (i1 != 0)
      {
        String str = "ad";
        if (this.am) {
          str = "audio";
        }
        AdLog.i("LBAdController", "Going to make request..." + str);
        if (this.am)
        {
          str = "audio";
          label179:
          if (this.c == null) {
            break label272;
          }
        }
        label272:
        for (Object localObject = this.c;; localObject = this.a)
        {
          this.ac = new AdTask(this, (Context)localObject, this.t, str);
          this.ac.setSubId(this.H);
          this.ac.setTokens(this.I);
          this.ac.setUseLocation(this.m);
          this.ac.execute(new String[] { "" });
          return;
          i1 = 0;
          break;
          str = "ad";
          break label179;
        }
      }
      AdLog.i("LBAdController", "No request to be made - Request in progress");
      return;
      i1 = 1;
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: ldc 14
    //   2: ldc_w 666
    //   5: invokestatic 552	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   12: ifnonnull +12 -> 24
    //   15: ldc 14
    //   17: ldc_w 668
    //   20: invokestatic 545	com/jtpgodorncrqoeurl/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: return
    //   24: aload_0
    //   25: getfield 181	com/jtpgodorncrqoeurl/AdController:ao	Ljava/lang/String;
    //   28: ifnonnull +11 -> 39
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 196	com/jtpgodorncrqoeurl/AdController:t	Ljava/lang/String;
    //   36: putfield 181	com/jtpgodorncrqoeurl/AdController:ao	Ljava/lang/String;
    //   39: aload_0
    //   40: new 530	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 669	java/lang/StringBuilder:<init>	()V
    //   47: aload_0
    //   48: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   51: ldc_w 671
    //   54: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   57: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_0
    //   61: getfield 181	com/jtpgodorncrqoeurl/AdController:ao	Ljava/lang/String;
    //   64: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: putfield 673	com/jtpgodorncrqoeurl/AdController:g	Ljava/lang/String;
    //   73: aconst_null
    //   74: astore 13
    //   76: aload_0
    //   77: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   80: ldc_w 675
    //   83: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   86: astore 14
    //   88: aload 14
    //   90: astore 13
    //   92: aload_0
    //   93: getfield 489	com/jtpgodorncrqoeurl/AdController:aj	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   96: ifnull +71 -> 167
    //   99: aload_0
    //   100: getfield 183	com/jtpgodorncrqoeurl/AdController:ap	Z
    //   103: ifne +10 -> 113
    //   106: aload_0
    //   107: getfield 141	com/jtpgodorncrqoeurl/AdController:l	Z
    //   110: ifeq +57 -> 167
    //   113: aload_0
    //   114: getfield 673	com/jtpgodorncrqoeurl/AdController:g	Ljava/lang/String;
    //   117: ifnull +2064 -> 2181
    //   120: aload_0
    //   121: getfield 673	com/jtpgodorncrqoeurl/AdController:g	Ljava/lang/String;
    //   124: ldc -38
    //   126: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   129: ifne +2052 -> 2181
    //   132: ldc 14
    //   134: ldc_w 677
    //   137: invokestatic 552	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload_0
    //   141: getfield 489	com/jtpgodorncrqoeurl/AdController:aj	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   144: aload_0
    //   145: getfield 673	com/jtpgodorncrqoeurl/AdController:g	Ljava/lang/String;
    //   148: invokevirtual 682	com/jtpgodorncrqoeurl/AdWebView:setLoadingURL	(Ljava/lang/String;)V
    //   151: aload_0
    //   152: getfield 489	com/jtpgodorncrqoeurl/AdController:aj	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   155: aload_0
    //   156: getfield 673	com/jtpgodorncrqoeurl/AdController:g	Ljava/lang/String;
    //   159: invokevirtual 685	com/jtpgodorncrqoeurl/AdWebView:loadUrl	(Ljava/lang/String;)V
    //   162: aload_0
    //   163: iconst_1
    //   164: putfield 687	com/jtpgodorncrqoeurl/AdController:h	Z
    //   167: aload_0
    //   168: getfield 183	com/jtpgodorncrqoeurl/AdController:ap	Z
    //   171: ifne -148 -> 23
    //   174: aload_0
    //   175: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   178: ldc_w 689
    //   181: invokevirtual 692	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   184: ifne +80 -> 264
    //   187: aload_0
    //   188: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   191: ldc_w 689
    //   194: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   197: ldc_w 694
    //   200: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   203: ifeq +61 -> 264
    //   206: aload_0
    //   207: iconst_0
    //   208: putfield 687	com/jtpgodorncrqoeurl/AdController:h	Z
    //   211: aload_0
    //   212: iconst_0
    //   213: putfield 141	com/jtpgodorncrqoeurl/AdController:l	Z
    //   216: ldc 14
    //   218: ldc_w 696
    //   221: invokestatic 523	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload_0
    //   225: invokespecial 698	com/jtpgodorncrqoeurl/AdController:d	()V
    //   228: return
    //   229: astore 13
    //   231: ldc 14
    //   233: aload 13
    //   235: invokestatic 423	com/jtpgodorncrqoeurl/AdLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   238: ldc 14
    //   240: new 530	java/lang/StringBuilder
    //   243: dup
    //   244: ldc_w 700
    //   247: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   250: aload 13
    //   252: invokevirtual 538	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   255: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 545	com/jtpgodorncrqoeurl/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload_0
    //   265: getfield 139	com/jtpgodorncrqoeurl/AdController:k	Z
    //   268: ifne -245 -> 23
    //   271: ldc 14
    //   273: ldc_w 702
    //   276: invokestatic 552	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: aload_0
    //   280: iconst_1
    //   281: putfield 139	com/jtpgodorncrqoeurl/AdController:k	Z
    //   284: aload_0
    //   285: iconst_0
    //   286: putfield 141	com/jtpgodorncrqoeurl/AdController:l	Z
    //   289: aload_0
    //   290: iconst_1
    //   291: putfield 687	com/jtpgodorncrqoeurl/AdController:h	Z
    //   294: aload_0
    //   295: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   298: ldc_w 704
    //   301: invokevirtual 708	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   304: ldc_w 694
    //   307: invokevirtual 709	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   310: ifeq +2222 -> 2532
    //   313: aload_0
    //   314: invokespecial 711	com/jtpgodorncrqoeurl/AdController:i	()V
    //   317: aload_0
    //   318: getfield 137	com/jtpgodorncrqoeurl/AdController:j	Z
    //   321: istore 12
    //   323: iload 12
    //   325: ifne +2197 -> 2522
    //   328: aload_0
    //   329: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   332: aload_0
    //   333: getfield 489	com/jtpgodorncrqoeurl/AdController:aj	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   336: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   339: aload_0
    //   340: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   343: aload_0
    //   344: getfield 495	com/jtpgodorncrqoeurl/AdController:u	Landroid/view/View;
    //   347: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   350: aload_0
    //   351: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   354: aload_0
    //   355: getfield 497	com/jtpgodorncrqoeurl/AdController:v	Landroid/widget/TextView;
    //   358: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   361: aload_0
    //   362: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   365: aload_0
    //   366: getfield 499	com/jtpgodorncrqoeurl/AdController:w	Landroid/view/View;
    //   369: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   372: aload_0
    //   373: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   376: aload_0
    //   377: getfield 501	com/jtpgodorncrqoeurl/AdController:x	Landroid/widget/TextView;
    //   380: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   383: aload_0
    //   384: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   387: aload_0
    //   388: getfield 503	com/jtpgodorncrqoeurl/AdController:y	Landroid/widget/Button;
    //   391: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   394: aload_0
    //   395: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   398: aload_0
    //   399: getfield 505	com/jtpgodorncrqoeurl/AdController:z	Landroid/widget/Button;
    //   402: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   405: aload_0
    //   406: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   409: aload_0
    //   410: getfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   413: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   416: aload_0
    //   417: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   420: aload_0
    //   421: getfield 509	com/jtpgodorncrqoeurl/AdController:B	Landroid/widget/Button;
    //   424: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   427: aload_0
    //   428: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   431: aconst_null
    //   432: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   435: aload_0
    //   436: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   439: aload_0
    //   440: getfield 511	com/jtpgodorncrqoeurl/AdController:e	Landroid/view/View;
    //   443: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   446: aload_0
    //   447: getfield 713	com/jtpgodorncrqoeurl/AdController:C	Landroid/widget/Button;
    //   450: ifnull +10 -> 460
    //   453: aload_0
    //   454: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   457: invokevirtual 716	android/widget/RelativeLayout:removeAllViews	()V
    //   460: aload_0
    //   461: new 483	android/view/View
    //   464: dup
    //   465: aload_0
    //   466: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   469: invokespecial 717	android/view/View:<init>	(Landroid/content/Context;)V
    //   472: putfield 511	com/jtpgodorncrqoeurl/AdController:e	Landroid/view/View;
    //   475: aload_0
    //   476: getfield 511	com/jtpgodorncrqoeurl/AdController:e	Landroid/view/View;
    //   479: iconst_m1
    //   480: invokevirtual 720	android/view/View:setMinimumHeight	(I)V
    //   483: aload_0
    //   484: getfield 511	com/jtpgodorncrqoeurl/AdController:e	Landroid/view/View;
    //   487: iconst_m1
    //   488: invokevirtual 723	android/view/View:setMinimumWidth	(I)V
    //   491: aload_0
    //   492: getfield 511	com/jtpgodorncrqoeurl/AdController:e	Landroid/view/View;
    //   495: ldc_w 724
    //   498: invokevirtual 727	android/view/View:setBackgroundColor	(I)V
    //   501: aload_0
    //   502: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   505: ldc_w 729
    //   508: invokevirtual 733	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   511: dstore_1
    //   512: aload_0
    //   513: getfield 511	com/jtpgodorncrqoeurl/AdController:e	Landroid/view/View;
    //   516: invokevirtual 737	android/view/View:getBackground	()Landroid/graphics/drawable/Drawable;
    //   519: dload_1
    //   520: ldc2_w 738
    //   523: dmul
    //   524: d2i
    //   525: invokevirtual 744	android/graphics/drawable/Drawable:setAlpha	(I)V
    //   528: aload_0
    //   529: getfield 511	com/jtpgodorncrqoeurl/AdController:e	Landroid/view/View;
    //   532: new 746	com/jtpgodorncrqoeurl/t
    //   535: dup
    //   536: aload_0
    //   537: invokespecial 748	com/jtpgodorncrqoeurl/t:<init>	(Lcom/jtpgodorncrqoeurl/AdController;)V
    //   540: invokevirtual 752	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   543: new 754	android/view/ViewGroup$MarginLayoutParams
    //   546: dup
    //   547: iconst_m1
    //   548: iconst_m1
    //   549: invokespecial 757	android/view/ViewGroup$MarginLayoutParams:<init>	(II)V
    //   552: astore 13
    //   554: aload 13
    //   556: iconst_0
    //   557: iconst_0
    //   558: iconst_0
    //   559: iconst_0
    //   560: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   563: new 763	android/widget/RelativeLayout$LayoutParams
    //   566: dup
    //   567: aload 13
    //   569: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   572: astore 17
    //   574: aload_0
    //   575: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   578: ldc_w 299
    //   581: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   584: istore 5
    //   586: ldc_w 768
    //   589: astore 13
    //   591: aload_0
    //   592: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   595: ldc_w 770
    //   598: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   601: astore 14
    //   603: aload 14
    //   605: astore 13
    //   607: iload 5
    //   609: istore 4
    //   611: aload_0
    //   612: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   615: ldc_w 772
    //   618: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   621: ifne +156 -> 777
    //   624: aload_0
    //   625: getfield 489	com/jtpgodorncrqoeurl/AdController:aj	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   628: astore 14
    //   630: aload 14
    //   632: ifnull +30 -> 662
    //   635: aload_0
    //   636: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   639: ldc_w 774
    //   642: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   645: ldc_w 694
    //   648: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   651: ifeq +11 -> 662
    //   654: aload_0
    //   655: getfield 489	com/jtpgodorncrqoeurl/AdController:aj	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   658: iconst_0
    //   659: invokevirtual 775	com/jtpgodorncrqoeurl/AdWebView:setBackgroundColor	(I)V
    //   662: aload_0
    //   663: getfield 247	com/jtpgodorncrqoeurl/AdController:b	Lcom/jtpgodorncrqoeurl/AdView;
    //   666: astore 14
    //   668: aload 14
    //   670: ifnull +30 -> 700
    //   673: aload_0
    //   674: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   677: ldc_w 774
    //   680: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   683: ldc_w 694
    //   686: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   689: ifeq +11 -> 700
    //   692: aload_0
    //   693: getfield 247	com/jtpgodorncrqoeurl/AdController:b	Lcom/jtpgodorncrqoeurl/AdView;
    //   696: iconst_0
    //   697: invokevirtual 778	com/jtpgodorncrqoeurl/AdView:setBackgroundColor	(I)V
    //   700: iload 5
    //   702: istore 4
    //   704: aload_0
    //   705: getfield 149	com/jtpgodorncrqoeurl/AdController:D	I
    //   708: ifle +69 -> 777
    //   711: iload 5
    //   713: istore 4
    //   715: aload 13
    //   717: ldc_w 768
    //   720: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   723: ifne +54 -> 777
    //   726: ldc 14
    //   728: new 530	java/lang/StringBuilder
    //   731: dup
    //   732: ldc_w 780
    //   735: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   738: aload_0
    //   739: getfield 149	com/jtpgodorncrqoeurl/AdController:D	I
    //   742: invokevirtual 783	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   745: ldc_w 785
    //   748: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   754: invokestatic 523	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   757: aload 13
    //   759: ldc_w 787
    //   762: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   765: ifeq +1536 -> 2301
    //   768: iload 5
    //   770: aload_0
    //   771: getfield 149	com/jtpgodorncrqoeurl/AdController:D	I
    //   774: iadd
    //   775: istore 4
    //   777: new 754	android/view/ViewGroup$MarginLayoutParams
    //   780: dup
    //   781: aload_0
    //   782: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   785: ldc_w 287
    //   788: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   791: aload_0
    //   792: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   795: ldc_w 295
    //   798: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   801: invokespecial 757	android/view/ViewGroup$MarginLayoutParams:<init>	(II)V
    //   804: astore 13
    //   806: aload 13
    //   808: aload_0
    //   809: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   812: ldc_w 297
    //   815: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   818: iload 4
    //   820: iconst_0
    //   821: iconst_0
    //   822: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   825: new 763	android/widget/RelativeLayout$LayoutParams
    //   828: dup
    //   829: aload 13
    //   831: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   834: astore 18
    //   836: aload_0
    //   837: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   840: ldc_w 789
    //   843: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   846: istore 4
    //   848: aload_0
    //   849: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   852: ldc_w 791
    //   855: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   858: istore 5
    //   860: aload_0
    //   861: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   864: ldc_w 793
    //   867: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   870: istore 6
    //   872: aload_0
    //   873: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   876: ldc_w 795
    //   879: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   882: istore 7
    //   884: new 754	android/view/ViewGroup$MarginLayoutParams
    //   887: dup
    //   888: iload 6
    //   890: iload 7
    //   892: invokespecial 757	android/view/ViewGroup$MarginLayoutParams:<init>	(II)V
    //   895: astore 13
    //   897: aload 13
    //   899: iload 4
    //   901: iload 5
    //   903: iconst_0
    //   904: iconst_0
    //   905: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   908: new 763	android/widget/RelativeLayout$LayoutParams
    //   911: dup
    //   912: aload 13
    //   914: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   917: astore 19
    //   919: aload_0
    //   920: new 483	android/view/View
    //   923: dup
    //   924: aload_0
    //   925: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   928: invokespecial 717	android/view/View:<init>	(Landroid/content/Context;)V
    //   931: putfield 495	com/jtpgodorncrqoeurl/AdController:u	Landroid/view/View;
    //   934: aload_0
    //   935: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   938: ldc_w 797
    //   941: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   944: astore 13
    //   946: aload 13
    //   948: ldc -38
    //   950: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   953: ifne +1694 -> 2647
    //   956: aload 13
    //   958: ifnonnull +1686 -> 2644
    //   961: goto +1686 -> 2647
    //   964: aload_0
    //   965: getfield 495	com/jtpgodorncrqoeurl/AdController:u	Landroid/view/View;
    //   968: aload 13
    //   970: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   973: invokevirtual 727	android/view/View:setBackgroundColor	(I)V
    //   976: aload_0
    //   977: new 804	android/widget/TextView
    //   980: dup
    //   981: aload_0
    //   982: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   985: invokespecial 805	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   988: putfield 497	com/jtpgodorncrqoeurl/AdController:v	Landroid/widget/TextView;
    //   991: aload_0
    //   992: getfield 497	com/jtpgodorncrqoeurl/AdController:v	Landroid/widget/TextView;
    //   995: aload_0
    //   996: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   999: ldc_w 807
    //   1002: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1005: invokevirtual 811	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1008: aload_0
    //   1009: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1012: ldc_w 813
    //   1015: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1018: astore 14
    //   1020: aload 14
    //   1022: ldc -38
    //   1024: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1027: ifne +1628 -> 2655
    //   1030: aload 14
    //   1032: ifnonnull +1609 -> 2641
    //   1035: goto +1620 -> 2655
    //   1038: aload_0
    //   1039: getfield 497	com/jtpgodorncrqoeurl/AdController:v	Landroid/widget/TextView;
    //   1042: aload 14
    //   1044: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1047: invokevirtual 816	android/widget/TextView:setTextColor	(I)V
    //   1050: aload_0
    //   1051: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1054: ldc_w 818
    //   1057: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1060: istore 8
    //   1062: new 754	android/view/ViewGroup$MarginLayoutParams
    //   1065: dup
    //   1066: aload_0
    //   1067: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1070: ldc_w 820
    //   1073: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1076: iload 8
    //   1078: invokespecial 757	android/view/ViewGroup$MarginLayoutParams:<init>	(II)V
    //   1081: astore 15
    //   1083: aload 15
    //   1085: iload 4
    //   1087: bipush 20
    //   1089: iadd
    //   1090: iload 7
    //   1092: iload 8
    //   1094: isub
    //   1095: iconst_2
    //   1096: idiv
    //   1097: iload 5
    //   1099: iadd
    //   1100: iconst_4
    //   1101: iadd
    //   1102: iconst_0
    //   1103: iconst_0
    //   1104: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   1107: new 763	android/widget/RelativeLayout$LayoutParams
    //   1110: dup
    //   1111: aload 15
    //   1113: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   1116: astore 20
    //   1118: aload_0
    //   1119: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1122: ldc_w 822
    //   1125: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1128: istore 8
    //   1130: aload_0
    //   1131: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1134: ldc_w 824
    //   1137: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1140: istore 9
    //   1142: aload_0
    //   1143: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1146: ldc_w 826
    //   1149: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1152: istore 10
    //   1154: new 754	android/view/ViewGroup$MarginLayoutParams
    //   1157: dup
    //   1158: aload_0
    //   1159: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1162: ldc_w 828
    //   1165: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1168: iload 10
    //   1170: invokespecial 757	android/view/ViewGroup$MarginLayoutParams:<init>	(II)V
    //   1173: astore 15
    //   1175: aload 15
    //   1177: iload 8
    //   1179: iload 9
    //   1181: iconst_0
    //   1182: iconst_0
    //   1183: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   1186: new 763	android/widget/RelativeLayout$LayoutParams
    //   1189: dup
    //   1190: aload 15
    //   1192: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   1195: astore 21
    //   1197: aload_0
    //   1198: new 483	android/view/View
    //   1201: dup
    //   1202: aload_0
    //   1203: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   1206: invokespecial 717	android/view/View:<init>	(Landroid/content/Context;)V
    //   1209: putfield 499	com/jtpgodorncrqoeurl/AdController:w	Landroid/view/View;
    //   1212: aload_0
    //   1213: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1216: ldc_w 830
    //   1219: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1222: astore 16
    //   1224: aload 16
    //   1226: ldc -38
    //   1228: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1231: ifne +1432 -> 2663
    //   1234: aload 16
    //   1236: astore 15
    //   1238: aload 16
    //   1240: ifnonnull +6 -> 1246
    //   1243: goto +1420 -> 2663
    //   1246: aload_0
    //   1247: getfield 499	com/jtpgodorncrqoeurl/AdController:w	Landroid/view/View;
    //   1250: aload 15
    //   1252: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1255: invokevirtual 727	android/view/View:setBackgroundColor	(I)V
    //   1258: aload_0
    //   1259: new 804	android/widget/TextView
    //   1262: dup
    //   1263: aload_0
    //   1264: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   1267: invokespecial 805	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   1270: putfield 501	com/jtpgodorncrqoeurl/AdController:x	Landroid/widget/TextView;
    //   1273: aload_0
    //   1274: getfield 501	com/jtpgodorncrqoeurl/AdController:x	Landroid/widget/TextView;
    //   1277: aload_0
    //   1278: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1281: ldc_w 832
    //   1284: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1287: invokevirtual 811	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1290: aload_0
    //   1291: getfield 501	com/jtpgodorncrqoeurl/AdController:x	Landroid/widget/TextView;
    //   1294: ldc_w 833
    //   1297: invokevirtual 837	android/widget/TextView:setTextSize	(F)V
    //   1300: aload_0
    //   1301: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1304: ldc_w 839
    //   1307: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1310: istore 11
    //   1312: aload_0
    //   1313: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1316: ldc_w 841
    //   1319: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1322: astore 16
    //   1324: aload 16
    //   1326: ldc -38
    //   1328: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1331: ifne +1340 -> 2671
    //   1334: aload 16
    //   1336: astore 15
    //   1338: aload 16
    //   1340: ifnonnull +6 -> 1346
    //   1343: goto +1328 -> 2671
    //   1346: aload_0
    //   1347: getfield 501	com/jtpgodorncrqoeurl/AdController:x	Landroid/widget/TextView;
    //   1350: aload 15
    //   1352: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1355: invokevirtual 816	android/widget/TextView:setTextColor	(I)V
    //   1358: new 754	android/view/ViewGroup$MarginLayoutParams
    //   1361: dup
    //   1362: aload_0
    //   1363: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1366: ldc_w 843
    //   1369: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1372: iload 11
    //   1374: invokespecial 757	android/view/ViewGroup$MarginLayoutParams:<init>	(II)V
    //   1377: astore 15
    //   1379: aload 15
    //   1381: iload 8
    //   1383: bipush 20
    //   1385: iadd
    //   1386: iload 9
    //   1388: iload 10
    //   1390: iload 11
    //   1392: isub
    //   1393: iconst_2
    //   1394: idiv
    //   1395: iadd
    //   1396: iconst_0
    //   1397: iconst_0
    //   1398: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   1401: new 763	android/widget/RelativeLayout$LayoutParams
    //   1404: dup
    //   1405: aload 15
    //   1407: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   1410: astore 15
    //   1412: iload 7
    //   1414: iconst_5
    //   1415: isub
    //   1416: iconst_0
    //   1417: invokestatic 849	java/lang/Math:max	(II)I
    //   1420: istore 8
    //   1422: iload 8
    //   1424: iconst_2
    //   1425: idiv
    //   1426: i2f
    //   1427: fstore_3
    //   1428: aload_0
    //   1429: new 851	android/widget/Button
    //   1432: dup
    //   1433: aload_0
    //   1434: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   1437: invokespecial 852	android/widget/Button:<init>	(Landroid/content/Context;)V
    //   1440: putfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   1443: aload_0
    //   1444: getfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   1447: ldc_w 853
    //   1450: invokevirtual 854	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   1453: aload_0
    //   1454: getfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   1457: fload_3
    //   1458: invokevirtual 855	android/widget/Button:setTextSize	(F)V
    //   1461: aload_0
    //   1462: getfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   1465: aload 14
    //   1467: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1470: invokevirtual 856	android/widget/Button:setTextColor	(I)V
    //   1473: aload_0
    //   1474: getfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   1477: iconst_0
    //   1478: iconst_0
    //   1479: iconst_0
    //   1480: iconst_0
    //   1481: invokevirtual 859	android/widget/Button:setPadding	(IIII)V
    //   1484: aload_0
    //   1485: getfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   1488: aload 13
    //   1490: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1493: invokevirtual 860	android/widget/Button:setBackgroundColor	(I)V
    //   1496: aload_0
    //   1497: getfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   1500: new 862	com/jtpgodorncrqoeurl/u
    //   1503: dup
    //   1504: aload_0
    //   1505: invokespecial 863	com/jtpgodorncrqoeurl/u:<init>	(Lcom/jtpgodorncrqoeurl/AdController;)V
    //   1508: invokevirtual 864	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1511: aload_0
    //   1512: new 754	android/view/ViewGroup$MarginLayoutParams
    //   1515: dup
    //   1516: bipush 55
    //   1518: iload 8
    //   1520: invokespecial 757	android/view/ViewGroup$MarginLayoutParams:<init>	(II)V
    //   1523: putfield 866	com/jtpgodorncrqoeurl/AdController:s	Landroid/view/ViewGroup$MarginLayoutParams;
    //   1526: iload 7
    //   1528: iload 8
    //   1530: isub
    //   1531: iconst_2
    //   1532: idiv
    //   1533: istore 7
    //   1535: aload_0
    //   1536: getfield 866	com/jtpgodorncrqoeurl/AdController:s	Landroid/view/ViewGroup$MarginLayoutParams;
    //   1539: iload 6
    //   1541: iload 4
    //   1543: iadd
    //   1544: bipush 55
    //   1546: isub
    //   1547: iconst_5
    //   1548: isub
    //   1549: iload 7
    //   1551: iload 5
    //   1553: iadd
    //   1554: iconst_2
    //   1555: iadd
    //   1556: iconst_0
    //   1557: iconst_0
    //   1558: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   1561: aload_0
    //   1562: new 763	android/widget/RelativeLayout$LayoutParams
    //   1565: dup
    //   1566: aload_0
    //   1567: getfield 866	com/jtpgodorncrqoeurl/AdController:s	Landroid/view/ViewGroup$MarginLayoutParams;
    //   1570: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   1573: putfield 868	com/jtpgodorncrqoeurl/AdController:r	Landroid/widget/RelativeLayout$LayoutParams;
    //   1576: aload_0
    //   1577: getfield 198	com/jtpgodorncrqoeurl/AdController:f	Landroid/webkit/WebView;
    //   1580: ifnull +39 -> 1619
    //   1583: aload_0
    //   1584: aload_0
    //   1585: getfield 198	com/jtpgodorncrqoeurl/AdController:f	Landroid/webkit/WebView;
    //   1588: invokevirtual 871	android/webkit/WebView:getParent	()Landroid/view/ViewParent;
    //   1591: checkcast 517	android/view/ViewGroup
    //   1594: putfield 873	com/jtpgodorncrqoeurl/AdController:d	Landroid/view/ViewGroup;
    //   1597: aload_0
    //   1598: getfield 873	com/jtpgodorncrqoeurl/AdController:d	Landroid/view/ViewGroup;
    //   1601: aload_0
    //   1602: getfield 198	com/jtpgodorncrqoeurl/AdController:f	Landroid/webkit/WebView;
    //   1605: invokevirtual 518	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   1608: aload_0
    //   1609: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   1612: aload_0
    //   1613: getfield 198	com/jtpgodorncrqoeurl/AdController:f	Landroid/webkit/WebView;
    //   1616: invokevirtual 876	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   1619: aload_0
    //   1620: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1623: ldc_w 878
    //   1626: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1629: iconst_1
    //   1630: if_icmpne +38 -> 1668
    //   1633: aload_0
    //   1634: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   1637: aload_0
    //   1638: getfield 511	com/jtpgodorncrqoeurl/AdController:e	Landroid/view/View;
    //   1641: aload 17
    //   1643: invokevirtual 881	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1646: aload_0
    //   1647: getfield 198	com/jtpgodorncrqoeurl/AdController:f	Landroid/webkit/WebView;
    //   1650: ifnull +18 -> 1668
    //   1653: aload_0
    //   1654: getfield 198	com/jtpgodorncrqoeurl/AdController:f	Landroid/webkit/WebView;
    //   1657: new 883	com/jtpgodorncrqoeurl/v
    //   1660: dup
    //   1661: aload_0
    //   1662: invokespecial 884	com/jtpgodorncrqoeurl/v:<init>	(Lcom/jtpgodorncrqoeurl/AdController;)V
    //   1665: invokevirtual 888	android/webkit/WebView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1668: aconst_null
    //   1669: astore 13
    //   1671: aload_0
    //   1672: aload_0
    //   1673: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1676: ldc_w 890
    //   1679: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1682: iconst_0
    //   1683: invokespecial 281	com/jtpgodorncrqoeurl/AdController:a	(Ljava/lang/String;Z)Landroid/view/animation/Animation;
    //   1686: astore 14
    //   1688: aload 14
    //   1690: astore 13
    //   1692: aload_0
    //   1693: getfield 185	com/jtpgodorncrqoeurl/AdController:aq	Z
    //   1696: ifeq +644 -> 2340
    //   1699: ldc 14
    //   1701: ldc_w 892
    //   1704: invokestatic 552	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1707: aload_0
    //   1708: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   1711: aload_0
    //   1712: getfield 247	com/jtpgodorncrqoeurl/AdController:b	Lcom/jtpgodorncrqoeurl/AdView;
    //   1715: aload 18
    //   1717: invokevirtual 881	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1720: aload 13
    //   1722: ifnull +29 -> 1751
    //   1725: aload_0
    //   1726: getfield 247	com/jtpgodorncrqoeurl/AdController:b	Lcom/jtpgodorncrqoeurl/AdView;
    //   1729: bipush 8
    //   1731: invokevirtual 893	com/jtpgodorncrqoeurl/AdView:setVisibility	(I)V
    //   1734: aload_0
    //   1735: getfield 247	com/jtpgodorncrqoeurl/AdController:b	Lcom/jtpgodorncrqoeurl/AdView;
    //   1738: aload 13
    //   1740: invokevirtual 897	com/jtpgodorncrqoeurl/AdView:startAnimation	(Landroid/view/animation/Animation;)V
    //   1743: aload_0
    //   1744: getfield 247	com/jtpgodorncrqoeurl/AdController:b	Lcom/jtpgodorncrqoeurl/AdView;
    //   1747: iconst_0
    //   1748: invokevirtual 893	com/jtpgodorncrqoeurl/AdView:setVisibility	(I)V
    //   1751: ldc_w 899
    //   1754: invokestatic 903	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1757: ldc_w 905
    //   1760: aconst_null
    //   1761: invokevirtual 909	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1764: aload_0
    //   1765: getfield 489	com/jtpgodorncrqoeurl/AdController:aj	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   1768: aconst_null
    //   1769: invokevirtual 915	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1772: pop
    //   1773: aload_0
    //   1774: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1777: ldc_w 772
    //   1780: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1783: iconst_1
    //   1784: if_icmpne +76 -> 1860
    //   1787: aload_0
    //   1788: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   1791: aload_0
    //   1792: getfield 495	com/jtpgodorncrqoeurl/AdController:u	Landroid/view/View;
    //   1795: aload 19
    //   1797: invokevirtual 881	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1800: aload_0
    //   1801: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1804: ldc_w 807
    //   1807: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1810: ldc -38
    //   1812: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1815: ifne +16 -> 1831
    //   1818: aload_0
    //   1819: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   1822: aload_0
    //   1823: getfield 497	com/jtpgodorncrqoeurl/AdController:v	Landroid/widget/TextView;
    //   1826: aload 20
    //   1828: invokevirtual 881	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1831: aload_0
    //   1832: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1835: ldc_w 917
    //   1838: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1841: iconst_1
    //   1842: if_icmpne +18 -> 1860
    //   1845: aload_0
    //   1846: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   1849: aload_0
    //   1850: getfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   1853: aload_0
    //   1854: getfield 868	com/jtpgodorncrqoeurl/AdController:r	Landroid/widget/RelativeLayout$LayoutParams;
    //   1857: invokevirtual 881	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1860: aload_0
    //   1861: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1864: ldc_w 919
    //   1867: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1870: iconst_1
    //   1871: if_icmpne +47 -> 1918
    //   1874: aload_0
    //   1875: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   1878: aload_0
    //   1879: getfield 499	com/jtpgodorncrqoeurl/AdController:w	Landroid/view/View;
    //   1882: aload 21
    //   1884: invokevirtual 881	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1887: aload_0
    //   1888: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1891: ldc_w 832
    //   1894: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1897: ldc -38
    //   1899: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1902: ifne +16 -> 1918
    //   1905: aload_0
    //   1906: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   1909: aload_0
    //   1910: getfield 501	com/jtpgodorncrqoeurl/AdController:x	Landroid/widget/TextView;
    //   1913: aload 15
    //   1915: invokevirtual 881	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1918: new 754	android/view/ViewGroup$MarginLayoutParams
    //   1921: dup
    //   1922: aload_0
    //   1923: getfield 921	com/jtpgodorncrqoeurl/AdController:E	I
    //   1926: aload_0
    //   1927: getfield 923	com/jtpgodorncrqoeurl/AdController:F	I
    //   1930: invokespecial 757	android/view/ViewGroup$MarginLayoutParams:<init>	(II)V
    //   1933: astore 13
    //   1935: aload 13
    //   1937: iconst_0
    //   1938: iconst_0
    //   1939: iconst_0
    //   1940: iconst_0
    //   1941: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   1944: new 763	android/widget/RelativeLayout$LayoutParams
    //   1947: dup
    //   1948: aload 13
    //   1950: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   1953: astore 13
    //   1955: aload_0
    //   1956: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   1959: aload_0
    //   1960: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   1963: aload 13
    //   1965: invokevirtual 926	android/app/Activity:addContentView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1968: aload_0
    //   1969: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1972: ldc_w 928
    //   1975: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1978: iconst_1
    //   1979: if_icmpne +511 -> 2490
    //   1982: aload_0
    //   1983: getfield 173	com/jtpgodorncrqoeurl/AdController:ai	Z
    //   1986: ifne +504 -> 2490
    //   1989: aload_0
    //   1990: getfield 159	com/jtpgodorncrqoeurl/AdController:O	I
    //   1993: aload_0
    //   1994: getfield 161	com/jtpgodorncrqoeurl/AdController:P	I
    //   1997: if_icmpgt +493 -> 2490
    //   2000: aload_0
    //   2001: getfield 159	com/jtpgodorncrqoeurl/AdController:O	I
    //   2004: aload_0
    //   2005: getfield 163	com/jtpgodorncrqoeurl/AdController:Q	I
    //   2008: if_icmpge +482 -> 2490
    //   2011: ldc 14
    //   2013: ldc_w 930
    //   2016: invokestatic 552	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2019: aload_0
    //   2020: iconst_1
    //   2021: putfield 173	com/jtpgodorncrqoeurl/AdController:ai	Z
    //   2024: aload_0
    //   2025: new 932	com/jtpgodorncrqoeurl/E
    //   2028: dup
    //   2029: aload_0
    //   2030: invokespecial 933	com/jtpgodorncrqoeurl/E:<init>	(Lcom/jtpgodorncrqoeurl/AdController;)V
    //   2033: putfield 342	com/jtpgodorncrqoeurl/AdController:ag	Lcom/jtpgodorncrqoeurl/E;
    //   2036: aload_0
    //   2037: new 935	android/os/Handler
    //   2040: dup
    //   2041: invokespecial 936	android/os/Handler:<init>	()V
    //   2044: putfield 277	com/jtpgodorncrqoeurl/AdController:ah	Landroid/os/Handler;
    //   2047: ldc 14
    //   2049: new 530	java/lang/StringBuilder
    //   2052: dup
    //   2053: ldc_w 938
    //   2056: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2059: aload_0
    //   2060: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   2063: ldc_w 940
    //   2066: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   2069: invokevirtual 783	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2072: ldc_w 941
    //   2075: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2078: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2081: invokestatic 552	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2084: aload_0
    //   2085: getfield 277	com/jtpgodorncrqoeurl/AdController:ah	Landroid/os/Handler;
    //   2088: aload_0
    //   2089: getfield 342	com/jtpgodorncrqoeurl/AdController:ag	Lcom/jtpgodorncrqoeurl/E;
    //   2092: aload_0
    //   2093: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   2096: ldc_w 940
    //   2099: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   2102: sipush 1000
    //   2105: imul
    //   2106: i2l
    //   2107: invokevirtual 945	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   2110: pop
    //   2111: return
    //   2112: astore 13
    //   2114: ldc 14
    //   2116: new 530	java/lang/StringBuilder
    //   2119: dup
    //   2120: ldc_w 947
    //   2123: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2126: aload 13
    //   2128: invokevirtual 538	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2131: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2134: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2137: invokestatic 545	com/jtpgodorncrqoeurl/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2140: ldc 14
    //   2142: aload 13
    //   2144: invokestatic 423	com/jtpgodorncrqoeurl/AdLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   2147: return
    //   2148: astore 13
    //   2150: aload_0
    //   2151: invokespecial 949	com/jtpgodorncrqoeurl/AdController:f	()V
    //   2154: ldc 14
    //   2156: new 530	java/lang/StringBuilder
    //   2159: dup
    //   2160: ldc_w 951
    //   2163: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2166: aload 13
    //   2168: invokevirtual 952	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2171: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2174: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2177: invokestatic 552	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2180: return
    //   2181: aload 13
    //   2183: ifnull -2016 -> 167
    //   2186: aload 13
    //   2188: ldc -38
    //   2190: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2193: ifne -2026 -> 167
    //   2196: aload_0
    //   2197: getfield 489	com/jtpgodorncrqoeurl/AdController:aj	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   2200: aload 13
    //   2202: ldc_w 954
    //   2205: ldc_w 956
    //   2208: invokevirtual 960	com/jtpgodorncrqoeurl/AdWebView:loadData	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2211: goto -2044 -> 167
    //   2214: astore 13
    //   2216: aload_0
    //   2217: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   2220: aload_0
    //   2221: getfield 247	com/jtpgodorncrqoeurl/AdController:b	Lcom/jtpgodorncrqoeurl/AdView;
    //   2224: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   2227: goto -1888 -> 339
    //   2230: astore 13
    //   2232: goto -1772 -> 460
    //   2235: astore 14
    //   2237: aload_0
    //   2238: getfield 489	com/jtpgodorncrqoeurl/AdController:aj	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   2241: iconst_0
    //   2242: invokevirtual 775	com/jtpgodorncrqoeurl/AdWebView:setBackgroundColor	(I)V
    //   2245: goto -1583 -> 662
    //   2248: astore 13
    //   2250: aload_0
    //   2251: invokespecial 949	com/jtpgodorncrqoeurl/AdController:f	()V
    //   2254: ldc 14
    //   2256: aload 13
    //   2258: invokestatic 423	com/jtpgodorncrqoeurl/AdLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   2261: ldc 14
    //   2263: new 530	java/lang/StringBuilder
    //   2266: dup
    //   2267: ldc_w 962
    //   2270: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2273: aload 13
    //   2275: invokevirtual 538	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2278: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2281: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2284: invokestatic 552	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2287: return
    //   2288: astore 14
    //   2290: aload_0
    //   2291: getfield 247	com/jtpgodorncrqoeurl/AdController:b	Lcom/jtpgodorncrqoeurl/AdView;
    //   2294: iconst_0
    //   2295: invokevirtual 778	com/jtpgodorncrqoeurl/AdView:setBackgroundColor	(I)V
    //   2298: goto -1598 -> 700
    //   2301: iload 5
    //   2303: istore 4
    //   2305: aload 13
    //   2307: ldc_w 964
    //   2310: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2313: ifeq -1536 -> 777
    //   2316: iload 5
    //   2318: aload_0
    //   2319: getfield 149	com/jtpgodorncrqoeurl/AdController:D	I
    //   2322: isub
    //   2323: istore 5
    //   2325: iload 5
    //   2327: istore 4
    //   2329: iload 5
    //   2331: ifge -1554 -> 777
    //   2334: iconst_0
    //   2335: istore 4
    //   2337: goto -1560 -> 777
    //   2340: ldc 14
    //   2342: ldc_w 966
    //   2345: invokestatic 552	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2348: aload_0
    //   2349: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   2352: aload_0
    //   2353: getfield 489	com/jtpgodorncrqoeurl/AdController:aj	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   2356: aload 18
    //   2358: invokevirtual 881	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   2361: aload 13
    //   2363: ifnull +29 -> 2392
    //   2366: aload_0
    //   2367: getfield 489	com/jtpgodorncrqoeurl/AdController:aj	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   2370: bipush 8
    //   2372: invokevirtual 967	com/jtpgodorncrqoeurl/AdWebView:setVisibility	(I)V
    //   2375: aload_0
    //   2376: getfield 489	com/jtpgodorncrqoeurl/AdController:aj	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   2379: aload 13
    //   2381: invokevirtual 968	com/jtpgodorncrqoeurl/AdWebView:startAnimation	(Landroid/view/animation/Animation;)V
    //   2384: aload_0
    //   2385: getfield 489	com/jtpgodorncrqoeurl/AdController:aj	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   2388: iconst_0
    //   2389: invokevirtual 967	com/jtpgodorncrqoeurl/AdWebView:setVisibility	(I)V
    //   2392: ldc_w 899
    //   2395: invokestatic 903	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   2398: ldc_w 905
    //   2401: aconst_null
    //   2402: invokevirtual 909	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   2405: aload_0
    //   2406: getfield 247	com/jtpgodorncrqoeurl/AdController:b	Lcom/jtpgodorncrqoeurl/AdView;
    //   2409: aconst_null
    //   2410: invokevirtual 915	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2413: pop
    //   2414: goto -641 -> 1773
    //   2417: astore 14
    //   2419: aload_0
    //   2420: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   2423: invokevirtual 515	android/widget/RelativeLayout:getParent	()Landroid/view/ViewParent;
    //   2426: checkcast 517	android/view/ViewGroup
    //   2429: aload_0
    //   2430: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   2433: invokevirtual 518	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   2436: aload_0
    //   2437: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   2440: aload_0
    //   2441: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   2444: aload 13
    //   2446: invokevirtual 926	android/app/Activity:addContentView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   2449: goto -481 -> 1968
    //   2452: astore 13
    //   2454: ldc 14
    //   2456: aload 13
    //   2458: invokestatic 423	com/jtpgodorncrqoeurl/AdLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   2461: ldc 14
    //   2463: new 530	java/lang/StringBuilder
    //   2466: dup
    //   2467: ldc_w 970
    //   2470: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2473: aload 13
    //   2475: invokevirtual 538	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2478: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2481: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2484: invokestatic 545	com/jtpgodorncrqoeurl/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2487: goto -519 -> 1968
    //   2490: aload_0
    //   2491: getfield 159	com/jtpgodorncrqoeurl/AdController:O	I
    //   2494: aload_0
    //   2495: getfield 161	com/jtpgodorncrqoeurl/AdController:P	I
    //   2498: if_icmple -2475 -> 23
    //   2501: aload_0
    //   2502: getfield 159	com/jtpgodorncrqoeurl/AdController:O	I
    //   2505: aload_0
    //   2506: getfield 163	com/jtpgodorncrqoeurl/AdController:Q	I
    //   2509: if_icmplt -2486 -> 23
    //   2512: aload_0
    //   2513: iconst_0
    //   2514: putfield 173	com/jtpgodorncrqoeurl/AdController:ai	Z
    //   2517: aload_0
    //   2518: invokespecial 972	com/jtpgodorncrqoeurl/AdController:e	()V
    //   2521: return
    //   2522: aload_0
    //   2523: iconst_0
    //   2524: putfield 687	com/jtpgodorncrqoeurl/AdController:h	Z
    //   2527: aload_0
    //   2528: invokespecial 949	com/jtpgodorncrqoeurl/AdController:f	()V
    //   2531: return
    //   2532: aload_0
    //   2533: iconst_0
    //   2534: putfield 687	com/jtpgodorncrqoeurl/AdController:h	Z
    //   2537: aload_0
    //   2538: invokespecial 949	com/jtpgodorncrqoeurl/AdController:f	()V
    //   2541: aload_0
    //   2542: getfield 169	com/jtpgodorncrqoeurl/AdController:ad	Lcom/jtpgodorncrqoeurl/AdListener;
    //   2545: astore 13
    //   2547: aload 13
    //   2549: ifnull +25 -> 2574
    //   2552: ldc 14
    //   2554: ldc_w 974
    //   2557: invokestatic 523	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2560: aload_0
    //   2561: getfield 169	com/jtpgodorncrqoeurl/AdController:ad	Lcom/jtpgodorncrqoeurl/AdListener;
    //   2564: invokeinterface 977 1 0
    //   2569: aload_0
    //   2570: iconst_1
    //   2571: putfield 155	com/jtpgodorncrqoeurl/AdController:M	Z
    //   2574: aload_0
    //   2575: getfield 237	com/jtpgodorncrqoeurl/AdController:al	Lcom/jtpgodorncrqoeurl/AdAudioListener;
    //   2578: ifnull -2555 -> 23
    //   2581: aload_0
    //   2582: getfield 237	com/jtpgodorncrqoeurl/AdController:al	Lcom/jtpgodorncrqoeurl/AdAudioListener;
    //   2585: invokeinterface 980 1 0
    //   2590: aload_0
    //   2591: iconst_1
    //   2592: putfield 179	com/jtpgodorncrqoeurl/AdController:an	Z
    //   2595: return
    //   2596: astore 13
    //   2598: ldc 14
    //   2600: ldc_w 982
    //   2603: invokestatic 523	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2606: ldc 14
    //   2608: aload 13
    //   2610: invokestatic 423	com/jtpgodorncrqoeurl/AdLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   2613: goto -39 -> 2574
    //   2616: astore 14
    //   2618: goto -926 -> 1692
    //   2621: astore 14
    //   2623: goto -2016 -> 607
    //   2626: astore 13
    //   2628: goto -2085 -> 543
    //   2631: astore 14
    //   2633: goto -2541 -> 92
    //   2636: astore 13
    //   2638: goto -2565 -> 73
    //   2641: goto -1603 -> 1038
    //   2644: goto -1680 -> 964
    //   2647: ldc_w 984
    //   2650: astore 13
    //   2652: goto -1688 -> 964
    //   2655: ldc_w 984
    //   2658: astore 14
    //   2660: goto -1622 -> 1038
    //   2663: ldc_w 984
    //   2666: astore 15
    //   2668: goto -1422 -> 1246
    //   2671: ldc_w 984
    //   2674: astore 15
    //   2676: goto -1330 -> 1346
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2679	0	this	AdController
    //   511	9	1	d1	double
    //   1427	31	3	f1	float
    //   609	1727	4	i1	int
    //   584	1746	5	i2	int
    //   870	674	6	i3	int
    //   882	672	7	i4	int
    //   1060	471	8	i5	int
    //   1140	256	9	i6	int
    //   1152	241	10	i7	int
    //   1310	83	11	i8	int
    //   321	3	12	bool	boolean
    //   74	17	13	localObject1	Object
    //   229	22	13	localException1	Exception
    //   552	1412	13	localObject2	Object
    //   2112	31	13	localException2	Exception
    //   2148	53	13	localJSONException	JSONException
    //   2214	1	13	localException3	Exception
    //   2230	1	13	localException4	Exception
    //   2248	197	13	localException5	Exception
    //   2452	22	13	localException6	Exception
    //   2545	3	13	localAdListener	AdListener
    //   2596	13	13	localException7	Exception
    //   2626	1	13	localException8	Exception
    //   2636	1	13	localException9	Exception
    //   2650	1	13	str1	String
    //   86	1603	14	localObject3	Object
    //   2235	1	14	localException10	Exception
    //   2288	1	14	localException11	Exception
    //   2417	1	14	localException12	Exception
    //   2616	1	14	localException13	Exception
    //   2621	1	14	localException14	Exception
    //   2631	1	14	localException15	Exception
    //   2658	1	14	str2	String
    //   1081	1594	15	localObject4	Object
    //   1222	117	16	str3	String
    //   572	1070	17	localLayoutParams1	RelativeLayout.LayoutParams
    //   834	1523	18	localLayoutParams2	RelativeLayout.LayoutParams
    //   917	879	19	localLayoutParams3	RelativeLayout.LayoutParams
    //   1116	711	20	localLayoutParams4	RelativeLayout.LayoutParams
    //   1195	688	21	localLayoutParams5	RelativeLayout.LayoutParams
    // Exception table:
    //   from	to	target	type
    //   174	228	229	java/lang/Exception
    //   2047	2111	2112	java/lang/Exception
    //   289	323	2148	org/json/JSONException
    //   328	339	2148	org/json/JSONException
    //   339	460	2148	org/json/JSONException
    //   460	543	2148	org/json/JSONException
    //   543	586	2148	org/json/JSONException
    //   591	603	2148	org/json/JSONException
    //   611	630	2148	org/json/JSONException
    //   635	662	2148	org/json/JSONException
    //   662	668	2148	org/json/JSONException
    //   673	700	2148	org/json/JSONException
    //   704	711	2148	org/json/JSONException
    //   715	777	2148	org/json/JSONException
    //   777	956	2148	org/json/JSONException
    //   964	1030	2148	org/json/JSONException
    //   1038	1234	2148	org/json/JSONException
    //   1246	1334	2148	org/json/JSONException
    //   1346	1619	2148	org/json/JSONException
    //   1619	1668	2148	org/json/JSONException
    //   1671	1688	2148	org/json/JSONException
    //   1692	1720	2148	org/json/JSONException
    //   1725	1751	2148	org/json/JSONException
    //   1751	1773	2148	org/json/JSONException
    //   1773	1831	2148	org/json/JSONException
    //   1831	1860	2148	org/json/JSONException
    //   1860	1918	2148	org/json/JSONException
    //   1918	1955	2148	org/json/JSONException
    //   1955	1968	2148	org/json/JSONException
    //   1968	2047	2148	org/json/JSONException
    //   2047	2111	2148	org/json/JSONException
    //   2114	2147	2148	org/json/JSONException
    //   2216	2227	2148	org/json/JSONException
    //   2237	2245	2148	org/json/JSONException
    //   2290	2298	2148	org/json/JSONException
    //   2305	2325	2148	org/json/JSONException
    //   2340	2361	2148	org/json/JSONException
    //   2366	2392	2148	org/json/JSONException
    //   2392	2414	2148	org/json/JSONException
    //   2419	2449	2148	org/json/JSONException
    //   2454	2487	2148	org/json/JSONException
    //   2490	2521	2148	org/json/JSONException
    //   2522	2531	2148	org/json/JSONException
    //   2532	2547	2148	org/json/JSONException
    //   2552	2574	2148	org/json/JSONException
    //   2574	2595	2148	org/json/JSONException
    //   2598	2613	2148	org/json/JSONException
    //   328	339	2214	java/lang/Exception
    //   339	460	2230	java/lang/Exception
    //   2216	2227	2230	java/lang/Exception
    //   635	662	2235	java/lang/Exception
    //   289	323	2248	java/lang/Exception
    //   543	586	2248	java/lang/Exception
    //   611	630	2248	java/lang/Exception
    //   662	668	2248	java/lang/Exception
    //   704	711	2248	java/lang/Exception
    //   715	777	2248	java/lang/Exception
    //   777	956	2248	java/lang/Exception
    //   964	1030	2248	java/lang/Exception
    //   1038	1234	2248	java/lang/Exception
    //   1246	1334	2248	java/lang/Exception
    //   1346	1619	2248	java/lang/Exception
    //   1619	1668	2248	java/lang/Exception
    //   1692	1720	2248	java/lang/Exception
    //   1725	1751	2248	java/lang/Exception
    //   1751	1773	2248	java/lang/Exception
    //   1773	1831	2248	java/lang/Exception
    //   1831	1860	2248	java/lang/Exception
    //   1860	1918	2248	java/lang/Exception
    //   1918	1955	2248	java/lang/Exception
    //   1968	2047	2248	java/lang/Exception
    //   2114	2147	2248	java/lang/Exception
    //   2237	2245	2248	java/lang/Exception
    //   2290	2298	2248	java/lang/Exception
    //   2305	2325	2248	java/lang/Exception
    //   2340	2361	2248	java/lang/Exception
    //   2366	2392	2248	java/lang/Exception
    //   2392	2414	2248	java/lang/Exception
    //   2454	2487	2248	java/lang/Exception
    //   2490	2521	2248	java/lang/Exception
    //   2522	2531	2248	java/lang/Exception
    //   2532	2547	2248	java/lang/Exception
    //   2574	2595	2248	java/lang/Exception
    //   2598	2613	2248	java/lang/Exception
    //   673	700	2288	java/lang/Exception
    //   1955	1968	2417	java/lang/Exception
    //   2419	2449	2452	java/lang/Exception
    //   2552	2574	2596	java/lang/Exception
    //   1671	1688	2616	java/lang/Exception
    //   591	603	2621	java/lang/Exception
    //   460	543	2626	java/lang/Exception
    //   76	88	2631	java/lang/Exception
    //   39	73	2636	java/lang/Exception
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: ldc 14
    //   2: ldc_w 987
    //   5: invokestatic 523	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_0
    //   9: invokespecial 711	com/jtpgodorncrqoeurl/AdController:i	()V
    //   12: aload_0
    //   13: getfield 141	com/jtpgodorncrqoeurl/AdController:l	Z
    //   16: ifne +2068 -> 2084
    //   19: ldc 14
    //   21: new 530	java/lang/StringBuilder
    //   24: dup
    //   25: ldc_w 989
    //   28: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 687	com/jtpgodorncrqoeurl/AdController:h	Z
    //   35: invokevirtual 992	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   38: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 523	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: iconst_0
    //   46: putfield 139	com/jtpgodorncrqoeurl/AdController:k	Z
    //   49: aload_0
    //   50: iconst_1
    //   51: putfield 141	com/jtpgodorncrqoeurl/AdController:l	Z
    //   54: aload_0
    //   55: getfield 687	com/jtpgodorncrqoeurl/AdController:h	Z
    //   58: ifne +2026 -> 2084
    //   61: ldc 14
    //   63: ldc_w 994
    //   66: invokestatic 523	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   73: aload_0
    //   74: getfield 489	com/jtpgodorncrqoeurl/AdController:aj	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   77: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   80: aload_0
    //   81: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   84: aload_0
    //   85: getfield 495	com/jtpgodorncrqoeurl/AdController:u	Landroid/view/View;
    //   88: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   91: aload_0
    //   92: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   95: aload_0
    //   96: getfield 497	com/jtpgodorncrqoeurl/AdController:v	Landroid/widget/TextView;
    //   99: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   102: aload_0
    //   103: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   106: aload_0
    //   107: getfield 499	com/jtpgodorncrqoeurl/AdController:w	Landroid/view/View;
    //   110: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   113: aload_0
    //   114: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   117: aload_0
    //   118: getfield 501	com/jtpgodorncrqoeurl/AdController:x	Landroid/widget/TextView;
    //   121: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   124: aload_0
    //   125: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   128: aload_0
    //   129: getfield 503	com/jtpgodorncrqoeurl/AdController:y	Landroid/widget/Button;
    //   132: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   135: aload_0
    //   136: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   139: aload_0
    //   140: getfield 505	com/jtpgodorncrqoeurl/AdController:z	Landroid/widget/Button;
    //   143: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   146: aload_0
    //   147: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   150: aload_0
    //   151: getfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   154: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   157: aload_0
    //   158: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   161: aload_0
    //   162: getfield 509	com/jtpgodorncrqoeurl/AdController:B	Landroid/widget/Button;
    //   165: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   168: aload_0
    //   169: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   172: aconst_null
    //   173: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   176: aload_0
    //   177: getfield 713	com/jtpgodorncrqoeurl/AdController:C	Landroid/widget/Button;
    //   180: ifnull +10 -> 190
    //   183: aload_0
    //   184: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   187: invokevirtual 716	android/widget/RelativeLayout:removeAllViews	()V
    //   190: aload_0
    //   191: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   194: ldc_w 996
    //   197: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   200: istore 5
    //   202: aload_0
    //   203: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   206: ldc_w 998
    //   209: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   212: istore 6
    //   214: new 754	android/view/ViewGroup$MarginLayoutParams
    //   217: dup
    //   218: aload_0
    //   219: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   222: ldc_w 1000
    //   225: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   228: aload_0
    //   229: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   232: ldc_w 1002
    //   235: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   238: invokespecial 757	android/view/ViewGroup$MarginLayoutParams:<init>	(II)V
    //   241: astore 17
    //   243: aload 17
    //   245: iload 5
    //   247: iload 6
    //   249: iconst_0
    //   250: iconst_0
    //   251: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   254: new 763	android/widget/RelativeLayout$LayoutParams
    //   257: dup
    //   258: aload 17
    //   260: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   263: astore 21
    //   265: aload_0
    //   266: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   269: ldc_w 1004
    //   272: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   275: istore 7
    //   277: aload_0
    //   278: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   281: ldc_w 1006
    //   284: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   287: istore 13
    //   289: aload_0
    //   290: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   293: ldc_w 1008
    //   296: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   299: istore 8
    //   301: aload_0
    //   302: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   305: ldc_w 1010
    //   308: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   311: istore 9
    //   313: new 754	android/view/ViewGroup$MarginLayoutParams
    //   316: dup
    //   317: iload 7
    //   319: iload 13
    //   321: invokespecial 757	android/view/ViewGroup$MarginLayoutParams:<init>	(II)V
    //   324: astore 17
    //   326: aload 17
    //   328: iload 8
    //   330: iload 9
    //   332: iconst_0
    //   333: iconst_0
    //   334: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   337: new 763	android/widget/RelativeLayout$LayoutParams
    //   340: dup
    //   341: aload 17
    //   343: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   346: astore 23
    //   348: aload_0
    //   349: getfield 495	com/jtpgodorncrqoeurl/AdController:u	Landroid/view/View;
    //   352: invokevirtual 1013	android/view/View:invalidate	()V
    //   355: aload_0
    //   356: new 483	android/view/View
    //   359: dup
    //   360: aload_0
    //   361: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   364: invokespecial 717	android/view/View:<init>	(Landroid/content/Context;)V
    //   367: putfield 495	com/jtpgodorncrqoeurl/AdController:u	Landroid/view/View;
    //   370: aload_0
    //   371: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   374: ldc_w 1015
    //   377: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   380: astore 17
    //   382: aload 17
    //   384: ldc -38
    //   386: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   389: ifne +2070 -> 2459
    //   392: aload 17
    //   394: ifnonnull +2062 -> 2456
    //   397: goto +2062 -> 2459
    //   400: aload_0
    //   401: getfield 495	com/jtpgodorncrqoeurl/AdController:u	Landroid/view/View;
    //   404: aload 17
    //   406: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   409: invokevirtual 727	android/view/View:setBackgroundColor	(I)V
    //   412: aload_0
    //   413: getfield 497	com/jtpgodorncrqoeurl/AdController:v	Landroid/widget/TextView;
    //   416: invokevirtual 1016	android/widget/TextView:invalidate	()V
    //   419: aload_0
    //   420: new 804	android/widget/TextView
    //   423: dup
    //   424: aload_0
    //   425: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   428: invokespecial 805	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   431: putfield 497	com/jtpgodorncrqoeurl/AdController:v	Landroid/widget/TextView;
    //   434: aload_0
    //   435: getfield 497	com/jtpgodorncrqoeurl/AdController:v	Landroid/widget/TextView;
    //   438: aload_0
    //   439: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   442: ldc_w 1018
    //   445: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   448: invokevirtual 811	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   451: aload_0
    //   452: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   455: ldc_w 1020
    //   458: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   461: astore 18
    //   463: aload 18
    //   465: ldc -38
    //   467: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   470: ifne +1997 -> 2467
    //   473: aload 18
    //   475: ifnonnull +1978 -> 2453
    //   478: goto +1989 -> 2467
    //   481: aload_0
    //   482: getfield 497	com/jtpgodorncrqoeurl/AdController:v	Landroid/widget/TextView;
    //   485: aload 18
    //   487: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   490: invokevirtual 816	android/widget/TextView:setTextColor	(I)V
    //   493: new 754	android/view/ViewGroup$MarginLayoutParams
    //   496: dup
    //   497: aload_0
    //   498: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   501: ldc_w 1022
    //   504: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   507: iload 13
    //   509: iconst_2
    //   510: isub
    //   511: invokespecial 757	android/view/ViewGroup$MarginLayoutParams:<init>	(II)V
    //   514: astore 19
    //   516: aload 19
    //   518: iload 8
    //   520: bipush 20
    //   522: iadd
    //   523: iload 9
    //   525: bipush 8
    //   527: iadd
    //   528: iconst_0
    //   529: iconst_0
    //   530: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   533: new 763	android/widget/RelativeLayout$LayoutParams
    //   536: dup
    //   537: aload 19
    //   539: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   542: astore 25
    //   544: aload_0
    //   545: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   548: ldc_w 1024
    //   551: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   554: istore 10
    //   556: aload_0
    //   557: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   560: ldc_w 1026
    //   563: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   566: istore 11
    //   568: aload_0
    //   569: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   572: ldc_w 1028
    //   575: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   578: istore 12
    //   580: new 754	android/view/ViewGroup$MarginLayoutParams
    //   583: dup
    //   584: aload_0
    //   585: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   588: ldc_w 1030
    //   591: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   594: iload 12
    //   596: invokespecial 757	android/view/ViewGroup$MarginLayoutParams:<init>	(II)V
    //   599: astore 19
    //   601: aload 19
    //   603: iload 10
    //   605: iload 11
    //   607: iconst_0
    //   608: iconst_0
    //   609: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   612: new 763	android/widget/RelativeLayout$LayoutParams
    //   615: dup
    //   616: aload 19
    //   618: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   621: astore 24
    //   623: aload_0
    //   624: new 483	android/view/View
    //   627: dup
    //   628: aload_0
    //   629: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   632: invokespecial 717	android/view/View:<init>	(Landroid/content/Context;)V
    //   635: putfield 499	com/jtpgodorncrqoeurl/AdController:w	Landroid/view/View;
    //   638: aload_0
    //   639: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   642: ldc_w 1032
    //   645: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   648: astore 19
    //   650: aload 19
    //   652: ldc -38
    //   654: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   657: ifne +1818 -> 2475
    //   660: aload 19
    //   662: ifnonnull +1788 -> 2450
    //   665: goto +1810 -> 2475
    //   668: aload_0
    //   669: getfield 499	com/jtpgodorncrqoeurl/AdController:w	Landroid/view/View;
    //   672: aload 19
    //   674: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   677: invokevirtual 727	android/view/View:setBackgroundColor	(I)V
    //   680: aload_0
    //   681: new 804	android/widget/TextView
    //   684: dup
    //   685: aload_0
    //   686: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   689: invokespecial 805	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   692: putfield 501	com/jtpgodorncrqoeurl/AdController:x	Landroid/widget/TextView;
    //   695: aload_0
    //   696: getfield 501	com/jtpgodorncrqoeurl/AdController:x	Landroid/widget/TextView;
    //   699: aload_0
    //   700: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   703: ldc_w 1034
    //   706: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   709: invokevirtual 811	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   712: aload_0
    //   713: getfield 501	com/jtpgodorncrqoeurl/AdController:x	Landroid/widget/TextView;
    //   716: ldc_w 833
    //   719: invokevirtual 837	android/widget/TextView:setTextSize	(F)V
    //   722: aload_0
    //   723: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   726: ldc_w 1036
    //   729: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   732: astore 22
    //   734: aload 22
    //   736: ldc -38
    //   738: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   741: ifne +1742 -> 2483
    //   744: aload 22
    //   746: astore 20
    //   748: aload 22
    //   750: ifnonnull +6 -> 756
    //   753: goto +1730 -> 2483
    //   756: aload_0
    //   757: getfield 501	com/jtpgodorncrqoeurl/AdController:x	Landroid/widget/TextView;
    //   760: aload 20
    //   762: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   765: invokevirtual 816	android/widget/TextView:setTextColor	(I)V
    //   768: new 754	android/view/ViewGroup$MarginLayoutParams
    //   771: dup
    //   772: aload_0
    //   773: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   776: ldc_w 1038
    //   779: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   782: aload_0
    //   783: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   786: ldc_w 1040
    //   789: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   792: invokespecial 757	android/view/ViewGroup$MarginLayoutParams:<init>	(II)V
    //   795: astore 20
    //   797: aload_0
    //   798: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   801: ldc_w 1042
    //   804: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   807: iconst_1
    //   808: if_icmpne +1298 -> 2106
    //   811: iload 10
    //   813: bipush 70
    //   815: iadd
    //   816: istore 4
    //   818: aload 20
    //   820: iload 4
    //   822: iload 11
    //   824: iconst_5
    //   825: iadd
    //   826: iconst_0
    //   827: iconst_0
    //   828: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   831: new 763	android/widget/RelativeLayout$LayoutParams
    //   834: dup
    //   835: aload 20
    //   837: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   840: astore 20
    //   842: iload 13
    //   844: iconst_5
    //   845: isub
    //   846: iconst_0
    //   847: invokestatic 849	java/lang/Math:max	(II)I
    //   850: istore 14
    //   852: iload 14
    //   854: iconst_2
    //   855: idiv
    //   856: i2f
    //   857: fstore_1
    //   858: fload_1
    //   859: ldc_w 833
    //   862: fcmpl
    //   863: ifle +1584 -> 2447
    //   866: ldc_w 833
    //   869: fstore_1
    //   870: iload 12
    //   872: iconst_5
    //   873: isub
    //   874: iconst_0
    //   875: invokestatic 849	java/lang/Math:max	(II)I
    //   878: istore 4
    //   880: iload 4
    //   882: iconst_2
    //   883: idiv
    //   884: i2f
    //   885: fstore_3
    //   886: fload_3
    //   887: fstore_2
    //   888: fload_3
    //   889: ldc_w 833
    //   892: fcmpl
    //   893: ifle +7 -> 900
    //   896: ldc_w 833
    //   899: fstore_2
    //   900: aload_0
    //   901: getfield 509	com/jtpgodorncrqoeurl/AdController:B	Landroid/widget/Button;
    //   904: ifnull +10 -> 914
    //   907: aload_0
    //   908: getfield 509	com/jtpgodorncrqoeurl/AdController:B	Landroid/widget/Button;
    //   911: invokevirtual 1043	android/widget/Button:invalidate	()V
    //   914: aload_0
    //   915: new 851	android/widget/Button
    //   918: dup
    //   919: aload_0
    //   920: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   923: invokespecial 852	android/widget/Button:<init>	(Landroid/content/Context;)V
    //   926: putfield 509	com/jtpgodorncrqoeurl/AdController:B	Landroid/widget/Button;
    //   929: aload_0
    //   930: getfield 509	com/jtpgodorncrqoeurl/AdController:B	Landroid/widget/Button;
    //   933: ldc_w 1045
    //   936: invokevirtual 854	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   939: aload_0
    //   940: getfield 509	com/jtpgodorncrqoeurl/AdController:B	Landroid/widget/Button;
    //   943: fload_2
    //   944: invokevirtual 855	android/widget/Button:setTextSize	(F)V
    //   947: aload_0
    //   948: getfield 509	com/jtpgodorncrqoeurl/AdController:B	Landroid/widget/Button;
    //   951: aload 18
    //   953: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   956: invokevirtual 856	android/widget/Button:setTextColor	(I)V
    //   959: aload_0
    //   960: getfield 509	com/jtpgodorncrqoeurl/AdController:B	Landroid/widget/Button;
    //   963: iconst_0
    //   964: iconst_0
    //   965: iconst_0
    //   966: iconst_0
    //   967: invokevirtual 859	android/widget/Button:setPadding	(IIII)V
    //   970: aload_0
    //   971: getfield 509	com/jtpgodorncrqoeurl/AdController:B	Landroid/widget/Button;
    //   974: aload 19
    //   976: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   979: invokevirtual 860	android/widget/Button:setBackgroundColor	(I)V
    //   982: aload_0
    //   983: getfield 509	com/jtpgodorncrqoeurl/AdController:B	Landroid/widget/Button;
    //   986: new 1047	com/jtpgodorncrqoeurl/w
    //   989: dup
    //   990: aload_0
    //   991: invokespecial 1048	com/jtpgodorncrqoeurl/w:<init>	(Lcom/jtpgodorncrqoeurl/AdController;)V
    //   994: invokevirtual 864	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   997: aload_0
    //   998: getfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   1001: ifnull +10 -> 1011
    //   1004: aload_0
    //   1005: getfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   1008: invokevirtual 1043	android/widget/Button:invalidate	()V
    //   1011: aload_0
    //   1012: new 851	android/widget/Button
    //   1015: dup
    //   1016: aload_0
    //   1017: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   1020: invokespecial 852	android/widget/Button:<init>	(Landroid/content/Context;)V
    //   1023: putfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   1026: aload_0
    //   1027: getfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   1030: ldc_w 853
    //   1033: invokevirtual 854	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   1036: aload_0
    //   1037: getfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   1040: fload_1
    //   1041: invokevirtual 855	android/widget/Button:setTextSize	(F)V
    //   1044: aload_0
    //   1045: getfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   1048: aload 18
    //   1050: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1053: invokevirtual 856	android/widget/Button:setTextColor	(I)V
    //   1056: aload_0
    //   1057: getfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   1060: iconst_0
    //   1061: iconst_0
    //   1062: iconst_0
    //   1063: iconst_0
    //   1064: invokevirtual 859	android/widget/Button:setPadding	(IIII)V
    //   1067: aload_0
    //   1068: getfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   1071: aload 17
    //   1073: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1076: invokevirtual 860	android/widget/Button:setBackgroundColor	(I)V
    //   1079: aload_0
    //   1080: getfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   1083: new 1050	com/jtpgodorncrqoeurl/x
    //   1086: dup
    //   1087: aload_0
    //   1088: invokespecial 1051	com/jtpgodorncrqoeurl/x:<init>	(Lcom/jtpgodorncrqoeurl/AdController;)V
    //   1091: invokevirtual 864	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1094: aload_0
    //   1095: new 851	android/widget/Button
    //   1098: dup
    //   1099: aload_0
    //   1100: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   1103: invokespecial 852	android/widget/Button:<init>	(Landroid/content/Context;)V
    //   1106: putfield 505	com/jtpgodorncrqoeurl/AdController:z	Landroid/widget/Button;
    //   1109: aload_0
    //   1110: getfield 505	com/jtpgodorncrqoeurl/AdController:z	Landroid/widget/Button;
    //   1113: ldc_w 1053
    //   1116: invokevirtual 854	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   1119: aload_0
    //   1120: getfield 505	com/jtpgodorncrqoeurl/AdController:z	Landroid/widget/Button;
    //   1123: fload_2
    //   1124: invokevirtual 855	android/widget/Button:setTextSize	(F)V
    //   1127: aload_0
    //   1128: getfield 505	com/jtpgodorncrqoeurl/AdController:z	Landroid/widget/Button;
    //   1131: aload 18
    //   1133: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1136: invokevirtual 856	android/widget/Button:setTextColor	(I)V
    //   1139: aload_0
    //   1140: getfield 505	com/jtpgodorncrqoeurl/AdController:z	Landroid/widget/Button;
    //   1143: iconst_0
    //   1144: iconst_0
    //   1145: iconst_0
    //   1146: iconst_0
    //   1147: invokevirtual 859	android/widget/Button:setPadding	(IIII)V
    //   1150: aload_0
    //   1151: getfield 505	com/jtpgodorncrqoeurl/AdController:z	Landroid/widget/Button;
    //   1154: aload 19
    //   1156: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1159: invokevirtual 860	android/widget/Button:setBackgroundColor	(I)V
    //   1162: aload_0
    //   1163: getfield 505	com/jtpgodorncrqoeurl/AdController:z	Landroid/widget/Button;
    //   1166: new 1055	com/jtpgodorncrqoeurl/y
    //   1169: dup
    //   1170: aload_0
    //   1171: invokespecial 1056	com/jtpgodorncrqoeurl/y:<init>	(Lcom/jtpgodorncrqoeurl/AdController;)V
    //   1174: invokevirtual 864	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1177: aload_0
    //   1178: getfield 503	com/jtpgodorncrqoeurl/AdController:y	Landroid/widget/Button;
    //   1181: ifnull +10 -> 1191
    //   1184: aload_0
    //   1185: getfield 503	com/jtpgodorncrqoeurl/AdController:y	Landroid/widget/Button;
    //   1188: invokevirtual 1043	android/widget/Button:invalidate	()V
    //   1191: aload_0
    //   1192: new 851	android/widget/Button
    //   1195: dup
    //   1196: aload_0
    //   1197: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   1200: invokespecial 852	android/widget/Button:<init>	(Landroid/content/Context;)V
    //   1203: putfield 503	com/jtpgodorncrqoeurl/AdController:y	Landroid/widget/Button;
    //   1206: aload_0
    //   1207: getfield 503	com/jtpgodorncrqoeurl/AdController:y	Landroid/widget/Button;
    //   1210: ldc_w 1058
    //   1213: invokevirtual 854	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   1216: aload_0
    //   1217: getfield 503	com/jtpgodorncrqoeurl/AdController:y	Landroid/widget/Button;
    //   1220: fload_2
    //   1221: invokevirtual 855	android/widget/Button:setTextSize	(F)V
    //   1224: aload_0
    //   1225: getfield 503	com/jtpgodorncrqoeurl/AdController:y	Landroid/widget/Button;
    //   1228: aload 18
    //   1230: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1233: invokevirtual 856	android/widget/Button:setTextColor	(I)V
    //   1236: aload_0
    //   1237: getfield 503	com/jtpgodorncrqoeurl/AdController:y	Landroid/widget/Button;
    //   1240: iconst_0
    //   1241: iconst_0
    //   1242: iconst_0
    //   1243: iconst_0
    //   1244: invokevirtual 859	android/widget/Button:setPadding	(IIII)V
    //   1247: aload_0
    //   1248: getfield 503	com/jtpgodorncrqoeurl/AdController:y	Landroid/widget/Button;
    //   1251: aload 19
    //   1253: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1256: invokevirtual 860	android/widget/Button:setBackgroundColor	(I)V
    //   1259: aload_0
    //   1260: getfield 503	com/jtpgodorncrqoeurl/AdController:y	Landroid/widget/Button;
    //   1263: new 1060	com/jtpgodorncrqoeurl/j
    //   1266: dup
    //   1267: aload_0
    //   1268: invokespecial 1061	com/jtpgodorncrqoeurl/j:<init>	(Lcom/jtpgodorncrqoeurl/AdController;)V
    //   1271: invokevirtual 864	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1274: new 754	android/view/ViewGroup$MarginLayoutParams
    //   1277: dup
    //   1278: bipush 30
    //   1280: iload 4
    //   1282: invokespecial 757	android/view/ViewGroup$MarginLayoutParams:<init>	(II)V
    //   1285: astore 17
    //   1287: aload_0
    //   1288: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1291: ldc_w 1028
    //   1294: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1297: iload 4
    //   1299: isub
    //   1300: iconst_2
    //   1301: idiv
    //   1302: iload 11
    //   1304: iadd
    //   1305: iconst_3
    //   1306: iadd
    //   1307: istore 15
    //   1309: aload 17
    //   1311: iload 10
    //   1313: iconst_5
    //   1314: iadd
    //   1315: iload 15
    //   1317: iconst_0
    //   1318: iconst_0
    //   1319: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   1322: new 763	android/widget/RelativeLayout$LayoutParams
    //   1325: dup
    //   1326: aload 17
    //   1328: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   1331: astore 18
    //   1333: aload 17
    //   1335: iload 10
    //   1337: iconst_5
    //   1338: iadd
    //   1339: bipush 30
    //   1341: iadd
    //   1342: iload 15
    //   1344: iconst_0
    //   1345: iconst_0
    //   1346: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   1349: new 763	android/widget/RelativeLayout$LayoutParams
    //   1352: dup
    //   1353: aload 17
    //   1355: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   1358: astore 19
    //   1360: aload_0
    //   1361: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1364: ldc_w 1063
    //   1367: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1370: iconst_1
    //   1371: if_icmpne +745 -> 2116
    //   1374: aload_0
    //   1375: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   1378: aload_0
    //   1379: getfield 495	com/jtpgodorncrqoeurl/AdController:u	Landroid/view/View;
    //   1382: aload 23
    //   1384: invokevirtual 881	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1387: aload_0
    //   1388: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1391: ldc_w 1018
    //   1394: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1397: ldc -38
    //   1399: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1402: ifne +16 -> 1418
    //   1405: aload_0
    //   1406: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   1409: aload_0
    //   1410: getfield 497	com/jtpgodorncrqoeurl/AdController:v	Landroid/widget/TextView;
    //   1413: aload 25
    //   1415: invokevirtual 881	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1418: aload 21
    //   1420: astore 17
    //   1422: aload_0
    //   1423: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1426: ldc_w 917
    //   1429: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1432: iconst_1
    //   1433: if_icmpne +87 -> 1520
    //   1436: aload_0
    //   1437: new 754	android/view/ViewGroup$MarginLayoutParams
    //   1440: dup
    //   1441: bipush 55
    //   1443: iload 14
    //   1445: invokespecial 757	android/view/ViewGroup$MarginLayoutParams:<init>	(II)V
    //   1448: putfield 866	com/jtpgodorncrqoeurl/AdController:s	Landroid/view/ViewGroup$MarginLayoutParams;
    //   1451: iload 13
    //   1453: iload 14
    //   1455: isub
    //   1456: iconst_2
    //   1457: idiv
    //   1458: istore 13
    //   1460: aload_0
    //   1461: getfield 866	com/jtpgodorncrqoeurl/AdController:s	Landroid/view/ViewGroup$MarginLayoutParams;
    //   1464: iload 7
    //   1466: iload 8
    //   1468: iadd
    //   1469: bipush 55
    //   1471: isub
    //   1472: iconst_5
    //   1473: isub
    //   1474: iload 13
    //   1476: iload 9
    //   1478: iadd
    //   1479: iconst_2
    //   1480: iadd
    //   1481: iconst_0
    //   1482: iconst_0
    //   1483: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   1486: aload_0
    //   1487: new 763	android/widget/RelativeLayout$LayoutParams
    //   1490: dup
    //   1491: aload_0
    //   1492: getfield 866	com/jtpgodorncrqoeurl/AdController:s	Landroid/view/ViewGroup$MarginLayoutParams;
    //   1495: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   1498: putfield 868	com/jtpgodorncrqoeurl/AdController:r	Landroid/widget/RelativeLayout$LayoutParams;
    //   1501: aload_0
    //   1502: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   1505: aload_0
    //   1506: getfield 507	com/jtpgodorncrqoeurl/AdController:A	Landroid/widget/Button;
    //   1509: aload_0
    //   1510: getfield 868	com/jtpgodorncrqoeurl/AdController:r	Landroid/widget/RelativeLayout$LayoutParams;
    //   1513: invokevirtual 881	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1516: aload 21
    //   1518: astore 17
    //   1520: aload_0
    //   1521: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1524: ldc_w 1065
    //   1527: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1530: iconst_1
    //   1531: if_icmpne +689 -> 2220
    //   1534: aload_0
    //   1535: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   1538: aload_0
    //   1539: getfield 499	com/jtpgodorncrqoeurl/AdController:w	Landroid/view/View;
    //   1542: aload 24
    //   1544: invokevirtual 881	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1547: aload_0
    //   1548: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1551: ldc_w 1034
    //   1554: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1557: ldc -38
    //   1559: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1562: ifne +16 -> 1578
    //   1565: aload_0
    //   1566: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   1569: aload_0
    //   1570: getfield 501	com/jtpgodorncrqoeurl/AdController:x	Landroid/widget/TextView;
    //   1573: aload 20
    //   1575: invokevirtual 881	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1578: aload_0
    //   1579: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1582: ldc_w 1042
    //   1585: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1588: iconst_1
    //   1589: if_icmpne +29 -> 1618
    //   1592: aload_0
    //   1593: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   1596: aload_0
    //   1597: getfield 503	com/jtpgodorncrqoeurl/AdController:y	Landroid/widget/Button;
    //   1600: aload 18
    //   1602: invokevirtual 881	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1605: aload_0
    //   1606: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   1609: aload_0
    //   1610: getfield 505	com/jtpgodorncrqoeurl/AdController:z	Landroid/widget/Button;
    //   1613: aload 19
    //   1615: invokevirtual 881	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1618: aload 17
    //   1620: astore 18
    //   1622: aload_0
    //   1623: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1626: ldc_w 917
    //   1629: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1632: iconst_1
    //   1633: if_icmpne +81 -> 1714
    //   1636: new 754	android/view/ViewGroup$MarginLayoutParams
    //   1639: dup
    //   1640: bipush 55
    //   1642: iload 4
    //   1644: invokespecial 757	android/view/ViewGroup$MarginLayoutParams:<init>	(II)V
    //   1647: astore 18
    //   1649: aload 18
    //   1651: aload_0
    //   1652: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1655: ldc_w 1030
    //   1658: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1661: iload 10
    //   1663: iadd
    //   1664: bipush 55
    //   1666: isub
    //   1667: iconst_5
    //   1668: isub
    //   1669: iload 12
    //   1671: iload 4
    //   1673: isub
    //   1674: iconst_2
    //   1675: idiv
    //   1676: iload 11
    //   1678: iadd
    //   1679: iconst_2
    //   1680: iadd
    //   1681: iconst_0
    //   1682: iconst_0
    //   1683: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   1686: new 763	android/widget/RelativeLayout$LayoutParams
    //   1689: dup
    //   1690: aload 18
    //   1692: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   1695: astore 18
    //   1697: aload_0
    //   1698: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   1701: aload_0
    //   1702: getfield 509	com/jtpgodorncrqoeurl/AdController:B	Landroid/widget/Button;
    //   1705: aload 18
    //   1707: invokevirtual 881	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1710: aload 17
    //   1712: astore 18
    //   1714: aload_0
    //   1715: getfield 185	com/jtpgodorncrqoeurl/AdController:aq	Z
    //   1718: ifeq +559 -> 2277
    //   1721: ldc 14
    //   1723: ldc_w 1067
    //   1726: invokestatic 552	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1729: aload_0
    //   1730: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   1733: aload_0
    //   1734: getfield 247	com/jtpgodorncrqoeurl/AdController:b	Lcom/jtpgodorncrqoeurl/AdView;
    //   1737: aload 18
    //   1739: invokevirtual 881	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1742: aload_0
    //   1743: getfield 169	com/jtpgodorncrqoeurl/AdController:ad	Lcom/jtpgodorncrqoeurl/AdListener;
    //   1746: astore 17
    //   1748: aload 17
    //   1750: ifnull +39 -> 1789
    //   1753: aload_0
    //   1754: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1757: ldc_w 689
    //   1760: invokevirtual 708	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   1763: ldc_w 694
    //   1766: invokevirtual 709	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   1769: ifne +20 -> 1789
    //   1772: ldc 14
    //   1774: ldc_w 1069
    //   1777: invokestatic 523	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1780: aload_0
    //   1781: getfield 169	com/jtpgodorncrqoeurl/AdController:ad	Lcom/jtpgodorncrqoeurl/AdListener;
    //   1784: invokeinterface 1072 1 0
    //   1789: aload_0
    //   1790: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1793: ldc_w 689
    //   1796: invokevirtual 708	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   1799: ldc_w 694
    //   1802: invokevirtual 709	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   1805: istore 16
    //   1807: iload 16
    //   1809: ifeq +53 -> 1862
    //   1812: new 754	android/view/ViewGroup$MarginLayoutParams
    //   1815: dup
    //   1816: aload_0
    //   1817: getfield 921	com/jtpgodorncrqoeurl/AdController:E	I
    //   1820: aload_0
    //   1821: getfield 923	com/jtpgodorncrqoeurl/AdController:F	I
    //   1824: invokespecial 757	android/view/ViewGroup$MarginLayoutParams:<init>	(II)V
    //   1827: astore 17
    //   1829: aload 17
    //   1831: iconst_0
    //   1832: iconst_0
    //   1833: iconst_0
    //   1834: iconst_0
    //   1835: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   1838: new 763	android/widget/RelativeLayout$LayoutParams
    //   1841: dup
    //   1842: aload 17
    //   1844: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   1847: astore 17
    //   1849: aload_0
    //   1850: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   1853: aload_0
    //   1854: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   1857: aload 17
    //   1859: invokevirtual 926	android/app/Activity:addContentView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1862: ldc 14
    //   1864: new 530	java/lang/StringBuilder
    //   1867: dup
    //   1868: ldc_w 1074
    //   1871: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1874: aload_0
    //   1875: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1878: ldc_w 928
    //   1881: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1884: invokevirtual 783	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1887: ldc_w 1076
    //   1890: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1893: aload_0
    //   1894: getfield 173	com/jtpgodorncrqoeurl/AdController:ai	Z
    //   1897: invokevirtual 992	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1900: ldc_w 1078
    //   1903: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1906: aload_0
    //   1907: getfield 159	com/jtpgodorncrqoeurl/AdController:O	I
    //   1910: invokevirtual 783	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1913: ldc_w 1080
    //   1916: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1919: aload_0
    //   1920: getfield 161	com/jtpgodorncrqoeurl/AdController:P	I
    //   1923: invokevirtual 783	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1926: ldc_w 1082
    //   1929: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1932: aload_0
    //   1933: getfield 163	com/jtpgodorncrqoeurl/AdController:Q	I
    //   1936: invokevirtual 783	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1939: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1942: invokestatic 523	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1945: iconst_0
    //   1946: istore 5
    //   1948: aload_0
    //   1949: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1952: ldc_w 928
    //   1955: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1958: iconst_1
    //   1959: if_icmpne +393 -> 2352
    //   1962: aload_0
    //   1963: getfield 173	com/jtpgodorncrqoeurl/AdController:ai	Z
    //   1966: ifne +386 -> 2352
    //   1969: aload_0
    //   1970: getfield 159	com/jtpgodorncrqoeurl/AdController:O	I
    //   1973: ifle +379 -> 2352
    //   1976: iconst_1
    //   1977: istore 4
    //   1979: iload 4
    //   1981: ifeq +435 -> 2416
    //   1984: ldc 14
    //   1986: ldc_w 1084
    //   1989: invokestatic 523	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1992: aload_0
    //   1993: iconst_1
    //   1994: putfield 173	com/jtpgodorncrqoeurl/AdController:ai	Z
    //   1997: aload_0
    //   1998: new 932	com/jtpgodorncrqoeurl/E
    //   2001: dup
    //   2002: aload_0
    //   2003: invokespecial 933	com/jtpgodorncrqoeurl/E:<init>	(Lcom/jtpgodorncrqoeurl/AdController;)V
    //   2006: putfield 342	com/jtpgodorncrqoeurl/AdController:ag	Lcom/jtpgodorncrqoeurl/E;
    //   2009: aload_0
    //   2010: new 935	android/os/Handler
    //   2013: dup
    //   2014: invokespecial 936	android/os/Handler:<init>	()V
    //   2017: putfield 277	com/jtpgodorncrqoeurl/AdController:ah	Landroid/os/Handler;
    //   2020: ldc 14
    //   2022: new 530	java/lang/StringBuilder
    //   2025: dup
    //   2026: ldc_w 938
    //   2029: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2032: aload_0
    //   2033: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   2036: ldc_w 940
    //   2039: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   2042: invokevirtual 783	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2045: ldc_w 941
    //   2048: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2051: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2054: invokestatic 552	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2057: aload_0
    //   2058: getfield 277	com/jtpgodorncrqoeurl/AdController:ah	Landroid/os/Handler;
    //   2061: aload_0
    //   2062: getfield 342	com/jtpgodorncrqoeurl/AdController:ag	Lcom/jtpgodorncrqoeurl/E;
    //   2065: aload_0
    //   2066: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   2069: ldc_w 940
    //   2072: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   2075: sipush 1000
    //   2078: imul
    //   2079: i2l
    //   2080: invokevirtual 945	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   2083: pop
    //   2084: return
    //   2085: astore 17
    //   2087: aload_0
    //   2088: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   2091: aload_0
    //   2092: getfield 247	com/jtpgodorncrqoeurl/AdController:b	Lcom/jtpgodorncrqoeurl/AdView;
    //   2095: invokevirtual 493	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   2098: goto -2018 -> 80
    //   2101: astore 17
    //   2103: goto -1913 -> 190
    //   2106: iload 10
    //   2108: bipush 20
    //   2110: iadd
    //   2111: istore 4
    //   2113: goto -1295 -> 818
    //   2116: new 754	android/view/ViewGroup$MarginLayoutParams
    //   2119: dup
    //   2120: aload_0
    //   2121: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   2124: ldc_w 1000
    //   2127: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   2130: aload_0
    //   2131: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   2134: ldc_w 1002
    //   2137: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   2140: iload 13
    //   2142: iadd
    //   2143: invokespecial 757	android/view/ViewGroup$MarginLayoutParams:<init>	(II)V
    //   2146: astore 17
    //   2148: aload 17
    //   2150: iload 5
    //   2152: iload 6
    //   2154: aload_0
    //   2155: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   2158: ldc_w 1006
    //   2161: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   2164: isub
    //   2165: iconst_0
    //   2166: iconst_0
    //   2167: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   2170: new 763	android/widget/RelativeLayout$LayoutParams
    //   2173: dup
    //   2174: aload 17
    //   2176: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   2179: astore 17
    //   2181: goto -661 -> 1520
    //   2184: astore 17
    //   2186: ldc 14
    //   2188: aload 17
    //   2190: invokestatic 423	com/jtpgodorncrqoeurl/AdLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   2193: ldc 14
    //   2195: new 530	java/lang/StringBuilder
    //   2198: dup
    //   2199: ldc_w 1086
    //   2202: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2205: aload 17
    //   2207: invokevirtual 952	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2210: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2213: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2216: invokestatic 545	com/jtpgodorncrqoeurl/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2219: return
    //   2220: new 754	android/view/ViewGroup$MarginLayoutParams
    //   2223: dup
    //   2224: aload_0
    //   2225: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   2228: ldc_w 1000
    //   2231: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   2234: aload_0
    //   2235: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   2238: ldc_w 1002
    //   2241: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   2244: iload 12
    //   2246: iadd
    //   2247: invokespecial 757	android/view/ViewGroup$MarginLayoutParams:<init>	(II)V
    //   2250: astore 17
    //   2252: aload 17
    //   2254: iload 5
    //   2256: iload 6
    //   2258: iconst_0
    //   2259: iconst_0
    //   2260: invokevirtual 761	android/view/ViewGroup$MarginLayoutParams:setMargins	(IIII)V
    //   2263: new 763	android/widget/RelativeLayout$LayoutParams
    //   2266: dup
    //   2267: aload 17
    //   2269: invokespecial 766	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$MarginLayoutParams;)V
    //   2272: astore 18
    //   2274: goto -560 -> 1714
    //   2277: ldc 14
    //   2279: ldc_w 1088
    //   2282: invokestatic 552	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2285: aload_0
    //   2286: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   2289: aload_0
    //   2290: getfield 489	com/jtpgodorncrqoeurl/AdController:aj	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   2293: aload 18
    //   2295: invokevirtual 881	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   2298: goto -556 -> 1742
    //   2301: astore 17
    //   2303: ldc 14
    //   2305: ldc_w 1090
    //   2308: invokestatic 545	com/jtpgodorncrqoeurl/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2311: ldc 14
    //   2313: aload 17
    //   2315: invokestatic 423	com/jtpgodorncrqoeurl/AdLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   2318: goto -529 -> 1789
    //   2321: astore 17
    //   2323: ldc 14
    //   2325: new 530	java/lang/StringBuilder
    //   2328: dup
    //   2329: ldc_w 1092
    //   2332: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2335: aload 17
    //   2337: invokevirtual 538	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2340: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2343: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2346: invokestatic 545	com/jtpgodorncrqoeurl/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2349: goto -487 -> 1862
    //   2352: aload_0
    //   2353: getfield 159	com/jtpgodorncrqoeurl/AdController:O	I
    //   2356: aload_0
    //   2357: getfield 161	com/jtpgodorncrqoeurl/AdController:P	I
    //   2360: if_icmpgt +20 -> 2380
    //   2363: aload_0
    //   2364: getfield 159	com/jtpgodorncrqoeurl/AdController:O	I
    //   2367: aload_0
    //   2368: getfield 163	com/jtpgodorncrqoeurl/AdController:Q	I
    //   2371: if_icmpge +9 -> 2380
    //   2374: iconst_1
    //   2375: istore 4
    //   2377: goto -398 -> 1979
    //   2380: iload 5
    //   2382: istore 4
    //   2384: aload_0
    //   2385: getfield 159	com/jtpgodorncrqoeurl/AdController:O	I
    //   2388: aload_0
    //   2389: getfield 161	com/jtpgodorncrqoeurl/AdController:P	I
    //   2392: if_icmple -413 -> 1979
    //   2395: iload 5
    //   2397: istore 4
    //   2399: aload_0
    //   2400: getfield 159	com/jtpgodorncrqoeurl/AdController:O	I
    //   2403: aload_0
    //   2404: getfield 163	com/jtpgodorncrqoeurl/AdController:Q	I
    //   2407: if_icmplt -428 -> 1979
    //   2410: iconst_0
    //   2411: istore 4
    //   2413: goto -434 -> 1979
    //   2416: ldc 14
    //   2418: ldc_w 1094
    //   2421: invokestatic 523	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2424: aload_0
    //   2425: iconst_0
    //   2426: putfield 173	com/jtpgodorncrqoeurl/AdController:ai	Z
    //   2429: aload_0
    //   2430: invokespecial 972	com/jtpgodorncrqoeurl/AdController:e	()V
    //   2433: return
    //   2434: astore 17
    //   2436: return
    //   2437: astore 18
    //   2439: goto -2020 -> 419
    //   2442: astore 17
    //   2444: goto -2089 -> 355
    //   2447: goto -1577 -> 870
    //   2450: goto -1782 -> 668
    //   2453: goto -1972 -> 481
    //   2456: goto -2056 -> 400
    //   2459: ldc_w 984
    //   2462: astore 17
    //   2464: goto -2064 -> 400
    //   2467: ldc_w 1096
    //   2470: astore 18
    //   2472: goto -1991 -> 481
    //   2475: ldc_w 984
    //   2478: astore 19
    //   2480: goto -1812 -> 668
    //   2483: ldc_w 1096
    //   2486: astore 20
    //   2488: goto -1732 -> 756
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2491	0	this	AdController
    //   857	184	1	f1	float
    //   887	334	2	f2	float
    //   885	4	3	f3	float
    //   816	1596	4	i1	int
    //   200	2196	5	i2	int
    //   212	2045	6	i3	int
    //   275	1194	7	i4	int
    //   299	1170	8	i5	int
    //   311	1168	9	i6	int
    //   554	1557	10	i7	int
    //   566	1113	11	i8	int
    //   578	1669	12	i9	int
    //   287	1856	13	i10	int
    //   850	606	14	i11	int
    //   1307	36	15	i12	int
    //   1805	3	16	bool	boolean
    //   241	1617	17	localObject1	Object
    //   2085	1	17	localException1	Exception
    //   2101	1	17	localException2	Exception
    //   2146	34	17	localObject2	Object
    //   2184	22	17	localJSONException	JSONException
    //   2250	18	17	localMarginLayoutParams	ViewGroup.MarginLayoutParams
    //   2301	13	17	localException3	Exception
    //   2321	15	17	localException4	Exception
    //   2434	1	17	localException5	Exception
    //   2442	1	17	localException6	Exception
    //   2462	1	17	str1	String
    //   461	1833	18	localObject3	Object
    //   2437	1	18	localException7	Exception
    //   2470	1	18	str2	String
    //   514	1965	19	localObject4	Object
    //   746	1741	20	localObject5	Object
    //   263	1254	21	localLayoutParams1	RelativeLayout.LayoutParams
    //   732	17	22	str3	String
    //   346	1037	23	localLayoutParams2	RelativeLayout.LayoutParams
    //   621	922	24	localLayoutParams3	RelativeLayout.LayoutParams
    //   542	872	25	localLayoutParams4	RelativeLayout.LayoutParams
    // Exception table:
    //   from	to	target	type
    //   69	80	2085	java/lang/Exception
    //   80	190	2101	java/lang/Exception
    //   2087	2098	2101	java/lang/Exception
    //   69	80	2184	org/json/JSONException
    //   80	190	2184	org/json/JSONException
    //   190	348	2184	org/json/JSONException
    //   348	355	2184	org/json/JSONException
    //   355	392	2184	org/json/JSONException
    //   400	412	2184	org/json/JSONException
    //   412	419	2184	org/json/JSONException
    //   419	473	2184	org/json/JSONException
    //   481	660	2184	org/json/JSONException
    //   668	744	2184	org/json/JSONException
    //   756	811	2184	org/json/JSONException
    //   818	858	2184	org/json/JSONException
    //   870	886	2184	org/json/JSONException
    //   900	914	2184	org/json/JSONException
    //   914	1011	2184	org/json/JSONException
    //   1011	1191	2184	org/json/JSONException
    //   1191	1418	2184	org/json/JSONException
    //   1422	1516	2184	org/json/JSONException
    //   1520	1578	2184	org/json/JSONException
    //   1578	1618	2184	org/json/JSONException
    //   1622	1710	2184	org/json/JSONException
    //   1714	1742	2184	org/json/JSONException
    //   1742	1748	2184	org/json/JSONException
    //   1753	1789	2184	org/json/JSONException
    //   1789	1807	2184	org/json/JSONException
    //   1812	1862	2184	org/json/JSONException
    //   1862	1945	2184	org/json/JSONException
    //   1948	1976	2184	org/json/JSONException
    //   1984	2020	2184	org/json/JSONException
    //   2020	2084	2184	org/json/JSONException
    //   2087	2098	2184	org/json/JSONException
    //   2116	2181	2184	org/json/JSONException
    //   2220	2274	2184	org/json/JSONException
    //   2277	2298	2184	org/json/JSONException
    //   2303	2318	2184	org/json/JSONException
    //   2323	2349	2184	org/json/JSONException
    //   2352	2374	2184	org/json/JSONException
    //   2384	2395	2184	org/json/JSONException
    //   2399	2410	2184	org/json/JSONException
    //   2416	2433	2184	org/json/JSONException
    //   1753	1789	2301	java/lang/Exception
    //   1812	1862	2321	java/lang/Exception
    //   2020	2084	2434	java/lang/Exception
    //   412	419	2437	java/lang/Exception
    //   348	355	2442	java/lang/Exception
  }
  
  private void e()
  {
    float f1 = 10.0F;
    Object localObject2;
    Object localObject1;
    try
    {
      boolean bool = this.i.getString("clickfootervisible").equals("1");
      if (!bool) {
        return;
      }
    }
    catch (Exception localException1)
    {
      this.ai = false;
      if (this.ah != null) {
        this.ah.removeCallbacks(this.ag);
      }
      this.C = new Button(this.c);
      this.C.setText("Refresh");
      localObject2 = "#E6E6E6";
      localObject1 = "#000000";
      if (!this.l) {}
    }
    for (;;)
    {
      int i2;
      try
      {
        i2 = Math.max(this.i.getInt("clickfooterheight") - 5, 0);
        localObject3 = localObject1;
      }
      catch (Exception localException4)
      {
        Object localObject3;
        String str3;
        String str2;
        i1 = 0;
        localException5 = localException2;
        continue;
      }
      try
      {
        str3 = this.i.getString("clickfootercolor");
        localObject3 = localObject1;
        localObject2 = str3;
        str2 = this.i.getString("clicktitletextcolor");
        localObject3 = str2;
        localObject2 = str3;
        if (str3.equals("")) {
          break label479;
        }
        localObject1 = str3;
        if (str3 == null) {
          break label479;
        }
        localObject3 = str2;
        localObject2 = localObject1;
        if (!str2.equals(""))
        {
          localObject3 = str2;
          localObject2 = localObject1;
          i1 = i2;
          if (str2 != null) {}
        }
        else
        {
          localObject3 = "#000000";
          i1 = i2;
          localObject2 = localObject1;
        }
      }
      catch (Exception localException3)
      {
        i1 = i2;
        continue;
        f1 = f2;
        continue;
      }
      float f2 = i1 / 2;
      if (f2 > 10.0F)
      {
        this.C.setPadding(0, 0, 0, 0);
        this.C.setTextSize(f1);
        this.C.setTextColor(Color.parseColor((String)localObject3));
        this.C.setBackgroundColor(Color.parseColor((String)localObject2));
        this.C.setOnClickListener(new k(this));
        if (!this.l) {
          break;
        }
        try
        {
          i2 = this.i.getInt("clickfooterx");
          int i3 = this.i.getInt("clickfootery");
          int i4 = this.i.getInt("clickfooterheight");
          localObject1 = new ViewGroup.MarginLayoutParams(55, i1);
          ((ViewGroup.MarginLayoutParams)localObject1).setMargins(i2 + this.i.getInt("clickfooterwidth") - 120, i3 + (i4 - i1) / 2 + 2, 0, 0);
          localObject1 = new RelativeLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
          this.q.addView(this.C, (ViewGroup.LayoutParams)localObject1);
          return;
        }
        catch (Exception localException2)
        {
          AdLog.e("LBAdController", "Error (add Manual Poll btn before click): " + localException2.getMessage());
          AdLog.printStackTrace("LBAdController", localException2);
          return;
        }
      }
      int i1 = 0;
      Exception localException5 = localException3;
      continue;
      label479:
      String str1 = "#E6E6E6";
    }
  }
  
  private void f()
  {
    try
    {
      this.aj.stopLoading();
      try
      {
        this.b.stopLoading();
        if (this.ac != null) {
          this.ac.cancel(true);
        }
        if (this.ak != null) {
          this.ak.cancel(true);
        }
        AdLog.i("LBAdController", "closeUnlocker called");
        this.j = false;
        this.k = false;
        this.l = false;
        this.ai = false;
        this.N = true;
        this.p = false;
        this.G = true;
        this.M = false;
        this.R = false;
        this.am = false;
        this.an = false;
        this.ap = true;
        this.aq = false;
        if (this.ah != null) {
          this.ah.removeCallbacks(this.ag);
        }
        try
        {
          Class.forName("android.webkit.WebView").getMethod("onPause", null).invoke(this.aj, null);
          Class.forName("android.webkit.WebView").getMethod("onPause", null).invoke(this.b, null);
          try
          {
            this.c.runOnUiThread(new l(this));
            if (this.f != null) {
              this.f.setOnTouchListener(null);
            }
            if (this.c != null)
            {
              Object localObject1 = this.c;
              localObject1 = ((Context)localObject1).getSharedPreferences("Preference", 0);
              if (((SharedPreferences)localObject1).getBoolean("AD_CLOSEBUTTON_CLICKED", false)) {
                break label286;
              }
              g();
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              AdLog.e("LBAdController", "CloseUnlocker error - " + localException1.getMessage());
              continue;
              localObject2 = this.a;
            }
            label286:
            Object localObject2 = ((SharedPreferences)localObject2).edit();
            ((SharedPreferences.Editor)localObject2).putBoolean("AD_CLOSEBUTTON_CLICKED", false);
            ((SharedPreferences.Editor)localObject2).commit();
            return;
          }
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
      }
      catch (Exception localException3)
      {
        for (;;) {}
      }
    }
    catch (Exception localException4)
    {
      for (;;) {}
    }
  }
  
  private void g()
  {
    AdController localAdController = this;
    if (localAdController.as != null)
    {
      localAdController.as.removeCallbacks(localAdController.at);
      localAdController.as = null;
      localAdController.at = null;
      if (localAdController.c == null) {
        break label105;
      }
    }
    label105:
    for (Object localObject = localAdController.c;; localObject = localAdController.a)
    {
      localObject = ((Context)localObject).getSharedPreferences("Preference", 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("SD_IS_AUDIOTRACK_" + localAdController.t, false);
      ((SharedPreferences.Editor)localObject).commit();
      if (localAdController.ae == null) {
        return;
      }
      localAdController = localAdController.ae;
      break;
    }
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   4: ifnonnull +12 -> 16
    //   7: ldc 14
    //   9: ldc_w 1156
    //   12: invokestatic 545	com/jtpgodorncrqoeurl/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: return
    //   16: aload_0
    //   17: getfield 256	com/jtpgodorncrqoeurl/AdController:T	Landroid/media/MediaPlayer;
    //   20: ifnonnull -5 -> 15
    //   23: aload_0
    //   24: iconst_1
    //   25: putfield 179	com/jtpgodorncrqoeurl/AdController:an	Z
    //   28: aload_0
    //   29: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   32: ifnull +385 -> 417
    //   35: aload_0
    //   36: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   39: astore 6
    //   41: aload_0
    //   42: aload 6
    //   44: ldc_w 1158
    //   47: invokevirtual 1162	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   50: putfield 1164	com/jtpgodorncrqoeurl/AdController:V	Ljava/io/FileInputStream;
    //   53: ldc 14
    //   55: ldc_w 1166
    //   58: invokestatic 523	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_0
    //   62: new 1168	android/media/MediaPlayer
    //   65: dup
    //   66: invokespecial 1169	android/media/MediaPlayer:<init>	()V
    //   69: putfield 256	com/jtpgodorncrqoeurl/AdController:T	Landroid/media/MediaPlayer;
    //   72: aload_0
    //   73: getfield 256	com/jtpgodorncrqoeurl/AdController:T	Landroid/media/MediaPlayer;
    //   76: new 1171	com/jtpgodorncrqoeurl/q
    //   79: dup
    //   80: aload_0
    //   81: invokespecial 1172	com/jtpgodorncrqoeurl/q:<init>	(Lcom/jtpgodorncrqoeurl/AdController;)V
    //   84: invokevirtual 1176	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   87: aload_0
    //   88: getfield 256	com/jtpgodorncrqoeurl/AdController:T	Landroid/media/MediaPlayer;
    //   91: aload_0
    //   92: getfield 1164	com/jtpgodorncrqoeurl/AdController:V	Ljava/io/FileInputStream;
    //   95: invokevirtual 1182	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   98: invokevirtual 1186	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   101: aload_0
    //   102: getfield 256	com/jtpgodorncrqoeurl/AdController:T	Landroid/media/MediaPlayer;
    //   105: invokevirtual 1189	android/media/MediaPlayer:prepare	()V
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 253	com/jtpgodorncrqoeurl/AdController:S	Landroid/media/AudioManager;
    //   113: iconst_3
    //   114: invokevirtual 1195	android/media/AudioManager:getStreamVolume	(I)I
    //   117: putfield 250	com/jtpgodorncrqoeurl/AdController:Z	I
    //   120: aload_0
    //   121: getfield 250	com/jtpgodorncrqoeurl/AdController:Z	I
    //   124: istore_3
    //   125: aload_0
    //   126: getfield 253	com/jtpgodorncrqoeurl/AdController:S	Landroid/media/AudioManager;
    //   129: iconst_3
    //   130: invokevirtual 1198	android/media/AudioManager:getStreamMaxVolume	(I)I
    //   133: istore 5
    //   135: aload_0
    //   136: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   139: ldc_w 1200
    //   142: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   145: istore 4
    //   147: iload 4
    //   149: i2d
    //   150: dstore_1
    //   151: dload_1
    //   152: dconst_0
    //   153: dcmpl
    //   154: ifle +10 -> 164
    //   157: dload_1
    //   158: iload 5
    //   160: i2d
    //   161: dmul
    //   162: d2i
    //   163: istore_3
    //   164: iload_3
    //   165: istore 4
    //   167: iload_3
    //   168: iload 5
    //   170: if_icmple +7 -> 177
    //   173: iload 5
    //   175: istore 4
    //   177: aload_0
    //   178: getfield 237	com/jtpgodorncrqoeurl/AdController:al	Lcom/jtpgodorncrqoeurl/AdAudioListener;
    //   181: ifnull +12 -> 193
    //   184: aload_0
    //   185: getfield 237	com/jtpgodorncrqoeurl/AdController:al	Lcom/jtpgodorncrqoeurl/AdAudioListener;
    //   188: invokeinterface 1203 1 0
    //   193: aload_0
    //   194: getfield 253	com/jtpgodorncrqoeurl/AdController:S	Landroid/media/AudioManager;
    //   197: iconst_3
    //   198: iload 4
    //   200: bipush 8
    //   202: invokevirtual 1207	android/media/AudioManager:setStreamVolume	(III)V
    //   205: aload_0
    //   206: getfield 256	com/jtpgodorncrqoeurl/AdController:T	Landroid/media/MediaPlayer;
    //   209: invokevirtual 1210	android/media/MediaPlayer:start	()V
    //   212: ldc 14
    //   214: ldc_w 1212
    //   217: invokestatic 523	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload_0
    //   221: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   224: ifnull +238 -> 462
    //   227: aload_0
    //   228: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   231: astore 6
    //   233: aload 6
    //   235: ldc -54
    //   237: iconst_0
    //   238: invokevirtual 244	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   241: astore 6
    //   243: aload 6
    //   245: invokeinterface 214 1 0
    //   250: astore 7
    //   252: aload 6
    //   254: new 530	java/lang/StringBuilder
    //   257: dup
    //   258: ldc_w 1214
    //   261: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   264: aload_0
    //   265: getfield 196	com/jtpgodorncrqoeurl/AdController:t	Ljava/lang/String;
    //   268: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: iconst_0
    //   275: invokeinterface 585 3 0
    //   280: istore_3
    //   281: aload 7
    //   283: new 530	java/lang/StringBuilder
    //   286: dup
    //   287: ldc_w 1214
    //   290: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   293: aload_0
    //   294: getfield 196	com/jtpgodorncrqoeurl/AdController:t	Ljava/lang/String;
    //   297: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: iload_3
    //   304: iconst_1
    //   305: iadd
    //   306: invokeinterface 589 3 0
    //   311: pop
    //   312: aload 7
    //   314: invokeinterface 232 1 0
    //   319: pop
    //   320: ldc 14
    //   322: ldc_w 1216
    //   325: invokestatic 523	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   328: aload_0
    //   329: getfield 192	com/jtpgodorncrqoeurl/AdController:ar	Lcom/jtpgodorncrqoeurl/z;
    //   332: invokevirtual 1218	com/jtpgodorncrqoeurl/z:b	()V
    //   335: aload_0
    //   336: getfield 192	com/jtpgodorncrqoeurl/AdController:ar	Lcom/jtpgodorncrqoeurl/z;
    //   339: aload_0
    //   340: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   343: ldc_w 1220
    //   346: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   349: invokevirtual 1222	com/jtpgodorncrqoeurl/z:a	(I)V
    //   352: aload_0
    //   353: getfield 192	com/jtpgodorncrqoeurl/AdController:ar	Lcom/jtpgodorncrqoeurl/z;
    //   356: aload_0
    //   357: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   360: ldc_w 1224
    //   363: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   366: sipush 1000
    //   369: imul
    //   370: invokevirtual 1226	com/jtpgodorncrqoeurl/z:b	(I)V
    //   373: aload_0
    //   374: getfield 192	com/jtpgodorncrqoeurl/AdController:ar	Lcom/jtpgodorncrqoeurl/z;
    //   377: invokevirtual 1227	com/jtpgodorncrqoeurl/z:a	()V
    //   380: return
    //   381: astore 6
    //   383: ldc 14
    //   385: new 530	java/lang/StringBuilder
    //   388: dup
    //   389: ldc_w 1229
    //   392: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   395: aload 6
    //   397: invokevirtual 538	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   400: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 552	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   409: ldc 14
    //   411: aload 6
    //   413: invokestatic 423	com/jtpgodorncrqoeurl/AdLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   416: return
    //   417: aload_0
    //   418: getfield 241	com/jtpgodorncrqoeurl/AdController:a	Landroid/content/Context;
    //   421: astore 6
    //   423: goto -382 -> 41
    //   426: astore 6
    //   428: ldc 14
    //   430: ldc_w 1231
    //   433: invokestatic 545	com/jtpgodorncrqoeurl/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   436: ldc 14
    //   438: aload 6
    //   440: invokestatic 423	com/jtpgodorncrqoeurl/AdLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   443: goto -382 -> 61
    //   446: astore 6
    //   448: iload_3
    //   449: i2d
    //   450: iload_3
    //   451: i2d
    //   452: ldc2_w 1232
    //   455: dmul
    //   456: dadd
    //   457: d2i
    //   458: istore_3
    //   459: goto -295 -> 164
    //   462: aload_0
    //   463: getfield 241	com/jtpgodorncrqoeurl/AdController:a	Landroid/content/Context;
    //   466: astore 6
    //   468: goto -235 -> 233
    //   471: astore 6
    //   473: aload_0
    //   474: getfield 192	com/jtpgodorncrqoeurl/AdController:ar	Lcom/jtpgodorncrqoeurl/z;
    //   477: aload_0
    //   478: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   481: ldc_w 1235
    //   484: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   487: invokevirtual 1222	com/jtpgodorncrqoeurl/z:a	(I)V
    //   490: aload_0
    //   491: getfield 192	com/jtpgodorncrqoeurl/AdController:ar	Lcom/jtpgodorncrqoeurl/z;
    //   494: aload_0
    //   495: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   498: ldc_w 1237
    //   501: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   504: sipush 1000
    //   507: imul
    //   508: invokevirtual 1226	com/jtpgodorncrqoeurl/z:b	(I)V
    //   511: goto -138 -> 373
    //   514: astore 6
    //   516: goto -352 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	519	0	this	AdController
    //   150	8	1	d1	double
    //   124	335	3	i1	int
    //   145	54	4	i2	int
    //   133	41	5	i3	int
    //   39	214	6	localObject	Object
    //   381	31	6	localException1	Exception
    //   421	1	6	localContext1	Context
    //   426	13	6	localFileNotFoundException	java.io.FileNotFoundException
    //   446	1	6	localJSONException	JSONException
    //   466	1	6	localContext2	Context
    //   471	1	6	localException2	Exception
    //   514	1	6	localException3	Exception
    //   250	63	7	localEditor	SharedPreferences.Editor
    // Exception table:
    //   from	to	target	type
    //   87	135	381	java/lang/Exception
    //   177	193	381	java/lang/Exception
    //   193	233	381	java/lang/Exception
    //   233	335	381	java/lang/Exception
    //   373	380	381	java/lang/Exception
    //   462	468	381	java/lang/Exception
    //   473	511	381	java/lang/Exception
    //   28	41	426	java/io/FileNotFoundException
    //   41	61	426	java/io/FileNotFoundException
    //   417	423	426	java/io/FileNotFoundException
    //   135	147	446	org/json/JSONException
    //   335	373	471	java/lang/Exception
    //   135	147	514	java/lang/Exception
  }
  
  private void i()
  {
    if (this.al != null) {
      this.al.onAdClosed();
    }
    if (this.ac != null) {
      this.ac.cancel(true);
    }
    if (this.ak != null) {
      this.ak.cancel(true);
    }
    this.ar.c();
    if (this.T != null)
    {
      if (this.T.isPlaying()) {
        this.T.stop();
      }
      this.T.release();
      this.T = null;
    }
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   4: ifnull +1395 -> 1399
    //   7: aload_0
    //   8: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   11: ldc_w 704
    //   14: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: ldc_w 1248
    //   20: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: istore 10
    //   25: iload 10
    //   27: ifeq +6 -> 33
    //   30: return
    //   31: astore 17
    //   33: aload_0
    //   34: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   37: ifnull +946 -> 983
    //   40: aload_0
    //   41: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   44: astore 19
    //   46: aload 19
    //   48: ldc -54
    //   50: iconst_0
    //   51: invokevirtual 244	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   54: pop
    //   55: aload 19
    //   57: ldc_w 1250
    //   60: invokevirtual 1253	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   63: checkcast 575	android/app/NotificationManager
    //   66: astore 20
    //   68: ldc_w 1255
    //   71: astore 18
    //   73: aload_0
    //   74: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   77: ldc_w 1257
    //   80: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 17
    //   85: aload 17
    //   87: astore 18
    //   89: ldc_w 1259
    //   92: astore 17
    //   94: aload 18
    //   96: ldc_w 1255
    //   99: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifeq +898 -> 1000
    //   105: aload 17
    //   107: astore 18
    //   109: aload 19
    //   111: invokevirtual 1263	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   114: astore 21
    //   116: aload 17
    //   118: astore 18
    //   120: new 1265	android/content/Intent
    //   123: dup
    //   124: ldc_w 1267
    //   127: aconst_null
    //   128: invokespecial 1270	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   131: astore 22
    //   133: aload 17
    //   135: astore 18
    //   137: aload 22
    //   139: ldc_w 1272
    //   142: invokevirtual 1276	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   145: pop
    //   146: aload 17
    //   148: astore 18
    //   150: aload 22
    //   152: aload 19
    //   154: invokevirtual 1279	android/content/Context:getPackageName	()Ljava/lang/String;
    //   157: invokevirtual 1282	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   160: pop
    //   161: aload 17
    //   163: astore 18
    //   165: aload 21
    //   167: aload 22
    //   169: iconst_0
    //   170: invokevirtual 1288	android/content/pm/PackageManager:queryIntentActivities	(Landroid/content/Intent;I)Ljava/util/List;
    //   173: invokeinterface 1294 1 0
    //   178: astore 21
    //   180: aload 17
    //   182: astore 18
    //   184: aload 21
    //   186: invokeinterface 1299 1 0
    //   191: ifeq +806 -> 997
    //   194: aload 17
    //   196: astore 18
    //   198: aload 21
    //   200: invokeinterface 1302 1 0
    //   205: checkcast 1304	android/content/pm/ResolveInfo
    //   208: astore 22
    //   210: aload 22
    //   212: getfield 1308	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   215: getfield 1313	android/content/pm/ActivityInfo:name	Ljava/lang/String;
    //   218: astore 22
    //   220: aload 22
    //   222: invokestatic 903	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   225: astore 18
    //   227: aload 18
    //   229: astore 17
    //   231: ldc 14
    //   233: new 530	java/lang/StringBuilder
    //   236: dup
    //   237: ldc_w 1315
    //   240: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   243: aload 22
    //   245: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 552	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: new 1265	android/content/Intent
    //   257: dup
    //   258: aload 19
    //   260: aload 17
    //   262: invokespecial 1318	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   265: astore 17
    //   267: aload 17
    //   269: ldc_w 1319
    //   272: invokevirtual 1323	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   275: pop
    //   276: aload 17
    //   278: ldc_w 1325
    //   281: aload_0
    //   282: getfield 196	com/jtpgodorncrqoeurl/AdController:t	Ljava/lang/String;
    //   285: invokevirtual 1329	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   288: pop
    //   289: aload 19
    //   291: iconst_0
    //   292: aload 17
    //   294: iconst_0
    //   295: invokestatic 1335	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   298: astore 21
    //   300: ldc 14
    //   302: ldc_w 1337
    //   305: invokestatic 552	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: iconst_m1
    //   309: istore 4
    //   311: aload 19
    //   313: invokevirtual 1263	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   316: aload 19
    //   318: invokevirtual 1279	android/content/Context:getPackageName	()Ljava/lang/String;
    //   321: iconst_0
    //   322: invokevirtual 1341	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   325: getfield 1346	android/content/pm/ApplicationInfo:icon	I
    //   328: istore_1
    //   329: iload_1
    //   330: istore 4
    //   332: ldc_w 1348
    //   335: astore 17
    //   337: aload_0
    //   338: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   341: ldc_w 1350
    //   344: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   347: astore 18
    //   349: aload 18
    //   351: astore 17
    //   353: iconst_m1
    //   354: istore 5
    //   356: iconst_m1
    //   357: istore 6
    //   359: iconst_m1
    //   360: istore 7
    //   362: iload 7
    //   364: istore_3
    //   365: iload 6
    //   367: istore_2
    //   368: iload 5
    //   370: istore_1
    //   371: new 530	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 669	java/lang/StringBuilder:<init>	()V
    //   378: aload 19
    //   380: invokevirtual 1279	android/content/Context:getPackageName	()Ljava/lang/String;
    //   383: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: ldc_w 1352
    //   389: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 903	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   398: astore 18
    //   400: iload 7
    //   402: istore_3
    //   403: iload 6
    //   405: istore_2
    //   406: iload 5
    //   408: istore_1
    //   409: aload 18
    //   411: ldc_w 1354
    //   414: invokevirtual 1358	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   417: aload 18
    //   419: invokevirtual 1361	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   422: istore 5
    //   424: iload 7
    //   426: istore_3
    //   427: iload 6
    //   429: istore_2
    //   430: iload 5
    //   432: istore_1
    //   433: new 530	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 669	java/lang/StringBuilder:<init>	()V
    //   440: aload 19
    //   442: invokevirtual 1279	android/content/Context:getPackageName	()Ljava/lang/String;
    //   445: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: ldc_w 1363
    //   451: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 903	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   460: astore 18
    //   462: iload 7
    //   464: istore_3
    //   465: iload 6
    //   467: istore_2
    //   468: iload 5
    //   470: istore_1
    //   471: aload 18
    //   473: ldc_w 1365
    //   476: invokevirtual 1358	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   479: aload 18
    //   481: invokevirtual 1361	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   484: istore 6
    //   486: iload 7
    //   488: istore_3
    //   489: iload 6
    //   491: istore_2
    //   492: iload 5
    //   494: istore_1
    //   495: aload 18
    //   497: ldc_w 1367
    //   500: invokevirtual 1358	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   503: aload 18
    //   505: invokevirtual 1361	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   508: istore 7
    //   510: iload 7
    //   512: istore_3
    //   513: iload 6
    //   515: istore_2
    //   516: iload 5
    //   518: istore_1
    //   519: aload 18
    //   521: ldc_w 1369
    //   524: invokevirtual 1358	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   527: aload 18
    //   529: invokevirtual 1361	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   532: istore 8
    //   534: iload 7
    //   536: istore_1
    //   537: iload 6
    //   539: istore_3
    //   540: iload 8
    //   542: istore_2
    //   543: aload_0
    //   544: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   547: ldc_w 1371
    //   550: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   553: astore 18
    //   555: aload_0
    //   556: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   559: ldc_w 1373
    //   562: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   565: astore 22
    //   567: aload_0
    //   568: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   571: ldc_w 1375
    //   574: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   577: astore 23
    //   579: aload 17
    //   581: ldc_w 1377
    //   584: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   587: ifeq +548 -> 1135
    //   590: iload 5
    //   592: iconst_m1
    //   593: if_icmpeq +542 -> 1135
    //   596: iload_3
    //   597: iconst_m1
    //   598: if_icmpeq +537 -> 1135
    //   601: iload_2
    //   602: iconst_m1
    //   603: if_icmpeq +532 -> 1135
    //   606: new 530	java/lang/StringBuilder
    //   609: dup
    //   610: invokespecial 669	java/lang/StringBuilder:<init>	()V
    //   613: aload_0
    //   614: getfield 241	com/jtpgodorncrqoeurl/AdController:a	Landroid/content/Context;
    //   617: invokevirtual 1279	android/content/Context:getPackageName	()Ljava/lang/String;
    //   620: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: ldc_w 1363
    //   626: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokestatic 903	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   635: astore 17
    //   637: aload 17
    //   639: ldc_w 1379
    //   642: invokevirtual 1358	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   645: aload 17
    //   647: invokevirtual 1361	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   650: istore 6
    //   652: aload 17
    //   654: ldc_w 1381
    //   657: invokevirtual 1358	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   660: aload 17
    //   662: invokevirtual 1361	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   665: istore 7
    //   667: aload 17
    //   669: ldc_w 1383
    //   672: invokevirtual 1358	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   675: aload 17
    //   677: invokevirtual 1361	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   680: istore 8
    //   682: aload 17
    //   684: ldc_w 1385
    //   687: invokevirtual 1358	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   690: aload 17
    //   692: invokevirtual 1361	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   695: istore 9
    //   697: iload_2
    //   698: iconst_m1
    //   699: if_icmpeq +409 -> 1108
    //   702: iload 6
    //   704: iconst_m1
    //   705: if_icmpeq +403 -> 1108
    //   708: iload 7
    //   710: iconst_m1
    //   711: if_icmpeq +397 -> 1108
    //   714: iload 8
    //   716: iconst_m1
    //   717: if_icmpeq +391 -> 1108
    //   720: iload 9
    //   722: iconst_m1
    //   723: if_icmpeq +385 -> 1108
    //   726: new 1387	android/widget/RemoteViews
    //   729: dup
    //   730: aload_0
    //   731: getfield 241	com/jtpgodorncrqoeurl/AdController:a	Landroid/content/Context;
    //   734: invokevirtual 1279	android/content/Context:getPackageName	()Ljava/lang/String;
    //   737: iload 5
    //   739: invokespecial 1390	android/widget/RemoteViews:<init>	(Ljava/lang/String;I)V
    //   742: astore 17
    //   744: aload 17
    //   746: iload_3
    //   747: ldc_w 1391
    //   750: aload_0
    //   751: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   754: ldc_w 1393
    //   757: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   760: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   763: invokevirtual 1397	android/widget/RemoteViews:setInt	(ILjava/lang/String;I)V
    //   766: aload 17
    //   768: iload 6
    //   770: aload_0
    //   771: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   774: ldc_w 1399
    //   777: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   780: invokevirtual 1403	android/widget/RemoteViews:setTextViewText	(ILjava/lang/CharSequence;)V
    //   783: aload 17
    //   785: iload 6
    //   787: aload_0
    //   788: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   791: ldc_w 1405
    //   794: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   797: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   800: invokevirtual 1407	android/widget/RemoteViews:setTextColor	(II)V
    //   803: aload 17
    //   805: iload 7
    //   807: aload_0
    //   808: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   811: ldc_w 1409
    //   814: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   817: invokevirtual 1403	android/widget/RemoteViews:setTextViewText	(ILjava/lang/CharSequence;)V
    //   820: aload 17
    //   822: iload 7
    //   824: aload_0
    //   825: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   828: ldc_w 1411
    //   831: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   834: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   837: invokevirtual 1407	android/widget/RemoteViews:setTextColor	(II)V
    //   840: aload 17
    //   842: iload 8
    //   844: aload_0
    //   845: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   848: ldc_w 1413
    //   851: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   854: invokevirtual 1403	android/widget/RemoteViews:setTextViewText	(ILjava/lang/CharSequence;)V
    //   857: aload 17
    //   859: iload 8
    //   861: aload_0
    //   862: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   865: ldc_w 1415
    //   868: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   871: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   874: invokevirtual 1407	android/widget/RemoteViews:setTextColor	(II)V
    //   877: aload 17
    //   879: iload 9
    //   881: aload_0
    //   882: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   885: ldc_w 1417
    //   888: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   891: invokevirtual 1403	android/widget/RemoteViews:setTextViewText	(ILjava/lang/CharSequence;)V
    //   894: aload 17
    //   896: iload 9
    //   898: aload_0
    //   899: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   902: ldc_w 1419
    //   905: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   908: invokestatic 802	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   911: invokevirtual 1407	android/widget/RemoteViews:setTextColor	(II)V
    //   914: iload_1
    //   915: iconst_m1
    //   916: if_icmpeq +10 -> 926
    //   919: aload 17
    //   921: iload_1
    //   922: iconst_4
    //   923: invokevirtual 1422	android/widget/RemoteViews:setViewVisibility	(II)V
    //   926: iload 4
    //   928: iconst_m1
    //   929: if_icmpeq -899 -> 30
    //   932: aload_0
    //   933: aload 19
    //   935: iload 4
    //   937: aload 18
    //   939: aload 22
    //   941: aload 23
    //   943: aload 20
    //   945: aload 21
    //   947: aload 17
    //   949: invokespecial 601	com/jtpgodorncrqoeurl/AdController:a	(Landroid/content/Context;ILjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/NotificationManager;Landroid/app/PendingIntent;Landroid/widget/RemoteViews;)Z
    //   952: pop
    //   953: return
    //   954: astore 17
    //   956: iload 4
    //   958: iconst_m1
    //   959: if_icmpeq -929 -> 30
    //   962: aload_0
    //   963: aload 19
    //   965: iload 4
    //   967: aload 18
    //   969: aload 22
    //   971: aload 23
    //   973: aload 20
    //   975: aload 21
    //   977: aconst_null
    //   978: invokespecial 601	com/jtpgodorncrqoeurl/AdController:a	(Landroid/content/Context;ILjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/NotificationManager;Landroid/app/PendingIntent;Landroid/widget/RemoteViews;)Z
    //   981: pop
    //   982: return
    //   983: aload_0
    //   984: getfield 241	com/jtpgodorncrqoeurl/AdController:a	Landroid/content/Context;
    //   987: astore 19
    //   989: goto -943 -> 46
    //   992: astore 18
    //   994: goto -814 -> 180
    //   997: goto -743 -> 254
    //   1000: aload 18
    //   1002: ldc_w 1424
    //   1005: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1008: ifeq +39 -> 1047
    //   1011: aconst_null
    //   1012: astore 17
    //   1014: aload_0
    //   1015: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1018: ldc_w 1426
    //   1021: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1024: astore 18
    //   1026: aload 18
    //   1028: astore 17
    //   1030: aload 17
    //   1032: ifnull +15 -> 1047
    //   1035: aload 17
    //   1037: invokestatic 903	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1040: astore 17
    //   1042: goto -788 -> 254
    //   1045: astore 17
    //   1047: ldc_w 1259
    //   1050: astore 17
    //   1052: goto -798 -> 254
    //   1055: astore 17
    //   1057: ldc 14
    //   1059: new 530	java/lang/StringBuilder
    //   1062: dup
    //   1063: ldc_w 1428
    //   1066: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1069: aload 17
    //   1071: invokevirtual 538	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1074: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1080: invokestatic 545	com/jtpgodorncrqoeurl/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1083: goto -751 -> 332
    //   1086: astore 18
    //   1088: iload_2
    //   1089: istore 5
    //   1091: iload_1
    //   1092: istore 6
    //   1094: iconst_m1
    //   1095: istore_2
    //   1096: iload_3
    //   1097: istore_1
    //   1098: iload 5
    //   1100: istore_3
    //   1101: iload 6
    //   1103: istore 5
    //   1105: goto -562 -> 543
    //   1108: iload 4
    //   1110: iconst_m1
    //   1111: if_icmpeq -1081 -> 30
    //   1114: aload_0
    //   1115: aload 19
    //   1117: iload 4
    //   1119: aload 18
    //   1121: aload 22
    //   1123: aload 23
    //   1125: aload 20
    //   1127: aload 21
    //   1129: aconst_null
    //   1130: invokespecial 601	com/jtpgodorncrqoeurl/AdController:a	(Landroid/content/Context;ILjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/NotificationManager;Landroid/app/PendingIntent;Landroid/widget/RemoteViews;)Z
    //   1133: pop
    //   1134: return
    //   1135: aload 17
    //   1137: ldc_w 1430
    //   1140: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1143: ifeq +229 -> 1372
    //   1146: iload 5
    //   1148: iconst_m1
    //   1149: if_icmpeq +223 -> 1372
    //   1152: iload_1
    //   1153: iconst_m1
    //   1154: if_icmpeq +218 -> 1372
    //   1157: new 530	java/lang/StringBuilder
    //   1160: dup
    //   1161: invokespecial 669	java/lang/StringBuilder:<init>	()V
    //   1164: aload_0
    //   1165: getfield 241	com/jtpgodorncrqoeurl/AdController:a	Landroid/content/Context;
    //   1168: invokevirtual 1279	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1171: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1174: ldc_w 1363
    //   1177: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1180: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1183: invokestatic 903	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1186: astore 17
    //   1188: aload 17
    //   1190: ldc_w 1432
    //   1193: invokevirtual 1358	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   1196: aload 17
    //   1198: invokevirtual 1361	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   1201: istore_2
    //   1202: aload 17
    //   1204: ldc_w 1434
    //   1207: invokevirtual 1358	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   1210: aload 17
    //   1212: invokevirtual 1361	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   1215: istore_3
    //   1216: iload_1
    //   1217: iconst_m1
    //   1218: if_icmpeq +119 -> 1337
    //   1221: iload_2
    //   1222: iconst_m1
    //   1223: if_icmpeq +114 -> 1337
    //   1226: iload_3
    //   1227: iconst_m1
    //   1228: if_icmpeq +109 -> 1337
    //   1231: new 1436	com/jtpgodorncrqoeurl/D
    //   1234: dup
    //   1235: aload_0
    //   1236: aload 19
    //   1238: iload 4
    //   1240: aload 18
    //   1242: aload 22
    //   1244: aload 23
    //   1246: aload 20
    //   1248: aload 21
    //   1250: invokespecial 1439	com/jtpgodorncrqoeurl/D:<init>	(Lcom/jtpgodorncrqoeurl/AdController;Landroid/content/Context;ILjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/NotificationManager;Landroid/app/PendingIntent;)V
    //   1253: iconst_1
    //   1254: anewarray 303	java/lang/String
    //   1257: dup
    //   1258: iconst_0
    //   1259: aload_0
    //   1260: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   1263: ldc_w 1441
    //   1266: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1269: aastore
    //   1270: invokevirtual 1442	com/jtpgodorncrqoeurl/D:execute	([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   1273: pop
    //   1274: return
    //   1275: astore 17
    //   1277: ldc 14
    //   1279: new 530	java/lang/StringBuilder
    //   1282: dup
    //   1283: ldc_w 1444
    //   1286: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1289: aload 17
    //   1291: invokevirtual 538	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1294: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1297: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1300: invokestatic 552	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1303: ldc 14
    //   1305: aload 17
    //   1307: invokestatic 423	com/jtpgodorncrqoeurl/AdLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   1310: iload 4
    //   1312: iconst_m1
    //   1313: if_icmpeq -1283 -> 30
    //   1316: aload_0
    //   1317: aload 19
    //   1319: iload 4
    //   1321: aload 18
    //   1323: aload 22
    //   1325: aload 23
    //   1327: aload 20
    //   1329: aload 21
    //   1331: aconst_null
    //   1332: invokespecial 601	com/jtpgodorncrqoeurl/AdController:a	(Landroid/content/Context;ILjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/NotificationManager;Landroid/app/PendingIntent;Landroid/widget/RemoteViews;)Z
    //   1335: pop
    //   1336: return
    //   1337: iload 4
    //   1339: iconst_m1
    //   1340: if_icmpeq -1310 -> 30
    //   1343: ldc 14
    //   1345: ldc_w 1446
    //   1348: invokestatic 552	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1351: aload_0
    //   1352: aload 19
    //   1354: iload 4
    //   1356: aload 18
    //   1358: aload 22
    //   1360: aload 23
    //   1362: aload 20
    //   1364: aload 21
    //   1366: aconst_null
    //   1367: invokespecial 601	com/jtpgodorncrqoeurl/AdController:a	(Landroid/content/Context;ILjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/NotificationManager;Landroid/app/PendingIntent;Landroid/widget/RemoteViews;)Z
    //   1370: pop
    //   1371: return
    //   1372: iload 4
    //   1374: iconst_m1
    //   1375: if_icmpeq -1345 -> 30
    //   1378: aload_0
    //   1379: aload 19
    //   1381: iload 4
    //   1383: aload 18
    //   1385: aload 22
    //   1387: aload 23
    //   1389: aload 20
    //   1391: aload 21
    //   1393: aconst_null
    //   1394: invokespecial 601	com/jtpgodorncrqoeurl/AdController:a	(Landroid/content/Context;ILjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/NotificationManager;Landroid/app/PendingIntent;Landroid/widget/RemoteViews;)Z
    //   1397: pop
    //   1398: return
    //   1399: aload_0
    //   1400: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   1403: ifnull +331 -> 1734
    //   1406: aload_0
    //   1407: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   1410: astore 17
    //   1412: aload 17
    //   1414: ldc -54
    //   1416: iconst_0
    //   1417: invokevirtual 244	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1420: astore 17
    //   1422: aload 17
    //   1424: invokeinterface 214 1 0
    //   1429: astore 18
    //   1431: aload 17
    //   1433: new 530	java/lang/StringBuilder
    //   1436: dup
    //   1437: ldc_w 1448
    //   1440: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1443: aload_0
    //   1444: getfield 196	com/jtpgodorncrqoeurl/AdController:t	Ljava/lang/String;
    //   1447: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1450: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1453: ldc_w 1248
    //   1456: invokeinterface 469 3 0
    //   1461: invokestatic 1450	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1464: invokevirtual 405	java/lang/Integer:intValue	()I
    //   1467: i2l
    //   1468: lstore 11
    //   1470: invokestatic 558	java/lang/System:currentTimeMillis	()J
    //   1473: lstore 13
    //   1475: lload 11
    //   1477: ldc2_w 1451
    //   1480: lcmp
    //   1481: ifle +262 -> 1743
    //   1484: aload 17
    //   1486: new 530	java/lang/StringBuilder
    //   1489: dup
    //   1490: ldc_w 1454
    //   1493: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1496: aload_0
    //   1497: getfield 196	com/jtpgodorncrqoeurl/AdController:t	Ljava/lang/String;
    //   1500: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1503: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1506: lconst_0
    //   1507: invokeinterface 1458 4 0
    //   1512: lstore 15
    //   1514: ldc 14
    //   1516: new 530	java/lang/StringBuilder
    //   1519: dup
    //   1520: ldc_w 1460
    //   1523: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1526: lload 15
    //   1528: invokevirtual 1463	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1531: ldc_w 941
    //   1534: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1540: invokestatic 523	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1543: ldc 14
    //   1545: new 530	java/lang/StringBuilder
    //   1548: dup
    //   1549: ldc_w 1465
    //   1552: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1555: lload 11
    //   1557: invokevirtual 1463	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1560: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1563: invokestatic 523	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1566: lload 15
    //   1568: ldc2_w 1466
    //   1571: lmul
    //   1572: lload 13
    //   1574: ladd
    //   1575: lstore 11
    //   1577: aload 18
    //   1579: new 530	java/lang/StringBuilder
    //   1582: dup
    //   1583: ldc_w 1469
    //   1586: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1589: aload_0
    //   1590: getfield 196	com/jtpgodorncrqoeurl/AdController:t	Ljava/lang/String;
    //   1593: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1596: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1599: lload 11
    //   1601: invokeinterface 1473 4 0
    //   1606: pop
    //   1607: aload 18
    //   1609: new 530	java/lang/StringBuilder
    //   1612: dup
    //   1613: ldc_w 1448
    //   1616: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1619: aload_0
    //   1620: getfield 196	com/jtpgodorncrqoeurl/AdController:t	Ljava/lang/String;
    //   1623: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1626: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1629: ldc_w 1248
    //   1632: invokeinterface 224 3 0
    //   1637: pop
    //   1638: aload 18
    //   1640: invokeinterface 232 1 0
    //   1645: pop
    //   1646: aload_0
    //   1647: aload_0
    //   1648: getfield 241	com/jtpgodorncrqoeurl/AdController:a	Landroid/content/Context;
    //   1651: ldc_w 1475
    //   1654: invokevirtual 1253	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1657: checkcast 1477	android/app/AlarmManager
    //   1660: putfield 1479	com/jtpgodorncrqoeurl/AdController:ab	Landroid/app/AlarmManager;
    //   1663: new 1265	android/content/Intent
    //   1666: dup
    //   1667: aload_0
    //   1668: getfield 241	com/jtpgodorncrqoeurl/AdController:a	Landroid/content/Context;
    //   1671: ldc_w 1481
    //   1674: invokespecial 1318	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1677: astore 17
    //   1679: aload 17
    //   1681: ldc_w 1325
    //   1684: aload_0
    //   1685: getfield 196	com/jtpgodorncrqoeurl/AdController:t	Ljava/lang/String;
    //   1688: invokevirtual 1329	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1691: pop
    //   1692: aload_0
    //   1693: aload_0
    //   1694: getfield 241	com/jtpgodorncrqoeurl/AdController:a	Landroid/content/Context;
    //   1697: iconst_0
    //   1698: aload 17
    //   1700: ldc_w 1482
    //   1703: invokestatic 1485	android/app/PendingIntent:getBroadcast	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   1706: putfield 1487	com/jtpgodorncrqoeurl/AdController:aa	Landroid/app/PendingIntent;
    //   1709: aload_0
    //   1710: getfield 1479	com/jtpgodorncrqoeurl/AdController:ab	Landroid/app/AlarmManager;
    //   1713: iconst_0
    //   1714: lload 11
    //   1716: aload_0
    //   1717: getfield 1487	com/jtpgodorncrqoeurl/AdController:aa	Landroid/app/PendingIntent;
    //   1720: invokevirtual 1490	android/app/AlarmManager:set	(IJLandroid/app/PendingIntent;)V
    //   1723: return
    //   1724: astore 17
    //   1726: ldc 14
    //   1728: aload 17
    //   1730: invokestatic 423	com/jtpgodorncrqoeurl/AdLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   1733: return
    //   1734: aload_0
    //   1735: getfield 241	com/jtpgodorncrqoeurl/AdController:a	Landroid/content/Context;
    //   1738: astore 17
    //   1740: goto -328 -> 1412
    //   1743: lload 11
    //   1745: ldc2_w 1491
    //   1748: lrem
    //   1749: lconst_0
    //   1750: lcmp
    //   1751: ifne +82 -> 1833
    //   1754: lload 11
    //   1756: lconst_0
    //   1757: lcmp
    //   1758: ifle +75 -> 1833
    //   1761: ldc 14
    //   1763: ldc_w 1494
    //   1766: invokestatic 523	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1769: aload 18
    //   1771: new 530	java/lang/StringBuilder
    //   1774: dup
    //   1775: ldc_w 1448
    //   1778: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1781: aload_0
    //   1782: getfield 196	com/jtpgodorncrqoeurl/AdController:t	Ljava/lang/String;
    //   1785: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1788: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1791: new 530	java/lang/StringBuilder
    //   1794: dup
    //   1795: invokespecial 669	java/lang/StringBuilder:<init>	()V
    //   1798: lload 11
    //   1800: lconst_1
    //   1801: ladd
    //   1802: invokevirtual 1463	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1805: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1808: invokeinterface 224 3 0
    //   1813: pop
    //   1814: aload 18
    //   1816: invokeinterface 232 1 0
    //   1821: pop
    //   1822: ldc2_w 1495
    //   1825: lload 13
    //   1827: ladd
    //   1828: lstore 11
    //   1830: goto -184 -> 1646
    //   1833: ldc 14
    //   1835: ldc_w 1498
    //   1838: invokestatic 523	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1841: aload 18
    //   1843: new 530	java/lang/StringBuilder
    //   1846: dup
    //   1847: ldc_w 1448
    //   1850: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1853: aload_0
    //   1854: getfield 196	com/jtpgodorncrqoeurl/AdController:t	Ljava/lang/String;
    //   1857: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1860: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1863: new 530	java/lang/StringBuilder
    //   1866: dup
    //   1867: invokespecial 669	java/lang/StringBuilder:<init>	()V
    //   1870: lload 11
    //   1872: lconst_1
    //   1873: ladd
    //   1874: invokevirtual 1463	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1877: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1880: invokeinterface 224 3 0
    //   1885: pop
    //   1886: aload 18
    //   1888: invokeinterface 232 1 0
    //   1893: pop
    //   1894: ldc2_w 1499
    //   1897: lload 13
    //   1899: ladd
    //   1900: lstore 11
    //   1902: goto -256 -> 1646
    //   1905: astore 24
    //   1907: goto -993 -> 914
    //   1910: astore 24
    //   1912: goto -1035 -> 877
    //   1915: astore 24
    //   1917: goto -1077 -> 840
    //   1920: astore 24
    //   1922: goto -1119 -> 803
    //   1925: astore 24
    //   1927: goto -1161 -> 766
    //   1930: astore 17
    //   1932: return
    //   1933: astore 18
    //   1935: goto -1582 -> 353
    //   1938: astore 18
    //   1940: goto -910 -> 1030
    //   1943: astore 17
    //   1945: aload 18
    //   1947: astore 17
    //   1949: goto -1695 -> 254
    //   1952: astore 18
    //   1954: goto -960 -> 994
    //   1957: astore 17
    //   1959: goto -1870 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1962	0	this	AdController
    //   328	891	1	i1	int
    //   367	857	2	i2	int
    //   364	865	3	i3	int
    //   309	1073	4	i4	int
    //   354	796	5	i5	int
    //   357	745	6	i6	int
    //   360	463	7	i7	int
    //   532	328	8	i8	int
    //   695	202	9	i9	int
    //   23	3	10	bool	boolean
    //   1468	433	11	l1	long
    //   1473	425	13	l2	long
    //   1512	55	15	l3	long
    //   31	1	17	localException1	Exception
    //   83	865	17	localObject1	Object
    //   954	1	17	localException2	Exception
    //   1012	29	17	localObject2	Object
    //   1045	1	17	localException3	Exception
    //   1050	1	17	localClass1	Class
    //   1055	81	17	localException4	Exception
    //   1186	25	17	localClass2	Class
    //   1275	31	17	localException5	Exception
    //   1410	289	17	localObject3	Object
    //   1724	5	17	localException6	Exception
    //   1738	1	17	localContext	Context
    //   1930	1	17	localException7	Exception
    //   1943	1	17	localException8	Exception
    //   1947	1	17	localObject4	Object
    //   1957	1	17	localException9	Exception
    //   71	897	18	localObject5	Object
    //   992	9	18	localException10	Exception
    //   1024	3	18	str1	String
    //   1086	298	18	localException11	Exception
    //   1429	458	18	localEditor	SharedPreferences.Editor
    //   1933	1	18	localException12	Exception
    //   1938	8	18	localException13	Exception
    //   1952	1	18	localException14	Exception
    //   44	1336	19	localObject6	Object
    //   66	1324	20	localNotificationManager	NotificationManager
    //   114	1278	21	localObject7	Object
    //   131	1255	22	localObject8	Object
    //   577	811	23	str2	String
    //   1905	1	24	localException15	Exception
    //   1910	1	24	localException16	Exception
    //   1915	1	24	localException17	Exception
    //   1920	1	24	localException18	Exception
    //   1925	1	24	localException19	Exception
    // Exception table:
    //   from	to	target	type
    //   7	25	31	java/lang/Exception
    //   606	697	954	java/lang/Exception
    //   726	744	954	java/lang/Exception
    //   766	783	954	java/lang/Exception
    //   803	820	954	java/lang/Exception
    //   840	857	954	java/lang/Exception
    //   877	894	954	java/lang/Exception
    //   919	926	954	java/lang/Exception
    //   932	953	954	java/lang/Exception
    //   1114	1134	954	java/lang/Exception
    //   231	254	992	java/lang/Exception
    //   1035	1042	1045	java/lang/Exception
    //   311	329	1055	java/lang/Exception
    //   371	400	1086	java/lang/Exception
    //   409	424	1086	java/lang/Exception
    //   433	462	1086	java/lang/Exception
    //   471	486	1086	java/lang/Exception
    //   495	510	1086	java/lang/Exception
    //   519	534	1086	java/lang/Exception
    //   1157	1216	1275	java/lang/Exception
    //   1231	1274	1275	java/lang/Exception
    //   1343	1371	1275	java/lang/Exception
    //   1709	1723	1724	java/lang/Exception
    //   894	914	1905	java/lang/Exception
    //   857	877	1910	java/lang/Exception
    //   820	840	1915	java/lang/Exception
    //   783	803	1920	java/lang/Exception
    //   744	766	1925	java/lang/Exception
    //   543	579	1930	java/lang/Exception
    //   337	349	1933	java/lang/Exception
    //   1014	1026	1938	java/lang/Exception
    //   109	116	1943	java/lang/Exception
    //   120	133	1943	java/lang/Exception
    //   137	146	1943	java/lang/Exception
    //   150	161	1943	java/lang/Exception
    //   165	180	1943	java/lang/Exception
    //   184	194	1943	java/lang/Exception
    //   198	210	1943	java/lang/Exception
    //   210	227	1952	java/lang/Exception
    //   73	85	1957	java/lang/Exception
  }
  
  /* Error */
  public void adInitialized()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 147	com/jtpgodorncrqoeurl/AdController:p	Z
    //   5: aload_0
    //   6: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   9: ifnull +122 -> 131
    //   12: aload_0
    //   13: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   16: astore_3
    //   17: aload_3
    //   18: ldc -54
    //   20: iconst_0
    //   21: invokevirtual 244	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   24: astore_3
    //   25: aload_3
    //   26: invokeinterface 214 1 0
    //   31: astore 4
    //   33: aload_0
    //   34: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   37: ifnull +966 -> 1003
    //   40: aload 4
    //   42: ldc_w 1526
    //   45: aload_0
    //   46: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   49: ldc_w 1526
    //   52: invokevirtual 1529	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   55: invokeinterface 1473 4 0
    //   60: pop
    //   61: aload 4
    //   63: invokeinterface 232 1 0
    //   68: pop
    //   69: aload_0
    //   70: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   73: ldc_w 704
    //   76: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   79: ldc_w 1248
    //   82: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifeq +56 -> 141
    //   88: aload_0
    //   89: getfield 169	com/jtpgodorncrqoeurl/AdController:ad	Lcom/jtpgodorncrqoeurl/AdListener;
    //   92: ifnull +17 -> 109
    //   95: aload_0
    //   96: iconst_1
    //   97: putfield 155	com/jtpgodorncrqoeurl/AdController:M	Z
    //   100: aload_0
    //   101: getfield 169	com/jtpgodorncrqoeurl/AdController:ad	Lcom/jtpgodorncrqoeurl/AdListener;
    //   104: invokeinterface 977 1 0
    //   109: aload_0
    //   110: getfield 237	com/jtpgodorncrqoeurl/AdController:al	Lcom/jtpgodorncrqoeurl/AdAudioListener;
    //   113: ifnull +17 -> 130
    //   116: aload_0
    //   117: iconst_1
    //   118: putfield 179	com/jtpgodorncrqoeurl/AdController:an	Z
    //   121: aload_0
    //   122: getfield 237	com/jtpgodorncrqoeurl/AdController:al	Lcom/jtpgodorncrqoeurl/AdAudioListener;
    //   125: invokeinterface 980 1 0
    //   130: return
    //   131: aload_0
    //   132: getfield 241	com/jtpgodorncrqoeurl/AdController:a	Landroid/content/Context;
    //   135: astore_3
    //   136: goto -119 -> 17
    //   139: astore 5
    //   141: aload_0
    //   142: aload_0
    //   143: getfield 196	com/jtpgodorncrqoeurl/AdController:t	Ljava/lang/String;
    //   146: putfield 181	com/jtpgodorncrqoeurl/AdController:ao	Ljava/lang/String;
    //   149: aload_0
    //   150: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   153: ifnull +230 -> 383
    //   156: new 1531	android/util/DisplayMetrics
    //   159: dup
    //   160: invokespecial 1532	android/util/DisplayMetrics:<init>	()V
    //   163: astore 5
    //   165: aload_0
    //   166: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   169: invokevirtual 1536	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   172: invokeinterface 1542 1 0
    //   177: aload 5
    //   179: invokevirtual 1548	android/view/Display:getMetrics	(Landroid/util/DisplayMetrics;)V
    //   182: new 1550	android/graphics/Rect
    //   185: dup
    //   186: invokespecial 1551	android/graphics/Rect:<init>	()V
    //   189: astore 6
    //   191: aload_0
    //   192: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   195: invokevirtual 1555	android/app/Activity:getWindow	()Landroid/view/Window;
    //   198: astore 7
    //   200: aload 7
    //   202: invokevirtual 1561	android/view/Window:getDecorView	()Landroid/view/View;
    //   205: aload 6
    //   207: invokevirtual 1565	android/view/View:getWindowVisibleDisplayFrame	(Landroid/graphics/Rect;)V
    //   210: aload 6
    //   212: getfield 1568	android/graphics/Rect:top	I
    //   215: istore_2
    //   216: aload 7
    //   218: ldc_w 1569
    //   221: invokevirtual 1573	android/view/Window:findViewById	(I)Landroid/view/View;
    //   224: invokevirtual 1576	android/view/View:getTop	()I
    //   227: istore_1
    //   228: iload_1
    //   229: iload_2
    //   230: if_icmple +351 -> 581
    //   233: iload_1
    //   234: iload_2
    //   235: isub
    //   236: istore_1
    //   237: aload_0
    //   238: aload 5
    //   240: getfield 1579	android/util/DisplayMetrics:widthPixels	I
    //   243: putfield 921	com/jtpgodorncrqoeurl/AdController:E	I
    //   246: aload_0
    //   247: aload_0
    //   248: getfield 196	com/jtpgodorncrqoeurl/AdController:t	Ljava/lang/String;
    //   251: putfield 181	com/jtpgodorncrqoeurl/AdController:ao	Ljava/lang/String;
    //   254: aload_3
    //   255: ldc -28
    //   257: aconst_null
    //   258: invokeinterface 469 3 0
    //   263: astore 6
    //   265: aload_3
    //   266: ldc -30
    //   268: aconst_null
    //   269: invokeinterface 469 3 0
    //   274: astore 7
    //   276: aload_3
    //   277: ldc -40
    //   279: aconst_null
    //   280: invokeinterface 469 3 0
    //   285: astore 8
    //   287: aload_0
    //   288: getfield 921	com/jtpgodorncrqoeurl/AdController:E	I
    //   291: sipush 720
    //   294: if_icmple +340 -> 634
    //   297: aload 6
    //   299: ifnull +287 -> 586
    //   302: aload 6
    //   304: ldc -38
    //   306: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   309: ifne +277 -> 586
    //   312: aload_0
    //   313: aload 6
    //   315: putfield 181	com/jtpgodorncrqoeurl/AdController:ao	Ljava/lang/String;
    //   318: aload_0
    //   319: aload 5
    //   321: getfield 1582	android/util/DisplayMetrics:heightPixels	I
    //   324: iload_2
    //   325: isub
    //   326: iload_1
    //   327: isub
    //   328: putfield 923	com/jtpgodorncrqoeurl/AdController:F	I
    //   331: ldc 14
    //   333: new 530	java/lang/StringBuilder
    //   336: dup
    //   337: ldc_w 1584
    //   340: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   343: aload 5
    //   345: getfield 1582	android/util/DisplayMetrics:heightPixels	I
    //   348: invokevirtual 783	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: ldc_w 1586
    //   354: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: iload_2
    //   358: invokevirtual 783	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   361: ldc_w 1588
    //   364: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc_w 1586
    //   370: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: iload_1
    //   374: invokevirtual 783	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   377: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 552	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload_0
    //   384: aload_0
    //   385: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   388: ldc_w 1590
    //   391: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   394: putfield 161	com/jtpgodorncrqoeurl/AdController:P	I
    //   397: aload_0
    //   398: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   401: ldc_w 1592
    //   404: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   407: istore_1
    //   408: aload_0
    //   409: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   412: ldc_w 940
    //   415: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   418: istore_2
    //   419: iload_2
    //   420: ifle +306 -> 726
    //   423: aload_0
    //   424: iload_1
    //   425: bipush 60
    //   427: imul
    //   428: iload_2
    //   429: idiv
    //   430: putfield 163	com/jtpgodorncrqoeurl/AdController:Q	I
    //   433: aload_0
    //   434: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   437: ldc_w 1594
    //   440: invokevirtual 708	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   443: ldc_w 694
    //   446: invokevirtual 709	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   449: ifeq +8 -> 457
    //   452: aload_0
    //   453: iconst_1
    //   454: putfield 145	com/jtpgodorncrqoeurl/AdController:n	Z
    //   457: aload 4
    //   459: new 530	java/lang/StringBuilder
    //   462: dup
    //   463: ldc_w 1596
    //   466: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   469: aload_0
    //   470: getfield 181	com/jtpgodorncrqoeurl/AdController:ao	Ljava/lang/String;
    //   473: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: aload_0
    //   480: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   483: ldc_w 1598
    //   486: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   489: invokeinterface 224 3 0
    //   494: pop
    //   495: aload 4
    //   497: invokeinterface 232 1 0
    //   502: pop
    //   503: aload_0
    //   504: getfield 177	com/jtpgodorncrqoeurl/AdController:am	Z
    //   507: ifeq +282 -> 789
    //   510: aload_0
    //   511: invokevirtual 1601	com/jtpgodorncrqoeurl/AdController:retrieveAudioAd	()V
    //   514: aload_3
    //   515: new 530	java/lang/StringBuilder
    //   518: dup
    //   519: ldc_w 1149
    //   522: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   525: aload_0
    //   526: getfield 196	com/jtpgodorncrqoeurl/AdController:t	Ljava/lang/String;
    //   529: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: iconst_0
    //   536: invokeinterface 1135 3 0
    //   541: ifeq -411 -> 130
    //   544: aload_0
    //   545: getfield 1145	com/jtpgodorncrqoeurl/AdController:as	Landroid/os/Handler;
    //   548: ifnull -418 -> 130
    //   551: aload_0
    //   552: getfield 1145	com/jtpgodorncrqoeurl/AdController:as	Landroid/os/Handler;
    //   555: aload_0
    //   556: getfield 1147	com/jtpgodorncrqoeurl/AdController:at	Ljava/lang/Runnable;
    //   559: aload_0
    //   560: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   563: ldc_w 1603
    //   566: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   569: sipush 1000
    //   572: imul
    //   573: i2l
    //   574: invokevirtual 945	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   577: pop
    //   578: return
    //   579: astore_3
    //   580: return
    //   581: iconst_0
    //   582: istore_1
    //   583: goto -346 -> 237
    //   586: aload 7
    //   588: ifnull +22 -> 610
    //   591: aload 7
    //   593: ldc -38
    //   595: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   598: ifne +12 -> 610
    //   601: aload_0
    //   602: aload 7
    //   604: putfield 181	com/jtpgodorncrqoeurl/AdController:ao	Ljava/lang/String;
    //   607: goto -289 -> 318
    //   610: aload 8
    //   612: ifnull -294 -> 318
    //   615: aload 8
    //   617: ldc -38
    //   619: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   622: ifne -304 -> 318
    //   625: aload_0
    //   626: aload 8
    //   628: putfield 181	com/jtpgodorncrqoeurl/AdController:ao	Ljava/lang/String;
    //   631: goto -313 -> 318
    //   634: aload_0
    //   635: getfield 921	com/jtpgodorncrqoeurl/AdController:E	I
    //   638: sipush 480
    //   641: if_icmple +51 -> 692
    //   644: aload 7
    //   646: ifnull +22 -> 668
    //   649: aload 7
    //   651: ldc -38
    //   653: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   656: ifne +12 -> 668
    //   659: aload_0
    //   660: aload 7
    //   662: putfield 181	com/jtpgodorncrqoeurl/AdController:ao	Ljava/lang/String;
    //   665: goto -347 -> 318
    //   668: aload 8
    //   670: ifnull -352 -> 318
    //   673: aload 8
    //   675: ldc -38
    //   677: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   680: ifne -362 -> 318
    //   683: aload_0
    //   684: aload 8
    //   686: putfield 181	com/jtpgodorncrqoeurl/AdController:ao	Ljava/lang/String;
    //   689: goto -371 -> 318
    //   692: aload_0
    //   693: getfield 921	com/jtpgodorncrqoeurl/AdController:E	I
    //   696: sipush 320
    //   699: if_icmple -381 -> 318
    //   702: aload 8
    //   704: ifnull -386 -> 318
    //   707: aload 8
    //   709: ldc -38
    //   711: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   714: ifne -396 -> 318
    //   717: aload_0
    //   718: aload 8
    //   720: putfield 181	com/jtpgodorncrqoeurl/AdController:ao	Ljava/lang/String;
    //   723: goto -405 -> 318
    //   726: aload_0
    //   727: bipush 10
    //   729: putfield 163	com/jtpgodorncrqoeurl/AdController:Q	I
    //   732: goto -299 -> 433
    //   735: astore 5
    //   737: aload_0
    //   738: sipush 500
    //   741: putfield 161	com/jtpgodorncrqoeurl/AdController:P	I
    //   744: aload_0
    //   745: bipush 10
    //   747: putfield 163	com/jtpgodorncrqoeurl/AdController:Q	I
    //   750: goto -317 -> 433
    //   753: astore 5
    //   755: aload 4
    //   757: new 530	java/lang/StringBuilder
    //   760: dup
    //   761: ldc_w 1596
    //   764: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   767: aload_0
    //   768: getfield 181	com/jtpgodorncrqoeurl/AdController:ao	Ljava/lang/String;
    //   771: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   777: ldc_w 1248
    //   780: invokeinterface 224 3 0
    //   785: pop
    //   786: goto -291 -> 495
    //   789: aload_0
    //   790: getfield 489	com/jtpgodorncrqoeurl/AdController:aj	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   793: ifnonnull +42 -> 835
    //   796: aload_0
    //   797: new 679	com/jtpgodorncrqoeurl/AdWebView
    //   800: dup
    //   801: aload_0
    //   802: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   805: aload_0
    //   806: aload_0
    //   807: getfield 145	com/jtpgodorncrqoeurl/AdController:n	Z
    //   810: aload_0
    //   811: getfield 169	com/jtpgodorncrqoeurl/AdController:ad	Lcom/jtpgodorncrqoeurl/AdListener;
    //   814: aload_0
    //   815: getfield 200	com/jtpgodorncrqoeurl/AdController:q	Landroid/widget/RelativeLayout;
    //   818: invokespecial 1606	com/jtpgodorncrqoeurl/AdWebView:<init>	(Landroid/app/Activity;Lcom/jtpgodorncrqoeurl/AdController;ZLcom/jtpgodorncrqoeurl/AdListener;Landroid/widget/RelativeLayout;)V
    //   821: putfield 489	com/jtpgodorncrqoeurl/AdController:aj	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   824: aload_0
    //   825: getfield 489	com/jtpgodorncrqoeurl/AdController:aj	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   828: aload_0
    //   829: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   832: invokevirtual 1610	com/jtpgodorncrqoeurl/AdWebView:setResults	(Lorg/json/JSONObject;)V
    //   835: aload_0
    //   836: getfield 247	com/jtpgodorncrqoeurl/AdController:b	Lcom/jtpgodorncrqoeurl/AdView;
    //   839: ifnonnull +23 -> 862
    //   842: aload_0
    //   843: new 777	com/jtpgodorncrqoeurl/AdView
    //   846: dup
    //   847: aload_0
    //   848: getfield 194	com/jtpgodorncrqoeurl/AdController:c	Landroid/app/Activity;
    //   851: aload_0
    //   852: aload_0
    //   853: getfield 169	com/jtpgodorncrqoeurl/AdController:ad	Lcom/jtpgodorncrqoeurl/AdListener;
    //   856: invokespecial 1613	com/jtpgodorncrqoeurl/AdView:<init>	(Landroid/content/Context;Lcom/jtpgodorncrqoeurl/AdController;Lcom/jtpgodorncrqoeurl/AdListener;)V
    //   859: putfield 247	com/jtpgodorncrqoeurl/AdController:b	Lcom/jtpgodorncrqoeurl/AdView;
    //   862: aload_0
    //   863: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   866: ldc_w 1615
    //   869: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   872: iconst_1
    //   873: if_icmpne +26 -> 899
    //   876: aload_0
    //   877: getfield 169	com/jtpgodorncrqoeurl/AdController:ad	Lcom/jtpgodorncrqoeurl/AdListener;
    //   880: ifnull -750 -> 130
    //   883: aload_0
    //   884: getfield 169	com/jtpgodorncrqoeurl/AdController:ad	Lcom/jtpgodorncrqoeurl/AdListener;
    //   887: invokeinterface 1618 1 0
    //   892: return
    //   893: astore_3
    //   894: aload_0
    //   895: invokespecial 664	com/jtpgodorncrqoeurl/AdController:c	()V
    //   898: return
    //   899: aload_0
    //   900: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   903: ldc_w 1615
    //   906: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   909: istore_1
    //   910: iload_1
    //   911: ifne -781 -> 130
    //   914: aload_0
    //   915: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   918: ldc_w 1620
    //   921: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   924: ifle +74 -> 998
    //   927: aload_0
    //   928: getfield 285	com/jtpgodorncrqoeurl/AdController:i	Lorg/json/JSONObject;
    //   931: ldc_w 1620
    //   934: invokevirtual 293	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   937: sipush 1000
    //   940: imul
    //   941: istore_1
    //   942: ldc 14
    //   944: new 530	java/lang/StringBuilder
    //   947: dup
    //   948: ldc_w 1622
    //   951: invokespecial 535	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   954: iload_1
    //   955: invokevirtual 783	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   958: ldc_w 1624
    //   961: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   967: invokestatic 523	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   970: new 935	android/os/Handler
    //   973: dup
    //   974: invokespecial 936	android/os/Handler:<init>	()V
    //   977: new 1626	com/jtpgodorncrqoeurl/r
    //   980: dup
    //   981: aload_0
    //   982: invokespecial 1627	com/jtpgodorncrqoeurl/r:<init>	(Lcom/jtpgodorncrqoeurl/AdController;)V
    //   985: iload_1
    //   986: i2l
    //   987: invokevirtual 945	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   990: pop
    //   991: return
    //   992: astore_3
    //   993: aload_0
    //   994: invokespecial 664	com/jtpgodorncrqoeurl/AdController:c	()V
    //   997: return
    //   998: aload_0
    //   999: invokespecial 664	com/jtpgodorncrqoeurl/AdController:c	()V
    //   1002: return
    //   1003: aload_0
    //   1004: getfield 169	com/jtpgodorncrqoeurl/AdController:ad	Lcom/jtpgodorncrqoeurl/AdListener;
    //   1007: ifnull +17 -> 1024
    //   1010: aload_0
    //   1011: iconst_1
    //   1012: putfield 155	com/jtpgodorncrqoeurl/AdController:M	Z
    //   1015: aload_0
    //   1016: getfield 169	com/jtpgodorncrqoeurl/AdController:ad	Lcom/jtpgodorncrqoeurl/AdListener;
    //   1019: invokeinterface 977 1 0
    //   1024: aload_0
    //   1025: getfield 237	com/jtpgodorncrqoeurl/AdController:al	Lcom/jtpgodorncrqoeurl/AdAudioListener;
    //   1028: ifnull -898 -> 130
    //   1031: aload_0
    //   1032: iconst_1
    //   1033: putfield 179	com/jtpgodorncrqoeurl/AdController:an	Z
    //   1036: aload_0
    //   1037: getfield 237	com/jtpgodorncrqoeurl/AdController:al	Lcom/jtpgodorncrqoeurl/AdAudioListener;
    //   1040: invokeinterface 980 1 0
    //   1045: return
    //   1046: astore 5
    //   1048: goto -591 -> 457
    //   1051: astore 5
    //   1053: goto -984 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1056	0	this	AdController
    //   227	759	1	i1	int
    //   215	215	2	i2	int
    //   16	499	3	localObject1	Object
    //   579	1	3	localException1	Exception
    //   893	1	3	localException2	Exception
    //   992	1	3	localException3	Exception
    //   31	725	4	localEditor	SharedPreferences.Editor
    //   139	1	5	localException4	Exception
    //   163	181	5	localDisplayMetrics	android.util.DisplayMetrics
    //   735	1	5	localException5	Exception
    //   753	1	5	localException6	Exception
    //   1046	1	5	localJSONException	JSONException
    //   1051	1	5	localException7	Exception
    //   189	125	6	localObject2	Object
    //   198	463	7	localObject3	Object
    //   285	434	8	str	String
    // Exception table:
    //   from	to	target	type
    //   69	109	139	java/lang/Exception
    //   109	130	139	java/lang/Exception
    //   551	578	579	java/lang/Exception
    //   383	419	735	java/lang/Exception
    //   423	433	735	java/lang/Exception
    //   726	732	735	java/lang/Exception
    //   457	495	753	java/lang/Exception
    //   862	892	893	java/lang/Exception
    //   899	910	893	java/lang/Exception
    //   993	997	893	java/lang/Exception
    //   914	991	992	java/lang/Exception
    //   998	1002	992	java/lang/Exception
    //   433	457	1046	org/json/JSONException
    //   40	69	1051	java/lang/Exception
  }
  
  public String adShowStatus()
  {
    if (this.c != null) {}
    for (Object localObject = this.c;; localObject = this.a) {
      return ((Context)localObject).getSharedPreferences("Preference", 0).getString("SD_ADSTATUS_" + this.t, "default");
    }
  }
  
  public void audioAdRetrieved(Integer paramInteger)
  {
    if (paramInteger.intValue() == 0) {
      h();
    }
    while (this.al == null) {
      return;
    }
    this.al.onAdFailed();
    this.an = true;
  }
  
  public void checkForAudioAd(String paramString1, String paramString2)
  {
    if ((this.N) || (paramString1 == null) || (paramString1.equals("null")) || (paramString1.equals("")) || (this.i.isNull("adaudiourl"))) {}
    try
    {
      this.i.put("adaudiourl", paramString1);
      this.i.put("adurl", paramString2);
      if ((!this.an) && (!this.i.isNull("adaudiourl")))
      {
        if (this.ar == null) {
          this.ar = new z(this, true);
        }
        if (this.U == null) {
          if (this.c == null) {
            break label181;
          }
        }
      }
      label181:
      for (paramString1 = this.c;; paramString1 = this.a)
      {
        this.S = ((AudioManager)paramString1.getSystemService("audio"));
        this.U = ((SensorManager)this.c.getSystemService("sensor"));
        this.W = 0.0F;
        this.X = 9.80665F;
        this.Y = 9.80665F;
        retrieveAudioAd();
        return;
      }
      AdLog.d("LBAdController", "No audio component");
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;) {}
    }
  }
  
  public void destroyAd()
  {
    AdLog.i("LBAdController", "destroyAd called");
    this.N = true;
    i();
    f();
  }
  
  public boolean getAdDestroyed()
  {
    return this.N;
  }
  
  public boolean getAdLoaded()
  {
    return this.M;
  }
  
  public boolean getLoadInBackground()
  {
    return this.ap;
  }
  
  public boolean getOnAdLoaded()
  {
    return this.R;
  }
  
  public void hideElements()
  {
    try
    {
      this.u.setVisibility(8);
      this.v.setVisibility(8);
      this.w.setVisibility(8);
      this.x.setVisibility(8);
      this.y.setVisibility(8);
      this.z.setVisibility(8);
      this.A.setVisibility(8);
      this.B.setVisibility(8);
      this.q.setVisibility(8);
      throw new NullPointerException();
    }
    catch (Exception localException) {}
  }
  
  public void loadAd()
  {
    Object localObject = this.c.getSharedPreferences("Preference", 0);
    String str1 = ((SharedPreferences)localObject).getString("SD_APP_OPTIN_SHOWN", "notset");
    String str2 = ((SharedPreferences)localObject).getString("SD_APP_OPTIN", "notset");
    if ((!str1.equals("notset")) && (str2.equals("0")))
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("SD_APP_OPTIN_SHOWN", "invalid");
      ((SharedPreferences.Editor)localObject).commit();
    }
    AdLog.i("LBAdController", "loadAd called");
    this.R = false;
    if (!this.p)
    {
      this.G = true;
      this.N = false;
      b();
    }
    for (;;)
    {
      if ((this.ad != null) && (this.J > 0))
      {
        if (this.L == null) {
          this.L = new s(this);
        }
        if (this.K == null)
        {
          this.K = new Handler();
          this.K.postDelayed(this.L, this.J * 1000);
        }
      }
      return;
      c();
    }
  }
  
  public void loadAudioAd()
  {
    if (this.T != null) {}
    label20:
    label275:
    label280:
    for (;;)
    {
      return;
      Object localObject1;
      if (this.c != null)
      {
        localObject1 = this.c;
        Object localObject2 = ((Context)localObject1).getSharedPreferences("Preference", 0);
        String str1 = ((SharedPreferences)localObject2).getString("SD_APP_OPTIN_SHOWN", "notset");
        String str2 = ((SharedPreferences)localObject2).getString("SD_APP_OPTIN", "notset");
        if ((!str1.equals("notset")) && (str2.equals("0")))
        {
          localObject2 = ((SharedPreferences)localObject2).edit();
          ((SharedPreferences.Editor)localObject2).putString("SD_APP_OPTIN_SHOWN", "invalid");
          ((SharedPreferences.Editor)localObject2).commit();
        }
        AdLog.i("LBAdController", "loadAudioAd called");
        if (this.p) {
          break label275;
        }
        this.am = true;
        if (this.U == null)
        {
          this.ar = new z(this, true);
          this.S = ((AudioManager)((Context)localObject1).getSystemService("audio"));
          this.U = ((SensorManager)((Context)localObject1).getSystemService("sensor"));
          this.W = 0.0F;
          this.X = 9.80665F;
          this.Y = 9.80665F;
        }
        b();
      }
      for (;;)
      {
        if ((this.ad == null) || (this.J <= 0)) {
          break label280;
        }
        if (this.L == null) {
          this.L = new o(this);
        }
        if (this.K != null) {
          break;
        }
        this.K = new Handler();
        this.K.postDelayed(this.L, this.J * 1000);
        return;
        localObject1 = this.a;
        break label20;
        h();
      }
    }
  }
  
  public void loadAudioTrack(long paramLong)
  {
    if (this.at == null) {
      this.at = new p(this);
    }
    if (this.as == null)
    {
      this.as = new Handler();
      this.as.postDelayed(this.at, 60L * paramLong * 1000L);
      return;
    }
    this.as.removeCallbacks(this.at);
    this.as.postDelayed(this.at, 60L * paramLong * 1000L);
  }
  
  public void loadReEngagement()
  {
    int i1;
    if (this.ac != null)
    {
      AdLog.i("LBAdController", "AdTask status - " + this.ac.getStatus());
      if (this.ac.getStatus() == AsyncTask.Status.FINISHED) {
        i1 = 1;
      }
    }
    for (;;)
    {
      if (i1 != 0)
      {
        Object localObject;
        label66:
        String str2;
        if (this.c != null)
        {
          localObject = this.c;
          boolean bool = ((Context)localObject).getSharedPreferences("Preference", 0).getBoolean("reengagementalarm", false);
          str2 = this.t;
          if (!bool) {
            break label179;
          }
        }
        label179:
        for (String str1 = "reengagement_alarm";; str1 = "reengagement")
        {
          this.ac = new AdTask(this, (Context)localObject, str2, str1);
          this.ac.setSubId(this.H);
          this.ac.setTokens(this.I);
          this.ac.setUseLocation(this.m);
          this.ac.execute(new String[] { "" });
          return;
          i1 = 0;
          break;
          localObject = this.a;
          break label66;
        }
      }
      AdLog.i("LBAdController", "No request to be made");
      return;
      i1 = 1;
    }
  }
  
  public void loadStartAd(String paramString1, String paramString2)
  {
    loadAd();
    this.ae = new AdController(this.c, paramString1);
    this.ae.loadAudioTrack(2L);
    new AdController(this.c, paramString2).loadReEngagement();
  }
  
  public boolean onBackPressed()
  {
    if (this.l)
    {
      loadAd();
      return true;
    }
    return false;
  }
  
  public void onLinkClicked()
  {
    d();
  }
  
  public void pauseAd()
  {
    if (this.c != null) {}
    for (Object localObject = this.c;; localObject = this.a)
    {
      localObject = ((Context)localObject).getSharedPreferences("Preference", 0).edit();
      if (this.ao == null) {
        this.ao = this.t;
      }
      ((SharedPreferences.Editor)localObject).putString("SD_ADSTATUS_" + this.ao, "hidden");
      ((SharedPreferences.Editor)localObject).commit();
      if (this.ad != null) {}
      try
      {
        this.ad.onAdPaused();
        return;
      }
      catch (Exception localException)
      {
        AdLog.printStackTrace("LBAdController", localException);
        AdLog.e("LBAdController", "Error while triggering onAdPaused - " + localException.getMessage());
      }
    }
  }
  
  public void reEngagementInitialized()
  {
    Object localObject1;
    if (this.i != null)
    {
      AdLog.i("LBAdController", "createAlarm called");
      if (this.c == null) {
        break label381;
      }
      localObject1 = this.c;
    }
    for (;;)
    {
      SharedPreferences.Editor localEditor = ((Context)localObject1).getSharedPreferences("Preference", 0).edit();
      Object localObject2;
      long l1;
      if (this.i.length() > 1)
      {
        localObject2 = new Intent((Context)localObject1, ReEngagement.class);
        ((Intent)localObject2).putExtra("sectionid", this.t);
        this.aa = PendingIntent.getBroadcast((Context)localObject1, 0, (Intent)localObject2, 134217728);
        localObject2 = Calendar.getInstance();
        l1 = System.currentTimeMillis();
      }
      try
      {
        this.ab = ((AlarmManager)((Context)localObject1).getSystemService("alarm"));
        int i1 = Integer.parseInt(this.i.getString("reengagementstart"));
        ((Calendar)localObject2).add(13, i1);
        AdLog.d("LBAdController", "Alarm initialized - Scheduled at " + i1 + ", current time = " + l1);
        AdLog.d("LBAdController", "----------------------------------------");
        this.ab.cancel(this.aa);
        this.ab.set(0, ((Calendar)localObject2).getTimeInMillis(), this.aa);
        localEditor.putLong("SD_ALARM_TIME_" + this.t, l1);
        localEditor.putLong("SD_WAKE_TIME_" + this.t, ((Calendar)localObject2).getTimeInMillis());
        localEditor.putLong("SD_ALARM_INTERVAL_" + this.t, i1);
        localEditor.commit();
        if (this.c != null)
        {
          localObject1 = this.c;
          localObject1 = ((Context)localObject1).getSharedPreferences("Preference", 0);
          localEditor = ((SharedPreferences)localObject1).edit();
          if (((SharedPreferences)localObject1).getBoolean("reengagementalarm", false))
          {
            localEditor.putBoolean("reengagementalarm", false);
            localEditor.commit();
            j();
          }
          return;
          label381:
          localObject1 = this.a;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          AdLog.e("LBAdController", "Error caused while setting Alarm (if case): " + localException.getMessage());
          AdLog.printStackTrace("LBAdController", localException);
          continue;
          Context localContext = this.a;
        }
      }
    }
  }
  
  public void resumeAd()
  {
    if (this.c != null) {}
    for (Object localObject = this.c;; localObject = this.a)
    {
      localObject = ((Context)localObject).getSharedPreferences("Preference", 0).edit();
      if (this.ao == null) {
        this.ao = this.t;
      }
      ((SharedPreferences.Editor)localObject).putString("SD_ADSTATUS_" + this.ao, "default");
      ((SharedPreferences.Editor)localObject).commit();
      if (this.ad != null) {}
      try
      {
        this.ad.onAdResumed();
        return;
      }
      catch (Exception localException)
      {
        AdLog.printStackTrace("LBAdController", localException);
        AdLog.e("LBAdController", "Error while triggering onAdResumed - " + localException.getMessage());
      }
    }
  }
  
  public void retrieveAudioAd()
  {
    int i2 = 1;
    for (;;)
    {
      try
      {
        if (this.i.get("show").equals("1"))
        {
          i1 = i2;
          if (this.ak != null)
          {
            if (this.ak.getStatus() == AsyncTask.Status.FINISHED) {
              break label141;
            }
            i1 = i2;
          }
          if (i1 != 0)
          {
            if (this.c != null)
            {
              localObject = this.c;
              this.ak = new AdAudioTask(this, (Context)localObject);
              this.ak.execute(new String[] { this.i.getString("adaudiourl") });
              return;
            }
            Object localObject = this.a;
            continue;
          }
        }
        else
        {
          this.am = false;
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        AdLog.d("LBAdController", "JSONException - " + localJSONException.getMessage());
      }
      return;
      label141:
      int i1 = 0;
    }
  }
  
  public void setAdDestroyed(boolean paramBoolean)
  {
    this.N = paramBoolean;
  }
  
  public void setAdLoaded(boolean paramBoolean)
  {
    this.M = paramBoolean;
  }
  
  public void setAdditionalDockingMargin(int paramInt)
  {
    this.D = paramInt;
    AdLog.i("LBAdController", "setAdditionalDockingMargin: " + paramInt);
  }
  
  public void setCompleted(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setHTML(String paramString)
  {
    if (this.b != null)
    {
      paramString = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">" + paramString + "</html>";
      this.b.loadHTMLWrap(paramString);
    }
  }
  
  public void setHTMLAds(boolean paramBoolean)
  {
    this.aq = paramBoolean;
  }
  
  public void setHomeLoaded(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setLayout(RelativeLayout paramRelativeLayout)
  {
    this.q = paramRelativeLayout;
  }
  
  public void setLoadInBackground(boolean paramBoolean)
  {
    this.ap = paramBoolean;
  }
  
  public void setLoading(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setOnAdLoaded(boolean paramBoolean)
  {
    this.R = paramBoolean;
    if ((this.ap) && (!this.N)) {
      this.c.runOnUiThread(new n(this));
    }
  }
  
  public void setOnProgressInterval(int paramInt)
  {
    this.J = paramInt;
  }
  
  public void setResults(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.i = paramJSONObject;
      if (this.c == null) {
        break label93;
      }
    }
    for (paramJSONObject = this.c;; paramJSONObject = this.a)
    {
      paramJSONObject = paramJSONObject.getSharedPreferences("Preference", 0).edit();
      try
      {
        paramJSONObject.putLong("adrechecktime", this.i.getLong("adrechecktime"));
        paramJSONObject.commit();
        AdLog.d("LBAdController", "Adrechecktime set - " + this.i.getLong("adrechecktime"));
        return;
      }
      catch (Exception paramJSONObject)
      {
        label93:
        AdLog.d("LBAdController", "Error with setting adrechecktime - " + paramJSONObject.getMessage());
      }
    }
  }
  
  public void setSubId(String paramString)
  {
    this.H = paramString;
  }
  
  public void setTokens(List paramList)
  {
    this.I = paramList;
  }
  
  public void setUseLocation(boolean paramBoolean)
  {
    this.m = paramBoolean;
    AdLog.i("LBAdController", "setUseLocation: " + paramBoolean);
  }
  
  public void showElements()
  {
    try
    {
      this.u.setVisibility(0);
      this.v.setVisibility(0);
      this.w.setVisibility(0);
      this.x.setVisibility(0);
      this.y.setVisibility(0);
      this.z.setVisibility(0);
      this.A.setVisibility(0);
      this.B.setVisibility(0);
      this.q.setVisibility(0);
      throw new NullPointerException();
    }
    catch (Exception localException) {}
  }
  
  public void showInternetDialog()
  {
    if (this.c != null)
    {
      if (this.af == null)
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.c);
        localBuilder.setMessage("Internet not available").setCancelable(false).setPositiveButton("Close", new i(this));
        this.af = localBuilder.create();
      }
      this.af.show();
    }
  }
  
  public void stopAllListeners() {}
  
  public void triggerAdCompleted()
  {
    if (this.ad != null) {}
    try
    {
      AdLog.i("LBAdController", "onAdCompleted triggered");
      this.ad.onAdCompleted();
      return;
    }
    catch (Exception localException)
    {
      AdLog.e("LBAdController", "error when onAdCompleted triggered");
      AdLog.printStackTrace("LBAdController", localException);
    }
  }
  
  public void triggerAdFailed()
  {
    AdLog.e("LBAdController", "No Internet connection detected. No Ads loaded");
    if (this.ad != null) {}
    try
    {
      AdLog.i("LBAdController", "onAdFailed triggered");
      this.ad.onAdFailed();
      this.M = true;
      if (this.al != null)
      {
        this.al.onAdFailed();
        this.an = true;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AdLog.i("LBAdController", "Error while calling onAdFailed");
        AdLog.printStackTrace("LBAdController", localException);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */