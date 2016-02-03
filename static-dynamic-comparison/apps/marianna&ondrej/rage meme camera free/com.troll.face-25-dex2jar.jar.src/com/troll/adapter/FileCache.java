package com.troll.adapter;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class FileCache
{
  private File cacheDir;
  
  public FileCache(Context paramContext)
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (this.cacheDir = new File(Environment.getExternalStorageDirectory(), "LazyList");; this.cacheDir = paramContext.getCacheDir())
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
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      arrayOfFile[i].delete();
      i += 1;
    }
  }
  
  public File getFile(String paramString)
  {
    int i = paramString.hashCode();
    return new File(this.cacheDir, String.valueOf(i));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/troll/adapter/FileCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */