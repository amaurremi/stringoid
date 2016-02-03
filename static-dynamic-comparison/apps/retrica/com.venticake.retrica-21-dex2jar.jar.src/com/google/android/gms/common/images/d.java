package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import com.google.android.gms.internal.hq;
import com.google.android.gms.internal.ip;

final class d
  extends hq<i, Bitmap>
{
  public d(Context paramContext)
  {
    super(a(paramContext));
  }
  
  private static int a(Context paramContext)
  {
    ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
    if ((paramContext.getApplicationInfo().flags & 0x100000) != 0)
    {
      i = 1;
      if ((i == 0) || (!ip.gc())) {
        break label55;
      }
    }
    label55:
    for (int i = c.a(localActivityManager);; i = localActivityManager.getMemoryClass())
    {
      return (int)(i * 1048576 * 0.33F);
      i = 0;
      break;
    }
  }
  
  protected int a(i parami, Bitmap paramBitmap)
  {
    return paramBitmap.getHeight() * paramBitmap.getRowBytes();
  }
  
  protected void a(boolean paramBoolean, i parami, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    super.entryRemoved(paramBoolean, parami, paramBitmap1, paramBitmap2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/images/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */