package com.venticake.retrica;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import com.venticake.retrica.engine.BufferPictureCallback;
import com.venticake.retrica.setting.a;
import com.venticake.retrica.setting.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.List<*>;

public class i
{
  private static int j = 1024;
  private static int k = 1024;
  private static int l = 768;
  public BufferPictureCallback a = new BufferPictureCallback()
  {
    public void callback(ByteBuffer paramAnonymousByteBuffer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      i.a(i.this, 0.1F);
      Object localObject = new byte[paramAnonymousByteBuffer.remaining()];
      paramAnonymousByteBuffer.get((byte[])localObject);
      paramAnonymousByteBuffer = Bitmap.createBitmap(paramAnonymousInt1, paramAnonymousInt2, Bitmap.Config.ARGB_8888);
      paramAnonymousByteBuffer.copyPixelsFromBuffer(ByteBuffer.wrap((byte[])localObject, 0, localObject.length));
      i.a(i.this, 0.5F);
      if (a.a().j())
      {
        int i = i.a(paramAnonymousInt1, paramAnonymousInt2);
        localObject = Bitmap.createBitmap(i * 2 + paramAnonymousInt1, i * 2 + paramAnonymousInt2, Bitmap.Config.ARGB_8888);
        i.a(i.this, 0.6F);
        Canvas localCanvas = new Canvas((Bitmap)localObject);
        if (a.a().l() == 1) {
          localCanvas.drawColor(-1);
        }
        i.a(i.this, 0.7F);
        localCanvas.drawBitmap(paramAnonymousByteBuffer, i, i, null);
        i.a(i.this, 0.9F);
        paramAnonymousByteBuffer = (ByteBuffer)localObject;
      }
      for (;;)
      {
        i.a(i.this, 1.0F);
        boolean bool;
        if (a.a().q()) {
          if ((i.a(i.this).p()) && (!a.a().r()))
          {
            bool = false;
            paramAnonymousByteBuffer = b.a(i.a(i.this), paramAnonymousByteBuffer, i.a(i.this).g, 1, bool);
          }
        }
        for (;;)
        {
          if ((i.a(i.this).p()) && (!a.a().r())) {}
          for (bool = true;; bool = false)
          {
            paramAnonymousByteBuffer = new g(i.a(i.this)).a(paramAnonymousByteBuffer, i.a(i.this).g, i.a(i.this).r(), false, bool, i.a(i.this).z());
            if (paramAnonymousByteBuffer != null) {
              break label332;
            }
            i.a(i.this).u();
            return;
            bool = true;
            break;
          }
          label332:
          Log.i("Retrica", "hjh ImageComposition savedUri" + paramAnonymousByteBuffer);
          i.a(i.this).a(paramAnonymousByteBuffer, "RenderedPicture");
          return;
        }
      }
    }
  };
  public BufferPictureCallback b = new BufferPictureCallback()
  {
    public void callback(ByteBuffer paramAnonymousByteBuffer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      byte[] arrayOfByte = new byte[paramAnonymousByteBuffer.remaining()];
      paramAnonymousByteBuffer.get(arrayOfByte);
      paramAnonymousByteBuffer = Bitmap.createBitmap(paramAnonymousInt1, paramAnonymousInt2, Bitmap.Config.ARGB_8888);
      paramAnonymousByteBuffer.copyPixelsFromBuffer(ByteBuffer.wrap(arrayOfByte, 0, arrayOfByte.length));
      Log.d("retrica", "Activity.Orientation: " + i.a(i.this).g + " , set Orientation: " + i.b(i.this) + ", set FlipHori: " + i.c(i.this));
      paramAnonymousByteBuffer = i.a(paramAnonymousByteBuffer, i.b(i.this), i.c(i.this));
      i.a(i.this).l.add(paramAnonymousByteBuffer);
      if (i.d(i.this) != null) {
        i.e(i.this).post(new Runnable()
        {
          public void run()
          {
            try
            {
              i.d(i.this).a(i.a(i.this).l.size());
              return;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        });
      }
    }
  };
  private j c = null;
  private k d = null;
  private k e = null;
  private MainActivity f;
  private Handler g = null;
  private int h = 0;
  private boolean i = false;
  
  public i(MainActivity paramMainActivity)
  {
    this.f = paramMainActivity;
    this.c = null;
    this.d = null;
    this.e = null;
    this.g = new Handler();
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    double d2;
    if (paramInt1 > paramInt2)
    {
      d2 = paramInt1;
      if (a.a().k() != 1) {
        break label41;
      }
    }
    label41:
    for (double d1 = 0.01D;; d1 = 0.02D)
    {
      paramInt1 = (int)(d1 * d2);
      if (paramInt1 >= 5) {
        return paramInt1;
      }
      return 5;
      paramInt1 = paramInt2;
      break;
    }
    return paramInt1;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int m = a(paramInt1, paramInt2);
    Bitmap localBitmap = Bitmap.createBitmap(m * 2 + paramInt1, m * 2 + paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    if (a.a().l() == 1) {
      localCanvas.drawColor(-1);
    }
    localCanvas.drawBitmap(paramBitmap, m, m, null);
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return b(paramBitmap, 0, paramBoolean);
    case 2: 
      return b(paramBitmap, 180, paramBoolean);
    case 1: 
      return b(paramBitmap, 90, paramBoolean);
    }
    return b(paramBitmap, 270, paramBoolean);
  }
  
  private Bitmap a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Bitmap)) {
      return (Bitmap)paramObject;
    }
    Object localObject1;
    if ((paramObject instanceof String))
    {
      localObject1 = Uri.parse((String)paramObject);
      if ((paramObject instanceof Uri)) {
        localObject1 = (Uri)paramObject;
      }
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = MediaStore.Images.Media.getBitmap(this.f.getContentResolver(), (Uri)localObject1);
        switch (this.h)
        {
        case 0: 
          localObject1 = g.a((Bitmap)localObject1, paramInt, m, true);
          return (Bitmap)localObject1;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        Log.e("retrica", "ERROR - cannot getBitmap: " + paramObject);
        return null;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        continue;
      }
      int m = -90;
      continue;
      m = 90;
      continue;
      m = 0;
      continue;
      m = 180;
      continue;
      Object localObject2 = null;
      break;
      m = 0;
    }
  }
  
  private void a(float paramFloat)
  {
    if (this.d != null) {
      this.d.a(paramFloat);
    }
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 9: 
    case 10: 
    case 19: 
    case 20: 
    default: 
      return 0;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 7: 
    case 8: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 17: 
    case 18: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 27: 
    case 28: 
      return j;
    case 5: 
    case 15: 
    case 25: 
      return k;
    }
    return l;
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramBitmap == null) {
      localObject = null;
    }
    for (;;)
    {
      return (Bitmap)localObject;
      if (paramInt == 0)
      {
        localObject = paramBitmap;
        if (!paramBoolean) {}
      }
      else
      {
        localObject = new Matrix();
        ((Matrix)localObject).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
        if (paramBoolean)
        {
          ((Matrix)localObject).postScale(-1.0F, 1.0F);
          ((Matrix)localObject).postTranslate(paramBitmap.getWidth(), 0.0F);
        }
        try
        {
          Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
          localObject = paramBitmap;
          if (paramBitmap != localBitmap)
          {
            paramBitmap.recycle();
            return localBitmap;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError) {}
      }
    }
    return paramBitmap;
  }
  
  private void b(float paramFloat)
  {
    if (this.e != null) {
      this.e.a(paramFloat);
    }
  }
  
  public static int c(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 90;
    case 2: 
      return 180;
    }
    return 270;
  }
  
  public Bitmap a(int paramInt1, List<?> paramList, int paramInt2)
  {
    Object localObject = a(paramList.get(0), j);
    int m = ((Bitmap)localObject).getWidth();
    int n = ((Bitmap)localObject).getHeight();
    a(0.0F);
    int i4 = 0;
    int i5 = 0;
    int i1 = 0;
    int i3 = 0;
    int i2 = 0;
    switch (paramInt1)
    {
    case 5: 
    case 6: 
    case 9: 
    case 10: 
    case 15: 
    case 16: 
    case 19: 
    case 20: 
    case 25: 
    case 26: 
    default: 
      paramInt2 = 0;
      paramList = null;
      paramInt1 = i1;
      a(0.8F);
      localObject = new Matrix();
      ((Matrix)localObject).preScale(1.0F, -1.0F);
      localObject = Bitmap.createBitmap(paramList, 0, 0, paramInt1, paramInt2, (Matrix)localObject, false);
      a(0.9F);
      paramList = (List<?>)localObject;
      if (a.a().q()) {
        paramList = b.a(this.f, (Bitmap)localObject, -1, 2, false);
      }
      a(1.0F);
      this.d = null;
      return paramList;
    case 2: 
    case 4: 
    case 7: 
    case 12: 
    case 14: 
    case 17: 
    case 21: 
    case 23: 
    case 28: 
      switch (paramInt1)
      {
      default: 
        paramInt1 = i4;
        i1 = i2;
        label355:
        a(0.1F);
        i2 = paramInt1 / paramInt2;
        if (a.a().j())
        {
          n = a(m, n);
          paramInt1 += (paramInt2 + 1) * n;
          m = i1 + n * 2;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      localObject = Bitmap.createBitmap(paramInt1, m, Bitmap.Config.ARGB_8888);
      a(0.3F);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      if (a.a().l() == 1) {
        localCanvas.drawColor(-1);
      }
      localCanvas.drawBitmap(a(paramList.get(0), j), n * 1, n, null);
      localCanvas.drawBitmap(a(paramList.get(1), j), n * 2 + i2, n, null);
      a(0.5F);
      switch (paramInt2)
      {
      }
      for (;;)
      {
        localCanvas.save();
        a(0.7F);
        paramList = (List<?>)localObject;
        paramInt2 = m;
        break;
        paramInt1 = m * paramInt2;
        i1 = n;
        break label355;
        if (m > n) {}
        for (i1 = n;; i1 = m)
        {
          paramInt1 = i1 * paramInt2;
          break;
        }
        if (m > n) {}
        for (i1 = m;; i1 = n)
        {
          paramInt1 = i1;
          break;
        }
        localCanvas.drawBitmap(a(paramList.get(2), j), i2 * 2 + n * 3, n, null);
        continue;
        localCanvas.drawBitmap(a(paramList.get(2), j), n * 3 + i2 * 2, n, null);
        localCanvas.drawBitmap(a(paramList.get(3), j), i2 * 3 + n * 4, n, null);
      }
      switch (paramInt1)
      {
      default: 
        paramInt1 = i5;
        i1 = i3;
        label815:
        a(0.1F);
        i2 = i1 / paramInt2;
        if (a.a().j())
        {
          n = a(m, n);
          paramInt1 += n * 2;
          m = i1 + (paramInt2 + 1) * n;
        }
        break;
      }
      for (;;)
      {
        localObject = Bitmap.createBitmap(paramInt1, m, Bitmap.Config.ARGB_8888);
        a(0.3F);
        localCanvas = new Canvas((Bitmap)localObject);
        if (a.a().l() == 1) {
          localCanvas.drawColor(-1);
        }
        localCanvas.drawBitmap(a(paramList.get(paramList.size() - 1), j), n, n, null);
        localCanvas.drawBitmap(a(paramList.get(paramList.size() - 2), j), n, n * 2 + i2, null);
        a(0.5F);
        switch (paramInt2)
        {
        }
        for (;;)
        {
          localCanvas.save();
          a(0.7F);
          paramList = (List<?>)localObject;
          paramInt2 = m;
          break;
          i1 = n * paramInt2;
          paramInt1 = m;
          break label815;
          if (m > n) {}
          for (paramInt1 = n;; paramInt1 = m)
          {
            i2 = paramInt1;
            i1 = paramInt1 * paramInt2;
            paramInt1 = i2;
            break;
          }
          if (m > n) {}
          for (i1 = m;; i1 = n)
          {
            paramInt1 = i1;
            break;
          }
          localCanvas.drawBitmap(a(paramList.get(paramList.size() - 3), j), n, n * 3 + i2 * 2, null);
          continue;
          localCanvas.drawBitmap(a(paramList.get(paramList.size() - 3), j), n, n * 3 + i2 * 2, null);
          localCanvas.drawBitmap(a(paramList.get(paramList.size() - 4), j), n, n * 4 + i2 * 3, null);
        }
        m = i1;
        n = 0;
      }
      m = i1;
      n = 0;
    }
  }
  
  public Bitmap a(int paramInt, List<?> paramList, k paramk)
  {
    this.d = paramk;
    switch (paramInt)
    {
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    default: 
      return a(paramInt, paramList, paramList.size());
    case 6: 
    case 16: 
    case 26: 
      return b(paramList);
    case 5: 
    case 15: 
    case 25: 
      return a(paramList);
    }
    return a(paramInt, paramList, 4);
  }
  
  public Bitmap a(List<?> paramList)
  {
    a(0.0F);
    Bitmap localBitmap2 = a(paramList.get(0), k);
    int n = localBitmap2.getWidth();
    int i1 = localBitmap2.getHeight();
    if (a.a().j()) {}
    for (int m = a(n, i1);; m = 0)
    {
      int i2 = m * 3 + n * 2;
      int i3 = m * 3 + i1 * 2;
      a(0.2F);
      Bitmap localBitmap1 = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
      a(0.4F);
      Canvas localCanvas = new Canvas(localBitmap1);
      if (a.a().l() == 1) {
        localCanvas.drawColor(-1);
      }
      localCanvas.drawBitmap(a(paramList.get(2), k), m, m, null);
      localCanvas.drawBitmap(a(paramList.get(3), k), m * 2 + n, m, null);
      a(0.6F);
      localCanvas.drawBitmap(localBitmap2, m, m * 2 + i1, null);
      localCanvas.drawBitmap(a(paramList.get(1), k), n + m * 2, m * 2 + i1, null);
      a(0.8F);
      paramList = new Matrix();
      paramList.preScale(1.0F, -1.0F);
      localBitmap1 = Bitmap.createBitmap(localBitmap1, 0, 0, i2, i3, paramList, false);
      a(0.9F);
      paramList = localBitmap1;
      if (a.a().q()) {
        paramList = b.a(this.f, localBitmap1, -1, 2, false);
      }
      a(1.0F);
      this.d = null;
      return paramList;
    }
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(j paramj)
  {
    this.c = paramj;
  }
  
  public void a(k paramk)
  {
    this.e = paramk;
  }
  
  public void a(File paramFile, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramFile = g.a(paramFile, paramArrayOfByte, paramInt, paramBoolean1, paramBoolean2, null);
    Log.d("take", "imageUri: ori(" + paramInt + ") f: " + this.i + " - " + paramFile);
    this.f.m.add(paramFile);
    if (this.c != null) {
      this.g.post(new Runnable()
      {
        public void run()
        {
          i.d(i.this).a(i.a(i.this).m.size());
        }
      });
    }
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    this.g.postDelayed(paramRunnable, paramLong);
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public Bitmap b(List<?> paramList)
  {
    a(0.0F);
    Object localObject = a(paramList.get(0), l);
    int n = ((Bitmap)localObject).getWidth();
    int i1 = ((Bitmap)localObject).getHeight();
    if (a.a().j()) {}
    for (int m = a(n, i1);; m = 0)
    {
      int i2 = n * 3 + m * 4;
      int i3 = i1 * 3 + m * 4;
      a(0.1F);
      Bitmap localBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
      if (localBitmap != null) {
        localObject = new Canvas(localBitmap);
      }
      for (;;)
      {
        if (a.a().l() == 1) {
          ((Canvas)localObject).drawColor(-1);
        }
        a(0.2F);
        ((Canvas)localObject).drawBitmap(a(paramList.get(6), l), m, m, null);
        ((Canvas)localObject).drawBitmap(a(paramList.get(3), l), m, m * 2 + i1, null);
        ((Canvas)localObject).drawBitmap(a(paramList.get(0), l), m, m * 3 + i1 * 2, null);
        a(0.4F);
        ((Canvas)localObject).drawBitmap(a(paramList.get(7), l), m * 2 + n, m, null);
        ((Canvas)localObject).drawBitmap(a(paramList.get(4), l), m * 2 + n, m * 2 + i1, null);
        ((Canvas)localObject).drawBitmap(a(paramList.get(1), l), m * 2 + n, m * 3 + i1 * 2, null);
        a(0.6F);
        ((Canvas)localObject).drawBitmap(a(paramList.get(8), l), m * 3 + n * 2, m, null);
        ((Canvas)localObject).drawBitmap(a(paramList.get(5), l), m * 3 + n * 2, m * 2 + i1, null);
        ((Canvas)localObject).drawBitmap(a(paramList.get(2), l), n * 2 + m * 3, m * 3 + i1 * 2, null);
        a(0.8F);
        localObject = new Matrix();
        ((Matrix)localObject).preScale(1.0F, -1.0F);
        try
        {
          paramList = Bitmap.createBitmap(localBitmap, 0, 0, i2, i3, (Matrix)localObject, false);
          a(0.9F);
          localObject = paramList;
          if (a.a().q()) {
            localObject = b.a(this.f, paramList, -1, 2, false);
          }
          a(1.0F);
          this.d = null;
          return (Bitmap)localObject;
          ((MainActivity)MainActivity.a).onResume();
          localObject = null;
        }
        catch (OutOfMemoryError paramList)
        {
          for (;;)
          {
            paramList.printStackTrace();
            System.gc();
            paramList = Bitmap.createBitmap(localBitmap, 0, 0, i2, i3, (Matrix)localObject, false);
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */