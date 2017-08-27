package com.example.admin.examplechat;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 2017-08-26.
 */

public class ChatListAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<ChatDto> chatArray;
    private String userName;
    private String imei;

    public ChatListAdapter(Activity activity, ArrayList<ChatDto> chatArray) {
        this.activity = activity;
        this.chatArray = chatArray;
        this.userName = Util.getInstance().getUserName();
        this.imei = Util.getInstance().getImei();
    }

    @Override
    public int getCount() {
        return chatArray.size();
    }

    @Override
    public Object getItem(int position) {
        return chatArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        TextView user_name_tv = null;
        ChatTextView user_message_tv = null;

        if(imei.equals(chatArray.get(position).getImei())){
            view = activity.getLayoutInflater().inflate(R.layout.my_chat_list_item, null);
            user_message_tv = (ChatTextView) view.findViewById(R.id.user_message_tv);
        }
        else{
            if(position > 0 && !chatArray.get(position).getImei().equals(chatArray.get(position - 1).getImei())) {
                view = activity.getLayoutInflater().inflate(R.layout.other_chat_list_item1, null);
                user_name_tv = (TextView) view.findViewById(R.id.user_name_tv);
                user_message_tv = (ChatTextView) view.findViewById(R.id.user_message_tv);
                user_name_tv.setText(chatArray.get(position).getUserName());
            }
            else{
                view = activity.getLayoutInflater().inflate(R.layout.other_chat_list_item2, null);
                user_message_tv = (ChatTextView) view.findViewById(R.id.user_message_tv);
            }
        }

        user_message_tv.setText(chatArray.get(position).getMessage());

        return view;
    }

    public void add(ChatDto chatDto){
        chatArray.add(chatDto);
        notifyDataSetChanged();
    }
}
