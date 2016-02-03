package mobi.beyondpod.ui.views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import java.util.UUID;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.MediaFile;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import mobi.beyondpod.ui.dialogs.PreviewPlayer;
import mobi.beyondpod.ui.views.base.TitleBarBase.TitleInfo;
import mobi.beyondpod.ui.views.base.TitleBarFeedContent;
import mobi.beyondpod.ui.views.base.WorkspaceViewManagerPager;

public class FeedPreviewActivity
  extends FeedContentViewActivity
{
  private static final String THIS_FEED_ALREADY_EXISTS_IN_CATEGORY = CoreHelper.LoadResourceString(2131297042);
  
  public static void SubscribeAudioBook(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    Object localObject = FeedRepository.GetFeedByUrl(paramString1);
    if (localObject != null)
    {
      Toast.makeText(paramContext, String.format(THIS_FEED_ALREADY_EXISTS_IN_CATEGORY, new Object[] { ((Feed)localObject).getCategories().getPrimary().Name() }), 1).show();
      return;
    }
    Feed localFeed = new Feed(UUID.randomUUID(), null);
    localFeed.setType(6);
    localFeed.setFeedUrl(paramString1);
    localObject = paramString2;
    if (StringUtils.IsNullOrEmpty(paramString2)) {
      localObject = paramString1;
    }
    localFeed.setName((String)localObject);
    localFeed.setForceUniqueTrackNames(false);
    localFeed.setTrackSortOrder(0);
    localFeed.setAllowAutoTrackDeletions(1);
    if (!StringUtils.IsNullOrEmpty(paramString1)) {
      localFeed.setFeedImageUrl(paramString1);
    }
    Feed.SubscribeToFeedAndPromptForCategory(paramContext, localFeed, Configuration.getActiveFeedCategory().Value(), true);
  }
  
  public static void SubscribeFeed(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      return;
    }
    Feed localFeed = FeedRepository.GetFeedByUrl(paramString1);
    if (localFeed != null)
    {
      Toast.makeText(paramContext, String.format(THIS_FEED_ALREADY_EXISTS_IN_CATEGORY, new Object[] { localFeed.getCategories().getPrimary().Name() }), 1).show();
      return;
    }
    localFeed = new Feed(UUID.randomUUID(), null);
    localFeed.setFeedUrl(paramString1);
    if (!StringUtils.IsNullOrEmpty(paramString3)) {
      localFeed.setFeedImageUrl(paramString3);
    }
    if (StringUtils.IsNullOrEmpty(paramString2)) {}
    for (;;)
    {
      localFeed.setName(paramString1);
      Feed.SubscribeToFeedAndPromptForCategory(paramContext, localFeed, Configuration.getActiveFeedCategory().Value(), true);
      return;
      paramString1 = paramString2;
    }
  }
  
  protected int ConfigureFeedFilter(int paramInt, Feed paramFeed)
  {
    return 0;
  }
  
  public void PlayEnclosure(RssEnclosure paramRssEnclosure)
  {
    try
    {
      String str = paramRssEnclosure.Type;
      int j = MediaFile.MapMimeToContentType(str);
      int i;
      if (j != 0)
      {
        i = j;
        if (j != -1) {}
      }
      else
      {
        i = MediaFile.MapMimeToContentType(MediaFile.ConvertToStreamableMimeType(str, paramRssEnclosure.Url, ""));
      }
      if (i == 3) {}
      for (Intent localIntent = new Intent("android.intent.action.VIEW");; localIntent = new Intent(this, PreviewPlayer.class))
      {
        localIntent.setDataAndType(Uri.parse(paramRssEnclosure.Url), str);
        localIntent.putExtra("android.intent.extra.title", paramRssEnclosure.Parent.Title.toString());
        localIntent.putExtra("android.intent.extra.album", this.FeedContent.FeedContentList.CurrentFeed().ID().toString());
        localIntent.putExtra("output", i);
        startActivity(localIntent);
        return;
      }
      return;
    }
    catch (Exception paramRssEnclosure)
    {
      Toast.makeText(BeyondPodApplication.GetInstance(), getString(2131297032) + "\n\n" + paramRssEnclosure.getMessage(), 1).show();
    }
  }
  
  public void RefreshActiveViewTitle()
  {
    if (this.FeedContent == null) {
      return;
    }
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        TitleBarBase.TitleInfo localTitleInfo = FeedPreviewActivity.this.FeedContent.GetViewTitle();
        int i = FeedContentListViewDataSource.TotalItemCount();
        if (i > 0) {
          localTitleInfo.SubTitle = String.valueOf(i);
        }
        FeedPreviewActivity.this.SetTitle(localTitleInfo);
      }
    });
  }
  
  protected void WSLoadDataInWorkspaceViews()
  {
    super.WSLoadDataInWorkspaceViews();
    View localView = this.FeedContent.findViewById(2131230970);
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.Flipper.removePage(this.Player);
    this.FeedContent.FeedContentList.setHeaderEnabled(false);
    this.FeedContent.FeedContentList.ApplyFilter(0);
    this._Title.setFeedPreviewMode();
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return true;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo) {}
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return false;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return true;
    }
    super.onOptionsItemSelected(paramMenuItem);
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/FeedPreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */