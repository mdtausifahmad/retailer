package com.tausif;

import java.util.List;

public interface Promotion {
    public boolean isActive();
    public double applyPromotion(List<Item> items, double totalPurchaseAmount);
}
