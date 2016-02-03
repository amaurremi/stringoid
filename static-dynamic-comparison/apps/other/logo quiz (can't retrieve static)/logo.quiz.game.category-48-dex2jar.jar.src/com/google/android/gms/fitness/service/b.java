package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.k;
import java.util.Iterator;
import java.util.List;

class b
  implements SensorEventDispatcher
{
  private final k Up;
  
  b(k paramk)
  {
    this.Up = ((k)n.i(paramk));
  }
  
  public void publish(DataPoint paramDataPoint)
    throws RemoteException
  {
    this.Up.onEvent(paramDataPoint);
  }
  
  public void publish(List<DataPoint> paramList)
    throws RemoteException
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      publish((DataPoint)paramList.next());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/service/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */