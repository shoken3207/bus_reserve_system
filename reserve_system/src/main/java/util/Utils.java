package util;

public class Utils {
	public int[] parseIntegerToIntArray(Integer[] target) {
		int[] nums = new int[target.length];
		int i = 0;
		for (Integer num: target) {
			nums[i] = num;
			i++;
		}

		return nums;
	}
}
