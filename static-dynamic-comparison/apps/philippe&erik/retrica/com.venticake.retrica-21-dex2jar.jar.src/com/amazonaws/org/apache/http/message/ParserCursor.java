package com.amazonaws.org.apache.http.message;

import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class ParserCursor
{
  private final int lowerBound;
  private int pos;
  private final int upperBound;
  
  public ParserCursor(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IndexOutOfBoundsException("Lower bound cannot be negative");
    }
    if (paramInt1 > paramInt2) {
      throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
    }
    this.lowerBound = paramInt1;
    this.upperBound = paramInt2;
    this.pos = paramInt1;
  }
  
  public boolean atEnd()
  {
    return this.pos >= this.upperBound;
  }
  
  public int getPos()
  {
    return this.pos;
  }
  
  public int getUpperBound()
  {
    return this.upperBound;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    localStringBuilder.append(Integer.toString(this.lowerBound));
    localStringBuilder.append('>');
    localStringBuilder.append(Integer.toString(this.pos));
    localStringBuilder.append('>');
    localStringBuilder.append(Integer.toString(this.upperBound));
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void updatePos(int paramInt)
  {
    if (paramInt < this.lowerBound) {
      throw new IndexOutOfBoundsException("pos: " + paramInt + " < lowerBound: " + this.lowerBound);
    }
    if (paramInt > this.upperBound) {
      throw new IndexOutOfBoundsException("pos: " + paramInt + " > upperBound: " + this.upperBound);
    }
    this.pos = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/message/ParserCursor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */