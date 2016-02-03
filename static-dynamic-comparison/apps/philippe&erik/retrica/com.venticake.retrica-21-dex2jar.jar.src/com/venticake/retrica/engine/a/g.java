package com.venticake.retrica.engine.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.opengl.GLES20;
import android.util.Log;
import com.venticake.retrica.engine.RetricaRenderer;
import com.venticake.retrica.engine.Rotation;
import com.venticake.retrica.engine.TextureRotationUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends f
{
  public static final float[] a = { 0.0F, 0.0F, 1.0F, 1.0F };
  private String A = null;
  private String B = null;
  private String C = null;
  private float D = 1.0F;
  private int E = 0;
  private boolean F = false;
  private float G = 0.3F;
  private float H = 0.75F;
  private boolean I = false;
  private float J = 0.45F;
  private float K = 0.35F;
  private float L = 0.5F;
  private float M = 0.5F;
  private float N = 0.6F;
  private boolean O = false;
  private boolean P = false;
  private int Q = 0;
  private int R = 0;
  private int S = 0;
  private int T = 0;
  private boolean U = false;
  private float[] V = a;
  private boolean b = true;
  private c g;
  private int h;
  private int i;
  private List<f> j = null;
  private int[] k;
  private int[] l;
  private final FloatBuffer m = ByteBuffer.allocateDirect(RetricaRenderer.CUBE.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
  private final FloatBuffer n;
  private final FloatBuffer o;
  private Bitmap p = null;
  private ByteBuffer q = null;
  private String r = null;
  private String s = null;
  private int t = 0;
  private e u = null;
  private h v = null;
  private l w = null;
  private i x = null;
  private boolean y;
  private boolean z;
  
  public g()
  {
    this.m.put(RetricaRenderer.CUBE).position(0);
    this.n = ByteBuffer.allocateDirect(TextureRotationUtil.TEXTURE_NO_ROTATION.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.n.put(TextureRotationUtil.TEXTURE_NO_ROTATION).position(0);
    float[] arrayOfFloat = TextureRotationUtil.getRotation(Rotation.NORMAL, false, true);
    this.o = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.o.put(arrayOfFloat).position(0);
    this.D = com.venticake.retrica.setting.a.a().g();
  }
  
  public g(Context paramContext)
  {
    this(paramContext, "Test", "lookup_amatorka");
  }
  
  public g(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, paramString1, paramString2, false, false);
  }
  
  public g(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, boolean paramBoolean1, float paramFloat1, float paramFloat2, boolean paramBoolean2, float paramFloat3, float paramFloat4, boolean paramBoolean3, boolean paramBoolean4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this();
    this.r = paramString1;
    this.s = paramString2;
    this.A = paramString3;
    this.B = paramString4;
    this.C = paramString5;
    this.D = com.venticake.retrica.setting.a.a().g();
    this.E = paramInt;
    this.F = paramBoolean1;
    this.G = paramFloat1;
    this.H = paramFloat2;
    this.I = paramBoolean2;
    this.J = paramFloat3;
    this.K = paramFloat4;
    this.y = paramBoolean3;
    this.z = paramBoolean4;
    a(paramFloat5, paramFloat6);
    b(paramFloat7);
  }
  
  public g(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this();
    this.A = paramString1;
    this.r = paramString2;
    this.y = paramBoolean1;
    this.z = paramBoolean2;
    this.D = com.venticake.retrica.setting.a.a().g();
  }
  
  public g(JSONObject paramJSONObject)
  {
    this();
    try
    {
      this.r = paramJSONObject.getString("lookup_filename");
    }
    catch (JSONException localJSONException11)
    {
      try
      {
        this.s = paramJSONObject.getString("sample_filename");
      }
      catch (JSONException localJSONException11)
      {
        try
        {
          String str = paramJSONObject.getString("sample_color");
          if (str != null) {
            this.t = Color.parseColor("#" + str);
          }
        }
        catch (JSONException localJSONException11)
        {
          try
          {
            this.A = paramJSONObject.getString("t");
          }
          catch (JSONException localJSONException11)
          {
            try
            {
              this.B = paramJSONObject.getString("t_initial");
            }
            catch (JSONException localJSONException11)
            {
              try
              {
                this.C = paramJSONObject.getString("t_display");
              }
              catch (JSONException localJSONException11)
              {
                try
                {
                  this.E = paramJSONObject.getInt("v_type");
                }
                catch (JSONException localJSONException11)
                {
                  try
                  {
                    this.F = paramJSONObject.getBoolean("v_first");
                  }
                  catch (JSONException localJSONException11)
                  {
                    try
                    {
                      this.G = ((float)paramJSONObject.getDouble("v_start"));
                    }
                    catch (JSONException localJSONException11)
                    {
                      try
                      {
                        this.H = ((float)paramJSONObject.getDouble("v_end"));
                      }
                      catch (JSONException localJSONException11)
                      {
                        try
                        {
                          this.I = paramJSONObject.getBoolean("vh_use");
                        }
                        catch (JSONException localJSONException11)
                        {
                          try
                          {
                            for (;;)
                            {
                              this.J = ((float)paramJSONObject.getDouble("vh_end"));
                              try
                              {
                                this.K = ((float)paramJSONObject.getDouble("vh_weight"));
                                return;
                              }
                              catch (JSONException paramJSONObject)
                              {
                                paramJSONObject.printStackTrace();
                              }
                              localJSONException1 = localJSONException1;
                              localJSONException1.printStackTrace();
                              continue;
                              localJSONException2 = localJSONException2;
                              localJSONException2.printStackTrace();
                              continue;
                              localJSONException3 = localJSONException3;
                              localJSONException3.printStackTrace();
                              continue;
                              localJSONException4 = localJSONException4;
                              localJSONException4.printStackTrace();
                              continue;
                              localJSONException5 = localJSONException5;
                              localJSONException5.printStackTrace();
                              continue;
                              localJSONException6 = localJSONException6;
                              localJSONException6.printStackTrace();
                              continue;
                              localJSONException7 = localJSONException7;
                              localJSONException7.printStackTrace();
                              continue;
                              localJSONException8 = localJSONException8;
                              localJSONException8.printStackTrace();
                              continue;
                              localJSONException9 = localJSONException9;
                              localJSONException9.printStackTrace();
                              continue;
                              localJSONException10 = localJSONException10;
                              localJSONException10.printStackTrace();
                              continue;
                              localJSONException11 = localJSONException11;
                              localJSONException11.printStackTrace();
                            }
                          }
                          catch (JSONException localJSONException12)
                          {
                            for (;;)
                            {
                              localJSONException12.printStackTrace();
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private Context D()
  {
    return a.a();
  }
  
  private void E()
  {
    Iterator localIterator;
    if ((this.j != null) && (this.j.size() > 0)) {
      localIterator = this.j.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((f)localIterator.next()).f();
    }
  }
  
  private void F()
  {
    Iterator localIterator;
    if ((this.j != null) && (this.j.size() > 0)) {
      localIterator = this.j.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((f)localIterator.next()).h();
    }
  }
  
  private boolean G()
  {
    return d(this.Q, this.R);
  }
  
  private void H()
  {
    if (this.l != null)
    {
      GLES20.glDeleteTextures(this.l.length, this.l, 0);
      this.l = null;
    }
    if (this.k != null)
    {
      GLES20.glDeleteFramebuffers(this.k.length, this.k, 0);
      this.k = null;
    }
    if (this.i != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { this.i }, 0);
      this.i = -1;
    }
    if (this.h > 0)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.h }, 0);
      this.h = 0;
    }
  }
  
  private void I()
  {
    ArrayList localArrayList = new ArrayList();
    if (!this.b)
    {
      this.g = new c();
      localArrayList.add(this.g);
      if (!Arrays.equals(this.V, a))
      {
        this.g.a(this.U);
        this.g.a(this.V);
      }
      if (!y()) {
        break label448;
      }
      this.w = new l();
      this.w.a(this.E);
      this.w.a(this.G);
      this.w.b(this.H);
      if (!this.I) {
        break label437;
      }
      this.w.b(1);
      this.w.c(this.J);
      this.w.d(this.K);
      label158:
      if ((this.F) && (this.w != null)) {
        localArrayList.add(this.w);
      }
      if (this.v != null) {
        break label456;
      }
      Log.d("lookup", "new lookup" + this.r);
      this.v = new h();
      if (this.D < 1.0F) {
        this.v.a(this.D);
      }
      a(D(), this.r);
    }
    for (;;)
    {
      localArrayList.add(this.v);
      if ((!this.F) && (this.w != null)) {
        localArrayList.add(this.w);
      }
      if (z())
      {
        this.x = new i();
        this.x.a(this.U);
        this.x.a(this.L, this.M);
        this.x.a(this.N);
        localArrayList.add(this.x);
        t();
      }
      this.j = localArrayList;
      return;
      if (Arrays.equals(this.V, a))
      {
        this.u = null;
        break;
      }
      if (this.u == null) {
        this.u = new e();
      }
      this.u.a(this.U);
      this.u.a(this.V);
      localArrayList.add(this.u);
      break;
      label437:
      this.w.b(0);
      break label158;
      label448:
      this.w = null;
      break label158;
      label456:
      Log.d("lookup", "NO new lookup - " + this.r);
    }
  }
  
  private boolean d(int paramInt1, int paramInt2)
  {
    this.Q = paramInt1;
    this.R = paramInt2;
    if ((this.Q < 1) || (this.R < 1) || ((!this.b) && ((this.S < 1) || (this.T < 1)))) {
      return false;
    }
    int i1;
    if (this.j.size() > 0)
    {
      this.k = new int[this.j.size() - 1];
      this.l = new int[this.j.size() - 1];
      i1 = 0;
      if (i1 >= this.j.size() - 1) {
        ((f)this.j.get(this.j.size() - 1)).a(paramInt1, paramInt2);
      }
    }
    for (;;)
    {
      this.h = 0;
      this.i = -1;
      return true;
      ((f)this.j.get(i1)).a(paramInt1, paramInt2);
      GLES20.glGenFramebuffers(1, this.k, i1);
      GLES20.glGenTextures(1, this.l, i1);
      GLES20.glBindTexture(3553, this.l[i1]);
      if (this.b) {
        GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      }
      for (;;)
      {
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glBindFramebuffer(36160, this.k[i1]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.l[i1], 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        i1 += 1;
        break;
        GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      }
      this.k = null;
      this.l = null;
    }
  }
  
  public void A()
  {
    if (this.x == null) {
      return;
    }
    this.x.a();
  }
  
  public void B()
  {
    if (this.x == null) {
      return;
    }
    this.x.b();
  }
  
  public int C()
  {
    return this.t;
  }
  
  public g a(Context paramContext)
  {
    return new g(paramContext, this.r, this.s, this.A, this.B, this.C, this.E, this.F, this.G, this.H, this.I, this.J, this.K, this.y, this.z, this.L, this.M, this.N);
  }
  
  @SuppressLint({"DefaultLocale"})
  public String a()
  {
    return this.s.replace("-", "_").replace(".png", "").toLowerCase();
  }
  
  public void a(float paramFloat)
  {
    this.D = paramFloat;
    if (this.v == null) {
      return;
    }
    this.v.a(this.D);
    com.venticake.retrica.setting.a.a().a(this.D);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.L = paramFloat1;
    this.M = paramFloat2;
    if (this.x == null) {
      return;
    }
    this.x.a(this.L, this.M);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Log.d("retrica", "onOutputSizeChanged: " + paramInt1 + ", " + paramInt2);
    if ((this.Q != paramInt1) || (this.R != paramInt2))
    {
      this.Q = paramInt1;
      this.R = paramInt2;
      H();
    }
  }
  
  @SuppressLint({"WrongCall"})
  public void a(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    k();
    r();
    t();
    if (!l()) {}
    while (((this.k == null) || (this.l == null)) && ((!G()) || (this.j.size() <= 0))) {
      return;
    }
    if (this.j.size() > 1)
    {
      int i2 = -1;
      int i1 = 0;
      Object localObject;
      if (i1 >= this.j.size() - 1)
      {
        localObject = (f)this.j.get(this.j.size() - 1);
        if (this.j.size() % 2 != 0) {
          break label269;
        }
      }
      label269:
      for (paramFloatBuffer2 = this.o;; paramFloatBuffer2 = this.n)
      {
        ((f)localObject).a(i2, paramFloatBuffer1, paramFloatBuffer2);
        return;
        f localf = (f)this.j.get(i1);
        GLES20.glBindFramebuffer(36160, this.k[i1]);
        if (i1 == 0)
        {
          this.g.a(paramInt1, paramInt2, paramFloatBuffer1, paramFloatBuffer2);
          GLES20.glBindFramebuffer(36160, 0);
          i2 = this.l[i1];
          i1 += 1;
          break;
        }
        FloatBuffer localFloatBuffer = this.m;
        if ((i1 == 0) && (this.j.size() % 2 == 0)) {}
        for (localObject = this.o;; localObject = this.n)
        {
          localf.a(i2, localFloatBuffer, (FloatBuffer)localObject);
          break;
        }
      }
    }
    ((f)this.j.get(this.j.size() - 1)).a(-1, paramFloatBuffer1, paramFloatBuffer2);
  }
  
  @SuppressLint({"WrongCall"})
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    k();
    r();
    t();
    if (!l()) {}
    while (((this.k == null) || (this.l == null)) && (!G())) {
      return;
    }
    if (this.j.size() > 1)
    {
      int i2 = 0;
      int i1 = paramInt;
      paramInt = i2;
      Object localObject;
      if (paramInt >= this.j.size() - 1)
      {
        localObject = (f)this.j.get(this.j.size() - 1);
        if (this.j.size() % 2 != 0) {
          break label257;
        }
      }
      label257:
      for (paramFloatBuffer2 = this.o;; paramFloatBuffer2 = this.n)
      {
        ((f)localObject).a(i1, paramFloatBuffer1, paramFloatBuffer2);
        return;
        f localf = (f)this.j.get(paramInt);
        GLES20.glBindFramebuffer(36160, this.k[paramInt]);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        if (paramInt == 0)
        {
          localf.a(i1, this.m, paramFloatBuffer2);
          GLES20.glBindFramebuffer(36160, 0);
          i1 = this.l[paramInt];
          paramInt += 1;
          break;
        }
        FloatBuffer localFloatBuffer = this.m;
        if ((paramInt == 0) && (this.j.size() % 2 == 0)) {}
        for (localObject = this.o;; localObject = this.n)
        {
          localf.a(i1, localFloatBuffer, (FloatBuffer)localObject);
          break;
        }
      }
    }
    ((f)this.j.get(this.j.size() - 1)).a(paramInt, paramFloatBuffer1, paramFloatBuffer2);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f2;
    float f1;
    switch (paramInt)
    {
    default: 
      f2 = paramFloat2;
      f1 = paramFloat1;
    }
    for (;;)
    {
      a(f1, f2);
      b(paramFloat3);
      return;
      f1 = paramFloat1;
      f2 = paramFloat2;
      if (paramBoolean1)
      {
        f1 = paramFloat1;
        f2 = paramFloat2;
        if (!paramBoolean2)
        {
          f1 = 1.0F - paramFloat1;
          f2 = paramFloat2;
          continue;
          if (paramBoolean1)
          {
            if (paramBoolean2)
            {
              f1 = 1.0F - paramFloat1;
              f2 = 1.0F - paramFloat2;
            }
            else
            {
              f1 = 1.0F - paramFloat1;
              f2 = paramFloat2;
            }
          }
          else
          {
            f1 = 1.0F - paramFloat1;
            f2 = 1.0F - paramFloat2;
          }
        }
      }
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    this.r = paramString;
    b(paramContext);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b == paramBoolean) {
      return;
    }
    this.b = paramBoolean;
    h();
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    if (Arrays.equals(this.V, paramArrayOfFloat)) {}
    int i1;
    do
    {
      return;
      this.V = paramArrayOfFloat;
      i1 = 1;
      int i2 = 1;
      if (!Arrays.equals(this.V, a))
      {
        i1 = i2;
        if (this.g != null)
        {
          this.g.a(this.V);
          i1 = 0;
        }
        if (this.u != null)
        {
          this.u.a(this.V);
          i1 = 0;
        }
      }
    } while (i1 == 0);
    q();
  }
  
  public void b()
  {
    if (this.p == null) {
      return;
    }
    Log.d("retrica", "unloadLookupTableBitmap: " + toString());
    Log.d("lookup", "unloadLookupTableBitmap: " + toString());
    if (this.v != null)
    {
      this.v.a(null);
      this.v = null;
    }
    this.p.recycle();
    this.p = null;
  }
  
  public void b(float paramFloat)
  {
    this.N = paramFloat;
    if (this.x == null) {
      return;
    }
    this.x.a(this.N);
  }
  
  public void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = paramFloat1;
    float f2 = paramFloat2;
    switch (paramInt)
    {
    default: 
      f2 = paramFloat2;
      f1 = paramFloat1;
    }
    for (;;)
    {
      a(f1, f2);
      b(paramFloat3);
      return;
      f1 = 1.0F - paramFloat1;
      f2 = 1.0F - paramFloat2;
      continue;
      f2 = 1.0F - paramFloat1;
      f1 = paramFloat2;
      continue;
      f1 = 1.0F - paramFloat2;
      f2 = paramFloat1;
    }
  }
  
  public void b(Context paramContext)
  {
    Log.d("aes", "load Lookup Bitmap START");
    Log.d("lookup", "load Lookup Bitmap: " + this.r);
    paramContext = paramContext.getAssets();
    try
    {
      paramContext = paramContext.open(this.r.concat(".png.enc"));
      Log.d("lookup", "ims: " + paramContext);
      Log.d("aes", "   - source loaded : " + this.r);
      this.p = null;
      if (paramContext != null)
      {
        localObject = new ByteArrayOutputStream();
        arrayOfByte = new byte[65535];
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          i1 = paramContext.read(arrayOfByte);
          if (i1 == -1)
          {
            ((ByteArrayOutputStream)localObject).flush();
            Log.d("aes", "   - buffer created");
            localObject = com.venticake.retrica.util.a.b(((ByteArrayOutputStream)localObject).toByteArray());
            Log.d("aes", "   - " + localObject.length + " bytes (" + localObject.length / 1024 + " KB) decrypted");
            this.p = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
            Log.d("aes", "mLookupTableBitmap: " + this.p);
            if (this.p != null) {
              Log.d("aes", "   " + this.p.getWidth() + ", " + this.p.getHeight());
            }
            this.q = ByteBuffer.allocate(this.p.getWidth() * this.p.getHeight() * 4);
            this.p.copyPixelsToBuffer(this.q);
            Log.d("aes", "mLookupTableByteBuffer: " + this.q);
          }
        }
        catch (IOException localIOException)
        {
          try
          {
            Object localObject;
            byte[] arrayOfByte;
            int i1;
            paramContext.close();
            Log.d("lookup", "setBitmap: " + this.p);
            this.v.a(this.p);
            Log.d("aes", "load Lookup Bitmap FINISH");
            return;
            paramContext = paramContext;
            paramContext.printStackTrace();
            paramContext = null;
            continue;
            ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, i1);
            continue;
            localIOException = localIOException;
            localIOException.printStackTrace();
          }
          catch (IOException paramContext)
          {
            paramContext.printStackTrace();
            continue;
          }
        }
        this.v.a(null);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.U = paramBoolean;
    if (this.g != null) {
      this.g.a(paramBoolean);
    }
    if (this.u != null) {
      this.u.a(paramBoolean);
    }
    if (this.x != null) {
      this.x.a(paramBoolean);
    }
  }
  
  public void c()
  {
    super.c();
    I();
    E();
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    Log.d("retrica", "setSourceSize: " + paramInt1 + ", " + paramInt2);
    this.S = paramInt1;
    this.T = paramInt2;
  }
  
  public void c(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public void i()
  {
    H();
    F();
    q();
    super.i();
    Log.d("retrica", "lens destroyed: " + toString());
  }
  
  public void p()
  {
    GLES20.glUseProgram(o());
  }
  
  public void q()
  {
    this.O = true;
  }
  
  public void r()
  {
    if (this.O)
    {
      this.O = false;
      F();
      H();
      I();
      E();
    }
  }
  
  public void s()
  {
    this.P = true;
  }
  
  public void t()
  {
    if ((this.x == null) || (!z())) {}
    while (!this.P) {
      return;
    }
    this.P = false;
    this.x.p();
  }
  
  public String toString()
  {
    return "[" + v() + "] - title: " + this.A;
  }
  
  public ByteBuffer u()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(m() * n() * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    localByteBuffer.position(0);
    GLES20.glReadPixels(0, 0, m(), n(), 6408, 5121, localByteBuffer);
    return localByteBuffer;
  }
  
  public String v()
  {
    return this.r.replace("lookup_", "");
  }
  
  public String w()
  {
    return this.A;
  }
  
  public String x()
  {
    return this.C;
  }
  
  public boolean y()
  {
    return this.y;
  }
  
  public boolean z()
  {
    return this.z;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/engine/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */