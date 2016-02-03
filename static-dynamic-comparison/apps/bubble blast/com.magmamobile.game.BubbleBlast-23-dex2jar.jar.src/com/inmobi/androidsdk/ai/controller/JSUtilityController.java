package com.inmobi.androidsdk.ai.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.inmobi.androidsdk.ai.container.IMWebView;
import com.inmobi.commons.internal.IMLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class JSUtilityController
  extends JSController
{
  private JSAssetController a;
  private JSDisplayController b;
  
  public JSUtilityController(IMWebView paramIMWebView, Context paramContext)
  {
    super(paramIMWebView, paramContext);
    this.a = new JSAssetController(paramIMWebView, paramContext);
    this.b = new JSDisplayController(paramIMWebView, paramContext);
    paramIMWebView.addJavascriptInterface(this.b, "displayController");
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    do
    {
      return (String)localObject;
      localObject = paramString;
    } while (paramString.startsWith("tel:"));
    Object localObject = new StringBuilder("tel:");
    ((StringBuilder)localObject).append(paramString);
    return ((StringBuilder)localObject).toString();
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    ContentResolver localContentResolver = this.mContext.getContentResolver();
    long l = Long.parseLong(paramString1);
    paramString1 = new ContentValues();
    paramString1.put("calendar_id", Integer.valueOf(paramInt));
    paramString1.put("title", paramString2);
    paramString1.put("description", paramString3);
    paramString1.put("dtstart", Long.valueOf(l));
    paramString1.put("hasAlarm", Integer.valueOf(1));
    paramString1.put("dtend", Long.valueOf(3600000L + l));
    if (Build.VERSION.SDK_INT == 8)
    {
      paramString1 = localContentResolver.insert(Uri.parse("content://com.android.calendar/events"), paramString1);
      if (paramString1 != null)
      {
        l = Long.parseLong(paramString1.getLastPathSegment());
        paramString1 = new ContentValues();
        paramString1.put("event_id", Long.valueOf(l));
        paramString1.put("method", Integer.valueOf(1));
        paramString1.put("minutes", Integer.valueOf(15));
        if (Build.VERSION.SDK_INT != 8) {
          break label206;
        }
        localContentResolver.insert(Uri.parse("content://com.android.calendar/reminders"), paramString1);
      }
    }
    for (;;)
    {
      Toast.makeText(this.mContext, "Event added to calendar", 0).show();
      return;
      paramString1 = localContentResolver.insert(Uri.parse("content://calendar/events"), paramString1);
      break;
      label206:
      localContentResolver.insert(Uri.parse("content://calendar/reminders"), paramString1);
    }
  }
  
  private void b(final String paramString)
  {
    new Thread()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_2
        //   2: aconst_null
        //   3: astore_3
        //   4: aload_2
        //   5: astore_1
        //   6: aload_0
        //   7: getfield 18	com/inmobi/androidsdk/ai/controller/JSUtilityController$2:b	Ljava/lang/String;
        //   10: ldc 27
        //   12: ldc 29
        //   14: invokevirtual 35	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   17: astore 4
        //   19: aload_2
        //   20: astore_1
        //   21: ldc 37
        //   23: new 39	java/lang/StringBuilder
        //   26: dup
        //   27: ldc 41
        //   29: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   32: aload 4
        //   34: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   37: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   40: invokestatic 57	com/inmobi/commons/internal/IMLog:debug	(Ljava/lang/String;Ljava/lang/String;)V
        //   43: aload_2
        //   44: astore_1
        //   45: new 59	java/net/URL
        //   48: dup
        //   49: aload 4
        //   51: invokespecial 60	java/net/URL:<init>	(Ljava/lang/String;)V
        //   54: invokevirtual 64	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   57: checkcast 66	java/net/HttpURLConnection
        //   60: astore_2
        //   61: aload_2
        //   62: sipush 20000
        //   65: invokevirtual 70	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   68: aload_2
        //   69: ldc 72
        //   71: invokevirtual 75	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   74: aload_0
        //   75: getfield 16	com/inmobi/androidsdk/ai/controller/JSUtilityController$2:a	Lcom/inmobi/androidsdk/ai/controller/JSUtilityController;
        //   78: getfield 79	com/inmobi/androidsdk/ai/controller/JSUtilityController:imWebView	Lcom/inmobi/androidsdk/ai/container/IMWebView;
        //   81: getfield 84	com/inmobi/androidsdk/ai/container/IMWebView:webviewUserAgent	Ljava/lang/String;
        //   84: astore_1
        //   85: aload_1
        //   86: ifnull +10 -> 96
        //   89: aload_2
        //   90: ldc 86
        //   92: aload_1
        //   93: invokevirtual 89	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   96: ldc 37
        //   98: new 39	java/lang/StringBuilder
        //   101: dup
        //   102: ldc 91
        //   104: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   107: aload_2
        //   108: invokevirtual 95	java/net/HttpURLConnection:getResponseCode	()I
        //   111: invokevirtual 98	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   114: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   117: invokestatic 57	com/inmobi/commons/internal/IMLog:debug	(Ljava/lang/String;Ljava/lang/String;)V
        //   120: aload_2
        //   121: ifnull +7 -> 128
        //   124: aload_2
        //   125: invokevirtual 101	java/net/HttpURLConnection:disconnect	()V
        //   128: return
        //   129: astore_1
        //   130: aload_3
        //   131: astore_2
        //   132: aload_1
        //   133: astore_3
        //   134: aload_2
        //   135: astore_1
        //   136: ldc 37
        //   138: ldc 103
        //   140: aload_3
        //   141: invokestatic 106	com/inmobi/commons/internal/IMLog:debug	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   144: aload_2
        //   145: ifnull -17 -> 128
        //   148: aload_2
        //   149: invokevirtual 101	java/net/HttpURLConnection:disconnect	()V
        //   152: return
        //   153: astore_3
        //   154: aload_1
        //   155: astore_2
        //   156: aload_3
        //   157: astore_1
        //   158: aload_2
        //   159: ifnull +7 -> 166
        //   162: aload_2
        //   163: invokevirtual 101	java/net/HttpURLConnection:disconnect	()V
        //   166: aload_1
        //   167: athrow
        //   168: astore_1
        //   169: goto -11 -> 158
        //   172: astore_3
        //   173: goto -39 -> 134
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	176	0	this	2
        //   5	88	1	localObject1	Object
        //   129	4	1	localException1	Exception
        //   135	32	1	localObject2	Object
        //   168	1	1	localObject3	Object
        //   1	162	2	localObject4	Object
        //   3	138	3	localObject5	Object
        //   153	4	3	localObject6	Object
        //   172	1	3	localException2	Exception
        //   17	33	4	str	String
        // Exception table:
        //   from	to	target	type
        //   6	19	129	java/lang/Exception
        //   21	43	129	java/lang/Exception
        //   45	61	129	java/lang/Exception
        //   6	19	153	finally
        //   21	43	153	finally
        //   45	61	153	finally
        //   136	144	153	finally
        //   61	85	168	finally
        //   89	96	168	finally
        //   96	120	168	finally
        //   61	85	172	java/lang/Exception
        //   89	96	172	java/lang/Exception
        //   96	120	172	java/lang/Exception
      }
    }.start();
  }
  
  public void activate(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> activate: " + paramString);
  }
  
  public void asyncPing(String paramString)
  {
    try
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> asyncPing: url: " + paramString);
      if (!URLUtil.isValidUrl(paramString))
      {
        this.imWebView.raiseError("Invalid url", "asyncPing");
        return;
      }
      b(paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void closeVideo(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> closeVideo: id :" + paramString);
    this.imWebView.closeVideo(paramString);
  }
  
  public String copyTextFromJarIntoAssetDir(String paramString1, String paramString2)
  {
    return this.a.copyTextFromJarIntoAssetDir(paramString1, paramString2);
  }
  
  public void createEvent(final String paramString1, final String paramString2, final String paramString3)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> createEvent: date: " + paramString1 + " title: " + paramString2 + " body: " + paramString3);
    Object localObject1 = this.mContext.getContentResolver();
    final Object localObject2 = new String[3];
    localObject2[0] = "_id";
    localObject2[1] = "displayName";
    localObject2[2] = "_sync_account";
    if (Build.VERSION.SDK_INT == 8) {}
    for (localObject1 = ((ContentResolver)localObject1).query(Uri.parse("content://com.android.calendar/calendars"), (String[])localObject2, null, null, null); (localObject1 == null) || ((localObject1 != null) && (!((Cursor)localObject1).moveToFirst())); localObject1 = ((ContentResolver)localObject1).query(Uri.parse("content://calendar/calendars"), (String[])localObject2, null, null, null))
    {
      Toast.makeText(this.mContext, "No calendar account found", 1).show();
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      return;
    }
    if (((Cursor)localObject1).getCount() == 1)
    {
      a(((Cursor)localObject1).getInt(0), paramString1, paramString2, paramString3);
      ((Cursor)localObject1).close();
      return;
    }
    localObject2 = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i >= ((Cursor)localObject1).getCount())
      {
        localObject3 = new AlertDialog.Builder(this.mContext);
        ((AlertDialog.Builder)localObject3).setTitle("Choose Calendar to save event to");
        ((AlertDialog.Builder)localObject3).setSingleChoiceItems(new SimpleAdapter(this.mContext, (List)localObject2, 17367053, new String[] { "NAME", "EMAILID" }, new int[] { 16908308, 16908309 }), -1, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            Map localMap = (Map)localObject2.get(paramAnonymousInt);
            JSUtilityController.a(JSUtilityController.this, Integer.parseInt((String)localMap.get("ID")), paramString1, paramString2, paramString3);
            paramAnonymousDialogInterface.cancel();
          }
        });
        ((AlertDialog.Builder)localObject3).create().show();
        break;
      }
      Object localObject3 = new HashMap();
      ((Map)localObject3).put("ID", ((Cursor)localObject1).getString(0));
      ((Map)localObject3).put("NAME", ((Cursor)localObject1).getString(1));
      ((Map)localObject3).put("EMAILID", ((Cursor)localObject1).getString(2));
      ((List)localObject2).add(localObject3);
      ((Cursor)localObject1).moveToNext();
      i += 1;
    }
  }
  
  public void deactivate(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> deactivate: " + paramString);
  }
  
  public void deleteOldAds()
  {
    this.a.deleteOldAds();
  }
  
  public int getAudioVolume(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> getAudioVolume: ");
    return this.imWebView.getAudioVolume(paramString);
  }
  
  /* Error */
  public String getCurrentPosition()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: iconst_0
    //   7: istore_3
    //   8: ldc -80
    //   10: ldc_w 335
    //   13: invokestatic 183	com/inmobi/commons/internal/IMLog:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: new 337	org/json/JSONObject
    //   19: dup
    //   20: invokespecial 338	org/json/JSONObject:<init>	()V
    //   23: astore 9
    //   25: new 340	android/util/DisplayMetrics
    //   28: dup
    //   29: invokespecial 341	android/util/DisplayMetrics:<init>	()V
    //   32: astore 8
    //   34: aload_0
    //   35: getfield 68	com/inmobi/androidsdk/ai/controller/JSUtilityController:mContext	Landroid/content/Context;
    //   38: ldc_w 343
    //   41: invokevirtual 347	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   44: checkcast 349	android/view/WindowManager
    //   47: invokeinterface 353 1 0
    //   52: aload 8
    //   54: invokevirtual 359	android/view/Display:getMetrics	(Landroid/util/DisplayMetrics;)V
    //   57: aload_0
    //   58: getfield 197	com/inmobi/androidsdk/ai/controller/JSUtilityController:imWebView	Lcom/inmobi/androidsdk/ai/container/IMWebView;
    //   61: invokevirtual 362	com/inmobi/androidsdk/ai/container/IMWebView:isViewable	()Z
    //   64: ifeq +306 -> 370
    //   67: iconst_2
    //   68: newarray <illegal type>
    //   70: astore 10
    //   72: aload_0
    //   73: getfield 197	com/inmobi/androidsdk/ai/controller/JSUtilityController:imWebView	Lcom/inmobi/androidsdk/ai/container/IMWebView;
    //   76: aload 10
    //   78: invokevirtual 366	com/inmobi/androidsdk/ai/container/IMWebView:getLocationOnScreen	([I)V
    //   81: aload 10
    //   83: iconst_0
    //   84: iaload
    //   85: istore_3
    //   86: aload 10
    //   88: iconst_1
    //   89: iaload
    //   90: istore 4
    //   92: aload_0
    //   93: getfield 197	com/inmobi/androidsdk/ai/controller/JSUtilityController:imWebView	Lcom/inmobi/androidsdk/ai/container/IMWebView;
    //   96: invokevirtual 369	com/inmobi/androidsdk/ai/container/IMWebView:getWidth	()I
    //   99: i2f
    //   100: fstore_1
    //   101: aload 8
    //   103: getfield 373	android/util/DisplayMetrics:density	F
    //   106: fstore_2
    //   107: fload_1
    //   108: fload_2
    //   109: fdiv
    //   110: f2i
    //   111: istore 5
    //   113: aload_0
    //   114: getfield 197	com/inmobi/androidsdk/ai/controller/JSUtilityController:imWebView	Lcom/inmobi/androidsdk/ai/container/IMWebView;
    //   117: invokevirtual 376	com/inmobi/androidsdk/ai/container/IMWebView:getHeight	()I
    //   120: i2f
    //   121: fstore_1
    //   122: aload 8
    //   124: getfield 373	android/util/DisplayMetrics:density	F
    //   127: fstore_2
    //   128: fload_1
    //   129: fload_2
    //   130: fdiv
    //   131: f2i
    //   132: istore 7
    //   134: iload_3
    //   135: istore 6
    //   137: iload 7
    //   139: istore_3
    //   140: aload 9
    //   142: ldc_w 378
    //   145: iload 6
    //   147: invokevirtual 381	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   150: pop
    //   151: aload 9
    //   153: ldc_w 383
    //   156: iload 4
    //   158: invokevirtual 381	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   161: pop
    //   162: aload 9
    //   164: ldc_w 385
    //   167: iload 5
    //   169: invokevirtual 381	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   172: pop
    //   173: aload 9
    //   175: ldc_w 387
    //   178: iload_3
    //   179: invokevirtual 381	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   182: pop
    //   183: aload 9
    //   185: invokevirtual 388	org/json/JSONObject:toString	()Ljava/lang/String;
    //   188: areturn
    //   189: astore 8
    //   191: iconst_0
    //   192: istore_3
    //   193: iconst_0
    //   194: istore 5
    //   196: ldc -80
    //   198: ldc_w 390
    //   201: invokestatic 183	com/inmobi/commons/internal/IMLog:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: aload 9
    //   206: ldc_w 378
    //   209: iload 5
    //   211: invokevirtual 381	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   214: pop
    //   215: aload 9
    //   217: ldc_w 383
    //   220: iload 4
    //   222: invokevirtual 381	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   225: pop
    //   226: aload 9
    //   228: ldc_w 385
    //   231: iload_3
    //   232: invokevirtual 381	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   235: pop
    //   236: aload 9
    //   238: ldc_w 387
    //   241: iconst_0
    //   242: invokevirtual 381	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   245: pop
    //   246: goto -63 -> 183
    //   249: astore 8
    //   251: goto -68 -> 183
    //   254: astore 8
    //   256: iconst_0
    //   257: istore 4
    //   259: iconst_0
    //   260: istore_3
    //   261: aload 9
    //   263: ldc_w 378
    //   266: iload_3
    //   267: invokevirtual 381	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   270: pop
    //   271: aload 9
    //   273: ldc_w 383
    //   276: iload 4
    //   278: invokevirtual 381	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   281: pop
    //   282: aload 9
    //   284: ldc_w 385
    //   287: iload 5
    //   289: invokevirtual 381	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   292: pop
    //   293: aload 9
    //   295: ldc_w 387
    //   298: iconst_0
    //   299: invokevirtual 381	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   302: pop
    //   303: aload 8
    //   305: athrow
    //   306: astore 8
    //   308: goto -125 -> 183
    //   311: astore 9
    //   313: goto -10 -> 303
    //   316: astore 8
    //   318: goto -57 -> 261
    //   321: astore 8
    //   323: goto -62 -> 261
    //   326: astore 8
    //   328: iload 5
    //   330: istore 6
    //   332: iload_3
    //   333: istore 5
    //   335: iload 6
    //   337: istore_3
    //   338: goto -77 -> 261
    //   341: astore 8
    //   343: iconst_0
    //   344: istore 6
    //   346: iload_3
    //   347: istore 5
    //   349: iload 6
    //   351: istore_3
    //   352: goto -156 -> 196
    //   355: astore 8
    //   357: iload_3
    //   358: istore 6
    //   360: iload 5
    //   362: istore_3
    //   363: iload 6
    //   365: istore 5
    //   367: goto -171 -> 196
    //   370: iconst_0
    //   371: istore 5
    //   373: iconst_0
    //   374: istore 4
    //   376: iconst_0
    //   377: istore 6
    //   379: goto -239 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	382	0	this	JSUtilityController
    //   100	29	1	f1	float
    //   106	24	2	f2	float
    //   7	356	3	i	int
    //   1	374	4	j	int
    //   4	368	5	k	int
    //   135	243	6	m	int
    //   132	6	7	n	int
    //   32	91	8	localDisplayMetrics	DisplayMetrics
    //   189	1	8	localException1	Exception
    //   249	1	8	localJSONException1	JSONException
    //   254	50	8	localObject1	Object
    //   306	1	8	localJSONException2	JSONException
    //   316	1	8	localObject2	Object
    //   321	1	8	localObject3	Object
    //   326	1	8	localObject4	Object
    //   341	1	8	localException2	Exception
    //   355	1	8	localException3	Exception
    //   23	271	9	localJSONObject	JSONObject
    //   311	1	9	localJSONException3	JSONException
    //   70	17	10	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   57	81	189	java/lang/Exception
    //   204	246	249	org/json/JSONException
    //   57	81	254	finally
    //   140	183	306	org/json/JSONException
    //   261	303	311	org/json/JSONException
    //   92	107	316	finally
    //   113	128	321	finally
    //   196	204	326	finally
    //   92	107	341	java/lang/Exception
    //   113	128	355	java/lang/Exception
  }
  
  public String getScreenSize()
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> getScreenSize");
    Object localObject = new DisplayMetrics();
    ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = (int)(((DisplayMetrics)localObject).widthPixels / ((DisplayMetrics)localObject).density);
    int j = (int)(((DisplayMetrics)localObject).heightPixels / ((DisplayMetrics)localObject).density);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("width", i);
      ((JSONObject)localObject).put("height", j);
      return ((JSONObject)localObject).toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        IMLog.debug("InMobiAndroidSDK_3.6.1", "Failed to get screen size");
      }
    }
  }
  
  public int getVideoVolume(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> getVideoVolume: ");
    return this.imWebView.getVideoVolume(paramString);
  }
  
  public void hideVideo(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> hideVideo: id :" + paramString);
    this.imWebView.hideVideo(paramString);
  }
  
  public boolean isAudioMuted(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> isAudioMuted: ");
    return this.imWebView.isAudioMuted(paramString);
  }
  
  public boolean isVideoMuted(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> isVideoMuted: ");
    return this.imWebView.isVideoMuted(paramString);
  }
  
  public void log(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "Ad Log Message: " + paramString);
  }
  
  public void makeCall(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> makeCall: number: " + paramString);
    try
    {
      if (this.mContext.checkCallingOrSelfPermission("android.permission.CALL_PHONE") == -1)
      {
        IMLog.debug("InMobiAndroidSDK_3.6.1", "No permission to make call");
        this.imWebView.raiseError("No Permisson to make call", "makeCall");
        return;
      }
      paramString = a(paramString);
      if (paramString == null)
      {
        this.imWebView.raiseError("Bad Phone Number", "makeCall");
        return;
      }
    }
    catch (Exception paramString)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception in making call ", paramString);
      this.imWebView.raiseError("Exception in making call", "makeCall");
      return;
    }
    paramString = new Intent("android.intent.action.CALL", Uri.parse(paramString.toString()));
    paramString.addFlags(268435456);
    this.imWebView.getExpandedActivity().startActivity(paramString);
    this.imWebView.fireOnLeaveApplication();
  }
  
  public void muteAudio(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> muteAudio: ");
    this.imWebView.muteAudio(paramString);
  }
  
  public void muteVideo(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> muteVideo: ");
    this.imWebView.muteVideo(paramString);
  }
  
  public void openExternal(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> openExternal: url: " + paramString);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString));
    localIntent.addFlags(268435456);
    try
    {
      this.imWebView.getContext().startActivity(localIntent);
      return;
    }
    catch (Exception paramString)
    {
      this.imWebView.raiseError("Request must specify a valid URL", "openExternal");
    }
  }
  
  public void pauseAudio(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> pauseAudio: id :" + paramString);
    this.imWebView.pauseAudio(paramString);
  }
  
  public void pauseVideo(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> pauseVideo: id :" + paramString);
    this.imWebView.pauseVideo(paramString);
  }
  
  public void playAudio(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, String paramString4)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "playAudio: url: " + paramString1 + " autoPlay: " + paramBoolean1 + " controls: " + paramBoolean2 + " loop: " + paramBoolean3 + " startStyle: " + paramString2 + " stopStyle: " + paramString3 + " id:" + paramString4);
    this.imWebView.playAudio(paramString1, paramBoolean1, paramBoolean2, paramBoolean3, paramString2, paramString3, paramString4);
  }
  
  public void playVideo(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> playVideo: url: " + paramString1 + " audioMuted: " + paramBoolean1 + " autoPlay: " + paramBoolean2 + " controls: " + paramBoolean3 + " loop: " + paramBoolean4 + " x: " + paramString2 + " y: " + paramString3 + " width: " + paramString4 + " height: " + paramString5 + " startStyle: " + paramString6 + " stopStyle: " + paramString7 + " id:" + paramString8);
    JSController.Dimensions localDimensions = new JSController.Dimensions();
    localDimensions.x = Integer.parseInt(paramString2);
    localDimensions.y = Integer.parseInt(paramString3);
    localDimensions.width = Integer.parseInt(paramString4);
    localDimensions.height = Integer.parseInt(paramString5);
    this.imWebView.playVideo(paramString1, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, localDimensions, paramString6, paramString7, paramString8);
  }
  
  public void seekAudio(String paramString, int paramInt)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> seekAudio: ");
    this.imWebView.seekAudio(paramString, paramInt);
  }
  
  public void seekVideo(String paramString, int paramInt)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> seekVideo: ");
    this.imWebView.seekVideo(paramString, paramInt);
  }
  
  public void sendMail(String paramString1, String paramString2, String paramString3)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> sendMail: recipient: " + paramString1 + " subject: " + paramString2 + " body: " + paramString3);
    try
    {
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setType("plain/text");
      localIntent.putExtra("android.intent.extra.EMAIL", new String[] { paramString1 });
      localIntent.putExtra("android.intent.extra.SUBJECT", paramString2);
      localIntent.putExtra("android.intent.extra.TEXT", paramString3);
      localIntent.addFlags(268435456);
      paramString1 = Intent.createChooser(localIntent, "Choose the Email Client.");
      this.imWebView.getExpandedActivity().startActivity(paramString1);
      this.imWebView.fireOnLeaveApplication();
      return;
    }
    catch (Exception paramString1)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception in sending mail ", paramString1);
      this.imWebView.raiseError("Exception in sending mail", "sendMail");
    }
  }
  
  public void sendSMS(String paramString1, String paramString2)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> sendSMS: recipient: " + paramString1 + " body: " + paramString2);
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.putExtra("address", paramString1);
      localIntent.putExtra("sms_body", paramString2);
      localIntent.setType("vnd.android-dir/mms-sms");
      localIntent.addFlags(268435456);
      this.imWebView.getExpandedActivity().startActivity(localIntent);
      this.imWebView.fireOnLeaveApplication();
      return;
    }
    catch (Exception paramString1)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception in sending SMS ", paramString1);
      this.imWebView.raiseError("Exception in sending SMS", "sendSMS");
    }
  }
  
  public void setAudioVolume(String paramString, int paramInt)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> setAudioVolume: ");
    this.imWebView.setAudioVolume(paramString, paramInt);
  }
  
  public void setVideoVolume(String paramString, int paramInt)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> setVideoVolume: ");
    this.imWebView.setVideoVolume(paramString, paramInt);
  }
  
  public void showAlert(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", paramString);
  }
  
  public void showVideo(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> showVideo: id :" + paramString);
    this.imWebView.showVideo(paramString);
  }
  
  public void stopAllListeners()
  {
    try
    {
      this.a.stopAllListeners();
      this.b.stopAllListeners();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void unMuteAudio(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> unMuteAudio: ");
    this.imWebView.unMuteAudio(paramString);
  }
  
  public void unMuteVideo(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSUtilityController-> unMuteVideo: ");
    this.imWebView.unMuteVideo(paramString);
  }
  
  public String writeToDiskWrap(InputStream paramInputStream, String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4)
    throws IllegalStateException, IOException
  {
    return this.a.writeToDiskWrap(paramInputStream, paramString1, paramBoolean, paramString2, paramString3, paramString4);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/ai/controller/JSUtilityController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */