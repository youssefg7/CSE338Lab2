public class EOMM {

    public String evenOdd(int n){
        if (n%2==0)
            return "even";
        else return "odd";
    }
    public int[] minMax(int arr[]){
        int[] minMax=new int[2];
        minMax[0]=arr[0];
        minMax[1]=arr[0];
        for (int i = 1; i< arr.length; i++){
            if (arr[i]>minMax[1])
                minMax[1] = arr[i];
            else if (arr[i]<minMax[0])
                minMax[0] = arr[i];
        }
        return minMax;
    }

}
