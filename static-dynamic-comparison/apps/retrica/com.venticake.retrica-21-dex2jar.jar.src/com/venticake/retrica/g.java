package com.venticake.retrica;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.location.Location;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.venticake.retrica.util.FileComparator;
import com.venticake.retrica.util.UserInterfaceUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class g
{
  private static File e;
  private Activity a;
  private SQLiteOpenHelper b;
  private int c;
  private MainActivity d;
  private boolean f = false;
  
  public g(Activity paramActivity)
  {
    this.a = paramActivity;
    this.f = this.a.getResources().getBoolean(2131427336);
    this.b = new SQLiteOpenHelper(paramActivity, "RETRICA_THUMBNAIL.sqlite", null, 1)
    {
      public void onCreate(SQLiteDatabase paramAnonymousSQLiteDatabase)
      {
        try
        {
          paramAnonymousSQLiteDatabase.execSQL("CREATE TABLE THUMBNAIL (uri VARCHAR(512) NOT NULL, thumbnail_image BLOB);");
          paramAnonymousSQLiteDatabase.execSQL("CREATE UNIQUE INDEX `id_uri` ON `THUMBNAIL` (`uri` ASC);");
          return;
        }
        catch (Exception paramAnonymousSQLiteDatabase)
        {
          Log.d("retrica", "DB " + paramAnonymousSQLiteDatabase.getMessage());
        }
      }
      
      public void onUpgrade(SQLiteDatabase paramAnonymousSQLiteDatabase, int paramAnonymousInt1, int paramAnonymousInt2) {}
    };
    paramActivity = new DisplayMetrics();
    this.a.getWindowManager().getDefaultDisplay().getMetrics(paramActivity);
    this.c = UserInterfaceUtil.dp2px(a(), paramActivity.density);
    if (this.c < 50) {
      this.c = 50;
    }
    this.d = null;
  }
  
  public static int a()
  {
    switch (MainActivity.c)
    {
    default: 
      return 100;
    case 4: 
      return 200;
    }
    return 150;
  }
  
  public static int a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 8;
    if (paramBoolean1) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      i = 1;
      do
      {
        return i;
      } while (!paramBoolean2);
      return 7;
      if (paramBoolean2) {
        return 5;
      }
      return 6;
      if (paramBoolean2) {
        return 2;
      }
      return 1;
      if (paramBoolean2) {
        return 4;
      }
      return 3;
      switch (paramInt)
      {
      }
    }
    return 6;
    return 1;
    return 3;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    float f1;
    if ((paramBitmap.getWidth() > paramInt1) && (paramBitmap.getWidth() > paramBitmap.getHeight())) {
      f1 = paramInt1 * 1.0F / paramBitmap.getWidth();
    }
    for (;;)
    {
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f1, f1);
      localMatrix.postRotate(paramInt2);
      localMatrix.postScale(-1.0F, 1.0F);
      return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
      if (paramBitmap.getHeight() > paramInt1) {
        f1 = paramInt1 * 1.0F / paramBitmap.getHeight();
      } else {
        f1 = 1.0F;
      }
    }
  }
  
  /* Error */
  public static Uri a(File paramFile, byte[] paramArrayOfByte, int paramInt, Location paramLocation)
  {
    // Byte code:
    //   0: new 120	java/io/FileOutputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 123	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   8: astore 4
    //   10: aload 4
    //   12: aload_1
    //   13: invokevirtual 127	java/io/FileOutputStream:write	([B)V
    //   16: aload 4
    //   18: ifnull +13 -> 31
    //   21: aload 4
    //   23: invokevirtual 130	java/io/FileOutputStream:flush	()V
    //   26: aload 4
    //   28: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   31: new 135	android/media/ExifInterface
    //   34: dup
    //   35: aload_0
    //   36: invokevirtual 141	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   39: invokespecial 144	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   42: astore_1
    //   43: aload_1
    //   44: invokestatic 147	com/venticake/retrica/g:a	(Landroid/media/ExifInterface;)V
    //   47: aload_1
    //   48: ldc -107
    //   50: new 151	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   57: iload_2
    //   58: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_3
    //   68: ifnull +55 -> 123
    //   71: aload_1
    //   72: ldc -91
    //   74: aload_3
    //   75: invokevirtual 171	android/location/Location:getLatitude	()D
    //   78: invokestatic 174	com/venticake/retrica/g:a	(D)Ljava/lang/String;
    //   81: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_1
    //   85: ldc -80
    //   87: aload_3
    //   88: invokevirtual 171	android/location/Location:getLatitude	()D
    //   91: invokestatic 178	com/venticake/retrica/g:b	(D)Ljava/lang/String;
    //   94: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_1
    //   98: ldc -76
    //   100: aload_3
    //   101: invokevirtual 183	android/location/Location:getLongitude	()D
    //   104: invokestatic 174	com/venticake/retrica/g:a	(D)Ljava/lang/String;
    //   107: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_1
    //   111: ldc -71
    //   113: aload_3
    //   114: invokevirtual 183	android/location/Location:getLongitude	()D
    //   117: invokestatic 187	com/venticake/retrica/g:c	(D)Ljava/lang/String;
    //   120: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_1
    //   124: invokevirtual 190	android/media/ExifInterface:saveAttributes	()V
    //   127: aload_0
    //   128: invokestatic 196	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   131: areturn
    //   132: astore_1
    //   133: aload_1
    //   134: invokevirtual 199	java/lang/Exception:printStackTrace	()V
    //   137: goto -106 -> 31
    //   140: astore_0
    //   141: aload_0
    //   142: invokevirtual 199	java/lang/Exception:printStackTrace	()V
    //   145: aconst_null
    //   146: areturn
    //   147: astore_1
    //   148: aload_1
    //   149: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   152: goto -25 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramFile	File
    //   0	155	1	paramArrayOfByte	byte[]
    //   0	155	2	paramInt	int
    //   0	155	3	paramLocation	Location
    //   8	19	4	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   21	31	132	java/lang/Exception
    //   0	16	140	java/lang/Exception
    //   133	137	140	java/lang/Exception
    //   31	67	147	java/io/IOException
    //   71	123	147	java/io/IOException
    //   123	127	147	java/io/IOException
  }
  
  public static Uri a(File paramFile, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, boolean paramBoolean2, Location paramLocation)
  {
    return a(paramFile, paramArrayOfByte, a(paramInt, paramBoolean1, paramBoolean2), paramLocation);
  }
  
  public static final String a(double paramDouble)
  {
    try
    {
      paramDouble = Math.abs(paramDouble);
      int i = (int)paramDouble;
      paramDouble = paramDouble * 60.0D - i * 60.0D;
      int j = (int)paramDouble;
      int k = (int)((paramDouble * 60.0D - j * 60.0D) * 1000.0D);
      Object localObject1 = new StringBuilder(20);
      ((StringBuilder)localObject1).setLength(0);
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append("/1,");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append("/1,");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append("/1000,");
      localObject1 = ((StringBuilder)localObject1).toString();
      return (String)localObject1;
    }
    finally {}
  }
  
  private static void a(ExifInterface paramExifInterface)
  {
    paramExifInterface.setAttribute("Make", o.e());
    paramExifInterface.setAttribute("Model", o.f());
    try
    {
      paramExifInterface.setAttribute("Software", o.g());
      return;
    }
    catch (Exception paramExifInterface)
    {
      Log.d("exif", "Cannot set 'Software' attribute : " + paramExifInterface.getMessage());
    }
  }
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    return new g(paramActivity).a(paramString);
  }
  
  public static File[] a(boolean paramBoolean, Context paramContext)
  {
    paramContext = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Retrica");
    if (paramBoolean)
    {
      paramContext = paramContext.listFiles();
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(Arrays.asList(paramContext));
      Collections.sort(localArrayList, new FileComparator());
      return (File[])localArrayList.toArray(new File[paramContext.length]);
    }
    return paramContext.listFiles();
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt)
  {
    for (;;)
    {
      try
      {
        localObject = new Matrix();
        switch (paramInt)
        {
        case 2: 
          ((Matrix)localObject).setScale(-1.0F, 1.0F);
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        localException.printStackTrace();
        return paramBitmap;
      }
      try
      {
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
        paramBitmap.recycle();
        return (Bitmap)localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        return paramBitmap;
      }
      ((Matrix)localObject).setRotate(180.0F);
      continue;
      localException.setRotate(180.0F);
      localException.postScale(-1.0F, 1.0F);
      continue;
      localException.setRotate(90.0F);
      localException.postScale(-1.0F, 1.0F);
      continue;
      localException.setRotate(90.0F);
      continue;
      localException.setRotate(-90.0F);
      localException.postScale(-1.0F, 1.0F);
      continue;
      localException.setRotate(-90.0F);
    }
    return paramBitmap;
  }
  
  private static String b(double paramDouble)
  {
    if (paramDouble < 0.0D) {
      return "S";
    }
    return "N";
  }
  
  private String c()
  {
    String str = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    return "IMG_" + str;
  }
  
  private static String c(double paramDouble)
  {
    if (paramDouble < 0.0D) {
      return "W";
    }
    return "E";
  }
  
  public int a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    int i = 6;
    if (paramBoolean1) {
      switch (paramInt)
      {
      default: 
        i = 0;
      }
    }
    do
    {
      return i;
      return 8;
      return 3;
      return 1;
      return 1;
      switch (paramInt)
      {
      default: 
        break;
      case -1: 
        return 1;
      case 0: 
        if (paramBoolean2) {
          return 3;
        }
        return 4;
      case 2: 
        if (paramBoolean2) {
          return 1;
        }
        return 2;
      case 1: 
        if (paramBoolean2) {
          return 8;
        }
        return 7;
      }
    } while (paramBoolean2);
    return 5;
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    float f1 = 90.0F;
    if ((paramInt < 2) || (paramInt > 8)) {
      return paramBitmap;
    }
    boolean bool;
    switch (paramInt)
    {
    default: 
      bool = false;
      f1 = 0.0F;
    }
    for (;;)
    {
      Log.d("thumb", "ori: " + paramInt + ", rotate: " + f1 + ", flipHorizon: " + bool);
      Matrix localMatrix = new Matrix();
      if (bool)
      {
        localMatrix.setScale(-1.0F, 1.0F);
        localMatrix.postTranslate(paramBitmap.getWidth(), 0.0F);
      }
      localMatrix.postRotate(f1);
      return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
      bool = false;
      f1 = 0.0F;
      continue;
      bool = true;
      f1 = 0.0F;
      continue;
      f1 = 180.0F;
      bool = false;
      continue;
      f1 = 180.0F;
      bool = true;
      continue;
      f1 = 270.0F;
      bool = true;
      continue;
      bool = false;
      continue;
      bool = true;
      continue;
      f1 = 270.0F;
      bool = false;
    }
  }
  
  public Uri a(Bitmap paramBitmap, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Location paramLocation)
  {
    return a(paramBitmap, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramLocation, null);
  }
  
  public Uri a(Bitmap paramBitmap, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Location paramLocation, ExifInterface paramExifInterface)
  {
    return a(b(), paramBitmap, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramLocation, paramExifInterface);
  }
  
  public Uri a(File paramFile, Bitmap paramBitmap, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Location paramLocation, ExifInterface paramExifInterface)
  {
    return a(paramFile, paramBitmap, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramLocation, paramExifInterface, true);
  }
  
  /* Error */
  public Uri a(File paramFile, Bitmap paramBitmap, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Location paramLocation, ExifInterface paramExifInterface, boolean paramBoolean4)
  {
    // Byte code:
    //   0: getstatic 385	com/venticake/retrica/MainActivity:a	Landroid/content/Context;
    //   3: checkcast 86	com/venticake/retrica/MainActivity
    //   6: getfield 388	com/venticake/retrica/MainActivity:d	Landroid/net/Uri;
    //   9: ifnull +23 -> 32
    //   12: new 137	java/io/File
    //   15: dup
    //   16: getstatic 385	com/venticake/retrica/MainActivity:a	Landroid/content/Context;
    //   19: checkcast 86	com/venticake/retrica/MainActivity
    //   22: getfield 388	com/venticake/retrica/MainActivity:d	Landroid/net/Uri;
    //   25: invokevirtual 391	android/net/Uri:getPath	()Ljava/lang/String;
    //   28: invokespecial 392	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: aload_1
    //   33: ifnonnull +7 -> 40
    //   36: aconst_null
    //   37: astore_2
    //   38: aload_2
    //   39: areturn
    //   40: aload_0
    //   41: iload 5
    //   43: iload_3
    //   44: iload 6
    //   46: invokevirtual 394	com/venticake/retrica/g:a	(ZIZ)I
    //   49: istore 10
    //   51: aload_0
    //   52: iload 10
    //   54: invokevirtual 396	com/venticake/retrica/g:a	(I)Z
    //   57: istore 5
    //   59: ldc_w 398
    //   62: new 151	java/lang/StringBuilder
    //   65: dup
    //   66: ldc_w 400
    //   69: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: iload 5
    //   74: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   77: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 256	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   83: pop
    //   84: iload 10
    //   86: istore_3
    //   87: aload_2
    //   88: astore 11
    //   90: iload 5
    //   92: ifne +13 -> 105
    //   95: aload_2
    //   96: iload 10
    //   98: invokestatic 402	com/venticake/retrica/g:b	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   101: astore 11
    //   103: iconst_1
    //   104: istore_3
    //   105: new 120	java/io/FileOutputStream
    //   108: dup
    //   109: aload_1
    //   110: invokespecial 123	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   113: astore_2
    //   114: aload 11
    //   116: getstatic 408	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   119: bipush 98
    //   121: aload_2
    //   122: invokevirtual 412	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   125: pop
    //   126: aload_2
    //   127: ifnull +11 -> 138
    //   130: aload_2
    //   131: invokevirtual 130	java/io/FileOutputStream:flush	()V
    //   134: aload_2
    //   135: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   138: aload 11
    //   140: invokevirtual 320	android/graphics/Bitmap:recycle	()V
    //   143: iload 4
    //   145: ifeq +344 -> 489
    //   148: ldc_w 398
    //   151: new 151	java/lang/StringBuilder
    //   154: dup
    //   155: ldc_w 414
    //   158: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload_1
    //   162: invokevirtual 141	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   165: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 256	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   174: pop
    //   175: new 135	android/media/ExifInterface
    //   178: dup
    //   179: aload_1
    //   180: invokevirtual 141	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   183: invokespecial 144	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   186: astore_2
    //   187: aload_2
    //   188: invokestatic 147	com/venticake/retrica/g:a	(Landroid/media/ExifInterface;)V
    //   191: aload_2
    //   192: ldc -107
    //   194: new 151	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   201: iload_3
    //   202: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload 8
    //   213: ifnull +204 -> 417
    //   216: aload 8
    //   218: ldc -91
    //   220: invokevirtual 418	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   223: ifnull +16 -> 239
    //   226: aload_2
    //   227: ldc -91
    //   229: aload 8
    //   231: ldc -91
    //   233: invokevirtual 418	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   236: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload 8
    //   241: ldc -80
    //   243: invokevirtual 418	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   246: ifnull +16 -> 262
    //   249: aload_2
    //   250: ldc -80
    //   252: aload 8
    //   254: ldc -80
    //   256: invokevirtual 418	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   259: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload 8
    //   264: ldc -76
    //   266: invokevirtual 418	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   269: ifnull +16 -> 285
    //   272: aload_2
    //   273: ldc -76
    //   275: aload 8
    //   277: ldc -76
    //   279: invokevirtual 418	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   282: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload 8
    //   287: ldc -71
    //   289: invokevirtual 418	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   292: ifnull +16 -> 308
    //   295: aload_2
    //   296: ldc -71
    //   298: aload 8
    //   300: ldc -71
    //   302: invokevirtual 418	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   305: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: aload_2
    //   309: invokevirtual 190	android/media/ExifInterface:saveAttributes	()V
    //   312: aload_1
    //   313: invokestatic 196	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   316: astore 7
    //   318: aload 7
    //   320: astore_2
    //   321: iload 9
    //   323: ifeq -285 -> 38
    //   326: aload_0
    //   327: getfield 27	com/venticake/retrica/g:a	Landroid/app/Activity;
    //   330: new 420	android/content/Intent
    //   333: dup
    //   334: ldc_w 422
    //   337: aload 7
    //   339: invokespecial 425	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   342: invokevirtual 429	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   345: aload 7
    //   347: astore_2
    //   348: aload_1
    //   349: invokevirtual 433	java/io/File:exists	()Z
    //   352: ifeq -314 -> 38
    //   355: aload 7
    //   357: astore_2
    //   358: aload_1
    //   359: invokevirtual 437	java/io/File:length	()J
    //   362: lconst_0
    //   363: lcmp
    //   364: ifle -326 -> 38
    //   367: aload_0
    //   368: aload_1
    //   369: invokevirtual 439	com/venticake/retrica/g:a	(Ljava/io/File;)V
    //   372: aload 7
    //   374: areturn
    //   375: astore_1
    //   376: aload_1
    //   377: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   380: aconst_null
    //   381: areturn
    //   382: astore_2
    //   383: aload_2
    //   384: invokevirtual 199	java/lang/Exception:printStackTrace	()V
    //   387: goto -249 -> 138
    //   390: astore_1
    //   391: aload_1
    //   392: invokevirtual 199	java/lang/Exception:printStackTrace	()V
    //   395: aload 11
    //   397: ifnull +8 -> 405
    //   400: aload 11
    //   402: invokevirtual 320	android/graphics/Bitmap:recycle	()V
    //   405: aconst_null
    //   406: areturn
    //   407: astore 7
    //   409: aload 7
    //   411: invokevirtual 199	java/lang/Exception:printStackTrace	()V
    //   414: goto -106 -> 308
    //   417: aload 7
    //   419: ifnull -111 -> 308
    //   422: aload_2
    //   423: ldc -91
    //   425: aload 7
    //   427: invokevirtual 171	android/location/Location:getLatitude	()D
    //   430: invokestatic 174	com/venticake/retrica/g:a	(D)Ljava/lang/String;
    //   433: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   436: aload_2
    //   437: ldc -80
    //   439: aload 7
    //   441: invokevirtual 171	android/location/Location:getLatitude	()D
    //   444: invokestatic 178	com/venticake/retrica/g:b	(D)Ljava/lang/String;
    //   447: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   450: aload_2
    //   451: ldc -76
    //   453: aload 7
    //   455: invokevirtual 183	android/location/Location:getLongitude	()D
    //   458: invokestatic 174	com/venticake/retrica/g:a	(D)Ljava/lang/String;
    //   461: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   464: aload_2
    //   465: ldc -71
    //   467: aload 7
    //   469: invokevirtual 183	android/location/Location:getLongitude	()D
    //   472: invokestatic 187	com/venticake/retrica/g:c	(D)Ljava/lang/String;
    //   475: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   478: goto -170 -> 308
    //   481: astore_2
    //   482: aload_2
    //   483: invokevirtual 199	java/lang/Exception:printStackTrace	()V
    //   486: goto -174 -> 312
    //   489: aload 8
    //   491: ifnull +136 -> 627
    //   494: new 135	android/media/ExifInterface
    //   497: dup
    //   498: aload_1
    //   499: invokevirtual 141	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   502: invokespecial 144	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   505: astore_2
    //   506: aload_2
    //   507: invokestatic 147	com/venticake/retrica/g:a	(Landroid/media/ExifInterface;)V
    //   510: aload 8
    //   512: ldc -91
    //   514: invokevirtual 418	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   517: ifnull +16 -> 533
    //   520: aload_2
    //   521: ldc -91
    //   523: aload 8
    //   525: ldc -91
    //   527: invokevirtual 418	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   530: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: aload 8
    //   535: ldc -80
    //   537: invokevirtual 418	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   540: ifnull +16 -> 556
    //   543: aload_2
    //   544: ldc -80
    //   546: aload 8
    //   548: ldc -80
    //   550: invokevirtual 418	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   553: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   556: aload 8
    //   558: ldc -76
    //   560: invokevirtual 418	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   563: ifnull +16 -> 579
    //   566: aload_2
    //   567: ldc -76
    //   569: aload 8
    //   571: ldc -76
    //   573: invokevirtual 418	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   576: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   579: aload 8
    //   581: ldc -71
    //   583: invokevirtual 418	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   586: ifnull +16 -> 602
    //   589: aload_2
    //   590: ldc -71
    //   592: aload 8
    //   594: ldc -71
    //   596: invokevirtual 418	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   599: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   602: aload_2
    //   603: invokevirtual 190	android/media/ExifInterface:saveAttributes	()V
    //   606: goto -294 -> 312
    //   609: astore_2
    //   610: aload_2
    //   611: invokevirtual 199	java/lang/Exception:printStackTrace	()V
    //   614: goto -302 -> 312
    //   617: astore 7
    //   619: aload 7
    //   621: invokevirtual 199	java/lang/Exception:printStackTrace	()V
    //   624: goto -22 -> 602
    //   627: aload 7
    //   629: ifnull +82 -> 711
    //   632: new 135	android/media/ExifInterface
    //   635: dup
    //   636: aload_1
    //   637: invokevirtual 141	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   640: invokespecial 144	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   643: astore_2
    //   644: aload_2
    //   645: invokestatic 147	com/venticake/retrica/g:a	(Landroid/media/ExifInterface;)V
    //   648: aload_2
    //   649: ldc -91
    //   651: aload 7
    //   653: invokevirtual 171	android/location/Location:getLatitude	()D
    //   656: invokestatic 174	com/venticake/retrica/g:a	(D)Ljava/lang/String;
    //   659: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   662: aload_2
    //   663: ldc -80
    //   665: aload 7
    //   667: invokevirtual 171	android/location/Location:getLatitude	()D
    //   670: invokestatic 178	com/venticake/retrica/g:b	(D)Ljava/lang/String;
    //   673: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   676: aload_2
    //   677: ldc -76
    //   679: aload 7
    //   681: invokevirtual 183	android/location/Location:getLongitude	()D
    //   684: invokestatic 174	com/venticake/retrica/g:a	(D)Ljava/lang/String;
    //   687: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   690: aload_2
    //   691: ldc -71
    //   693: aload 7
    //   695: invokevirtual 183	android/location/Location:getLongitude	()D
    //   698: invokestatic 187	com/venticake/retrica/g:c	(D)Ljava/lang/String;
    //   701: invokevirtual 163	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   704: aload_2
    //   705: invokevirtual 190	android/media/ExifInterface:saveAttributes	()V
    //   708: goto -396 -> 312
    //   711: new 135	android/media/ExifInterface
    //   714: dup
    //   715: aload_1
    //   716: invokevirtual 141	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   719: invokespecial 144	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   722: astore_2
    //   723: aload_2
    //   724: invokestatic 147	com/venticake/retrica/g:a	(Landroid/media/ExifInterface;)V
    //   727: aload_2
    //   728: invokevirtual 190	android/media/ExifInterface:saveAttributes	()V
    //   731: goto -419 -> 312
    //   734: astore_1
    //   735: goto -330 -> 405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	738	0	this	g
    //   0	738	1	paramFile	File
    //   0	738	2	paramBitmap	Bitmap
    //   0	738	3	paramInt	int
    //   0	738	4	paramBoolean1	boolean
    //   0	738	5	paramBoolean2	boolean
    //   0	738	6	paramBoolean3	boolean
    //   0	738	7	paramLocation	Location
    //   0	738	8	paramExifInterface	ExifInterface
    //   0	738	9	paramBoolean4	boolean
    //   49	48	10	i	int
    //   88	313	11	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   148	211	375	java/io/IOException
    //   216	239	375	java/io/IOException
    //   239	262	375	java/io/IOException
    //   262	285	375	java/io/IOException
    //   285	308	375	java/io/IOException
    //   308	312	375	java/io/IOException
    //   312	318	375	java/io/IOException
    //   326	345	375	java/io/IOException
    //   348	355	375	java/io/IOException
    //   358	372	375	java/io/IOException
    //   409	414	375	java/io/IOException
    //   422	478	375	java/io/IOException
    //   482	486	375	java/io/IOException
    //   494	510	375	java/io/IOException
    //   510	533	375	java/io/IOException
    //   533	556	375	java/io/IOException
    //   556	579	375	java/io/IOException
    //   579	602	375	java/io/IOException
    //   602	606	375	java/io/IOException
    //   610	614	375	java/io/IOException
    //   619	624	375	java/io/IOException
    //   632	708	375	java/io/IOException
    //   711	731	375	java/io/IOException
    //   130	138	382	java/lang/Exception
    //   105	126	390	java/lang/Exception
    //   138	143	390	java/lang/Exception
    //   383	387	390	java/lang/Exception
    //   216	239	407	java/lang/Exception
    //   239	262	407	java/lang/Exception
    //   262	285	407	java/lang/Exception
    //   285	308	407	java/lang/Exception
    //   308	312	481	java/lang/Exception
    //   602	606	609	java/lang/Exception
    //   510	533	617	java/lang/Exception
    //   533	556	617	java/lang/Exception
    //   556	579	617	java/lang/Exception
    //   579	602	617	java/lang/Exception
    //   400	405	734	java/lang/Exception
  }
  
  public File a(Context paramContext)
  {
    if (((MainActivity)MainActivity.a).d != null) {
      return new File(((MainActivity)MainActivity.a).d.toString());
    }
    paramContext = paramContext.getCacheDir();
    try
    {
      paramContext = File.createTempFile(c(), ".jpg", paramContext);
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public void a(MainActivity paramMainActivity)
  {
    this.d = paramMainActivity;
  }
  
  public void a(File paramFile)
  {
    Object localObject2 = paramFile.getPath();
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
    ((BitmapFactory.Options)localObject1).inSampleSize = 4;
    localObject1 = ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile((String)localObject2, (BitmapFactory.Options)localObject1), this.c, this.c, 2);
    try
    {
      localObject2 = a((Bitmap)localObject1, new ExifInterface((String)localObject2).getAttributeInt("Orientation", 1));
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          localObject1 = this.b.getWritableDatabase();
          SQLiteStatement localSQLiteStatement = ((SQLiteDatabase)localObject1).compileStatement("INSERT INTO THUMBNAIL (uri, thumbnail_image) VALUES (?, ?)");
          localSQLiteStatement.clearBindings();
          localSQLiteStatement.bindString(1, Uri.fromFile(paramFile).toString());
          localSQLiteStatement.bindBlob(2, ((ByteArrayOutputStream)localObject2).toByteArray());
          localSQLiteStatement.executeInsert();
          ((SQLiteDatabase)localObject1).close();
          return;
        }
        catch (Exception paramFile)
        {
          Log.d("retrica", paramFile.getMessage());
        }
        localIOException = localIOException;
        localIOException.printStackTrace();
      }
    }
    localObject2 = new ByteArrayOutputStream();
    ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject2);
  }
  
  public boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 6: 
    default: 
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    Log.d("retrica", "removeFileAt: " + paramString);
    Object localObject;
    try
    {
      localObject = new URI(paramString);
      localObject = new File((URI)localObject);
      if (!((File)localObject).exists())
      {
        Log.d("retrica", "file not exists.");
        return false;
      }
    }
    catch (URISyntaxException paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    Uri localUri = Uri.fromFile((File)localObject);
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    localSQLiteDatabase.delete("THUMBNAIL", "uri= '" + localUri.toString() + "'", null);
    localSQLiteDatabase.close();
    boolean bool = ((File)localObject).delete();
    Log.d("retrica", "fileDeleted: " + bool);
    System.gc();
    this.a.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse(paramString)));
    return true;
  }
  
  public File b()
  {
    File localFile3;
    try
    {
      File localFile1 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Retrica");
      localFile3 = localFile1;
      if (localFile1 != null)
      {
        localFile3 = localFile1;
        if (!localFile1.exists())
        {
          localFile3 = localFile1;
          if (!localFile1.mkdirs())
          {
            localFile3 = localFile1;
            if (!localFile1.mkdir())
            {
              localFile3 = new File(this.d.getFilesDir(), "Retrica");
              if ((!localFile3.exists()) && (!localFile3.mkdirs())) {
                return null;
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        File localFile2 = new File(this.d.getFilesDir(), "Retrica");
      }
      e = localFile3;
    }
    return new File(localFile3.getPath() + File.separator + c() + ".jpg");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */