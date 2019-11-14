package com.synconset;

import android.os.Parcel;
import android.os.Parcelable;

public class SelectedModel implements Parcelable {
    String filename;
    int number;

    public SelectedModel() {
    }

    public SelectedModel(String filename, int number) {
        this.filename = filename;
        this.number = number;
    }

    protected SelectedModel(Parcel in) {
        filename = in.readString();
        number = in.readInt();
    }

    public static final Creator<SelectedModel> CREATOR = new Creator<SelectedModel>() {
        @Override
        public SelectedModel createFromParcel(Parcel in) {
            return new SelectedModel(in);
        }

        @Override
        public SelectedModel[] newArray(int size) {
            return new SelectedModel[size];
        }
    };

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(filename);
        dest.writeInt(number);
    }
}
