package com.google.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public abstract class aj
  implements ai
{
  protected MotionEvent a = null;
  protected DisplayMetrics b = null;
  private au c = null;
  private ByteArrayOutputStream d = null;
  
  protected aj(Context paramContext)
  {
    try
    {
      this.b = paramContext.getResources().getDisplayMetrics();
      return;
    }
    catch (UnsupportedOperationException paramContext)
    {
      this.b = new DisplayMetrics();
      this.b.density = 1.0F;
    }
  }
  
  private String a(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      a();
      if (paramBoolean) {
        c(paramContext);
      }
      for (;;)
      {
        paramContext = b();
        if (paramContext.length != 0) {
          break;
        }
        return Integer.toString(5);
        b(paramContext);
      }
      return Integer.toString(3);
    }
    catch (NoSuchAlgorithmException paramContext)
    {
      return Integer.toString(7);
      paramContext = a(paramContext, paramString);
      return paramContext;
    }
    catch (UnsupportedEncodingException paramContext)
    {
      return Integer.toString(7);
    }
    catch (IOException paramContext) {}
  }
  
  private void a()
  {
    this.d = new ByteArrayOutputStream();
    this.c = au.a(this.d);
  }
  
  private byte[] b()
    throws IOException
  {
    this.c.a();
    return this.d.toByteArray();
  }
  
  public String a(Context paramContext)
  {
    return a(paramContext, null, false);
  }
  
  public String a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, true);
  }
  
  String a(byte[] paramArrayOfByte, String paramString)
    throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException
  {
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte.length > 239)
    {
      a();
      a(20, 1L);
      localObject = b();
    }
    if (localObject.length < 239)
    {
      paramArrayOfByte = new byte[239 - localObject.length];
      new SecureRandom().nextBytes(paramArrayOfByte);
    }
    for (paramArrayOfByte = ByteBuffer.allocate(240).put((byte)localObject.length).put((byte[])localObject).put(paramArrayOfByte).array();; paramArrayOfByte = ByteBuffer.allocate(240).put((byte)localObject.length).put((byte[])localObject).array())
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      localObject = ((MessageDigest)localObject).digest();
      paramArrayOfByte = ByteBuffer.allocate(256).put((byte[])localObject).put(paramArrayOfByte).array();
      localObject = new byte['Ā'];
      new ag().a(paramArrayOfByte, (byte[])localObject);
      if ((paramString != null) && (paramString.length() > 0)) {
        a(paramString, (byte[])localObject);
      }
      return aq.a((byte[])localObject, false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a != null) {
      this.a.recycle();
    }
    this.a = MotionEvent.obtain(0L, paramInt3, 1, paramInt1 * this.b.density, paramInt2 * this.b.density, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
  }
  
  protected void a(int paramInt, long paramLong)
    throws IOException
  {
    this.c.a(paramInt, paramLong);
  }
  
  protected void a(int paramInt, String paramString)
    throws IOException
  {
    this.c.a(paramInt, paramString);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if (this.a != null) {
        this.a.recycle();
      }
      this.a = MotionEvent.obtain(paramMotionEvent);
    }
  }
  
  void a(String paramString, byte[] paramArrayOfByte)
    throws UnsupportedEncodingException
  {
    String str = paramString;
    if (paramString.length() > 32) {
      str = paramString.substring(0, 32);
    }
    new ar(str.getBytes("UTF-8")).a(paramArrayOfByte);
  }
  
  protected abstract void b(Context paramContext);
  
  protected abstract void c(Context paramContext);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/ads/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */