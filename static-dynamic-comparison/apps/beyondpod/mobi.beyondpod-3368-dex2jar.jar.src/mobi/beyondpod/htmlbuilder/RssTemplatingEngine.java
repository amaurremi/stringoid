package mobi.beyondpod.htmlbuilder;

import java.io.File;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.events.ApplicationEvents.ApplicationErrorEvent;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;

public class RssTemplatingEngine
{
  private static final String DOWNLOAD_ENCODE_KEY = "";
  public static long LastTransformationDuration = 0L;
  private static final String STREAM_ENCODE_KEY = "";
  private static final ErrorMessageTemplate m_ErrorTmpl = new ErrorMessageTemplate(TemplateBase.TemplateTypes_RSS);
  private static final InfoMessageTemplate m_InfoTmpl = new InfoMessageTemplate(TemplateBase.TemplateTypes_RSS);
  
  public static String DecodeDownloadEnclosureUrl(String paramString)
  {
    return paramString.replace("", "");
  }
  
  public static String DecodeStreamEnclosureUrl(String paramString)
  {
    return paramString.replace("", "");
  }
  
  public static String EncodeDownloadEnclosureUrl(String paramString)
  {
    return paramString;
  }
  
  public static String EncodeStreamEnclosureUrl(String paramString)
  {
    return paramString;
  }
  
  public static boolean IsDownloadEncodedEnclosureUrl(String paramString)
  {
    return paramString.endsWith("");
  }
  
  public static boolean IsStreamEncodedEnclosureUrl(String paramString)
  {
    return paramString.endsWith("");
  }
  
  public static void ReloadAlltemplates() {}
  
  public static boolean TransformFeedLoadError(String paramString1, String paramString2, File paramFile)
  {
    m_ErrorTmpl.setFeedName(paramString1);
    m_ErrorTmpl.setMessage(paramString2);
    try
    {
      boolean bool = m_ErrorTmpl.SaveAsHtml(paramFile);
      return bool;
    }
    catch (Exception paramString1)
    {
      BeyondPodApplication.MessageBus.PublishEventAsync(new ApplicationEvents.ApplicationErrorEvent(paramString1, 0));
    }
    return false;
  }
  
  public static boolean TransformNoCachedFeedInfo(String paramString, File paramFile)
  {
    m_InfoTmpl.setFeedName(paramString);
    try
    {
      boolean bool = m_InfoTmpl.SaveAsHtml(paramFile);
      return bool;
    }
    catch (Exception paramString)
    {
      BeyondPodApplication.MessageBus.PublishEventAsync(new ApplicationEvents.ApplicationErrorEvent(paramString, 0));
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/htmlbuilder/RssTemplatingEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */