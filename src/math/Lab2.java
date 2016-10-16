package math;

/**
 * Created by cantoress on 15.10.2016.
 */
public class Lab2 {

    public static void main(String[] args){

        double k = 0;
        double a = 0;
        double b = 2;
        double c = 0;
        double d = 2.828427;

        int m = 0;
        int n = 0;
        double hm = 0;
        double hn = 0;
        double integral = 0;
        double x = 0;
        double y = 0;
        double s = 0;
        double eps = 0;
        //System.out.println(getMax());
        //Это копировать для каждого раза
        eps = 0.005;
        k = 0.5;
        m = getM(eps,a,b,c,d,k,9.99936,6.29061);
        n = (int)Math.ceil(k*m);
        hm = (b-a)/m;
        hn = (d-c)/n;
        s = hm*hn;
        x = a;

        System.out.println("m = "+m);
        System.out.println("n = "+n);

        while(x<=b){
            y = c;
            while(y<=d){
                integral+=s*f(x,y)*getlyambda(x,y);
                y+=hn;
            }
            x+=hm;
        }
        System.out.println(integral);


    }

    public static int getM(double eps, double a, double b, double c, double d, double k, double Mxx, double Myy){
        return (int)Math.ceil(Math.sqrt((1/(24*eps))*(b-a)*(d-c)*(((b-a)/k)*((b-a)/k)*Mxx+(d-c)*(d-c)*Myy)));

    }


    public static int getlyambda(double x, double y){

        if((x<=2)&&(x>=0)&&(y>=Math.sqrt(2*x-x*x))&&(y<=2*Math.sqrt(x))) return 1;
        return 0;
    }

    public static double f(double x, double y){

        return Math.atan(5*x*x+4*Math.sin(y*y));
    }


    public static double getMax(){
        double hx = 0.02;
        double x = 0.001;
        double max = -100000;
        double temp = 0;

        while(x<=2){
            double ya = Math.sqrt(2*x-x*x);
            double yb = Math.sqrt(x)*2;
            double hy = (yb-ya)/100;
            double y = ya;
            while(y<=yb){

                temp = -(10*(75*Math.pow(x,4)+40*x*x*Math.sin(y*y)+8*Math.cos(2*y*y)-9))/Math.pow((25*Math.pow(x,4)+40*x*x*Math.sin(y*y)+16*Math.sin(y*y)*Math.sin(y*y)+1),2);
//                temp = (8*(-2*y*y*Math.sin(y*y)*(Math.pow((5*x*x+4*Math.sin(y*y)),2)+1)-16*y*y*Math.pow(Math.cos(y*y),2)*(5*x*x+4*Math.sin(y*y))+Math.cos(y*y)*(Math.pow((5*x*x+4*Math.sin(y*y)),2)+1)))/Math.pow((Math.pow((5*x*x+4*Math.sin(y*2)),2)+1),2);
                //System.out.println(temp);
                if(temp>max){
                    max = temp;
                }
                y+=hy;
            }
            x+=hx;
        }
        return max;

    }
}
