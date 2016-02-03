package com.venticake.retrica.engine.a;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import com.venticake.retrica.engine.RetricaRenderer;
import com.venticake.retrica.engine.Rotation;
import com.venticake.retrica.engine.TextureRotationUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class i
  extends f
{
  public final float a = 1.7F;
  private final d b = new d(1.7F, 0);
  private final d g;
  private final j h;
  private final List<f> i = new ArrayList();
  private int[] j;
  private int[] k;
  private final FloatBuffer l;
  private final FloatBuffer m;
  private final FloatBuffer n;
  private float o = 0.5F;
  private float p = 0.5F;
  private float q = 0.3F;
  private Handler r = null;
  private long s = 0L;
  
  public i()
  {
    this.i.add(this.b);
    this.g = new d(1.7F, 1);
    this.i.add(this.g);
    this.h = new j();
    this.i.add(this.h);
    this.l = ByteBuffer.allocateDirect(RetricaRenderer.CUBE.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.l.put(RetricaRenderer.CUBE).position(0);
    this.m = ByteBuffer.allocateDirect(TextureRotationUtil.TEXTURE_NO_ROTATION.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.m.put(TextureRotationUtil.TEXTURE_NO_ROTATION).position(0);
    float[] arrayOfFloat = TextureRotationUtil.getRotation(Rotation.NORMAL, false, true);
    this.n = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.n.put(arrayOfFloat).position(0);
  }
  
  private void q()
  {
    if (this.k != null)
    {
      GLES20.glDeleteTextures(this.k.length, this.k, 0);
      this.k = null;
    }
    if (this.j != null)
    {
      GLES20.glDeleteFramebuffers(this.j.length, this.j, 0);
      this.j = null;
    }
  }
  
  private void r()
  {
    if (this.s < 0L) {
      return;
    }
    this.s -= 100L;
    if (this.s < 0L) {
      this.s = 0L;
    }
    b(100L);
  }
  
  public void a()
  {
    if (this.r != null) {
      this.r.removeCallbacksAndMessages(null);
    }
    this.h.d(1.0F);
  }
  
  public void a(float paramFloat)
  {
    this.q = paramFloat;
    this.h.a(paramFloat);
    this.h.b(0.625F * paramFloat);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.o = paramFloat1;
    this.p = paramFloat2;
    this.h.a(paramFloat1, paramFloat2);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (this.j != null) {
      q();
    }
    this.j = new int[this.i.size() - 1];
    this.k = new int[this.i.size() - 1];
    int i1 = 0;
    for (;;)
    {
      if (i1 >= this.i.size() - 1)
      {
        ((f)this.i.get(this.i.size() - 1)).a(paramInt1, paramInt2);
        return;
      }
      ((f)this.i.get(i1)).a(paramInt1, paramInt2);
      GLES20.glGenFramebuffers(1, this.j, i1);
      GLES20.glGenTextures(1, this.k, i1);
      GLES20.glBindTexture(3553, this.k[i1]);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glBindFramebuffer(36160, this.j[i1]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.k[i1], 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindFramebuffer(36160, 0);
      i1 += 1;
    }
  }
  
  @SuppressLint({"WrongCall"})
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    k();
    if ((!l()) || (this.j == null) || (this.k == null)) {
      return;
    }
    int i1 = 0;
    int i2 = paramInt;
    f localf;
    for (;;)
    {
      if (i1 >= this.i.size() - 1)
      {
        this.h.a(paramInt, i2, paramFloatBuffer1, paramFloatBuffer2, this.m);
        return;
      }
      localf = (f)this.i.get(i1);
      GLES20.glBindFramebuffer(36160, this.j[i1]);
      if (i1 != 0) {
        break;
      }
      localf.a(i2, this.l, paramFloatBuffer2);
      GLES20.glBindFramebuffer(36160, 0);
      i2 = this.k[i1];
      i1 += 1;
    }
    FloatBuffer localFloatBuffer2 = this.l;
    if ((i1 == 0) && (this.i.size() % 2 == 0)) {}
    for (FloatBuffer localFloatBuffer1 = this.n;; localFloatBuffer1 = this.m)
    {
      localf.a(i2, localFloatBuffer2, localFloatBuffer1);
      break;
    }
  }
  
  public void a(long paramLong)
  {
    if (this.h.a() > 0.0F)
    {
      this.s = paramLong;
      r();
      return;
    }
    this.s = 0L;
  }
  
  public void a(long paramLong1, final long paramLong2)
  {
    if (this.r != null) {
      this.r.removeCallbacksAndMessages(null);
    }
    if (this.r == null) {
      this.r = new Handler(Looper.getMainLooper());
    }
    this.r.postDelayed(new Runnable()
    {
      public void run()
      {
        i.this.a(paramLong2);
      }
    }, paramLong1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.h.a(paramBoolean);
  }
  
  public void b()
  {
    a(250L, 500L);
  }
  
  public void b(final long paramLong)
  {
    if (this.r == null) {
      this.r = new Handler(Looper.getMainLooper());
    }
    this.r.postDelayed(new Runnable()
    {
      public void run()
      {
        if (i.a(i.this).e(0.1F) > 0.0F) {
          i.this.b(paramLong);
        }
      }
    }, paramLong);
  }
  
  public void c()
  {
    super.c();
    Iterator localIterator = this.i.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        a(this.o, this.p);
        a(this.q);
        return;
      }
      ((f)localIterator.next()).f();
    }
  }
  
  public void i()
  {
    q();
    Iterator localIterator = this.i.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        super.i();
        return;
      }
      ((f)localIterator.next()).h();
    }
  }
  
  public void p()
  {
    a();
    b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/engine/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */