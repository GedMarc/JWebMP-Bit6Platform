module com.jwebmp.plugins.bit6 {
	exports com.jwebmp.plugins.sixbitplatform;
	exports com.jwebmp.plugins.sixbitplatform.features;

	requires com.jwebmp.core;
	requires com.guicedee.logmaster;
	requires java.logging;
	requires jakarta.validation;
	requires com.guicedee.guicedinjection;

	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.sixbitplatform.SixBitPageConfigurator;

	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.plugins.sixbitplatform.implementations.Bit6ExclusionsModule;

	opens com.jwebmp.plugins.sixbitplatform to com.fasterxml.jackson.databind, com.jwebmp.core;
	//opens com.jwebmp.plugins.sixbitplatform.events to com.fasterxml.jackson.databind,com.jwebmp.core;
	opens com.jwebmp.plugins.sixbitplatform.features to com.fasterxml.jackson.databind, com.jwebmp.core;
}
