package com.mobisystems.mobiscanner.image;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.view.View;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.model.b;

public class g
  extends e
{
  private Cursor aIo = null;
  private boolean aIp = true;
  private Object aIq = new Object();
  private int aIr;
  private int aIs;
  private c aIt = null;
  private a aIu;
  private b axZ;
  private final com.mobisystems.mobiscanner.common.c mLog = new com.mobisystems.mobiscanner.common.c(this);
  
  public g(Context paramContext, FragmentManager paramFragmentManager, b paramb)
  {
    super(paramContext);
    this.axZ = new b(paramb);
    this.aIu = new a(this.axZ.getId());
    this.aIu.execute(new Boolean[] { Boolean.valueOf(true) });
  }
  
  private String d(long paramLong1, long paramLong2)
  {
    return String.valueOf(paramLong1) + "_" + String.valueOf(paramLong2);
  }
  
  private long dM(String paramString)
  {
    return Long.parseLong(paramString.substring(0, paramString.indexOf('_')));
  }
  
  public void Ii()
  {
    super.Ii();
    if (this.aIo != null) {
      this.aIo.close();
    }
  }
  
  public b Im()
  {
    return this.axZ;
  }
  
  public void a(int paramInt, View paramView)
  {
    this.mLog.dl("loadPageImage, page idx=" + paramInt + ", view=" + com.mobisystems.mobiscanner.common.d.ay(paramView));
    if (this.aIo != null)
    {
      if (this.aIo.moveToPosition(paramInt - 1))
      {
        b(this.aIo.getLong(this.aIr), this.aIo.getLong(this.aIs), paramView);
        return;
      }
      this.mLog.A("Could not find page index=" + paramInt);
      return;
    }
    new b(paramInt, paramView).execute(new Void[0]);
  }
  
  protected void a(View paramView, BitmapDrawable paramBitmapDrawable, String paramString)
  {
    super.a(paramView, paramBitmapDrawable, paramString);
    if (this.aIt != null) {
      this.aIt.Gv();
    }
  }
  
  public void a(c paramc)
  {
    this.aIt = paramc;
  }
  
  protected void ac(View paramView) {}
  
  protected Rect ae(View paramView)
  {
    Rect localRect = new Rect();
    int i = paramView.getResources().getDisplayMetrics().widthPixels;
    int j = paramView.getResources().getDisplayMetrics().heightPixels;
    double d1 = i / j;
    double d2 = Math.floor((float)Runtime.getRuntime().maxMemory() * 0.12F) / 4.0D;
    i = (int)Math.round(Math.sqrt(d2 * d1));
    j = (int)Math.round(Math.sqrt(d2 / d1));
    localRect.top = 0;
    localRect.left = 0;
    localRect.right = i;
    localRect.bottom = j;
    return localRect;
  }
  
  public void b(long paramLong1, long paramLong2, View paramView)
  {
    a(d(paramLong1, paramLong2), paramView);
  }
  
  public void bo(boolean paramBoolean)
  {
    synchronized (this.aIq)
    {
      this.aIp = true;
      if (this.aIo != null) {
        this.aIo.close();
      }
      this.aIo = null;
      if (this.aIu != null) {
        this.aIu.cancel(false);
      }
      this.aIu = new a(this.axZ.getId());
      this.aIu.execute(new Boolean[] { Boolean.valueOf(paramBoolean) });
      return;
    }
  }
  
  public void d(b paramb, boolean paramBoolean)
  {
    synchronized (this.aIq)
    {
      this.axZ = paramb;
      if (paramBoolean)
      {
        this.aIp = true;
        if (this.aIo != null) {
          this.aIo.close();
        }
        this.aIo = null;
        if (this.aIu != null) {
          this.aIu.cancel(false);
        }
        this.aIu = new a(this.axZ.getId());
        this.aIu.execute(new Boolean[] { Boolean.valueOf(true) });
      }
      return;
    }
  }
  
  public com.mobisystems.mobiscanner.model.c gv(int paramInt)
  {
    com.mobisystems.mobiscanner.model.c localc = null;
    if (this.aIo != null)
    {
      if (this.aIo.moveToPosition(paramInt - 1)) {
        localc = new com.mobisystems.mobiscanner.model.c(this.axZ, this.aIo);
      }
    }
    else {
      return localc;
    }
    this.mLog.A("Could not find page index=" + paramInt);
    return null;
  }
  
  protected BitmapDrawable h(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject3 = null;
    this.mLog.dl("loadBitmap called for image: " + paramString);
    if (this.aHM != null) {}
    for (Object localObject1 = this.aHM.dP(paramString);; localObject1 = null)
    {
      Object localObject2 = localObject1;
      Image localImage;
      if (localObject1 == null)
      {
        long l = dM(paramString);
        localImage = new DocumentModel().ao(l);
        localObject2 = localObject1;
        if (localImage != null) {
          if (this.aHM == null) {
            break label161;
          }
        }
      }
      label161:
      for (localObject1 = this.aHM.Ig();; localObject1 = null)
      {
        localObject2 = localImage.a(paramInt1, paramInt2, (k)localObject1, Image.RestrictMemory.aHy);
        localObject1 = localObject3;
        if (localObject2 != null)
        {
          localObject2 = e((Bitmap)localObject2);
          localObject1 = localObject2;
          if (this.aHM != null)
          {
            this.aHM.a(paramString, (BitmapDrawable)localObject2);
            localObject1 = localObject2;
          }
        }
        return (BitmapDrawable)localObject1;
      }
    }
  }
  
  private class a
    extends AsyncTask<Boolean, Void, Cursor>
  {
    private long aCg;
    private Cursor aIv;
    private boolean aIw;
    
    public a(long paramLong)
    {
      this.aCg = paramLong;
    }
    
    protected Cursor b(Boolean... paramVarArgs)
    {
      try
      {
        this.aIw = paramVarArgs[0].booleanValue();
        paramVarArgs = new DocumentModel().ah(this.aCg);
        this.aIv = paramVarArgs;
        return paramVarArgs;
      }
      finally
      {
        paramVarArgs = finally;
        throw paramVarArgs;
      }
    }
    
    protected void b(Cursor paramCursor)
    {
      synchronized (g.a(g.this))
      {
        if (!isCancelled())
        {
          g.a(g.this, false);
          g.a(g.this, paramCursor);
          g.a(g.this, g.b(g.this).getColumnIndex("_id"));
          g.b(g.this, g.b(g.this).getColumnIndex("page_last_modification_time"));
          g.a(g.this).notifyAll();
        }
        while (paramCursor == null)
        {
          if ((!isCancelled()) && (g.c(g.this) != null) && (this.aIw)) {
            g.c(g.this).Gu();
          }
          return;
        }
        paramCursor.close();
      }
    }
    
    protected void d(Cursor paramCursor)
    {
      e(paramCursor);
    }
    
    protected void e(Cursor paramCursor)
    {
      if (paramCursor != null) {
        paramCursor.close();
      }
    }
    
    protected void onCancelled()
    {
      try
      {
        e(this.aIv);
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
  
  private class b
    extends AsyncTask<Void, Void, Void>
  {
    private int aDX;
    private View mView;
    
    public b(int paramInt, View paramView)
    {
      this.aDX = paramInt;
      this.mView = paramView;
    }
    
    protected Void doInBackground(Void... arg1)
    {
      synchronized (g.a(g.this))
      {
        for (;;)
        {
          boolean bool = g.d(g.this);
          if (!bool) {
            break;
          }
          try
          {
            g.a(g.this).wait();
          }
          catch (InterruptedException localInterruptedException) {}
        }
        return null;
      }
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      if (g.b(g.this) != null)
      {
        if (g.b(g.this).moveToPosition(this.aDX - 1)) {
          g.this.b(g.b(g.this).getLong(g.e(g.this)), g.b(g.this).getLong(g.f(g.this)), this.mView);
        }
      }
      else {
        return;
      }
      g.g(g.this).A("Could not find page index=" + this.aDX);
    }
  }
  
  public static abstract interface c
  {
    public abstract void Gu();
    
    public abstract void Gv();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/image/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */