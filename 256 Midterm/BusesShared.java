public class BusesShared extends Routes implements Vehicles
{
	//instance variables
	double vehicles=0;
	double numstops=0;

	//constructor
	public BusesShared(String name, double length, double speed, double hway, double numstops)
	{
		super(name,length,speed,hway);
		this.numstops=numstops;
	}

	//returns the number of stops
	public double getStops()
	{
		return numstops;
	}

	//returns the number of vehicles
	public final double getVehicles()
	{
		vehicles=2*60*routeLength*1.20/(avgSpeed*headway);
		return  Math.round(vehicles*100.0)/100.0;
	}

	//returns the number of staff
	public final double getStaff()
	{
		return  Math.round(vehicles*100.0)/100.0;
	}


}