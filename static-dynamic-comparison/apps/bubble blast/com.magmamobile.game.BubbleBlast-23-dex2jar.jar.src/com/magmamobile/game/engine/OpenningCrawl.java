package com.magmamobile.game.engine;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.nio.IntBuffer;

public class OpenningCrawl
  extends GameObject
{
  private static boolean _done;
  private static final Rect bnds = new Rect();
  private static float cos_vx;
  private static float dist;
  private static int height;
  private static Bitmap img;
  private static int[] pixels;
  private static float scroll_offset;
  private static float scroll_speed;
  private static float sin_vx;
  private static int textheight;
  private static int[] textpixels;
  private static int textwidth;
  private static float vx;
  private static int width;
  private static float zoom;
  
  public OpenningCrawl(String paramString, int paramInt)
  {
    width = Game.mBufferWidth;
    height = Game.mBufferHeight;
    _done = false;
    zoom = 100.0F;
    vx = 1.3F;
    scroll_speed = 0.5F;
    cos_vx = (float)Math.cos(vx);
    sin_vx = (float)Math.sin(vx);
    paramString = createTextImage();
    textwidth = paramString.getWidth();
    textheight = paramString.getHeight();
    IntBuffer localIntBuffer = IntBuffer.allocate(textwidth * textheight);
    paramString.copyPixelsToBuffer(localIntBuffer);
    textpixels = localIntBuffer.array();
    paramString.recycle();
    localIntBuffer.clear();
    dist = (cos_vx * zoom + (height - height / 4) * sin_vx) * (textwidth / 2) / (width / 2 * cos_vx);
    scroll_offset = -(height - height / 4.0F) * (dist / (cos_vx * zoom + (height - height / 4.0F) * sin_vx));
    pixels = new int[width * height];
    img = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
  }
  
  private static final Bitmap createTextImage()
  {
    Paint localPaint = new Paint();
    localPaint.setFakeBoldText(true);
    localPaint.setColor(-16711708);
    localPaint.setAntiAlias(true);
    localPaint.setFilterBitmap(true);
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "It is a period of civil war";
    arrayOfString[1] = "Rebel spaceship, striking";
    arrayOfString[2] = "from a hidden base, has won";
    arrayOfString[3] = "trop de ouai";
    arrayOfString[4] = "c'est cool.";
    arrayOfString[5] = "ça marche bien mais aussi i";
    int i = 0;
    int k = 0;
    int[] arrayOfInt = new int[6];
    int j = 0;
    Bitmap localBitmap;
    Canvas localCanvas;
    if (j >= 6)
    {
      localBitmap = Bitmap.createBitmap(i, k, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      j = 0;
    }
    for (;;)
    {
      if (j >= 6)
      {
        return localBitmap;
        localPaint.getTextBounds(arrayOfString[j], 0, arrayOfString[j].length(), bnds);
        int n = bnds.right - bnds.left;
        int i1 = bnds.bottom;
        int i2 = bnds.top;
        int m = i;
        if (n > i) {
          m = n;
        }
        arrayOfInt[j] = (k - bnds.top);
        k += i1 - i2;
        j += 1;
        i = m;
        break;
      }
      drawJustifyText(localCanvas, localPaint, i, arrayOfInt[j], arrayOfString[j]);
      j += 1;
    }
  }
  
  private static final void drawJustifyText(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, String paramString)
  {
    if (paramString.endsWith("."))
    {
      paramCanvas.drawText(paramString, 0.0F, paramInt2, paramPaint);
      return;
    }
    paramString = paramString.split(" ");
    int k = paramString.length;
    int[] arrayOfInt = new int[k];
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (j >= k)
      {
        j = 0;
        int m = (paramInt1 - i - 8) / (k - 1);
        paramInt1 = 0;
        i = j;
        while (paramInt1 < k)
        {
          paramCanvas.drawText(paramString[paramInt1], i, paramInt2, paramPaint);
          i += arrayOfInt[paramInt1] + m;
          paramInt1 += 1;
        }
        break;
      }
      paramPaint.getTextBounds(paramString[j], 0, paramString[j].length(), bnds);
      arrayOfInt[j] = (bnds.right - bnds.left);
      i += arrayOfInt[j];
      j += 1;
    }
  }
  
  private static final boolean next_scrollimage()
  {
    int i = (int)(-cos_vx * zoom / sin_vx) + height / 4;
    if (i < 0) {
      i = 0;
    }
    int m;
    for (;;)
    {
      m = i;
      if (m < height) {
        break;
      }
      scroll_offset += scroll_speed;
      return false;
      i += 1;
    }
    float f = dist / (cos_vx * zoom + (m - height / 4) * sin_vx);
    int i3 = (int)(scroll_offset + (m - height / 4) * f);
    if (i3 >= textheight) {
      return true;
    }
    int j;
    int k;
    int i4;
    int i5;
    int n;
    int i6;
    int i7;
    int i1;
    if ((i3 >= 0) && (i3 < textheight))
    {
      j = (int)((height - 1 - height / 4) * f);
      k = (int)((i - height / 4) * f);
      i4 = (int)(((m - height / 4) * f - k) * 255.0F / (j - k));
      j = (int)(1048576.0F * (textwidth / 2 + -width / 2 * cos_vx * f));
      k = j;
      if (j < 0) {
        k = 0;
      }
      i5 = (int)(cos_vx * f * 1048576.0F);
      n = (int)(-textwidth / 2 / (cos_vx * f)) + width / 2;
      j = n;
      if (n < 0) {
        j = 0;
      }
      i6 = width;
      i7 = textwidth;
      i1 = width;
      n = j;
      int i2 = j + i1 * m;
      i1 = k;
      k = i2;
    }
    for (;;)
    {
      if (n >= i6 - j)
      {
        m += 1;
        break;
      }
      pixels[k] = (textpixels[((i1 >> 20) + i3 * i7)] & -16777216 + 65792 * i4);
      i1 += i5;
      n += 1;
      k += 1;
    }
  }
  
  public boolean isDone()
  {
    return _done;
  }
  
  public void onAction()
  {
    _done = next_scrollimage();
  }
  
  public void onRender()
  {
    img.setPixels(pixels, 0, width, 0, 0, width, height);
    Game.drawBitmap(img, 0, 0, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/OpenningCrawl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */