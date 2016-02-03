package com.drew.metadata;

public class c
{
  private final int _height;
  private final int _width;
  private final int fT;
  private final int fU;
  private final String fV;
  private final a fW;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, a parama)
  {
    this.fT = paramInt1;
    this.fU = paramInt2;
    this._width = paramInt3;
    this._height = paramInt4;
    this.fV = paramString;
    this.fW = parama;
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
      paramObject = (c)paramObject;
      if (this._height != ((c)paramObject)._height) {
        return false;
      }
      if (this._width != ((c)paramObject)._width) {
        return false;
      }
      if (this.fT != ((c)paramObject).fT) {
        return false;
      }
      if (this.fU != ((c)paramObject).fU) {
        return false;
      }
      if (this.fW != null)
      {
        if (this.fW.equals(((c)paramObject).fW)) {}
      }
      else {
        while (((c)paramObject).fW != null) {
          return false;
        }
      }
      if (this.fV == null) {
        break;
      }
    } while (this.fV.equals(((c)paramObject).fV));
    for (;;)
    {
      return false;
      if (((c)paramObject).fV == null) {
        break;
      }
    }
  }
  
  public int hashCode()
  {
    int j = 0;
    int k = this.fT;
    int m = this.fU;
    int n = this._width;
    int i1 = this._height;
    if (this.fV != null) {}
    for (int i = this.fV.hashCode();; i = 0)
    {
      if (this.fW != null) {
        j = this.fW.hashCode();
      }
      return (i + (((k * 31 + m) * 31 + n) * 31 + i1) * 31) * 31 + j;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("x: ").append(this.fT);
    localStringBuilder.append(" y: ").append(this.fU);
    localStringBuilder.append(" width: ").append(this._width);
    localStringBuilder.append(" height: ").append(this._height);
    if (this.fV != null) {
      localStringBuilder.append(" name: ").append(this.fV);
    }
    if (this.fW != null) {
      localStringBuilder.append(" age: ").append(this.fW.az());
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */