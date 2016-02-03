package mobi.beyondpod.rsscore.helpers;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.widget.RemoteViews;

public abstract class NotificationBuilderHelper
{
  public static NotificationBuilderHelper getInstance(Context paramContext)
  {
    if (CoreHelper.ApiLevel() < 11) {
      return new NotificationBuilderOld(paramContext);
    }
    return new NotificationBuilderNew(paramContext);
  }
  
  public abstract Notification getNotification(Notification paramNotification);
  
  public abstract NotificationBuilderHelper setContent(RemoteViews paramRemoteViews);
  
  public abstract NotificationBuilderHelper setContentIntent(PendingIntent paramPendingIntent);
  
  public abstract NotificationBuilderHelper setContentText(CharSequence paramCharSequence);
  
  public abstract NotificationBuilderHelper setContentTitle(CharSequence paramCharSequence);
  
  public abstract NotificationBuilderHelper setOngoing(boolean paramBoolean);
  
  public abstract NotificationBuilderHelper setSmallIcon(int paramInt);
  
  public abstract NotificationBuilderHelper setSmallIcon(int paramInt1, int paramInt2);
  
  public abstract NotificationBuilderHelper setTicker(CharSequence paramCharSequence);
  
  private static class NotificationBuilderNew
    extends NotificationBuilderHelper.NotificationBuilderOld
  {
    public NotificationBuilderNew(Context paramContext)
    {
      super();
    }
    
    @TargetApi(11)
    public Notification getNotification(Notification paramNotification)
    {
      if (paramNotification == null)
      {
        paramNotification = new Notification.Builder(this.mContext);
        if (this.mContent != null)
        {
          paramNotification.setContent(this.mContent);
          if (this.mSmallIconLevel == -1) {
            break label114;
          }
          paramNotification.setSmallIcon(this.mSmallIcon, this.mSmallIconLevel);
          label53:
          paramNotification.setTicker(this.mTickerText);
          if ((this.mFlags & 0x2) == 0) {
            break label126;
          }
        }
        label114:
        label126:
        for (boolean bool = true;; bool = false)
        {
          paramNotification.setOngoing(bool);
          paramNotification.setContentIntent(this.mContentIntent);
          return paramNotification.getNotification();
          paramNotification.setContentTitle(this.mContentTitle);
          paramNotification.setContentText(this.mContentText);
          break;
          paramNotification.setSmallIcon(this.mSmallIcon);
          break label53;
        }
      }
      if (this.mContent != null) {
        paramNotification.contentView = this.mContent;
      }
      for (;;)
      {
        UpdateExistingCommon(paramNotification);
        return paramNotification;
        UpdateExistingLatestEventInfo(paramNotification);
      }
    }
  }
  
  private static class NotificationBuilderOld
    extends NotificationBuilderHelper
  {
    protected RemoteViews mContent;
    protected PendingIntent mContentIntent;
    protected CharSequence mContentText;
    protected CharSequence mContentTitle;
    protected Context mContext;
    protected int mFlags;
    protected int mSmallIcon;
    protected int mSmallIconLevel = -1;
    protected CharSequence mTickerText;
    
    public NotificationBuilderOld(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    private void setFlag(int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.mFlags |= paramInt;
        return;
      }
      this.mFlags &= (paramInt ^ 0xFFFFFFFF);
    }
    
    protected void UpdateExistingCommon(Notification paramNotification)
    {
      paramNotification.tickerText = this.mTickerText;
      paramNotification.icon = this.mSmallIcon;
      paramNotification.flags = this.mFlags;
      if (this.mSmallIconLevel != -1) {
        paramNotification.iconLevel = this.mSmallIconLevel;
      }
    }
    
    protected void UpdateExistingLatestEventInfo(Notification paramNotification)
    {
      paramNotification.setLatestEventInfo(this.mContext, this.mContentTitle, this.mContentText, this.mContentIntent);
    }
    
    public Notification getNotification(Notification paramNotification)
    {
      paramNotification = new Notification();
      UpdateExistingCommon(paramNotification);
      UpdateExistingLatestEventInfo(paramNotification);
      return paramNotification;
    }
    
    public NotificationBuilderHelper setContent(RemoteViews paramRemoteViews)
    {
      this.mContent = paramRemoteViews;
      return this;
    }
    
    public NotificationBuilderHelper setContentIntent(PendingIntent paramPendingIntent)
    {
      this.mContentIntent = paramPendingIntent;
      return this;
    }
    
    public NotificationBuilderHelper setContentText(CharSequence paramCharSequence)
    {
      this.mContentText = paramCharSequence;
      return this;
    }
    
    public NotificationBuilderHelper setContentTitle(CharSequence paramCharSequence)
    {
      this.mContentTitle = paramCharSequence;
      return this;
    }
    
    public NotificationBuilderHelper setOngoing(boolean paramBoolean)
    {
      setFlag(2, paramBoolean);
      return this;
    }
    
    public NotificationBuilderHelper setSmallIcon(int paramInt)
    {
      this.mSmallIcon = paramInt;
      return this;
    }
    
    public NotificationBuilderHelper setSmallIcon(int paramInt1, int paramInt2)
    {
      setSmallIcon(paramInt1);
      this.mSmallIconLevel = paramInt2;
      return this;
    }
    
    public NotificationBuilderHelper setTicker(CharSequence paramCharSequence)
    {
      this.mTickerText = paramCharSequence;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/NotificationBuilderHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */