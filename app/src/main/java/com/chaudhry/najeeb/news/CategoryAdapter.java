package com.chaudhry.najeeb.news;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    //Context of the app
    private Context mContext;

    //Constructor: Create a new object
    //param context is context of the app
    //param fm is the fragment manager that will keep each fragment's state in the adapter across swipes
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    //Return the fragment that should be displayed for the given page number
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new DebateFragment();
        } else if (position == 1) {
            return new EconomyFragment();
        } else if (position == 2) {
            return new ImmigrationFragment();
        } else {
            return new EducationFragment();
        }
    }

    //Return total number of pages
    @Override
    public int getCount() {
        return 4;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.category_debate);
            case 1:
                return mContext.getString(R.string.category_economy);
            case 2:
                return mContext.getString(R.string.category_immigration);
            case 3:
                return mContext.getString(R.string.category_education);
            default:
                return null;
        }
    }
}

