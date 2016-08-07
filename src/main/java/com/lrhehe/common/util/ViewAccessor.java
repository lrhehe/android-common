package com.lrhehe.common.util;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lrhehe.common.R;

/**
 * @author wanghb
 * @date 14/12/30.
 */
public class ViewAccessor {
    public static ViewAccessor create(View view) {
        return new ViewAccessor(view);
    }

    private View wrappedView;

    private ViewAccessor(View view) {
        wrappedView = view;
    }

    public View getWrappedView() {
        return wrappedView;
    }

    public ViewAccessor setText(int id, CharSequence string) {
        setText(id, string, 0);
        return this;
    }

    public ViewAccessor setText(int id, int stringId) {
        setText(id, ResUtil.getString(stringId), 0);
        return this;
    }

    public ViewAccessor setText(int id, CharSequence string, int color) {
        View v = wrappedView.findViewById(id);
        if(v instanceof TextView){
            ((TextView)v).setText(string);
            if(color != 0){
                ((TextView)v).setTextColor(color);
            }
        }
        return this;
    }

    public ViewAccessor setText(int id, int stringId, int color) {
        setText(id, ResUtil.getString(stringId), color);
        return this;
    }

    public ViewAccessor setVisibility(int id, int visibility) {
        View view = wrappedView.findViewById(id);
        if (view != null) {
            view.setVisibility(visibility);
        }
        return this;
    }

    public ViewAccessor setOnClickListener(int id, OnClickListener l) {
        View view = wrappedView.findViewById(id);
        if (view != null) {
            view.setOnClickListener(l);
        }
        return this;
    }

    public View findViewById(int id) {
        if (wrappedView == null) {
            return null;
        }
        return wrappedView.findViewById(id);
    }

    public ViewAccessor setImageResource(int id, int resId) {
        ImageView view = (ImageView) wrappedView.findViewById(id);
        if (view != null) {
            view.setImageResource(resId);
        }
        return this;
    }

    public ViewAccessor setSelected(int id, boolean selected) {
        View view = wrappedView.findViewById(id);
        if (view != null) {
            view.setSelected(selected);
        }
        return this;
    }

    public ViewAccessor setAllSelected(boolean selected){
        setAllSelected(wrappedView, selected);
        return this;
    }

    public ViewAccessor setAllSelected(int id, boolean selected){
        View v = wrappedView.findViewById(id);
        if(v != null) {
            setAllSelected(v, selected);
        }
        return this;
    }

    private ViewAccessor setAllSelected(View v, boolean selected){
        if(v instanceof ViewGroup){
            for(int i = 0; i < ((ViewGroup)v).getChildCount(); i++){
                setAllSelected(((ViewGroup)v).getChildAt(i), selected);
            }
        } else {
            v.setSelected(selected);
        }
        return this;
    }

    public ViewAccessor setBackgoundColor(int id, int color) {
        View view = wrappedView.findViewById(id);
        if (view != null) {
            view.setBackgroundColor(color);
        }
        return this;
    }

    public ViewAccessor setInvisible(int id, int mode){
        View view = wrappedView.findViewById(id);
        if (view != null) {
            view.setVisibility(mode);
        }
        return this;
    }
}
