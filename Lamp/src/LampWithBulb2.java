/**
 * @author gabrielferraz
 *
 */
public class LampWithBulb2 {
	LightBulb bulb;
	
	// implements a constructor in place of the setter
	public LampWithBulb2(LightBulb bulb)
	{
		this.bulb = bulb;
	}
	
	public void turnOn()
	{
		if(bulb == null)
		{
			System.out.println("There is no lightbulb");
		}
		else if(bulb.isLit())
		{
			System.out.println("The lamp is already on.");
		} 
		else
		{
			bulb.setLit(true);
			System.out.println("The lamp is on.");
		}		
	}
	
	public void turnOff()
	{
		if(bulb == null)
		{
			System.out.println("There is no lightbulb");
		}
		else if(bulb.isLit())
		{
			bulb.setLit(false);
			System.out.println("The lamp is off.");
		} 
		else
		{
			System.out.println("The lamp is already off.");
		}		
	}	

}
