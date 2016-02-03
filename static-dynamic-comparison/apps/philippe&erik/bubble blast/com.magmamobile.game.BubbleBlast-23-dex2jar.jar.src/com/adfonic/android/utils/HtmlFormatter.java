package com.adfonic.android.utils;

public class HtmlFormatter
{
  private static final String HTML_FORMATTING_PREFIX = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"  \"http://www.w3.org/TR/html4/loose.dtd\" ><html lang=\"en\" style=\"width:100%; height:100%;\"><head><title>Adfonic</title><meta http-equiv=\"Content-type\" content=\"text/html;charset=UTF-8\"></head><body style=\"margin:0; padding:0; width:100%; height:100%;\"><table style=\"width:100%; height:100%; \" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"vertical-align:middle;\"><center>";
  private static final String HTML_FORMATTING_SUFFIX = "</center></td></tr></table></body></html>";
  public static final String TEXT_HTML = "text/html";
  public static final String UTF_8 = "utf-8";
  
  public String applyHtmlFormatting(String paramString)
  {
    return "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"  \"http://www.w3.org/TR/html4/loose.dtd\" ><html lang=\"en\" style=\"width:100%; height:100%;\"><head><title>Adfonic</title><meta http-equiv=\"Content-type\" content=\"text/html;charset=UTF-8\"></head><body style=\"margin:0; padding:0; width:100%; height:100%;\"><table style=\"width:100%; height:100%; \" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"vertical-align:middle;\"><center>" + paramString + "</center></td></tr></table></body></html>";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/utils/HtmlFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */