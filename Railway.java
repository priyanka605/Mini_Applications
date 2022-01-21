import java.util.*;

public class Railway {
    static Scanner sc = new Scanner(System.in);
    static String admin_user = "Admin";
    static String admin_password = "1234";
    public static int[] berth = new int[13];
    static int current_user = 0;
    static int State = 1;
    static int Admin_attempt = 1;
    public String User_Name, User_Pin;
    public int User_attempt;
    public ArrayList<String> Old_user;
    static int[] seats = new int[200];
    static Railway[] user;

    Railway(String Name, String Pin) {
        this.User_Name = Name;
        this.User_Pin = Pin;
        this.User_attempt = 1;
    }

    public static void Admin_login() {
        while (Admin_attempt <= 2) {
            System.out.print("\033[H\033[2J");
            System.out.print("\t Welcome Admin \n Enter the Admin User Id : ");
            String User_Id = sc.next();
            sc.nextLine();
            System.out.print("\n Enter the Admin Password : ");
            String User_Password = sc.next();
            sc.nextLine();
            if (admin_user.equals(User_Id) && admin_password.equals(User_Password)) {
                Admin();
            } else {
                Admin_attempt += 1;
            }
        }
        if (Admin_attempt == 3) {
            System.out.print("\033[H\033[2J");
            System.out.println("This is your Final Attempt,Please Enter Valid Password:");
            System.out.print("\nEnter the Admin User Id : ");
            String User_Id = sc.next();
            sc.nextLine();
            System.out.print("\nEnter the Admin Password : ");
            String User_Password = sc.next();
            sc.nextLine();
            if (admin_user.equals(User_Id) && admin_password.equals(User_Password)) {
                Admin();
            } else {
                Admin_attempt += 1;
            }

        }
        if (Admin_attempt == 4) {
            System.out.println("Your Account Has been Locked  :-(");
            main(null);
        }
    }

    public static void Admin() {
        int i = 1;
        System.out.print("\033[H\033[2J");
        while (i != 0) {
            System.out.println(
                    "\t Welcome to Admin \n 1 => Add Train,Route and Stations \n 2 => Declare Seat Availability \n 3 =>Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Enter Train Details");
                    System.out.println("Enter PNR no:");

                    break;
                case 2:
                    System.out.println("TO be added");
                    break;

                case 3:
                    main(null);
                    break;

                default:
                    System.out.println("---Please enter the valid options !---");

            }
        }
    }

    public static void User_Login() {
        int k = 1;
        while (user[current_user].User_attempt <= 3 && k != 0) {
            System.out.print("\033[H\033[2J");
            System.out.print("\t Welcome User Panel \nEnter the User Id : ");
            String User_Id = sc.next();
            sc.nextLine();
            System.out.print("\nEnter the User Password : ");
            String User_Password = sc.next();
            sc.nextLine();
            for (int i = 0; i <= 3; i++) {
                // Checks the user id and Password
                if (user[i].User_Name.equals(User_Id) && user[i].User_Pin.equals(User_Password)) {
                    current_user = i;
                    old_login();
                    k += 1;
                    break;
                }
            }
            user[current_user].User_attempt += 1;
        }

        // If the attemp is more than 3 the account has been locked :-)
        if (user[current_user].User_attempt == 4) {
            System.out.println("Your Account Has been Locked  :-(");
            main(null);
        }
    }

    public static void old_login() {
        int i = 1;
        if (i != 0) {
            System.out.println(
                    "**Welcome Passenger** \n 1 =>PNR Status \n 2 =>Train Booking \n 3 =>Seat Availability \n 4 =>Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("PNR Status");
                    break;

                case 2:
                    seat_booking();
                    break;

                case 3:
                    System.out.println("Seat Availability");
                    System.out.println(seats.length);
                    break;

                case 4:
                    main(null);
                    break;
                default:
                    System.out.println("---Please enter the Valid Cases---");
            }
        }
    }

    public static void seat_booking() {
        int choice = 1;
        int seat = 0;
        for (int i = 0; i < 12; i++) {
            berth[i] = 0;
        }

        System.out.print("Please select your type of berth:\n1.Upper Berth\n2.Lower Berth\n0.Exit.\n");
        choice = sc.nextInt();

        while (choice != 0) {
            int seatnumber = 0;

            if (choice == 1) {
                System.out.println("Enter No of Seats: ");
                seat = sc.nextInt();

                if (seatnumber == -1) {
                    seatnumber = bookLower();

                    if (seatnumber != -1) {

                        System.out.println("Sorry, there are no Upper Berths available. But we do have a Lower Berth.");
                        boardingPass(seatnumber);
                    }
                } else {

                    System.out.println("         Congratulations, we have a Upper Berth available!");
                    boardingPass(seatnumber);
                }
            } else if (choice == 2) {

                seatnumber = bookLower();

                if (seatnumber == -1) {
                    seatnumber = bookUpper();

                    if (seatnumber != -1) {
                        System.out.println("Sorry, there are no Lower Berths available. But we do have a Upper Berth.");
                        boardingPass(seatnumber);
                    }
                } else {

                    System.out.println("         Congratulations, we have a Lower berth available!");
                    boardingPass(seatnumber);
                }
            } else {

                System.out.println("Your choice is invalid. Please provide valid choice!");
                choice = 0;
            }

            if (seatnumber == -1) {
                System.out.println("Sorry, there are no Upper Berths or no Lower Berths available");
                System.out.println();
            }

            System.out.print("Please select your type of berth:\n1.Upper Berth\n2.Lower Berth\n0.Exit.\n");
            choice = sc.nextInt();
        }
    }

    private static int bookUpper() {
        for (int i = 0; i < 6; i++) {
            if (berth[i] == 0) {
                berth[i] = 1;
                return i + 1;
            }
        }
        return -1;
    }

    private static int bookLower() {
        for (int i = 6; i < 12; i++) {
            if (berth[i] == 0) {
                berth[i] = 1;
                return i + 1;
            }
        }
        return -1;
    }

    public static void boardingPass(int berthnumber) {
        Date timenow = new Date();
        System.out.println();
        System.out.println("Date: " + timenow.toString());
        System.out.println("Boarding pass for berth number: " + berthnumber);
        System.out.println("Your Booking Successful!!!");
        System.out.println("This ticket is non-refundable.");
        System.out.println("Please be polite,keep your place clean . Have a safe journey.");
        System.out.println("!!Have a great day!!!");
        System.out.println();
    }

    public static void main(String[] args) {
        int i = 1;
        if (State == 1) {
            user = new Railway[3];
            user[0] = new Railway("Priya", "1234");
            user[0].Old_user = new ArrayList<>();
            user[1] = new Railway("Yadhu", "1234");
            user[1].Old_user = new ArrayList<>();
            user[2] = new Railway("Karthi", "1234");
            user[2].Old_user = new ArrayList<>();
            State = 0;
        }
        while (i != 0) {
            System.out.println(
                    "****Welcome to Online Rail Booking System**** \n 1=>Admin \n 2=>Old Passenger \n 3=>New Passenger \n 4=>Exit");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    Admin_login();
                    break;

                case 2:
                    User_Login();
                    break;

                case 3:
                    // new_login();
                    System.out.println("new User");
                    break;

                case 4:
                    System.out.println("***Thank You for Visiting US ! Have a Comfort and Safe Journey***");
                    System.exit(0);
            }
        }
    }
}
