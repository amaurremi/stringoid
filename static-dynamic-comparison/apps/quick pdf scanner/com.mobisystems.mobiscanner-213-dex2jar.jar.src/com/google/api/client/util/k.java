package com.google.api.client.util;

public class k
  implements c
{
  private int adF;
  private final int adG;
  private final double adH;
  private final double adI;
  private final int adJ;
  long adK;
  private final int adL;
  private final t adM;
  
  public k()
  {
    this(new a());
  }
  
  protected k(a parama)
  {
    this.adG = parama.adG;
    this.adH = parama.adH;
    this.adI = parama.adI;
    this.adJ = parama.adJ;
    this.adL = parama.adL;
    this.adM = parama.adM;
    if (this.adG > 0)
    {
      bool1 = true;
      x.av(bool1);
      if ((0.0D > this.adH) || (this.adH >= 1.0D)) {
        break label146;
      }
      bool1 = true;
      label87:
      x.av(bool1);
      if (this.adI < 1.0D) {
        break label151;
      }
      bool1 = true;
      label102:
      x.av(bool1);
      if (this.adJ < this.adG) {
        break label156;
      }
      bool1 = true;
      label119:
      x.av(bool1);
      if (this.adL <= 0) {
        break label161;
      }
    }
    label146:
    label151:
    label156:
    label161:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      x.av(bool1);
      reset();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label87;
      bool1 = false;
      break label102;
      bool1 = false;
      break label119;
    }
  }
  
  static int a(double paramDouble1, double paramDouble2, int paramInt)
  {
    paramDouble1 = paramInt * paramDouble1;
    double d = paramInt - paramDouble1;
    return (int)((paramDouble1 + paramInt - d + 1.0D) * paramDouble2 + d);
  }
  
  private void yN()
  {
    if (this.adF >= this.adJ / this.adI)
    {
      this.adF = this.adJ;
      return;
    }
    this.adF = ((int)(this.adF * this.adI));
  }
  
  public final void reset()
  {
    this.adF = this.adG;
    this.adK = this.adM.nanoTime();
  }
  
  public long yG()
  {
    if (yM() > this.adL) {
      return -1L;
    }
    int i = a(this.adH, Math.random(), this.adF);
    yN();
    return i;
  }
  
  public final long yM()
  {
    return (this.adM.nanoTime() - this.adK) / 1000000L;
  }
  
  public static class a
  {
    int adG = 500;
    double adH = 0.5D;
    double adI = 1.5D;
    int adJ = 60000;
    int adL = 900000;
    t adM = t.aee;
    
    public k yO()
    {
      return new k(this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */