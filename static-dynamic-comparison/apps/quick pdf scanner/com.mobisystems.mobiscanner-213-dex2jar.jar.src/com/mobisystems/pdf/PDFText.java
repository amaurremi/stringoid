package com.mobisystems.pdf;

public class PDFText
{
  long _handle;
  
  public PDFText()
  {
    PDFError.throwError(init());
  }
  
  private native void destroy();
  
  private native long getOffsetNative(float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2);
  
  private native boolean getWordNative(int paramInt, int[] paramArrayOfInt);
  
  private native int init();
  
  protected void finalize()
  {
    destroy();
    super.finalize();
  }
  
  public native int getLineEnd(int paramInt);
  
  public native PDFQuadrilateral getLineQuadrilateral(int paramInt);
  
  public native int getLineStart(int paramInt);
  
  public int getOffset(float paramFloat1, float paramFloat2)
  {
    return (int)(getOffsetNative(paramFloat1, paramFloat2, true, false) & 0xFFFFFFFF);
  }
  
  public int getOffset(float paramFloat1, float paramFloat2, boolean paramBoolean, OffsetResult paramOffsetResult)
  {
    if (paramOffsetResult != null)
    {
      long l = getOffsetNative(paramFloat1, paramFloat2, paramBoolean, true);
      paramOffsetResult.offset = ((int)(l & 0xFFFFFFFF));
      paramOffsetResult.lineIdx = ((int)(l >> 32 & 0xFFFFFFFF));
      return paramOffsetResult.offset;
    }
    return (int)(getOffsetNative(paramFloat1, paramFloat2, paramBoolean, false) & 0xFFFFFFFF);
  }
  
  public native PDFQuadrilateral getQuadrilateral(int paramInt);
  
  public native int getSelectionEnd();
  
  public native int getSelectionStart();
  
  public TextRegion getWord(int paramInt)
  {
    int[] arrayOfInt = new int[2];
    if (getWordNative(paramInt, arrayOfInt))
    {
      paramInt = arrayOfInt[0];
      int i = arrayOfInt[0];
      return new TextRegion(paramInt, arrayOfInt[1] + i);
    }
    return null;
  }
  
  public native int indexOf(String paramString, int paramInt);
  
  public native int length();
  
  public native int quadrilaterals();
  
  public native void setCursor(int paramInt, boolean paramBoolean);
  
  public static class OffsetResult
  {
    public int lineIdx;
    public int offset;
    
    public String toString()
    {
      return "OffsetResult(" + this.offset + ", " + this.lineIdx + ")";
    }
  }
  
  public static class TextRegion
  {
    private int end;
    private int start;
    
    public TextRegion(int paramInt1, int paramInt2)
    {
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    public int getEnd()
    {
      return this.end;
    }
    
    public int getStart()
    {
      return this.start;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/PDFText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */