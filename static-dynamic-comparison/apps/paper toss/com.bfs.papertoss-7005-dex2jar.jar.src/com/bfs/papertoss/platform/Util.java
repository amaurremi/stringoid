package com.bfs.papertoss.platform;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import com.bfs.papertoss.PaperTossActivity;
import com.bfs.papertoss.vector.v4f;
import com.flurry.android.FlurryAgent;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import javax.microedition.khronos.opengles.GL10;

public class Util
{
  static int m_requires_pot = -1;
  static long start_time = ;
  
  public static void ASSERT(Object paramObject) {}
  
  public static void ASSERT(boolean paramBoolean) {}
  
  public static boolean checkGL()
  {
    return true;
  }
  
  public static float degrees(float paramFloat)
  {
    return 180.0F * paramFloat / 3.1415927F;
  }
  
  public static ByteBuffer getByteBufferFromByteArray(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramArrayOfByte.length);
    localByteBuffer.put(paramArrayOfByte);
    localByteBuffer.position(0);
    return localByteBuffer;
  }
  
  public static FloatBuffer getFloatBufferFromFloatArray(float[] paramArrayOfFloat)
  {
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramArrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    return (FloatBuffer)localObject;
  }
  
  public static double getTime()
  {
    return (System.nanoTime() - start_time) * 0.001D * 1.0E-6D;
  }
  
  public static Bitmap loadFontFileText(String paramString1, int paramInt1, String paramString2, int paramInt2, v4f paramv4f1, v4f paramv4f2, int paramInt3, float paramFloat, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    Log.i("BFS", "Auto-generated method stub", new Exception());
    return BitmapFactory.decodeResource(Globals.m_context.getResources(), 2130837514);
  }
  
  public static Bitmap makePowerOfTwo(Bitmap paramBitmap)
  {
    if (!requiresPowerOfTwo()) {
      return paramBitmap;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(nextPowerOfTwo(i), nextPowerOfTwo(j), Bitmap.Config.ARGB_8888);
    new Canvas(localBitmap).drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint());
    paramBitmap.recycle();
    return localBitmap;
  }
  
  public static int nextPowerOfTwo(int paramInt)
  {
    int i = 1;
    while (i < Integer.MAX_VALUE)
    {
      if (i >= paramInt) {
        return i;
      }
      i *= 2;
    }
    return 0;
  }
  
  public static float radians(float paramFloat)
  {
    return 3.1415927F * paramFloat / 180.0F;
  }
  
  public static boolean requiresPowerOfTwo()
  {
    if (m_requires_pot != -1) {
      return m_requires_pot == 1;
    }
    HashMap localHashMap = new HashMap();
    Object localObject2 = Globals.GL.glGetString(7939);
    Object localObject1;
    if (((String)localObject2).contains("GL_ARB_texture_non_power_of_two"))
    {
      localObject1 = "NO";
      m_requires_pot = 0;
      localHashMap.put("POT", localObject1);
      if (!((String)localObject2).contains("GL_IMG_texture_compression_pvrtc")) {
        break label269;
      }
      localObject1 = "YES";
    }
    for (;;)
    {
      localHashMap.put("PVRTC", localObject1);
      localObject1 = Globals.GL.glGetString(7938);
      try
      {
        localObject2 = ((ActivityManager)Globals.m_activity.getSystemService("activity")).getDeviceConfigurationInfo();
        localObject2 = String.format("%X", new Object[] { Integer.valueOf(localObject2.getClass().getField("reqGlEsVersion").getInt(localObject2)) });
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      localHashMap.put("VERSION", localObject1);
      localObject1 = Globals.GL.glGetString(7937);
      localObject2 = Globals.GL.glGetString(7936);
      localHashMap.put("RENDERER/VENDOR", (String)localObject1 + "/" + (String)localObject2);
      localHashMap.put("RENDERER/VENDOR/MODEL", (String)localObject1 + "/" + (String)localObject2 + "/" + Build.MODEL);
      FlurryAgent.onEvent("OPEN_GL_ES", localHashMap);
      if (m_requires_pot != 1) {
        break label292;
      }
      return true;
      localObject1 = "YES";
      m_requires_pot = 1;
      break;
      label269:
      if (((String)localObject2).contains("atitc")) {
        localObject1 = "ATITC";
      } else {
        localObject1 = "NO";
      }
    }
    label292:
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/platform/Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */