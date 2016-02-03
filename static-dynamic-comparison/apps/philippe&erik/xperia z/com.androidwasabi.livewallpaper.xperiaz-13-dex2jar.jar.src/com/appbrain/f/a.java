package com.appbrain.f;

import com.appbrain.g.b;
import com.appbrain.g.c;
import com.appbrain.g.e;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class a
  implements g
{
  private final e a;
  
  protected a(e parame)
  {
    this.a = parame;
  }
  
  protected static long a(byte[]... paramVarArgs)
  {
    MessageDigest localMessageDigest = a();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localMessageDigest.update(paramVarArgs[i]);
      i += 1;
    }
    return ByteBuffer.wrap(localMessageDigest.digest()).getLong();
  }
  
  private static MessageDigest a()
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      return localMessageDigest;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
  }
  
  protected abstract long a(byte[] paramArrayOfByte);
  
  public final b a(c paramc)
  {
    paramc = paramc.d();
    paramc.a(a(paramc.f().b()));
    paramc.a(this.a);
    return paramc.f();
  }
  
  public final void a(b paramb)
  {
    if (paramb.o() != this.a) {
      throw new SecurityException("Unexpected sign-type: " + paramb.o());
    }
    c localc = paramb.I();
    localc.g();
    localc.h();
    long l = a(localc.f().b());
    if (l != paramb.m()) {
      throw new SecurityException("Wrong checksum value. " + l + " " + paramb.m() + ", wrapper:\n" + paramb);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */