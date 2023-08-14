package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class JapanCuisines extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CuisineAdapter adapter;
    private List<Cuisine> cuisines = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japan_cuisines);
        recyclerView = findViewById(R.id.recyclerViewCuisines);
        initializeRecyclerView();

        cuisines.add(new Cuisine(R.drawable.japancuisine1, "Sushi", "Sushi is one of the best known Japanese foods around the world. It is offered in various ways and prices, from the entertaining kaiten-zushi (conveyor belt sushi), where visitors can enjoy sushi for a reasonable price of about 100 yen per plate, to high-end, long-established, traditional Edomae sushi (Edo-style sushi) where you will sit at a quiet counter to eat as the sushi is prepared right before your eyes. Sushi can be eaten with chopsticks or directly with your hand. However, there's one thing you should be careful about. When dipping the sushi in soy sauce, you should turn it over and apply the soy sauce to the neta, rather than the rice itself. This is to prevent the rice from sucking up too much soy sauce and erasing the original taste of the neta itself."));
        cuisines.add(new Cuisine(R.drawable.japancuisine2, "Unagi - Grilled Eel", "Unagi, or eel, is a fish known to be found mainly in rivers. In Japan, it is a delicacy typical in high-class Japanese dining. There are also many casual restaurants that specialize in unagi dishes. At unagi restaurants, you will be able to enjoy kabayaki, where the unagi is put on skewers and grilled with a special sauce containing soy sauce, mirin, sugar, and sake. Unadon, a dish of kabayaki on top of white rice, is also offered at these establishments."));
        cuisines.add(new Cuisine(R.drawable.japancuisine3, "Tempura", "Tempura is a dish involving ingredients like seafood, meat, and vegetables covered in batter and deep-fried in oil. The batter usually contains flour and egg. Tempura is generally dipped in a special sauce called tentsuyu before eating. Tentsuyu is a sauce made of broth from kombu or dried bonito, mirin, and soy sauce mixed at a ratio of 4:1:1 and cooked. You can add ginger or grated radish to your liking for a more refreshing taste."));
        cuisines.add(new Cuisine(R.drawable.japancuisine4, "Soba (Buckwheat Noodles)", "Soba is a noodle dish made from buckwheat flour with water and flour, thinly spread and cut into noodles with widths of 1cm-2cm. After boiling the noodles in hot water, it is eaten dipped in cold soup, or by pouring hot soup over it. The soba broth (tsuyu) is typically made from kombu or dried bonito broth, seasoned with soy sauce and mirin, and is crucial for having a delicious soba experience. Soba is enjoyed hot or cold, making it an ideal dish year-round."));
        cuisines.add(new Cuisine(R.drawable.japancuisine5, "Yakitori - Grilled Chicken Skewers", "Yakitori is a popular food where chicken is cut into small pieces, then placed on bamboo skewers and grilled. It is often found on the menus of izakaya and casual restaurants, making it a good option for a night out in Japan with friends. It is especially delicious when paired with alcohol. Also, if you go to a Japanese festival, there is a good chance that food stalls will be selling this classic dish. Yakitori is ordered at restaurants by the part of the chicken. You will also find other types of meat and vegetables on skewers, too. It is usually seasoned lightly with salt when it comes, so take the first bite without adding extra condiments. You can eat right off the skewer."));
        adapter = new CuisineAdapter(cuisines, this);
        recyclerView.setAdapter(adapter);
    }

    private void initializeRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
