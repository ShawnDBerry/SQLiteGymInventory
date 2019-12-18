package com.example.sqlitegyminventory.model;

import android.os.Parcel;
import android.os.Parcelable;

public class GymItem implements Parcelable {
    private int gymItemId;
    private String gymItemName;
    private String gymItemQuantity;

    protected GymItem(Parcel in) {
        gymItemId = in.readInt();
        gymItemName = in.readString();
        gymItemQuantity = in.readString();
    }

    public GymItem(int gymItemId, String gymItemName, String gymItemQuantity) {
        this.gymItemId = gymItemId;
        this.gymItemName = gymItemName;
        this.gymItemQuantity = gymItemQuantity;
    }

    public static final Creator<GymItem> CREATOR = new Creator<GymItem>() {
        @Override
        public GymItem createFromParcel(Parcel in) {
            return new GymItem(in);
        }

        @Override
        public GymItem[] newArray(int size) {
            return new GymItem[size];
        }
    };

    public GymItem(String gymItemName, String gymItemQuantity) {
        this.gymItemName = gymItemName;
        this.gymItemQuantity = gymItemQuantity;
    }

    public int getGymItemId() {
        return gymItemId;
    }

    public void setGymItemId(int gymItemId) {
        this.gymItemId = gymItemId;
    }

    public String getGymItemName() {
        return gymItemName;
    }

    public void setGymItemName(String gymItemName) {
        this.gymItemName = gymItemName;
    }

    public String getGymItemQuantity() {
        return gymItemQuantity;
    }

    public void setGymItemQuantity(String gymItemQuantity) {
        this.gymItemQuantity = gymItemQuantity;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(gymItemId);
        dest.writeString(gymItemName);
        dest.writeString(gymItemQuantity);
    }
}
