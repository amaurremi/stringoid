package com.google.android.gms.appstate;

@Deprecated
public abstract interface OnStateLoadedListener
{
  public abstract void onStateConflict(int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public abstract void onStateLoaded(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/appstate/OnStateLoadedListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */