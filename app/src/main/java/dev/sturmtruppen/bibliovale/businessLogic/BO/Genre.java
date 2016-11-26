package dev.sturmtruppen.bibliovale.businessLogic.BO;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Matteo on 26/11/2016.
 */

public class Genre {

    private String originalJson;
    private int id;
    private String name;

    public Genre(){super();}
    public Genre(JSONObject _jsonBook){
        try {
            this.originalJson = _jsonBook.toString();
            this.id = _jsonBook.getInt("id");
            this.name = _jsonBook.getString("name");

        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}