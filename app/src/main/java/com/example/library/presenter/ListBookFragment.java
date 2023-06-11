package com.example.library.presenter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.library.api.ApiService;
import com.example.library.databinding.FragmentListBookBinding;
import com.example.library.models.BookModel;
import com.example.library.network.HttpClient;
import com.example.library.viewmodels.ListBookViewModel;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListBookFragment extends Fragment {

    private FragmentListBookBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ListBookViewModel listBookViewModel =
                new ViewModelProvider(this).get(ListBookViewModel.class);

        binding = FragmentListBookBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textListBook;
        listBookViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);


        ApiService apiService = HttpClient.getApiService();
        int bookId = 15; // Puedes cambiar el valor según tu lógica

        // Realizar la llamada al endpoint GET /api/v1/books/{id}
        Call<BookModel> call = apiService.getBookById(bookId);

        Log.d("ListBookFragmente", "ID: " + call);
        call.enqueue(new Callback<BookModel>() {
            @Override
            public void onResponse(Call<BookModel> call, Response<BookModel> response) {
                if (response.isSuccessful()) {
                    // Obtener el libro del cuerpo de la respuesta
                    BookModel book = response.body();
                    Gson gson = new Gson();
                    String bookJson = gson.toJson(book.getId());

                    Log.d("ListBookFragment2", "ID: " +  bookJson);
                    // Actualizar el texto del TextView con los datos del libro
//                    textView.setText(book.getTitle());
                } else {
                    // Mostrar algún mensaje de error en caso de respuesta no exitosa
//                    textView.setText("Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<BookModel> call, Throwable t) {
                // Mostrar algún mensaje de error en caso de fallo de la llamada
//                textView.setText("Error: " + t.getMessage());

                Log.d("ListBookFragment3", "ID: " + t.getMessage());
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
