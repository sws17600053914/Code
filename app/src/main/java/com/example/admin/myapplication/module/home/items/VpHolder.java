package com.example.admin.myapplication.module.home.items;

import android.view.View;

import com.example.admin.myapplication.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;



/**
 * Created by C on 2017/7/19
 */

public class VpHolder extends XRecyclerView.ViewHolder {

    private Banner banner;

    public void setBanner(Banner banner) {
        this.banner = banner;
    }

    public VpHolder(View itemView) {
        super(itemView);
        banner = (Banner) itemView.findViewById(R.id.mybanner);
    }
}
