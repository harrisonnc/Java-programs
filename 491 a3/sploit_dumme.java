
public class sploit_dummy {

	public static firewall firewall_port=new firewall();
	
	public static void main(String [ ] args)
	{

		
		packet p1 = new packet(7,1,true, 0, "localhost","192.168.2.1","youtube");
		firewall_port.firewall_reset();
		
		firewall_port.stateless_firewall(p1);
		
		firewall_port.firewall_finish();
		
		
	}
	
}