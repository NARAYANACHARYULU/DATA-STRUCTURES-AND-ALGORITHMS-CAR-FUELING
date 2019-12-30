import java.util.Scanner;
public class CarFueling {
    private static int computeMinRefills(int dist, int tank, int[] stops) {
    	int n=stops.length;
        int count1 =0;
        int count2=0;
        int laststop=0;
        int currentstop1=0;
        int currentstop2=0;
        int finalstop=0;
        int oneinp=0;
        for(int i=0;i<n-1;i++)
        {
        	
        	if((((stops[i]-laststop)-tank<=0) && ((stops[i+1]-laststop)-tank)>0) && stops[i]!=stops[i+1] )
        	{
        		count1++;
        		laststop=stops[i];
        		
        	}
        	else if(((stops[i]-laststop)-tank<=0) && ((stops[i+1]-laststop)-tank)==0 && stops[i]!=stops[i+1] )
        	{
        		count1++;
        		laststop=stops[i+1];
        		
        	}
        	currentstop1=stops[i];
        	currentstop2=stops[i+1];
        	finalstop=stops[i+1];  	
        }
        if(((dist-currentstop2)+(currentstop2-currentstop1)+currentstop1-laststop)>tank)
    	{
    		count1++;
    	}

        for(int i=0;i<n-1;i++)
        {
        	if(stops[i+1]-stops[i]>tank)
        	{
        		count2++;
        	}
        }
        if(n==1)
        {
        	oneinp=stops[0];
        	if(dist-oneinp>tank || tank<oneinp)
        	{
        		count2++;
        	}	
        }
        else
        {
        	oneinp=finalstop;
        }
        if(dist-oneinp>tank)
        {
        	count2++;
        }
        if(count2>0)
        {
        	return -1;
        }
        else if(tank>=dist)
        {
        	return 0;
        }
        else
        {
        	return count1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            stops[i] =scanner.nextInt();
        }
        System.out.println(computeMinRefills(dist, tank, stops));
    }
}