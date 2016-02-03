package logo.quiz.commons.utils.image;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DecodeUtils
{
  private static int computeSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    double d2;
    if ((paramInt5 == 0) || (paramInt5 == 180)) {
      d2 = paramInt1;
    }
    for (double d1 = paramInt2;; d1 = paramInt1)
    {
      return (int)Math.ceil(Math.max(d2 / paramInt3, d1 / paramInt4));
      d2 = paramInt2;
    }
  }
  
  public static Bitmap decode(Context paramContext, Uri paramUri, int paramInt1, int paramInt2)
  {
    Object localObject = openInputStream(paramContext, paramUri);
    if (localObject == null) {}
    int j;
    int[] arrayOfInt;
    boolean bool;
    do
    {
      return null;
      j = ExifUtils.getExifOrientation(paramContext, paramUri);
      arrayOfInt = new int[2];
      bool = decodeImageBounds((InputStream)localObject, arrayOfInt);
      IOUtils.closeSilently((Closeable)localObject);
    } while (!bool);
    if ((paramInt1 < 0) || (paramInt2 < 0)) {}
    for (int i = 1;; i = computeSampleSize(arrayOfInt[0], arrayOfInt[1], (int)(paramInt1 * 1.2D), (int)(paramInt2 * 1.2D), j))
    {
      localObject = getDefaultOptions();
      ((BitmapFactory.Options)localObject).inSampleSize = i;
      return decodeBitmap(paramContext, paramUri, (BitmapFactory.Options)localObject, paramInt1, paramInt2, j, 0);
    }
  }
  
  private static Bitmap decodeBitmap(Context paramContext, Uri paramUri, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    localObject = null;
    if (paramInt4 > 20) {
      return null;
    }
    localInputStream = openInputStream(paramContext, paramUri);
    if (localInputStream == null) {
      return null;
    }
    try
    {
      Bitmap localBitmap1 = BitmapFactory.decodeStream(localInputStream, null, paramOptions);
      localObject = localBitmap1;
      IOUtils.closeSilently(localInputStream);
      localObject = localBitmap1;
      if (localBitmap1 != null)
      {
        localObject = localBitmap1;
        if (paramInt1 > 0)
        {
          localObject = localBitmap1;
          if (paramInt2 > 0)
          {
            localObject = localBitmap1;
            Bitmap localBitmap2 = BitmapUtils.resizeBitmap(localBitmap1, paramInt1, paramInt2, paramInt3);
            if (localBitmap1 != localBitmap2)
            {
              localObject = localBitmap1;
              localBitmap1.recycle();
            }
            localObject = localBitmap2;
          }
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        IOUtils.closeSilently(localInputStream);
        if (localObject != null) {
          ((Bitmap)localObject).recycle();
        }
        paramOptions.inSampleSize += 1;
        localObject = decodeBitmap(paramContext, paramUri, paramOptions, paramInt1, paramInt2, paramInt3, paramInt4 + 1);
      }
    }
    return (Bitmap)localObject;
  }
  
  public static boolean decodeImageBounds(InputStream paramInputStream, int[] paramArrayOfInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    if ((localOptions.outHeight > 0) && (localOptions.outWidth > 0))
    {
      paramArrayOfInt[0] = localOptions.outWidth;
      paramArrayOfInt[1] = localOptions.outHeight;
      return true;
    }
    return false;
  }
  
  private static BitmapFactory.Options getDefaultOptions()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inScaled = false;
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    localOptions.inDither = false;
    localOptions.inJustDecodeBounds = false;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    localOptions.inTempStorage = new byte['䀀'];
    return localOptions;
  }
  
  private static InputStream openContentInputStream(Context paramContext, Uri paramUri)
  {
    try
    {
      paramContext = paramContext.getContentResolver().openInputStream(paramUri);
      return paramContext;
    }
    catch (FileNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private static InputStream openFileInputStream(String paramString)
  {
    try
    {
      paramString = new FileInputStream(paramString);
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static InputStream openInputStream(Context paramContext, Uri paramUri)
  {
    if (paramUri == null) {}
    String str;
    do
    {
      return null;
      str = paramUri.getScheme();
      if ((str == null) || ("file".equals(str))) {
        return openFileInputStream(paramUri.getPath());
      }
      if ("content".equals(str)) {
        return openContentInputStream(paramContext, paramUri);
      }
    } while ((!"http".equals(str)) && (!"https".equals(str)));
    return openRemoteInputStream(paramUri);
  }
  
  private static InputStream openRemoteInputStream(Uri paramUri)
  {
    try
    {
      paramUri = new URL(paramUri.toString());
      try
      {
        HttpURLConnection localHttpURLConnection;
        int i;
        paramUri = (InputStream)paramUri.getContent();
        return paramUri;
      }
      catch (IOException paramUri)
      {
        paramUri.printStackTrace();
      }
    }
    catch (MalformedURLException paramUri)
    {
      for (;;)
      {
        try
        {
          localHttpURLConnection = (HttpURLConnection)paramUri.openConnection();
          localHttpURLConnection.setInstanceFollowRedirects(false);
        }
        catch (IOException paramUri)
        {
          paramUri.printStackTrace();
          return null;
        }
        try
        {
          i = localHttpURLConnection.getResponseCode();
          if ((i != 301) && (i != 302) && (i != 303)) {
            break;
          }
          return openRemoteInputStream(Uri.parse(localHttpURLConnection.getHeaderField("Location")));
        }
        catch (IOException paramUri)
        {
          paramUri.printStackTrace();
          return null;
        }
      }
      paramUri = paramUri;
      paramUri.printStackTrace();
      return null;
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/image/DecodeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */