package com.google.android.gms.games;

public final class Games$GamesOptions$Builder
{
  boolean MM = false;
  boolean MN = true;
  int MO = 17;
  boolean MP = false;
  int MQ = 4368;
  String MR = null;
  
  public Games.GamesOptions build()
  {
    return new Games.GamesOptions(this, null);
  }
  
  public Builder setSdkVariant(int paramInt)
  {
    this.MQ = paramInt;
    return this;
  }
  
  public Builder setShowConnectingPopup(boolean paramBoolean)
  {
    this.MN = paramBoolean;
    this.MO = 17;
    return this;
  }
  
  public Builder setShowConnectingPopup(boolean paramBoolean, int paramInt)
  {
    this.MN = paramBoolean;
    this.MO = paramInt;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/Games$GamesOptions$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */