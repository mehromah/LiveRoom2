
package com.example.myapplication.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
@Entity(tableName = "tbl_product")
public class Product implements Parcelable {




    @SerializedName("discount")
    private Long mDiscount;

    @PrimaryKey
    @SerializedName("id")
    private int mId;
    @SerializedName("image")
    private String mImage;
    @SerializedName("previous_price")
    private Long mPreviousPrice;
    @SerializedName("price")
    private Long mPrice;
    @SerializedName("status")
    private Long mStatus;
    @SerializedName("title")
    private String mTitle;

    public Long getDiscount() {
        return mDiscount;
    }

    public void setDiscount(Long discount) {
        mDiscount = discount;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public Long getPreviousPrice() {
        return mPrice + mDiscount;
    }

    public void setPreviousPrice(Long previousPrice) {
        mPreviousPrice = previousPrice;
    }

    public Long getPrice() {
        return mPrice;
    }

    public void setPrice(Long price) {
        mPrice = price;
    }

    public Long getStatus() {
        return mStatus;
    }

    public void setStatus(Long status) {
        mStatus = status;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }


    public Product() {
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.mDiscount);
        dest.writeInt(this.mId);
        dest.writeString(this.mImage);
        dest.writeValue(this.mPreviousPrice);
        dest.writeValue(this.mPrice);
        dest.writeValue(this.mStatus);
        dest.writeString(this.mTitle);
    }

    protected Product(Parcel in) {
        this.mDiscount = (Long) in.readValue(Long.class.getClassLoader());
        this.mId = in.readInt();
        this.mImage = in.readString();
        this.mPreviousPrice = (Long) in.readValue(Long.class.getClassLoader());
        this.mPrice = (Long) in.readValue(Long.class.getClassLoader());
        this.mStatus = (Long) in.readValue(Long.class.getClassLoader());
        this.mTitle = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
