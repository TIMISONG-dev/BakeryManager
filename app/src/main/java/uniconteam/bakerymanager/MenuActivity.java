package uniconteam.bakerymanager;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import uniconteam.bakerymanager.databinding.MenuBinding;
import uniconteam.bakerymanager.databinding.BottomsheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MenuActivity extends AppCompatActivity {
    
    private MenuBinding binding;
    String name;
    String desc;
    String cost;
    String desc1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        binding.box1.setElevation(3f);
        binding.box2.setElevation(3f);
        binding.box3.setElevation(3f);
        binding.box4.setElevation(3f);

        binding.box1.setOnClickListener(v -> {
                name = binding.name1.getText().toString();
                cost = binding.cost1.getText().toString();
                desc = "Вкусный хлебушек. Попробуйте его пожалуйста";
                desc1 = "Состав: мука пшеничная высший сорт, молоко, соль, сахар, дрожжи";
                showBottomSheet(name, cost, binding.icon1, desc, desc1);
        });
        binding.box2.setOnClickListener(v -> {
                name = binding.name2.getText().toString();
                cost = binding.cost2.getText().toString();
                desc = "Самый вкусный БАГГЕТИЩЕ на свете. Попробуйте срочно!";
                desc1 = "Состав: мука пшеничная высший сорт, вода, соль, высушенная пшеничная закваска, аскорбиновая кислота, ферменты, солод ржаной неферментированный, дрожжи хлебопекарные";
                showBottomSheet(name, cost, binding.icon2, desc, desc1);
        });
        binding.box3.setOnClickListener(v -> {
                name = binding.name3.getText().toString();
                cost = binding.cost3.getText().toString();
                desc = "Для любителей изысканного хлебушка";
                desc1 = "Состав: мука пшеничная хлебопекарная второго сорта, мука ржаная хлебопекарная обдирная, вода, соль поваренная пищевая, дрожжи хлебопекарные";
                showBottomSheet(name, cost, binding.icon3, desc, desc1);
        });
        binding.box4.setOnClickListener(v -> {
                name = binding.name4.getText().toString();
                cost = binding.cost4.getText().toString();
                desc = "Тем кто скучает по домашней еде";
                desc1 = "Состав: мука ржаная, вода, соль, закваска";
                showBottomSheet(name, cost, binding.icon4, desc, desc1);
        });
    }

    private void showBottomSheet(String name, String cost, ImageView photo, String desc, String desc1) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottomsheet, null);
        bottomSheetDialog.setContentView(bottomSheetView);
        
        TextView nameProduct = bottomSheetView.findViewById(R.id.name);
        TextView costProduct = bottomSheetView.findViewById(R.id.cost);
        ImageView iconProduct = bottomSheetView.findViewById(R.id.icon);
        TextView descProduct = bottomSheetView.findViewById(R.id.desc);
        TextView desc1Product = bottomSheetView.findViewById(R.id.desc1);
        MaterialButton mbutton = bottomSheetView.findViewById(R.id.buy);
        
        nameProduct.setText(name);
        costProduct.setText(cost);
        iconProduct.setImageDrawable(photo.getDrawable());
        descProduct.setText(desc);
        desc1Product.setText(desc1);
        
        mbutton.setOnClickListener(v ->{
            bottomSheetDialog.dismiss();
        });
        
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheetView.getParent());
        bottomSheetBehavior.setPeekHeight(getResources().getDisplayMetrics().heightPixels / 1);
        bottomSheetBehavior.setDraggable(true); // Разрешаем перетаскивание
        
        bottomSheetDialog.show();
    }
}

