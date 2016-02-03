package com.quoord.tapatalkpro.adapter.forum.conversation;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.quoord.tapatalkpro.activity.forum.conversation.ConversationOuterFragment;

import java.io.Serializable;

public class ConvHeaderView
        implements Serializable {
    public static View getHeaderView(ConversationOuterFragment paramConversationOuterFragment, int paramInt) {
        LinearLayout localLinearLayout = (LinearLayout) paramConversationOuterFragment.getActivity().getLayoutInflater().inflate(2130903124, null);
        paramConversationOuterFragment = ConvPaginationView.get(paramConversationOuterFragment, paramInt);
        localLinearLayout.removeViewAt(0);
        localLinearLayout.addView(paramConversationOuterFragment, 0);
        return localLinearLayout;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/conversation/ConvHeaderView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */