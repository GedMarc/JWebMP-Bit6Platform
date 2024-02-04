/*
 * Copyright (C) 2017 GedMarc
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
import com.jwebmp.core.plugins.PluginStatus;
import com.jwebmp.core.services.IPageConfigurator;

import com.jwebmp.plugins.sixbitplatform.features.SixBitSessionConfigureFeature;

import jakarta.validation.constraints.NotNull;
import java.util.logging.Logger;

/**
 * Allows for elements to have an auto expand by adding a class
 *
 * @author GedMarc
 * @since 16 Jun 2017
 */
@PluginInformation(pluginName = "Bit6 Conferencing",
		pluginDescription = "Bit6 is a real-time, cloud-based communications-as-a-service platform that allows mobile and web application developers" +
				" to quickly and easily add voice/video calling, " +
				"texting, and multimedia messaging capabilities into their apps.",
		pluginUniqueName = "bit6",
		pluginVersion = "1.0.0",
		pluginCategories = "conferencing,video,calling",
		pluginSubtitle = "Bit6 JS SDK",
		pluginSourceUrl = "https://www.akveo.com/products.html",
		pluginWikiUrl = "https://github.com/GedMarc/JWebMP-Bit6Platform/wiki",
		pluginGitUrl = "https://github.com/bit6/bit6-js-sdk",
		pluginIconUrl = "",
		pluginIconImageUrl = "",
		pluginOriginalHomepage = "https://github.com/bit6/bit6-js-sdk",
		pluginDownloadUrl = "https://mvnrepository.com/artifact/com.jwebmp.plugins.javascript/jwebmp-bit6",
		pluginGroupId = "com.jwebmp.plugins.javascript",
		pluginArtifactId = "jwebmp-bit6",
		pluginModuleName = "com.jwebmp.plugins.bit6",
		pluginStatus = PluginStatus.Deprecated
)
@ComponentInformation(name = "Bit 6 Video Conferencing",
		description = "Component to allow integration with bit 6")
public class SixBitPageConfigurator
		implements IPageConfigurator<SixBitPageConfigurator>
{
	private static final Logger log = LogFactory.getLog(SixBitPageConfigurator.class.getName());
	/**
	 * If this configurator is enabled
	 */
	private static boolean enabled = true;
	private static String apiKey = "";

	/*
	 * Constructs a new SixBitPageConfigurator
	 */
	public SixBitPageConfigurator()
	{
		//Nothing needed
	}

	/**
	 * Method isEnabled returns the enabled of this AngularAnimatedChangePageConfigurator object.
	 * <p>
	 * If this configurator is enabled
	 *
	 * @return the enabled (type boolean) of this AngularAnimatedChangePageConfigurator object.
	 */
	public static boolean isEnabled()
	{
		return SixBitPageConfigurator.enabled;
	}

	/**
	 * Method setEnabled sets the enabled of this AngularAnimatedChangePageConfigurator object.
	 * <p>
	 * If this configurator is enabled
	 *
	 * @param mustEnable
	 * 		the enabled of this AngularAnimatedChangePageConfigurator object.
	 */
	public static void setEnabled(boolean mustEnable)
	{
		SixBitPageConfigurator.enabled = mustEnable;
	}

	@NotNull
	@Override
	@SuppressWarnings("unchecked")
	 public Page<?> configure(Page<?> page)
	{
		SixBitPageConfigurator.log.finer("Configuring Six Bit Page Configurator");
		if (!page.isConfigured() && enabled())
		{
			page.getBody()
			    .addVariable("b6");
			page.getBody()
			    .getJavascriptReferences()
			    .add(SixBitReferencePool.SixBit.getJavaScriptReference());
		}

		if (SixBitPageConfigurator.apiKey != null && !SixBitPageConfigurator.apiKey.isEmpty())
		{
			page.getBody()
			    .addFeature(new SixBitSessionConfigureFeature(SixBitPageConfigurator.getApiKey()));
		}
		else
		{
			SixBitPageConfigurator.log.severe("6Bit Plugin Not Available. No API Key Supplied. Use SixBitPageConfigurator.setApiKey();");
		}

		SixBitPageConfigurator.log.finer("Done Six Bit Page Configurator");
		return page;
	}

	@Override
	public boolean enabled()
	{
		return SixBitPageConfigurator.enabled;
	}

	/**
	 * Gets the API Key
	 *
	 * @return
	 */
	public static String getApiKey()
	{
		return SixBitPageConfigurator.apiKey;
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
