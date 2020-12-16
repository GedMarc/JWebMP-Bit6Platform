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

package com.jwebmp.plugins.sixbitplatform.features;

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * @author GedMarc
 * @since 22 Jun 2017
 */
public class SixBitSignupFeature
		extends Feature<GlobalFeatures, JavaScriptPart<?>, SixBitSignupFeature>
{
	private final String password;
	private final String username;

	/*
	 * Constructs a new SixBitLoginFeature
	 */
	public SixBitSignupFeature(String username, String password)
	{
		super("6BitSignup");
		this.username = username;
		this.password = password;
	}

	@Override
	protected void assignFunctionsToComponent()
	{
		addQuery(
				"b6.session['signup']({'identity': 'usr:" +
				username +
				"', 'password': '" +
				password +
				"'}, function(err) {\n" +
				"            if (err) {\n" +
				"                console.log('auth error', err);\n" +
				"                var msg = isNewUser ? 'New user' : 'Login';\n" +
				"                msg += ': ' + err.message;\n" +
				"                $('#authError').html('<p>' + msg + '</p>');\n" +
				"            }\n" +
				"            else {\n" +
				"                console.log('auth done');\n" +
				"                $('#authUsername').val('');\n" +
				"                $('#authPassword').val('');\n" +
				"                loginDone();\n" +
				"            }\n" +
				"        });");
	}
}
