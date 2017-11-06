
package com.example.joseph.redditchallenge.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response implements Serializable
{

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("data")
    @Expose
    private Data data;
    private final static long serialVersionUID = 2073776376901043703L;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
