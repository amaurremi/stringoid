package com.mobisystems.mobiscanner.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.model.DocumentModel;

public class a
  extends e
{
  private final c mLog = new c(this);
  
  public a(Context paramContext, FragmentManager paramFragmentManager)
  {
    super(paramContext);
  }
  
  private String d(long paramLong1, long paramLong2)
  {
    return String.valueOf(paramLong1) + "_" + String.valueOf(paramLong2);
  }
  
  private long dM(String paramString)
  {
    return Long.parseLong(paramString.substring(0, paramString.indexOf('_')));
  }
  
  public void a(long paramLong1, long paramLong2, View paramView)
  {
    a(d(paramLong1, paramLong2), paramView);
  }
  
  protected BitmapDrawable h(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject3 = null;
    this.mLog.dl("loadBitmap called for image: " + paramString);
    if (this.aHM != null) {}
    for (Object localObject1 = this.aHM.dP(paramString);; localObject1 = null)
    {
      Object localObject2 = localObject1;
      Image localImage;
      if (localObject1 == null)
      {
        long l = dM(paramString);
        localImage = new DocumentModel().ao(l);
        localObject2 = localObject1;
        if (localImage != null) {
          if (this.aHM == null) {
            break label160;
          }
        }
      }
      label160:
      for (localObject1 = this.aHM.Ig();; localObject1 = null)
      {
        localObject2 = localImage.a(paramInt1, paramInt2, (k)localObject1, Image.RestrictMemory.aHw);
        localObject1 = localObject3;
        if (localObject2 != null)
        {
          localObject2 = e((Bitmap)localObject2);
          localObject1 = localObject2;
          if (this.aHM != null)
          {
            this.aHM.a(paramString, (BitmapDrawable)localObject2);
            localObject1 = localObject2;
          }
        }
        return (BitmapDrawable)localObject1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/image/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */