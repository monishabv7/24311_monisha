package com.example.mynotesapp.adapter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.mynotesapp.AlarmReceiver;
import com.example.mynotesapp.R;

import java.util.ArrayList;
import java.util.Calendar;

public class MyNewArrayAdapter extends ArrayAdapter implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {

    private Context mContext;

    private int reminderListLayout;

    private int hour, minute;

    private String note;

    private MyViewHolder viewHolder;

    public MyNewArrayAdapter(Context context, int resource, ArrayList<String> reminderList) {
        super(context, resource, reminderList);

        this.mContext = context;

        reminderListLayout = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        note = String.valueOf(getItem(position));

        if(convertView == null)
        {
            viewHolder = new MyViewHolder();

            LayoutInflater inflater = LayoutInflater.from(mContext);

            convertView = inflater.inflate(reminderListLayout, parent, false);

            viewHolder.rmDesc = convertView.findViewById(R.id.text1);
            viewHolder.rmImg = convertView.findViewById(R.id.alarm_icon);
            viewHolder.rmImg.setOnClickListener(this);

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (MyViewHolder) convertView.getTag();
        }

        viewHolder.rmDesc.setText(note);

        return convertView;
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.alarm_icon)
        {
            TimePickerDialog timePickerDialog = new TimePickerDialog(mContext, android.R.style.Theme_Material_Dialog_Alert, this, hour, minute, true);
            timePickerDialog.setTitle("Set a time");
            timePickerDialog.show();
        }
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
        String time = hourOfDay + ":" + minute;

        notifyDataSetChanged();

        Calendar calNow = Calendar.getInstance();
        Calendar calSet = (Calendar) calNow.clone();

        calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calSet.set(Calendar.MINUTE, minute);
        calSet.set(Calendar.SECOND, 0);
        calSet.set(Calendar.MILLISECOND, 0);

        if (calSet.compareTo(calNow) <= 0) {

            calSet.add(Calendar.DATE, 1);
        }

        setAlarm(calSet);

    }

    private void setAlarm(Calendar targetCal) {


        Toast.makeText(mContext, "Alarm is set at" + targetCal.getTime(),Toast.LENGTH_LONG).show();

        Intent intent = new Intent(mContext, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, 1, intent, 0);
        AlarmManager alarmManager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(),
                pendingIntent);

    }

    private static class MyViewHolder {

        TextView rmDesc;
        ImageView rmImg;
    }

}


