package com.facebook.widget;

import com.facebook.model.GraphUser;

class FriendPickerFragment$ImmediateLoadingStrategy
        extends PickerFragment<GraphUser>.LoadingStrategy {
    private FriendPickerFragment$ImmediateLoadingStrategy(FriendPickerFragment paramFriendPickerFragment) {
        super(paramFriendPickerFragment);
    }

    private void followNextLink() {
        this.this$0.displayActivityCircle();
        this.loader.followNextLink();
    }

    protected boolean canSkipRoundTripIfCached() {
        return FriendPickerFragment.access$100(this.this$0).isCacheable();
    }

    protected void onLoadFinished(GraphObjectPagingLoader<GraphUser> paramGraphObjectPagingLoader, SimpleGraphObjectCursor<GraphUser> paramSimpleGraphObjectCursor) {
        super.onLoadFinished(paramGraphObjectPagingLoader, paramSimpleGraphObjectCursor);
        if ((paramSimpleGraphObjectCursor == null) || (paramGraphObjectPagingLoader.isLoading())) {
        }
        do {
            return;
            if (paramSimpleGraphObjectCursor.areMoreObjectsAvailable()) {
                followNextLink();
                return;
            }
            this.this$0.hideActivityCircle();
        } while (!paramSimpleGraphObjectCursor.isFromCache());
        if (paramSimpleGraphObjectCursor.getCount() == 0) {
        }
        for (long l = 2000L; ; l = 0L) {
            paramGraphObjectPagingLoader.refreshOriginalRequest(l);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/FriendPickerFragment$ImmediateLoadingStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */