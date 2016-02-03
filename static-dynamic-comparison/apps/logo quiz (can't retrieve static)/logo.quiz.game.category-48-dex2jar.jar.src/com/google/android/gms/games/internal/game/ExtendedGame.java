package com.google.android.gms.games.internal.game;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import java.util.ArrayList;

public abstract interface ExtendedGame
  extends Parcelable, Freezable<ExtendedGame>
{
  public abstract Game getGame();
  
  public abstract ArrayList<GameBadge> kO();
  
  public abstract int kP();
  
  public abstract boolean kQ();
  
  public abstract int kR();
  
  public abstract long kS();
  
  public abstract long kT();
  
  public abstract String kU();
  
  public abstract long kV();
  
  public abstract String kW();
  
  public abstract SnapshotMetadata kX();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/game/ExtendedGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */