package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ChinaCuisines extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CuisineAdapter adapter;
    private List<Cuisine> cuisines = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_china_cuisines);
        recyclerView = findViewById(R.id.recyclerViewCuisines);
        initializeRecyclerView();

        cuisines.add(new Cuisine(R.drawable.chinacuisine1, "Peking Roasted Duck", "Peking duck (北京烤鸭 Běijīng kǎoyā) is a famous dish from Beijing, enjoying world fame, and considered as one of China national dishes. Peking duck is savored for its thin and crispy skin. Sliced Peking duck is often eaten with pancakes, sweet bean sauce, or soy sauce with mashed garlic. It is a must-taste dish in Beijing! As “the first dish to taste in China”, Beijing Roast Duck used to be a royal dish in medieval China. It has been a “national dish of diplomacy” since the 1970s, when it was first used for the reception of foreign guests by Premier Zhou Enlai (the first Premier of the People's Republic of China). It is highly praised by heads of state, government officials, and domestic and foreign tourists."));
        cuisines.add(new Cuisine(R.drawable.chinacuisine2, "Kung Pao Chicken", "Kung Pao Chicken (宫保鸡丁 gōngbào jīdīng) is a famous Sichuan-style specialty, popular with both Chinese and foreigners. The major ingredients are diced chicken, dried chili, cucumber, and fried peanuts (or cashews). People (Chinese takeaways) in Western countries have created a Western-style kung pao chicken, for which the diced chicken is covered with cornstarch, and vegetables, sweet and sour sauce, and mashed garlic are added. See How to Cook Kung Pao Chicken for a classic recipe and its history."));
        cuisines.add(new Cuisine(R.drawable.chinacuisine3, "Sweet and Sour Pork", "Sweet and sour pork (糖醋里脊 tángcù lǐjǐ) has a bright orange-red color, and a delicious sweet and sour taste. At the very beginning there was only sweet and sour pork, but to meet demands, there have been some developments on this dish. Now, the pork can be substituted with other ingredients like chicken, beef, or pork ribs."));
        cuisines.add(new Cuisine(R.drawable.chinacuisine4, "Hot Pot", "Hot pot, or hotpot (火锅 huǒguō), is one of the most popular dishes in China, especially in Sichuan Province or Chongqing. People cook in and eat from a simmering pot of soup stock (broth) on a gas/induction hob in the middle of the dining table with foodstuffs and condiments around the pot. People can add and cook whatever they like in the broth. The secret of whether a hot pot is good or not lies in the broth, which all the meat slices and vegetables take their flavor from. Chinese people are very fond of hot pot. In the past hot pot used to be favored only in winter, but nowadays hot pot has been appearing on tables all year round. It is a great way to socialize with friends and relatives. People gather around the pot to eat while chatting, eating, drinking, and having fun."));
        cuisines.add(new Cuisine(R.drawable.chinacuisine5, "Dim Sum", "Dim sum (点心 diǎnxin) is one of the most popular Cantonese cuisine dishes. It contains a large range of small dishes, including dumplings, rolls, cakes, and meat, seafood, dessert, and vegetable preparations. There are more than one thousand dim sum dishes in existence today. Dim sum originated in Guangzhou city. People of Guangdong are fond of drinking tea in the morning or lunch. So, they often eat dim sum during their tea parties for breakfast and lunch. It is a popular way to get together with friends and relatives or have social gatherings. Read more about Dim sum."));
        cuisines.add(new Cuisine(R.drawable.chinacuisine6, "Dumplings", "Dumplings (饺子 jiǎozi) are a traditional food type that is widely popular, especially in North China. Chinese dumplings consist of minced meat and/or chopped vegetables wrapped in a thin dough skin. Popular fillings are minced pork, diced shrimp, ground chicken, beef, and vegetables. Dumplings can be cooked by boiling, steaming, or frying. Dumplings are also a traditional dish eaten on Chinese New Year’s Eve. As they look like Chinese silver ingots (Chinese money in old times), it is believed that the more dumplings you eat during the New Year celebrations, the more money you will make in the New Year. Making dumplings is a good way to interact with your friends and relatives. You will see a busy kitchens with Chinese families making dumplings during Chinese New Year. Read more abou Dumpli"));

        adapter = new CuisineAdapter(cuisines, this);
        recyclerView.setAdapter(adapter);
    }

    private void initializeRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}