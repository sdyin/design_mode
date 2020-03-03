package com.sdyin.design.dsag;

/**
 * @Description:
 * @Author: liuye
 * @time: 2020/2/7$ 上午10:56$
 */
public class PackageProblem1 {

    private static int maxW = Integer.MIN_VALUE;

    // 物品重量
    private static int[] weight = {2,2,4,6,3};
    // 物品个数
    private static int n = 5;
    // 背包承受的最大重量
    private static int w = 9;

    /**
     *
     * @param i 第i个物品
     * @param cw 当前背包总重量
     */
    public static void f(int i,int cw){
        if(i == n || cw == w){
            if(cw > maxW){
                maxW = cw;
                return;
            }
        }
        //选择不装第i个商品
        f(i + 1, cw);
        if(cw + weight[i] <= w){
            //选择装第i个物品
            f(i + 1, cw + weight[i]);
        }
    }

    public static void main(String[] args) {


    }
}
