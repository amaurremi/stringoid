package com.appbrain.f;

import com.appbrain.g.a.a;
import com.appbrain.g.a.a.a;
import com.appbrain.g.a.c;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class a
  implements d.a
{
  private final a.c a;
  
  protected a(a.c paramc)
  {
    this.a = paramc;
  }
  
  protected static long a(byte[]... paramVarArgs)
  {
    MessageDigest localMessageDigest = a();
    int i = 0;
    while (i <= 0)
    {
      localMessageDigest.update(paramVarArgs[0]);
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
  
  public final a.a a(a.a.a parama)
  {
    if ((parama.g()) && (parama.i())) {
      throw new IllegalArgumentException("Already signed");
    }
    parama = parama.d();
    parama.a(a(parama.f().b()));
    parama.a(this.a);
    return parama.f();
  }
  
  public final void a(a.a parama)
  {
    if (parama.o() != this.a) {
      throw new SecurityException("Unexpected sign-type: " + parama.o());
    }
    a.a.a locala = parama.I();
    locala.h();
    locala.j();
    long l = a(locala.f().b());
    if (l != parama.m()) {
      throw new SecurityException("Wrong checksum value. " + l + " " + parama.m() + ", wrapper:\n" + parama);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */