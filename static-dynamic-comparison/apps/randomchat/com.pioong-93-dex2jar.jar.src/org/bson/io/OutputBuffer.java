package org.bson.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public abstract class OutputBuffer
  extends OutputStream
{
  public String asString()
  {
    return new String(toByteArray());
  }
  
  public String asString(String paramString)
    throws UnsupportedEncodingException
  {
    return new String(toByteArray(), paramString);
  }
  
  public abstract int getPosition();
  
  public String hex()
  {
    final StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      pipe(new OutputStream()
      {
        public void write(int paramAnonymousInt)
        {
          String str = Integer.toHexString(paramAnonymousInt & 0xFF);
          if (str.length() < 2) {
            localStringBuilder.append("0");
          }
          localStringBuilder.append(str);
        }
      });
      return localStringBuilder.toString();
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("impossible");
    }
  }
  
  /* Error */
  public String md5()
  {
    // Byte code:
    //   0: ldc 61
    //   2: invokestatic 67	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_1
    //   6: aload_1
    //   7: invokevirtual 70	java/security/MessageDigest:reset	()V
    //   10: aload_0
    //   11: new 8	org/bson/io/OutputBuffer$2
    //   14: dup
    //   15: aload_0
    //   16: aload_1
    //   17: invokespecial 73	org/bson/io/OutputBuffer$2:<init>	(Lorg/bson/io/OutputBuffer;Ljava/security/MessageDigest;)V
    //   20: invokevirtual 46	org/bson/io/OutputBuffer:pipe	(Ljava/io/OutputStream;)I
    //   23: pop
    //   24: aload_1
    //   25: invokevirtual 76	java/security/MessageDigest:digest	()[B
    //   28: invokestatic 82	com/mongodb/util/Util:toHex	([B)Ljava/lang/String;
    //   31: areturn
    //   32: astore_1
    //   33: new 51	java/lang/RuntimeException
    //   36: dup
    //   37: ldc 84
    //   39: invokespecial 56	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   42: athrow
    //   43: astore_1
    //   44: new 51	java/lang/RuntimeException
    //   47: dup
    //   48: ldc 53
    //   50: invokespecial 56	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	OutputBuffer
    //   5	20	1	localMessageDigest	MessageDigest
    //   32	1	1	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   43	1	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   0	6	32	java/security/NoSuchAlgorithmException
    //   10	24	43	java/io/IOException
  }
  
  public abstract int pipe(OutputStream paramOutputStream)
    throws IOException;
  
  public abstract void seekEnd();
  
  public abstract void seekStart();
  
  public abstract void setPosition(int paramInt);
  
  public abstract int size();
  
  public byte[] toByteArray()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream(size());
      pipe((OutputStream)localObject);
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("should be impossible", localIOException);
    }
  }
  
  public String toString()
  {
    return getClass().getName() + " size: " + size() + " pos: " + getPosition();
  }
  
  public abstract void write(int paramInt);
  
  public abstract void write(byte[] paramArrayOfByte);
  
  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public void writeDouble(double paramDouble)
  {
    writeLong(Double.doubleToRawLongBits(paramDouble));
  }
  
  public void writeInt(int paramInt)
  {
    write(paramInt >> 0);
    write(paramInt >> 8);
    write(paramInt >> 16);
    write(paramInt >> 24);
  }
  
  public void writeInt(int paramInt1, int paramInt2)
  {
    int i = getPosition();
    setPosition(paramInt1);
    writeInt(paramInt2);
    setPosition(i);
  }
  
  public void writeIntBE(int paramInt)
  {
    write(paramInt >> 24);
    write(paramInt >> 16);
    write(paramInt >> 8);
    write(paramInt);
  }
  
  public void writeLong(long paramLong)
  {
    write((byte)(int)(paramLong >> 0 & 0xFF));
    write((byte)(int)(paramLong >> 8 & 0xFF));
    write((byte)(int)(paramLong >> 16 & 0xFF));
    write((byte)(int)(paramLong >> 24 & 0xFF));
    write((byte)(int)(paramLong >> 32 & 0xFF));
    write((byte)(int)(paramLong >> 40 & 0xFF));
    write((byte)(int)(paramLong >> 48 & 0xFF));
    write((byte)(int)(paramLong >> 56 & 0xFF));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/io/OutputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */