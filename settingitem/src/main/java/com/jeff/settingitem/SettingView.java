package com.jeff.settingitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by jeff on 2017/2/20.
 */

public class SettingView extends RelativeLayout {

    private RelativeLayout mRootView;
    private TextView mTvText;
    private ImageView mLeftIcon;
    private ImageView mRightIcon;
    private OnItemViewClick mOnItemViewClick;
    private ImageView mIvDot;

    public SettingView(Context context) {
        this(context, null);
    }

    public SettingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SettingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initAttr(context, attrs);
    }

    private void initAttr(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SettingView);
        int count = a.getIndexCount();
        for (int i = 0; i < count; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.SettingView_item_background) { //backgroundcolor,is a color or selector
                Drawable drawable = a.getDrawable(attr);
                if (Build.VERSION.SDK_INT >= 16) {
                    mRootView.setBackground(drawable);
                } else {
                    mRootView.setBackgroundDrawable(drawable);
                }
            } else if (attr == R.styleable.SettingView_item_text) {    //item text
                String string = a.getString(attr);
                setItemText(string);
            } else if (attr == R.styleable.SettingView_text_color) {   //tiem text color
                int color = a.getColor(attr, Color.BLACK);
                mTvText.setTextColor(color);
            } else if (attr == R.styleable.SettingView_text_size) {    //item text size
                int size = a.getDimensionPixelSize(attr, 16);
                mTvText.setTextSize(px2sp(context, size));
            } else if (attr == R.styleable.SettingView_left_icon) {    //left icon
                Drawable drawable = a.getDrawable(attr);
                mLeftIcon.setImageDrawable(drawable);
            } else if (attr == R.styleable.SettingView_right_icon) {   //right icon
                Drawable drawable = a.getDrawable(attr);
                mRightIcon.setImageDrawable(drawable);
            } else if (attr == R.styleable.SettingView_left_icon_margin_left) {    //marginleft of the left icon
                RelativeLayout.LayoutParams params = (LayoutParams) mLeftIcon.getLayoutParams();
                int left = a.getDimensionPixelSize(attr, 20);
                params.leftMargin = left;
                mLeftIcon.setLayoutParams(params);
            } else if (attr == R.styleable.SettingView_text_margin_left) {   //marginright of the text
                RelativeLayout.LayoutParams params = (LayoutParams) mTvText.getLayoutParams();
                int right = a.getDimensionPixelSize(attr, 20);
                params.leftMargin = right;
                mTvText.setLayoutParams(params);
            } else if (attr == R.styleable.SettingView_right_icon_margin_right) {  //marginright of the right icon
                RelativeLayout.LayoutParams params = (LayoutParams) mRightIcon.getLayoutParams();
                float left = a.getDimension(attr, 0);
                params.rightMargin = (int) left;
                mRightIcon.setLayoutParams(params);
            } else if (attr == R.styleable.SettingView_show_left_icon) {
                boolean show = a.getBoolean(attr, true);
                showLeftIcon(show);
            } else if (attr == R.styleable.SettingView_show_right_icon) {
                boolean show = a.getBoolean(attr, true);
                showRightIcon(show);
            } else if (attr == R.styleable.SettingView_show_dot) {
                boolean show = a.getBoolean(attr, false);
                showDot(show);
            }
        }
        a.recycle();
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.item_view, this);
        mRootView = (RelativeLayout) view.findViewById(R.id.rel_root);
        mLeftIcon = (ImageView) view.findViewById(R.id.iv_left);
        mTvText = (TextView) view.findViewById(R.id.tv_text);
        mRightIcon = (ImageView) view.findViewById(R.id.iv_right);
        mIvDot = (ImageView) view.findViewById(R.id.iv_dot);
        mRootView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mOnItemViewClick) {
                    mOnItemViewClick.itemClick();
                }
            }
        });
    }

    /**
     * is show left icon
     *
     * @param show
     */
    public void showLeftIcon(boolean show) {
        if (show) {
            mLeftIcon.setVisibility(VISIBLE);
        } else {
            mLeftIcon.setVisibility(GONE);
        }
    }

    /**
     * is show righticon
     *
     * @param show
     */
    public void showRightIcon(boolean show) {
        if (show) {
            mRightIcon.setVisibility(VISIBLE);
        } else {
            mRightIcon.setVisibility(GONE);
        }
    }

    /**
     * is show dot
     *
     * @param show
     */
    public void showDot(boolean show) {
        if (show) {
            mIvDot.setVisibility(VISIBLE);
        } else {
            mIvDot.setVisibility(GONE);
        }
    }

    /**
     * setting item text
     *
     * @param text
     */
    public void setItemText(String text) {
        mTvText.setText(text);
    }

    public void setOnItemViewClick(OnItemViewClick onItemviewClick) {
        this.mOnItemViewClick = onItemviewClick;
    }

    public interface OnItemViewClick {
        void itemClick();
    }

    private float px2sp(Context context, float px) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return px / fontScale;
    }

    private float px2dip(Context context, int px) {
        float density = context.getResources().getDisplayMetrics().density;
        return px / density;
    }
}
