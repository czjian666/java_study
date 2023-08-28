package ATM_system;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {
    private ArrayList<Account> accounts = new ArrayList<>();

    private Scanner sc = new Scanner(System.in);
    private Account loginAcc;
    public void start() {
        while (true) {
            System.out.println("==欢迎您进入ATM系统==");
            System.out.println("1、用户登录");
            System.out.println("2、用户开户");
            System.out.println("请选择");
            int command = sc.nextInt();

            switch (command){
                case 1:
                    login();
                    break;
                case 2:
                    creatAccount();
                    break;
                default:
                    System.out.println("没有该操作~~~");
            }
        }
    }
    //用户登录
    private void login(){
        System.out.println("==系统登录==");
        if(accounts.size()==0){
            System.out.println("系统中无账号");
            return;
        }

        while (true) {
            System.out.println("请输入您的登录卡号：");
            String cardId = sc.next();

            Account acc = getAccountByCardId(cardId);
            if (acc ==null){
                System.out.println("登录卡号不存在");
            }else{
                while (true) {
                    System.out.println("请您输入登录密码:");
                    String passWord = sc.next();
                    if(acc.getPassWord().equals(passWord)){
                        loginAcc = acc ;
                        System.out.println("恭喜您"+acc.getUserName()+"成功登录卡号为"+ acc.getCardId());
                        //登录后操作界面
                        showUserCommand();
                        return;

                    }else{
                        System.out.println("您输入的密码不正确，请确认~~");
                    }
                }
            }
        }
    }

    private void showUserCommand(){
        while (true) {
            System.out.println(loginAcc.getUserName() +"您可以选择如下功能进行账户的处====");
            System.out.println("1、查询账户");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、密码修改");
            System.out.println("6、退出");
            System.out.println("7、注销当前账户");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    showLoginAccount();
                    break;
                case 2:
                    depostMoney();
                    break;
                case 3:
                    drawMoney();
                    break;
                case 4:
                    transfermoney();
                    break;
                case 5:
                    updataPassWard();
                    break;
                case 6:
                    System.out.println(loginAcc.getUserName()+ "您退出系统成功");
                    return;
                case 7:
                    if (deletAccount()) {
                        return;
                    }

                    break;
                default:
                    System.out.println("您当前选择操作是不存在的，请确认");
            }
        }

    }

    private void updataPassWard() {
        System.out.println("==账号密码修改==");
        while (true) {
            System.out.println("请您输入当前账号的密码：");
            String passWord = sc.next();

            if(loginAcc.getPassWord().equals(passWord)){
                while (true) {
                    System.out.println("请您输入新密码：");
                    String newpassWord = sc.next();
                    System.out.println("请您再输入新密码：");
                    String oknewpassWord = sc.next();

                    if(oknewpassWord.equals(newpassWord)){
                        loginAcc.setPassWord(oknewpassWord);
                        System.out.println("密码修改成功");
                        return;
                    }else {
                        System.out.println("您输入两次密码不一致~~");
                    }
                }

            }else{
                System.out.println("您输入的密码不正确~~");
            }
        }
    }

    private boolean deletAccount() {
        System.out.println("==进行销户操作==");
        System.out.println("请问您确认销户吗？ y/n");
        String command = sc.next();
        switch (command){
            case "y":
                if(loginAcc.getMoney()==0){
                    accounts.remove(loginAcc);
                    System.out.println("您好，您的账号已经成功销户");
                    return true;
                }else{
                    System.out.println("对不起，您的账号还有余额，不允许销户~~");
                    return false;
                }
            default:
                System.out.println("您好，账号保留");
                return false;
        }
    }

    private void transfermoney() {
        System.out.println("==用户转账==");
        if(accounts.size()<2){
            System.out.println("当前系统中只有一个账号，无法转账~~");
            return;
        }

        if(loginAcc.getMoney()==0){
            System.out.println("您自己都没钱了，别转了~~");
            return;
        }

        while (true) {
            System.out.println("请您输入对方的卡号：");
            String cardId = sc.next();

            Account acc = getAccountByCardId(cardId);
            if(acc==null){
                System.out.println("您输入的对方的卡号不存在~~");
            }else{
                //确认姓氏
                String name = '*' +acc.getUserName().substring(1);
                System.out.println("请您输入【"+ name +"】的姓氏：");
                String preName = sc.next();
                if(acc.getUserName().startsWith(preName)){
                    System.out.println("请您输入转账给对方的金额：");
                    double money = sc.nextDouble();
                    if(loginAcc.getMoney()>=money){
                        loginAcc.setMoney(loginAcc.getMoney()-money);
                        acc.setMoney(acc.getMoney()+ money);
                        return;
                    }else {
                        System.out.println("您的余额不足，无法给对方转这么多的钱，最多可转："+loginAcc.getMoney());
                    }
                }

            }
        }
    }

    private void drawMoney() {
        System.out.println("==取钱操作==");
        if (loginAcc.getMoney()<100){
            System.out.println("您账号余额不足一百块，不容许取钱~~");
            return;
        }
        while (true) {
            System.out.println("请输入取款金额：");
            double money = sc.nextDouble();
            if(loginAcc.getMoney()>=money){
                if(money>loginAcc.getLimit()){
                    System.out.println("您当前取款金额超过限额了，您每次最多取："+loginAcc.getLimit());

                }else{
                    loginAcc.setMoney(loginAcc.getMoney()-money);
                    System.out.println("您取款："+money +"成功，取款后您剩余"+ loginAcc.getMoney());
                    break;
                }

            }else {
                System.out.println("余额不足，您账号余额是："+ loginAcc.getMoney());
            }
        }
    }

    private void depostMoney() {
        System.out.println("==存钱操作==");
        System.out.println("请您输入存款金额：");
        double money = sc.nextDouble();
        loginAcc.setMoney(loginAcc.getMoney() +money);
        System.out.println("恭喜您，您存钱；"+ money +"成功，存钱后余额是："+ loginAcc.getMoney());

    }

    private void showLoginAccount() {
        System.out.println("==当前您的账户信息如下:==");
        System.out.println("卡号: " + loginAcc.getCardId());
        System.out.println("户主: " + loginAcc.getUserName());
        System.out.println("性别: " + loginAcc.getSex());
        System.out.println("余额:" + loginAcc.getMoney());
        System.out.println("每次取现额度:" + loginAcc.getLimit());
    }
    //开户操作
    private void creatAccount(){
        System.out.println("进入开户操作");
        Account acc = new Account();

        System.out.println("请您输入您的账号名称：");
        String name = sc.next();
        acc.setUserName(name);

        while (true) {
            System.out.println("请您输入您的性别：");
            char sex = sc.next().charAt(0);
            if (sex =='男'||sex =='女'){
                acc.setSex(sex);
                break;

            }else{
                System.out.println("您输入的性别有误~只能是男或者女");
            }
        }

        while (true) {
            System.out.println("请输入您的账号密码：");
            String password = sc.next();
            System.out.println("请再次输入您的账号密码：");
            String okpassword = sc.next();
            if(password.equals(okpassword)){
                acc.setPassWord(password);
                break;
            }else{
                System.out.println("您输入的两次密码不一致，请您确认~~");
            }
        }

        System.out.println("请您输入您的取现额度：");
        double limit = sc.nextDouble();
        acc.setLimit(limit);

        String newcardId = creatCardId();
        acc.setCardId(newcardId);

        accounts.add(acc);
        System.out.println("恭喜您"+acc.getUserName()+"开户成功，您的卡号是:"+ acc.getCardId());
    }
    private String creatCardId(){
        while (true) {
            String cardId = "";

            Random r = new Random();
            for (int i = 0; i < 8; i++) {
                int data = r.nextInt(10);
                cardId +=data;
            }
            Account acc =getAccountByCardId(cardId);
            if(acc == null){
                return cardId;
            }
        }

    }
    private Account getAccountByCardId(String cardId){
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if (acc.getCardId().equals(cardId)){
                return acc;
            }
        }
        return null;

    }
}
