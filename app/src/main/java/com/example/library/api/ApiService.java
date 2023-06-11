package com.example.library.api;

import com.example.library.models.BookModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("/api/v1/books/{id}")
    Call<BookModel> getBookById(@Path("id") int id);
}
