package com.attendance.system.activities;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.attendance.system.R;
import com.attendance.system.databinding.ActivityChatBinding;
import com.attendance.system.view_holders.MessageLeftVH;
import com.attendance.system.view_holders.MessageRightVH;

import java.util.ArrayList;
import java.util.List;

import atirek.pothiwala.utility.adapters.ListAdapter;
import atirek.pothiwala.utility.views.SpacingDecoration;

public class ChatActivity extends AppCompatActivity {

    ActivityChatBinding binding;
    List<String> list = new ArrayList<>();

    static ChatActivity activity;

    public static ChatActivity getInstance() {
        return activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat);
        activity = this;

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        SpacingDecoration spacingDecoration = new SpacingDecoration(activity, R.dimen.dp10, R.dimen.dp10, true);
        binding.rvChat.addItemDecoration(spacingDecoration);
        binding.rvChat.setAdapter(adapter);
    }

    ListAdapter adapter = new ListAdapter(new ListAdapter.AdapterListener() {

        MessageRightVH messageRightVH = new MessageRightVH();
        MessageLeftVH messageLeftVH = new MessageLeftVH();

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            if (viewType == 1) {
                messageRightVH.setItemBinding(activity, parent);
                return messageRightVH.getHolder();
            } else {
                messageLeftVH.setItemBinding(activity, parent);
                return messageLeftVH.getHolder();
            }
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
            if (getItemViewType(position) == 1) {
                final MessageRightVH.MyHolder myHolder = messageRightVH.castHolder(holder);
                myHolder.tvMessage.setText("Hello " + position);
                myHolder.tvDate.setText(position + " Aug, 2019");

            } else {
                final MessageLeftVH.MyHolder myHolder = messageLeftVH.castHolder(holder);
                myHolder.tvMessage.setText("Hello " + position);
                myHolder.tvDate.setText(position + " Aug, 2019");
            }
        }

        @Override
        public int getItemCount() {
            int size = list.size();
            binding.tvEmpty.setVisibility(size > 0 ? View.GONE : View.VISIBLE);
            return size;
        }

        @Override
        public int getItemViewType(int position) {
            if (position % 2 == 0) {
                return 1;
            }
            return 0;
        }
    });
}
