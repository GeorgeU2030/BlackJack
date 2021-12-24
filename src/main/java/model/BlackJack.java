package model;
import java.util.ArrayList;
public class BlackJack{

private String[] cards;
private int[]num;
private double money=1000;
private int scorePlayer;
private int scoreCrupier;
private double moneyBet=1000;
private boolean flag = false;
private ArrayList<Double> bets;

public BlackJack(){
    cards = new String[52];
    num = new int[52];
    createCards();
    bets = new ArrayList<Double>();
}
public boolean getFlag() {
    return flag;
}
public void setFlag(boolean flag) {
    this.flag = flag;
}
public void setMoneyBet(double moneyBet){
    this.moneyBet=moneyBet;
}
public double getMoney() {
    return money;
}
public void setMoney(double money) {
    this.money = money;
}

public void createCards(){
    int value=2;
    for (int i=0;i < 52;i++){
    if(value>10){
        value=2;
    }
    if(i>=0 && i<9 ){
        cards[i]= value + " Clubs ";
        num[i]=value;
        value++;
    }
    if(i>=9&&i<18){
        cards[i]= value+ " Spades ";
        num[i]=value;
        value++;
    }
    if(i>=18&&i<27){
        cards[i]=value+ " Hearts ";
        num[i]=value;
        value++;
    }
    if(i>=27&&i<36){
        cards[i]=value+ " Diamonds ";
        num[i]=value;
        value++;
    }
    if(i>=36&&i<40){
        num[i]=11;
    }
    if(i>=40){
        num[i]=10;
    }
    cards[36]= "A Clubs ";
    cards[37]= "A Spades ";
    cards[38]= "A Hearts ";
    cards[39]= "A Diamonds ";
    cards[40]= "J Clubs ";
    cards[41]= "K Clubs ";
    cards[42]= "Q Clubs ";
    cards[43]= "J Spades ";
    cards[44]= "K Spades ";
    cards[45]= "Q Spades ";
    cards[46]= "J Hearts ";
    cards[47]= "K Hearts ";
    cards[48]= "Q Hearts ";
    cards[49]= "J Diamonds ";
    cards[50]= "K Diamonds ";
    cards[51]= "Q Diamonds ";
    }
}


public void showCards(){
    scorePlayer=0;
    for(int i=0;i<2;i++){
    int number = (int)(Math.random()*51+1);
    System.out.println(cards[number]);
    scorePlayer += num[number];
}
     System.out.println("\nYour Score is "+ scorePlayer+ "\n");
}
public void doubleMoney(){
    double operation=0;
    if(money<=1001){
        System.out.println("You can't double");
    }
    else {
    moneyBet = moneyBet*2;
    operation = money-moneyBet;
    if(operation<0){
        System.out.println("You can't double");
    }
    else{  
         System.out.println("The money has double for "+ moneyBet+ "\n");
         setFlag(true);
    }
    }
}
public void showCrupier(){
    scoreCrupier=0;
    for(int i=0;i<2;i++){
        int number = (int)(Math.random()*51+1);
        System.out.println(cards[number]);
        scoreCrupier += num[number];
}
System.out.println("\nCrupier Score is "+ scoreCrupier+ "\n");
}
public void showWinner(){
    if(scoreCrupier>scorePlayer){
        System.out.println("You Lose\n");
        money = money-moneyBet;
        bets.add(money);
    }
    if(scoreCrupier<scorePlayer&&scorePlayer<22){
        System.out.println("You Win\n");
        money= money+moneyBet;
        bets.add(money);
    }
    if(scorePlayer==21&& scoreCrupier!=21){
        System.out.println("YOU WIN, BLACKJACK, CONGRATULATIONS...\n");
        money= money+moneyBet;
        bets.add(money);
    }
    if(scorePlayer>21){
        System.out.println("You Lose\n");
        money = money-moneyBet;
        bets.add(money);
    }
}
public void newMoney(double moneyNew){
    moneyBet = moneyNew;
}
public void addCard(){
    int number = (int)(Math.random()*51+1);
    System.out.println("the card add is "+cards[number] );
    scorePlayer+=num[number];
    System.out.println("\nYour Score is "+ scorePlayer+ "\n");
    if(scorePlayer>21){
        System.out.println("YOU HAVE A PROBLEM");
    }
    if(scorePlayer==21){
        System.out.println("You have Good Luck, IS BLACKJACK");
    }
}
public void showRecord(){
    System.out.println("\nTHE RECORD IS BY GEORGE = 48.000 USD\n");
}
public double searchMoney(){
  double bestBet=0;
  for(int i=0;i<bets.size();i++){
      if(bets.get(i)>bestBet){
          bestBet=bets.get(i);
      }
  }
  return bestBet;
}
}
