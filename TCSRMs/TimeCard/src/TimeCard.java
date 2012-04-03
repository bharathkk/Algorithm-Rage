import java.util.*;

public class TimeCard {
    
    static class TimeStamp {
        int hh,mm;
        boolean hourOfDay;
        
        public TimeStamp(int hh, int mm, boolean flag) {
            this.hh = hh%12;
            this.mm = mm;
            hourOfDay = flag;
        }
        
        public int getHh() {
            return hh;
        }
        
        public int getMm() {
            return mm;
        }

        public boolean hourOfDay() {
            return hourOfDay;
        }

        public int getHourDiff(TimeStamp obj) {
            int ans;
            ans = obj.hh - hh;
            if(obj.mm > mm)
                ans--;
            if(obj.hourOfDay != hourOfDay)
                ans += 12 - hh;
            
            return ans;
        }
        
        public int getMinDiff(TimeStamp obj) {
            int ans;
            if(obj.mm > mm)
               ans = obj.mm - mm;
            else
                ans = obj.mm + 60 - mm;

            return ans;
        }
    }
	public String leave(String[] time) {
        int len = time.length;
        TimeStamp[] workHours = new TimeStamp[len];
        int hh,mm,thh=0,tmm=0,hh1,mm1;
        StringBuilder soln = new StringBuilder();
        String amPm,amPm1;
        boolean flag=false;
        StringTokenizer st;
        st = new StringTokenizer(time[0]);
        if(st.nextToken().equals("am"))
            flag = true;
        workHours[0] = new TimeStamp(Integer.parseInt(st.nextToken(":")),Integer.parseInt(st.nextToken(",")),flag);
        for ( int i = 1; i < len; i++ ) {
            flag = false;
            if(i % 2 == 0 ) {
                st = new StringTokenizer(time[0]);
                hh1 = Integer.parseInt(st.nextToken(":"));
                mm1 = Integer.parseInt(st.nextToken(","));
                amPm1 = st.nextToken();
                if(amPm1.equals("am"))
                    flag = true;
                workHours[i] = new TimeStamp(hh1,mm1,flag);
                thh += workHours[i-1].getHourDiff(workHours[i]);
                tmm += workHours[i-1].getMinDiff(workHours[i]);
                if(tmm >= 60) {
                    thh ++;
                    tmm %= 60;
                }
            }
            else {
                st = new StringTokenizer(time[0]);
                hh = Integer.parseInt(st.nextToken(":"));
                mm = Integer.parseInt(st.nextToken(","));
                amPm = st.nextToken();
                if(amPm.equals("am"))
                    flag = true;
                workHours[i] = new TimeStamp(hh,mm,flag);
            }

            if(thh < 20) {
                return "BELOW 40";
            }
            else {
                
            }
        }
		return soln.toString();
	}
}
