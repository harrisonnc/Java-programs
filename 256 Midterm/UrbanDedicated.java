public class UrbanDedicated extends Routes implements Vehicles
{
	//instance variables
	double vehicles=0;
	double trainlength=0;
	double addstaff=0;
	double numstation=0;
	double stationstaff=0;

	//constructor
	public UrbanDedicated(String name, double length, double speed, double hway,double trainlength, double addstaff, double stationstaff,double numstation)
	{
		super(name,length,speed,hway);
		this.addstaff=addstaff;
		this.numstation=numstation;
		this.trainlength=trainlength;
		this.stationstaff=stationstaff;
	}

	//returns the number of stations
	public double getStations()
	{
		return numstation;
	}

	//returnds the number of vehicles
	public double getVehicles()
	{
		vehicles=2*60*routeLength*trainlength/(avgSpeed*headway);
		return Math.round(vehicles*100.0)/100.0;
	}

	//returns the number of staff
	public double getStaff()
	{
		//System.out.println(vehicles/trainlength);
		//System.out.println(stationstaff*numstation);
		return Math.round(((vehicles/trainlength)+(addstaff*vehicles/trainlength)+(stationstaff*numstation))*100.0)/100.0;
	}


}