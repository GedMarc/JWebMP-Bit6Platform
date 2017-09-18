package za.co.mmagon.jwebswing.plugins.sixbitplatform;

import org.junit.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.Page;

/**
 * @author Marc Magon
 */
public class SixBitPageConfiguratorTest extends BaseTestClass
{
	
	public SixBitPageConfiguratorTest()
	{
	}
	
	@Test
	public void testNoApi()
	{
		Page p = getInstance();
		System.out.println(p.toString(0));
	}
	
	@Test
	public void testApi()
	{
		Page p = getInstance();
		SixBitPageConfigurator.setApiKey("apiKey123");
		System.out.println(p.toString(0));
	}
}
