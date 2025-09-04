import java.util.Random;

public class HW5NO5 {
    public static int[] RSelect(int[] array){
        int l = (array.length - 1);
        for(int i = 0; i < l; i++){
            int max = i;
            for(int j = i + 1; j < l + 1; j++){
                if(array[j] > array[max]){
                    max = j;
                }
            }
            int temp = array[i];
            array[i] = array[max];
            array[max] = temp;
        }
        return array;
    }
    public static void main(String[] args) {
        int[] Arr = new int[10];
        for(int i = 0; i < 10; i++){
            Random ran = new Random();
            Arr[i] = ran.nextInt(0, 100);
        }
        System.out.println("10 numbers are generated and they are");
        for(int i = 0; i < 10; i++){
            System.out.print(Arr[i] + " ");
        }
        System.out.println();
        RSelect(Arr);
        System.out.println("10 numbers are sorted and they are");
        for(int i = 0; i < 10; i++){
            System.out.print(Arr[i] + " ");
        }
    }
}