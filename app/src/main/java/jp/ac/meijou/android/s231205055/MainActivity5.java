package jp.ac.meijou.android.s231205055;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import jp.ac.meijou.android.s231205055.databinding.ActivityMain5Binding;
import jp.ac.meijou.android.s231205055.databinding.ActivityMainBinding;

public class MainActivity5 extends AppCompatActivity {

    private ActivityMain5Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain5Binding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.moveButton.setOnClickListener(view -> {
            var intent = new Intent(this, MainActivity4.class);
            intent.putExtra("text", "かきくけこ");
            startActivity(intent);
        } );
    }
}