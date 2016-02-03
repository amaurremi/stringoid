package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.api.c.d;
import com.google.android.gms.common.b;
import com.google.android.gms.common.c;
import com.google.android.gms.common.c.a;
import com.google.android.gms.common.c.b;
import com.google.android.gms.common.d;
import java.util.ArrayList;

public abstract class cs<T extends IInterface>
  implements a.a, c, ct.b
{
  public static final String[] GU = { "service_esmobile", "service_googleme" };
  private T GO;
  private final ArrayList<cs<T>.b<?>> GP = new ArrayList();
  private cs<T>.e GQ;
  private volatile int GR = 1;
  private final String[] GS;
  boolean GT = false;
  private final Context mContext;
  final Handler mHandler;
  private final Looper qY;
  private final ct ru;
  
  protected cs(Context paramContext, Looper paramLooper, c.c paramc, c.d paramd, String... paramVarArgs)
  {
    this.mContext = ((Context)dc.N(paramContext));
    this.qY = ((Looper)dc.e(paramLooper, "Looper must not be null"));
    this.ru = new ct(paramContext, paramLooper, this);
    this.mHandler = new a(paramLooper);
    f(paramVarArgs);
    this.GS = paramVarArgs;
    b((c.c)dc.N(paramc));
    b((c.d)dc.N(paramd));
  }
  
  protected cs(Context paramContext, c.a parama, c.b paramb, String... paramVarArgs)
  {
    this(paramContext, paramContext.getMainLooper(), new c(parama), new f(paramb), paramVarArgs);
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new g(paramInt, paramIBinder, paramBundle)));
  }
  
  protected abstract void a(cx paramcx, d paramd);
  
  public void b(c.c paramc)
  {
    this.ru.b(paramc);
  }
  
  public void b(c.d paramd)
  {
    this.ru.a(paramd);
  }
  
  public void connect()
  {
    this.GT = true;
    this.GR = 2;
    int i = d.w(this.mContext);
    if (i != 0)
    {
      this.GR = 1;
      this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(i)));
    }
    do
    {
      return;
      if (this.GQ != null)
      {
        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
        this.GO = null;
        cu.I(this.mContext).b(nm(), this.GQ);
      }
      this.GQ = new e();
    } while (cu.I(this.mContext).a(nm(), this.GQ));
    Log.e("GmsClient", "unable to connect to service: " + nm());
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
  }
  
  protected abstract T d(IBinder paramIBinder);
  
  public void disconnect()
  {
    this.GT = false;
    synchronized (this.GP)
    {
      int j = this.GP.size();
      int i = 0;
      while (i < j)
      {
        ((b)this.GP.get(i)).qu();
        i += 1;
      }
      this.GP.clear();
      this.GR = 1;
      this.GO = null;
      if (this.GQ != null)
      {
        cu.I(this.mContext).b(nm(), this.GQ);
        this.GQ = null;
      }
      return;
    }
  }
  
  protected void f(String... paramVarArgs) {}
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public final Looper getLooper()
  {
    return this.qY;
  }
  
  public boolean isConnected()
  {
    return this.GR == 3;
  }
  
  public boolean isConnecting()
  {
    return this.GR == 2;
  }
  
  protected final void lf()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public boolean mG()
  {
    return this.GT;
  }
  
  public Bundle mH()
  {
    return null;
  }
  
  protected abstract String nl();
  
  protected abstract String nm();
  
  public final String[] qq()
  {
    return this.GS;
  }
  
  protected final T qr()
  {
    lf();
    return this.GO;
  }
  
  protected final void w(IBinder paramIBinder)
  {
    try
    {
      a(cx.a.y(paramIBinder), new d(this));
      return;
    }
    catch (RemoteException paramIBinder)
    {
      Log.w("GmsClient", "service died");
    }
  }
  
  final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((paramMessage.what == 1) && (!cs.this.isConnecting()))
      {
        paramMessage = (cs.b)paramMessage.obj;
        paramMessage.qs();
        paramMessage.unregister();
        return;
      }
      if (paramMessage.what == 3)
      {
        cs.a(cs.this).b(new b(((Integer)paramMessage.obj).intValue(), null));
        return;
      }
      if (paramMessage.what == 4)
      {
        cs.a(cs.this, 1);
        cs.a(cs.this, null);
        cs.a(cs.this).cF(((Integer)paramMessage.obj).intValue());
        return;
      }
      if ((paramMessage.what == 2) && (!cs.this.isConnected()))
      {
        paramMessage = (cs.b)paramMessage.obj;
        paramMessage.qs();
        paramMessage.unregister();
        return;
      }
      if ((paramMessage.what == 2) || (paramMessage.what == 1))
      {
        ((cs.b)paramMessage.obj).qt();
        return;
      }
      Log.wtf("GmsClient", "Don't know how to handle this message.");
    }
  }
  
  protected abstract class b<TListener>
  {
    private TListener GW;
    private boolean GX;
    
    public b()
    {
      Object localObject;
      this.GW = localObject;
      this.GX = false;
    }
    
    protected abstract void L(TListener paramTListener);
    
    protected abstract void qs();
    
    /* Error */
    public void qt()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 24	com/google/android/gms/internal/cs$b:GW	Ljava/lang/Object;
      //   6: astore_1
      //   7: aload_0
      //   8: getfield 26	com/google/android/gms/internal/cs$b:GX	Z
      //   11: ifeq +33 -> 44
      //   14: ldc 37
      //   16: new 39	java/lang/StringBuilder
      //   19: dup
      //   20: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   23: ldc 42
      //   25: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   28: aload_0
      //   29: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   32: ldc 51
      //   34: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   40: invokestatic 61	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   43: pop
      //   44: aload_0
      //   45: monitorexit
      //   46: aload_1
      //   47: ifnull +34 -> 81
      //   50: aload_0
      //   51: aload_1
      //   52: invokevirtual 63	com/google/android/gms/internal/cs$b:L	(Ljava/lang/Object;)V
      //   55: aload_0
      //   56: monitorenter
      //   57: aload_0
      //   58: iconst_1
      //   59: putfield 26	com/google/android/gms/internal/cs$b:GX	Z
      //   62: aload_0
      //   63: monitorexit
      //   64: aload_0
      //   65: invokevirtual 66	com/google/android/gms/internal/cs$b:unregister	()V
      //   68: return
      //   69: astore_1
      //   70: aload_0
      //   71: monitorexit
      //   72: aload_1
      //   73: athrow
      //   74: astore_1
      //   75: aload_0
      //   76: invokevirtual 68	com/google/android/gms/internal/cs$b:qs	()V
      //   79: aload_1
      //   80: athrow
      //   81: aload_0
      //   82: invokevirtual 68	com/google/android/gms/internal/cs$b:qs	()V
      //   85: goto -30 -> 55
      //   88: astore_1
      //   89: aload_0
      //   90: monitorexit
      //   91: aload_1
      //   92: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	93	0	this	b
      //   6	46	1	localObject1	Object
      //   69	4	1	localObject2	Object
      //   74	6	1	localRuntimeException	RuntimeException
      //   88	4	1	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   2	44	69	finally
      //   44	46	69	finally
      //   70	72	69	finally
      //   50	55	74	java/lang/RuntimeException
      //   57	64	88	finally
      //   89	91	88	finally
    }
    
    public void qu()
    {
      try
      {
        this.GW = null;
        return;
      }
      finally {}
    }
    
    public void unregister()
    {
      qu();
      synchronized (cs.b(cs.this))
      {
        cs.b(cs.this).remove(this);
        return;
      }
    }
  }
  
  public static final class c
    implements c.c
  {
    private final c.a GY;
    
    public c(c.a parama)
    {
      this.GY = parama;
    }
    
    public void a(Bundle paramBundle)
    {
      this.GY.a(paramBundle);
    }
    
    public void bl(int paramInt)
    {
      this.GY.onDisconnected();
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof c)) {
        return this.GY.equals(((c)paramObject).GY);
      }
      return this.GY.equals(paramObject);
    }
  }
  
  public static final class d
    extends cw.a
  {
    private cs GZ;
    
    public d(cs paramcs)
    {
      this.GZ = paramcs;
    }
    
    public void b(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      dc.e("onPostInitComplete can be called only once per call to getServiceFromBroker", this.GZ);
      this.GZ.a(paramInt, paramIBinder, paramBundle);
      this.GZ = null;
    }
  }
  
  final class e
    implements ServiceConnection
  {
    e() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      cs.this.w(paramIBinder);
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      cs.this.mHandler.sendMessage(cs.this.mHandler.obtainMessage(4, Integer.valueOf(1)));
    }
  }
  
  public static final class f
    implements c.d
  {
    private final c.b Ha;
    
    public f(c.b paramb)
    {
      this.Ha = paramb;
    }
    
    public void a(b paramb)
    {
      this.Ha.a(paramb);
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof f)) {
        return this.Ha.equals(((f)paramObject).Ha);
      }
      return this.Ha.equals(paramObject);
    }
  }
  
  protected final class g
    extends cs<T>.b<Boolean>
  {
    public final Bundle Hb;
    public final IBinder Hc;
    public final int statusCode;
    
    public g(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      super(Boolean.valueOf(true));
      this.statusCode = paramInt;
      this.Hc = paramIBinder;
      this.Hb = paramBundle;
    }
    
    protected void b(Boolean paramBoolean)
    {
      if (paramBoolean == null)
      {
        cs.a(cs.this, 1);
        return;
      }
      switch (this.statusCode)
      {
      default: 
        if (this.Hb == null) {
          break;
        }
      }
      for (paramBoolean = (PendingIntent)this.Hb.getParcelable("pendingIntent");; paramBoolean = null)
      {
        if (cs.d(cs.this) != null)
        {
          cu.I(cs.e(cs.this)).b(cs.this.nm(), cs.d(cs.this));
          cs.a(cs.this, null);
        }
        cs.a(cs.this, 1);
        cs.a(cs.this, null);
        cs.a(cs.this).b(new b(this.statusCode, paramBoolean));
        return;
        try
        {
          paramBoolean = this.Hc.getInterfaceDescriptor();
          if (cs.this.nl().equals(paramBoolean))
          {
            cs.a(cs.this, cs.this.d(this.Hc));
            if (cs.c(cs.this) != null)
            {
              cs.a(cs.this, 3);
              cs.a(cs.this).lh();
              return;
            }
          }
        }
        catch (RemoteException paramBoolean)
        {
          cu.I(cs.e(cs.this)).b(cs.this.nm(), cs.d(cs.this));
          cs.a(cs.this, null);
          cs.a(cs.this, 1);
          cs.a(cs.this, null);
          cs.a(cs.this).b(new b(8, null));
          return;
        }
        cs.a(cs.this, 1);
        throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
      }
    }
    
    protected void qs() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */