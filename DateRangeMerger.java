/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Date{
    public int day;
    public String month;
    public int year;
    public void setDate(String date_str)
    {
        String[] arrOfStr = date_str.split(" ", 5);
        this.day = Integer.parseInt(arrOfStr[0]);
        this.month = arrOfStr[1];
        this.year = Integer.parseInt(arrOfStr[2]);
    }
    public void display()
    {
        System.out.print(day+" "+month+" "+year);
    }
}

class DateRange{
    public Date m_startDate, m_endDate;
    public static DateRange[] dateMerger(DateRange[] dates)
    {
       DateRange[] result = new DateRange[dates.length];
       DateRange tempRange = dates[0];
       int i,j=0;
       for(i=1;i<dates.length;i++)
       {
	    int endMonth, startMonth;
		endMonth = findMonth(tempRange.m_endDate.month);
		startMonth = findMonth(dates[i].m_startDate.month);

        if(tempRange.m_endDate.year == dates[i].m_startDate.year &&
           endMonth == startMonth &&
           tempRange.m_endDate.day >= dates[i].m_startDate.day)
        {
           tempRange.m_endDate = dates[i].m_endDate;
        }
        else if(tempRange.m_endDate.year == dates[i].m_startDate.year &&
           endMonth > startMonth &&
           tempRange.m_endDate.day >= dates[i].m_startDate.day)
        {
           tempRange.m_endDate = dates[i].m_endDate;
        }
        else
        {
            result[j] = tempRange;
            if(i<(dates.length-1))
            tempRange = dates[i];
            j++;
        }
       }
       result[j] = tempRange;
       return result;
    }
	public static int findMonth(String month)
	{
		String months[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		for(int i=0;i<months.length;i++)
		{
			if(month.equals(months[i]))
			{
				return i+1;
			}		
		}
		return 0;
	}
    public void disRange()
    {
        m_startDate.display();
        System.out.print("-");
        m_endDate.display();
        System.out.println();
    }
};

public class Main{

 
 
     public static void main(String []args){
        DateRange[] inputDates = new DateRange[4];
        Date startDate,endDate;
        
        inputDates[0]=new DateRange();
        startDate = new Date();
        endDate = new Date();
        startDate.setDate("01 Jan 2014");
        endDate.setDate("30 Jan 2014");
        inputDates[0].m_startDate = startDate;
        inputDates[0].m_endDate = endDate;
        
        inputDates[1]=new DateRange();
        startDate = new Date();
        endDate = new Date();
        startDate.setDate("15 Jan 2014");
        endDate.setDate("15 Feb 2014");
        inputDates[1].m_startDate = startDate;
        inputDates[1].m_endDate = endDate;
        
        inputDates[2]=new DateRange();
        startDate = new Date();
        endDate = new Date();
        startDate.setDate("10 Mar 2014");
        endDate.setDate("15 Apr 2014");
        inputDates[2].m_startDate = startDate;
        inputDates[2].m_endDate = endDate;
        
        inputDates[3]=new DateRange();
        startDate = new Date();
        endDate = new Date();
        startDate.setDate("10 Apr 2014");
        endDate.setDate("15 May 2014");
        inputDates[3].m_startDate = startDate;
        inputDates[3].m_endDate = endDate;
        DateRange[] resultDates = DateRange.dateMerger(inputDates);
        System.out.println("Final Output after Merge :");
        for(int i=0;i<resultDates.length;i++)
        {
            if(resultDates[i] != null)
            resultDates[i].disRange();
        }
     }
}