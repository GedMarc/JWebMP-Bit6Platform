package za.co.mmagon.jwebswing.plugins.sixbitplatform;

import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.PageConfigurator;
import za.co.mmagon.jwebswing.plugins.ComponentInformation;
import za.co.mmagon.jwebswing.plugins.PluginInformation;
import za.co.mmagon.jwebswing.plugins.sixbitplatform.features.SixBitSessionConfigureFeature;
import za.co.mmagon.logger.LogFactory;

import java.util.logging.Logger;

/**
 * Allows for elements to have an auto expand by adding a class
 *
 * @author Marc Magon
 * @since 16 Jun 2017
 */
@PluginInformation(pluginName = "Angular Auto Focus",
		pluginDescription = "Auto Focus Components with Angular",
		pluginUniqueName = "jwebswing-angular-auto-focus",
		pluginVersion = "1.0.0",
		pluginCategories = "angular,focus,ui,web ui, framework",
		pluginSubtitle = "Auto Focus Components with Angular",
		pluginSourceUrl = "https://www.akveo.com/products.html",
		pluginWikiUrl = "https://github.com/GedMarc/JWebSwing-Angular-Auto-Focus/wiki",
		pluginGitUrl = "https://github.com/GedMarc/JWebSwing-Angular-Auto-Focus",
		pluginIconUrl = "",
		pluginIconImageUrl = "",
		pluginOriginalHomepage = "https://www.akveo.com/products.html",
		pluginDownloadUrl = "https://sourceforge.net/projects/jwebswing/files/plugins/AngularAutoFocus.jar/download"
)
@ComponentInformation(name = "Angular Auto Focus",
		description = "Auto Focus Components with Angular",
		url = "https://www.akveo.com/products.html")
public class SixBitPageConfigurator extends PageConfigurator
{

	private static final Logger log = LogFactory.getLog(SixBitPageConfigurator.class.getName());

	private static final long serialVersionUID = 1L;

	private static String apiKey = "";

	/*
	 * Constructs a new SixBitPageConfigurator
	 */
	public SixBitPageConfigurator()
	{
		//Nothing needed
	}

	/**
	 * Gets the API Key
	 *
	 * @return
	 */
	public static String getApiKey()
	{
		return apiKey;
	}

	/**
	 * Sets the API Key
	 *
	 * @param apiKey
	 */
	public static void setApiKey(String apiKey)
	{
		SixBitPageConfigurator.apiKey = apiKey;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Page configure(Page page)
	{
		log.finer("Configuring Six Bit Page Configurator");
		if (!page.isConfigured())
		{
			page.getBody().addVariable("b6");
			page.getBody().getJavascriptReferences().add(SixBitReferencePool.SixBit.getJavaScriptReference());
		}

		if (apiKey != null && !apiKey.isEmpty())
		{
			page.getBody().addFeature(new SixBitSessionConfigureFeature(getApiKey()));
		}
		else
		{
			log.severe("6Bit Plugin Not Available. No API Key Supplied. Use SixBitPageConfigurator.setApiKey();");
		}

		log.finer("Done Six Bit Page Configurator");
		return page;
	}


}
