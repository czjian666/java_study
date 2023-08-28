package doudizhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Room {
    private List<Card> allCard = new ArrayList<>();
    public Room(){
        String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        String[] colors = {"黑桃","红桃","梅花","方片"};
        int size = 0;

        for (String number : numbers) {
            size++;
            for (String color : colors) {
                Card c = new Card(number,color,size);
                allCard.add(c);
            }

        }
        Card c1 = new Card("","小王",++size);
        Card c2 = new Card("","大王",++size);
        Collections.addAll(allCard,c1,c2);
        System.out.println("新牌"+allCard);
    }

    public void start() {
        //1 洗牌
        Collections.shuffle(allCard);
        System.out.println( "洗牌后"+ allCard);
        List <Card> linhuchong = new ArrayList<>();
        List<Card> jiumozhi = new ArrayList<>();
        List<Card> renyingying = new ArrayList<>();

        for (int i = 0; i <allCard.size()-3; i++) {
            Card c = allCard.get(i);
            if (i %3== 0) {
                linhuchong.add(c);
            }else if(i%3==1){
                jiumozhi.add(c);
            } else if (i%3==2) {
                renyingying.add(c);
            }

        }
        sortCard(linhuchong);
        sortCard(jiumozhi);
        sortCard(renyingying);
        System.out.println("lihuchong"+linhuchong);
        System.out.println("jiumozhi"+jiumozhi);
        System.out.println("renyingying"+renyingying);
        List<Card> lastthreeCards = allCard.subList(allCard.size() - 3,allCard.size());
        System.out.println("底牌："+ lastthreeCards);
        jiumozhi.addAll(lastthreeCards);
        sortCard(jiumozhi);
        System.out.println("jiumozhi是地主"+jiumozhi);
    }

    private void sortCard(List<Card> cards) {

        Collections.sort(cards, (o1, o2) -> o1.getSize() - o2.getSize());
    }


}
