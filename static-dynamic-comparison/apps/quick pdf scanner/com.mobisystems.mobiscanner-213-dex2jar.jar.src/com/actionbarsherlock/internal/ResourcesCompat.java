package com.actionbarsherlock.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.actionbarsherlock.R.bool;
import com.actionbarsherlock.R.integer;

public final class ResourcesCompat
{
  private static final String TAG = "ResourcesCompat";
  
  public static boolean getResources_getBoolean(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return paramContext.getResources().getBoolean(paramInt);
    }
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f2 = paramContext.widthPixels / paramContext.density;
    float f3 = paramContext.heightPixels / paramContext.density;
    float f1 = f3;
    if (f2 < f3) {
      f1 = f2;
    }
    if (paramInt == R.bool.abs__action_bar_embed_tabs) {
      return f2 >= 480.0F;
    }
    if (paramInt == R.bool.abs__split_action_bar_is_narrow) {
      return f2 < 480.0F;
    }
    if (paramInt == R.bool.abs__action_bar_expanded_action_views_exclusive) {
      return f1 < 600.0F;
    }
    if (paramInt == R.bool.abs__config_allowActionMenuItemTextWithIcon) {
      return f2 >= 480.0F;
    }
    throw new IllegalArgumentException("Unknown boolean resource ID " + paramInt);
  }
  
  public static int getResources_getInteger(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 13) {
      return paramContext.getResources().getInteger(paramInt);
    }
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f = paramContext.widthPixels / paramContext.density;
    if (paramInt == R.integer.abs__max_action_buttons)
    {
      if (f >= 600.0F) {
        return 5;
      }
      if (f >= 500.0F) {
        return 4;
      }
      if (f >= 360.0F) {
        return 3;
      }
      return 2;
    }
    throw new IllegalArgumentException("Unknown integer resource ID " + paramInt);
  }
  
  /* Error */
  public static int loadLogoFromManifest(android.app.Activity paramActivity)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 109	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: invokevirtual 114	java/lang/Class:getName	()Ljava/lang/String;
    //   7: astore 9
    //   9: aload_0
    //   10: invokevirtual 120	android/app/Activity:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   13: getfield 125	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   16: astore 10
    //   18: aload_0
    //   19: aload 10
    //   21: iconst_0
    //   22: invokevirtual 129	android/app/Activity:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   25: invokevirtual 133	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   28: ldc -121
    //   30: invokevirtual 141	android/content/res/AssetManager:openXmlResourceParser	(Ljava/lang/String;)Landroid/content/res/XmlResourceParser;
    //   33: astore 11
    //   35: aload 11
    //   37: invokeinterface 147 1 0
    //   42: istore_2
    //   43: iconst_0
    //   44: istore_1
    //   45: iload_1
    //   46: istore_3
    //   47: iload_2
    //   48: iconst_1
    //   49: if_icmpeq +270 -> 319
    //   52: iload_1
    //   53: istore_3
    //   54: iload_2
    //   55: iconst_2
    //   56: if_icmpne +293 -> 349
    //   59: iload_1
    //   60: istore_2
    //   61: aload 11
    //   63: invokeinterface 148 1 0
    //   68: astore_0
    //   69: iload_1
    //   70: istore_2
    //   71: ldc -106
    //   73: aload_0
    //   74: invokevirtual 156	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifeq +73 -> 150
    //   80: iload_1
    //   81: istore_2
    //   82: aload 11
    //   84: invokeinterface 159 1 0
    //   89: iconst_1
    //   90: isub
    //   91: istore_3
    //   92: iload_1
    //   93: istore_2
    //   94: iload_3
    //   95: iflt +35 -> 130
    //   98: iload_1
    //   99: istore_2
    //   100: ldc -95
    //   102: aload 11
    //   104: iload_3
    //   105: invokeinterface 165 2 0
    //   110: invokevirtual 156	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   113: ifeq +30 -> 143
    //   116: iload_1
    //   117: istore_2
    //   118: aload 11
    //   120: iload_3
    //   121: iconst_0
    //   122: invokeinterface 169 3 0
    //   127: istore_1
    //   128: iload_1
    //   129: istore_2
    //   130: iload_2
    //   131: istore_1
    //   132: aload 11
    //   134: invokeinterface 172 1 0
    //   139: istore_2
    //   140: goto -95 -> 45
    //   143: iload_3
    //   144: iconst_1
    //   145: isub
    //   146: istore_3
    //   147: goto -55 -> 92
    //   150: iload_1
    //   151: istore_2
    //   152: iload_1
    //   153: istore_3
    //   154: ldc -82
    //   156: aload_0
    //   157: invokevirtual 156	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifeq +189 -> 349
    //   163: iload_1
    //   164: istore_2
    //   165: aload 11
    //   167: invokeinterface 159 1 0
    //   172: iconst_1
    //   173: isub
    //   174: istore_3
    //   175: iconst_0
    //   176: istore 4
    //   178: aconst_null
    //   179: astore 7
    //   181: aconst_null
    //   182: astore_0
    //   183: iload_3
    //   184: iflt +126 -> 310
    //   187: iload_1
    //   188: istore_2
    //   189: aload 11
    //   191: iload_3
    //   192: invokeinterface 165 2 0
    //   197: astore 12
    //   199: iload_1
    //   200: istore_2
    //   201: ldc -95
    //   203: aload 12
    //   205: invokevirtual 156	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   208: ifeq +50 -> 258
    //   211: iload_1
    //   212: istore_2
    //   213: aload 11
    //   215: iload_3
    //   216: iconst_0
    //   217: invokeinterface 169 3 0
    //   222: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: astore 8
    //   227: iload 4
    //   229: istore 5
    //   231: iload_1
    //   232: istore_2
    //   233: aload 8
    //   235: ifnull +119 -> 354
    //   238: iload_1
    //   239: istore_2
    //   240: aload 7
    //   242: ifnull +112 -> 354
    //   245: iload_1
    //   246: istore_2
    //   247: aload 8
    //   249: invokevirtual 183	java/lang/Integer:intValue	()I
    //   252: istore_1
    //   253: iload_1
    //   254: istore_2
    //   255: goto +99 -> 354
    //   258: iload 4
    //   260: istore 5
    //   262: aload_0
    //   263: astore 8
    //   265: iload_1
    //   266: istore_2
    //   267: ldc -71
    //   269: aload 12
    //   271: invokevirtual 156	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   274: ifeq -43 -> 231
    //   277: iload_1
    //   278: istore_2
    //   279: aload 10
    //   281: aload 11
    //   283: iload_3
    //   284: invokeinterface 188 2 0
    //   289: invokestatic 194	com/actionbarsherlock/internal/ActionBarSherlockCompat:cleanActivityName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   292: astore 7
    //   294: iload_1
    //   295: istore_2
    //   296: aload 9
    //   298: aload 7
    //   300: invokevirtual 156	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   303: istore 6
    //   305: iload 6
    //   307: ifne +14 -> 321
    //   310: iload_1
    //   311: istore_3
    //   312: iload 4
    //   314: ifeq +35 -> 349
    //   317: iload_1
    //   318: istore_3
    //   319: iload_3
    //   320: ireturn
    //   321: iconst_1
    //   322: istore 5
    //   324: aload_0
    //   325: astore 8
    //   327: goto -96 -> 231
    //   330: astore_0
    //   331: iconst_0
    //   332: istore_2
    //   333: aload_0
    //   334: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   337: iload_2
    //   338: ireturn
    //   339: astore_0
    //   340: goto -7 -> 333
    //   343: astore_0
    //   344: iload_1
    //   345: istore_2
    //   346: goto -13 -> 333
    //   349: iload_3
    //   350: istore_1
    //   351: goto -219 -> 132
    //   354: iload_3
    //   355: iconst_1
    //   356: isub
    //   357: istore_3
    //   358: iload_2
    //   359: istore_1
    //   360: iload 5
    //   362: istore 4
    //   364: aload 8
    //   366: astore_0
    //   367: goto -184 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	paramActivity	android.app.Activity
    //   44	316	1	i	int
    //   42	317	2	j	int
    //   46	312	3	k	int
    //   176	187	4	m	int
    //   229	132	5	n	int
    //   303	3	6	bool	boolean
    //   179	120	7	str1	String
    //   225	140	8	localObject	Object
    //   7	290	9	str2	String
    //   16	264	10	str3	String
    //   33	249	11	localXmlResourceParser	android.content.res.XmlResourceParser
    //   197	73	12	str4	String
    // Exception table:
    //   from	to	target	type
    //   0	43	330	java/lang/Exception
    //   61	69	339	java/lang/Exception
    //   71	80	339	java/lang/Exception
    //   82	92	339	java/lang/Exception
    //   100	116	339	java/lang/Exception
    //   118	128	339	java/lang/Exception
    //   154	163	339	java/lang/Exception
    //   165	175	339	java/lang/Exception
    //   189	199	339	java/lang/Exception
    //   201	211	339	java/lang/Exception
    //   213	227	339	java/lang/Exception
    //   247	253	339	java/lang/Exception
    //   267	277	339	java/lang/Exception
    //   279	294	339	java/lang/Exception
    //   296	305	339	java/lang/Exception
    //   132	140	343	java/lang/Exception
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/internal/ResourcesCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */