package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class LoaderManager
{
  public static void enableDebugLogging(boolean paramBoolean)
  {
    LoaderManagerImpl.DEBUG = paramBoolean;
  }
  
  public abstract void destroyLoader(int paramInt);
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract <D> h<D> getLoader(int paramInt);
  
  public boolean hasRunningLoaders()
  {
    return false;
  }
  
  public abstract <D> h<D> initLoader(int paramInt, Bundle paramBundle, LoaderCallbacks<D> paramLoaderCallbacks);
  
  public abstract <D> h<D> restartLoader(int paramInt, Bundle paramBundle, LoaderCallbacks<D> paramLoaderCallbacks);
  
  public static abstract interface LoaderCallbacks<D>
  {
    public abstract h<D> onCreateLoader(int paramInt, Bundle paramBundle);
    
    public abstract void onLoadFinished(h<D> paramh, D paramD);
    
    public abstract void onLoaderReset(h<D> paramh);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/app/LoaderManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */