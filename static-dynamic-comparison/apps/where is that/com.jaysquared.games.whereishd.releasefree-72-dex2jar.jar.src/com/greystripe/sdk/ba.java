package com.greystripe.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

final class ba
  implements Runnable
{
  ba(GSFullscreenActivity paramGSFullscreenActivity, Bitmap paramBitmap) {}
  
  public final void run()
  {
    Object localObject = GSFullscreenActivity.b(this.b).getRootView();
    bd.b("v1 width " + ((View)localObject).getWidth() + " h " + ((View)localObject).getHeight(), new Object[0]);
    Bitmap localBitmap1 = Bitmap.createBitmap(((View)localObject).getWidth(), ((View)localObject).getHeight(), Bitmap.Config.ARGB_8888);
    ((View)localObject).draw(new Canvas(localBitmap1));
    bd.b("pagebmp: w " + localBitmap1.getWidth() + " h " + localBitmap1.getHeight(), new Object[0]);
    ((View)localObject).setDrawingCacheEnabled(true);
    localBitmap1 = ((View)localObject).getDrawingCache();
    if (localBitmap1 == null) {
      bd.b("wth screencache is null", new Object[0]);
    }
    localBitmap1 = Bitmap.createBitmap(localBitmap1);
    ((View)localObject).setDrawingCacheEnabled(false);
    bd.b("screenshot w " + localBitmap1.getWidth() + " h " + localBitmap1.getHeight(), new Object[0]);
    localObject = new DisplayMetrics();
    this.b.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = ((DisplayMetrics)localObject).heightPixels;
    int j = ((DisplayMetrics)localObject).widthPixels;
    bd.b("screen w " + j + " h " + i, new Object[0]);
    localObject = Bitmap.createScaledBitmap(this.a, localBitmap1.getWidth(), localBitmap1.getHeight(), true);
    if (((Bitmap)localObject).getWidth() > localBitmap1.getWidth())
    {
      i = ((Bitmap)localObject).getWidth();
      if (((Bitmap)localObject).getHeight() <= localBitmap1.getHeight()) {
        break label475;
      }
    }
    label475:
    for (j = ((Bitmap)localObject).getHeight();; j = localBitmap1.getHeight())
    {
      bd.b("composition: w " + i + " h " + j, new Object[0]);
      Bitmap localBitmap2 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap2);
      localCanvas.drawBitmap((Bitmap)localObject, new Matrix(), null);
      localCanvas.drawBitmap(localBitmap1, new Matrix(), null);
      if (MediaStore.Images.Media.insertImage(this.b.getContentResolver(), localBitmap2, "", "") != null)
      {
        this.b.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
        GSFullscreenActivity.c(this.b).f();
      }
      return;
      i = localBitmap1.getWidth();
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */