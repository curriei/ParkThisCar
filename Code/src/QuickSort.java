

public class QuickSort {
	public static void sort(ParkingSpot[] p, int lo, int hi){
		if (hi<=lo) return;
		int lt = lo, i=lo+1, gt = hi;
		ParkingSpot v = p[lo];
		while(i<=gt){
			int cmp = p[i].compareTo(v);
			if(cmp<0) exch(p,lt++,i++);
			else if (cmp>0) exch(p,i,gt--);
			else i++;
		}
		sort(p,lo,lt-1);
		sort(p,gt+1,hi);
	}
	private static void exch(ParkingSpot a[], int i, int j){
		ParkingSpot temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
