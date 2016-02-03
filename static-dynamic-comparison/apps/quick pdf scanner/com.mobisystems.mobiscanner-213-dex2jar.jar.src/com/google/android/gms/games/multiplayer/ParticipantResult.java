package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.dc;
import com.google.android.gms.internal.eh;

public final class ParticipantResult
  implements SafeParcelable
{
  public static final a wa = new a();
  private final int qh;
  private final String vT;
  private final int wb;
  private final int wc;
  
  public ParticipantResult(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.qh = paramInt1;
    this.vT = ((String)dc.N(paramString));
    dc.G(eh.isValid(paramInt2));
    this.wb = paramInt2;
    this.wc = paramInt3;
  }
  
  public ParticipantResult(String paramString, int paramInt1, int paramInt2)
  {
    this(1, paramString, paramInt1, paramInt2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int lX()
  {
    return this.qh;
  }
  
  public String oi()
  {
    return this.vT;
  }
  
  public int om()
  {
    return this.wb;
  }
  
  public int on()
  {
    return this.wc;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */