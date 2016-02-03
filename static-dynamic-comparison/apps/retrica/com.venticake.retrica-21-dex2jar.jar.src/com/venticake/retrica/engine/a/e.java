package com.venticake.retrica.engine.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class e
  extends f
{
  private float[] a = { 0.0F, 0.0F, 1.0F, 1.0F };
  private boolean b;
  
  public e() {}
  
  public e(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  protected FloatBuffer a(FloatBuffer paramFloatBuffer)
  {
    float f4;
    float f3;
    float f2;
    float f1;
    float[] arrayOfFloat;
    float f5;
    if (this.b)
    {
      f4 = this.a[0];
      f3 = this.a[2];
      f2 = this.a[1];
      f1 = this.a[3];
      arrayOfFloat = new float[8];
      float[] tmp45_43 = arrayOfFloat;
      tmp45_43[0] = 0.0F;
      float[] tmp49_45 = tmp45_43;
      tmp49_45[1] = 0.0F;
      float[] tmp53_49 = tmp49_45;
      tmp53_49[2] = 0.0F;
      float[] tmp57_53 = tmp53_49;
      tmp57_53[3] = 0.0F;
      float[] tmp61_57 = tmp57_53;
      tmp61_57[4] = 0.0F;
      float[] tmp65_61 = tmp61_57;
      tmp65_61[5] = 0.0F;
      float[] tmp69_65 = tmp65_61;
      tmp69_65[6] = 0.0F;
      float[] tmp74_69 = tmp69_65;
      tmp74_69[7] = 0.0F;
      tmp74_69;
      if (paramFloatBuffer.get(0) <= 0.5F) {
        break label304;
      }
      f5 = f3;
      label95:
      arrayOfFloat[0] = f5;
      if (paramFloatBuffer.get(1) <= 0.5F) {
        break label311;
      }
      f5 = f1;
      label115:
      arrayOfFloat[1] = f5;
      if (paramFloatBuffer.get(2) <= 0.5F) {
        break label317;
      }
      f5 = f3;
      label136:
      arrayOfFloat[2] = f5;
      if (paramFloatBuffer.get(3) <= 0.5F) {
        break label324;
      }
      f5 = f1;
      label156:
      arrayOfFloat[3] = f5;
      if (paramFloatBuffer.get(4) <= 0.5F) {
        break label330;
      }
      f5 = f3;
      label177:
      arrayOfFloat[4] = f5;
      if (paramFloatBuffer.get(5) <= 0.5F) {
        break label337;
      }
      f5 = f1;
      label197:
      arrayOfFloat[5] = f5;
      if (paramFloatBuffer.get(6) <= 0.5F) {
        break label343;
      }
      label215:
      arrayOfFloat[6] = f3;
      if (paramFloatBuffer.get(7) <= 0.5F) {
        break label350;
      }
    }
    for (;;)
    {
      arrayOfFloat[7] = f1;
      paramFloatBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      paramFloatBuffer.put(arrayOfFloat).position(0);
      return paramFloatBuffer;
      f4 = this.a[1];
      f3 = this.a[3];
      f2 = this.a[0];
      f1 = this.a[2];
      break;
      label304:
      f5 = f4;
      break label95;
      label311:
      f5 = f2;
      break label115;
      label317:
      f5 = f4;
      break label136;
      label324:
      f5 = f2;
      break label156;
      label330:
      f5 = f4;
      break label177;
      label337:
      f5 = f2;
      break label197;
      label343:
      f3 = f4;
      break label215;
      label350:
      f1 = f2;
    }
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    super.a(paramInt, paramFloatBuffer1, a(paramFloatBuffer2));
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.a = paramArrayOfFloat;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/engine/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */