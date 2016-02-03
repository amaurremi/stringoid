package mobi.beyondpod.ui.views.impexp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.ui.core.volley.FadingNetworkImageView;
import mobi.beyondpod.ui.core.volley.ImageLoader;
import mobi.beyondpod.ui.views.FeedPreviewActivity;

class AudiobookSearchResultsListViewAdapter
  extends ArrayAdapter<FeedSearchResult>
{
  static Typeface FancyFont;
  private static final String IN_S = CoreHelper.LoadResourceString(2131297075);
  private static StringBuilder sFormatBuilder = new StringBuilder();
  private static Formatter sFormatter = new Formatter(sFormatBuilder, Locale.getDefault());
  private int entryViewResourceId;
  private List<FeedSearchResult> items;
  private ImageLoader mImageLoader;
  
  public AudiobookSearchResultsListViewAdapter(Context paramContext, int paramInt, List<FeedSearchResult> paramList, ImageLoader paramImageLoader)
  {
    super(paramContext, paramInt, paramList);
    this.items = paramList;
    this.entryViewResourceId = paramInt;
    this.mImageLoader = paramImageLoader;
  }
  
  public FeedSearchResult getItem(int paramInt)
  {
    return (FeedSearchResult)this.items.get(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    FeedSearchResult localFeedSearchResult;
    Object localObject1;
    Object localObject2;
    label304:
    label333:
    label366:
    String str;
    if (paramView == null)
    {
      localView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(this.entryViewResourceId, null);
      paramViewGroup = new ViewHolder(null);
      paramViewGroup.title = ((TextView)localView.findViewById(2131230818));
      paramViewGroup.description = ((TextView)localView.findViewById(2131230823));
      paramViewGroup.originatingFeed = ((TextView)localView.findViewById(2131230819));
      paramViewGroup.image = ((FadingNetworkImageView)localView.findViewById(2131230821));
      paramViewGroup.image.setFadeInImage(true);
      paramViewGroup.image.setDefaultImageResId(2130838006);
      paramViewGroup.image.setErrorImageResId(2130838012);
      paramViewGroup.image.setMaxImageSize(getContext().getResources().getDimensionPixelSize(2131492882), getContext().getResources().getDimensionPixelSize(2131492883));
      paramViewGroup.btnSubscribe = ((TextView)localView.findViewById(2131230822));
      paramViewGroup.LanguageTime = ((TextView)localView.findViewById(2131230820));
      localView.setTag(paramViewGroup);
      if (FancyFont != null) {
        paramViewGroup.title.setTypeface(FancyFont);
      }
      paramViewGroup.btnSubscribe.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = paramAnonymousView.getTag();
          if (paramAnonymousView != null)
          {
            paramAnonymousView = (Integer)paramAnonymousView;
            paramAnonymousView = (FeedSearchResult)AudiobookSearchResultsListViewAdapter.this.items.get(paramAnonymousView.intValue());
            FeedPreviewActivity.SubscribeFeed(AudiobookSearchResultsListViewAdapter.this.getContext(), paramAnonymousView.getLink(), paramAnonymousView.getTitle(), paramAnonymousView.getImageUrl());
          }
        }
      });
      paramViewGroup.btnSubscribe.setTag(Integer.valueOf(paramInt));
      localFeedSearchResult = (FeedSearchResult)this.items.get(paramInt);
      if ((localFeedSearchResult instanceof FeedSearchResult))
      {
        localObject1 = FeedRepository.GetFeedByUrl(localFeedSearchResult.getLink());
        if (localObject1 == null) {
          break label516;
        }
        paramView = ((Feed)localObject1).getCategories().getPrimary().Name();
        localObject1 = ((Feed)localObject1).getCategories().getSecondary().Name();
        localObject2 = CategoryManager.Unassigned.Name();
        if (((String)localObject2).equals(paramView)) {
          break label494;
        }
        paramViewGroup.btnSubscribe.setText(String.format(IN_S, new Object[] { paramView }));
        paramViewGroup.btnSubscribe.setEnabled(false);
        paramViewGroup.originatingFeed.setText(localFeedSearchResult.getOriginatingFeed());
        paramView = paramViewGroup.originatingFeed.getLayoutParams();
        if (!StringUtils.IsNullOrEmpty(localFeedSearchResult.getOriginatingFeed())) {
          break label537;
        }
        paramInt = 0;
        paramView.height = paramInt;
        paramViewGroup.title.setText(localFeedSearchResult.getTitle());
        paramViewGroup.description.setText(localFeedSearchResult.getDescription());
        sFormatBuilder.setLength(0);
        localObject1 = paramViewGroup.LanguageTime;
        localObject2 = sFormatter;
        str = localFeedSearchResult.getLanguage();
        if (localFeedSearchResult.getTotalTime() != null) {
          break label543;
        }
      }
    }
    label494:
    label516:
    label537:
    label543:
    for (paramView = "";; paramView = localFeedSearchResult.getTotalTime())
    {
      ((TextView)localObject1).setText(((Formatter)localObject2).format("%s%s", new Object[] { str, paramView }).toString());
      paramViewGroup.image.setImageUrl(localFeedSearchResult.getImageUrl(), this.mImageLoader);
      return localView;
      paramViewGroup = (ViewHolder)paramView.getTag();
      localView = paramView;
      break;
      if (!((String)localObject2).equals(localObject1))
      {
        paramView = (View)localObject1;
        break label304;
      }
      paramView = (View)localObject2;
      break label304;
      paramViewGroup.btnSubscribe.setText(2131297253);
      paramViewGroup.btnSubscribe.setEnabled(true);
      break label333;
      paramInt = -2;
      break label366;
    }
  }
  
  private static class ViewHolder
  {
    public TextView LanguageTime;
    public TextView btnSubscribe;
    public TextView description;
    public FadingNetworkImageView image;
    public TextView originatingFeed;
    public TextView title;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/impexp/AudiobookSearchResultsListViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */