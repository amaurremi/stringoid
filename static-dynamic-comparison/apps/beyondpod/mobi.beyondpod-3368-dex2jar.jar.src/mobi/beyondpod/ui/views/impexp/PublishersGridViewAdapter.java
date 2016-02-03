package mobi.beyondpod.ui.views.impexp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.List;
import mobi.beyondpod.ui.core.volley.FadingNetworkImageView;
import mobi.beyondpod.ui.core.volley.ImageLoader;

class PublishersGridViewAdapter
  extends ArrayAdapter<FeedSearchResult>
{
  static Typeface FancyFont;
  private int entryViewResourceId;
  private List<FeedSearchResult> items;
  private ImageLoader mImageLoader;
  
  public PublishersGridViewAdapter(Context paramContext, int paramInt, List<FeedSearchResult> paramList, ImageLoader paramImageLoader)
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
    if (paramView == null)
    {
      paramView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(this.entryViewResourceId, null);
      paramViewGroup = new ViewHolder(null);
      paramViewGroup.image = ((FadingNetworkImageView)paramView.findViewById(2131230821));
      paramViewGroup.image.setFadeInImage(true);
      paramViewGroup.image.setDefaultImageResId(2130838006);
      paramViewGroup.image.setMaxImageSize(getContext().getResources().getDimensionPixelSize(2131492882), getContext().getResources().getDimensionPixelSize(2131492883));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      FeedSearchResult localFeedSearchResult = (FeedSearchResult)this.items.get(paramInt);
      if ((localFeedSearchResult instanceof FeedSearchResult)) {
        paramViewGroup.image.setImageUrl(localFeedSearchResult.getImageUrl(), this.mImageLoader);
      }
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
    }
  }
  
  private static class ViewHolder
  {
    public FadingNetworkImageView image;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/impexp/PublishersGridViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */