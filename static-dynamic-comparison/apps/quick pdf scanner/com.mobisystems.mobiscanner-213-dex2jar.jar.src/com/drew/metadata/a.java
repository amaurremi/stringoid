package com.drew.metadata;

public class a
{
  private int fJ;
  private int fK;
  private int fL;
  private int fM;
  private int fN;
  private int fO;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.fJ = paramInt1;
    this.fK = paramInt2;
    this.fL = paramInt3;
    this.fM = paramInt4;
    this.fN = paramInt5;
    this.fO = paramInt6;
  }
  
  private static void a(StringBuilder paramStringBuilder, int paramInt, String paramString)
  {
    if (paramInt == 0) {}
    do
    {
      return;
      if (paramStringBuilder.length() != 0) {
        paramStringBuilder.append(' ');
      }
      paramStringBuilder.append(paramInt).append(' ').append(paramString);
    } while (paramInt == 1);
    paramStringBuilder.append('s');
  }
  
  public static a b(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    if ((paramString.length() != 19) || (paramString.startsWith("9999:99:99"))) {
      return null;
    }
    try
    {
      paramString = new a(Integer.parseInt(paramString.substring(0, 4)), Integer.parseInt(paramString.substring(5, 7)), Integer.parseInt(paramString.substring(8, 10)), Integer.parseInt(paramString.substring(11, 13)), Integer.parseInt(paramString.substring(14, 16)), Integer.parseInt(paramString.substring(17, 19)));
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  public String az()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, this.fJ, "year");
    a(localStringBuilder, this.fK, "month");
    a(localStringBuilder, this.fL, "day");
    a(localStringBuilder, this.fM, "hour");
    a(localStringBuilder, this.fN, "minute");
    a(localStringBuilder, this.fO, "second");
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.fL != ((a)paramObject).fL) {
        return false;
      }
      if (this.fM != ((a)paramObject).fM) {
        return false;
      }
      if (this.fN != ((a)paramObject).fN) {
        return false;
      }
      if (this.fK != ((a)paramObject).fK) {
        return false;
      }
      if (this.fO != ((a)paramObject).fO) {
        return false;
      }
    } while (this.fJ == ((a)paramObject).fJ);
    return false;
  }
  
  public int hashCode()
  {
    return ((((this.fJ * 31 + this.fK) * 31 + this.fL) * 31 + this.fM) * 31 + this.fN) * 31 + this.fO;
  }
  
  public String toString()
  {
    return String.format("%04d:%02d:%02d %02d:%02d:%02d", new Object[] { Integer.valueOf(this.fJ), Integer.valueOf(this.fK), Integer.valueOf(this.fL), Integer.valueOf(this.fM), Integer.valueOf(this.fN), Integer.valueOf(this.fO) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */