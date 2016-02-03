package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;

public class d
{
  public static boolean a(int paramInt, DriveId paramDriveId)
  {
    return (paramDriveId != null) || (bd(paramInt));
  }
  
  public static boolean bd(int paramInt)
  {
    return (0x2 & 1 << paramInt) != 0L;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/events/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */