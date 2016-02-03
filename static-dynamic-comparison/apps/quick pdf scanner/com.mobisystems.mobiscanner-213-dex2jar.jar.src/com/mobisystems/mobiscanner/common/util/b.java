package com.mobisystems.mobiscanner.common.util;

public class b
  implements Comparable<b>
{
  private double awI;
  private double awJ;
  private double awK;
  private double awL;
  private double awM;
  private double awN;
  private double awO;
  private double awP;
  
  public b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7)
  {
    this.awI = paramDouble1;
    this.awJ = paramDouble2;
    this.awK = paramDouble3;
    this.awL = paramDouble4;
    this.awM = paramDouble5;
    this.awN = paramDouble6;
    this.awP = paramDouble7;
    this.awO = Math.sqrt(Math.pow(paramDouble1 - paramDouble3, 2.0D) + Math.pow(paramDouble2 - paramDouble4, 2.0D));
  }
  
  public b(b paramb)
  {
    this(paramb.DR(), paramb.DQ(), paramb.DP(), paramb.DO(), paramb.DN(), paramb.DM(), paramb.DL());
  }
  
  public double DK()
  {
    return this.awO;
  }
  
  public double DL()
  {
    return this.awP;
  }
  
  public double DM()
  {
    return this.awN;
  }
  
  public double DN()
  {
    return this.awM;
  }
  
  public double DO()
  {
    return this.awL;
  }
  
  public double DP()
  {
    return this.awK;
  }
  
  public double DQ()
  {
    return this.awJ;
  }
  
  public double DR()
  {
    return this.awI;
  }
  
  public int a(b paramb)
  {
    return (int)Math.signum(this.awO - paramb.DK());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/common/util/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */