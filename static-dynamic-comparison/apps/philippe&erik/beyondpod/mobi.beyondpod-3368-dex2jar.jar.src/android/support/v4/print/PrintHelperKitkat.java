package android.support.v4.print;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentInfo.Builder;
import android.print.PrintManager;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class PrintHelperKitkat
{
  public static final int COLOR_MODE_COLOR = 2;
  public static final int COLOR_MODE_MONOCHROME = 1;
  private static final String LOG_TAG = "PrintHelperKitkat";
  private static final int MAX_PRINT_SIZE = 3500;
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  int mColorMode = 2;
  final Context mContext;
  int mScaleMode = 2;
  
  PrintHelperKitkat(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private Bitmap loadBitmap(Uri paramUri, BitmapFactory.Options paramOptions)
    throws FileNotFoundException
  {
    if ((paramUri == null) || (this.mContext == null)) {
      throw new IllegalArgumentException("bad argument to loadBitmap");
    }
    localUri = null;
    try
    {
      paramUri = this.mContext.getContentResolver().openInputStream(paramUri);
      localUri = paramUri;
      paramOptions = BitmapFactory.decodeStream(paramUri, null, paramOptions);
      if (paramUri != null) {}
      try
      {
        paramUri.close();
        return paramOptions;
      }
      catch (IOException paramUri)
      {
        Log.w("PrintHelperKitkat", "close fail ", paramUri);
        return paramOptions;
      }
      try
      {
        localUri.close();
        throw paramUri;
      }
      catch (IOException paramOptions)
      {
        for (;;)
        {
          Log.w("PrintHelperKitkat", "close fail ", paramOptions);
        }
      }
    }
    finally
    {
      if (localUri == null) {}
    }
  }
  
  private Bitmap loadConstrainedBitmap(Uri paramUri, int paramInt)
    throws FileNotFoundException
  {
    if ((paramInt <= 0) || (paramUri == null) || (this.mContext == null)) {
      throw new IllegalArgumentException("bad argument to getScaledBitmap");
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    loadBitmap(paramUri, localOptions);
    int k = localOptions.outWidth;
    int m = localOptions.outHeight;
    if ((k <= 0) || (m <= 0)) {}
    int i;
    do
    {
      return null;
      int j = Math.max(k, m);
      i = 1;
      while (j > paramInt)
      {
        j >>>= 1;
        i <<= 1;
      }
    } while ((i <= 0) || (Math.min(k, m) / i <= 0));
    localOptions = new BitmapFactory.Options();
    localOptions.inMutable = true;
    localOptions.inSampleSize = i;
    return loadBitmap(paramUri, localOptions);
  }
  
  public int getColorMode()
  {
    return this.mColorMode;
  }
  
  public int getScaleMode()
  {
    return this.mScaleMode;
  }
  
  public void printBitmap(final String paramString, final Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    final int i = this.mScaleMode;
    PrintManager localPrintManager = (PrintManager)this.mContext.getSystemService("print");
    Object localObject = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
    if (paramBitmap.getWidth() > paramBitmap.getHeight()) {
      localObject = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
    }
    localObject = new PrintAttributes.Builder().setMediaSize((PrintAttributes.MediaSize)localObject).setColorMode(this.mColorMode).build();
    localPrintManager.print(paramString, new PrintDocumentAdapter()
    {
      private PrintAttributes mAttributes;
      
      public void onLayout(PrintAttributes paramAnonymousPrintAttributes1, PrintAttributes paramAnonymousPrintAttributes2, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
      {
        boolean bool = true;
        this.mAttributes = paramAnonymousPrintAttributes2;
        paramAnonymousCancellationSignal = new PrintDocumentInfo.Builder(paramString).setContentType(1).setPageCount(1).build();
        if (!paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {}
        for (;;)
        {
          paramAnonymousLayoutResultCallback.onLayoutFinished(paramAnonymousCancellationSignal, bool);
          return;
          bool = false;
        }
      }
      
      /* Error */
      public void onWrite(android.print.PageRange[] paramAnonymousArrayOfPageRange, android.os.ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, android.print.PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
      {
        // Byte code:
        //   0: new 71	android/print/pdf/PrintedPdfDocument
        //   3: dup
        //   4: aload_0
        //   5: getfield 23	android/support/v4/print/PrintHelperKitkat$1:this$0	Landroid/support/v4/print/PrintHelperKitkat;
        //   8: getfield 75	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
        //   11: aload_0
        //   12: getfield 37	android/support/v4/print/PrintHelperKitkat$1:mAttributes	Landroid/print/PrintAttributes;
        //   15: invokespecial 78	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
        //   18: astore_1
        //   19: aload_1
        //   20: iconst_1
        //   21: invokevirtual 82	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
        //   24: astore_3
        //   25: new 84	android/graphics/RectF
        //   28: dup
        //   29: aload_3
        //   30: invokevirtual 90	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
        //   33: invokevirtual 96	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
        //   36: invokespecial 99	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
        //   39: astore 6
        //   41: new 101	android/graphics/Matrix
        //   44: dup
        //   45: invokespecial 102	android/graphics/Matrix:<init>	()V
        //   48: astore 7
        //   50: aload 6
        //   52: invokevirtual 106	android/graphics/RectF:width	()F
        //   55: aload_0
        //   56: getfield 27	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
        //   59: invokevirtual 112	android/graphics/Bitmap:getWidth	()I
        //   62: i2f
        //   63: fdiv
        //   64: fstore 5
        //   66: aload_0
        //   67: getfield 29	android/support/v4/print/PrintHelperKitkat$1:val$fittingMode	I
        //   70: iconst_2
        //   71: if_icmpne +144 -> 215
        //   74: fload 5
        //   76: aload 6
        //   78: invokevirtual 115	android/graphics/RectF:height	()F
        //   81: aload_0
        //   82: getfield 27	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
        //   85: invokevirtual 118	android/graphics/Bitmap:getHeight	()I
        //   88: i2f
        //   89: fdiv
        //   90: invokestatic 124	java/lang/Math:max	(FF)F
        //   93: fstore 5
        //   95: aload 7
        //   97: fload 5
        //   99: fload 5
        //   101: invokevirtual 128	android/graphics/Matrix:postScale	(FF)Z
        //   104: pop
        //   105: aload 7
        //   107: aload 6
        //   109: invokevirtual 106	android/graphics/RectF:width	()F
        //   112: aload_0
        //   113: getfield 27	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
        //   116: invokevirtual 112	android/graphics/Bitmap:getWidth	()I
        //   119: i2f
        //   120: fload 5
        //   122: fmul
        //   123: fsub
        //   124: fconst_2
        //   125: fdiv
        //   126: aload 6
        //   128: invokevirtual 115	android/graphics/RectF:height	()F
        //   131: aload_0
        //   132: getfield 27	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
        //   135: invokevirtual 118	android/graphics/Bitmap:getHeight	()I
        //   138: i2f
        //   139: fload 5
        //   141: fmul
        //   142: fsub
        //   143: fconst_2
        //   144: fdiv
        //   145: invokevirtual 131	android/graphics/Matrix:postTranslate	(FF)Z
        //   148: pop
        //   149: aload_3
        //   150: invokevirtual 135	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
        //   153: aload_0
        //   154: getfield 27	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
        //   157: aload 7
        //   159: aconst_null
        //   160: invokevirtual 141	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
        //   163: aload_1
        //   164: aload_3
        //   165: invokevirtual 145	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
        //   168: aload_1
        //   169: new 147	java/io/FileOutputStream
        //   172: dup
        //   173: aload_2
        //   174: invokevirtual 153	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
        //   177: invokespecial 156	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
        //   180: invokevirtual 160	android/print/pdf/PrintedPdfDocument:writeTo	(Ljava/io/OutputStream;)V
        //   183: aload 4
        //   185: iconst_1
        //   186: anewarray 162	android/print/PageRange
        //   189: dup
        //   190: iconst_0
        //   191: getstatic 166	android/print/PageRange:ALL_PAGES	Landroid/print/PageRange;
        //   194: aastore
        //   195: invokevirtual 172	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFinished	([Landroid/print/PageRange;)V
        //   198: aload_1
        //   199: ifnull +7 -> 206
        //   202: aload_1
        //   203: invokevirtual 175	android/print/pdf/PrintedPdfDocument:close	()V
        //   206: aload_2
        //   207: ifnull +7 -> 214
        //   210: aload_2
        //   211: invokevirtual 176	android/os/ParcelFileDescriptor:close	()V
        //   214: return
        //   215: fload 5
        //   217: aload 6
        //   219: invokevirtual 115	android/graphics/RectF:height	()F
        //   222: aload_0
        //   223: getfield 27	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
        //   226: invokevirtual 118	android/graphics/Bitmap:getHeight	()I
        //   229: i2f
        //   230: fdiv
        //   231: invokestatic 179	java/lang/Math:min	(FF)F
        //   234: fstore 5
        //   236: goto -141 -> 95
        //   239: astore_3
        //   240: ldc -75
        //   242: ldc -73
        //   244: aload_3
        //   245: invokestatic 189	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   248: pop
        //   249: aload 4
        //   251: aconst_null
        //   252: invokevirtual 193	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFailed	(Ljava/lang/CharSequence;)V
        //   255: goto -57 -> 198
        //   258: astore_3
        //   259: aload_1
        //   260: ifnull +7 -> 267
        //   263: aload_1
        //   264: invokevirtual 175	android/print/pdf/PrintedPdfDocument:close	()V
        //   267: aload_2
        //   268: ifnull +7 -> 275
        //   271: aload_2
        //   272: invokevirtual 176	android/os/ParcelFileDescriptor:close	()V
        //   275: aload_3
        //   276: athrow
        //   277: astore_1
        //   278: return
        //   279: astore_1
        //   280: goto -5 -> 275
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	283	0	this	1
        //   0	283	1	paramAnonymousArrayOfPageRange	android.print.PageRange[]
        //   0	283	2	paramAnonymousParcelFileDescriptor	android.os.ParcelFileDescriptor
        //   0	283	3	paramAnonymousCancellationSignal	CancellationSignal
        //   0	283	4	paramAnonymousWriteResultCallback	android.print.PrintDocumentAdapter.WriteResultCallback
        //   64	171	5	f	float
        //   39	179	6	localRectF	android.graphics.RectF
        //   48	110	7	localMatrix	android.graphics.Matrix
        // Exception table:
        //   from	to	target	type
        //   168	198	239	java/io/IOException
        //   19	95	258	finally
        //   95	168	258	finally
        //   168	198	258	finally
        //   215	236	258	finally
        //   240	255	258	finally
        //   210	214	277	java/io/IOException
        //   271	275	279	java/io/IOException
      }
    }, (PrintAttributes)localObject);
  }
  
  public void printBitmap(String paramString, Uri paramUri)
    throws FileNotFoundException
  {
    printBitmap(paramString, loadConstrainedBitmap(paramUri, 3500));
  }
  
  public void setColorMode(int paramInt)
  {
    this.mColorMode = paramInt;
  }
  
  public void setScaleMode(int paramInt)
  {
    this.mScaleMode = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v4/print/PrintHelperKitkat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */