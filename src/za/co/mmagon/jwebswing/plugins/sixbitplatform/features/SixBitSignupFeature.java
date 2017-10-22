package za.co.mmagon.jwebswing.plugins.sixbitplatform.features;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * @author Marc Magon
 * @since 22 Jun 2017
 */
public class SixBitSignupFeature extends Feature<JavaScriptPart, SixBitSignupFeature>
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
	protected void assignFunctionsToComponent()
	{
		addQuery("b6.session['signup']({'identity': 'usr:" + username + "', 'password': '" + password + "'}, function(err) {\n"
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
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (username != null ? username.hashCode() : 0);
		return result;
	}
}
