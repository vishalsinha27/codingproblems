package ss.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DatePainter {
  private static SimpleDateFormat format = new SimpleDateFormat("yyyy,MM,dd");
  private static Calendar calendar = Calendar.getInstance();


  public static void main(String[] args) throws ParseException {
 
    Map<Date, Long> dateMap = new HashMap<Date, Long>();
    try {
      
        dateMap.put(format.parse("2018, 02, 1"), 1L);
        dateMap.put(format.parse("2018, 02, 2"), 3L);
        dateMap.put(format.parse("2018, 02, 3"), 4L);
        dateMap.put(format.parse("2018, 02, 4"), 2L);
        dateMap.put(format.parse("2018, 02, 5"), 3L);

        dateMap.put(format.parse("2018, 02, 6"), 1L);
        dateMap.put(format.parse("2018, 02, 7"), 3L);
        dateMap.put(format.parse("2018, 02, 8"), 4L);
        dateMap.put(format.parse("2018, 02, 9"), 2L);
        
       
         dateMap.put(format.parse("2018, 02, 10"), 3l);
         dateMap.put(format.parse("2018, 02, 20"), 1l);
         dateMap.put(format.parse("2018, 02, 22"), 3l);
         
         dateMap.put(format.parse("2018, 02, 27"), 4l);
         dateMap.put(format.parse("2018, 03, 01"), 2l);
         
         dateMap.put(format.parse("2018, 03, 10"), 3l);
         dateMap.put(format.parse("2018, 03, 11"), 3l);
         dateMap.put(format.parse("2018, 03, 15"), 3l);
         
         
        for (Map.Entry<String, Long> entry : getGroupedDateMap(dateMap).entrySet()) {

            System.out.println(entry.getKey() + "   " + entry.getValue());
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    
    
}

  private static Map<String, Long> getGroupedDateMap(Map<Date, Long> dateMap) {
    if(dateMap == null) {
      return null;
    }
    // sort keys based on date.
    Set<Date> dateSet = dateMap.keySet() ;
    TreeSet< Date> sortedSet = new TreeSet<Date>() ;
    for(Date date: dateSet) {
      sortedSet.add(date) ;

    }
    // divide the keys in week bucket
    LinkedHashMap<String, Long> printMap = new LinkedHashMap<String, Long>() ;
    long count = 0 ;
    Date startDate = null ;
    Date previousDate = null ;
    boolean added = false ;
    for(Date date : sortedSet) {
      boolean b = dateBelongsToWeekBucket(startDate, date) ;
      added = false ;
      if(b) {
        count = count + dateMap.get(date) ;
      } else {
        
        addToPrintMap(printMap, startDate, previousDate, count);
        added = true ;
        startDate = date ;
        //reset the count for new week.
        count = dateMap.get(date) ;
        
        

      }
      previousDate = date ;
    }
    if(!added) {
      addToPrintMap(printMap, startDate, previousDate, count);

    }
    return printMap;
  }

  private static void addToPrintMap(Map<String, Long> printMap, Date startDate, Date previousDate, long count) {
    if(startDate!=null) {
      previousDate = previousDate!=null ? previousDate : startDate ;
      String key = format.format(startDate) + " - " + format.format(previousDate) ;
      printMap.put(key, count) ;
    }

  }
  private static  boolean dateBelongsToWeekBucket(Date startDate, Date date) {
    boolean retVal = false ;
    if(startDate==null) {
      return retVal ;
    }
    /*
    if(startDate.getMonth()!= date.getMonth()) {
      return retVal ;
    }
    */
    calendar.setTime(startDate);
    // get the start sunday
    calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    // get the end date...
    calendar.add(Calendar.DATE, 6);
    Date endDate = calendar.getTime() ;
    retVal = endDate.compareTo(date) >= 0  ;
    /*
    if(date.getMonth() == endDate.getMonth()) {
      // for the same month check if the endDate is greater then date. If yes then it is within the week.
    } 
    */ 
    return retVal;
    
  }

}
