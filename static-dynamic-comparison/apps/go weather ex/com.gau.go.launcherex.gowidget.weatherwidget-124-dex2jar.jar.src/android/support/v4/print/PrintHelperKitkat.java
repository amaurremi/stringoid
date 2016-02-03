package android.support.v4.print;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument.Page;
import android.graphics.pdf.PdfDocument.PageInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.CancellationSignal.OnCancelListener;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.print.PrintDocumentInfo.Builder;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

class PrintHelperKitkat
{
  public static final int COLOR_MODE_COLOR = 2;
  public static final int COLOR_MODE_MONOCHROME = 1;
  private static final String LOG_TAG = "PrintHelperKitkat";
  private static final int MAX_PRINT_SIZE = 3500;
  public static final int ORIENTATION_LANDSCAPE = 1;
  public static final int ORIENTATION_PORTRAIT = 2;
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  int mColorMode = 2;
  final Context mContext;
  BitmapFactory.Options mDecodeOptions = null;
  private final Object mLock = new Object();
  int mOrientation = 1;
  int mScaleMode = 2;
  
  PrintHelperKitkat(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private Matrix getMatrix(int paramInt1, int paramInt2, RectF paramRectF, int paramInt3)
  {
    Matrix localMatrix = new Matrix();
    float f = paramRectF.width() / paramInt1;
    if (paramInt3 == 2) {}
    for (f = Math.max(f, paramRectF.height() / paramInt2);; f = Math.min(f, paramRectF.height() / paramInt2))
    {
      localMatrix.postScale(f, f);
      localMatrix.postTranslate((paramRectF.width() - paramInt1 * f) / 2.0F, (paramRectF.height() - paramInt2 * f) / 2.0F);
      return localMatrix;
    }
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
  
  private Bitmap loadConstrainedBitmap(Uri arg1, int paramInt)
    throws FileNotFoundException
  {
    if ((paramInt <= 0) || (??? == null) || (this.mContext == null)) {
      throw new IllegalArgumentException("bad argument to getScaledBitmap");
    }
    ??? = new BitmapFactory.Options();
    ((BitmapFactory.Options)???).inJustDecodeBounds = true;
    loadBitmap(???, (BitmapFactory.Options)???);
    int k = ((BitmapFactory.Options)???).outWidth;
    int m = ((BitmapFactory.Options)???).outHeight;
    if ((k <= 0) || (m <= 0)) {}
    int j;
    int i;
    do
    {
      return null;
      j = Math.max(k, m);
      i = 1;
    } while ((j <= paramInt) && ((i <= 0) || (Math.min(k, m) / i <= 0)));
    BitmapFactory.Options localOptions;
    synchronized (this.mLock)
    {
      this.mDecodeOptions = new BitmapFactory.Options();
      this.mDecodeOptions.inMutable = true;
      this.mDecodeOptions.inSampleSize = i;
      localOptions = this.mDecodeOptions;
    }
  }
  
  public int getColorMode()
  {
    return this.mColorMode;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
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
        if (paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {
          bool = false;
        }
        paramAnonymousLayoutResultCallback.onLayoutFinished(paramAnonymousCancellationSignal, bool);
      }
      
      public void onWrite(PageRange[] paramAnonymousArrayOfPageRange, ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
      {
        paramAnonymousArrayOfPageRange = new PrintedPdfDocument(PrintHelperKitkat.this.mContext, this.mAttributes);
        try
        {
          paramAnonymousCancellationSignal = paramAnonymousArrayOfPageRange.startPage(1);
          Object localObject = new RectF(paramAnonymousCancellationSignal.getInfo().getContentRect());
          localObject = PrintHelperKitkat.this.getMatrix(paramBitmap.getWidth(), paramBitmap.getHeight(), (RectF)localObject, i);
          paramAnonymousCancellationSignal.getCanvas().drawBitmap(paramBitmap, (Matrix)localObject, null);
          paramAnonymousArrayOfPageRange.finishPage(paramAnonymousCancellationSignal);
          try
          {
            paramAnonymousArrayOfPageRange.writeTo(new FileOutputStream(paramAnonymousParcelFileDescriptor.getFileDescriptor()));
            paramAnonymousWriteResultCallback.onWriteFinished(new PageRange[] { PageRange.ALL_PAGES });
            if (paramAnonymousArrayOfPageRange != null) {
              paramAnonymousArrayOfPageRange.close();
            }
            if (paramAnonymousParcelFileDescriptor == null) {}
          }
          catch (IOException paramAnonymousCancellationSignal)
          {
            for (;;)
            {
              try
              {
                paramAnonymousParcelFileDescriptor.close();
                return;
              }
              catch (IOException paramAnonymousArrayOfPageRange) {}
              paramAnonymousCancellationSignal = paramAnonymousCancellationSignal;
              Log.e("PrintHelperKitkat", "Error writing printed content", paramAnonymousCancellationSignal);
              paramAnonymousWriteResultCallback.onWriteFailed(null);
            }
          }
          return;
        }
        finally
        {
          if (paramAnonymousArrayOfPageRange != null) {
            paramAnonymousArrayOfPageRange.close();
          }
          if (paramAnonymousParcelFileDescriptor != null) {}
          try
          {
            paramAnonymousParcelFileDescriptor.close();
            throw paramAnonymousCancellationSignal;
          }
          catch (IOException paramAnonymousArrayOfPageRange)
          {
            for (;;) {}
          }
        }
      }
    }, (PrintAttributes)localObject);
  }
  
  public void printBitmap(final String paramString, final Uri paramUri)
    throws FileNotFoundException
  {
    paramUri = new PrintDocumentAdapter()
    {
      AsyncTask<Uri, Boolean, Bitmap> loadBitmap;
      private PrintAttributes mAttributes;
      Bitmap mBitmap = null;
      
      private void cancelLoad()
      {
        synchronized (PrintHelperKitkat.this.mLock)
        {
          if (PrintHelperKitkat.this.mDecodeOptions != null)
          {
            PrintHelperKitkat.this.mDecodeOptions.requestCancelDecode();
            PrintHelperKitkat.this.mDecodeOptions = null;
          }
          return;
        }
      }
      
      public void onFinish()
      {
        super.onFinish();
        cancelLoad();
        this.loadBitmap.cancel(true);
      }
      
      public void onLayout(final PrintAttributes paramAnonymousPrintAttributes1, final PrintAttributes paramAnonymousPrintAttributes2, final CancellationSignal paramAnonymousCancellationSignal, final PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
      {
        boolean bool = false;
        if (paramAnonymousCancellationSignal.isCanceled())
        {
          paramAnonymousLayoutResultCallback.onLayoutCancelled();
          this.mAttributes = paramAnonymousPrintAttributes2;
          return;
        }
        if (this.mBitmap != null)
        {
          paramAnonymousCancellationSignal = new PrintDocumentInfo.Builder(paramString).setContentType(1).setPageCount(1).build();
          if (paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {}
          for (;;)
          {
            paramAnonymousLayoutResultCallback.onLayoutFinished(paramAnonymousCancellationSignal, bool);
            return;
            bool = true;
          }
        }
        this.loadBitmap = new AsyncTask()
        {
          protected Bitmap doInBackground(Uri... paramAnonymous2VarArgs)
          {
            try
            {
              paramAnonymous2VarArgs = PrintHelperKitkat.this.loadConstrainedBitmap(this.val$imageFile, 3500);
              return paramAnonymous2VarArgs;
            }
            catch (FileNotFoundException paramAnonymous2VarArgs) {}
            return null;
          }
          
          protected void onCancelled(Bitmap paramAnonymous2Bitmap)
          {
            paramAnonymousLayoutResultCallback.onLayoutCancelled();
          }
          
          protected void onPostExecute(Bitmap paramAnonymous2Bitmap)
          {
            boolean bool = true;
            super.onPostExecute(paramAnonymous2Bitmap);
            PrintHelperKitkat.2.this.mBitmap = paramAnonymous2Bitmap;
            if (paramAnonymous2Bitmap != null)
            {
              paramAnonymous2Bitmap = new PrintDocumentInfo.Builder(this.val$jobName).setContentType(1).setPageCount(1).build();
              if (paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {
                bool = false;
              }
              paramAnonymousLayoutResultCallback.onLayoutFinished(paramAnonymous2Bitmap, bool);
              return;
            }
            paramAnonymousLayoutResultCallback.onLayoutFailed(null);
          }
          
          protected void onPreExecute()
          {
            paramAnonymousCancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener()
            {
              public void onCancel()
              {
                PrintHelperKitkat.2.this.cancelLoad();
                PrintHelperKitkat.2.1.this.cancel(false);
              }
            });
          }
        };
        this.loadBitmap.execute(new Uri[0]);
        this.mAttributes = paramAnonymousPrintAttributes2;
      }
      
      public void onWrite(PageRange[] paramAnonymousArrayOfPageRange, ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
      {
        paramAnonymousArrayOfPageRange = new PrintedPdfDocument(PrintHelperKitkat.this.mContext, this.mAttributes);
        try
        {
          paramAnonymousCancellationSignal = paramAnonymousArrayOfPageRange.startPage(1);
          Object localObject = new RectF(paramAnonymousCancellationSignal.getInfo().getContentRect());
          localObject = PrintHelperKitkat.this.getMatrix(this.mBitmap.getWidth(), this.mBitmap.getHeight(), (RectF)localObject, this.val$fittingMode);
          paramAnonymousCancellationSignal.getCanvas().drawBitmap(this.mBitmap, (Matrix)localObject, null);
          paramAnonymousArrayOfPageRange.finishPage(paramAnonymousCancellationSignal);
          try
          {
            paramAnonymousArrayOfPageRange.writeTo(new FileOutputStream(paramAnonymousParcelFileDescriptor.getFileDescriptor()));
            paramAnonymousWriteResultCallback.onWriteFinished(new PageRange[] { PageRange.ALL_PAGES });
            if (paramAnonymousArrayOfPageRange != null) {
              paramAnonymousArrayOfPageRange.close();
            }
            if (paramAnonymousParcelFileDescriptor == null) {}
          }
          catch (IOException paramAnonymousCancellationSignal)
          {
            for (;;)
            {
              try
              {
                paramAnonymousParcelFileDescriptor.close();
                return;
              }
              catch (IOException paramAnonymousArrayOfPageRange) {}
              paramAnonymousCancellationSignal = paramAnonymousCancellationSignal;
              Log.e("PrintHelperKitkat", "Error writing printed content", paramAnonymousCancellationSignal);
              paramAnonymousWriteResultCallback.onWriteFailed(null);
            }
          }
          return;
        }
        finally
        {
          if (paramAnonymousArrayOfPageRange != null) {
            paramAnonymousArrayOfPageRange.close();
          }
          if (paramAnonymousParcelFileDescriptor != null) {}
          try
          {
            paramAnonymousParcelFileDescriptor.close();
            throw paramAnonymousCancellationSignal;
          }
          catch (IOException paramAnonymousArrayOfPageRange)
          {
            for (;;) {}
          }
        }
      }
    };
    PrintManager localPrintManager = (PrintManager)this.mContext.getSystemService("print");
    PrintAttributes.Builder localBuilder = new PrintAttributes.Builder();
    localBuilder.setColorMode(this.mColorMode);
    if (this.mOrientation == 1) {
      localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
    }
    for (;;)
    {
      localPrintManager.print(paramString, paramUri, localBuilder.build());
      return;
      if (this.mOrientation == 2) {
        localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
      }
    }
  }
  
  public void setColorMode(int paramInt)
  {
    this.mColorMode = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    this.mOrientation = paramInt;
  }
  
  public void setScaleMode(int paramInt)
  {
    this.mScaleMode = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/android/support/v4/print/PrintHelperKitkat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */