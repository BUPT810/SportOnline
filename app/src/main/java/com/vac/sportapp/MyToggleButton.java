package com.vac.sportapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by vac on 2016/7/15.
 */
public class MyToggleButton extends TextView implements Checkable {

    boolean mChecked;
    private  OnCheckedChangeListener mOnCheckedChangeListener = null;
    public MyToggleButton(Context context) {
        this(context,null);
    }

    public MyToggleButton(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyToggleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setChecked(false);
    }
    @Override
    public void setChecked(boolean checked) {
        this.mChecked = checked;
        if(mOnCheckedChangeListener != null)
            mOnCheckedChangeListener.onCheckedChanged(this,checked);
        Drawable icon,icon2;
        if (checked) {
            setTextColor(getResources().getColor(R.color.checked));
            icon = getResources().getDrawable(R.mipmap.dropdown_actived_right);
            icon2 = getResources().getDrawable(R.mipmap.dropdown_active_bottom);
        }else {
            setTextColor(getResources().getColor(R.color.text_gray));
            icon = getResources().getDrawable(R.mipmap.dropdown_normal_right);
            icon2 = getResources().getDrawable(R.mipmap.dropdown_nomal_bottom);
        }
        setCompoundDrawablesWithIntrinsicBounds(null, null, icon,icon2);
        //mOnCheckedChangeListener.onCheckedChanged(MyToggleButton.this,checked);
    }
    @Override
    public boolean isChecked() {
        return mChecked;
    }
    @Override
    public void toggle() {
       setChecked(!mChecked);
    }
    @Override
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    /**
     * Register a callback to be invoked when the checked state of this button
     * changes. This callback is used for internal purpose only.
     *
     * @param listener the callback to call on checked state change
     * @hide
     */
    void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeListener = listener;
    }

    /**
     * Interface definition for a callback to be invoked when the checked state
     * of a compound button changed.
     */
    public static interface OnCheckedChangeListener {
        /**
         * Called when the checked state of a compound button has changed.
         *
         * @param buttonView The compound button view whose state has changed.
         * @param isChecked  The new checked state of buttonView.
         */
        void onCheckedChanged(MyToggleButton buttonView, boolean isChecked);
    }
}
