import java.util.*;
interface ATM{
    public void History();
    public void Withdraw(int x);
    public void Deposit(int x);
    public void Transfer(Account a,int x);
    public void Quit();
}
class Account implements ATM{
    int balance;
    String Uname;
    String pswd;
    public void History(){
        System.out.println("your balance= "+balance);
    }
    public void Withdraw(int x){
        if(balance>x)
            balance=balance-x;
        else
            System.out.println("our account balance is less than requested");
    }
    public void Deposit(int x){
        balance =balance+x;
    }
    public void Transfer(Account a,int x){
        if(balance<x){
            System.out.println("your account balance is less than requested");
            System.out.printf("TRANSACTION UNSUCCESSFULL\n");
        }
        else{
        a.balance=a.balance+x;
        balance=balance-x; 
        System.out.printf("TRANSACTION SUCCESSFULL\n");
        }
    }
    public void Quit(){
       return;
    }
}
class JavaTask3{
        Account a[]=new Account[2];
        JavaTask3(){        
            Scanner sc=new Scanner(System.in);
            for(int i=0;i<2;i++){
                a[i]=new Account();
                System.out.println("create username and password for account and intialize balance");
                a[i].Uname=sc.next();
                a[i].pswd=sc.next();
                a[i].balance=sc.nextInt();
            }	
        }
        public void operations(int l){
            Scanner sc=new Scanner(System.in);
            int money;
            while(true){
                
                try{
                System.out.printf("\nCHOOSE\n1.History\n2.Withdraw\n3.deposit\n4.transfer\n5.Quit\n");
                int s=sc.nextInt();
                switch(s){
                    case 1:a[l].History();
                            break;
                    case 2:System.out.println("enter money to withdraw");
                            money=sc.nextInt();
                            a[l].Withdraw(money);
                            break;
                    case 3:System.out.println("enter money to deposit");
                            money=sc.nextInt();
                            a[l].Deposit(money);
                            break;
                    case 4:System.out.println("enter money to Transfer");
                            money=sc.nextInt();
                            System.out.println("enter username to transer");
                           String ll=sc.next();
                           int i;
                            for( i=0;i<2;i++){
                                if(a[i].Uname.equals(ll))
                                    break;
                            } 
                            if(i==2){
                                    System.out.printf("invalid transaction username \nTRANSACTION UNSUCCESFULL\n");
                                    break;
                            }
                            else{
                                a[l].Transfer(a[i],money);
                                break;
                            }
                    case 5:
                            return ;
                        }
                }
                catch(InputMismatchException e){
                    System.out.println("enter only number\n");
                }
            }
        }
        public static void main(String args[]){
           JavaTask3 t3=new JavaTask3(); 
           Scanner sc=new Scanner(System.in);
           while(true){
            try{
            System.out.println("\nCHOOSE\n1.login\n2.exit\n");
            int x=sc.nextInt();
            if(x==1){
                    System.out.println("enter username and password");
                    String uname=sc.next();
                    String pswd=sc.next();
                    int k=t3.check(uname,pswd);
                    if(k!=-1){
                            t3.operations(k);
                    }
                    else{
                        System.out.println("invalid login");
                    }
                }
                else{
                    return ;
                }
            }
                catch(Exception e){
                    System.out.println("please enter correctly\n");
                }
           
        }
    }
        public int check(String s1,String s2){
           int i;
            for(i=0;i<2;i++)
			{
                if(a[i].Uname.equals(s1) && a[i].pswd.equals(s2)){
                        return i;   
            }
			}
            return -1;
			
        }
}