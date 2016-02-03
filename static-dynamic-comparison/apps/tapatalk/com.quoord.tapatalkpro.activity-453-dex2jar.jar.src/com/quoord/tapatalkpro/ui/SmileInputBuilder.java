package com.quoord.tapatalkpro.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.quoord.tapatalkpro.util.SmileMap;

import java.util.ArrayList;

public class SmileInputBuilder {
    private Activity _activity;
    private SmileAdapter _adapter;
    private int _iconSize = 80;
    private SmileMap _smileMap;
    private GridView _view;

    public SmileInputBuilder(Activity paramActivity) {
        this._activity = paramActivity;
        this._smileMap = new SmileMap();
    }

    public GridView create() {
        return this._view;
    }

    public void setForumType(int paramInt) {
        this._view = new GridView(this._activity);
        this._smileMap.setCurrentForum(paramInt);
        this._adapter = new SmileAdapter(this._smileMap.getKeys(), this._smileMap.getValues());
        this._view.setNumColumns(6);
        this._view.setAdapter(this._adapter);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener) {
        this._view.setOnItemClickListener(paramOnItemClickListener);
    }

    private class SmileAdapter
            extends BaseAdapter {
        private String[] _keys;
        private String[] _values;
        private ArrayList<ImageView> _views;

        public SmileAdapter(String[] paramArrayOfString1, String[] paramArrayOfString2) {
            this._keys = paramArrayOfString1;
            this._values = paramArrayOfString2;
            this._views = new ArrayList(this._values.length);
            int i = 0;
            for (; ; ) {
                if (i >= this._keys.length) {
                    return;
                }
                int j = SmileInputBuilder.this._activity.getResources().getIdentifier(SmileInputBuilder.this._activity.getPackageName() + ":drawable/" + this._values[i], null, null);
                paramArrayOfString1 = new ImageView(SmileInputBuilder.this._activity);
                paramArrayOfString1.setLayoutParams(new AbsListView.LayoutParams(SmileInputBuilder.this._iconSize, SmileInputBuilder.this._iconSize));
                paramArrayOfString1.setAdjustViewBounds(true);
                paramArrayOfString1.setScaleType(ImageView.ScaleType.CENTER);
                paramArrayOfString1.setImageResource(j);
                this._views.add(paramArrayOfString1);
                i += 1;
            }
        }

        public int getCount() {
            return this._keys.length;
        }

        public Object getItem(int paramInt) {
            return this._keys[paramInt];
        }

        public long getItemId(int paramInt) {
            return paramInt;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            return (View) this._views.get(paramInt);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/SmileInputBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */