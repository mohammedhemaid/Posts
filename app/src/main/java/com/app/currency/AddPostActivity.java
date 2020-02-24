package com.app.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPostActivity extends AppCompatActivity {
    EditText titleEditText;
    EditText descrptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_post);
        titleEditText = findViewById(R.id.editText);
        descrptionEditText = findViewById(R.id.editText2);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postOnApi(titleEditText.getText().toString(), descrptionEditText.getText().toString());
            }
        });
    }

    private void postOnApi(String title, String des) {
        App.apiRequest.Post(1500, 1500, title, des).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(AddPostActivity.this, " response.body().getTitle()" + response.body().getTitle(), Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK);
                } else {
                    Toast.makeText(AddPostActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_CANCELED);
                }
                finish();
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });

    }


}
