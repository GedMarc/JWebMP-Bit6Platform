package za.co.mmagon.jwebswing.plugins.sixbitplatform.features;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * @author Marc Magon
 * @since 22 Jun 2017
 */
public class SixBitLoginFeature extends Feature<JavaScriptPart, SixBitLoginFeature>
{

	private static final long serialVersionUID = 1L;
	private final String password;
	private final String username;

	/*
	 * Constructs a new SixBitLoginFeature
	 */
	public SixBitLoginFeature(String username, String password)
	{
		super("6BitLogin");
		this.username = username;
		this.password = password;
	}

	@Override
	protected void assignFunctionsToComponent()
	{
		addQuery("b6.session['login']({'identity': 'usr:" + username + "', 'password': '" + password + "'}, function(err) {\n"
				         + "            if (err) {\n"
				         + "                console.log('auth error', err);\n"
				         + "                var msg = isNewUser ? 'New user' : 'Login';\n"
				         + "                msg += ': ' + err.message;\n"
				         + "                $('#authError').html('<p>' + msg + '</p>');\n"
				         + "            }\n"
				         + "            else {\n"
				         + "                console.log('auth done');\n"
				         + "                $('#authUsername').val('');\n"
				         + "                $('#authPassword').val('');\n"
				         + "                loginDone();\n"
				         + "            }\n"
				         + "        });");
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof SixBitLoginFeature))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		SixBitLoginFeature that = (SixBitLoginFeature) o;

		if (!password.equals(that.password))
		{
			return false;
		}
		return username.equals(that.username);
	}

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + password.hashCode();
		result = 31 * result + username.hashCode();
		return result;
	}
}
