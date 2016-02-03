package com.magmamobile.mmusia.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.magmamobile.mmusia.MCommon;
import com.magmamobile.mmusia.image.ImageSetterSDK3;
import com.magmamobile.mmusia.image.ImageSetterSDK4;
import com.magmamobile.mmusia.image.cache.Images;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public final class ImageViewEx
  extends ImageView
{
  private static final String TAG = "MMUSIA";
  final Handler handler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      ImageViewEx.this.setFromLocal();
    }
  };
  private String mRemote;
  private boolean save2Disk = true;
  private boolean verboseLog = false;
  
  public ImageViewEx(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ImageViewEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImageViewEx(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  /* Error */
  private static Drawable ImageOperations(String paramString)
  {
    // Byte code:
    //   0: new 51	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 54	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 58	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 60	java/net/HttpURLConnection
    //   14: astore_2
    //   15: iconst_1
    //   16: invokestatic 64	java/net/HttpURLConnection:setFollowRedirects	(Z)V
    //   19: aload_2
    //   20: invokevirtual 68	java/net/HttpURLConnection:connect	()V
    //   23: aload_2
    //   24: invokevirtual 72	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   27: astore_3
    //   28: aload_3
    //   29: invokestatic 76	com/magmamobile/mmusia/views/ImageViewEx:readBytes	(Ljava/io/InputStream;)[B
    //   32: astore_1
    //   33: aload_1
    //   34: invokestatic 80	com/magmamobile/mmusia/views/ImageViewEx:loadResizedBitmap	([B)Landroid/graphics/drawable/Drawable;
    //   37: astore_1
    //   38: aload_3
    //   39: ifnull +7 -> 46
    //   42: aload_3
    //   43: invokevirtual 85	java/io/InputStream:close	()V
    //   46: aload_2
    //   47: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   50: aload_1
    //   51: areturn
    //   52: astore 4
    //   54: aconst_null
    //   55: astore_1
    //   56: aload 4
    //   58: invokevirtual 91	java/lang/OutOfMemoryError:printStackTrace	()V
    //   61: goto -23 -> 38
    //   64: astore_1
    //   65: ldc 16
    //   67: new 93	java/lang/StringBuilder
    //   70: dup
    //   71: ldc 95
    //   73: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   76: aload_0
    //   77: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 110	com/magmamobile/mmusia/MCommon:Log_e	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aconst_null
    //   87: areturn
    //   88: astore 4
    //   90: aconst_null
    //   91: astore_1
    //   92: aload 4
    //   94: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   97: goto -59 -> 38
    //   100: astore_1
    //   101: ldc 16
    //   103: new 93	java/lang/StringBuilder
    //   106: dup
    //   107: ldc 113
    //   109: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: aload_1
    //   113: invokevirtual 116	java/io/IOException:getMessage	()Ljava/lang/String;
    //   116: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 110	com/magmamobile/mmusia/MCommon:Log_e	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: ldc 16
    //   127: aload_0
    //   128: invokestatic 110	com/magmamobile/mmusia/MCommon:Log_e	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aconst_null
    //   132: areturn
    //   133: astore_1
    //   134: ldc 16
    //   136: new 93	java/lang/StringBuilder
    //   139: dup
    //   140: ldc 118
    //   142: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   145: aload_1
    //   146: invokevirtual 119	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   149: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 110	com/magmamobile/mmusia/MCommon:Log_e	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: ldc 16
    //   160: aload_0
    //   161: invokestatic 110	com/magmamobile/mmusia/MCommon:Log_e	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aconst_null
    //   165: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramString	String
    //   32	24	1	localObject1	Object
    //   64	1	1	localMalformedURLException	java.net.MalformedURLException
    //   91	1	1	localObject2	Object
    //   100	13	1	localIOException	IOException
    //   133	13	1	localException1	Exception
    //   14	33	2	localHttpURLConnection	java.net.HttpURLConnection
    //   27	16	3	localInputStream	InputStream
    //   52	5	4	localOutOfMemoryError	OutOfMemoryError
    //   88	5	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   33	38	52	java/lang/OutOfMemoryError
    //   0	33	64	java/net/MalformedURLException
    //   33	38	64	java/net/MalformedURLException
    //   42	46	64	java/net/MalformedURLException
    //   46	50	64	java/net/MalformedURLException
    //   56	61	64	java/net/MalformedURLException
    //   92	97	64	java/net/MalformedURLException
    //   33	38	88	java/lang/Exception
    //   0	33	100	java/io/IOException
    //   33	38	100	java/io/IOException
    //   42	46	100	java/io/IOException
    //   46	50	100	java/io/IOException
    //   56	61	100	java/io/IOException
    //   92	97	100	java/io/IOException
    //   0	33	133	java/lang/Exception
    //   42	46	133	java/lang/Exception
    //   46	50	133	java/lang/Exception
    //   56	61	133	java/lang/Exception
    //   92	97	133	java/lang/Exception
  }
  
  public static final void arthur_fetchDrawable(Context paramContext, String paramString, boolean paramBoolean)
  {
    fetchDrawable(paramContext, paramString, paramBoolean);
  }
  
  private final void fetchDrawable(Context paramContext, String paramString)
  {
    fetchDrawable(paramContext, paramString, true, this.save2Disk);
  }
  
  private static final void fetchDrawable(Context paramContext, String paramString, boolean paramBoolean)
  {
    fetchDrawable(paramContext, paramString, true, paramBoolean);
  }
  
  private static final void fetchDrawable(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Drawable localDrawable = ImageOperations(paramString);
    if (localDrawable != null)
    {
      if (paramBoolean2) {
        Images.saveImage(paramContext, localDrawable, MCommon.alphaNum(paramString, ""));
      }
      MCommon.drawableMap.put(paramString, localDrawable);
      return;
    }
    if (paramBoolean1)
    {
      MCommon.Log_e("MMUSIA", "ImageViewEx :: drawable == null !!!! Second Try ! :: " + paramString);
      fetchDrawable(paramContext, paramString, false, paramBoolean2);
      return;
    }
    MCommon.Log_e("MMUSIA", "ImageViewEx :: drawable == null !!!! Last Try :( " + paramString);
  }
  
  public static Drawable loadResizedBitmap(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    Object localObject1 = localObject2;
    if (localOptions.outHeight > 0)
    {
      localObject1 = localObject2;
      if (localOptions.outWidth > 0) {
        localOptions.inJustDecodeBounds = false;
      }
    }
    for (localOptions.inSampleSize = 1;; localOptions.inSampleSize += 1) {
      if ((localOptions.outWidth / localOptions.inSampleSize <= 320) || (localOptions.outHeight / localOptions.inSampleSize <= 240))
      {
        localObject1 = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
        return new BitmapDrawable((Bitmap)localObject1);
      }
    }
  }
  
  public static byte[] readBytes(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        return localByteArrayOutputStream.toByteArray();
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static Drawable resizeDrawable(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if (paramDrawable == null) {
      return null;
    }
    return new BitmapDrawable(Bitmap.createScaledBitmap(((BitmapDrawable)paramDrawable).getBitmap(), paramInt1, paramInt2, false));
  }
  
  private void setFromLocal()
  {
    Drawable localDrawable;
    if (MCommon.drawableMap.containsKey(this.mRemote))
    {
      localDrawable = (Drawable)MCommon.drawableMap.get(this.mRemote);
      if (localDrawable != null)
      {
        if (!MCommon.isSDKAPI4Mini()) {
          break label47;
        }
        ImageSetterSDK4.setImage(localDrawable, this);
      }
    }
    return;
    label47:
    ImageSetterSDK3.setImage(localDrawable, this);
  }
  
  public void loadImage(final Context paramContext)
  {
    if (this.mRemote == null) {}
    while (this.mRemote.equals("")) {
      return;
    }
    if ((!MCommon.drawableMap.containsKey(this.mRemote)) && (Images.isExist(paramContext, MCommon.alphaNum(this.mRemote, ""))) && (this.save2Disk))
    {
      MCommon.drawableMap.put(this.mRemote, Images.loadImage(paramContext, MCommon.alphaNum(this.mRemote, "")));
      if (this.verboseLog) {
        MCommon.Log_i("MMUSIA", "LoadImage : Exists in Cache, Added in memory cache");
      }
      new Thread()
      {
        public void run()
        {
          Message localMessage = ImageViewEx.this.handler.obtainMessage(1);
          ImageViewEx.this.handler.sendMessage(localMessage);
        }
      }.start();
      return;
    }
    if (MCommon.drawableMap.containsKey(this.mRemote))
    {
      if (this.verboseLog) {
        MCommon.Log_i("MMUSIA", "LoadImage : Exists");
      }
      new Thread()
      {
        public void run()
        {
          Message localMessage = ImageViewEx.this.handler.obtainMessage(1);
          ImageViewEx.this.handler.sendMessage(localMessage);
        }
      }.start();
      return;
    }
    if (this.verboseLog) {
      MCommon.Log_i("MMUSIA", "LoadImage : NOT Exists");
    }
    new Thread()
    {
      public void run()
      {
        ImageViewEx.this.fetchDrawable(paramContext, ImageViewEx.this.mRemote);
        Message localMessage = ImageViewEx.this.handler.obtainMessage(1);
        ImageViewEx.this.handler.sendMessage(localMessage);
      }
    }.start();
  }
  
  public void loadImage(Context paramContext, boolean paramBoolean)
  {
    this.save2Disk = paramBoolean;
    loadImage(paramContext);
  }
  
  public void setRemoteURI(String paramString)
  {
    if (paramString == null) {}
    while (!paramString.startsWith("http")) {
      return;
    }
    this.mRemote = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/views/ImageViewEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */