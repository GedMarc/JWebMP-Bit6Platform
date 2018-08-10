/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jwebmp.plugins.sixbitplatform;

import com.jwebmp.core.Page;
import com.jwebmp.core.plugins.ComponentInformation;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.logger.LogFactory;
import com.jwebmp.plugins.sixbitplatform.features.SixBitSessionConfigureFeature;

import javax.validation.constraints.NotNull;
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
		pluginDownloadUrl = "https://sourceforge.net/projects/jwebswing/files/plugins/AngularAutoFocus.jar/download")
@ComponentInformation(name = "Angular Auto Focus",
		description = "Auto Focus Components with Angular",
		url = "https://www.akveo.com/products.html")
public class SixBitPageConfigurator
		implements IPageConfigurator
{

	private static final Logger log = LogFactory.getLog(SixBitPageConfigurator.class.getName());

	private static String apiKey = "";

	/*
	 * Constructs a new SixBitPageConfigurator
	 */
	public SixBitPageConfigurator()
	{
		//Nothing needed
	}

	@NotNull
	@Override
	@SuppressWarnings("unchecked")
	public Page configure(Page page)
	{
		log.finer("Configuring Six Bit Page Configurator");
		if (!page.isConfigured())
		{
			page.getBody()
			    .addVariable("b6");
			page.getBody()
			    .getJavascriptReferences()
			    .add(SixBitReferencePool.SixBit.getJavaScriptReference());
		}

		if (apiKey != null && !apiKey.isEmpty())
		{
			page.getBody()
			    .addFeature(new SixBitSessionConfigureFeature(getApiKey()));
		}
		else
		{
			log.severe("6Bit Plugin Not Available. No API Key Supplied. Use SixBitPageConfigurator.setApiKey();");
		}

		log.finer("Done Six Bit Page Configurator");
		return page;
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

}
