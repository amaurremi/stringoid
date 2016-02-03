package com.gau.go.launcherex.gowidget.weather.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;

public abstract class d
  extends Binder
  implements c
{
  public d()
  {
    attachInterface(this, "com.gau.go.launcherex.gowidget.weather.service.IRemoteServiceCallback");
  }
  
  public static c a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.gau.go.launcherex.gowidget.weather.service.IRemoteServiceCallback");
    if ((localIInterface != null) && ((localIInterface instanceof c))) {
      return (c)localIInterface;
    }
    return new e(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool = false;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.gau.go.launcherex.gowidget.weather.service.IRemoteServiceCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.gau.go.launcherex.gowidget.weather.service.IRemoteServiceCallback");
      a(paramParcel1.readInt(), paramParcel1.createTypedArrayList(WeatherBean.CREATOR));
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.gau.go.launcherex.gowidget.weather.service.IRemoteServiceCallback");
      a(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.gau.go.launcherex.gowidget.weather.service.IRemoteServiceCallback");
      a(paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.gau.go.launcherex.gowidget.weather.service.IRemoteServiceCallback");
      if (paramParcel1.readInt() != 0) {
        localObject1 = (WeatherBean)WeatherBean.CREATOR.createFromParcel(paramParcel1);
      }
      a((WeatherBean)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.gau.go.launcherex.gowidget.weather.service.IRemoteServiceCallback");
      a(paramParcel1.createStringArrayList());
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.gau.go.launcherex.gowidget.weather.service.IRemoteServiceCallback");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (WeatherBean)WeatherBean.CREATOR.createFromParcel(paramParcel1);
      }
      b((WeatherBean)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.gau.go.launcherex.gowidget.weather.service.IRemoteServiceCallback");
      if (paramParcel1.readInt() != 0) {}
      for (bool = true;; bool = false)
      {
        a(bool);
        paramParcel2.writeNoException();
        return true;
      }
    }
    paramParcel1.enforceInterface("com.gau.go.launcherex.gowidget.weather.service.IRemoteServiceCallback");
    if (paramParcel1.readInt() != 0) {
      bool = true;
    }
    b(bool);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/service/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */