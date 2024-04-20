package uniconteam.bakerymanager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import uniconteam.bakerymanager.databinding.AuthBinding;

public class AuthActivity extends AppCompatActivity {
	
    private AuthBinding binding;
    
    private Intent intent = new Intent();
    
    int choosenAccount = 2;
    int choosenAuth = 2;
      
    void selectedAccountVariant(int choosenAccount){
        if(choosenAccount == 1){
                binding.employee.setBackgroundResource(R.drawable.selectedbox);
                binding.user.setBackgroundResource(R.drawable.blueboxes);
                binding.uidField.setVisibility(View.VISIBLE);
        } else {
                binding.employee.setBackgroundResource(R.drawable.blueboxes);
                binding.user.setBackgroundResource(R.drawable.selectedbox);
                binding.uidField.setVisibility(View.GONE);
        }
    }
    
    void selectedAuthVariant(int choosenAuth){
        if(choosenAuth == 1){
                binding.register.setBackgroundResource(R.drawable.selectedbox);
                binding.login.setBackgroundResource(R.drawable.blueboxes);
                binding.fullnameField.setVisibility(View.VISIBLE);
        } else {
                binding.register.setBackgroundResource(R.drawable.blueboxes);
                binding.login.setBackgroundResource(R.drawable.selectedbox);
                binding.fullnameField.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		    binding = AuthBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, 
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        
            selectedAccountVariant(choosenAccount);
            selectedAuthVariant(choosenAuth);
            binding.employee.setOnClickListener(v ->
            {
                choosenAccount = 1;
                selectedAccountVariant(choosenAccount);
            });
            binding.user.setOnClickListener(v ->
            {
                choosenAccount = 2;
                selectedAccountVariant(choosenAccount);
            });
            binding.register.setOnClickListener(v ->
            {
                choosenAuth = 1;
                selectedAuthVariant(choosenAuth);
            });
            binding.login.setOnClickListener(v ->
            {
                choosenAuth = 2;
                selectedAuthVariant(choosenAuth);
            });
        binding.enter.setOnClickListener(
                v -> {
                    if (choosenAccount == 2) {
                        intent.setClass(getApplicationContext(), MenuActivity.class);
                        startActivity(intent);
                    } else {
                        intent.setClass(getApplicationContext(), EmployeeActivity.class);
                        startActivity(intent);
                    }
                });
		    /* binding.fab.setOnClickListener(v ->
          Toast.makeText(AuthActivity.this, "Replace with your action", Toast.LENGTH_SHORT).show()
        ); */
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }
}