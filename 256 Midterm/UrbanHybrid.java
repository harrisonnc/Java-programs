public class UrbanHybrid extends Routes implements Vehicles
{
	//instance variables
	double vehicles=0;
	double trainlength=0;
	double addstaff=0;
	double stationstaff=0;
	double numstops=0;
	double numstation=0;

	//constructor
	public UrbanHybrid(String name, double length, double speed, double hway,double trainlength, double addstaff,double stationstaff, double numstation, double numstops)
	{
		super(name,length,speed,hway);
		this.trainlength=trainlength;
		this.stationstaff=stationstaff;
		this.addstaff=addstaff;
		this.numstops=numstops;
		this.numstation=numstation;
	}

	//getVehicle method to return the number of vehicles
	public double getVehicles()
	{
		vehicles=2*60*routeLength*1.25*trainlength/(avgSpeed*headway);
		return Math.round(vehicles*100.0)/100.0;
	}

	//returns the number of stops the vehicle will make
	public double getStops()
	{
		return numstops;
	}

	//returns the number of stations
	public double getStations()
	{
		return numstation;
	}

	//returns the staff
	public double getStaff()
	{
		return Math.round(((vehicles/trainlength)+(addstaff*(vehicles/trainlength))+(stationstaff*numstation))*100.0)/100.0;
	}


}