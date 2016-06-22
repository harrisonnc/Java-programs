public class BusesHybrid extends Routes implements Vehicles
{
	//instance variables
	double vehicles=0;
	double numstops=0;
	double numstation=0;
	double stationstaff=0;

	//constructor
	public BusesHybrid(String name, double length, double speed, double hway, double numstops ,double numstation,double stationstaff)
	{
		super(name,length,speed,hway);
		this.numstops=numstops;
		this.numstation=numstation;
		this.stationstaff=stationstaff;
	}

	//returns the number of stops
	public double getStops()
	{
		return numstops;
	}

	//returns the number stations
	public double getStations()
	{
			return numstation;
	}

	//returns the number of vehicles
	public final double getVehicles()
	{
		vehicles=2*60*routeLength*1.15/(avgSpeed*headway);
		return Math.round(vehicles*100.0)/100.0;
	}

	//returns the number of staff
	public final double getStaff()
	{
		return Math.round((vehicles+(stationstaff*numstation))*100.0)/100.0;
	}


}