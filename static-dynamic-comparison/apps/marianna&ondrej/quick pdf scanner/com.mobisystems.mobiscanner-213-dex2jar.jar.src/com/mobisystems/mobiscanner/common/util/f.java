package com.mobisystems.mobiscanner.common.util;

public class f
{
  public double x;
  public double y;
  public double z;
  
  public f()
  {
    this(0.0D, 0.0D, 0.0D);
  }
  
  public f(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    this.x = paramDouble1;
    this.y = paramDouble2;
    this.z = paramDouble3;
  }
  
  public f DV()
  {
    return new f(this.x, this.y, this.z);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof f)) {
        return false;
      }
      paramObject = (f)paramObject;
    } while ((this.x == ((f)paramObject).x) && (this.y == ((f)paramObject).y) && (this.z == ((f)paramObject).z));
    return false;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.x);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.y);
    int j = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.z);
    return ((i + 31) * 31 + j) * 31 + (int)(l ^ l >>> 32);
  }
  
  public String toString()
  {
    return "{" + this.x + ", " + this.y + ", " + this.z + "}";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/common/util/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */