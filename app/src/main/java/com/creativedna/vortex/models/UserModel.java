package com.creativedna.vortex.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class UserModel implements Parcelable {

    public String userID;
    public String userName;
    public String userEmail;
    public String profilePic;

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {

        @Override
        public UserModel createFromParcel(Parcel parcel) {
            return new UserModel(parcel);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public UserModel() {

    }

    private UserModel(Parcel parcel) {
        userName = parcel.readString();
        userEmail = parcel.readString();
        profilePic = parcel.readString();
        userID = parcel.readString();
    }


    @Override
    public void writeToParcel(Parcel parcel, int flag) {
        parcel.writeString(userName);
        parcel.writeString(userEmail);
        parcel.writeString(profilePic);
        parcel.writeString(userID);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
