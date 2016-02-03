package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

class bn
{
  int nN()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public bm ov()
  {
    if (nN() < 8) {
      return new av();
    }
    return new aw();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */