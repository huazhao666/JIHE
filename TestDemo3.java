import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-02
 * Time : 18:33
 */
class Card {
    public int rank; // 牌面值
     public String suit; // 花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit='" + suit + '\'' +
                '}';
    }
}
class CardDmeo{
    public String[] suits = {"♥","♦", "♣","♠"};//五十二张牌；
    public List<Card> buyDeck() {
    List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= 13 ; j++) {
                int rank = j;
                String suit = suits[i];
                Card card = new Card(rank,suit);
                cards.add(card);
            }
        }
        return cards;
    }

    public void swap(List<Card> cards,int i ,int j){ //交换两张牌的位置
        Card tmp = cards.get(i);
        Card card = cards.get(j);
        cards.set(i,card);
        cards.set(j,tmp);
    }
    public void shuffle(List<Card> cards){ //洗牌
        Random random = new Random();
        int size = cards.size();
        for (int i = size-1; i >0; i--) {
            int j = random.nextInt(i);
            swap(cards,i,j);
        }
    }
}
public class TestDemo3{
    public static void main (String[] args){
        CardDmeo cardDmeo = new CardDmeo();
        List<Card> cardList  = cardDmeo.buyDeck();
        System.out.println(cardList);
        cardDmeo.shuffle(cardList);
        System.out.println(cardList);
        List<List<Card>>hands = new ArrayList<>();
        List<Card> hands1 = new ArrayList<>();
        List<Card> hands2 = new ArrayList<>();
        List<Card> hands3 = new ArrayList<>();
        hands.add(hands1);
        hands.add(hands2);
        hands.add(hands3);
        //三个人开始抓牌，一个人一张，轮流抓五次；
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card cardTmp = cardList.remove(0);
                hands.get(j).add(cardTmp);
            }
        }
        System.out.println("第一个人" + hands1);
        System.out.println("第二个人" + hands2);
        System.out.println("第三个人" + hands3);
        System.out.println("剩余的牌");
        System.out.println(cardList);
    }
}