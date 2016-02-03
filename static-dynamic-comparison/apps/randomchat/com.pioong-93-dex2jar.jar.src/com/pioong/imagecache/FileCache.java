package com.pioong.imagecache;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class FileCache
{
  private File cacheDir;
  
  public FileCache(Context paramContext)
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (this.cacheDir = new File(Environment.getExternalStorageDirectory(), "TTImages_cache");; this.cacheDir = paramContext.getCacheDir())
    {
      if (!this.cacheDir.exists()) {
        this.cacheDir.mkdirs();
      }
      return;
    }
  }
  
  public void clear()
  {
    File[] arrayOfFile = this.cacheDir.listFiles();
    if (arrayOfFile == null) {}
    for (;;)
    {
      return;
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
  }
  
  public File getFile(String paramString)
  {
    int i = paramString.hashCode();
    return new File(this.cacheDir, String.valueOf(i));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/imagecache/FileCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */