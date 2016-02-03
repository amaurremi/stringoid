package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.TimeZone;

public class acx
  extends abq<TimeZone>
{
  public static final acx a = new acx();
  
  public acx()
  {
    super(TimeZone.class);
  }
  
  public void a(TimeZone paramTimeZone, or paramor, ru paramru)
    throws IOException, oq
  {
    paramor.b(paramTimeZone.getID());
  }
  
  public void a(TimeZone paramTimeZone, or paramor, ru paramru, rx paramrx)
    throws IOException, oq
  {
    paramrx.a(paramTimeZone, paramor, TimeZone.class);
    a(paramTimeZone, paramor, paramru);
    paramrx.d(paramTimeZone, paramor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/acx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */