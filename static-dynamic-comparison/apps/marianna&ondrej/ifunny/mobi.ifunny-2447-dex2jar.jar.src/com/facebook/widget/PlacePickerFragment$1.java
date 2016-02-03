package com.facebook.widget;

import android.content.Context;
import com.facebook.android.R.drawable;
import com.facebook.android.R.layout;
import com.facebook.android.R.string;
import com.facebook.model.GraphPlace;

class PlacePickerFragment$1
        extends PickerFragment<GraphPlace>.PickerFragmentAdapter<GraphPlace> {
    PlacePickerFragment$1(PlacePickerFragment paramPlacePickerFragment, Context paramContext) {
        super(paramPlacePickerFragment, paramContext);
    }

    protected int getDefaultPicture() {
        return R.drawable.com_facebook_place_default_icon;
    }

    protected int getGraphObjectRowLayoutId(GraphPlace paramGraphPlace) {
        return R.layout.com_facebook_placepickerfragment_list_row;
    }

    protected CharSequence getSubTitleOfGraphObject(GraphPlace paramGraphPlace) {
        String str = paramGraphPlace.getCategory();
        paramGraphPlace = (Integer) paramGraphPlace.getProperty("were_here_count");
        if ((str != null) && (paramGraphPlace != null)) {
            return this.this$0.getString(R.string.com_facebook_placepicker_subtitle_format, new Object[]{str, paramGraphPlace});
        }
        if ((str == null) && (paramGraphPlace != null)) {
            return this.this$0.getString(R.string.com_facebook_placepicker_subtitle_were_here_only_format, new Object[]{paramGraphPlace});
        }
        if ((str != null) && (paramGraphPlace == null)) {
            return this.this$0.getString(R.string.com_facebook_placepicker_subtitle_catetory_only_format, new Object[]{str});
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/PlacePickerFragment$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */