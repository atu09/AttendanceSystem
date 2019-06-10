package com.attendance.system.view_holders;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.attendance.system.R;
import com.attendance.system.databinding.CellMessageLeftBinding;


/**
 * Created by Admin on 5/15/2017.
 */

public class MessageLeftVH {

    private CellMessageLeftBinding itemBinding;

    public MessageLeftVH() {
    }

    public void setItemBinding(Context context, ViewGroup parent) {
        this.itemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.cell_message_left, parent, false);
    }

    public MyHolder castHolder(RecyclerView.ViewHolder holder) {
        return (MyHolder) holder;
    }

    public MyHolder getHolder() {
        return new MyHolder(itemBinding.getRoot());
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        public TextView tvMessage, tvDate;

        MyHolder(View view) {
            super(view);

            this.tvMessage = itemBinding.tvMessage;
            this.tvDate = itemBinding.tvDate;

        }

    }
}
