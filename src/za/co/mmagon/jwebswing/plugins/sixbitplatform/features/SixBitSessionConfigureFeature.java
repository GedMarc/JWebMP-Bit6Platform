package za.co.mmagon.jwebswing.plugins.sixbitplatform.features;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.plugins.sixbitplatform.SixBitPageConfigurator;

/**
 * @author Marc Magon
 * @since 22 Jun 2017
 */
public class SixBitSessionConfigureFeature extends Feature<JavaScriptPart, SixBitSessionConfigureFeature>
{

	private static final long serialVersionUID = 1L;

	/*
	 * Constructs a new SixBitSessionConfigureEvent
	 */
	public SixBitSessionConfigureFeature(String apiKey)
	{
		super("SixBitSessionStarter");
		SixBitPageConfigurator.setApiKey(apiKey);
	}

	@Override
	protected void assignFunctionsToComponent()
	{
		addQuery("b6 = new bit6.Client({apiKey:'" + SixBitPageConfigurator.getApiKey() + "'});" + getNewLine());
	}


}
