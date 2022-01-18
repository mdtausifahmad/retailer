package com.tausif;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CheckOut {

    private PromotionalRules promotionalRules;

    public CheckOut(PromotionalRules promotionalRules) {
        this.promotionalRules = promotionalRules;
    }

    private List<Item> items = new ArrayList<>();
    private double total;

    public List<Item> addToBasket(Item item){
        items.add(item);
        return items;
    }

    public List<Item> getItems() {
        return items;
    }

    public double total(){
        double totalPurchase = items.stream()
                .mapToDouble(Item::getPrice)
                .sum();
        if (promotionalRules.getPromotions().isEmpty())
            return totalPurchase;

        return applyPromotion(totalPurchase);
    }

    private double applyPromotion(double totalPurchase){
        for (Promotion promotion: this.promotionalRules.getPromotions()) {
            if (promotion.isActive()){
                totalPurchase = promotion.applyPromotion(items,totalPurchase);
            }
        }
        return roundToHalf(totalPurchase);
    }

    public  double roundToHalf(double d) {
        return Math.round(d * 2) / 2.0;
    }

}
