package com.bfs.papertoss.cpp;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.opengl.GLUtils;
import android.util.Log;
import com.bfs.papertoss.PaperTossActivity;
import com.bfs.papertoss.platform.Globals;
import com.bfs.papertoss.platform.Util;
import com.bfs.papertoss.vector.v2i;
import com.bfs.papertoss.vector.v4f;
import java.io.IOException;
import javax.microedition.khronos.opengles.GL10;

public class Texture
{
  int m_components;
  public int m_id;
  public String m_name;
  v2i m_pot_size;
  v2i m_size;
  public v2i m_text_size;
  
  public Texture(Bitmap paramBitmap, int paramInt, v2i paramv2i1, v2i paramv2i2)
  {
    this.m_id = 0;
    this.m_components = 4;
    this.m_size = new v2i(paramBitmap.getWidth(), paramBitmap.getHeight());
    this.m_pot_size = this.m_size;
    create(paramBitmap, paramInt, paramv2i1, paramv2i2);
  }
  
  public Texture(String paramString)
  {
    this.m_id = 0;
    this.m_components = 4;
    new v2i(0, 0);
    v2i localv2i = null;
    String str = paramString;
    if (!paramString.contains("img"))
    {
      if (!Globals.HI_RES) {
        break label155;
      }
      str = "img_hi_res/" + paramString;
    }
    try
    {
      for (;;)
      {
        paramString = BitmapFactory.decodeStream(Globals.m_activity.getAssets().open(str));
        localv2i = new v2i(paramString.getWidth(), paramString.getHeight());
        int i = getComponents(paramString);
        if (paramString != null) {
          bool = true;
        }
        Util.ASSERT(bool);
        if (paramString != null)
        {
          paramString = Util.makePowerOfTwo(paramString);
          create(paramString, i, localv2i, new v2i(paramString.getWidth(), paramString.getHeight()));
          this.m_name = str;
        }
        return;
        label155:
        str = "img/" + paramString;
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.w("BFS", paramString);
        paramString = localv2i;
      }
    }
  }
  
  public Texture(String paramString1, String paramString2, int paramInt1, int paramInt2, v4f paramv4f, int paramInt3, float paramFloat)
  {
    this.m_components = 4;
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramInt2);
    localPaint.setARGB((int)(paramv4f.w * 255.0F), (int)(paramv4f.x * 255.0F), (int)(paramv4f.y * 255.0F), (int)(paramv4f.z * 255.0F));
    localPaint.setTextAlign(Paint.Align.CENTER);
    paramInt1 = (int)localPaint.measureText(paramString1);
    int i = Util.nextPowerOfTwo(Math.max(paramInt1, paramInt2));
    localPaint.setTypeface(Typeface.createFromAsset(Globals.m_activity.getAssets(), "fonts/" + paramString2 + ".ttf"));
    localPaint.setAntiAlias(true);
    if (paramInt3 > 0) {
      localPaint.setFakeBoldText(true);
    }
    paramString2 = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_4444);
    paramv4f = new Canvas(paramString2);
    paramv4f.scale(1.0F, -1.0F);
    paramv4f.drawText(paramString1, i / 2, -1.0F * (i / 2 - paramInt2 / 4), localPaint);
    this.m_pot_size = new v2i(paramString2.getWidth(), paramString2.getHeight());
    this.m_size = this.m_pot_size;
    this.m_text_size = new v2i(paramInt1, paramInt2);
    create(paramString2, this.m_components, this.m_size, this.m_pot_size);
    this.m_name = paramString1;
  }
  
  private int getComponents(Bitmap paramBitmap)
  {
    paramBitmap = paramBitmap.getConfig();
    switch (paramBitmap)
    {
    case ???: 
    case ???: 
    default: 
      return 4;
    case ???: 
      return 1;
    }
    return 3;
  }
  
  public int components()
  {
    return this.m_components;
  }
  
  public void create(Bitmap paramBitmap, int paramInt, v2i paramv2i1, v2i paramv2i2)
  {
    this.m_components = paramInt;
    this.m_size = paramv2i1;
    this.m_pot_size = paramv2i2;
    paramv2i1 = new int[1];
    paramv2i1[0] = this.m_id;
    Globals.GL.glGenTextures(1, paramv2i1, 0);
    this.m_id = paramv2i1[0];
    Globals.GL.glBindTexture(3553, this.m_id);
    if (this.m_components == 4) {
      if (this.m_components != 2) {
        break label178;
      }
    }
    label178:
    for (;;)
    {
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
      paramBitmap.recycle();
      Globals.GL.glTexParameterf(3553, 10241, 9729.0F);
      Globals.GL.glTexParameterf(3553, 10240, 9729.0F);
      Globals.GL.glTexParameterf(3553, 10242, 33071.0F);
      Globals.GL.glTexParameterf(3553, 10243, 33071.0F);
      Util.ASSERT(Util.checkGL());
      return;
      if (this.m_components == 1) {
        break;
      }
      break;
    }
  }
  
  public void delete()
  {
    if (this.m_id != 0)
    {
      int i = this.m_id;
      Globals.GL.glDeleteTextures(1, new int[] { i }, 0);
    }
  }
  
  public int id()
  {
    return this.m_id;
  }
  
  public v2i potSize()
  {
    return this.m_pot_size;
  }
  
  public v2i size()
  {
    return this.m_size;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/cpp/Texture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */