package android.support.v4.content;

import android.content.Context;
import java.io.File;

class b
{
  public static File a(Context paramContext)
  {
    return paramContext.getExternalCacheDir();
  }
  
  public static File a(Context paramContext, String paramString)
  {
    return paramContext.getExternalFilesDir(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/content/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */