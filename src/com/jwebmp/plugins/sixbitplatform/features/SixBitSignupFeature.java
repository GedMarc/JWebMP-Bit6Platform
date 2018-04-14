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

/**
 * @author Marc Magon
 * @since 22 Jun 2017
 */
public class SixBitSignupFeature
		extends Feature<JavaScriptPart, SixBitSignupFeature>
{

	private static final long serialVersionUID = 1L;
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
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (username != null ? username.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof SixBitSignupFeature))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		SixBitSignupFeature that = (SixBitSignupFeature) o;

		if (password != null ? !password.equals(that.password) : that.password != null)
		{
			return false;
		}
		return username != null ? username.equals(that.username) : that.username == null;
	}

	@Override
	protected void assignFunctionsToComponent()
	{
		addQuery(
				"b6.session['signup']({'identity': 'usr:" + username + "', 'password': '" + password + "'}, function(err) {\n" + "            if (err) {\n" + "                console.log('auth error', err);\n" + "                var msg = isNewUser ? 'New user' : 'Login';\n" + "                msg += ': ' + err.message;\n" + "                $('#authError').html('<p>' + msg + '</p>');\n" + "            }\n" + "            else {\n" + "                console.log('auth done');\n" + "                $('#authUsername').val('');\n" + "                $('#authPassword').val('');\n" + "                loginDone();\n" + "            }\n" + "        });");
	}
}
