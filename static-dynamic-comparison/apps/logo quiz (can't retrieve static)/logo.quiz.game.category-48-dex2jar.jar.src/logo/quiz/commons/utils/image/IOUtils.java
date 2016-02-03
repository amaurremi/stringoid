package logo.quiz.commons.utils.image;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.Closeable;

public class IOUtils
{
  public static void closeSilently(Cursor paramCursor)
  {
    if (paramCursor == null) {}
    while (paramCursor == null) {
      return;
    }
    try
    {
      paramCursor.close();
      return;
    }
    catch (Throwable paramCursor) {}
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
  
  public static String getRealFilePath(Context paramContext, Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    String str = paramUri.getScheme();
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1;
    if (str == null) {
      localObject1 = paramUri.getPath();
    }
    for (;;)
    {
      return (String)localObject1;
      if ("file".equals(str))
      {
        localObject1 = paramUri.getPath();
      }
      else
      {
        localObject1 = localObject3;
        if ("content".equals(str))
        {
          paramContext = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
          localObject1 = localObject3;
          if (paramContext != null)
          {
            localObject1 = localObject2;
            if (paramContext.moveToFirst())
            {
              int i = paramContext.getColumnIndex("_data");
              localObject1 = localObject2;
              if (i > -1) {
                localObject1 = paramContext.getString(i);
              }
            }
            paramContext.close();
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/image/IOUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */