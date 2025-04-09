package ch12.addr2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateUtil {
	/**
	 * 날짜 형식이 올바른지 여부를 판별
	 * 
	 * @param dateString	문자열의 날짜
	 * @return		형식이 올바른지의 여부(true/false)
	 */
	public boolean isValidDate(String dateString) {
		try {
			if (dateString.length() != 8 && dateString.length() != 10) {
				return false;
			}

			dateString = dateString.replaceAll("(\\-|\\.|\\/)", "");
			
			String s;
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
			LocalDate localDate = LocalDate.parse(dateString, formatter);
			// 2001-02-31=>2001-02-28로 변환, 2000-02-32=>예외발생
			
			s = localDate.format(formatter);
			if( dateString.equals(s) ) {
				return true;
			}

		} catch (Exception e) {
			// 예외가 발생한 경우 false를 반환
			return false;
		}

		return false;
	}
	
	/**
	 * 문자열을 LocalDate 	형으로 변환하여 반환
	 * @param dateString	변환 할 날짜(String)
	 * @return			변환 된 날짜(LocalDate)
	 */
	public LocalDate toLocalDate(String dateString) {
		LocalDate result = null;
		
		if (!isValidDate(dateString)) {
			// 메소드의 인자값이 잘못 되었다는 예외를 발생 시킴
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + dateString);
		}
		
		try {
			dateString = dateString.replaceAll("\\-|\\/|\\.", "");
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
			
			result = LocalDate.parse(dateString, formatter);
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + dateString);
		}
		
		return result;
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
	 * LocalDate형을 String형으로 변환(yyyy-MM-dd)하여 반환
	 * @param localDate	변환할 날짜
	 * @return			변환된 문자열(yyyy-MM-dd)
	 */
	public String toString(LocalDate localDate) {
		String str = null;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		str = localDate.format(formatter);

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

		try {
			LocalDate today = LocalDate.now();
			
			LocalDate birthDate = toLocalDate(birth);
			age = (int)birthDate.until(today, ChronoUnit.YEARS);
			
			/*
			LocalDate date = today.withYear(birthDate.getYear());
			age = today.getYear() - birthDate.getYear();
			if(date.isBefore(birthDate)) {  // date < birthDate
				age--;
			}
			*/
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + birth);
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
			LocalDate localDate = toLocalDate(dateString);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E");
			result = localDate.format(formatter); // 일, 월, ... , 토

		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd)");
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
			LocalDate localDate = toLocalDate(dateString);
			
			// D : 년의 몇 번째 일(1~366), d : 월의 몇 번째 일(1~31)
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("D");
			String s = localDate.format(formatter);
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
			LocalDate localDate = toLocalDate(dateString);
			
			// w : 년의 몇 번째 주(1~53), W : 월의 몇 번째 주(1~5)
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("w");
			String s = localDate.format(formatter);
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

		try {
			LocalDate localDate = toLocalDate(dateString);
			
			b = localDate.isLeapYear();
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd)");
		}

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
		long diff = 0;

		try {
			LocalDate beginLocal = toLocalDate(beginDate);
			LocalDate endLocal = toLocalDate(endDate);
			
			diff = beginLocal.until(endLocal, ChronoUnit.DAYS);
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd)");
		}


		return diff;
	}

	/**
	 * 두 날짜 사이의 차이(시간)를 구하여 반환
	 * 
	 * @param beginDateTime	차이를 구할 시작 날짜
	 * @param endDateTime	차이를 구할 끝나는 날짜
	 * @return				날짜 차이(시간)
	 */
	public long toDiffHours(String beginDateTime, String endDateTime) {
		long diff = 0;

		try {
			beginDateTime = beginDateTime.replaceAll("\\-|\\/|\\.", "");
			endDateTime = endDateTime.replaceAll("\\-|\\/|\\.", "");
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
			
			LocalDateTime beginLocal = LocalDateTime.parse(beginDateTime, formatter);
			LocalDateTime endLocal = LocalDateTime.parse(endDateTime, formatter);
			
			diff = beginLocal.until(endLocal, ChronoUnit.HOURS);
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd HH:mm:ss, yyyy-MM-dd HH:mm:ss)");
		}


		return diff;
	}

	/**
	 * 기준날짜의 며칠째 되는 날을 구하는 메소드
	 * 
	 * @param dateString	기준날짜
	 * @param days	며칠째 되는 날을 계산할 일자
	 * @return		며칠후의 날짜(yyyy-MM-dd)
	 */
	public String toDaysLater(String dateString, int days) {
		String result = null;

		try {
			LocalDate localDate = toLocalDate(dateString);
			LocalDate targetDate = localDate.plusDays(days);
			
			// result = targetDate.toString();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");			
			result = targetDate.format(formatter);
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd)");
		}


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

		try {
			/*
			 - TemporalAdjusters
			   : LocalDate, LocalDateTime 등 시간관리 클래스로 날짜를 지정하고 지정된 날짜를 조정하는데 쓰인다.
			   : with와 함께 사용
			   : TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY)
			     이전 일요일(오늘 포함)
			   : TemporalAdjusters.previous(DayOfWeek.SUNDAY)
			     이전 일요일
			 */
			LocalDate localDate = toLocalDate(dateString);
			LocalDate targetDateTime = localDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
					
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");			
			result = targetDateTime.format(formatter);
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + dateString);
		}
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

		try {
			/*
			   : TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)
			     다음 토요일(오늘 포함)
			   : TemporalAdjusters.next(DayOfWeek.SATURDAY)
			     다음 토요일
			 */
			LocalDate localDate = toLocalDate(dateString);
			LocalDate targetDateTime = localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");			
			result = targetDateTime.format(formatter);
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + dateString);
		}

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

		try {
			LocalDate localDate = toLocalDate(dateString);
			LocalDate targetDate = localDate.plusDays(1);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");			
			result = targetDate.format(formatter);
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + dateString);
		}

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

		try {
			LocalDate localDate = toLocalDate(dateString);
			LocalDate targetDate = localDate.minusDays(1);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");			
			result = targetDate.format(formatter);
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + dateString);
		}

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
