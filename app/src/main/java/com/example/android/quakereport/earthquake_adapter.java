package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class earthquake_adapter extends ArrayAdapter<earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public earthquake_adapter(@NonNull Context context, List<earthquake> eq){
        super(context,0,eq);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DecimalFormat magFormatter = new DecimalFormat("0.0");
        View listItemView=convertView;
        if(listItemView==null)
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        earthquake mEarthquake=getItem(position);
        TextView mMag=(TextView)listItemView.findViewById(R.id.magnitude);

        GradientDrawable magnitudeCircle = (GradientDrawable) mMag.getBackground();
        magnitudeCircle.setColor(getMagnitudeColor(mEarthquake.getMag()));

        TextView mLocOffset=(TextView)listItemView.findViewById(R.id.locationOffset);
        TextView mLocPrimary=(TextView)listItemView.findViewById(R.id.locationPrimary);
        TextView mDat=(TextView)listItemView.findViewById(R.id.date);
        TextView mTime=(TextView)listItemView.findViewById(R.id.time);
        if(mEarthquake!=null){
            mMag.setText(magFormatter.format(mEarthquake.getMag()));
            if(mEarthquake.getLoc().contains(LOCATION_SEPARATOR)) {
                mLocOffset.setText((mEarthquake.getLoc().split(LOCATION_SEPARATOR)[0]+LOCATION_SEPARATOR));
                mLocPrimary.setText(mEarthquake.getLoc().split(LOCATION_SEPARATOR)[1]);
            }
            else{
                mLocOffset.setText(getContext().getString(R.string.near_the));
                mLocPrimary.setText(mEarthquake.getLoc());
            }
            mDat.setText(mEarthquake.getDat());
            mTime.setText(mEarthquake.getTim());
        }
        return listItemView;
    }
}