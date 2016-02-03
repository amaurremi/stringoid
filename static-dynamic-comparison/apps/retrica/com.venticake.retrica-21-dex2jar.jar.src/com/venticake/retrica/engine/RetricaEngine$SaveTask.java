package com.venticake.retrica.engine;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

class RetricaEngine$SaveTask
  extends AsyncTask<Void, Void, Void>
{
  private final Bitmap mBitmap;
  private final String mFileName;
  private final String mFolderName;
  private final Handler mHandler;
  private final RetricaEngine.OnPictureSavedListener mListener;
  
  public RetricaEngine$SaveTask(RetricaEngine paramRetricaEngine, Bitmap paramBitmap, String paramString1, String paramString2, RetricaEngine.OnPictureSavedListener paramOnPictureSavedListener)
  {
    this.mBitmap = paramBitmap;
    this.mFolderName = paramString1;
    this.mFileName = paramString2;
    this.mListener = paramOnPictureSavedListener;
    this.mHandler = new Handler();
  }
  
  private void saveImage(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    paramString2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), paramString1 + "/" + paramString2);
    try
    {
      paramString2.getParentFile().mkdirs();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(paramString2));
      paramString1 = RetricaEngine.access$0(this.this$0);
      paramString2 = paramString2.toString();
      paramBitmap = new MediaScannerConnection.OnScanCompletedListener()
      {
        public void onScanCompleted(String paramAnonymousString, final Uri paramAnonymousUri)
        {
          if (RetricaEngine.SaveTask.this.mListener != null) {
            RetricaEngine.SaveTask.this.mHandler.post(new Runnable()
            {
              public void run()
              {
                RetricaEngine.SaveTask.this.mListener.onPictureSaved(paramAnonymousUri);
              }
            });
          }
        }
      };
      MediaScannerConnection.scanFile(paramString1, new String[] { paramString2 }, null, paramBitmap);
      return;
    }
    catch (FileNotFoundException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = this.this$0.getBitmapWithFilterApplied(this.mBitmap, false);
    saveImage(this.mFolderName, this.mFileName, paramVarArgs);
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/engine/RetricaEngine$SaveTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */