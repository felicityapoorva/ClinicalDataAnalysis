package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import bean.AdmissionDiagnosis;
import model.ConfigList;

public class Util {

	public static Date getDateFromString(String str){

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date date = null;
		try {
			date = simpleDateFormat.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("date : "+simpleDateFormat.format(date));
		return date;

	}

	public static String ordinal(int c) {
		int r100 = (c % 100);
		int r10 = (c % 10);
		if(r10 == 1 && r100 != 11) {
			return c + "st";
		} else if(r10 == 2 && r100 != 12) {
			return c + "nd";
		} else if(r10 == 3 && r100 != 13) {
			return c + "rd";
		} else {
			return c + "th";
		}
	}


	public static int countNoOfPatients(String disease){

		List<AdmissionDiagnosis> list=ConfigList.getDiagnosisList();
		int count=0;
		for(AdmissionDiagnosis obj: list){
			String[] words = obj.getPrimaryDiagonsisDesc().split(" ");
			for(String str:words){
				if(disease.toUpperCase().equals(str.toUpperCase())){
					count++;
				}
			}
		}
		return count;


	}
}
