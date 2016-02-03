package com.venticake.retrica.view.album;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.Closeable;

public class Util
{
  private static final String MAPS_CLASS_NAME = "com.google.android.maps.MapsActivity";
  private static final String MAPS_PACKAGE_NAME = "com.google.android.apps.maps";
  private static final String TAG = "db.Util";
  
  public static void Assert(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new AssertionError();
    }
  }
  
  public static void closeSilently(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor == null) {
      return;
    }
    try
    {
      paramParcelFileDescriptor.close();
      return;
    }
    catch (Throwable paramParcelFileDescriptor) {}
  }
  
  public static void closeSilently(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  public static Intent createSetAsIntent(Uri paramUri, String paramString)
  {
    String str = paramString;
    if (paramUri.getScheme().equals("file"))
    {
      int i = paramUri.getPath().lastIndexOf('.');
      str = paramString;
      if (i != -1) {
        str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramUri.getPath().substring(i + 1).toLowerCase());
      }
    }
    paramString = new Intent("android.intent.action.ATTACH_DATA");
    paramString.setDataAndType(paramUri, str);
    paramString.putExtra("mimeType", str);
    return paramString;
  }
  
  public static boolean equals(String paramString1, String paramString2)
  {
    return (paramString1 == paramString2) || (paramString1.equals(paramString2));
  }
  
  public static Bitmap extractMiniThumb(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return extractMiniThumb(paramBitmap, paramInt1, paramInt2, true);
  }
  
  public static Bitmap extractMiniThumb(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject;
    if (paramBitmap == null)
    {
      localObject = null;
      return (Bitmap)localObject;
    }
    if (paramBitmap.getWidth() < paramBitmap.getHeight()) {}
    for (float f = paramInt1 / paramBitmap.getWidth();; f = paramInt2 / paramBitmap.getHeight())
    {
      localObject = new Matrix();
      ((Matrix)localObject).setScale(f, f);
      Bitmap localBitmap = transform((Matrix)localObject, paramBitmap, paramInt1, paramInt2, false);
      localObject = localBitmap;
      if (!paramBoolean) {
        break;
      }
      localObject = localBitmap;
      if (localBitmap == paramBitmap) {
        break;
      }
      paramBitmap.recycle();
      return localBitmap;
    }
  }
  
  public static <T> int indexOf(T[] paramArrayOfT, T paramT)
  {
    int i = 0;
    for (;;)
    {
      int j;
      if (i >= paramArrayOfT.length) {
        j = -1;
      }
      do
      {
        return j;
        j = i;
      } while (paramArrayOfT[i].equals(paramT));
      i += 1;
    }
  }
  
  public static void openMaps(Context paramContext, double paramDouble1, double paramDouble2)
  {
    try
    {
      String str = String.format("http://maps.google.com/maps?f=q&q=(%s,%s)", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
      ComponentName localComponentName = new ComponentName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
      paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)).setComponent(localComponentName));
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Log.e("db.Util", "GMM activity not found!", localActivityNotFoundException);
      paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%s,%s", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) }))));
    }
  }
  
  public static Bitmap rotate(Bitmap paramBitmap, int paramInt)
  {
    Object localObject = paramBitmap;
    if (paramInt != 0)
    {
      localObject = paramBitmap;
      if (paramBitmap != null)
      {
        localObject = new Matrix();
        ((Matrix)localObject).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
      }
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localObject = paramBitmap;
      if (paramBitmap != localBitmap)
      {
        paramBitmap.recycle();
        localObject = localBitmap;
      }
      return (Bitmap)localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return paramBitmap;
  }
  
  public static void startBackgroundJob(MonitoredActivity paramMonitoredActivity, String paramString1, String paramString2, Runnable paramRunnable, Handler paramHandler)
  {
    new Thread(new Util.BackgroundJob(paramMonitoredActivity, paramRunnable, ProgressDialog.show(paramMonitoredActivity, paramString1, paramString2, true, false), paramHandler)).start();
  }
  
  public static Bitmap transform(Matrix paramMatrix, Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = null;
    int j = paramBitmap.getWidth() - paramInt1;
    int i = paramBitmap.getHeight() - paramInt2;
    if ((!paramBoolean) && ((j < 0) || (i < 0)))
    {
      paramMatrix = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localObject = new Canvas(paramMatrix);
      j = Math.max(0, j / 2);
      i = Math.max(0, i / 2);
      Rect localRect = new Rect(j, i, Math.min(paramInt1, paramBitmap.getWidth()) + j, Math.min(paramInt2, paramBitmap.getHeight()) + i);
      i = (paramInt1 - localRect.width()) / 2;
      j = (paramInt2 - localRect.height()) / 2;
      ((Canvas)localObject).drawBitmap(paramBitmap, localRect, new Rect(i, j, paramInt1 - i, paramInt2 - j), null);
      return paramMatrix;
    }
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    if (f1 / f2 > paramInt1 / paramInt2)
    {
      f1 = paramInt2 / f2;
      if ((f1 < 0.9F) || (f1 > 1.0F))
      {
        paramMatrix.setScale(f1, f1);
        localObject = paramMatrix;
      }
      if (localObject == null) {
        break label332;
      }
    }
    label332:
    for (paramMatrix = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);; paramMatrix = paramBitmap)
    {
      i = Math.max(0, paramMatrix.getWidth() - paramInt1);
      j = Math.max(0, paramMatrix.getHeight() - paramInt2);
      localObject = Bitmap.createBitmap(paramMatrix, i / 2, j / 2, paramInt1, paramInt2);
      if (paramMatrix != paramBitmap) {
        paramMatrix.recycle();
      }
      return (Bitmap)localObject;
      f1 = paramInt1 / f1;
      if ((f1 >= 0.9F) && (f1 <= 1.0F)) {
        break;
      }
      paramMatrix.setScale(f1, f1);
      localObject = paramMatrix;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */