import java.util.Scanner;
public class MergeSort {

	private static void merge(int[] A, int start, int mid, int end)
	{
		int[] left = new int[(mid-start+1)];
		int[] right = new int[(end-mid)];
		int k=start,i=0,j=0;
		for(i=0;i<left.length;i++)
			left[i]=A[start+i];
		for(i=0;i<right.length;i++)
			right[i]=A[mid+i+1];
		i=0;
		while(k<end && i<left.length && j<right.length) // merges elements in a sorted way in thr original array
			if(left[i]<right[j])
					A[k++]=left[i++];
			else
					A[k++]=right[j++];
		while(i<left.length) // copies the remaining elements from left array
			A[k++]=left[i++];
		while(j<right.length)// copies the remaining elements from right array
			A[k++]=right[j++];	
	}
		
	public static void MergeSort(int[] A, int start, int end)
	{
		if(start<end)
		{
			int mid =(int)Math.floor((start+end)/2); 
			// sort first and second halves
			MergeSort(A,start,mid);
			MergeSort(A,mid+1,end);
			merge(A, start, mid, end); // merge the sorted halves
		}
	}
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of elements ");
		int len = s.nextInt();
		int[] A = new int[len];
		System.out.println("Enter the elements one by one ");
		for(int i=0;i<len;i++)
			A[i]=s.nextInt();
		s.close();
		MergeSort(A,0,A.length-1);
    System.out.println("Sorted Array");
		for(int i=0;i<A.length;i++)
			System.out.println(A[i]);	
	}
}
