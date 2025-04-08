package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	/**
	 * 날짜 형식이 올바른지 여부를 판별
	 * 
	 * @param dateString	문자열의 날짜
	 * @return		형식이 올바른지의 여부(true/false)
	 */
	public boolean isValidDate(String dateString) {
		String[] dateFormats = {
				"yyyy-MM-dd", "yyyy.MM.dd", "yyyy/MM/dd", "yyyyMMdd"};
		
		for(String format: dateFormats) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			sdf.setLenient(false); // 엄격한 날짜 검사
				// 엄격한 날짜 검사에서는 2025-04-31은 false
			
			try {
				sdf.parse(dateString);
				return true;
			} catch (Exception e) { // ParseException
				// 예외가 발생하면 해당 형식은 유효하지 않음
			}
		}
		
		return false;
	}

	public boolean isValidDate2(String dateString) {
		try {
			if (dateString.length() != 8 && dateString.length() != 10) {
				return false;
			}

			/*
			// try ~ catch 안에 있으므로 생략 가능
			String p = "^\\d{4}(\\.|\\-|\\/)?\\d{2}(\\.|\\-|\\/)?\\d{2}$";
			if (! dateString.matches(p)) {
				return false;
			}
			*/
			
			dateString = dateString.replaceAll("(\\-|\\.|\\/)", "");
			if (dateString.length() != 8) {
				return false;
			}

			int y = Integer.parseInt(dateString.substring(0, 4));
			int m = Integer.parseInt(dateString.substring(4, 6));
			int d = Integer.parseInt(dateString.substring(6));

			Calendar cal = Calendar.getInstance();
			cal.set(y, m - 1, d);

			int y1 = cal.get(Calendar.YEAR);
			int m1 = cal.get(Calendar.MONTH) + 1;
			int d1 = cal.get(Calendar.DATE);

			if (y != y1 || m != m1 || d != d1) {
				return false;
			}

		} catch (Exception e) {
			// 예외가 발생한 경우 false를 반환
			return false;
		}

		return true;
	}

	/**
	 * String형 날짜를 Date형으로 변환하여 반환
	 * 
	 * @param dateString	변환할 날짜
	 * @return			변환된 Date형 날짜
	 */
	public Date toDate(String dateString) {
		Date result = null;

		try {
			if (!isValidDate(dateString)) {
				throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + dateString);
						// 매개변수가 잘못될 때 사용되는 unchecked exception
			}

			dateString = dateString.replaceAll("(\\-|\\.|/)", "");

			SimpleDateFormat sformat = new SimpleDateFormat("yyyyMMdd");
			result = sformat.parse(dateString);

		} catch (ParseException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	/**
	 * Date형을 String형으로 변환(yyyy-MM-dd)하여 반환
	 * 
	 * @param date	변환할 날짜
	 * @return		변환된 문자열(yyyy-MM-dd)
	 */
	public String toString(Date date) {
		String str = null;

		SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd");
		str = sformat.format(date);

		return str;
	}
	
	/**
	 * 생년월일을 이용하여 나이를 계산
	 * 
	 * @param birth	생년월일
	 * @return		나이
	 */
	public int toAge(String birth) {
		int age = -1;

		if (!isValidDate(birth)) {
			// 메소드의 인자값이 잘못 되었다는 예외를 발생 시킴
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + birth);
		}

		birth = birth.replaceAll("(\\-|\\.|\\/)", "");

		Calendar now = Calendar.getInstance();
		String nowMonthDate = String.format("%02d%02d", now.get(Calendar.MONTH)+1, now.get(Calendar.DATE));
		
		int y = Integer.parseInt(birth.substring(0, 4));
		age = now.get(Calendar.YEAR) - y;
		
		// 숫자로 변환하여 비교 가능
		if(birth.substring(4).compareTo(nowMonthDate) > 0) {
			age--;
		}

		return age;
	}

	/**
	 * 날짜에 해당하는 요일을 구하는 메소드
	 * 
	 * @param dateString	요일을 구할 날짜
	 * @return			요일
	*/
	public String toDayOfWeek(String dateString) {
		String result = null;

		try {
			Date d = toDate(dateString);
			
			SimpleDateFormat sformat = new SimpleDateFormat("E");
			result = sformat.format(d); // 일, 월, ... , 토 

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return result;
	}
	
	/**
	 * 날짜가 해당 년도의 몇일째 되는 날인지를 반환
	 * 
	 * @param dateString	일자를 구할 날짜
	 * @return			일자
	*/
	public int dayOfTheYear(String dateString) {
		int result = 0;

		try {
			Date d = toDate(dateString);
			
			// D : 년의 몇 번째 일(1~366), d : 월의 몇 번째 일(1~31)
			SimpleDateFormat sformat = new SimpleDateFormat("D");
			String s = sformat.format(d);
			result = Integer.parseInt(s);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return result;
	}
	
	/**
	 * 날짜가 해당 년도의 몇 주차인지 반환
	 * 
	 * @param dateString	주차를 구할 날짜
	 * @return			주차
	*/
	public int weekOfTheYear(String dateString) {
		int result = 0;

		try {
			Date d = toDate(dateString);
			
			// w : 년의 몇 번째 주(1~53), W : 월의 몇 번째 주(1~5)
			SimpleDateFormat sformat = new SimpleDateFormat("w");
			String s = sformat.format(d);
			result = Integer.parseInt(s);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	/**
	 * 날짜의 년도가 윤년인지를 판별
	 * 
	 * @param dateString	윤년 여부를 판단할 날짜
	 * @return			윤년 여부를 판별하여 윤년이면 true를 리턴
	 */
	public boolean isLeapYear(String dateString) {
		boolean b = false;

		if (!isValidDate(dateString)) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + dateString);
		}

		dateString = dateString.replaceAll("\\-|\\.|/", "");
		int year = Integer.parseInt(dateString.substring(0, 4));

		b = isLeapYear(year);

		return b;
	}

	/**
	 * 년도가 윤년인지를 판별
	 * 
	 * @param year	년도
	 * @return		윤년이면 true를 반환
	 */
	public boolean isLeapYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}

	/**
	 * 두 날짜 사이의 차이(일자)를 구하여 반환
	 * 
	 * @param beginDate	차이를 구할 시작 날짜
	 * @param endDate	차이를 구할 끝나는 날짜
	 * @return			날짜 차이(일자)
	 */
	public long toDiffDays(String beginDate, String endDate) {
		long dif = 0;

		try {
			if ((!isValidDate(beginDate)) || (!isValidDate(endDate))) {
				throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd)");
			}

			beginDate = beginDate.replaceAll("\\-|\\.|/", "");
			endDate = endDate.replaceAll("\\-|\\.|/", "");

			SimpleDateFormat sformat = new SimpleDateFormat("yyyyMMdd");
			Date begin = sformat.parse(beginDate);
			Date end = sformat.parse(endDate);
			dif = (end.getTime() - begin.getTime()) / (1000 * 60 * 60 * 24);

		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd)");
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd)");
		}

		return dif;
	}

	/**
	 * 두 날짜 사이의 차이(시간)를 구하여 반환
	 * 
	 * @param beginDateTime	차이를 구할 시작 날짜
	 * @param endDateTime	차이를 구할 끝나는 날짜
	 * @return				날짜 차이(시간)
	 */
	public long toDiffHours(String beginDateTime, String endDateTime) {
		long dif = 0;

		try {
			beginDateTime = beginDateTime.replaceAll("\\-|\\.|/", "");
			endDateTime = endDateTime.replaceAll("\\-|\\.|/", "");

			SimpleDateFormat sformat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
			Date begin = sformat.parse(beginDateTime);
			Date end = sformat.parse(endDateTime);
			dif = (end.getTime() - begin.getTime()) / (1000 * 60 * 60);

		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd HH:mm:ss, yyyy-MM-dd HH:mm:ss)");
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd HH:mm:ss, yyyy-MM-dd HH:mm:ss)");
		}

		return dif;
	}

	/**
	 * 기준날짜의 며칠째 되는 날을 구하는 메소드
	 * 
	 * @param dateString	기준날짜
	 * @param days		며칠째 되는 날을 계산할 일자
	 * @return			며칠후의 날짜(yyyy-MM-dd)
	 */
	public String toDaysLater(String dateString, int days) {
		String result = null;

		if (!isValidDate(dateString)) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + dateString);
		}

		dateString = dateString.replaceAll("(\\-|\\.|\\/)", "");

		int y = Integer.parseInt(dateString.substring(0, 4));
		int m = Integer.parseInt(dateString.substring(4, 6));
		int d = Integer.parseInt(dateString.substring(6));

		Calendar cal = Calendar.getInstance();
		// cal.set(y, m-1, d+days);

		cal.set(y, m - 1, d);
		cal.add(Calendar.DATE, days);

		result = String.format("%tF", cal);

		/*
		y = cal.get(Calendar.YEAR);
		m = cal.get(Calendar.MONTH)+1;
		d = cal.get(Calendar.DATE);
		result = String.format("%04d%02d%02d", y, m, d);
		*/

		return result;
	}

	/**
	 * 한 주의 시작일(일요일)을 구하는 메소드
	 * 
	 * @param dateString	기준날짜
	 * @return			한 주의 시작일자(yyyy-MM-dd)
	 */
	public String toWeekStart(String dateString) {
		String result = null;

		if (!isValidDate(dateString)) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + dateString);
		}

		dateString = dateString.replaceAll("\\-|\\.|/", "");

		int year = Integer.parseInt(dateString.substring(0, 4));
		int month = Integer.parseInt(dateString.substring(4, 6));
		int day = Integer.parseInt(dateString.substring(6));

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, day);
		cal.getTime();
		/*
		 set() 메소드로 Calendar 필드의 값은 변경 되지만,
		   Calendar의 시간값은 get(), getTime(), getTimeInMillis(), add() 등을
		   호출할때까지 변경되지 않는다.
		  따라서 set ()에 대한 여러 번 호출은 여러 번의 불필요한 계산을 트리거하지 않는다.
		  위에서 getTime()을 호출하지 않으면 시간이 변경되지 않아 초기 날짜의 일요일로 설정된다.
		 */

		cal.set(Calendar.DAY_OF_WEEK, 1); // 요일을 일요일로 설정

		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		day = cal.get(Calendar.DATE);

		/*
		// 다른 방법
		Calendar sday = (Calendar) cal.clone();
		int t = cal.get(Calendar.DAY_OF_WEEK) - 1;
		sday.add(Calendar.DAY_OF_MONTH, t * -1);
		year = sday.get(Calendar.YEAR);
		month = sday.get(Calendar.MONTH) + 1;
		day = sday.get(Calendar.DATE);
		 */

		result = String.format("%4d-%02d-%02d", year, month, day);

		return result;
	}

	/**
	 * 한 주의 마지막일(토요일)을 구하는 메소드
	 * 
	 * @param dateString	기준 날짜
	 * @return			한 주의 마지막일자(yyyy-MM-dd)
	 */
	public String toWeekEnd(String dateString) {
		String result = null;

		if (!isValidDate(dateString)) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + dateString);
		}

		dateString = dateString.replaceAll("\\-|\\.|/", "");

		int year = Integer.parseInt(dateString.substring(0, 4));
		int month = Integer.parseInt(dateString.substring(4, 6));
		int day = Integer.parseInt(dateString.substring(6));

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, day);
		cal.getTime();

		cal.set(Calendar.DAY_OF_WEEK, 7); // 요일을 토요일로 설정

		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		day = cal.get(Calendar.DATE);

		/*
		// 다른 방법
		Calendar eday = (Calendar) cal.clone();
		int t = 7 - cal.get(Calendar.DAY_OF_WEEK);
		eday.add(Calendar.DAY_OF_MONTH, t);
		year = eday.get(Calendar.YEAR);
		month = eday.get(Calendar.MONTH) + 1;
		day = eday.get(Calendar.DATE);
		*/
		result = String.format("%4d-%02d-%02d", year, month, day);

		return result;
	}

	/**
	 * 특정날짜의 다음날짜를 구하는 메소드
	 * 
	 * @param dateString	다음날짜를 구할 날짜
	 * @return			특정날짜의 다음날짜 리턴(yyyy-MM-dd)
	 */
	public String afterDays(String dateString) {
		String result = null;

		if (!isValidDate(dateString)) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + dateString);
		}

		dateString = dateString.replaceAll("\\-|\\.|/", "");

		int year = Integer.parseInt(dateString.substring(0, 4));
		int month = Integer.parseInt(dateString.substring(4, 6));
		int day = Integer.parseInt(dateString.substring(6));

		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);

		cal.add(Calendar.DATE, +1);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		result = formatter.format(cal.getTime());

		return result;
	}

	/**
	 * 특정날짜의 이전날짜를 구하는 메소드
	 * 
	 * @param dateString	이전날짜를 구할 날짜
	 * @return			특정날짜의 이전날짜 리턴(yyyy-MM-dd)
	 */
	public String preDays(String dateString) {
		String result = null;

		if (!isValidDate(dateString)) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + dateString);
		}

		dateString = dateString.replaceAll("\\-|\\.|/", "");

		int year = Integer.parseInt(dateString.substring(0, 4));
		int month = Integer.parseInt(dateString.substring(4, 6));
		int day = Integer.parseInt(dateString.substring(6));

		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);

		cal.add(Calendar.DATE, -1);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		result = formatter.format(cal.getTime());

		return result;
	}

	/**
	 * 해당 년도의 띠를 구하는 메소드
	 * 
	 * @param birth	생년월일
	 * @return		띠
	 */
	public String toTti(String birth) {
		String s = null;

		if (!isValidDate(birth)) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + birth);
		}

		birth = birth.replaceAll("\\-|\\.|/", "");

		int year = Integer.parseInt(birth.substring(0, 4));
		s = toTti(year);

		return s;
	}

	/**
	 * 해당 년도의 띠를 구하는 메소드
	 * 
	 * @param year	년도
	 * @return		띠
	 */
	public String toTti(int year) {
		String t[] = { "원숭이", "닭", "개", "돼지", "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양" };
		return t[year % 12];
	}

	/**
	 * 주민번호가 올바른 형식인지를 리턴하는 메소드(올바르면 true)
	 * 
	 * @param rrn	주민번호
	 * @return		형식이 올바른지 유무
	 */
	public boolean isValidRrn(String rrn) {
		int[] check = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };
		int tot, n, lastNum, chkNum;
		boolean b = false;

		try {
			if (rrn.length() != 14 && rrn.length() != 13) {
				return false;
			}

			if (toBirth(rrn).length() == 0) {
				return false;
			}

			rrn = rrn.replaceAll("-", "");

			tot = 0;
			for (int i = 0; i < 12; i++) {
				n = Integer.parseInt(rrn.substring(i, i + 1));

				tot = tot + (n * check[i]);
			}

			lastNum = Integer.parseInt(rrn.substring(12));
			chkNum = 11 - tot % 11;
			chkNum = chkNum % 10;

			b = lastNum == chkNum;

		} catch (Exception e) {
			return false;
		}

		return b;
	}

	/**
	 * 주민번호를 이용하여 생년월일을 리턴하는 메소드
	 * 
	 * @param rrn	주민번호
	 * @return		생년월일(yyyy-MM-dd)
	 */
	public String toBirth(String rrn) {
		String birth = null;
		int gender;

		try {
			if (rrn.length() != 14 && rrn.length() != 13) {
				throw new IllegalArgumentException("Invalid rrn format: " + rrn);
			}

			rrn = rrn.replaceAll("-", "");
			gender = Integer.parseInt(rrn.substring(6, 7));

			// birth = rrn.substring(0, 6);
			birth = rrn.substring(0, 2) + "-" + rrn.substring(2, 4) + "-" + rrn.substring(4, 6);
			if (gender == 1 || gender == 2 || gender == 5 || gender == 6) {
				birth = "19" + birth;
			} else if (gender == 3 || gender == 4 || gender == 7 || gender == 8) {
				birth = "20" + birth;
			} else if (gender == 0 || gender == 9) {
				birth = "18" + birth;
			}

			if (!isValidDate(birth)) {
				throw new IllegalArgumentException("Invalid rrn format: " + rrn);
			}
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return birth;
	}

	/**
	 * 주민번호를 이용하여 성별을 반환하는 메소드
	 * 
	 * @param rrn	주민번호
	 * @return		성별
	 */
	public String toGender(String rrn) {
		String gender = null;
		int s;

		try {
			if (rrn.length() != 14 && rrn.length() != 13) {
				throw new IllegalArgumentException("Invalid rrn format: " + rrn);
			}

			rrn = rrn.replaceAll("-", "");
			s = Integer.parseInt(rrn.substring(6, 7));

			gender = s % 2 == 1 ? "남자" : "여자";

		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return gender;
	}
}
