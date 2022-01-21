import java.util.Scanner; 
 
public class Atm{ 
    static Scanner sc=new Scanner(System.in); 
    static String name="priyanka"; 
    static int password=0103; 
    static int[] noOfCurrency={0, 0, 0, 0}; 
    static int[] currency={100, 200, 500, 2000}; 
    static int total=0; 
    static int balance=5000; 
 
    public static void admin(){ 
        System.out.println("You have chosen Admin Login"); 
        System.out.println("Enter Admin name and Password"); 
        String adminname=sc.next(); 
        int adminpassword=sc.nextInt(); 
        int ad=0; 
        if(name.equals(adminname) && adminpassword==password){ 
            do { 
                System.out.println("Welcome Admin"); 
                System.out.println("1.Load"); 
                System.out.println("2.Check Balance"); 
                System.out.println("3.Exit"); 
                ad=sc.nextInt(); 
                switch(ad){ 
                    case 1: 
                        System.out.println("Enter Amount"); 
                        load(); 
                        break; 
                    case 2: 
                        System.out.println("Check Balance"); 
                        check(); 
                        break; 
                    case 3: 
                        break; 
                } 
            }while(ad !=3); 
        }else{ 
            System.out.println("Check name and password"); 
        } 
    } 
    public static void load(){ 
        for(int i=0;i<=3;i++){ 
            System.out.println("Enter the currency to load "+currency[i]+"->"); 
            noOfCurrency[i]+=sc.nextInt(); 
            System.out.println("Amount loaded successfully"); 
        } 
    } 
    public static void check(){ 
        int tot=1000; 
        for(int i=0;i<=3;i++){ 
            System.out.println("No of "+currency[i]+"->"+noOfCurrency[i]); 
            tot+=currency[i]*noOfCurrency[i]; 
            total=tot; 
            System.out.println(tot); 
 
        } 
    } 
    public static void user(){ 
        System.out.println("You have chosen user login"); 
        System.out.println("Enter User name and Password"); 
        String username=sc.next(); 
        int userpassword=sc.nextInt(); 
        int us=0; 
            do { 
                if(username.equals(username) && userpassword==userpassword){ 
                System.out.println("Welcome User"); 
                System.out.println("1.Check Balance"); 
                System.out.println("2.Withdraw Amount"); 
                System.out.println("3.Pin Change"); 
                System.out.println("4.Direct Deposit"); 
                System.out.println("5.Exit"); 
                us = sc.nextInt(); 
                switch (us) { 
                    case 1: 
                        checkbalance(); 
                        break; 
                    case 2: 
                        withdraw(); 
                        break; 
                    case 3: 
                        pinchange(); 
                        break; 
                    case 4: 
                        deposit(); 
                        break; 
                    case 5: 
                        break; 
                } 
            } 
        }while (us != 5); 
    } 
 
    public static void checkbalance(){ 
        System.out.println("Balance : "+balance); 
    } 
    public static void pinchange(){ 
        System.out.println("Enter your Old pin : "); 
        int a=sc.nextInt(); 
        if(a==password) 
            password=sc.nextInt(); 
        System.out.println("Your pin has been changed successfully"); 
    } 
    public static void deposit(){ 
        int total=balance; 
        for(int i=0;i<=3;i++){ 
            System.out.println("Enter no of "+currency[i]+"-"); 
            int n=sc.nextInt(); 
            noOfCurrency[i]+=n; 
            total+=currency[i]*n; 
            balance+=currency[i]*n; 
        } 
    } 
    public static void withdraw(){ 
        System.out.println("Enter Withdraw Amount"); 
        System.out.println("multiples of "); 
        for(int i=0;i<=3;i++){

if(noOfCurrency[i]>0) 
                System.out.println(currency[i]+"s"); 
        } 
        int withdrawamt=sc.nextInt(); 
        if(withdrawamt>balance){ 
            System.out.println("Enter Minimum Amount"); 
        } 
        else{ 
            int noOfNote=0; 
            for(int j=3;j>=0;j--){ 
                while(withdrawamt>currency[j] && noOfCurrency[j]>0){ 
                    withdrawamt-=currency[j]; 
                    noOfCurrency[j]--; 
                    noOfNote++; 
                } 
            } 
            total-=withdrawamt; 
            balance-=withdrawamt; 
            System.out.println("Amount withdrawed successfully "+noOfNote); 
            System.out.println("Collect your cash"); 
        } 
    } 
    public static void main(String[] args){ 
 
        int ch=0; 
        do{ 
            System.out.println("Welcome"); 
            System.out.println("Atm Application"); 
            System.out.println("1.Admin Login"); 
            System.out.println("2.User Login"); 
            System.out.println("3.Exit"); 
            ch =sc.nextInt(); 
            switch(ch){ 
                case 1: 
                    admin(); 
                    break; 
                case 2: 
                    user(); 
                    break; 
                case 3: 
                    break; 
            } 
        } 
        while(ch!=3); 
        System.out.println("Thanks for using"); 
    } 
}
