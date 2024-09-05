package jp.ac.meijou.android.s231205055;

import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

import jp.ac.meijou.android.s231205055.databinding.ActivityMain6Binding;
import jp.ac.meijou.android.s231205055.databinding.ActivityMain7Binding;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity7 extends AppCompatActivity {

    private ActivityMain7Binding binding;
    private final OkHttpClient okHttpClient = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain7Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main7);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        var request = new Request.Builder().url("https://placehold.jp/350×350.png").build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                var bitmap = BitmapFactory.decodeStream(response.body().byteStream());
                runOnUiThread(() -> binding.imageViewA.setImageBitmap(bitmap));
            }
        });
    }
}