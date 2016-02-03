package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import android.content.Intent;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.common.d;
import java.util.EnumMap;

public class HelpAboutHelper
{
  private static final EnumMap<HelpTopic, String> aCX;
  static c apd = new c();
  
  static
  {
    aCX = new EnumMap(HelpTopic.class);
    aCX.put(HelpTopic.aCY, "#table of contents");
    aCX.put(HelpTopic.aCZ, "");
    aCX.put(HelpTopic.aDa, "#document_list_selection");
    aCX.put(HelpTopic.aDb, "#page_list");
    aCX.put(HelpTopic.aDc, "#page_list_selection");
    aCX.put(HelpTopic.aDd, "#page_detail");
    aCX.put(HelpTopic.aDe, "#camera");
    aCX.put(HelpTopic.aDf, "#settings");
  }
  
  public static void a(Context paramContext, HelpTopic paramHelpTopic)
  {
    paramHelpTopic = (String)aCX.get(paramHelpTopic);
    if (paramHelpTopic != null) {}
    for (paramHelpTopic = "file:///android_asset/help/index.html" + paramHelpTopic;; paramHelpTopic = "file:///android_asset/help/index.html")
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.MAIN");
      localIntent.setClass(paramContext, WebActivity.class);
      localIntent.putExtra("WEB_ACTIVITY_HOME_LINK", paramHelpTopic);
      paramContext.startActivity(localIntent);
      return;
    }
  }
  
  public static void aq(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.setClass(paramContext, WebActivity.class);
    localIntent.putExtra("WEB_ACTIVITY_HOME_LINK", "http://www.mobisystems.com");
    paramContext.startActivity(localIntent);
  }
  
  public static void ar(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.setClass(paramContext, WebActivity.class);
    localIntent.putExtra("WEB_ACTIVITY_HOME_DATA", aw(paramContext));
    paramContext.startActivity(localIntent);
  }
  
  public static void as(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.setClass(paramContext, WebActivity.class);
    localIntent.putExtra("WEB_ACTIVITY_HOME_LINK", "file:///android_asset/about/third-party.html");
    paramContext.startActivity(localIntent);
  }
  
  public static void at(Context paramContext)
  {
    String str = "http://www.mobisystems.com/mobile/privacy-policy.html";
    if ((d.DD()) || (d.DE())) {
      str = "file:///android_asset/about/privacy-policy.html";
    }
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.setClass(paramContext, WebActivity.class);
    localIntent.putExtra("WEB_ACTIVITY_HOME_LINK", str);
    paramContext.startActivity(localIntent);
  }
  
  public static void au(Context paramContext)
  {
    String str = "http://www.mobisystems.com/mobile/terms-of-use.html";
    if ((d.DD()) || (d.DE())) {
      str = "file:///android_asset/about/terms.html";
    }
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.setClass(paramContext, WebActivity.class);
    localIntent.putExtra("WEB_ACTIVITY_HOME_LINK", str);
    paramContext.startActivity(localIntent);
  }
  
  /* Error */
  private static String av(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 4
    //   7: ldc 43
    //   9: astore 5
    //   11: new 84	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   18: ldc 43
    //   20: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 164	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   27: aload_0
    //   28: invokevirtual 167	android/content/Context:getPackageName	()Ljava/lang/String;
    //   31: iconst_0
    //   32: invokevirtual 173	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   35: getfield 179	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   38: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: astore_1
    //   45: aload_1
    //   46: astore 5
    //   48: new 84	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   55: astore 6
    //   57: aload_0
    //   58: invokevirtual 183	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   61: invokevirtual 187	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   64: ldc -67
    //   66: invokevirtual 195	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   69: astore_0
    //   70: aload_0
    //   71: astore_1
    //   72: aload_3
    //   73: astore_2
    //   74: new 197	java/io/InputStreamReader
    //   77: dup
    //   78: aload_0
    //   79: ldc -57
    //   81: invokespecial 202	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   84: astore_3
    //   85: sipush 1024
    //   88: invokestatic 208	java/nio/CharBuffer:allocate	(I)Ljava/nio/CharBuffer;
    //   91: astore_1
    //   92: aload_3
    //   93: aload_1
    //   94: invokevirtual 214	java/io/Reader:read	(Ljava/nio/CharBuffer;)I
    //   97: ifle +207 -> 304
    //   100: aload 6
    //   102: aload_1
    //   103: invokevirtual 218	java/nio/CharBuffer:flip	()Ljava/nio/Buffer;
    //   106: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_1
    //   111: invokevirtual 224	java/nio/CharBuffer:clear	()Ljava/nio/Buffer;
    //   114: pop
    //   115: goto -23 -> 92
    //   118: astore_1
    //   119: aload_3
    //   120: astore 4
    //   122: aload_1
    //   123: astore_3
    //   124: aload_0
    //   125: astore_1
    //   126: aload 4
    //   128: astore_2
    //   129: getstatic 21	com/mobisystems/mobiscanner/controller/HelpAboutHelper:apd	Lcom/mobisystems/mobiscanner/common/c;
    //   132: new 84	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   139: ldc -30
    //   141: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_3
    //   145: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokevirtual 230	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   154: aload 4
    //   156: ifnull +8 -> 164
    //   159: aload 4
    //   161: invokevirtual 233	java/io/Reader:close	()V
    //   164: aload_0
    //   165: ifnull +7 -> 172
    //   168: aload_0
    //   169: invokevirtual 236	java/io/InputStream:close	()V
    //   172: aload 6
    //   174: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: ldc -18
    //   179: aload 5
    //   181: invokevirtual 242	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   184: ldc -12
    //   186: ldc -10
    //   188: invokevirtual 242	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   191: areturn
    //   192: astore_1
    //   193: getstatic 21	com/mobisystems/mobiscanner/controller/HelpAboutHelper:apd	Lcom/mobisystems/mobiscanner/common/c;
    //   196: new 84	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   203: ldc -8
    //   205: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_1
    //   209: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokevirtual 230	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   218: goto -170 -> 48
    //   221: astore_3
    //   222: aconst_null
    //   223: astore_0
    //   224: aload_2
    //   225: ifnull +7 -> 232
    //   228: aload_2
    //   229: invokevirtual 233	java/io/Reader:close	()V
    //   232: aload_0
    //   233: ifnull +7 -> 240
    //   236: aload_0
    //   237: invokevirtual 236	java/io/InputStream:close	()V
    //   240: aload_3
    //   241: athrow
    //   242: astore_0
    //   243: getstatic 21	com/mobisystems/mobiscanner/controller/HelpAboutHelper:apd	Lcom/mobisystems/mobiscanner/common/c;
    //   246: new 84	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   253: ldc -6
    //   255: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_0
    //   259: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokevirtual 230	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   268: goto -28 -> 240
    //   271: astore_0
    //   272: getstatic 21	com/mobisystems/mobiscanner/controller/HelpAboutHelper:apd	Lcom/mobisystems/mobiscanner/common/c;
    //   275: astore_1
    //   276: new 84	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   283: ldc -6
    //   285: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_0
    //   289: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: astore_0
    //   296: aload_1
    //   297: aload_0
    //   298: invokevirtual 230	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   301: goto -129 -> 172
    //   304: aload_3
    //   305: ifnull +7 -> 312
    //   308: aload_3
    //   309: invokevirtual 233	java/io/Reader:close	()V
    //   312: aload_0
    //   313: ifnull -141 -> 172
    //   316: aload_0
    //   317: invokevirtual 236	java/io/InputStream:close	()V
    //   320: goto -148 -> 172
    //   323: astore_0
    //   324: getstatic 21	com/mobisystems/mobiscanner/controller/HelpAboutHelper:apd	Lcom/mobisystems/mobiscanner/common/c;
    //   327: astore_1
    //   328: new 84	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   335: ldc -6
    //   337: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload_0
    //   341: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   344: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: astore_0
    //   348: goto -52 -> 296
    //   351: astore_3
    //   352: aload_1
    //   353: astore_0
    //   354: goto -130 -> 224
    //   357: astore_1
    //   358: aload_3
    //   359: astore_2
    //   360: aload_1
    //   361: astore_3
    //   362: goto -138 -> 224
    //   365: astore_3
    //   366: aconst_null
    //   367: astore_0
    //   368: goto -244 -> 124
    //   371: astore_3
    //   372: goto -248 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	paramContext	Context
    //   44	67	1	localObject1	Object
    //   118	5	1	localException1	Exception
    //   125	1	1	localContext	Context
    //   192	17	1	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   275	78	1	localc	c
    //   357	4	1	localObject2	Object
    //   1	359	2	localObject3	Object
    //   3	142	3	localObject4	Object
    //   221	88	3	localObject5	Object
    //   351	8	3	localObject6	Object
    //   361	1	3	localObject7	Object
    //   365	1	3	localException2	Exception
    //   371	1	3	localException3	Exception
    //   5	155	4	localObject8	Object
    //   9	171	5	localObject9	Object
    //   55	118	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   85	92	118	java/lang/Exception
    //   92	115	118	java/lang/Exception
    //   11	45	192	android/content/pm/PackageManager$NameNotFoundException
    //   57	70	221	finally
    //   228	232	242	java/lang/Exception
    //   236	240	242	java/lang/Exception
    //   159	164	271	java/lang/Exception
    //   168	172	271	java/lang/Exception
    //   308	312	323	java/lang/Exception
    //   316	320	323	java/lang/Exception
    //   74	85	351	finally
    //   129	154	351	finally
    //   85	92	357	finally
    //   92	115	357	finally
    //   57	70	365	java/lang/Exception
    //   74	85	371	java/lang/Exception
  }
  
  /* Error */
  private static String aw(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 4
    //   7: ldc 43
    //   9: astore 5
    //   11: new 84	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   18: ldc 43
    //   20: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 164	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   27: aload_0
    //   28: invokevirtual 167	android/content/Context:getPackageName	()Ljava/lang/String;
    //   31: iconst_0
    //   32: invokevirtual 173	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   35: getfield 179	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   38: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: astore_1
    //   45: aload_1
    //   46: astore 5
    //   48: new 252	java/util/Date
    //   51: dup
    //   52: aload_0
    //   53: invokestatic 256	com/mobisystems/mobiscanner/controller/HelpAboutHelper:ax	(Landroid/content/Context;)J
    //   56: invokespecial 259	java/util/Date:<init>	(J)V
    //   59: astore_1
    //   60: new 261	java/text/SimpleDateFormat
    //   63: dup
    //   64: ldc_w 263
    //   67: getstatic 269	java/util/Locale:US	Ljava/util/Locale;
    //   70: invokespecial 272	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   73: aload_1
    //   74: invokevirtual 276	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   77: astore 6
    //   79: new 84	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   86: astore 7
    //   88: aload_0
    //   89: invokevirtual 183	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   92: invokevirtual 187	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   95: ldc_w 278
    //   98: invokevirtual 195	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   101: astore_0
    //   102: aload_0
    //   103: astore_1
    //   104: aload_3
    //   105: astore_2
    //   106: new 197	java/io/InputStreamReader
    //   109: dup
    //   110: aload_0
    //   111: ldc -57
    //   113: invokespecial 202	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   116: astore_3
    //   117: sipush 1024
    //   120: invokestatic 208	java/nio/CharBuffer:allocate	(I)Ljava/nio/CharBuffer;
    //   123: astore_1
    //   124: aload_3
    //   125: aload_1
    //   126: invokevirtual 214	java/io/Reader:read	(Ljava/nio/CharBuffer;)I
    //   129: ifle +208 -> 337
    //   132: aload 7
    //   134: aload_1
    //   135: invokevirtual 218	java/nio/CharBuffer:flip	()Ljava/nio/Buffer;
    //   138: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_1
    //   143: invokevirtual 224	java/nio/CharBuffer:clear	()Ljava/nio/Buffer;
    //   146: pop
    //   147: goto -23 -> 124
    //   150: astore_1
    //   151: aload_3
    //   152: astore 4
    //   154: aload_1
    //   155: astore_3
    //   156: aload_0
    //   157: astore_1
    //   158: aload 4
    //   160: astore_2
    //   161: getstatic 21	com/mobisystems/mobiscanner/controller/HelpAboutHelper:apd	Lcom/mobisystems/mobiscanner/common/c;
    //   164: new 84	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   171: ldc -30
    //   173: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_3
    //   177: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokevirtual 230	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   186: aload 4
    //   188: ifnull +8 -> 196
    //   191: aload 4
    //   193: invokevirtual 233	java/io/Reader:close	()V
    //   196: aload_0
    //   197: ifnull +7 -> 204
    //   200: aload_0
    //   201: invokevirtual 236	java/io/InputStream:close	()V
    //   204: aload 7
    //   206: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: ldc -18
    //   211: aload 5
    //   213: invokevirtual 242	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   216: ldc_w 280
    //   219: aload 6
    //   221: invokevirtual 242	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   224: areturn
    //   225: astore_1
    //   226: getstatic 21	com/mobisystems/mobiscanner/controller/HelpAboutHelper:apd	Lcom/mobisystems/mobiscanner/common/c;
    //   229: new 84	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   236: ldc -8
    //   238: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_1
    //   242: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokevirtual 230	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   251: goto -203 -> 48
    //   254: astore_3
    //   255: aconst_null
    //   256: astore_0
    //   257: aload_2
    //   258: ifnull +7 -> 265
    //   261: aload_2
    //   262: invokevirtual 233	java/io/Reader:close	()V
    //   265: aload_0
    //   266: ifnull +7 -> 273
    //   269: aload_0
    //   270: invokevirtual 236	java/io/InputStream:close	()V
    //   273: aload_3
    //   274: athrow
    //   275: astore_0
    //   276: getstatic 21	com/mobisystems/mobiscanner/controller/HelpAboutHelper:apd	Lcom/mobisystems/mobiscanner/common/c;
    //   279: new 84	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   286: ldc -6
    //   288: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_0
    //   292: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokevirtual 230	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   301: goto -28 -> 273
    //   304: astore_0
    //   305: getstatic 21	com/mobisystems/mobiscanner/controller/HelpAboutHelper:apd	Lcom/mobisystems/mobiscanner/common/c;
    //   308: astore_1
    //   309: new 84	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   316: ldc -6
    //   318: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_0
    //   322: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: astore_0
    //   329: aload_1
    //   330: aload_0
    //   331: invokevirtual 230	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   334: goto -130 -> 204
    //   337: aload_3
    //   338: ifnull +7 -> 345
    //   341: aload_3
    //   342: invokevirtual 233	java/io/Reader:close	()V
    //   345: aload_0
    //   346: ifnull -142 -> 204
    //   349: aload_0
    //   350: invokevirtual 236	java/io/InputStream:close	()V
    //   353: goto -149 -> 204
    //   356: astore_0
    //   357: getstatic 21	com/mobisystems/mobiscanner/controller/HelpAboutHelper:apd	Lcom/mobisystems/mobiscanner/common/c;
    //   360: astore_1
    //   361: new 84	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   368: ldc -6
    //   370: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload_0
    //   374: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: astore_0
    //   381: goto -52 -> 329
    //   384: astore_3
    //   385: aload_1
    //   386: astore_0
    //   387: goto -130 -> 257
    //   390: astore_1
    //   391: aload_3
    //   392: astore_2
    //   393: aload_1
    //   394: astore_3
    //   395: goto -138 -> 257
    //   398: astore_3
    //   399: aconst_null
    //   400: astore_0
    //   401: goto -245 -> 156
    //   404: astore_3
    //   405: goto -249 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	paramContext	Context
    //   44	99	1	localObject1	Object
    //   150	5	1	localException1	Exception
    //   157	1	1	localContext	Context
    //   225	17	1	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   308	78	1	localc	c
    //   390	4	1	localObject2	Object
    //   1	392	2	localObject3	Object
    //   3	174	3	localObject4	Object
    //   254	88	3	localObject5	Object
    //   384	8	3	localObject6	Object
    //   394	1	3	localObject7	Object
    //   398	1	3	localException2	Exception
    //   404	1	3	localException3	Exception
    //   5	187	4	localObject8	Object
    //   9	203	5	localObject9	Object
    //   77	143	6	str	String
    //   86	119	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   117	124	150	java/lang/Exception
    //   124	147	150	java/lang/Exception
    //   11	45	225	android/content/pm/PackageManager$NameNotFoundException
    //   88	102	254	finally
    //   261	265	275	java/lang/Exception
    //   269	273	275	java/lang/Exception
    //   191	196	304	java/lang/Exception
    //   200	204	304	java/lang/Exception
    //   341	345	356	java/lang/Exception
    //   349	353	356	java/lang/Exception
    //   106	117	384	finally
    //   161	186	384	finally
    //   117	124	390	finally
    //   124	147	390	finally
    //   88	102	398	java/lang/Exception
    //   106	117	404	java/lang/Exception
  }
  
  /* Error */
  private static long ax(Context paramContext)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_1
    //   2: aconst_null
    //   3: astore 5
    //   5: new 284	java/util/zip/ZipFile
    //   8: dup
    //   9: aload_0
    //   10: invokevirtual 164	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   13: aload_0
    //   14: invokevirtual 167	android/content/Context:getPackageName	()Ljava/lang/String;
    //   17: iconst_0
    //   18: invokevirtual 288	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   21: getfield 293	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   24: invokespecial 295	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   27: astore_0
    //   28: aload_0
    //   29: ldc_w 297
    //   32: invokevirtual 301	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   35: invokevirtual 307	java/util/zip/ZipEntry:getTime	()J
    //   38: lstore_3
    //   39: lload_3
    //   40: lstore_1
    //   41: lload_1
    //   42: lstore_3
    //   43: aload_0
    //   44: ifnull +11 -> 55
    //   47: lload_1
    //   48: lstore_3
    //   49: aload_0
    //   50: invokevirtual 308	java/util/zip/ZipFile:close	()V
    //   53: lload_1
    //   54: lstore_3
    //   55: lload_3
    //   56: lreturn
    //   57: astore_0
    //   58: aload 5
    //   60: ifnull +8 -> 68
    //   63: aload 5
    //   65: invokevirtual 308	java/util/zip/ZipFile:close	()V
    //   68: aload_0
    //   69: athrow
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_0
    //   73: lload_1
    //   74: lstore_3
    //   75: aload_0
    //   76: ifnull -21 -> 55
    //   79: lload_1
    //   80: lstore_3
    //   81: aload_0
    //   82: invokevirtual 308	java/util/zip/ZipFile:close	()V
    //   85: lconst_0
    //   86: lreturn
    //   87: astore_0
    //   88: lload_3
    //   89: lreturn
    //   90: astore 5
    //   92: goto -24 -> 68
    //   95: astore 6
    //   97: aload_0
    //   98: astore 5
    //   100: aload 6
    //   102: astore_0
    //   103: goto -45 -> 58
    //   106: astore 5
    //   108: goto -35 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	paramContext	Context
    //   1	79	1	l1	long
    //   38	51	3	l2	long
    //   3	61	5	localObject1	Object
    //   90	1	5	localIOException	java.io.IOException
    //   98	1	5	localContext	Context
    //   106	1	5	localException	Exception
    //   95	6	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	28	57	finally
    //   5	28	70	java/lang/Exception
    //   49	53	87	java/io/IOException
    //   81	85	87	java/io/IOException
    //   63	68	90	java/io/IOException
    //   28	39	95	finally
    //   28	39	106	java/lang/Exception
  }
  
  public static void showAbout(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.setClass(paramContext, WebActivity.class);
    localIntent.putExtra("WEB_ACTIVITY_HOME_DATA", av(paramContext));
    paramContext.startActivity(localIntent);
  }
  
  public static enum HelpTopic
  {
    private HelpTopic() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/HelpAboutHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */