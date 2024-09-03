package jp.ac.meijou.android.s231205055;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import jp.ac.meijou.android.s231205055.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PrefDataStore prefDataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        prefDataStore = PrefDataStore.getInstance(this);
        /*
        prefDataStore.getString("name")
                        .ifPresent(name -> binding.text.setText(name));

         */

        binding.button.setOnClickListener(view -> {
            // binding.text.setText(R.string.text); テキストのテスト
            // binding.text.setTextScaleX(6.0f);    横幅を6倍する
            var text = binding.editTextText.getText().toString();   // textFieldのtextを取得
            binding.text.setText(text); // textFieldのtextに変更
        });


        binding.saveButton.setOnClickListener(view -> {
            var text = binding.editTextText.getText().toString();
            prefDataStore.setString("name", text);
        });

        // binding.text.setText(R.string.text);

        EdgeToEdge.enable(this);
        // カメラの画像をファイルから取得
        var cameraImage = ContextCompat.getDrawable(this, R.drawable.baseline_add_a_photo_24);
        // imageView2に画像を代入
        // binding.imageView2.setImageDrawable(cameraImage);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.editTextText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // テキストが更新される直前
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 文字を1つ入力された時に呼ばれる
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // テキストが更新された後に呼ばれる
                binding.text.setText(editable.toString());
            }
        });
    }

    protected void onStart(){
        super.onStart();
        prefDataStore.getString("name")
                .ifPresent(name->binding.text.setText(name));
    }
}