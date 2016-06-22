

public class firewall {

static String forbidden_dest= "192.168.2.1";
static String forbidden_content= "youtube";
int packet_counter;
static String packet_data;
static boolean blocked;
String blocked_addr;
static int buffer_size=100;
static boolean done=false;
static String [] pkts= new String [100];

// Number of packets is not fixed
public static server server_port=new server();

///////////////////////Comments//////////////////////////////

//server_port is an object of the server and you need to create it

	public firewall() {

		}

	public void firewall_reset(){

		packet_data="";
		packet_counter=0;

	}
	public void firewall_finish() {
		server_port.finish();
	}

public static void stateless_firewall(packet ip){

	if (ip.dest_addr.equals(forbidden_dest))
	{
		System.out.println("Firewall can not pass the packet !!!");
		done=true;
		blocked=true;
	}

	if (ip.data.contains(forbidden_content))
	{if (!done)
		System.out.println("Firewall can not pass the packet !!!");
		blocked=true;
	}

	if (!blocked)
		server_port.forward(ip);
}

public static void stateful_firewall1(packet ip){

	if (ip.dest_addr.equals(forbidden_dest))
		{blocked=true;
		System.out.println("Firewall can not pass the packet !!!");
		  return;}


	if (ip.data.contains(forbidden_content)){
		blocked=true;
		System.out.println("Firewall can not pass the packet !!!");
		  return;
	}

    if (!blocked){

    	if (ip.more_frags){
    		packet_data=packet_data+ip.data;
    		if (packet_data.contains(forbidden_content))
    			{
    			blocked=true;
    			System.out.print("Firewall can not pass the packet !!!");
    			return;}
    			else {
    				server_port.forward(ip);
    			}

    	}
    	else{
    		// No incoming packet and connection is closed
    		blocked=true;
    	}

    }
}

public static void stateful_firewall2(packet ip){

	if (ip.dest_addr.equals(forbidden_dest))
	{blocked=true;
	System.out.print("Firewall can not pass the packet !!!");
	  return;}

	if (ip.data.contains(forbidden_content)){
		blocked=true;
		System.out.print("Firewall can not pass the packet !!!");
		  return;
	}

	if (!blocked){

		if (!(ip.frag_offset>=buffer_size)){

			
			pkts[ip.frag_offset]=ip.data;
			int i;
			for (i=0;i<buffer_size;i++){
				if (pkts[i]!= null)
				packet_data=packet_data+pkts[i];
			}

			if (packet_data.contains(forbidden_content))
			{
				blocked=true;
				System.out.print("Firewall can not pass the packet !!!");
				return;
			}

		}

		server_port.forward(ip);

	}
}

    }
