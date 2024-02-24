package model.store.prize;

import model.store.Goods;
import model.store.ToyStore;
import model.store.Toys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PrizeDraw implements Serializable {
    private List<Goods> prizeList;
    private List<Goods> goodsList;
    private int significance;

    public PrizeDraw(List<Goods> goodsList){
        this.goodsList = goodsList;
        prizeList = new ArrayList<>();
    }

    /**
     * Генерируем случайный вес игрушки с вероятностью:
     * 1 - 14,3%
     * 2 - 28,6%
     * 3 - 57,1%
     */
    private Integer setSignificance(int start, int end){

        int number = new Random().nextInt(start, end);
        if (number == 1) {
            return 1;
        }
         if (number > 1 && number < 4){

            return 2;
        } else {
            return 3;
            }
            
        }
    

    /**
     * Проверяем есть ли игрушки для розыгыша
     */
    private boolean areAvailable(){
        int sum = 0;
        for (Goods toys : goodsList){
            sum += toys.getQuantity();
        }
        return sum != 0;

    }

    /**
     * проверяем можем ли мы выдать конкретную игрушку
     */
    private boolean areAvailableToy(){
        int start = 1;
        int end = 8;

        for(Goods goods : goodsList){
            if (goods.getSignificance() == 3){
                if (!quantityNull(goods)){
                    end = 4;
                }
            } else if (goods.getSignificance() == 1){
                if (!quantityNull(goods)){
                    start = 2;
                }
            }

        }


        significance = setSignificance(start, end);


        for (Goods toys : goodsList){
            if (toys.getSignificance() == significance){
                if (quantityNull(toys)){
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    private Goods getToysOfSignificance(){
        for (Goods toys : goodsList){
            if (toys.getSignificance() == significance){
                return toys;
            }
        }
        return null;
    }


    public String conductingTheDraw(){
        if (areAvailable()){
            if (areAvailableToy()){
                Toys toys = new Toys(getToysOfSignificance().getId(),
                        getToysOfSignificance().getName(),
                        getToysOfSignificance().getSignificance(),
                        getToysOfSignificance().getPrice(),
                        1
                        );
                if(prizeList.isEmpty()){
                    prizeList.add(toys);
                    getToysOfSignificance().setQuantity(getToysOfSignificance().getQuantity() - 1);
                    return getToysOfSignificance().getName();
                } else {
                    for (int i = 0; i < prizeList.size(); i++) {
                        if(prizeList.get(i).getId() == getToysOfSignificance().getId()){
                            int quantity = prizeList.get(i).getQuantity();
                            prizeList.get(i).setQuantity(++quantity);
                            getToysOfSignificance().setQuantity(getToysOfSignificance().getQuantity() - 1);
                            return getToysOfSignificance().getName();
                        }
                    }
                    prizeList.add(toys);
                    getToysOfSignificance().setQuantity(getToysOfSignificance().getQuantity() - 1);
                    return getToysOfSignificance().getName();
                }
            } else {
                conductingTheDraw();
            }

        }
        return null;
    }


    private boolean quantityNull (Goods toys){
        return toys.getQuantity() != 0;
    }

    public String getPrizeList() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Вы выиграли: ").append("\n");
        for (Goods goods : prizeList){
            stringBuilder.append(goods).append("\n");
        }
        return stringBuilder.toString();
    }

//    public List<Goods> retPrizeList(){
//        return prizeList;
//    }
//
//    public void setPrizeList(List<Goods> prizeList){
//        this.prizeList = prizeList;
//    }


}
