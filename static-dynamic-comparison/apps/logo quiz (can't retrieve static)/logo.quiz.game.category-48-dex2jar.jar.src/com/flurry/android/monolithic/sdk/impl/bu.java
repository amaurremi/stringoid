package com.flurry.android.monolithic.sdk.impl;

import com.flurry.android.impl.ads.FlurryAdModule;
import java.nio.ByteBuffer;
import java.util.Map;

class bu
  extends jf
{
  bu(bt parambt) {}
  
  public void a()
  {
    try
    {
      byte[] arrayOfByte = im.a();
      if (arrayOfByte != null)
      {
        ja.a(3, bt.b(), "Fetched hashed IMEI");
        bt.a(this.a).put(ie.b, ByteBuffer.wrap(arrayOfByte));
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ja.a(6, bt.b(), "", localThrowable);
      }
    }
    if (!bt.b(this.a))
    {
      bt.a(this.a, true);
      bt.c(this.a).a(bt.a(this.a));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */