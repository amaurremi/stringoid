package com.venticake.retrica.engine;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import java.io.InputStream;
import java.net.URL;

class RetricaEngine$LoadImageUriTask
  extends RetricaEngine.LoadImageTask
{
  private final Uri mUri;
  
  public RetricaEngine$LoadImageUriTask(RetricaEngine paramRetricaEngine1, RetricaEngine paramRetricaEngine2, Uri paramUri)
  {
    super(paramRetricaEngine1, paramRetricaEngine2);
    this.mUri = paramUri;
  }
  
  protected Bitmap decode(BitmapFactory.Options paramOptions)
  {
    try
    {
      if ((this.mUri.getScheme().startsWith("http")) || (this.mUri.getScheme().startsWith("https"))) {}
      for (InputStream localInputStream = new URL(this.mUri.toString()).openStream();; localInputStream = RetricaEngine.access$0(this.this$0).getContentResolver().openInputStream(this.mUri)) {
        return BitmapFactory.decodeStream(localInputStream, null, paramOptions);
      }
      return null;
    }
    catch (Exception paramOptions)
    {
      paramOptions.printStackTrace();
    }
  }
  
  protected int getImageOrientation()
  {
    Cursor localCursor = RetricaEngine.access$0(this.this$0).getContentResolver().query(this.mUri, new String[] { "orientation" }, null, null, null);
    if ((localCursor == null) || (localCursor.getCount() != 1)) {
      return 0;
    }
    localCursor.moveToFirst();
    return localCursor.getInt(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/engine/RetricaEngine$LoadImageUriTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */