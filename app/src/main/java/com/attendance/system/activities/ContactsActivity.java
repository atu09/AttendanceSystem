package com.attendance.system.activities;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.attendance.system.R;
import com.attendance.system.databinding.ActivityContactsBinding;
import com.attendance.system.view_holders.ChatVH;

import java.util.ArrayList;
import java.util.List;

import atirek.pothiwala.utility.adapters.ListAdapter;

public class ContactsActivity extends AppCompatActivity {

    ActivityContactsBinding binding;
    List<String> list = new ArrayList<>();

    static ContactsActivity activity;

    public static ContactsActivity getInstance() {
        return activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_contacts);
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

        binding.rvList.setAdapter(adapter);
    }

    ListAdapter adapter = new ListAdapter(new ListAdapter.AdapterListener() {

        ChatVH chatVH = new ChatVH();

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            chatVH.setItemBinding(activity, parent);
            return chatVH.getHolder();
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
            final ChatVH.MyHolder myHolder = chatVH.castHolder(holder);
            myHolder.tvTitle.setText("Kaizad Hansotia");
            myHolder.tvSubTitle.setText("+91 9662282189");
            myHolder.tvDate.setVisibility(View.GONE);
            myHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        @Override
        public int getItemViewType(int position) {
            return 0;
        }
    });
}
