package com.wugod.wg_framework2.widget.pinlockview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.wugod.wg_framework2.R;

/**
 * It represents a set of indicator dots which when attached with {@link PinLockView}
 * can be used to indicate the current length of the input
 *
 * Created by aritraroy on 01/06/16.
 */
@SuppressLint("NewApi")
public class IndicatorDots extends LinearLayout {

    private static final int DEFAULT_PIN_LENGTH = 4;

    private int mDotDiameter;
    private int mDotSpacing;
    private int mFillDrawable;
    private int mEmptyDrawable;
    private int mPinLength;

    public IndicatorDots(Context context) {
        this(context, null);
    }

    public IndicatorDots(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IndicatorDots(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PinLockView);

        try {
            mDotDiameter = (int) typedArray.getDimension(R.styleable.PinLockView_dotDiameter, ResourceUtils.getDimensionInPx(getContext(), R.dimen.lock_dot_diameter));
            mDotSpacing = (int) typedArray.getDimension(R.styleable.PinLockView_dotSpacing, ResourceUtils.getDimensionInPx(getContext(), R.dimen.lock_dot_spacing));
            mFillDrawable = typedArray.getResourceId(R.styleable.PinLockView_dotFilledBackground, R.drawable.lock_dot_filled);
            mEmptyDrawable = typedArray.getResourceId(R.styleable.PinLockView_dotEmptyBackground, R.drawable.lock_dot_empty);
            mPinLength = typedArray.getInt(R.styleable.PinLockView_pinLength, DEFAULT_PIN_LENGTH);
        } finally {
            typedArray.recycle();
        }

        initDots(context);
    }

    private void initDots(Context context) {

        for (int i = 0; i < mPinLength; i++) {

            View dot = new View(context);
            emptyDot(dot);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(mDotDiameter, mDotDiameter);
            params.setMargins(mDotSpacing, 0, mDotSpacing, 0);
            dot.setLayoutParams(params);

            addView(dot);
        }
    }

    void updateDot(int length) {

        if (length > 0) {

            for (int i = 0; i < getChildCount(); i++) {
                View v = getChildAt(i);
                emptyDot(v);
            }

            for (int i = 0; i < length; i++) {
                View v = getChildAt(i);
                if (v != null) {
                    fillDot(v);
                }
            }
        } else {

            /**
             * When {@code mPinLength} is 0, we need to reset all the views back to empty
             */
            for (int i = 0; i < getChildCount(); i++) {
                View v = getChildAt(i);
                emptyDot(v);
            }
        }

    }

    private void emptyDot(View dot) {
        dot.setBackgroundResource(mEmptyDrawable);
    }

    private void fillDot(View dot) {
        dot.setBackgroundResource(mFillDrawable);
    }

    public int getPinLength() {
        return mPinLength;
    }

    public void setPinLength(int pinLength) {
        this.mPinLength = pinLength;
        removeAllViews();
        initDots(getContext());
    }
}
