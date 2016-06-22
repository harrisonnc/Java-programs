class SimpleThread extends Thread {
    public SimpleThread(String str) {
	super(str);
    }
    //run starts running the thread
	public void run() {
	for (int i = 0; i < 10; i++) {
	    //the thread is going to run, display its increment from the for loop
		//and its name
		System.out.println(i + " " + getName());
            try {
		//it then waits a random amount of time, between 0 and 1 second,
		//before starting the next increment
		//this means that the threads will not finish at the same time
		sleep((int)(Math.random() * 1000));
	    } catch (InterruptedException e) {}
	}
	//once the increment reaches 10 it prints done instead of the number
	System.out.println("DONE! " + getName());
    }
}



class TwoThreadsTest {
    public static void main (String args[]) {
        //these creates the the threads and .start instantiates them them
		new SimpleThread("Teller1").start();
        new SimpleThread("Teller2").start();
    }
}


//example of the code being run
/*
0 Teller1
0 Teller2
1 Teller2
1 Teller1
2 Teller2
2 Teller1
3 Teller2
3 Teller1
4 Teller2
4 Teller1
5 Teller2
5 Teller1
6 Teller1
6 Teller2
7 Teller1
8 Teller1
9 Teller1
7 Teller2
DONE! Teller1
8 Teller2
9 Teller2
DONE! Teller2
*/