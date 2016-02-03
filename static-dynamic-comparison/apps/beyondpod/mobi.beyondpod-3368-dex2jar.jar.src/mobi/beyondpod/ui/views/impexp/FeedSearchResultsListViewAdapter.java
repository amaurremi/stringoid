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
import java.util.List;
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

class FeedSearchResultsListViewAdapter
  extends ArrayAdapter<FeedSearchResult>
{
  static Typeface FancyFont;
  private static final String IN_S = CoreHelper.LoadResourceString(2131297075);
  private int entryViewResourceId;
  private List<FeedSearchResult> items;
  private ImageLoader mImageLoader;
  
  public FeedSearchResultsListViewAdapter(Context paramContext, int paramInt, List<FeedSearchResult> paramList, ImageLoader paramImageLoader)
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
    Object localObject;
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
      paramViewGroup.image.setMaxImageSize(getContext().getResources().getDimensionPixelSize(2131492882), getContext().getResources().getDimensionPixelSize(2131492883));
      paramViewGroup.movieOverlay = localView.findViewById(2131230935);
      paramViewGroup.btnSubscribe = ((TextView)localView.findViewById(2131230822));
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
            FeedSearchResult localFeedSearchResult = (FeedSearchResult)FeedSearchResultsListViewAdapter.this.items.get(paramAnonymousView.intValue());
            String str = localFeedSearchResult.getOriginatingFeed();
            paramAnonymousView = str;
            if (StringUtils.IsNullOrEmpty(str)) {
              paramAnonymousView = localFeedSearchResult.getTitle();
            }
            FeedPreviewActivity.SubscribeFeed(FeedSearchResultsListViewAdapter.this.getContext(), localFeedSearchResult.getLink(), paramAnonymousView, null);
          }
        }
      });
      paramViewGroup.btnSubscribe.setTag(Integer.valueOf(paramInt));
      localFeedSearchResult = (FeedSearchResult)this.items.get(paramInt);
      if ((localFeedSearchResult instanceof FeedSearchResult))
      {
        localObject = FeedRepository.GetFeedByUrl(localFeedSearchResult.getLink());
        if (localObject == null) {
          break label486;
        }
        paramView = ((Feed)localObject).getCategories().getPrimary().Name();
        localObject = ((Feed)localObject).getCategories().getSecondary().Name();
        str = CategoryManager.Unassigned.Name();
        if (str.equals(paramView)) {
          break label464;
        }
        label292:
        paramViewGroup.btnSubscribe.setText(String.format(IN_S, new Object[] { paramView }));
        paramViewGroup.btnSubscribe.setEnabled(false);
        label321:
        paramViewGroup.originatingFeed.setText(localFeedSearchResult.getOriginatingFeed());
        paramView = paramViewGroup.originatingFeed.getLayoutParams();
        if (!StringUtils.IsNullOrEmpty(localFeedSearchResult.getOriginatingFeed())) {
          break label507;
        }
        paramInt = 0;
        label354:
        paramView.height = paramInt;
        paramViewGroup.title.setText(localFeedSearchResult.getTitle());
        paramViewGroup.description.setText(localFeedSearchResult.getDescription());
        paramView = paramViewGroup.movieOverlay;
        if (!StringUtils.Equals(localFeedSearchResult.getType(), "video")) {
          break label513;
        }
        paramInt = 0;
        label403:
        paramView.setVisibility(paramInt);
        if (!StringUtils.Equals(localFeedSearchResult.getType(), "video")) {
          break label519;
        }
        paramViewGroup.image.setErrorImageResId(2130838075);
      }
    }
    for (;;)
    {
      paramViewGroup.image.setImageUrl(localFeedSearchResult.getImageUrl(), this.mImageLoader);
      return localView;
      paramViewGroup = (ViewHolder)paramView.getTag();
      localView = paramView;
      break;
      label464:
      if (!str.equals(localObject))
      {
        paramView = (View)localObject;
        break label292;
      }
      paramView = str;
      break label292;
      label486:
      paramViewGroup.btnSubscribe.setText(2131297253);
      paramViewGroup.btnSubscribe.setEnabled(true);
      break label321;
      label507:
      paramInt = -2;
      break label354;
      label513:
      paramInt = 8;
      break label403;
      label519:
      paramViewGroup.image.setErrorImageResId(2130838071);
    }
  }
  
  private static class ViewHolder
  {
    public TextView btnSubscribe;
    public TextView description;
    public FadingNetworkImageView image;
    public View movieOverlay;
    public TextView originatingFeed;
    public TextView title;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/impexp/FeedSearchResultsListViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */