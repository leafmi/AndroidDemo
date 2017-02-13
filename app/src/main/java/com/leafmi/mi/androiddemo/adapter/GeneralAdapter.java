package com.leafmi.mi.androiddemo.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.leafmi.mi.androiddemo.R;

import java.util.List;

/**
 * Created by Admin on 2016/8/29.
 */
public class GeneralAdapter extends BaseAdapter {
    private List<String> list;
    private Context mContext;

    public GeneralAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_general, viewGroup, false);
        }
        ViewHolder.<TextView>get(view, R.id.tv_item_name).setText(list.get(i));
        return view;
    }
}
