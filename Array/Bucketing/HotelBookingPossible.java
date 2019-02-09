/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array.Bucketing;

/**
 *
 * @author jakadam
 */
import java.util.*;

public class HotelBookingPossible {
  
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
            Collections.sort(arrive);
            Collections.sort(depart);
            int roomsRequired=0,i=0,j=0;
            while(i<arrive.size()  && j<arrive.size() && roomsRequired<=K){
                    if(arrive.get(i)<depart.get(j) ){
                            i++;
                            roomsRequired++;
                    }else{
                            j++;
                            roomsRequired--;
                    }
            }
            if(roomsRequired<=K){
                    return true;
            }else{
                    return false;
            }

    }

}
/*
ProblemUrls:
I-https://www.interviewbit.com/problems/hotel-bookings-possible/
NOTES:

*/