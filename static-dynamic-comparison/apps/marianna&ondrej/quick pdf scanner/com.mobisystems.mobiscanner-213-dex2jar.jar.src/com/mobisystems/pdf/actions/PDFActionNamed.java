package com.mobisystems.pdf.actions;

public class PDFActionNamed
  extends PDFAction
{
  public static final int FIRST_PAGE = 1;
  public static final int LAST_PAGE = 4;
  public static final int NEXT_PAGE = 3;
  public static final int PREV_PAGE = 2;
  public static final int UNDEFINED = 0;
  
  public native int getAction();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/actions/PDFActionNamed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */