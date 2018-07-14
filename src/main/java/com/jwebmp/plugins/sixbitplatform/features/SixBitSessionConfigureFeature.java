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

package com.jwebmp.plugins.sixbitplatform.features;

import com.jwebmp.Feature;
import com.jwebmp.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.sixbitplatform.SixBitPageConfigurator;

/**
 * @author Marc Magon
 * @since 22 Jun 2017
 */
public class SixBitSessionConfigureFeature
		extends Feature<JavaScriptPart, SixBitSessionConfigureFeature>
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
