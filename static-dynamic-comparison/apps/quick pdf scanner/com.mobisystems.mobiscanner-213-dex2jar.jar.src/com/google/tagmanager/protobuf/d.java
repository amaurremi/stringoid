package com.google.tagmanager.protobuf;

import java.util.NoSuchElementException;

class d
  extends m
{
  private final int ajc;
  private final int ajd;
  
  d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte);
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Offset too small: " + paramInt1);
    }
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("Length too small: " + paramInt1);
    }
    if (paramInt1 + paramInt2 > paramArrayOfByte.length) {
      throw new IllegalArgumentException("Offset+Length too large: " + paramInt1 + "+" + paramInt2);
    }
    this.ajc = paramInt1;
    this.ajd = paramInt2;
  }
  
  protected int AH()
  {
    return this.ajc;
  }
  
  public e.a AI()
  {
    return new a(null);
  }
  
  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.akd, AH() + paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public byte eR(int paramInt)
  {
    if (paramInt < 0) {
      throw new ArrayIndexOutOfBoundsException("Index too small: " + paramInt);
    }
    if (paramInt >= size()) {
      throw new ArrayIndexOutOfBoundsException("Index too large: " + paramInt + ", " + size());
    }
    return this.akd[(this.ajc + paramInt)];
  }
  
  public int size()
  {
    return this.ajd;
  }
  
  private class a
    implements e.a
  {
    private final int ahp = this.position + d.this.size();
    private int position = d.this.AH();
    
    private a() {}
    
    public Byte AJ()
    {
      return Byte.valueOf(nextByte());
    }
    
    public boolean hasNext()
    {
      return this.position < this.ahp;
    }
    
    public byte nextByte()
    {
      if (this.position >= this.ahp) {
        throw new NoSuchElementException();
      }
      byte[] arrayOfByte = d.this.akd;
      int i = this.position;
      this.position = (i + 1);
      return arrayOfByte[i];
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */