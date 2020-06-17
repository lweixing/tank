package com.star.tank.test;

public class Yayitouzical {
    public static void main(String[] args) {

        float total = 100;
        System.out.println("以总投资"+total+"万，技术投资人和普通投资人投资占比3:1算。普通投资人每人投资1万依次累加计算：");
        for(int i=1;i<100;i++){
            System.out.println("普通投资人每人投资"+i+"万，计算结果：");
            float singleCommMoney = i;
            float commMoney = 5*i;
            float techMoney = total - commMoney;
            /*float chaoRate ;
            float touziRate = 1 - chaoRate;
            (chaoRate/3) / touziRate = techMoney / commMoney;
            将1 - chaoRate 代入 touziRate：
                (chaoRate/3)/(1-chaoRate) = techMoney / commMoney;
                chaoRate/(3-3*chaoRate) = techMoney/commMoney;
                chaoRate*commMoney = 3*techMoney - 3*chaoRate*techMoney;
                commMoney*chaoRate+3*techMoney*chaoRate = 3*techMoney;
                (commMoney+3*techMoney) * chaoRate = 3*techMoney;
                chaoRate = 3*techMoney / (commMoney+3*techMoney);
            */
            float chaoRate = 3*techMoney / (commMoney+3*techMoney);
            float touziRate = 1 - chaoRate;
            System.out.println("普通投资人每人投资"+singleCommMoney+"万，技术投资"+techMoney+"万,普通投资人总体占比："+touziRate+",技术占比："+chaoRate);
        }


    }
}

class Person{
    private float money;
    private float rate;
}

class Xiangchao extends Person{

}
