import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.sixbitplatform.SixBitPageConfigurator;

module com.jwebmp.plugins.bit6 {
	exports com.jwebmp.plugins.sixbitplatform;
	exports com.jwebmp.plugins.sixbitplatform.features;

	requires com.jwebmp.core;
	requires com.jwebmp.logmaster;
	requires java.logging;

	provides IPageConfigurator with SixBitPageConfigurator;

}