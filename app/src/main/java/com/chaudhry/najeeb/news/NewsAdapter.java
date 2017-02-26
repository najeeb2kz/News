package com.chaudhry.najeeb.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NewsAdapter extends ArrayAdapter<News> {

    // Constructor
    public NewsAdapter(Context context, ArrayList<News> n) {
        super(context, 0, n);
    }


    // getView() method is in ArrayAdapter class
    // ListView calls ArrayAdapter’s getView() method to get items from ArrayAdapter
    // getView() passes the right view to ListView
    // You can either create a View manually or inflate it from an XML layout file
    //
    // parameter position: The position of the item within the adapter's data set of the item whose view we want
    // parameter convertView: The old view to reuse, if possible
    // paramter parent: The parent that this view will eventually be attached to
    // reurn View: A View corresponding to the data at the specified position.
    //
    // from() is static so use it with class name: LayoutInflater.from()
    // from(): Obtains the LayoutInflater from the given context
    // inflate(int resource, ViewGroup root, boolean attachToRoot)
    // inflate(): Inflate a new view hierarchy from the specified xml resource
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // getItem(position) is defined in super class ArrayAdapter
        // This method returns item in the list at given index position
        // Find the earthquake at the given position in the list of earthquakes
        News currentNews = getItem(position);

        TextView titleOfArticle = (TextView) listItemView.findViewById(R.id.titleOfArticle);
        titleOfArticle.setText(currentNews.getTitleOfArticle());

        TextView nameOfSection = (TextView) listItemView.findViewById(R.id.nameOfSection);
        nameOfSection.setText(currentNews.getNameOfSection());

        TextView authorName = (TextView) listItemView.findViewById(R.id.authorName);
        authorName.setText(currentNews.getAuthorName());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.dateTextView);
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.timeTextView);
        // So far time is in milliseconds.  Convert into good looking date and time format.
        // First create date object
        Date dateTimeObject = new Date(currentNews.getDateTimePusblished());
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateTimeObject);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateTimeObject);
        //Display date and time in proper textViews
        dateTextView.setText(formattedDate);
        timeTextView.setText(formattedTime);

        return listItemView;
    }


    //Return the formatted date string (i.e. "Mar 3, 1984") from a Date object
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }



    //Return the formatted date string (i.e. "4:30 PM") from a Date object
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
