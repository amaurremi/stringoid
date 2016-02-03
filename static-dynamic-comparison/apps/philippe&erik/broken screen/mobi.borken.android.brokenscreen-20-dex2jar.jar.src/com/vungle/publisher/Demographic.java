package com.vungle.publisher;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Demographic
{
  private Integer a;
  private Gender b;
  
  public Integer getAge()
  {
    return this.a;
  }
  
  public Gender getGender()
  {
    return this.b;
  }
  
  public boolean isEmpty()
  {
    return (this.a == null) && (this.b == null);
  }
  
  public void setAge(Integer paramInteger)
  {
    this.a = paramInteger;
  }
  
  public void setGender(Gender paramGender)
  {
    this.b = paramGender;
  }
  
  public static enum Gender
  {
    private Gender() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/Demographic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */