package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.fitness.request.DataSourceListener;
import java.util.HashMap;
import java.util.Map;

public class l
  extends k.a
{
  private final DataSourceListener SY;
  
  private l(DataSourceListener paramDataSourceListener)
  {
    this.SY = ((DataSourceListener)n.i(paramDataSourceListener));
  }
  
  public void onEvent(DataPoint paramDataPoint)
    throws RemoteException
  {
    this.SY.onEvent(paramDataPoint);
  }
  
  public static class a
  {
    private static final a SZ = new a();
    private final Map<DataSourceListener, l> Ta = new HashMap();
    
    public static a iO()
    {
      return SZ;
    }
    
    public l a(DataSourceListener paramDataSourceListener)
    {
      synchronized (this.Ta)
      {
        l locall2 = (l)this.Ta.get(paramDataSourceListener);
        l locall1 = locall2;
        if (locall2 == null)
        {
          locall1 = new l(paramDataSourceListener, null);
          this.Ta.put(paramDataSourceListener, locall1);
        }
        return locall1;
      }
    }
    
    public l b(DataSourceListener paramDataSourceListener)
    {
      synchronized (this.Ta)
      {
        paramDataSourceListener = (l)this.Ta.get(paramDataSourceListener);
        return paramDataSourceListener;
      }
    }
    
    public l c(DataSourceListener paramDataSourceListener)
    {
      synchronized (this.Ta)
      {
        l locall = (l)this.Ta.remove(paramDataSourceListener);
        if (locall != null) {
          return locall;
        }
        paramDataSourceListener = new l(paramDataSourceListener, null);
        return paramDataSourceListener;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */