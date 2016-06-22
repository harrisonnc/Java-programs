
public class packet {
	
	
    int total_length;
    int id;
    boolean more_frags;
    int frag_offset;
    String source_addr;
    String dest_addr;
    String data;


public packet(int length, int id,boolean more_frags ,int frag_off,String src, String dest, String data) {
   this.id = id;
   this.total_length = length;
   this.source_addr= src;
   this.dest_addr= dest;
   this.data=data;
   this.more_frags=more_frags;
   this.frag_offset=frag_off;
   
}
    

    // getter
    public int getlenght() { return total_length; }
    public int getid() { return id; }
    public String getsource() { return source_addr; }
    public String getdest() { return dest_addr; }
    public String getdata() { return data; }
    
    // setter

    public void setlength(int length) { this.total_length = length; }
    public void setid(int id) { this.id = id; }
    public void setsource(String sid) { this.source_addr = sid; }
    public void setdest(String did) { this.dest_addr = did; }
    public void setdata(String data) { this.data = data; }
    
   
}

