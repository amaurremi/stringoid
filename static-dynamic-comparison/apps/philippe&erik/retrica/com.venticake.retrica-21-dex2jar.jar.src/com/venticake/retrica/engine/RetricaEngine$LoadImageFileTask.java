package com.venticake.retrica.engine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import java.io.File;

class RetricaEngine$LoadImageFileTask
  extends RetricaEngine.LoadImageTask
{
  private final File mImageFile;
  
  public RetricaEngine$LoadImageFileTask(RetricaEngine paramRetricaEngine1, RetricaEngine paramRetricaEngine2, File paramFile)
  {
    super(paramRetricaEngine1, paramRetricaEngine2);
    this.mImageFile = paramFile;
  }
  
  protected Bitmap decode(BitmapFactory.Options paramOptions)
  {
    return BitmapFactory.decodeFile(this.mImageFile.getAbsolutePath(), paramOptions);
  }
  
  protected int getImageOrientation()
  {
    switch (new ExifInterface(this.mImageFile.getAbsolutePath()).getAttributeInt("Orientation", 1))
    {
    case 1: 
    case 2: 
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 6: 
      return 90;
    case 3: 
      return 180;
    }
    return 270;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/engine/RetricaEngine$LoadImageFileTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */