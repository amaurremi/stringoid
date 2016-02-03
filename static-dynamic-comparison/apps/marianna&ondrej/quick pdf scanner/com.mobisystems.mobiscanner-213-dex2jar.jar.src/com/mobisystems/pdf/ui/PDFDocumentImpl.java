package com.mobisystems.pdf.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.mobisystems.pdf.PDFDocument;
import com.mobisystems.pdf.PDFError;
import java.io.File;
import java.io.InputStream;

public class PDFDocumentImpl
  extends PDFDocument
{
  public static final Parcelable.Creator<PDFDocument> CREATOR = new Parcelable.Creator()
  {
    public PDFDocument createFromParcel(Parcel paramAnonymousParcel)
    {
      try
      {
        paramAnonymousParcel = new PDFDocumentImpl(paramAnonymousParcel);
        return paramAnonymousParcel;
      }
      catch (PDFError paramAnonymousParcel)
      {
        paramAnonymousParcel.printStackTrace();
      }
      return null;
    }
    
    public PDFDocument[] newArray(int paramAnonymousInt)
    {
      return new PDFDocumentImpl[paramAnonymousInt];
    }
  };
  protected Context mContext;
  
  protected PDFDocumentImpl(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  protected PDFDocumentImpl(String paramString, Context paramContext)
  {
    super(paramString);
    setContext(paramContext);
  }
  
  public String getCachePath()
  {
    return new File(this.mContext.getCacheDir(), "cache.txt").getAbsolutePath();
  }
  
  public InputStream getSystemCMapStream(String paramString)
  {
    return this.mContext.getAssets().open("CMap/" + paramString);
  }
  
  public File getTempDir()
  {
    return this.mContext.getCacheDir();
  }
  
  /* Error */
  public void onLock()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokestatic 83	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6: invokevirtual 87	java/lang/Thread:getId	()J
    //   9: invokevirtual 91	com/mobisystems/pdf/ui/PDFDocumentImpl:incrementLockCount	(J)I
    //   12: istore_1
    //   13: iload_1
    //   14: ifne +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: invokevirtual 96	java/lang/Object:wait	()V
    //   24: goto -22 -> 2
    //   27: astore_2
    //   28: aload_2
    //   29: invokevirtual 99	java/lang/InterruptedException:printStackTrace	()V
    //   32: goto -30 -> 2
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	PDFDocumentImpl
    //   12	2	1	i	int
    //   27	2	2	localInterruptedException	InterruptedException
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	24	27	java/lang/InterruptedException
    //   2	13	35	finally
    //   20	24	35	finally
    //   28	32	35	finally
  }
  
  public void onUnlock()
  {
    try
    {
      if (decrementLockCount(Thread.currentThread().getId()) == 0) {
        notifyAll();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.mContext = paramContext;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/PDFDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */