package com.flurry.android.monolithic.sdk.impl;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.Window;

public final class cq
{
  @TargetApi(11)
  public static void a(Window paramWindow)
  {
    if (paramWindow == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramWindow.setFlags(16777216, 16777216);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */