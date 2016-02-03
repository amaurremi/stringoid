package com.bluebird.mobile.tools.cache;

import android.os.AsyncTask;
import android.util.Log;

public class LoadBitmapsAsyncTask
  extends AsyncTask<String, Void, Void>
{
  private BitmapCache bitmapCache;
  
  public LoadBitmapsAsyncTask(BitmapCache paramBitmapCache)
  {
    this.bitmapCache = paramBitmapCache;
  }
  
  protected Void doInBackground(String... paramVarArgs)
  {
    Log.d("LoadBitmapsAsyncTask", "Will load bitmaps into cache");
    long l1 = System.currentTimeMillis();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      Log.d("LoadBitmapsAsyncTask", "Loading: " + str);
      this.bitmapCache.getBitmap(str);
      i += 1;
    }
    long l2 = System.currentTimeMillis();
    Log.d("LoadBitmapsAsyncTask", "Bitmaps Loaded. Milliseconds: " + (l2 - l1));
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/cache/LoadBitmapsAsyncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */