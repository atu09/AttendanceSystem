package com.attendance.system.fragments;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.attendance.system.R;
import com.attendance.system.activities.ChatActivity;
import com.attendance.system.activities.HomeActivity;
import com.attendance.system.databinding.FragmentListBinding;
import com.attendance.system.view_holders.ChatVH;

import java.util.ArrayList;
import java.util.List;

import atirek.pothiwala.utility.adapters.ListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {

    FragmentListBinding binding;
    List<String> list = new ArrayList<>();

    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, true);

            for (int i = 0; i < 10; i++) {
                list.add(String.valueOf(i));
            }

            DividerItemDecoration itemDecoration = new DividerItemDecoration(HomeActivity.getInstance(), DividerItemDecoration.VERTICAL);
            itemDecoration.setDrawable(getResources().getDrawable(R.drawable.divider_gray));
            binding.rvList.addItemDecoration(itemDecoration);
            binding.rvList.setHasFixedSize(true);
            binding.rvList.setAdapter(adapter);
        }

        return binding.getRoot();
    }

    ListAdapter adapter = new ListAdapter(new ListAdapter.AdapterListener() {

        ChatVH chatVH = new ChatVH();

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            chatVH.setItemBinding(getContext(), parent);
            return chatVH.getHolder();
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
            final ChatVH.MyHolder myHolder = chatVH.castHolder(holder);
            myHolder.tvTitle.setText("Kaizad Hansotia");
            myHolder.tvSubTitle.setText("Hello!");
            myHolder.tvDate.setText("9 Aug, 2019");
            myHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(HomeActivity.getInstance(), ChatActivity.class));
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
