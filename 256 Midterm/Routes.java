//parent class of all other routes
public abstract class Routes
{
	//instance variables
	protected String routeName;
	protected double routeLength;
	protected double avgSpeed;
	protected double headway;
	protected double stationstaff;
	protected double numstation;

	//constructor
	public Routes(String name, double length, double speed, double hway)
	{
		routeName=name;
		routeLength=length;
		avgSpeed=speed;
		headway=hway;

	}

	//returns the name
	public String getName()
	{
		return routeName;
	}
	abstract double getVehicles();
	abstract double getStaff();


}