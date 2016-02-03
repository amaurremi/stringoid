package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;

class AssetBitmapHunter
  extends BitmapHunter
{
  protected static final String ANDROID_ASSET = "android_asset";
  private static final int ASSET_PREFIX_LENGTH = "file:///android_asset/".length();
  private final AssetManager assetManager;
  
  public AssetBitmapHunter(Context paramContext, Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction)
  {
    super(paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
    this.assetManager = paramContext.getAssets();
  }
  
  Bitmap decode(Request paramRequest)
    throws IOException
  {
    return decodeAsset(paramRequest.uri.toString().substring(ASSET_PREFIX_LENGTH));
  }
  
  /* Error */
  Bitmap decodeAsset(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 67	com/squareup/picasso/AssetBitmapHunter:data	Lcom/squareup/picasso/Request;
    //   4: invokestatic 71	com/squareup/picasso/AssetBitmapHunter:createBitmapOptions	(Lcom/squareup/picasso/Request;)Landroid/graphics/BitmapFactory$Options;
    //   7: astore 4
    //   9: aload 4
    //   11: invokestatic 75	com/squareup/picasso/AssetBitmapHunter:requiresInSampleSize	(Landroid/graphics/BitmapFactory$Options;)Z
    //   14: ifeq +47 -> 61
    //   17: aconst_null
    //   18: astore_2
    //   19: aload_0
    //   20: getfield 38	com/squareup/picasso/AssetBitmapHunter:assetManager	Landroid/content/res/AssetManager;
    //   23: aload_1
    //   24: invokevirtual 81	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   27: astore_3
    //   28: aload_3
    //   29: astore_2
    //   30: aload_3
    //   31: aconst_null
    //   32: aload 4
    //   34: invokestatic 87	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   37: pop
    //   38: aload_3
    //   39: invokestatic 93	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   42: aload_0
    //   43: getfield 67	com/squareup/picasso/AssetBitmapHunter:data	Lcom/squareup/picasso/Request;
    //   46: getfield 96	com/squareup/picasso/Request:targetWidth	I
    //   49: aload_0
    //   50: getfield 67	com/squareup/picasso/AssetBitmapHunter:data	Lcom/squareup/picasso/Request;
    //   53: getfield 99	com/squareup/picasso/Request:targetHeight	I
    //   56: aload 4
    //   58: invokestatic 103	com/squareup/picasso/AssetBitmapHunter:calculateInSampleSize	(IILandroid/graphics/BitmapFactory$Options;)V
    //   61: aload_0
    //   62: getfield 38	com/squareup/picasso/AssetBitmapHunter:assetManager	Landroid/content/res/AssetManager;
    //   65: aload_1
    //   66: invokevirtual 81	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   69: astore_1
    //   70: aload_1
    //   71: aconst_null
    //   72: aload 4
    //   74: invokestatic 87	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   77: astore_2
    //   78: aload_1
    //   79: invokestatic 93	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   82: aload_2
    //   83: areturn
    //   84: astore_1
    //   85: aload_2
    //   86: invokestatic 93	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   89: aload_1
    //   90: athrow
    //   91: astore_2
    //   92: aload_1
    //   93: invokestatic 93	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   96: aload_2
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	AssetBitmapHunter
    //   0	98	1	paramString	String
    //   18	68	2	localObject1	Object
    //   91	6	2	localObject2	Object
    //   27	12	3	localInputStream	java.io.InputStream
    //   7	66	4	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   19	28	84	finally
    //   30	38	84	finally
    //   70	78	91	finally
  }
  
  Picasso.LoadedFrom getLoadedFrom()
  {
    return Picasso.LoadedFrom.DISK;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/picasso/AssetBitmapHunter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */