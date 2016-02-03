package com.google.tagmanager.protobuf;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class e
  implements Iterable<Byte>
{
  public static final e ajf;
  
  static
  {
    if (!e.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ajf = new m(new byte[0]);
      return;
    }
  }
  
  public static b AN()
  {
    return new b(128);
  }
  
  private static e a(Iterator<e> paramIterator, int paramInt)
  {
    assert (paramInt >= 1);
    if (paramInt == 1) {
      return (e)paramIterator.next();
    }
    int i = paramInt >>> 1;
    return a(paramIterator, i).a(a(paramIterator, paramInt - i));
  }
  
  public static e b(Iterable<e> paramIterable)
  {
    ArrayList localArrayList;
    if (!(paramIterable instanceof Collection))
    {
      localArrayList = new ArrayList();
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        localArrayList.add((e)paramIterable.next());
      }
    }
    for (paramIterable = localArrayList; paramIterable.isEmpty(); paramIterable = (Collection)paramIterable) {
      return ajf;
    }
    return a(paramIterable.iterator(), paramIterable.size());
  }
  
  public static e cU(String paramString)
  {
    try
    {
      paramString = new m(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported?", paramString);
    }
  }
  
  public static e e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new m(arrayOfByte);
  }
  
  public static e k(byte[] paramArrayOfByte)
  {
    return e(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public abstract a AI();
  
  public String AK()
  {
    try
    {
      String str = toString("UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported?", localUnsupportedEncodingException);
    }
  }
  
  public abstract boolean AL();
  
  public abstract f AM();
  
  protected abstract int AO();
  
  protected abstract boolean AP();
  
  protected abstract int AQ();
  
  public e a(e parame)
  {
    int i = size();
    int j = parame.size();
    if (i + j >= 2147483647L) {
      throw new IllegalArgumentException("ByteString would be too long: " + i + "+" + j);
    }
    return r.a(this, parame);
  }
  
  void a(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IndexOutOfBoundsException("Source offset < 0: " + paramInt1);
    }
    if (paramInt2 < 0) {
      throw new IndexOutOfBoundsException("Length < 0: " + paramInt2);
    }
    if (paramInt1 + paramInt2 > size()) {
      throw new IndexOutOfBoundsException("Source end offset exceeded: " + (paramInt1 + paramInt2));
    }
    if (paramInt2 > 0) {
      b(paramOutputStream, paramInt1, paramInt2);
    }
  }
  
  protected abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  abstract void b(OutputStream paramOutputStream, int paramInt1, int paramInt2);
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < 0) {
      throw new IndexOutOfBoundsException("Source offset < 0: " + paramInt1);
    }
    if (paramInt2 < 0) {
      throw new IndexOutOfBoundsException("Target offset < 0: " + paramInt2);
    }
    if (paramInt3 < 0) {
      throw new IndexOutOfBoundsException("Length < 0: " + paramInt3);
    }
    if (paramInt1 + paramInt3 > size()) {
      throw new IndexOutOfBoundsException("Source end offset < 0: " + (paramInt1 + paramInt3));
    }
    if (paramInt2 + paramInt3 > paramArrayOfByte.length) {
      throw new IndexOutOfBoundsException("Target end offset < 0: " + (paramInt2 + paramInt3));
    }
    if (paramInt3 > 0) {
      a(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    }
  }
  
  protected abstract int g(int paramInt1, int paramInt2, int paramInt3);
  
  protected abstract int h(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int hashCode();
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public abstract int size();
  
  public byte[] toByteArray()
  {
    int i = size();
    if (i == 0) {
      return i.ajg;
    }
    byte[] arrayOfByte = new byte[i];
    a(arrayOfByte, 0, 0, i);
    return arrayOfByte;
  }
  
  public String toString()
  {
    return String.format("<ByteString@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
  }
  
  public abstract String toString(String paramString);
  
  public static abstract interface a
    extends Iterator<Byte>
  {
    public abstract byte nextByte();
  }
  
  public static final class b
    extends OutputStream
  {
    private static final byte[] ajg = new byte[0];
    private final int ajh;
    private final ArrayList<e> aji;
    private int ajj;
    private int ajk;
    private byte[] buffer;
    
    b(int paramInt)
    {
      if (paramInt < 0) {
        throw new IllegalArgumentException("Buffer size < 0");
      }
      this.ajh = paramInt;
      this.aji = new ArrayList();
      this.buffer = new byte[paramInt];
    }
    
    private void AS()
    {
      if (this.ajk < this.buffer.length) {
        if (this.ajk > 0)
        {
          byte[] arrayOfByte = new byte[this.ajk];
          System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.ajk);
          this.aji.add(new m(arrayOfByte));
        }
      }
      for (;;)
      {
        this.ajj += this.ajk;
        this.ajk = 0;
        return;
        this.aji.add(new m(this.buffer));
        this.buffer = ajg;
      }
    }
    
    private void eS(int paramInt)
    {
      this.aji.add(new m(this.buffer));
      this.ajj += this.buffer.length;
      this.buffer = new byte[Math.max(this.ajh, Math.max(paramInt, this.ajj >>> 1))];
      this.ajk = 0;
    }
    
    public e AR()
    {
      try
      {
        AS();
        e locale = e.b(this.aji);
        return locale;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public int size()
    {
      try
      {
        int i = this.ajj;
        int j = this.ajk;
        return i + j;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public String toString()
    {
      return String.format("<ByteString.Output@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
    }
    
    public void write(int paramInt)
    {
      try
      {
        if (this.ajk == this.buffer.length) {
          eS(1);
        }
        byte[] arrayOfByte = this.buffer;
        int i = this.ajk;
        this.ajk = (i + 1);
        arrayOfByte[i] = ((byte)paramInt);
        return;
      }
      finally {}
    }
    
    /* Error */
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: iload_3
      //   3: aload_0
      //   4: getfield 42	com/google/tagmanager/protobuf/e$b:buffer	[B
      //   7: arraylength
      //   8: aload_0
      //   9: getfield 45	com/google/tagmanager/protobuf/e$b:ajk	I
      //   12: isub
      //   13: if_icmpgt +30 -> 43
      //   16: aload_1
      //   17: iload_2
      //   18: aload_0
      //   19: getfield 42	com/google/tagmanager/protobuf/e$b:buffer	[B
      //   22: aload_0
      //   23: getfield 45	com/google/tagmanager/protobuf/e$b:ajk	I
      //   26: iload_3
      //   27: invokestatic 51	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   30: aload_0
      //   31: aload_0
      //   32: getfield 45	com/google/tagmanager/protobuf/e$b:ajk	I
      //   35: iload_3
      //   36: iadd
      //   37: putfield 45	com/google/tagmanager/protobuf/e$b:ajk	I
      //   40: aload_0
      //   41: monitorexit
      //   42: return
      //   43: aload_0
      //   44: getfield 42	com/google/tagmanager/protobuf/e$b:buffer	[B
      //   47: arraylength
      //   48: aload_0
      //   49: getfield 45	com/google/tagmanager/protobuf/e$b:ajk	I
      //   52: isub
      //   53: istore 4
      //   55: aload_1
      //   56: iload_2
      //   57: aload_0
      //   58: getfield 42	com/google/tagmanager/protobuf/e$b:buffer	[B
      //   61: aload_0
      //   62: getfield 45	com/google/tagmanager/protobuf/e$b:ajk	I
      //   65: iload 4
      //   67: invokestatic 51	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   70: iload_3
      //   71: iload 4
      //   73: isub
      //   74: istore_3
      //   75: aload_0
      //   76: iload_3
      //   77: invokespecial 109	com/google/tagmanager/protobuf/e$b:eS	(I)V
      //   80: aload_1
      //   81: iload_2
      //   82: iload 4
      //   84: iadd
      //   85: aload_0
      //   86: getfield 42	com/google/tagmanager/protobuf/e$b:buffer	[B
      //   89: iconst_0
      //   90: iload_3
      //   91: invokestatic 51	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   94: aload_0
      //   95: iload_3
      //   96: putfield 45	com/google/tagmanager/protobuf/e$b:ajk	I
      //   99: goto -59 -> 40
      //   102: astore_1
      //   103: aload_0
      //   104: monitorexit
      //   105: aload_1
      //   106: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	107	0	this	b
      //   0	107	1	paramArrayOfByte	byte[]
      //   0	107	2	paramInt1	int
      //   0	107	3	paramInt2	int
      //   53	32	4	i	int
      // Exception table:
      //   from	to	target	type
      //   2	40	102	finally
      //   43	70	102	finally
      //   75	99	102	finally
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */