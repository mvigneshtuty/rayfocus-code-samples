package com.rayfocus.java.utils.timesheet;

public class TimeSheetApp {

	public static void main(String[] args) {
		int targetHours = 298;
		int targetMinutes = 12;
		int totalTargetTimeInMinutes = (targetHours * 60) + targetMinutes;
		System.out.println("totalTargetTimeInMinutes : " + totalTargetTimeInMinutes);
		
		// Per day standard(std) in Hexaware
		// total standard time : 9 hours 15 minutes 
		//int stdDailyTimeInMinutes = (9 * 60) + 15;
		//System.out.println("stdDailyTimeInMinutes : "+stdDailyTimeInMinutes);
		
		// Approximation Advice
		int remainingWorkDays = 32;
		System.out.println("Remaining work days : " + remainingWorkDays);
		int approxPerDayMinutes = totalTargetTimeInMinutes / remainingWorkDays;
		int approxPendingMinutes = totalTargetTimeInMinutes % remainingWorkDays; 
		int approxPerDayHours = approxPerDayMinutes / 60;
		int perDayDeltaPendingMinutes =  approxPerDayMinutes % 60;
		int revisedPendingMinutes = ( perDayDeltaPendingMinutes * remainingWorkDays ) + approxPendingMinutes;
		//int approxPerDayMinutes = 555%60;
		//System.out.println("approxPerDayMinutes: "+approxPerDayMinutes);
		//System.out.println("approxPerDayPendingMinutes : "+approxPendingMinutes);
		
		//System.out.println("approxPerDayHours : "+approxPerDayHours);
		//System.out.println("perDayDeltaPendingMinutes : "+perDayDeltaPendingMinutes);
		//System.out.println("revisedPendingMinutes : "+revisedPendingMinutes);
		
		int dailyMinutes = revisedPendingMinutes / remainingWorkDays;
		int pendingDailyMinutes = revisedPendingMinutes % remainingWorkDays;
		String perDayWorkTime = approxPerDayHours + " hrs, "+dailyMinutes+" minutes";
		int pendingSeconds = pendingDailyMinutes * 60;
		int revisedDailySeconds =  pendingSeconds / remainingWorkDays;
		perDayWorkTime = perDayWorkTime + ", "+revisedDailySeconds+" seconds";
		if(pendingSeconds % remainingWorkDays > 0) {
			perDayWorkTime = perDayWorkTime + "[ additional "+(pendingSeconds % remainingWorkDays)+" seconds overall ]";
		}
		System.out.println("Total Remaining Work Time : ("+ perDayWorkTime + ") => for "+remainingWorkDays +" days");
	}

}
