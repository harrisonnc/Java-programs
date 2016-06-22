/*
 * Decompiled with CFR 0_102.
 * 
 * Could not load the following classes:
 *  packet
 */
import java.io.PrintStream;
import packet;

public class server {
    int buffer_size = 1000;
    int counter = 0;
    String packet_data;
    byte[] merged = new byte[this.buffer_size];
    String forbidden_content = "youtube";
    boolean blocked;
    boolean done = false;

    public void finish() {
        System.out.println("server received: " + new String(this.merged));
    }

    public void forward(packet packet) {
        if (!this.done) {
            for (int i = 0; i < packet.total_length; ++i) {
                this.merged[packet.frag_offset + i] = (byte)packet.data.charAt(i);
            }
            if (new String(this.merged).contains((CharSequence)this.forbidden_content)) {
                System.out.println("Congratulations, you passed the firewall !!! ");
                this.done = true;
            }
            return;
        }
    }
}