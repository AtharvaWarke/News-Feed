    package com.example.android.newsfeed;

public class data {
    private String mTitle;
    public String mUrl;
    private String mUrlToImage;
    private String mDescription;
    private String mSource;
    static data INSTANCE;

    public data(String source, String title, String description, String url, String urlToImage) {
        mSource = source;
        mTitle = title;
        mDescription = description;
        mUrl = url;
        mUrlToImage = urlToImage;
        INSTANCE = this;
    }


    public String getSource() {
        return mSource;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getUrlToImage() {
        return mUrlToImage;
    }


}
