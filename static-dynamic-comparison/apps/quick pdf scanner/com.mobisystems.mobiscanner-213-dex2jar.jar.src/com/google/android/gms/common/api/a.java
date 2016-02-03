package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.internal.ee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class a
{
  private final b<?> qQ;
  private final ArrayList<h> qR;
  
  public a(b<?> paramb, h... paramVarArgs)
  {
    this.qQ = paramb;
    this.qR = new ArrayList(Arrays.asList(paramVarArgs));
  }
  
  public b<?> mm()
  {
    return this.qQ;
  }
  
  public List<h> mn()
  {
    return this.qR;
  }
  
  public static abstract interface a
  {
    public abstract void connect();
    
    public abstract void disconnect();
    
    public abstract Looper getLooper();
    
    public abstract boolean isConnected();
  }
  
  public static abstract interface b<T extends a.a>
  {
    public abstract T a(Context paramContext, Looper paramLooper, ee paramee, c.a parama, c.c paramc, c.d paramd);
    
    public abstract int getPriority();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/common/api/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */