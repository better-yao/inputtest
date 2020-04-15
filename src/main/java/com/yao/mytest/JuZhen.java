package com.yao.mytest;

public class JuZhen {
    public static void main(String[] args) {
        double[][] A= new double[][]{{1,0,0}, {0,0.9999632814886206,-0.008569461739792162},{0,0.008569461739792162 ,0.9999632814886206}};
        double[][] B= new double[][]{{0.9999845009534094,0,0.0055675715496666354},{0,1,0},{-0.0055675715496666354,0,0.9999845009534094}};
        double[][] C= new double[][]{{-0.22233132621239796 ,0.9749711695145843,0},{-0.9749711695145843 ,-0.22233132621239796,0},{0,0,1}};
        double[][] J1= new double[][]{{1,2,3},{4,5,6}};
        double[][] J2= new double[][]{{1,4},{2,5},{3,6}};
        double[][] J3= new double[][]{{1,2,3},{4,5,6}};
        int m=2,p=3,n=2;
        double[][] c= new double[m][n];
//        JZcheng(J1,J2,m,n,p,c);
        /*double[][] test=*/
        JZjia(J1,J3);
        /*show(test);*/
    }


    //展示矩阵中的数据
    public static void show(double[][] c){
        for(int i=0;i<c.length;i++){
            for(int j=0;j<c[i].length;j++){
                System.out.print(c[i][j]+"  ");
            }
            System.out.println();
        }
    }

    //矩阵乘法操作
    public static void JZcheng(double[][] a, double[][] b, int m, int n, int p, double[][] c){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                c[i][j]=add(a[i],b,j,p);
            }
        }

    }

    private static double add(double[] a, double[][] b, int j, int n) {
        double sum=0;
        for(int k=0;k<n;k++)
        {
            sum+=a[k]*b[k][j];
        }
        return sum;
    }

    //矩阵加法操作   同型
    public static double[][] JZjia(double[][] m1,double[][] m2){
        if(m1==null||m2==null|| m1.length!=m2.length|| m1[0].length!=m2[0].length) {
            return null;
        }
        double[][] m = new double[m1.length][m1[0].length];
        for(int i=0;i<m.length;++i){
            for (int j=0;j<m[i].length;++j){
                m[i][j]=m1[i][j]+m2[i][j];
            }
        }
        return m;
    }

    //矩阵转置   line=行 liet=列
    public static double [][] JZzhuanzhi(double [][] aa, int line, int list) {
        double [][] result = new double [list] [line] ;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < list; j++) {
                result[j][i] = aa[i][j] ;
            }
        }
        return result;
    }
}
