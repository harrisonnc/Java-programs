public class sploit1 {

	public static firewall firewall_port=new firewall();
	
	public static void main(String [ ] args)
	{

		
		//192.168.2.0 is the proxy
		packet p1 = new packet(3,1,false, 0, "LocalHost","192.168.2.0","you");
        packet p2 = new packet(4,1,false, 3, "LocalHost","192.168.2.0","tube");
		
		firewall_port.firewall_reset();
		
		firewall_port.stateless_firewall(p1);
		
		firewall_port.firewall_finish();
		
		
	}
	
}