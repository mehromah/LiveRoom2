package com.example.myapplication.model.api;



import com.example.myapplication.model.PRSMBL003;
import com.example.myapplication.model.PRSMBL004;
import com.example.myapplication.model.PRSMBL005;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class JsonResponse {
    @SerializedName("Table")
    private List<PRSMBL003> prsmbl003List;

    @SerializedName("Table1")
    private List<PRSMBL004> prsmbl004List;

    @SerializedName("Table2")
    private List<PRSMBL005> prsmbl005List;


    public List<PRSMBL003> getPrsmbl003List() {
        return prsmbl003List;
    }

    public void setPrsmbl003List(List<PRSMBL003> prsmbl003List) {
        this.prsmbl003List = prsmbl003List;
    }

    public List<PRSMBL004> getPrsmbl004List() {
        return prsmbl004List;
    }

    public void setPrsmbl004List(List<PRSMBL004> prsmbl004List) {
        this.prsmbl004List = prsmbl004List;
    }

    public List<PRSMBL005> getPrsmbl005List() {
        return prsmbl005List;
    }

    public void setPrsmbl005List(List<PRSMBL005> prsmbl005List) {
        this.prsmbl005List = prsmbl005List;
    }
}
