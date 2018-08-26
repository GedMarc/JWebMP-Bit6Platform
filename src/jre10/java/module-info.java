import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.sixbitplatform.SixBitPageConfigurator;

module com.jwebmp.plugins.bit6 {
	exports com.jwebmp.plugins.sixbitplatform;
	exports com.jwebmp.plugins.sixbitplatform.features;

	requires com.jwebmp.core;
	requires com.jwebmp.logmaster;
	requires java.logging;
	requires java.validation;

	provides IPageConfigurator with SixBitPageConfigurator;

	opens com.jwebmp.plugins.sixbitplatform to com.fasterxml.jackson.databind, com.jwebmp.core;
	//opens com.jwebmp.plugins.sixbitplatform.events to com.fasterxml.jackson.databind,com.jwebmp.core;
	opens com.jwebmp.plugins.sixbitplatform.features to com.fasterxml.jackson.databind, com.jwebmp.core;
}
