package com.chaudhry.najeeb.news;


public class News {

    private String mTitleOfArticle;
    private String mNameOfSection;
    private String mAuthorName;
    private long mDatePusblished;

    public News(String titleOfArticle, String nameOfSection, String authorName, long datePusblished) {
        mTitleOfArticle = titleOfArticle;
        mNameOfSection = nameOfSection;
        mAuthorName = authorName;
        mDatePusblished = datePusblished;
    }

    public String getTitleOfArticle() {
        return mTitleOfArticle;
    }

    public String getNameOfSection() {
        return mNameOfSection;
    }

    public String getAuthorName() {
        return mAuthorName;
    }

    public long getDateTimePusblished() {
        return mDatePusblished;
    }
}
