package com.bfs.papertoss.cpp;

import com.bfs.papertoss.platform.Globals;
import com.bfs.papertoss.platform.Util;
import com.bfs.papertoss.vector.v2f;
import com.bfs.papertoss.vector.v2i;
import com.bfs.papertoss.vector.v3f;
import com.bfs.papertoss.vector.v4f;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Sprite
{
  private static final v4f DEFAULT_COLOR = new v4f(1.0F, 1.0F, 1.0F, 1.0F);
  private static final v3f DEFAULT_ROT;
  private static final v2f DEFAULT_SCALE = new v2f(1.0F, 1.0F);
  FloatBuffer[] m_buffers = null;
  int m_current_frame;
  float m_duration;
  float m_elapsed;
  int m_frame_count;
  v2f m_frame_size = new v2f();
  v2f m_scroll = new v2f();
  Texture m_texture = null;
  boolean m_tile;
  
  static
  {
    DEFAULT_ROT = new v3f(0.0F, 0.0F, 0.0F);
  }
  
  Sprite(int paramInt1, int paramInt2, String paramString1, String paramString2, v4f paramv4f, int paramInt3)
  {
    this.m_texture = null;
    this.m_frame_count = 0;
    this.m_frame_size = new v2f(0.0F, 0.0F);
    this.m_current_frame = 0;
    this.m_duration = 0.0F;
    this.m_elapsed = 0.0F;
    this.m_scroll = new v2f(0.0F, 0.0F);
    this.m_tile = false;
    float f1 = paramInt1 / Globals.SCALE_FACTOR;
    this.m_texture = Globals.texture_mgr.getText(paramString2, paramString1, paramInt2, (int)(f1 + 0.5F), paramv4f, paramInt3, (paramv4f.x + paramv4f.y + paramv4f.z) / 3.0F);
    paramString1 = this.m_texture.size();
    paramString2 = this.m_texture.potSize();
    f1 = paramString1.y / paramString2.y;
    float f2 = paramString1.x / paramString2.x;
    this.m_frame_size = new v2f(paramString1.x, paramString1.y);
    this.m_frame_count = 1;
    this.m_buffers = new FloatBuffer[1];
    this.m_buffers[0] = Util.getFloatBufferFromFloatArray(new float[] { 0.0F, 0.0F, f2, 0.0F, f2, f1, 0.0F, f1 });
    this.m_frame_size.timesEquals(Globals.SCALE_FACTOR);
  }
  
  public Sprite(String paramString)
  {
    constructor(paramString, new v2i(0, 0), 0.0F, false, 0);
  }
  
  public Sprite(String paramString, v2i paramv2i)
  {
    constructor(paramString, paramv2i, 0.0F, false, 0);
  }
  
  public Sprite(String paramString, v2i paramv2i, float paramFloat)
  {
    constructor(paramString, paramv2i, paramFloat, false, 0);
  }
  
  public Sprite(String paramString, v2i paramv2i, float paramFloat, boolean paramBoolean, int paramInt)
  {
    constructor(paramString, paramv2i, paramFloat, paramBoolean, paramInt);
  }
  
  private void constructor(String paramString, v2i paramv2i, float paramFloat, boolean paramBoolean, int paramInt)
  {
    this.m_texture = null;
    this.m_frame_count = 0;
    this.m_frame_size = new v2f(0.0F, 0.0F);
    this.m_current_frame = 0;
    if (paramBoolean) {
      paramFloat = 0.0F;
    }
    this.m_duration = paramFloat;
    this.m_elapsed = 0.0F;
    this.m_scroll = new v2f(0.0F, 0.0F);
    this.m_tile = paramBoolean;
    this.m_texture = Globals.texture_mgr.get(paramString);
    v2i localv2i1 = this.m_texture.size();
    v2i localv2i2 = this.m_texture.potSize();
    int j;
    int k;
    int i;
    if (paramv2i.equalsZero())
    {
      paramString = new v2f(localv2i1.x, localv2i1.y);
      this.m_frame_size = paramString;
      j = Math.max(localv2i1.x / (int)this.m_frame_size.x, 1);
      k = Math.max(localv2i1.y / (int)this.m_frame_size.y, 1);
      if (!this.m_tile) {
        break label385;
      }
      i = 1;
    }
    for (;;)
    {
      this.m_frame_count = i;
      this.m_buffers = new FloatBuffer[this.m_frame_count];
      paramInt = 0;
      while (paramInt < this.m_frame_count)
      {
        i = paramInt / j;
        k = paramInt % j;
        paramFloat = k * this.m_frame_size.x / localv2i2.x;
        float f1 = (k + 1) * this.m_frame_size.x / localv2i2.x;
        float f2 = i * this.m_frame_size.y / localv2i2.y;
        float f3 = (i + 1) * this.m_frame_size.y / localv2i2.y;
        this.m_buffers[paramInt] = Util.getFloatBufferFromFloatArray(new float[] { paramFloat, f3, f1, f3, f1, f2, paramFloat, f2 });
        paramInt += 1;
      }
      paramString = new v2f(paramv2i.x, paramv2i.y);
      break;
      label385:
      i = paramInt;
      if (paramInt <= 0) {
        i = j * k;
      }
    }
    this.m_frame_size.timesEquals(Globals.SCALE_FACTOR);
  }
  
  public static void killSprite(Sprite paramSprite)
  {
    if (paramSprite != null) {
      paramSprite.delete();
    }
  }
  
  public static boolean pointInRect(v2f paramv2f1, v2f paramv2f2, v2f paramv2f3)
  {
    paramv2f2 = new v2f(paramv2f2.x, paramv2f2.y);
    v2f localv2f = new v2f(paramv2f3.x * 0.5F, paramv2f3.y * 0.5F);
    paramv2f3 = paramv2f2.minus(localv2f);
    paramv2f2 = paramv2f2.plus(localv2f);
    return (paramv2f1.x >= paramv2f3.x) && (paramv2f1.x <= paramv2f2.x) && (paramv2f1.y >= paramv2f3.y) && (paramv2f1.y <= paramv2f2.y);
  }
  
  public boolean checkPoint(v3f paramv3f, v2f paramv2f, float paramFloat)
  {
    if (this.m_texture.m_text_size != null) {}
    for (v2f localv2f = new v2f(this.m_texture.m_text_size.x, this.m_texture.m_text_size.y);; localv2f = this.m_frame_size)
    {
      localv2f = new v2f(localv2f.x / 2.0F * paramFloat, localv2f.y / 2.0F * paramFloat);
      paramv3f = new v4f(paramv3f.x - localv2f.x, paramv3f.y - localv2f.y, paramv3f.x + localv2f.x, paramv3f.y + localv2f.y);
      if ((paramv2f.x < paramv3f.x) || (paramv2f.x > paramv3f.z) || (paramv2f.y < paramv3f.y) || (paramv2f.y > paramv3f.w)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void delete()
  {
    Globals.texture_mgr.release(this.m_texture);
  }
  
  void draw(v3f paramv3f)
  {
    draw(paramv3f, DEFAULT_SCALE, DEFAULT_ROT, DEFAULT_COLOR);
  }
  
  void draw(v3f paramv3f1, v2f paramv2f, v3f paramv3f2, v4f paramv4f)
  {
    if (this.m_frame_count == 0) {
      return;
    }
    if (this.m_duration > 0.0F) {
      this.m_current_frame = Math.min((int)(this.m_elapsed / this.m_duration * this.m_frame_count), this.m_frame_count - 1);
    }
    Globals.GL.glPushMatrix();
    Globals.GL.glTranslatef(paramv3f1.x, paramv3f1.y, -paramv3f1.z);
    if (paramv3f2.z != 0.0F) {
      Globals.GL.glRotatef(paramv3f2.z, 0.0F, 0.0F, 1.0F);
    }
    if (paramv3f2.y != 0.0F) {
      Globals.GL.glRotatef(paramv3f2.y, 0.0F, 1.0F, 0.0F);
    }
    if (paramv3f2.x != 0.0F) {
      Globals.GL.glRotatef(paramv3f2.x, 1.0F, 0.0F, 0.0F);
    }
    float f1 = this.m_frame_size.x;
    float f2 = paramv2f.x;
    float f3 = this.m_frame_size.y;
    float f4 = paramv2f.y;
    Globals.GL.glScalef(f1 * f2, f3 * f4, 1.0F);
    Globals.GL.glColor4f(paramv4f.x, paramv4f.y, paramv4f.z, paramv4f.w);
    Globals.GL.glBindTexture(3553, this.m_texture.id());
    Globals.GL.glTexCoordPointer(2, 5126, 0, this.m_buffers[this.m_current_frame]);
    Globals.GL.glDrawArrays(6, 0, 4);
    Globals.GL.glPopMatrix();
  }
  
  public v2i frameSize()
  {
    return new v2i((int)this.m_frame_size.x, (int)this.m_frame_size.y);
  }
  
  void setFrame(int paramInt)
  {
    this.m_current_frame = Math.max(Math.min(paramInt, this.m_frame_count - 1), 0);
    this.m_elapsed = (this.m_current_frame / this.m_frame_count * this.m_duration);
  }
  
  void setScroll(v2f paramv2f)
  {
    if (this.m_frame_count == 1)
    {
      this.m_scroll = paramv2f;
      this.m_duration = 0.0F;
    }
  }
  
  boolean update(float paramFloat)
  {
    if (this.m_duration > 0.0F)
    {
      this.m_elapsed += paramFloat;
      if (this.m_elapsed >= this.m_duration)
      {
        this.m_elapsed %= this.m_duration;
        return true;
      }
    }
    else if (this.m_scroll.equalsZero()) {}
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/cpp/Sprite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */