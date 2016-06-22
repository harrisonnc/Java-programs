public class CommuterDedicated extends Routes implements Engines
{
	//instacne variables
	double vehicles=0;
	double trainlength=0;
	double numengines=0;
	double engines=0;
	double addstaff=0;
	double numstation=0;

	//constructor
	public CommuterDedicated(String name, double length, double speed, double hway,double trainlength,double numengines, double addstaff,double stationstaff, double numstation)
	{
		super(name,length,speed,hway);
		this.trainlength=trainlength;
		this.stationstaff=stationstaff;
		this.numstation=numstation;
		this.addstaff=addstaff;
	}

	//returns the number of stations
	public double getStations()
	{
		return numstation;
	}

	//returns the number of vehicles
	public double getVehicles()
	{
		vehicles=2*60*routeLength*trainlength/(avgSpeed*headway);
		return Math.round(vehicles*100.0)/100.0;
	}

	//returns the number of engines
	public double getEngines()
	{
		engines=2*60*routeLength/(avgSpeed*headway);
		return Math.round(engines*100.0)/100.0;
	}

	//returns the number of staff
	public double getStaff()
	{

		//System.out.println(getEngines());
		//System.out.println(addstaff*engines);
		//System.out.println(stationstaff*numstation);
		return (getEngines())+(addstaff*getEngines())+(stationstaff*numstation);
	}


}