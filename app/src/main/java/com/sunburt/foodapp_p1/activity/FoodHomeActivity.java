package com.sunburt.foodapp_p1.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sunburt.foodapp_p1.R;
import com.sunburt.foodapp_p1.adapter.DrinkHomeAdapter;
import com.sunburt.foodapp_p1.adapter.FoodHomeAdapter;
import com.sunburt.foodapp_p1.database.DBHelper;
import com.sunburt.foodapp_p1.model.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodHomeActivity extends AppCompatActivity {

    private RecyclerView revFood;
    private BottomNavigationView btmNavigationFood;
    private List<Food> foods = new ArrayList<>();
    private DBHelper db;
    private FoodHomeAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_home);

        getControls();

        // display all food
        foods = db.getAllFood();
        adapter = new FoodHomeAdapter(FoodHomeActivity.this, foods);
        revFood.setAdapter(adapter);
        revFood.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //addData();

        btmNavigationFood.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_food:
                        Intent intent1 = new Intent(getApplicationContext(), FoodHomeActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_cart:
                        Intent intent2 = new Intent(getApplicationContext(), CartActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_drink:
                        Intent intent3 = new Intent(getApplicationContext(), DrinkHomeActivity.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });

        adapter.OnRecyclerFoodClickListener(new FoodHomeAdapter.OnRecyclerFoodClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getApplicationContext(), DetailFoodActivity.class);
                if (foods.get(position) != null && foods.size() != 0){
                    intent.putExtra("Food", foods.get(position));
                }
                startActivity(intent);
            }
        });
    }

    private void addData() {

        boolean checkAdd1 = db.addNewFood("KimChi", R.drawable.img_kimchi1, "Korea",
                "Mon an quen thuoc voi nguoi dan han quoc, duoc dong dao nguoi dan tren " +
                        "the gioi biet den", 1);

        boolean checkAdd2 = db.addNewFood("B??n b?? Hu???", R.drawable.food_bun, "VietNam",
                "M???t trong nh???ng m??n ??n kh??ng th??? thi???u c???a ng?????i Vi???t, ???????c ????ng ?????o," +
                        "kh??ch tham quan y??u th??ch", 2);

        boolean checkAdd3 = db.addNewFood("Seafood paella", R.drawable.food_seafoodpaela,
                "Spain", "One mouthful of a steamy bowl of paella and you'll be on a beach in Spain" +
                        "", 3);

        boolean checkAdd4 = db.addNewFood("Pizza", R.drawable.food_pizza, "Italia",
                "One of the most favourite food in the world, the most popular food",
                5);

        boolean checkAdd5 = db.addNewFood("KFC", R.drawable.food_kfc, "America",
                "One of the most favourite fast food in the world", 2);

        boolean checkAdd6 = db.addNewFood("?????u ph??? th???i", R.drawable.food_dauphu, "Trung" +
                "Qu???c", "M???t m??n ??n ?????c tr??ng c???a ng?????i Trung Qu???c, ?????c s???n ??m th???c y??u" +
                "th??ch c???a n?????c n??y", 1);

        boolean checkAdd7 = db.addNewFood("Sushi", R.drawable.food_sushi, "Japan",
                "A great food from japan consisting of cooked rice flavoured with vinegar and a variety of vegetable" +
                        ", egg, or raw seafood garnishes and served cold", 10);

        boolean checkAdd8 = db.addNewFood("C??m rang d??a b??", R.drawable.food_comrang, "Vi???t Nam",
                "M??n ??n quen thu???c c???a ng?????i Vi???t Nam, th??nh ph???n ch??nh l?? c??m ???? n???u s???n " +
                        "v?? d??a chua c??ng th???t b??", 2);

        boolean checkAdd9 = db.addNewFood("Tacos", R.drawable.food_tacos, "Mexico",
                "Tacos are a chief component of Mexican cuisine rolled-up tortillas stuffed with sizzling chunks of meat or vegetables"
                        , 3);

        boolean checkAdd10 = db.addNewFood("Fish 'n' chips", R.drawable.food_chips, "United Kingdom",
                "One of Britain's favorite dishes dates back to the 1860s. A Friday dinnertime special across the UK",
                2);

        boolean checkAdd11 = db.addNewFood("B??nh m???", R.drawable.food_banhmy, "Vi???t Nam",
                "M??n ??n nh??? n???i ti???ng nh???t Vi???t Nam, c?? th??? ??n k??m v???i r???t nhi???u c??c lo???i" +
                        "gia v??? ho???c rau kh??c nhau", 1);

        boolean checkAdd12 = db.addNewFood("Hamburger", R.drawable.food_hamburger, "Germany",
                "This juicy amalgamation of meaty from the fast food edition to the ever-growing number of gourmet burger joints",
                2);

    }

    private void getControls() {
        revFood = findViewById(R.id.revFood);
        btmNavigationFood = findViewById(R.id.btm_nav_food);
        db = new DBHelper(this);
    }
}