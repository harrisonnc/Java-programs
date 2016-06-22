//Nicholas Harrison
//Midterm
//Due on Friday 10/11
//turned in on 10/9
/*
Input: there is no input, all of the information is hard coded in
Output: returns information about the Routes
Summary: this code was meant to test our ability to implements different portions of object oriented programming
and be able to implement it all together
*/

import java.util.*;
//runner class
public class RouteTest
{
	//main method
	public static void main (String [] args)
	{
	double numvehicles;
	String vename;
	double totalstaff=0;
	double totalbuses=0;
	double totalcrv=0;
	double totalcre=0;
	double totalurv=0;

	Routes[] array=new Routes[5];
	array[0]= new BusesShared("Bus 77",5.0,12.0,7.0,40.0);
	array[1]= new BusesHybrid("Silver Line Bus",7.0,20.0,10.0,5.0,3.0,1.0);
	array[2]= new UrbanDedicated("Red Line",16.0,18.0,8.0,6.0,1.0,2.0,17.0);
	array[3]= new UrbanHybrid("Green Line", 12.0, 10.0,10.0,2.0,1.0,2.0,11.0,19.0);
	array[4]= new CommuterDedicated("Lowell Line", 25.0,30.0,30.0,5.0,1.0,2.0,1.0,6.0);

	//loop that counts through the array
	for (Routes route:array)
	{
		numvehicles=route.getVehicles();
		vename=route.getName();
		//staff=route.getStaff();


		//searches for the type of route class
		if(route instanceof BusesShared)
		{
		BusesShared sbus = (BusesShared)route;
		System.out.println(vename+" Staff:"+sbus.getStaff()+" Vehicles:"+numvehicles+" Stops:"+sbus.getStops());
		totalstaff+=sbus.getStaff();
		totalbuses+=sbus.getVehicles();
		}

		if(route instanceof BusesHybrid)
		{
		BusesHybrid hbus=(BusesHybrid)route;
		System.out.println(vename+" Staff:"+hbus.getStaff()+" Vehicles:"+numvehicles+" Stations:"+hbus.getStations()+" Stops:"+hbus.getStops());
		totalstaff+=hbus.getStaff();
		totalbuses+=hbus.getVehicles();
		}

		if (route instanceof UrbanDedicated)
		{
		UrbanDedicated durban=(UrbanDedicated)route;
		System.out.println(vename+" Staff:"+durban.getStaff()+" Vehicles:"+numvehicles+" Stations:"+durban.getStations());
		totalstaff+=durban.getStaff();
		totalurv+=durban.getVehicles();
		}

		if (route instanceof UrbanHybrid)
		{
		UrbanHybrid hurban=(UrbanHybrid)route;
		//System.out.println();
		System.out.println(vename+" Staff:"+hurban.getStaff()+" Vehicles:"+numvehicles+" Stations:"+hurban.getStations()+" Stops:"+hurban.getStops());
		totalstaff+=hurban.getStaff();
		totalurv+=hurban.getVehicles();
		}

		if (route instanceof CommuterDedicated)
		{
		CommuterDedicated dcommuter=(CommuterDedicated)route;
		System.out.println(vename+" Staff:"+dcommuter.getStaff()+" Vehicles:"+numvehicles+" Engines:"+dcommuter.getEngines()+" Stations:"+dcommuter.getStations());
		totalstaff+=dcommuter.getStaff();
		totalcrv=dcommuter.getVehicles();
		totalcre=dcommuter.getEngines();
		}

  	}

	//output
	System.out.println();
	System.out.println(" Total Staff:"+totalstaff);
	System.out.println(" Buses:"+totalbuses);
	System.out.println(" Urban Rail Vehicles:"+totalurv);
	System.out.println(" Total Commuter Rail Vehicles:"+totalcrv);
	System.out.println(" Total Commuter Rail Engines:"+totalcre);

	}
}