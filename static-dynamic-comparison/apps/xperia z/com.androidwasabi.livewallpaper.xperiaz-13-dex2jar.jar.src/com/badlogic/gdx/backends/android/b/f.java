package com.badlogic.gdx.backends.android.b;

import java.io.IOException;
import java.io.Writer;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL10Ext;
import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11Ext;

class f
  extends ae
{
  boolean a;
  boolean b;
  boolean c;
  boolean d;
  StringBuilder e;
  private Writer k;
  private boolean l;
  private int m;
  private g n;
  private g o;
  private g p;
  private g q;
  
  public f(GL paramGL, Writer paramWriter, boolean paramBoolean)
  {
    super(paramGL);
    this.k = paramWriter;
    this.l = paramBoolean;
  }
  
  private String A(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    case 4608: 
      return "GL_AMBIENT";
    case 4609: 
      return "GL_DIFFUSE";
    case 4610: 
      return "GL_SPECULAR";
    case 4611: 
      return "GL_POSITION";
    case 4612: 
      return "GL_SPOT_DIRECTION";
    case 4613: 
      return "GL_SPOT_EXPONENT";
    case 4614: 
      return "GL_SPOT_CUTOFF";
    case 4615: 
      return "GL_CONSTANT_ATTENUATION";
    case 4616: 
      return "GL_LINEAR_ATTENUATION";
    }
    return "GL_QUADRATIC_ATTENUATION";
  }
  
  private int B(int paramInt)
  {
    int i = 4;
    switch (paramInt)
    {
    default: 
      i = 0;
    case 4608: 
    case 4609: 
    case 4610: 
    case 4611: 
      return i;
    case 4612: 
      return 3;
    case 4613: 
      return 1;
    case 4614: 
      return 1;
    case 4615: 
      return 1;
    case 4616: 
      return 1;
    }
    return 1;
  }
  
  private String C(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    case 2899: 
      return "GL_LIGHT_MODEL_AMBIENT";
    }
    return "GL_LIGHT_MODEL_TWO_SIDE";
  }
  
  private int D(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 2899: 
      return 4;
    }
    return 1;
  }
  
  private String E(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    case 5120: 
      return "GL_BYTE";
    case 5121: 
      return "GL_UNSIGNED_BYTE";
    case 5122: 
      return "GL_SHORT";
    case 5132: 
      return "GL_FIXED";
    }
    return "GL_FLOAT";
  }
  
  private String a(float paramFloat)
  {
    int i = (int)paramFloat;
    if (paramFloat == i)
    {
      switch (i)
      {
      default: 
        return b(i);
      case 7681: 
        return "GL_REPLACE";
      case 8448: 
        return "GL_MODULATE";
      case 8449: 
        return "GL_DECAL";
      case 3042: 
        return "GL_BLEND";
      case 260: 
        return "GL_ADD";
      }
      return "GL_COMBINE";
    }
    return Float.toString(paramFloat);
  }
  
  private String a(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\n");
    int i = 0;
    while (i < paramInt1)
    {
      localStringBuilder.append(" [" + i + "] = ");
      a(localStringBuilder, paramIntBuffer.get(i), paramInt2);
      localStringBuilder.append('\n');
      i += 1;
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  private String a(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\n");
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < paramInt1)
    {
      int i1 = paramInt3 + i;
      localStringBuilder.append(" [" + i1 + "] = ");
      if ((i1 < 0) || (i1 >= j)) {
        localStringBuilder.append("out of bounds");
      }
      for (;;)
      {
        localStringBuilder.append('\n');
        i += 1;
        break;
        a(localStringBuilder, paramArrayOfInt[i1], paramInt2);
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  private String a(int paramInt, FloatBuffer paramFloatBuffer)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\n");
    int i = 0;
    while (i < paramInt)
    {
      localStringBuilder.append(" [" + i + "] = " + paramFloatBuffer.get(i) + '\n');
      i += 1;
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  private String a(int paramInt, ShortBuffer paramShortBuffer)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\n");
    int i = 0;
    while (i < paramInt)
    {
      localStringBuilder.append(" [" + i + "] = " + paramShortBuffer.get(i) + '\n');
      i += 1;
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  private String a(int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\n");
    int j = paramArrayOfFloat.length;
    int i = 0;
    if (i < paramInt1)
    {
      int i1 = paramInt2 + i;
      localStringBuilder.append("[" + i1 + "] = ");
      if ((i1 < 0) || (i1 >= j)) {
        localStringBuilder.append("out of bounds");
      }
      for (;;)
      {
        localStringBuilder.append('\n');
        i += 1;
        break;
        localStringBuilder.append(paramArrayOfFloat[i1]);
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  private String a(int paramInt1, short[] paramArrayOfShort, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\n");
    int j = paramArrayOfShort.length;
    int i = 0;
    if (i < paramInt1)
    {
      int i1 = paramInt2 + i;
      localStringBuilder.append(" [" + i1 + "] = ");
      if ((i1 < 0) || (i1 >= j)) {
        localStringBuilder.append("out of bounds");
      }
      for (;;)
      {
        localStringBuilder.append('\n');
        i += 1;
        break;
        localStringBuilder.append(paramArrayOfShort[i1]);
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    int i = this.f.glGetError();
    if (i != 0) {
      a("glError: " + Integer.toString(i));
    }
  }
  
  private void a(int paramInt)
  {
    d(Integer.toString(paramInt));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer)
  {
    a("size", paramInt1);
    a("type", E(paramInt2));
    a("stride", paramInt3);
    a("pointer", paramBuffer.toString());
  }
  
  private void a(String paramString)
  {
    b(paramString + '\n');
  }
  
  private void a(String paramString, float paramFloat)
  {
    a(paramString, Float.toString(paramFloat));
  }
  
  private void a(String paramString, int paramInt)
  {
    a(paramString, Integer.toString(paramInt));
  }
  
  private void a(String paramString, int paramInt, FloatBuffer paramFloatBuffer)
  {
    a(paramString, a(paramInt, paramFloatBuffer));
  }
  
  private void a(String paramString, int paramInt, IntBuffer paramIntBuffer)
  {
    a(paramString, a(paramInt, 0, paramIntBuffer));
  }
  
  private void a(String paramString, int paramInt, ShortBuffer paramShortBuffer)
  {
    a(paramString, a(paramInt, paramShortBuffer));
  }
  
  private void a(String paramString, int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    a(paramString, a(paramInt1, paramArrayOfFloat, paramInt2));
  }
  
  private void a(String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    a(paramString, a(paramInt1, 0, paramArrayOfInt, paramInt2));
  }
  
  private void a(String paramString, int paramInt1, short[] paramArrayOfShort, int paramInt2)
  {
    a(paramString, a(paramInt1, paramArrayOfShort, paramInt2));
  }
  
  private void a(String paramString1, String paramString2)
  {
    int i = this.m;
    this.m = (i + 1);
    if (i > 0) {
      b(", ");
    }
    if (this.l) {
      b(paramString1 + "=");
    }
    b(paramString2);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    a(paramString, Boolean.toString(paramBoolean));
  }
  
  private void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      paramStringBuilder.append(paramInt1);
      return;
    case 1: 
      paramStringBuilder.append(Float.intBitsToFloat(paramInt1));
      return;
    }
    paramStringBuilder.append(paramInt1 / 65536.0F);
  }
  
  private void a(StringBuilder paramStringBuilder, boolean paramBoolean, String paramString, g paramg, int paramInt)
  {
    if (!paramBoolean) {
      return;
    }
    paramStringBuilder.append(" ");
    paramStringBuilder.append(paramString + ":{");
    if (paramg == null)
    {
      paramStringBuilder.append("undefined");
      return;
    }
    if (paramg.c < 0)
    {
      paramStringBuilder.append("invalid stride");
      return;
    }
    int i = paramg.a();
    paramString = paramg.e;
    int j = paramg.a;
    int i1 = paramg.b;
    int i2 = paramg.a(i1);
    i *= paramInt;
    paramInt = 0;
    if (paramInt < j)
    {
      if (paramInt > 0) {
        paramStringBuilder.append(", ");
      }
      switch (i1)
      {
      default: 
        paramStringBuilder.append("?");
      }
      for (;;)
      {
        i += i2;
        paramInt += 1;
        break;
        paramStringBuilder.append(Integer.toString(paramString.get(i)));
        continue;
        paramStringBuilder.append(Integer.toString(paramString.get(i) & 0xFF));
        continue;
        paramStringBuilder.append(Integer.toString(paramString.asShortBuffer().get(i / 2)));
        continue;
        paramStringBuilder.append(Integer.toString(paramString.asIntBuffer().get(i / 4)));
        continue;
        paramStringBuilder.append(Float.toString(paramString.asFloatBuffer().get(i / 4)));
      }
    }
    paramStringBuilder.append("}");
  }
  
  private char[] a(int paramInt1, int paramInt2, Buffer paramBuffer)
  {
    int i = 0;
    char[] arrayOfChar = new char[paramInt1];
    switch (paramInt2)
    {
    case 5122: 
    default: 
      return arrayOfChar;
    case 5121: 
      paramBuffer = a(paramInt1, paramBuffer);
      byte[] arrayOfByte = paramBuffer.array();
      int j = paramBuffer.arrayOffset();
      paramInt2 = i;
      while (paramInt2 < paramInt1)
      {
        arrayOfChar[paramInt2] = ((char)(arrayOfByte[(j + paramInt2)] & 0xFF));
        paramInt2 += 1;
      }
    }
    if ((paramBuffer instanceof CharBuffer)) {}
    for (paramBuffer = (CharBuffer)paramBuffer;; paramBuffer = a(paramInt1 * 2, paramBuffer).asCharBuffer())
    {
      paramInt1 = paramBuffer.position();
      paramBuffer.position(0);
      paramBuffer.get(arrayOfChar);
      paramBuffer.position(paramInt1);
      return arrayOfChar;
    }
  }
  
  private String b(float paramFloat)
  {
    int i = (int)paramFloat;
    if (paramFloat == i)
    {
      switch (i)
      {
      default: 
        return b(i);
      case 33071: 
        return "GL_CLAMP_TO_EDGE";
      case 10497: 
        return "GL_REPEAT";
      case 9728: 
        return "GL_NEAREST";
      case 9729: 
        return "GL_LINEAR";
      case 9984: 
        return "GL_NEAREST_MIPMAP_NEAREST";
      case 9985: 
        return "GL_LINEAR_MIPMAP_NEAREST";
      case 9986: 
        return "GL_NEAREST_MIPMAP_LINEAR";
      }
      return "GL_LINEAR_MIPMAP_LINEAR";
    }
    return Float.toString(paramFloat);
  }
  
  private static String b(int paramInt)
  {
    return "0x" + Integer.toHexString(paramInt);
  }
  
  private void b()
  {
    b(");\n");
    c();
  }
  
  private void b(String paramString)
  {
    try
    {
      this.k.write(paramString);
      return;
    }
    catch (IOException paramString) {}
  }
  
  private void b(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    paramStringBuilder.append(" [" + paramInt1 + " : " + paramInt2 + "] =");
    a(paramStringBuilder, this.d, "v", this.q, paramInt2);
    a(paramStringBuilder, this.b, "n", this.o, paramInt2);
    a(paramStringBuilder, this.a, "c", this.n, paramInt2);
    a(paramStringBuilder, this.c, "t", this.p, paramInt2);
    paramStringBuilder.append("\n");
  }
  
  private String c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramInt & 0x100) != 0) {
      localStringBuilder.append("GL_DEPTH_BUFFER_BIT");
    }
    for (int i = paramInt & 0xFEFF;; i = paramInt)
    {
      paramInt = i;
      if ((i & 0x400) != 0)
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(" | ");
        }
        localStringBuilder.append("GL_STENCIL_BUFFER_BIT");
        paramInt = i & 0xFBFF;
      }
      i = paramInt;
      if ((paramInt & 0x4000) != 0)
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(" | ");
        }
        localStringBuilder.append("GL_COLOR_BUFFER_BIT");
        i = paramInt & 0xBFFF;
      }
      if (i != 0)
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(" | ");
        }
        localStringBuilder.append(b(i));
      }
      return localStringBuilder.toString();
    }
  }
  
  private void c()
  {
    try
    {
      this.k.flush();
      return;
    }
    catch (IOException localIOException)
    {
      this.k = null;
    }
  }
  
  private void c(String paramString)
  {
    b(paramString + '(');
    this.m = 0;
  }
  
  private String d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    case 0: 
      return "GL_ZERO";
    case 1: 
      return "GL_ONE";
    case 768: 
      return "GL_SRC_COLOR";
    case 769: 
      return "GL_ONE_MINUS_SRC_COLOR";
    case 774: 
      return "GL_DST_COLOR";
    case 775: 
      return "GL_ONE_MINUS_DST_COLOR";
    case 770: 
      return "GL_SRC_ALPHA";
    case 771: 
      return "GL_ONE_MINUS_SRC_ALPHA";
    case 772: 
      return "GL_DST_ALPHA";
    case 773: 
      return "GL_ONE_MINUS_DST_ALPHA";
    }
    return "GL_SRC_ALPHA_SATURATE";
  }
  
  private void d()
  {
    if (this.a) {
      this.n.b();
    }
    if (this.b) {
      this.o.b();
    }
    if (this.c) {
      this.p.b();
    }
    if (this.d) {
      this.q.b();
    }
  }
  
  private void d(String paramString)
  {
    b(") returns " + paramString + ";\n");
    c();
  }
  
  private String e(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    case 7424: 
      return "GL_FLAT";
    }
    return "GL_SMOOTH";
  }
  
  private void e()
  {
    if (this.a) {
      this.n.c();
    }
    if (this.b) {
      this.o.c();
    }
    if (this.c) {
      this.p.c();
    }
    if (this.d) {
      this.q.c();
    }
  }
  
  private String f(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    }
    return "GL_TEXTURE_2D";
  }
  
  private void f()
  {
    this.e = new StringBuilder();
    this.e.append("\n");
    d();
  }
  
  private String g(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    }
    return "GL_TEXTURE_ENV";
  }
  
  private void g()
  {
    b(this.e.toString());
    e();
  }
  
  private String h(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    case 8704: 
      return "GL_TEXTURE_ENV_MODE";
    }
    return "GL_TEXTURE_ENV_COLOR";
  }
  
  private int i(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 8704: 
      return 1;
    }
    return 4;
  }
  
  private String j(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    case 5888: 
      return "GL_MODELVIEW";
    case 5889: 
      return "GL_PROJECTION";
    }
    return "GL_TEXTURE";
  }
  
  private String k(int paramInt)
  {
    switch (paramInt)
    {
    case 32887: 
    default: 
      return b(paramInt);
    case 32886: 
      return "GL_COLOR_ARRAY";
    case 32884: 
      return "GL_VERTEX_ARRAY";
    case 32885: 
      return "GL_NORMAL_ARRAY";
    }
    return "GL_TEXTURE_COORD_ARRAY";
  }
  
  private String l(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    case 2912: 
      return "GL_FOG";
    case 2896: 
      return "GL_LIGHTING";
    case 3553: 
      return "GL_TEXTURE_2D";
    case 2884: 
      return "GL_CULL_FACE";
    case 3008: 
      return "GL_ALPHA_TEST";
    case 3042: 
      return "GL_BLEND";
    case 3058: 
      return "GL_COLOR_LOGIC_OP";
    case 3024: 
      return "GL_DITHER";
    case 2960: 
      return "GL_STENCIL_TEST";
    case 2929: 
      return "GL_DEPTH_TEST";
    case 16384: 
      return "GL_LIGHT0";
    case 16385: 
      return "GL_LIGHT1";
    case 16386: 
      return "GL_LIGHT2";
    case 16387: 
      return "GL_LIGHT3";
    case 16388: 
      return "GL_LIGHT4";
    case 16389: 
      return "GL_LIGHT5";
    case 16390: 
      return "GL_LIGHT6";
    case 16391: 
      return "GL_LIGHT7";
    case 2832: 
      return "GL_POINT_SMOOTH";
    case 2848: 
      return "GL_LINE_SMOOTH";
    case 2903: 
      return "GL_COLOR_MATERIAL";
    case 2977: 
      return "GL_NORMALIZE";
    case 32826: 
      return "GL_RESCALE_NORMAL";
    case 32884: 
      return "GL_VERTEX_ARRAY";
    case 32885: 
      return "GL_NORMAL_ARRAY";
    case 32886: 
      return "GL_COLOR_ARRAY";
    case 32888: 
      return "GL_TEXTURE_COORD_ARRAY";
    case 32925: 
      return "GL_MULTISAMPLE";
    case 32926: 
      return "GL_SAMPLE_ALPHA_TO_COVERAGE";
    case 32927: 
      return "GL_SAMPLE_ALPHA_TO_ONE";
    case 32928: 
      return "GL_SAMPLE_COVERAGE";
    }
    return "GL_SCISSOR_TEST";
  }
  
  private String m(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    case 10240: 
      return "GL_TEXTURE_MAG_FILTER";
    case 10241: 
      return "GL_TEXTURE_MIN_FILTER";
    case 10242: 
      return "GL_TEXTURE_WRAP_S";
    case 10243: 
      return "GL_TEXTURE_WRAP_T";
    case 33169: 
      return "GL_GENERATE_MIPMAP";
    }
    return "GL_TEXTURE_CROP_RECT_OES";
  }
  
  private String n(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    case 2914: 
      return "GL_FOG_DENSITY";
    case 2915: 
      return "GL_FOG_START";
    case 2916: 
      return "GL_FOG_END";
    case 2917: 
      return "GL_FOG_MODE";
    }
    return "GL_FOG_COLOR";
  }
  
  private int o(int paramInt)
  {
    int i = 1;
    switch (paramInt)
    {
    default: 
      i = 0;
    case 2914: 
    case 2915: 
    case 2916: 
    case 2917: 
      return i;
    }
    return 4;
  }
  
  private String p(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    case 0: 
      return "GL_POINTS";
    case 1: 
      return "GL_LINES";
    case 2: 
      return "GL_LINE_LOOP";
    case 3: 
      return "GL_LINE_STRIP";
    case 4: 
      return "GL_TRIANGLES";
    case 5: 
      return "GL_TRIANGLE_STRIP";
    }
    return "GL_TRIANGLE_FAN";
  }
  
  private String q(int paramInt)
  {
    switch (paramInt)
    {
    case 5122: 
    default: 
      return b(paramInt);
    case 5123: 
      return "GL_UNSIGNED_SHORT";
    }
    return "GL_UNSIGNED_BYTE";
  }
  
  private String r(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    case 3413: 
      return "GL_ALPHA_BITS";
    case 33902: 
      return "GL_ALIASED_LINE_WIDTH_RANGE";
    case 33901: 
      return "GL_ALIASED_POINT_SIZE_RANGE";
    case 3412: 
      return "GL_BLUE_BITS";
    case 34467: 
      return "GL_COMPRESSED_TEXTURE_FORMATS";
    case 3414: 
      return "GL_DEPTH_BITS";
    case 3411: 
      return "GL_GREEN_BITS";
    case 33001: 
      return "GL_MAX_ELEMENTS_INDICES";
    case 33000: 
      return "GL_MAX_ELEMENTS_VERTICES";
    case 3377: 
      return "GL_MAX_LIGHTS";
    case 3379: 
      return "GL_MAX_TEXTURE_SIZE";
    case 3386: 
      return "GL_MAX_VIEWPORT_DIMS";
    case 3382: 
      return "GL_MAX_MODELVIEW_STACK_DEPTH";
    case 3384: 
      return "GL_MAX_PROJECTION_STACK_DEPTH";
    case 3385: 
      return "GL_MAX_TEXTURE_STACK_DEPTH";
    case 34018: 
      return "GL_MAX_TEXTURE_UNITS";
    case 34466: 
      return "GL_NUM_COMPRESSED_TEXTURE_FORMATS";
    case 3410: 
      return "GL_RED_BITS";
    case 2850: 
      return "GL_SMOOTH_LINE_WIDTH_RANGE";
    case 2834: 
      return "GL_SMOOTH_POINT_SIZE_RANGE";
    case 3415: 
      return "GL_STENCIL_BITS";
    case 3408: 
      return "GL_SUBPIXEL_BITS";
    case 35213: 
      return "GL_MODELVIEW_MATRIX_FLOAT_AS_INT_BITS_OES";
    case 35214: 
      return "GL_PROJECTION_MATRIX_FLOAT_AS_INT_BITS_OES";
    }
    return "GL_TEXTURE_MATRIX_FLOAT_AS_INT_BITS_OES";
  }
  
  private int s(int paramInt)
  {
    int i = 1;
    switch (paramInt)
    {
    default: 
      i = 0;
    case 3377: 
    case 3379: 
    case 3382: 
    case 3384: 
    case 3385: 
    case 3408: 
    case 3410: 
    case 3411: 
    case 3412: 
    case 3413: 
    case 3414: 
    case 3415: 
    case 33000: 
    case 33001: 
    case 34018: 
    case 34466: 
      return i;
    case 33902: 
      return 2;
    case 33901: 
      return 2;
    case 34467: 
      int[] arrayOfInt = new int[1];
      this.f.glGetIntegerv(34466, arrayOfInt, 0);
      return arrayOfInt[0];
    case 3386: 
      return 2;
    case 2850: 
      return 2;
    case 2834: 
      return 2;
    }
    return 16;
  }
  
  private int t(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    }
    return 1;
  }
  
  private String u(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    case 3156: 
      return "GL_FOG_HINT";
    case 3154: 
      return "GL_LINE_SMOOTH_HINT";
    case 3152: 
      return "GL_PERSPECTIVE_CORRECTION_HINT";
    case 3153: 
      return "GL_POINT_SMOOTH_HINT";
    case 3155: 
      return "GL_POLYGON_SMOOTH_HINT";
    }
    return "GL_GENERATE_MIPMAP_HINT";
  }
  
  private String v(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    case 4353: 
      return "GL_FASTEST";
    case 4354: 
      return "GL_NICEST";
    }
    return "GL_DONT_CARE";
  }
  
  private String w(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    }
    return "GL_FRONT_AND_BACK";
  }
  
  private String x(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    case 4608: 
      return "GL_AMBIENT";
    case 4609: 
      return "GL_DIFFUSE";
    case 4610: 
      return "GL_SPECULAR";
    case 5632: 
      return "GL_EMISSION";
    case 5633: 
      return "GL_SHININESS";
    }
    return "GL_AMBIENT_AND_DIFFUSE";
  }
  
  private int y(int paramInt)
  {
    int i = 4;
    switch (paramInt)
    {
    default: 
      i = 0;
    case 4608: 
    case 4609: 
    case 4610: 
    case 5632: 
    case 5634: 
      return i;
    }
    return 1;
  }
  
  private String z(int paramInt)
  {
    if ((paramInt >= 16384) && (paramInt <= 16391)) {
      return "GL_LIGHT" + Integer.toString(paramInt);
    }
    return b(paramInt);
  }
  
  ByteBuffer a(int paramInt, Buffer paramBuffer)
  {
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    int j = 0;
    int i;
    if (paramInt < 0) {
      i = 1;
    }
    Object localObject1;
    while ((paramBuffer instanceof ByteBuffer))
    {
      localObject1 = (ByteBuffer)paramBuffer;
      if (i != 0) {
        paramInt = ((ByteBuffer)localObject1).limit();
      }
      paramBuffer = ByteBuffer.allocate(paramInt).order(((ByteBuffer)localObject1).order());
      i1 = ((ByteBuffer)localObject1).position();
      i = j;
      for (;;)
      {
        if (i < paramInt)
        {
          paramBuffer.put(((ByteBuffer)localObject1).get());
          i += 1;
          continue;
          i = 0;
          break;
        }
      }
      ((ByteBuffer)localObject1).position(i1);
    }
    for (;;)
    {
      paramBuffer.rewind();
      paramBuffer.order(ByteOrder.nativeOrder());
      return paramBuffer;
      Object localObject2;
      if ((paramBuffer instanceof CharBuffer))
      {
        localObject1 = (CharBuffer)paramBuffer;
        if (i != 0) {
          paramInt = ((CharBuffer)localObject1).limit() * 2;
        }
        paramBuffer = ByteBuffer.allocate(paramInt).order(((CharBuffer)localObject1).order());
        localObject2 = paramBuffer.asCharBuffer();
        j = ((CharBuffer)localObject1).position();
        i = i1;
        while (i < paramInt / 2)
        {
          ((CharBuffer)localObject2).put(((CharBuffer)localObject1).get());
          i += 1;
        }
        ((CharBuffer)localObject1).position(j);
      }
      else if ((paramBuffer instanceof ShortBuffer))
      {
        localObject1 = (ShortBuffer)paramBuffer;
        if (i != 0) {
          paramInt = ((ShortBuffer)localObject1).limit() * 2;
        }
        paramBuffer = ByteBuffer.allocate(paramInt).order(((ShortBuffer)localObject1).order());
        localObject2 = paramBuffer.asShortBuffer();
        j = ((ShortBuffer)localObject1).position();
        i = i2;
        while (i < paramInt / 2)
        {
          ((ShortBuffer)localObject2).put(((ShortBuffer)localObject1).get());
          i += 1;
        }
        ((ShortBuffer)localObject1).position(j);
      }
      else if ((paramBuffer instanceof IntBuffer))
      {
        localObject1 = (IntBuffer)paramBuffer;
        if (i != 0) {
          paramInt = ((IntBuffer)localObject1).limit() * 4;
        }
        paramBuffer = ByteBuffer.allocate(paramInt).order(((IntBuffer)localObject1).order());
        localObject2 = paramBuffer.asIntBuffer();
        j = ((IntBuffer)localObject1).position();
        i = i3;
        while (i < paramInt / 4)
        {
          ((IntBuffer)localObject2).put(((IntBuffer)localObject1).get());
          i += 1;
        }
        ((IntBuffer)localObject1).position(j);
      }
      else if ((paramBuffer instanceof FloatBuffer))
      {
        localObject1 = (FloatBuffer)paramBuffer;
        if (i != 0) {
          paramInt = ((FloatBuffer)localObject1).limit() * 4;
        }
        paramBuffer = ByteBuffer.allocate(paramInt).order(((FloatBuffer)localObject1).order());
        localObject2 = paramBuffer.asFloatBuffer();
        j = ((FloatBuffer)localObject1).position();
        i = i4;
        while (i < paramInt / 4)
        {
          ((FloatBuffer)localObject2).put(((FloatBuffer)localObject1).get());
          i += 1;
        }
        ((FloatBuffer)localObject1).position(j);
      }
      else if ((paramBuffer instanceof DoubleBuffer))
      {
        localObject1 = (DoubleBuffer)paramBuffer;
        if (i != 0) {
          paramInt = ((DoubleBuffer)localObject1).limit() * 8;
        }
        paramBuffer = ByteBuffer.allocate(paramInt).order(((DoubleBuffer)localObject1).order());
        localObject2 = paramBuffer.asDoubleBuffer();
        j = ((DoubleBuffer)localObject1).position();
        i = i5;
        while (i < paramInt / 8)
        {
          ((DoubleBuffer)localObject2).put(((DoubleBuffer)localObject1).get());
          i += 1;
        }
        ((DoubleBuffer)localObject1).position(j);
      }
      else
      {
        if (!(paramBuffer instanceof LongBuffer)) {
          break;
        }
        localObject1 = (LongBuffer)paramBuffer;
        if (i != 0) {
          paramInt = ((LongBuffer)localObject1).limit() * 8;
        }
        paramBuffer = ByteBuffer.allocate(paramInt).order(((LongBuffer)localObject1).order());
        localObject2 = paramBuffer.asLongBuffer();
        j = ((LongBuffer)localObject1).position();
        i = i6;
        while (i < paramInt / 8)
        {
          ((LongBuffer)localObject2).put(((LongBuffer)localObject1).get());
          i += 1;
        }
        ((LongBuffer)localObject1).position(j);
      }
    }
    throw new RuntimeException("Unimplemented Buffer subclass.");
  }
  
  public void glActiveTexture(int paramInt)
  {
    c("glActiveTexture");
    a("texture", paramInt);
    b();
    this.f.glActiveTexture(paramInt);
    a();
  }
  
  public void glAlphaFunc(int paramInt, float paramFloat)
  {
    c("glAlphaFunc");
    a("func", paramInt);
    a("ref", paramFloat);
    b();
    this.f.glAlphaFunc(paramInt, paramFloat);
    a();
  }
  
  public void glAlphaFuncx(int paramInt1, int paramInt2)
  {
    c("glAlphaFuncx");
    a("func", paramInt1);
    a("ref", paramInt2);
    b();
    this.f.glAlphaFuncx(paramInt1, paramInt2);
    a();
  }
  
  public void glBindBuffer(int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glBindTexture(int paramInt1, int paramInt2)
  {
    c("glBindTexture");
    a("target", f(paramInt1));
    a("texture", paramInt2);
    b();
    this.f.glBindTexture(paramInt1, paramInt2);
    a();
  }
  
  public void glBlendFunc(int paramInt1, int paramInt2)
  {
    c("glBlendFunc");
    a("sfactor", d(paramInt1));
    a("dfactor", d(paramInt2));
    b();
    this.f.glBlendFunc(paramInt1, paramInt2);
    a();
  }
  
  public void glBufferData(int paramInt1, int paramInt2, Buffer paramBuffer, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glBufferSubData(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glClear(int paramInt)
  {
    c("glClear");
    a("mask", c(paramInt));
    b();
    this.f.glClear(paramInt);
    a();
  }
  
  public void glClearColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    c("glClearColor");
    a("red", paramFloat1);
    a("green", paramFloat2);
    a("blue", paramFloat3);
    a("alpha", paramFloat4);
    b();
    this.f.glClearColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    a();
  }
  
  public void glClearColorx(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c("glClearColor");
    a("red", paramInt1);
    a("green", paramInt2);
    a("blue", paramInt3);
    a("alpha", paramInt4);
    b();
    this.f.glClearColorx(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
  }
  
  public void glClearDepthf(float paramFloat)
  {
    c("glClearDepthf");
    a("depth", paramFloat);
    b();
    this.f.glClearDepthf(paramFloat);
    a();
  }
  
  public void glClearDepthx(int paramInt)
  {
    c("glClearDepthx");
    a("depth", paramInt);
    b();
    this.f.glClearDepthx(paramInt);
    a();
  }
  
  public void glClearStencil(int paramInt)
  {
    c("glClearStencil");
    a("s", paramInt);
    b();
    this.f.glClearStencil(paramInt);
    a();
  }
  
  public void glClientActiveTexture(int paramInt)
  {
    c("glClientActiveTexture");
    a("texture", paramInt);
    b();
    this.f.glClientActiveTexture(paramInt);
    a();
  }
  
  public void glClipPlanef(int paramInt, FloatBuffer paramFloatBuffer)
  {
    c("glClipPlanef");
    a("plane", paramInt);
    a("equation", 4, paramFloatBuffer);
    b();
    this.h.glClipPlanef(paramInt, paramFloatBuffer);
    a();
  }
  
  public void glClipPlanef(int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    c("glClipPlanef");
    a("plane", paramInt1);
    a("equation", 4, paramArrayOfFloat, paramInt2);
    a("offset", paramInt2);
    b();
    this.h.glClipPlanef(paramInt1, paramArrayOfFloat, paramInt2);
    a();
  }
  
  public void glClipPlanex(int paramInt, IntBuffer paramIntBuffer)
  {
    c("glClipPlanef");
    a("plane", paramInt);
    a("equation", 4, paramIntBuffer);
    b();
    this.h.glClipPlanex(paramInt, paramIntBuffer);
    a();
  }
  
  public void glClipPlanex(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    c("glClipPlanex");
    a("plane", paramInt1);
    a("equation", 4, paramArrayOfInt, paramInt2);
    a("offset", paramInt2);
    b();
    this.h.glClipPlanex(paramInt1, paramArrayOfInt, paramInt2);
    a();
  }
  
  public void glColor4f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    c("glColor4f");
    a("red", paramFloat1);
    a("green", paramFloat2);
    a("blue", paramFloat3);
    a("alpha", paramFloat4);
    b();
    this.f.glColor4f(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    a();
  }
  
  public void glColor4ub(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glColor4x(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c("glColor4x");
    a("red", paramInt1);
    a("green", paramInt2);
    a("blue", paramInt3);
    a("alpha", paramInt4);
    b();
    this.f.glColor4x(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
  }
  
  public void glColorMask(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    c("glColorMask");
    a("red", paramBoolean1);
    a("green", paramBoolean2);
    a("blue", paramBoolean3);
    a("alpha", paramBoolean4);
    b();
    this.f.glColorMask(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
    a();
  }
  
  public void glColorPointer(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer)
  {
    c("glColorPointer");
    a(paramInt1, paramInt2, paramInt3, paramBuffer);
    b();
    this.n = new g(this, paramInt1, paramInt2, paramInt3, paramBuffer);
    this.f.glColorPointer(paramInt1, paramInt2, paramInt3, paramBuffer);
    a();
  }
  
  public void glCompressedTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, Buffer paramBuffer)
  {
    c("glCompressedTexImage2D");
    a("target", f(paramInt1));
    a("level", paramInt2);
    a("internalformat", paramInt3);
    a("width", paramInt4);
    a("height", paramInt5);
    a("border", paramInt6);
    a("imageSize", paramInt7);
    a("data", paramBuffer.toString());
    b();
    this.f.glCompressedTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramBuffer);
    a();
  }
  
  public void glCompressedTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Buffer paramBuffer)
  {
    c("glCompressedTexSubImage2D");
    a("target", f(paramInt1));
    a("level", paramInt2);
    a("xoffset", paramInt3);
    a("yoffset", paramInt4);
    a("width", paramInt5);
    a("height", paramInt6);
    a("format", paramInt7);
    a("imageSize", paramInt8);
    a("data", paramBuffer.toString());
    b();
    this.f.glCompressedTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBuffer);
    a();
  }
  
  public void glCopyTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    c("glCopyTexImage2D");
    a("target", f(paramInt1));
    a("level", paramInt2);
    a("internalformat", paramInt3);
    a("x", paramInt4);
    a("y", paramInt5);
    a("width", paramInt6);
    a("height", paramInt7);
    a("border", paramInt8);
    b();
    this.f.glCopyTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    a();
  }
  
  public void glCopyTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    c("glCopyTexSubImage2D");
    a("target", f(paramInt1));
    a("level", paramInt2);
    a("xoffset", paramInt3);
    a("yoffset", paramInt4);
    a("x", paramInt5);
    a("y", paramInt6);
    a("width", paramInt7);
    a("height", paramInt8);
    b();
    this.f.glCopyTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    a();
  }
  
  public void glCullFace(int paramInt)
  {
    c("glCullFace");
    a("mode", paramInt);
    b();
    this.f.glCullFace(paramInt);
    a();
  }
  
  public void glDeleteBuffers(int paramInt, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glDeleteBuffers(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glDeleteTextures(int paramInt, IntBuffer paramIntBuffer)
  {
    c("glDeleteTextures");
    a("n", paramInt);
    a("textures", paramInt, paramIntBuffer);
    b();
    this.f.glDeleteTextures(paramInt, paramIntBuffer);
    a();
  }
  
  public void glDeleteTextures(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    c("glDeleteTextures");
    a("n", paramInt1);
    a("textures", paramInt1, paramArrayOfInt, paramInt2);
    a("offset", paramInt2);
    b();
    this.f.glDeleteTextures(paramInt1, paramArrayOfInt, paramInt2);
    a();
  }
  
  public void glDepthFunc(int paramInt)
  {
    c("glDepthFunc");
    a("func", paramInt);
    b();
    this.f.glDepthFunc(paramInt);
    a();
  }
  
  public void glDepthMask(boolean paramBoolean)
  {
    c("glDepthMask");
    a("flag", paramBoolean);
    b();
    this.f.glDepthMask(paramBoolean);
    a();
  }
  
  public void glDepthRangef(float paramFloat1, float paramFloat2)
  {
    c("glDepthRangef");
    a("near", paramFloat1);
    a("far", paramFloat2);
    b();
    this.f.glDepthRangef(paramFloat1, paramFloat2);
    a();
  }
  
  public void glDepthRangex(int paramInt1, int paramInt2)
  {
    c("glDepthRangex");
    a("near", paramInt1);
    a("far", paramInt2);
    b();
    this.f.glDepthRangex(paramInt1, paramInt2);
    a();
  }
  
  public void glDisable(int paramInt)
  {
    c("glDisable");
    a("cap", l(paramInt));
    b();
    this.f.glDisable(paramInt);
    a();
  }
  
  public void glDisableClientState(int paramInt)
  {
    c("glDisableClientState");
    a("array", k(paramInt));
    b();
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.f.glDisableClientState(paramInt);
      a();
      return;
      this.a = false;
      continue;
      this.b = false;
      continue;
      this.c = false;
      continue;
      this.d = false;
    }
  }
  
  public void glDrawArrays(int paramInt1, int paramInt2, int paramInt3)
  {
    c("glDrawArrays");
    a("mode", paramInt1);
    a("first", paramInt2);
    a("count", paramInt3);
    f();
    int i = 0;
    while (i < paramInt3)
    {
      b(this.e, i, paramInt2 + i);
      i += 1;
    }
    g();
    b();
    this.f.glDrawArrays(paramInt1, paramInt2, paramInt3);
    a();
  }
  
  public void glDrawElements(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer)
  {
    c("glDrawElements");
    a("mode", p(paramInt1));
    a("count", paramInt2);
    a("type", q(paramInt3));
    char[] arrayOfChar = a(paramInt2, paramInt3, paramBuffer);
    int j = arrayOfChar.length;
    f();
    int i = 0;
    while (i < j)
    {
      b(this.e, i, arrayOfChar[i]);
      i += 1;
    }
    g();
    b();
    this.f.glDrawElements(paramInt1, paramInt2, paramInt3, paramBuffer);
    a();
  }
  
  public void glDrawTexfOES(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    c("glDrawTexfOES");
    a("x", paramFloat1);
    a("y", paramFloat2);
    a("z", paramFloat3);
    a("width", paramFloat4);
    a("height", paramFloat5);
    b();
    this.i.glDrawTexfOES(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
    a();
  }
  
  public void glDrawTexfvOES(FloatBuffer paramFloatBuffer)
  {
    c("glDrawTexfvOES");
    a("coords", 5, paramFloatBuffer);
    b();
    this.i.glDrawTexfvOES(paramFloatBuffer);
    a();
  }
  
  public void glDrawTexfvOES(float[] paramArrayOfFloat, int paramInt)
  {
    c("glDrawTexfvOES");
    a("coords", 5, paramArrayOfFloat, paramInt);
    a("offset", paramInt);
    b();
    this.i.glDrawTexfvOES(paramArrayOfFloat, paramInt);
    a();
  }
  
  public void glDrawTexiOES(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    c("glDrawTexiOES");
    a("x", paramInt1);
    a("y", paramInt2);
    a("z", paramInt3);
    a("width", paramInt4);
    a("height", paramInt5);
    b();
    this.i.glDrawTexiOES(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    a();
  }
  
  public void glDrawTexivOES(IntBuffer paramIntBuffer)
  {
    c("glDrawTexivOES");
    a("coords", 5, paramIntBuffer);
    b();
    this.i.glDrawTexivOES(paramIntBuffer);
    a();
  }
  
  public void glDrawTexivOES(int[] paramArrayOfInt, int paramInt)
  {
    c("glDrawTexivOES");
    a("coords", 5, paramArrayOfInt, paramInt);
    a("offset", paramInt);
    b();
    this.i.glDrawTexivOES(paramArrayOfInt, paramInt);
    a();
  }
  
  public void glDrawTexsOES(short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5)
  {
    c("glDrawTexsOES");
    a("x", paramShort1);
    a("y", paramShort2);
    a("z", paramShort3);
    a("width", paramShort4);
    a("height", paramShort5);
    b();
    this.i.glDrawTexsOES(paramShort1, paramShort2, paramShort3, paramShort4, paramShort5);
    a();
  }
  
  public void glDrawTexsvOES(ShortBuffer paramShortBuffer)
  {
    c("glDrawTexsvOES");
    a("coords", 5, paramShortBuffer);
    b();
    this.i.glDrawTexsvOES(paramShortBuffer);
    a();
  }
  
  public void glDrawTexsvOES(short[] paramArrayOfShort, int paramInt)
  {
    c("glDrawTexsvOES");
    a("coords", 5, paramArrayOfShort, paramInt);
    a("offset", paramInt);
    b();
    this.i.glDrawTexsvOES(paramArrayOfShort, paramInt);
    a();
  }
  
  public void glDrawTexxOES(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    c("glDrawTexxOES");
    a("x", paramInt1);
    a("y", paramInt2);
    a("z", paramInt3);
    a("width", paramInt4);
    a("height", paramInt5);
    b();
    this.i.glDrawTexxOES(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    a();
  }
  
  public void glDrawTexxvOES(IntBuffer paramIntBuffer)
  {
    c("glDrawTexxvOES");
    a("coords", 5, paramIntBuffer);
    b();
    this.i.glDrawTexxvOES(paramIntBuffer);
    a();
  }
  
  public void glDrawTexxvOES(int[] paramArrayOfInt, int paramInt)
  {
    c("glDrawTexxvOES");
    a("coords", 5, paramArrayOfInt, paramInt);
    a("offset", paramInt);
    b();
    this.i.glDrawTexxvOES(paramArrayOfInt, paramInt);
    a();
  }
  
  public void glEnable(int paramInt)
  {
    c("glEnable");
    a("cap", l(paramInt));
    b();
    this.f.glEnable(paramInt);
    a();
  }
  
  public void glEnableClientState(int paramInt)
  {
    c("glEnableClientState");
    a("array", k(paramInt));
    b();
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.f.glEnableClientState(paramInt);
      a();
      return;
      this.a = true;
      continue;
      this.b = true;
      continue;
      this.c = true;
      continue;
      this.d = true;
    }
  }
  
  public void glFinish()
  {
    c("glFinish");
    b();
    this.f.glFinish();
    a();
  }
  
  public void glFlush()
  {
    c("glFlush");
    b();
    this.f.glFlush();
    a();
  }
  
  public void glFogf(int paramInt, float paramFloat)
  {
    c("glFogf");
    a("pname", paramInt);
    a("param", paramFloat);
    b();
    this.f.glFogf(paramInt, paramFloat);
    a();
  }
  
  public void glFogfv(int paramInt, FloatBuffer paramFloatBuffer)
  {
    c("glFogfv");
    a("pname", n(paramInt));
    a("params", o(paramInt), paramFloatBuffer);
    b();
    this.f.glFogfv(paramInt, paramFloatBuffer);
    a();
  }
  
  public void glFogfv(int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    c("glFogfv");
    a("pname", n(paramInt1));
    a("params", o(paramInt1), paramArrayOfFloat, paramInt2);
    a("offset", paramInt2);
    b();
    this.f.glFogfv(paramInt1, paramArrayOfFloat, paramInt2);
    a();
  }
  
  public void glFogx(int paramInt1, int paramInt2)
  {
    c("glFogx");
    a("pname", n(paramInt1));
    a("param", paramInt2);
    b();
    this.f.glFogx(paramInt1, paramInt2);
    a();
  }
  
  public void glFogxv(int paramInt, IntBuffer paramIntBuffer)
  {
    c("glFogxv");
    a("pname", n(paramInt));
    a("params", o(paramInt), paramIntBuffer);
    b();
    this.f.glFogxv(paramInt, paramIntBuffer);
    a();
  }
  
  public void glFogxv(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    c("glFogxv");
    a("pname", n(paramInt1));
    a("params", o(paramInt1), paramArrayOfInt, paramInt2);
    a("offset", paramInt2);
    b();
    this.f.glFogxv(paramInt1, paramArrayOfInt, paramInt2);
    a();
  }
  
  public void glFrontFace(int paramInt)
  {
    c("glFrontFace");
    a("mode", paramInt);
    b();
    this.f.glFrontFace(paramInt);
    a();
  }
  
  public void glFrustumf(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    c("glFrustumf");
    a("left", paramFloat1);
    a("right", paramFloat2);
    a("bottom", paramFloat3);
    a("top", paramFloat4);
    a("near", paramFloat5);
    a("far", paramFloat6);
    b();
    this.f.glFrustumf(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    a();
  }
  
  public void glFrustumx(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    c("glFrustumx");
    a("left", paramInt1);
    a("right", paramInt2);
    a("bottom", paramInt3);
    a("top", paramInt4);
    a("near", paramInt5);
    a("far", paramInt6);
    b();
    this.f.glFrustumx(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    a();
  }
  
  public void glGenBuffers(int paramInt, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGenBuffers(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGenTextures(int paramInt, IntBuffer paramIntBuffer)
  {
    c("glGenTextures");
    a("n", paramInt);
    a("textures", paramIntBuffer.toString());
    this.f.glGenTextures(paramInt, paramIntBuffer);
    d(a(paramInt, 0, paramIntBuffer));
    a();
  }
  
  public void glGenTextures(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    c("glGenTextures");
    a("n", paramInt1);
    a("textures", Arrays.toString(paramArrayOfInt));
    a("offset", paramInt2);
    this.f.glGenTextures(paramInt1, paramArrayOfInt, paramInt2);
    d(a(paramInt1, 0, paramArrayOfInt, paramInt2));
    a();
  }
  
  public void glGetBooleanv(int paramInt, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetBooleanv(int paramInt1, boolean[] paramArrayOfBoolean, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetBufferParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetBufferParameteriv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetClipPlanef(int paramInt, FloatBuffer paramFloatBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetClipPlanef(int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetClipPlanex(int paramInt, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetClipPlanex(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public int glGetError()
  {
    c("glGetError");
    int i = this.f.glGetError();
    a(i);
    return i;
  }
  
  public void glGetFixedv(int paramInt, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetFixedv(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetFloatv(int paramInt, FloatBuffer paramFloatBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetFloatv(int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetIntegerv(int paramInt, IntBuffer paramIntBuffer)
  {
    c("glGetIntegerv");
    a("pname", r(paramInt));
    a("params", paramIntBuffer.toString());
    this.f.glGetIntegerv(paramInt, paramIntBuffer);
    d(a(s(paramInt), t(paramInt), paramIntBuffer));
    a();
  }
  
  public void glGetIntegerv(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    c("glGetIntegerv");
    a("pname", r(paramInt1));
    a("params", Arrays.toString(paramArrayOfInt));
    a("offset", paramInt2);
    this.f.glGetIntegerv(paramInt1, paramArrayOfInt, paramInt2);
    d(a(s(paramInt1), t(paramInt1), paramArrayOfInt, paramInt2));
    a();
  }
  
  public void glGetLightfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetLightfv(int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetLightxv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetLightxv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetMaterialfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetMaterialfv(int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetMaterialxv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetMaterialxv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public String glGetString(int paramInt)
  {
    c("glGetString");
    a("name", paramInt);
    String str = this.f.glGetString(paramInt);
    d(str);
    a();
    return str;
  }
  
  public void glGetTexEnviv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetTexEnviv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetTexEnvxv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetTexEnvxv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetTexParameterfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetTexParameterfv(int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetTexParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetTexParameteriv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetTexParameterxv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glGetTexParameterxv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glHint(int paramInt1, int paramInt2)
  {
    c("glHint");
    a("target", u(paramInt1));
    a("mode", v(paramInt2));
    b();
    this.f.glHint(paramInt1, paramInt2);
    a();
  }
  
  public boolean glIsBuffer(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean glIsEnabled(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean glIsTexture(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glLightModelf(int paramInt, float paramFloat)
  {
    c("glLightModelf");
    a("pname", C(paramInt));
    a("param", paramFloat);
    b();
    this.f.glLightModelf(paramInt, paramFloat);
    a();
  }
  
  public void glLightModelfv(int paramInt, FloatBuffer paramFloatBuffer)
  {
    c("glLightModelfv");
    a("pname", C(paramInt));
    a("params", D(paramInt), paramFloatBuffer);
    b();
    this.f.glLightModelfv(paramInt, paramFloatBuffer);
    a();
  }
  
  public void glLightModelfv(int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    c("glLightModelfv");
    a("pname", C(paramInt1));
    a("params", D(paramInt1), paramArrayOfFloat, paramInt2);
    a("offset", paramInt2);
    b();
    this.f.glLightModelfv(paramInt1, paramArrayOfFloat, paramInt2);
    a();
  }
  
  public void glLightModelx(int paramInt1, int paramInt2)
  {
    c("glLightModelx");
    a("pname", C(paramInt1));
    a("param", paramInt2);
    b();
    this.f.glLightModelx(paramInt1, paramInt2);
    a();
  }
  
  public void glLightModelxv(int paramInt, IntBuffer paramIntBuffer)
  {
    c("glLightModelfv");
    a("pname", C(paramInt));
    a("params", D(paramInt), paramIntBuffer);
    b();
    this.f.glLightModelxv(paramInt, paramIntBuffer);
    a();
  }
  
  public void glLightModelxv(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    c("glLightModelxv");
    a("pname", C(paramInt1));
    a("params", D(paramInt1), paramArrayOfInt, paramInt2);
    a("offset", paramInt2);
    b();
    this.f.glLightModelxv(paramInt1, paramArrayOfInt, paramInt2);
    a();
  }
  
  public void glLightf(int paramInt1, int paramInt2, float paramFloat)
  {
    c("glLightf");
    a("light", z(paramInt1));
    a("pname", A(paramInt2));
    a("param", paramFloat);
    b();
    this.f.glLightf(paramInt1, paramInt2, paramFloat);
    a();
  }
  
  public void glLightfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer)
  {
    c("glLightfv");
    a("light", z(paramInt1));
    a("pname", A(paramInt2));
    a("params", B(paramInt2), paramFloatBuffer);
    b();
    this.f.glLightfv(paramInt1, paramInt2, paramFloatBuffer);
    a();
  }
  
  public void glLightfv(int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    c("glLightfv");
    a("light", z(paramInt1));
    a("pname", A(paramInt2));
    a("params", B(paramInt2), paramArrayOfFloat, paramInt3);
    a("offset", paramInt3);
    b();
    this.f.glLightfv(paramInt1, paramInt2, paramArrayOfFloat, paramInt3);
    a();
  }
  
  public void glLightx(int paramInt1, int paramInt2, int paramInt3)
  {
    c("glLightx");
    a("light", z(paramInt1));
    a("pname", A(paramInt2));
    a("param", paramInt3);
    b();
    this.f.glLightx(paramInt1, paramInt2, paramInt3);
    a();
  }
  
  public void glLightxv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    c("glLightxv");
    a("light", z(paramInt1));
    a("pname", A(paramInt2));
    a("params", B(paramInt2), paramIntBuffer);
    b();
    this.f.glLightxv(paramInt1, paramInt2, paramIntBuffer);
    a();
  }
  
  public void glLightxv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    c("glLightxv");
    a("light", z(paramInt1));
    a("pname", A(paramInt2));
    a("params", B(paramInt2), paramArrayOfInt, paramInt3);
    a("offset", paramInt3);
    b();
    this.f.glLightxv(paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    a();
  }
  
  public void glLineWidth(float paramFloat)
  {
    c("glLineWidth");
    a("width", paramFloat);
    b();
    this.f.glLineWidth(paramFloat);
    a();
  }
  
  public void glLineWidthx(int paramInt)
  {
    c("glLineWidthx");
    a("width", paramInt);
    b();
    this.f.glLineWidthx(paramInt);
    a();
  }
  
  public void glLoadIdentity()
  {
    c("glLoadIdentity");
    b();
    this.f.glLoadIdentity();
    a();
  }
  
  public void glLoadMatrixf(FloatBuffer paramFloatBuffer)
  {
    c("glLoadMatrixf");
    a("m", 16, paramFloatBuffer);
    b();
    this.f.glLoadMatrixf(paramFloatBuffer);
    a();
  }
  
  public void glLoadMatrixf(float[] paramArrayOfFloat, int paramInt)
  {
    c("glLoadMatrixf");
    a("m", 16, paramArrayOfFloat, paramInt);
    a("offset", paramInt);
    b();
    this.f.glLoadMatrixf(paramArrayOfFloat, paramInt);
    a();
  }
  
  public void glLoadMatrixx(IntBuffer paramIntBuffer)
  {
    c("glLoadMatrixx");
    a("m", 16, paramIntBuffer);
    b();
    this.f.glLoadMatrixx(paramIntBuffer);
    a();
  }
  
  public void glLoadMatrixx(int[] paramArrayOfInt, int paramInt)
  {
    c("glLoadMatrixx");
    a("m", 16, paramArrayOfInt, paramInt);
    a("offset", paramInt);
    b();
    this.f.glLoadMatrixx(paramArrayOfInt, paramInt);
    a();
  }
  
  public void glLogicOp(int paramInt)
  {
    c("glLogicOp");
    a("opcode", paramInt);
    b();
    this.f.glLogicOp(paramInt);
    a();
  }
  
  public void glMaterialf(int paramInt1, int paramInt2, float paramFloat)
  {
    c("glMaterialf");
    a("face", w(paramInt1));
    a("pname", x(paramInt2));
    a("param", paramFloat);
    b();
    this.f.glMaterialf(paramInt1, paramInt2, paramFloat);
    a();
  }
  
  public void glMaterialfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer)
  {
    c("glMaterialfv");
    a("face", w(paramInt1));
    a("pname", x(paramInt2));
    a("params", y(paramInt2), paramFloatBuffer);
    b();
    this.f.glMaterialfv(paramInt1, paramInt2, paramFloatBuffer);
    a();
  }
  
  public void glMaterialfv(int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    c("glMaterialfv");
    a("face", w(paramInt1));
    a("pname", x(paramInt2));
    a("params", y(paramInt2), paramArrayOfFloat, paramInt3);
    a("offset", paramInt3);
    b();
    this.f.glMaterialfv(paramInt1, paramInt2, paramArrayOfFloat, paramInt3);
    a();
  }
  
  public void glMaterialx(int paramInt1, int paramInt2, int paramInt3)
  {
    c("glMaterialx");
    a("face", w(paramInt1));
    a("pname", x(paramInt2));
    a("param", paramInt3);
    b();
    this.f.glMaterialx(paramInt1, paramInt2, paramInt3);
    a();
  }
  
  public void glMaterialxv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    c("glMaterialxv");
    a("face", w(paramInt1));
    a("pname", x(paramInt2));
    a("params", y(paramInt2), paramIntBuffer);
    b();
    this.f.glMaterialxv(paramInt1, paramInt2, paramIntBuffer);
    a();
  }
  
  public void glMaterialxv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    c("glMaterialxv");
    a("face", w(paramInt1));
    a("pname", x(paramInt2));
    a("params", y(paramInt2), paramArrayOfInt, paramInt3);
    a("offset", paramInt3);
    b();
    this.f.glMaterialxv(paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    a();
  }
  
  public void glMatrixMode(int paramInt)
  {
    c("glMatrixMode");
    a("mode", j(paramInt));
    b();
    this.f.glMatrixMode(paramInt);
    a();
  }
  
  public void glMultMatrixf(FloatBuffer paramFloatBuffer)
  {
    c("glMultMatrixf");
    a("m", 16, paramFloatBuffer);
    b();
    this.f.glMultMatrixf(paramFloatBuffer);
    a();
  }
  
  public void glMultMatrixf(float[] paramArrayOfFloat, int paramInt)
  {
    c("glMultMatrixf");
    a("m", 16, paramArrayOfFloat, paramInt);
    a("offset", paramInt);
    b();
    this.f.glMultMatrixf(paramArrayOfFloat, paramInt);
    a();
  }
  
  public void glMultMatrixx(IntBuffer paramIntBuffer)
  {
    c("glMultMatrixx");
    a("m", 16, paramIntBuffer);
    b();
    this.f.glMultMatrixx(paramIntBuffer);
    a();
  }
  
  public void glMultMatrixx(int[] paramArrayOfInt, int paramInt)
  {
    c("glMultMatrixx");
    a("m", 16, paramArrayOfInt, paramInt);
    a("offset", paramInt);
    b();
    this.f.glMultMatrixx(paramArrayOfInt, paramInt);
    a();
  }
  
  public void glMultiTexCoord4f(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    c("glMultiTexCoord4f");
    a("target", paramInt);
    a("s", paramFloat1);
    a("t", paramFloat2);
    a("r", paramFloat3);
    a("q", paramFloat4);
    b();
    this.f.glMultiTexCoord4f(paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    a();
  }
  
  public void glMultiTexCoord4x(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    c("glMultiTexCoord4x");
    a("target", paramInt1);
    a("s", paramInt2);
    a("t", paramInt3);
    a("r", paramInt4);
    a("q", paramInt5);
    b();
    this.f.glMultiTexCoord4x(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    a();
  }
  
  public void glNormal3f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    c("glNormal3f");
    a("nx", paramFloat1);
    a("ny", paramFloat2);
    a("nz", paramFloat3);
    b();
    this.f.glNormal3f(paramFloat1, paramFloat2, paramFloat3);
    a();
  }
  
  public void glNormal3x(int paramInt1, int paramInt2, int paramInt3)
  {
    c("glNormal3x");
    a("nx", paramInt1);
    a("ny", paramInt2);
    a("nz", paramInt3);
    b();
    this.f.glNormal3x(paramInt1, paramInt2, paramInt3);
    a();
  }
  
  public void glNormalPointer(int paramInt1, int paramInt2, Buffer paramBuffer)
  {
    c("glNormalPointer");
    a("type", paramInt1);
    a("stride", paramInt2);
    a("pointer", paramBuffer.toString());
    b();
    this.o = new g(this, 3, paramInt1, paramInt2, paramBuffer);
    this.f.glNormalPointer(paramInt1, paramInt2, paramBuffer);
    a();
  }
  
  public void glOrthof(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    c("glOrthof");
    a("left", paramFloat1);
    a("right", paramFloat2);
    a("bottom", paramFloat3);
    a("top", paramFloat4);
    a("near", paramFloat5);
    a("far", paramFloat6);
    b();
    this.f.glOrthof(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    a();
  }
  
  public void glOrthox(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    c("glOrthox");
    a("left", paramInt1);
    a("right", paramInt2);
    a("bottom", paramInt3);
    a("top", paramInt4);
    a("near", paramInt5);
    a("far", paramInt6);
    b();
    this.f.glOrthox(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    a();
  }
  
  public void glPixelStorei(int paramInt1, int paramInt2)
  {
    c("glPixelStorei");
    a("pname", paramInt1);
    a("param", paramInt2);
    b();
    this.f.glPixelStorei(paramInt1, paramInt2);
    a();
  }
  
  public void glPointParameterf(int paramInt, float paramFloat)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glPointParameterfv(int paramInt, FloatBuffer paramFloatBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glPointParameterfv(int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glPointParameterx(int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glPointParameterxv(int paramInt, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glPointParameterxv(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glPointSize(float paramFloat)
  {
    c("glPointSize");
    a("size", paramFloat);
    b();
    this.f.glPointSize(paramFloat);
    a();
  }
  
  public void glPointSizePointerOES(int paramInt1, int paramInt2, Buffer paramBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glPointSizex(int paramInt)
  {
    c("glPointSizex");
    a("size", paramInt);
    b();
    this.f.glPointSizex(paramInt);
    a();
  }
  
  public void glPolygonOffset(float paramFloat1, float paramFloat2)
  {
    c("glPolygonOffset");
    a("factor", paramFloat1);
    a("units", paramFloat2);
    b();
    this.f.glPolygonOffset(paramFloat1, paramFloat2);
    a();
  }
  
  public void glPolygonOffsetx(int paramInt1, int paramInt2)
  {
    c("glPolygonOffsetx");
    a("factor", paramInt1);
    a("units", paramInt2);
    b();
    this.f.glPolygonOffsetx(paramInt1, paramInt2);
    a();
  }
  
  public void glPopMatrix()
  {
    c("glPopMatrix");
    b();
    this.f.glPopMatrix();
    a();
  }
  
  public void glPushMatrix()
  {
    c("glPushMatrix");
    b();
    this.f.glPushMatrix();
    a();
  }
  
  public int glQueryMatrixxOES(IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2)
  {
    c("glQueryMatrixxOES");
    a("mantissa", paramIntBuffer1.toString());
    a("exponent", paramIntBuffer2.toString());
    b();
    int i = this.g.glQueryMatrixxOES(paramIntBuffer1, paramIntBuffer2);
    d(a(16, 2, paramIntBuffer1));
    d(a(16, 0, paramIntBuffer2));
    a();
    return i;
  }
  
  public int glQueryMatrixxOES(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    c("glQueryMatrixxOES");
    a("mantissa", Arrays.toString(paramArrayOfInt1));
    a("exponent", Arrays.toString(paramArrayOfInt2));
    b();
    int i = this.g.glQueryMatrixxOES(paramArrayOfInt1, paramInt1, paramArrayOfInt2, paramInt2);
    d(a(16, 2, paramArrayOfInt1, paramInt1));
    d(a(16, 0, paramArrayOfInt2, paramInt2));
    a();
    return i;
  }
  
  public void glReadPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Buffer paramBuffer)
  {
    c("glReadPixels");
    a("x", paramInt1);
    a("y", paramInt2);
    a("width", paramInt3);
    a("height", paramInt4);
    a("format", paramInt5);
    a("type", paramInt6);
    a("pixels", paramBuffer.toString());
    b();
    this.f.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBuffer);
    a();
  }
  
  public void glRotatef(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    c("glRotatef");
    a("angle", paramFloat1);
    a("x", paramFloat2);
    a("y", paramFloat3);
    a("z", paramFloat4);
    b();
    this.f.glRotatef(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    a();
  }
  
  public void glRotatex(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c("glRotatex");
    a("angle", paramInt1);
    a("x", paramInt2);
    a("y", paramInt3);
    a("z", paramInt4);
    b();
    this.f.glRotatex(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
  }
  
  public void glSampleCoverage(float paramFloat, boolean paramBoolean)
  {
    c("glSampleCoveragex");
    a("value", paramFloat);
    a("invert", paramBoolean);
    b();
    this.f.glSampleCoverage(paramFloat, paramBoolean);
    a();
  }
  
  public void glSampleCoveragex(int paramInt, boolean paramBoolean)
  {
    c("glSampleCoveragex");
    a("value", paramInt);
    a("invert", paramBoolean);
    b();
    this.f.glSampleCoveragex(paramInt, paramBoolean);
    a();
  }
  
  public void glScalef(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    c("glScalef");
    a("x", paramFloat1);
    a("y", paramFloat2);
    a("z", paramFloat3);
    b();
    this.f.glScalef(paramFloat1, paramFloat2, paramFloat3);
    a();
  }
  
  public void glScalex(int paramInt1, int paramInt2, int paramInt3)
  {
    c("glScalex");
    a("x", paramInt1);
    a("y", paramInt2);
    a("z", paramInt3);
    b();
    this.f.glScalex(paramInt1, paramInt2, paramInt3);
    a();
  }
  
  public void glScissor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c("glScissor");
    a("x", paramInt1);
    a("y", paramInt2);
    a("width", paramInt3);
    a("height", paramInt4);
    b();
    this.f.glScissor(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
  }
  
  public void glShadeModel(int paramInt)
  {
    c("glShadeModel");
    a("mode", e(paramInt));
    b();
    this.f.glShadeModel(paramInt);
    a();
  }
  
  public void glStencilFunc(int paramInt1, int paramInt2, int paramInt3)
  {
    c("glStencilFunc");
    a("func", paramInt1);
    a("ref", paramInt2);
    a("mask", paramInt3);
    b();
    this.f.glStencilFunc(paramInt1, paramInt2, paramInt3);
    a();
  }
  
  public void glStencilMask(int paramInt)
  {
    c("glStencilMask");
    a("mask", paramInt);
    b();
    this.f.glStencilMask(paramInt);
    a();
  }
  
  public void glStencilOp(int paramInt1, int paramInt2, int paramInt3)
  {
    c("glStencilOp");
    a("fail", paramInt1);
    a("zfail", paramInt2);
    a("zpass", paramInt3);
    b();
    this.f.glStencilOp(paramInt1, paramInt2, paramInt3);
    a();
  }
  
  public void glTexCoordPointer(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer)
  {
    c("glTexCoordPointer");
    a(paramInt1, paramInt2, paramInt3, paramBuffer);
    b();
    this.p = new g(this, paramInt1, paramInt2, paramInt3, paramBuffer);
    this.f.glTexCoordPointer(paramInt1, paramInt2, paramInt3, paramBuffer);
    a();
  }
  
  public void glTexEnvf(int paramInt1, int paramInt2, float paramFloat)
  {
    c("glTexEnvf");
    a("target", g(paramInt1));
    a("pname", h(paramInt2));
    a("param", a(paramFloat));
    b();
    this.f.glTexEnvf(paramInt1, paramInt2, paramFloat);
    a();
  }
  
  public void glTexEnvfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer)
  {
    c("glTexEnvfv");
    a("target", g(paramInt1));
    a("pname", h(paramInt2));
    a("params", i(paramInt2), paramFloatBuffer);
    b();
    this.f.glTexEnvfv(paramInt1, paramInt2, paramFloatBuffer);
    a();
  }
  
  public void glTexEnvfv(int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    c("glTexEnvfv");
    a("target", g(paramInt1));
    a("pname", h(paramInt2));
    a("params", i(paramInt2), paramArrayOfFloat, paramInt3);
    a("offset", paramInt3);
    b();
    this.f.glTexEnvfv(paramInt1, paramInt2, paramArrayOfFloat, paramInt3);
    a();
  }
  
  public void glTexEnvi(int paramInt1, int paramInt2, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glTexEnviv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glTexEnviv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glTexEnvx(int paramInt1, int paramInt2, int paramInt3)
  {
    c("glTexEnvx");
    a("target", g(paramInt1));
    a("pname", h(paramInt2));
    a("param", paramInt3);
    b();
    this.f.glTexEnvx(paramInt1, paramInt2, paramInt3);
    a();
  }
  
  public void glTexEnvxv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    c("glTexEnvxv");
    a("target", g(paramInt1));
    a("pname", h(paramInt2));
    a("params", i(paramInt2), paramIntBuffer);
    b();
    this.f.glTexEnvxv(paramInt1, paramInt2, paramIntBuffer);
    a();
  }
  
  public void glTexEnvxv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    c("glTexEnvxv");
    a("target", g(paramInt1));
    a("pname", h(paramInt2));
    a("params", i(paramInt2), paramArrayOfInt, paramInt3);
    a("offset", paramInt3);
    b();
    this.f.glTexEnvxv(paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    a();
  }
  
  public void glTexImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Buffer paramBuffer)
  {
    c("glTexImage2D");
    a("target", paramInt1);
    a("level", paramInt2);
    a("internalformat", paramInt3);
    a("width", paramInt4);
    a("height", paramInt5);
    a("border", paramInt6);
    a("format", paramInt7);
    a("type", paramInt8);
    a("pixels", paramBuffer.toString());
    b();
    this.f.glTexImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBuffer);
    a();
  }
  
  public void glTexParameterf(int paramInt1, int paramInt2, float paramFloat)
  {
    c("glTexParameterf");
    a("target", f(paramInt1));
    a("pname", m(paramInt2));
    a("param", b(paramFloat));
    b();
    this.f.glTexParameterf(paramInt1, paramInt2, paramFloat);
    a();
  }
  
  public void glTexParameterfv(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glTexParameterfv(int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glTexParameteri(int paramInt1, int paramInt2, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glTexParameteriv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    c("glTexParameteriv");
    a("target", f(paramInt1));
    a("pname", m(paramInt2));
    a("params", 4, paramIntBuffer);
    b();
    this.h.glTexParameteriv(paramInt1, paramInt2, paramIntBuffer);
    a();
  }
  
  public void glTexParameteriv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    c("glTexParameteriv");
    a("target", f(paramInt1));
    a("pname", m(paramInt2));
    a("params", 4, paramArrayOfInt, paramInt3);
    b();
    this.h.glTexParameteriv(paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    a();
  }
  
  public void glTexParameterx(int paramInt1, int paramInt2, int paramInt3)
  {
    c("glTexParameterx");
    a("target", f(paramInt1));
    a("pname", m(paramInt2));
    a("param", paramInt3);
    b();
    this.f.glTexParameterx(paramInt1, paramInt2, paramInt3);
    a();
  }
  
  public void glTexParameterxv(int paramInt1, int paramInt2, IntBuffer paramIntBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glTexParameterxv(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    throw new UnsupportedOperationException();
  }
  
  public void glTexSubImage2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Buffer paramBuffer)
  {
    c("glTexSubImage2D");
    a("target", f(paramInt1));
    a("level", paramInt2);
    a("xoffset", paramInt3);
    a("yoffset", paramInt4);
    a("width", paramInt5);
    a("height", paramInt6);
    a("format", paramInt7);
    a("type", paramInt8);
    a("pixels", paramBuffer.toString());
    b();
    this.f.glTexSubImage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBuffer);
    a();
  }
  
  public void glTranslatef(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    c("glTranslatef");
    a("x", paramFloat1);
    a("y", paramFloat2);
    a("z", paramFloat3);
    b();
    this.f.glTranslatef(paramFloat1, paramFloat2, paramFloat3);
    a();
  }
  
  public void glTranslatex(int paramInt1, int paramInt2, int paramInt3)
  {
    c("glTranslatex");
    a("x", paramInt1);
    a("y", paramInt2);
    a("z", paramInt3);
    b();
    this.f.glTranslatex(paramInt1, paramInt2, paramInt3);
    a();
  }
  
  public void glVertexPointer(int paramInt1, int paramInt2, int paramInt3, Buffer paramBuffer)
  {
    c("glVertexPointer");
    a(paramInt1, paramInt2, paramInt3, paramBuffer);
    b();
    this.q = new g(this, paramInt1, paramInt2, paramInt3, paramBuffer);
    this.f.glVertexPointer(paramInt1, paramInt2, paramInt3, paramBuffer);
    a();
  }
  
  public void glViewport(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c("glViewport");
    a("x", paramInt1);
    a("y", paramInt2);
    a("width", paramInt3);
    a("height", paramInt4);
    b();
    this.f.glViewport(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */