/*******************************************************************************
 * Copyright (c) 2017 ejpark.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU General Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.html
 * 
 * Contributors:
 *     eungjun11@gmail.com - initial API and implementation
 ******************************************************************************/

package algorithm.ka;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * @author ejpark
 *
 */
public class A1003 {

	public static void main(String[] args) {
		int[] nArr = { 1, 2, 2, 1, 1, 10 };
		int[] tArr = { 1, 10, 1, 1, 1, 60 };
		int[] mArr = { 5, 2, 2, 5, 1, 6 };
		String[][] timeTables = { { "08:00", "08:01", "08:02", "08:03" }, { "09:10", "09:09", "08:00" },
				{ "09:00", "09:00", "09:00", "09:00" }, { "00:01", "00:01", "00:01", "00:01", "00:01" }, { "23:59" },
				{ "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
						"23:59", "23:59", "23:59", "23:59", "23:59" } };
		for (int i = 0; i < nArr.length; i++) {
			int n = nArr[i];
			int t = tArr[i];
			int m = mArr[i];
			int totalSeat = n * m;
			String[] timeTable = timeTables[i];
			Arrays.sort(timeTable);
			String departureTime = "09:00";
			int currentCnt = 0;
			String possibleTime = "";
			for (int j = 0; j < n; j++) {
				if (j > 0) {
					departureTime = addMinute(departureTime, t);
				}
				List<String> departCrewTimeList = getAvailableCrewTimes(departureTime, timeTable, currentCnt);
				int departureCnt = departCrewTimeList.size();
				currentCnt += (departureCnt > m ? m : departureCnt);
				totalSeat -= m;
				if (totalSeat == 0) {
					if (departureCnt >= m) {
						possibleTime = addMinute(departCrewTimeList.get(m - 1), -1);
					} else {
						possibleTime = departureTime;
					}
					break;
				}
			}
			System.out.println(possibleTime);
		}
	}

	private static String addMinute(String time, int min) {
		String[] times = time.split(":");
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.HOUR, Integer.parseInt(times[0]));
		calendar.set(Calendar.MINUTE, Integer.parseInt(times[1]));
		calendar.add(Calendar.MINUTE, min);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String rTime = sdf.format(calendar.getTime());
		return rTime;
	}

	private static List<String> getAvailableCrewTimes(String departTime, String[] timeTable, int startIndex) {
		int maxIndex = timeTable.length;
		List<String> availableTimeList = new ArrayList<String>();
		for (int i = startIndex; i < maxIndex; i++) {
			String time = timeTable[i];
			if (departTime.compareTo(time) >= 0) {
				availableTimeList.add(time);
			}
		}
		return availableTimeList;
	}
}
/*
 * "09:00","09:09","08:59","00:00","09:00","18:00"
 * 
 */
