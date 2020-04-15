package com.yao.mytest;

public class jisuanTest {
    public static void main(String[] args) {
        double heading=343;
        double roll=5;
        double pitch=-0.5;
        double latitude=20.5156992;
        double longitude=113.8655697;
        final double longitude0=117;
        final double k0=0.9996;
        final double FE=500000;
        final double PI=Math.PI;
        final double a=6378137;
        final double b=6356752.314245;

        double lat=(latitude*PI)/180;
        double lon=(longitude*PI)/180;
        double e=Math.sqrt(1-Math.pow((b/a),2));
        double lon0=(longitude0*PI)/180;

        System.out.println("lat："+lat+"--------lon："+lon+"---------e："+e+"---------lon0："+lon0);

        double FN=latitude<0?1*10000000:0;
        System.out.println("FN："+FN);

        double eps=e*e/1-(e*e);
        System.out.println("eps："+eps);

        double N= a/Math.sqrt(1-Math.pow(e,2)*Math.pow(Math.sin(lat),2));
        double T=Math.pow(Math.tan(lat),2);
        double C=Math.pow(Math.cos(lat),2)*(Math.pow(e,2)/(1-Math.pow(e,2)));
        double A=(lon-lon0)*Math.cos(lat);

        double M=a*((1-Math.pow(e,2)/4-3*Math.pow(e,4)/64-5*Math.pow(e,6)/256)*lat-(3*Math.pow(e,2)/8+3*Math.pow(e,4)/32+45*Math.pow(e,6)/1024)*Math.sin(2*lat)+(15*Math.pow(e,4)/256+45*Math.pow(e,6)/1024)*Math.sin(4*lat)-(35*Math.pow(e,6)/3072)*Math.sin(6*lat));
        double X=FE+k0*N*(A+(1-T+C)*Math.pow(A,3)/6+(5-18*T+Math.pow(T,2)+72*C-58*eps)*Math.pow(A,5)/120 );
        double Y=FN+k0*M+k0*N*Math.tan(lat)*(Math.pow(A,2)/2+(5-T+9*C+4*Math.pow(C,2))*Math.pow(A,4)/24+(61-58*T+Math.pow(T,2)+600*C-330*eps)*Math.pow(A,6)/720);
        double utmzone=Math.floor(longitude0/6)+31;


        if(latitude==0 && longitude==0){
            return;
        }
        System.out.println("    X= "+X+"      Y= "+Y+"        utmzone= "+utmzone);

        double aaa=((90-heading)*Math.PI/180);
        double XG=X+Math.cos(aaa)*203.57;
        double YG=Y+Math.sin(aaa)*203.57;


        double Xone=(-11.794)*Math.sin((Math.PI*roll)/180)*Math.sin((Math.PI*(90-heading))/180);
        double Xtwo=105.2*Math.sin((Math.PI*pitch)/180)*Math.cos((Math.PI*pitch)/180)*Math.cos((Math.PI*(90-heading))/180);
        double XF=XG+Xone+Xtwo;

        double Yone=(-11.794)*Math.sin((roll*Math.PI)/180)*Math.cos(((90-heading)*Math.PI)/180);
        double Ytwo=105.2*Math.sin((pitch*Math.PI)/180)*Math.cos((pitch*Math.PI)/180)*Math.sin(((90-heading)*Math.PI)/180);
        double YF=YG+Yone+Ytwo;

        System.out.println("Xone=:"+Xone+"==Xtwo=:"+Xtwo);
        System.out.println("Yone=:"+Yone+"==Ytwo=:"+Ytwo);
    }
}
