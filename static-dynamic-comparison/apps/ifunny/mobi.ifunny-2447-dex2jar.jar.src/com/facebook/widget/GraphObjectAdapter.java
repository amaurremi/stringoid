package com.facebook.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SectionIndexer;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.facebook.FacebookException;
import com.facebook.android.R.drawable;
import com.facebook.android.R.id;
import com.facebook.android.R.layout;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageRequest.Builder;
import com.facebook.internal.ImageResponse;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;

class GraphObjectAdapter<T extends GraphObject>
        extends BaseAdapter
        implements SectionIndexer {
    private static final int ACTIVITY_CIRCLE_VIEW_TYPE = 2;
    private static final int DISPLAY_SECTIONS_THRESHOLD = 1;
    private static final int GRAPH_OBJECT_VIEW_TYPE = 1;
    private static final int HEADER_VIEW_TYPE = 0;
    private static final String ID = "id";
    private static final int MAX_PREFETCHED_PICTURES = 20;
    private static final String NAME = "name";
    private static final String PICTURE = "picture";
    private Context context;
    private GraphObjectCursor<T> cursor;
    private GraphObjectAdapter.DataNeededListener dataNeededListener;
    private boolean displaySections;
    private GraphObjectAdapter.Filter<T> filter;
    private Map<String, T> graphObjectsById = new HashMap();
    private Map<String, ArrayList<T>> graphObjectsBySection = new HashMap();
    private String groupByField;
    private final LayoutInflater inflater;
    private GraphObjectAdapter.OnErrorListener onErrorListener;
    private final Map<String, ImageRequest> pendingRequests = new HashMap();
    private Map<String, ImageResponse> prefetchedPictureCache = new HashMap();
    private ArrayList<String> prefetchedProfilePictureIds = new ArrayList();
    private List<String> sectionKeys = new ArrayList();
    private boolean showCheckbox;
    private boolean showPicture;
    private List<String> sortFields;

    static {
        if (!GraphObjectAdapter.class.desiredAssertionStatus()) {
        }
        for (boolean bool = true; ; bool = false) {
            $assertionsDisabled = bool;
            return;
        }
    }

    public GraphObjectAdapter(Context paramContext) {
        this.context = paramContext;
        this.inflater = LayoutInflater.from(paramContext);
    }

    private void callOnErrorListener(Exception paramException) {
        if (this.onErrorListener != null) {
            if ((paramException instanceof FacebookException)) {
                break label38;
            }
            paramException = new FacebookException(paramException);
        }
        label38:
        for (; ; ) {
            this.onErrorListener.onError(this, (FacebookException) paramException);
            return;
        }
    }

    private static int compareGraphObjects(GraphObject paramGraphObject1, GraphObject paramGraphObject2, Collection<String> paramCollection, Collator paramCollator) {
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
            String str2 = (String) paramCollection.next();
            String str1 = (String) paramGraphObject1.getProperty(str2);
            str2 = (String) paramGraphObject2.getProperty(str2);
            if ((str1 != null) && (str2 != null)) {
                int i = paramCollator.compare(str1, str2);
                if (i != 0) {
                    return i;
                }
            } else if ((str1 != null) || (str2 != null)) {
                if (str1 == null) {
                    return -1;
                }
                return 1;
            }
        }
        return 0;
    }

    private void downloadProfilePicture(String paramString, URI paramURI, ImageView paramImageView) {
        if (paramURI == null) {
        }
        for (; ; ) {
            return;
            if (paramImageView == null) {
            }
            for (int i = 1; (i != 0) || (!paramURI.equals(paramImageView.getTag())); i = 0) {
                if (i == 0) {
                    paramImageView.setTag(paramString);
                    paramImageView.setImageResource(getDefaultPicture());
                }
                paramURI = new ImageRequest.Builder(this.context.getApplicationContext(), paramURI).setCallerTag(this).setCallback(new GraphObjectAdapter
                .2 (this, paramString, paramImageView)).build();
                this.pendingRequests.put(paramString, paramURI);
                ImageDownloader.downloadAsync(paramURI);
                return;
            }
        }
    }

    private View getActivityCircleView(View paramView, ViewGroup paramViewGroup) {
        paramViewGroup = paramView;
        if (paramView == null) {
            paramViewGroup = this.inflater.inflate(R.layout.com_facebook_picker_activity_circle_row, null);
        }
        ((ProgressBar) paramViewGroup.findViewById(R.id.com_facebook_picker_row_activity_circle)).setVisibility(0);
        return paramViewGroup;
    }

    private void processImageResponse(ImageResponse paramImageResponse, String paramString, ImageView paramImageView) {
        this.pendingRequests.remove(paramString);
        if (paramImageResponse.getError() != null) {
            callOnErrorListener(paramImageResponse.getError());
        }
        if (paramImageView == null) {
            if (paramImageResponse.getBitmap() != null) {
                if (this.prefetchedPictureCache.size() >= 20) {
                    paramImageView = (String) this.prefetchedProfilePictureIds.remove(0);
                    this.prefetchedPictureCache.remove(paramImageView);
                }
            }
        }
        Bitmap localBitmap;
        do {
            this.prefetchedPictureCache.put(paramString, paramImageResponse);
            do {
                return;
            } while (!paramString.equals(paramImageView.getTag()));
            paramString = paramImageResponse.getError();
            localBitmap = paramImageResponse.getBitmap();
        } while ((paramString != null) || (localBitmap == null));
        paramImageView.setImageBitmap(localBitmap);
        paramImageView.setTag(paramImageResponse.getRequest().getImageUri());
    }

    private void rebuildSections() {
        boolean bool2 = false;
        this.sectionKeys = new ArrayList();
        this.graphObjectsBySection = new HashMap();
        this.graphObjectsById = new HashMap();
        this.displaySections = false;
        if ((this.cursor == null) || (this.cursor.getCount() == 0)) {
            return;
        }
        this.cursor.moveToFirst();
        int i = 0;
        for (; ; ) {
            Object localObject1 = this.cursor.getGraphObject();
            if (!filterIncludesItem((GraphObject) localObject1)) {
            }
            while (!this.cursor.moveToNext()) {
                if (this.sortFields != null) {
                    localObject1 = Collator.getInstance();
                    Object localObject2 = this.graphObjectsBySection.values().iterator();
                    for (; ; ) {
                        if (((Iterator) localObject2).hasNext()) {
                            Collections.sort((List) ((Iterator) localObject2).next(), new GraphObjectAdapter .1
                            (this, (Collator) localObject1));
                            continue;
                            i += 1;
                            localObject2 = getSectionKeyOfGraphObject((GraphObject) localObject1);
                            if (!this.graphObjectsBySection.containsKey(localObject2)) {
                                this.sectionKeys.add(localObject2);
                                this.graphObjectsBySection.put(localObject2, new ArrayList());
                            }
                            ((List) this.graphObjectsBySection.get(localObject2)).add(localObject1);
                            this.graphObjectsById.put(getIdOfGraphObject((GraphObject) localObject1), localObject1);
                            break;
                        }
                    }
                }
                Collections.sort(this.sectionKeys, Collator.getInstance());
                boolean bool1 = bool2;
                if (this.sectionKeys.size() > 1) {
                    bool1 = bool2;
                    if (i > 1) {
                        bool1 = true;
                    }
                }
                this.displaySections = bool1;
                return;
            }
        }
    }

    private boolean shouldShowActivityCircleCell() {
        return (this.cursor != null) && (this.cursor.areMoreObjectsAvailable()) && (this.dataNeededListener != null) && (!isEmpty());
    }

    public boolean areAllItemsEnabled() {
        return this.displaySections;
    }

    public boolean changeCursor(GraphObjectCursor<T> paramGraphObjectCursor) {
        if (this.cursor == paramGraphObjectCursor) {
            return false;
        }
        if (this.cursor != null) {
            this.cursor.close();
        }
        this.cursor = paramGraphObjectCursor;
        rebuildAndNotify();
        return true;
    }

    protected View createGraphObjectView(T paramT) {
        paramT = this.inflater.inflate(getGraphObjectRowLayoutId(paramT), null);
        ViewStub localViewStub = (ViewStub) paramT.findViewById(R.id.com_facebook_picker_checkbox_stub);
        if (localViewStub != null) {
            if (getShowCheckbox()) {
                break label68;
            }
            localViewStub.setVisibility(8);
        }
        for (; ; ) {
            localViewStub = (ViewStub) paramT.findViewById(R.id.com_facebook_picker_profile_pic_stub);
            if (getShowPicture()) {
                break;
            }
            localViewStub.setVisibility(8);
            return paramT;
            label68:
            updateCheckboxState((CheckBox) localViewStub.inflate(), false);
        }
        ((ImageView) localViewStub.inflate()).setVisibility(0);
        return paramT;
    }

    boolean filterIncludesItem(T paramT) {
        return (this.filter == null) || (this.filter.includeItem(paramT));
    }

    public int getCount() {
        int i = 0;
        if (this.sectionKeys.size() == 0) {
            return 0;
        }
        if (this.displaySections) {
            i = this.sectionKeys.size();
        }
        Iterator localIterator = this.graphObjectsBySection.values().iterator();
        while (localIterator.hasNext()) {
            i = ((List) localIterator.next()).size() + i;
        }
        int j = i;
        if (shouldShowActivityCircleCell()) {
            j = i + 1;
        }
        return j;
    }

    public GraphObjectCursor<T> getCursor() {
        return this.cursor;
    }

    public GraphObjectAdapter.DataNeededListener getDataNeededListener() {
        return this.dataNeededListener;
    }

    protected int getDefaultPicture() {
        return R.drawable.com_facebook_profile_default_icon;
    }

    GraphObjectAdapter.Filter<T> getFilter() {
        return this.filter;
    }

    protected int getGraphObjectRowLayoutId(T paramT) {
        return R.layout.com_facebook_picker_list_row;
    }

    protected View getGraphObjectView(T paramT, View paramView, ViewGroup paramViewGroup) {
        paramViewGroup = paramView;
        if (paramView == null) {
            paramViewGroup = createGraphObjectView(paramT);
        }
        populateGraphObjectView(paramViewGroup, paramT);
        return paramViewGroup;
    }

    public List<T> getGraphObjectsById(Collection<String> paramCollection) {
        Object localObject1 = new HashSet();
        ((Set) localObject1).addAll(paramCollection);
        paramCollection = new ArrayList(((Set) localObject1).size());
        localObject1 = ((Set) localObject1).iterator();
        while (((Iterator) localObject1).hasNext()) {
            Object localObject2 = (String) ((Iterator) localObject1).next();
            localObject2 = (GraphObject) this.graphObjectsById.get(localObject2);
            if (localObject2 != null) {
                paramCollection.add(localObject2);
            }
        }
        return paramCollection;
    }

    public String getGroupByField() {
        return this.groupByField;
    }

    String getIdOfGraphObject(T paramT) {
        if (paramT.asMap().containsKey("id")) {
            paramT = paramT.getProperty("id");
            if ((paramT instanceof String)) {
                return (String) paramT;
            }
        }
        throw new FacebookException("Received an object without an ID.");
    }

    public Object getItem(int paramInt) {
        GraphObjectAdapter.SectionAndItem localSectionAndItem = getSectionAndItem(paramInt);
        if (localSectionAndItem.getType() == GraphObjectAdapter.SectionAndItem.Type.GRAPH_OBJECT) {
            return localSectionAndItem.graphObject;
        }
        return null;
    }

    public long getItemId(int paramInt) {
        Object localObject = getSectionAndItem(paramInt);
        if ((localObject != null) && (((GraphObjectAdapter.SectionAndItem) localObject).graphObject != null)) {
            localObject = getIdOfGraphObject(((GraphObjectAdapter.SectionAndItem) localObject).graphObject);
            if (localObject != null) {
                try {
                    long l = Long.parseLong((String) localObject);
                    return l;
                } catch (NumberFormatException localNumberFormatException) {
                }
            }
        }
        return 0L;
    }

    public int getItemViewType(int paramInt) {
        GraphObjectAdapter.SectionAndItem localSectionAndItem = getSectionAndItem(paramInt);
        switch (GraphObjectAdapter
        .3.$SwitchMap$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type[localSectionAndItem.getType().ordinal()])
        {
            default:
                throw new FacebookException("Unexpected type of section and item.");
            case 1:
                return 0;
            case 2:
                return 1;
        }
        return 2;
    }

    public GraphObjectAdapter.OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    String getPictureFieldSpecifier() {
        Object localObject = (ImageView) createGraphObjectView(null).findViewById(R.id.com_facebook_picker_image);
        if (localObject == null) {
            return null;
        }
        localObject = ((ImageView) localObject).getLayoutParams();
        return String.format(Locale.US, "picture.height(%d).width(%d)", new Object[]{Integer.valueOf(((ViewGroup.LayoutParams) localObject).height), Integer.valueOf(((ViewGroup.LayoutParams) localObject).width)});
    }

    protected URI getPictureUriOfGraphObject(T paramT) {
        paramT = paramT.getProperty("picture");
        if ((paramT instanceof String)) {
            paramT = (String) paramT;
        }
        for (; ; ) {
            if (paramT != null) {
                try {
                    paramT = new URI(paramT);
                    return paramT;
                } catch (URISyntaxException paramT) {
                }
                if (!(paramT instanceof JSONObject)) {
                    break label84;
                }
                paramT = ((GraphObjectAdapter.ItemPicture) GraphObject.Factory.create((JSONObject) paramT).cast(GraphObjectAdapter.ItemPicture.class)).getData();
                if (paramT == null) {
                    break label84;
                }
                paramT = paramT.getUrl();
                continue;
            }
            return null;
            label84:
            paramT = null;
        }
    }

    int getPosition(String paramString, T paramT) {
        int k = 0;
        Iterator localIterator = this.sectionKeys.iterator();
        int i = 0;
        String str;
        int m;
        if (localIterator.hasNext()) {
            str = (String) localIterator.next();
            j = i;
            if (this.displaySections) {
                j = i + 1;
            }
            if (str.equals(paramString)) {
                m = 1;
                i = j;
            }
        }
        for (int j = m; ; j = 0) {
            if (j == 0) {
                j = -1;
                return j;
                i = ((ArrayList) this.graphObjectsBySection.get(str)).size() + j;
                break;
            }
            if (paramT == null) {
                j = k;
                if (this.displaySections) {
                    j = 1;
                }
                return i - j;
            }
            paramString = ((ArrayList) this.graphObjectsBySection.get(paramString)).iterator();
            for (; ; ) {
                if (!paramString.hasNext()) {
                    break label182;
                }
                j = i;
                if (GraphObject.Factory.hasSameId((GraphObject) paramString.next(), paramT)) {
                    break;
                }
                i += 1;
            }
            label182:
            return -1;
        }
    }

    public int getPositionForSection(int paramInt) {
        int j = 0;
        int i = j;
        if (this.displaySections) {
            paramInt = Math.max(0, Math.min(paramInt, this.sectionKeys.size() - 1));
            i = j;
            if (paramInt < this.sectionKeys.size()) {
                i = getPosition((String) this.sectionKeys.get(paramInt), null);
            }
        }
        return i;
    }

    GraphObjectAdapter.SectionAndItem<T> getSectionAndItem(int paramInt) {
        Object localObject2 = null;
        if (this.sectionKeys.size() == 0) {
            return null;
        }
        Object localObject1;
        if (!this.displaySections) {
            localObject2 = (String) this.sectionKeys.get(0);
            localObject1 = (List) this.graphObjectsBySection.get(localObject2);
            if ((paramInt >= 0) && (paramInt < ((List) localObject1).size())) {
                localObject1 = (GraphObject) ((ArrayList) this.graphObjectsBySection.get(localObject2)).get(paramInt);
            }
        }
        for (; ; ) {
            if (localObject2 != null) {
                return new GraphObjectAdapter.SectionAndItem((String) localObject2, (GraphObject) localObject1);
                assert ((this.dataNeededListener != null) && (this.cursor.areMoreObjectsAvailable()));
                return new GraphObjectAdapter.SectionAndItem(null, null);
                Object localObject3 = this.sectionKeys.iterator();
                for (; ; ) {
                    if (!((Iterator) localObject3).hasNext()) {
                        break label273;
                    }
                    localObject1 = (String) ((Iterator) localObject3).next();
                    int i = paramInt - 1;
                    if (paramInt == 0) {
                        localObject3 = null;
                        localObject2 = localObject1;
                        localObject1 = localObject3;
                        break;
                    }
                    List localList = (List) this.graphObjectsBySection.get(localObject1);
                    if (i < localList.size()) {
                        localObject3 = (GraphObject) localList.get(i);
                        localObject2 = localObject1;
                        localObject1 = localObject3;
                        break;
                    }
                    paramInt = i - localList.size();
                }
            }
            throw new IndexOutOfBoundsException("position");
            label273:
            localObject1 = null;
        }
    }

    public int getSectionForPosition(int paramInt) {
        int i = 0;
        GraphObjectAdapter.SectionAndItem localSectionAndItem = getSectionAndItem(paramInt);
        paramInt = i;
        if (localSectionAndItem != null) {
            paramInt = i;
            if (localSectionAndItem.getType() != GraphObjectAdapter.SectionAndItem.Type.ACTIVITY_CIRCLE) {
                paramInt = Math.max(0, Math.min(this.sectionKeys.indexOf(localSectionAndItem.sectionKey), this.sectionKeys.size() - 1));
            }
        }
        return paramInt;
    }

    protected View getSectionHeaderView(String paramString, View paramView, ViewGroup paramViewGroup) {
        paramView = (TextView) paramView;
        if (paramView == null) {
            paramView = (TextView) this.inflater.inflate(R.layout.com_facebook_picker_list_section_header, null);
        }
        for (; ; ) {
            paramView.setText(paramString);
            return paramView;
        }
    }

    protected String getSectionKeyOfGraphObject(T paramT) {
        Object localObject = null;
        if (this.groupByField != null) {
            paramT = (String) paramT.getProperty(this.groupByField);
            localObject = paramT;
            if (paramT != null) {
                localObject = paramT;
                if (paramT.length() > 0) {
                    localObject = paramT.substring(0, 1).toUpperCase();
                }
            }
        }
        if (localObject != null) {
            return (String) localObject;
        }
        return "";
    }

    public Object[] getSections() {
        if (this.displaySections) {
            return this.sectionKeys.toArray();
        }
        return new Object[0];
    }

    public boolean getShowCheckbox() {
        return this.showCheckbox;
    }

    public boolean getShowPicture() {
        return this.showPicture;
    }

    public List<String> getSortFields() {
        return this.sortFields;
    }

    protected CharSequence getSubTitleOfGraphObject(T paramT) {
        return null;
    }

    protected CharSequence getTitleOfGraphObject(T paramT) {
        return (String) paramT.getProperty("name");
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        GraphObjectAdapter.SectionAndItem localSectionAndItem = getSectionAndItem(paramInt);
        switch (GraphObjectAdapter
        .3.$SwitchMap$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type[localSectionAndItem.getType().ordinal()])
        {
            default:
                throw new FacebookException("Unexpected type of section and item.");
            case 1:
                return getSectionHeaderView(localSectionAndItem.sectionKey, paramView, paramViewGroup);
            case 2:
                return getGraphObjectView(localSectionAndItem.graphObject, paramView, paramViewGroup);
        }
        assert ((this.cursor.areMoreObjectsAvailable()) && (this.dataNeededListener != null));
        this.dataNeededListener.onDataNeeded();
        return getActivityCircleView(paramView, paramViewGroup);
    }

    public int getViewTypeCount() {
        return 3;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isEmpty() {
        return this.sectionKeys.size() == 0;
    }

    public boolean isEnabled(int paramInt) {
        return getSectionAndItem(paramInt).getType() == GraphObjectAdapter.SectionAndItem.Type.GRAPH_OBJECT;
    }

    boolean isGraphObjectSelected(String paramString) {
        return false;
    }

    protected void populateGraphObjectView(View paramView, T paramT) {
        String str = getIdOfGraphObject(paramT);
        paramView.setTag(str);
        CharSequence localCharSequence = getTitleOfGraphObject(paramT);
        TextView localTextView = (TextView) paramView.findViewById(R.id.com_facebook_picker_title);
        if (localTextView != null) {
            localTextView.setText(localCharSequence, TextView.BufferType.SPANNABLE);
        }
        localCharSequence = getSubTitleOfGraphObject(paramT);
        localTextView = (TextView) paramView.findViewById(R.id.picker_subtitle);
        if (localTextView != null) {
            if (localCharSequence == null) {
                break label191;
            }
            localTextView.setText(localCharSequence, TextView.BufferType.SPANNABLE);
            localTextView.setVisibility(0);
        }
        for (; ; ) {
            if (getShowCheckbox()) {
                updateCheckboxState((CheckBox) paramView.findViewById(R.id.com_facebook_picker_checkbox), isGraphObjectSelected(str));
            }
            if (getShowPicture()) {
                paramT = getPictureUriOfGraphObject(paramT);
                if (paramT != null) {
                    paramView = (ImageView) paramView.findViewById(R.id.com_facebook_picker_image);
                    if (!this.prefetchedPictureCache.containsKey(str)) {
                        break;
                    }
                    paramT = (ImageResponse) this.prefetchedPictureCache.get(str);
                    paramView.setImageBitmap(paramT.getBitmap());
                    paramView.setTag(paramT.getRequest().getImageUri());
                }
            }
            return;
            label191:
            localTextView.setVisibility(8);
        }
        downloadProfilePicture(str, paramT, paramView);
    }

    public void prioritizeViewRange(int paramInt1, int paramInt2, int paramInt3) {
        if ((paramInt2 < paramInt1) || (this.sectionKeys.size() == 0)) {
        }
        for (; ; ) {
            return;
            int i = paramInt2;
            while (i >= 0) {
                localObject1 = getSectionAndItem(i);
                if (((GraphObjectAdapter.SectionAndItem) localObject1).graphObject != null) {
                    localObject1 = getIdOfGraphObject(((GraphObjectAdapter.SectionAndItem) localObject1).graphObject);
                    localObject1 = (ImageRequest) this.pendingRequests.get(localObject1);
                    if (localObject1 != null) {
                        ImageDownloader.prioritizeRequest((ImageRequest) localObject1);
                    }
                }
                i -= 1;
            }
            i = Math.max(0, paramInt1 - paramInt3);
            int j = Math.min(paramInt2 + paramInt3, getCount() - 1);
            Object localObject1 = new ArrayList();
            paramInt3 = i;
            Object localObject2;
            while (paramInt3 < paramInt1) {
                localObject2 = getSectionAndItem(paramInt3);
                if (((GraphObjectAdapter.SectionAndItem) localObject2).graphObject != null) {
                    ((ArrayList) localObject1).add(((GraphObjectAdapter.SectionAndItem) localObject2).graphObject);
                }
                paramInt3 += 1;
            }
            paramInt1 = paramInt2 + 1;
            while (paramInt1 <= j) {
                localObject2 = getSectionAndItem(paramInt1);
                if (((GraphObjectAdapter.SectionAndItem) localObject2).graphObject != null) {
                    ((ArrayList) localObject1).add(((GraphObjectAdapter.SectionAndItem) localObject2).graphObject);
                }
                paramInt1 += 1;
            }
            localObject1 = ((ArrayList) localObject1).iterator();
            while (((Iterator) localObject1).hasNext()) {
                Object localObject3 = (GraphObject) ((Iterator) localObject1).next();
                localObject2 = getPictureUriOfGraphObject((GraphObject) localObject3);
                localObject3 = getIdOfGraphObject((GraphObject) localObject3);
                boolean bool = this.prefetchedProfilePictureIds.remove(localObject3);
                this.prefetchedProfilePictureIds.add(localObject3);
                if (!bool) {
                    downloadProfilePicture((String) localObject3, (URI) localObject2, null);
                }
            }
        }
    }

    public void rebuildAndNotify() {
        rebuildSections();
        notifyDataSetChanged();
    }

    public void setDataNeededListener(GraphObjectAdapter.DataNeededListener paramDataNeededListener) {
        this.dataNeededListener = paramDataNeededListener;
    }

    void setFilter(GraphObjectAdapter.Filter<T> paramFilter) {
        this.filter = paramFilter;
    }

    public void setGroupByField(String paramString) {
        this.groupByField = paramString;
    }

    public void setOnErrorListener(GraphObjectAdapter.OnErrorListener paramOnErrorListener) {
        this.onErrorListener = paramOnErrorListener;
    }

    public void setShowCheckbox(boolean paramBoolean) {
        this.showCheckbox = paramBoolean;
    }

    public void setShowPicture(boolean paramBoolean) {
        this.showPicture = paramBoolean;
    }

    public void setSortFields(List<String> paramList) {
        this.sortFields = paramList;
    }

    void updateCheckboxState(CheckBox paramCheckBox, boolean paramBoolean) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/GraphObjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */