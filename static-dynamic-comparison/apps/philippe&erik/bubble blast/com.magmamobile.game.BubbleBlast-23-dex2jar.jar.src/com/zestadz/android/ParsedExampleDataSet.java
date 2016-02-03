package com.zestadz.android;

import java.util.ArrayList;
import java.util.List;

public class ParsedExampleDataSet
{
  static List<String> ExtractedError = new ArrayList();
  static List<String> extractedAdType;
  static List<String> extractedPicture;
  static List<String> extractedText = new ArrayList();
  static List<String> extractedURL;
  
  static
  {
    extractedPicture = new ArrayList();
    extractedURL = new ArrayList();
    extractedAdType = new ArrayList();
  }
  
  public static List<String> getExtractedAdType()
  {
    return extractedAdType;
  }
  
  public static List<String> getExtractedError()
  {
    return ExtractedError;
  }
  
  public static List<String> getExtractedPicture()
  {
    return extractedPicture;
  }
  
  public static List<String> getExtractedText()
  {
    return extractedText;
  }
  
  public static List<String> getExtractedURL()
  {
    return extractedURL;
  }
  
  public void setExtractedAdType(String paramString)
  {
    extractedAdType.add(paramString);
  }
  
  public void setExtractedError(String paramString)
  {
    ExtractedError.add(paramString);
  }
  
  public void setExtractedPicture(String paramString)
  {
    extractedPicture.add(paramString);
  }
  
  public void setExtractedText(String paramString)
  {
    extractedText.add(paramString);
  }
  
  public void setExtractedURL(String paramString)
  {
    extractedURL.add(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/zestadz/android/ParsedExampleDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */