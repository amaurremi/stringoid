package mobi.beyondpod.ui.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.R.styleable;
import mobi.beyondpod.downloadengine.EnclosureDownloadManager;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.MediaFile;
import mobi.beyondpod.rsscore.helpers.MediaFile.MediaFileType;
import mobi.beyondpod.rsscore.helpers.Path;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.ui.core.FeedImageCache;
import mobi.beyondpod.ui.core.volley.FadingNetworkImageViewTrack;
import mobi.beyondpod.ui.core.volley.ImageLoaderTrack;

public class FeedContentListViewItemBuilder
{
  private static final String ACTION_DOWNLOAD;
  private static final String ACTION_RESUME_DOWNLOAD = CoreHelper.LoadResourceString(2131296974);
  private static final String ACTION_RE_DOWNLOAD;
  private static final String DOWNLOADING;
  private static final String DOWNLOADING_KB = CoreHelper.LoadResourceString(2131296968);
  private static final String DOWNLOADING_PERCENT = CoreHelper.LoadResourceString(2131296969);
  private static final String DOWNLOAD_PENDING;
  static Typeface FancyFont;
  private static final String TAG = FeedContentListViewItemBuilder.class.getSimpleName();
  static long _LastParseDuration;
  static Exception _ParseException;
  private int _DescriptionFontSize = 10;
  boolean _HasDPad;
  int _ImageHeight;
  int _ImageWidth;
  private LayoutInflater _Inflater;
  boolean _IsDefaultMultilineTitle;
  private int _ItemFontSize = 14;
  FeedContentListView _Owner;
  private ColorStateList _Primary;
  private ColorStateList _PrimaryRead;
  private int _ProgressWidth;
  private ColorStateList _Secondary;
  private ColorStateList _SecondaryRead;
  ImageLoader.ImageListener _prefetchImageListener = new ImageLoader.ImageListener()
  {
    public void onErrorResponse(VolleyError paramAnonymousVolleyError) {}
    
    public void onResponse(ImageLoader.ImageContainer paramAnonymousImageContainer, boolean paramAnonymousBoolean) {}
  };
  
  static
  {
    DOWNLOADING = CoreHelper.LoadResourceString(2131296970);
    DOWNLOAD_PENDING = CoreHelper.LoadResourceString(2131296971);
    ACTION_DOWNLOAD = CoreHelper.LoadResourceString(2131296972);
    ACTION_RE_DOWNLOAD = CoreHelper.LoadResourceString(2131296973);
  }
  
  public FeedContentListViewItemBuilder(FeedContentListView paramFeedContentListView)
  {
    this._Owner = paramFeedContentListView;
    if (paramFeedContentListView.getResources().getConfiguration().navigation != 1) {}
    for (boolean bool = true;; bool = false)
    {
      this._HasDPad = bool;
      this._IsDefaultMultilineTitle = paramFeedContentListView.getResources().getBoolean(2131427335);
      this._Inflater = LayoutInflater.from(this._Owner.getContext());
      paramFeedContentListView = this._Owner.getContext().obtainStyledAttributes(R.styleable.FeedContentListViewItemColors);
      this._Primary = paramFeedContentListView.getColorStateList(0);
      this._PrimaryRead = paramFeedContentListView.getColorStateList(1);
      this._Secondary = paramFeedContentListView.getColorStateList(2);
      this._SecondaryRead = paramFeedContentListView.getColorStateList(3);
      paramFeedContentListView.recycle();
      this._ImageWidth = ((int)this._Owner.getContext().getResources().getDimension(2131492882));
      this._ImageHeight = ((int)this._Owner.getContext().getResources().getDimension(2131492883));
      this._ProgressWidth = this._ImageWidth;
      LoadDefaultFontSize();
      return;
    }
  }
  
  private void AssignTrackPrimaryImage(ContentViewEpisodeItem paramContentViewEpisodeItem, Track paramTrack, int paramInt1, int paramInt2)
  {
    int k = 1;
    int j = 0;
    boolean bool = mobi.beyondpod.rsscore.Configuration.FeedContentItemOptimizeForReading();
    int i;
    if (!mobi.beyondpod.rsscore.Configuration.ShowContentListPostImages())
    {
      paramContentViewEpisodeItem.ItemImageArea.setVisibility(8);
      paramInt2 = 0;
      paramInt1 = paramInt2;
      if (paramTrack != null)
      {
        i = paramTrack.getCurrentPlayState();
        if (i != 1) {
          break label63;
        }
        paramInt1 = 2130837993;
      }
      for (;;)
      {
        paramContentViewEpisodeItem.ItemText.setCompoundDrawablesWithIntrinsicBounds(0, 0, paramInt1, 0);
        return;
        label63:
        if (i == 0)
        {
          paramInt1 = 2130837992;
        }
        else if ((i == 3) || (i == 6))
        {
          paramInt1 = 2130837994;
        }
        else if ((i != 3) && (i != 7))
        {
          paramInt1 = paramInt2;
          if (i != 8) {}
        }
        else
        {
          paramInt1 = 2130837991;
        }
      }
    }
    label167:
    label201:
    label211:
    ImageView localImageView;
    if ((mobi.beyondpod.rsscore.Configuration.AllowEpisodeStreaming() == 2) && (paramInt2 != 0) && (paramInt2 != 6))
    {
      i = 1;
      if (paramTrack != null) {
        break label295;
      }
      if ((!bool) || (i != 0)) {
        break label284;
      }
      paramContentViewEpisodeItem.NowPlaying.setImageResource(2130837995);
      if ((paramTrack == null) || (paramTrack.AllowAutoDelete()) || (paramInt2 == 5)) {
        break label433;
      }
      paramContentViewEpisodeItem.OverlayImage.setImageResource(2130838021);
      paramContentViewEpisodeItem.OverlayImage.setVisibility(0);
      if (!MediaFile.isVideoFileType(paramInt1)) {
        break label445;
      }
      i = 2;
      localImageView = paramContentViewEpisodeItem.MovieOverlay;
      if (i != 2) {
        break label462;
      }
    }
    label284:
    label295:
    label433:
    label445:
    label462:
    for (paramInt1 = j;; paramInt1 = 8)
    {
      localImageView.setVisibility(paramInt1);
      paramContentViewEpisodeItem.ItemImage.setErrorImageResId(FadingNetworkImageViewTrack.GetDefaultImage(i));
      if ((paramTrack != null) && (paramTrack.ContentType() != 3)) {
        break label468;
      }
      paramContentViewEpisodeItem.ItemImage.setFeed(this._Owner.CurrentFeed(), this._Owner.getImageLoader());
      return;
      i = 0;
      break;
      paramContentViewEpisodeItem.NowPlaying.setImageDrawable(null);
      break label167;
      int m = paramTrack.getCurrentPlayState();
      if (m == 1)
      {
        paramContentViewEpisodeItem.NowPlaying.setImageResource(2130837993);
        break label167;
      }
      if (m == 0)
      {
        paramContentViewEpisodeItem.NowPlaying.setImageResource(2130837992);
        break label167;
      }
      if ((m == 3) || (m == 6))
      {
        paramContentViewEpisodeItem.NowPlaying.setImageResource(2130837994);
        break label167;
      }
      if ((m == 3) || (m == 7) || (m == 8) || (m == 9))
      {
        paramContentViewEpisodeItem.NowPlaying.setImageResource(2130837991);
        break label167;
      }
      if ((bool) && (i == 0))
      {
        paramContentViewEpisodeItem.NowPlaying.setImageResource(2130837995);
        break label167;
      }
      paramContentViewEpisodeItem.NowPlaying.setImageDrawable(null);
      break label167;
      paramContentViewEpisodeItem.OverlayImage.setVisibility(8);
      break label201;
      i = k;
      if (!MediaFile.isImageFileType(paramInt1)) {
        break label211;
      }
      i = 3;
      break label211;
    }
    label468:
    if ((paramInt2 == 0) || (paramInt2 == 6))
    {
      paramContentViewEpisodeItem.ItemImage.setTrack(paramTrack, this._Owner.getImageLoader());
      return;
    }
    paramContentViewEpisodeItem.ItemImage.setFeed(this._Owner.CurrentFeed(), this._Owner.getImageLoader());
  }
  
  private void BuildCommonViewItem(ContentViewTextItem paramContentViewTextItem, RssFeedItem paramRssFeedItem, Feed paramFeed, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 255;
    int k = 0;
    paramContentViewTextItem.ItemText.setText(paramRssFeedItem.Title);
    TextView localTextView;
    Object localObject;
    if (paramContentViewTextItem.ItemContent != null)
    {
      if (!paramBoolean1) {
        break label453;
      }
      paramContentViewTextItem.ItemContent.setText(paramRssFeedItem.ShortTaglessDescription());
      paramContentViewTextItem.ItemContent.setTextSize(this._DescriptionFontSize);
      localTextView = paramContentViewTextItem.ItemContent;
      if (paramBoolean2)
      {
        localObject = this._SecondaryRead;
        localTextView.setTextColor((ColorStateList)localObject);
        paramContentViewTextItem.ItemContent.setEllipsize(TextUtils.TruncateAt.END);
      }
    }
    else
    {
      label88:
      localTextView = paramContentViewTextItem.ItemText;
      if (!paramBoolean2) {
        break label465;
      }
      localObject = this._PrimaryRead;
      label105:
      localTextView.setTextColor((ColorStateList)localObject);
      paramContentViewTextItem.ItemText.setTextSize(this._ItemFontSize);
      paramContentViewTextItem.ItemOriginatingFeed.setText(paramRssFeedItem.ResolveOriginatingFeedTitle());
      localTextView = paramContentViewTextItem.ItemPubDate;
      if (paramRssFeedItem.PubDate() == null) {
        break label474;
      }
      localObject = DateTime.FormatDateTime(paramRssFeedItem.PubDate());
      label157:
      localTextView.setText((CharSequence)localObject);
      localTextView = paramContentViewTextItem.ItemOriginatingFeed;
      if (!paramBoolean2) {
        break label482;
      }
      localObject = this._SecondaryRead;
      label181:
      localTextView.setTextColor((ColorStateList)localObject);
      localTextView = paramContentViewTextItem.ItemPubDate;
      if (!paramBoolean2) {
        break label491;
      }
      localObject = this._SecondaryRead;
      label205:
      localTextView.setTextColor((ColorStateList)localObject);
      localObject = paramContentViewTextItem.ReadUnreadStatus;
      if (!paramBoolean2) {
        break label500;
      }
      i = 2130838008;
      label228:
      ((ImageView)localObject).setImageResource(i);
      localObject = paramContentViewTextItem.ReadUnreadStatus;
      if ((!paramFeed.IsTransient) && (!paramRssFeedItem.IsMockItem().booleanValue())) {
        break label508;
      }
      i = 4;
      label261:
      ((ImageView)localObject).setVisibility(i);
      localObject = paramContentViewTextItem.ReadUnreadStatus;
      if (!paramRssFeedItem.IsGoogleReadLocked) {
        break label514;
      }
      paramBoolean1 = false;
      label284:
      ((ImageView)localObject).setEnabled(paramBoolean1);
      localObject = paramContentViewTextItem.ReadUnreadStatus.getDrawable().mutate();
      if ((!paramRssFeedItem.IsGoogleReadLocked) && (!paramRssFeedItem.IsMockItem().booleanValue())) {
        break label520;
      }
      i = 80;
      label324:
      ((Drawable)localObject).setAlpha(i);
      localObject = paramContentViewTextItem.Star;
      if (!FeedContentListViewDataSource.CurrentFeed().IsGReaderFeed()) {
        break label534;
      }
      if ((paramFeed.IsTransient) || (paramRssFeedItem.IsMockItem().booleanValue())) {
        break label528;
      }
      i = k;
      label367:
      ((ImageView)localObject).setVisibility(i);
      paramFeed = paramContentViewTextItem.Star;
      if (!paramRssFeedItem.getStarred()) {
        break label541;
      }
    }
    label453:
    label465:
    label474:
    label482:
    label491:
    label500:
    label508:
    label514:
    label520:
    label528:
    label534:
    label541:
    for (int i = 2130837696;; i = 2130837694)
    {
      paramFeed.setImageResource(i);
      paramFeed = paramContentViewTextItem.Star.getDrawable().mutate();
      i = j;
      if (paramBoolean2) {
        i = 125;
      }
      paramFeed.setAlpha(i);
      paramContentViewTextItem.ReadUnreadStatus.setTag(paramRssFeedItem);
      paramContentViewTextItem.Star.setTag(paramRssFeedItem);
      return;
      localObject = this._Secondary;
      break;
      paramContentViewTextItem.ItemContent.setVisibility(8);
      break label88;
      localObject = this._Primary;
      break label105;
      localObject = "";
      break label157;
      localObject = this._Secondary;
      break label181;
      localObject = this._Secondary;
      break label205;
      i = 2130838010;
      break label228;
      i = 0;
      break label261;
      paramBoolean1 = true;
      break label284;
      i = 255;
      break label324;
      i = 4;
      break label367;
      i = 8;
      break label367;
    }
  }
  
  private void BuildEpisodeViewItem(ContentViewEpisodeItem paramContentViewEpisodeItem, RssFeedItem paramRssFeedItem1, RssFeedItem paramRssFeedItem2, Feed paramFeed)
  {
    boolean bool1;
    label37:
    boolean bool2;
    label40:
    Object localObject2;
    Object localObject1;
    label64:
    Track localTrack;
    int k;
    label137:
    int j;
    label189:
    int i;
    if ((!paramRssFeedItem1.IsMockItem().booleanValue()) && (paramRssFeedItem1.getRead()))
    {
      bool1 = true;
      BuildCommonViewItem(paramContentViewEpisodeItem, paramRssFeedItem1, paramFeed, true, bool1);
      if (!mobi.beyondpod.rsscore.Configuration.MultilineEpisodeTitle()) {
        break label569;
      }
      bool2 = false;
      localObject2 = paramContentViewEpisodeItem.ItemText;
      if (!bool2) {
        break label605;
      }
      if (!paramFeed.getLeftTruncateLongTrackNames()) {
        break label582;
      }
      localObject1 = TextUtils.TruncateAt.START;
      ((TextView)localObject2).setEllipsize((TextUtils.TruncateAt)localObject1);
      paramContentViewEpisodeItem.ItemText.setSingleLine(bool2);
      localObject2 = paramRssFeedItem1.Enclosure();
      localTrack = paramFeed.Tracks().GetTrackByNameOrUrl(((RssEnclosure)localObject2).FileName(), ((RssEnclosure)localObject2).Url);
      k = ((RssEnclosure)localObject2).PlayableState(localTrack);
      if ((localTrack == null) || (!BeyondPodApplication.GetInstance().PlayList().HasTrack(localTrack))) {
        break label611;
      }
      bool2 = true;
      j = MediaFile.getFileTypeForMimeType(((RssEnclosure)localObject2).Type);
      localObject1 = Path.GetExtension(((RssEnclosure)localObject2).FileName());
      paramFeed = (Feed)localObject1;
      if (StringUtils.IsNullOrEmpty((String)localObject1)) {
        paramFeed = MediaFile.getFileExtensionForType(j);
      }
      if (!StringUtils.IsNullOrEmpty(paramFeed)) {
        break label617;
      }
      paramFeed = "";
      i = this._Owner.CurrentFeed().getItemFilter();
      localObject1 = paramContentViewEpisodeItem.Separator;
      if ((FeedContentListViewDataSource.IsEpisodeOnlyFilter(i)) || (!paramRssFeedItem1.IsMockItem().booleanValue()) || ((paramRssFeedItem2 != null) && ((paramRssFeedItem2 == null) || (paramRssFeedItem2.IsMockItem().booleanValue())))) {
        break label627;
      }
      i = 0;
      label246:
      ((TextView)localObject1).setVisibility(i);
      paramRssFeedItem2 = paramContentViewEpisodeItem.EnclosureInPlaylist;
      if (!bool2) {
        break label634;
      }
      i = 0;
      label266:
      paramRssFeedItem2.setVisibility(i);
      paramRssFeedItem2 = paramContentViewEpisodeItem.EnclosureStreamable;
      if ((k != 2) && (k != 7)) {
        break label640;
      }
      i = 0;
      label293:
      paramRssFeedItem2.setVisibility(i);
      paramRssFeedItem2 = paramContentViewEpisodeItem.PlayedPortionIndicator.getLayoutParams();
      if (localTrack == null) {
        break label653;
      }
      float f1 = this._ProgressWidth;
      float f2 = localTrack.PlayedAsFraction();
      if (localTrack.PlayedAsFraction() <= 0.0F) {
        break label647;
      }
      i = 1;
      label339:
      paramRssFeedItem2.width = ((int)Math.max(f2 * f1, i));
      paramContentViewEpisodeItem.PlayedPortionIndicator.setLayoutParams(paramRssFeedItem2);
      paramContentViewEpisodeItem.PlayedPortionIndicator.setVisibility(0);
      label371:
      paramRssFeedItem2 = (LevelListDrawable)paramContentViewEpisodeItem.PlayedPortionIndicator.getBackground();
      if (!bool1) {
        break label704;
      }
      i = 20;
      label391:
      paramRssFeedItem2.setLevel(i);
      if ((localTrack != null) && (localTrack.getTotalTime() > 0L)) {
        break label720;
      }
      localObject1 = paramContentViewEpisodeItem.Duration;
      if ((((RssEnclosure)localObject2).EnclosureFileLength() != null) && (((RssEnclosure)localObject2).EnclosureFileLength().longValue() >= 1024L)) {
        break label711;
      }
      paramRssFeedItem2 = "";
      label446:
      ((TextView)localObject1).setText(paramRssFeedItem2);
      label452:
      paramRssFeedItem2 = (LevelListDrawable)paramContentViewEpisodeItem.Duration.getBackground();
      if (!bool1) {
        break label795;
      }
      i = 20;
      label472:
      paramRssFeedItem2.setLevel(i);
      localObject1 = paramContentViewEpisodeItem.Duration;
      if (!bool1) {
        break label802;
      }
    }
    label569:
    label582:
    label605:
    label611:
    label617:
    label627:
    label634:
    label640:
    label647:
    label653:
    label704:
    label711:
    label720:
    label795:
    label802:
    for (paramRssFeedItem2 = this._PrimaryRead;; paramRssFeedItem2 = this._Primary)
    {
      ((TextView)localObject1).setTextColor(paramRssFeedItem2);
      i = j;
      if (j == 0)
      {
        paramRssFeedItem2 = MediaFile.getFileType(((RssEnclosure)localObject2).FileName());
        i = j;
        if (paramRssFeedItem2 != null) {
          i = paramRssFeedItem2.fileType;
        }
      }
      AssignTrackPrimaryImage(paramContentViewEpisodeItem, localTrack, i, k);
      WireDownloadPlaylistButtons(paramContentViewEpisodeItem, paramRssFeedItem1, (RssEnclosure)localObject2, localTrack, k, bool2, i, paramFeed);
      return;
      bool1 = false;
      break;
      if (this._IsDefaultMultilineTitle) {
        break label37;
      }
      bool2 = true;
      break label40;
      if (this._HasDPad)
      {
        localObject1 = TextUtils.TruncateAt.MARQUEE;
        break label64;
      }
      localObject1 = TextUtils.TruncateAt.END;
      break label64;
      localObject1 = null;
      break label64;
      bool2 = false;
      break label137;
      paramFeed = paramFeed.toLowerCase();
      break label189;
      i = 8;
      break label246;
      i = 4;
      break label266;
      i = 8;
      break label293;
      i = 0;
      break label339;
      if ((paramRssFeedItem1.getRead()) && (mobi.beyondpod.rsscore.Configuration.SetAsPlayedOnMarkRead()))
      {
        paramRssFeedItem2.width = this._ProgressWidth;
        paramContentViewEpisodeItem.PlayedPortionIndicator.setLayoutParams(paramRssFeedItem2);
        paramContentViewEpisodeItem.PlayedPortionIndicator.setVisibility(0);
        break label371;
      }
      paramContentViewEpisodeItem.PlayedPortionIndicator.setVisibility(4);
      break label371;
      i = 10;
      break label391;
      paramRssFeedItem2 = ((RssEnclosure)localObject2).EnclosureSizeAsString();
      break label446;
      paramContentViewEpisodeItem.Duration.setText(localTrack.TotalTimeAsString());
      if ((paramContentViewEpisodeItem.ItemText.getText().length() == 0) || (StringUtils.IsNullOrEmpty(paramRssFeedItem1.Link))) {
        paramContentViewEpisodeItem.ItemText.setText(localTrack.DisplayName());
      }
      if (StringUtils.IsNullOrEmpty(localTrack.TrackDescription())) {
        break label452;
      }
      paramContentViewEpisodeItem.ItemContent.setText(localTrack.TrackDescription());
      break label452;
      i = 10;
      break label472;
    }
  }
  
  private void BuildPreviewEpisodeViewItem(ContentViewEpisodeItem paramContentViewEpisodeItem, RssFeedItem paramRssFeedItem1, RssFeedItem paramRssFeedItem2, Feed paramFeed)
  {
    BuildCommonViewItem(paramContentViewEpisodeItem, paramRssFeedItem1, paramFeed, true, false);
    TextView localTextView = paramContentViewEpisodeItem.ItemText;
    int j;
    if (mobi.beyondpod.rsscore.Configuration.ShowContentListPostImages()) {
      if (paramFeed.getLeftTruncateLongTrackNames())
      {
        paramRssFeedItem2 = TextUtils.TruncateAt.START;
        localTextView.setEllipsize(paramRssFeedItem2);
        paramContentViewEpisodeItem.ItemText.setSingleLine(false);
        paramContentViewEpisodeItem.ItemContent.setCompoundDrawables(null, null, null, null);
        paramFeed = paramRssFeedItem1.Enclosure();
        j = MediaFile.getFileTypeForMimeType(paramFeed.Type);
        paramRssFeedItem2 = Path.GetExtension(paramFeed.FileName());
        paramRssFeedItem1 = paramRssFeedItem2;
        if (StringUtils.IsNullOrEmpty(paramRssFeedItem2)) {
          paramRssFeedItem1 = MediaFile.getFileExtensionForType(j);
        }
        if (!StringUtils.IsNullOrEmpty(paramRssFeedItem1)) {
          break label269;
        }
        label106:
        paramContentViewEpisodeItem.Separator.setVisibility(8);
        paramContentViewEpisodeItem.EnclosureInPlaylist.setVisibility(4);
        paramContentViewEpisodeItem.EnclosureStreamable.setVisibility(8);
        paramContentViewEpisodeItem.PlayedPortionIndicator.setVisibility(4);
        paramRssFeedItem2 = paramContentViewEpisodeItem.Duration;
        if ((paramFeed.EnclosureFileLength() != null) && (paramFeed.EnclosureFileLength().longValue() >= 1024L)) {
          break label277;
        }
        paramRssFeedItem1 = "";
        label172:
        paramRssFeedItem2.setText(paramRssFeedItem1);
        paramRssFeedItem1 = paramContentViewEpisodeItem.Duration;
        if (paramContentViewEpisodeItem.Duration.getText().length() != 0) {
          break label286;
        }
      }
    }
    label269:
    label277:
    label286:
    for (int i = 4;; i = 0)
    {
      paramRssFeedItem1.setVisibility(i);
      i = j;
      if (j == 0)
      {
        paramRssFeedItem1 = MediaFile.getFileType(paramFeed.FileName());
        i = j;
        if (paramRssFeedItem1 != null) {
          i = paramRssFeedItem1.fileType;
        }
      }
      AssignTrackPrimaryImage(paramContentViewEpisodeItem, null, i, 4);
      paramContentViewEpisodeItem.Toolbar.setVisibility(8);
      return;
      paramRssFeedItem2 = TextUtils.TruncateAt.MARQUEE;
      break;
      paramRssFeedItem2 = null;
      break;
      paramRssFeedItem1.toLowerCase();
      break label106;
      paramRssFeedItem1 = paramFeed.EnclosureSizeAsString();
      break label172;
    }
  }
  
