package mobi.beyondpod.ui.views.impexp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.volley.NetworkResponse;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import java.util.ArrayList;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper.DeviceNetworkConnection;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEvent;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEventListener;
import mobi.beyondpod.ui.core.volley.ImageLoader;
import mobi.beyondpod.ui.core.volley.ImageLoader.ImageLoaderProvider;
import org.json.JSONArray;

public abstract class SearchResultFragmentBase
  extends Fragment
  implements RepositoryEvents.RepositoryEventListener
{
  protected static final int MAX_PAGE_COUNT = 20;
  protected static final String SEARCH_RESULTS_TAG = "SEARCH_RESULTS";
  protected static final String SEARCH_RESULT_NO_MORE_RESULTS_TAG = "SEARCH_RESULT_NO_MORE_RESULTS";
  protected static final String SEARCH_RESULT_PAGE_TAG = "SEARCH_RESULT_PAGE";
  protected static final String SEARCH_RESULT_QUERY_TAG = "SEARCH_RESULT_QUERY";
  public static final String TAG = FeedSearchResultFragment.class.getSimpleName();
  protected int PAGE_SIZE = 20;
  protected ArrayAdapter<FeedSearchResult> _Adapter;
  protected int _CurrentPage;
  private View _EmptyProgress;
  private View _EmptyView;
  private TextView _EmptyViewText;
  protected FeedSearchService _FeedSearchService;
  protected ImageLoader _ImageLoader;
  View _InfoFooter = null;
  protected boolean _IsAppending;
  protected boolean _IsSearching;
  protected boolean _NoMoreResultsExist;
  protected String _Query;
  protected AbsListView _ResultView;
  protected ArrayList<FeedSearchResult> _SearchResults = new ArrayList();
  protected Object _SearchingLock = new Object();
  private Response.ErrorListener _errorListener = new Response.ErrorListener()
  {
    public void onErrorResponse(VolleyError paramAnonymousVolleyError)
    {
      SearchResultFragmentBase.this.setIsSearching(false);
      SearchResultFragmentBase.this.toggleProgressFooter(false);
      SearchResultFragmentBase.this._EmptyProgress.setVisibility(8);
      if (CoreHelper.GetDeviceNetworkConnection().IsConnectedToNetwork())
      {
        String str = SearchResultFragmentBase.TAG;
        StringBuilder localStringBuilder = new StringBuilder("Error performing search: Http Error: ");
        if (paramAnonymousVolleyError.networkResponse != null) {}
        for (paramAnonymousVolleyError = Integer.valueOf(paramAnonymousVolleyError.networkResponse.statusCode);; paramAnonymousVolleyError = paramAnonymousVolleyError.getMessage())
        {
          CoreHelper.WriteTraceEntry(str, paramAnonymousVolleyError);
          SearchResultFragmentBase.this._EmptyViewText.setText(2131297252);
          return;
        }
      }
      SearchResultFragmentBase.this._EmptyViewText.setText(2131297255);
      paramAnonymousVolleyError = new AlertDialog.Builder(SearchResultFragmentBase.this.getActivity());
      paramAnonymousVolleyError.setTitle(SearchResultFragmentBase.this.getActivity().getResources().getString(2131297256));
      paramAnonymousVolleyError.setMessage(SearchResultFragmentBase.this.getResources().getString(2131297252));
      paramAnonymousVolleyError.setNegativeButton(2131296752, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
      });
      paramAnonymousVolleyError.create().show();
    }
  };
  private SearchSuccessListener _successListener = new SearchSuccessListener();
  
  private void toggleProgressFooter(boolean paramBoolean)
  {
    if ((this._ResultView instanceof ListView))
    {
      if (paramBoolean) {
        ((ListView)this._ResultView).addFooterView(this._InfoFooter, null, false);
      }
    }
    else {
      return;
    }
    ((ListView)this._ResultView).removeFooterView(this._InfoFooter);
  }
  
  abstract View BuildContents(LayoutInflater paramLayoutInflater, Bundle paramBundle);
  
  protected void DoSearchInternal(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this._Query = paramString;
    this._EmptyViewText.setText(getResources().getString(2131297250));
    this._EmptyProgress.setVisibility(0);
    this._EmptyView.setVisibility(0);
    this._SearchResults.clear();
    this._Adapter.notifyDataSetChanged();
    this._CurrentPage = 0;
    performSearch(this._Query, false, this._CurrentPage);
  }
  
  abstract void ItemSelected(FeedSearchResult paramFeedSearchResult);
  
  public void OnRepositoryEvent(RepositoryEvents.RepositoryEvent paramRepositoryEvent)
  {
    if ((paramRepositoryEvent.Type == 5) && (this._Adapter != null)) {
      this._Adapter.notifyDataSetChanged();
    }
  }
  
  abstract void callSearch(String paramString, int paramInt, SearchSuccessListener paramSearchSuccessListener, Response.ErrorListener paramErrorListener)
    throws FeedSearchService.ServiceException;
  
  abstract CharSequence getEmptyText();
  
  abstract int getHeaderViewsCount();
  
  protected boolean isSearching()
  {
    synchronized (this._SearchingLock)
    {
      boolean bool = this._IsSearching;
      return bool;
    }
  }
  
  abstract void onAfterDataLoaded(boolean paramBoolean, String paramString);
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    BeyondPodApplication.MessageBus.Subscribe(this, RepositoryEvents.RepositoryEvent.class);
  }
  
  abstract void onBeforeDataLoaded(boolean paramBoolean, String paramString);
  
  public void onCreate(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this._InfoFooter = LayoutInflater.from(getActivity()).inflate(2130903120, null);
    setImageLoader(((ImageLoader.ImageLoaderProvider)getActivity()).getImageLoaderInstance());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = BuildContents(paramLayoutInflater, paramBundle);
    this._EmptyView = paramLayoutInflater.findViewById(2131231060);
    this._EmptyViewText = ((TextView)paramLayoutInflater.findViewById(2131231062));
    this._EmptyProgress = paramLayoutInflater.findViewById(2131231061);
    this._EmptyProgress.setVisibility(8);
    this._ResultView.setEmptyView(this._EmptyView);
    setIsSearching(true);
    toggleProgressFooter(true);
    if ((this._ResultView instanceof ListView)) {
      ((ListView)this._ResultView).setAdapter(this._Adapter);
    }
    for (;;)
    {
      toggleProgressFooter(false);
      this._ResultView.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public void onScroll(AbsListView arg1, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          int i;
          if (paramAnonymousInt3 - SearchResultFragmentBase.this.getHeaderViewsCount() > 0) {
            i = 1;
          }
          for (;;)
          {
            if ((i != 0) && (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3) && (!SearchResultFragmentBase.this._NoMoreResultsExist)) {}
            synchronized (SearchResultFragmentBase.this._SearchingLock)
            {
              boolean bool = SearchResultFragmentBase.this.isSearching();
              if (!bool) {
                SearchResultFragmentBase.this._IsSearching = true;
              }
              if (!bool)
              {
                ??? = SearchResultFragmentBase.this;
                ???._CurrentPage += 1;
                if (SearchResultFragmentBase.this._CurrentPage >= 20) {
                  SearchResultFragmentBase.this._NoMoreResultsExist = true;
                }
                SearchResultFragmentBase.this._IsSearching = true;
                SearchResultFragmentBase.this.performSearch(SearchResultFragmentBase.this._Query, true, SearchResultFragmentBase.this._CurrentPage);
              }
              return;
              i = 0;
            }
          }
        }
        
        public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
      });
      this._ResultView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = (FeedSearchResult)((ListAdapter)SearchResultFragmentBase.this._ResultView.getAdapter()).getItem(paramAnonymousInt);
          SearchResultFragmentBase.this.ItemSelected(paramAnonymousAdapterView);
        }
      });
      this._ResultView.postDelayed(new Runnable()
      {
        public void run()
        {
          SearchResultFragmentBase.this.setIsSearching(false);
        }
      }, 1000L);
      return paramLayoutInflater;
      ((GridView)this._ResultView).setAdapter(this._Adapter);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    BeyondPodApplication.MessageBus.Unsubscribe(this, RepositoryEvents.RepositoryEvent.class);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this._Query = paramBundle.getString("SEARCH_RESULT_QUERY");
      this._CurrentPage = paramBundle.getInt("SEARCH_RESULT_PAGE");
      this._NoMoreResultsExist = paramBundle.getBoolean("SEARCH_RESULT_NO_MORE_RESULTS");
      this._SearchResults = paramBundle.getParcelableArrayList("SEARCH_RESULTS");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("SEARCH_RESULT_QUERY", this._Query);
    paramBundle.putInt("SEARCH_RESULT_PAGE", this._CurrentPage);
    paramBundle.putBoolean("SEARCH_RESULT_NO_MORE_RESULTS", this._NoMoreResultsExist);
    paramBundle.putParcelableArrayList("SEARCH_RESULTS", this._SearchResults);
  }
  
  protected void parseJSONResults(String paramString, JSONArray paramJSONArray, Object[] paramArrayOfObject)
    throws FeedSearchService.ServiceException
  {
    paramArrayOfObject[0] = this._FeedSearchService.parseJSONResults(paramJSONArray);
  }
  
  protected void performSearch(String paramString, boolean paramBoolean, int paramInt)
  {
    setIsSearching(true);
    setIsAppending(paramBoolean);
    if (paramInt != 0) {
      toggleProgressFooter(true);
    }
    try
    {
      this._successListener.setQuery(paramString);
      callSearch(paramString, paramInt, this._successListener, this._errorListener);
      return;
    }
    catch (Exception paramString)
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
      localBuilder.setMessage(getResources().getString(2131297252));
      localBuilder.setNegativeButton(2131296752, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      localBuilder.create().show();
      CoreHelper.LogException(TAG, getResources().getString(2131297252), paramString);
      setIsSearching(false);
      toggleProgressFooter(false);
    }
  }
  
  public void setImageLoader(ImageLoader paramImageLoader)
  {
    this._ImageLoader = paramImageLoader;
    if (this._ImageLoader != null) {
      this._FeedSearchService = new FeedSearchService(Configuration.BeyondPodPublicAPIRoot(), this._ImageLoader.getRequestQueue());
    }
  }
  
  protected void setIsAppending(boolean paramBoolean)
  {
    this._IsAppending = paramBoolean;
  }
  
  protected void setIsSearching(boolean paramBoolean)
  {
    synchronized (this._SearchingLock)
    {
      this._IsSearching = paramBoolean;
      return;
    }
  }
  
  class SearchSuccessListener
    implements Response.Listener<JSONArray>
  {
    String _Query;
    
    SearchSuccessListener() {}
    
    /* Error */
    public void onResponse(JSONArray paramJSONArray)
    {
      // Byte code:
      //   0: iconst_2
      //   1: anewarray 5	java/lang/Object
      //   4: astore 4
      //   6: aload_0
      //   7: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   10: getfield 35	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:_ResultView	Landroid/widget/AbsListView;
      //   13: instanceof 37
      //   16: ifeq +34 -> 50
      //   19: aload_0
      //   20: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   23: getfield 41	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:_InfoFooter	Landroid/view/View;
      //   26: ifnull +24 -> 50
      //   29: aload_0
      //   30: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   33: getfield 35	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:_ResultView	Landroid/widget/AbsListView;
      //   36: checkcast 37	android/widget/ListView
      //   39: aload_0
      //   40: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   43: getfield 41	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:_InfoFooter	Landroid/view/View;
      //   46: invokevirtual 45	android/widget/ListView:removeFooterView	(Landroid/view/View;)Z
      //   49: pop
      //   50: aload_0
      //   51: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   54: invokestatic 49	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:access$1	(Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;)Landroid/view/View;
      //   57: bipush 8
      //   59: invokevirtual 55	android/view/View:setVisibility	(I)V
      //   62: aload_0
      //   63: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   66: aload_0
      //   67: getfield 57	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:_Query	Ljava/lang/String;
      //   70: aload_1
      //   71: aload 4
      //   73: invokevirtual 61	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:parseJSONResults	(Ljava/lang/String;Lorg/json/JSONArray;[Ljava/lang/Object;)V
      //   76: aload_0
      //   77: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   80: getfield 65	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:_IsAppending	Z
      //   83: ifne +13 -> 96
      //   86: aload_0
      //   87: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   90: getfield 69	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:_SearchResults	Ljava/util/ArrayList;
      //   93: invokevirtual 74	java/util/ArrayList:clear	()V
      //   96: aload 4
      //   98: iconst_0
      //   99: aaload
      //   100: ifnull +71 -> 171
      //   103: iconst_0
      //   104: istore_2
      //   105: aload_0
      //   106: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   109: aload_0
      //   110: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   113: getfield 65	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:_IsAppending	Z
      //   116: aload 4
      //   118: iconst_1
      //   119: aaload
      //   120: checkcast 76	java/lang/String
      //   123: invokevirtual 80	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:onBeforeDataLoaded	(ZLjava/lang/String;)V
      //   126: aload 4
      //   128: iconst_0
      //   129: aaload
      //   130: checkcast 82	java/util/List
      //   133: invokeinterface 86 1 0
      //   138: astore_1
      //   139: aload_1
      //   140: invokeinterface 92 1 0
      //   145: ifne +104 -> 249
      //   148: aload_0
      //   149: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   152: astore_1
      //   153: iload_2
      //   154: aload_0
      //   155: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   158: getfield 96	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:PAGE_SIZE	I
      //   161: if_icmpge +119 -> 280
      //   164: iconst_1
      //   165: istore_3
      //   166: aload_1
      //   167: iload_3
      //   168: putfield 99	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:_NoMoreResultsExist	Z
      //   171: aload_0
      //   172: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   175: getfield 69	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:_SearchResults	Ljava/util/ArrayList;
      //   178: invokevirtual 103	java/util/ArrayList:size	()I
      //   181: ifne +20 -> 201
      //   184: aload_0
      //   185: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   188: invokestatic 107	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:access$2	(Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;)Landroid/widget/TextView;
      //   191: aload_0
      //   192: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   195: invokevirtual 111	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:getEmptyText	()Ljava/lang/CharSequence;
      //   198: invokevirtual 117	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   201: aload_0
      //   202: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   205: aload_0
      //   206: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   209: getfield 65	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:_IsAppending	Z
      //   212: aload 4
      //   214: iconst_1
      //   215: aaload
      //   216: checkcast 76	java/lang/String
      //   219: invokevirtual 120	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:onAfterDataLoaded	(ZLjava/lang/String;)V
      //   222: aload_0
      //   223: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   226: getfield 124	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:_Adapter	Landroid/widget/ArrayAdapter;
      //   229: invokevirtual 129	android/widget/ArrayAdapter:notifyDataSetChanged	()V
      //   232: aload_0
      //   233: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   236: iconst_0
      //   237: invokevirtual 133	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:setIsSearching	(Z)V
      //   240: aload_0
      //   241: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   244: iconst_0
      //   245: invokestatic 137	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:access$0	(Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;Z)V
      //   248: return
      //   249: aload_1
      //   250: invokeinterface 141 1 0
      //   255: checkcast 143	mobi/beyondpod/ui/views/impexp/FeedSearchResult
      //   258: astore 5
      //   260: aload_0
      //   261: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   264: getfield 69	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:_SearchResults	Ljava/util/ArrayList;
      //   267: aload 5
      //   269: invokevirtual 147	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   272: pop
      //   273: iload_2
      //   274: iconst_1
      //   275: iadd
      //   276: istore_2
      //   277: goto -138 -> 139
      //   280: iconst_0
      //   281: istore_3
      //   282: goto -116 -> 166
      //   285: astore_1
      //   286: aload_0
      //   287: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   290: invokestatic 107	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:access$2	(Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;)Landroid/widget/TextView;
      //   293: ldc -108
      //   295: invokevirtual 150	android/widget/TextView:setText	(I)V
      //   298: getstatic 153	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:TAG	Ljava/lang/String;
      //   301: new 155	java/lang/StringBuilder
      //   304: dup
      //   305: ldc -99
      //   307: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   310: aload_1
      //   311: invokevirtual 164	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   314: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   317: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   320: invokestatic 177	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
      //   323: aload_0
      //   324: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   327: iconst_0
      //   328: invokevirtual 133	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:setIsSearching	(Z)V
      //   331: aload_0
      //   332: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   335: iconst_0
      //   336: invokestatic 137	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:access$0	(Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;Z)V
      //   339: return
      //   340: astore_1
      //   341: aload_0
      //   342: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   345: iconst_0
      //   346: invokevirtual 133	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:setIsSearching	(Z)V
      //   349: aload_0
      //   350: getfield 18	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase$SearchSuccessListener:this$0	Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;
      //   353: iconst_0
      //   354: invokestatic 137	mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase:access$0	(Lmobi/beyondpod/ui/views/impexp/SearchResultFragmentBase;Z)V
      //   357: aload_1
      //   358: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	359	0	this	SearchSuccessListener
      //   0	359	1	paramJSONArray	JSONArray
      //   104	173	2	i	int
      //   165	117	3	bool	boolean
      //   4	209	4	arrayOfObject	Object[]
      //   258	10	5	localFeedSearchResult	FeedSearchResult
      // Exception table:
      //   from	to	target	type
      //   6	50	285	java/lang/Exception
      //   50	96	285	java/lang/Exception
      //   105	139	285	java/lang/Exception
      //   139	164	285	java/lang/Exception
      //   166	171	285	java/lang/Exception
      //   171	201	285	java/lang/Exception
      //   201	232	285	java/lang/Exception
      //   249	273	285	java/lang/Exception
      //   6	50	340	finally
      //   50	96	340	finally
      //   105	139	340	finally
      //   139	164	340	finally
      //   166	171	340	finally
      //   171	201	340	finally
      //   201	232	340	finally
      //   249	273	340	finally
      //   286	323	340	finally
    }
    
    void setQuery(String paramString)
    {
      this._Query = paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/impexp/SearchResultFragmentBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */