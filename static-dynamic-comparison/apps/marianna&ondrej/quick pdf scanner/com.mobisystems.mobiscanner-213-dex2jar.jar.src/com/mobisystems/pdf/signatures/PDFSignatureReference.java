package com.mobisystems.pdf.signatures;

public class PDFSignatureReference
{
  public class FieldLockAction
  {
    public static final int ALL = 1;
    public static final int EXCLUDE = 3;
    public static final int INCLUDE = 2;
    public static final int NONE = 0;
    
    public FieldLockAction() {}
  }
  
  public class MDPPermissions
  {
    public static final int LEVEL2 = 2;
    public static final int LEVEL3 = 3;
    public static final int NONE = 1;
    public static final int UNKNOWN = 0;
    
    public MDPPermissions() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/signatures/PDFSignatureReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */