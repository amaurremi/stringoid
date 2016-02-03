package mobi.beyondpod.ui.views.notifications;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class Message
{
  private static final String EMBEDDED_IMAGE_ALT_MARKER = "#IMGALT#";
  private static final String EMBEDDED_IMAGE_MARKER = "#IMG#";
  public int ImageAltResourceId;
  public int ImageResourceId;
  public String MessageText;
  public String MessageTitle;
  public int RepeatInterval = 168;
  public String URL;
  private MessageExpirationPolicy _ExpirationPolicy;
  
  public Message() {}
  
  public Message(String paramString)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while (paramString.startsWith("--"));
      paramString = paramString.split("\\|");
      if (paramString.length > 0) {
        this.MessageText = paramString[0].replace("&lt;", "<").replace("&gt;", ">").replace("\\n", "\n");
      }
      if (paramString.length > 1) {
        this.URL = paramString[1];
      }
      if (paramString.length > 2) {
        this.RepeatInterval = StringUtils.TryParseIntFromString(paramString[2], Integer.valueOf(168)).intValue();
      }
    } while (paramString.length <= 3);
    this._ExpirationPolicy = MessageExpirationPolicy.BuildPolicy(paramString[3]);
  }
  
  public String ExpandURLTokens()
  {
    if (StringUtils.IsNullOrEmpty(this.URL)) {
      return "";
    }
    return this.URL.replace("#BP_VERSION#", Configuration.ProductVersion());
  }
  
  public Spannable FormattedMessage(Context paramContext)
  {
    SpannableString localSpannableString = new SpannableString(this.MessageText);
    int i;
    if (this.ImageResourceId > 0)
    {
      i = this.MessageText.indexOf("#IMG#");
      if (i >= 0) {
        localSpannableString.setSpan(new ImageSpan(paramContext, this.ImageResourceId), i, "#IMG#".length() + i, 33);
      }
    }
    if (this.ImageAltResourceId > 0)
    {
      i = this.MessageText.indexOf("#IMGALT#");
      if (i >= 0) {
        localSpannableString.setSpan(new ImageSpan(paramContext, this.ImageAltResourceId), i, "#IMGALT#".length() + i, 33);
      }
    }
    return localSpannableString;
  }
  
  public boolean HasText()
  {
    return !StringUtils.IsNullOrEmpty(this.MessageText);
  }
  
  public boolean IsExpired()
  {
    if (this._ExpirationPolicy != null) {
      return this._ExpirationPolicy.IsExpired();
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (!(paramObject instanceof Message)) {
          return false;
        }
        paramObject = (Message)paramObject;
        if (this.MessageText == null)
        {
          if (((Message)paramObject).MessageText != null) {
            return false;
          }
        }
        else if (!this.MessageText.equals(((Message)paramObject).MessageText)) {
          return false;
        }
        if (this.RepeatInterval != ((Message)paramObject).RepeatInterval) {
          return false;
        }
        if (this.URL != null) {
          break;
        }
      } while (((Message)paramObject).URL == null);
      return false;
    } while (this.URL.equals(((Message)paramObject).URL));
    return false;
  }
  
  public int hashCode()
  {
    int j = 0;
    int i;
    int k;
    if (this.MessageText == null)
    {
      i = 0;
      k = this.RepeatInterval;
      if (this.URL != null) {
        break label49;
      }
    }
    for (;;)
    {
      return ((i + 31) * 31 + k) * 31 + j;
      i = this.MessageText.hashCode();
      break;
      label49:
      j = this.URL.hashCode();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/notifications/Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */