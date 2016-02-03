package com.mobisystems.mobiscanner.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.mobisystems.mobiscanner.common.c;

public class i
  extends BitmapDrawable
{
  private boolean aIA;
  private int aIy = 0;
  private int aIz = 0;
  private final c mLog = new c(this);
  
  public i(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
  }
  
  private void In()
  {
    try
    {
      if ((this.aIy <= 0) && (this.aIz <= 0) && (this.aIA) && (Io()))
      {
        this.mLog.dl("No longer being used or cached so recycling. ");
        getBitmap().recycle();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  private boolean Io()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 45	com/mobisystems/mobiscanner/image/i:getBitmap	()Landroid/graphics/Bitmap;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +18 -> 26
    //   11: aload_2
    //   12: invokevirtual 53	android/graphics/Bitmap:isRecycled	()Z
    //   15: istore_1
    //   16: iload_1
    //   17: ifne +9 -> 26
    //   20: iconst_1
    //   21: istore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: iconst_0
    //   27: istore_1
    //   28: goto -6 -> 22
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	i
    //   15	13	1	bool	boolean
    //   6	6	2	localBitmap	Bitmap
    //   31	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   11	16	31	finally
  }
  
  public void bp(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.aIz += 1;
        this.aIA = true;
        In();
        return;
      }
      finally {}
      this.aIz -= 1;
    }
  }
  
  public void bq(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.aIy += 1;
        In();
        return;
      }
      finally {}
      this.aIy -= 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/image/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */