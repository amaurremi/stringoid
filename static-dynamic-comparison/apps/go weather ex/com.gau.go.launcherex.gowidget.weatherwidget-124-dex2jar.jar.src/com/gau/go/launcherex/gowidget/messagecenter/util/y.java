package com.gau.go.launcherex.gowidget.messagecenter.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.gau.go.gostaticsdk.d;
import com.gau.go.launcherex.gowidget.statistics.t;
import com.gtp.a.a.a.a;
import com.gtp.a.a.b.c;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class y
{
  l a;
  private String b;
  private String c;
  private Context d;
  private final ExecutorService e;
  
  public y(Context paramContext)
  {
    this.d = paramContext;
    this.e = Executors.newFixedThreadPool(1);
    File localFile = this.d.getFilesDir();
    if (localFile != null) {
      this.b = (localFile.getAbsolutePath() + "/message_center_statistics.temp");
    }
    for (this.c = (localFile.getAbsolutePath() + "/message_center_app_statistics.temp");; this.c = "/data/data/com.gau.go.launcherex.gowidget.weatherwidget/files/message_center_app_statistics.temp")
    {
      this.a = l.a(paramContext);
      return;
      this.b = "/data/data/com.gau.go.launcherex.gowidget.weatherwidget/files/message_center_statistics.temp";
    }
  }
  
  /* Error */
  private void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 39	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 89	java/io/File:exists	()Z
    //   13: ifne +8 -> 21
    //   16: aload_2
    //   17: invokevirtual 92	java/io/File:createNewFile	()Z
    //   20: pop
    //   21: aload_2
    //   22: invokevirtual 89	java/io/File:exists	()Z
    //   25: ifeq +53 -> 78
    //   28: new 94	java/io/FileOutputStream
    //   31: dup
    //   32: aload_2
    //   33: iconst_1
    //   34: invokespecial 97	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   37: astore_3
    //   38: aload_3
    //   39: astore_2
    //   40: aload_3
    //   41: new 36	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   48: aload_1
    //   49: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 99
    //   54: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokevirtual 105	java/lang/String:getBytes	()[B
    //   63: invokevirtual 109	java/io/FileOutputStream:write	([B)V
    //   66: aload_3
    //   67: ifnull +11 -> 78
    //   70: aload_3
    //   71: invokevirtual 112	java/io/FileOutputStream:flush	()V
    //   74: aload_3
    //   75: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   78: return
    //   79: astore_3
    //   80: aload_3
    //   81: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   84: goto -63 -> 21
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   92: return
    //   93: astore 4
    //   95: aconst_null
    //   96: astore_1
    //   97: aload_1
    //   98: astore_2
    //   99: aload 4
    //   101: invokevirtual 119	java/lang/Exception:printStackTrace	()V
    //   104: aload_1
    //   105: ifnull -27 -> 78
    //   108: aload_1
    //   109: invokevirtual 112	java/io/FileOutputStream:flush	()V
    //   112: aload_1
    //   113: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   116: return
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   122: return
    //   123: astore_1
    //   124: aconst_null
    //   125: astore_2
    //   126: aload_2
    //   127: ifnull +11 -> 138
    //   130: aload_2
    //   131: invokevirtual 112	java/io/FileOutputStream:flush	()V
    //   134: aload_2
    //   135: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   138: aload_1
    //   139: athrow
    //   140: astore_2
    //   141: aload_2
    //   142: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   145: goto -7 -> 138
    //   148: astore_1
    //   149: goto -23 -> 126
    //   152: astore 4
    //   154: aload_3
    //   155: astore_1
    //   156: goto -59 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	y
    //   0	159	1	paramString1	String
    //   0	159	2	paramString2	String
    //   37	38	3	localFileOutputStream	java.io.FileOutputStream
    //   79	76	3	localIOException	java.io.IOException
    //   93	7	4	localException1	Exception
    //   152	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   16	21	79	java/io/IOException
    //   70	78	87	java/io/IOException
    //   28	38	93	java/lang/Exception
    //   108	116	117	java/io/IOException
    //   28	38	123	finally
    //   130	138	140	java/io/IOException
    //   40	66	148	finally
    //   99	104	148	finally
    //   40	66	152	java/lang/Exception
  }
  
  private void c(String paramString)
  {
    c.a("MSGCenterStatistics", "开始上传");
    c.a("MSGCenterStatistics", paramString);
    a.a().a("开始上传!(" + paramString + ")", "message_center_statistics.txt");
    if (this.a.b(paramString))
    {
      c.a("MSGCenterStatistics", "上传成功");
      a.a().a("上传成功!(" + paramString + ")", "message_center_statistics.txt");
      return;
    }
    c.a("MSGCenterStatistics", "上传失败，写文件");
    paramString = paramString.split("&");
    a.a().a("上传失败，保存到文件!", "message_center_statistics.txt");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      a.a().a(str, "message_center_statistics.txt");
      a(str, this.b);
      i += 1;
    }
    a.a().a("保存完毕", "message_center_statistics.txt");
  }
  
  private void d(String paramString)
  {
    a.a().a("消息中心应用安装的统计 - " + paramString, "message_center_statistics.txt");
    if (this.a.c(paramString)) {
      a.a().a("消息中心应用安装的统计 - " + paramString + "上传成功.", "message_center_statistics.txt");
    }
    for (;;)
    {
      return;
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        a(paramString[i], this.c);
        i += 1;
      }
    }
  }
  
  /* Error */
  public List a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 39	java/io/File
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 4
    //   12: aload 4
    //   14: invokevirtual 89	java/io/File:exists	()Z
    //   17: ifeq +152 -> 169
    //   20: new 169	java/util/ArrayList
    //   23: dup
    //   24: invokespecial 170	java/util/ArrayList:<init>	()V
    //   27: astore 5
    //   29: new 172	java/io/BufferedReader
    //   32: dup
    //   33: new 174	java/io/FileReader
    //   36: dup
    //   37: aload 4
    //   39: invokespecial 177	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   42: invokespecial 180	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_2
    //   46: aload_2
    //   47: astore_1
    //   48: aload_2
    //   49: invokevirtual 183	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore_3
    //   53: aload_3
    //   54: ifnull +41 -> 95
    //   57: aload_2
    //   58: astore_1
    //   59: aload 5
    //   61: aload_3
    //   62: invokeinterface 189 2 0
    //   67: pop
    //   68: goto -22 -> 46
    //   71: astore_3
    //   72: aload_2
    //   73: astore_1
    //   74: aload_3
    //   75: invokevirtual 119	java/lang/Exception:printStackTrace	()V
    //   78: aload_2
    //   79: ifnull +13 -> 92
    //   82: aload_2
    //   83: invokevirtual 190	java/io/BufferedReader:close	()V
    //   86: aload 4
    //   88: invokevirtual 193	java/io/File:delete	()Z
    //   91: pop
    //   92: aload 5
    //   94: areturn
    //   95: aload_2
    //   96: ifnull -4 -> 92
    //   99: aload_2
    //   100: invokevirtual 190	java/io/BufferedReader:close	()V
    //   103: aload 4
    //   105: invokevirtual 193	java/io/File:delete	()Z
    //   108: pop
    //   109: aload 5
    //   111: areturn
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   117: aload 5
    //   119: areturn
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   125: aload 5
    //   127: areturn
    //   128: astore_1
    //   129: aload_3
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull +13 -> 145
    //   135: aload_2
    //   136: invokevirtual 190	java/io/BufferedReader:close	()V
    //   139: aload 4
    //   141: invokevirtual 193	java/io/File:delete	()Z
    //   144: pop
    //   145: aload_1
    //   146: athrow
    //   147: astore_2
    //   148: aload_2
    //   149: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   152: goto -7 -> 145
    //   155: astore_3
    //   156: aload_1
    //   157: astore_2
    //   158: aload_3
    //   159: astore_1
    //   160: goto -29 -> 131
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_2
    //   166: goto -94 -> 72
    //   169: aconst_null
    //   170: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	y
    //   0	171	1	paramString	String
    //   45	91	2	localObject1	Object
    //   147	2	2	localIOException	java.io.IOException
    //   157	9	2	str1	String
    //   1	61	3	str2	String
    //   71	59	3	localException1	Exception
    //   155	4	3	localObject2	Object
    //   163	1	3	localException2	Exception
    //   10	130	4	localFile	File
    //   27	99	5	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   48	53	71	java/lang/Exception
    //   59	68	71	java/lang/Exception
    //   99	109	112	java/io/IOException
    //   82	92	120	java/io/IOException
    //   29	46	128	finally
    //   135	145	147	java/io/IOException
    //   48	53	155	finally
    //   59	68	155	finally
    //   74	78	155	finally
    //   29	46	163	java/lang/Exception
  }
  
  public void a(ab paramab)
  {
    this.e.execute(new ad(this, paramab));
  }
  
  public void a(List paramList)
  {
    this.e.execute(new ac(this, paramList));
  }
  
  public void b(String paramString)
  {
    long l1 = 0L;
    Object localObject = this.d.getSharedPreferences("message_center_app_statistics", 0);
    String str = ((SharedPreferences)localObject).getString(paramString, null);
    String[] arrayOfString;
    long l2;
    if (!TextUtils.isEmpty(str))
    {
      arrayOfString = str.split("#");
      if (arrayOfString.length == 2) {
        str = arrayOfString[0];
      }
    }
    else
    {
      try
      {
        l2 = Long.parseLong(arrayOfString[1]);
        l1 = l2;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
        ((SharedPreferences)localObject).edit().remove(paramString).commit();
        return;
      }
      if (System.currentTimeMillis() - l1 < 1800000L) {
        m.a(this.d).a(str, new z(this));
      }
    }
    do
    {
      do
      {
        return;
      } while (localException2.length != 1);
      try
      {
        l2 = Long.parseLong(localException2[0]);
        l1 = l2;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
        }
        if (!"com.mx.browser".equals(paramString)) {
          break label252;
        }
        localObject = "5380697";
        continue;
        if (!"com.dianxinos.optimizer.duplay".equals(paramString)) {
          break label270;
        }
        localObject = "5377557";
        continue;
        if (!"com.qihoo.cleandroid".equals(paramString)) {
          continue;
        }
        localObject = "5576867";
        continue;
        ((SharedPreferences)localObject).edit().remove(paramString).commit();
      }
      if (System.currentTimeMillis() - l1 >= 1800000L) {
        break label288;
      }
      localObject = "";
      if (!"com.cleanmaster.mguard".equals(paramString)) {
        break;
      }
      localObject = "2463865";
    } while (TextUtils.isEmpty((CharSequence)localObject));
    paramString = new t(this.d, (String)localObject, "b001", "1");
    d.a(this.d).a(paramString.toString());
    return;
    label252:
    label270:
    label288:
    return;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */