package mobi.beyondpod.ui.views.impexp;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Iterator;
import mobi.beyondpod.aggregators.AggregatorLoginHelper;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.ui.core.ActionBarActivityBase;

public class DisableGoogleReaderDialog
  extends ActionBarActivityBase
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903100);
    paramBundle = (TextView)findViewById(2131230809);
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = AggregatorLoginHelper.getAllAggregatorFeeds();
    if (((FeedList)localObject).size() == 0)
    {
      AggregatorLoginHelper.ClearLogin();
      Toast.makeText(this, 2131297126, 1).show();
      finish();
      return;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localObject = ((FeedList)localObject).iterator();
    int i;
    if (!((Iterator)localObject).hasNext())
    {
      i = 0;
      if (localStringBuilder2.length() > 0)
      {
        i = 1;
        localStringBuilder1.append(getResources().getString(2131296529, new Object[] { localStringBuilder2 }));
      }
      localObject = AggregatorLoginHelper.getAllSpecialAggregatorFeeds();
      if (((FeedList)localObject).size() > 0)
      {
        localStringBuilder1.append("\n\n");
        localStringBuilder2 = new StringBuilder();
        localObject = ((FeedList)localObject).iterator();
      }
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        localStringBuilder1.append(getResources().getString(2131296530, new Object[] { localStringBuilder2.toString() }));
        paramBundle.setText(localStringBuilder1.toString());
        findViewById(2131230929).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            DisableGoogleReaderDialog.this.finish();
          }
        });
        paramBundle = (Button)findViewById(2131230928);
        if (i == 0) {
          break label351;
        }
        paramBundle.setText(2131296531);
        paramBundle.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            Toast.makeText(DisableGoogleReaderDialog.this, DisableGoogleReaderDialog.this.getResources().getString(2131296624, new Object[] { Integer.valueOf(AggregatorLoginHelper.DisconnectFromAggregator()) }), 0).show();
            DisableGoogleReaderDialog.this.finish();
          }
        });
        return;
        localFeed = (Feed)((Iterator)localObject).next();
        if (AggregatorLoginHelper.IsCategoryAggregatorFeed(localFeed)) {
          break;
        }
        localStringBuilder2.append("  • " + localFeed.getName() + "\n");
        break;
      }
      Feed localFeed = (Feed)((Iterator)localObject).next();
      localStringBuilder2.append("  • " + localFeed.getName() + "\n");
    }
    label351:
    paramBundle.setVisibility(8);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/impexp/DisableGoogleReaderDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */