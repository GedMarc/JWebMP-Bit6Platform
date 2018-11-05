import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions;
import com.jwebmp.plugins.sixbitplatform.SixBitPageConfigurator;
import com.jwebmp.plugins.sixbitplatform.implementations.Bit6ExclusionsModule;

module com.jwebmp.plugins.bit6 {
	exports com.jwebmp.plugins.sixbitplatform;
	exports com.jwebmp.plugins.sixbitplatform.features;

	requires com.jwebmp.core;
	requires com.jwebmp.logmaster;
	requires java.logging;
	requires java.validation;
	requires com.jwebmp.guicedinjection;

	provides IPageConfigurator with SixBitPageConfigurator;

	provides IGuiceScanModuleExclusions with Bit6ExclusionsModule;
	provides IGuiceScanJarExclusions with Bit6ExclusionsModule;

	opens com.jwebmp.plugins.sixbitplatform to com.fasterxml.jackson.databind, com.jwebmp.core;
	//opens com.jwebmp.plugins.sixbitplatform.events to com.fasterxml.jackson.databind,com.jwebmp.core;
	opens com.jwebmp.plugins.sixbitplatform.features to com.fasterxml.jackson.databind, com.jwebmp.core;
}
