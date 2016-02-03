package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.b.a;

final class b
  extends b.a
{
  private final GoogleMap.CancelableCallback a;
  
  b(GoogleMap.CancelableCallback paramCancelableCallback)
  {
    this.a = paramCancelableCallback;
  }
  
  public void onCancel()
  {
    this.a.onCancel();
  }
  
  public void onFinish()
  {
    this.a.onFinish();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */