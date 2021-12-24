package ui;
import model.BlackJack;
import java.util.Scanner;

public class Main{

private BlackJack game;
private Scanner sc;


public Main(){
 game = new BlackJack();
 sc= new Scanner(System.in);
}
public static void main(String[]args){
    System.out.println("\nWelcome to the BlackJack\n");
    Main obj = new Main();
    int option =0;
    do{
     option = obj.showMenu();
    obj.answerOption(option);
    }while(option!=0);
}
public int showMenu(){
 System.out.println("1.Initialize the Game");
 System.out.println("0.Exit the Game\n");
 int option = sc.nextInt();
 return option;
}
public void answerOption(int option){
    switch(option){
        case 0:
        System.out.println("it was a pleasure ");
        break;
        case 1:
        initializeGame();
        break;
    }
}
public void initializeGame(){
    System.out.println("The initial value to bet is 1000 USD");
    double money = 1000;
    game.setMoney(money);
    game.setMoneyBet(money);
    System.out.println("\nYour Deck is \n");
    game.showCards();
    menuGame();
}


public void menuGame(){
    System.out.println("1.Double");
    System.out.println("2.Show the crupier");
    System.out.println("3.Add a card");
    System.out.println("4.Show the Record\n");
    int option =sc.nextInt();
    optionsGame(option);
}
public void optionsGame(int option){
    switch(option){
        case 1:
        game.doubleMoney();
        menuGame();
        break;
        case 2:
        game.showCrupier();
        game.showWinner();
        if(game.getMoney()<1000){
        System.out.println("You want play again..");
        System.out.println("1.Yes \n2.NO");
        int optionPlay =sc.nextInt();
        if(optionPlay==1){
        initializeGame();
        }
        if(optionPlay==2){
            System.out.println("Your best bet was "+ game.searchMoney()+"\n");   
            answerOption(0);
        }
        }
        else{
            showOptions();
        }
        break;
        case 3:
        game.addCard();
        menuGame();
        break;
        case 4:
        game.showRecord();
        break;
    }
}
public void betNew(){
    System.out.println("Your Money is " + game.getMoney());
    System.out.println("How much will you bet...");
    double money=sc.nextDouble();
    game.newMoney(money);
    game.showCards();
}
public void showOptions(){
    System.out.println("1.Bet Again");
    System.out.println("2.EXIT");
    int option=sc.nextInt();
    switch(option){
        case 1:
        betNew();
        menuGame();
        break;
        case 2:
        System.out.println("Your best bet was "+ game.searchMoney());
        break;
    }
}
}