package com.google.android.gms.games.request;

import android.os.Parcelable;
import com.google.android.gms.common.data.c;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import java.util.ArrayList;

public abstract interface GameRequest
  extends Parcelable, c<GameRequest>
{
  public abstract int ax(String paramString);
  
  public abstract byte[] getData();
  
  public abstract int getType();
  
  public abstract Game nX();
  
  public abstract String oE();
  
  public abstract Player oF();
  
  public abstract ArrayList<Player> oG();
  
  public abstract long oH();
  
  public abstract long oa();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/request/GameRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */