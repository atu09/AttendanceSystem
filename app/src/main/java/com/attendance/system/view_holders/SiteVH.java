package com.attendance.system.view_holders;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.attendance.system.R;
import com.attendance.system.databinding.CellSiteBinding;

import atirek.pothiwala.utility.views.SquareImageView;


/**
 * Created by Admin on 5/15/2017.
 */

public class SiteVH {

    private CellSiteBinding itemBinding;

    public SiteVH() {
    }

    public void setItemBinding(Context context, ViewGroup parent) {
        this.itemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.cell_site, parent, false);
    }

    public MyHolder castHolder(RecyclerView.ViewHolder holder) {
        return (MyHolder) holder;
    }

    public MyHolder getHolder() {
        return new MyHolder(itemBinding.getRoot());
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        public SquareImageView ivSite;
        public TextView tvTitle, tvSubTitle, tvDate, btnChat, btnLocate;

        MyHolder(View view) {
            super(view);

            this.tvTitle = itemBinding.tvTitle;
            this.tvSubTitle = itemBinding.tvSubTitle;
            this.tvDate = itemBinding.tvDate;
            this.btnChat = itemBinding.btnChat;
            this.btnLocate = itemBinding.btnLocate;
            this.ivSite = itemBinding.ivSite;

        }

    }
}
