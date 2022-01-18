package com.tausif;

public class Main {

    public static void main(String[] args) {

        Item a = new Item("1011-005","Tote Bag",8950);
        Item b = new Item("2010-001","Belt",990);
        Item c = new Item("3000-002","KeyChain",95);

        PromotionalRules promotionalRules = new PromotionalRules();
        promotionalRules.addPromotions(new PromotionOnQuantityOfItem());
        promotionalRules.addPromotions(new PromotionOnTotalPurchaseAmount());

        CheckOut checkOut = new CheckOut(promotionalRules);

        checkOut.addToBasket(a);
        checkOut.addToBasket(c);
        checkOut.addToBasket(b);
        checkOut.addToBasket(c);

        System.out.println(checkOut.total());

        /**
         * 95+990+95
         * = 0
         */


    }
}
