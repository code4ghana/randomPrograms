package quickSorting;

import java.util.Comparator;

public class InPlaceQuickSort {
	public InPlaceQuickSort() {
		// TODO Auto-generated constructor stub
	}

	public void sort(Comparable<Object>[] array, int leftstart, int pivot,
			int rightend) {
		int left = leftstart;
		int right = rightend;
		if (array.length < 2) {
			return;
		}
		// left includes pivot and right is everything above
		while (left <= pivot && right > pivot) {
			while (new myCompare().compare(array[left], array[pivot]) < 1
					&& left <= pivot) {
				left++;
			}
			while (new myCompare().compare(array[right], array[pivot]) > 0
					&& right > pivot) {
				right--;
			}
			// swap them
			Comparable<Object> tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
			if (pivot == left - 1) {
				pivot = ++right;
			} else if (pivot == right + 1) {
				pivot = --left;
			}
		}
		sort(array, left, (pivot + pivot - 1) / 2, pivot - 1);
		sort(array, pivot + 1, (pivot + pivot - 1) / 2, right);

	}

	public static void main(String[] args) {
		Comparable[] list = { 3, 7, 8, 5, 2, 1, 9, 5, 4 };
		InPlaceQuickSort mySorter = new InPlaceQuickSort();
		mySorter.sort(list, 0, 4, 8);
	}

	class myCompare implements Comparator {

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			if (o1 instanceof Integer) {
				int a = (Integer) o1;
				int b = (Integer) o2;
				if (a <= b)
					return -1;
				if (a > b)
					return 1;
				return 0;
			}
			return 0;
		}

	}

}
