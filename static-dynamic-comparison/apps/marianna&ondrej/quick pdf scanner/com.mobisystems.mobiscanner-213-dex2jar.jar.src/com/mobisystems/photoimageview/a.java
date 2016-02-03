package com.mobisystems.photoimageview;

public class a
{
  private int aNn;
  private int aNo;
  private int aNp;
  private int aNq;
  private int aNr;
  private int aNs;
  private double aNt;
  private double aNu;
  private int aNv;
  private int aNw;
  private int aNx;
  private double aNy;
  private int amE;
  private int amF;
  private int mDuration;
  
  private int W(float paramFloat)
  {
    int j = (int)Math.round(this.aNn + this.aNv * paramFloat * this.aNu);
    int i;
    if ((this.aNu > 0.0D) && (this.aNn <= this.aNr)) {
      i = Math.min(j, this.aNr);
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (this.aNu >= 0.0D);
      i = j;
    } while (this.aNn < this.aNp);
    return Math.max(j, this.aNp);
  }
  
  private int X(float paramFloat)
  {
    int j = (int)Math.round(this.aNo + this.aNv * paramFloat * this.aNt);
    int i;
    if ((this.aNt > 0.0D) && (this.aNo <= this.aNs)) {
      i = Math.min(j, this.aNs);
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (this.aNt >= 0.0D);
      i = j;
    } while (this.aNo < this.aNq);
    return Math.max(j, this.aNq);
  }
  
  private double Y(float paramFloat)
  {
    return this.aNv * 4 * 1000 * Math.pow(1.0F - paramFloat, 3.0D) / this.mDuration;
  }
  
  public void V(float paramFloat)
  {
    paramFloat = Math.min(paramFloat, 1.0F);
    float f = 1.0F - (float)Math.pow(1.0F - paramFloat, 4.0D);
    this.amE = W(f);
    this.amF = X(f);
    this.aNy = Y(paramFloat);
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.aNn = paramInt1;
    this.aNo = paramInt2;
    this.aNp = paramInt5;
    this.aNq = paramInt7;
    this.aNr = paramInt6;
    this.aNs = paramInt8;
    double d = Math.hypot(paramInt3, paramInt4);
    this.aNt = (paramInt4 / d);
    this.aNu = (paramInt3 / d);
    this.mDuration = ((int)Math.round(50.0D * Math.pow(Math.abs(d), 0.3333333333333333D)));
    this.aNv = ((int)Math.round(d * this.mDuration / 4.0D / 1000.0D));
    this.aNw = W(1.0F);
    this.aNx = X(1.0F);
  }
  
  public int getCurrX()
  {
    return this.amE;
  }
  
  public int getCurrY()
  {
    return this.amF;
  }
  
  public int getDuration()
  {
    return this.mDuration;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/photoimageview/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */