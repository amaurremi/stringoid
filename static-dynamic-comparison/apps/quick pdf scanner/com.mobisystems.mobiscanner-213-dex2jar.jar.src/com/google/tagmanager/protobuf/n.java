package com.google.tagmanager.protobuf;

public abstract interface n
  extends o
{
  public abstract void a(CodedOutputStream paramCodedOutputStream);
  
  public abstract q<? extends n> fA();
  
  public abstract int fI();
  
  public abstract a fM();
  
  public abstract a fN();
  
  public abstract byte[] toByteArray();
  
  public static abstract interface a
    extends o, Cloneable
  {
    public abstract a e(f paramf, g paramg);
    
    public abstract n fX();
    
    public abstract n fY();
    
    public abstract a j(byte[] paramArrayOfByte);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */