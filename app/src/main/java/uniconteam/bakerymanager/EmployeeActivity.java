package uniconteam.bakerymanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.appcompat.app.AppCompatActivity;
import uniconteam.bakerymanager.databinding.EmployeeBinding;

public class EmployeeActivity extends AppCompatActivity {
    
    private EmployeeBinding binding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = EmployeeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