  private void BuildTextViewItem(ContentViewTextItem paramContentViewTextItem, RssFeedItem paramRssFeedItem, Feed paramFeed)
  {
    boolean bool2 = mobi.beyondpod.rsscore.Configuration.ShowContentListPostImages();
    if ((!paramRssFeedItem.IsMockItem().booleanValue()) && (paramRssFeedItem.getRead())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      BuildCommonViewItem(paramContentViewTextItem, paramRssFeedItem, paramFeed, bool2, bool1);
      if (paramContentViewTextItem.ItemImage != null)
      {
        if (!bool2) {
          break;
        }
        paramContentViewTextItem.ItemImage.setVisibility(0);
        paramContentViewTextItem.ItemImage.setErrorImageResId(FeedImageCache.GetDefaultImageResId(paramFeed));
        paramContentViewTextItem.ItemImage.setRssItem(paramRssFeedItem, this._Owner.CurrentFeed(), this._Owner.getImageLoader());
      }
      return;
    }
    paramContentViewTextItem.ItemImage.setVisibility(8);
  }
  
  private void WireDownloadPlaylistButtons(ContentViewEpisodeItem paramContentViewEpisodeItem, RssFeedItem paramRssFeedItem, RssEnclosure paramRssEnclosure, Track paramTrack, int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    paramContentViewEpisodeItem.EnclosureDownload.setTag(paramRssFeedItem);
    paramContentViewEpisodeItem.EnclosureAddRemovePlaylist.setTag(paramRssFeedItem);
    paramContentViewEpisodeItem.EnclosureDelete.setTag(paramRssFeedItem);
    paramContentViewEpisodeItem.EpisodeNotes.setTag(paramRssFeedItem);
    if (mobi.beyondpod.rsscore.Configuration.FeedContentItemOptimizeForReading())
    {
      paramContentViewEpisodeItem.ItemImageArea.setTag(paramRssFeedItem);
      paramContentViewEpisodeItem.ItemImageArea.setOnClickListener(this._Owner);
      paramContentViewEpisodeItem.ItemImageArea.setOnLongClickListener(this._Owner);
    }
    int i;
    label119:
    int j;
    if ((StringUtils.IsNullOrEmpty(paramRssFeedItem.Description)) || (mobi.beyondpod.rsscore.Configuration.FeedContentItemOptimizeForReading()))
    {
      paramContentViewEpisodeItem.EpisodeNotes.setVisibility(8);
      paramContentViewEpisodeItem.ItemContent.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramRssFeedItem = paramContentViewEpisodeItem.EnclosureAddRemovePlaylist;
      if (!paramBoolean) {
        break label254;
      }
      i = 2130837971;
      paramRssFeedItem.setImageResource(i);
      j = 2130837950;
      if ((paramInt1 != 0) && (paramInt1 != 6)) {
        break label274;
      }
      paramRssFeedItem = paramContentViewEpisodeItem.EnclosureDelete;
      if (!paramTrack.AllowAutoDelete()) {
        break label262;
      }
      i = 0;
      label158:
      paramRssFeedItem.setVisibility(i);
      paramContentViewEpisodeItem.EnclosureDownload.setVisibility(4);
      paramRssFeedItem = paramContentViewEpisodeItem.EnclosureAddRemovePlaylist;
      if (!MediaFile.isImageFileType(paramInt2)) {
        break label268;
      }
      paramInt2 = 4;
      label188:
      paramRssFeedItem.setVisibility(paramInt2);
      paramInt2 = j;
    }
    for (;;)
    {
      if ((mobi.beyondpod.rsscore.Configuration.AllowEpisodeStreaming() == 2) && (paramInt1 != 0) && (paramInt1 != 6)) {
        paramContentViewEpisodeItem.EnclosureAddRemovePlaylist.setVisibility(4);
      }
      paramContentViewEpisodeItem.EnclosureDownload.setCompoundDrawablesWithIntrinsicBounds(paramInt2, 0, 0, 0);
      return;
      paramContentViewEpisodeItem.ItemContent.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837806, 0);
      break;
      label254:
      i = 2130837970;
      break label119;
      label262:
      i = 4;
      break label158;
      label268:
      paramInt2 = 0;
      break label188;
      label274:
      if ((paramInt1 == 2) || (paramInt1 == 7))
      {
        paramRssFeedItem = paramContentViewEpisodeItem.EnclosureDelete;
        if (paramTrack.AllowAutoDelete())
        {
          i = 0;
          label303:
          paramRssFeedItem.setVisibility(i);
          paramRssFeedItem = paramContentViewEpisodeItem.EnclosureDownload;
          if (!"swf".equals(paramString)) {
            break label372;
          }
        }
        label372:
        for (i = 4;; i = 0)
        {
          paramRssFeedItem.setVisibility(i);
          if (!EnclosureDownloadManager.IsDownloadPending(paramRssEnclosure)) {
            break label378;
          }
          paramInt2 = 0;
          paramContentViewEpisodeItem.EnclosureDownload.setText(DOWNLOAD_PENDING);
          paramContentViewEpisodeItem.EnclosureAddRemovePlaylist.setVisibility(8);
          break;
          i = 4;
          break label303;
        }
        label378:
        paramContentViewEpisodeItem.EnclosureDownload.setText(ACTION_DOWNLOAD);
        paramRssFeedItem = paramContentViewEpisodeItem.EnclosureAddRemovePlaylist;
        if (MediaFile.isImageFileType(paramInt2)) {}
        for (paramInt2 = 4;; paramInt2 = 0)
        {
          paramRssFeedItem.setVisibility(paramInt2);
          paramInt2 = j;
          break;
        }
      }
      paramContentViewEpisodeItem.EnclosureDelete.setVisibility(4);
      paramRssFeedItem = paramContentViewEpisodeItem.EnclosureDownload;
      if ("swf".equals(paramString))
      {
        i = 4;
        label450:
        paramRssFeedItem.setVisibility(i);
        if (paramInt1 != 5) {
          break label576;
        }
        paramInt2 = 2130837974;
        if (paramTrack == null) {
          break label563;
        }
        if (paramTrack.getDownloadSize() > 0L) {
          break label531;
        }
        paramContentViewEpisodeItem.EnclosureDownload.setText(String.format(DOWNLOADING_KB, new Object[] { CoreHelper.GetFileLengthAsString(Long.valueOf(paramTrack.getDownloadedPortion())) }));
      }
      for (;;)
      {
        paramContentViewEpisodeItem.EnclosureAddRemovePlaylist.setVisibility(8);
        break;
        i = 0;
        break label450;
        label531:
        paramContentViewEpisodeItem.EnclosureDownload.setText(String.format(DOWNLOADING_PERCENT, new Object[] { Integer.valueOf((int)paramTrack.getDownloadPercent()) }));
        continue;
        label563:
        paramContentViewEpisodeItem.EnclosureDownload.setText(DOWNLOADING);
      }
      label576:
      if (!EnclosureDownloadManager.IsDownloadPending(paramRssEnclosure)) {
        break label608;
      }
      paramInt2 = 0;
      paramContentViewEpisodeItem.EnclosureDownload.setText(DOWNLOAD_PENDING);
      paramContentViewEpisodeItem.EnclosureAddRemovePlaylist.setVisibility(8);
    }
    label608:
    if (paramInt1 == 1)
    {
      paramContentViewEpisodeItem.EnclosureDownload.setText(ACTION_RESUME_DOWNLOAD);
      paramContentViewEpisodeItem.EnclosureDelete.setVisibility(0);
      label632:
      paramRssFeedItem = paramContentViewEpisodeItem.EnclosureAddRemovePlaylist;
      if (!MediaFile.isImageFileType(paramInt2)) {
        break label693;
      }
    }
    label693:
    for (paramInt2 = 4;; paramInt2 = 0)
    {
      paramRssFeedItem.setVisibility(paramInt2);
      paramInt2 = j;
      break;
      if (paramInt1 == 3)
      {
        paramContentViewEpisodeItem.EnclosureDownload.setText(ACTION_RE_DOWNLOAD);
        break label632;
      }
      paramContentViewEpisodeItem.EnclosureDownload.setText(ACTION_DOWNLOAD);
      break label632;
    }
  }
  
  public static int getFilterStringResource(int paramInt)
  {
    if (paramInt == 3) {
      return 2131297153;
    }
    if (paramInt == 2) {
      return 2131297152;
    }
    if (paramInt == 1) {
      return 2131297151;
    }
    return 2131297154;
  }
  
  public View BuildEmptyView(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    View localView1 = this._Inflater.inflate(2130903105, null);
    TextView localTextView = (TextView)localView1.findViewById(2131230942);
    View localView2 = localView1.findViewById(2131230868);
    if (this._Owner.CurrentFeed() == null) {
      localTextView.setText(2131296920);
    }
    do
    {
      do
      {
        return localView1;
        localView2.setVisibility(8);
        if (!paramBoolean1) {
          break;
        }
        localTextView.setText(2131296917);
      } while (!paramBoolean3);
      localView2.setVisibility(0);
      return localView1;
      if (paramBoolean2)
      {
        localTextView.setText(2131296918);
        int i = this._Owner.CurrentFeed().getItemFilter();
        localTextView.setText(this._Owner.getContext().getString(2131296933, new Object[] { this._Owner.getResources().getString(getFilterStringResource(i)) }));
        return localView1;
      }
      if (!this._Owner.IsUpdating()) {
        break;
      }
      localTextView.setText(2131296919);
    } while (!paramBoolean3);
    localView2.setVisibility(0);
    return localView1;
    if (this._Owner.CurrentFeed().HasUri())
    {
      localTextView.setText(2131296920);
      return localView1;
    }
    localTextView.setText(2131296921);
    return localView1;
  }
  
  public View BuildViewFor(RssFeedItem paramRssFeedItem1, RssFeedItem paramRssFeedItem2, View paramView, Feed paramFeed)
  {
    Object localObject = paramView;
    View localView = paramView;
    for (;;)
    {
      try
      {
        if (paramRssFeedItem2.ItemID() == null) {
          break label1204;
        }
        localView = paramView;
        if (paramView != null)
        {
          localView = paramView;
          localObject = paramView;
          if (paramView.getTag() == null)
          {
            localObject = paramView;
            CoreHelper.WriteTraceEntry(TAG, "Found ConvertView without a Tag!");
            localView = null;
          }
        }
        localObject = localView;
        if (paramRssFeedItem2.Enclosure() == null)
        {
          if (localView == null)
          {
            localObject = localView;
            localView = this._Inflater.inflate(2130903109, null);
            localObject = localView;
            paramRssFeedItem1 = new ContentViewTextItem();
            localObject = localView;
            paramRssFeedItem1.Star = ((ImageView)localView.findViewById(2131230956));
            localObject = localView;
            paramRssFeedItem1.ReadUnreadStatus = ((ImageView)localView.findViewById(2131230957));
            localObject = localView;
            paramRssFeedItem1.ItemText = ((TextView)localView.findViewById(2131230966));
            localObject = localView;
            paramRssFeedItem1.ItemContent = ((TextView)localView.findViewById(2131230947));
            localObject = localView;
            paramRssFeedItem1.ItemOriginatingFeed = ((TextView)localView.findViewById(2131230950));
            localObject = localView;
            paramRssFeedItem1.ItemPubDate = ((TextView)localView.findViewById(2131230967));
            localObject = localView;
            paramRssFeedItem1.ItemImage = ((FadingNetworkImageViewTrack)localView.findViewById(2131230934));
            localObject = localView;
            if (paramRssFeedItem1.ItemImage != null)
            {
              localObject = localView;
              paramRssFeedItem1.ItemImage.setFadeInImage(true);
              localObject = localView;
              paramRssFeedItem1.ItemImage.setMaxImageSize(this._ImageWidth, this._ImageHeight);
              localObject = localView;
              paramRssFeedItem1.ItemImage.setImageDrawable(null);
              localObject = localView;
              paramRssFeedItem1.ItemImage.setDefaultImageResId(2130838006);
            }
            localObject = localView;
            localView.setTag(paramRssFeedItem1);
            localObject = localView;
            if (FancyFont != null)
            {
              localObject = localView;
              paramRssFeedItem1.ItemText.setTypeface(FancyFont);
            }
            localObject = localView;
            paramRssFeedItem1.ReadUnreadStatus.setOnClickListener(this._Owner);
            localObject = localView;
            paramRssFeedItem1.Star.setOnClickListener(this._Owner);
            localObject = localView;
            BuildTextViewItem(paramRssFeedItem1, paramRssFeedItem2, paramFeed);
            return localView;
          }
          localObject = localView;
          paramRssFeedItem1 = (ContentViewTextItem)localView.getTag();
          continue;
        }
        if (localView == null)
        {
          localObject = localView;
          localView = this._Inflater.inflate(2130903106, null);
          localObject = localView;
          paramView = new ContentViewEpisodeItem();
          localObject = localView;
          paramView.Star = ((ImageView)localView.findViewById(2131230956));
          localObject = localView;
          paramView.ReadUnreadStatus = ((ImageView)localView.findViewById(2131230957));
          localObject = localView;
          paramView.ItemText = ((TextView)localView.findViewById(2131230946));
          localObject = localView;
          paramView.ItemContent = ((TextView)localView.findViewById(2131230947));
          localObject = localView;
          paramView.ItemOriginatingFeed = ((TextView)localView.findViewById(2131230950));
          localObject = localView;
          paramView.ItemPubDate = ((TextView)localView.findViewById(2131230948));
          localObject = localView;
          paramView.ItemImageArea = localView.findViewById(2131230933);
          localObject = localView;
          paramView.ItemImage = ((FadingNetworkImageViewTrack)localView.findViewById(2131230934));
          localObject = localView;
          paramView.ItemImage.setFadeInImage(true);
          localObject = localView;
          paramView.ItemImage.setMaxImageSize(this._ImageWidth, this._ImageHeight);
          localObject = localView;
          paramView.ItemImage.setImageDrawable(null);
          localObject = localView;
          paramView.ItemImage.setDefaultImageResId(2130838006);
          localObject = localView;
          paramView.MovieOverlay = ((ImageView)localView.findViewById(2131230935));
          localObject = localView;
          paramView.OverlayImage = ((ImageView)localView.findViewById(2131230936));
          localObject = localView;
          paramView.NowPlaying = ((ImageView)localView.findViewById(2131230939));
          localObject = localView;
          paramView.EnclosureDownload = ((TextView)localView.findViewById(2131230953));
          localObject = localView;
          paramView.EnclosureDelete = ((ImageView)localView.findViewById(2131230954));
          localObject = localView;
          paramView.EnclosureAddRemovePlaylist = ((ImageView)localView.findViewById(2131230955));
          localObject = localView;
          paramView.EnclosureStreamable = localView.findViewById(2131230850);
          localObject = localView;
          paramView.EnclosureInPlaylist = ((ImageView)localView.findViewById(2131230949));
          localObject = localView;
          paramView.Duration = ((TextView)localView.findViewById(2131230937));
          localObject = localView;
          paramView.Separator = ((TextView)localView.findViewById(2131230944));
          localObject = localView;
          paramView.EpisodeNotes = localView.findViewById(2131230951);
          localObject = localView;
          paramView.PlayedPortionIndicator = localView.findViewById(2131230938);
          localObject = localView;
          paramView.Toolbar = localView.findViewById(2131230952);
          localObject = localView;
          paramView.ItemLayout = localView.findViewById(2131230943);
          localObject = localView;
          CoreHelper.ForceBackgroundTile(paramView.Toolbar);
          localObject = localView;
          if (!mobi.beyondpod.rsscore.Configuration.ShowContentListPostImages())
          {
            localObject = localView;
            paramView.ItemText.setSingleLine(false);
            localObject = localView;
            paramView.ItemContent.setMinLines(0);
            localObject = localView;
            paramView.ItemContent.setMaxLines(this._Owner.getContext().getResources().getInteger(2131361807));
          }
          localObject = localView;
          if (FancyFont != null)
          {
            localObject = localView;
            paramView.ItemText.setTypeface(FancyFont);
          }
          localObject = localView;
          if (!paramFeed.IsTransient)
          {
            localObject = localView;
            paramView.ReadUnreadStatus.setOnClickListener(this._Owner);
            localObject = localView;
            paramView.Star.setOnClickListener(this._Owner);
            localObject = localView;
            paramView.EnclosureDownload.setOnClickListener(this._Owner);
            localObject = localView;
            paramView.EnclosureAddRemovePlaylist.setOnClickListener(this._Owner);
            localObject = localView;
            paramView.EnclosureDelete.setOnClickListener(this._Owner);
            localObject = localView;
            paramView.ItemLayout.setOnClickListener(this._Owner);
            localObject = localView;
            paramView.ItemLayout.setOnLongClickListener(this._Owner);
            localObject = localView;
            paramView.EpisodeNotes.setOnClickListener(this._Owner);
            localObject = localView;
            paramView.EpisodeNotes.setOnLongClickListener(this._Owner);
          }
          localObject = localView;
          localView.setTag(paramView);
          localObject = localView;
          if (!paramFeed.IsTransient) {
            break;
          }
          localObject = localView;
          BuildPreviewEpisodeViewItem(paramView, paramRssFeedItem2, paramRssFeedItem1, paramFeed);
          return localView;
        }
      }
      catch (Exception paramRssFeedItem1)
      {
        CoreHelper.LogException(TAG, "Exception occured in GetView()", paramRssFeedItem1);
        return (View)localObject;
      }
      localObject = localView;
      paramView = (ContentViewEpisodeItem)localView.getTag();
    }
    localObject = localView;
    BuildEpisodeViewItem(paramView, paramRssFeedItem2, paramRssFeedItem1, paramFeed);
    label1204:
    return localView;
  }
  
  void LoadDefaultFontSize()
  {
    this._ItemFontSize = ((int)mobi.beyondpod.rsscore.Configuration.DefaultPrimaryFontSizeInUnits());
    this._DescriptionFontSize = ((int)mobi.beyondpod.rsscore.Configuration.DefaultDescriptionFontSizeInUnits());
  }
  
  boolean SupportsItemImages()
  {
    return true;
  }
  
  public void prefetchEpisodeImage(Track paramTrack)
  {
    String str;
    if (paramTrack.IsFullyDownloaded())
    {
      str = FadingNetworkImageViewTrack.getEpisodeImageUrl(paramTrack);
      if (!StringUtils.IsNullOrEmpty(str)) {
        ((ImageLoaderTrack)this._Owner.getImageLoader()).get(str, paramTrack, paramTrack.getParentFeed(), this._prefetchImageListener, this._ImageWidth, this._ImageHeight);
      }
    }
    do
    {
      return;
      str = FadingNetworkImageViewTrack.getFeedImageUrl(paramTrack.getParentFeed());
    } while (StringUtils.IsNullOrEmpty(str));
    ((ImageLoaderTrack)this._Owner.getImageLoader()).get(str, null, paramTrack.getParentFeed(), this._prefetchImageListener, this._ImageWidth, this._ImageHeight);
  }
  
  public void prefetchPostImage(RssFeedItem paramRssFeedItem)
  {
    paramRssFeedItem = FadingNetworkImageViewTrack.generateItemImageUrl(paramRssFeedItem);
    if (StringUtils.IsNullOrEmpty(paramRssFeedItem)) {
      return;
    }
    ((ImageLoaderTrack)this._Owner.getImageLoader()).get(paramRssFeedItem, null, this._Owner.CurrentFeed(), this._prefetchImageListener, this._ImageWidth, this._ImageHeight);
  }
  
  public static class ContentViewEpisodeItem
    extends FeedContentListViewItemBuilder.ContentViewTextItem
  {
    TextView Duration;
    ImageView EnclosureAddRemovePlaylist;
    ImageView EnclosureDelete;
    TextView EnclosureDownload;
    ImageView EnclosureInPlaylist;
    View EnclosureStreamable;
    View EpisodeNotes;
    View ItemImageArea;
    View ItemLayout;
    ImageView MovieOverlay;
    ImageView NowPlaying;
    ImageView OverlayImage;
    View PlayedPortionIndicator;
    TextView Separator;
    View Toolbar;
  }
  
  public static class ContentViewTextItem
  {
    TextView ItemContent;
    FadingNetworkImageViewTrack ItemImage;
    TextView ItemOriginatingFeed;
    TextView ItemPubDate;
    TextView ItemText;
    ImageView ReadUnreadStatus;
    ImageView Star;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/FeedContentListViewItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */