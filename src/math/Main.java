package math;

public class Main {

    public static void main(String[] args) {

        System.out.println("Решение определенного интеграла №2 методом трапеций");
        System.out.println("При 10 итерациях");
        System.out.println(trap(10,0,0.78539816339));
        System.out.println("Погрешность");
        System.out.println(deltatrap(10,0.,0.78539816339));
        System.out.println("При 20 итерациях");
        System.out.println(trap(20,0,0.78539816339));
        System.out.println("Погрешность");
        System.out.println(deltatrap(20,0.,0.78539816339));

        System.out.println("Решение определенного интеграла №2 методом парабол");
        System.out.println("При 10 итерациях");
        System.out.println(parabf1(10,0,0.78539816339));
        System.out.println("Погрешность");
        System.out.println(deltaparab(10,0.,0.78539816339));
        System.out.println("При 20 итерациях");
        System.out.println(parabf1(20,0,0.78539816339));
        System.out.println("Погрешность");
        System.out.println(deltaparab(20,0.,0.78539816339));

        System.out.println("Решение определенного интеграла №4 методом парабол");
        System.out.println("Определяем количество итераций для точности 0.00001 с помощью формулы погрешности");
        System.out.println(getn(0.00001,0.8,1.2));
        System.out.println(parabf2(6,0.8,1.2));
        System.out.println("Погрешность");
        System.out.println(deltaparab(6,0.8,1.2));
        System.out.println(Runge(0.00001,0.8,1.2));
    }

    public static double f1 (double x){

        return x/(Math.cos(x)*Math.cos(x));
    }

    public static double f2 (double x){

        return Math.sin(2*x)/(x*x);
    }

    public static double trap (int n, double a, double b) {

        double h = (b-a)/n;

        double res = 0;
        double x = a;
        res+=(f1(a)+f1(b))/2;

        for(int i=1; i<n; i++){
            x = a+h*i;
            res+=f1(x);
        }
        res = res*h;
        return res;
    }

    public static double deltatrap (int n, double a, double b){

        return 20.5664*(b-a)*(b-a)*(b-a)/(12*n*n);
    }

    public static double parabf1(int n, double a, double b){
        double h = (b-a)/n;

        double res = 0;
        double x = a;

        res+=f1(a)+f1(b);

        for(int i=1; i<=n/2;i++){
            x = a+(2*i-1)*h;
            res+=4*f1(x);
        }
        for(int i=1; i<=n/2-1;i++){
            x = a+ 2*i*h;
            res+=2*f1(x);
        }

        res = res*h/3;
        return res;
    }

    public static double parabf2(int n, double a, double b){
        double h = (b-a)/n;

        double res = 0;
        double x = a;

        res+=f2(a)+f2(b);

        for(int i=1; i<=n/2;i++){
            x = a+(2*i-1)*h;
            res+=4*f2(x);
        }
        for(int i=1; i<=n/2-1;i++){
            x = a+ 2*i*h;
            res+=2*f2(x);
        }

        res = res*h/3;
        return res;
    }

    public static double deltaparab (int n, double a, double b){

        return 722.124*(b-a)*(b-a)*(b-a)*(b-a)*(b-a)/(180*n*n*n*n);
    }

    public static int getn(double eps, double a, double b){

        double res = Math.pow(144.604*(b-a)*(b-a)*(b-a)*(b-a)*(b-a)/(180*eps),0.25);
        System.out.println(res);
        return (int)Math.ceil(res);
    }

    public static int k (int m){
        return (int)Math.pow(2,m)-1;
    }

    public static double Runge (double eps, double a, double b){

        double keps = k(4)*eps;
        int n = 1;
        double res1 = parabf2(n,a,b);
        double res2 = parabf2(2*n,a,b);
        while (Math.abs(res1-res2)>keps){
            n = n*2;
            res1 = res2;
            res2 = parabf2(2*n,a,b);
        }

        System.out.println("Количество итераций по методу Рунге равно "+ 2*n);
        return res2;
    }
}
