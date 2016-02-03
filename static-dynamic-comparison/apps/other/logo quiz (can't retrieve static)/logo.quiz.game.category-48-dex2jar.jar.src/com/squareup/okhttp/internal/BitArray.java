package com.squareup.okhttp.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract interface BitArray
{
  public abstract void clear();
  
  public abstract boolean get(int paramInt);
  
  public abstract void set(int paramInt);
  
  public abstract void shiftLeft(int paramInt);
  
  public abstract void toggle(int paramInt);
  
  public static final class FixedCapacity
    implements BitArray
  {
    long data = 0L;
    
    private static int checkInput(int paramInt)
    {
      if ((paramInt < 0) || (paramInt > 63)) {
        throw new IllegalArgumentException(String.format("input must be between 0 and 63: %s", new Object[] { Integer.valueOf(paramInt) }));
      }
      return paramInt;
    }
    
    public void clear()
    {
      this.data = 0L;
    }
    
    public boolean get(int paramInt)
    {
      return (this.data >> checkInput(paramInt) & 1L) == 1L;
    }
    
    public void set(int paramInt)
    {
      this.data |= 1L << checkInput(paramInt);
    }
    
    public void shiftLeft(int paramInt)
    {
      this.data <<= checkInput(paramInt);
    }
    
    public String toString()
    {
      return Long.toBinaryString(this.data);
    }
    
    public BitArray toVariableCapacity()
    {
      return new BitArray.VariableCapacity(this, null);
    }
    
    public void toggle(int paramInt)
    {
      this.data ^= 1L << checkInput(paramInt);
    }
  }
  
  public static final class VariableCapacity
    implements BitArray
  {
    long[] data;
    private int start;
    
    public VariableCapacity()
    {
      this.data = new long[1];
    }
    
    private VariableCapacity(BitArray.FixedCapacity paramFixedCapacity)
    {
      this.data = new long[] { paramFixedCapacity.data, 0L };
    }
    
    private static int checkInput(int paramInt)
    {
      if (paramInt < 0) {
        throw new IllegalArgumentException(String.format("input must be a positive number: %s", new Object[] { Integer.valueOf(paramInt) }));
      }
      return paramInt;
    }
    
    private void growToSize(int paramInt)
    {
      long[] arrayOfLong = new long[paramInt];
      if (this.data != null) {
        System.arraycopy(this.data, 0, arrayOfLong, 0, this.data.length);
      }
      this.data = arrayOfLong;
    }
    
    private int offsetOf(int paramInt)
    {
      paramInt = (paramInt + this.start) / 64;
      if (paramInt > this.data.length - 1) {
        growToSize(paramInt + 1);
      }
      return paramInt;
    }
    
    private int shiftOf(int paramInt)
    {
      return (this.start + paramInt) % 64;
    }
    
    public void clear()
    {
      Arrays.fill(this.data, 0L);
    }
    
    public boolean get(int paramInt)
    {
      checkInput(paramInt);
      int i = offsetOf(paramInt);
      return (this.data[i] & 1L << shiftOf(paramInt)) != 0L;
    }
    
    public void set(int paramInt)
    {
      checkInput(paramInt);
      int i = offsetOf(paramInt);
      long[] arrayOfLong = this.data;
      arrayOfLong[i] |= 1L << shiftOf(paramInt);
    }
    
    public void shiftLeft(int paramInt)
    {
      this.start -= checkInput(paramInt);
      if (this.start < 0)
      {
        paramInt = this.start / -64 + 1;
        long[] arrayOfLong = new long[this.data.length + paramInt];
        System.arraycopy(this.data, 0, arrayOfLong, paramInt, this.data.length);
        this.data = arrayOfLong;
        this.start = (this.start % 64 + 64);
      }
    }
    
    List<Integer> toIntegerList()
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      int j = this.data.length;
      int k = this.start;
      while (i < j * 64 - k)
      {
        if (get(i)) {
          localArrayList.add(Integer.valueOf(i));
        }
        i += 1;
      }
      return localArrayList;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("{");
      List localList = toIntegerList();
      int i = 0;
      int j = localList.size();
      while (i < j)
      {
        if (i > 0) {
          localStringBuilder.append(',');
        }
        localStringBuilder.append(localList.get(i));
        i += 1;
      }
      return '}';
    }
    
    public void toggle(int paramInt)
    {
      checkInput(paramInt);
      int i = offsetOf(paramInt);
      long[] arrayOfLong = this.data;
      arrayOfLong[i] ^= 1L << shiftOf(paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/BitArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */