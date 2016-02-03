package a.a.a;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class b
{
  private static String a = null;
  private static String b = null;
  
  public static int a(WeakReference paramWeakReference)
  {
    int i = 0;
    String[] arrayOfString = b();
    Object localObject = null;
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      if (paramWeakReference != null) {}
      for (;;)
      {
        try
        {
          paramWeakReference = (Context)paramWeakReference.get();
          if (paramWeakReference == null) {
            break label114;
          }
          paramWeakReference = Arrays.asList(paramWeakReference.getSharedPreferences("HockeySDK", 0).getString("ConfirmedFilenames", "").split("\\|"));
        }
        catch (Exception paramWeakReference)
        {
          int k;
          int m;
          int j;
          paramWeakReference = (WeakReference)localObject;
          continue;
        }
        if (paramWeakReference != null)
        {
          k = 2;
          m = arrayOfString.length;
          j = k;
          if (i < m)
          {
            if (!paramWeakReference.contains(arrayOfString[i])) {
              j = 1;
            }
          }
          else {
            return j;
          }
          i += 1;
          continue;
        }
        return 1;
        label114:
        paramWeakReference = null;
      }
    }
    return 0;
  }
  
  private static String a()
  {
    return b + "api/2/apps/" + a + "/crashes/";
  }
  
  private static String a(String[] paramArrayOfString, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localStringBuffer.append(paramArrayOfString[i]);
      if (i < paramArrayOfString.length - 1) {
        localStringBuffer.append(paramString);
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static void a(Context paramContext, c paramc)
  {
    if ((paramc != null) && (paramc.b())) {}
    Boolean localBoolean2;
    WeakReference localWeakReference;
    int i;
    for (boolean bool = true;; bool = false)
    {
      localBoolean2 = Boolean.valueOf(bool);
      localWeakReference = new WeakReference(paramContext);
      i = a(localWeakReference);
      if (i != 1) {
        break label118;
      }
      Boolean localBoolean1 = Boolean.valueOf(false);
      paramContext = localBoolean1;
      if (paramc != null)
      {
        paramContext = Boolean.valueOf(Boolean.valueOf(localBoolean1.booleanValue() | paramc.a()).booleanValue() | paramc.g());
        paramc.h();
      }
      if (paramContext.booleanValue()) {
        break;
      }
      c(localWeakReference, paramc, localBoolean2.booleanValue());
      return;
    }
    d(localWeakReference, paramc, localBoolean2.booleanValue());
    return;
    label118:
    if (i == 2)
    {
      if (paramc != null) {
        paramc.i();
      }
      d(localWeakReference, paramc, localBoolean2.booleanValue());
      return;
    }
    e(localWeakReference, paramc, localBoolean2.booleanValue());
  }
  
  public static void a(Context paramContext, String paramString, c paramc)
  {
    a(paramContext, "https://sdk.hockeyapp.net/", paramString, paramc);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, c paramc)
  {
    a(paramContext, paramString1, paramString2, paramc, false);
    a(paramContext, paramc);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, c paramc, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      b = paramString1;
      a = paramString2;
      a.a(paramContext);
      if (a == null) {
        a = a.d;
      }
      if (paramBoolean) {
        if ((paramc == null) || (!paramc.b())) {
          break label68;
        }
      }
    }
    label68:
    for (paramBoolean = true;; paramBoolean = false)
    {
      e(new WeakReference(paramContext), paramc, Boolean.valueOf(paramBoolean).booleanValue());
      return;
    }
  }
  
  public static void a(WeakReference paramWeakReference, c paramc)
  {
    String[] arrayOfString = b();
    Object localObject1;
    int i;
    Object localObject4;
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      Log.d("HockeyApp", "Found " + arrayOfString.length + " stacktrace(s).");
      localObject1 = Boolean.valueOf(false);
      i = 0;
      if (i < arrayOfString.length)
      {
        localObject4 = arrayOfString[i];
        for (;;)
        {
          try
          {
            String str = b(paramWeakReference, (String)localObject4);
            localObject2 = localObject1;
            if (str.length() > 0)
            {
              Log.d("HockeyApp", "Transmitting crash data: \n" + str);
              localObject2 = (DefaultHttpClient)a.a.a.d.a.a().b();
              HttpPost localHttpPost = new HttpPost(a());
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(new BasicNameValuePair("raw", str));
              localArrayList.add(new BasicNameValuePair("userID", b(paramWeakReference, ((String)localObject4).replace(".stacktrace", ".user"))));
              localArrayList.add(new BasicNameValuePair("contact", b(paramWeakReference, ((String)localObject4).replace(".stacktrace", ".contact"))));
              localArrayList.add(new BasicNameValuePair("description", b(paramWeakReference, ((String)localObject4).replace(".stacktrace", ".description"))));
              localArrayList.add(new BasicNameValuePair("sdk", "HockeySDK"));
              localArrayList.add(new BasicNameValuePair("sdk_version", "3.0.1"));
              localHttpPost.setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
              ((DefaultHttpClient)localObject2).execute(localHttpPost);
              localObject2 = Boolean.valueOf(true);
            }
            if (!((Boolean)localObject2).booleanValue()) {
              continue;
            }
            a(paramWeakReference, arrayOfString[i]);
            localObject4 = localObject2;
            if (paramc != null)
            {
              paramc.j();
              localObject4 = localObject2;
            }
          }
          catch (Exception localException)
          {
            Object localObject2;
            localException.printStackTrace();
            if (!((Boolean)localObject1).booleanValue()) {
              continue;
            }
            a(paramWeakReference, arrayOfString[i]);
            localObject4 = localObject1;
            if (paramc == null) {
              continue;
            }
            paramc.j();
            localObject4 = localObject1;
            continue;
            localObject4 = localObject1;
            if (paramc == null) {
              continue;
            }
            paramc.k();
            localObject4 = localObject1;
            continue;
          }
          finally
          {
            if (!((Boolean)localObject1).booleanValue()) {
              continue;
            }
            a(paramWeakReference, arrayOfString[i]);
            if (paramc == null) {
              continue;
            }
            paramc.j();
            throw ((Throwable)localObject3);
            if (paramc == null) {
              continue;
            }
            paramc.k();
            continue;
          }
          i += 1;
          localObject1 = localObject4;
          break;
          localObject4 = localObject2;
          if (paramc != null)
          {
            paramc.k();
            localObject4 = localObject2;
          }
        }
      }
    }
  }
  
  private static void a(WeakReference paramWeakReference, String paramString)
  {
    if (paramWeakReference != null)
    {
      paramWeakReference = (Context)paramWeakReference.get();
      if (paramWeakReference != null)
      {
        paramWeakReference.deleteFile(paramString);
        paramWeakReference.deleteFile(paramString.replace(".stacktrace", ".user"));
        paramWeakReference.deleteFile(paramString.replace(".stacktrace", ".contact"));
        paramWeakReference.deleteFile(paramString.replace(".stacktrace", ".description"));
      }
    }
  }
  
  /* Error */
  private static String b(WeakReference paramWeakReference, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnull +144 -> 147
    //   6: aload_0
    //   7: invokevirtual 34	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   10: checkcast 36	android/content/Context
    //   13: astore_0
    //   14: aload_0
    //   15: ifnull +132 -> 147
    //   18: new 75	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   25: astore_3
    //   26: new 271	java/io/BufferedReader
    //   29: dup
    //   30: new 273	java/io/InputStreamReader
    //   33: dup
    //   34: aload_0
    //   35: aload_1
    //   36: invokevirtual 277	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   39: invokespecial 280	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   42: invokespecial 283	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_0
    //   46: aload_0
    //   47: astore_1
    //   48: aload_0
    //   49: invokevirtual 286	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore_2
    //   53: aload_2
    //   54: ifnull +41 -> 95
    //   57: aload_0
    //   58: astore_1
    //   59: aload_3
    //   60: aload_2
    //   61: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_0
    //   66: astore_1
    //   67: aload_3
    //   68: ldc_w 288
    //   71: invokestatic 294	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   74: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: goto -32 -> 46
    //   81: astore_1
    //   82: aload_0
    //   83: ifnull +7 -> 90
    //   86: aload_0
    //   87: invokevirtual 297	java/io/BufferedReader:close	()V
    //   90: aload_3
    //   91: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: areturn
    //   95: aload_0
    //   96: ifnull -6 -> 90
    //   99: aload_0
    //   100: invokevirtual 297	java/io/BufferedReader:close	()V
    //   103: goto -13 -> 90
    //   106: astore_0
    //   107: goto -17 -> 90
    //   110: astore_2
    //   111: aconst_null
    //   112: astore_0
    //   113: aload_0
    //   114: astore_1
    //   115: aload_2
    //   116: invokevirtual 298	java/io/IOException:printStackTrace	()V
    //   119: aload_0
    //   120: ifnull -30 -> 90
    //   123: aload_0
    //   124: invokevirtual 297	java/io/BufferedReader:close	()V
    //   127: goto -37 -> 90
    //   130: astore_0
    //   131: goto -41 -> 90
    //   134: astore_0
    //   135: aconst_null
    //   136: astore_1
    //   137: aload_1
    //   138: ifnull +7 -> 145
    //   141: aload_1
    //   142: invokevirtual 297	java/io/BufferedReader:close	()V
    //   145: aload_0
    //   146: athrow
    //   147: aconst_null
    //   148: areturn
    //   149: astore_0
    //   150: goto -60 -> 90
    //   153: astore_1
    //   154: goto -9 -> 145
    //   157: astore_0
    //   158: goto -21 -> 137
    //   161: astore_2
    //   162: goto -49 -> 113
    //   165: astore_0
    //   166: aload_2
    //   167: astore_0
    //   168: goto -86 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramWeakReference	WeakReference
    //   0	171	1	paramString	String
    //   1	60	2	str	String
    //   110	6	2	localIOException1	java.io.IOException
    //   161	6	2	localIOException2	java.io.IOException
    //   25	66	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   48	53	81	java/io/FileNotFoundException
    //   59	65	81	java/io/FileNotFoundException
    //   67	78	81	java/io/FileNotFoundException
    //   99	103	106	java/io/IOException
    //   26	46	110	java/io/IOException
    //   123	127	130	java/io/IOException
    //   26	46	134	finally
    //   86	90	149	java/io/IOException
    //   141	145	153	java/io/IOException
    //   48	53	157	finally
    //   59	65	157	finally
    //   67	78	157	finally
    //   115	119	157	finally
    //   48	53	161	java/io/IOException
    //   59	65	161	java/io/IOException
    //   67	78	161	java/io/IOException
    //   26	46	165	java/io/FileNotFoundException
  }
  
  public static void b(WeakReference paramWeakReference)
  {
    String[] arrayOfString = b();
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      Log.d("HockeyApp", "Found " + arrayOfString.length + " stacktrace(s).");
      int i = 0;
      while (i < arrayOfString.length)
      {
        if (paramWeakReference != null) {}
        try
        {
          Log.d("HockeyApp", "Delete stacktrace " + arrayOfString[i] + ".");
          a(paramWeakReference, arrayOfString[i]);
          Context localContext = (Context)paramWeakReference.get();
          if (localContext != null) {
            localContext.deleteFile(arrayOfString[i]);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        i += 1;
      }
    }
  }
  
  private static String[] b()
  {
    if (a.a != null)
    {
      Log.d("HockeyApp", "Looking for exceptions in: " + a.a);
      File localFile = new File(a.a + "/");
      if ((!localFile.mkdir()) && (!localFile.exists())) {
        return new String[0];
      }
      localFile.list(new FilenameFilter()
      {
        public boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          return paramAnonymousString.endsWith(".stacktrace");
        }
      });
    }
    Log.d("HockeyApp", "Can't search for exception as file path is null.");
    return null;
  }
  
  private static void c(WeakReference paramWeakReference)
  {
    Object localObject;
    if (paramWeakReference != null)
    {
      localObject = (Context)paramWeakReference.get();
      if (localObject == null) {}
    }
    try
    {
      paramWeakReference = b();
      localObject = ((Context)localObject).getSharedPreferences("HockeySDK", 0).edit();
      ((SharedPreferences.Editor)localObject).putString("ConfirmedFilenames", a(paramWeakReference, "|"));
      a.a.a.d.c.a((SharedPreferences.Editor)localObject);
      return;
    }
    catch (Exception paramWeakReference) {}
  }
  
  private static void c(final WeakReference paramWeakReference, final c paramc, final boolean paramBoolean)
  {
    Object localObject = null;
    if (paramWeakReference != null) {
      localObject = (Context)paramWeakReference.get();
    }
    if (localObject == null) {
      return;
    }
    localObject = new AlertDialog.Builder((Context)localObject);
    ((AlertDialog.Builder)localObject).setTitle(g.a(paramc, 0));
    ((AlertDialog.Builder)localObject).setMessage(g.a(paramc, 1));
    ((AlertDialog.Builder)localObject).setNegativeButton(g.a(paramc, 2), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (b.this != null) {
          b.this.l();
        }
        b.b(paramWeakReference);
        b.a(paramWeakReference, b.this, paramBoolean);
      }
    });
    ((AlertDialog.Builder)localObject).setPositiveButton(g.a(paramc, 3), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        b.b(b.this, paramc, paramBoolean);
      }
    });
    ((AlertDialog.Builder)localObject).create().show();
  }
  
  private static void d(WeakReference paramWeakReference, final c paramc, final boolean paramBoolean)
  {
    c(paramWeakReference);
    new Thread()
    {
      public void run()
      {
        b.a(b.this, paramc);
        b.a(b.this, paramc, paramBoolean);
      }
    }.start();
  }
  
  private static void e(WeakReference paramWeakReference, c paramc, boolean paramBoolean)
  {
    if ((a.b != null) && (a.d != null))
    {
      paramWeakReference = Thread.getDefaultUncaughtExceptionHandler();
      if (paramWeakReference != null) {
        Log.d("HockeyApp", "Current handler class = " + paramWeakReference.getClass().getName());
      }
      if ((paramWeakReference instanceof d))
      {
        ((d)paramWeakReference).a(paramc);
        return;
      }
      Thread.setDefaultUncaughtExceptionHandler(new d(paramWeakReference, paramc, paramBoolean));
      return;
    }
    Log.d("HockeyApp", "Exception handler not set because version or package is null.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */