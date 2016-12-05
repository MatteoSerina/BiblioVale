package dev.sturmtruppen.bibliovale.businessLogic;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;

import java.util.concurrent.ExecutionException;

import dev.sturmtruppen.bibliovale.businessLogic.BO.Book;
import dev.sturmtruppen.bibliovale.businessLogic.DataFetchers.BiblioValeDataFetcher;

/**
 * Created by Matteo on 25/07/2016.
 */
public class BiblioValeApi {

    //private static String URL = "http://192.168.1.127/bibliovale/BiblioValeApi.php?"; //TEST, da convertire in configurazione
    private static String URL = GlobalConstants.webSiteUrl + "/BiblioValeApi.php?";

    // Elenco API REST PHP esposte
    private enum F_NAMES {getBook, getAuthors, getIsbn, createBook, createAuthor,
                            getGenreID, getStatusID, getAllGenres, getAllAuthors, updateBook}

    public static String getBookList(String _surname, String _name, String _title){
        String jsonBookList = "";

        // Preparazione url per chiamata REST
        String urlString = Uri.parse(URL).buildUpon()
                .appendQueryParameter("fName", F_NAMES.getBook.name())
                .appendQueryParameter("surname", _surname.isEmpty() ? "" : _surname)
                .appendQueryParameter("name", _name.isEmpty() ? "" : _name)
                .appendQueryParameter("title", _title.isEmpty() ? "" : _title)
                .build().toString();

        // Fetch book list
        try {
            jsonBookList = new BiblioValeDataFetcher().execute(urlString).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return jsonBookList;
    }

    public static String getAllGenres(){
        String jsonGenresList = "";

        // Preparazione url per chiamata REST
        String urlString = Uri.parse(URL).buildUpon()
                .appendQueryParameter("fName", F_NAMES.getAllGenres.name())
                .build().toString();

        // Fetch lista completa generi
        try {
            jsonGenresList = new BiblioValeDataFetcher().execute(urlString).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return jsonGenresList;
    }

    public static int getGenreID(String _genreName){
        String genreID = "";

        // Preparazione url per chiamata REST
        String urlString = Uri.parse(URL).buildUpon()
                .appendQueryParameter("fName", F_NAMES.getGenreID.name())
                .appendQueryParameter("genName", _genreName.isEmpty() ? "" : _genreName)
                .build().toString();

        // Fetch lista completa generi
        try {
            genreID = new BiblioValeDataFetcher().execute(urlString).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (TextUtils.isEmpty(genreID))
            return -1;
        else {
            return Integer.parseInt(genreID);
        }
    }

    public static String getAllAuthors(){
        String jsonAuthorsList = "";

        // Preparazione url per chiamata REST
        String urlString = Uri.parse(URL).buildUpon()
                .appendQueryParameter("fName", F_NAMES.getAllAuthors.name())
                .build().toString();

        // Fetch lista completa generi
        try {
            jsonAuthorsList = new BiblioValeDataFetcher().execute(urlString).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return jsonAuthorsList;
    }

    public static String getAuthors(String _name, String _surname){
        String jsonAuthorsList = "";

        // Preparazione url per chiamata REST
        String urlString = Uri.parse(URL).buildUpon()
                .appendQueryParameter("fName", F_NAMES.getAuthors.name())
                .appendQueryParameter("name", _name.isEmpty() ? "" : _name)
                .appendQueryParameter("surname", _surname.isEmpty() ? "" : _surname)
                .build().toString();

        // Fetch lista completa generi
        try {
            jsonAuthorsList = new BiblioValeDataFetcher().execute(urlString).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return jsonAuthorsList;
    }

    public static String updateBook(Book book){
        String jsonResponse = "";

        // Preparazione url per chiamata REST
        String urlString = Uri.parse(URL).buildUpon()
                .appendQueryParameter("fName", F_NAMES.updateBook.name())
                .appendQueryParameter("id", String.valueOf(book.getId()))
                .appendQueryParameter("title", book.getTitle().isEmpty() ? "" : book.getTitle())
                .appendQueryParameter("genre", book.getGenre().getName().isEmpty() ? "" : book.getGenre().getName())
                .appendQueryParameter("surname", book.getAuthors().get(0).getSurname().isEmpty() ? "" : book.getAuthors().get(0).getSurname())
                .appendQueryParameter("name", book.getAuthors().get(0).getName().isEmpty() ? "" :  book.getAuthors().get(0).getName())
                .appendQueryParameter("year", book.getYear().isEmpty() ? "" : book.getYear())
                .appendQueryParameter("status", book.getStatus().isEmpty() ? "" : book.getStatus())
                //.appendQueryParameter("liking", _name.isEmpty() ? "" : _name)
                .appendQueryParameter("isbn_10", book.getIsbn10().isEmpty() ? "" : book.getIsbn10())
                .appendQueryParameter("isbn_13", book.getIsbn13().isEmpty() ? "" : book.getIsbn13())
                .appendQueryParameter("notes", book.getNotes().isEmpty() ? "" : book.getNotes())
                .build().toString();

        // Fetch lista completa generi
        try {
            jsonResponse = new BiblioValeDataFetcher().execute(urlString).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return jsonResponse;
    }

    public static String createAuthor(String _surname, String _name){
        String jsonResponse = "";

        // Preparazione url per chiamata REST
        String urlString = Uri.parse(URL).buildUpon()
                .appendQueryParameter("fName", F_NAMES.createAuthor.name())
                .appendQueryParameter("surname", _surname.isEmpty() ? "" : _surname)
                .appendQueryParameter("name", _name.isEmpty() ? "" : _name)
                .build().toString();

        // Fetch lista completa generi
        try {
            jsonResponse = new BiblioValeDataFetcher().execute(urlString).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return jsonResponse;
    }

    public static String createBook(Book book){
        String jsonResponse = "";

        // Preparazione url per chiamata REST
        String urlString = Uri.parse(URL).buildUpon()
                .appendQueryParameter("fName", F_NAMES.createBook.name())
                .appendQueryParameter("title", book.getTitle().isEmpty() ? "" : book.getTitle())
                .appendQueryParameter("genre", book.getGenre().getName().isEmpty() ? "" : book.getGenre().getName())
                .appendQueryParameter("surname", book.getAuthors().get(0).getSurname().isEmpty() ? "" : book.getAuthors().get(0).getSurname())
                .appendQueryParameter("name", book.getAuthors().get(0).getName().isEmpty() ? "" :  book.getAuthors().get(0).getName())
                .appendQueryParameter("year", book.getYear().isEmpty() ? "" : book.getYear())
                .appendQueryParameter("status", book.getStatus().isEmpty() ? "" : book.getStatus())
                //.appendQueryParameter("liking", _name.isEmpty() ? "" : _name)
                .appendQueryParameter("isbn_10", book.getIsbn10().isEmpty() ? "" : book.getIsbn10())
                .appendQueryParameter("isbn_13", book.getIsbn13().isEmpty() ? "" : book.getIsbn13())
                .appendQueryParameter("notes", book.getNotes().isEmpty() ? "" : book.getNotes())
                .build().toString();

        // Fetch lista completa generi
        try {
            jsonResponse = new BiblioValeDataFetcher().execute(urlString).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return jsonResponse;
    }
}
