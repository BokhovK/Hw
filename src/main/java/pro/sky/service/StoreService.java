package pro.sky.service;

import org.springframework.stereotype.Service;
import pro.sky.component.Basket;
import pro.sky.model.Item;
import pro.sky.component.ItemStore;

import java.util.List;

@Service
public class StoreService {
    private final ItemStore itemStore;
    private final Basket basket;

    public StoreService(ItemStore itemStore,
                        Basket basket) {
        this.itemStore = itemStore;
        this.basket = basket;
    }
    public void add(List<Integer> ids){
     basket.add(ids.stream().map(itemStore::get).toList());
    }
    public List<Item> get() {
        return basket.get();
    }
}
