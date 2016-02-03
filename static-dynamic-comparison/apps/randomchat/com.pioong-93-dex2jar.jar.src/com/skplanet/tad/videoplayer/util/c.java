package com.skplanet.tad.videoplayer.util;

import android.content.Context;
import android.widget.Toast;

public class c
{
  public static int a(int paramInt)
  {
    int i = (int)(256.0D * (paramInt / 100.0D) - 1.0D);
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Toast.makeText(paramContext, paramString, 0).show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/videoplayer/util/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */