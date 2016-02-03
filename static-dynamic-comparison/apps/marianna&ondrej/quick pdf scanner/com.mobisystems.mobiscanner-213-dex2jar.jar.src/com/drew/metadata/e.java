package com.drew.metadata;

public class e
{
  private final int fZ;
  private final b ga;
  
  public e(int paramInt, b paramb)
  {
    this.fZ = paramInt;
    this.ga = paramb;
  }
  
  public int aD()
  {
    return this.fZ;
  }
  
  public String getDescription()
  {
    return this.ga.getDescription(this.fZ);
  }
  
  public String getTagName()
  {
    return this.ga.getTagName(this.fZ);
  }
  
  public String toString()
  {
    String str2 = getDescription();
    String str1 = str2;
    if (str2 == null) {
      str1 = this.ga.getString(aD()) + " (unable to formulate description)";
    }
    return "[" + this.ga.getName() + "] " + getTagName() + " - " + str1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */