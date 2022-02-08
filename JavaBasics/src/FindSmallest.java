public class FindSmallest {
    public static void main(String[] args){
        int[] arr = {5,4,7,2,3};
        System.out.println(findmin(arr));
    }

    public static int findmin(int[] arr) {
        int min = arr[0];
        for(int i = 0;i< arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }
}
