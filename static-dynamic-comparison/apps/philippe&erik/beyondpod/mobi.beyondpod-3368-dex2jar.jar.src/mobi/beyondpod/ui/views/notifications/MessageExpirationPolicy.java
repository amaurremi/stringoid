package mobi.beyondpod.ui.views.notifications;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.helpers.Version;

public abstract class MessageExpirationPolicy
{
  public static MessageExpirationPolicy BuildPolicy(String paramString)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {
      return new NeverExpireExpirationPolicy();
    }
    if (paramString.startsWith("SHOW_IF_VERSION_LESS_THAN:")) {
      return new VersionLessExpirationPolicy(ExtractData(paramString, "SHOW_IF_VERSION_LESS_THAN:"));
    }
    if (paramString.startsWith("SHOW_IF_VERSION_MORE_THAN:")) {
      return new VersionMoreExpirationPolicy(ExtractData(paramString, "SHOW_IF_VERSION_MORE_THAN:"));
    }
    if (paramString.startsWith("SHOW_IF_VERSION:")) {
      return new VersionEqualExpirationPolicy(ExtractData(paramString, "SHOW_IF_VERSION:"));
    }
    if (paramString.startsWith("SHOW_BEFORE:")) {
      return new DateExpirationPolicy(ExtractData(paramString, "SHOW_BEFORE:"));
    }
    return new NeverExpireExpirationPolicy();
  }
  
  private static String ExtractData(String paramString1, String paramString2)
  {
    if (StringUtils.IsNullOrEmpty(paramString1)) {
      return null;
    }
    return paramString1.substring(paramString2.length()).trim();
  }
  
  abstract boolean IsExpired();
  
  public static class DateExpirationPolicy
    extends MessageExpirationPolicy
  {
    public static final String TAG = "SHOW_BEFORE:";
    Date _TargetDate = new GregorianCalendar(2100, 1, 1).getTime();
    
    public DateExpirationPolicy(String paramString)
    {
      if (StringUtils.IsNullOrEmpty(paramString)) {}
      do
      {
        return;
        paramString = DateTime.TryParseDateTimeWithFormat(paramString, new SimpleDateFormat("yyyy-MM-dd"));
      } while (paramString == null);
      this._TargetDate = paramString;
    }
    
    boolean IsExpired()
    {
      return new Date().after(this._TargetDate);
    }
  }
  
  public static class NeverExpireExpirationPolicy
    extends MessageExpirationPolicy
  {
    boolean IsExpired()
    {
      return false;
    }
  }
  
  public static class VersionEqualExpirationPolicy
    extends MessageExpirationPolicy.VersionLessExpirationPolicy
  {
    public static final String TAG = "SHOW_IF_VERSION:";
    
    public VersionEqualExpirationPolicy(String paramString)
    {
      super();
    }
    
    boolean IsExpired()
    {
      return Version.Compare(Configuration.CurrentProductVersion(), this._TargetVersion) != 0;
    }
  }
  
  public static class VersionLessExpirationPolicy
    extends MessageExpirationPolicy
  {
    public static final String TAG = "SHOW_IF_VERSION_LESS_THAN:";
    protected Version _TargetVersion = new Version("0.0.0.0");
    
    public VersionLessExpirationPolicy(String paramString)
    {
      if (StringUtils.IsNullOrEmpty(paramString)) {
        return;
      }
      this._TargetVersion = new Version(paramString);
    }
    
    boolean IsExpired()
    {
      return Version.Compare(Configuration.CurrentProductVersion(), this._TargetVersion) >= 0;
    }
  }
  
  public static class VersionMoreExpirationPolicy
    extends MessageExpirationPolicy.VersionLessExpirationPolicy
  {
    public static final String TAG = "SHOW_IF_VERSION_MORE_THAN:";
    
    public VersionMoreExpirationPolicy(String paramString)
    {
      super();
    }
    
    boolean IsExpired()
    {
      return Version.Compare(Configuration.CurrentProductVersion(), this._TargetVersion) <= 0;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/notifications/MessageExpirationPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */