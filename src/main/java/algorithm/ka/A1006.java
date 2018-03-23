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

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ejpark
 *
 */
public class A1006 {

	public static void main(String[] args) {
		String[][] logTimes = { { "2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s" },
				{ "2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s" },
				{ "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s",
						"2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s",
						"2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s",
						"2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s",
						"2016-09-15 21:00:02.066 2.62s" } };
		for (int i = 0; i < logTimes.length; i++) {
			String[] logs = logTimes[i];
			Date[][] startEndTime = new Date[logs.length][2];
			Date[] checks = new Date[logs.length * 2];
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			for (int j = 0; j < logs.length; j++) {
				String[] logStr = logs[j].split(" ");
				String date = logStr[0];
				String time = logStr[1];
				String durationStr = logStr[2];
				int duration = new BigDecimal(durationStr.substring(0, durationStr.length() - 1)).movePointRight(3)
						.intValue()-1;
				try {
					Date endTime = sdf.parse(String.format("%s %s", date, time));
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(endTime);
					calendar.add(Calendar.MILLISECOND, duration * (-1));
					Date startTime = calendar.getTime();
					startEndTime[j][0] = startTime;
					startEndTime[j][1] = endTime;
					checks[j * 2] = startTime;
					checks[(j * 2) + 1] = endTime;
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
			int maxCnt = 0;
			for (int j = 0; j < checks.length; j++) {
				Date start = checks[j];
				Calendar current = Calendar.getInstance();
				current.setTime(start);
				current.add(Calendar.SECOND, 1);
				current.add(Calendar.MILLISECOND, -1);
				Date end = current.getTime();
				int cnt = 0;
				for (int k = 0; k < startEndTime.length; k++) {
					Date s = startEndTime[k][0];
					Date e = startEndTime[k][1];
					if ((s.after(start)||s.equals(start)) && (s.before(end)||s.equals(end)) || (e.after(start)||e.equals(start)) && (e.before(end)||e.equals(end))
							|| (s.before(start)||s.equals(start)) && (e.after(end)||e.equals(end))) {
						cnt++;
//						System.out.println(sdf.format(start) + " | " + sdf.format(end)+"==="+sdf.format(s) + " | " + sdf.format(e)+" == "+cnt);
					}
				}
				if (cnt > maxCnt) {
					maxCnt = cnt;
				}
			}
			System.out.println(maxCnt);
		}
	}

}
/*
 * 출력: 1 출력: 2 출력: 7
 */
