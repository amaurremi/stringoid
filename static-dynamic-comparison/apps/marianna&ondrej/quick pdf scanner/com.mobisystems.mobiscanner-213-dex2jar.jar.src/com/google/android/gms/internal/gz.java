package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public final class gz
  implements SafeParcelable, GameRequest
{
  public static final ek MH = new ek();
  private final ArrayList<GameRequestEntity> MI;
  private final int qh;
  
  gz(int paramInt, ArrayList<GameRequestEntity> paramArrayList)
  {
    this.qh = paramInt;
    this.MI = paramArrayList;
    rb();
  }
  
  private void rb()
  {
    GameRequest localGameRequest1;
    int i;
    label39:
    GameRequest localGameRequest2;
    if (!this.MI.isEmpty())
    {
      bool = true;
      cq.G(bool);
      localGameRequest1 = (GameRequest)this.MI.get(0);
      int j = this.MI.size();
      i = 1;
      if (i >= j) {
        return;
      }
      localGameRequest2 = (GameRequest)this.MI.get(i);
      if (localGameRequest1.getType() != localGameRequest2.getType()) {
        break label116;
      }
    }
    label116:
    for (boolean bool = true;; bool = false)
    {
      cq.a(bool, "All the requests must be of the same type");
      cq.a(localGameRequest1.oF().equals(localGameRequest2.oF()), "All the requests must be from the same sender");
      i += 1;
      break label39;
      bool = false;
      break;
    }
  }
  
  public int ax(String paramString)
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof gz)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (gz)paramObject;
    if (((gz)paramObject).MI.size() != this.MI.size()) {
      return false;
    }
    int j = this.MI.size();
    int i = 0;
    while (i < j)
    {
      if (!((GameRequest)this.MI.get(i)).equals((GameRequest)((gz)paramObject).MI.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public byte[] getData()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int getType()
  {
    return ((GameRequestEntity)this.MI.get(0)).getType();
  }
  
  public int hashCode()
  {
    return cz.hashCode(this.MI.toArray());
  }
  
  public int lX()
  {
    return this.qh;
  }
  
  public Game nX()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public String oE()
  {
    return ((GameRequestEntity)this.MI.get(0)).oE();
  }
  
  public Player oF()
  {
    return ((GameRequestEntity)this.MI.get(0)).oF();
  }
  
  public ArrayList<Player> oG()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public long oH()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public GameRequest oJ()
  {
    return this;
  }
  
  public long oa()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public ArrayList<GameRequest> rd()
  {
    return new ArrayList(this.MI);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ek.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/gz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */