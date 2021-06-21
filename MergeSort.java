import java.util.Random;

public class MergeSort {

    private int[] nums;
    private int[] tempArray;

    public MergeSort(int[] nums) {
        this.nums = nums;
        this.tempArray = new int[nums.length];
    }

    public void mergeSort(int low, int high){

        if(low >= high) return;

        int middle = (low + high) / 2;

        mergeSort(low, middle);
        mergeSort(middle + 1, high);
        merge(low,middle,high);


    }

    private void merge(int low, int middle, int high) {

        for (int i = 0; i < nums.length; i++){
            tempArray[i] = nums[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while((i <= middle) && (j <= high)){
            if(tempArray[i] <= tempArray[j]){
                nums[k] = tempArray[i];
                i++;
            } else {
                nums[k] = tempArray[j];
                j++;
            }
            k++;
        }

        while( i <= middle){
            nums[k] =  tempArray[i];
            k++;
            i++;
        }

        while( j <= high){
            nums[k] =  tempArray[j];
            k++;
            j++;
        }


    }
    void showResults(){
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+" ");
        }
    }

    public static void main(String[] args) {

        Random random = new Random();
        int[] nums = new int[30];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }
        MergeSort mergeSort = new MergeSort(nums);

        mergeSort.mergeSort(0,nums.length - 1);
        mergeSort.showResults();
    }

}
