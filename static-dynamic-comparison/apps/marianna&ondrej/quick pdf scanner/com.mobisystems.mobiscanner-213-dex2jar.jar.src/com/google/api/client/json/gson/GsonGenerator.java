package com.google.api.client.json.gson;

import com.google.api.client.json.e;
import com.google.gson.stream.b;
import java.math.BigDecimal;
import java.math.BigInteger;

class GsonGenerator
  extends e
{
  private final b acH;
  private final a acI;
  
  GsonGenerator(a parama, b paramb)
  {
    this.acI = parama;
    this.acH = paramb;
    paramb.setLenient(true);
  }
  
  public void a(BigDecimal paramBigDecimal)
  {
    this.acH.a(paramBigDecimal);
  }
  
  public void a(BigInteger paramBigInteger)
  {
    this.acH.a(paramBigInteger);
  }
  
  public void cp(String paramString)
  {
    this.acH.cL(paramString);
  }
  
  public void eK(int paramInt)
  {
    this.acH.A(paramInt);
  }
  
  public void flush()
  {
    this.acH.flush();
  }
  
  public void j(double paramDouble)
  {
    this.acH.l(paramDouble);
  }
  
  public void s(float paramFloat)
  {
    this.acH.l(paramFloat);
  }
  
  public void writeBoolean(boolean paramBoolean)
  {
    this.acH.az(paramBoolean);
  }
  
  public void writeString(String paramString)
  {
    this.acH.cM(paramString);
  }
  
  public void ye()
  {
    this.acH.zT();
  }
  
  public void yf()
  {
    this.acH.zU();
  }
  
  public void yg()
  {
    this.acH.zV();
  }
  
  public void yh()
  {
    this.acH.zW();
  }
  
  public void yi()
  {
    this.acH.zX();
  }
  
  public void yj()
  {
    this.acH.setIndent("  ");
  }
  
  public void z(long paramLong)
  {
    this.acH.A(paramLong);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/json/gson/GsonGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */