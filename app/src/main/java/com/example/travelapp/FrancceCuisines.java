package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FrancceCuisines extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CuisineAdapter adapter;
    private List<Cuisine> cuisines = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_francce_cuisines);
        recyclerView = findViewById(R.id.recyclerViewCuisines);
        initializeRecyclerView();

        cuisines.add(new Cuisine(R.drawable.francecuisine1, "Bœuf bourguignon", "Dishes don’t get much more typically French than bœuf bourguignon. The dish hails from the same region as coq au vin – that’s Burgundy in eastern France – and there are similarities between the two dishes. Bœuf bourguignon is essentially a stew made from beef braised in red wine, beef broth, and seasoned vegetables including pearl onions and mushrooms. Originally a peasant dish, this recipe is now a staple in French restaurants around the world. Traditionally, the cheap cuts of meat would be tenderized in wine for two days to intensify the flavors, although some shortcuts can be taken. Every August in Burgundy, the Fête du Charolais celebrates the dish, along with plenty of music "));
        cuisines.add(new Cuisine(R.drawable.francecuisine2, "Cassoulet", "Cassoulet is a comfort dish of white beans stewed slowly with meat. The dish typically uses pork or duck but can include sausages, goose, mutton or whatever else the chef has lying around. This peasant dish originates from southern France and is popular in Toulouse, Carcassonne, and Castelnaudary. The name of the dish comes from the pot (cassole) that it’s traditionally baked in. This pot is a staple in many French homes, highlighting the popularity of this rich, hearty meal that’s perfect for those colder months."));
        cuisines.add(new Cuisine(R.drawable.francecuisine3, "Soupe à l’oignon", "This is a traditional French soup made of onions and beef stock, usually served with croutons and melted cheese on top. Dating back to Roman times, this was traditionally a peasant dish although the current version dates from the 18th century. The soup’s unique flavor comes from the caramelization of the onions, which often have brandy or sherry added during the slow-cooking process. If you’re in a soup mood, why not try Marseille’s traditional soupe de poisson à la rouille. Once a fisherman’s favorite, this soup is characterized by a dollop of garlic and saffron mayonnaise placed on top."));
        cuisines.add(new Cuisine(R.drawable.francecuisine4, "Flamiche", "Flamiche means ‘cake’ in Dutch and this dish originates from northern France, near the border with Belgium. It has a puff-pastry crust filled with cheese and vegetables and resembles a quiche. The traditional filling is leeks and cream, although various variations exist. There’s also a pizza-like version of flamiche, which comes without the top crust of the pie. For a southern French twist, try the thin crusty pissaladière, which has anchovies, onions, and olives."));
        cuisines.add(new Cuisine(R.drawable.francecuisine5, "Coq au vin", "This quintessential French food was popularized by Julia Child, becoming one of her signature dishes. The dish sees chicken braised with wine, mushrooms, salty pork or bacon (lardons), mushrooms, onions, garlic and sometimes even a drop of brandy. Although the name translates as ‘rooster in wine’ – the braising is ideal for tougher birds – the recipe usually uses chicken or capon. The wine is typically Burgundy, although regional variations of the dish exist across France that use local wines. These include coq au vin jaune (Jura), coq au Riesling (Alsace), and coq au pourpre (Beaujolais nouveau). Believe it or not, there’s even a coq au Champagne (Champagne)."));

        adapter = new CuisineAdapter(cuisines, this);
        recyclerView.setAdapter(adapter);
    }

    private void initializeRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}