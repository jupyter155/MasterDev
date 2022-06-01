
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
public class main {
    public static Scanner scanner = new Scanner(System.in);
    // M1
    public static void M1_Tinhtongsonguyen() {
        System.out.print("nhap vao so phan tu trong mang: ");
        int n = scanner.nextInt();
        double[] arr = new double[n];
        double total = 0;
        for(int i=0; i<arr.length; i++){
            System.out.print("nhap vao gia tri phan tu thu "+(i+1)+": ");
            arr[i] = scanner.nextDouble();
        }
        for (double v : arr) {
            total = total + v;
        }
        System.out.format("ket qua la: %.3f%n", total);
    }
    //M2
    static void  M2_maxChars(){
        System.out.print("nhap chuoi : ");
        String s = scanner.next();
        HashMap<Character, Integer> hash_Map = new HashMap<Character, Integer>();
        for(Character i : s.toCharArray()){
            if (hash_Map.containsKey(i)){
                hash_Map.put(i,hash_Map.get(i)+1);
            }
            else {
                hash_Map.put(i,1);
            }
        }
        int maxValueInMap = (Collections.max(hash_Map.values()));
        System.out.println("max = " + maxValueInMap);
        hash_Map.forEach((key,value) -> {
            if (value == maxValueInMap) {
                System.out.println("ky tu :" + key);
            }
        });
    }
    //M3
    public static void sortASC(int [] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
    public static void M3_Sort(){
        System.out.print("nhap so phan tu cua mang: ");
        int n = scanner.nextInt();

        int [] arr = new int [n];
        System.out.print("nhap cac phan tu cua mang:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        sortASC(arr);
        System.out.println("day so duoc sap xep tang dan:  \n");
        for (int j : arr) {
            System.out.print(j + " ");
        }

    }
    //M4
    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void M4_SoNguyenTo(){
        System.out.print("Nhap so nguyen:");
        int n = scanner.nextInt();
        System.out.print(isPrimeNumber(n) + "\n");
    }
    //M5
    static double dienTichTamGiac(double a,double b, double c)
    {
        float p=(float)(a+b+c)/2;
        float s;
        s=(float)Math.sqrt(p*(p-a)*(p-b)*(p-c));
        return s;
    }
    public static void M5_STamGiac(){
        double Stamgiac ;
        Scanner nhap = new Scanner(System.in);
        double a ,b ,c ;
        do {
            System.out.print("nhap a=");
            a = nhap.nextDouble();
            System.out.print("nhap b=");
            b = nhap.nextDouble();
            System.out.print("nhap c=");
            c = nhap.nextDouble();
        }
        while (a <=0 || b <=0 || c <=0);
        if (a + b <= c || a + c <= b || b + c <=a){
            System.out.print("Day khong phai la tam giac \n");
        }
        else {
            Stamgiac = dienTichTamGiac(a, b, c);
            System.out.println("Dien tich tam giac la :" + Stamgiac +"\n");
        }
    }
    //M6
    public static void M6_VeHinh(){
        double distance;
        System.out.print("nhap rad :");
        int rad = scanner.nextInt();
        // Use for loop for row wise
        for (int row = 0; row <= 2 * rad; row++) {
            for (int col = 0; col <= 2 * rad; col++) {
                distance = Math.sqrt((row - rad) * (row - rad) + (col - rad) * (col - rad));
                if (distance > rad - 0.5 && distance < rad + 0.5)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        boolean check = true;
        while(check) {
            System.out.print("nhap number :");
            int number = scanner.nextInt();
            switch (number) {
                case 1 -> M1_Tinhtongsonguyen();
                case 2 -> M2_maxChars();
                case 3 -> M3_Sort();
                case 4 -> M4_SoNguyenTo();
                case 5 -> M5_STamGiac();
                case 6 -> M6_VeHinh();
                case 7 ->
                    check = false;
                default -> {
                }
            }
        }
    }
}
