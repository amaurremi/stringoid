package com.venticake.retrica.engine;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;

abstract class RetricaEngine$LoadImageTask
  extends AsyncTask<Void, Void, Bitmap>
{
  private final RetricaEngine mEngine;
  private int mOutputHeight;
  private int mOutputWidth;
  
  public RetricaEngine$LoadImageTask(RetricaEngine paramRetricaEngine1, RetricaEngine paramRetricaEngine2)
  {
    this.mEngine = paramRetricaEngine2;
  }
  
  private boolean checkSize(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (RetricaEngine.access$4(this.this$0) == RetricaEngine.ScaleType.CENTER_CROP) {
      if ((!paramBoolean1) || (!paramBoolean2)) {}
    }
    while ((paramBoolean1) || (paramBoolean2))
    {
      return true;
      return false;
    }
    return false;
  }
  
  private int[] getScaleSize(int paramInt1, int paramInt2)
  {
    float f1 = paramInt1 / this.mOutputWidth;
    float f2 = paramInt2 / this.mOutputHeight;
    int i;
    if (RetricaEngine.access$4(this.this$0) == RetricaEngine.ScaleType.CENTER_CROP) {
      if (f1 > f2)
      {
        i = 1;
        if (i == 0) {
          break label106;
        }
        f1 = this.mOutputHeight;
        f2 = f1 / paramInt2 * paramInt1;
      }
    }
    for (;;)
    {
      return new int[] { Math.round(f2), Math.round(f1) };
      i = 0;
      break;
      if (f1 < f2)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label106:
      f2 = this.mOutputWidth;
      f1 = f2 / paramInt1 * paramInt2;
    }
  }
  
  private Bitmap loadResizedImage()
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    decode((BitmapFactory.Options)localObject);
    int i = 1;
    boolean bool1;
    if (((BitmapFactory.Options)localObject).outWidth / i > this.mOutputWidth)
    {
      bool1 = true;
      label40:
      if (((BitmapFactory.Options)localObject).outHeight / i <= this.mOutputHeight) {
        break label145;
      }
    }
    label145:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (!checkSize(bool1, bool2))
      {
        int j = i - 1;
        i = j;
        if (j < 1) {
          i = 1;
        }
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inSampleSize = i;
        ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
        ((BitmapFactory.Options)localObject).inPurgeable = true;
        ((BitmapFactory.Options)localObject).inTempStorage = new byte[32768];
        localObject = decode((BitmapFactory.Options)localObject);
        if (localObject != null) {
          break label151;
        }
        return null;
      }
      i += 1;
      break;
      bool1 = false;
      break label40;
    }
    label151:
    return scaleBitmap(rotateImage((Bitmap)localObject));
  }
  
  /* Error */
  private Bitmap rotateImage(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +7 -> 8
    //   4: aconst_null
    //   5: astore_3
    //   6: aload_3
    //   7: areturn
    //   8: aload_0
    //   9: invokevirtual 101	com/venticake/retrica/engine/RetricaEngine$LoadImageTask:getImageOrientation	()I
    //   12: istore_2
    //   13: aload_1
    //   14: astore_3
    //   15: iload_2
    //   16: ifeq -10 -> 6
    //   19: new 103	android/graphics/Matrix
    //   22: dup
    //   23: invokespecial 104	android/graphics/Matrix:<init>	()V
    //   26: astore_3
    //   27: aload_3
    //   28: iload_2
    //   29: i2f
    //   30: invokevirtual 108	android/graphics/Matrix:postRotate	(F)Z
    //   33: pop
    //   34: aload_1
    //   35: iconst_0
    //   36: iconst_0
    //   37: aload_1
    //   38: invokevirtual 113	android/graphics/Bitmap:getWidth	()I
    //   41: aload_1
    //   42: invokevirtual 116	android/graphics/Bitmap:getHeight	()I
    //   45: aload_3
    //   46: iconst_1
    //   47: invokestatic 120	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   50: astore_3
    //   51: aload_1
    //   52: invokevirtual 123	android/graphics/Bitmap:recycle	()V
    //   55: aload_3
    //   56: areturn
    //   57: astore_3
    //   58: aload_3
    //   59: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   62: aload_1
    //   63: areturn
    //   64: astore 4
    //   66: aload_3
    //   67: astore_1
    //   68: aload 4
    //   70: astore_3
    //   71: goto -13 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	LoadImageTask
    //   0	74	1	paramBitmap	Bitmap
    //   12	17	2	i	int
    //   5	51	3	localObject1	Object
    //   57	10	3	localIOException1	java.io.IOException
    //   70	1	3	localObject2	Object
    //   64	5	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   8	13	57	java/io/IOException
    //   19	51	57	java/io/IOException
    //   51	55	64	java/io/IOException
  }
  
  private Bitmap scaleBitmap(Bitmap paramBitmap)
  {
    int[] arrayOfInt = getScaleSize(paramBitmap.getWidth(), paramBitmap.getHeight());
    Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, arrayOfInt[0], arrayOfInt[1], true);
    paramBitmap.recycle();
    System.gc();
    if (RetricaEngine.access$4(this.this$0) == RetricaEngine.ScaleType.CENTER_CROP)
    {
      int i = arrayOfInt[0] - this.mOutputWidth;
      int j = arrayOfInt[1] - this.mOutputHeight;
      paramBitmap = Bitmap.createBitmap(localBitmap, i / 2, j / 2, arrayOfInt[0] - i, arrayOfInt[1] - j);
      localBitmap.recycle();
      return paramBitmap;
    }
    return localBitmap;
  }
  
  protected abstract Bitmap decode(BitmapFactory.Options paramOptions);
  
  /* Error */
  protected Bitmap doInBackground(Void... arg1)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	com/venticake/retrica/engine/RetricaEngine$LoadImageTask:this$0	Lcom/venticake/retrica/engine/RetricaEngine;
    //   4: invokestatic 148	com/venticake/retrica/engine/RetricaEngine:access$1	(Lcom/venticake/retrica/engine/RetricaEngine;)Lcom/venticake/retrica/engine/RetricaRenderer;
    //   7: ifnull +47 -> 54
    //   10: aload_0
    //   11: getfield 15	com/venticake/retrica/engine/RetricaEngine$LoadImageTask:this$0	Lcom/venticake/retrica/engine/RetricaEngine;
    //   14: invokestatic 148	com/venticake/retrica/engine/RetricaEngine:access$1	(Lcom/venticake/retrica/engine/RetricaEngine;)Lcom/venticake/retrica/engine/RetricaRenderer;
    //   17: invokevirtual 153	com/venticake/retrica/engine/RetricaRenderer:getFrameWidth	()I
    //   20: ifne +34 -> 54
    //   23: aload_0
    //   24: getfield 15	com/venticake/retrica/engine/RetricaEngine$LoadImageTask:this$0	Lcom/venticake/retrica/engine/RetricaEngine;
    //   27: invokestatic 148	com/venticake/retrica/engine/RetricaEngine:access$1	(Lcom/venticake/retrica/engine/RetricaEngine;)Lcom/venticake/retrica/engine/RetricaRenderer;
    //   30: getfield 157	com/venticake/retrica/engine/RetricaRenderer:mSurfaceChangedWaiter	Ljava/lang/Object;
    //   33: astore_1
    //   34: aload_1
    //   35: monitorenter
    //   36: aload_0
    //   37: getfield 15	com/venticake/retrica/engine/RetricaEngine$LoadImageTask:this$0	Lcom/venticake/retrica/engine/RetricaEngine;
    //   40: invokestatic 148	com/venticake/retrica/engine/RetricaEngine:access$1	(Lcom/venticake/retrica/engine/RetricaEngine;)Lcom/venticake/retrica/engine/RetricaRenderer;
    //   43: getfield 157	com/venticake/retrica/engine/RetricaRenderer:mSurfaceChangedWaiter	Ljava/lang/Object;
    //   46: ldc2_w 158
    //   49: invokevirtual 165	java/lang/Object:wait	(J)V
    //   52: aload_1
    //   53: monitorexit
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 15	com/venticake/retrica/engine/RetricaEngine$LoadImageTask:this$0	Lcom/venticake/retrica/engine/RetricaEngine;
    //   59: invokestatic 169	com/venticake/retrica/engine/RetricaEngine:access$2	(Lcom/venticake/retrica/engine/RetricaEngine;)I
    //   62: putfield 39	com/venticake/retrica/engine/RetricaEngine$LoadImageTask:mOutputWidth	I
    //   65: aload_0
    //   66: aload_0
    //   67: getfield 15	com/venticake/retrica/engine/RetricaEngine$LoadImageTask:this$0	Lcom/venticake/retrica/engine/RetricaEngine;
    //   70: invokestatic 172	com/venticake/retrica/engine/RetricaEngine:access$3	(Lcom/venticake/retrica/engine/RetricaEngine;)I
    //   73: putfield 41	com/venticake/retrica/engine/RetricaEngine$LoadImageTask:mOutputHeight	I
    //   76: aload_0
    //   77: invokespecial 174	com/venticake/retrica/engine/RetricaEngine$LoadImageTask:loadResizedImage	()Landroid/graphics/Bitmap;
    //   80: areturn
    //   81: astore_2
    //   82: aload_1
    //   83: monitorexit
    //   84: aload_2
    //   85: athrow
    //   86: astore_1
    //   87: aload_1
    //   88: invokevirtual 175	java/lang/InterruptedException:printStackTrace	()V
    //   91: goto -37 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	LoadImageTask
    //   81	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   36	54	81	finally
    //   82	84	81	finally
    //   23	36	86	java/lang/InterruptedException
    //   84	86	86	java/lang/InterruptedException
  }
  
  protected abstract int getImageOrientation();
  
  protected void onPostExecute(Bitmap paramBitmap)
  {
    super.onPostExecute(paramBitmap);
    this.mEngine.setImage(paramBitmap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/engine/RetricaEngine$LoadImageTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */