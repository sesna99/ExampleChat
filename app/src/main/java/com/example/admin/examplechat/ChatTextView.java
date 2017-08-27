package com.example.admin.examplechat;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by admin on 2017-08-27.
 */

public class ChatTextView extends AppCompatTextView {
    public ChatTextView(Context context) {
        super(context);
    }

    public ChatTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChatTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override public void setText(CharSequence text, BufferType type) {
        super.setText(text.toString().replace(" ", "\u00A0"), type);
    }
}
