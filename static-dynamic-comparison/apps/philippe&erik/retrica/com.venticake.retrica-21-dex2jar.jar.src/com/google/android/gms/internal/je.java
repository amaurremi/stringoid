package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.a;
import com.google.android.gms.location.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

public abstract interface je
  extends IInterface
{
  public abstract void a(long paramLong, boolean paramBoolean, PendingIntent paramPendingIntent);
  
  public abstract void a(PendingIntent paramPendingIntent);
  
  public abstract void a(PendingIntent paramPendingIntent, jd paramjd, String paramString);
  
  public abstract void a(Location paramLocation, int paramInt);
  
  public abstract void a(jd paramjd, String paramString);
  
  public abstract void a(jk paramjk, ka paramka, PendingIntent paramPendingIntent);
  
  public abstract void a(jm paramjm, ka paramka, jy paramjy);
  
  public abstract void a(jo paramjo, ka paramka);
  
  public abstract void a(jq paramjq, ka paramka, PendingIntent paramPendingIntent);
  
  public abstract void a(ju paramju, ka paramka, jy paramjy);
  
  public abstract void a(ka paramka, PendingIntent paramPendingIntent);
  
  public abstract void a(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent);
  
  public abstract void a(LocationRequest paramLocationRequest, a parama);
  
  public abstract void a(LocationRequest paramLocationRequest, a parama, String paramString);
  
  public abstract void a(a parama);
  
  public abstract void a(LatLng paramLatLng, jm paramjm, ka paramka, jy paramjy);
  
  public abstract void a(LatLngBounds paramLatLngBounds, int paramInt, jm paramjm, ka paramka, jy paramjy);
  
  public abstract void a(LatLngBounds paramLatLngBounds, int paramInt, String paramString, jm paramjm, ka paramka, jy paramjy);
  
  public abstract void a(String paramString, ka paramka, jy paramjy);
  
  public abstract void a(String paramString, LatLngBounds paramLatLngBounds, jm paramjm, ka paramka, jy paramjy);
  
  public abstract void a(String paramString, List<String> paramList, List<jw> paramList1, ka paramka, jy paramjy);
  
  public abstract void a(List<jh> paramList, PendingIntent paramPendingIntent, jd paramjd, String paramString);
  
  public abstract void a(String[] paramArrayOfString, jd paramjd, String paramString);
  
  public abstract void b(ka paramka, PendingIntent paramPendingIntent);
  
  public abstract void b(String paramString, ka paramka, jy paramjy);
  
  public abstract Location bo(String paramString);
  
  public abstract b bp(String paramString);
  
  public abstract Location iW();
  
  public abstract IBinder iX();
  
  public abstract void removeActivityUpdates(PendingIntent paramPendingIntent);
  
  public abstract void setMockLocation(Location paramLocation);
  
  public abstract void setMockMode(boolean paramBoolean);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/je.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */