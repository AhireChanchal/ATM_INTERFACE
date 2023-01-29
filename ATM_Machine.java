import java.util.Scanner;
public class ATM_Machine {

    static Scanner sc = new Scanner(System.in);
        
    static String USER_NAME;
    static String PASSWORD;
    static int Account_No;
    static int PIN;
    static float BALANCE = 100000f;
    static int TRANS = 0;
    static String transHis = "";

    public static void Register(){

        System.out.println("\nEnter your Username  :");
        USER_NAME= sc.next();
        System.out.println("ENTER YOUR PASSWORD  :");
        PASSWORD = sc.next();
        System.out.println("ENTER YOUR ACCOUNT NUMBER  :");
        Account_No= sc.nextInt();
        System.out.println("ENTER YOUR ATM PIN  :");
        PIN=sc.nextInt();
        System.out.println("\nRegistration completed. Successfully!!");
        System.out.println("Kindly login to your account.");
    }


    public static boolean Login(){
        boolean isLogin = false;
        while(!isLogin)
        {
            System.out.println("\nEnter your Account Number : ");
            int actno = sc.nextInt();
            if(actno == Account_No)
            {
               System.out.println("Enter your ATM pin : ");
               int Pin1 = sc.nextInt();
               while(!isLogin)
               {
                   if(Pin1 == PIN)
                   {
                      System.out.println("\nLogged in Successfully");
                      isLogin = true;
                   }
                   else
                   {
                      System.out.println("\nInvalid ATM pin");
                      break;
                   }
            
                }
            }
            else
            {
               System.out.println("\nInvalid Account Number");
            }
        }
        return isLogin;

    }


    public static void checkBalance(){
        System.out.println("\nYour balance is : "+BALANCE);
    }


    public static void deposit(){
        System.out.println("\nEnter the Amount to be deposited : ");
        float dep_amnt = sc.nextFloat();
        BALANCE = BALANCE+dep_amnt;
        System.out.println("\nYour money has been successfully deposited");
        System.out.println("After depositing "+dep_amnt+", balance is "+BALANCE);
        TRANS+=1;
        String s = "Rs. "+dep_amnt+" deposited to account\n";
        transHis = transHis.concat(s);
    }


    public static void withdraw(){
        System.out.println("\nEnter the amount you want to withdraw :");
        float wd_amnt = sc.nextFloat();
        if(wd_amnt<=BALANCE)
        {
            System.out.println("\nSuccessfully withdrawn Rs. "+wd_amnt);
            BALANCE= BALANCE-wd_amnt;
            System.out.println("Your current balance is : "+BALANCE);
            TRANS+=1;
            String s = "Rs. "+wd_amnt+" withdrawn from account\n";
            transHis = transHis.concat(s);
        }
        else
        {
            System.out.println("\nSorry can't withdraw. Insufficient balance");
            System.out.println("Your current balance is : "+BALANCE);
        }
    }


    public static void transfer(){
        System.out.println("\nEnter the Account No. you want to transfer to : ");
        String acc_no = sc.next();
        System.out.println("Enter the amount you want to transfer : ");
        float t_amnt = sc.nextInt();

            if(t_amnt<=BALANCE)
            {
                System.out.println("\nMoney Transfered Successfully");
                BALANCE = BALANCE-t_amnt;
                System.out.println("Your current balance is : "+BALANCE);
                TRANS+=1;
                String s = "Rs. "+t_amnt+" transfered from account\n";
                transHis = transHis.concat(s);
            }
            else
            {
                System.out.println("\nSorry can't transfer. Insufficient balance");
                System.out.println("Your current balance is : "+BALANCE);
            }
    }


    public static void transHistory(){
        if(TRANS==0){
            System.out.println("No Transactions");
        }
        else
        {
            System.out.println(transHis);
        }
    }


    public static void main(String args[]){

        System.out.println("\nWELCOME TO ATM!!!");
        System.out.println("\nSelect any one option!");
        System.out.println("1.REGISTER\n2.EXIT");
        System.out.println("\nEnter your option :");

        int choice = sc.nextInt();

        if(choice == 1)
        {
            Register();
            while(choice == 1){
                System.out.println("\nSelect any one option!");
                System.out.println("1.LOGIN\n2.EXIT");
                System.out.println("\nEnter your option :");
                int op=sc.nextInt();
                if (op==1)
                {
                    if(Login())
                    {
                        boolean isFin = false;
                        while(!isFin)
                        {
                            System.out.println("\nSelect any option : ");
                            System.out.println("1.CHECK BALANCE\n2.DEPOSIT\n3.WITHDRAW\n4.TRANSFER\n5.TRANSACTION HISTORY\n6.EXIT");
                            System.out.println("\nEnter your option :");
                            int c=sc.nextInt();
                            switch(c){
                                case 1 : checkBalance();
                                        break;
                                case 2 : deposit();
                                        break;
                                case 3 : withdraw();
                                        break;
                                case 4 : transfer();
                                        break;
                                case 5 : transHistory();
                                        break;
                                case 6 : isFin=true;
                                        System.out.println("\nPlease collect your card");
                                        break;
                                default: System.out.println("Invalid option!");
                            }
                        }
                    }
                }
                else
                {
                    System.out.println("\nPlease collect your card");
                    System.exit(0);
                }
                break;
            }

        }
        else
        {
            System.out.println("\nPlease collect your card");
            System.exit(0);
        }
    }   
}

