package com.leafmi.mi.androiddemo.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.leafmi.mi.androiddemo.R;
import com.leafmi.mi.androiddemo.bean.network.JokePic;

import java.util.List;

/**
 * Created by Admin on 2016/9/29.
 */
public class JokePicAdapter extends BaseAdapter {

    private List<JokePic.ShowapiResBodyBean.ContentlistBean> jokePic;
    private Context mContext;

    public JokePicAdapter(Context context, List<JokePic.ShowapiResBodyBean.ContentlistBean> list) {
        this.mContext = context;
        this.jokePic = list;
    }

    @Override
    public int getCount() {
        return jokePic.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_joke_pic, parent, false);
        }
        ViewHolder.<TextView>get(convertView, R.id.title).setText(jokePic.get(position).getTitle());
        Glide.with(mContext)
                .load(jokePic.get(position).getImg())
                .into(ViewHolder.<ImageView>get(convertView, R.id.img));
        return convertView;
    }

    public static class ViewHolder {
        private static final int TAG_KEY = 0x7f000000;//viewHolder cache key

        @SuppressWarnings("unchecked")
        public static <T extends View> T get(View view, int id) {
            //we use view.getTag(int key) for cache, so we can use getTag() for other use
            SparseArray<View> viewHolder = (SparseArray<View>) view.getTag(TAG_KEY);
            if (viewHolder == null) {
                viewHolder = new SparseArray<>();
                view.setTag(TAG_KEY, viewHolder);
            }

            View childView = viewHolder.get(id);
            if (childView == null) {
                childView = view.findViewById(id);
                viewHolder.put(id, childView);
            }

            return (T) childView;
        }
    }
}
