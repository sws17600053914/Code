package com.example.admin.myapplication.utils;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.admin.myapplication.R;

import java.util.List;




/**
 * 自定义控件：1、自定义组合已有控件 2、自定义控件(继承已有的控件,继承View,继承ViewGroup)
 *
 * @author Administrator
 */

public class MyGridLayout extends GridLayout {
    OnItemClickLitener onItemClickLitener;
    private List<String> list1;
    private int index;

    public interface OnItemClickLitener {
        void OnItemClickLitener(String strItem, View v);
    }

    public void setOnItemClickLitener(OnItemClickLitener onItemClickLitener) {
        this.onItemClickLitener = onItemClickLitener;
    }

    // 被拖拽的View
    private View mDragedView;

    // 在XML里面声明该控件的style属性的时候调用
    public MyGridLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();

    }

    // 在XML里面声明该控件的时候调用
    public MyGridLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    // 在代码里面new对象的时候调用
    public MyGridLayout(Context context) {
        this(context, null);
    }


    private void init() {
        setColumnCount(3);
        setLayoutTransition(new LayoutTransition());
    }

    // 初始化当前GridLayout的条目个数和 条目动画
    public void setItems(List<String> list) {
        list1 = list;
        for (String strItem : list) {
            addItem(strItem);
        }
    }

    private int mMargin = 15;
    private boolean mDragAble;


    // 向外界提供的设置添加GridLayout条目的方法
    public void addItem(final String strItem) {
        final TextView tv = new TextView(getContext());
        LayoutParams lp = new LayoutParams();
        lp.width = getResources().getDisplayMetrics().widthPixels / 3 - 0
                * 2;
        lp.height = LayoutParams.WRAP_CONTENT;
        lp.setMargins(0, mMargin, 0, mMargin);


        tv.setLayoutParams(lp);
        tv.setTextSize(20f);
        tv.setGravity(Gravity.CENTER);
        tv.setPadding(0, 10, 0, 10);
        tv.setText(strItem);
        tv.setScaleX(0.8f);
        tv.setScaleY(0.8f);
        tv.setBackgroundResource(R.drawable.drag_item_selector);
        MyGridLayout.this.addView(tv);
        tv.setClickable(false);
        tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickLitener.OnItemClickLitener(strItem, tv);
            }
        });

        // 可以拖拽
        if (mDragAble) {
            tv.setOnLongClickListener(ocl);
            // 不能拖拽
        } else {
            tv.setOnLongClickListener(null);
        }

    }

    // TextView(MyGridLayout的条目)的长按事件
    private OnLongClickListener ocl = new OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {

            mDragedView = v;
            Log.e("num", "ocl");
//            v.startAnimation(new ScaleAnimation(0.2f,1.5f,0.2f,1.5f));
            v.setAnimation(new ScaleAnimation(0.2f, 1.5f, 0.2f, 1.5f));
            v.setScaleX(1.0f);
            v.setScaleY(1.0f);
            v.startDrag(null, new DragShadowBuilder(v), null, 0);
            v.setEnabled(false);

            return true;
        }
    };

    // 向外界提供是否能拖拽的方法
    public void setDragAble(boolean isDrage) {
        this.mDragAble = isDrage;
        Log.e("num", "1111" + isDrage);
        if (mDragAble) {
            // 监听拖拽事件
            this.setOnDragListener(odl);
        } else {
            // 不监听拖拽事件
            this.setOnDragListener(null);
        }
    }

    // 拖拽监听器
    private OnDragListener odl = new OnDragListener() {

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean onDrag(View arg0, DragEvent event) {

            switch (event.getAction()) {
                // 开始拖拽
                case DragEvent.ACTION_DRAG_STARTED:
                    initRect();

                    break;

                // 实时监听拖拽事件
                case DragEvent.ACTION_DRAG_LOCATION:
                    index = getIntouchIndex(event);
                    if (index > -1 && mDragedView != null
                            && mDragedView != getChildAt(index)) {
                        removeView(mDragedView);
                        addView(mDragedView, index);
                    }
                    break;

                // 停止拖拽
                case DragEvent.ACTION_DRAG_ENDED:
                    if (mDragedView != null) {
                        mDragedView.setScaleX(0.8f);
                        mDragedView.setScaleY(0.8f);
                        mDragedView.setEnabled(true);
                    }
//                    MyApp.mLists.remove(mDragedView.toString());
//                    MyApp.mLists.add(index,mDragedView.toString());

                    Log.e("YAH", "onDrag: "+"-------"+index +"------++"+mDragedView.getTransitionName());



                    break;
            }
            return true;
        }

    };

    private Rect[] mRectArr;

    // 将所有的条目都封装成矩形然后存入数组
    private void initRect() {
        int childViewCount = getChildCount();
        mRectArr = new Rect[childViewCount];
        for (int i = 0; i < childViewCount; i++) {
            View childView = getChildAt(i);

            Rect rect = new Rect(childView.getLeft(), childView.getTop(),
                    childView.getRight(), childView.getBottom());
            mRectArr[i] = rect;
        }

    }

    // 实时监听拖拽的点是否进入到了某一个子控件范围内
    private int getIntouchIndex(DragEvent event) {
        for (int i = 0; i < mRectArr.length; i++) {
            if (mRectArr[i].contains((int) event.getX(), (int) event.getY())) {
                return i;
            }
        }


        return -1;
    }


}
