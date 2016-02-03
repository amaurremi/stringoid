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
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
    private DataNeededListener dataNeededListener;
    private boolean displaySections;
    private Filter<T> filter;
    private Map<String, T> graphObjectsById = new HashMap();
    private Map<String, ArrayList<T>> graphObjectsBySection = new HashMap();
    private String groupByField;
    private final LayoutInflater inflater;
    private OnErrorListener onErrorListener;
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
            Object localObject = paramException;
            if (!(paramException instanceof FacebookException)) {
                localObject = new FacebookException(paramException);
            }
            this.onErrorListener.onError(this, (FacebookException) localObject);
        }
    }

    private static int compareGraphObjects(GraphObject paramGraphObject1, GraphObject paramGraphObject2, Collection<String> paramCollection, Collator paramCollator) {
        paramCollection = paramCollection.iterator();
        String str2;
        String str1;
        do {
            do {
                if (!paramCollection.hasNext()) {
                    return 0;
                }
                str2 = (String) paramCollection.next();
                str1 = (String) paramGraphObject1.getProperty(str2);
                str2 = (String) paramGraphObject2.getProperty(str2);
                if ((str1 == null) || (str2 == null)) {
                    break;
                }
                i = paramCollator.compare(str1, str2);
            } while (i == 0);
            return i;
        } while ((str1 == null) && (str2 == null));
        if (str1 == null) {
        }
        for (int i = -1; ; i = 1) {
            return i;
        }
    }

    private void downloadProfilePicture(final String paramString, URL paramURL, final ImageView paramImageView) {
        if (paramURL == null) {
        }
        for (; ; ) {
            return;
            if (paramImageView == null) {
            }
            for (int i = 1; (i != 0) || (!paramURL.equals(paramImageView.getTag())); i = 0) {
                if (i == 0) {
                    paramImageView.setTag(paramString);
                    paramImageView.setImageResource(getDefaultPicture());
                }
                paramURL = new ImageRequest.Builder(this.context.getApplicationContext(), paramURL).setCallerTag(this).setCallback(new ImageRequest.Callback() {
                    public void onCompleted(ImageResponse paramAnonymousImageResponse) {
                        GraphObjectAdapter.this.processImageResponse(paramAnonymousImageResponse, paramString, paramImageView);
                    }
                }).build();
                this.pendingRequests.put(paramString, paramURL);
                ImageDownloader.downloadAsync(paramURL);
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
            } while ((paramImageView == null) || (!paramString.equals(paramImageView.getTag())));
            paramString = paramImageResponse.getError();
            localBitmap = paramImageResponse.getBitmap();
        } while ((paramString != null) || (localBitmap == null));
        paramImageView.setImageBitmap(localBitmap);
        paramImageView.setTag(paramImageResponse.getRequest().getImageUrl());
    }

    private void rebuildSections() {
        boolean bool = true;
        this.sectionKeys = new ArrayList();
        this.graphObjectsBySection = new HashMap();
        this.graphObjectsById = new HashMap();
        this.displaySections = false;
        if ((this.cursor == null) || (this.cursor.getCount() == 0)) {
            return;
        }
        int i = 0;
        this.cursor.moveToFirst();
        final Object localObject1;
        int j;
        do {
            localObject1 = this.cursor.getGraphObject();
            if (filterIncludesItem((GraphObject) localObject1)) {
                break;
            }
            j = i;
            i = j;
        } while (this.cursor.moveToNext());
        Object localObject2;
        if (this.sortFields != null) {
            localObject1 = Collator.getInstance();
            localObject2 = this.graphObjectsBySection.values().iterator();
            label136:
            if (((Iterator) localObject2).hasNext()) {
            }
        } else {
            Collections.sort(this.sectionKeys, Collator.getInstance());
            if ((this.sectionKeys.size() <= 1) || (j <= 1)) {
                break label306;
            }
        }
        for (; ; ) {
            this.displaySections = bool;
            return;
            j = i + 1;
            localObject2 = getSectionKeyOfGraphObject((GraphObject) localObject1);
            if (!this.graphObjectsBySection.containsKey(localObject2)) {
                this.sectionKeys.add(localObject2);
                this.graphObjectsBySection.put(localObject2, new ArrayList());
            }
            ((List) this.graphObjectsBySection.get(localObject2)).add(localObject1);
            this.graphObjectsById.put(getIdOfGraphObject((GraphObject) localObject1), localObject1);
            break;
            Collections.sort((List) ((Iterator) localObject2).next(), new Comparator() {
                public int compare(GraphObject paramAnonymousGraphObject1, GraphObject paramAnonymousGraphObject2) {
                    return GraphObjectAdapter.compareGraphObjects(paramAnonymousGraphObject1, paramAnonymousGraphObject2, GraphObjectAdapter.this.sortFields, localObject1);
                }
            });
            break label136;
            label306:
            bool = false;
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

    protected View createGraphObjectView(T paramT, View paramView) {
        paramT = this.inflater.inflate(getGraphObjectRowLayoutId(paramT), null);
        paramView = (ViewStub) paramT.findViewById(R.id.com_facebook_picker_checkbox_stub);
        if (paramView != null) {
            if (getShowCheckbox()) {
                break label68;
            }
            paramView.setVisibility(8);
        }
        for (; ; ) {
            paramView = (ViewStub) paramT.findViewById(R.id.com_facebook_picker_profile_pic_stub);
            if (getShowPicture()) {
                break;
            }
            paramView.setVisibility(8);
            return paramT;
            label68:
            updateCheckboxState((CheckBox) paramView.inflate(), false);
        }
        ((ImageView) paramView.inflate()).setVisibility(0);
        return paramT;
    }

    boolean filterIncludesItem(T paramT) {
        return (this.filter == null) || (this.filter.includeItem(paramT));
    }

    public int getCount() {
        int i = 0;
        int j = 0;
        if (this.sectionKeys.size() == 0) {
            return j;
        }
        if (this.displaySections) {
            i = this.sectionKeys.size();
        }
        Iterator localIterator = this.graphObjectsBySection.values().iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                j = i;
                if (!shouldShowActivityCircleCell()) {
                    break;
                }
                return i + 1;
            }
            i += ((List) localIterator.next()).size();
        }
    }

    public GraphObjectCursor<T> getCursor() {
        return this.cursor;
    }

    public DataNeededListener getDataNeededListener() {
        return this.dataNeededListener;
    }

    protected int getDefaultPicture() {
        return R.drawable.com_facebook_profile_default_icon;
    }

    Filter<T> getFilter() {
        return this.filter;
    }

    protected int getGraphObjectRowLayoutId(T paramT) {
        return R.layout.com_facebook_picker_list_row;
    }

    protected View getGraphObjectView(T paramT, View paramView, ViewGroup paramViewGroup) {
        paramViewGroup = paramView;
        Object localObject = paramViewGroup;
        if (paramViewGroup == null) {
            localObject = createGraphObjectView(paramT, paramView);
        }
        populateGraphObjectView((View) localObject, paramT);
        return (View) localObject;
    }

    public List<T> getGraphObjectsById(Collection<String> paramCollection) {
        Object localObject1 = new HashSet();
        ((Set) localObject1).addAll(paramCollection);
        paramCollection = new ArrayList(((Set) localObject1).size());
        localObject1 = ((Set) localObject1).iterator();
        for (; ; ) {
            if (!((Iterator) localObject1).hasNext()) {
                return paramCollection;
            }
            Object localObject2 = (String) ((Iterator) localObject1).next();
            localObject2 = (GraphObject) this.graphObjectsById.get(localObject2);
            if (localObject2 != null) {
                paramCollection.add(localObject2);
            }
        }
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
        SectionAndItem localSectionAndItem = getSectionAndItem(paramInt);
        if (localSectionAndItem.getType() == GraphObjectAdapter.SectionAndItem.Type.GRAPH_OBJECT) {
            return localSectionAndItem.graphObject;
        }
        return null;
    }

    public long getItemId(int paramInt) {
        Object localObject = getSectionAndItem(paramInt);
        if ((localObject != null) && (((SectionAndItem) localObject).graphObject != null)) {
            localObject = getIdOfGraphObject(((SectionAndItem) localObject).graphObject);
            if (localObject != null) {
                return Long.parseLong((String) localObject);
            }
        }
        return 0L;
    }

    public int getItemViewType(int paramInt) {
        SectionAndItem localSectionAndItem = getSectionAndItem(paramInt);
        switch (localSectionAndItem.getType()) {
            default:
                throw new FacebookException("Unexpected type of section and item.");
            case GRAPH_OBJECT:
                return 0;
            case ACTIVITY_CIRCLE:
                return 1;
        }
        return 2;
    }

    public OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    String getPictureFieldSpecifier() {
        Object localObject = (ImageView) createGraphObjectView(null, null).findViewById(R.id.com_facebook_picker_image);
        if (localObject == null) {
            return null;
        }
        localObject = ((ImageView) localObject).getLayoutParams();
        return String.format("picture.height(%d).width(%d)", new Object[]{Integer.valueOf(((ViewGroup.LayoutParams) localObject).height), Integer.valueOf(((ViewGroup.LayoutParams) localObject).width)});
    }

    protected URL getPictureUrlOfGraphObject(T paramT) {
        Object localObject1 = null;
        Object localObject2 = paramT.getProperty("picture");
        if ((localObject2 instanceof String)) {
            paramT = (String) localObject2;
        }
        while (paramT != null) {
            try {
                paramT = new URL(paramT);
                return paramT;
            } catch (MalformedURLException paramT) {
            }
            paramT = (T) localObject1;
            if ((localObject2 instanceof JSONObject)) {
                localObject2 = ((ItemPicture) GraphObject.Factory.create((JSONObject) localObject2).cast(ItemPicture.class)).getData();
                paramT = (T) localObject1;
                if (localObject2 != null) {
                    paramT = ((ItemPictureData) localObject2).getUrl();
                }
            }
        }
        return null;
    }

    int getPosition(String paramString, T paramT) {
        int i = 0;
        int k = 0;
        Iterator localIterator = this.sectionKeys.iterator();
        int j;
        for (; ; ) {
            if (!localIterator.hasNext()) {
            }
            String str;
            for (; ; ) {
                if (k != 0) {
                    break label102;
                }
                return -1;
                str = (String) localIterator.next();
                j = i;
                if (this.displaySections) {
                    j = i + 1;
                }
                if (!str.equals(paramString)) {
                    break;
                }
                k = 1;
                i = j;
            }
            i = j + ((ArrayList) this.graphObjectsBySection.get(str)).size();
        }
        label102:
        if (paramT == null) {
            if (this.displaySections) {
            }
            for (j = 1; ; j = 0) {
                return i - j;
            }
        }
        paramString = ((ArrayList) this.graphObjectsBySection.get(paramString)).iterator();
        for (; ; ) {
            if (!paramString.hasNext()) {
                return -1;
            }
            if (GraphObject.Factory.hasSameId((GraphObject) paramString.next(), paramT)) {
                return i;
            }
            i += 1;
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

    SectionAndItem<T> getSectionAndItem(int paramInt) {
        if (this.sectionKeys.size() == 0) {
            return null;
        }
        Object localObject4 = null;
        Object localObject3 = null;
        Object localObject1;
        Object localObject2;
        if (!this.displaySections) {
            localObject1 = (String) this.sectionKeys.get(0);
            localObject2 = (List) this.graphObjectsBySection.get(localObject1);
            if ((paramInt >= 0) && (paramInt < ((List) localObject2).size())) {
                localObject2 = (GraphObject) ((ArrayList) this.graphObjectsBySection.get(localObject1)).get(paramInt);
                if (localObject1 != null) {
                    return new SectionAndItem((String) localObject1, (GraphObject) localObject2);
                }
            } else {
                assert ((this.dataNeededListener != null) && (this.cursor.areMoreObjectsAvailable()));
                return new SectionAndItem(null, null);
            }
        } else {
            Iterator localIterator = this.sectionKeys.iterator();
            for (; ; ) {
                localObject2 = localObject3;
                localObject1 = localObject4;
                if (!localIterator.hasNext()) {
                    break;
                }
                localObject1 = (String) localIterator.next();
                int i = paramInt - 1;
                if (paramInt == 0) {
                    localObject2 = localObject3;
                    break;
                }
                localObject2 = (List) this.graphObjectsBySection.get(localObject1);
                if (i < ((List) localObject2).size()) {
                    localObject2 = (GraphObject) ((List) localObject2).get(i);
                    break;
                }
                paramInt = i - ((List) localObject2).size();
            }
        }
        throw new IndexOutOfBoundsException("position");
    }

    public int getSectionForPosition(int paramInt) {
        int i = 0;
        SectionAndItem localSectionAndItem = getSectionAndItem(paramInt);
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
        paramViewGroup = (TextView) paramView;
        paramView = paramViewGroup;
        if (paramViewGroup == null) {
            paramView = (TextView) this.inflater.inflate(R.layout.com_facebook_picker_list_section_header, null);
        }
        paramView.setText(paramString);
        return paramView;
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
        SectionAndItem localSectionAndItem = getSectionAndItem(paramInt);
        switch (localSectionAndItem.getType()) {
            default:
                throw new FacebookException("Unexpected type of section and item.");
            case GRAPH_OBJECT:
                return getSectionHeaderView(localSectionAndItem.sectionKey, paramView, paramViewGroup);
            case ACTIVITY_CIRCLE:
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
                paramT = getPictureUrlOfGraphObject(paramT);
                if (paramT != null) {
                    paramView = (ImageView) paramView.findViewById(R.id.com_facebook_picker_image);
                    if (!this.prefetchedPictureCache.containsKey(str)) {
                        break;
                    }
                    paramT = (ImageResponse) this.prefetchedPictureCache.get(str);
                    paramView.setImageBitmap(paramT.getBitmap());
                    paramView.setTag(paramT.getRequest().getImageUrl());
                }
            }
            return;
            label191:
            localTextView.setVisibility(8);
        }
        downloadProfilePicture(str, paramT, paramView);
    }

    public void prioritizeViewRange(int paramInt1, int paramInt2, int paramInt3) {
        if (paramInt2 < paramInt1) {
            return;
        }
        int i = paramInt2;
        label9:
        int j;
        Object localObject1;
        if (i < 0) {
            i = Math.max(0, paramInt1 - paramInt3);
            j = Math.min(paramInt2 + paramInt3, getCount() - 1);
            localObject1 = new ArrayList();
            paramInt3 = i;
            label49:
            if (paramInt3 < paramInt1) {
                break label209;
            }
            paramInt1 = paramInt2 + 1;
        }
        for (; ; ) {
            if (paramInt1 > j) {
                localObject1 = ((ArrayList) localObject1).iterator();
                while (((Iterator) localObject1).hasNext()) {
                    Object localObject3 = (GraphObject) ((Iterator) localObject1).next();
                    localObject2 = getPictureUrlOfGraphObject((GraphObject) localObject3);
                    localObject3 = getIdOfGraphObject((GraphObject) localObject3);
                    boolean bool = this.prefetchedProfilePictureIds.remove(localObject3);
                    this.prefetchedProfilePictureIds.add(localObject3);
                    if (!bool) {
                        downloadProfilePicture((String) localObject3, (URL) localObject2, null);
                    }
                }
                break;
                localObject1 = getSectionAndItem(i);
                if (((SectionAndItem) localObject1).graphObject != null) {
                    localObject1 = getIdOfGraphObject(((SectionAndItem) localObject1).graphObject);
                    localObject1 = (ImageRequest) this.pendingRequests.get(localObject1);
                    if (localObject1 != null) {
                        ImageDownloader.prioritizeRequest((ImageRequest) localObject1);
                    }
                }
                i -= 1;
                break label9;
                label209:
                localObject2 = getSectionAndItem(paramInt3);
                if (((SectionAndItem) localObject2).graphObject != null) {
                    ((ArrayList) localObject1).add(((SectionAndItem) localObject2).graphObject);
                }
                paramInt3 += 1;
                break label49;
            }
            Object localObject2 = getSectionAndItem(paramInt1);
            if (((SectionAndItem) localObject2).graphObject != null) {
                ((ArrayList) localObject1).add(((SectionAndItem) localObject2).graphObject);
            }
            paramInt1 += 1;
        }
    }

    public void rebuildAndNotify() {
        rebuildSections();
        notifyDataSetChanged();
    }

    public void setDataNeededListener(DataNeededListener paramDataNeededListener) {
        this.dataNeededListener = paramDataNeededListener;
    }

    void setFilter(Filter<T> paramFilter) {
        this.filter = paramFilter;
    }

    public void setGroupByField(String paramString) {
        this.groupByField = paramString;
    }

    public void setOnErrorListener(OnErrorListener paramOnErrorListener) {
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

    public static abstract interface DataNeededListener {
        public abstract void onDataNeeded();
    }

    static abstract interface Filter<T> {
        public abstract boolean includeItem(T paramT);
    }

    private static abstract interface ItemPicture
            extends GraphObject {
        public abstract GraphObjectAdapter.ItemPictureData getData();
    }

    private static abstract interface ItemPictureData
            extends GraphObject {
        public abstract String getUrl();
    }

    public static abstract interface OnErrorListener {
        public abstract void onError(GraphObjectAdapter<?> paramGraphObjectAdapter, FacebookException paramFacebookException);
    }

    public static class SectionAndItem<T extends GraphObject> {
        public T graphObject;
        public String sectionKey;

        public SectionAndItem(String paramString, T paramT) {
            this.sectionKey = paramString;
            this.graphObject = paramT;
        }

        public Type getType() {
            if (this.sectionKey == null) {
                return Type.ACTIVITY_CIRCLE;
            }
            if (this.graphObject == null) {
                return Type.SECTION_HEADER;
            }
            return Type.GRAPH_OBJECT;
        }

        public static enum Type {
            GRAPH_OBJECT, SECTION_HEADER, ACTIVITY_CIRCLE;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/widget/GraphObjectAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */