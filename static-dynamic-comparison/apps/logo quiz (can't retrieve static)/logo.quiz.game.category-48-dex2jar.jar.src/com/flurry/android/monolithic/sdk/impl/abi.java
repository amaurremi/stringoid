package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.net.InetAddress;

public class abi
  extends abq<InetAddress>
{
  public static final abi a = new abi();
  
  public abi()
  {
    super(InetAddress.class);
  }
  
  public void a(InetAddress paramInetAddress, or paramor, ru paramru)
    throws IOException, oq
  {
    paramru = paramInetAddress.toString().trim();
    int i = paramru.indexOf('/');
    paramInetAddress = paramru;
    if (i >= 0) {
      if (i != 0) {
        break label40;
      }
    }
    label40:
    for (paramInetAddress = paramru.substring(1);; paramInetAddress = paramru.substring(0, i))
    {
      paramor.b(paramInetAddress);
      return;
    }
  }
  
  public void a(InetAddress paramInetAddress, or paramor, ru paramru, rx paramrx)
    throws IOException, oq
  {
    paramrx.a(paramInetAddress, paramor, InetAddress.class);
    a(paramInetAddress, paramor, paramru);
    paramrx.d(paramInetAddress, paramor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/abi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */