package dev.sturmtruppen.bibliovale.businessLogic.Helpers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import dev.sturmtruppen.bibliovale.businessLogic.BO.Book;
import dev.sturmtruppen.bibliovale.businessLogic.BO.Genre;

/**
 * Created by Matteo on 27/08/2016.
 */
public final class JSONHelper {

    public static List<Book> getBookList(String jsonList){
        List<Book> books = new ArrayList<Book>();

        try {
            JSONArray jsonBooks;
            jsonBooks = new JSONArray(jsonList);
            if (jsonBooks != null){
                for (int i=0; i<jsonBooks.length(); i++){
                    JSONObject jsonBook = jsonBooks.getJSONObject(i);
                    Book book = new Book(jsonBook);
                    books.add(book);
                }
            }
        } catch (JSONException e){
            e.printStackTrace();
        }

        return books;
    }

    public static Book getBook(String strBook){
        JSONObject jsonBook = null;
        try {
            jsonBook = new JSONObject(strBook);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Book book = new Book(jsonBook);

        return book;
    }

    public static List<Genre> getGenresList(String jsonList){
        List<Genre> genres = new ArrayList<Genre>();

        try {
            JSONArray jsonGenres;
            jsonGenres = new JSONArray(jsonList);
            if (jsonGenres != null){
                for (int i=0; i<jsonGenres.length(); i++){
                    JSONObject jsonGenre = jsonGenres.getJSONObject(i);
                    Genre genre = new Genre(jsonGenre);
                    genres.add(genre);
                }
            }
        } catch (JSONException e){
            e.printStackTrace();
        }

        return genres;
    }
}