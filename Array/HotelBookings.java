/*
 * 
    A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .

    Input:


    First list for arrival time of booking.
    Second list for departure time of booking.
    Third is K which denotes count of rooms.

    Output:

    A boolean which tells whether its possible to make a booking. 
    Return 0/1 for C programs.
    O -> No there are not enough rooms for N booking.
    1 -> Yes there are enough rooms for N booking.
    Example :

    Input : 
            Arrivals :   [1 3 5]
            Departures : [2 6 8]
            K : 1

    Return : False / 0 

    At day = 5, there are 2 guests in the hotel. But I have only one room. 
 */
package interviewprep.Array;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class HotelBookings {
       public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        /**
         *
            1. Create event points for every interval start, and end. 
            2. Sort it according to the day. 
            3. Now, iterate over them one by one. If you encounter a start, then the number of active guests increase by one. If you encounter an end, the number of active guests decrease by one. 
            4. If at any point, the number of active guests exceed K, we know that scheduling is not possible. 

         */
         
        
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
Link-
https://www.interviewbit.com/problems/hotel-bookings-possible/
Notes-
Code is self Explainatory.

*/
