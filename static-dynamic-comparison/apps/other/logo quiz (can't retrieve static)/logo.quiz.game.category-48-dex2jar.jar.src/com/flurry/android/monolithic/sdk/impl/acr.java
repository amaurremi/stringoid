package com.flurry.android.monolithic.sdk.impl;

import java.util.Calendar;
import java.util.Date;

public class acr
{
  protected static final ra<Object> a = new acq();
  protected static final ra<Object> b = new acu();
  
  public static ra<Object> a(afm paramafm)
  {
    if (paramafm == null) {
      return a;
    }
    paramafm = paramafm.p();
    if (paramafm == String.class) {
      return b;
    }
    if (paramafm == Object.class) {
      return a;
    }
    if (Date.class.isAssignableFrom(paramafm)) {
      return act.a;
    }
    if (Calendar.class.isAssignableFrom(paramafm)) {
      return acs.a;
    }
    return a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/acr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */