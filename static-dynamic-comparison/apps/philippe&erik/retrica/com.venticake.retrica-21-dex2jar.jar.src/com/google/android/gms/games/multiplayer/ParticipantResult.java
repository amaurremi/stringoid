package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.constants.MatchResult;
import com.google.android.gms.internal.hm;

public final class ParticipantResult
  implements SafeParcelable
{
  public static final ParticipantResultCreator CREATOR = new ParticipantResultCreator();
  public static final int MATCH_RESULT_DISAGREED = 5;
  public static final int MATCH_RESULT_DISCONNECT = 4;
  public static final int MATCH_RESULT_LOSS = 1;
  public static final int MATCH_RESULT_NONE = 3;
  public static final int MATCH_RESULT_TIE = 2;
  public static final int MATCH_RESULT_UNINITIALIZED = -1;
  public static final int MATCH_RESULT_WIN = 0;
  public static final int PLACING_UNINITIALIZED = -1;
  private final String Oq;
  private final int Tf;
  private final int Tg;
  private final int xM;
  
  public ParticipantResult(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.xM = paramInt1;
    this.Oq = ((String)hm.f(paramString));
    hm.A(MatchResult.isValid(paramInt2));
    this.Tf = paramInt2;
    this.Tg = paramInt3;
  }
  
  public ParticipantResult(String paramString, int paramInt1, int paramInt2)
  {
    this(1, paramString, paramInt1, paramInt2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getParticipantId()
  {
    return this.Oq;
  }
  
  public int getPlacing()
  {
    return this.Tg;
  }
  
  public int getResult()
  {
    return this.Tf;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ParticipantResultCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */